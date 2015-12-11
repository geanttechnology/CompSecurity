.class public Lcom/poshmark/ui/customviews/CropImageSurfaceView;
.super Landroid/view/SurfaceView;
.source "CropImageSurfaceView.java"

# interfaces
.implements Landroid/view/SurfaceHolder$Callback;


# static fields
.field public static final CREATE_COVERSHOT:I = 0x1

.field public static final CREATE_THUMBNAIL:I


# instance fields
.field angle:I

.field private bIsDragging:Z

.field private bmpFileName:Ljava/lang/String;

.field cropImageWidth:I

.field private diffX:F

.field private diffY:F

.field private mHolder:Landroid/view/SurfaceHolder;

.field originalHeight:F

.field originalWidth:F

.field paint:Landroid/graphics/Paint;

.field private parentHeight:I

.field private parentWidth:I

.field private prevX:F

.field private prevY:F

.field rotatedHeight:F

.field rotatedWidth:F

.field scale:F

.field selectedImage:Landroid/graphics/Bitmap;

.field viewportRect:Landroid/graphics/Rect;

.field xTranslation:F

.field yTranslation:F


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v1, 0x0

    .line 54
    invoke-direct {p0, p1, p2}, Landroid/view/SurfaceView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 31
    iput v1, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->xTranslation:F

    .line 32
    iput v1, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->yTranslation:F

    .line 33
    iput v1, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->scale:F

    .line 43
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->bIsDragging:Z

    .line 46
    iput v1, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->diffX:F

    .line 47
    iput v1, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->diffY:F

    .line 49
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->paint:Landroid/graphics/Paint;

    .line 55
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->mHolder:Landroid/view/SurfaceHolder;

    .line 56
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->mHolder:Landroid/view/SurfaceHolder;

    invoke-interface {v0, p0}, Landroid/view/SurfaceHolder;->addCallback(Landroid/view/SurfaceHolder$Callback;)V

    .line 58
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->mHolder:Landroid/view/SurfaceHolder;

    const/4 v1, 0x3

    invoke-interface {v0, v1}, Landroid/view/SurfaceHolder;->setType(I)V

    .line 59
    return-void
.end method

.method private drawImage(Landroid/graphics/Canvas;)V
    .locals 4
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 207
    iget-object v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->bmpFileName:Ljava/lang/String;

    if-eqz v2, :cond_0

    .line 208
    iget v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->yTranslation:F

    iget v3, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->diffY:F

    add-float/2addr v2, v3

    iput v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->yTranslation:F

    .line 209
    new-instance v1, Landroid/graphics/Matrix;

    invoke-direct {v1}, Landroid/graphics/Matrix;-><init>()V

    .line 210
    .local v1, "transformation":Landroid/graphics/Matrix;
    iget v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->scale:F

    iget v3, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->scale:F

    invoke-virtual {v1, v2, v3}, Landroid/graphics/Matrix;->preScale(FF)Z

    .line 211
    iget v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->xTranslation:F

    iget v3, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->yTranslation:F

    invoke-virtual {v1, v2, v3}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 212
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    .line 213
    .local v0, "paint":Landroid/graphics/Paint;
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroid/graphics/Paint;->setFilterBitmap(Z)V

    .line 214
    const/4 v2, 0x0

    sget-object v3, Landroid/graphics/PorterDuff$Mode;->CLEAR:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {p1, v2, v3}, Landroid/graphics/Canvas;->drawColor(ILandroid/graphics/PorterDuff$Mode;)V

    .line 215
    iget-object v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->selectedImage:Landroid/graphics/Bitmap;

    invoke-virtual {p1, v2, v1, v0}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V

    .line 217
    .end local v0    # "paint":Landroid/graphics/Paint;
    .end local v1    # "transformation":Landroid/graphics/Matrix;
    :cond_0
    return-void
.end method

