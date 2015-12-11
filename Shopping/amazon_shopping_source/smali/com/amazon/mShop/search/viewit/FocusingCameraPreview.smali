.class public Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;
.super Lcom/amazon/mShop/search/viewit/CameraPreview;
.source "FocusingCameraPreview.java"


# instance fields
.field private mFocusMode:Ljava/lang/String;

.field private mFocusing:Z

.field private mFramesTilNextFocus:I

.field private mLastFocus:Ljava/util/Date;

.field private mSupportsContinuousFocus:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 33
    invoke-direct {p0, p1}, Lcom/amazon/mShop/search/viewit/CameraPreview;-><init>(Landroid/content/Context;)V

    .line 29
    const-string/jumbo v0, "auto"

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mFocusMode:Ljava/lang/String;

    .line 30
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mSupportsContinuousFocus:Z

    .line 34
    return-void
.end method

.method static synthetic access$002(Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;
    .param p1, "x1"    # Z

    .prologue
    .line 17
    iput-boolean p1, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mFocusing:Z

    return p1
.end method

.method static synthetic access$102(Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;I)I
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;
    .param p1, "x1"    # I

    .prologue
    .line 17
    iput p1, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mFramesTilNextFocus:I

    return p1
.end method

.method static synthetic access$202(Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;Ljava/util/Date;)Ljava/util/Date;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;
    .param p1, "x1"    # Ljava/util/Date;

    .prologue
    .line 17
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mLastFocus:Ljava/util/Date;

    return-object p1
.end method

.method static synthetic access$300(Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;

    .prologue
    .line 17
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mSupportsContinuousFocus:Z

    return v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;

    .prologue
    .line 17
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->setFocusArea()V

    return-void
.end method

.method private checkFocus()V
    .locals 4

    .prologue
    .line 43
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mSupportsContinuousFocus:Z

    if-nez v0, :cond_1

    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mFocusing:Z

    if-nez v0, :cond_1

    iget v0, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mFramesTilNextFocus:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mFramesTilNextFocus:I

    if-gez v0, :cond_1

    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mLastFocus:Ljava/util/Date;

    if-eqz v0, :cond_0

    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    move-result-wide v0

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mLastFocus:Ljava/util/Date;

    invoke-virtual {v2}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    sub-long/2addr v0, v2

    const-wide/16 v2, 0xbb8

    cmp-long v0, v0, v2

    if-lez v0, :cond_1

    .line 44
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->focus()V

    .line 46
    :cond_1
    return-void
.end method

.method private focus()V
    .locals 5

    .prologue
    .line 49
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mCamera:Landroid/hardware/Camera;

    if-nez v2, :cond_0

    .line 91
    :goto_0
    return-void

    .line 52
    :cond_0
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mFocusing:Z

    .line 54
    :try_start_0
    iget-boolean v2, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mSupportsContinuousFocus:Z

    if-eqz v2, :cond_1

    .line 55
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v2}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v1

    .line 56
    .local v1, "parameters":Landroid/hardware/Camera$Parameters;
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mFocusMode:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/hardware/Camera$Parameters;->setFocusMode(Ljava/lang/String;)V

    .line 57
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v2, v1}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V

    .line 60
    .end local v1    # "parameters":Landroid/hardware/Camera$Parameters;
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mCamera:Landroid/hardware/Camera;

    new-instance v3, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview$1;

    invoke-direct {v3, p0}, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview$1;-><init>(Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;)V

    invoke-virtual {v2, v3}, Landroid/hardware/Camera;->autoFocus(Landroid/hardware/Camera$AutoFocusCallback;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 86
    :catch_0
    move-exception v0

    .line 88
    .local v0, "e":Ljava/lang/Exception;
    const-string/jumbo v2, "FocusingCameraPreview"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "Error autoFocus:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 89
    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mFocusing:Z

    goto :goto_0
.end method

.method private setFocusArea()V
    .locals 8

    .prologue
    .line 131
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v4}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v3

    .line 132
    .local v3, "parameters":Landroid/hardware/Camera$Parameters;
    sget v4, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v5, 0xe

    if-lt v4, v5, :cond_0

    invoke-virtual {v3}, Landroid/hardware/Camera$Parameters;->getMaxNumFocusAreas()I

    move-result v4

    if-lez v4, :cond_0

    .line 135
    :try_start_0
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 136
    .local v1, "areas":Ljava/util/List;, "Ljava/util/List<Landroid/hardware/Camera$Area;>;"
    new-instance v0, Landroid/graphics/Rect;

    const/16 v4, -0x96

    const/16 v5, -0xfa

    const/16 v6, 0x96

    const/16 v7, 0xfa

    invoke-direct {v0, v4, v5, v6, v7}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 138
    .local v0, "areaRect":Landroid/graphics/Rect;
    new-instance v4, Landroid/hardware/Camera$Area;

    const/16 v5, 0x3e8

    invoke-direct {v4, v0, v5}, Landroid/hardware/Camera$Area;-><init>(Landroid/graphics/Rect;I)V

    invoke-interface {v1, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 139
    invoke-virtual {v3, v1}, Landroid/hardware/Camera$Parameters;->setFocusAreas(Ljava/util/List;)V

    .line 140
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v4, v3}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 145
    .end local v0    # "areaRect":Landroid/graphics/Rect;
    .end local v1    # "areas":Ljava/util/List;, "Ljava/util/List<Landroid/hardware/Camera$Area;>;"
    :cond_0
    :goto_0
    return-void

    .line 141
    :catch_0
    move-exception v2

    .line 142
    .local v2, "e":Ljava/lang/Exception;
    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/hardware/Camera$Parameters;->setFocusAreas(Ljava/util/List;)V

    goto :goto_0
