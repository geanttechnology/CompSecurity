.class public abstract Lco/vine/android/PendingRequestHelper;
.super Ljava/lang/Object;
.source "PendingRequestHelper.java"


# static fields
.field public static final PROGRESS_FETCH_DATA:I = 0x3

.field public static final PROGRESS_FETCH_DATA_NEW_AUTO:I = 0x4

.field public static final PROGRESS_FETCH_NEWER:I = 0x2

.field public static final PROGRESS_FETCH_OLDER:I = 0x1

.field public static final PROGRESS_FIRST_USER:I = 0x6

.field public static final PROGRESS_LOAD_DATA:I = 0x5

.field public static final PROGRESS_LOAD_DATA_OLDER:I = 0x7

.field public static final PROGRESS_NONE:I = 0x0

.field private static final STATE_CURRENT_REQ_IDS:Ljava/lang/String; = "pending_reqs"


# instance fields
.field private mAppController:Lco/vine/android/client/AppController;

.field private final mCaptchaRequestHelper:Lco/vine/android/CaptchaRequestHelper;

.field private mPendingRequests:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/PendingRequest;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 71
    new-instance v0, Lco/vine/android/PendingRequestHelper$1;

    invoke-direct {v0, p0}, Lco/vine/android/PendingRequestHelper$1;-><init>(Lco/vine/android/PendingRequestHelper;)V

    iput-object v0, p0, Lco/vine/android/PendingRequestHelper;->mCaptchaRequestHelper:Lco/vine/android/CaptchaRequestHelper;

    return-void
.end method


