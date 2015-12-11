.class public Lcom/auditude/ads/network/vast/model/VASTClick;
.super Ljava/lang/Object;
.source "VASTClick.java"


# instance fields
.field private customClickUrls:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private trackingUrls:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 5
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final addClickTrackingUrl(Ljava/lang/String;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 40
    invoke-static {p1}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 50
    :goto_0
    return-void

    .line 45
    :cond_0
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTClick;->trackingUrls:Ljava/util/ArrayList;

    if-nez v0, :cond_1

    .line 47
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTClick;->trackingUrls:Ljava/util/ArrayList;

    .line 49
    :cond_1
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTClick;->trackingUrls:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public final addCustomClickUrl(Ljava/lang/String;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 54
    invoke-static {p1}, Lcom/auditude/ads/util/StringUtil;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 64
    :goto_0
    return-void

    .line 59
    :cond_0
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTClick;->customClickUrls:Ljava/util/ArrayList;

    if-nez v0, :cond_1

    .line 61
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTClick;->customClickUrls:Ljava/util/ArrayList;

    .line 63
    :cond_1
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTClick;->customClickUrls:Ljava/util/ArrayList;

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
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 22
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTClick;->trackingUrls:Ljava/util/ArrayList;

    return-object v0
.end method

.method public final getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 13
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTClick;->url:Ljava/lang/String;

    return-object v0
.end method

.method public final setUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/String;

    .prologue
    .line 17
    iput-object p1, p0, Lcom/auditude/ads/network/vast/model/VASTClick;->url:Ljava/lang/String;

    .line 18
    return-void
.end method
