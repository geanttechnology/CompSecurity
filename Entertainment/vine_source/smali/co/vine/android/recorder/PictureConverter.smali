.class public Lco/vine/android/recorder/PictureConverter;
.super Ljava/lang/Object;
.source "PictureConverter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/recorder/PictureConverter$1;,
        Lco/vine/android/recorder/PictureConverter$ScaleStep;
    }
.end annotation


# instance fields
.field public final LOCK:[I

.field private lastH:I

.field private lastW:I

.field private mFilterYuv:Lco/vine/android/recorder/RsYuv;

.field private mLastDegree:I

.field private mLastFront:Z

.field private mLastMirrored:Z

.field private final mMatrix:Landroid/graphics/Matrix;

.field private final mPaint:Landroid/graphics/Paint;

.field private mRS:Landroid/support/v8/renderscript/RenderScript;

.field private mScaleStep:Lco/vine/android/recorder/PictureConverter$ScaleStep;

.field private final mTargetSize:I

.field private srcBmp:Landroid/graphics/Bitmap;


# direct methods
.method public constructor <init>(Landroid/support/v8/renderscript/RenderScript;ILco/vine/android/recorder/CameraSetting;)V
    .locals 3
    .param p1, "rs"    # Landroid/support/v8/renderscript/RenderScript;
    .param p2, "targetSize"    # I
    .param p3, "cameraSetting"    # Lco/vine/android/recorder/CameraSetting;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/VineNotSupportedException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    .line 56
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 21
    const v1, -0x1869f

    iput v1, p0, Lco/vine/android/recorder/PictureConverter;->mLastDegree:I

    .line 26
    new-array v1, v2, [I

    iput-object v1, p0, Lco/vine/android/recorder/PictureConverter;->LOCK:[I

    .line 27
    iput-boolean v2, p0, Lco/vine/android/recorder/PictureConverter;->mLastMirrored:Z

    .line 57
    iput-object p1, p0, Lco/vine/android/recorder/PictureConverter;->mRS:Landroid/support/v8/renderscript/RenderScript;

    .line 58
    new-instance v1, Landroid/graphics/Matrix;

    invoke-direct {v1}, Landroid/graphics/Matrix;-><init>()V

    iput-object v1, p0, Lco/vine/android/recorder/PictureConverter;->mMatrix:Landroid/graphics/Matrix;

    .line 59
    iput p2, p0, Lco/vine/android/recorder/PictureConverter;->mTargetSize:I

    .line 60
    new-instance v1, Landroid/graphics/Paint;

    invoke-direct {v1}, Landroid/graphics/Paint;-><init>()V

    iput-object v1, p0, Lco/vine/android/recorder/PictureConverter;->mPaint:Landroid/graphics/Paint;

    .line 62
    :try_start_0
    invoke-direct {p0, p3}, Lco/vine/android/recorder/PictureConverter;->setCameraSetting(Lco/vine/android/recorder/CameraSetting;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 66
    return-void

    .line 63
    :catch_0
    move-exception v0

    .line 64
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Lco/vine/android/VineNotSupportedException;

    invoke-direct {v1}, Lco/vine/android/VineNotSupportedException;-><init>()V

    throw v1
.end method

.method static synthetic access$000(Lco/vine/android/recorder/PictureConverter;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/PictureConverter;

    .prologue
    .line 15
    iget v0, p0, Lco/vine/android/recorder/PictureConverter;->lastH:I

    return v0
.end method

.method static synthetic access$100(Lco/vine/android/recorder/PictureConverter;)I
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/PictureConverter;

    .prologue
    .line 15
    iget v0, p0, Lco/vine/android/recorder/PictureConverter;->lastW:I

    return v0
.end method

.method static synthetic access$200(Lco/vine/android/recorder/PictureConverter;)Landroid/graphics/Bitmap;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/PictureConverter;

    .prologue
    .line 15
    iget-object v0, p0, Lco/vine/android/recorder/PictureConverter;->srcBmp:Landroid/graphics/Bitmap;

    return-object v0
.end method

.method static synthetic access$300(Lco/vine/android/recorder/PictureConverter;)Landroid/graphics/Paint;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/recorder/PictureConverter;

    .prologue
    .line 15
    iget-object v0, p0, Lco/vine/android/recorder/PictureConverter;->mPaint:Landroid/graphics/Paint;

    return-object v0
.end method

.method private allocate(III)V
    .locals 2
    .param p1, "frameSize"    # I
    .param p2, "originalW"    # I
    .param p3, "originalH"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/VineNotSupportedException;
        }
    .end annotation

    .prologue
    .line 175
    new-instance v0, Lco/vine/android/recorder/RsYuv;

    iget-object v1, p0, Lco/vine/android/recorder/PictureConverter;->mRS:Landroid/support/v8/renderscript/RenderScript;

    invoke-direct {v0, v1, p2, p3}, Lco/vine/android/recorder/RsYuv;-><init>(Landroid/support/v8/renderscript/RenderScript;II)V

    iput-object v0, p0, Lco/vine/android/recorder/PictureConverter;->mFilterYuv:Lco/vine/android/recorder/RsYuv;

    .line 176
    return-void
.end method

.method private convertUsingRenderScript(Lco/vine/android/recorder/CameraSetting;Lco/vine/android/recorder/VideoData;Z)V
    .locals 5
    .param p1, "cameraSetting"    # Lco/vine/android/recorder/CameraSetting;
    .param p2, "next"    # Lco/vine/android/recorder/VideoData;
    .param p3, "hasChanged"    # Z

    .prologue
    .line 137
    iget-object v1, p2, Lco/vine/android/recorder/VideoData;->data:[B

    if-nez v1, :cond_0

    .line 138
    const-string v1, "Data is null."

    invoke-static {v1}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 140
    :cond_0
    iget-object v1, p0, Lco/vine/android/recorder/PictureConverter;->mRS:Landroid/support/v8/renderscript/RenderScript;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lco/vine/android/recorder/PictureConverter;->mFilterYuv:Lco/vine/android/recorder/RsYuv;

    if-eqz v1, :cond_1

    if-eqz p3, :cond_2

    .line 142
    :cond_1
    :try_start_0
    new-instance v1, Lco/vine/android/recorder/RsYuv;

    iget-object v2, p0, Lco/vine/android/recorder/PictureConverter;->mRS:Landroid/support/v8/renderscript/RenderScript;

    iget v3, p1, Lco/vine/android/recorder/CameraSetting;->originalW:I

    iget v4, p1, Lco/vine/android/recorder/CameraSetting;->originalH:I

    invoke-direct {v1, v2, v3, v4}, Lco/vine/android/recorder/RsYuv;-><init>(Landroid/support/v8/renderscript/RenderScript;II)V

    iput-object v1, p0, Lco/vine/android/recorder/PictureConverter;->mFilterYuv:Lco/vine/android/recorder/RsYuv;
    :try_end_0
    .catch Lco/vine/android/VineNotSupportedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 147
    :cond_2
    :goto_0
    iget-object v1, p0, Lco/vine/android/recorder/PictureConverter;->mFilterYuv:Lco/vine/android/recorder/RsYuv;

    iget-object v2, p2, Lco/vine/android/recorder/VideoData;->data:[B

    iget-object v3, p0, Lco/vine/android/recorder/PictureConverter;->srcBmp:Landroid/graphics/Bitmap;

    invoke-virtual {v1, v2, v3}, Lco/vine/android/recorder/RsYuv;->execute([BLandroid/graphics/Bitmap;)V

    .line 148
    return-void

    .line 143
    :catch_0
    move-exception v0

    .line 144
    .local v0, "e":Lco/vine/android/VineNotSupportedException;
    const-string v1, "Failed to RsYuv, it should never reach here."

    invoke-static {v1}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private giveMatrixNewValuesWithScaleIfDegreeHasChanged(IZ)V
    .locals 11
    .param p1, "degrees"    # I
    .param p2, "mirror"    # Z

    .prologue
    const/high16 v10, 0x40000000    # 2.0f

    .line 151
    iget v7, p0, Lco/vine/android/recorder/PictureConverter;->mLastDegree:I

    if-ne v7, p1, :cond_0

    iget-boolean v7, p0, Lco/vine/android/recorder/PictureConverter;->mLastMirrored:Z

    if-eq v7, p2, :cond_1

    .line 152
    :cond_0
    iget-object v7, p0, Lco/vine/android/recorder/PictureConverter;->mScaleStep:Lco/vine/android/recorder/PictureConverter$ScaleStep;

    if-nez v7, :cond_2

    iget v6, p0, Lco/vine/android/recorder/PictureConverter;->lastW:I

    .line 153
    .local v6, "width":I
    :goto_0
    iget-object v7, p0, Lco/vine/android/recorder/PictureConverter;->mScaleStep:Lco/vine/android/recorder/PictureConverter$ScaleStep;

    if-nez v7, :cond_3

    iget v2, p0, Lco/vine/android/recorder/PictureConverter;->lastH:I

    .line 154
    .local v2, "height":I
    :goto_1
    iget-object v7, p0, Lco/vine/android/recorder/PictureConverter;->mMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v7}, Landroid/graphics/Matrix;->reset()V

    .line 155
    iget v7, p0, Lco/vine/android/recorder/PictureConverter;->mTargetSize:I

    int-to-float v7, v7

    int-to-float v8, v6

    div-float/2addr v7, v8

    iget v8, p0, Lco/vine/android/recorder/PictureConverter;->mTargetSize:I

    int-to-float v8, v8

    int-to-float v9, v2

    div-float/2addr v8, v9

    invoke-static {v7, v8}, Ljava/lang/Math;->max(FF)F

    move-result v5

    .line 156
    .local v5, "scaleFactor":F
    int-to-float v7, v6

    mul-float v1, v7, v5

    .line 157
    .local v1, "actualWidth":F
    int-to-float v7, v2

    mul-float v0, v7, v5

    .line 158
    .local v0, "actualHeight":F
    iget v7, p0, Lco/vine/android/recorder/PictureConverter;->mTargetSize:I

    int-to-float v7, v7

    sub-float v7, v1, v7

    neg-float v7, v7

    div-float v3, v7, v10

    .line 159
    .local v3, "offsetX":F
    iget v7, p0, Lco/vine/android/recorder/PictureConverter;->mTargetSize:I

    int-to-float v7, v7

    sub-float v7, v0, v7

    neg-float v7, v7

    div-float v4, v7, v10

    .line 160
    .local v4, "offsetY":F
    iget-object v7, p0, Lco/vine/android/recorder/PictureConverter;->mMatrix:Landroid/graphics/Matrix;

    int-to-float v8, p1

    div-int/lit8 v9, v6, 0x2

    int-to-float v9, v9

    div-int/lit8 v10, v2, 0x2

    int-to-float v10, v10

    invoke-virtual {v7, v8, v9, v10}, Landroid/graphics/Matrix;->postRotate(FFF)Z

    .line 161
    const-string v7, "Creating with mirrored {}."

    invoke-static {p2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 162
    if-eqz p2, :cond_4

    .line 163
    iget-object v7, p0, Lco/vine/android/recorder/PictureConverter;->mMatrix:Landroid/graphics/Matrix;

    neg-float v8, v5

    invoke-virtual {v7, v8, v5}, Landroid/graphics/Matrix;->postScale(FF)Z

    .line 164
    iget-object v7, p0, Lco/vine/android/recorder/PictureConverter;->mMatrix:Landroid/graphics/Matrix;

    neg-float v8, v3

    iget v9, p0, Lco/vine/android/recorder/PictureConverter;->mTargetSize:I

    int-to-float v9, v9

    add-float/2addr v8, v9

    invoke-virtual {v7, v8, v4}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 169
    :goto_2
    iput-boolean p2, p0, Lco/vine/android/recorder/PictureConverter;->mLastMirrored:Z

    .line 170
    iput p1, p0, Lco/vine/android/recorder/PictureConverter;->mLastDegree:I

    .line 172
    .end local v0    # "actualHeight":F
    .end local v1    # "actualWidth":F
    .end local v2    # "height":I
    .end local v3    # "offsetX":F
    .end local v4    # "offsetY":F
    .end local v5    # "scaleFactor":F
    .end local v6    # "width":I
    :cond_1
    return-void

    .line 152
    :cond_2
    iget-object v7, p0, Lco/vine/android/recorder/PictureConverter;->mScaleStep:Lco/vine/android/recorder/PictureConverter$ScaleStep;

    # getter for: Lco/vine/android/recorder/PictureConverter$ScaleStep;->scaledW:I
    invoke-static {v7}, Lco/vine/android/recorder/PictureConverter$ScaleStep;->access$700(Lco/vine/android/recorder/PictureConverter$ScaleStep;)I

    move-result v6

    goto :goto_0

    .line 153
    .restart local v6    # "width":I
    :cond_3
    iget-object v7, p0, Lco/vine/android/recorder/PictureConverter;->mScaleStep:Lco/vine/android/recorder/PictureConverter$ScaleStep;

    # getter for: Lco/vine/android/recorder/PictureConverter$ScaleStep;->scaledH:I
    invoke-static {v7}, Lco/vine/android/recorder/PictureConverter$ScaleStep;->access$800(Lco/vine/android/recorder/PictureConverter$ScaleStep;)I

    move-result v2

    goto :goto_1

    .line 166
    .restart local v0    # "actualHeight":F
    .restart local v1    # "actualWidth":F
    .restart local v2    # "height":I
    .restart local v3    # "offsetX":F
    .restart local v4    # "offsetY":F
    .restart local v5    # "scaleFactor":F
    :cond_4
    iget-object v7, p0, Lco/vine/android/recorder/PictureConverter;->mMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v7, v5, v5}, Landroid/graphics/Matrix;->postScale(FF)Z

    .line 167
    iget-object v7, p0, Lco/vine/android/recorder/PictureConverter;->mMatrix:Landroid/graphics/Matrix;

    invoke-virtual {v7, v3, v4}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    goto :goto_2
.end method

.method private setCameraSetting(Lco/vine/android/recorder/CameraSetting;)V
    .locals 6
    .param p1, "cameraSetting"    # Lco/vine/android/recorder/CameraSetting;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/VineNotSupportedException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x0

    .line 95
    iget-object v1, p0, Lco/vine/android/recorder/PictureConverter;->srcBmp:Landroid/graphics/Bitmap;

    if-eqz v1, :cond_0

    .line 96
    iget-object v1, p0, Lco/vine/android/recorder/PictureConverter;->srcBmp:Landroid/graphics/Bitmap;

    invoke-virtual {v1}, Landroid/graphics/Bitmap;->recycle()V

    .line 97
    iput-object v4, p0, Lco/vine/android/recorder/PictureConverter;->srcBmp:Landroid/graphics/Bitmap;

    .line 99
    :cond_0
    iget v1, p1, Lco/vine/android/recorder/CameraSetting;->originalW:I

    iget v2, p1, Lco/vine/android/recorder/CameraSetting;->originalH:I

    sget-object v3, Lco/vine/android/recorder/RecordConfigUtils;->DEFAULT_BITMAP_CONFIG:Landroid/graphics/Bitmap$Config;

    invoke-static {v1, v2, v3}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/recorder/PictureConverter;->srcBmp:Landroid/graphics/Bitmap;

    .line 102
    iget v1, p1, Lco/vine/android/recorder/CameraSetting;->originalW:I

    iget v2, p1, Lco/vine/android/recorder/CameraSetting;->originalH:I

    mul-int v0, v1, v2

    .line 103
    .local v0, "currentFrameSize":I
    iget v1, p1, Lco/vine/android/recorder/CameraSetting;->originalH:I

    iput v1, p0, Lco/vine/android/recorder/PictureConverter;->lastH:I

    .line 104
    iget v1, p1, Lco/vine/android/recorder/CameraSetting;->originalW:I

    iput v1, p0, Lco/vine/android/recorder/PictureConverter;->lastW:I

    .line 105
    iget-boolean v1, p1, Lco/vine/android/recorder/CameraSetting;->frontFacing:Z

    iput-boolean v1, p0, Lco/vine/android/recorder/PictureConverter;->mLastFront:Z

    .line 107
    iget-boolean v1, p1, Lco/vine/android/recorder/CameraSetting;->frontFacing:Z

    if-eqz v1, :cond_1

    iget v1, p1, Lco/vine/android/recorder/CameraSetting;->frontFacingAspectRatio:F

    cmpl-float v1, v1, v5

    if-lez v1, :cond_1

    .line 108
    new-instance v1, Lco/vine/android/recorder/PictureConverter$ScaleStep;

    iget v2, p1, Lco/vine/android/recorder/CameraSetting;->frontFacingAspectRatio:F

    invoke-direct {v1, p0, v2, v4}, Lco/vine/android/recorder/PictureConverter$ScaleStep;-><init>(Lco/vine/android/recorder/PictureConverter;FLco/vine/android/recorder/PictureConverter$1;)V

    iput-object v1, p0, Lco/vine/android/recorder/PictureConverter;->mScaleStep:Lco/vine/android/recorder/PictureConverter$ScaleStep;

    .line 115
    :goto_0
    iget v1, p1, Lco/vine/android/recorder/CameraSetting;->degrees:I

    const/4 v2, 0x0

    invoke-direct {p0, v1, v2}, Lco/vine/android/recorder/PictureConverter;->giveMatrixNewValuesWithScaleIfDegreeHasChanged(IZ)V

    .line 116
    iget v1, p1, Lco/vine/android/recorder/CameraSetting;->originalW:I

    iget v2, p1, Lco/vine/android/recorder/CameraSetting;->originalH:I

    invoke-direct {p0, v0, v1, v2}, Lco/vine/android/recorder/PictureConverter;->allocate(III)V

    .line 117
    return-void

    .line 109
    :cond_1
    iget v1, p1, Lco/vine/android/recorder/CameraSetting;->backFacingAspectRatio:F

    cmpl-float v1, v1, v5

    if-lez v1, :cond_2

    .line 110
    new-instance v1, Lco/vine/android/recorder/PictureConverter$ScaleStep;

    iget v2, p1, Lco/vine/android/recorder/CameraSetting;->backFacingAspectRatio:F

    invoke-direct {v1, p0, v2, v4}, Lco/vine/android/recorder/PictureConverter$ScaleStep;-><init>(Lco/vine/android/recorder/PictureConverter;FLco/vine/android/recorder/PictureConverter$1;)V

    iput-object v1, p0, Lco/vine/android/recorder/PictureConverter;->mScaleStep:Lco/vine/android/recorder/PictureConverter$ScaleStep;

    goto :goto_0

    .line 112
    :cond_2
    iput-object v4, p0, Lco/vine/android/recorder/PictureConverter;->mScaleStep:Lco/vine/android/recorder/PictureConverter$ScaleStep;

    goto :goto_0
.end method


# virtual methods
.method public convert(Lco/vine/android/recorder/CameraSetting;Lco/vine/android/recorder/VideoData;Z)Z
    .locals 2
    .param p1, "cameraSetting"    # Lco/vine/android/recorder/CameraSetting;
    .param p2, "next"    # Lco/vine/android/recorder/VideoData;
    .param p3, "hasChanged"    # Z

    .prologue
    const/4 v1, 0x0

    .line 125
    :try_start_0
    invoke-direct {p0, p1, p2, p3}, Lco/vine/android/recorder/PictureConverter;->convertUsingRenderScript(Lco/vine/android/recorder/CameraSetting;Lco/vine/android/recorder/VideoData;Z)V
    :try_end_0
    .catch Landroid/renderscript/RSInvalidStateException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Landroid/support/v8/renderscript/RSInvalidStateException; {:try_start_0 .. :try_end_0} :catch_1

    .line 126
    const/4 v1, 0x1

    .line 132
    :goto_0
    return v1

    .line 127
    :catch_0
    move-exception v0

    .line 129
    .local v0, "e":Landroid/renderscript/RSInvalidStateException;
    goto :goto_0

    .line 130
    .end local v0    # "e":Landroid/renderscript/RSInvalidStateException;
    :catch_1
    move-exception v0

    .line 132
    .local v0, "e":Landroid/support/v8/renderscript/RSInvalidStateException;
    goto :goto_0
.end method

.method public draw(Landroid/graphics/Canvas;)V
    .locals 3
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 69
    iget-object v0, p0, Lco/vine/android/recorder/PictureConverter;->mScaleStep:Lco/vine/android/recorder/PictureConverter$ScaleStep;

    if-nez v0, :cond_0

    .line 70
    iget-object v0, p0, Lco/vine/android/recorder/PictureConverter;->srcBmp:Landroid/graphics/Bitmap;

    iget-object v1, p0, Lco/vine/android/recorder/PictureConverter;->mMatrix:Landroid/graphics/Matrix;

    iget-object v2, p0, Lco/vine/android/recorder/PictureConverter;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1, v2}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V

    .line 75
    :goto_0
    return-void

    .line 72
    :cond_0
    iget-object v0, p0, Lco/vine/android/recorder/PictureConverter;->mScaleStep:Lco/vine/android/recorder/PictureConverter$ScaleStep;

    # invokes: Lco/vine/android/recorder/PictureConverter$ScaleStep;->scale()V
    invoke-static {v0}, Lco/vine/android/recorder/PictureConverter$ScaleStep;->access$400(Lco/vine/android/recorder/PictureConverter$ScaleStep;)V

    .line 73
    iget-object v0, p0, Lco/vine/android/recorder/PictureConverter;->mScaleStep:Lco/vine/android/recorder/PictureConverter$ScaleStep;

    # getter for: Lco/vine/android/recorder/PictureConverter$ScaleStep;->mPreScaleBitmap:Landroid/graphics/Bitmap;
    invoke-static {v0}, Lco/vine/android/recorder/PictureConverter$ScaleStep;->access$500(Lco/vine/android/recorder/PictureConverter$ScaleStep;)Landroid/graphics/Bitmap;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/recorder/PictureConverter;->mMatrix:Landroid/graphics/Matrix;

    iget-object v2, p0, Lco/vine/android/recorder/PictureConverter;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1, v2}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V

    goto :goto_0
.end method

.method public drawGeneric(Landroid/graphics/Canvas;Landroid/graphics/Bitmap;Landroid/graphics/Matrix;)V
    .locals 1
    .param p1, "canvas"    # Landroid/graphics/Canvas;
    .param p2, "bitmap"    # Landroid/graphics/Bitmap;
    .param p3, "matrix"    # Landroid/graphics/Matrix;

    .prologue
    .line 78
    iget-object v0, p0, Lco/vine/android/recorder/PictureConverter;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, p2, p3, v0}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V

    .line 79
    return-void
.end method

.method public giveMatrixNewValuesWithScaleIfDegreeHasChangedWithKnownConfigs(IZ)V
    .locals 0
    .param p1, "degrees"    # I
    .param p2, "frontFacing"    # Z

    .prologue
    .line 120
    invoke-direct {p0, p1, p2}, Lco/vine/android/recorder/PictureConverter;->giveMatrixNewValuesWithScaleIfDegreeHasChanged(IZ)V

    .line 121
    return-void
.end method

.method public updateSettingsIfNeeded(Lco/vine/android/recorder/CameraSetting;)Z
    .locals 4
    .param p1, "cameraSetting"    # Lco/vine/android/recorder/CameraSetting;

    .prologue
    .line 82
    iget v2, p0, Lco/vine/android/recorder/PictureConverter;->lastW:I

    iget v3, p1, Lco/vine/android/recorder/CameraSetting;->originalW:I

    if-ne v2, v3, :cond_0

    iget v2, p0, Lco/vine/android/recorder/PictureConverter;->lastH:I

    iget v3, p1, Lco/vine/android/recorder/CameraSetting;->originalH:I

    if-ne v2, v3, :cond_0

    iget-boolean v2, p1, Lco/vine/android/recorder/CameraSetting;->frontFacing:Z

    iget-boolean v3, p0, Lco/vine/android/recorder/PictureConverter;->mLastFront:Z

    if-eq v2, v3, :cond_3

    :cond_0
    const/4 v1, 0x1

    .line 84
    .local v1, "hasChanged":Z
    :goto_0
    iget-object v2, p0, Lco/vine/android/recorder/PictureConverter;->srcBmp:Landroid/graphics/Bitmap;

    if-eqz v2, :cond_1

    if-eqz v1, :cond_2

    .line 86
    :cond_1
    :try_start_0
    invoke-direct {p0, p1}, Lco/vine/android/recorder/PictureConverter;->setCameraSetting(Lco/vine/android/recorder/CameraSetting;)V
    :try_end_0
    .catch Lco/vine/android/VineNotSupportedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 91
    :cond_2
    :goto_1
    return v1

    .line 82
    .end local v1    # "hasChanged":Z
    :cond_3
    const/4 v1, 0x0

    goto :goto_0

    .line 87
    .restart local v1    # "hasChanged":Z
    :catch_0
    move-exception v0

    .line 88
    .local v0, "e":Lco/vine/android/VineNotSupportedException;
    const-string v2, "Failed to make RsYuv, it should never reach here."

    invoke-static {v2}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    goto :goto_1
.end method
