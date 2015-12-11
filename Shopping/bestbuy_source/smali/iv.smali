.class public Liv;
.super Lka;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/String;

.field private j:Landroid/app/ProgressDialog;

.field private k:Ljava/lang/String;

.field private l:Ljava/lang/String;

.field private m:Lcom/google/zxing/Result;

.field private n:Z


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/google/zxing/Result;)V
    .locals 1

    .prologue
    .line 32
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 25
    const-string v0, ""

    iput-object v0, p0, Liv;->k:Ljava/lang/String;

    .line 33
    iput-object p2, p0, Liv;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    .line 34
    invoke-virtual {p3}, Lcom/google/zxing/Result;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Liv;->a:Ljava/lang/String;

    .line 35
    iput-object p3, p0, Liv;->m:Lcom/google/zxing/Result;

    .line 36
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/google/zxing/Result;Z)V
    .locals 1

    .prologue
    .line 39
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 25
    const-string v0, ""

    iput-object v0, p0, Liv;->k:Ljava/lang/String;

    .line 40
    iput-object p2, p0, Liv;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    .line 41
    invoke-virtual {p3}, Lcom/google/zxing/Result;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Liv;->a:Ljava/lang/String;

    .line 42
    iput-object p3, p0, Liv;->m:Lcom/google/zxing/Result;

    .line 43
    iput-boolean p4, p0, Liv;->n:Z

    .line 44
    return-void
.end method

.method private a(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 56
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    const-string v1, "products"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v0

    .line 57
    invoke-virtual {v0}, Lorg/json/JSONArray;->length()I

    move-result v1

    if-lez v1, :cond_0

    .line 58
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v0

    invoke-static {v0}, Lcom/bestbuy/android/api/lib/models/product/Product;->loadBBYOpenData(Lorg/json/JSONObject;)Lcom/bestbuy/android/api/lib/models/product/Product;

    move-result-object v0

    .line 59
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/product/Product;->getSku()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Liv;->k:Ljava/lang/String;

    .line 60
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/product/Product;->getProductId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Liv;->l:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 65
    :cond_0
    :goto_0
    return-void

    .line 62
    :catch_0
    move-exception v0

    .line 63
    const-string v1, "GetProductScanResultTask"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Could not parse Weekly Deals by Category: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lgs;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private f()V
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Liv;->j:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 79
    iget-object v0, p0, Liv;->f:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->d()V

    .line 80
    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 48
    iget-object v0, p0, Liv;->a:Ljava/lang/String;

    invoke-static {v0}, Lfu;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 49
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    if-lez v1, :cond_0

    .line 50
    invoke-direct {p0, v0}, Liv;->a(Ljava/lang/String;)V

    .line 52
    :cond_0
    return-void
.end method

.method protected a_(Ljava/lang/Void;)V
    .locals 4

    .prologue
    .line 94
    invoke-super {p0, p1}, Lka;->a_(Ljava/lang/Void;)V

    .line 95
    iget-object v0, p0, Liv;->k:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Liv;->n:Z

    if-nez v0, :cond_0

    .line 96
    iget-object v0, p0, Liv;->j:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 97
    iget-object v0, p0, Liv;->f:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

    iget-object v1, p0, Liv;->m:Lcom/google/zxing/Result;

    iget-object v2, p0, Liv;->k:Ljava/lang/String;

    iget-object v3, p0, Liv;->l:Ljava/lang/String;

    invoke-virtual {v0, v1, v2, v3}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->a(Lcom/google/zxing/Result;Ljava/lang/String;Ljava/lang/String;)V

    .line 105
    :goto_0
    return-void

    .line 98
    :cond_0
    iget-boolean v0, p0, Liv;->n:Z

    if-eqz v0, :cond_1

    .line 99
    iget-object v0, p0, Liv;->j:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 100
    iget-object v0, p0, Liv;->f:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

    iget-object v1, p0, Liv;->m:Lcom/google/zxing/Result;

    iget-object v2, p0, Liv;->k:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->a(Lcom/google/zxing/Result;Ljava/lang/String;)V

    goto :goto_0

    .line 103
    :cond_1
    invoke-direct {p0}, Liv;->f()V

    goto :goto_0
.end method

.method public b()V
    .locals 0

    .prologue
    .line 118
    return-void
.end method

.method protected synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 22
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Liv;->a_(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPreExecute()V
    .locals 3

    .prologue
    .line 109
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 110
    iget-object v0, p0, Liv;->f:Landroid/app/Activity;

    const/4 v1, 0x0

    const-string v2, "Loading..."

    invoke-static {v0, v1, v2}, Landroid/app/ProgressDialog;->show(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Landroid/app/ProgressDialog;

    move-result-object v0

    iput-object v0, p0, Liv;->j:Landroid/app/ProgressDialog;

    .line 111
    iget-object v0, p0, Liv;->j:Landroid/app/ProgressDialog;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setCancelable(Z)V

    .line 112
    iget-object v0, p0, Liv;->j:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->show()V

    .line 113
    return-void
.end method
