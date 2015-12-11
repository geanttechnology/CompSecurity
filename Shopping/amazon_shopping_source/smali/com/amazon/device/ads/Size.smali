.class Lcom/amazon/device/ads/Size;
.super Ljava/lang/Object;
.source "Size.java"


# instance fields
.field private final height:I

.field private final width:I


# direct methods
.method public constructor <init>(II)V
    .locals 0
    .param p1, "width"    # I
    .param p2, "height"    # I

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput p1, p0, Lcom/amazon/device/ads/Size;->width:I

    .line 24
    iput p2, p0, Lcom/amazon/device/ads/Size;->height:I

    .line 25
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 6
    .param p1, "screenSize"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    const/4 v2, 0x0

    .line 34
    .local v2, "width":I
    const/4 v1, 0x0

    .line 36
    .local v1, "height":I
    if-eqz p1, :cond_0

    .line 38
    const-string/jumbo v3, "x"

    invoke-virtual {p1, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 40
    .local v0, "dimensions":[Ljava/lang/String;
    if-eqz v0, :cond_0

    array-length v3, v0

    const/4 v4, 0x2

    if-ne v3, v4, :cond_0

    .line 43
    aget-object v3, v0, v5

    invoke-static {v3, v5}, Lcom/amazon/device/ads/Size;->parseInt(Ljava/lang/String;I)I

    move-result v3

    invoke-static {v3, v5}, Ljava/lang/Math;->max(II)I

    move-result v2

    .line 44
    const/4 v3, 0x1

    aget-object v3, v0, v3

    invoke-static {v3, v5}, Lcom/amazon/device/ads/Size;->parseInt(Ljava/lang/String;I)I

    move-result v3

    invoke-static {v3, v5}, Ljava/lang/Math;->max(II)I

    move-result v1

    .line 47
    .end local v0    # "dimensions":[Ljava/lang/String;
    :cond_0
    iput v2, p0, Lcom/amazon/device/ads/Size;->width:I

    .line 48
    iput v1, p0, Lcom/amazon/device/ads/Size;->height:I

    .line 49
    return-void
.end method

.method private static parseInt(Ljava/lang/String;I)I
    .locals 1
    .param p0, "str"    # Ljava/lang/String;
    .param p1, "defaultValue"    # I

    .prologue
    .line 88
    :try_start_0
    invoke-static {p0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result p1

    .line 92
    .end local p1    # "defaultValue":I
    :goto_0
    return p1

    .line 90
    .restart local p1    # "defaultValue":I
    :catch_0
    move-exception v0

    .line 92
    .local v0, "nfe":Ljava/lang/NumberFormatException;
    goto :goto_0
.end method


# virtual methods
.method public getHeight()I
    .locals 1

    .prologue
    .line 66
    iget v0, p0, Lcom/amazon/device/ads/Size;->height:I

    return v0
.end method

.method public getWidth()I
    .locals 1

    .prologue
    .line 57
    iget v0, p0, Lcom/amazon/device/ads/Size;->width:I

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 75
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget v1, p0, Lcom/amazon/device/ads/Size;->width:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "x"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/amazon/device/ads/Size;->height:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
