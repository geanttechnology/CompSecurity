.class Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$5;
.super Ljava/lang/Object;
.source "CheckoutConfirmationFragment.java"

# interfaces
.implements Lcom/poshmark/http/BrainTreeHttpResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->fireOrderViaBrainTree_Step2(Lcom/poshmark/data_model/models/BrainTreeGatewayInfo;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

.field final synthetic val$info:Lcom/poshmark/data_model/models/BrainTreeGatewayInfo;

.field final synthetic val$map:Ljava/util/Map;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;Ljava/util/Map;Lcom/poshmark/data_model/models/BrainTreeGatewayInfo;)V
    .locals 0

    .prologue
    .line 285
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$5;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    iput-object p2, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$5;->val$map:Ljava/util/Map;

    iput-object p3, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$5;->val$info:Lcom/poshmark/data_model/models/BrainTreeGatewayInfo;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/PMHttpResponse;)V
    .locals 11
    .param p1, "response"    # Lcom/poshmark/http/PMHttpResponse;

    .prologue
    const/4 v8, 0x0

    .line 288
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$5;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    invoke-virtual {v6}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->isAdded()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 289
    invoke-virtual {p1}, Lcom/poshmark/http/PMHttpResponse;->hasError()Z

    move-result v6

    if-nez v6, :cond_1

    .line 292
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$5;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    iput v8, v6, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->CURRENT_REDIRECT_URL_RETRY_COUNT:I

    .line 293
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    iget-object v6, p1, Lcom/poshmark/http/PMHttpResponse;->headerArray:[Lorg/apache/http/Header;

    array-length v6, v6

    if-ge v2, v6, :cond_2

    .line 294
    iget-object v6, p1, Lcom/poshmark/http/PMHttpResponse;->headerArray:[Lorg/apache/http/Header;

    aget-object v1, v6, v2

    .line 295
    .local v1, "header":Lorg/apache/http/Header;
    invoke-interface {v1}, Lorg/apache/http/Header;->getName()Ljava/lang/String;

    move-result-object v6

    const-string v7, "Location"

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 296
    invoke-interface {v1}, Lorg/apache/http/Header;->getValue()Ljava/lang/String;

    move-result-object v5

    .line 297
    .local v5, "url":Ljava/lang/String;
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$5;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    iget-object v6, v6, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->flowHandler:Lcom/poshmark/utils/CheckoutFlowHandler;

    invoke-virtual {v6}, Lcom/poshmark/utils/CheckoutFlowHandler;->getPoshmarkOrder()Lcom/poshmark/data_model/models/PMOrder;

    move-result-object v4

    .line 298
    .local v4, "order":Lcom/poshmark/data_model/models/PMOrder;
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 299
    .local v3, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v6, "braintree_return_url"

    invoke-interface {v3, v6, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 300
    const-string v6, "checkout_type"

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/PMOrder;->getCheckoutType()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v3, v6, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 301
    const-string v6, "inventory_unit_ids"

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/PMOrder;->getInventoryUnitIds()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v3, v6, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 302
    const-string v6, "order_id"

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/PMOrder;->getOrderId()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v3, v6, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 303
    const-string v6, "user_id"

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v7

    invoke-virtual {v7}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v3, v6, v7}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 304
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$5;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    # invokes: Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->fireOrderViaServer(Ljava/util/Map;)V
    invoke-static {v6, v3}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->access$200(Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;Ljava/util/Map;)V

    .line 293
    .end local v3    # "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v4    # "order":Lcom/poshmark/data_model/models/PMOrder;
    .end local v5    # "url":Ljava/lang/String;
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 308
    .end local v1    # "header":Lorg/apache/http/Header;
    .end local v2    # "i":I
    :cond_1
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$5;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    iget v6, v6, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->CURRENT_REDIRECT_URL_RETRY_COUNT:I

    iget-object v7, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$5;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    iget v7, v7, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->REDIRECT_URL_RETRY_COUNT:I

    if-gt v6, v7, :cond_3

    .line 309
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$5;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    iget v7, v6, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->CURRENT_REDIRECT_URL_RETRY_COUNT:I

    add-int/lit8 v7, v7, 0x1

    iput v7, v6, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->CURRENT_REDIRECT_URL_RETRY_COUNT:I

    .line 310
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$5;->val$map:Ljava/util/Map;

    iget-object v7, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$5;->val$info:Lcom/poshmark/data_model/models/BrainTreeGatewayInfo;

    iget-object v7, v7, Lcom/poshmark/data_model/models/BrainTreeGatewayInfo;->form_action:Ljava/lang/String;

    invoke-static {v6, v7, p0}, Lcom/poshmark/http/api/BrainTreeApi;->PostBrainTreeValidation(Ljava/util/Map;Ljava/lang/String;Lcom/poshmark/http/BrainTreeHttpResponseHandler;)V

    .line 320
    :cond_2
    :goto_1
    return-void

    .line 312
    :cond_3
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$5;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    invoke-virtual {v6}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->hideProgressDialog()V

    .line 313
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$5;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    iput v8, v6, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->CURRENT_REDIRECT_URL_RETRY_COUNT:I

    .line 314
    new-instance v0, Lcom/poshmark/http/api/PMApiError;

    const/4 v6, 0x0

    iget-object v7, p1, Lcom/poshmark/http/PMHttpResponse;->httpError:Lcom/poshmark/http/PMHttpError;

    iget-object v7, v7, Lcom/poshmark/http/PMHttpError;->exception:Ljava/lang/Throwable;

    iget v8, p1, Lcom/poshmark/http/PMHttpResponse;->httpCode:I

    sget-object v9, Lcom/poshmark/data_model/models/PMErrorType;->UNKNOWN_ERROR:Lcom/poshmark/data_model/models/PMErrorType;

    invoke-direct {v0, v6, v7, v8, v9}, Lcom/poshmark/http/api/PMApiError;-><init>(Lcom/poshmark/data_model/models/PMError;Ljava/lang/Throwable;ILcom/poshmark/data_model/models/PMErrorType;)V

    .line 315
    .local v0, "error":Lcom/poshmark/http/api/PMApiError;
    iget-object v6, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$5;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    new-instance v7, Lcom/poshmark/ui/model/ActionErrorContext;

    sget-object v8, Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;->SUBMIT_CC:Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;

    iget-object v9, p0, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment$5;->this$0:Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;

    const v10, 0x7f0600f5

    invoke-virtual {v9, v10}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->getString(I)Ljava/lang/String;

    move-result-object v9

    sget-object v10, Lcom/poshmark/ui/model/ActionErrorContext$Severity;->HIGH:Lcom/poshmark/ui/model/ActionErrorContext$Severity;

    invoke-direct {v7, v0, v8, v9, v10}, Lcom/poshmark/ui/model/ActionErrorContext;-><init>(Lcom/poshmark/http/api/PMApiError;Lcom/poshmark/ui/model/ActionErrorContext$ActionContext;Ljava/lang/String;Lcom/poshmark/ui/model/ActionErrorContext$Severity;)V

    invoke-virtual {v6, v7}, Lcom/poshmark/ui/fragments/CheckoutConfirmationFragment;->showError(Lcom/poshmark/ui/model/ActionErrorContext;)V

    goto :goto_1
.end method
