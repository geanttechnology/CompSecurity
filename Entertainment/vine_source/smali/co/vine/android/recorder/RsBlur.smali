.class public Lco/vine/android/recorder/RsBlur;
.super Ljava/lang/Object;
.source "RsBlur.java"


# instance fields
.field private mAllocationIn:Landroid/support/v8/renderscript/Allocation;

.field private mAllocationOut:Landroid/support/v8/renderscript/Allocation;

.field private mBlur:Landroid/support/v8/renderscript/ScriptIntrinsicBlur;

.field private final mHeight:I

.field private final mWidth:I


# direct methods
.method public constructor <init>(Landroid/support/v8/renderscript/RenderScript;IIF)V
    .locals 3
    .param p1, "rs"    # Landroid/support/v8/renderscript/RenderScript;
    .param p2, "width"    # I
    .param p3, "height"    # I
    .param p4, "radius"    # F

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    iput p2, p0, Lco/vine/android/recorder/RsBlur;->mWidth:I

    .line 33
    iput p3, p0, Lco/vine/android/recorder/RsBlur;->mHeight:I

    .line 34
    new-instance v0, Landroid/support/v8/renderscript/Type$Builder;

    invoke-static {p1}, Landroid/support/v8/renderscript/Element;->RGBA_8888(Landroid/support/v8/renderscript/RenderScript;)Landroid/support/v8/renderscript/Element;

    move-result-object v1

    invoke-direct {v0, p1, v1}, Landroid/support/v8/renderscript/Type$Builder;-><init>(Landroid/support/v8/renderscript/RenderScript;Landroid/support/v8/renderscript/Element;)V

    .line 35
    .local v0, "tb":Landroid/support/v8/renderscript/Type$Builder;
    iget v1, p0, Lco/vine/android/recorder/RsBlur;->mWidth:I

    invoke-virtual {v0, v1}, Landroid/support/v8/renderscript/Type$Builder;->setX(I)Landroid/support/v8/renderscript/Type$Builder;

    .line 36
    iget v1, p0, Lco/vine/android/recorder/RsBlur;->mHeight:I

    invoke-virtual {v0, v1}, Landroid/support/v8/renderscript/Type$Builder;->setY(I)Landroid/support/v8/renderscript/Type$Builder;

    .line 37
    invoke-virtual {v0}, Landroid/support/v8/renderscript/Type$Builder;->create()Landroid/support/v8/renderscript/Type;

    move-result-object v1

    invoke-static {p1, v1}, Landroid/support/v8/renderscript/Allocation;->createTyped(Landroid/support/v8/renderscript/RenderScript;Landroid/support/v8/renderscript/Type;)Landroid/support/v8/renderscript/Allocation;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/recorder/RsBlur;->mAllocationIn:Landroid/support/v8/renderscript/Allocation;

    .line 38
    invoke-virtual {v0}, Landroid/support/v8/renderscript/Type$Builder;->create()Landroid/support/v8/renderscript/Type;

    move-result-object v1

    invoke-static {p1, v1}, Landroid/support/v8/renderscript/Allocation;->createTyped(Landroid/support/v8/renderscript/RenderScript;Landroid/support/v8/renderscript/Type;)Landroid/support/v8/renderscript/Allocation;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/recorder/RsBlur;->mAllocationOut:Landroid/support/v8/renderscript/Allocation;

    .line 39
    invoke-static {p1}, Landroid/support/v8/renderscript/Element;->U8_4(Landroid/support/v8/renderscript/RenderScript;)Landroid/support/v8/renderscript/Element;

    move-result-object v1

    invoke-static {p1, v1}, Landroid/support/v8/renderscript/ScriptIntrinsicBlur;->create(Landroid/support/v8/renderscript/RenderScript;Landroid/support/v8/renderscript/Element;)Landroid/support/v8/renderscript/ScriptIntrinsicBlur;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/recorder/RsBlur;->mBlur:Landroid/support/v8/renderscript/ScriptIntrinsicBlur;

    .line 40
    iget-object v1, p0, Lco/vine/android/recorder/RsBlur;->mBlur:Landroid/support/v8/renderscript/ScriptIntrinsicBlur;

    invoke-virtual {v1, p4}, Landroid/support/v8/renderscript/ScriptIntrinsicBlur;->setRadius(F)V

    .line 41
    iget-object v1, p0, Lco/vine/android/recorder/RsBlur;->mBlur:Landroid/support/v8/renderscript/ScriptIntrinsicBlur;

    iget-object v2, p0, Lco/vine/android/recorder/RsBlur;->mAllocationIn:Landroid/support/v8/renderscript/Allocation;

    invoke-virtual {v1, v2}, Landroid/support/v8/renderscript/ScriptIntrinsicBlur;->setInput(Landroid/support/v8/renderscript/Allocation;)V

    .line 42
    return-void
.end method

