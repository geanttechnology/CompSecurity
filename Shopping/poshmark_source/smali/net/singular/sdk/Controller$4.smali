.class Lnet/singular/sdk/Controller$4;
.super Ljava/lang/Object;
.source "Controller.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lnet/singular/sdk/Controller;->onResume()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lnet/singular/sdk/Controller;


# direct methods
.method constructor <init>(Lnet/singular/sdk/Controller;)V
    .locals 0

    .prologue
    .line 241
    iput-object p1, p0, Lnet/singular/sdk/Controller$4;->this$0:Lnet/singular/sdk/Controller;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 245
    :try_start_0
    iget-object v1, p0, Lnet/singular/sdk/Controller$4;->this$0:Lnet/singular/sdk/Controller;

    # getter for: Lnet/singular/sdk/Controller;->sessionManager:Lnet/singular/sdk/SessionManager;
    invoke-static {v1}, Lnet/singular/sdk/Controller;->access$400(Lnet/singular/sdk/Controller;)Lnet/singular/sdk/SessionManager;

    move-result-object v1

    invoke-virtual {v1}, Lnet/singular/sdk/SessionManager;->onResume()V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 249
    :goto_0
    return-void

    .line 246
    :catch_0
    move-exception v0

    .line 247
    .local v0, "e":Ljava/lang/RuntimeException;
    iget-object v1, p0, Lnet/singular/sdk/Controller$4;->this$0:Lnet/singular/sdk/Controller;

    const-string v2, "onResume runnable"

    # invokes: Lnet/singular/sdk/Controller;->logAndReportException(Ljava/lang/Exception;Ljava/lang/String;)V
    invoke-static {v1, v0, v2}, Lnet/singular/sdk/Controller;->access$100(Lnet/singular/sdk/Controller;Ljava/lang/Exception;Ljava/lang/String;)V

    goto :goto_0
.end method
