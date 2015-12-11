.class public Lco/vine/android/RecordingPreviewFragment;
.super Lco/vine/android/BaseFragment;
.source "RecordingPreviewFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;


# static fields
.field public static final AG_THUMBNAIL_PATH:Ljava/lang/String; = "pic_path"

.field public static final AG_UPLOAD_PATH:Ljava/lang/String; = "upload_path"

.field public static final AG_VIDEO_PATH:Ljava/lang/String; = "video_path"

.field public static final ARG_AM_FOLLOWING:Ljava/lang/String; = "am_following"

.field public static final ARG_COLOR:Ljava/lang/String; = "color"

.field public static final ARG_CONVERSATION_ROW_ID:Ljava/lang/String; = "conversation_row_id"

.field public static final ARG_DIRECT_USER_ID:Ljava/lang/String; = "direct_user_id"

.field public static final ARG_FROM_SONY:Ljava/lang/String; = "f_s"

.field public static final ARG_IS_MESSAGING:Ljava/lang/String; = "messaging"

.field public static final ARG_IS_VM_ONBOARDING:Ljava/lang/String; = "is_vm_onboarding"

.field public static final ARG_RECIPIENT_USERNAME:Ljava/lang/String; = "recipient_username"

.field private static final DIALOG_MUST_LOGIN:I = 0x1

.field private static final REQUEST_CODE_LOGIN_TO_POST:I = 0x3039

.field public static final REQUEST_POST:I = 0x7c6

.field public static final REQUEST_SEND_MESSAGE:I = 0x7c7

.field private static final TRANSITION_DURATION:J = 0xfaL

