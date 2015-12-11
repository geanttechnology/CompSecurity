.class public final Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;
.super Lcom/adobe/mediacore/timeline/TimelineOperation;

# interfaces
.implements Lcom/adobe/mediacore/timeline/TimelineMarker;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement$1;
    }
.end annotation


# instance fields
.field private final _adBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;


# direct methods
.method public constructor <init>(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)V
    .locals 2

    invoke-direct {p0, p2}, Lcom/adobe/mediacore/timeline/TimelineOperation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)V

    sget-object v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement$1;->$SwitchMap$com$adobe$mediacore$timeline$advertising$PlacementInformation$Type:[I

    invoke-virtual {p2}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getType()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    :goto_0
    iput-object p1, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->_adBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    return-void

    :pswitch_0
    sget-object v0, Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;->PRE_ROLL:Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

    invoke-virtual {p1, v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->setType(Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;)V

    goto :goto_0

    :pswitch_1
    sget-object v0, Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;->MID_ROLL:Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

    invoke-virtual {p1, v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->setType(Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;)V

    goto :goto_0

    :pswitch_2
    sget-object v0, Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;->POST_ROLL:Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;

    invoke-virtual {p1, v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->setType(Lcom/adobe/mediacore/timeline/advertising/AdBreak$Type;)V

    goto :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method


# virtual methods
.method public getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->_adBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    return-object v0
.end method

.method public getDuration()J
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->_adBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getDuration()J

    move-result-wide v0

    return-wide v0
.end method

.method public getTime()J
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->_placementInformation:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v0

    return-wide v0
.end method

.method public isValid()Z
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->_adBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->isValid()Z

    move-result v0

    return v0
.end method
