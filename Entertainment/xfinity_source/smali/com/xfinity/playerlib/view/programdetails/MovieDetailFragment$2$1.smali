.class Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2$1;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "MovieDetailFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple3;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener",
        "<",
        "Ljava/util/Map",
        "<",
        "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
        "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;

.field final synthetic val$dibicMovie:Lcom/xfinity/playerlib/model/dibic/DibicProgram;

.field final synthetic val$entitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;

    .prologue
    .line 208
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2$1;->val$entitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    iput-object p3, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2$1;->val$dibicMovie:Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 1
    .param p1, "e"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 218
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->onLoadingFailed()V

    .line 219
    return-void
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 208
    check-cast p1, Ljava/util/Map;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2$1;->onPostExecute(Ljava/util/Map;)V

    return-void
.end method

.method public onPostExecute(Ljava/util/Map;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 211
    .local p1, "bookmarks":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2$1;->val$entitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2$1;->val$dibicMovie:Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    invoke-virtual {v0, p1, v1, v2}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->presentConsumableMovie(Ljava/util/Map;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V

    .line 212
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->onLoadingFinished()V

    .line 213
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2$1;->this$1:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->detailArtView:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->access$300(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;)Landroid/widget/ImageView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 214
    return-void
.end method
