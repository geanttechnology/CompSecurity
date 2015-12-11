.class Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2$1;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "TabletFeaturedFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2;->onLoadError(Landroid/widget/ImageView;Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener",
        "<",
        "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2;

    .prologue
    .line 255
    iput-object p1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2$1;->this$1:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 2
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 264
    # getter for: Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->access$200()Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "Couldn\'t get title for last watched"

    invoke-interface {v0, v1, p1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 265
    return-void
.end method

.method public onPostExecute(Lcom/xfinity/playerlib/model/dibic/DibicResource;)V
    .locals 3
    .param p1, "resource"    # Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .prologue
    .line 258
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2$1;->this$1:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2;->val$parentMerlinId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-interface {p1, v1}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getProgramByMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    move-result-object v0

    .line 259
    .local v0, "lastWatched":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2$1;->this$1:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getTitle()Ljava/lang/String;

    move-result-object v2

    # invokes: Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->showLastWatchTitle(Ljava/lang/String;)V
    invoke-static {v1, v2}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->access$300(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;Ljava/lang/String;)V

    .line 260
    return-void
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 255
    check-cast p1, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$2$1;->onPostExecute(Lcom/xfinity/playerlib/model/dibic/DibicResource;)V

    return-void
.end method
