.class Lio/branch/referral/Branch$BranchWindowCallback$1;
.super Ljava/lang/Object;
.source "Branch.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/branch/referral/Branch$BranchWindowCallback;-><init>(Lio/branch/referral/Branch;Landroid/view/Window$Callback;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lio/branch/referral/Branch$BranchWindowCallback;

.field private timer:Ljava/util/Timer;

.field final synthetic val$this$0:Lio/branch/referral/Branch;


# direct methods
.method constructor <init>(Lio/branch/referral/Branch$BranchWindowCallback;Lio/branch/referral/Branch;)V
    .locals 0

    .prologue
    .line 3530
    iput-object p1, p0, Lio/branch/referral/Branch$BranchWindowCallback$1;->this$1:Lio/branch/referral/Branch$BranchWindowCallback;

    iput-object p2, p0, Lio/branch/referral/Branch$BranchWindowCallback$1;->val$this$0:Lio/branch/referral/Branch;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 3534
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback$1;->this$1:Lio/branch/referral/Branch$BranchWindowCallback;

    iget-object v0, v0, Lio/branch/referral/Branch$BranchWindowCallback;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->debugHandler_:Landroid/os/Handler;
    invoke-static {v0}, Lio/branch/referral/Branch;->access$200(Lio/branch/referral/Branch;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lio/branch/referral/Branch$BranchWindowCallback$1;->this$1:Lio/branch/referral/Branch$BranchWindowCallback;

    # getter for: Lio/branch/referral/Branch$BranchWindowCallback;->longPressed_:Ljava/lang/Runnable;
    invoke-static {v1}, Lio/branch/referral/Branch$BranchWindowCallback;->access$2700(Lio/branch/referral/Branch$BranchWindowCallback;)Ljava/lang/Runnable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 3535
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback$1;->this$1:Lio/branch/referral/Branch$BranchWindowCallback;

    iget-object v0, v0, Lio/branch/referral/Branch$BranchWindowCallback;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->debugStarted_:Z
    invoke-static {v0}, Lio/branch/referral/Branch;->access$2800(Lio/branch/referral/Branch;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 3536
    const-string v0, "Branch Debug"

    const-string v1, "======= Start Debug Session ======="

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 3537
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback$1;->this$1:Lio/branch/referral/Branch$BranchWindowCallback;

    iget-object v0, v0, Lio/branch/referral/Branch$BranchWindowCallback;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;
    invoke-static {v0}, Lio/branch/referral/Branch;->access$100(Lio/branch/referral/Branch;)Lio/branch/referral/PrefHelper;

    move-result-object v0

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->setDebug()V

    .line 3538
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback$1;->timer:Ljava/util/Timer;

    .line 3539
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback$1;->timer:Ljava/util/Timer;

    new-instance v1, Lio/branch/referral/Branch$BranchWindowCallback$KeepDebugConnectionTask;

    iget-object v2, p0, Lio/branch/referral/Branch$BranchWindowCallback$1;->this$1:Lio/branch/referral/Branch$BranchWindowCallback;

    invoke-direct {v1, v2}, Lio/branch/referral/Branch$BranchWindowCallback$KeepDebugConnectionTask;-><init>(Lio/branch/referral/Branch$BranchWindowCallback;)V

    new-instance v2, Ljava/util/Date;

    invoke-direct {v2}, Ljava/util/Date;-><init>()V

    const-wide/16 v4, 0x4e20

    invoke-virtual {v0, v1, v2, v4, v5}, Ljava/util/Timer;->scheduleAtFixedRate(Ljava/util/TimerTask;Ljava/util/Date;J)V

    .line 3548
    :cond_0
    :goto_0
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback$1;->this$1:Lio/branch/referral/Branch$BranchWindowCallback;

    iget-object v1, v0, Lio/branch/referral/Branch$BranchWindowCallback;->this$0:Lio/branch/referral/Branch;

    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback$1;->this$1:Lio/branch/referral/Branch$BranchWindowCallback;

    iget-object v0, v0, Lio/branch/referral/Branch$BranchWindowCallback;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->debugStarted_:Z
    invoke-static {v0}, Lio/branch/referral/Branch;->access$2800(Lio/branch/referral/Branch;)Z

    move-result v0

    if-nez v0, :cond_2

    const/4 v0, 0x1

    :goto_1
    # setter for: Lio/branch/referral/Branch;->debugStarted_:Z
    invoke-static {v1, v0}, Lio/branch/referral/Branch;->access$2802(Lio/branch/referral/Branch;Z)Z

    .line 3549
    return-void

    .line 3541
    :cond_1
    const-string v0, "Branch Debug"

    const-string v1, "======= End Debug Session ======="

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 3542
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback$1;->this$1:Lio/branch/referral/Branch$BranchWindowCallback;

    iget-object v0, v0, Lio/branch/referral/Branch$BranchWindowCallback;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;
    invoke-static {v0}, Lio/branch/referral/Branch;->access$100(Lio/branch/referral/Branch;)Lio/branch/referral/PrefHelper;

    move-result-object v0

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->clearDebug()V

    .line 3543
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback$1;->timer:Ljava/util/Timer;

    if-eqz v0, :cond_0

    .line 3544
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback$1;->timer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 3545
    const/4 v0, 0x0

    iput-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback$1;->timer:Ljava/util/Timer;

    goto :goto_0

    .line 3548
    :cond_2
    const/4 v0, 0x0

    goto :goto_1
.end method
