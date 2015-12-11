.class public Lcom/amazon/mShop/util/ImageUtil;
.super Ljava/lang/Object;
.source "ImageUtil.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;
    }
.end annotation


# static fields
.field public static final BAD_IMAGE:[B

.field private static final IMAGE_ID:Ljava/util/regex/Pattern;

.field private static final IMAGE_SERVER:Ljava/util/regex/Pattern;

.field private static final STYLECODE_SCALE_HEIGHT:Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;

.field private static final STYLECODE_SCALE_LONGEST:Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;

.field private static final STYLECODE_SCALE_WIDTH:Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;

.field private static final SUFFIX:Ljava/util/regex/Pattern;

.field private static final TRIMMER:Ljava/util/regex/Pattern;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 26
    const-string/jumbo v0, "^https?://(.*images-|media-services\\.integ\\.)amazon\\.com(:[0-9]+)?/images/"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/util/ImageUtil;->IMAGE_SERVER:Ljava/util/regex/Pattern;

    .line 29
    const-string/jumbo v0, ".*/([^./]+)[^/]+$"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/util/ImageUtil;->IMAGE_ID:Ljava/util/regex/Pattern;

    .line 33
    const-string/jumbo v0, "\\._.+_(\\.\\w+)$"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/util/ImageUtil;->TRIMMER:Ljava/util/regex/Pattern;

    .line 36
    const-string/jumbo v0, "(\\.\\w+$)"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/util/ImageUtil;->SUFFIX:Ljava/util/regex/Pattern;

    .line 42
    new-instance v0, Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;

    const-string/jumbo v1, "SL"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/util/ImageUtil;->STYLECODE_SCALE_LONGEST:Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;

    .line 48
    new-instance v0, Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;

    const-string/jumbo v1, "SY"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/util/ImageUtil;->STYLECODE_SCALE_HEIGHT:Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;

    .line 54
    new-instance v0, Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;

    const-string/jumbo v1, "SX"

    invoke-direct {v0, v1}, Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/mShop/util/ImageUtil;->STYLECODE_SCALE_WIDTH:Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;

    .line 56
    const/4 v0, 0x0

    new-array v0, v0, [B

    sput-object v0, Lcom/amazon/mShop/util/ImageUtil;->BAD_IMAGE:[B

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 167
    return-void
.end method

.method static synthetic access$000()Ljava/util/regex/Pattern;
    .locals 1

    .prologue
    .line 8
    sget-object v0, Lcom/amazon/mShop/util/ImageUtil;->SUFFIX:Ljava/util/regex/Pattern;

    return-object v0
.end method

.method public static getImageId(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 115
    invoke-static {p0}, Lcom/amazon/mShop/util/ImageUtil;->isImageUrl(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 116
    sget-object v1, Lcom/amazon/mShop/util/ImageUtil;->IMAGE_ID:Ljava/util/regex/Pattern;

    invoke-virtual {v1, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    .line 117
    .local v0, "m":Ljava/util/regex/Matcher;
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->matches()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 118
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v1

    .line 121
    .end local v0    # "m":Ljava/util/regex/Matcher;
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static getImageUrl(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 141
    invoke-static {p0}, Lcom/amazon/mShop/util/ImageUtil;->isImageUrl(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 142
    sget-object v0, Lcom/amazon/mShop/util/ImageUtil;->TRIMMER:Ljava/util/regex/Pattern;

    invoke-virtual {v0, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    const-string/jumbo v1, "$1"

    invoke-virtual {v0, v1}, Ljava/util/regex/Matcher;->replaceAll(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 145
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static getImageUrl(Ljava/lang/String;I)Ljava/lang/String;
    .locals 2
    .param p0, "url"    # Ljava/lang/String;
    .param p1, "maxDimension"    # I

    .prologue
    .line 73
    invoke-static {p0}, Lcom/amazon/mShop/util/ImageUtil;->isImageUrl(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/amazon/mShop/util/ImageUtil;->STYLECODE_SCALE_LONGEST:Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p0, v1}, Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;->replaceIn(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static getImageUrlWithMaxHeight(Ljava/lang/String;I)Ljava/lang/String;
    .locals 2
    .param p0, "url"    # Ljava/lang/String;
    .param p1, "maxHeight"    # I

    .prologue
    .line 85
    invoke-static {p0}, Lcom/amazon/mShop/util/ImageUtil;->isImageUrl(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Lcom/amazon/mShop/util/ImageUtil;->STYLECODE_SCALE_HEIGHT:Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;

    invoke-static {p1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p0, v1}, Lcom/amazon/mShop/util/ImageUtil$StyleCodePattern;->replaceIn(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static isImageUrl(Ljava/lang/String;)Z
    .locals 1
    .param p0, "url"    # Ljava/lang/String;

    .prologue
    .line 59
    if-eqz p0, :cond_0

    sget-object v0, Lcom/amazon/mShop/util/ImageUtil;->IMAGE_SERVER:Ljava/util/regex/Pattern;

    invoke-virtual {v0, p0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/regex/Matcher;->find()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static sizeOfBitmap(Landroid/graphics/Bitmap;)J
    .locals 2
    .param p0, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 155
    if-nez p0, :cond_0

    .line 156
    const-wide/16 v0, 0x0

    .line 158
    :goto_0
    return-wide v0

    :cond_0
    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getRowBytes()I

    move-result v0

    invoke-virtual {p0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v1

    mul-int/2addr v0, v1

    int-to-long v0, v0

    goto :goto_0
.end method
