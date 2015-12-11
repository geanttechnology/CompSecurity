.class Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;
.super Ljava/lang/Object;
.source "AccountManagerLogic.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/storage/DataStorage$DataPropogationCallback;


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

.field final synthetic val$deviceEmail:Ljava/lang/String;

.field final synthetic val$deviceType:Ljava/lang/String;

.field final synthetic val$directedId:Ljava/lang/String;

.field final synthetic val$userData:Landroid/os/Bundle;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;Ljava/lang/String;Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 947
    iput-object p1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;->this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    iput-object p2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;->val$directedId:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;->val$userData:Landroid/os/Bundle;

    iput-object p4, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;->val$deviceEmail:Ljava/lang/String;

    iput-object p5, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;->val$deviceType:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onSuccess()V
    .locals 5

    .prologue
    .line 952
    # getter for: Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->access$700()Ljava/lang/String;

    .line 957
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;->this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    # getter for: Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mMultipleAccountLogic:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;
    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->access$800(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;)Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;->invalidateCache()V

    .line 961
    new-instance v0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5$1;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5$1;-><init>(Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;)V

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->submitToBackgroundThread(Ljava/lang/Runnable;)V

    .line 984
    iget-object v0, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;->this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    # getter for: Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mContext:Landroid/content/Context;
    invoke-static {v0}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->access$100(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;)Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;->this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    # getter for: Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mMultipleAccountLogic:Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;
    invoke-static {v1}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->access$800(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;)Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;->this$0:Lcom/amazon/identity/auth/accounts/AccountManagerLogic;

    # getter for: Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->mMultipleAccountPlugin:Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;
    invoke-static {v2}, Lcom/amazon/identity/auth/accounts/AccountManagerLogic;->access$900(Lcom/amazon/identity/auth/accounts/AccountManagerLogic;)Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/identity/auth/accounts/AccountManagerLogic$5;->val$directedId:Ljava/lang/String;

    const/4 v4, 0x0

    invoke-static {v0, v1, v2, v3, v4}, Lcom/amazon/identity/auth/accounts/AccountStateBroadcasts;->sendAsynchronousAccountAddedNotification(Landroid/content/Context;Lcom/amazon/identity/auth/accounts/MultipleAccountsLogic;Lcom/amazon/identity/auth/accounts/MultipleAccountPlugin;Ljava/lang/String;Ljava/lang/String;)V

    .line 990
    return-void
.end method