.end method


# virtual methods
.method public focusOnClick()V
    .locals 1

    .prologue
    .line 37
    iget-boolean v0, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mFocusing:Z

    if-nez v0, :cond_0

    .line 38
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->focus()V

    .line 40
    :cond_0
    return-void
.end method

.method public onPreviewFrame([BLandroid/hardware/Camera;)V
    .locals 0
    .param p1, "data"    # [B
    .param p2, "camera"    # Landroid/hardware/Camera;

    .prologue
    .line 95
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/search/viewit/CameraPreview;->onPreviewFrame([BLandroid/hardware/Camera;)V

    .line 96
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->checkFocus()V

    .line 97
    return-void
.end method

.method protected startPreview()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 101
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mCamera:Landroid/hardware/Camera;

    if-nez v4, :cond_0

    .line 128
    :goto_0
    return-void

    .line 103
    :cond_0
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v4}, Landroid/hardware/Camera;->getParameters()Landroid/hardware/Camera$Parameters;

    move-result-object v2

    .line 105
    .local v2, "parameters":Landroid/hardware/Camera$Parameters;
    invoke-virtual {v2}, Landroid/hardware/Camera$Parameters;->getSupportedFocusModes()Ljava/util/List;

    move-result-object v3

    .line 106
    .local v3, "supportedFocusModes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-eqz v3, :cond_3

    .line 107
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 108
    .local v0, "focusMode":Ljava/lang/String;
    const-string/jumbo v4, "continuous-picture"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 109
    const/4 v4, 0x1

    iput-boolean v4, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mSupportsContinuousFocus:Z

    .line 112
    :cond_2
    const-string/jumbo v4, "macro"

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 114
    const-string/jumbo v4, "macro"

    iput-object v4, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mFocusMode:Ljava/lang/String;

    goto :goto_1

    .line 119
    .end local v0    # "focusMode":Ljava/lang/String;
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_3
    iget-boolean v4, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mSupportsContinuousFocus:Z

    if-eqz v4, :cond_4

    .line 120
    invoke-direct {p0}, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->setFocusArea()V

    .line 121
    const-string/jumbo v4, "continuous-picture"

    invoke-virtual {v2, v4}, Landroid/hardware/Camera$Parameters;->setFocusMode(Ljava/lang/String;)V

    .line 122
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mCamera:Landroid/hardware/Camera;

    invoke-virtual {v4, v2}, Landroid/hardware/Camera;->setParameters(Landroid/hardware/Camera$Parameters;)V

    .line 124
    :cond_4
    iput-boolean v5, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mFocusing:Z

    .line 125
    const/4 v4, 0x0

    iput-object v4, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mLastFocus:Ljava/util/Date;

    .line 126
    iput v5, p0, Lcom/amazon/mShop/search/viewit/FocusingCameraPreview;->mFramesTilNextFocus:I

    .line 127
    invoke-super {p0}, Lcom/amazon/mShop/search/viewit/CameraPreview;->startPreview()V

    goto :goto_0
.end method
