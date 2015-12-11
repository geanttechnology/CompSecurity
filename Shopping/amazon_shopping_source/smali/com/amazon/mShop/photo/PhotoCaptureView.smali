.class public Lcom/amazon/mShop/photo/PhotoCaptureView;
.super Landroid/widget/LinearLayout;
.source "PhotoCaptureView.java"

# interfaces
.implements Landroid/view/SurfaceHolder$Callback;
.implements Lcom/amazon/mShop/TitleProvider;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/photo/PhotoCaptureView$MyOrientationListener;,
        Lcom/amazon/mShop/photo/PhotoCaptureView$MyPictureCallbackJpeg;
    }
.end annotation


# instance fields
.field private mCamera:Landroid/hardware/Camera;

.field private mCancelButton:Landroid/widget/ImageButton;

.field private mIsCameraAutoFocusing:Z

.field private mIsPreviewRunning:Z

.field private mLastKnownOrientation:I

.field private mLastTimeCameraClicked:J

.field private final mOrientationListener:Lcom/amazon/mShop/photo/PhotoCaptureView$MyOrientationListener;

.field private final mPhotoCaptureActivity:Lcom/amazon/mShop/photo/PhotoCaptureActivity;

.field private mPhotoTaken:Z

.field private mSurfaceView:Landroid/view/SurfaceView;

