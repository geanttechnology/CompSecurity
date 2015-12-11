.class Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$7;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->a(I)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)V
    .locals 0

    .prologue
    .line 399
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$7;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 403
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$7;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$7;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->h(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)Ljava/lang/Runnable;

    move-result-object v1

    invoke-static {}, Landroid/view/ViewConfiguration;->getPressedStateDuration()I

    move-result v2

    int-to-long v2, v2

    invoke-virtual {v0, v1, v2, v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 404
    return-void
.end method
