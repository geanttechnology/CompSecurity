.class public Lco/vine/android/DraftFragment;
.super Lco/vine/android/BaseFragment;
.source "DraftFragment.java"

# interfaces
.implements Lco/vine/android/player/VideoViewInterface$OnPreparedListener;
.implements Lco/vine/android/player/VideoViewInterface$OnErrorListener;
.implements Lco/vine/android/player/SdkVideoView$SurfaceReadyListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/DraftFragment$DraftPageViewHolder;
    }
.end annotation


# static fields
.field private static final VISIBILITY_DELAY:I = 0x64


# instance fields
.field private mBitmap:Landroid/graphics/Bitmap;

.field public mCanUnhide:Z

.field private mDimen:I

.field private mExpired:Z

.field private mFadeIn:Landroid/view/animation/Animation;

.field private mFolder:Ljava/io/File;

.field private mHolder:Lco/vine/android/DraftFragment$DraftPageViewHolder;

.field private mIndex:I

.field private mListener:Landroid/view/View$OnClickListener;

.field private mProgress:I

.field private mQuickFadeOut:Landroid/view/animation/Animation;

.field private mSelected:Z

.field private final mStartPlayingRunnable:Ljava/lang/Runnable;

.field private mThumbUrl:Ljava/lang/String;

.field private mVideoUrl:Ljava/lang/String;

.field private mVideoView:Lco/vine/android/player/SdkVideoView;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 84
    invoke-direct {p0}, Lco/vine/android/BaseFragment;-><init>()V

    .line 47
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/DraftFragment;->mCanUnhide:Z

    .line 49
    new-instance v0, Lco/vine/android/DraftFragment$1;

    invoke-direct {v0, p0}, Lco/vine/android/DraftFragment$1;-><init>(Lco/vine/android/DraftFragment;)V

    iput-object v0, p0, Lco/vine/android/DraftFragment;->mStartPlayingRunnable:Ljava/lang/Runnable;

    .line 86
    return-void
.end method

.method public constructor <init>(ZILjava/lang/String;Ljava/lang/String;Ljava/io/File;II)V
    .locals 1
    .param p1, "selected"    # Z
    .param p2, "index"    # I
    .param p3, "videoUrl"    # Ljava/lang/String;
    .param p4, "thumbUrl"    # Ljava/lang/String;
    .param p5, "folder"    # Ljava/io/File;
    .param p6, "progress"    # I
    .param p7, "dimension"    # I

    .prologue
    .line 100
    invoke-direct {p0}, Lco/vine/android/BaseFragment;-><init>()V

    .line 47
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/DraftFragment;->mCanUnhide:Z

    .line 49
    new-instance v0, Lco/vine/android/DraftFragment$1;

    invoke-direct {v0, p0}, Lco/vine/android/DraftFragment$1;-><init>(Lco/vine/android/DraftFragment;)V

    iput-object v0, p0, Lco/vine/android/DraftFragment;->mStartPlayingRunnable:Ljava/lang/Runnable;

    .line 101
    iput p2, p0, Lco/vine/android/DraftFragment;->mIndex:I

    .line 102
    iput-boolean p1, p0, Lco/vine/android/DraftFragment;->mSelected:Z

    .line 103
    iput-object p3, p0, Lco/vine/android/DraftFragment;->mVideoUrl:Ljava/lang/String;

    .line 104
    iput-object p5, p0, Lco/vine/android/DraftFragment;->mFolder:Ljava/io/File;

    .line 105
    iput p6, p0, Lco/vine/android/DraftFragment;->mProgress:I

    .line 106
    iput-object p4, p0, Lco/vine/android/DraftFragment;->mThumbUrl:Ljava/lang/String;

    .line 107
    iput p7, p0, Lco/vine/android/DraftFragment;->mDimen:I

    .line 108
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/DraftFragment;->mExpired:Z

    .line 109
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/DraftFragment;)Lco/vine/android/player/SdkVideoView;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/DraftFragment;

    .prologue
    .line 28
    iget-object v0, p0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    return-object v0
.end method

.method private onSelected()V
    .locals 0

    .prologue
    .line 234
    invoke-virtual {p0}, Lco/vine/android/DraftFragment;->resumePlayer()V

    .line 235
    return-void
.end method

.method private onUnselected()V
    .locals 1

    .prologue
    .line 230
    iget-object v0, p0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->pause()V

    .line 231
    return-void
.end method


