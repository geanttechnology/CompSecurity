.class final Lcom/ant/liao/GifDrawable$BitmapState;
.super Landroid/graphics/drawable/Drawable$ConstantState;
.source "GifDrawable.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/ant/liao/GifDrawable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x18
    name = "BitmapState"
.end annotation


# instance fields
.field mBitmap:Landroid/graphics/Bitmap;

.field mChangingConfigurations:I

.field mGravity:I

.field mPaint:Landroid/graphics/Paint;

.field mRebuildShader:Z

.field mTargetDensity:I

.field mTileModeX:Landroid/graphics/Shader$TileMode;

.field mTileModeY:Landroid/graphics/Shader$TileMode;


# direct methods
.method constructor <init>(Landroid/graphics/Bitmap;)V
    .locals 3
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    const/4 v2, 0x0

    .line 660
    invoke-direct {p0}, Landroid/graphics/drawable/Drawable$ConstantState;-><init>()V

    .line 653
    const/16 v0, 0x77

    iput v0, p0, Lcom/ant/liao/GifDrawable$BitmapState;->mGravity:I

    .line 654
    new-instance v0, Landroid/graphics/Paint;

    const/4 v1, 0x6

    invoke-direct {v0, v1}, Landroid/graphics/Paint;-><init>(I)V

    iput-object v0, p0, Lcom/ant/liao/GifDrawable$BitmapState;->mPaint:Landroid/graphics/Paint;

    .line 655
    iput-object v2, p0, Lcom/ant/liao/GifDrawable$BitmapState;->mTileModeX:Landroid/graphics/Shader$TileMode;

    .line 656
    iput-object v2, p0, Lcom/ant/liao/GifDrawable$BitmapState;->mTileModeY:Landroid/graphics/Shader$TileMode;

    .line 657
    const/16 v0, 0xa0

    iput v0, p0, Lcom/ant/liao/GifDrawable$BitmapState;->mTargetDensity:I

    .line 661
    iput-object p1, p0, Lcom/ant/liao/GifDrawable$BitmapState;->mBitmap:Landroid/graphics/Bitmap;

    .line 662
    return-void
.end method

.method constructor <init>(Lcom/ant/liao/GifDrawable$BitmapState;)V
    .locals 2
    .param p1, "bitmapState"    # Lcom/ant/liao/GifDrawable$BitmapState;

    .prologue
    .line 665
    iget-object v0, p1, Lcom/ant/liao/GifDrawable$BitmapState;->mBitmap:Landroid/graphics/Bitmap;

    invoke-direct {p0, v0}, Lcom/ant/liao/GifDrawable$BitmapState;-><init>(Landroid/graphics/Bitmap;)V

    .line 666
    iget v0, p1, Lcom/ant/liao/GifDrawable$BitmapState;->mChangingConfigurations:I

    iput v0, p0, Lcom/ant/liao/GifDrawable$BitmapState;->mChangingConfigurations:I

    .line 667
    iget v0, p1, Lcom/ant/liao/GifDrawable$BitmapState;->mGravity:I

    iput v0, p0, Lcom/ant/liao/GifDrawable$BitmapState;->mGravity:I

    .line 668
    iget-object v0, p1, Lcom/ant/liao/GifDrawable$BitmapState;->mTileModeX:Landroid/graphics/Shader$TileMode;

    iput-object v0, p0, Lcom/ant/liao/GifDrawable$BitmapState;->mTileModeX:Landroid/graphics/Shader$TileMode;

    .line 669
    iget-object v0, p1, Lcom/ant/liao/GifDrawable$BitmapState;->mTileModeY:Landroid/graphics/Shader$TileMode;

    iput-object v0, p0, Lcom/ant/liao/GifDrawable$BitmapState;->mTileModeY:Landroid/graphics/Shader$TileMode;

    .line 670
    iget v0, p1, Lcom/ant/liao/GifDrawable$BitmapState;->mTargetDensity:I

    iput v0, p0, Lcom/ant/liao/GifDrawable$BitmapState;->mTargetDensity:I

    .line 671
    new-instance v0, Landroid/graphics/Paint;

    iget-object v1, p1, Lcom/ant/liao/GifDrawable$BitmapState;->mPaint:Landroid/graphics/Paint;

    invoke-direct {v0, v1}, Landroid/graphics/Paint;-><init>(Landroid/graphics/Paint;)V

    iput-object v0, p0, Lcom/ant/liao/GifDrawable$BitmapState;->mPaint:Landroid/graphics/Paint;

    .line 672
    iget-boolean v0, p1, Lcom/ant/liao/GifDrawable$BitmapState;->mRebuildShader:Z

    iput-boolean v0, p0, Lcom/ant/liao/GifDrawable$BitmapState;->mRebuildShader:Z

    .line 673
    return-void
.end method


# virtual methods
.method public getChangingConfigurations()I
    .locals 1

    .prologue
    .line 687
    iget v0, p0, Lcom/ant/liao/GifDrawable$BitmapState;->mChangingConfigurations:I

    return v0
.end method

.method public newDrawable()Landroid/graphics/drawable/Drawable;
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 677
    new-instance v0, Lcom/ant/liao/GifDrawable;

    invoke-direct {v0, p0, v1, v1}, Lcom/ant/liao/GifDrawable;-><init>(Lcom/ant/liao/GifDrawable$BitmapState;Landroid/content/res/Resources;Lcom/ant/liao/GifDrawable;)V

    return-object v0
.end method

.method public newDrawable(Landroid/content/res/Resources;)Landroid/graphics/drawable/Drawable;
    .locals 2
    .param p1, "res"    # Landroid/content/res/Resources;

    .prologue
    .line 682
    new-instance v0, Lcom/ant/liao/GifDrawable;

    const/4 v1, 0x0

    invoke-direct {v0, p0, p1, v1}, Lcom/ant/liao/GifDrawable;-><init>(Lcom/ant/liao/GifDrawable$BitmapState;Landroid/content/res/Resources;Lcom/ant/liao/GifDrawable;)V

    return-object v0
.end method
