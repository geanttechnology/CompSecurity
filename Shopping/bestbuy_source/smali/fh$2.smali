.class Lfh$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lfh;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

.field final synthetic b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

.field final synthetic c:Lfh;


# direct methods
.method constructor <init>(Lfh;Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V
    .locals 0

    .prologue
    .line 232
    iput-object p1, p0, Lfh$2;->c:Lfh;

    iput-object p2, p0, Lfh$2;->a:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    iput-object p3, p0, Lfh$2;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9

    .prologue
    const/4 v6, 0x1

    const/4 v0, 0x0

    .line 236
    .line 237
    const/4 v1, 0x0

    .line 238
    iget-object v2, p0, Lfh$2;->a:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getIcrMapPriceValue()Ljava/lang/String;

    move-result-object v2

    const-string v3, "1"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    iget-object v2, p0, Lfh$2;->a:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getIcrMapPriceValue()Ljava/lang/String;

    move-result-object v2

    const-string v3, "2"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 239
    :cond_0
    new-instance v0, Llb;

    iget-object v1, p0, Lfh$2;->c:Lfh;

    invoke-static {v1}, Lfh;->a(Lfh;)Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f0801e4

    const v3, 0x7f0801e1

    const v4, 0x7f0801e5

    const v5, 0x7f0801e2

    const v6, 0x7f0801e3

    invoke-direct/range {v0 .. v6}, Llb;-><init>(Landroid/content/Context;IIIII)V

    .line 258
    :goto_0
    if-eqz v0, :cond_1

    .line 259
    invoke-virtual {v0}, Llb;->show()V

    .line 260
    :cond_1
    return-void

    .line 240
    :cond_2
    iget-object v2, p0, Lfh$2;->a:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->isMapFlag()Z

    move-result v2

    if-eqz v2, :cond_7

    .line 241
    iget-object v1, p0, Lfh$2;->a:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuTypeCode()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_6

    iget-object v1, p0, Lfh$2;->a:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuTypeCode()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lfh$2;->c:Lfh;

    invoke-static {v2}, Lfh;->a(Lfh;)Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f080068

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_6

    .line 242
    iget-object v1, p0, Lfh$2;->a:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuTypeCode()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lfh$2;->c:Lfh;

    invoke-static {v2}, Lfh;->a(Lfh;)Landroid/content/Context;

    move-result-object v2

    const v3, 0x7f08003a

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 256
    :cond_3
    :goto_1
    new-instance v0, Llb;

    iget-object v1, p0, Lfh$2;->c:Lfh;

    invoke-static {v1}, Lfh;->a(Lfh;)Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f080224

    const v3, 0x7f080222

    const v4, 0x7f080225

    const v5, 0x7f080223

    iget-object v7, p0, Lfh$2;->a:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    iget-object v8, p0, Lfh$2;->b:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-direct/range {v0 .. v8}, Llb;-><init>(Landroid/content/Context;IIIIZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V

    goto :goto_0

    .line 245
    :cond_4
    iget-object v1, p0, Lfh$2;->a:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuDisplayable()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_5

    .line 246
    iget-object v1, p0, Lfh$2;->a:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuDisplayable()Ljava/lang/String;

    move-result-object v1

    const-string v2, "1"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3

    move v6, v0

    goto :goto_1

    :cond_5
    move v6, v0

    .line 250
    goto :goto_1

    :cond_6
    move v6, v0

    .line 254
    goto :goto_1

    :cond_7
    move-object v0, v1

    goto/16 :goto_0
.end method
