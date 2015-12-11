.class public Lco/vine/android/recorder/RsYuv;
.super Ljava/lang/Object;
.source "RsYuv.java"


# instance fields
.field private mAllocationIn:Landroid/support/v8/renderscript/Allocation;

.field private mAllocationOut:Landroid/support/v8/renderscript/Allocation;

.field private mYuv:Landroid/support/v8/renderscript/ScriptIntrinsicYuvToRGB;


# direct methods
.method public constructor <init>(Landroid/support/v8/renderscript/RenderScript;II)V
    .locals 6
    .param p1, "rs"    # Landroid/support/v8/renderscript/RenderScript;
    .param p2, "width"    # I
    .param p3, "height"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lco/vine/android/VineNotSupportedException;
        }
    .end annotation

    .prologue
    .line 33
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    :try_start_0
    invoke-static {p1}, Landroid/support/v8/renderscript/Element;->RGBA_8888(Landroid/support/v8/renderscript/RenderScript;)Landroid/support/v8/renderscript/Element;

    move-result-object v2

    invoke-static {p1, v2}, Landroid/support/v8/renderscript/ScriptIntrinsicYuvToRGB;->create(Landroid/support/v8/renderscript/RenderScript;Landroid/support/v8/renderscript/Element;)Landroid/support/v8/renderscript/ScriptIntrinsicYuvToRGB;

    move-result-object v2

    iput-object v2, p0, Lco/vine/android/recorder/RsYuv;->mYuv:Landroid/support/v8/renderscript/ScriptIntrinsicYuvToRGB;

    .line 37
    new-instance v1, Landroid/support/v8/renderscript/Type$Builder;

    invoke-static {p1}, Landroid/support/v8/renderscript/Element;->RGBA_8888(Landroid/support/v8/renderscript/RenderScript;)Landroid/support/v8/renderscript/Element;

    move-result-object v2

    invoke-direct {v1, p1, v2}, Landroid/support/v8/renderscript/Type$Builder;-><init>(Landroid/support/v8/renderscript/RenderScript;Landroid/support/v8/renderscript/Element;)V

    .line 38
    .local v1, "tb":Landroid/support/v8/renderscript/Type$Builder;
    invoke-virtual {v1, p2}, Landroid/support/v8/renderscript/Type$Builder;->setX(I)Landroid/support/v8/renderscript/Type$Builder;

    .line 39
    invoke-virtual {v1, p3}, Landroid/support/v8/renderscript/Type$Builder;->setY(I)Landroid/support/v8/renderscript/Type$Builder;

    .line 41
    invoke-virtual {v1}, Landroid/support/v8/renderscript/Type$Builder;->create()Landroid/support/v8/renderscript/Type;

    move-result-object v2

    invoke-static {p1, v2}, Landroid/support/v8/renderscript/Allocation;->createTyped(Landroid/support/v8/renderscript/RenderScript;Landroid/support/v8/renderscript/Type;)Landroid/support/v8/renderscript/Allocation;

    move-result-object v2

    iput-object v2, p0, Lco/vine/android/recorder/RsYuv;->mAllocationOut:Landroid/support/v8/renderscript/Allocation;

    .line 42
    invoke-static {p1}, Landroid/support/v8/renderscript/Element;->U8(Landroid/support/v8/renderscript/RenderScript;)Landroid/support/v8/renderscript/Element;

    move-result-object v2

    mul-int v3, p3, p2

    div-int/lit8 v4, p3, 0x2

    div-int/lit8 v5, p2, 0x2

    mul-int/2addr v4, v5

    mul-int/lit8 v4, v4, 0x2

    add-int/2addr v3, v4

    invoke-static {p1, v2, v3}, Landroid/support/v8/renderscript/Allocation;->createSized(Landroid/support/v8/renderscript/RenderScript;Landroid/support/v8/renderscript/Element;I)Landroid/support/v8/renderscript/Allocation;

    move-result-object v2

    iput-object v2, p0, Lco/vine/android/recorder/RsYuv;->mAllocationIn:Landroid/support/v8/renderscript/Allocation;
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 47
    iget-object v2, p0, Lco/vine/android/recorder/RsYuv;->mYuv:Landroid/support/v8/renderscript/ScriptIntrinsicYuvToRGB;

    iget-object v3, p0, Lco/vine/android/recorder/RsYuv;->mAllocationIn:Landroid/support/v8/renderscript/Allocation;

    invoke-virtual {v2, v3}, Landroid/support/v8/renderscript/ScriptIntrinsicYuvToRGB;->setInput(Landroid/support/v8/renderscript/Allocation;)V

    .line 48
    return-void

    .line 44
    .end local v1    # "tb":Landroid/support/v8/renderscript/Type$Builder;
    :catch_0
    move-exception v0

    .line 45
    .local v0, "e":Ljava/lang/Throwable;
    new-instance v2, Lco/vine/android/VineNotSupportedException;

    invoke-direct {v2}, Lco/vine/android/VineNotSupportedException;-><init>()V

    throw v2
.end method


# virtual methods
.method public execute([BLandroid/graphics/Bitmap;)V
    .locals 2
    .param p1, "yuv"    # [B
    .param p2, "b"    # Landroid/graphics/Bitmap;

    .prologue
    .line 51
    iget-object v0, p0, Lco/vine/android/recorder/RsYuv;->mAllocationIn:Landroid/support/v8/renderscript/Allocation;

    invoke-virtual {v0, p1}, Landroid/support/v8/renderscript/Allocation;->copyFrom([B)V

    .line 52
    iget-object v0, p0, Lco/vine/android/recorder/RsYuv;->mYuv:Landroid/support/v8/renderscript/ScriptIntrinsicYuvToRGB;

    iget-object v1, p0, Lco/vine/android/recorder/RsYuv;->mAllocationOut:Landroid/support/v8/renderscript/Allocation;

    invoke-virtual {v0, v1}, Landroid/support/v8/renderscript/ScriptIntrinsicYuvToRGB;->forEach(Landroid/support/v8/renderscript/Allocation;)V

    .line 53
    iget-object v0, p0, Lco/vine/android/recorder/RsYuv;->mAllocationOut:Landroid/support/v8/renderscript/Allocation;

    invoke-virtual {v0, p2}, Landroid/support/v8/renderscript/Allocation;->copyTo(Landroid/graphics/Bitmap;)V

    .line 54
    return-void
.end method
