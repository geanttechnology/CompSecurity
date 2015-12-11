.class Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5$1;
.super Ljava/lang/Object;
.source "AccountManagerLogic.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;->onSuccess()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;)V
    .locals 0

    .prologue
    .line 962
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5$1;->this$1:Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 967
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5$1;->this$1:Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;

    iget-object v1, v1, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;->val$directedId:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5$1;->this$1:Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;

    iget-object v2, v2, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;->this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    # getter for: Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mMultipleAccountPlugin:Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;
    invoke-static {v2}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->access$900(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;)Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/identity/auth/attributes/CorPfmLogic;->notifyChange(Ljava/lang/String;Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;)V

    .line 971
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5$1;->this$1:Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;

    iget-object v1, v1, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;->val$userData:Landroid/os/Bundle;

    const-string/jumbo v2, "com.amazon.dcp.sso.property.devicename"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 972
    .local v0, "deviceName":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5$1;->this$1:Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;

    iget-object v1, v1, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;->this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    # getter for: Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mContext:Landroid/content/Context;
    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->access$100(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;)Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5$1;->this$1:Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;

    iget-object v2, v2, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;->val$directedId:Ljava/lang/String;

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/attributes/UserProperties;->sendDeviceNameChangedNotification(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    .line 974
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5$1;->this$1:Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;

    iget-object v1, v1, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;->this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    # getter for: Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mAmazonAccountManager:Lcom/amazon/identity/auth/accounts/AmazonAccountManager;
    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->access$1000(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;)Lcom/amazon/identity/auth/accounts/AmazonAccountManager;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5$1;->this$1:Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;

    iget-object v2, v2, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;->val$directedId:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/accounts/AmazonAccountManager;->isSecondaryAmazonAccount(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 978
    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5$1;->this$1:Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;

    iget-object v1, v1, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;->this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5$1;->this$1:Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;

    iget-object v2, v2, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;->val$deviceEmail:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5$1;->this$1:Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;

    iget-object v3, v3, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;->val$directedId:Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5$1;->this$1:Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;

    iget-object v4, v4, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;->val$deviceType:Ljava/lang/String;

    invoke-static {v1, v2, v3, v4}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->access$1100(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 980
    :cond_0
    return-void
.end method
