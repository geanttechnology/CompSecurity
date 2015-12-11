.class Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->b()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;)V
    .locals 0

    .prologue
    .line 184
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$4;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 187
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$4;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "http://www.bestbuy.com"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$4;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->d(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getMovieRatings()Lcom/bestbuy/android/api/lib/models/pdp/MovieRatings;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/MovieRatings;->getLink()Lcom/bestbuy/android/api/lib/models/pdp/Link;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/Link;->getUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;Ljava/lang/String;)Ljava/lang/String;

    .line 188
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$4;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$4;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a(Ljava/lang/String;)V

    .line 189
    return-void
.end method
