.class public Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;
.super Ljava/lang/Object;
.source "VASTTrackingUrl.java"


# instance fields
.field private offset:I

.field private offsetIsPercent:Ljava/lang/Boolean;

.field private type:Ljava/lang/String;

.field private url:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "type"    # Ljava/lang/String;

    .prologue
    const/4 v0, 0x0

    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 7
    iput v0, p0, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;->offset:I

    .line 8
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;->offsetIsPercent:Ljava/lang/Boolean;

    .line 12
    iput-object p2, p0, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;->type:Ljava/lang/String;

    .line 13
    iput-object p1, p0, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;->url:Ljava/lang/String;

    .line 14
    return-void
.end method


# virtual methods
.method public final getOffset()I
    .locals 1

    .prologue
    .line 36
    iget v0, p0, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;->offset:I

    return v0
.end method

.method public final getOffsetIsPercent()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;->offsetIsPercent:Ljava/lang/Boolean;

    return-object v0
.end method

.method public final getUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;->url:Ljava/lang/String;

    return-object v0
.end method

.method public final setOffset(I)V
    .locals 0
    .param p1, "value"    # I

    .prologue
    .line 40
    iput p1, p0, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;->offset:I

    .line 41
    return-void
.end method

.method public final setOffsetIsPercent(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value"    # Ljava/lang/Boolean;

    .prologue
    .line 49
    iput-object p1, p0, Lcom/auditude/ads/network/vast/model/VASTTrackingUrl;->offsetIsPercent:Ljava/lang/Boolean;

    .line 50
    return-void
.end method
