.class Lcom/amazon/device/ads/MraidViewableProperty;
.super Lcom/amazon/device/ads/MraidProperty;
.source "MraidProperty.java"


# instance fields
.field private final mViewable:Z


# direct methods
.method constructor <init>(Z)V
    .locals 0
    .param p1, "viewable"    # Z

    .prologue
    .line 87
    invoke-direct {p0}, Lcom/amazon/device/ads/MraidProperty;-><init>()V

    .line 88
    iput-boolean p1, p0, Lcom/amazon/device/ads/MraidViewableProperty;->mViewable:Z

    .line 89
    return-void
.end method

.method public static createWithViewable(Z)Lcom/amazon/device/ads/MraidViewableProperty;
    .locals 1
    .param p0, "viewable"    # Z

    .prologue
    .line 92
    new-instance v0, Lcom/amazon/device/ads/MraidViewableProperty;

    invoke-direct {v0, p0}, Lcom/amazon/device/ads/MraidViewableProperty;-><init>(Z)V

    return-object v0
.end method


# virtual methods
.method public toJsonPair()Ljava/lang/String;
    .locals 2

    .prologue
    .line 97
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "viewable: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v0, p0, Lcom/amazon/device/ads/MraidViewableProperty;->mViewable:Z

    if-eqz v0, :cond_0

    const-string/jumbo v0, "true"

    :goto_0
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_0
    const-string/jumbo v0, "false"

    goto :goto_0
.end method