.method private moveImage()V
    .locals 4

    .prologue
    .line 188
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->invalidate()V

    .line 190
    const/4 v0, 0x0

    .line 192
    .local v0, "canvas":Landroid/graphics/Canvas;
    :try_start_0
    iget-object v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->mHolder:Landroid/view/SurfaceHolder;

    const/4 v3, 0x0

    invoke-interface {v2, v3}, Landroid/view/SurfaceHolder;->lockCanvas(Landroid/graphics/Rect;)Landroid/graphics/Canvas;

    move-result-object v0

    .line 193
    iget-object v3, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->mHolder:Landroid/view/SurfaceHolder;

    monitor-enter v3
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 195
    :try_start_1
    invoke-direct {p0, v0}, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->drawImage(Landroid/graphics/Canvas;)V

    .line 196
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 200
    if-eqz v0, :cond_0

    .line 201
    iget-object v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->mHolder:Landroid/view/SurfaceHolder;

    invoke-interface {v2, v0}, Landroid/view/SurfaceHolder;->unlockCanvasAndPost(Landroid/graphics/Canvas;)V

    .line 204
    :cond_0
    :goto_0
    return-void

    .line 196
    :catchall_0
    move-exception v2

    :try_start_2
    monitor-exit v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :try_start_3
    throw v2
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 197
    :catch_0
    move-exception v1

    .line 198
    .local v1, "e":Ljava/lang/Exception;
    :try_start_4
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 200
    if-eqz v0, :cond_0

    .line 201
    iget-object v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->mHolder:Landroid/view/SurfaceHolder;

    invoke-interface {v2, v0}, Landroid/view/SurfaceHolder;->unlockCanvasAndPost(Landroid/graphics/Canvas;)V

    goto :goto_0

    .line 200
    .end local v1    # "e":Ljava/lang/Exception;
    :catchall_1
    move-exception v2

    if-eqz v0, :cond_1

    .line 201
    iget-object v3, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->mHolder:Landroid/view/SurfaceHolder;

    invoke-interface {v3, v0}, Landroid/view/SurfaceHolder;->unlockCanvasAndPost(Landroid/graphics/Canvas;)V

    :cond_1
    throw v2
.end method


# virtual methods
.method public getBitmap(Landroid/graphics/Rect;)Landroid/net/Uri;
    .locals 13
    .param p1, "cropViewPort"    # Landroid/graphics/Rect;

    .prologue
    .line 245
    new-instance v5, Landroid/graphics/Matrix;

    invoke-direct {v5}, Landroid/graphics/Matrix;-><init>()V

    .line 248
    .local v5, "matrix":Landroid/graphics/Matrix;
    iget v10, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->cropImageWidth:I

    int-to-float v10, v10

    iget v11, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->rotatedWidth:F

    div-float v8, v10, v11

    .line 249
    .local v8, "scaleWidth":F
    iget v10, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->cropImageWidth:I

    int-to-float v10, v10

    iget v11, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->rotatedHeight:F

    div-float v7, v10, v11

    .line 250
    .local v7, "scaleHeight":F
    invoke-virtual {v5, v8, v8}, Landroid/graphics/Matrix;->preScale(FF)Z

    .line 252
    iget v10, p1, Landroid/graphics/Rect;->top:I

    int-to-float v10, v10

    iget v11, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->yTranslation:F

    sub-float v2, v10, v11

    .line 253
    .local v2, "deltaBetweenTops":F
    iget v10, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->cropImageWidth:I

    int-to-float v10, v10

    invoke-virtual {p1}, Landroid/graphics/Rect;->height()I

    move-result v11

    int-to-float v11, v11

    div-float v9, v10, v11

    .line 254
    .local v9, "yScale":F
    const/4 v3, 0x0

    .line 255
    .local v3, "destLeft":I
    mul-float v10, v2, v9

    float-to-int v10, v10

    mul-int/lit8 v4, v10, -0x1

    .line 256
    .local v4, "destTop":I
    int-to-float v10, v3

    int-to-float v11, v4

    invoke-virtual {v5, v10, v11}, Landroid/graphics/Matrix;->postTranslate(FF)Z

    .line 258
    iget v10, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->cropImageWidth:I

    iget v11, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->cropImageWidth:I

    sget-object v12, Landroid/graphics/Bitmap$Config;->ARGB_8888:Landroid/graphics/Bitmap$Config;

    invoke-static {v10, v11, v12}, Landroid/graphics/Bitmap;->createBitmap(IILandroid/graphics/Bitmap$Config;)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 260
    .local v1, "correctBmp":Landroid/graphics/Bitmap;
    new-instance v0, Landroid/graphics/Canvas;

    invoke-direct {v0, v1}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 261
    .local v0, "canvas":Landroid/graphics/Canvas;
    new-instance v6, Landroid/graphics/Paint;

    invoke-direct {v6}, Landroid/graphics/Paint;-><init>()V

    .line 262
    .local v6, "paint":Landroid/graphics/Paint;
    const/4 v10, 0x1

    invoke-virtual {v6, v10}, Landroid/graphics/Paint;->setFilterBitmap(Z)V

    .line 263
    const/4 v10, 0x0

    sget-object v11, Landroid/graphics/PorterDuff$Mode;->CLEAR:Landroid/graphics/PorterDuff$Mode;

    invoke-virtual {v0, v10, v11}, Landroid/graphics/Canvas;->drawColor(ILandroid/graphics/PorterDuff$Mode;)V

    .line 264
    iget-object v10, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->selectedImage:Landroid/graphics/Bitmap;

    invoke-virtual {v0, v10, v5, v6}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;Landroid/graphics/Matrix;Landroid/graphics/Paint;)V

    .line 265
    iget-object v10, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->selectedImage:Landroid/graphics/Bitmap;

    invoke-virtual {v10}, Landroid/graphics/Bitmap;->recycle()V

    .line 266
    const/4 v10, 0x0

    iput-object v10, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->selectedImage:Landroid/graphics/Bitmap;

    .line 267
    invoke-static {v1}, Lcom/poshmark/utils/ImageUtils;->saveBitmapToDisk(Landroid/graphics/Bitmap;)Landroid/net/Uri;

    move-result-object v10

    return-object v10
