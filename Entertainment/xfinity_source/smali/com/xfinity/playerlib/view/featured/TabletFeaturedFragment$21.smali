.class Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$21;
.super Ljava/lang/Object;
.source "TabletFeaturedFragment.java"

# interfaces
.implements Lcom/xfinity/playerlib/view/ScrollStateTracker;


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
    .line 597
    iput-object p1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$21;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public isFlinging()Z
    .locals 2

    .prologue
    .line 600
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$21;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    # getter for: Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->coverVideoGalleryScrollState:I
    invoke-static {v0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->access$800(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;)I

    move-result v0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
