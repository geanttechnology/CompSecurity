.class Lio/branch/referral/Branch$1$KeepDebugConnectionTask;
.super Ljava/util/TimerTask;
.source "Branch.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/branch/referral/Branch$1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "KeepDebugConnectionTask"
.end annotation


# instance fields
.field final synthetic this$1:Lio/branch/referral/Branch$1;


# direct methods
.method constructor <init>(Lio/branch/referral/Branch$1;)V
    .locals 0

    .prologue
    .line 1141
    iput-object p1, p0, Lio/branch/referral/Branch$1$KeepDebugConnectionTask;->this$1:Lio/branch/referral/Branch$1;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 1143
    iget-object v0, p0, Lio/branch/referral/Branch$1$KeepDebugConnectionTask;->this$1:Lio/branch/referral/Branch$1;

    iget-object v0, v0, Lio/branch/referral/Branch$1;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;
    invoke-static {v0}, Lio/branch/referral/Branch;->access$100(Lio/branch/referral/Branch;)Lio/branch/referral/PrefHelper;

    move-result-object v0

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->keepDebugConnection()Z

    move-result v0

    if-nez v0, :cond_0

    .line 1144
    iget-object v0, p0, Lio/branch/referral/Branch$1$KeepDebugConnectionTask;->this$1:Lio/branch/referral/Branch$1;

    iget-object v0, v0, Lio/branch/referral/Branch$1;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->debugHandler_:Landroid/os/Handler;
    invoke-static {v0}, Lio/branch/referral/Branch;->access$200(Lio/branch/referral/Branch;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lio/branch/referral/Branch$1$KeepDebugConnectionTask;->this$1:Lio/branch/referral/Branch$1;

    iget-object v1, v1, Lio/branch/referral/Branch$1;->_longPressed:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 1146
    :cond_0
    return-void
.end method
