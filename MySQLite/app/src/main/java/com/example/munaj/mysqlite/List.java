package com.example.munaj.mysqlite;

/**
 * Created by Munaj on 1/10/2016.
 */
public class List {

    private int _id;
    private String _productName;

    public List(){

    }
    public List(String productName){
        this._productName = productName;
    }

    public void set_id(int id){
        this._id = id;
    }

    public void set_productName(String productName){
        this._productName = productName;
    }

    public int get_id(){
        return _id;
    }

    public String get_productName(){
        return _productName;
    }
}
