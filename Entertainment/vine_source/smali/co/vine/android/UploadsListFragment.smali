.class public Lco/vine/android/UploadsListFragment;
.super Lco/vine/android/BaseCursorListFragment;
.source "UploadsListFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Landroid/widget/AdapterView$OnItemLongClickListener;
.implements Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/UploadsListFragment$UploadListPendingRequestHelper;,
        Lco/vine/android/UploadsListFragment$UploadProgressHandler;
    }
.end annotation


# static fields
.field private static final DIALOG_CONFIRM_DELETE:I = 0x1

.field private static final TAG:Ljava/lang/String; = "UploadsListFragment"


# instance fields
.field private mBound:Z

.field private mConnection:Landroid/content/ServiceConnection;

.field private mIncomingMessenger:Landroid/os/Messenger;

.field private mPath:Ljava/lang/String;

.field private mProgressView:Lco/vine/android/recorder/ProgressView;

.field private mProgressViewWidth:I

.field private mReference:Ljava/lang/String;

.field private mRefreshIcon:Landroid/widget/ImageView;

.field private mServiceMessenger:Landroid/os/Messenger;

.field private mStatusMessage:Landroid/widget/TextView;

.field private mVersions:[Lco/vine/android/recorder/RecordSessionVersion;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 56
    invoke-direct {p0}, Lco/vine/android/BaseCursorListFragment;-><init>()V

    .line 74
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/UploadsListFragment;->mProgressViewWidth:I

    .line 192
    return-void
.end method

.method static synthetic access$102(Lco/vine/android/UploadsListFragment;Landroid/os/Messenger;)Landroid/os/Messenger;
    .locals 0
    .param p0, "x0"    # Lco/vine/android/UploadsListFragment;
    .param p1, "x1"    # Landroid/os/Messenger;

    .prologue
    .line 56
    iput-object p1, p0, Lco/vine/android/UploadsListFragment;->mServiceMessenger:Landroid/os/Messenger;

    return-object p1
.end method

.method static synthetic access$202(Lco/vine/android/UploadsListFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lco/vine/android/UploadsListFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 56
    iput-boolean p1, p0, Lco/vine/android/UploadsListFragment;->mBound:Z

    return p1
.end method

.method static synthetic access$300(Lco/vine/android/UploadsListFragment;)Landroid/os/Messenger;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/UploadsListFragment;

    .prologue
    .line 56
    iget-object v0, p0, Lco/vine/android/UploadsListFragment;->mIncomingMessenger:Landroid/os/Messenger;

    return-object v0
.end method

.method static synthetic access$400(Lco/vine/android/UploadsListFragment;Landroid/os/Message;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/UploadsListFragment;
    .param p1, "x1"    # Landroid/os/Message;

    .prologue
    .line 56
    invoke-direct {p0, p1}, Lco/vine/android/UploadsListFragment;->sendMessage(Landroid/os/Message;)V

    return-void
.end method

.method static synthetic access$500(Lco/vine/android/UploadsListFragment;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/UploadsListFragment;

    .prologue
    .line 56
    iget-object v0, p0, Lco/vine/android/UploadsListFragment;->mStatusMessage:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$600(Lco/vine/android/UploadsListFragment;)Lco/vine/android/recorder/ProgressView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/UploadsListFragment;

    .prologue
    .line 56
    iget-object v0, p0, Lco/vine/android/UploadsListFragment;->mProgressView:Lco/vine/android/recorder/ProgressView;

    return-object v0
.end method

.method static synthetic access$700(Lco/vine/android/UploadsListFragment;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/UploadsListFragment;

    .prologue
    .line 56
    iget v0, p0, Lco/vine/android/UploadsListFragment;->mProgressViewWidth:I

    return v0
.end method

.method static synthetic access$702(Lco/vine/android/UploadsListFragment;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/UploadsListFragment;
    .param p1, "x1"    # I

    .prologue
    .line 56
    iput p1, p0, Lco/vine/android/UploadsListFragment;->mProgressViewWidth:I

    return p1
.end method

.method static synthetic access$800(Lco/vine/android/UploadsListFragment;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/UploadsListFragment;

    .prologue
    .line 56
    invoke-direct {p0}, Lco/vine/android/UploadsListFragment;->resetFailedUpload()V

    return-void
.end method

.method static synthetic access$900(Lco/vine/android/UploadsListFragment;Landroid/database/Cursor;Z)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/UploadsListFragment;
    .param p1, "x1"    # Landroid/database/Cursor;
    .param p2, "x2"    # Z

    .prologue
    .line 56
    invoke-direct {p0, p1, p2}, Lco/vine/android/UploadsListFragment;->handleRetryPost(Landroid/database/Cursor;Z)V

    return-void
.end method

.method private handleRetryPost(Landroid/database/Cursor;Z)V
    .locals 11
    .param p1, "cursor"    # Landroid/database/Cursor;
    .param p2, "ignoreCaptcha"    # Z

    .prologue
    .line 293
    const/4 v0, 0x1

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/UploadsListFragment;->mPath:Ljava/lang/String;

    .line 296
    const/4 v0, 0x3

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v9

    .line 297
    .local v9, "status":I
    iget-object v0, p0, Lco/vine/android/UploadsListFragment;->mPath:Ljava/lang/String;

    invoke-static {v0, p1}, Lco/vine/android/api/VineUpload;->fromCursor(Ljava/lang/String;Landroid/database/Cursor;)Lco/vine/android/api/VineUpload;

    move-result-object v10

    .line 298
    .local v10, "upload":Lco/vine/android/api/VineUpload;
    if-nez v9, :cond_0

    .line 299
    invoke-virtual {p0}, Lco/vine/android/UploadsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, v10, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    iget-object v2, v10, Lco/vine/android/api/VineUpload;->hash:Ljava/lang/String;

    iget-object v3, v10, Lco/vine/android/api/VineUpload;->thumbnailPath:Ljava/lang/String;

    iget-object v4, v10, Lco/vine/android/api/VineUpload;->reference:Ljava/lang/String;

    const/4 v5, 0x0

    const-wide/16 v6, -0x1

    invoke-static/range {v0 .. v7}, Lco/vine/android/service/VineUploadService;->getUploadIntent(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJ)Landroid/content/Intent;

    move-result-object v8

    .line 301
    .local v8, "intent":Landroid/content/Intent;
    invoke-virtual {p0}, Lco/vine/android/UploadsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0, v8}, Landroid/support/v4/app/FragmentActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 314
    .end local v8    # "intent":Landroid/content/Intent;
    :goto_0
    return-void

    .line 303
    :cond_0
    iget-object v0, v10, Lco/vine/android/api/VineUpload;->postInfo:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 304
    invoke-virtual {p0}, Lco/vine/android/UploadsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, v10, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    iget-object v2, v10, Lco/vine/android/api/VineUpload;->thumbnailPath:Ljava/lang/String;

    const/4 v3, 0x0

    const/4 v4, 0x1

    const/4 v5, 0x0

    invoke-static/range {v0 .. v5}, Lco/vine/android/PostActivity;->getIntent(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)Landroid/content/Intent;

    move-result-object v8

    .line 306
    .restart local v8    # "intent":Landroid/content/Intent;
    invoke-virtual {p0}, Lco/vine/android/UploadsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v8, v1}, Landroid/support/v4/app/FragmentActivity;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_0

    .line 307
    .end local v8    # "intent":Landroid/content/Intent;
    :cond_1
    iget-object v0, v10, Lco/vine/android/api/VineUpload;->captchaUrl:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    if-eqz p2, :cond_3

    .line 308
    :cond_2
    invoke-virtual {p0}, Lco/vine/android/UploadsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const/4 v1, 0x1

    invoke-static {v0, v10, v1}, Lco/vine/android/service/VineUploadService;->getPostIntent(Landroid/content/Context;Lco/vine/android/api/VineUpload;Z)Landroid/content/Intent;

    move-result-object v8

    .line 309
    .restart local v8    # "intent":Landroid/content/Intent;
    invoke-virtual {p0}, Lco/vine/android/UploadsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0, v8}, Landroid/support/v4/app/FragmentActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    goto :goto_0

    .line 311
    .end local v8    # "intent":Landroid/content/Intent;
    :cond_3
    iget-object v0, p0, Lco/vine/android/UploadsListFragment;->mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

    invoke-virtual {p0}, Lco/vine/android/UploadsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/UploadsListFragment;->mPath:Ljava/lang/String;

    const/4 v3, 0x0

    const/4 v4, 0x0

    iget-object v5, v10, Lco/vine/android/api/VineUpload;->captchaUrl:Ljava/lang/String;

    invoke-virtual/range {v0 .. v5}, Lco/vine/android/PendingRequestHelper;->onCaptchaRequired(Landroid/support/v4/app/FragmentActivity;Ljava/lang/String;ILandroid/os/Bundle;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private resetFailedUpload()V
    .locals 2

    .prologue
    .line 142
    iget-object v0, p0, Lco/vine/android/UploadsListFragment;->mStatusMessage:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/UploadsListFragment;->mRefreshIcon:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/UploadsListFragment;->mProgressView:Lco/vine/android/recorder/ProgressView;

    if-eqz v0, :cond_0

    .line 143
    iget-object v0, p0, Lco/vine/android/UploadsListFragment;->mStatusMessage:Landroid/widget/TextView;

    const v1, 0x7f0e025e

    invoke-virtual {p0, v1}, Lco/vine/android/UploadsListFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 144
    iget-object v0, p0, Lco/vine/android/UploadsListFragment;->mRefreshIcon:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 145
    iget-object v0, p0, Lco/vine/android/UploadsListFragment;->mProgressView:Lco/vine/android/recorder/ProgressView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lco/vine/android/recorder/ProgressView;->setProgressRatio(F)V

    .line 147
    :cond_0
    return-void
.end method

.method private sendMessage(Landroid/os/Message;)V
    .locals 1
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 246
    :try_start_0
    iget-object v0, p0, Lco/vine/android/UploadsListFragment;->mServiceMessenger:Landroid/os/Messenger;

    invoke-virtual {v0, p1}, Landroid/os/Messenger;->send(Landroid/os/Message;)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    .line 249
    :goto_0
    return-void

    .line 247
    :catch_0
    move-exception v0

    goto :goto_0
.end method


# virtual methods
.method protected createPendingRequestHelper()Lco/vine/android/PendingRequestHelper;
    .locals 1

    .prologue
    .line 228
    new-instance v0, Lco/vine/android/UploadsListFragment$UploadListPendingRequestHelper;

    invoke-direct {v0, p0}, Lco/vine/android/UploadsListFragment$UploadListPendingRequestHelper;-><init>(Lco/vine/android/UploadsListFragment;)V

    return-object v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 9
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v8, 0x0

    .line 151
    invoke-super {p0, p1}, Lco/vine/android/BaseCursorListFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 153
    invoke-virtual {p0}, Lco/vine/android/UploadsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 155
    .local v0, "activity":Landroid/support/v4/app/FragmentActivity;
    iget-object v5, p0, Lco/vine/android/UploadsListFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    if-nez v5, :cond_0

    .line 156
    new-instance v5, Lco/vine/android/UploadsAdapter;

    iget-object v6, p0, Lco/vine/android/UploadsListFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-direct {v5, v0, v6, v8}, Lco/vine/android/UploadsAdapter;-><init>(Landroid/content/Context;Lco/vine/android/client/AppController;I)V

    iput-object v5, p0, Lco/vine/android/UploadsListFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    .line 160
    :cond_0
    :try_start_0
    invoke-static {v0}, Lco/vine/android/recorder/RecordSessionVersion;->getValuesWithManagers(Landroid/content/Context;)[Lco/vine/android/recorder/RecordSessionVersion;

    move-result-object v5

    iput-object v5, p0, Lco/vine/android/UploadsListFragment;->mVersions:[Lco/vine/android/recorder/RecordSessionVersion;
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 166
    :goto_0
    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v5

    const v6, 0x7f03009e

    iget-object v7, p0, Lco/vine/android/UploadsListFragment;->mListView:Landroid/widget/ListView;

    invoke-virtual {v5, v6, v7, v8}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 167
    .local v2, "header":Landroid/view/View;
    const v5, 0x7f0a004a

    invoke-virtual {v2, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 168
    .local v3, "headerTitle":Landroid/widget/TextView;
    const v5, 0x7f0e025b

    invoke-virtual {v3, v5}, Landroid/widget/TextView;->setText(I)V

    .line 170
    iget-object v4, p0, Lco/vine/android/UploadsListFragment;->mListView:Landroid/widget/ListView;

    .line 171
    .local v4, "listview":Landroid/widget/ListView;
    const/4 v5, 0x0

    invoke-virtual {v4, v2, v5, v8}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 172
    invoke-virtual {p0}, Lco/vine/android/UploadsListFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f090093

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    invoke-virtual {v4, v5}, Landroid/widget/ListView;->setBackgroundColor(I)V

    .line 173
    invoke-virtual {v4, v8}, Landroid/widget/ListView;->setDividerHeight(I)V

    .line 174
    invoke-virtual {v4, p0}, Landroid/widget/ListView;->setOnItemLongClickListener(Landroid/widget/AdapterView$OnItemLongClickListener;)V

    .line 175
    iget-object v5, p0, Lco/vine/android/UploadsListFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v4, v5}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 176
    return-void

    .line 161
    .end local v2    # "header":Landroid/view/View;
    .end local v3    # "headerTitle":Landroid/widget/TextView;
    .end local v4    # "listview":Landroid/widget/ListView;
    :catch_0
    move-exception v1

    .line 162
    .local v1, "e":Ljava/io/IOException;
    const v5, 0x7f0e0231

    invoke-static {v0, v5}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    .line 163
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    goto :goto_0
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 366
    iget-object v0, p0, Lco/vine/android/UploadsListFragment;->mPendingRequestHelper:Lco/vine/android/PendingRequestHelper;

    invoke-virtual {v0, p1, p2, p3}, Lco/vine/android/PendingRequestHelper;->onActivityResult(IILandroid/content/Intent;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 367
    if-nez p2, :cond_0

    .line 368
    invoke-direct {p0}, Lco/vine/android/UploadsListFragment;->resetFailedUpload()V

    .line 371
    :cond_0
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 362
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 79
    invoke-super {p0, p1}, Lco/vine/android/BaseCursorListFragment;->onCreate(Landroid/os/Bundle;)V

    .line 81
    new-instance v0, Landroid/os/Messenger;

    new-instance v1, Lco/vine/android/UploadsListFragment$UploadProgressHandler;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lco/vine/android/UploadsListFragment$UploadProgressHandler;-><init>(Lco/vine/android/UploadsListFragment;Lco/vine/android/UploadsListFragment$1;)V

    invoke-direct {v0, v1}, Landroid/os/Messenger;-><init>(Landroid/os/Handler;)V

    iput-object v0, p0, Lco/vine/android/UploadsListFragment;->mIncomingMessenger:Landroid/os/Messenger;

    .line 82
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/UploadsListFragment;->mBound:Z

    .line 83
    new-instance v0, Lco/vine/android/UploadsListFragment$1;

    invoke-direct {v0, p0}, Lco/vine/android/UploadsListFragment$1;-><init>(Lco/vine/android/UploadsListFragment;)V

    iput-object v0, p0, Lco/vine/android/UploadsListFragment;->mConnection:Landroid/content/ServiceConnection;

    .line 103
    return-void
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/support/v4/content/Loader;
    .locals 8
    .param p1, "id"    # I
    .param p2, "args"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x2

    .line 253
    const-string v7, "status=? AND is_private=?"

    .line 254
    .local v7, "selection":Ljava/lang/String;
    new-array v5, v1, [Ljava/lang/String;

    const/4 v0, 0x0

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v5, v0

    const/4 v0, 0x1

    const-string v1, "0"

    aput-object v1, v5, v0

    .line 255
    .local v5, "selArgs":[Ljava/lang/String;
    new-instance v0, Landroid/support/v4/content/CursorLoader;

    invoke-virtual {p0}, Lco/vine/android/UploadsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    sget-object v2, Lco/vine/android/provider/VineUploads$Uploads;->CONTENT_URI:Landroid/net/Uri;

    sget-object v3, Lco/vine/android/provider/VineUploadsDatabaseSQL$UploadsQuery;->PROJECTION:[Ljava/lang/String;

    const-string v4, "status=? AND is_private=?"

    const-string v6, "_id ASC"

    invoke-direct/range {v0 .. v6}, Landroid/support/v4/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public onDialogDone(Landroid/content/DialogInterface;II)V
    .locals 4
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I
    .param p3, "which"    # I

    .prologue
    .line 336
    packed-switch p2, :pswitch_data_0

    .line 358
    :goto_0
    :pswitch_0
    return-void

    .line 338
    :pswitch_1
    packed-switch p3, :pswitch_data_1

    goto :goto_0

    .line 343
    :pswitch_2
    invoke-virtual {p0}, Lco/vine/android/UploadsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 345
    .local v0, "context":Landroid/content/Context;
    :try_start_0
    iget-object v2, p0, Lco/vine/android/UploadsListFragment;->mReference:Ljava/lang/String;

    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 346
    iget-object v2, p0, Lco/vine/android/UploadsListFragment;->mReference:Ljava/lang/String;

    invoke-static {v0, v2}, Lco/vine/android/recorder/RecordSessionVersion;->deleteSessionWithName(Landroid/content/Context;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 351
    :cond_0
    :goto_1
    invoke-virtual {p0}, Lco/vine/android/UploadsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/UploadsListFragment;->mPath:Ljava/lang/String;

    invoke-static {v0, v3}, Lco/vine/android/service/VineUploadService;->getDiscardIntent(Landroid/content/Context;Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/support/v4/app/FragmentActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    goto :goto_0

    .line 348
    :catch_0
    move-exception v1

    .line 349
    .local v1, "e":Ljava/io/IOException;
    const-string v2, "Failed to delete session."

    invoke-static {v2}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    goto :goto_1

    .line 336
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
    .end packed-switch

    .line 338
    :pswitch_data_1
    .packed-switch -0x2
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method public onItemLongClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)Z
    .locals 4
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)Z"
        }
    .end annotation

    .prologue
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    const/4 v2, 0x1

    .line 318
    iget-object v3, p0, Lco/vine/android/UploadsListFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v3}, Landroid/support/v4/widget/CursorAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    .line 319
    .local v0, "cursor":Landroid/database/Cursor;
    check-cast p1, Landroid/widget/ListView;

    .end local p1    # "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    invoke-virtual {p1}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v3

    sub-int v3, p3, v3

    invoke-interface {v0, v3}, Landroid/database/Cursor;->moveToPosition(I)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 320
    invoke-interface {v0, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lco/vine/android/UploadsListFragment;->mPath:Ljava/lang/String;

    .line 321
    const/16 v3, 0xb

    invoke-interface {v0, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lco/vine/android/UploadsListFragment;->mReference:Ljava/lang/String;

    .line 322
    invoke-static {v2}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v1

    .line 324
    .local v1, "promptDialogFragment":Lco/vine/android/widgets/PromptDialogSupportFragment;
    invoke-virtual {v1, p0}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setListener(Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;)V

    .line 325
    const v3, 0x7f0e00af

    invoke-virtual {v1, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 326
    const v3, 0x7f0e0288

    invoke-virtual {v1, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 327
    const v3, 0x7f0e0057

    invoke-virtual {v1, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNegativeButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 328
    invoke-virtual {p0}, Lco/vine/android/UploadsListFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v3

    invoke-virtual {v1, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V

    .line 331
    .end local v1    # "promptDialogFragment":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public onListItemClick(Landroid/widget/ListView;Landroid/view/View;IJ)V
    .locals 5
    .param p1, "l"    # Landroid/widget/ListView;
    .param p2, "v"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J

    .prologue
    .line 273
    iget-object v4, p0, Lco/vine/android/UploadsListFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v4}, Landroid/support/v4/widget/CursorAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v0

    .line 274
    .local v0, "cursor":Landroid/database/Cursor;
    invoke-virtual {p1}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v4

    sub-int v3, p3, v4

    .line 276
    .local v3, "uploadPosition":I
    if-nez v3, :cond_0

    invoke-interface {v0}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 277
    const/4 v4, 0x1

    invoke-interface {v0, v4}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lco/vine/android/UploadsListFragment;->mPath:Ljava/lang/String;

    .line 278
    const v4, 0x7f0a00c6

    invoke-virtual {p2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lco/vine/android/recorder/ProgressView;

    iput-object v4, p0, Lco/vine/android/UploadsListFragment;->mProgressView:Lco/vine/android/recorder/ProgressView;

    .line 280
    const v4, 0x7f0a0229

    invoke-virtual {p2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 281
    .local v1, "retry":Landroid/widget/ImageView;
    const/16 v4, 0x8

    invoke-virtual {v1, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 282
    iput-object v1, p0, Lco/vine/android/UploadsListFragment;->mRefreshIcon:Landroid/widget/ImageView;

    .line 284
    const v4, 0x7f0a0228

    invoke-virtual {p2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 285
    .local v2, "statusMessage":Landroid/widget/TextView;
    const v4, 0x7f0e0261

    invoke-virtual {p0, v4}, Lco/vine/android/UploadsListFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 286
    iput-object v2, p0, Lco/vine/android/UploadsListFragment;->mStatusMessage:Landroid/widget/TextView;

    .line 288
    const/4 v4, 0x0

    invoke-direct {p0, v0, v4}, Lco/vine/android/UploadsListFragment;->handleRetryPost(Landroid/database/Cursor;Z)V

    .line 290
    .end local v1    # "retry":Landroid/widget/ImageView;
    .end local v2    # "statusMessage":Landroid/widget/TextView;
    :cond_0
    return-void
.end method

.method public onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V
    .locals 2
    .param p2, "cursor"    # Landroid/database/Cursor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;",
            "Landroid/database/Cursor;",
            ")V"
        }
    .end annotation

    .prologue
    .local p1, "loader":Landroid/support/v4/content/Loader;, "Landroid/support/v4/content/Loader<Landroid/database/Cursor;>;"
    const/4 v1, 0x0

    .line 261
    invoke-super {p0, p1, p2}, Lco/vine/android/BaseCursorListFragment;->onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V

    .line 262
    const/4 v0, 0x3

    invoke-virtual {p0, v0}, Lco/vine/android/UploadsListFragment;->hideProgress(I)V

    .line 263
    invoke-virtual {p0}, Lco/vine/android/UploadsListFragment;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 264
    const/4 v0, 0x1

    invoke-virtual {p0, v0, v1}, Lco/vine/android/UploadsListFragment;->showSadface(ZZ)V

    .line 265
    invoke-virtual {p0}, Lco/vine/android/UploadsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {p0}, Lco/vine/android/UploadsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1}, Lco/vine/android/service/VineUploadService;->getClearNotificationsIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 269
    :goto_0
    return-void

    .line 267
    :cond_0
    invoke-virtual {p0, v1}, Lco/vine/android/UploadsListFragment;->showSadface(Z)V

    goto :goto_0
.end method

.method public bridge synthetic onLoadFinished(Landroid/support/v4/content/Loader;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Landroid/support/v4/content/Loader;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 56
    check-cast p2, Landroid/database/Cursor;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lco/vine/android/UploadsListFragment;->onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V

    return-void
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 233
    invoke-super {p0}, Lco/vine/android/BaseCursorListFragment;->onPause()V

    .line 235
    iget-boolean v0, p0, Lco/vine/android/UploadsListFragment;->mBound:Z

    if-eqz v0, :cond_0

    .line 236
    const-string v0, "UploadsListFragment"

    const-string v1, "Will unbind from VineUploadService now"

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 238
    const/4 v0, 0x0

    const/4 v1, 0x2

    invoke-static {v0, v1}, Landroid/os/Message;->obtain(Landroid/os/Handler;I)Landroid/os/Message;

    move-result-object v0

    invoke-direct {p0, v0}, Lco/vine/android/UploadsListFragment;->sendMessage(Landroid/os/Message;)V

    .line 239
    invoke-virtual {p0}, Lco/vine/android/UploadsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/UploadsListFragment;->mConnection:Landroid/content/ServiceConnection;

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentActivity;->unbindService(Landroid/content/ServiceConnection;)V

    .line 240
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/UploadsListFragment;->mBound:Z

    .line 242
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 4

    .prologue
    .line 180
    invoke-super {p0}, Lco/vine/android/BaseCursorListFragment;->onResume()V

    .line 181
    iget-object v1, p0, Lco/vine/android/UploadsListFragment;->mCursorAdapter:Landroid/support/v4/widget/CursorAdapter;

    invoke-virtual {v1}, Landroid/support/v4/widget/CursorAdapter;->getCursor()Landroid/database/Cursor;

    move-result-object v1

    if-nez v1, :cond_0

    .line 182
    invoke-virtual {p0}, Lco/vine/android/UploadsListFragment;->initLoader()V

    .line 185
    :cond_0
    iget-boolean v1, p0, Lco/vine/android/UploadsListFragment;->mBound:Z

    if-nez v1, :cond_1

    .line 186
    const-string v1, "UploadsListFragment"

    const-string v2, "Will bind to VineUploadService now"

    invoke-static {v1, v2}, Lcom/edisonwang/android/slog/SLog;->dWithTag(Ljava/lang/String;Ljava/lang/String;)V

    .line 187
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lco/vine/android/UploadsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-class v2, Lco/vine/android/service/VineUploadService;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 188
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0}, Lco/vine/android/UploadsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/UploadsListFragment;->mConnection:Landroid/content/ServiceConnection;

    const/4 v3, 0x1

    invoke-virtual {v1, v0, v2, v3}, Landroid/support/v4/app/FragmentActivity;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    .line 190
    .end local v0    # "intent":Landroid/content/Intent;
    :cond_1
    return-void
.end method
