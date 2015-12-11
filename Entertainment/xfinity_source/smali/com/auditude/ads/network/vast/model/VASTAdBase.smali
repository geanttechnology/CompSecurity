.class public Lcom/auditude/ads/network/vast/model/VASTAdBase;
.super Ljava/lang/Object;
.source "VASTAdBase.java"


# instance fields
.field public adSystem:Ljava/lang/String;

.field public errorUrl:Ljava/lang/String;

.field private extensions:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private impressionUrls:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;",
            ">;"
        }
    .end annotation
.end field

.field private networkAdId:Ljava/lang/String;

.field private skipOffset:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final addExtension(Ljava/lang/Object;)V
    .locals 1
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    .line 42
    if-nez p1, :cond_0

    .line 49
    :goto_0
    return-void

    .line 44
    :cond_0
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAdBase;->extensions:Ljava/util/ArrayList;

    if-nez v0, :cond_1

    .line 46
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAdBase;->extensions:Ljava/util/ArrayList;

    .line 48
    :cond_1
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAdBase;->extensions:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public final addImpressionUrl(Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;)V
    .locals 1
    .param p1, "trackingUrl"    # Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;

    .prologue
    .line 28
    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 38
    :goto_0
    return-void

    .line 33
    :cond_0
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAdBase;->impressionUrls:Ljava/util/ArrayList;

    if-nez v0, :cond_1

    .line 35
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAdBase;->impressionUrls:Ljava/util/ArrayList;

    .line 37
    :cond_1
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAdBase;->impressionUrls:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public final getImpressionUrls()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;",
            ">;"
        }
    .end annotation

    .prologue
    .line 18
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAdBase;->impressionUrls:Ljava/util/ArrayList;

    return-object v0
.end method

.method public final getNetworkAdId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAdBase;->networkAdId:Ljava/lang/String;

    return-object v0
.end method

.method public final getSkipOffset()Ljava/lang/String;
    .locals 1

    .prologue
    .line 57
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTAdBase;->skipOffset:Ljava/lang/String;

    return-object v0
.end method

.method public final setNetworkAdId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 66
    iput-object p1, p0, Lcom/auditude/ads/network/vast/model/VASTAdBase;->networkAdId:Ljava/lang/String;

    .line 67
    return-void
.end method

.method public final setSkipOffset(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 53
    iput-object p1, p0, Lcom/auditude/ads/network/vast/model/VASTAdBase;->skipOffset:Ljava/lang/String;

    .line 54
    return-void
.end method