.end method

.method public onLayout(ZIIII)V
    .locals 3
    .param p1, "changed"    # Z
    .param p2, "left"    # I
    .param p3, "top"    # I
    .param p4, "right"    # I
    .param p5, "bottom"    # I

    .prologue
    const/4 v2, 0x0

    .line 143
    if-eqz p1, :cond_0

    .line 144
    iget v0, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->parentWidth:I

    iget v1, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->parentHeight:I

    invoke-virtual {p0, v2, v2, v0, v1}, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->layout(IIII)V

    .line 146
    :cond_0
    return-void
.end method

.method protected onMeasure(II)V
    .locals 2
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 136
    invoke-static {p1}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v0

    iput v0, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->parentWidth:I

    .line 137
    invoke-static {p2}, Landroid/view/View$MeasureSpec;->getSize(I)I

    move-result v0

    iput v0, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->parentHeight:I

    .line 138
    iget v0, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->parentWidth:I

    iget v1, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->parentHeight:I

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->setMeasuredDimension(II)V

    .line 139
    return-void
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 5
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 153
    const/4 v3, 0x0

    .line 154
    .local v3, "touched":Z
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    .line 155
    .local v0, "action":I
    packed-switch v0, :pswitch_data_0

    .line 184
    :goto_0
    const/4 v4, 0x1

    return v4

    .line 157
    :pswitch_0
    const/4 v3, 0x1

    .line 158
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v4

    iput v4, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->prevX:F

    .line 159
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v4

    iput v4, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->prevY:F

    goto :goto_0

    .line 162
    :pswitch_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    .line 163
    .local v1, "currentX":F
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getY()F

    move-result v2

    .line 165
    .local v2, "currentY":F
    iget v4, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->prevX:F

    sub-float v4, v1, v4

    iput v4, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->diffX:F

    .line 166
    iget v4, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->prevY:F

    sub-float v4, v2, v4

    iput v4, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->diffY:F

    .line 168
    iput v1, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->prevX:F

    .line 169
    iput v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->prevY:F

    .line 171
    invoke-direct {p0}, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->moveImage()V

    goto :goto_0

    .line 174
    .end local v1    # "currentX":F
    .end local v2    # "currentY":F
    :pswitch_2
    const/4 v3, 0x0

    .line 175
    goto :goto_0

    .line 177
    :pswitch_3
    const/4 v3, 0x0

    .line 178
    goto :goto_0

    .line 180
    :pswitch_4
    const/4 v3, 0x0

    .line 181
    goto :goto_0

    .line 155
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_2
        :pswitch_1
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method

.method public setFile(Ljava/lang/String;)V
    .locals 0
    .param p1, "fileName"    # Ljava/lang/String;

    .prologue
    .line 221
    iput-object p1, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->bmpFileName:Ljava/lang/String;

    .line 222
    return-void
.end method

