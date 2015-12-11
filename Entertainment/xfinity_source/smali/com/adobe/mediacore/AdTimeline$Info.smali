.class public Lcom/adobe/mediacore/AdTimeline$Info;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/AdTimeline;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Info"
.end annotation


# instance fields
.field private final _ad:Lcom/adobe/mediacore/timeline/advertising/Ad;

.field private final _adBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;


# direct methods
.method private constructor <init>(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/adobe/mediacore/AdTimeline$Info;->_adBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    iput-object p2, p0, Lcom/adobe/mediacore/AdTimeline$Info;->_ad:Lcom/adobe/mediacore/timeline/advertising/Ad;

    return-void
.end method

.method public static createInfo(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;)Lcom/adobe/mediacore/AdTimeline$Info;
    .locals 1

    if-eqz p0, :cond_0

    if-eqz p1, :cond_0

    new-instance v0, Lcom/adobe/mediacore/AdTimeline$Info;

    invoke-direct {v0, p0, p1}, Lcom/adobe/mediacore/AdTimeline$Info;-><init>(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;)V

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public equals(Lcom/adobe/mediacore/AdTimeline$Info;)Z
    .locals 2

    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/AdTimeline$Info;->_adBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdTimeline$Info;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v1

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/AdTimeline$Info;->_ad:Lcom/adobe/mediacore/timeline/advertising/Ad;

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdTimeline$Info;->getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v1

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/AdTimeline$Info;->_ad:Lcom/adobe/mediacore/timeline/advertising/Ad;

    return-object v0
.end method

.method public getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/AdTimeline$Info;->_adBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    return-object v0
.end method
