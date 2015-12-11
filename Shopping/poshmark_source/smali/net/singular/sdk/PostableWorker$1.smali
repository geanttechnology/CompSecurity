.class Lnet/singular/sdk/PostableWorker$1;
.super Ljava/lang/Object;
.source "PostableWorker.java"

# interfaces
.implements Ljava/lang/Thread$UncaughtExceptionHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lnet/singular/sdk/PostableWorker;-><init>(Ljava/lang/String;Lnet/singular/sdk/SingularLog;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lnet/singular/sdk/PostableWorker;

.field final synthetic val$log:Lnet/singular/sdk/SingularLog;

.field final synthetic val$name:Ljava/lang/String;


# direct methods
.method constructor <init>(Lnet/singular/sdk/PostableWorker;Lnet/singular/sdk/SingularLog;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 18
    iput-object p1, p0, Lnet/singular/sdk/PostableWorker$1;->this$0:Lnet/singular/sdk/PostableWorker;

    iput-object p2, p0, Lnet/singular/sdk/PostableWorker$1;->val$log:Lnet/singular/sdk/SingularLog;

    iput-object p3, p0, Lnet/singular/sdk/PostableWorker$1;->val$name:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public uncaughtException(Ljava/lang/Thread;Ljava/lang/Throwable;)V
    .locals 6
    .param p1, "thread"    # Ljava/lang/Thread;
    .param p2, "ex"    # Ljava/lang/Throwable;

    .prologue
    const/4 v3, 0x1

    const/4 v5, 0x0

    .line 21
    iget-object v0, p0, Lnet/singular/sdk/PostableWorker$1;->val$log:Lnet/singular/sdk/SingularLog;

    if-eqz v0, :cond_0

    .line 22
    iget-object v0, p0, Lnet/singular/sdk/PostableWorker$1;->val$log:Lnet/singular/sdk/SingularLog;

    const-string v1, "singular_sdk"

    const-string v2, "%s background thread had died."

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p0, Lnet/singular/sdk/PostableWorker$1;->val$name:Ljava/lang/String;

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2, p2}, Lnet/singular/sdk/SingularLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 27
    :goto_0
    return-void

    .line 24
    :cond_0
    const-string v0, "singular_sdk"

    const-string v1, "%s background thread had died."

    new-array v2, v3, [Ljava/lang/Object;

    iget-object v3, p0, Lnet/singular/sdk/PostableWorker$1;->val$name:Ljava/lang/String;

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, p2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method
