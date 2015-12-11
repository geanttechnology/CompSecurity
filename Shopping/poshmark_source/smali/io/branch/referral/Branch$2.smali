.class Lio/branch/referral/Branch$2;
.super Ljava/util/TimerTask;
.source "Branch.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/branch/referral/Branch;->closeSession()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lio/branch/referral/Branch;


# direct methods
.method constructor <init>(Lio/branch/referral/Branch;)V
    .locals 0

    .prologue
    .line 1230
    iput-object p1, p0, Lio/branch/referral/Branch$2;->this$0:Lio/branch/referral/Branch;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 1234
    iget-object v0, p0, Lio/branch/referral/Branch$2;->this$0:Lio/branch/referral/Branch;

    const/4 v1, 0x0

    # setter for: Lio/branch/referral/Branch;->currentActivity_:Landroid/app/Activity;
    invoke-static {v0, v1}, Lio/branch/referral/Branch;->access$402(Lio/branch/referral/Branch;Landroid/app/Activity;)Landroid/app/Activity;

    .line 1235
    iget-object v0, p0, Lio/branch/referral/Branch$2;->this$0:Lio/branch/referral/Branch;

    # invokes: Lio/branch/referral/Branch;->executeClose()V
    invoke-static {v0}, Lio/branch/referral/Branch;->access$500(Lio/branch/referral/Branch;)V

    .line 1236
    return-void
.end method