# virtual methods
.method public getProgressView()Landroid/view/View;
    .locals 1

    .prologue
    .line 140
    iget-object v0, p0, Lco/vine/android/DraftFragment;->mHolder:Lco/vine/android/DraftFragment$DraftPageViewHolder;

    iget-object v0, v0, Lco/vine/android/DraftFragment$DraftPageViewHolder;->progressView:Lco/vine/android/recorder/ProgressView;

    return-object v0
.end method

.method public getThumbnailView()Landroid/view/View;
    .locals 1

    .prologue
    .line 144
    iget-object v0, p0, Lco/vine/android/DraftFragment;->mHolder:Lco/vine/android/DraftFragment$DraftPageViewHolder;

    iget-object v0, v0, Lco/vine/android/DraftFragment$DraftPageViewHolder;->thumb:Landroid/widget/ImageView;

    return-object v0
.end method

.method public isExpired()Z
    .locals 1

    .prologue
    .line 264
    iget-boolean v0, p0, Lco/vine/android/DraftFragment;->mExpired:Z

    return v0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 17
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "root"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 150
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/DraftFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    .line 151
    .local v9, "res":Landroid/content/res/Resources;
    const v13, 0x7f030036

    const/4 v14, 0x0

    move-object/from16 v0, p1

    move-object/from16 v1, p2

    invoke-virtual {v0, v13, v1, v14}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v11

    .line 152
    .local v11, "v":Landroid/view/View;
    new-instance v4, Lco/vine/android/DraftFragment$DraftPageViewHolder;

    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/DraftFragment;->mVideoUrl:Ljava/lang/String;

    invoke-direct {v4, v11, v13}, Lco/vine/android/DraftFragment$DraftPageViewHolder;-><init>(Landroid/view/View;Ljava/lang/String;)V

    .line 153
    .local v4, "holder":Lco/vine/android/DraftFragment$DraftPageViewHolder;
    const v13, 0x7f0b006a

    invoke-virtual {v9, v13}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v7

    .line 154
    .local v7, "progressHeight":I
    const v13, 0x7f0b0033

    invoke-virtual {v9, v13}, Landroid/content/res/Resources;->getDimensionPixelOffset(I)I

    move-result v3

    .line 156
    .local v3, "draftProgressHeight":I
    iget-object v13, v4, Lco/vine/android/DraftFragment$DraftPageViewHolder;->draftContainer:Landroid/widget/RelativeLayout;

    invoke-virtual {v13}, Landroid/widget/RelativeLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v2

    check-cast v2, Landroid/widget/RelativeLayout$LayoutParams;

    .line 158
    .local v2, "containerParams":Landroid/widget/RelativeLayout$LayoutParams;
    add-int v13, v7, v3

    iput v13, v2, Landroid/widget/RelativeLayout$LayoutParams;->topMargin:I

    .line 159
    iget-object v13, v4, Lco/vine/android/DraftFragment$DraftPageViewHolder;->draftContainer:Landroid/widget/RelativeLayout;

    invoke-virtual {v13, v2}, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 161
    const v13, 0x7f0a00d6

    invoke-virtual {v11, v13}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v12

    check-cast v12, Landroid/widget/RelativeLayout;

    .line 163
    .local v12, "videoContainer":Landroid/widget/RelativeLayout;
    const/4 v13, 0x1

    invoke-virtual {v12, v13}, Landroid/widget/RelativeLayout;->setDrawingCacheEnabled(Z)V

    .line 165
    invoke-virtual {v12}, Landroid/widget/RelativeLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v6

    .line 166
    .local v6, "params":Landroid/view/ViewGroup$LayoutParams;
    move-object/from16 v0, p0

    iget v13, v0, Lco/vine/android/DraftFragment;->mDimen:I

    iput v13, v6, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 167
    move-object/from16 v0, p0

    iget v13, v0, Lco/vine/android/DraftFragment;->mDimen:I

    iput v13, v6, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 168
    invoke-virtual {v12, v6}, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 169
    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/DraftFragment;->mFolder:Ljava/io/File;

    invoke-virtual {v12, v13}, Landroid/widget/RelativeLayout;->setTag(Ljava/lang/Object;)V

    .line 171
    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/DraftFragment;->mListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v12, v13}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 174
    iget-object v13, v4, Lco/vine/android/DraftFragment$DraftPageViewHolder;->progressView:Lco/vine/android/recorder/ProgressView;

    invoke-virtual {v13}, Lco/vine/android/recorder/ProgressView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v8

    .line 175
    .local v8, "progressLayoutParams":Landroid/view/ViewGroup$LayoutParams;
    move-object/from16 v0, p0

    iget v13, v0, Lco/vine/android/DraftFragment;->mDimen:I

    iput v13, v8, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 176
    iget-object v13, v4, Lco/vine/android/DraftFragment$DraftPageViewHolder;->progressView:Lco/vine/android/recorder/ProgressView;

    invoke-virtual {v13, v8}, Lco/vine/android/recorder/ProgressView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 178
    iget-object v13, v4, Lco/vine/android/DraftFragment$DraftPageViewHolder;->progressView:Lco/vine/android/recorder/ProgressView;

    move-object/from16 v0, p0

    iget v14, v0, Lco/vine/android/DraftFragment;->mProgress:I

    int-to-float v14, v14

    const v15, 0x45bb8000    # 6000.0f

    div-float/2addr v14, v15

    invoke-virtual {v13, v14}, Lco/vine/android/recorder/ProgressView;->setProgressRatio(F)V

    .line 180
    const v13, 0x7f0a00d4

    invoke-virtual {v11, v13}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    .line 182
    .local v5, "mask":Landroid/view/View;
    invoke-virtual {v5}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v6

    .line 183
    move-object/from16 v0, p0

    iget v13, v0, Lco/vine/android/DraftFragment;->mDimen:I

    iput v13, v6, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 184
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/DraftFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v13

    check-cast v13, Lco/vine/android/AbstractRecordingActivity;

    invoke-virtual {v13}, Lco/vine/android/AbstractRecordingActivity;->getScreenSize()Landroid/graphics/Point;

    move-result-object v13

    iget v13, v13, Landroid/graphics/Point;->y:I

    iput v13, v6, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 186
    invoke-virtual {v5, v6}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 188
    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/DraftFragment;->mThumbUrl:Ljava/lang/String;

    invoke-static {v13}, Landroid/graphics/BitmapFactory;->decodeFile(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v13

    move-object/from16 v0, p0

    iput-object v13, v0, Lco/vine/android/DraftFragment;->mBitmap:Landroid/graphics/Bitmap;

    .line 190
    iget-object v13, v4, Lco/vine/android/DraftFragment$DraftPageViewHolder;->thumb:Landroid/widget/ImageView;

    invoke-virtual {v13}, Landroid/widget/ImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v10

    .line 191
    .local v10, "thumbLayoutParams":Landroid/view/ViewGroup$LayoutParams;
    move-object/from16 v0, p0

    iget v13, v0, Lco/vine/android/DraftFragment;->mDimen:I

    iput v13, v10, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 192
    move-object/from16 v0, p0

    iget v13, v0, Lco/vine/android/DraftFragment;->mDimen:I

    iput v13, v10, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 193
    iget-object v13, v4, Lco/vine/android/DraftFragment$DraftPageViewHolder;->thumb:Landroid/widget/ImageView;

    invoke-virtual {v13, v10}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 194
    iget-object v13, v4, Lco/vine/android/DraftFragment$DraftPageViewHolder;->thumb:Landroid/widget/ImageView;

    new-instance v14, Lco/vine/android/drawable/RecyclableBitmapDrawable;

    invoke-virtual/range {p0 .. p0}, Lco/vine/android/DraftFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v15

    invoke-virtual {v15}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/DraftFragment;->mBitmap:Landroid/graphics/Bitmap;

    move-object/from16 v16, v0

    invoke-direct/range {v14 .. v16}, Lco/vine/android/drawable/RecyclableBitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-virtual {v13, v14}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 195
    iget-object v13, v4, Lco/vine/android/DraftFragment$DraftPageViewHolder;->thumb:Landroid/widget/ImageView;

    const/4 v14, 0x0

    invoke-virtual {v13, v14}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 197
    move-object/from16 v0, p0

    iput-object v4, v0, Lco/vine/android/DraftFragment;->mHolder:Lco/vine/android/DraftFragment$DraftPageViewHolder;

    .line 198
    iget-object v13, v4, Lco/vine/android/DraftFragment$DraftPageViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    move-object/from16 v0, p0

    iput-object v13, v0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    .line 200
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/DraftFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v13

    check-cast v13, Lco/vine/android/AbstractRecordingActivity;

    move-object/from16 v0, p0

    iget-object v14, v0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v13, v14}, Lco/vine/android/AbstractRecordingActivity;->addPlayerToPool(Lco/vine/android/player/SdkVideoView;)V

    .line 201
    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    move-object/from16 v0, p0

    invoke-virtual {v13, v0}, Lco/vine/android/player/SdkVideoView;->setOnPreparedListener(Lco/vine/android/player/VideoViewInterface$OnPreparedListener;)V

    .line 202
    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    const/4 v14, 0x1

    invoke-virtual {v13, v14}, Lco/vine/android/player/SdkVideoView;->setKeepScreenOn(Z)V

    .line 203
    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    const/4 v14, 0x1

    invoke-virtual {v13, v14}, Lco/vine/android/player/SdkVideoView;->setLooping(Z)V

    .line 204
    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    move-object/from16 v0, p0

    invoke-virtual {v13, v0}, Lco/vine/android/player/SdkVideoView;->setOnErrorListener(Lco/vine/android/player/VideoViewInterface$OnErrorListener;)V

    .line 205
    move-object/from16 v0, p0

    iget-object v13, v0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    move-object/from16 v0, p0

    invoke-virtual {v13, v0}, Lco/vine/android/player/SdkVideoView;->setSurfaceReadyListener(Lco/vine/android/player/SdkVideoView$SurfaceReadyListener;)V

    .line 207
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/DraftFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v13

    const v14, 0x7f04000d

    invoke-static {v13, v14}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v13

    move-object/from16 v0, p0

    iput-object v13, v0, Lco/vine/android/DraftFragment;->mFadeIn:Landroid/view/animation/Animation;

    .line 208
    invoke-virtual/range {p0 .. p0}, Lco/vine/android/DraftFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v13

    const v14, 0x7f040013

    invoke-static {v13, v14}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v13

    move-object/from16 v0, p0

    iput-object v13, v0, Lco/vine/android/DraftFragment;->mQuickFadeOut:Landroid/view/animation/Animation;

    .line 210
    const/4 v13, 0x1

    invoke-virtual {v11, v13}, Landroid/view/View;->setDrawingCacheEnabled(Z)V

    .line 211
    const/high16 v13, 0x100000

    invoke-virtual {v11, v13}, Landroid/view/View;->setDrawingCacheQuality(I)V

    .line 213
    return-object v11
