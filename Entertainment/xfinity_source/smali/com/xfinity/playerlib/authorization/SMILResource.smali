.class public Lcom/xfinity/playerlib/authorization/SMILResource;
.super Ljava/lang/Object;
.source "SMILResource.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final adsBreakStartTimes:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private adsType:Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

.field private final c3Blocks:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;",
            ">;"
        }
    .end annotation
.end field

.field private final signedManifestUrl:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 13
    const-class v0, Lcom/xfinity/playerlib/authorization/SMILResource;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/authorization/SMILResource;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;)V
    .locals 1
    .param p1, "token"    # Ljava/lang/String;

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/authorization/SMILResource;->adsBreakStartTimes:Ljava/util/List;

    .line 23
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/authorization/SMILResource;->c3Blocks:Ljava/util/List;

    .line 26
    iput-object p1, p0, Lcom/xfinity/playerlib/authorization/SMILResource;->signedManifestUrl:Ljava/lang/String;

    .line 27
    return-void
.end method


# virtual methods
.method public addAdsBreakStartTime(I)V
    .locals 2
    .param p1, "time"    # I

    .prologue
    .line 42
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/SMILResource;->adsBreakStartTimes:Ljava/util/List;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 43
    return-void
.end method

.method public addC3Block(Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;)V
    .locals 1
    .param p1, "adBreak"    # Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/SMILResource;->c3Blocks:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 51
    return-void
.end method

.method public getAdsBreakStartTimes()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 46
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/SMILResource;->adsBreakStartTimes:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getAdsType()Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/SMILResource;->adsType:Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

    return-object v0
.end method

.method public getC3Blocks()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/playerplatform/primetime/android/ads/VideoAdBreak;",
            ">;"
        }
    .end annotation

    .prologue
    .line 54
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/SMILResource;->c3Blocks:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getSignedManifestUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/SMILResource;->signedManifestUrl:Ljava/lang/String;

    return-object v0
.end method

.method public setAdsType(Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;)V
    .locals 0
    .param p1, "type"    # Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/xfinity/playerlib/authorization/SMILResource;->adsType:Lcom/xfinity/playerlib/authorization/SMILResource$AdsType;

    .line 35
    return-void
.end method
