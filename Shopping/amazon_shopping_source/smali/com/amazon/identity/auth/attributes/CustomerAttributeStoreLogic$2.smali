.class Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$2;
.super Ljava/lang/Object;
.source "CustomerAttributeStoreLogic.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->setAttribute(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;

.field final synthetic val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

.field final synthetic val$directedId:Ljava/lang/String;

.field final synthetic val$key:Ljava/lang/String;

.field final synthetic val$value:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/callback/CallbackFuture;)V
    .locals 0

    .prologue
    .line 202
    iput-object p1, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$2;->this$0:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;

    iput-object p2, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$2;->val$key:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$2;->val$directedId:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$2;->val$value:Ljava/lang/String;

    iput-object p5, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$2;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 206
    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$2;->val$key:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->parseKey(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/KeyInfo;

    move-result-object v0

    .line 207
    .local v0, "keyInfo":Lcom/amazon/identity/auth/device/utils/KeyInfo;
    # getter for: Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->access$500()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "Setting the attribute for key: %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getRawKey()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 208
    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$2;->this$0:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;

    # getter for: Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->mCustomerAttributeDataStorage:Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;
    invoke-static {v1}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->access$600(Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;)Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$2;->val$directedId:Ljava/lang/String;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getRawKey()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$2;->val$value:Ljava/lang/String;

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/identity/auth/device/storage/LocalAppDataAwareDataStorage;->setUserData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 209
    iget-object v1, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$2;->this$0:Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;

    iget-object v2, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$2;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    iget-object v3, p0, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic$2;->val$value:Ljava/lang/String;

    const/4 v4, 0x0

    # invokes: Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->callbackWithValueDefaultBundleResult(Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;Ljava/lang/String;)V
    invoke-static {v1, v2, v3, v4}, Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;->access$700(Lcom/amazon/identity/auth/attributes/CustomerAttributeStoreLogic;Lcom/amazon/identity/auth/device/api/Callback;Ljava/lang/String;Ljava/lang/String;)V

    .line 210
    return-void
.end method
