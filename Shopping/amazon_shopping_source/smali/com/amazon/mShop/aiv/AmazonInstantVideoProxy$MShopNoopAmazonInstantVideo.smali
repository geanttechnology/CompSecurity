.class Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$MShopNoopAmazonInstantVideo;
.super Ljava/lang/Object;
.source "AmazonInstantVideoProxy.java"

# interfaces
.implements Lcom/amazon/avod/MShopAmazonInstantVideo;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "MShopNoopAmazonInstantVideo"
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 205
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$1;

    .prologue
    .line 205
    invoke-direct {p0}, Lcom/amazon/mShop/aiv/AmazonInstantVideoProxy$MShopNoopAmazonInstantVideo;-><init>()V

    return-void
.end method


# virtual methods
.method public forceRefreshAccount()V
    .locals 0

    .prologue
    .line 240
    return-void
.end method

.method public getGroverRecommendations()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 254
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getGroverRecommendationsTTLMillis()J
    .locals 2

    .prologue
    .line 260
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public isAIVBeta()Z
    .locals 1

    .prologue
    .line 229
    const/4 v0, 0x0

    return v0
.end method

.method public isPlaybackSustainable()Z
    .locals 1

    .prologue
    .line 234
    const/4 v0, 0x0

    return v0
.end method

.method public isSupported()Z
    .locals 1

    .prologue
    .line 209
    const/4 v0, 0x0

    return v0
.end method

.method public refreshUserData()V
    .locals 0

    .prologue
    .line 245
    return-void
.end method

.method public startPlayback(Landroid/app/Activity;Ljava/lang/String;J)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "asin"    # Ljava/lang/String;
    .param p3, "timecode"    # J

    .prologue
    .line 220
    return-void
.end method

.method public startTrailer(Landroid/app/Activity;Ljava/lang/String;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "asin"    # Ljava/lang/String;

    .prologue
    .line 225
    return-void
.end method

.method public verifyAndroidRuntime(Landroid/app/Activity;Ljava/lang/Runnable;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "runnable"    # Ljava/lang/Runnable;

    .prologue
    .line 250
    return-void
.end method

.method public whisperCache(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 215
    .local p1, "asins":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    return-void
.end method
