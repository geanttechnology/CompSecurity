.class Lcom/amazon/identity/auth/device/token/TokenManagementLogic$2;
.super Ljava/lang/Object;
.source "TokenManagementLogic.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->getCookies(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/token/TokenManagementLogic;

.field final synthetic val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

.field final synthetic val$directedId:Ljava/lang/String;

.field final synthetic val$domain:Ljava/lang/String;

.field final synthetic val$options:Landroid/os/Bundle;

.field final synthetic val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;Landroid/os/Bundle;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/callback/CallbackFuture;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 0

    .prologue
    .line 192
    iput-object p1, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$2;->this$0:Lcom/amazon/identity/auth/device/token/TokenManagementLogic;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$2;->val$options:Landroid/os/Bundle;

    iput-object p3, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$2;->val$directedId:Ljava/lang/String;

    iput-object p4, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$2;->val$domain:Ljava/lang/String;

    iput-object p5, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$2;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    iput-object p6, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$2;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 197
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$2;->val$options:Landroid/os/Bundle;

    if-nez v0, :cond_0

    .line 199
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$2;->this$0:Lcom/amazon/identity/auth/device/token/TokenManagementLogic;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$2;->val$directedId:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$2;->val$domain:Ljava/lang/String;

    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    iget-object v4, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$2;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    iget-object v5, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$2;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-static/range {v0 .. v5}, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->access$900(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 205
    :goto_0
    return-void

    .line 203
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$2;->this$0:Lcom/amazon/identity/auth/device/token/TokenManagementLogic;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$2;->val$directedId:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$2;->val$domain:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$2;->val$options:Landroid/os/Bundle;

    iget-object v4, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$2;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    iget-object v5, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$2;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-static/range {v0 .. v5}, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->access$900(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto :goto_0
.end method
