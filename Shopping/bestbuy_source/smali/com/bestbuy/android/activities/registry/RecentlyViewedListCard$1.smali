.class Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->a(I)V
.end annotation


# instance fields
.field final synthetic a:I

.field final synthetic b:Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;I)V
    .locals 0

    .prologue
    .line 193
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard$1;->b:Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    iput p2, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard$1;->a:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9

    .prologue
    const/4 v3, 0x0

    const/4 v8, 0x0

    .line 197
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 198
    const-string v0, "bb.addToList"

    const-string v2, "1"

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 199
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard$1;->b:Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->a(Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;)Ljava/lang/String;

    move-result-object v0

    const-string v2, "weddingregistrylists"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 200
    const-string v2, "&&products"

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, ";"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard$1;->b:Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->b(Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;)Ljava/util/ArrayList;

    move-result-object v0

    iget v5, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard$1;->a:I

    invoke-virtual {v0, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, ";;;;evar48=LE-WL"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 201
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Llu;->L:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard$1;->b:Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    invoke-static {v2}, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->a(Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;)Ljava/lang/String;

    move-result-object v2

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard$1;->b:Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    invoke-static {v4}, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->a(Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    invoke-virtual {v2, v8, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v1}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 202
    new-instance v0, Liy;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard$1;->b:Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    iget-object v1, v1, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard$1;->b:Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard$1;->b:Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    invoke-static {v4}, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->c(Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard$1;->b:Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    invoke-static {v5}, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->b(Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;)Ljava/util/ArrayList;

    move-result-object v5

    iget v6, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard$1;->a:I

    invoke-virtual {v5, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard$1;->b:Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    invoke-static {v6}, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->a(Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;)Ljava/lang/String;

    move-result-object v6

    const-string v7, "1"

    invoke-direct/range {v0 .. v7}, Liy;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 203
    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v8, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Liy;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 211
    :cond_0
    :goto_0
    return-void

    .line 204
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard$1;->b:Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->a(Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;)Ljava/lang/String;

    move-result-object v0

    const-string v2, "weddingregistrylists"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 205
    const-string v2, "&&products"

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, ";"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard$1;->b:Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    invoke-static {v0}, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->b(Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;)Ljava/util/ArrayList;

    move-result-object v0

    iget v5, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard$1;->a:I

    invoke-virtual {v0, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, ";;;;evar48=WR-WR"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 206
    sget-object v0, Llu;->aH:Ljava/lang/String;

    invoke-static {v0, v1}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 207
    new-instance v0, Liy;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard$1;->b:Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    iget-object v1, v1, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard$1;->b:Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard$1;->b:Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    invoke-static {v4}, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->c(Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;)Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard$1;->b:Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    invoke-static {v5}, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->b(Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;)Ljava/util/ArrayList;

    move-result-object v5

    iget v6, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard$1;->a:I

    invoke-virtual {v5, v6}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard$1;->b:Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    invoke-static {v6}, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->a(Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;)Ljava/lang/String;

    move-result-object v6

    const-string v7, "1"

    invoke-direct/range {v0 .. v7}, Liy;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 208
    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v8, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Liy;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method
