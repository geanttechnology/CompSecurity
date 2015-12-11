.class Lcom/amazon/identity/auth/accounts/AccountManagerLogic$7;
.super Ljava/lang/Object;
.source "AccountManagerLogic.java"

# interfaces
.implements Lcom/amazon/identity/auth/accounts/DeregisterAccount$IDeregisterAccount;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/accounts/AccountManagerLogic;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

.field final synthetic val$backCompatAccount:Landroid/accounts/Account;

.field final synthetic val$callback:Lcom/amazon/identity/auth/device/api/Callback;

.field final synthetic val$directedId:Ljava/lang/String;

.field final synthetic val$isPrimaryAccount:Z

.field final synthetic val$profilesForRemovedDirectedId:Ljava/util/Set;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;ZLjava/lang/String;Landroid/accounts/Account;Ljava/util/Set;Lcom/amazon/identity/auth/device/api/Callback;)V
    .locals 0

    .prologue
    .line 1273
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$7;->this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    iput-boolean p2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$7;->val$isPrimaryAccount:Z

    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$7;->val$directedId:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$7;->val$backCompatAccount:Landroid/accounts/Account;

    iput-object p5, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$7;->val$profilesForRemovedDirectedId:Ljava/util/Set;

    iput-object p6, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$7;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(ILjava/lang/String;)V
    .locals 5
    .param p1, "errorCode"    # I
    .param p2, "errorMsg"    # Ljava/lang/String;

    .prologue
    .line 1311
    # getter for: Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->access$700()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "Device deregistration error: code = %d, msg = \"%s\""

    const/4 v0, 0x2

    new-array v3, v0, [Ljava/lang/Object;

    const/4 v0, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v0

    const/4 v4, 0x1

    if-eqz p2, :cond_0

    move-object v0, p2

    :goto_0
    aput-object v0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1314
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$7;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    const/4 v1, 0x0

    invoke-static {v0, p1, p2, v1}, Lcom/amazon/identity/auth/accounts/AccountsCallbackHelpers;->onError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;Landroid/os/Bundle;)V

    .line 1315
    return-void

    .line 1311
    :cond_0
    const-string/jumbo v0, "<null>"

    goto :goto_0
.end method

.method public onResult(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 1277
    const-string/jumbo v0, "booleanResult"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1279
    # getter for: Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->access$700()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Device deregistration success"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1286
    :goto_0
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$7;->this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    # getter for: Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mContext:Landroid/content/Context;
    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->access$100(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;)Landroid/content/Context;

    move-result-object v0

    iget-boolean v1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$7;->val$isPrimaryAccount:Z

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$7;->val$directedId:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$7;->val$backCompatAccount:Landroid/accounts/Account;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$7;->val$profilesForRemovedDirectedId:Ljava/util/Set;

    invoke-static/range {v0 .. v5}, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts;->sendAccountRemovedNotification(Landroid/content/Context;ZLjava/lang/String;Landroid/accounts/Account;Ljava/lang/String;Ljava/util/Set;)V

    .line 1305
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$7;->this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$7;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->access$1300(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 1306
    return-void

    .line 1283
    :cond_0
    # getter for: Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->access$700()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Device deregistration failed"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
