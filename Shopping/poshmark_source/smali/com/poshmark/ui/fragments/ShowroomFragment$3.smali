.class Lcom/poshmark/ui/fragments/ShowroomFragment$3;
.super Ljava/lang/Object;
.source "ShowroomFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/ShowroomFragment;->loadShowroom()V
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
        "Lcom/poshmark/data_model/models/Showroom;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/ShowroomFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/ShowroomFragment;)V
    .locals 0

    .prologue
    .line 281
    iput-object p1, p0, Lcom/poshmark/ui/fragments/ShowroomFragment$3;->this$0:Lcom/poshmark/ui/fragments/ShowroomFragment;

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
            "Lcom/poshmark/data_model/models/Showroom;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 284
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/Showroom;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment$3;->this$0:Lcom/poshmark/ui/fragments/ShowroomFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 285
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_0

    .line 286
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ShowroomFragment$3;->this$0:Lcom/poshmark/ui/fragments/ShowroomFragment;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/Showroom;

    # setter for: Lcom/poshmark/ui/fragments/ShowroomFragment;->showroom:Lcom/poshmark/data_model/models/Showroom;
    invoke-static {v1, v0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->access$202(Lcom/poshmark/ui/fragments/ShowroomFragment;Lcom/poshmark/data_model/models/Showroom;)Lcom/poshmark/data_model/models/Showroom;

    .line 288
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment$3;->this$0:Lcom/poshmark/ui/fragments/ShowroomFragment;

    const/4 v1, 0x0

    # invokes: Lcom/poshmark/ui/fragments/ShowroomFragment;->getShowroomListings(Z)V
    invoke-static {v0, v1}, Lcom/poshmark/ui/fragments/ShowroomFragment;->access$100(Lcom/poshmark/ui/fragments/ShowroomFragment;Z)V

    .line 289
    iget-object v0, p0, Lcom/poshmark/ui/fragments/ShowroomFragment$3;->this$0:Lcom/poshmark/ui/fragments/ShowroomFragment;

    # invokes: Lcom/poshmark/ui/fragments/ShowroomFragment;->updateHeaderView()V
    invoke-static {v0}, Lcom/poshmark/ui/fragments/ShowroomFragment;->access$300(Lcom/poshmark/ui/fragments/ShowroomFragment;)V

    .line 292
    :cond_0
    return-void
.end method
