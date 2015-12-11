.class Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$15;
.super Ljava/lang/Object;
.source "TabletFeaturedFragment.java"

# interfaces
.implements Lit/sephiroth/android/library/widget/AbsHListView$OnScrollListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->setupNewMoviesGallery(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

.field final synthetic val$newMoviesShadowLeft:Landroid/widget/ImageView;

.field final synthetic val$newMoviesShadowRight:Landroid/widget/ImageView;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;Landroid/widget/ImageView;Landroid/widget/ImageView;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    .prologue
    .line 492
    iput-object p1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$15;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$15;->val$newMoviesShadowLeft:Landroid/widget/ImageView;

    iput-object p3, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$15;->val$newMoviesShadowRight:Landroid/widget/ImageView;

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
    .line 501
    return-void
.end method

.method public onScrollStateChanged(Lit/sephiroth/android/library/widget/AbsHListView;I)V
    .locals 4
    .param p1, "absHListView"    # Lit/sephiroth/android/library/widget/AbsHListView;
    .param p2, "i"    # I

    .prologue
    .line 495
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$15;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$15;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    # getter for: Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->movieGallery:Lit/sephiroth/android/library/widget/HListView;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->access$600(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;)Lit/sephiroth/android/library/widget/HListView;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$15;->val$newMoviesShadowLeft:Landroid/widget/ImageView;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$15;->val$newMoviesShadowRight:Landroid/widget/ImageView;

    # invokes: Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->adjustScrollShadows(Lit/sephiroth/android/library/widget/HListView;Landroid/widget/ImageView;Landroid/widget/ImageView;)V
    invoke-static {v0, v1, v2, v3}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->access$400(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;Lit/sephiroth/android/library/widget/HListView;Landroid/widget/ImageView;Landroid/widget/ImageView;)V

    .line 496
    return-void
.end method
