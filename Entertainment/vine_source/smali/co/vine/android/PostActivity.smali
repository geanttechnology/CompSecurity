.class public Lco/vine/android/PostActivity;
.super Lco/vine/android/BaseControllerActionBarActivity;
.source "PostActivity.java"

# interfaces
.implements Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;


# static fields
.field public static final AG_CAMERA_WAIT_TIME:Ljava/lang/String; = "camera_wait"

.field public static final AG_COMBINE_WAIT_TIME:Ljava/lang/String; = "combine_wait"

.field public static final AG_FROM_SONY:Ljava/lang/String; = "f_s"

.field public static final AG_IS_RETRY:Ljava/lang/String; = "is_retry"

.field public static final AG_PREVIEW_PATH:Ljava/lang/String; = "preview_path"

.field public static final AG_THUMBNAIL_PATH:Ljava/lang/String; = "pic_path"

.field private static final DIALOG_UNSAVED_CHANGES:I = 0x124

.field private static final POST_TAG:Ljava/lang/String; = "post"


# instance fields
.field private mFrag:Lco/vine/android/PostFragment;

.field private mVideoPath:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Lco/vine/android/BaseControllerActionBarActivity;-><init>()V

    return-void
.end method

.method public static getIntent(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)Landroid/content/Intent;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "videoPath"    # Ljava/lang/String;
    .param p2, "thumbnailPath"    # Ljava/lang/String;
    .param p3, "previewPath"    # Ljava/lang/String;
    .param p4, "isRetry"    # Z
    .param p5, "isFromSony"    # Z

    .prologue
    .line 41
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/PostActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 42
    .local v0, "intent":Landroid/content/Intent;
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 43
    :cond_0
    new-instance v1, Ljava/lang/IllegalStateException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Well, you should give two paths that are not null you know: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 46
    :cond_1
    new-instance v1, Ljava/io/File;

    invoke-direct {v1, p1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {v1}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 47
    const-string v1, "pic_path"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 48
    const-string v1, "preview_path"

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 49
    const-string v1, "is_retry"

    invoke-virtual {v0, v1, p4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 50
    const-string v1, "f_s"

    invoke-virtual {v0, v1, p5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 51
    const-string v1, "camera_wait"

    sget-wide v2, Lco/vine/android/recorder/BasicVineRecorder;->sTimeTaken:J

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 52
    const-string v1, "combine_wait"

    sget-wide v2, Lco/vine/android/recorder/RecordController;->sMaxKnownStopTime:J

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 53
    return-object v0
.end method


# virtual methods
.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 2
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 119
    iget-object v0, p0, Lco/vine/android/PostActivity;->mFrag:Lco/vine/android/PostFragment;

    if-nez v0, :cond_0

    .line 120
    invoke-virtual {p0}, Lco/vine/android/PostActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const-string v1, "post"

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lco/vine/android/PostFragment;

    iput-object v0, p0, Lco/vine/android/PostActivity;->mFrag:Lco/vine/android/PostFragment;

    .line 122
    :cond_0
    iget-object v0, p0, Lco/vine/android/PostActivity;->mFrag:Lco/vine/android/PostFragment;

    if-eqz v0, :cond_1

    .line 123
    iget-object v0, p0, Lco/vine/android/PostActivity;->mFrag:Lco/vine/android/PostFragment;

    invoke-virtual {v0, p1, p2, p3}, Lco/vine/android/PostFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 127
    :goto_0
    return-void

    .line 125
    :cond_1
    invoke-super {p0, p1, p2, p3}, Lco/vine/android/BaseControllerActionBarActivity;->onActivityResult(IILandroid/content/Intent;)V

    goto :goto_0
.end method

.method public onBackPressed()V
    .locals 0

    .prologue
    .line 92
    invoke-static {}, Lco/vine/android/util/FlurryUtils;->trackBackFromPostScreen()V

    .line 93
    invoke-super {p0}, Lco/vine/android/BaseControllerActionBarActivity;->onBackPressed()V

    .line 94
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 10
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const-wide/16 v8, 0x0

    const/4 v6, 0x1

    .line 58
    const v3, 0x7f030046

    invoke-super {p0, p1, v3, v6}, Lco/vine/android/BaseControllerActionBarActivity;->onCreate(Landroid/os/Bundle;IZ)V

    .line 60
    invoke-virtual {p0, v6}, Lco/vine/android/PostActivity;->setRequestedOrientation(I)V

    .line 62
    if-nez p1, :cond_0

    .line 64
    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    const v5, 0x7f0e020f

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    invoke-virtual {p0, v3, v4, v5, v6}, Lco/vine/android/PostActivity;->setupActionBar(Ljava/lang/Boolean;Ljava/lang/Boolean;ILjava/lang/Boolean;)V

    .line 66
    invoke-virtual {p0}, Lco/vine/android/PostActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    .line 67
    .local v2, "intent":Landroid/content/Intent;
    invoke-virtual {v2}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v3}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lco/vine/android/PostActivity;->mVideoPath:Ljava/lang/String;

    .line 68
    new-instance v1, Lco/vine/android/PostFragment;

    invoke-direct {v1}, Lco/vine/android/PostFragment;-><init>()V

    .line 70
    .local v1, "frag":Lco/vine/android/PostFragment;
    iget-object v3, p0, Lco/vine/android/PostActivity;->mVideoPath:Ljava/lang/String;

    const-string v4, "pic_path"

    invoke-virtual {v2, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "preview_path"

    invoke-virtual {v2, v5}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "is_retry"

    const/4 v7, 0x0

    invoke-virtual {v2, v6, v7}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v6

    invoke-static {v2, v3, v4, v5, v6}, Lco/vine/android/PostFragment;->prepareArguments(Landroid/content/Intent;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Landroid/os/Bundle;

    move-result-object v0

    .line 76
    .local v0, "args":Landroid/os/Bundle;
    const-string v3, "Post activity started for {}."

    iget-object v4, p0, Lco/vine/android/PostActivity;->mVideoPath:Ljava/lang/String;

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 77
    invoke-virtual {v1, v0}, Lco/vine/android/PostFragment;->setArguments(Landroid/os/Bundle;)V

    .line 79
    const-string v3, "camera_wait"

    invoke-virtual {v2, v3, v8, v9}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v3

    sput-wide v3, Lco/vine/android/recorder/BasicVineRecorder;->sTimeTaken:J

    .line 80
    const-string v3, "combine_wait"

    invoke-virtual {v2, v3, v8, v9}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v3

    sput-wide v3, Lco/vine/android/recorder/RecordController;->sMaxKnownStopTime:J

    .line 82
    iput-object v1, p0, Lco/vine/android/PostActivity;->mFrag:Lco/vine/android/PostFragment;

    .line 83
    invoke-virtual {p0}, Lco/vine/android/PostActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v3

    const v4, 0x7f0a0102

    const-string v5, "post"

    invoke-virtual {v3, v4, v1, v5}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 88
    .end local v0    # "args":Landroid/os/Bundle;
    .end local v1    # "frag":Lco/vine/android/PostFragment;
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_0
    return-void
.end method

.method public onDialogDone(Landroid/content/DialogInterface;II)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I
    .param p3, "which"    # I

    .prologue
    .line 99
    packed-switch p2, :pswitch_data_0

    .line 115
    :goto_0
    return-void

    .line 101
    :pswitch_0
    packed-switch p3, :pswitch_data_1

    goto :goto_0

    .line 109
    :pswitch_1
    invoke-interface {p1}, Landroid/content/DialogInterface;->dismiss()V

    goto :goto_0

    .line 103
    :pswitch_2
    const-string v0, "post"

    invoke-static {v0}, Lco/vine/android/util/FlurryUtils;->trackAbandonedStage(Ljava/lang/String;)V

    .line 104
    iget-object v0, p0, Lco/vine/android/PostActivity;->mVideoPath:Ljava/lang/String;

    invoke-static {p0, v0}, Lco/vine/android/util/UploadManager;->removeFromUploadQueue(Landroid/content/Context;Ljava/lang/String;)V

    .line 105
    invoke-virtual {p0}, Lco/vine/android/PostActivity;->finish()V

    goto :goto_0

    .line 99
    :pswitch_data_0
    .packed-switch 0x124
        :pswitch_0
    .end packed-switch

    .line 101
    :pswitch_data_1
    .packed-switch -0x2
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
