.class Lio/branch/referral/Branch$4$1;
.super Ljava/lang/Object;
.source "Branch.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/branch/referral/Branch$4;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lio/branch/referral/Branch$4;


# direct methods
.method constructor <init>(Lio/branch/referral/Branch$4;)V
    .locals 0

    .prologue
    .line 2911
    iput-object p1, p0, Lio/branch/referral/Branch$4$1;->this$1:Lio/branch/referral/Branch$4;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 2914
    iget-object v0, p0, Lio/branch/referral/Branch$4$1;->this$1:Lio/branch/referral/Branch$4;

    iget-object v0, v0, Lio/branch/referral/Branch$4;->this$0:Lio/branch/referral/Branch;

    const/4 v1, 0x0

    # setter for: Lio/branch/referral/Branch;->keepAlive_:Z
    invoke-static {v0, v1}, Lio/branch/referral/Branch;->access$902(Lio/branch/referral/Branch;Z)Z

    .line 2915
    return-void
.end method
