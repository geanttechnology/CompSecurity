.class Lcom/poshmark/ui/fragments/CommentFragment$1;
.super Ljava/lang/Object;
.source "CommentFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/CommentFragment;->onActivityCreated(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/poshmark/http/api/PMApiResponseHandler",
        "<",
        "Lcom/poshmark/data_model/models/UserInteractions;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CommentFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CommentFragment;)V
    .locals 0

    .prologue
    .line 87
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CommentFragment$1;->this$0:Lcom/poshmark/ui/fragments/CommentFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/UserInteractions;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 90
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/UserInteractions;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CommentFragment$1;->this$0:Lcom/poshmark/ui/fragments/CommentFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/CommentFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 91
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_0

    .line 92
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CommentFragment$1;->this$0:Lcom/poshmark/ui/fragments/CommentFragment;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/UserInteractions;

    iput-object v0, v1, Lcom/poshmark/ui/fragments/CommentFragment;->interactionsData:Lcom/poshmark/data_model/models/UserInteractions;

    .line 93
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CommentFragment$1;->this$0:Lcom/poshmark/ui/fragments/CommentFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/CommentFragment;->interactionsData:Lcom/poshmark/data_model/models/UserInteractions;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CommentFragment$1;->this$0:Lcom/poshmark/ui/fragments/CommentFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/CommentFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingSocial;

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/models/UserInteractions;->addContextualData(Lcom/poshmark/data_model/models/ListingSocial;)V

    .line 94
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CommentFragment$1;->this$0:Lcom/poshmark/ui/fragments/CommentFragment;

    # invokes: Lcom/poshmark/ui/fragments/CommentFragment;->updateAutoCompleteView()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/CommentFragment;->access$000(Lcom/poshmark/ui/fragments/CommentFragment;)V

    .line 97
    :cond_0
    return-void
.end method
