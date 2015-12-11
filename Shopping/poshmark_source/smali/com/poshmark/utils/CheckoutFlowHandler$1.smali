.class Lcom/poshmark/utils/CheckoutFlowHandler$1;
.super Ljava/lang/Object;
.source "CheckoutFlowHandler.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/CheckoutFlowHandler;->addProductWithId(Ljava/lang/String;)V
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
        "Lcom/poshmark/data_model/models/PMOrder;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/CheckoutFlowHandler;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/CheckoutFlowHandler;)V
    .locals 0

    .prologue
    .line 107
    iput-object p1, p0, Lcom/poshmark/utils/CheckoutFlowHandler$1;->this$0:Lcom/poshmark/utils/CheckoutFlowHandler;

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
            "Lcom/poshmark/data_model/models/PMOrder;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 110
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/PMOrder;>;"
    iget-object v0, p0, Lcom/poshmark/utils/CheckoutFlowHandler$1;->this$0:Lcom/poshmark/utils/CheckoutFlowHandler;

    iget-object v0, v0, Lcom/poshmark/utils/CheckoutFlowHandler;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 111
    iget-object v0, p0, Lcom/poshmark/utils/CheckoutFlowHandler$1;->this$0:Lcom/poshmark/utils/CheckoutFlowHandler;

    # invokes: Lcom/poshmark/utils/CheckoutFlowHandler;->handleAddProductResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    invoke-static {v0, p1}, Lcom/poshmark/utils/CheckoutFlowHandler;->access$000(Lcom/poshmark/utils/CheckoutFlowHandler;Lcom/poshmark/http/api/PMApiResponse;)V

    .line 113
    :cond_0
    return-void
.end method
