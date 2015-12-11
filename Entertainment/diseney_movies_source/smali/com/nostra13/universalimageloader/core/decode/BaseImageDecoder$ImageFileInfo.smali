.class public Lcom/nostra13/universalimageloader/core/decode/BaseImageDecoder$ImageFileInfo;
.super Ljava/lang/Object;
.source "BaseImageDecoder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/nostra13/universalimageloader/core/decode/BaseImageDecoder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xc
    name = "ImageFileInfo"
.end annotation


# instance fields
.field final exif:Lcom/nostra13/universalimageloader/core/decode/BaseImageDecoder$ExifInfo;

.field final imageSize:Lcom/nostra13/universalimageloader/core/assist/ImageSize;


# direct methods
.method constructor <init>(Lcom/nostra13/universalimageloader/core/assist/ImageSize;Lcom/nostra13/universalimageloader/core/decode/BaseImageDecoder$ExifInfo;)V
    .locals 0
    .param p1, "imageSize"    # Lcom/nostra13/universalimageloader/core/assist/ImageSize;
    .param p2, "exif"    # Lcom/nostra13/universalimageloader/core/decode/BaseImageDecoder$ExifInfo;

    .prologue
    .line 223
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 224
    iput-object p1, p0, Lcom/nostra13/universalimageloader/core/decode/BaseImageDecoder$ImageFileInfo;->imageSize:Lcom/nostra13/universalimageloader/core/assist/ImageSize;

    .line 225
    iput-object p2, p0, Lcom/nostra13/universalimageloader/core/decode/BaseImageDecoder$ImageFileInfo;->exif:Lcom/nostra13/universalimageloader/core/decode/BaseImageDecoder$ExifInfo;

    .line 226
    return-void
.end method
