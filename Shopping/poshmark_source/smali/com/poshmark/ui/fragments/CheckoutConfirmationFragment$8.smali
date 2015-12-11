.class Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$8;
.super Ljava/lang/Object;
.source "CheckoutConfirmationFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->handlePostOrderResponse(Lcom/poshmark/http/api/PMApiResponse;Lcom/poshmark/data_model/models/PMOrder;Ljava/util/Map;)V
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
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

.field final synthetic val$map:Ljava/util/Map;

.field final synthetic val$order:Lcom/poshmark/data_model/models/PMOrder;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;Lcom/poshmark/data_model/models/PMOrder;Ljava/util/Map;)V
    .locals 0

    .prologue
    .line 383
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$8;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    iput-object p2, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$8;->val$order:Lcom/poshmark/data_model/models/PMOrder;

    iput-object p3, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$8;->val$map:Ljava/util/Map;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 3
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
    .line 386
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/PMOrder;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$8;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 387
    iget-object v0, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$8;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$8;->val$order:Lcom/poshmark/data_model/models/PMOrder;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$8;->val$map:Ljava/util/Map;

    # invokes: Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->handlePostOrderResponse(Lcom/poshmark/http/api/PMApiResponse;Lcom/poshmark/data_model/models/PMOrder;Ljava/util/Map;)V
    invoke-static {v0, p1, v1, v2}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->access$300(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;Lcom/poshmark/http/api/PMApiResponse;Lcom/poshmark/data_model/models/PMOrder;Ljava/util/Map;)V

    .line 389
    :cond_0
    return-void
.end method
