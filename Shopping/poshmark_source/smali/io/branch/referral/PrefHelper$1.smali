.class Lio/branch/referral/PrefHelper$1;
.super Ljava/lang/Object;
.source "PrefHelper.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/branch/referral/PrefHelper;->setDebug()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lio/branch/referral/PrefHelper;


# direct methods
.method constructor <init>(Lio/branch/referral/PrefHelper;)V
    .locals 0

    .prologue
    .line 1088
    iput-object p1, p0, Lio/branch/referral/PrefHelper$1;->this$0:Lio/branch/referral/PrefHelper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 1091
    iget-object v0, p0, Lio/branch/referral/PrefHelper$1;->this$0:Lio/branch/referral/PrefHelper;

    # getter for: Lio/branch/referral/PrefHelper;->remoteInterface_:Lio/branch/referral/BranchRemoteInterface;
    invoke-static {v0}, Lio/branch/referral/PrefHelper;->access$000(Lio/branch/referral/PrefHelper;)Lio/branch/referral/BranchRemoteInterface;

    move-result-object v0

    if-nez v0, :cond_0

    .line 1092
    iget-object v0, p0, Lio/branch/referral/PrefHelper$1;->this$0:Lio/branch/referral/PrefHelper;

    new-instance v1, Lio/branch/referral/BranchRemoteInterface;

    iget-object v2, p0, Lio/branch/referral/PrefHelper$1;->this$0:Lio/branch/referral/PrefHelper;

    # getter for: Lio/branch/referral/PrefHelper;->context_:Landroid/content/Context;
    invoke-static {v2}, Lio/branch/referral/PrefHelper;->access$100(Lio/branch/referral/PrefHelper;)Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Lio/branch/referral/BranchRemoteInterface;-><init>(Landroid/content/Context;)V

    # setter for: Lio/branch/referral/PrefHelper;->remoteInterface_:Lio/branch/referral/BranchRemoteInterface;
    invoke-static {v0, v1}, Lio/branch/referral/PrefHelper;->access$002(Lio/branch/referral/PrefHelper;Lio/branch/referral/BranchRemoteInterface;)Lio/branch/referral/BranchRemoteInterface;

    .line 1093
    iget-object v0, p0, Lio/branch/referral/PrefHelper$1;->this$0:Lio/branch/referral/PrefHelper;

    # getter for: Lio/branch/referral/PrefHelper;->remoteInterface_:Lio/branch/referral/BranchRemoteInterface;
    invoke-static {v0}, Lio/branch/referral/PrefHelper;->access$000(Lio/branch/referral/PrefHelper;)Lio/branch/referral/BranchRemoteInterface;

    move-result-object v0

    new-instance v1, Lio/branch/referral/PrefHelper$DebugNetworkCallback;

    invoke-direct {v1}, Lio/branch/referral/PrefHelper$DebugNetworkCallback;-><init>()V

    invoke-virtual {v0, v1}, Lio/branch/referral/BranchRemoteInterface;->setNetworkCallbackListener(Lio/branch/referral/NetworkCallback;)V

    .line 1096
    :cond_0
    iget-object v0, p0, Lio/branch/referral/PrefHelper$1;->this$0:Lio/branch/referral/PrefHelper;

    # getter for: Lio/branch/referral/PrefHelper;->remoteInterface_:Lio/branch/referral/BranchRemoteInterface;
    invoke-static {v0}, Lio/branch/referral/PrefHelper;->access$000(Lio/branch/referral/PrefHelper;)Lio/branch/referral/BranchRemoteInterface;

    move-result-object v0

    invoke-virtual {v0}, Lio/branch/referral/BranchRemoteInterface;->connectToDebug()V

    .line 1097
    return-void
.end method
