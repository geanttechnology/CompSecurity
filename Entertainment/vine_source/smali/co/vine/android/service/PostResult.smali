.class public Lco/vine/android/service/PostResult;
.super Ljava/lang/Object;
.source "PostResult.java"


# instance fields
.field public captchaUrl:Ljava/lang/String;

.field public shouldRefreshSessionKey:Z

.field public success:Z


# direct methods
.method public constructor <init>(Z)V
    .locals 0
    .param p1, "success"    # Z

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 9
    iput-boolean p1, p0, Lco/vine/android/service/PostResult;->success:Z

    .line 10
    return-void
.end method

.method public constructor <init>(ZZLjava/lang/String;)V
    .locals 0
    .param p1, "success"    # Z
    .param p2, "shouldRefreshSessionKey"    # Z
    .param p3, "captchaUrl"    # Ljava/lang/String;

    .prologue
    .line 12
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput-boolean p1, p0, Lco/vine/android/service/PostResult;->success:Z

    .line 14
    iput-object p3, p0, Lco/vine/android/service/PostResult;->captchaUrl:Ljava/lang/String;

    .line 15
    iput-boolean p2, p0, Lco/vine/android/service/PostResult;->shouldRefreshSessionKey:Z

    .line 16
    return-void
.end method
