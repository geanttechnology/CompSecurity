.class public Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;
.super Ljava/lang/Object;
.source "VASTTrackingEvent.java"


# instance fields
.field private trackingUrls:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;",
            ">;"
        }
    .end annotation
.end field

.field public type:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    iput-object p1, p0, Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;->type:Ljava/lang/String;

    .line 16
    return-void
.end method


# virtual methods
.method public final addTrackingUrl(Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;)V
    .locals 1
    .param p1, "trackingUrl"    # Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;

    .prologue
    .line 25
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/auditude/ads/util/StringUtil;->isNotNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 34
    :cond_0
    :goto_0
    return-void

    .line 29
    :cond_1
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;->trackingUrls:Ljava/util/ArrayList;

    if-nez v0, :cond_2

    .line 31
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;->trackingUrls:Ljava/util/ArrayList;

    .line 33
    :cond_2
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;->trackingUrls:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public final getTrackingUrls()Ljava/util/ArrayList;
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
    .line 20
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTTrackingEvent;->trackingUrls:Ljava/util/ArrayList;

    return-object v0
.end method
