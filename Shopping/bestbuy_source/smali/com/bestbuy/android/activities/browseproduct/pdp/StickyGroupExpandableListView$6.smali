.class Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$6;
.super Landroid/database/DataSetObserver;
.source "SourceFile"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->setAdapter(Lfd;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;)V
    .locals 0

    .prologue
    .line 326
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$6;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-direct {p0}, Landroid/database/DataSetObserver;-><init>()V

    return-void
.end method


# virtual methods
.method public onChanged()V
    .locals 2

    .prologue
    .line 329
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$6;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;Landroid/view/View;)Landroid/view/View;

    .line 330
    return-void
.end method

.method public onInvalidated()V
    .locals 2

    .prologue
    .line 334
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView$6;->a:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->a(Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;Landroid/view/View;)Landroid/view/View;

    .line 335
    return-void
.end method
