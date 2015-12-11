.class Lio/branch/referral/PrefHelper$4;
.super Ljava/lang/Object;
.source "PrefHelper.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/branch/referral/PrefHelper;->keepDebugConnection()Z
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
    .line 1189
    iput-object p1, p0, Lio/branch/referral/PrefHelper$4;->this$0:Lio/branch/referral/PrefHelper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 1192
    iget-object v0, p0, Lio/branch/referral/PrefHelper$4;->this$0:Lio/branch/referral/PrefHelper;

    # getter for: Lio/branch/referral/PrefHelper;->remoteInterface_:Lio/branch/referral/BranchRemoteInterface;
    invoke-static {v0}, Lio/branch/referral/PrefHelper;->access$000(Lio/branch/referral/PrefHelper;)Lio/branch/referral/BranchRemoteInterface;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Lio/branch/referral/BranchRemoteInterface;->sendLog(Ljava/lang/String;)V

    .line 1193
    return-void
.end method
