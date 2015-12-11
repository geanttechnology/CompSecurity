.class Lco/vine/android/recorder/CameraManager$DummySurfaceHolder;
.super Ljava/lang/Object;
.source "CameraManager.java"

# interfaces
.implements Landroid/view/SurfaceHolder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/recorder/CameraManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "DummySurfaceHolder"
.end annotation


# instance fields
.field private final mSurface:Landroid/view/Surface;


# direct methods
.method public constructor <init>(Landroid/view/Surface;)V
    .locals 0
    .param p1, "surface"    # Landroid/view/Surface;

    .prologue
    .line 1377
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1378
    iput-object p1, p0, Lco/vine/android/recorder/CameraManager$DummySurfaceHolder;->mSurface:Landroid/view/Surface;

    .line 1379
    return-void
.end method


# virtual methods
.method public addCallback(Landroid/view/SurfaceHolder$Callback;)V
    .locals 0
    .param p1, "callback"    # Landroid/view/SurfaceHolder$Callback;

    .prologue
    .line 1384
    return-void
.end method

.method public getSurface()Landroid/view/Surface;
    .locals 1

    .prologue
    .line 1443
    iget-object v0, p0, Lco/vine/android/recorder/CameraManager$DummySurfaceHolder;->mSurface:Landroid/view/Surface;

    return-object v0
.end method

.method public getSurfaceFrame()Landroid/graphics/Rect;
    .locals 1

    .prologue
    .line 1438
    const/4 v0, 0x0

    return-object v0
.end method

.method public isCreating()Z
    .locals 1

    .prologue
    .line 1393
    const/4 v0, 0x0

    return v0
.end method

.method public lockCanvas()Landroid/graphics/Canvas;
    .locals 1

    .prologue
    .line 1423
    const/4 v0, 0x0

    return-object v0
.end method

.method public lockCanvas(Landroid/graphics/Rect;)Landroid/graphics/Canvas;
    .locals 1
    .param p1, "dirty"    # Landroid/graphics/Rect;

    .prologue
    .line 1428
    const/4 v0, 0x0

    return-object v0
.end method

.method public removeCallback(Landroid/view/SurfaceHolder$Callback;)V
    .locals 0
    .param p1, "callback"    # Landroid/view/SurfaceHolder$Callback;

    .prologue
    .line 1389
    return-void
.end method

.method public setFixedSize(II)V
    .locals 0
    .param p1, "width"    # I
    .param p2, "height"    # I

    .prologue
    .line 1404
    return-void
.end method

.method public setFormat(I)V
    .locals 0
    .param p1, "format"    # I

    .prologue
    .line 1414
    return-void
.end method

.method public setKeepScreenOn(Z)V
    .locals 0
    .param p1, "screenOn"    # Z

    .prologue
    .line 1419
    return-void
.end method

.method public setSizeFromLayout()V
    .locals 0

    .prologue
    .line 1409
    return-void
.end method

.method public setType(I)V
    .locals 0
    .param p1, "type"    # I

    .prologue
    .line 1399
    return-void
.end method

.method public unlockCanvasAndPost(Landroid/graphics/Canvas;)V
    .locals 0
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 1434
    return-void
.end method