.field private static final VALID_MAX_LOOPS:[I


# instance fields
.field private mAmFollowing:Z

.field private mColor:I

.field private mConversationRowId:J

.field private mDirectUserId:J

.field private mFinalFile:Lco/vine/android/recorder/RecordingFile;

.field private mIsFromSony:Z

.field private mIsMessaging:Z

.field private mIsVmOnboarding:Z

.field private mMaxLoop:I

.field private mMessagingEditText:Landroid/widget/EditText;

.field private mMessagingLoopLimitText:Landroid/widget/Button;

.field private mNextButton:Landroid/view/View;

.field private mPreviewButtons:Landroid/view/View;

.field private mRecipientUsername:Ljava/lang/String;

.field private mThumbnailPath:Ljava/lang/String;

.field private mUploadPath:Ljava/lang/String;

.field private mVideoPath:Ljava/lang/String;

.field private mVideoPlayer:Lco/vine/android/player/SdkVideoView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 53
    const/4 v0, 0x4

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Lco/vine/android/RecordingPreviewFragment;->VALID_MAX_LOOPS:[I

    return-void

    nop

    :array_0
    .array-data 4
        0x0
        0x1
        0x3
        0x6
    .end array-data
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 50
    invoke-direct {p0}, Lco/vine/android/BaseFragment;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lco/vine/android/RecordingPreviewFragment;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/RecordingPreviewFragment;

    .prologue
    .line 50
    iget v0, p0, Lco/vine/android/RecordingPreviewFragment;->mMaxLoop:I

    return v0
.end method

.method static synthetic access$002(Lco/vine/android/RecordingPreviewFragment;I)I
    .locals 0
    .param p0, "x0"    # Lco/vine/android/RecordingPreviewFragment;
    .param p1, "x1"    # I

    .prologue
    .line 50
    iput p1, p0, Lco/vine/android/RecordingPreviewFragment;->mMaxLoop:I

    return p1
.end method

.method static synthetic access$100()[I
    .locals 1

    .prologue
    .line 50
    sget-object v0, Lco/vine/android/RecordingPreviewFragment;->VALID_MAX_LOOPS:[I

    return-object v0
.end method

.method static synthetic access$200(Lco/vine/android/RecordingPreviewFragment;)V
    .locals 0
    .param p0, "x0"    # Lco/vine/android/RecordingPreviewFragment;

    .prologue
    .line 50
    invoke-direct {p0}, Lco/vine/android/RecordingPreviewFragment;->updateMessageLoopLimit()V

    return-void
.end method

.method private animateInViews()V
    .locals 6

    .prologue
    const-wide/16 v4, 0xfa

    const/4 v3, 0x0

    const/high16 v2, 0x3f800000    # 1.0f

    const/4 v1, 0x0

    .line 295
    iget-boolean v0, p0, Lco/vine/android/RecordingPreviewFragment;->mIsMessaging:Z

    if-nez v0, :cond_0

    .line 296
    iget-object v0, p0, Lco/vine/android/RecordingPreviewFragment;->mNextButton:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setAlpha(F)V

    .line 297
    iget-object v0, p0, Lco/vine/android/RecordingPreviewFragment;->mNextButton:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 298
    iget-object v0, p0, Lco/vine/android/RecordingPreviewFragment;->mNextButton:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v4, v5}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 301
    :cond_0
    iget-object v0, p0, Lco/vine/android/RecordingPreviewFragment;->mPreviewButtons:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setAlpha(F)V

    .line 302
    iget-object v0, p0, Lco/vine/android/RecordingPreviewFragment;->mPreviewButtons:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 303
    iget-object v0, p0, Lco/vine/android/RecordingPreviewFragment;->mPreviewButtons:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v4, v5}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 304
    return-void
.end method

.method private animateOutViews()V
    .locals 4

    .prologue
    const-wide/16 v2, 0xfa

    const/4 v1, 0x0

    .line 307
    iget-object v0, p0, Lco/vine/android/RecordingPreviewFragment;->mNextButton:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 308
    iget-object v0, p0, Lco/vine/android/RecordingPreviewFragment;->mPreviewButtons:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->animate()Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v2, v3}, Landroid/view/ViewPropertyAnimator;->setDuration(J)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/view/ViewPropertyAnimator;->alpha(F)Landroid/view/ViewPropertyAnimator;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewPropertyAnimator;->start()V

    .line 309
    return-void
.end method

.method public static newInstance(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZJJZILjava/lang/String;ZZ)Lco/vine/android/RecordingPreviewFragment;
    .locals 3
    .param p0, "videoPath"    # Ljava/lang/String;
    .param p1, "uploadPath"    # Ljava/lang/String;
    .param p2, "thumbnailPath"    # Ljava/lang/String;
    .param p3, "isMessaging"    # Z
    .param p4, "conversationObjectId"    # J
    .param p6, "directUserId"    # J
    .param p8, "isFromSony"    # Z
    .param p9, "color"    # I
    .param p10, "recipientUsername"    # Ljava/lang/String;
    .param p11, "amFollowing"    # Z
    .param p12, "isVmOnboarding"    # Z

    .prologue
    .line 119
    new-instance v1, Lco/vine/android/RecordingPreviewFragment;

    invoke-direct {v1}, Lco/vine/android/RecordingPreviewFragment;-><init>()V

    .line 120
    .local v1, "fragment":Lco/vine/android/RecordingPreviewFragment;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 121
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v2, "video_path"

    invoke-virtual {v0, v2, p0}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 122
    const-string v2, "pic_path"

    invoke-virtual {v0, v2, p2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 123
    const-string v2, "upload_path"

    invoke-virtual {v0, v2, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 124
    const-string v2, "messaging"

    invoke-virtual {v0, v2, p3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 125
    const-string v2, "conversation_row_id"

    invoke-virtual {v0, v2, p4, p5}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 126
    const-string v2, "direct_user_id"

    invoke-virtual {v0, v2, p6, p7}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 127
    const-string v2, "f_s"

    invoke-virtual {v0, v2, p8}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 128
    const-string v2, "color"

    invoke-virtual {v0, v2, p9}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 129
    const-string v2, "recipient_username"

    invoke-virtual {v0, v2, p10}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    const-string v2, "am_following"

    invoke-virtual {v0, v2, p11}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 131
    const-string v2, "is_vm_onboarding"

    invoke-virtual {v0, v2, p12}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 132
    invoke-virtual {v1, v0}, Lco/vine/android/RecordingPreviewFragment;->setArguments(Landroid/os/Bundle;)V

    .line 133
    return-object v1
.end method

.method private updateMessageLoopLimit()V
    .locals 4

    .prologue
    .line 289
    iget-object v0, p0, Lco/vine/android/RecordingPreviewFragment;->mMessagingLoopLimitText:Landroid/widget/Button;

    if-eqz v0, :cond_0

    .line 290
    iget-object v1, p0, Lco/vine/android/RecordingPreviewFragment;->mMessagingLoopLimitText:Landroid/widget/Button;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Loop Limit: "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v0, Lco/vine/android/RecordingPreviewFragment;->VALID_MAX_LOOPS:[I

    iget v3, p0, Lco/vine/android/RecordingPreviewFragment;->mMaxLoop:I

    aget v0, v0, v3

    if-nez v0, :cond_1

    const-string v0, "Infinite"

    :goto_0
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 292
    :cond_0
    return-void

    .line 290
    :cond_1
    sget-object v0, Lco/vine/android/RecordingPreviewFragment;->VALID_MAX_LOOPS:[I

    iget v3, p0, Lco/vine/android/RecordingPreviewFragment;->mMaxLoop:I

    aget v0, v0, v3

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    goto :goto_0
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 159
    invoke-super {p0, p1}, Lco/vine/android/BaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 160
    invoke-virtual {p0}, Lco/vine/android/RecordingPreviewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getFilesDir()Ljava/io/File;

    move-result-object v0

    invoke-static {v0}, Lco/vine/android/recorder/RecordConfigUtils;->deletePreProcess(Ljava/io/File;)V

    .line 161
    iget-object v0, p0, Lco/vine/android/RecordingPreviewFragment;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    iget-object v1, p0, Lco/vine/android/RecordingPreviewFragment;->mVideoPath:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lco/vine/android/player/SdkVideoView;->setVideoPath(Ljava/lang/String;)V

    .line 162
    const-string v0, "Preview: {}"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lco/vine/android/RecordingPreviewFragment;->mVideoPath:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 163
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 429
    sparse-switch p1, :sswitch_data_0

    .line 450
    invoke-super {p0, p1, p2, p3}, Lco/vine/android/BaseFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 454
    :goto_0
    return-void

    .line 431
    :sswitch_0
    packed-switch p2, :pswitch_data_0

    goto :goto_0

    .line 433
    :pswitch_0
    invoke-virtual {p0}, Lco/vine/android/RecordingPreviewFragment;->uploadAndToPost()V

    goto :goto_0

    .line 441
    :sswitch_1
    packed-switch p2, :pswitch_data_1

    goto :goto_0

    .line 443
    :pswitch_1
    invoke-virtual {p0}, Lco/vine/android/RecordingPreviewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    goto :goto_0

    .line 429
    nop

    :sswitch_data_0
    .sparse-switch
        0x7c6 -> :sswitch_1
        0x3039 -> :sswitch_0
    .end sparse-switch

    .line 431
    :pswitch_data_0
    .packed-switch -0x1
        :pswitch_0
    .end packed-switch

    .line 441
    :pswitch_data_1
    .packed-switch 0x20
        :pswitch_1
    .end packed-switch
.end method

.method public onClick(Landroid/view/View;)V
    .locals 24
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 313
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecordingPreviewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v18

    check-cast v18, Lco/vine/android/AbstractRecordingActivity;

    .line 314
    .local v18, "activity":Lco/vine/android/AbstractRecordingActivity;
    if-nez v18, :cond_1

    .line 388
    :cond_0
    :goto_0
    return-void

    .line 317
    :cond_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/RecordingPreviewFragment;->mUploadPath:Ljava/lang/String;

    if-nez v2, :cond_2

    .line 318
    invoke-virtual/range {v18 .. v18}, Lco/vine/android/AbstractRecordingActivity;->makeSureUploadIsReady()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lco/vine/android/RecordingPreviewFragment;->mUploadPath:Ljava/lang/String;

    .line 320
    :cond_2
    invoke-virtual/range {p1 .. p1}, Landroid/view/View;->getId()I

    move-result v20

    .line 321
    .local v20, "id":I
    packed-switch v20, :pswitch_data_0

    :pswitch_0
    goto :goto_0

    .line 378
    :pswitch_1
    invoke-direct/range {p0 .. p0}, Lco/vine/android/RecordingPreviewFragment;->animateOutViews()V

    .line 379
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecordingPreviewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    check-cast v2, Lco/vine/android/AbstractRecordingActivity;

    const/4 v4, 0x0

    move-object/from16 v0, p0

    invoke-virtual {v0, v2, v4}, Lco/vine/android/RecordingPreviewFragment;->previewToRecord(Lco/vine/android/AbstractRecordingActivity;Z)V

    .line 380
    const-string v2, "capture"

    invoke-static {v2}, Lco/vine/android/util/FlurryUtils;->trackPreviewAction(Ljava/lang/String;)V

    goto :goto_0

    .line 323
    :pswitch_2
    invoke-static/range {v18 .. v18}, Lco/vine/android/client/AppController;->getInstance(Landroid/content/Context;)Lco/vine/android/client/AppController;

    move-result-object v2

    invoke-virtual {v2}, Lco/vine/android/client/AppController;->isLoggedIn()Z

    move-result v2

    if-nez v2, :cond_3

    .line 324
    const/4 v2, 0x1

    invoke-static {v2}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v22

    .line 326
    .local v22, "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    const v2, 0x7f0e0207

    move-object/from16 v0, v22

    invoke-virtual {v0, v2}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 327
    const v2, 0x104000a

    move-object/from16 v0, v22

    invoke-virtual {v0, v2}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setPositiveButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 328
    const/high16 v2, 0x1040000

    move-object/from16 v0, v22

    invoke-virtual {v0, v2}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNeutralButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    .line 329
    move-object/from16 v0, v22

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setListener(Lco/vine/android/widgets/PromptDialogSupportFragment$OnDialogDoneListener;)V

    .line 330
    const/4 v2, 0x0

    move-object/from16 v0, v22

    move-object/from16 v1, p0

    invoke-virtual {v0, v1, v2}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 331
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecordingPreviewFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    move-object/from16 v0, v22

    invoke-virtual {v0, v2}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V

    goto :goto_0

    .line 335
    .end local v22    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :cond_3
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecordingPreviewFragment;->toPost()V

    .line 336
    const-string v2, "post"

    invoke-static {v2}, Lco/vine/android/util/FlurryUtils;->trackPreviewAction(Ljava/lang/String;)V

    goto :goto_0

    .line 341
    :pswitch_3
    move-object/from16 v0, p0

    iget-object v2, v0, Lco/vine/android/RecordingPreviewFragment;->mMessagingEditText:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v23

    .line 342
    .local v23, "text":Landroid/text/Editable;
    if-eqz v23, :cond_4

    invoke-virtual/range {v23 .. v23}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    .line 343
    .local v3, "message":Ljava/lang/String;
    :goto_1
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lco/vine/android/RecordingPreviewFragment;->mIsMessaging:Z

    if-eqz v2, :cond_0

    .line 344
    move-object/from16 v0, p0

    iget-wide v4, v0, Lco/vine/android/RecordingPreviewFragment;->mDirectUserId:J

    const-wide/16 v6, 0x0

    cmp-long v2, v4, v6

    if-gez v2, :cond_5

    move-object/from16 v0, p0

    iget-wide v4, v0, Lco/vine/android/RecordingPreviewFragment;->mConversationRowId:J

    const-wide/16 v6, 0x0

    cmp-long v2, v4, v6

    if-gez v2, :cond_5

    .line 345
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecordingPreviewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v4, v0, Lco/vine/android/RecordingPreviewFragment;->mUploadPath:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/RecordingPreviewFragment;->mThumbnailPath:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v6, v0, Lco/vine/android/RecordingPreviewFragment;->mVideoPath:Ljava/lang/String;

    sget-object v7, Lco/vine/android/RecordingPreviewFragment;->VALID_MAX_LOOPS:[I

    move-object/from16 v0, p0

    iget v8, v0, Lco/vine/android/RecordingPreviewFragment;->mMaxLoop:I

    aget v7, v7, v8

    move-object/from16 v0, p0

    iget-boolean v8, v0, Lco/vine/android/RecordingPreviewFragment;->mIsVmOnboarding:Z

    invoke-static/range {v2 .. v8}, Lco/vine/android/RecipientPickerActivity;->getIntent(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IZ)Landroid/content/Intent;

    move-result-object v21

    .line 348
    .local v21, "intent":Landroid/content/Intent;
    const/16 v2, 0x7c7

    move-object/from16 v0, v18

    move-object/from16 v1, v21

    invoke-virtual {v0, v1, v2}, Lco/vine/android/AbstractRecordingActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 349
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecordingPreviewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Lco/vine/android/service/VineUploadService;->getShowProgressIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v2

    move-object/from16 v0, v18

    invoke-virtual {v0, v2}, Lco/vine/android/AbstractRecordingActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    goto/16 :goto_0

    .line 342
    .end local v3    # "message":Ljava/lang/String;
    .end local v21    # "intent":Landroid/content/Intent;
    :cond_4
    const-string v3, ""

    goto :goto_1

    .line 353
    .restart local v3    # "message":Ljava/lang/String;
    :cond_5
    move-object/from16 v0, p0

    iget-wide v4, v0, Lco/vine/android/RecordingPreviewFragment;->mDirectUserId:J

    const-wide/16 v6, 0x0

    cmp-long v2, v4, v6

    if-ltz v2, :cond_7

    .line 354
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 355
    .local v9, "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    move-object/from16 v0, p0

    iget-wide v4, v0, Lco/vine/android/RecordingPreviewFragment;->mDirectUserId:J

    invoke-static {v4, v5}, Lco/vine/android/api/VineRecipient;->fromUser(J)Lco/vine/android/api/VineRecipient;

    move-result-object v2

    invoke-virtual {v9, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 360
    :goto_2
    move-object/from16 v0, p0

    iget-object v5, v0, Lco/vine/android/RecordingPreviewFragment;->mUploadPath:Ljava/lang/String;

    const/4 v6, 0x0

    move-object/from16 v0, p0

    iget-wide v7, v0, Lco/vine/android/RecordingPreviewFragment;->mConversationRowId:J

    sget-object v2, Lco/vine/android/RecordingPreviewFragment;->VALID_MAX_LOOPS:[I

    move-object/from16 v0, p0

    iget v4, v0, Lco/vine/android/RecordingPreviewFragment;->mMaxLoop:I

    aget v11, v2, v4

    move-object/from16 v4, v18

    move-object v10, v3

    invoke-static/range {v4 .. v11}, Lco/vine/android/service/VineUploadService;->getVMPostIntent(Landroid/content/Context;Ljava/lang/String;ZJLjava/util/ArrayList;Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v2

    move-object/from16 v0, v18

    invoke-virtual {v0, v2}, Lco/vine/android/AbstractRecordingActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 363
    invoke-static/range {v18 .. v18}, Lco/vine/android/service/VineUploadService;->getShowProgressIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v2

    move-object/from16 v0, v18

    invoke-virtual {v0, v2}, Lco/vine/android/AbstractRecordingActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 364
    invoke-virtual/range {v18 .. v18}, Lco/vine/android/AbstractRecordingActivity;->startConversationOnFinish()Z

    move-result v2

    if-eqz v2, :cond_6

    .line 365
    invoke-virtual/range {v18 .. v18}, Lco/vine/android/AbstractRecordingActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v10

    move-object/from16 v0, p0

    iget-wide v11, v0, Lco/vine/android/RecordingPreviewFragment;->mConversationRowId:J

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/RecordingPreviewFragment;->mRecipientUsername:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-wide v14, v0, Lco/vine/android/RecordingPreviewFragment;->mDirectUserId:J

    move-object/from16 v0, p0

    iget-boolean v0, v0, Lco/vine/android/RecordingPreviewFragment;->mAmFollowing:Z

    move/from16 v16, v0

    const/16 v17, 0x0

    invoke-static/range {v10 .. v17}, Lco/vine/android/ConversationActivity;->getIntent(Landroid/content/Context;JLjava/lang/String;JZZ)Landroid/content/Intent;

    move-result-object v19

    .line 368
    .local v19, "i":Landroid/content/Intent;
    const/high16 v2, 0x4000000

    move-object/from16 v0, v19

    invoke-virtual {v0, v2}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 369
    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Lco/vine/android/RecordingPreviewFragment;->startActivity(Landroid/content/Intent;)V

    .line 371
    .end local v19    # "i":Landroid/content/Intent;
    :cond_6
    invoke-virtual/range {v18 .. v18}, Lco/vine/android/AbstractRecordingActivity;->finish()V

    goto/16 :goto_0

    .line 357
    .end local v9    # "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    :cond_7
    invoke-virtual/range {v18 .. v18}, Lco/vine/android/AbstractRecordingActivity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    move-object/from16 v0, p0

    iget-wide v4, v0, Lco/vine/android/RecordingPreviewFragment;->mConversationRowId:J

    invoke-static {v2, v4, v5}, Lco/vine/android/provider/VineProviderHelper;->getConversationRecipients(Landroid/content/ContentResolver;J)Ljava/util/ArrayList;

    move-result-object v9

    .restart local v9    # "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    goto :goto_2

    .line 383
    .end local v3    # "message":Ljava/lang/String;
    .end local v9    # "recipients":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineRecipient;>;"
    .end local v23    # "text":Landroid/text/Editable;
    :pswitch_4
    invoke-direct/range {p0 .. p0}, Lco/vine/android/RecordingPreviewFragment;->animateOutViews()V

    .line 384
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecordingPreviewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    check-cast v2, Lco/vine/android/AbstractRecordingActivity;

    const/4 v4, 0x1

    move-object/from16 v0, p0

    invoke-virtual {v0, v2, v4}, Lco/vine/android/RecordingPreviewFragment;->previewToRecord(Lco/vine/android/AbstractRecordingActivity;Z)V

    .line 385
    const-string v2, "edit"

    invoke-static {v2}, Lco/vine/android/util/FlurryUtils;->trackPreviewAction(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 321
    nop

    :pswitch_data_0
    .packed-switch 0x7f0a017c
        :pswitch_1
        :pswitch_4
        :pswitch_0
        :pswitch_1
        :pswitch_3
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const-wide/16 v3, -0x1

    .line 138
    invoke-super {p0, p1}, Lco/vine/android/BaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 139
    invoke-virtual {p0}, Lco/vine/android/RecordingPreviewFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 140
    .local v0, "args":Landroid/os/Bundle;
    const-string v1, "video_path"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/RecordingPreviewFragment;->mVideoPath:Ljava/lang/String;

    .line 141
    const-string v1, "pic_path"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/RecordingPreviewFragment;->mThumbnailPath:Ljava/lang/String;

    .line 142
    const-string v1, "upload_path"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/RecordingPreviewFragment;->mUploadPath:Ljava/lang/String;

    .line 143
    const-string v1, "messaging"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lco/vine/android/RecordingPreviewFragment;->mIsMessaging:Z

    .line 144
    const-string v1, "conversation_row_id"

    invoke-virtual {v0, v1, v3, v4}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v1

    iput-wide v1, p0, Lco/vine/android/RecordingPreviewFragment;->mConversationRowId:J

    .line 145
    const-string v1, "recipient_username"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/RecordingPreviewFragment;->mRecipientUsername:Ljava/lang/String;

    .line 146
    const-string v1, "am_following"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lco/vine/android/RecordingPreviewFragment;->mAmFollowing:Z

    .line 147
    const-string v1, "direct_user_id"

    invoke-virtual {v0, v1, v3, v4}, Landroid/os/Bundle;->getLong(Ljava/lang/String;J)J

    move-result-wide v1

    iput-wide v1, p0, Lco/vine/android/RecordingPreviewFragment;->mDirectUserId:J

    .line 148
    const-string v1, "f_s"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lco/vine/android/RecordingPreviewFragment;->mIsFromSony:Z

    .line 149
    const-string v1, "color"

    const/4 v2, -0x1

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    iput v1, p0, Lco/vine/android/RecordingPreviewFragment;->mColor:I

    .line 150
    iget v1, p0, Lco/vine/android/RecordingPreviewFragment;->mColor:I

    sget v2, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    if-eq v1, v2, :cond_0

    iget v1, p0, Lco/vine/android/RecordingPreviewFragment;->mColor:I

    if-gtz v1, :cond_1

    .line 151
    :cond_0
    const v1, 0xffffff

    invoke-virtual {p0}, Lco/vine/android/RecordingPreviewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f090096

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    and-int/2addr v1, v2

    iput v1, p0, Lco/vine/android/RecordingPreviewFragment;->mColor:I

    .line 153
    :cond_1
    iget v1, p0, Lco/vine/android/RecordingPreviewFragment;->mColor:I

    const/high16 v2, -0x1000000

    or-int/2addr v1, v2

    iput v1, p0, Lco/vine/android/RecordingPreviewFragment;->mColor:I

    .line 154
    const-string v1, "is_vm_onboarding"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    iput-boolean v1, p0, Lco/vine/android/RecordingPreviewFragment;->mIsVmOnboarding:Z

    .line 155
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 25
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 167
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecordingPreviewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v14

    .line 168
    .local v14, "res":Landroid/content/res/Resources;
    const v22, 0x7f030072

    const/16 v23, 0x0

    move-object/from16 v0, p1

    move/from16 v1, v22

    move-object/from16 v2, p2

    move/from16 v3, v23

    invoke-virtual {v0, v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v19

    .line 169
    .local v19, "view":Landroid/view/View;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecordingPreviewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v22

    invoke-static/range {v22 .. v22}, Lco/vine/android/util/SystemUtil;->getDisplaySize(Landroid/app/Activity;)Landroid/graphics/Point;

    move-result-object v16

    .line 171
    .local v16, "size":Landroid/graphics/Point;
    const v22, 0x7f0a0179

    move-object/from16 v0, v19

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v22

    check-cast v22, Landroid/widget/EditText;

    move-object/from16 v0, v22

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/RecordingPreviewFragment;->mMessagingEditText:Landroid/widget/EditText;

    .line 172
    const v22, 0x7f0a017a

    move-object/from16 v0, v19

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v22

    check-cast v22, Landroid/widget/Button;

    move-object/from16 v0, v22

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/RecordingPreviewFragment;->mMessagingLoopLimitText:Landroid/widget/Button;

    .line 173
    const v22, 0x7f0a0182

    move-object/from16 v0, v19

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v22

    move-object/from16 v0, v22

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/RecordingPreviewFragment;->mNextButton:Landroid/view/View;

    .line 174
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lco/vine/android/RecordingPreviewFragment;->mIsMessaging:Z

    move/from16 v22, v0

    if-eqz v22, :cond_4

    .line 175
    const/16 v22, 0x0

    move/from16 v0, v22

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/RecordingPreviewFragment;->mMaxLoop:I

    .line 176
    invoke-direct/range {p0 .. p0}, Lco/vine/android/RecordingPreviewFragment;->updateMessageLoopLimit()V

    .line 177
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingPreviewFragment;->mMessagingLoopLimitText:Landroid/widget/Button;

    move-object/from16 v22, v0

    if-eqz v22, :cond_0

    .line 178
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingPreviewFragment;->mMessagingLoopLimitText:Landroid/widget/Button;

    move-object/from16 v22, v0

    new-instance v23, Lco/vine/android/RecordingPreviewFragment$1;

    move-object/from16 v0, v23

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lco/vine/android/RecordingPreviewFragment$1;-><init>(Lco/vine/android/RecordingPreviewFragment;)V

    invoke-virtual/range {v22 .. v23}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 188
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingPreviewFragment;->mMessagingLoopLimitText:Landroid/widget/Button;

    move-object/from16 v22, v0

    const/16 v23, 0x8

    invoke-virtual/range {v22 .. v23}, Landroid/widget/Button;->setVisibility(I)V

    .line 191
    :cond_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingPreviewFragment;->mMessagingEditText:Landroid/widget/EditText;

    move-object/from16 v22, v0

    const/16 v23, 0x0

    invoke-virtual/range {v22 .. v23}, Landroid/widget/EditText;->setVisibility(I)V

    .line 192
    const v22, 0x7f0a017e

    move-object/from16 v0, v19

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v22

    move-object/from16 v0, v22

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/RecordingPreviewFragment;->mPreviewButtons:Landroid/view/View;

    .line 193
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingPreviewFragment;->mPreviewButtons:Landroid/view/View;

    move-object/from16 v22, v0

    const/16 v23, 0x0

    invoke-virtual/range {v22 .. v23}, Landroid/view/View;->setVisibility(I)V

    .line 194
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingPreviewFragment;->mPreviewButtons:Landroid/view/View;

    move-object/from16 v22, v0

    new-instance v23, Lco/vine/android/RecordingPreviewFragment$2;

    move-object/from16 v0, v23

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lco/vine/android/RecordingPreviewFragment$2;-><init>(Lco/vine/android/RecordingPreviewFragment;)V

    invoke-virtual/range {v22 .. v23}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 201
    const v22, 0x7f090025

    move/from16 v0, v22

    invoke-virtual {v14, v0}, Landroid/content/res/Resources;->getColor(I)I

    move-result v20

    .line 202
    .local v20, "vmBgColor":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingPreviewFragment;->mPreviewButtons:Landroid/view/View;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    move/from16 v1, v20

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundColor(I)V

    .line 204
    invoke-virtual/range {v19 .. v20}, Landroid/view/View;->setBackgroundColor(I)V

    .line 205
    const v22, 0x7f0a00e0

    move-object/from16 v0, v19

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v15

    .line 206
    .local v15, "scrollView":Landroid/view/View;
    move/from16 v0, v20

    invoke-virtual {v15, v0}, Landroid/view/View;->setBackgroundColor(I)V

    .line 208
    const v22, 0x7f0a0181

    move-object/from16 v0, v19

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v12

    check-cast v12, Lco/vine/android/widget/TypefacesTextView;

    .line 209
    .local v12, "recipient":Lco/vine/android/widget/TypefacesTextView;
    const/16 v22, 0x3

    move/from16 v0, v22

    invoke-virtual {v12, v0}, Lco/vine/android/widget/TypefacesTextView;->setWeight(I)V

    .line 210
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecordingPreviewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v22

    invoke-static/range {v22 .. v22}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v22

    move-object/from16 v0, v22

    iget-object v0, v0, Lco/vine/android/widget/Typefaces;->mediumContent:Landroid/graphics/Typeface;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    invoke-virtual {v12, v0}, Lco/vine/android/widget/TypefacesTextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 211
    const/16 v22, 0x0

    move/from16 v0, v22

    invoke-virtual {v12, v0}, Lco/vine/android/widget/TypefacesTextView;->setVisibility(I)V

    .line 212
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingPreviewFragment;->mRecipientUsername:Ljava/lang/String;

    move-object/from16 v22, v0

    invoke-static/range {v22 .. v22}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v22

    if-nez v22, :cond_1

    .line 213
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingPreviewFragment;->mRecipientUsername:Ljava/lang/String;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    invoke-virtual {v12, v0}, Lco/vine/android/widget/TypefacesTextView;->setText(Ljava/lang/CharSequence;)V

    .line 229
    .end local v12    # "recipient":Lco/vine/android/widget/TypefacesTextView;
    .end local v15    # "scrollView":Landroid/view/View;
    .end local v20    # "vmBgColor":I
    :cond_1
    :goto_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingPreviewFragment;->mNextButton:Landroid/view/View;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 231
    const v22, 0x7f0a017c

    move-object/from16 v0, v19

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v22

    move-object/from16 v0, v22

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 232
    const v22, 0x7f0a017d

    move-object/from16 v0, v19

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v22

    move-object/from16 v0, v22

    move-object/from16 v1, p0

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 233
    const v22, 0x7f0a0180

    move-object/from16 v0, v19

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/TextView;

    .line 234
    .local v9, "nextButton":Landroid/widget/TextView;
    move-object/from16 v0, p0

    invoke-virtual {v9, v0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 235
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lco/vine/android/RecordingPreviewFragment;->mIsMessaging:Z

    move/from16 v22, v0

    if-eqz v22, :cond_2

    .line 236
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/RecordingPreviewFragment;->mColor:I

    move/from16 v22, v0

    move/from16 v0, v22

    invoke-virtual {v9, v0}, Landroid/widget/TextView;->setTextColor(I)V

    .line 238
    :cond_2
    const v22, 0x7f0a017f

    move-object/from16 v0, v19

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .line 239
    .local v4, "backButton":Landroid/view/View;
    move-object/from16 v0, p0

    invoke-virtual {v4, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 240
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lco/vine/android/RecordingPreviewFragment;->mIsMessaging:Z

    move/from16 v22, v0

    if-eqz v22, :cond_3

    .line 241
    move-object/from16 v0, p0

    iget v0, v0, Lco/vine/android/RecordingPreviewFragment;->mColor:I

    move/from16 v22, v0

    const v23, 0x7f02014c

    move/from16 v0, v22

    move/from16 v1, v23

    invoke-static {v14, v0, v1, v4}, Lco/vine/android/util/ViewUtil;->fillColor(Landroid/content/res/Resources;IILandroid/view/View;)V

    .line 244
    :cond_3
    const v22, 0x7f0a0178

    move-object/from16 v0, v19

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v22

    check-cast v22, Lco/vine/android/player/SdkVideoView;

    move-object/from16 v0, v22

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/RecordingPreviewFragment;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    .line 245
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingPreviewFragment;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    move-object/from16 v22, v0

    const/16 v23, 0x0

    invoke-virtual/range {v22 .. v23}, Lco/vine/android/player/SdkVideoView;->setVisibility(I)V

    .line 246
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingPreviewFragment;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    move-object/from16 v22, v0

    const/16 v23, 0x1

    invoke-virtual/range {v22 .. v23}, Lco/vine/android/player/SdkVideoView;->setAutoPlayOnPrepared(Z)V

    .line 247
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingPreviewFragment;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    move-object/from16 v22, v0

    const/16 v23, 0x1

    invoke-virtual/range {v22 .. v23}, Lco/vine/android/player/SdkVideoView;->setKeepScreenOn(Z)V

    .line 250
    const v22, 0x7f0a00d6

    move-object/from16 v0, v19

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v18

    .line 251
    .local v18, "videoPlayerContainer":Landroid/view/View;
    const v22, 0x7f0b001c

    move/from16 v0, v22

    invoke-virtual {v14, v0}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v17

    .line 252
    .local v17, "topMaskHeightPx":I
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingPreviewFragment;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    move-object/from16 v22, v0

    check-cast v22, Lco/vine/android/player/StaticSizeVideoView;

    move-object/from16 v0, v16

    iget v0, v0, Landroid/graphics/Point;->x:I

    move/from16 v23, v0

    move-object/from16 v0, v16

    iget v0, v0, Landroid/graphics/Point;->x:I

    move/from16 v24, v0

    invoke-virtual/range {v22 .. v24}, Lco/vine/android/player/StaticSizeVideoView;->setSize(II)V

    .line 254
    new-instance v22, Lco/vine/android/player/OnSingleVideoClickedListener;

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingPreviewFragment;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    move-object/from16 v23, v0

    invoke-direct/range {v22 .. v23}, Lco/vine/android/player/OnSingleVideoClickedListener;-><init>(Lco/vine/android/player/VideoViewInterface;)V

    move-object/from16 v0, v18

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 255
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingPreviewFragment;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    move-object/from16 v22, v0

    const/16 v23, 0x1

    invoke-virtual/range {v22 .. v23}, Lco/vine/android/player/SdkVideoView;->setLooping(Z)V

    .line 256
    new-instance v13, Landroid/graphics/Rect;

    invoke-direct {v13}, Landroid/graphics/Rect;-><init>()V

    .line 257
    .local v13, "rect":Landroid/graphics/Rect;
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/RecordingPreviewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Landroid/support/v4/app/FragmentActivity;->getWindow()Landroid/view/Window;

    move-result-object v21

    .line 258
    .local v21, "window":Landroid/view/Window;
    invoke-virtual/range {v21 .. v21}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v22

    move-object/from16 v0, v22

    invoke-virtual {v0, v13}, Landroid/view/View;->getWindowVisibleDisplayFrame(Landroid/graphics/Rect;)V

    .line 259
    const/16 v22, 0x10

    invoke-virtual/range {v21 .. v22}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 261
    const v22, 0x7f0a00a3

    move-object/from16 v0, v19

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    .line 262
    .local v5, "bottomMask":Landroid/view/View;
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lco/vine/android/RecordingPreviewFragment;->mIsMessaging:Z

    move/from16 v22, v0

    if-eqz v22, :cond_5

    .line 263
    const/16 v22, 0x8

    move/from16 v0, v22

    invoke-virtual {v5, v0}, Landroid/view/View;->setVisibility(I)V

    .line 284
    :goto_1
    invoke-direct/range {p0 .. p0}, Lco/vine/android/RecordingPreviewFragment;->animateInViews()V

    .line 285
    return-object v19

    .line 216
    .end local v4    # "backButton":Landroid/view/View;
    .end local v5    # "bottomMask":Landroid/view/View;
    .end local v9    # "nextButton":Landroid/widget/TextView;
    .end local v13    # "rect":Landroid/graphics/Rect;
    .end local v17    # "topMaskHeightPx":I
    .end local v18    # "videoPlayerContainer":Landroid/view/View;
    .end local v21    # "window":Landroid/view/Window;
    :cond_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingPreviewFragment;->mMessagingLoopLimitText:Landroid/widget/Button;

    move-object/from16 v22, v0

    const/16 v23, 0x8

    invoke-virtual/range {v22 .. v23}, Landroid/widget/Button;->setVisibility(I)V

    .line 217
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingPreviewFragment;->mMessagingEditText:Landroid/widget/EditText;

    move-object/from16 v22, v0

    const/16 v23, 0x8

    invoke-virtual/range {v22 .. v23}, Landroid/widget/EditText;->setVisibility(I)V

    .line 218
    const v22, 0x7f0a017b

    move-object/from16 v0, v19

    move/from16 v1, v22

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v22

    move-object/from16 v0, v22

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/RecordingPreviewFragment;->mPreviewButtons:Landroid/view/View;

    .line 219
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingPreviewFragment;->mPreviewButtons:Landroid/view/View;

    move-object/from16 v22, v0

    const/16 v23, 0x0

    invoke-virtual/range {v22 .. v23}, Landroid/view/View;->setVisibility(I)V

    .line 220
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingPreviewFragment;->mPreviewButtons:Landroid/view/View;

    move-object/from16 v22, v0

    new-instance v23, Lco/vine/android/RecordingPreviewFragment$3;

    move-object/from16 v0, v23

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lco/vine/android/RecordingPreviewFragment$3;-><init>(Lco/vine/android/RecordingPreviewFragment;)V

    invoke-virtual/range {v22 .. v23}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 226
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingPreviewFragment;->mNextButton:Landroid/view/View;

    move-object/from16 v22, v0

    const/16 v23, 0x0

    invoke-virtual/range {v22 .. v23}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_0

    .line 265
    .restart local v4    # "backButton":Landroid/view/View;
    .restart local v5    # "bottomMask":Landroid/view/View;
    .restart local v9    # "nextButton":Landroid/widget/TextView;
    .restart local v13    # "rect":Landroid/graphics/Rect;
    .restart local v17    # "topMaskHeightPx":I
    .restart local v18    # "videoPlayerContainer":Landroid/view/View;
    .restart local v21    # "window":Landroid/view/Window;
    :cond_5
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingPreviewFragment;->mNextButton:Landroid/view/View;

    move-object/from16 v22, v0

    invoke-virtual/range {v22 .. v22}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v11

    check-cast v11, Landroid/widget/RelativeLayout$LayoutParams;

    .line 267
    .local v11, "postButtonParams":Landroid/widget/RelativeLayout$LayoutParams;
    const v22, 0x7f0b0061

    move/from16 v0, v22

    invoke-virtual {v14, v0}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v10

    .line 268
    .local v10, "postButtonHeight":I
    iget v0, v13, Landroid/graphics/Rect;->bottom:I

    move/from16 v22, v0

    iget v0, v13, Landroid/graphics/Rect;->top:I

    move/from16 v23, v0

    sub-int v22, v22, v23

    move-object/from16 v0, v16

    iget v0, v0, Landroid/graphics/Point;->x:I

    move/from16 v23, v0

    sub-int v22, v22, v23

    sub-int v22, v22, v17

    sub-int v22, v22, v10

    div-int/lit8 v7, v22, 0x2

    .line 270
    .local v7, "doneButtonBottomMargin":I
    const/16 v22, 0x0

    const/16 v23, 0x0

    const/16 v24, 0x0

    move/from16 v0, v22

    move/from16 v1, v23

    move/from16 v2, v24

    invoke-virtual {v11, v0, v1, v2, v7}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 271
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/RecordingPreviewFragment;->mNextButton:Landroid/view/View;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    invoke-virtual {v0, v11}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 273
    iget v0, v13, Landroid/graphics/Rect;->bottom:I

    move/from16 v22, v0

    iget v0, v13, Landroid/graphics/Rect;->top:I

    move/from16 v23, v0

    sub-int v22, v22, v23

    sub-int v22, v22, v17

    move-object/from16 v0, v16

    iget v0, v0, Landroid/graphics/Point;->x:I

    move/from16 v23, v0

    sub-int v6, v22, v23

    .line 274
    .local v6, "bottomMaskHeightPx":I
    invoke-virtual {v5}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v8

    check-cast v8, Landroid/widget/RelativeLayout$LayoutParams;

    .line 275
    .local v8, "lp":Landroid/widget/RelativeLayout$LayoutParams;
    iput v6, v8, Landroid/widget/RelativeLayout$LayoutParams;->height:I

    .line 276
    invoke-virtual {v5, v8}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 277
    new-instance v22, Lco/vine/android/RecordingPreviewFragment$4;

    move-object/from16 v0, v22

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lco/vine/android/RecordingPreviewFragment$4;-><init>(Lco/vine/android/RecordingPreviewFragment;)V

    move-object/from16 v0, v22

    invoke-virtual {v5, v0}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    goto/16 :goto_1
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 398
    invoke-super {p0}, Lco/vine/android/BaseFragment;->onDestroy()V

    .line 399
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/RecordingPreviewFragment;->mFinalFile:Lco/vine/android/recorder/RecordingFile;

    .line 400
    return-void
.end method

.method public onDialogDone(Landroid/content/DialogInterface;II)V
    .locals 4
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "id"    # I
    .param p3, "which"    # I

    .prologue
    .line 408
    packed-switch p2, :pswitch_data_0

    .line 425
    :goto_0
    return-void

    .line 410
    :pswitch_0
    packed-switch p3, :pswitch_data_1

    goto :goto_0

    .line 412
    :pswitch_1
    invoke-virtual {p0}, Lco/vine/android/RecordingPreviewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 413
    .local v0, "activity":Landroid/app/Activity;
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lco/vine/android/SonyStartActivity;

    invoke-direct {v1, v0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 414
    .local v1, "i":Landroid/content/Intent;
    const-string v2, "login_request_start_activity"

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 415
    const/16 v2, 0x3039

    invoke-virtual {v0, v1, v2}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_0

    .line 408
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch

    .line 410
    :pswitch_data_1
    .packed-switch -0x1
        :pswitch_1
    .end packed-switch
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 98
    invoke-super {p0}, Lco/vine/android/BaseFragment;->onPause()V

    .line 99
    iget-object v0, p0, Lco/vine/android/RecordingPreviewFragment;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->canPause()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 100
    iget-object v0, p0, Lco/vine/android/RecordingPreviewFragment;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->pause()V

    .line 102
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 106
    invoke-super {p0}, Lco/vine/android/BaseFragment;->onResume()V

    .line 107
    invoke-direct {p0}, Lco/vine/android/RecordingPreviewFragment;->animateInViews()V

    .line 108
    iget-object v0, p0, Lco/vine/android/RecordingPreviewFragment;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    iget v0, v0, Lco/vine/android/player/SdkVideoView;->mCurrentState:I

    const/4 v1, 0x7

    if-ne v0, v1, :cond_0

    .line 109
    iget-object v0, p0, Lco/vine/android/RecordingPreviewFragment;->mVideoPlayer:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->start()V

    .line 111
    :cond_0
    return-void
.end method

.method public previewToRecord(Lco/vine/android/AbstractRecordingActivity;Z)V
    .locals 2
    .param p1, "activity"    # Lco/vine/android/AbstractRecordingActivity;
    .param p2, "startWithEdit"    # Z

    .prologue
    .line 391
    if-eqz p1, :cond_0

    .line 392
    const/4 v0, 0x0

    iget-object v1, p0, Lco/vine/android/RecordingPreviewFragment;->mFinalFile:Lco/vine/android/recorder/RecordingFile;

    invoke-virtual {p1, v0, p2, v1}, Lco/vine/android/AbstractRecordingActivity;->toRecord(ZZLco/vine/android/recorder/RecordingFile;)V

    .line 394
    :cond_0
    return-void
.end method

.method public setFinalFile(Lco/vine/android/recorder/RecordingFile;)V
    .locals 0
    .param p1, "finalFile"    # Lco/vine/android/recorder/RecordingFile;

    .prologue
    .line 403
    iput-object p1, p0, Lco/vine/android/RecordingPreviewFragment;->mFinalFile:Lco/vine/android/recorder/RecordingFile;

    .line 404
    return-void
.end method

.method public toPost()V
    .locals 8

    .prologue
    .line 478
    invoke-virtual {p0}, Lco/vine/android/RecordingPreviewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v6

    check-cast v6, Lco/vine/android/AbstractRecordingActivity;

    .line 479
    .local v6, "activity":Lco/vine/android/AbstractRecordingActivity;
    if-nez v6, :cond_0

    .line 488
    :goto_0
    return-void

    .line 482
    :cond_0
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isIsHwEncodingEnabled()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 483
    invoke-virtual {v6}, Lco/vine/android/AbstractRecordingActivity;->makeSureUploadIsReady()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/RecordingPreviewFragment;->mUploadPath:Ljava/lang/String;

    .line 485
    :cond_1
    invoke-virtual {p0}, Lco/vine/android/RecordingPreviewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/RecordingPreviewFragment;->mUploadPath:Ljava/lang/String;

    iget-object v2, p0, Lco/vine/android/RecordingPreviewFragment;->mThumbnailPath:Ljava/lang/String;

    iget-object v3, p0, Lco/vine/android/RecordingPreviewFragment;->mVideoPath:Ljava/lang/String;

    const/4 v4, 0x0

    iget-boolean v5, p0, Lco/vine/android/RecordingPreviewFragment;->mIsFromSony:Z

    invoke-static/range {v0 .. v5}, Lco/vine/android/PostActivity;->getIntent(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)Landroid/content/Intent;

    move-result-object v7

    .line 487
    .local v7, "intent":Landroid/content/Intent;
    invoke-virtual {p0}, Lco/vine/android/RecordingPreviewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const/16 v1, 0x7c6

    invoke-virtual {v0, v7, v1}, Landroid/support/v4/app/FragmentActivity;->startActivityForResult(Landroid/content/Intent;I)V

    goto :goto_0
.end method

.method public uploadAndToPost()V
    .locals 8

    .prologue
    .line 462
    :try_start_0
    invoke-virtual {p0}, Lco/vine/android/RecordingPreviewFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lco/vine/android/AbstractRecordingActivity;

    .line 463
    .local v0, "activity":Lco/vine/android/AbstractRecordingActivity;
    if-nez v0, :cond_0

    .line 475
    .end local v0    # "activity":Lco/vine/android/AbstractRecordingActivity;
    :goto_0
    return-void

    .line 466
    .restart local v0    # "activity":Lco/vine/android/AbstractRecordingActivity;
    :cond_0
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isIsHwEncodingEnabled()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 467
    invoke-virtual {v0}, Lco/vine/android/AbstractRecordingActivity;->makeSureUploadIsReady()Ljava/lang/String;

    .line 469
    :cond_1
    iget-object v1, p0, Lco/vine/android/RecordingPreviewFragment;->mFinalFile:Lco/vine/android/recorder/RecordingFile;

    iget-object v2, p0, Lco/vine/android/RecordingPreviewFragment;->mThumbnailPath:Ljava/lang/String;

    iget-object v3, p0, Lco/vine/android/RecordingPreviewFragment;->mFinalFile:Lco/vine/android/recorder/RecordingFile;

    iget-object v3, v3, Lco/vine/android/recorder/RecordingFile;->folder:Ljava/io/File;

    invoke-virtual {v3}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v3

    iget-boolean v4, p0, Lco/vine/android/RecordingPreviewFragment;->mIsMessaging:Z

    iget-wide v5, p0, Lco/vine/android/RecordingPreviewFragment;->mConversationRowId:J

    invoke-static/range {v0 .. v6}, Lco/vine/android/util/UploadManager;->addToUploadQueue(Landroid/content/Context;Lco/vine/android/recorder/RecordingFile;Ljava/lang/String;Ljava/lang/String;ZJ)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/RecordingPreviewFragment;->mUploadPath:Ljava/lang/String;

    .line 471
    invoke-virtual {p0}, Lco/vine/android/RecordingPreviewFragment;->toPost()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 472
    .end local v0    # "activity":Lco/vine/android/AbstractRecordingActivity;
    :catch_0
    move-exception v7

    .line 473
    .local v7, "e":Ljava/lang/Exception;
    invoke-static {v7}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_0
.end method
