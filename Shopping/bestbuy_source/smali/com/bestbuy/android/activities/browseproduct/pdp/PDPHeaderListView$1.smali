.class public Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->a(Landroid/content/Context;Landroid/util/AttributeSet;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)V
    .locals 0

    .prologue
    .line 50
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 53
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lby;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 54
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPHeaderListView;)Lby;

    move-result-object v0

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move-wide v4, p4

    invoke-virtual/range {v0 .. v5}, Lby;->onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V

    .line 56
    :cond_0
    return-void
.end method
