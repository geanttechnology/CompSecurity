.class Lcom/poshmark/ui/fragments/PartyFragment$4;
.super Ljava/lang/Object;
.source "PartyFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/PartyFragment;->loadEventListings(Z)V
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
        "Lcom/poshmark/data_model/models/PartyEventListings;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/PartyFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/PartyFragment;)V
    .locals 0

    .prologue
    .line 251
    iput-object p1, p0, Lcom/poshmark/ui/fragments/PartyFragment$4;->this$0:Lcom/poshmark/ui/fragments/PartyFragment;

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
            "Lcom/poshmark/data_model/models/PartyEventListings;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 254
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/PartyEventListings;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment$4;->this$0:Lcom/poshmark/ui/fragments/PartyFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PartyFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 255
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_0

    .line 256
    iget-object v0, p0, Lcom/poshmark/ui/fragments/PartyFragment$4;->this$0:Lcom/poshmark/ui/fragments/PartyFragment;

    const/4 v1, 0x1

    # invokes: Lcom/poshmark/ui/fragments/PartyFragment;->handlePastEventResponse(Lcom/poshmark/http/api/PMApiResponse;Z)V
    invoke-static {v0, p1, v1}, Lcom/poshmark/ui/fragments/PartyFragment;->access$100(Lcom/poshmark/ui/fragments/PartyFragment;Lcom/poshmark/http/api/PMApiResponse;Z)V

    .line 259
    :cond_0
    return-void
.end method
