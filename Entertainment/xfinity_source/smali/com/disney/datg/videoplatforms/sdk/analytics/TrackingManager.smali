.class public Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;
.super Ljava/lang/Object;
.source "TrackingManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$1;,
        Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;,
        Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AppEvent;,
        Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;,
        Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;
    }
.end annotation


# static fields
.field private static TAG:Ljava/lang/String;

.field private static adTrackers:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/analytics/IAdTracker;",
            ">;"
        }
    .end annotation
.end field

.field private static appTrackers:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/analytics/IAppTracker;",
            ">;"
        }
    .end annotation
.end field

.field private static authTrackers:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/analytics/IAuthZTracker;",
            ">;"
        }
    .end annotation
.end field

.field private static linkTrackers:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/analytics/ILinkTracker;",
            ">;"
        }
    .end annotation
.end field

.field private static mediaTrackers:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 8
    const-string v0, "Tracking Manager"

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->TAG:Ljava/lang/String;

    .line 10
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->adTrackers:Ljava/util/Vector;

    .line 11
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->appTrackers:Ljava/util/Vector;

    .line 12
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->linkTrackers:Ljava/util/Vector;

    .line 13
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    .line 14
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->authTrackers:Ljava/util/Vector;

    return-void
.end method

.method public static getLinkTrackers()Ljava/util/Vector;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Vector",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/analytics/ILinkTracker;",
            ">;"
        }
    .end annotation

    .prologue
    .line 371
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->linkTrackers:Ljava/util/Vector;

    return-object v0
.end method

.method public static registerTracker(Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;)V
    .locals 3
    .param p0, "tracker"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    .prologue
    .line 25
    instance-of v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/IAdTracker;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->adTrackers:Ljava/util/Vector;

    invoke-virtual {v0, p0}, Ljava/util/Vector;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 26
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->adTrackers:Ljava/util/Vector;

    move-object v0, p0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/analytics/IAdTracker;

    invoke-virtual {v1, v0}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    .line 27
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Ad tracker registered "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-interface {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 29
    :cond_0
    instance-of v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/IAppTracker;

    if-eqz v0, :cond_1

    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->appTrackers:Ljava/util/Vector;

    invoke-virtual {v0, p0}, Ljava/util/Vector;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 30
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->appTrackers:Ljava/util/Vector;

    move-object v0, p0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/analytics/IAppTracker;

    invoke-virtual {v1, v0}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    .line 31
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "App tracker registered "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-interface {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 33
    :cond_1
    instance-of v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/ILinkTracker;

    if-eqz v0, :cond_2

    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->linkTrackers:Ljava/util/Vector;

    invoke-virtual {v0, p0}, Ljava/util/Vector;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 34
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->linkTrackers:Ljava/util/Vector;

    move-object v0, p0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/analytics/ILinkTracker;

    invoke-virtual {v1, v0}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    .line 35
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Link tracker registered "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-interface {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 37
    :cond_2
    instance-of v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;

    if-eqz v0, :cond_3

    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v0, p0}, Ljava/util/Vector;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 38
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    move-object v0, p0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;

    invoke-virtual {v1, v0}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    .line 39
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Media tracker registered "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-interface {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 41
    :cond_3
    instance-of v0, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/IAuthZTracker;

    if-eqz v0, :cond_4

    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->authTrackers:Ljava/util/Vector;

    invoke-virtual {v0, p0}, Ljava/util/Vector;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_4

    .line 42
    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->authTrackers:Ljava/util/Vector;

    move-object v0, p0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/analytics/IAuthZTracker;

    invoke-virtual {v1, v0}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    .line 43
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Media tracker registered "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-interface {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/disney/datg/videoplatforms/sdk/utils/LogUtils;->LOGD(Ljava/lang/String;Ljava/lang/String;)V

    .line 45
    :cond_4
    return-void
.end method

.method public static removeAllTrackers()V
    .locals 1

    .prologue
    .line 79
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->adTrackers:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->clear()V

    .line 80
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->appTrackers:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->clear()V

    .line 81
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->linkTrackers:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->clear()V

    .line 82
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->clear()V

    .line 83
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->authTrackers:Ljava/util/Vector;

    invoke-virtual {v0}, Ljava/util/Vector;->clear()V

    .line 84
    return-void
