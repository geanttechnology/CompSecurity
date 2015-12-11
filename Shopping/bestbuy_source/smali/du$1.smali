.class Ldu$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Ldu;->instantiateItem(Landroid/view/ViewGroup;I)Ljava/lang/Object;
.end annotation


# instance fields
.field final synthetic a:I

.field final synthetic b:Ldu;


# direct methods
.method constructor <init>(Ldu;I)V
    .locals 0

    .prologue
    .line 166
    iput-object p1, p0, Ldu$1;->b:Ldu;

    iput p2, p0, Ldu$1;->a:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 169
    iget-object v0, p0, Ldu$1;->b:Ldu;

    invoke-static {v0}, Ldu;->b(Ldu;)Landroid/app/Activity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    iget-object v1, p0, Ldu$1;->b:Ldu;

    invoke-static {v1}, Ldu;->a(Ldu;)Ljava/util/List;

    move-result-object v1

    iget v2, p0, Ldu$1;->a:I

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getSkuId()Ljava/lang/String;

    move-result-object v2

    iget-object v1, p0, Ldu$1;->b:Ldu;

    invoke-static {v1}, Ldu;->a(Ldu;)Ljava/util/List;

    move-result-object v1

    iget v3, p0, Ldu$1;->a:I

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/home/DealOfTheDay;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getProductId()Ljava/lang/String;

    move-result-object v1

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v1, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->openPDP(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 170
    return-void
.end method