.method public setMode(I)V
    .locals 1
    .param p1, "creation_mode"    # I

    .prologue
    .line 225
    packed-switch p1, :pswitch_data_0

    .line 234
    :goto_0
    return-void

    .line 227
    :pswitch_0
    const/16 v0, 0x64

    iput v0, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->cropImageWidth:I

    goto :goto_0

    .line 231
    :pswitch_1
    const/16 v0, 0x400

    iput v0, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->cropImageWidth:I

    goto :goto_0

    .line 225
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public setViewPortRect(Landroid/graphics/Rect;)V
    .locals 0
    .param p1, "viewportRect"    # Landroid/graphics/Rect;

    .prologue
    .line 272
    iput-object p1, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->viewportRect:Landroid/graphics/Rect;

    .line 273
    return-void
.end method

.method public surfaceChanged(Landroid/view/SurfaceHolder;III)V
    .locals 1
    .param p1, "holder"    # Landroid/view/SurfaceHolder;
    .param p2, "format"    # I
    .param p3, "w"    # I
    .param p4, "h"    # I

    .prologue
    .line 128
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->mHolder:Landroid/view/SurfaceHolder;

    invoke-interface {v0}, Landroid/view/SurfaceHolder;->getSurface()Landroid/view/Surface;

    move-result-object v0

    if-nez v0, :cond_0

    .line 132
    :cond_0
    return-void
.end method

