.class Lio/branch/referral/Branch$3;
.super Ljava/lang/Object;
.source "Branch.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/branch/referral/Branch;->scheduleListOfApps()V
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
    .line 2791
    iput-object p1, p0, Lio/branch/referral/Branch$3;->this$0:Lio/branch/referral/Branch;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 2794
    new-instance v0, Lio/branch/referral/ServerRequestSendAppList;

    iget-object v1, p0, Lio/branch/referral/Branch$3;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->context_:Landroid/content/Context;
    invoke-static {v1}, Lio/branch/referral/Branch;->access$700(Lio/branch/referral/Branch;)Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lio/branch/referral/ServerRequestSendAppList;-><init>(Landroid/content/Context;)V

    .line 2795
    .local v0, "req":Lio/branch/referral/ServerRequest;
    iget-boolean v1, v0, Lio/branch/referral/ServerRequest;->constructError_:Z

    if-nez v1, :cond_0

    iget-object v1, p0, Lio/branch/referral/Branch$3;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->context_:Landroid/content/Context;
    invoke-static {v1}, Lio/branch/referral/Branch;->access$700(Lio/branch/referral/Branch;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v0, v1}, Lio/branch/referral/ServerRequest;->handleErrors(Landroid/content/Context;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 2796
    iget-object v1, p0, Lio/branch/referral/Branch$3;->this$0:Lio/branch/referral/Branch;

    # invokes: Lio/branch/referral/Branch;->handleNewRequest(Lio/branch/referral/ServerRequest;)V
    invoke-static {v1, v0}, Lio/branch/referral/Branch;->access$800(Lio/branch/referral/Branch;Lio/branch/referral/ServerRequest;)V

    .line 2798
    :cond_0
    return-void
.end method
