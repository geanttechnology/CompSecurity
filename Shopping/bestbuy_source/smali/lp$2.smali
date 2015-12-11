.class final Llp$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Llp;->a(Landroid/app/Activity;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;IZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZLjava/lang/String;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

.field final synthetic b:Landroid/app/Activity;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 521
    iput-object p1, p0, Llp$2;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    iput-object p2, p0, Llp$2;->b:Landroid/app/Activity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 524
    const/4 v0, 0x0

    .line 525
    iget-object v1, p0, Llp$2;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Llp$2;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;->isMarketplace()Z

    move-result v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Llp$2;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCondition()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_2

    iget-object v1, p0, Llp$2;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCondition()Ljava/lang/String;

    move-result-object v1

    const-string v2, "refurbished"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 526
    new-instance v0, Llb;

    iget-object v1, p0, Llp$2;->b:Landroid/app/Activity;

    const v2, 0x7f080229

    const v3, 0x7f080228

    invoke-direct {v0, v1, v2, v3}, Llb;-><init>(Landroid/content/Context;II)V

    .line 532
    :cond_0
    :goto_0
    if-eqz v0, :cond_1

    .line 533
    invoke-virtual {v0}, Llb;->show()V

    .line 535
    :cond_1
    return-void

    .line 527
    :cond_2
    iget-object v1, p0, Llp$2;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v1

    if-eqz v1, :cond_3

    iget-object v1, p0, Llp$2;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;->isMarketplace()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 528
    new-instance v0, Llb;

    iget-object v1, p0, Llp$2;->b:Landroid/app/Activity;

    const v2, 0x7f08022b

    const v3, 0x7f080227

    invoke-direct {v0, v1, v2, v3}, Llb;-><init>(Landroid/content/Context;II)V

    goto :goto_0

    .line 529
    :cond_3
    iget-object v1, p0, Llp$2;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCondition()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Llp$2;->a:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getCondition()Ljava/lang/String;

    move-result-object v1

    const-string v2, "refurbished"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 530
    new-instance v0, Llb;

    iget-object v1, p0, Llp$2;->b:Landroid/app/Activity;

    const v2, 0x7f0802d2

    const v3, 0x7f0802d1

    invoke-direct {v0, v1, v2, v3}, Llb;-><init>(Landroid/content/Context;II)V

    goto :goto_0
.end method
