.class Lcom/xfinity/playerlib/view/browseprograms/MoviesFragment$1;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "MoviesFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browseprograms/MoviesFragment;->getTaskExecutionListener()Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener",
        "<",
        "Lcom/comcast/cim/cmasl/utils/container/Tuple",
        "<",
        "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
        "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/MoviesFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/MoviesFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browseprograms/MoviesFragment;

    .prologue
    .line 78
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/MoviesFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/MoviesFragment;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 1
    .param p1, "error"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 93
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MoviesFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/MoviesFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/MoviesFragment;->getLoadingViewDelegate()Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onLoadingFailed()V

    .line 94
    return-void
.end method

.method public onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 87
    .local p1, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;>;"
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/MoviesFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/MoviesFragment;

    iget-object v0, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e1:Ljava/lang/Object;

    check-cast v0, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getPrograms()Ljava/util/List;

    move-result-object v2

    iget-object v0, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    check-cast v0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    invoke-virtual {v1, v2, v0}, Lcom/xfinity/playerlib/view/browseprograms/MoviesFragment;->displayPrograms(Ljava/util/List;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V

    .line 88
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MoviesFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/MoviesFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/MoviesFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$id;->ACCESSIBILITY_ANNOUNCE_LOADED:I

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speakManagedMessage(I)V

    .line 89
    return-void
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 78
    check-cast p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/MoviesFragment$1;->onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple;)V

    return-void
.end method

.method public onPreAsynchronousExecute()V
    .locals 2

    .prologue
    .line 82
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/MoviesFragment$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/MoviesFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/MoviesFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->loading:I

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speakManagedMessage(I)V

    .line 83
    return-void
.end method