.end method

.method public onDestroyView()V
    .locals 1

    .prologue
    .line 125
    invoke-super {p0}, Lco/vine/android/BaseFragment;->onDestroyView()V

    .line 126
    iget-object v0, p0, Lco/vine/android/DraftFragment;->mBitmap:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_0

    .line 127
    iget-object v0, p0, Lco/vine/android/DraftFragment;->mBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    .line 129
    :cond_0
    iget-object v0, p0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    if-eqz v0, :cond_1

    .line 130
    iget-object v0, p0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->suspend()V

    .line 132
    :cond_1
    return-void
.end method

.method public onError(Lco/vine/android/player/VideoViewInterface;II)Z
    .locals 3
    .param p1, "view"    # Lco/vine/android/player/VideoViewInterface;
    .param p2, "what"    # I
    .param p3, "extra"    # I

    .prologue
    .line 269
    invoke-virtual {p0}, Lco/vine/android/DraftFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lco/vine/android/AbstractRecordingActivity;

    .line 270
    .local v0, "activity":Lco/vine/android/AbstractRecordingActivity;
    if-eqz v0, :cond_0

    .line 271
    iget-object v1, p0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v0, v1}, Lco/vine/android/AbstractRecordingActivity;->releaseOtherPlayers(Lco/vine/android/player/SdkVideoView;)V

    .line 272
    iget-object v1, p0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lco/vine/android/player/SdkVideoView;->retryOpenVideo(Z)Z

    .line 274
    :cond_0
    const/4 v1, 0x1

    return v1
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 117
    invoke-super {p0}, Lco/vine/android/BaseFragment;->onPause()V

    .line 118
    iget-object v0, p0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    if-eqz v0, :cond_0

    .line 119
    iget-object v0, p0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->pause()V

    .line 121
    :cond_0
    return-void
