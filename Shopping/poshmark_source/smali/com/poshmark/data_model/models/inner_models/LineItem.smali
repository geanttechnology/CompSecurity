.class public Lcom/poshmark/data_model/models/inner_models/LineItem;
.super Ljava/lang/Object;
.source "LineItem.java"


# instance fields
.field private id:Ljava/lang/String;

.field private inventory_unit_id:Ljava/lang/String;

.field private picture_url:Ljava/lang/String;

.field private price:Ljava/math/BigDecimal;

.field private product_id:Ljava/lang/String;

.field private seller_id:Ljava/lang/String;

.field private seller_name:Ljava/lang/String;

.field private size:Ljava/lang/String;

.field private tax_amount:Ljava/lang/String;

.field private tax_rate:F

.field private title:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 6
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public copy(Lcom/poshmark/data_model/models/inner_models/LineItem;)V
    .locals 1
    .param p1, "lineItem"    # Lcom/poshmark/data_model/models/inner_models/LineItem;

    .prologue
    .line 20
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/LineItem;->id:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/LineItem;->id:Ljava/lang/String;

    .line 21
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/LineItem;->title:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/LineItem;->title:Ljava/lang/String;

    .line 22
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/LineItem;->price:Ljava/math/BigDecimal;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/LineItem;->price:Ljava/math/BigDecimal;

    .line 23
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/LineItem;->seller_name:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/LineItem;->seller_name:Ljava/lang/String;

    .line 24
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/LineItem;->seller_id:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/LineItem;->seller_id:Ljava/lang/String;

    .line 25
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/LineItem;->size:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/LineItem;->size:Ljava/lang/String;

    .line 26
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/LineItem;->picture_url:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/LineItem;->picture_url:Ljava/lang/String;

    .line 27
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/LineItem;->product_id:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/LineItem;->product_id:Ljava/lang/String;

    .line 28
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/LineItem;->tax_amount:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/LineItem;->tax_amount:Ljava/lang/String;

    .line 29
    iget v0, p1, Lcom/poshmark/data_model/models/inner_models/LineItem;->tax_rate:F

    iput v0, p0, Lcom/poshmark/data_model/models/inner_models/LineItem;->tax_rate:F

    .line 30
    iget-object v0, p1, Lcom/poshmark/data_model/models/inner_models/LineItem;->inventory_unit_id:Ljava/lang/String;

    iput-object v0, p0, Lcom/poshmark/data_model/models/inner_models/LineItem;->inventory_unit_id:Ljava/lang/String;

    .line 31
    return-void
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/LineItem;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getInventoryUnitId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/LineItem;->inventory_unit_id:Ljava/lang/String;

    return-object v0
.end method

.method public getPictureURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/LineItem;->picture_url:Ljava/lang/String;

    return-object v0
.end method

.method public getPrice()Ljava/math/BigDecimal;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/LineItem;->price:Ljava/math/BigDecimal;

    return-object v0
.end method

.method public getProductId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/LineItem;->product_id:Ljava/lang/String;

    return-object v0
.end method

.method public getSellerId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/LineItem;->seller_id:Ljava/lang/String;

    return-object v0
.end method

.method public getSellerName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/LineItem;->seller_name:Ljava/lang/String;

    return-object v0
.end method

.method public getSize()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/LineItem;->size:Ljava/lang/String;

    return-object v0
.end method

.method public getTaxRate()F
    .locals 1

    .prologue
    .line 70
    iget v0, p0, Lcom/poshmark/data_model/models/inner_models/LineItem;->tax_rate:F

    return v0
.end method

.method public getTextAmount()Ljava/lang/String;
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/LineItem;->tax_amount:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/poshmark/data_model/models/inner_models/LineItem;->title:Ljava/lang/String;

    return-object v0
.end method
