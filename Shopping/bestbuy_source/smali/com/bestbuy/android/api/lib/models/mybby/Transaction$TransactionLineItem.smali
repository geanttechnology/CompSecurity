.class public Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private amount:Ljava/lang/String;

.field private description:Ljava/lang/String;

.field private eligible:Z

.field private lineNumber:Ljava/lang/String;

.field private prodCategory:Ljava/lang/String;

.field private prodThumbImgURL:Ljava/lang/String;

.field private productModelId:Ljava/lang/String;

.field private productSku:Ljava/lang/String;

.field private quantity:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 242
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;
    .locals 1

    .prologue
    .line 242
    invoke-static {p0}, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;

    move-result-object v0

    return-object v0
.end method

.method private static loadData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;
    .locals 3

    .prologue
    .line 282
    new-instance v0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;-><init>()V

    .line 284
    const-string v1, "productSku"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->productSku:Ljava/lang/String;

    .line 285
    const-string v1, "amount"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->amount:Ljava/lang/String;

    .line 288
    iget-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->amount:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->amount:Ljava/lang/String;

    const-string v2, "0"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 289
    const-string v1, "lineNumber"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->lineNumber:Ljava/lang/String;

    .line 290
    const-string v1, "description"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->description:Ljava/lang/String;

    .line 291
    const-string v1, "quantity"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->quantity:Ljava/lang/String;

    .line 292
    const-string v1, ""

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->prodCategory:Ljava/lang/String;

    .line 293
    const-string v1, ""

    iput-object v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->prodThumbImgURL:Ljava/lang/String;

    .line 294
    const-string v1, "eligible"

    invoke-virtual {p0, v1}, Lorg/json/JSONObject;->optBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, v0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->eligible:Z

    .line 300
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public getAmount()Ljava/lang/String;
    .locals 1

    .prologue
    .line 257
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->amount:Ljava/lang/String;

    return-object v0
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 263
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getLineNumber()Ljava/lang/String;
    .locals 1

    .prologue
    .line 260
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->lineNumber:Ljava/lang/String;

    return-object v0
.end method

.method public getProdCategory()Ljava/lang/String;
    .locals 1

    .prologue
    .line 272
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->prodCategory:Ljava/lang/String;

    return-object v0
.end method

.method public getProdThumbImgURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 269
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->prodThumbImgURL:Ljava/lang/String;

    return-object v0
.end method

.method public getProductModelId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 275
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->productModelId:Ljava/lang/String;

    return-object v0
.end method

.method public getProductSku()Ljava/lang/String;
    .locals 1

    .prologue
    .line 254
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->productSku:Ljava/lang/String;

    return-object v0
.end method

.method public getQuantity()Ljava/lang/String;
    .locals 1

    .prologue
    .line 266
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->quantity:Ljava/lang/String;

    return-object v0
.end method

.method public isEligible()Z
    .locals 1

    .prologue
    .line 278
    iget-boolean v0, p0, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->eligible:Z

    return v0
.end method
