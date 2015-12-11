.class Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->a()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)V
    .locals 0

    .prologue
    .line 96
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)Landroid/widget/AbsListView$OnScrollListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 108
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)Landroid/widget/AbsListView$OnScrollListener;

    move-result-object v0

    invoke-interface {v0, p1, p2, p3, p4}, Landroid/widget/AbsListView$OnScrollListener;->onScroll(Landroid/widget/AbsListView;III)V

    .line 111
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->b(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)Lfd;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)Lfd;

    move-result-object v0

    invoke-virtual {v0}, Lfd;->getGroupCount()I

    move-result v0

    if-lez v0, :cond_1

    if-lez p3, :cond_1

    .line 112
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v0, p2}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;I)V

    .line 114
    :cond_1
    return-void
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)Landroid/widget/AbsListView$OnScrollListener;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 101
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$1;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)Landroid/widget/AbsListView$OnScrollListener;

    move-result-object v0

    invoke-interface {v0, p1, p2}, Landroid/widget/AbsListView$OnScrollListener;->onScrollStateChanged(Landroid/widget/AbsListView;I)V

    .line 103
    :cond_0
    return-void
.end method
