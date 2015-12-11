.class Lcom/amazon/identity/auth/device/token/TokenManagementLogic$4;
.super Ljava/lang/Object;
.source "TokenManagementLogic.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;


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


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/token/TokenManagementLogic;)V
    .locals 0

    .prologue
    .line 343
    iput-object p1, p0, Lcom/amazon/identity/auth/device/token/TokenManagementLogic$4;->this$0:Lcom/amazon/identity/auth/device/token/TokenManagementLogic;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 354
    # getter for: Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->access$1100()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Registration check failed. This does not mean the device deregistered, this can happen if the network call failed.  Also this will not ever be raised to an application calling one of our apis as this is a background task to check the serverside registration state."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 356
    return-void
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 348
    # getter for: Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/token/TokenManagementLogic;->access$1100()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Registration check succeeded."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 349
    return-void
.end method