# virtual methods
.method public addRequest(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "reqId"    # Ljava/lang/String;

    .prologue
    .line 122
    iget-object v0, p0, Lco/vine/android/PendingRequestHelper;->mPendingRequests:Ljava/util/ArrayList;

    new-instance v1, Lco/vine/android/PendingRequest;

    invoke-direct {v1, p1}, Lco/vine/android/PendingRequest;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 123
    return-object p1
.end method

.method public addRequest(Ljava/lang/String;I)Ljava/lang/String;
    .locals 2
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "fetchType"    # I

    .prologue
    .line 130
    iget-object v0, p0, Lco/vine/android/PendingRequestHelper;->mPendingRequests:Ljava/util/ArrayList;

    new-instance v1, Lco/vine/android/PendingRequest;

    invoke-direct {v1, p1, p2}, Lco/vine/android/PendingRequest;-><init>(Ljava/lang/String;I)V

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 131
    return-object p1
.end method

.method public handleFailedCaptchaRequest(Lco/vine/android/PendingCaptchaRequest;)V
    .locals 4
    .param p1, "pendingCaptchaRequest"    # Lco/vine/android/PendingCaptchaRequest;

    .prologue
    .line 183
    iget-object v1, p0, Lco/vine/android/PendingRequestHelper;->mAppController:Lco/vine/android/client/AppController;

    if-eqz v1, :cond_0

    .line 184
    iget-object v1, p0, Lco/vine/android/PendingRequestHelper;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->generateReqIdForCanceledCaptcha()Ljava/lang/String;

    move-result-object v0

    .line 185
    .local v0, "newRequestToFail":Ljava/lang/String;
    invoke-virtual {p0, v0}, Lco/vine/android/PendingRequestHelper;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    .line 186
    iget-object v1, p0, Lco/vine/android/PendingRequestHelper;->mAppController:Lco/vine/android/client/AppController;

    iget v2, p1, Lco/vine/android/PendingCaptchaRequest;->actionCode:I

    iget-object v3, p1, Lco/vine/android/PendingCaptchaRequest;->bundle:Landroid/os/Bundle;

    invoke-virtual {v1, v0, v2, v3}, Lco/vine/android/client/AppController;->failRequest(Ljava/lang/String;ILandroid/os/Bundle;)V

    .line 189
    .end local v0    # "newRequestToFail":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public handlePendingCaptchaRequest()V
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lco/vine/android/PendingRequestHelper;->mCaptchaRequestHelper:Lco/vine/android/CaptchaRequestHelper;

    invoke-virtual {v0}, Lco/vine/android/CaptchaRequestHelper;->handlePendingCaptchaRequest()V

    .line 57
    return-void
.end method

.method public handleRetryCaptchaRequest(Lco/vine/android/PendingCaptchaRequest;)V
    .locals 3
    .param p1, "pendingCaptchaRequest"    # Lco/vine/android/PendingCaptchaRequest;

    .prologue
    .line 176
    iget-object v0, p0, Lco/vine/android/PendingRequestHelper;->mAppController:Lco/vine/android/client/AppController;

    if-eqz v0, :cond_0

    .line 177
    iget-object v0, p0, Lco/vine/android/PendingRequestHelper;->mAppController:Lco/vine/android/client/AppController;

    iget v1, p1, Lco/vine/android/PendingCaptchaRequest;->actionCode:I

    iget-object v2, p1, Lco/vine/android/PendingCaptchaRequest;->bundle:Landroid/os/Bundle;

    invoke-virtual {v0, v1, v2}, Lco/vine/android/client/AppController;->retryRequest(ILandroid/os/Bundle;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/PendingRequestHelper;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    .line 180
    :cond_0
    return-void
.end method

.method public hasPendingRequest()Z
    .locals 1

    .prologue
    .line 154
    iget-object v0, p0, Lco/vine/android/PendingRequestHelper;->mPendingRequests:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasPendingRequest(I)Z
    .locals 3
    .param p1, "fetchType"    # I

    .prologue
    .line 165
    if-eqz p1, :cond_1

    .line 166
    iget-object v2, p0, Lco/vine/android/PendingRequestHelper;->mPendingRequests:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/PendingRequest;

    .line 167
    .local v1, "req":Lco/vine/android/PendingRequest;
    iget v2, v1, Lco/vine/android/PendingRequest;->fetchType:I

    if-ne v2, p1, :cond_0

    .line 168
    const/4 v2, 0x1

    .line 172
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "req":Lco/vine/android/PendingRequest;
    :goto_0
    return v2

    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public abstract hideProgress(I)V
.end method

.method public onActivityResult(IILandroid/content/Intent;)Z
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 60
    iget-object v0, p0, Lco/vine/android/PendingRequestHelper;->mCaptchaRequestHelper:Lco/vine/android/CaptchaRequestHelper;

    invoke-virtual {v0, p1, p2, p3}, Lco/vine/android/CaptchaRequestHelper;->onActivityResult(IILandroid/content/Intent;)Z

    move-result v0

    return v0
.end method

.method public onCaptchaRequired(Landroid/support/v4/app/FragmentActivity;Ljava/lang/String;ILandroid/os/Bundle;Ljava/lang/String;)V
    .locals 6
    .param p1, "activity"    # Landroid/support/v4/app/FragmentActivity;
    .param p2, "reqId"    # Ljava/lang/String;
    .param p3, "actionCode"    # I
    .param p4, "bundle"    # Landroid/os/Bundle;
    .param p5, "captchaUrl"    # Ljava/lang/String;

    .prologue
    .line 64
    iget-object v0, p0, Lco/vine/android/PendingRequestHelper;->mCaptchaRequestHelper:Lco/vine/android/CaptchaRequestHelper;

    move-object v1, p1

    move-object v2, p2

    move v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-virtual/range {v0 .. v5}, Lco/vine/android/CaptchaRequestHelper;->onCaptchaRequired(Landroid/app/Activity;Ljava/lang/String;ILandroid/os/Bundle;Ljava/lang/String;)V

    .line 65
    return-void
.end method

.method public onCreate(Lco/vine/android/client/AppController;Landroid/os/Bundle;)V
    .locals 2
    .param p1, "appController"    # Lco/vine/android/client/AppController;
    .param p2, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 84
    iput-object p1, p0, Lco/vine/android/PendingRequestHelper;->mAppController:Lco/vine/android/client/AppController;

    .line 85
    if-eqz p2, :cond_0

    .line 86
    const-string v0, "pending_reqs"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getParcelableArrayList(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/PendingRequestHelper;->mPendingRequests:Ljava/util/ArrayList;

    .line 88
    :cond_0
    iget-object v0, p0, Lco/vine/android/PendingRequestHelper;->mPendingRequests:Ljava/util/ArrayList;

    if-nez v0, :cond_1

    .line 89
    new-instance v0, Ljava/util/ArrayList;

    const/4 v1, 0x5

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lco/vine/android/PendingRequestHelper;->mPendingRequests:Ljava/util/ArrayList;

    .line 91
    :cond_1
    return-void
.end method

.method public onResume()V
    .locals 4

    .prologue
    .line 98
    iget-object v2, p0, Lco/vine/android/PendingRequestHelper;->mPendingRequests:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    add-int/lit8 v0, v2, -0x1

    .local v0, "i":I
    :goto_0
    if-ltz v0, :cond_1

    .line 99
    iget-object v2, p0, Lco/vine/android/PendingRequestHelper;->mPendingRequests:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/PendingRequest;

    .line 100
    .local v1, "req":Lco/vine/android/PendingRequest;
    iget-object v2, p0, Lco/vine/android/PendingRequestHelper;->mAppController:Lco/vine/android/client/AppController;

    iget-object v3, v1, Lco/vine/android/PendingRequest;->id:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lco/vine/android/client/AppController;->isPendingRequest(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 101
    iget v2, v1, Lco/vine/android/PendingRequest;->fetchType:I

    invoke-virtual {p0, v2}, Lco/vine/android/PendingRequestHelper;->showProgress(I)V

    .line 98
    :goto_1
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 103
    :cond_0
    iget v2, v1, Lco/vine/android/PendingRequest;->fetchType:I

    invoke-virtual {p0, v2}, Lco/vine/android/PendingRequestHelper;->hideProgress(I)V

    .line 104
    iget-object v2, p0, Lco/vine/android/PendingRequestHelper;->mPendingRequests:Ljava/util/ArrayList;

    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    goto :goto_1

    .line 107
    .end local v1    # "req":Lco/vine/android/PendingRequest;
    :cond_1
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 114
    const-string v0, "pending_reqs"

    iget-object v1, p0, Lco/vine/android/PendingRequestHelper;->mPendingRequests:Ljava/util/ArrayList;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelableArrayList(Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 115
    iget-object v0, p0, Lco/vine/android/PendingRequestHelper;->mCaptchaRequestHelper:Lco/vine/android/CaptchaRequestHelper;

    invoke-virtual {v0, p1}, Lco/vine/android/CaptchaRequestHelper;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 116
    return-void
.end method

.method public removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;
    .locals 5
    .param p1, "reqId"    # Ljava/lang/String;

    .prologue
    .line 139
    iget-object v2, p0, Lco/vine/android/PendingRequestHelper;->mPendingRequests:Ljava/util/ArrayList;

    .line 140
    .local v2, "reqs":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/PendingRequest;>;"
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v3

    .line 141
    .local v3, "size":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, v3, :cond_1

    .line 142
    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/PendingRequest;

    .line 143
    .local v1, "req":Lco/vine/android/PendingRequest;
    iget-object v4, v1, Lco/vine/android/PendingRequest;->id:Ljava/lang/String;

    invoke-virtual {v4, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 144
    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/PendingRequest;

    .line 147
    .end local v1    # "req":Lco/vine/android/PendingRequest;
    :goto_1
    return-object v4

    .line 141
    .restart local v1    # "req":Lco/vine/android/PendingRequest;
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 147
    .end local v1    # "req":Lco/vine/android/PendingRequest;
    :cond_1
    const/4 v4, 0x0

    goto :goto_1
.end method

.method public restorePendingCaptchaRequest(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 52
    iget-object v0, p0, Lco/vine/android/PendingRequestHelper;->mCaptchaRequestHelper:Lco/vine/android/CaptchaRequestHelper;

    invoke-virtual {v0, p1}, Lco/vine/android/CaptchaRequestHelper;->restorePendingCaptchaRequest(Landroid/os/Bundle;)V

    .line 53
    return-void
.end method

.method public abstract showProgress(I)V
.end method
