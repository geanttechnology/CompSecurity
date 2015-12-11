.class public Lcom/auditude/ads/util/AuditudeUtil$AssetURI;
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
    name = "AssetURI"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 247
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getResult()Ljava/lang/String;
    .locals 1

    .prologue
    .line 251
    # getter for: Lcom/auditude/ads/util/AuditudeUtil;->assetUri:Ljava/lang/String;
    invoke-static {}, Lcom/auditude/ads/util/AuditudeUtil;->access$1()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    # getter for: Lcom/auditude/ads/util/AuditudeUtil;->assetUri:Ljava/lang/String;
    invoke-static {}, Lcom/auditude/ads/util/AuditudeUtil;->access$1()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 253
    # getter for: Lcom/auditude/ads/util/AuditudeUtil;->assetUri:Ljava/lang/String;
    invoke-static {}, Lcom/auditude/ads/util/AuditudeUtil;->access$1()Ljava/lang/String;

    move-result-object v0

    .line 257
    :goto_0
    return-object v0

    :cond_0
    const-string v0, "[ASSETURI]"

    goto :goto_0
.end method
