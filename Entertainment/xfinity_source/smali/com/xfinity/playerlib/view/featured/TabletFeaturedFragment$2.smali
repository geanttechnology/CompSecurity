.class Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2;
.super Ljava/lang/Object;
.source "TabletFeaturedFragment.java"

# interfaces
.implements Lcom/comcast/cim/android/image/CimImageLoader$OnLoadListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->showLastWatched(Lcom/xfinity/playerlib/bookmarks/Bookmark;Landroid/widget/ProgressBar;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

.field final synthetic val$parentMerlinId:Lcom/xfinity/playerlib/model/MerlinId;

.field final synthetic val$title:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/String;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    .prologue
    .line 243
    iput-object p1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2;->val$parentMerlinId:Lcom/xfinity/playerlib/model/MerlinId;

    iput-object p3, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2;->val$title:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLoad(Landroid/widget/ImageView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 0
    .param p1, "imageView"    # Landroid/widget/ImageView;
    .param p2, "imageUrl"    # Ljava/lang/String;
    .param p3, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 246
    return-void
.end method

.method public onLoadError(Landroid/widget/ImageView;Ljava/lang/String;)V
    .locals 3
    .param p1, "imageView"    # Landroid/widget/ImageView;
    .param p2, "imageUrl"    # Ljava/lang/String;

    .prologue
    .line 250
    # getter for: Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->access$200()Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "Couldn\'t load program art for last watched, show the title"

    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2;->val$parentMerlinId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-interface {v0, v1, v2}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;Ljava/lang/Object;)V

    .line 252
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2;->val$title:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2;->val$title:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 253
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2;->val$title:Ljava/lang/String;

    # invokes: Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->showLastWatchTitle(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->access$300(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;Ljava/lang/String;)V

    .line 269
    :goto_0
    return-void

    .line 255
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->programProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    new-instance v2, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2$1;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2$1;-><init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2;)V

    invoke-interface {v1, v2}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v1

    iput-object v1, v0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->programListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    goto :goto_0
.end method