.method public surfaceCreated(Landroid/view/SurfaceHolder;)V
    .locals 11
    .param p1, "holder"    # Landroid/view/SurfaceHolder;

    .prologue
    const/4 v6, 0x1

    const/4 v1, 0x0

    .line 63
    invoke-virtual {p0, v1}, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->setWillNotDraw(Z)V

    .line 64
    iget-object v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->bmpFileName:Ljava/lang/String;

    if-eqz v2, :cond_1

    .line 66
    iget-object v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->bmpFileName:Ljava/lang/String;

    invoke-static {v2}, Lcom/poshmark/utils/ImageUtils;->exifOrientation(Ljava/lang/String;)I

    move-result v2

    iput v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->angle:I

    .line 68
    new-instance v9, Landroid/graphics/BitmapFactory$Options;

    invoke-direct {v9}, Landroid/graphics/BitmapFactory$Options;-><init>()V

    .line 69
    .local v9, "options":Landroid/graphics/BitmapFactory$Options;
    iput-boolean v6, v9, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 70
    iget-object v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->bmpFileName:Ljava/lang/String;

    invoke-static {v2, v9}, Lcom/newrelic/agent/android/instrumentation/BitmapFactoryInstrumentation;->decodeFile(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 72
    .local v0, "originalSelectedImage":Landroid/graphics/Bitmap;
    iget v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->parentWidth:I

    iget v3, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->parentHeight:I

    invoke-static {v9, v2, v3}, Lcom/poshmark/utils/ImageUtils;->calculateInSampleSize(Landroid/graphics/BitmapFactory$Options;II)I

    move-result v10

    .line 73
    .local v10, "sampleSize":I
    iput-boolean v1, v9, Landroid/graphics/BitmapFactory$Options;->inJustDecodeBounds:Z

    .line 74
    iput v10, v9, Landroid/graphics/BitmapFactory$Options;->inSampleSize:I

    .line 76
    iget-object v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->bmpFileName:Ljava/lang/String;

    invoke-static {v2, v9}, Lcom/newrelic/agent/android/instrumentation/BitmapFactoryInstrumentation;->decodeFile(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 77
    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v2

    int-to-float v2, v2

    iput v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->originalWidth:F

    .line 78
    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v2

    int-to-float v2, v2

    iput v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->originalHeight:F

    .line 79
    iget v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->angle:I

    const/16 v3, 0x5a

    if-eq v2, v3, :cond_0

    iget v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->angle:I

    const/16 v3, 0x10e

    if-ne v2, v3, :cond_2

    .line 80
    :cond_0
    iget v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->originalWidth:F

    iput v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->rotatedHeight:F

    .line 81
    iget v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->originalHeight:F

    iput v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->rotatedWidth:F

    .line 87
    :goto_0
    iget v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->parentWidth:I

    iget-object v3, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->viewportRect:Landroid/graphics/Rect;

    iget v3, v3, Landroid/graphics/Rect;->left:I

    mul-int/lit8 v3, v3, 0x2

    sub-int/2addr v2, v3

    int-to-float v2, v2

    iget v3, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->rotatedWidth:F

    div-float/2addr v2, v3

    iput v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->scale:F

    .line 88
    const/high16 v2, 0x41200000    # 10.0f

    iput v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->xTranslation:F

    .line 89
    iget v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->parentHeight:I

    int-to-float v2, v2

    iget v3, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->rotatedHeight:F

    iget v4, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->scale:F

    mul-float/2addr v3, v4

    sub-float/2addr v2, v3

    const/high16 v3, 0x40000000    # 2.0f

    div-float/2addr v2, v3

    iput v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->yTranslation:F

    .line 92
    new-instance v5, Landroid/graphics/Matrix;

    invoke-direct {v5}, Landroid/graphics/Matrix;-><init>()V

    .line 93
    .local v5, "transformation":Landroid/graphics/Matrix;
    iget v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->angle:I

    if-eqz v2, :cond_3

    .line 94
    const/high16 v2, 0x42b40000    # 90.0f

    invoke-virtual {v5, v2}, Landroid/graphics/Matrix;->postRotate(F)Z

    .line 95
    iget v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->originalWidth:F

    float-to-int v3, v2

    iget v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->originalHeight:F

    float-to-int v4, v2

    move v2, v1

    invoke-static/range {v0 .. v6}, Landroid/graphics/Bitmap;->createBitmap(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->selectedImage:Landroid/graphics/Bitmap;

    .line 96
    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    .line 97
    const/4 v0, 0x0

    .line 102
    :goto_1
    const/4 v7, 0x0

    .line 104
    .local v7, "canvas":Landroid/graphics/Canvas;
    const/4 v1, 0x0

    :try_start_0
    invoke-interface {p1, v1}, Landroid/view/SurfaceHolder;->lockCanvas(Landroid/graphics/Rect;)Landroid/graphics/Canvas;

    move-result-object v7

    .line 105
    monitor-enter p1
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 106
    :try_start_1
    invoke-direct {p0, v7}, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->drawImage(Landroid/graphics/Canvas;)V

    .line 107
    monitor-exit p1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 111
    if-eqz v7, :cond_1

    .line 112
    invoke-interface {p1, v7}, Landroid/view/SurfaceHolder;->unlockCanvasAndPost(Landroid/graphics/Canvas;)V

    .line 117
    .end local v0    # "originalSelectedImage":Landroid/graphics/Bitmap;
    .end local v5    # "transformation":Landroid/graphics/Matrix;
    .end local v7    # "canvas":Landroid/graphics/Canvas;
    .end local v9    # "options":Landroid/graphics/BitmapFactory$Options;
    .end local v10    # "sampleSize":I
    :cond_1
    :goto_2
    return-void

    .line 83
    .restart local v0    # "originalSelectedImage":Landroid/graphics/Bitmap;
    .restart local v9    # "options":Landroid/graphics/BitmapFactory$Options;
    .restart local v10    # "sampleSize":I
    :cond_2
    iget v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->originalHeight:F

    iput v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->rotatedHeight:F

    .line 84
    iget v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->originalWidth:F

    iput v2, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->rotatedWidth:F

    goto :goto_0

    .line 99
    .restart local v5    # "transformation":Landroid/graphics/Matrix;
    :cond_3
    iput-object v0, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->selectedImage:Landroid/graphics/Bitmap;

    goto :goto_1

    .line 107
    .restart local v7    # "canvas":Landroid/graphics/Canvas;
    :catchall_0
    move-exception v1

    :try_start_2
    monitor-exit p1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :try_start_3
    throw v1
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 108
    :catch_0
    move-exception v8

    .line 109
    .local v8, "e":Ljava/lang/Exception;
    :try_start_4
    invoke-virtual {v8}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 111
    if-eqz v7, :cond_1

    .line 112
    invoke-interface {p1, v7}, Landroid/view/SurfaceHolder;->unlockCanvasAndPost(Landroid/graphics/Canvas;)V

    goto :goto_2

    .line 111
    .end local v8    # "e":Ljava/lang/Exception;
    :catchall_1
    move-exception v1

    if-eqz v7, :cond_4

    .line 112
    invoke-interface {p1, v7}, Landroid/view/SurfaceHolder;->unlockCanvasAndPost(Landroid/graphics/Canvas;)V

    :cond_4
    throw v1
.end method

.method public surfaceDestroyed(Landroid/view/SurfaceHolder;)V
    .locals 1
    .param p1, "holder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 121
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->selectedImage:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_0

    .line 122
    iget-object v0, p0, Lcom/poshmark/ui/customviews/CropImageSurfaceView;->selectedImage:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    .line 124
    :cond_0
    return-void
.end method
