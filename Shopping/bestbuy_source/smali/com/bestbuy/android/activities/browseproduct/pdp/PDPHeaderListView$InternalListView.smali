.class public Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;
.super Landroid/widget/ListView;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;


# direct methods
.method public constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0

    .prologue
    .line 296
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$InternalListView;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    .line 297
    invoke-direct {p0, p2, p3}, Landroid/widget/ListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 298
    return-void
.end method


# virtual methods
.method public computeVerticalScrollExtent()I
    .locals 1

    .prologue
    .line 302
    invoke-super {p0}, Landroid/widget/ListView;->computeVerticalScrollExtent()I

    move-result v0

    return v0
.end method

.method public computeVerticalScrollOffset()I
    .locals 1

    .prologue
    .line 307
    invoke-super {p0}, Landroid/widget/ListView;->computeVerticalScrollOffset()I

    move-result v0

    return v0
.end method

.method public computeVerticalScrollRange()I
    .locals 1

    .prologue
    .line 312
    invoke-super {p0}, Landroid/widget/ListView;->computeVerticalScrollRange()I

    move-result v0

    return v0
.end method
