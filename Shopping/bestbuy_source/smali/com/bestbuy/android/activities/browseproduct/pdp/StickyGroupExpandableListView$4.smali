.class Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$4;
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
    .line 151
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$4;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 155
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$4;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->setPressed(Z)V

    .line 156
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$4;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->e(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 157
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$4;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->e(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/View;->setPressed(Z)V

    .line 159
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$4;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->invalidate()V

    .line 160
    return-void
.end method
