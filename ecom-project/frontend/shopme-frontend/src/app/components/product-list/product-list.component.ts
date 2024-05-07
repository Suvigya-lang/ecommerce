import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CartItem } from 'src/app/common/cart-item';
import { Product } from 'src/app/common/product';
import { CartService } from 'src/app/services/cart.service';
import { ProductService } from 'src/app/services/product.service';

@Component({
  selector: 'app-product-list',
  //templateUrl: './product-list.component.html',
  //templateUrl: './product-list-table.component.html',
  templateUrl: './product-list-grid.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {

  products:Product[];
  currentCategoryId: number;
  searchMode: boolean;
  currentCategoryName: string;

  

  constructor(private productService: ProductService,
    private cartService: CartService,
    private route: ActivatedRoute) { }

  ngOnInit(): void {
   
    this.route.paramMap.subscribe(()=>{
      this.listProducts();
    });
  }
  listProducts() {
    //check if id parameter is available
    this.searchMode=this.route.snapshot.paramMap.has("keyword");

    if(this.searchMode){
      this.handleSearchProducts();

    }
    else{
      this.handleListProducts();
    }
   
  }
  handleSearchProducts() {
    const myKeyword: string= this.route.snapshot.paramMap.get("keyword");
    this.productService.searchProducts(myKeyword).subscribe(
      data=>{
        this.products=data;
      }
    )
  }
  handleListProducts(){
    const hasCategoryId: boolean = this.route.snapshot.paramMap.has("id");
    if(hasCategoryId){
      this.currentCategoryId = +this.route.snapshot.paramMap.get("id");
      this.currentCategoryName=this.route.snapshot.paramMap.get("name");
    }
    else{
      // default categoryid=1
      this.currentCategoryId=1;
      this.currentCategoryName="Books";
    }
    this.productService.getProductList(this.currentCategoryId).subscribe(
      data =>{
        this.products = data;
      }
    )

  }
  addToCart(product: Product){
    console.log(`Adding to cart: ${product.name},${product.unitPrice}`);

    const cartItem= new CartItem(product);
    this.cartService.addToCart(cartItem);
    
  }

}
