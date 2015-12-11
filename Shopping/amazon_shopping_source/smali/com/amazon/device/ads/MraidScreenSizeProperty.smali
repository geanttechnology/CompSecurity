.class Lcom/amazon/device/ads/MraidScreenSizeProperty;
.super Lcom/amazon/device/ads/MraidProperty;
.source "MraidProperty.java"


# instance fields
.field private final mScreenHeight:I

.field private final mScreenWidth:I


# direct methods
.method constructor <init>(II)V
    .locals 0
    .param p1, "width"    # I
    .param p2, "height"    # I

    .prologue
    .line 52
    invoke-direct {p0}, Lcom/amazon/device/ads/MraidProperty;-><init>()V

    .line 53
    iput p1, p0, Lcom/amazon/device/ads/MraidScreenSizeProperty;->mScreenWidth:I

    .line 54
    iput p2, p0, Lcom/amazon/device/ads/MraidScreenSizeProperty;->mScreenHeight:I

    .line 55
    return-void
.end method

.method public static createWithSize(II)Lcom/amazon/device/ads/MraidScreenSizeProperty;
    .locals 1
    .param p0, "width"    # I
    .param p1, "height"    # I

    .prologue
    .line 58
    new-instance v0, Lcom/amazon/device/ads/MraidScreenSizeProperty;

    invoke-direct {v0, p0, p1}, Lcom/amazon/device/ads/MraidScreenSizeProperty;-><init>(II)V

    return-object v0
.end method


# virtual methods
.method public toJsonPair()Ljava/lang/String;
    .locals 2

    .prologue
    .line 63
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "screenSize: { width: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/amazon/device/ads/MraidScreenSizeProperty;->mScreenWidth:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", height: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/amazon/device/ads/MraidScreenSizeProperty;->mScreenHeight:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, " }"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
