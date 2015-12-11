.class Lco/vine/android/ReshareFragment$1;
.super Lco/vine/android/CaptchaRequestHelper;
.source "ReshareFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/ReshareFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/ReshareFragment;


# direct methods
.method constructor <init>(Lco/vine/android/ReshareFragment;)V
    .locals 0

    .prologue
    .line 71
    iput-object p1, p0, Lco/vine/android/ReshareFragment$1;->this$0:Lco/vine/android/ReshareFragment;

    invoke-direct {p0}, Lco/vine/android/CaptchaRequestHelper;-><init>()V

    return-void
.end method


# virtual methods
.method protected handleFailedCaptchaRequest(Lco/vine/android/PendingCaptchaRequest;)V
    .locals 4
    .param p1, "pendingCaptchaRequest"    # Lco/vine/android/PendingCaptchaRequest;

    .prologue
    .line 81
    iget-object v1, p0, Lco/vine/android/ReshareFragment$1;->this$0:Lco/vine/android/ReshareFragment;

    iget-object v1, v1, Lco/vine/android/ReshareFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->generateReqIdForCanceledCaptcha()Ljava/lang/String;

    move-result-object v0

    .line 82
    .local v0, "newRequestToFail":Ljava/lang/String;
    iget-object v1, p0, Lco/vine/android/ReshareFragment$1;->this$0:Lco/vine/android/ReshareFragment;

    iget-object v1, v1, Lco/vine/android/ReshareFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v2, p0, Lco/vine/android/ReshareFragment$1;->mPendingCaptchaRequest:Lco/vine/android/PendingCaptchaRequest;

    iget v2, v2, Lco/vine/android/PendingCaptchaRequest;->actionCode:I

    iget-object v3, p0, Lco/vine/android/ReshareFragment$1;->mPendingCaptchaRequest:Lco/vine/android/PendingCaptchaRequest;

    iget-object v3, v3, Lco/vine/android/PendingCaptchaRequest;->bundle:Landroid/os/Bundle;

    invoke-virtual {v1, v0, v2, v3}, Lco/vine/android/client/AppController;->failRequest(Ljava/lang/String;ILandroid/os/Bundle;)V

    .line 84
    return-void
.end method

.method protected handleRetryCaptchaRequest(Lco/vine/android/PendingCaptchaRequest;)V
    .locals 3
    .param p1, "pendingCaptchaRequest"    # Lco/vine/android/PendingCaptchaRequest;

    .prologue
    .line 75
    iget-object v0, p0, Lco/vine/android/ReshareFragment$1;->this$0:Lco/vine/android/ReshareFragment;

    iget-object v0, v0, Lco/vine/android/ReshareFragment;->mAppController:Lco/vine/android/client/AppController;

    iget-object v1, p0, Lco/vine/android/ReshareFragment$1;->mPendingCaptchaRequest:Lco/vine/android/PendingCaptchaRequest;

    iget v1, v1, Lco/vine/android/PendingCaptchaRequest;->actionCode:I

    iget-object v2, p0, Lco/vine/android/ReshareFragment$1;->mPendingCaptchaRequest:Lco/vine/android/PendingCaptchaRequest;

    iget-object v2, v2, Lco/vine/android/PendingCaptchaRequest;->bundle:Landroid/os/Bundle;

    invoke-virtual {v0, v1, v2}, Lco/vine/android/client/AppController;->retryRequest(ILandroid/os/Bundle;)Ljava/lang/String;

    .line 77
    return-void
.end method
