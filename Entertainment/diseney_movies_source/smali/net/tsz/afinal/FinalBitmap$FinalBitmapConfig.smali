.class Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;
.super Ljava/lang/Object;
.source "FinalBitmap.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lnet/tsz/afinal/FinalBitmap;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "FinalBitmapConfig"
.end annotation


# instance fields
.field public bitmapProcess:Lnet/tsz/afinal/bitmap/core/BitmapProcess;

.field public cachePath:Ljava/lang/String;

.field public defaultDisplayConfig:Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

.field public diskCacheSize:I

.field public displayer:Lnet/tsz/afinal/bitmap/display/Displayer;

.field public downloader:Lnet/tsz/afinal/bitmap/download/Downloader;

.field public memCacheSize:I

.field public memCacheSizePercent:F

.field public originalDiskCacheSize:I

.field public poolSize:I

.field final synthetic this$0:Lnet/tsz/afinal/FinalBitmap;


# direct methods
.method public constructor <init>(Lnet/tsz/afinal/FinalBitmap;Landroid/content/Context;)V
    .locals 4
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 949
    iput-object p1, p0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->this$0:Lnet/tsz/afinal/FinalBitmap;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 945
    const/4 v2, 0x3

    iput v2, p0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->poolSize:I

    .line 946
    const/high16 v2, 0x1e00000

    iput v2, p0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->originalDiskCacheSize:I

    .line 950
    new-instance v2, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    invoke-direct {v2}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;-><init>()V

    iput-object v2, p0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->defaultDisplayConfig:Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    .line 952
    iget-object v2, p0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->defaultDisplayConfig:Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->setAnimation(Landroid/view/animation/Animation;)V

    .line 953
    iget-object v2, p0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->defaultDisplayConfig:Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->setAnimationType(I)V

    .line 956
    invoke-virtual {p2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v1

    .line 957
    .local v1, "displayMetrics":Landroid/util/DisplayMetrics;
    iget v2, v1, Landroid/util/DisplayMetrics;->widthPixels:I

    div-int/lit8 v2, v2, 0x4

    int-to-double v2, v2

    invoke-static {v2, v3}, Ljava/lang/Math;->floor(D)D

    move-result-wide v2

    double-to-int v0, v2

    .line 958
    .local v0, "defaultWidth":I
    iget-object v2, p0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->defaultDisplayConfig:Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    invoke-virtual {v2, v0}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->setBitmapHeight(I)V

    .line 959
    iget-object v2, p0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->defaultDisplayConfig:Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;

    invoke-virtual {v2, v0}, Lnet/tsz/afinal/bitmap/core/BitmapDisplayConfig;->setBitmapWidth(I)V

    .line 961
    return-void
.end method


# virtual methods
.method public init()V
    .locals 4

    .prologue
    .line 964
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->downloader:Lnet/tsz/afinal/bitmap/download/Downloader;

    if-nez v0, :cond_0

    .line 965
    new-instance v0, Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader;

    invoke-direct {v0}, Lnet/tsz/afinal/bitmap/download/SimpleHttpDownloader;-><init>()V

    iput-object v0, p0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->downloader:Lnet/tsz/afinal/bitmap/download/Downloader;

    .line 967
    :cond_0
    iget-object v0, p0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->displayer:Lnet/tsz/afinal/bitmap/display/Displayer;

    if-nez v0, :cond_1

    .line 968
    new-instance v0, Lnet/tsz/afinal/bitmap/display/SimpleDisplayer;

    invoke-direct {v0}, Lnet/tsz/afinal/bitmap/display/SimpleDisplayer;-><init>()V

    iput-object v0, p0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->displayer:Lnet/tsz/afinal/bitmap/display/Displayer;

    .line 970
    :cond_1
    new-instance v0, Lnet/tsz/afinal/bitmap/core/BitmapProcess;

    iget-object v1, p0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->downloader:Lnet/tsz/afinal/bitmap/download/Downloader;

    iget-object v2, p0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->cachePath:Ljava/lang/String;

    iget v3, p0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->originalDiskCacheSize:I

    invoke-direct {v0, v1, v2, v3}, Lnet/tsz/afinal/bitmap/core/BitmapProcess;-><init>(Lnet/tsz/afinal/bitmap/download/Downloader;Ljava/lang/String;I)V

    iput-object v0, p0, Lnet/tsz/afinal/FinalBitmap$FinalBitmapConfig;->bitmapProcess:Lnet/tsz/afinal/bitmap/core/BitmapProcess;

    .line 971
    return-void
.end method
