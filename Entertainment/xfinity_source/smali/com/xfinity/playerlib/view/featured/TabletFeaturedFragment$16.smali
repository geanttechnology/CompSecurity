.class Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$16;
.super Ljava/lang/Object;
.source "TabletFeaturedFragment.java"

# interfaces
.implements Lit/sephiroth/android/library/widget/AbsHListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->postOnResourceFetched(Lcom/comcast/cim/cmasl/utils/container/Tuple4;)V
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
    .line 526
    iput-object p1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$16;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onScroll(Lit/sephiroth/android/library/widget/AbsHListView;III)V
    .locals 0
    .param p1, "absHListView"    # Lit/sephiroth/android/library/widget/AbsHListView;
    .param p2, "i"    # I
    .param p3, "i2"    # I
    .param p4, "i3"    # I

    .prologue
    .line 535
    return-void
.end method

.method public onScrollStateChanged(Lit/sephiroth/android/library/widget/AbsHListView;I)V
    .locals 1
    .param p1, "absHListView"    # Lit/sephiroth/android/library/widget/AbsHListView;
    .param p2, "scrollState"    # I

    .prologue
    .line 529
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$16;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    # setter for: Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->seriesGalleryScrollState:I
    invoke-static {v0, p2}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->access$702(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;I)I

    .line 530
    return-void
.end method