.method public constructor <init>(Landroid/support/v8/renderscript/RenderScript;Landroid/graphics/Bitmap;F)V
    .locals 2
    .param p1, "rs"    # Landroid/support/v8/renderscript/RenderScript;
    .param p2, "output"    # Landroid/graphics/Bitmap;
    .param p3, "radius"    # F

    .prologue
    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 53
    invoke-virtual {p2}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v0

    iput v0, p0, Lco/vine/android/recorder/RsBlur;->mWidth:I

    .line 54
    invoke-virtual {p2}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v0

    iput v0, p0, Lco/vine/android/recorder/RsBlur;->mHeight:I

    .line 55
    sget-object v0, Landroid/support/v8/renderscript/Allocation$MipmapControl;->MIPMAP_NONE:Landroid/support/v8/renderscript/Allocation$MipmapControl;

    const/16 v1, 0x80

    invoke-static {p1, p2, v0, v1}, Landroid/support/v8/renderscript/Allocation;->createFromBitmap(Landroid/support/v8/renderscript/RenderScript;Landroid/graphics/Bitmap;Landroid/support/v8/renderscript/Allocation$MipmapControl;I)Landroid/support/v8/renderscript/Allocation;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/RsBlur;->mAllocationOut:Landroid/support/v8/renderscript/Allocation;

    .line 56
    iget-object v0, p0, Lco/vine/android/recorder/RsBlur;->mAllocationOut:Landroid/support/v8/renderscript/Allocation;

    invoke-virtual {v0}, Landroid/support/v8/renderscript/Allocation;->getType()Landroid/support/v8/renderscript/Type;

    move-result-object v0

    invoke-static {p1, v0}, Landroid/support/v8/renderscript/Allocation;->createTyped(Landroid/support/v8/renderscript/RenderScript;Landroid/support/v8/renderscript/Type;)Landroid/support/v8/renderscript/Allocation;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/RsBlur;->mAllocationIn:Landroid/support/v8/renderscript/Allocation;

    .line 57
    invoke-static {p1}, Landroid/support/v8/renderscript/Element;->U8_4(Landroid/support/v8/renderscript/RenderScript;)Landroid/support/v8/renderscript/Element;

    move-result-object v0

    invoke-static {p1, v0}, Landroid/support/v8/renderscript/ScriptIntrinsicBlur;->create(Landroid/support/v8/renderscript/RenderScript;Landroid/support/v8/renderscript/Element;)Landroid/support/v8/renderscript/ScriptIntrinsicBlur;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/RsBlur;->mBlur:Landroid/support/v8/renderscript/ScriptIntrinsicBlur;

    .line 58
    iget-object v0, p0, Lco/vine/android/recorder/RsBlur;->mBlur:Landroid/support/v8/renderscript/ScriptIntrinsicBlur;

    invoke-virtual {v0, p3}, Landroid/support/v8/renderscript/ScriptIntrinsicBlur;->setRadius(F)V

    .line 59
    iget-object v0, p0, Lco/vine/android/recorder/RsBlur;->mBlur:Landroid/support/v8/renderscript/ScriptIntrinsicBlur;

    iget-object v1, p0, Lco/vine/android/recorder/RsBlur;->mAllocationIn:Landroid/support/v8/renderscript/Allocation;

    invoke-virtual {v0, v1}, Landroid/support/v8/renderscript/ScriptIntrinsicBlur;->setInput(Landroid/support/v8/renderscript/Allocation;)V

    .line 60
    return-void
.end method


# virtual methods
.method public execute(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V
    .locals 5
    .param p1, "input"    # Landroid/graphics/Bitmap;
    .param p2, "output"    # Landroid/graphics/Bitmap;

    .prologue
    .line 79
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 80
    .local v0, "start":J
    iget-object v2, p0, Lco/vine/android/recorder/RsBlur;->mAllocationIn:Landroid/support/v8/renderscript/Allocation;

    invoke-virtual {v2, p1}, Landroid/support/v8/renderscript/Allocation;->copyFrom(Landroid/graphics/Bitmap;)V

    .line 81
    iget-object v2, p0, Lco/vine/android/recorder/RsBlur;->mBlur:Landroid/support/v8/renderscript/ScriptIntrinsicBlur;

    iget-object v3, p0, Lco/vine/android/recorder/RsBlur;->mAllocationOut:Landroid/support/v8/renderscript/Allocation;

    invoke-virtual {v2, v3}, Landroid/support/v8/renderscript/ScriptIntrinsicBlur;->forEach(Landroid/support/v8/renderscript/Allocation;)V

    .line 82
    if-eqz p2, :cond_0

    .line 83
    iget-object v2, p0, Lco/vine/android/recorder/RsBlur;->mAllocationOut:Landroid/support/v8/renderscript/Allocation;

    invoke-virtual {v2, p2}, Landroid/support/v8/renderscript/Allocation;->copyTo(Landroid/graphics/Bitmap;)V

    .line 85
    :cond_0
    const-string v2, "RenderScriptBlur took {}ms"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    sub-long/2addr v3, v0

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;)V

    .line 86
    return-void
.end method

.method public execute(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;I)V
    .locals 6
    .param p1, "input"    # Landroid/graphics/Bitmap;
    .param p2, "output"    # Landroid/graphics/Bitmap;
    .param p3, "loop"    # I

    .prologue
    .line 89
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    .line 90
    .local v1, "start":J
    invoke-virtual {p0, p1, p2}, Lco/vine/android/recorder/RsBlur;->execute(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V

    .line 91
    const/4 v0, 0x1

    .local v0, "i":I
    :goto_0
    if-ge v0, p3, :cond_0

    .line 92
    invoke-virtual {p0, p2, p2}, Lco/vine/android/recorder/RsBlur;->execute(Landroid/graphics/Bitmap;Landroid/graphics/Bitmap;)V

    .line 91
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 94
    :cond_0
    const-string v3, "RenderScriptBlur loop took {}ms."

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    sub-long/2addr v4, v1

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;)V

    .line 95
    return-void
.end method

.method public setRadius(F)V
    .locals 1
    .param p1, "radius"    # F

    .prologue
    .line 68
    iget-object v0, p0, Lco/vine/android/recorder/RsBlur;->mBlur:Landroid/support/v8/renderscript/ScriptIntrinsicBlur;

    invoke-virtual {v0, p1}, Landroid/support/v8/renderscript/ScriptIntrinsicBlur;->setRadius(F)V

    .line 69
    return-void
.end method
