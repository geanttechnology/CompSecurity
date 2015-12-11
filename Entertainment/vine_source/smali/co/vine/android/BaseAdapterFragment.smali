.class public abstract Lco/vine/android/BaseAdapterFragment;
.super Lco/vine/android/BaseControllerFragment;
.source "BaseAdapterFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/BaseAdapterFragment$BasePendingRequestHelper;
    }
.end annotation


# static fields
.field protected static final PROGRESS_FETCH_DATA:I = 0x3

.field protected static final PROGRESS_FETCH_DATA_NEW_AUTO:I = 0x4

.field protected static final PROGRESS_FETCH_NEWER:I = 0x2

.field protected static final PROGRESS_FETCH_OLDER:I = 0x1


# instance fields
.field protected final mHandler:Landroid/os/Handler;

.field protected final mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

.field protected mProgressDialog:Landroid/app/ProgressDialog;

.field protected mRefreshing:Z


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 14
    invoke-direct {p0}, Lco/vine/android/BaseControllerFragment;-><init>()V

    .line 23
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lco/vine/android/BaseAdapterFragment;->mHandler:Landroid/os/Handler;

    .line 25
    invoke-virtual {p0}, Lco/vine/android/BaseAdapterFragment;->createPendingRequestHelper()Lco/vine/android/PendingRequestHelper;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/BaseAdapterFragment;->mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

    .line 27
    return-void
.end method


# virtual methods
.method protected addRequest(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "reqId"    # Ljava/lang/String;

    .prologue
    .line 75
    iget-object v0, p0, Lco/vine/android/BaseAdapterFragment;->mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

    invoke-virtual {v0, p1}, Lco/vine/android/PendingRequestHelper;->addRequest(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected addRequest(Ljava/lang/String;I)Ljava/lang/String;
    .locals 1
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "fetchType"    # I

    .prologue
    .line 82
    iget-object v0, p0, Lco/vine/android/BaseAdapterFragment;->mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

    invoke-virtual {v0, p1, p2}, Lco/vine/android/PendingRequestHelper;->addRequest(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected createPendingRequestHelper()Lco/vine/android/PendingRequestHelper;
    .locals 1

    .prologue
    .line 41
    new-instance v0, Lco/vine/android/BaseAdapterFragment$BasePendingRequestHelper;

    invoke-direct {v0, p0}, Lco/vine/android/BaseAdapterFragment$BasePendingRequestHelper;-><init>(Lco/vine/android/BaseAdapterFragment;)V

    return-object v0
.end method

.method protected dismissDialog()V
    .locals 1

    .prologue
    .line 98
    iget-object v0, p0, Lco/vine/android/BaseAdapterFragment;->mProgressDialog:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_0

    .line 99
    iget-object v0, p0, Lco/vine/android/BaseAdapterFragment;->mProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 100
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/BaseAdapterFragment;->mProgressDialog:Landroid/app/ProgressDialog;

    .line 102
    :cond_0
    return-void
.end method

.method protected hasPendingRequest()Z
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lco/vine/android/BaseAdapterFragment;->mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

    invoke-virtual {v0}, Lco/vine/android/PendingRequestHelper;->hasPendingRequest()Z

    move-result v0

    return v0
.end method

.method protected hasPendingRequest(I)Z
    .locals 1
    .param p1, "fetchType"    # I

    .prologue
    .line 94
    iget-object v0, p0, Lco/vine/android/BaseAdapterFragment;->mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

    invoke-virtual {v0, p1}, Lco/vine/android/PendingRequestHelper;->hasPendingRequest(I)Z

    move-result v0

    return v0
.end method

.method protected abstract hideProgress(I)V
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 46
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onCreate(Landroid/os/Bundle;)V

    .line 47
    iget-object v0, p0, Lco/vine/android/BaseAdapterFragment;->mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

    iget-object v1, p0, Lco/vine/android/BaseAdapterFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v0, v1, p1}, Lco/vine/android/PendingRequestHelper;->onCreate(Lco/vine/android/client/AppController;Landroid/os/Bundle;)V

    .line 48
    return-void
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 61
    invoke-super {p0}, Lco/vine/android/BaseControllerFragment;->onPause()V

    .line 62
    invoke-virtual {p0}, Lco/vine/android/BaseAdapterFragment;->dismissDialog()V

    .line 63
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 52
    invoke-super {p0}, Lco/vine/android/BaseControllerFragment;->onResume()V

    .line 53
    iget-object v0, p0, Lco/vine/android/BaseAdapterFragment;->mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

    invoke-virtual {v0}, Lco/vine/android/PendingRequestHelper;->onResume()V

    .line 54
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 67
    invoke-super {p0, p1}, Lco/vine/android/BaseControllerFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 68
    iget-object v0, p0, Lco/vine/android/BaseAdapterFragment;->mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

    invoke-virtual {v0, p1}, Lco/vine/android/PendingRequestHelper;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 69
    return-void
.end method

.method protected removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;
    .locals 1
    .param p1, "reqId"    # Ljava/lang/String;

    .prologue
    .line 86
    iget-object v0, p0, Lco/vine/android/BaseAdapterFragment;->mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

    invoke-virtual {v0, p1}, Lco/vine/android/PendingRequestHelper;->removeRequest(Ljava/lang/String;)Lco/vine/android/PendingRequest;

    move-result-object v0

    return-object v0
.end method

.method protected abstract showProgress(I)V
.end method
