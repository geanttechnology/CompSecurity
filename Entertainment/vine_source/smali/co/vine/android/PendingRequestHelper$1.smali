.class Lco/vine/android/PendingRequestHelper$1;
.super Lco/vine/android/CaptchaRequestHelper;
.source "PendingRequestHelper.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/PendingRequestHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/PendingRequestHelper;


# direct methods
.method constructor <init>(Lco/vine/android/PendingRequestHelper;)V
    .locals 0

    .prologue
    .line 71
    iput-object p1, p0, Lco/vine/android/PendingRequestHelper$1;->this$0:Lco/vine/android/PendingRequestHelper;

    invoke-direct {p0}, Lco/vine/android/CaptchaRequestHelper;-><init>()V

    return-void
.end method


# virtual methods
.method protected handleFailedCaptchaRequest(Lco/vine/android/PendingCaptchaRequest;)V
    .locals 1
    .param p1, "pendingCaptchaRequest"    # Lco/vine/android/PendingCaptchaRequest;

    .prologue
    .line 79
    iget-object v0, p0, Lco/vine/android/PendingRequestHelper$1;->this$0:Lco/vine/android/PendingRequestHelper;

    invoke-virtual {v0, p1}, Lco/vine/android/PendingRequestHelper;->handleFailedCaptchaRequest(Lco/vine/android/PendingCaptchaRequest;)V

    .line 80
    return-void
.end method

.method protected handleRetryCaptchaRequest(Lco/vine/android/PendingCaptchaRequest;)V
    .locals 1
    .param p1, "pendingCaptchaRequest"    # Lco/vine/android/PendingCaptchaRequest;

    .prologue
    .line 74
    iget-object v0, p0, Lco/vine/android/PendingRequestHelper$1;->this$0:Lco/vine/android/PendingRequestHelper;

    invoke-virtual {v0, p1}, Lco/vine/android/PendingRequestHelper;->handleRetryCaptchaRequest(Lco/vine/android/PendingCaptchaRequest;)V

    .line 75
    return-void
.end method
