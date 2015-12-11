.class Lio/branch/referral/Branch$4;
.super Ljava/util/TimerTask;
.source "Branch.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/branch/referral/Branch;->keepAlive()V
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
    .line 2908
    iput-object p1, p0, Lio/branch/referral/Branch$4;->this$0:Lio/branch/referral/Branch;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 2911
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lio/branch/referral/Branch$4$1;

    invoke-direct {v1, p0}, Lio/branch/referral/Branch$4$1;-><init>(Lio/branch/referral/Branch$4;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 2917
    return-void
.end method
