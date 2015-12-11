.class Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$1;
.super Ljava/lang/Object;
.source "CentralCustomerAttributeStoreCommunication.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->getAttribute(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;Ljava/util/EnumSet;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;

.field final synthetic val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

.field final synthetic val$directedId:Ljava/lang/String;

.field final synthetic val$info:Landroid/os/Bundle;

.field final synthetic val$key:Ljava/lang/String;

.field final synthetic val$options:Ljava/util/EnumSet;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Ljava/util/EnumSet;Lcom/amazon/identity/auth/device/callback/CallbackFuture;)V
    .locals 0

    .prologue
    .line 91
    iput-object p1, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$1;->this$0:Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;

    iput-object p2, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$1;->val$directedId:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$1;->val$key:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$1;->val$info:Landroid/os/Bundle;

    iput-object p5, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$1;->val$options:Ljava/util/EnumSet;

    iput-object p6, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$1;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 12

    .prologue
    const/4 v9, 0x1

    .line 96
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$1;->this$0:Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;

    const-string/jumbo v1, "getAttribute"

    iget-object v2, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$1;->val$directedId:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$1;->val$key:Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$1;->val$info:Landroid/os/Bundle;

    iget-object v5, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$1;->val$options:Ljava/util/EnumSet;

    # invokes: Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->getJsonCommandInfo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Ljava/util/EnumSet;)Lorg/json/JSONObject;
    invoke-static/range {v0 .. v5}, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->access$000(Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Ljava/util/EnumSet;)Lorg/json/JSONObject;

    move-result-object v6

    .line 98
    .local v6, "commandInfo":Lorg/json/JSONObject;
    if-nez v6, :cond_0

    .line 100
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$1;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    const-string/jumbo v1, "Cannot construct command"

    invoke-static {v0, v9, v1}, Lcom/amazon/identity/auth/attributes/AttributeCallbackHelpers;->callbackWithError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V

    .line 124
    :goto_0
    return-void

    .line 108
    :cond_0
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$1;->this$0:Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;

    # invokes: Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->queryCentralStore(Lorg/json/JSONObject;)Landroid/os/Bundle;
    invoke-static {v0, v6}, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->access$100(Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;Lorg/json/JSONObject;)Landroid/os/Bundle;

    move-result-object v3

    .line 110
    .local v3, "result":Landroid/os/Bundle;
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$1;->this$0:Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;

    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$1;->val$key:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$1;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    const/4 v4, 0x2

    const-string/jumbo v5, "Key %s not supported"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    iget-object v11, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$1;->val$key:Ljava/lang/String;

    aput-object v11, v9, v10

    invoke-static {v5, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-static/range {v0 .. v5}, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->access$200(Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;Ljava/lang/String;Lcom/amazon/identity/auth/device/callback/CallbackFuture;Landroid/os/Bundle;ILjava/lang/String;)V
    :try_end_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 116
    .end local v3    # "result":Landroid/os/Bundle;
    :catch_0
    move-exception v7

    .line 118
    .local v7, "e":Ljava/util/concurrent/ExecutionException;
    const-string/jumbo v8, "Failed to call getAttribute"

    .line 119
    .local v8, "errorMsg":Ljava/lang/String;
    # getter for: Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->access$300()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v8, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 120
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$1;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    const/4 v1, 0x4

    invoke-static {v0, v1, v8}, Lcom/amazon/identity/auth/attributes/AttributeCallbackHelpers;->callbackWithError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V

    goto :goto_0
.end method
