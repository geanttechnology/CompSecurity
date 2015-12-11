.class Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$2;
.super Ljava/lang/Object;
.source "CentralCustomerAttributeStoreCommunication.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->setAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;

.field final synthetic val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

.field final synthetic val$directedId:Ljava/lang/String;

.field final synthetic val$key:Ljava/lang/String;

.field final synthetic val$value:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/callback/CallbackFuture;)V
    .locals 0

    .prologue
    .line 172
    iput-object p1, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$2;->this$0:Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;

    iput-object p2, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$2;->val$key:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$2;->val$value:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$2;->val$directedId:Ljava/lang/String;

    iput-object p5, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$2;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 13

    .prologue
    const/4 v10, 0x1

    .line 176
    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    .line 177
    .local v4, "attributeBundle":Landroid/os/Bundle;
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$2;->val$key:Ljava/lang/String;

    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$2;->val$value:Ljava/lang/String;

    invoke-virtual {v4, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 179
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$2;->this$0:Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;

    const-string/jumbo v1, "setAttribute"

    iget-object v2, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$2;->val$directedId:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$2;->val$key:Ljava/lang/String;

    const/4 v5, 0x0

    # invokes: Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->getJsonCommandInfo(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Ljava/util/EnumSet;)Lorg/json/JSONObject;
    invoke-static/range {v0 .. v5}, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->access$000(Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Ljava/util/EnumSet;)Lorg/json/JSONObject;

    move-result-object v11

    .line 181
    .local v11, "commandInfo":Lorg/json/JSONObject;
    if-nez v11, :cond_0

    .line 183
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$2;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    const-string/jumbo v1, "Cannot construct command"

    invoke-static {v0, v10, v1}, Lcom/amazon/identity/auth/attributes/AttributeCallbackHelpers;->callbackWithError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V

    .line 205
    :goto_0
    return-void

    .line 189
    :cond_0
    const/4 v8, 0x0

    .line 192
    .local v8, "result":Landroid/os/Bundle;
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$2;->this$0:Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;

    # invokes: Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->queryCentralStore(Lorg/json/JSONObject;)Landroid/os/Bundle;
    invoke-static {v0, v11}, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->access$100(Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;Lorg/json/JSONObject;)Landroid/os/Bundle;
    :try_end_0
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v8

    .line 199
    :goto_1
    iget-object v5, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$2;->this$0:Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;

    iget-object v6, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$2;->val$key:Ljava/lang/String;

    iget-object v7, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$2;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    const/4 v9, 0x5

    const-string/jumbo v0, "Unable to set the attribute for key: %s."

    new-array v1, v10, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication$2;->val$key:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-static/range {v5 .. v10}, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->access$200(Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;Ljava/lang/String;Lcom/amazon/identity/auth/device/callback/CallbackFuture;Landroid/os/Bundle;ILjava/lang/String;)V

    goto :goto_0

    .line 194
    :catch_0
    move-exception v12

    .line 196
    .local v12, "e":Ljava/util/concurrent/ExecutionException;
    # getter for: Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/attributes/CentralCustomerAttributeStoreCommunication;->access$300()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Failed to setAttribute in central customer attribute store"

    invoke-static {v0, v1, v12}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1
.end method