.end method

.method public static trackAd(Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 4
    .param p0, "event"    # Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 239
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$1;->$SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AdEvent:[I

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AdEvent;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 305
    :cond_0
    return-void

    .line 241
    :pswitch_0
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->adTrackers:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 242
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->adTrackers:Ljava/util/Vector;

    invoke-virtual {v2, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    .line 243
    .local v1, "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    if-eqz p1, :cond_1

    if-eqz v1, :cond_1

    invoke-interface {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 244
    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/IAdTracker;

    .end local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    invoke-interface {v1, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/IAdTracker;->trackAdBreakStart(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 241
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 249
    .end local v0    # "i":I
    :pswitch_1
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_1
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->adTrackers:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 250
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->adTrackers:Ljava/util/Vector;

    invoke-virtual {v2, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    .line 251
    .restart local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    if-eqz p1, :cond_2

    if-eqz v1, :cond_2

    invoke-interface {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 252
    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/IAdTracker;

    .end local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    invoke-interface {v1, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/IAdTracker;->trackAdBreakEnd(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 249
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 257
    .end local v0    # "i":I
    :pswitch_2
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_2
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->adTrackers:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 258
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->adTrackers:Ljava/util/Vector;

    invoke-virtual {v2, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    .line 259
    .restart local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    if-eqz p1, :cond_3

    if-eqz v1, :cond_3

    invoke-interface {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 260
    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/IAdTracker;

    .end local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    invoke-interface {v1, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/IAdTracker;->trackAdStart(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 257
    :cond_3
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 265
    .end local v0    # "i":I
    :pswitch_3
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_3
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->adTrackers:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 266
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->adTrackers:Ljava/util/Vector;

    invoke-virtual {v2, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    .line 267
    .restart local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    if-eqz p1, :cond_4

    if-eqz v1, :cond_4

    invoke-interface {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 268
    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/IAdTracker;

    .end local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    invoke-interface {v1, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/IAdTracker;->trackAdFirstQuartile(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 265
    :cond_4
    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    .line 273
    .end local v0    # "i":I
    :pswitch_4
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_4
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->adTrackers:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 274
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->adTrackers:Ljava/util/Vector;

    invoke-virtual {v2, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    .line 275
    .restart local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    if-eqz p1, :cond_5

    if-eqz v1, :cond_5

    invoke-interface {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 276
    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/IAdTracker;

    .end local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    invoke-interface {v1, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/IAdTracker;->trackAdMidpoint(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 273
    :cond_5
    add-int/lit8 v0, v0, 0x1

    goto :goto_4

    .line 281
    .end local v0    # "i":I
    :pswitch_5
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_5
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->adTrackers:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 282
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->adTrackers:Ljava/util/Vector;

    invoke-virtual {v2, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    .line 283
    .restart local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    if-eqz p1, :cond_6

    if-eqz v1, :cond_6

    invoke-interface {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 284
    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/IAdTracker;

    .end local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    invoke-interface {v1, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/IAdTracker;->trackAdThirdQuartile(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 281
    :cond_6
    add-int/lit8 v0, v0, 0x1

    goto :goto_5

    .line 289
    .end local v0    # "i":I
    :pswitch_6
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_6
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->adTrackers:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 290
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->adTrackers:Ljava/util/Vector;

    invoke-virtual {v2, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    .line 291
    .restart local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    if-eqz p1, :cond_7

    if-eqz v1, :cond_7

    invoke-interface {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 292
    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/IAdTracker;

    .end local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    invoke-interface {v1, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/IAdTracker;->trackAdEnd(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 289
    :cond_7
    add-int/lit8 v0, v0, 0x1

    goto :goto_6

    .line 297
    .end local v0    # "i":I
    :pswitch_7
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_7
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->adTrackers:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 298
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->adTrackers:Ljava/util/Vector;

    invoke-virtual {v2, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    .line 299
    .restart local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    if-eqz p1, :cond_8

    if-eqz v1, :cond_8

    invoke-interface {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_8

    .line 300
    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/IAdTracker;

    .end local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    invoke-interface {v1, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/IAdTracker;->trackAdError(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 297
    :cond_8
    add-int/lit8 v0, v0, 0x1

    goto :goto_7

    .line 239
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
    .end packed-switch
.end method

.method public static trackAuthZ(Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 4
    .param p0, "event"    # Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 93
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$1;->$SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$AuthZEvent:[I

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$AuthZEvent;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 119
    :cond_0
    return-void

    .line 95
    :pswitch_0
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->authTrackers:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 96
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->authTrackers:Ljava/util/Vector;

    invoke-virtual {v2, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    .line 97
    .local v1, "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    if-eqz p1, :cond_1

    if-eqz v1, :cond_1

    invoke-interface {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 98
    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/IAuthZTracker;

    .end local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    invoke-interface {v1, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/IAuthZTracker;->trackAuthZStarted(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 95
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 103
    .end local v0    # "i":I
    :pswitch_1
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_1
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->authTrackers:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 104
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->authTrackers:Ljava/util/Vector;

    invoke-virtual {v2, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    .line 105
    .restart local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    if-eqz p1, :cond_2

    if-eqz v1, :cond_2

    invoke-interface {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 106
    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/IAuthZTracker;

    .end local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    invoke-interface {v1, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/IAuthZTracker;->trackAuthZFailure(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 103
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 111
    .end local v0    # "i":I
    :pswitch_2
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_2
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->authTrackers:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 112
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->authTrackers:Ljava/util/Vector;

    invoke-virtual {v2, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    .line 113
    .restart local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    if-eqz p1, :cond_3

    if-eqz v1, :cond_3

    invoke-interface {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 114
    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/IAuthZTracker;

    .end local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    invoke-interface {v1, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/IAuthZTracker;->trackAuthZSuccess(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 111
    :cond_3
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 93
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method public static trackMedia(Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V
    .locals 4
    .param p0, "event"    # Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;
    .param p1, "trackable"    # Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;

    .prologue
    .line 126
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$1;->$SwitchMap$com$disney$datg$videoplatforms$sdk$analytics$TrackingManager$MediaEvent:[I

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager$MediaEvent;->ordinal()I

    move-result v3

    aget v2, v2, v3

    packed-switch v2, :pswitch_data_0

    .line 232
    :cond_0
    return-void

    .line 128
    :pswitch_0
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 129
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v2, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    .line 130
    .local v1, "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    if-eqz p1, :cond_1

    if-eqz v1, :cond_1

    invoke-interface {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 131
    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;

    .end local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    invoke-interface {v1, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;->trackMediaStarted(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 128
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 136
    .end local v0    # "i":I
    :pswitch_1
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_1
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 137
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v2, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    .line 138
    .restart local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    if-eqz p1, :cond_2

    if-eqz v1, :cond_2

    invoke-interface {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 139
    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;

    .end local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    invoke-interface {v1, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;->trackMediaPaused(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 136
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 144
    .end local v0    # "i":I
    :pswitch_2
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_2
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 145
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v2, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    .line 146
    .restart local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    if-eqz p1, :cond_3

    if-eqz v1, :cond_3

    invoke-interface {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 147
    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;

    .end local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    invoke-interface {v1, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;->trackMediaResumed(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 144
    :cond_3
    add-int/lit8 v0, v0, 0x1

    goto :goto_2

    .line 152
    .end local v0    # "i":I
    :pswitch_3
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_3
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 153
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v2, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    .line 154
    .restart local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    if-eqz p1, :cond_4

    if-eqz v1, :cond_4

    invoke-interface {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 155
    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;

    .end local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    invoke-interface {v1, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;->trackMediaStopped(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 152
    :cond_4
    add-int/lit8 v0, v0, 0x1

    goto :goto_3

    .line 160
    .end local v0    # "i":I
    :pswitch_4
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_4
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 161
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v2, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    .line 162
    .restart local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    if-eqz p1, :cond_5

    if-eqz v1, :cond_5

    invoke-interface {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 163
    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;

    .end local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    invoke-interface {v1, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;->trackMediaForward(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 160
    :cond_5
    add-int/lit8 v0, v0, 0x1

    goto :goto_4

    .line 168
    .end local v0    # "i":I
    :pswitch_5
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_5
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 169
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v2, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    .line 170
    .restart local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    if-eqz p1, :cond_6

    if-eqz v1, :cond_6

    invoke-interface {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 171
    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;

    .end local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    invoke-interface {v1, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;->trackMediaRewind(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 168
    :cond_6
    add-int/lit8 v0, v0, 0x1

    goto :goto_5

    .line 176
    .end local v0    # "i":I
    :pswitch_6
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_6
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 177
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v2, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    .line 178
    .restart local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    if-eqz p1, :cond_7

    if-eqz v1, :cond_7

    invoke-interface {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 179
    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;

    .end local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    invoke-interface {v1, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;->trackMediaStateUpdated(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 176
    :cond_7
    add-int/lit8 v0, v0, 0x1

    goto :goto_6

    .line 184
    .end local v0    # "i":I
    :pswitch_7
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_7
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 185
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v2, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    .line 186
    .restart local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    if-eqz p1, :cond_8

    if-eqz v1, :cond_8

    invoke-interface {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_8

    .line 187
    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;

    .end local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    invoke-interface {v1, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;->trackMediaFirstQuarter(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 184
    :cond_8
    add-int/lit8 v0, v0, 0x1

    goto :goto_7

    .line 192
    .end local v0    # "i":I
    :pswitch_8
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_8
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 193
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v2, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    .line 194
    .restart local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    if-eqz p1, :cond_9

    if-eqz v1, :cond_9

    invoke-interface {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_9

    .line 195
    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;

    .end local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    invoke-interface {v1, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;->trackMediaMidpoint(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 192
    :cond_9
    add-int/lit8 v0, v0, 0x1

    goto :goto_8

    .line 200
    .end local v0    # "i":I
    :pswitch_9
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_9
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 201
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v2, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    .line 202
    .restart local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    if-eqz p1, :cond_a

    if-eqz v1, :cond_a

    invoke-interface {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_a

    .line 203
    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;

    .end local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    invoke-interface {v1, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;->trackMediaThirdQuarter(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 200
    :cond_a
    add-int/lit8 v0, v0, 0x1

    goto :goto_9

    .line 208
    .end local v0    # "i":I
    :pswitch_a
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_a
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 209
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v2, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    .line 210
    .restart local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    if-eqz p1, :cond_b

    if-eqz v1, :cond_b

    invoke-interface {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_b

    .line 211
    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;

    .end local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    invoke-interface {v1, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;->trackMediaComplete(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 208
    :cond_b
    add-int/lit8 v0, v0, 0x1

    goto :goto_a

    .line 216
    .end local v0    # "i":I
    :pswitch_b
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_b
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 217
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v2, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    .line 218
    .restart local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    if-eqz p1, :cond_c

    if-eqz v1, :cond_c

    invoke-interface {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_c

    .line 219
    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;

    .end local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    invoke-interface {v1, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;->trackMediaError(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 216
    :cond_c
    add-int/lit8 v0, v0, 0x1

    goto :goto_b

    .line 224
    .end local v0    # "i":I
    :pswitch_c
    const/4 v0, 0x0

    .restart local v0    # "i":I
    :goto_c
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    if-ge v0, v2, :cond_0

    .line 225
    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/analytics/TrackingManager;->mediaTrackers:Ljava/util/Vector;

    invoke-virtual {v2, v0}, Ljava/util/Vector;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;

    .line 226
    .restart local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    if-eqz p1, :cond_d

    if-eqz v1, :cond_d

    invoke-interface {v1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_d

    .line 227
    check-cast v1, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;

    .end local v1    # "tracker":Lcom/disney/datg/videoplatforms/sdk/analytics/ITracker;
    invoke-interface {v1, p1}, Lcom/disney/datg/videoplatforms/sdk/analytics/IMediaTracker;->trackPing(Lcom/disney/datg/videoplatforms/sdk/analytics/ITrackable;)V

    .line 224
    :cond_d
    add-int/lit8 v0, v0, 0x1

    goto :goto_c

    .line 126
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_9
        :pswitch_a
        :pswitch_b
        :pswitch_c
    .end packed-switch
.end method
