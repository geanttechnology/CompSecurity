.class Lio/branch/referral/Branch$BranchWindowCallback$KeepDebugConnectionTask;
.super Ljava/util/TimerTask;
.source "Branch.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/branch/referral/Branch$BranchWindowCallback;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "KeepDebugConnectionTask"
.end annotation


# instance fields
.field final synthetic this$1:Lio/branch/referral/Branch$BranchWindowCallback;


# direct methods
.method constructor <init>(Lio/branch/referral/Branch$BranchWindowCallback;)V
    .locals 0

    .prologue
    .line 3554
    iput-object p1, p0, Lio/branch/referral/Branch$BranchWindowCallback$KeepDebugConnectionTask;->this$1:Lio/branch/referral/Branch$BranchWindowCallback;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 3556
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback$KeepDebugConnectionTask;->this$1:Lio/branch/referral/Branch$BranchWindowCallback;

    iget-object v0, v0, Lio/branch/referral/Branch$BranchWindowCallback;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->debugStarted_:Z
    invoke-static {v0}, Lio/branch/referral/Branch;->access$2800(Lio/branch/referral/Branch;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback$KeepDebugConnectionTask;->this$1:Lio/branch/referral/Branch$BranchWindowCallback;

    iget-object v0, v0, Lio/branch/referral/Branch$BranchWindowCallback;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;
    invoke-static {v0}, Lio/branch/referral/Branch;->access$100(Lio/branch/referral/Branch;)Lio/branch/referral/PrefHelper;

    move-result-object v0

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->keepDebugConnection()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback$KeepDebugConnectionTask;->this$1:Lio/branch/referral/Branch$BranchWindowCallback;

    # getter for: Lio/branch/referral/Branch$BranchWindowCallback;->longPressed_:Ljava/lang/Runnable;
    invoke-static {v0}, Lio/branch/referral/Branch$BranchWindowCallback;->access$2700(Lio/branch/referral/Branch$BranchWindowCallback;)Ljava/lang/Runnable;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 3557
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback$KeepDebugConnectionTask;->this$1:Lio/branch/referral/Branch$BranchWindowCallback;

    iget-object v0, v0, Lio/branch/referral/Branch$BranchWindowCallback;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->debugHandler_:Landroid/os/Handler;
    invoke-static {v0}, Lio/branch/referral/Branch;->access$200(Lio/branch/referral/Branch;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lio/branch/referral/Branch$BranchWindowCallback$KeepDebugConnectionTask;->this$1:Lio/branch/referral/Branch$BranchWindowCallback;

    # getter for: Lio/branch/referral/Branch$BranchWindowCallback;->longPressed_:Ljava/lang/Runnable;
    invoke-static {v1}, Lio/branch/referral/Branch$BranchWindowCallback;->access$2700(Lio/branch/referral/Branch$BranchWindowCallback;)Ljava/lang/Runnable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 3559
    :cond_0
    return-void
.end method
