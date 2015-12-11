.class Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;)V
    .locals 0

    .prologue
    .line 91
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 94
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getLayout()Landroid/text/Layout;

    move-result-object v0

    .line 95
    if-eqz v0, :cond_0

    .line 96
    invoke-virtual {v0}, Landroid/text/Layout;->getLineCount()I

    move-result v1

    .line 97
    if-lez v1, :cond_0

    .line 98
    add-int/lit8 v1, v1, -0x1

    invoke-virtual {v0, v1}, Landroid/text/Layout;->getEllipsisCount(I)I

    move-result v0

    if-lez v0, :cond_0

    .line 99
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setMaxLines(I)V

    .line 100
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSkuAndTitleFragment;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setEms(I)V

    .line 104
    :cond_0
    return-void
.end method
