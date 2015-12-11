.class Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$11;
.super Ljava/lang/Object;
.source "TabletFeaturedFragment.java"

# interfaces
.implements Lit/sephiroth/android/library/widget/AdapterView$OnItemLongClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->setupMustSeeGallery(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    .prologue
    .line 433
    iput-object p1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$11;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemLongClick(Lit/sephiroth/android/library/widget/AdapterView;Landroid/view/View;IJ)Z
    .locals 6
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lit/sephiroth/android/library/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)Z"
        }
    .end annotation

    .prologue
    .line 436
    .local p1, "parent":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<*>;"
    invoke-virtual {p1, p3}, Lit/sephiroth/android/library/widget/AdapterView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/CoverVideo;

    .line 437
    .local v0, "cover":Lcom/xfinity/playerlib/model/CoverVideo;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/CoverVideo;->getEntityType()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Movie"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 438
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$11;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$11;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    new-instance v3, Lcom/xfinity/playerlib/model/VideoFavorite;

    .line 439
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/CoverVideo;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v4

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/CoverVideo;->getTitle()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Lcom/xfinity/playerlib/model/VideoFavorite;-><init>(Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/String;)V

    .line 438
    invoke-virtual {v1, v2, v3}, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->promptBookmarkDialog(Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;Lcom/xfinity/playerlib/model/VideoFavorite;)V

    .line 446
    :cond_0
    :goto_0
    const/4 v1, 0x1

    return v1

    .line 440
    :cond_1
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/CoverVideo;->getEntityType()Ljava/lang/String;

    move-result-object v1

    const-string v2, "TvSeries"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 441
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$11;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$11;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    new-instance v3, Lcom/xfinity/playerlib/model/VideoFavorite;

    .line 442
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/CoverVideo;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v4

    .line 443
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/CoverVideo;->getTitle()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Lcom/xfinity/playerlib/model/VideoFavorite;-><init>(Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/String;)V

    .line 441
    invoke-virtual {v1, v2, v3}, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->promptBookmarkDialog(Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;Lcom/xfinity/playerlib/model/VideoFavorite;)V

    goto :goto_0
.end method
