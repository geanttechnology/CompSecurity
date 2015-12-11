.class Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod$1;
.super Ljava/lang/Object;
.source "InProcessAdpAuthenticationMethod.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->signCorpus([BLandroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;

.field final synthetic val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

.field final synthetic val$corpus:[B


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;[BLcom/amazon/identity/auth/device/callback/CallbackFuture;)V
    .locals 0

    .prologue
    .line 585
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod$1;->this$0:Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;

    iput-object p2, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod$1;->val$corpus:[B

    iput-object p3, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod$1;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "errorBundle"    # Landroid/os/Bundle;

    .prologue
    .line 612
    const-string/jumbo v0, "Unknown error during signCorpus execution."

    .line 613
    .local v0, "errorMessage":Ljava/lang/String;
    # getter for: Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->access$100()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 614
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod$1;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    const/4 v2, 0x5

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/ADPCorpusSigningCallbackHelpers;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    .line 617
    return-void
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 590
    const-string/jumbo v3, "value_key"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 591
    .local v1, "adpToken":Ljava/lang/String;
    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod$1;->this$0:Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;

    iget-object v4, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod$1;->val$corpus:[B

    # invokes: Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->signBufferAsBase64([B)Ljava/lang/String;
    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;->access$000(Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod;[B)Ljava/lang/String;

    move-result-object v0

    .line 592
    .local v0, "adpSignature":Ljava/lang/String;
    if-eqz v1, :cond_0

    if-nez v0, :cond_1

    .line 594
    :cond_0
    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod$1;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    const/4 v4, 0x2

    const-string/jumbo v5, "The account is not valid or no longer registered."

    invoke-static {v3, v4, v5}, Lcom/amazon/identity/auth/device/utils/ADPCorpusSigningCallbackHelpers;->callbackError(Lcom/amazon/identity/auth/device/callback/CallbackFuture;ILjava/lang/String;)V

    .line 607
    :goto_0
    return-void

    .line 600
    :cond_1
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 601
    .local v2, "response":Landroid/os/Bundle;
    const-string/jumbo v3, "adp_signature"

    invoke-virtual {v2, v3, v0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 603
    const-string/jumbo v3, "adp_token"

    invoke-virtual {v2, v3, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 606
    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/InProcessAdpAuthenticationMethod$1;->val$callbackFuture:Lcom/amazon/identity/auth/device/callback/CallbackFuture;

    invoke-virtual {v3, v2}, Lcom/amazon/identity/auth/device/callback/CallbackFuture;->onSuccess(Landroid/os/Bundle;)V

    goto :goto_0
.end method
