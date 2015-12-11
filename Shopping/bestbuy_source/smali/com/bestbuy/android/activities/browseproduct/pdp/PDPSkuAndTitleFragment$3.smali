.class Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$3;
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
    .line 172
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 175
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;

    iget-object v1, v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0802a0

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;Ljava/lang/String;)Ljava/lang/String;

    .line 176
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$3;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a(Ljava/lang/String;)V

    .line 177
    return-void
.end method
