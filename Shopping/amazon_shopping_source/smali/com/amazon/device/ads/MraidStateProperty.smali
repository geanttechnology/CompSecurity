.class Lcom/amazon/device/ads/MraidStateProperty;
.super Lcom/amazon/device/ads/MraidProperty;
.source "MraidProperty.java"


# instance fields
.field private final mViewState:Lcom/amazon/device/ads/MraidView$ViewState;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/MraidView$ViewState;)V
    .locals 0
    .param p1, "viewState"    # Lcom/amazon/device/ads/MraidView$ViewState;

    .prologue
    .line 70
    invoke-direct {p0}, Lcom/amazon/device/ads/MraidProperty;-><init>()V

    .line 71
    iput-object p1, p0, Lcom/amazon/device/ads/MraidStateProperty;->mViewState:Lcom/amazon/device/ads/MraidView$ViewState;

    .line 72
    return-void
.end method

.method public static createWithViewState(Lcom/amazon/device/ads/MraidView$ViewState;)Lcom/amazon/device/ads/MraidStateProperty;
    .locals 1
    .param p0, "viewState"    # Lcom/amazon/device/ads/MraidView$ViewState;

    .prologue
    .line 75
    new-instance v0, Lcom/amazon/device/ads/MraidStateProperty;

    invoke-direct {v0, p0}, Lcom/amazon/device/ads/MraidStateProperty;-><init>(Lcom/amazon/device/ads/MraidView$ViewState;)V

    return-object v0
.end method


# virtual methods
.method public toJsonPair()Ljava/lang/String;
    .locals 3

    .prologue
    .line 80
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "state: \'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/device/ads/MraidStateProperty;->mViewState:Lcom/amazon/device/ads/MraidView$ViewState;

    invoke-virtual {v1}, Lcom/amazon/device/ads/MraidView$ViewState;->toString()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
