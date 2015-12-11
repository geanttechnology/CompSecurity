.class Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;
.super Ljava/lang/Object;
.source "TokenManagementLogic.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/token/TokenManagementLogic;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/token/TokenManagementLogic;

.field final synthetic val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

.field final synthetic val$directedId:Ljava/lang/String;

.field final synthetic val$options:Landroid/os/Bundle;

.field final synthetic val$token:Ljava/lang/String;

.field final synthetic val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/callback/CallbackFuture;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 0

    .prologue
    .line 142
    iput-object p1, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->this$0:Lcom/amazon/identity/auth/device/token/TokenManagementLogic;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->val$token:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->val$options:Landroid/os/Bundle;

    iput-object p4, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    iput-object p5, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->val$directedId:Ljava/lang/String;

    iput-object p6, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    .line 147
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->val$token:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->parseKey(Ljava/lang/String;)Lcom/amazon/identity/auth/device/utils/KeyInfo;

    move-result-object v2

    .line 149
    .local v2, "keyInfo":Lcom/amazon/identity/auth/device/utils/KeyInfo;
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->this$0:Lcom/amazon/identity/auth/device/token/TokenManagementLogic;

    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->access$000(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;Lcom/amazon/identity/auth/device/utils/KeyInfo;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 151
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->this$0:Lcom/amazon/identity/auth/device/token/TokenManagementLogic;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->val$options:Landroid/os/Bundle;

    invoke-static {v0, v2, v1}, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->access$100(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;Lcom/amazon/identity/auth/device/utils/KeyInfo;Landroid/os/Bundle;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 153
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    const/4 v1, 0x7

    const-string/jumbo v3, "Cannot get central DMS Credentials. Please use %s or %s ."

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    const-class v6, Lcom/amazon/identity/auth/device/api/AuthenticatedURLConnection;

    invoke-virtual {v6}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    const-class v6, Lcom/amazon/identity/auth/device/api/AuthenticationAwareHttpClient;

    invoke-virtual {v6}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v1, v3}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->onAccountManagerError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V

    .line 176
    :goto_0
    return-void

    .line 161
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->this$0:Lcom/amazon/identity/auth/device/token/TokenManagementLogic;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->val$directedId:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->access$200(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    .line 162
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->this$0:Lcom/amazon/identity/auth/device/token/TokenManagementLogic;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->val$directedId:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->access$300(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Lcom/amazon/identity/auth/device/api/Callback;)V

    goto :goto_0

    .line 164
    :cond_1
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->this$0:Lcom/amazon/identity/auth/device/token/TokenManagementLogic;

    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->access$400(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;Lcom/amazon/identity/auth/device/utils/KeyInfo;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 166
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->this$0:Lcom/amazon/identity/auth/device/token/TokenManagementLogic;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->val$directedId:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->val$options:Landroid/os/Bundle;

    iget-object v4, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    iget-object v5, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-static/range {v0 .. v5}, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->access$500(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V

    goto :goto_0

    .line 168
    :cond_2
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->this$0:Lcom/amazon/identity/auth/device/token/TokenManagementLogic;

    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->access$600(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;Lcom/amazon/identity/auth/device/utils/KeyInfo;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 170
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->this$0:Lcom/amazon/identity/auth/device/token/TokenManagementLogic;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->val$directedId:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->access$700(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Lcom/amazon/identity/auth/device/api/Callback;)V

    goto :goto_0

    .line 174
    :cond_3
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->this$0:Lcom/amazon/identity/auth/device/token/TokenManagementLogic;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->val$directedId:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->val$token:Ljava/lang/String;

    iget-object v4, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$1;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-static {v0, v1, v3, v4, v2}, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->access$800(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/callback/CallbackFuture;Lcom/amazon/identity/auth/device/utils/KeyInfo;)V

    goto :goto_0
.end method
