.class Lcom/xfinity/playerlib/view/featured/FeaturedFragment$3;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "FeaturedFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->loadResources()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener",
        "<",
        "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
        "<",
        "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
        "Lcom/xfinity/playerlib/model/editorial/FeaturedResource;",
        "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
        "Lcom/comcast/cim/cmasl/utils/container/Option",
        "<",
        "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
        ">;>;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/featured/FeaturedFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/featured/FeaturedFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/featured/FeaturedFragment;

    .prologue
    .line 166
    iput-object p1, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment$3;->this$0:Lcom/xfinity/playerlib/view/featured/FeaturedFragment;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 1
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 184
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment$3;->this$0:Lcom/xfinity/playerlib/view/featured/FeaturedFragment;

    # getter for: Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->access$100(Lcom/xfinity/playerlib/view/featured/FeaturedFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onLoadingFailed()V

    .line 185
    return-void
.end method

.method public onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple4;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/editorial/FeaturedResource;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/comcast/cim/cmasl/utils/container/Option",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 176
    .local p1, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple4;, "Lcom/comcast/cim/cmasl/utils/container/Tuple4<Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/editorial/FeaturedResource;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/comcast/cim/cmasl/utils/container/Option<Lcom/xfinity/playerlib/bookmarks/Bookmark;>;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment$3;->this$0:Lcom/xfinity/playerlib/view/featured/FeaturedFragment;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->setupResources(Lcom/comcast/cim/cmasl/utils/container/Tuple4;)V

    .line 177
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment$3;->this$0:Lcom/xfinity/playerlib/view/featured/FeaturedFragment;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->postOnResourceFetched(Lcom/comcast/cim/cmasl/utils/container/Tuple4;)V

    .line 178
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment$3;->this$0:Lcom/xfinity/playerlib/view/featured/FeaturedFragment;

    # getter for: Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->access$100(Lcom/xfinity/playerlib/view/featured/FeaturedFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onLoadingFinished()V

    .line 179
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment$3;->this$0:Lcom/xfinity/playerlib/view/featured/FeaturedFragment;

    # getter for: Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->access$000(Lcom/xfinity/playerlib/view/featured/FeaturedFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$id;->ACCESSIBILITY_ANNOUNCE_LOADED:I

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speakManagedMessage(I)V

    .line 180
    return-void
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 166
    check-cast p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment$3;->onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple4;)V

    return-void
.end method

.method public onPreAsynchronousExecute()V
    .locals 2

    .prologue
    .line 170
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment$3;->this$0:Lcom/xfinity/playerlib/view/featured/FeaturedFragment;

    # getter for: Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->access$000(Lcom/xfinity/playerlib/view/featured/FeaturedFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->loading:I

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speakManagedMessage(I)V

    .line 171
    return-void
.end method
