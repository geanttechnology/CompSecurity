.class Lcom/poshmark/utils/BundleFlowHandler$1;
.super Ljava/lang/Object;
.source "BundleFlowHandler.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/BundleFlowHandler;->addProductWithId(Ljava/util/List;)V
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
.field final synthetic this$0:Lcom/poshmark/utils/BundleFlowHandler;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/BundleFlowHandler;)V
    .locals 0

    .prologue
    .line 78
    iput-object p1, p0, Lcom/poshmark/utils/BundleFlowHandler$1;->this$0:Lcom/poshmark/utils/BundleFlowHandler;

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
    .line 81
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/PMOrder;>;"
    iget-object v0, p0, Lcom/poshmark/utils/BundleFlowHandler$1;->this$0:Lcom/poshmark/utils/BundleFlowHandler;

    iget-object v0, v0, Lcom/poshmark/utils/BundleFlowHandler;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 82
    iget-object v0, p0, Lcom/poshmark/utils/BundleFlowHandler$1;->this$0:Lcom/poshmark/utils/BundleFlowHandler;

    # invokes: Lcom/poshmark/utils/BundleFlowHandler;->handleAddProductResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    invoke-static {v0, p1}, Lcom/poshmark/utils/BundleFlowHandler;->access$000(Lcom/poshmark/utils/BundleFlowHandler;Lcom/poshmark/http/api/PMApiResponse;)V

    .line 84
    :cond_0
    return-void
.end method