.end method

.method public onPrepared(Lco/vine/android/player/VideoViewInterface;)V
    .locals 4
    .param p1, "view"    # Lco/vine/android/player/VideoViewInterface;

    .prologue
    .line 253
    iget-boolean v0, p0, Lco/vine/android/DraftFragment;->mSelected:Z

    if-eqz v0, :cond_0

    invoke-interface {p1}, Lco/vine/android/player/VideoViewInterface;->isPlaying()Z

    move-result v0

    if-nez v0, :cond_0

    .line 254
    invoke-interface {p1}, Lco/vine/android/player/VideoViewInterface;->start()V

    .line 255
    iget-object v0, p0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    iget-object v1, p0, Lco/vine/android/DraftFragment;->mStartPlayingRunnable:Ljava/lang/Runnable;

    const-wide/16 v2, 0x64

    invoke-virtual {v0, v1, v2, v3}, Lco/vine/android/player/SdkVideoView;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 257
    :cond_0
    return-void
.end method

.method public onSurfaceTextureAvailable(Lco/vine/android/player/SdkVideoView;)V
    .locals 1
    .param p1, "videoView"    # Lco/vine/android/player/SdkVideoView;

    .prologue
    .line 61
    const/4 v0, 0x4

    invoke-virtual {p1, v0}, Lco/vine/android/player/SdkVideoView;->setVisibility(I)V

    .line 62
    iget-object v0, p0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->startOpenVideo()V

    .line 63
    return-void
