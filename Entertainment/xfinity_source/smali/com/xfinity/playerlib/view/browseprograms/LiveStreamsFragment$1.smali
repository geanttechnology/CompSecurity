.class Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$1;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "LiveStreamsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener",
        "<",
        "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContentResource;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 93
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 2
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 102
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarouselContainer:Lcom/xfinity/playerlib/view/PagerContainer;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$200(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/xfinity/playerlib/view/PagerContainer;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/PagerContainer;->setVisibility(I)V

    .line 103
    return-void
.end method

.method public onPostExecute(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContentResource;)V
    .locals 2
    .param p1, "resource"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContentResource;

    .prologue
    .line 96
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContentResource;->getLiveFeaturedContent()Ljava/util/List;

    move-result-object v1

    # setter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveFeaturedContentList:Ljava/util/List;
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$002(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;Ljava/util/List;)Ljava/util/List;

    .line 97
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # invokes: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->displayLiveFeaturedContent()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$100(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)V

    .line 98
    return-void
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 93
    check-cast p1, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContentResource;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$1;->onPostExecute(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContentResource;)V

    return-void
.end method