.field private mTakeButton:Landroid/widget/ImageButton;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/photo/PhotoCaptureActivity;)V
    .locals 4
    .param p1, "activity"    # Lcom/amazon/mShop/photo/PhotoCaptureActivity;

    .prologue
    const/4 v1, 0x0

    .line 51
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 138
    iput-boolean v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mIsCameraAutoFocusing:Z

    .line 157
    iput-boolean v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mPhotoTaken:Z

    .line 354
    const-wide/16 v1, -0x1

    iput-wide v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mLastTimeCameraClicked:J

    .line 53
    iput-object p1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mPhotoCaptureActivity:Lcom/amazon/mShop/photo/PhotoCaptureActivity;

    .line 55
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->photo_capture_view:I

    const/4 v3, 0x1

    invoke-virtual {v1, v2, p0, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    .line 56
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->photo_capture_frame:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/photo/PhotoCaptureView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    .line 57
    .local v0, "photoCaptureFrame":Landroid/widget/FrameLayout;
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/photo/PhotoCaptureView;->inflateMoreView(Landroid/widget/FrameLayout;)Landroid/view/View;

    .line 58
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->photo_capture_button_layout:I

    invoke-virtual {v1, v2, v0}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 78
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->photo_capture_cancel:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/photo/PhotoCaptureView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageButton;

    iput-object v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mCancelButton:Landroid/widget/ImageButton;

    .line 79
    iget-object v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mCancelButton:Landroid/widget/ImageButton;

    new-instance v2, Lcom/amazon/mShop/photo/PhotoCaptureView$1;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/photo/PhotoCaptureView$1;-><init>(Lcom/amazon/mShop/photo/PhotoCaptureView;)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 87
    iget-object v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mCancelButton:Landroid/widget/ImageButton;

    new-instance v2, Lcom/amazon/mShop/photo/PhotoCaptureView$2;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/photo/PhotoCaptureView$2;-><init>(Lcom/amazon/mShop/photo/PhotoCaptureView;)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageButton;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 98
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->photo_capture_take:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/photo/PhotoCaptureView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageButton;

    iput-object v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mTakeButton:Landroid/widget/ImageButton;

    .line 99
    iget-object v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mTakeButton:Landroid/widget/ImageButton;

    new-instance v2, Lcom/amazon/mShop/photo/PhotoCaptureView$3;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/photo/PhotoCaptureView$3;-><init>(Lcom/amazon/mShop/photo/PhotoCaptureView;)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 107
    iget-object v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mTakeButton:Landroid/widget/ImageButton;

    new-instance v2, Lcom/amazon/mShop/photo/PhotoCaptureView$4;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/photo/PhotoCaptureView$4;-><init>(Lcom/amazon/mShop/photo/PhotoCaptureView;)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageButton;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 117
    iget-object v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mTakeButton:Landroid/widget/ImageButton;

    invoke-virtual {v1}, Landroid/widget/ImageButton;->requestFocus()Z

    .line 119
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->photo_capture_preview:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/photo/PhotoCaptureView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/view/SurfaceView;

    iput-object v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mSurfaceView:Landroid/view/SurfaceView;

    .line 120
    iget-object v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mSurfaceView:Landroid/view/SurfaceView;

    invoke-virtual {v1}, Landroid/view/SurfaceView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v1

    const/4 v2, 0x3

    invoke-interface {v1, v2}, Landroid/view/SurfaceHolder;->setType(I)V

    .line 121
    iget-object v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mSurfaceView:Landroid/view/SurfaceView;

    invoke-virtual {v1}, Landroid/view/SurfaceView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v1

    invoke-interface {v1, p0}, Landroid/view/SurfaceHolder;->addCallback(Landroid/view/SurfaceHolder$Callback;)V

    .line 123
    const/4 v1, -0x1

    iput v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mLastKnownOrientation:I

    .line 124
    new-instance v1, Lcom/amazon/mShop/photo/PhotoCaptureView$MyOrientationListener;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/photo/PhotoCaptureView$MyOrientationListener;-><init>(Lcom/amazon/mShop/photo/PhotoCaptureView;Lcom/amazon/mShop/photo/PhotoCaptureActivity;)V

    iput-object v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mOrientationListener:Lcom/amazon/mShop/photo/PhotoCaptureView$MyOrientationListener;

    .line 125
    iget-object v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mOrientationListener:Lcom/amazon/mShop/photo/PhotoCaptureView$MyOrientationListener;

    invoke-virtual {v1}, Lcom/amazon/mShop/photo/PhotoCaptureView$MyOrientationListener;->enable()V

    .line 127
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/photo/PhotoCaptureView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/photo/PhotoCaptureView;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/amazon/mShop/photo/PhotoCaptureView;->doCancelPhoto()V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/mShop/photo/PhotoCaptureView;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/photo/PhotoCaptureView;

    .prologue
    .line 37
    invoke-direct {p0}, Lcom/amazon/mShop/photo/PhotoCaptureView;->isCameraButtonClickable()Z

    move-result v0

    return v0
.end method

.method static synthetic access$202(Lcom/amazon/mShop/photo/PhotoCaptureView;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/photo/PhotoCaptureView;
    .param p1, "x1"    # Z

    .prologue
    .line 37
    iput-boolean p1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mIsCameraAutoFocusing:Z

    return p1
.end method

.method static synthetic access$400(Lcom/amazon/mShop/photo/PhotoCaptureView;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/photo/PhotoCaptureView;

    .prologue
    .line 37
    iget v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mLastKnownOrientation:I

    return v0
.end method

.method static synthetic access$402(Lcom/amazon/mShop/photo/PhotoCaptureView;I)I
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/photo/PhotoCaptureView;
    .param p1, "x1"    # I

    .prologue
    .line 37
    iput p1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mLastKnownOrientation:I

    return p1
.end method

.method static synthetic access$500(Lcom/amazon/mShop/photo/PhotoCaptureView;)Lcom/amazon/mShop/photo/PhotoCaptureActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/photo/PhotoCaptureView;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mPhotoCaptureActivity:Lcom/amazon/mShop/photo/PhotoCaptureActivity;

    return-object v0
.end method

.method private doCancelPhoto()V
    .locals 1

    .prologue
    .line 134
    iget-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mOrientationListener:Lcom/amazon/mShop/photo/PhotoCaptureView$MyOrientationListener;

    invoke-virtual {v0}, Lcom/amazon/mShop/photo/PhotoCaptureView$MyOrientationListener;->disable()V

    .line 135
    iget-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mPhotoCaptureActivity:Lcom/amazon/mShop/photo/PhotoCaptureActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/photo/PhotoCaptureActivity;->handleCancelPhoto()V

    .line 136
    return-void
.end method

.method private isCameraButtonClickable()Z
    .locals 7

    .prologue
    .line 359
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    .line 363
    .local v0, "currentelapsedRealtime":J
    iget-wide v3, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mLastTimeCameraClicked:J

    sub-long v3, v0, v3

    const-wide/16 v5, 0x3e8

    cmp-long v3, v3, v5

    if-gtz v3, :cond_0

    .line 364
    const/4 v2, 0x0

    .line 367
    .local v2, "retValue":Z
    :goto_0
    iput-wide v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mLastTimeCameraClicked:J

    .line 369
    return v2

    .line 366
    .end local v2    # "retValue":Z
    :cond_0
    const/4 v2, 0x1

    .restart local v2    # "retValue":Z
    goto :goto_0
.end method


# virtual methods
.method doAutoFocus(Z)V
    .locals 2
    .param p1, "needTakePhotoAfterAutoFocus"    # Z

    .prologue
    .line 140
    iget-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mCamera:Landroid/hardware/Camera;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mIsCameraAutoFocusing:Z

    if-nez v0, :cond_0

    .line 141
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mIsCameraAutoFocusing:Z

    .line 142
    iget-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mCamera:Landroid/hardware/Camera;

    new-instance v1, Lcom/amazon/mShop/photo/PhotoCaptureView$5;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/photo/PhotoCaptureView$5;-><init>(Lcom/amazon/mShop/photo/PhotoCaptureView;Z)V

    invoke-virtual {v0, v1}, Landroid/hardware/Camera;->autoFocus(Landroid/hardware/Camera$AutoFocusCallback;)V

    .line 155
    :cond_0
    return-void
.end method

.method doTakePhoto()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 159
    iget-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mCamera:Landroid/hardware/Camera;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mPhotoTaken:Z

    if-nez v0, :cond_0

    .line 160
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mPhotoTaken:Z

    .line 162
    iget-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mOrientationListener:Lcom/amazon/mShop/photo/PhotoCaptureView$MyOrientationListener;

    invoke-virtual {v0}, Lcom/amazon/mShop/photo/PhotoCaptureView$MyOrientationListener;->disable()V

    .line 165
    iget-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mSurfaceView:Landroid/view/SurfaceView;

    const/high16 v1, -0x1000000

    invoke-virtual {v0, v1}, Landroid/view/SurfaceView;->setBackgroundColor(I)V

    .line 166
    iget-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mCamera:Landroid/hardware/Camera;

    new-instance v1, Lcom/amazon/mShop/photo/PhotoCaptureView$MyPictureCallbackJpeg;

    invoke-direct {v1, p0, v2}, Lcom/amazon/mShop/photo/PhotoCaptureView$MyPictureCallbackJpeg;-><init>(Lcom/amazon/mShop/photo/PhotoCaptureView;Lcom/amazon/mShop/photo/PhotoCaptureView$1;)V

    invoke-virtual {v0, v2, v2, v1}, Landroid/hardware/Camera;->takePicture(Landroid/hardware/Camera$ShutterCallback;Landroid/hardware/Camera$PictureCallback;Landroid/hardware/Camera$PictureCallback;)V

    .line 176
    iget-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mTakeButton:Landroid/widget/ImageButton;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setEnabled(Z)V

    .line 178
    :cond_0
    return-void
.end method

.method public bridge synthetic getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 37
    invoke-virtual {p0}, Lcom/amazon/mShop/photo/PhotoCaptureView;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 2

    .prologue
    .line 186
    invoke-virtual {p0}, Lcom/amazon/mShop/photo/PhotoCaptureView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->photo_capture_view_title:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected inflateMoreView(Landroid/widget/FrameLayout;)Landroid/view/View;
    .locals 1
    .param p1, "photoFrame"    # Landroid/widget/FrameLayout;

    .prologue
    .line 351
    const/4 v0, 0x0

    return-object v0
.end method

.method release()V
    .locals 1

    .prologue
    .line 316
    iget-boolean v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mIsPreviewRunning:Z

    if-eqz v0, :cond_1

    .line 317
    iget-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mCamera:Landroid/hardware/Camera;

    if-eqz v0, :cond_0

    .line 318
    iget-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v0}, Landroid/hardware/Camera;->stopPreview()V

    .line 320
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mIsPreviewRunning:Z

    .line 323
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mCamera:Landroid/hardware/Camera;

    if-eqz v0, :cond_2

    .line 324
    iget-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v0}, Landroid/hardware/Camera;->release()V

    .line 325
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mCamera:Landroid/hardware/Camera;

    .line 328
    :cond_2
    iget-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mOrientationListener:Lcom/amazon/mShop/photo/PhotoCaptureView$MyOrientationListener;

    invoke-virtual {v0}, Lcom/amazon/mShop/photo/PhotoCaptureView$MyOrientationListener;->disable()V

    .line 329
    return-void
.end method

.method public surfaceChanged(Landroid/view/SurfaceHolder;III)V
    .locals 3
    .param p1, "holder"    # Landroid/view/SurfaceHolder;
    .param p2, "format"    # I
    .param p3, "width"    # I
    .param p4, "height"    # I

    .prologue
    .line 277
    iget-object v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mCamera:Landroid/hardware/Camera;

    if-nez v1, :cond_0

    .line 278
    const-string/jumbo v1, "PhotoCaptureView"

    const-string/jumbo v2, "Surface changed but no current camera!"

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 295
    :goto_0
    return-void

    .line 282
    :cond_0
    iget-boolean v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mIsPreviewRunning:Z

    if-eqz v1, :cond_1

    .line 283
    iget-object v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v1}, Landroid/hardware/Camera;->stopPreview()V

    .line 284
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mIsPreviewRunning:Z

    .line 288
    :cond_1
    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v1, p1}, Landroid/hardware/Camera;->setPreviewDisplay(Landroid/view/SurfaceHolder;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 293
    :goto_1
    iget-object v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v1}, Landroid/hardware/Camera;->startPreview()V

    .line 294
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mIsPreviewRunning:Z

    goto :goto_0

    .line 289
    :catch_0
    move-exception v0

    .line 290
    .local v0, "ex":Ljava/io/IOException;
    const-string/jumbo v1, "PhotoCaptureView"

    const-string/jumbo v2, "surfaceChanged: Failed with IOException"

    invoke-static {v1, v2, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1
.end method

.method public surfaceCreated(Landroid/view/SurfaceHolder;)V
    .locals 18
    .param p1, "surfaceHolder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 196
    :try_start_0
    invoke-static {}, Landroid/hardware/Camera;->open()Landroid/hardware/Camera;

    move-result-object v13

    move-object/from16 v0, p0

    iput-object v13, v0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mCamera:Landroid/hardware/Camera;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 204
    :goto_0
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mCamera:Landroid/hardware/Camera;

    if-nez v13, :cond_0

    .line 205
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mPhotoCaptureActivity:Lcom/amazon/mShop/photo/PhotoCaptureActivity;

    sget v14, Lcom/amazon/mShop/android/lib/R$string;->unavailablity_lack_rare_camera:I

    const/4 v15, 0x1

    invoke-static {v13, v14, v15}, Landroid/widget/Toast;->makeText(Landroid/content/Context;II)Landroid/widget/Toast;

    move-result-object v11

    .line 206
    .local v11, "toast":Landroid/widget/Toast;
    const/16 v13, 0x11

    const/4 v14, 0x0

    const/4 v15, 0x0

    invoke-virtual {v11, v13, v14, v15}, Landroid/widget/Toast;->setGravity(III)V

    .line 207
    invoke-virtual {v11}, Landroid/widget/Toast;->show()V

    .line 208
    invoke-direct/range {p0 .. p0}, Lcom/amazon/mShop/photo/PhotoCaptureView;->doCancelPhoto()V

    .line 272
    .end local v11    # "toast":Landroid/widget/Toast;
    :goto_1
    return-void

    .line 197
    :catch_0
    move-exception v4

    .line 198
    .local v4, "e":Ljava/lang/Exception;
    const-string/jumbo v13, "PhotoCaptureView"

    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v15, "Cannot open camera : "

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v14

    invoke-static {v13, v14}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 199
    const/4 v13, 0x0

    move-object/from16 v0, p0

    iput-object v13, v0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mCamera:Landroid/hardware/Camera;

    goto :goto_0

    .line 212
    .end local v4    # "e":Ljava/lang/Exception;
    :cond_0
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v13}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v7

    .line 218
    .local v7, "parameters":Landroid/hardware/Camera$Parameters;
    const-string/jumbo v13, "picture-format-values"

    invoke-virtual {v7, v13}, Landroid/hardware/Camera$Parameters;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 219
    .local v8, "pictureFormatValues":Ljava/lang/String;
    invoke-static {v8}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v13

    if-nez v13, :cond_1

    const-string/jumbo v13, "jpeg"

    invoke-virtual {v8, v13}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v13

    if-eqz v13, :cond_1

    .line 220
    const/16 v13, 0x100

    invoke-virtual {v7, v13}, Landroid/hardware/Camera$Parameters;->setPictureFormat(I)V

    .line 225
    :cond_1
    sget-object v13, Landroid/os/Build$VERSION;->SDK:Ljava/lang/String;

    invoke-static {v13}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v13

    const/4 v14, 0x5

    if-lt v13, v14, :cond_2

    .line 227
    :try_start_1
    const-class v13, Landroid/hardware/Camera$Parameters;

    const-string/jumbo v14, "FLASH_MODE_AUTO"

    invoke-virtual {v13, v14}, Ljava/lang/Class;->getField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v5

    .line 228
    .local v5, "field":Ljava/lang/reflect/Field;
    const-class v13, Landroid/hardware/Camera$Parameters;

    const-string/jumbo v14, "setFlashMode"

    const/4 v15, 0x1

    new-array v15, v15, [Ljava/lang/Class;

    const/16 v16, 0x0

    const-class v17, Ljava/lang/String;

    aput-object v17, v15, v16

    invoke-virtual {v13, v14, v15}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v6

    .line 229
    .local v6, "m":Ljava/lang/reflect/Method;
    if-eqz v6, :cond_2

    if-eqz v5, :cond_2

    .line 230
    const/4 v13, 0x1

    new-array v13, v13, [Ljava/lang/Object;

    const/4 v14, 0x0

    const/4 v15, 0x0

    invoke-virtual {v5, v15}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v15

    aput-object v15, v13, v14

    invoke-virtual {v6, v7, v13}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catch Ljava/lang/SecurityException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/lang/NoSuchMethodException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Ljava/lang/NoSuchFieldException; {:try_start_1 .. :try_end_1} :catch_4
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_5
    .catch Ljava/lang/IllegalAccessException; {:try_start_1 .. :try_end_1} :catch_6
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_1 .. :try_end_1} :catch_7

    .line 248
    .end local v5    # "field":Ljava/lang/reflect/Field;
    .end local v6    # "m":Ljava/lang/reflect/Method;
    :cond_2
    :goto_2
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/photo/PhotoCaptureView;->getContext()Landroid/content/Context;

    move-result-object v13

    const-string/jumbo v14, "window"

    invoke-virtual {v13, v14}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Landroid/view/WindowManager;

    invoke-interface {v13}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v3

    .line 249
    .local v3, "display":Landroid/view/Display;
    invoke-virtual {v3}, Landroid/view/Display;->getWidth()I

    move-result v10

    .line 250
    .local v10, "screenWidth":I
    invoke-virtual {v3}, Landroid/view/Display;->getHeight()I

    move-result v9

    .line 251
    .local v9, "screenHeight":I
    invoke-virtual {v7}, Landroid/hardware/Camera$Parameters;->getSupportedPreviewSizes()Ljava/util/List;

    move-result-object v13

    const/4 v14, 0x0

    invoke-static {v13, v10, v9, v14}, Lcom/amazon/mShop/util/CameraUtils;->getBestMatchedSize(Ljava/util/List;IIZ)Landroid/hardware/Camera$Size;

    move-result-object v2

    .line 252
    .local v2, "bestMatchedPreviewSize":Landroid/hardware/Camera$Size;
    if-eqz v2, :cond_3

    .line 253
    iget v13, v2, Landroid/hardware/Camera$Size;->width:I

    iget v14, v2, Landroid/hardware/Camera$Size;->height:I

    invoke-virtual {v7, v13, v14}, Landroid/hardware/Camera$Parameters;->setPreviewSize(II)V

    .line 261
    :cond_3
    invoke-static {}, Lcom/amazon/mShop/util/JpegUtils;->computeWidthAndHeightForMyRawJpegImage()[I

    move-result-object v12

    .line 262
    .local v12, "widthAndHeight":[I
    invoke-virtual {v7}, Landroid/hardware/Camera$Parameters;->getSupportedPictureSizes()Ljava/util/List;

    move-result-object v13

    const/4 v14, 0x0

    aget v14, v12, v14

    const/4 v15, 0x1

    aget v15, v12, v15

    const/16 v16, 0x1

    invoke-static/range {v13 .. v16}, Lcom/amazon/mShop/util/CameraUtils;->getBestMatchedSize(Ljava/util/List;IIZ)Landroid/hardware/Camera$Size;

    move-result-object v1

    .line 263
    .local v1, "bestMatchedPictureSize":Landroid/hardware/Camera$Size;
    if-eqz v1, :cond_4

    .line 264
    iget v13, v1, Landroid/hardware/Camera$Size;->width:I

    iget v14, v1, Landroid/hardware/Camera$Size;->height:I

    invoke-virtual {v7, v13, v14}, Landroid/hardware/Camera$Parameters;->setPictureSize(II)V

    .line 268
    :cond_4
    :try_start_2
    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/amazon/mShop/photo/PhotoCaptureView;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v13, v7}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V
    :try_end_2
    .catch Ljava/lang/RuntimeException; {:try_start_2 .. :try_end_2} :catch_1

    goto/16 :goto_1

    .line 269
    :catch_1
    move-exception v4

    .line 270
    .local v4, "e":Ljava/lang/RuntimeException;
    const-string/jumbo v13, "PhotoCaptureView"

    const-string/jumbo v14, "Camera parameters setting is invalid or not supported!"

    invoke-static {v13, v14}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_1

    .line 232
    .end local v1    # "bestMatchedPictureSize":Landroid/hardware/Camera$Size;
    .end local v2    # "bestMatchedPreviewSize":Landroid/hardware/Camera$Size;
    .end local v3    # "display":Landroid/view/Display;
    .end local v4    # "e":Ljava/lang/RuntimeException;
    .end local v9    # "screenHeight":I
    .end local v10    # "screenWidth":I
    .end local v12    # "widthAndHeight":[I
    :catch_2
    move-exception v4

    .line 233
    .local v4, "e":Ljava/lang/SecurityException;
    const-string/jumbo v13, "PhotoCaptureView"

    const-string/jumbo v14, "Something wrong(SecurityException) setting flashMode"

    invoke-static {v13, v14, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_2

    .line 234
    .end local v4    # "e":Ljava/lang/SecurityException;
    :catch_3
    move-exception v4

    .line 235
    .local v4, "e":Ljava/lang/NoSuchMethodException;
    const-string/jumbo v13, "PhotoCaptureView"

    const-string/jumbo v14, "Something wrong(NoSuchMethodException) setting flashMode"

    invoke-static {v13, v14, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_2

    .line 236
    .end local v4    # "e":Ljava/lang/NoSuchMethodException;
    :catch_4
    move-exception v4

    .line 237
    .local v4, "e":Ljava/lang/NoSuchFieldException;
    const-string/jumbo v13, "PhotoCaptureView"

    const-string/jumbo v14, "Something wrong(NoSuchFieldException) setting flashMode"

    invoke-static {v13, v14, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_2

    .line 238
    .end local v4    # "e":Ljava/lang/NoSuchFieldException;
    :catch_5
    move-exception v4

    .line 239
    .local v4, "e":Ljava/lang/IllegalArgumentException;
    const-string/jumbo v13, "PhotoCaptureView"

    const-string/jumbo v14, "Something wrong(IllegalArgumentException) setting flashMode"

    invoke-static {v13, v14, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto/16 :goto_2

    .line 240
    .end local v4    # "e":Ljava/lang/IllegalArgumentException;
    :catch_6
    move-exception v4

    .line 241
    .local v4, "e":Ljava/lang/IllegalAccessException;
    const-string/jumbo v13, "PhotoCaptureView"

    const-string/jumbo v14, "Something wrong(IllegalAccessException) setting flashMode"

    invoke-static {v13, v14, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto/16 :goto_2

    .line 242
    .end local v4    # "e":Ljava/lang/IllegalAccessException;
    :catch_7
    move-exception v4

    .line 243
    .local v4, "e":Ljava/lang/reflect/InvocationTargetException;
    const-string/jumbo v13, "PhotoCaptureView"

    const-string/jumbo v14, "Something wrong(InvocationTargetException) setting flashMode"

    invoke-static {v13, v14, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto/16 :goto_2
.end method

.method public surfaceDestroyed(Landroid/view/SurfaceHolder;)V
    .locals 0
    .param p1, "surfaceHolder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 299
    invoke-virtual {p0}, Lcom/amazon/mShop/photo/PhotoCaptureView;->release()V

    .line 300
    return-void
.end method
