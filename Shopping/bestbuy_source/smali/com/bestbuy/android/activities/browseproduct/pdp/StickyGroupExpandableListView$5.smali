.class Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$5;
.super Landroid/view/GestureDetector$SimpleOnGestureListener;
.source "SourceFile"


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
    .line 163
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$5;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-direct {p0}, Landroid/view/GestureDetector$SimpleOnGestureListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onLongPress(Landroid/view/MotionEvent;)V
    .locals 6

    .prologue
    .line 167
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$5;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->e(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$5;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->e(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->isLongClickable()Z

    move-result v0

    if-nez v0, :cond_0

    .line 168
    new-instance v0, Landroid/widget/ExpandableListView$ExpandableListContextMenuInfo;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$5;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->e(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)Landroid/view/View;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$5;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->f(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)I

    move-result v2

    invoke-static {v2}, Landroid/widget/ExpandableListView;->getPackedPositionForGroup(I)J

    move-result-wide v2

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$5;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v4}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)Lfd;

    move-result-object v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$5;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v5}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->f(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)I

    move-result v5

    invoke-virtual {v4, v5}, Lfd;->getGroupId(I)J

    move-result-wide v4

    invoke-direct/range {v0 .. v5}, Landroid/widget/ExpandableListView$ExpandableListContextMenuInfo;-><init>(Landroid/view/View;JJ)V

    .line 169
    const-class v1, Landroid/widget/AbsListView;

    const-string v2, "mContextMenuInfo"

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$5;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v1, v2, v3, v0}, Lnp;->a(Ljava/lang/Class;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 170
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$5;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->showContextMenu()Z

    .line 172
    :cond_0
    return-void
.end method
