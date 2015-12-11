.class public Lcom/auditude/ads/util/AuditudeUtil$PageUrlTagResult;
.super Ljava/lang/Object;
.source "AuditudeUtil.java"

# interfaces
.implements Lcom/auditude/ads/util/AuditudeUtil$ITagResult;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/auditude/ads/util/AuditudeUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "PageUrlTagResult"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 214
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getResult()Ljava/lang/String;
    .locals 1

    .prologue
    .line 220
    :try_start_0
    invoke-static {}, Lcom/auditude/ads/util/BrowserUtil;->getPageUrl()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 224
    :goto_0
    return-object v0

    .line 222
    :catch_0
    move-exception v0

    .line 224
    const-string v0, ""

    goto :goto_0
.end method
