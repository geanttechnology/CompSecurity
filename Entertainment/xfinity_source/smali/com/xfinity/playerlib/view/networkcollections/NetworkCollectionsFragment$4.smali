.class Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$4;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "NetworkCollectionsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->loadResources()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener",
        "<",
        "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    .prologue
    .line 202
    iput-object p1, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$4;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 1
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 211
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$4;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->getLoadingViewDelegate()Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onLoadingFailed()V

    .line 212
    return-void
.end method

.method public onPostExecute(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V
    .locals 1
    .param p1, "resource"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .prologue
    .line 205
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$4;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    # setter for: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    invoke-static {v0, p1}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$302(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 206
    iget-object v0, p0, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$4;->this$0:Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;

    # invokes: Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->displayScreenProgramsIfReady()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;->access$400(Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment;)V

    .line 207
    return-void
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 202
    check-cast p1, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/networkcollections/NetworkCollectionsFragment$4;->onPostExecute(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V

    return-void
.end method
