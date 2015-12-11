.class final Lcom/a/b/bb;
.super Ljava/lang/Thread;
.source "SourceFile"


# direct methods
.method public constructor <init>(Ljava/lang/Runnable;)V
    .locals 0

    .prologue
    .line 260
    invoke-direct {p0, p1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 261
    return-void
.end method


# virtual methods
.method public final run()V
    .locals 1

    .prologue
    .line 264
    const/16 v0, 0xa

    invoke-static {v0}, Landroid/os/Process;->setThreadPriority(I)V

    .line 265
    invoke-super {p0}, Ljava/lang/Thread;->run()V

    .line 266
    return-void
.end method
