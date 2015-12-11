.class public Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;
.super Ljava/lang/Object;
.source "VastAssetRepackagerInfo.java"


# instance fields
.field public domain:Ljava/lang/String;

.field public repackaginEnabled:Ljava/lang/Boolean;

.field public requiredFormat:Ljava/lang/String;

.field public zoneId:I


# direct methods
.method public constructor <init>(Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 3
    .param p1, "repackaginEnabled"    # Ljava/lang/Boolean;
    .param p2, "requiredFormat"    # Ljava/lang/String;
    .param p3, "domain"    # Ljava/lang/String;
    .param p4, "zoneId"    # I

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 5
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;->repackaginEnabled:Ljava/lang/Boolean;

    .line 6
    iput-object v2, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;->requiredFormat:Ljava/lang/String;

    .line 7
    iput-object v2, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;->domain:Ljava/lang/String;

    .line 8
    iput v1, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;->zoneId:I

    .line 12
    iput-object p1, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;->repackaginEnabled:Ljava/lang/Boolean;

    .line 13
    iput-object p2, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;->requiredFormat:Ljava/lang/String;

    .line 14
    iput-object p3, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;->domain:Ljava/lang/String;

    .line 15
    iput p4, p0, Lcom/auditude/ads/network/vast/repackaging/VastAssetRepackagerInfo;->zoneId:I

    .line 16
    return-void
.end method
