.class Lcom/amazon/identity/auth/device/token/TokenManagementLogic$3;
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

.field final synthetic val$directedId:Ljava/lang/String;

.field final synthetic val$keyInfo:Lcom/amazon/identity/auth/device/utils/KeyInfo;

.field final synthetic val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;Ljava/lang/String;Lcom/amazon/identity/auth/device/utils/KeyInfo;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 0

    .prologue
    .line 323
    iput-object p1, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$3;->this$0:Lcom/amazon/identity/auth/device/token/TokenManagementLogic;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$3;->val$directedId:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$3;->val$keyInfo:Lcom/amazon/identity/auth/device/utils/KeyInfo;

    iput-object p4, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$3;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 328
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$3;->this$0:Lcom/amazon/identity/auth/device/token/TokenManagementLogic;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$3;->val$directedId:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$3;->val$keyInfo:Lcom/amazon/identity/auth/device/utils/KeyInfo;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/utils/KeyInfo;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/identity/auth/device/api/TokenKeys;->getAccessTokenKeyForPackage(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    iget-object v4, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$3;->this$0:Lcom/amazon/identity/auth/device/token/TokenManagementLogic;

    invoke-static {v4}, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->access$1000(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;)Lcom/amazon/identity/auth/device/api/Callback;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$3;->val$tracer:Lcom/amazon/identity/auth/device/framework/Tracer;

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->getToken(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    .line 333
    return-void
.end method
