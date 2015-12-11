.class Lcom/poshmark/ui/fragments/MakeOfferFragment$4;
.super Ljava/lang/Object;
.source "MakeOfferFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/MakeOfferFragment;->setupOffer(Ljava/lang/String;)V
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
        "Lcom/poshmark/data_model/models/PMOfferInfo;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/MakeOfferFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/MakeOfferFragment;)V
    .locals 0

    .prologue
    .line 204
    iput-object p1, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment$4;->this$0:Lcom/poshmark/ui/fragments/MakeOfferFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/PMOfferInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 207
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/PMOfferInfo;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment$4;->this$0:Lcom/poshmark/ui/fragments/MakeOfferFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 208
    iget-object v0, p0, Lcom/poshmark/ui/fragments/MakeOfferFragment$4;->this$0:Lcom/poshmark/ui/fragments/MakeOfferFragment;

    # invokes: Lcom/poshmark/ui/fragments/MakeOfferFragment;->handleAddProductResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    invoke-static {v0, p1}, Lcom/poshmark/ui/fragments/MakeOfferFragment;->access$300(Lcom/poshmark/ui/fragments/MakeOfferFragment;Lcom/poshmark/http/api/PMApiResponse;)V

    .line 210
    :cond_0
    return-void
.end method