.end method

.method public pausePlayer()V
    .locals 1

    .prologue
    .line 278
    iget-boolean v0, p0, Lco/vine/android/DraftFragment;->mSelected:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->canPause()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 279
    iget-object v0, p0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->pause()V

    .line 281
    :cond_0
    return-void
.end method

.method public release()V
    .locals 1

    .prologue
    .line 226
    iget-object v0, p0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->suspend()V

    .line 227
    return-void
.end method

.method public resumePlayer()V
    .locals 2

    .prologue
    .line 238
    iget-object v0, p0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->isInPlaybackState()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    iget-object v1, p0, Lco/vine/android/DraftFragment;->mVideoUrl:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lco/vine/android/player/SdkVideoView;->isPathPlaying(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 239
    iget-object v0, p0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->start()V

    .line 249
    :goto_0
    return-void

    .line 241
    :cond_0
    iget-object v0, p0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    invoke-virtual {v0}, Lco/vine/android/player/SdkVideoView;->isSurfaceReady()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 242
    iget-object v0, p0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Lco/vine/android/player/SdkVideoView;->setVisibility(I)V

    .line 243
    iget-object v0, p0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    iget-object v1, p0, Lco/vine/android/DraftFragment;->mVideoUrl:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lco/vine/android/player/SdkVideoView;->setVideoPath(Ljava/lang/String;)V

    goto :goto_0

    .line 245
    :cond_1
    iget-object v0, p0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    iget-object v1, p0, Lco/vine/android/DraftFragment;->mVideoUrl:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lco/vine/android/player/SdkVideoView;->setVideoPath(Ljava/lang/String;)V

    .line 246
    iget-object v0, p0, Lco/vine/android/DraftFragment;->mVideoView:Lco/vine/android/player/SdkVideoView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lco/vine/android/player/SdkVideoView;->setVisibility(I)V

    goto :goto_0
.end method

.method public setExpired(Z)V
    .locals 0
    .param p1, "expired"    # Z

    .prologue
    .line 260
    iput-boolean p1, p0, Lco/vine/android/DraftFragment;->mExpired:Z

    .line 261
    return-void
.end method

.method public setListener(Landroid/view/View$OnClickListener;)V
    .locals 0
    .param p1, "listener"    # Landroid/view/View$OnClickListener;

    .prologue
    .line 112
    iput-object p1, p0, Lco/vine/android/DraftFragment;->mListener:Landroid/view/View$OnClickListener;

    .line 113
    return-void
.end method

.method public setSelected(Z)V
    .locals 0
    .param p1, "selected"    # Z

    .prologue
    .line 217
    iput-boolean p1, p0, Lco/vine/android/DraftFragment;->mSelected:Z

    .line 218
    if-eqz p1, :cond_0

    .line 219
    invoke-direct {p0}, Lco/vine/android/DraftFragment;->onSelected()V

    .line 223
    :goto_0
    return-void

    .line 221
    :cond_0
    invoke-direct {p0}, Lco/vine/android/DraftFragment;->onUnselected()V

    goto :goto_0
.end method

.method public showImage()V
    .locals 2

    .prologue
    .line 135
    iget-object v0, p0, Lco/vine/android/DraftFragment;->mHolder:Lco/vine/android/DraftFragment$DraftPageViewHolder;

    iget-object v0, v0, Lco/vine/android/DraftFragment$DraftPageViewHolder;->thumb:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 136
    iget-object v0, p0, Lco/vine/android/DraftFragment;->mHolder:Lco/vine/android/DraftFragment$DraftPageViewHolder;

    iget-object v0, v0, Lco/vine/android/DraftFragment$DraftPageViewHolder;->videoView:Lco/vine/android/player/SdkVideoView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lco/vine/android/player/SdkVideoView;->setVisibility(I)V

    .line 137
    return-void
.end method
