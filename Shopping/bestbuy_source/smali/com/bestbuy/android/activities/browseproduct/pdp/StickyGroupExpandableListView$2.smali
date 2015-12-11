.class Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


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
    .line 117
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    const/4 v6, 0x1

    .line 121
    .line 123
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->d(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)Landroid/widget/ExpandableListView$OnGroupClickListener;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 124
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->d(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)Landroid/widget/ExpandableListView$OnGroupClickListener;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->e(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)Landroid/view/View;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->f(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)I

    move-result v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v4}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)Lfd;

    move-result-object v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v5}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->f(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)I

    move-result v5

    invoke-virtual {v4, v5}, Lfd;->getGroupId(I)J

    move-result-wide v4

    invoke-interface/range {v0 .. v5}, Landroid/widget/ExpandableListView$OnGroupClickListener;->onGroupClick(Landroid/widget/ExpandableListView;Landroid/view/View;IJ)Z

    move-result v0

    if-nez v0, :cond_1

    move v0, v6

    .line 127
    :goto_0
    if-eqz v0, :cond_0

    .line 128
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->c(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)Lfd;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->f(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)I

    move-result v1

    invoke-virtual {v0, v1}, Lfd;->a(I)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 129
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->f(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->collapseGroup(I)Z

    .line 134
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->f(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->setSelectedGroup(I)V

    .line 136
    :cond_0
    return-void

    .line 124
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 131
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$2;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->f(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->expandGroup(I)Z

    goto :goto_1

    :cond_3
    move v0, v6

    goto :goto_0
.end method
