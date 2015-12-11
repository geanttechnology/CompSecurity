.class Leq$3;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Leq;->a(Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;)Landroid/widget/LinearLayout;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

.field final synthetic b:Leq;


# direct methods
.method constructor <init>(Leq;Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;)V
    .locals 0

    .prologue
    .line 265
    iput-object p1, p0, Leq$3;->b:Leq;

    iput-object p2, p0, Leq$3;->a:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7

    .prologue
    .line 269
    const/4 v0, 0x0

    .line 270
    iget-object v1, p0, Leq$3;->a:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->getPricingType()Ljava/lang/String;

    move-result-object v1

    const-string v2, "ICR-noPrice"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Leq$3;->a:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->getPricingType()Ljava/lang/String;

    move-result-object v1

    const-string v2, "ICR-strikeThrough"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 271
    :cond_0
    new-instance v0, Llb;

    iget-object v1, p0, Leq$3;->b:Leq;

    invoke-static {v1}, Leq;->c(Leq;)Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f0801e4

    const v3, 0x7f0801e1

    const v4, 0x7f0801e5

    const v5, 0x7f0801e2

    const v6, 0x7f0801e3

    invoke-direct/range {v0 .. v6}, Llb;-><init>(Landroid/content/Context;IIIII)V

    .line 275
    :cond_1
    :goto_0
    if-eqz v0, :cond_2

    .line 276
    invoke-virtual {v0}, Llb;->show()V

    .line 277
    :cond_2
    return-void

    .line 272
    :cond_3
    iget-object v1, p0, Leq$3;->a:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->getPricingType()Ljava/lang/String;

    move-result-object v1

    const-string v2, "MAP"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 273
    new-instance v0, Llb;

    iget-object v1, p0, Leq$3;->b:Leq;

    invoke-static {v1}, Leq;->c(Leq;)Landroid/content/Context;

    move-result-object v1

    const v2, 0x7f080224

    const v3, 0x7f080222

    const v4, 0x7f080225

    const v5, 0x7f080223

    invoke-direct/range {v0 .. v5}, Llb;-><init>(Landroid/content/Context;IIII)V

    goto :goto_0
.end method
