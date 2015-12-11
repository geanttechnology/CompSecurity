.class Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$10;
.super Ljava/lang/Object;
.source "TabletFeaturedFragment.java"

# interfaces
.implements Lit/sephiroth/android/library/widget/AdapterView$OnItemClickListener;


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
    .line 425
    iput-object p1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$10;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Lit/sephiroth/android/library/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 4
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lit/sephiroth/android/library/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 428
    .local p1, "parent":Lit/sephiroth/android/library/widget/AdapterView;, "Lit/sephiroth/android/library/widget/AdapterView<*>;"
    invoke-virtual {p1, p3}, Lit/sephiroth/android/library/widget/AdapterView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/CoverVideo;

    .line 429
    .local v0, "cover":Lcom/xfinity/playerlib/model/CoverVideo;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$10;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/CoverVideo;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v2

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/CoverVideo;->getEpisodeMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->showDetail(Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 430
    return-void
.end method
