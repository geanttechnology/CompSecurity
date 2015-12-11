.class public Lco/vine/android/UploadsListFragment$UploadListPendingRequestHelper;
.super Lco/vine/android/BaseAdapterFragment$BasePendingRequestHelper;
.source "UploadsListFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/UploadsListFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "UploadListPendingRequestHelper"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/UploadsListFragment;


# direct methods
.method public constructor <init>(Lco/vine/android/UploadsListFragment;)V
    .locals 0

    .prologue
    .line 192
    iput-object p1, p0, Lco/vine/android/UploadsListFragment$UploadListPendingRequestHelper;->this$0:Lco/vine/android/UploadsListFragment;

    invoke-direct {p0, p1}, Lco/vine/android/BaseAdapterFragment$BasePendingRequestHelper;-><init>(Lco/vine/android/BaseAdapterFragment;)V

    return-void
.end method


# virtual methods
.method public handleFailedCaptchaRequest(Lco/vine/android/PendingCaptchaRequest;)V
    .locals 5
    .param p1, "pendingCaptchaRequest"    # Lco/vine/android/PendingCaptchaRequest;

    .prologue
    .line 196
    iget-object v3, p0, Lco/vine/android/UploadsListFragment$UploadListPendingRequestHelper;->this$0:Lco/vine/android/UploadsListFragment;

    iget-object v3, v3, Lco/vine/android/UploadsListFragment;->mListView:Landroid/widget/ListView;

    if-eqz v3, :cond_1

    .line 197
    iget-object v3, p0, Lco/vine/android/UploadsListFragment$UploadListPendingRequestHelper;->this$0:Lco/vine/android/UploadsListFragment;

    iget-object v3, v3, Lco/vine/android/UploadsListFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v3}, Landroid/widget/ListView;->getChildCount()I

    move-result v3

    iget-object v4, p0, Lco/vine/android/UploadsListFragment$UploadListPendingRequestHelper;->this$0:Lco/vine/android/UploadsListFragment;

    iget-object v4, v4, Lco/vine/android/UploadsListFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v4}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v4

    if-le v3, v4, :cond_1

    .line 198
    iget-object v3, p0, Lco/vine/android/UploadsListFragment$UploadListPendingRequestHelper;->this$0:Lco/vine/android/UploadsListFragment;

    iget-object v3, v3, Lco/vine/android/UploadsListFragment;->mListView:Landroid/widget/ListView;

    iget-object v4, p0, Lco/vine/android/UploadsListFragment$UploadListPendingRequestHelper;->this$0:Lco/vine/android/UploadsListFragment;

    iget-object v4, v4, Lco/vine/android/UploadsListFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v4}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/widget/ListView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 199
    .local v0, "currentRow":Landroid/view/View;
    if-eqz v0, :cond_1

    .line 200
    const v3, 0x7f0a0030

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ProgressBar;

    .line 202
    .local v1, "loading":Landroid/widget/ProgressBar;
    if-eqz v1, :cond_0

    .line 203
    const/16 v3, 0x8

    invoke-virtual {v1, v3}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 207
    :cond_0
    const v3, 0x7f0a0229

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    .line 208
    .local v2, "retry":Landroid/widget/ImageView;
    if-eqz v2, :cond_1

    .line 209
    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 215
    .end local v0    # "currentRow":Landroid/view/View;
    .end local v1    # "loading":Landroid/widget/ProgressBar;
    .end local v2    # "retry":Landroid/widget/ImageView;
    :cond_1
    return-void
.end method

.method public handleRetryCaptchaRequest(Lco/vine/android/PendingCaptchaRequest;)V
    .locals 3
    .param p1, "pendingCaptchaRequest"    # Lco/vine/android/PendingCaptchaRequest;

    .prologue
    .line 219
    iget-object v1, p0, Lco/vine/android/UploadsListFragment$UploadListPendingRequestHelper;->this$0:Lco/vine/android/UploadsListFragment;

    iget-object v1, v1, Lco/vine/android/UploadsListFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v1}, Landroid/support/v4/widget/CursorAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    .line 220
    .local v0, "c":Landroid/database/Cursor;
    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 221
    iget-object v1, p0, Lco/vine/android/UploadsListFragment$UploadListPendingRequestHelper;->this$0:Lco/vine/android/UploadsListFragment;

    const/4 v2, 0x1

    # invokes: Lco/vine/android/UploadsListFragment;->handleRetryPost(Landroid/database/Cursor;Z)V
    invoke-static {v1, v0, v2}, Lco/vine/android/UploadsListFragment;->access$900(Lco/vine/android/UploadsListFragment;Landroid/database/Cursor;Z)V

    .line 223
    :cond_0
    return-void
.end method

.method public bridge synthetic hideProgress(I)V
    .locals 0
    .param p1, "x0"    # I

    .prologue
    .line 192
    invoke-super {p0, p1}, Lco/vine/android/BaseAdapterFragment$BasePendingRequestHelper;->hideProgress(I)V

    return-void
.end method

.method public bridge synthetic showProgress(I)V
    .locals 0
    .param p1, "x0"    # I

    .prologue
    .line 192
    invoke-super {p0, p1}, Lco/vine/android/BaseAdapterFragment$BasePendingRequestHelper;->showProgress(I)V

    return-void
.end method
