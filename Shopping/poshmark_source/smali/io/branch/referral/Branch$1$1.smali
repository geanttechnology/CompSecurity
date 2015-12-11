.class Lio/branch/referral/Branch$1$1;
.super Ljava/lang/Object;
.source "Branch.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/branch/referral/Branch$1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private started:Z

.field final synthetic this$1:Lio/branch/referral/Branch$1;

.field private timer:Ljava/util/Timer;


# direct methods
.method constructor <init>(Lio/branch/referral/Branch$1;)V
    .locals 1

    .prologue
    .line 1149
    iput-object p1, p0, Lio/branch/referral/Branch$1$1;->this$1:Lio/branch/referral/Branch$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1150
    const/4 v0, 0x0

    iput-boolean v0, p0, Lio/branch/referral/Branch$1$1;->started:Z

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 1154
    iget-object v0, p0, Lio/branch/referral/Branch$1$1;->this$1:Lio/branch/referral/Branch$1;

    iget-object v0, v0, Lio/branch/referral/Branch$1;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->debugHandler_:Landroid/os/Handler;
    invoke-static {v0}, Lio/branch/referral/Branch;->access$200(Lio/branch/referral/Branch;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lio/branch/referral/Branch$1$1;->this$1:Lio/branch/referral/Branch$1;

    iget-object v1, v1, Lio/branch/referral/Branch$1;->_longPressed:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 1155
    iget-boolean v0, p0, Lio/branch/referral/Branch$1$1;->started:Z

    if-nez v0, :cond_0

    .line 1156
    const-string v0, "Branch Debug"

    const-string v1, "======= Start Debug Session ======="

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1157
    iget-object v0, p0, Lio/branch/referral/Branch$1$1;->this$1:Lio/branch/referral/Branch$1;

    iget-object v0, v0, Lio/branch/referral/Branch$1;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;
    invoke-static {v0}, Lio/branch/referral/Branch;->access$100(Lio/branch/referral/Branch;)Lio/branch/referral/PrefHelper;

    move-result-object v0

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->setDebug()V

    .line 1158
    new-instance v0, Ljava/util/Timer;

    invoke-direct {v0}, Ljava/util/Timer;-><init>()V

    iput-object v0, p0, Lio/branch/referral/Branch$1$1;->timer:Ljava/util/Timer;

    .line 1159
    iget-object v0, p0, Lio/branch/referral/Branch$1$1;->timer:Ljava/util/Timer;

    new-instance v1, Lio/branch/referral/Branch$1$KeepDebugConnectionTask;

    iget-object v2, p0, Lio/branch/referral/Branch$1$1;->this$1:Lio/branch/referral/Branch$1;

    invoke-direct {v1, v2}, Lio/branch/referral/Branch$1$KeepDebugConnectionTask;-><init>(Lio/branch/referral/Branch$1;)V

    new-instance v2, Ljava/util/Date;

    invoke-direct {v2}, Ljava/util/Date;-><init>()V

    const-wide/16 v4, 0x4e20

    invoke-virtual {v0, v1, v2, v4, v5}, Ljava/util/Timer;->scheduleAtFixedRate(Ljava/util/TimerTask;Ljava/util/Date;J)V

    .line 1166
    :goto_0
    iget-boolean v0, p0, Lio/branch/referral/Branch$1$1;->started:Z

    if-nez v0, :cond_1

    const/4 v0, 0x1

    :goto_1
    iput-boolean v0, p0, Lio/branch/referral/Branch$1$1;->started:Z

    .line 1167
    return-void

    .line 1161
    :cond_0
    const-string v0, "Branch Debug"

    const-string v1, "======= End Debug Session ======="

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 1162
    iget-object v0, p0, Lio/branch/referral/Branch$1$1;->this$1:Lio/branch/referral/Branch$1;

    iget-object v0, v0, Lio/branch/referral/Branch$1;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->prefHelper_:Lio/branch/referral/PrefHelper;
    invoke-static {v0}, Lio/branch/referral/Branch;->access$100(Lio/branch/referral/Branch;)Lio/branch/referral/PrefHelper;

    move-result-object v0

    invoke-virtual {v0}, Lio/branch/referral/PrefHelper;->clearDebug()V

    .line 1163
    iget-object v0, p0, Lio/branch/referral/Branch$1$1;->timer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 1164
    const/4 v0, 0x0

    iput-object v0, p0, Lio/branch/referral/Branch$1$1;->timer:Ljava/util/Timer;

    goto :goto_0

    .line 1166
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method
