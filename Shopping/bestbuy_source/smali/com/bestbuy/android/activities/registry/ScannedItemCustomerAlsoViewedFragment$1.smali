.class Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->a(I)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

.field final synthetic b:Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V
    .locals 0

    .prologue
    .line 174
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment$1;->b:Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;

    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment$1;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9

    .prologue
    const/4 v3, 0x0

    const/4 v8, 0x0

    .line 177
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 178
    const-string v1, "bb.addToList"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 179
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment$1;->b:Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->a(Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "weddingregistrylists"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 180
    const-string v1, "&&products"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, ";"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment$1;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, ";;;;evar48=LE-WL"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 181
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Llu;->L:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment$1;->b:Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->a(Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;)Ljava/lang/String;

    move-result-object v2

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment$1;->b:Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;

    invoke-static {v4}, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->a(Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    invoke-virtual {v2, v8, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 182
    new-instance v0, Liy;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment$1;->b:Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->b(Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;)Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment$1;->b:Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment$1;->b:Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;

    invoke-static {v4}, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->c(Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment$1;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment$1;->b:Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;

    invoke-static {v6}, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->a(Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;)Ljava/lang/String;

    move-result-object v6

    const-string v7, "1"

    invoke-direct/range {v0 .. v7}, Liy;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 183
    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v8, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Liy;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 191
    :cond_0
    :goto_0
    return-void

    .line 184
    :cond_1
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment$1;->b:Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->a(Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "weddingregistrylists"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 185
    const-string v1, "&&products"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, ";"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment$1;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, ";;;;evar48=WR-WR"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 186
    sget-object v1, Llu;->az:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 187
    new-instance v0, Liy;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment$1;->b:Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->b(Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;)Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment$1;->b:Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment$1;->b:Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;

    invoke-static {v4}, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->c(Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment$1;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment$1;->b:Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;

    invoke-static {v6}, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->a(Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;)Ljava/lang/String;

    move-result-object v6

    const-string v7, "1"

    invoke-direct/range {v0 .. v7}, Liy;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 188
    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v8, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Liy;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method
