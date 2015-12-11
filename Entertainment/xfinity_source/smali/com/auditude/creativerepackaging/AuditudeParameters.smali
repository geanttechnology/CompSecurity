.class public Lcom/auditude/creativerepackaging/AuditudeParameters;
.super Ljava/lang/Object;
.source "AuditudeParameters.java"


# instance fields
.field private adId:Ljava/lang/String;

.field private domain:Ljava/lang/String;

.field private externalAdId:Ljava/lang/String;

.field private zoneId:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAdId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/auditude/creativerepackaging/AuditudeParameters;->adId:Ljava/lang/String;

    return-object v0
.end method

.method public getDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lcom/auditude/creativerepackaging/AuditudeParameters;->domain:Ljava/lang/String;

    return-object v0
.end method

.method public getExternalAdId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/auditude/creativerepackaging/AuditudeParameters;->externalAdId:Ljava/lang/String;

    return-object v0
.end method

.method public getZoneId()I
    .locals 1

    .prologue
    .line 37
    iget v0, p0, Lcom/auditude/creativerepackaging/AuditudeParameters;->zoneId:I

    return v0
.end method

.method public setAdId(Ljava/lang/String;)V
    .locals 0
    .param p1, "adId"    # Ljava/lang/String;

    .prologue
    .line 66
    iput-object p1, p0, Lcom/auditude/creativerepackaging/AuditudeParameters;->adId:Ljava/lang/String;

    .line 67
    return-void
.end method

.method public setDomain(Ljava/lang/String;)V
    .locals 0
    .param p1, "domain"    # Ljava/lang/String;

    .prologue
    .line 29
    iput-object p1, p0, Lcom/auditude/creativerepackaging/AuditudeParameters;->domain:Ljava/lang/String;

    .line 30
    return-void
.end method

.method public setExternalAdId(Ljava/lang/String;)V
    .locals 0
    .param p1, "externalAdId"    # Ljava/lang/String;

    .prologue
    .line 84
    iput-object p1, p0, Lcom/auditude/creativerepackaging/AuditudeParameters;->externalAdId:Ljava/lang/String;

    .line 85
    return-void
.end method

.method public setZoneId(I)V
    .locals 0
    .param p1, "zoneId"    # I

    .prologue
    .line 47
    iput p1, p0, Lcom/auditude/creativerepackaging/AuditudeParameters;->zoneId:I

    .line 48
    return-void
.end method
