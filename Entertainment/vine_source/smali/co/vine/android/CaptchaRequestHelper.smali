.class public abstract Lco/vine/android/CaptchaRequestHelper;
.super Ljava/lang/Object;
.source "CaptchaRequestHelper.java"


# static fields
.field public static final REQUEST_CODE_CAPTCHA:I = 0xb

.field protected static final STATE_PENDING_CAPTCHA_REQUEST:Ljava/lang/String; = "state_pending_captcha_request"


# instance fields
.field protected mPendingCaptchaRequest:Lco/vine/android/PendingCaptchaRequest;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method protected abstract handleFailedCaptchaRequest(Lco/vine/android/PendingCaptchaRequest;)V
.end method

.method public handlePendingCaptchaRequest()V
    .locals 2

    .prologue
    .line 62
    iget-object v0, p0, Lco/vine/android/CaptchaRequestHelper;->mPendingCaptchaRequest:Lco/vine/android/PendingCaptchaRequest;

    if-eqz v0, :cond_1

    .line 63
    iget-object v0, p0, Lco/vine/android/CaptchaRequestHelper;->mPendingCaptchaRequest:Lco/vine/android/PendingCaptchaRequest;

    iget v0, v0, Lco/vine/android/PendingCaptchaRequest;->state:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_2

    .line 64
    iget-object v0, p0, Lco/vine/android/CaptchaRequestHelper;->mPendingCaptchaRequest:Lco/vine/android/PendingCaptchaRequest;

    invoke-virtual {p0, v0}, Lco/vine/android/CaptchaRequestHelper;->handleFailedCaptchaRequest(Lco/vine/android/PendingCaptchaRequest;)V

    .line 68
    :cond_0
    :goto_0
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/CaptchaRequestHelper;->mPendingCaptchaRequest:Lco/vine/android/PendingCaptchaRequest;

    .line 70
    :cond_1
    return-void

    .line 65
    :cond_2
    iget-object v0, p0, Lco/vine/android/CaptchaRequestHelper;->mPendingCaptchaRequest:Lco/vine/android/PendingCaptchaRequest;

    iget v0, v0, Lco/vine/android/PendingCaptchaRequest;->state:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    .line 66
    iget-object v0, p0, Lco/vine/android/CaptchaRequestHelper;->mPendingCaptchaRequest:Lco/vine/android/PendingCaptchaRequest;

    invoke-virtual {p0, v0}, Lco/vine/android/CaptchaRequestHelper;->handleRetryCaptchaRequest(Lco/vine/android/PendingCaptchaRequest;)V

    goto :goto_0
.end method

.method protected abstract handleRetryCaptchaRequest(Lco/vine/android/PendingCaptchaRequest;)V
.end method

.method public onActivityResult(IILandroid/content/Intent;)Z
    .locals 3
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    const/4 v2, 0x2

    .line 41
    packed-switch p1, :pswitch_data_0

    .line 58
    const/4 v1, 0x0

    :goto_0
    return v1

    .line 43
    :pswitch_0
    iget-object v1, p0, Lco/vine/android/CaptchaRequestHelper;->mPendingCaptchaRequest:Lco/vine/android/PendingCaptchaRequest;

    if-eqz v1, :cond_0

    if-eqz p3, :cond_0

    .line 44
    const-string v1, "rid"

    invoke-virtual {p3, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 45
    .local v0, "reqId":Ljava/lang/String;
    const/4 v1, -0x1

    if-ne p2, v1, :cond_1

    iget-object v1, p0, Lco/vine/android/CaptchaRequestHelper;->mPendingCaptchaRequest:Lco/vine/android/PendingCaptchaRequest;

    iget-object v1, v1, Lco/vine/android/PendingCaptchaRequest;->reqId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 47
    iget-object v1, p0, Lco/vine/android/CaptchaRequestHelper;->mPendingCaptchaRequest:Lco/vine/android/PendingCaptchaRequest;

    iput v2, v1, Lco/vine/android/PendingCaptchaRequest;->state:I

    .line 55
    .end local v0    # "reqId":Ljava/lang/String;
    :cond_0
    :goto_1
    const/4 v1, 0x1

    goto :goto_0

    .line 49
    .restart local v0    # "reqId":Ljava/lang/String;
    :cond_1
    if-ne p2, v2, :cond_0

    iget-object v1, p0, Lco/vine/android/CaptchaRequestHelper;->mPendingCaptchaRequest:Lco/vine/android/PendingCaptchaRequest;

    iget-object v1, v1, Lco/vine/android/PendingCaptchaRequest;->reqId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 51
    iget-object v1, p0, Lco/vine/android/CaptchaRequestHelper;->mPendingCaptchaRequest:Lco/vine/android/PendingCaptchaRequest;

    const/4 v2, 0x3

    iput v2, v1, Lco/vine/android/PendingCaptchaRequest;->state:I

    goto :goto_1

    .line 41
    nop

    :pswitch_data_0
    .packed-switch 0xb
        :pswitch_0
    .end packed-switch
.end method

.method public onCaptchaRequired(Landroid/app/Activity;Ljava/lang/String;ILandroid/os/Bundle;Ljava/lang/String;)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "reqId"    # Ljava/lang/String;
    .param p3, "actionCode"    # I
    .param p4, "bundle"    # Landroid/os/Bundle;
    .param p5, "captchaUrl"    # Ljava/lang/String;

    .prologue
    .line 30
    new-instance v1, Lco/vine/android/PendingCaptchaRequest;

    invoke-direct {v1, p2, p3, p4}, Lco/vine/android/PendingCaptchaRequest;-><init>(Ljava/lang/String;ILandroid/os/Bundle;)V

    invoke-virtual {p0, v1}, Lco/vine/android/CaptchaRequestHelper;->setPendingCaptchaRequest(Lco/vine/android/PendingCaptchaRequest;)V

    .line 31
    if-eqz p1, :cond_0

    .line 32
    invoke-static {p1, p5, p2}, Lco/vine/android/CaptchaActivity;->getIntent(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 33
    .local v0, "i":Landroid/content/Intent;
    const/16 v1, 0xb

    invoke-virtual {p1, v0, v1}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 35
    .end local v0    # "i":Landroid/content/Intent;
    :cond_0
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 73
    const-string v0, "state_pending_captcha_request"

    iget-object v1, p0, Lco/vine/android/CaptchaRequestHelper;->mPendingCaptchaRequest:Lco/vine/android/PendingCaptchaRequest;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 74
    return-void
.end method

.method public restorePendingCaptchaRequest(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 26
    const-string v0, "state_pending_captcha_request"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lco/vine/android/PendingCaptchaRequest;

    iput-object v0, p0, Lco/vine/android/CaptchaRequestHelper;->mPendingCaptchaRequest:Lco/vine/android/PendingCaptchaRequest;

    .line 27
    return-void
.end method

.method public setPendingCaptchaRequest(Lco/vine/android/PendingCaptchaRequest;)V
    .locals 0
    .param p1, "pendingCaptchaRequest"    # Lco/vine/android/PendingCaptchaRequest;

    .prologue
    .line 22
    iput-object p1, p0, Lco/vine/android/CaptchaRequestHelper;->mPendingCaptchaRequest:Lco/vine/android/PendingCaptchaRequest;

    .line 23
    return-void
.end method
