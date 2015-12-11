.class public Lcom/espn/androidplayersdk/datamanager/EPEvents;
.super Ljava/lang/Object;
.source "EPEvents.java"

# interfaces
.implements Ljava/io/Serializable;


# static fields
.field private static final serialVersionUID:J = -0x16f74338bb13335fL


# instance fields
.field airingId:Ljava/lang/String;

.field broadcastStartDate:Ljava/lang/String;

.field coverageType:Ljava/lang/String;

.field private defaultStartSessionUrl:Ljava/lang/String;

.field description:Ljava/lang/String;

.field endTime:Ljava/lang/String;

.field eventId:Ljava/lang/String;

.field eventName:Ljava/lang/String;

.field imageLarge:Ljava/lang/String;

.field imageMedium:Ljava/lang/String;

.field imageSmall:Ljava/lang/String;

.field leagueId:Ljava/lang/String;

.field leagueName:Ljava/lang/String;

.field networkId:Ljava/lang/String;

.field networkName:Ljava/lang/String;

.field networkResourceId:Ljava/lang/String;

.field parentalRating:Ljava/lang/String;

.field programinCode:Ljava/lang/String;

.field seekInSecond:Ljava/lang/String;

.field showName:Ljava/lang/String;

.field sport:Ljava/lang/String;

.field sportCode:Ljava/lang/String;

.field startTime:Ljava/lang/String;

.field type:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/util/HashMap;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 37
    .local p1, "items":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->defaultStartSessionUrl:Ljava/lang/String;

    .line 38
    const-string v0, "eventName"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->eventName:Ljava/lang/String;

    .line 39
    const-string v0, "eventId"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->eventId:Ljava/lang/String;

    .line 40
    const-string v0, "simulcastAiringId"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->airingId:Ljava/lang/String;

    .line 41
    const-string v0, "eventType"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->type:Ljava/lang/String;

    .line 42
    const-string v0, "showName"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->showName:Ljava/lang/String;

    .line 43
    const-string v0, "broadcastStartTime"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->broadcastStartDate:Ljava/lang/String;

    .line 44
    const-string v0, "startTime"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->startTime:Ljava/lang/String;

    .line 45
    const-string v0, "endTime"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->endTime:Ljava/lang/String;

    .line 46
    const-string v0, "imageLarge"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->imageLarge:Ljava/lang/String;

    .line 47
    const-string v0, "imageMed"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->imageMedium:Ljava/lang/String;

    .line 48
    const-string v0, "imageSmall"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->imageSmall:Ljava/lang/String;

    .line 49
    const-string v0, "parentalRating"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->parentalRating:Ljava/lang/String;

    .line 50
    const-string v0, "seekInSeconds"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->seekInSecond:Ljava/lang/String;

    .line 51
    const-string v0, "networkCode"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->networkId:Ljava/lang/String;

    .line 52
    const-string v0, "description"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->description:Ljava/lang/String;

    .line 53
    const-string v0, "networkName"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->networkName:Ljava/lang/String;

    .line 54
    const-string v0, "league"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->leagueId:Ljava/lang/String;

    .line 55
    const-string v0, "leagueName"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->leagueName:Ljava/lang/String;

    .line 56
    const-string v0, "SPORT"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->sport:Ljava/lang/String;

    .line 57
    const-string v0, "sportCode"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->sportCode:Ljava/lang/String;

    .line 58
    const-string v0, "programingCode"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->programinCode:Ljava/lang/String;

    .line 59
    const-string v0, "coverageType"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->coverageType:Ljava/lang/String;

    .line 60
    const-string v0, "defaultStartSessionUrl"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->defaultStartSessionUrl:Ljava/lang/String;

    .line 61
    const-string v0, "networkResourceId"

    invoke-virtual {p1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->networkResourceId:Ljava/lang/String;

    .line 62
    return-void
.end method


# virtual methods
.method public getAiringId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 73
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->airingId:Ljava/lang/String;

    return-object v0
.end method

.method public getBroadcastStartDate()Ljava/lang/String;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->broadcastStartDate:Ljava/lang/String;

    return-object v0
.end method

.method public getEndTime()Ljava/lang/String;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->endTime:Ljava/lang/String;

    return-object v0
.end method

.method public getEventDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getEventId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->eventId:Ljava/lang/String;

    return-object v0
.end method

.method public getEventName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 65
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->eventName:Ljava/lang/String;

    return-object v0
.end method

.method public getImageLarge()Ljava/lang/String;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->imageLarge:Ljava/lang/String;

    return-object v0
.end method

.method public getImageMedium()Ljava/lang/String;
    .locals 1

    .prologue
    .line 105
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->imageMedium:Ljava/lang/String;

    return-object v0
.end method

.method public getImageSmall()Ljava/lang/String;
    .locals 1

    .prologue
    .line 109
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->imageSmall:Ljava/lang/String;

    return-object v0
.end method

.method public getLeague()Ljava/lang/String;
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->leagueId:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 130
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->leagueId:Ljava/lang/String;

    .line 131
    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public getLeagueName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 135
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->leagueName:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 136
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->leagueName:Ljava/lang/String;

    .line 137
    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public getNetworkId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->networkId:Ljava/lang/String;

    return-object v0
.end method

.method public getNetworkName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 125
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->networkName:Ljava/lang/String;

    return-object v0
.end method

.method public getNetworkResourceId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 165
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->networkResourceId:Ljava/lang/String;

    return-object v0
.end method

.method public getParentalRating()Ljava/lang/String;
    .locals 1

    .prologue
    .line 113
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->parentalRating:Ljava/lang/String;

    return-object v0
.end method

.method public getSeekInSecond()Ljava/lang/String;
    .locals 1

    .prologue
    .line 117
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->seekInSecond:Ljava/lang/String;

    return-object v0
.end method

.method public getShowName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->showName:Ljava/lang/String;

    return-object v0
.end method

.method public getSport()Ljava/lang/String;
    .locals 1

    .prologue
    .line 141
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->sport:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 142
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->sport:Ljava/lang/String;

    .line 143
    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public getSportCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 147
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->sportCode:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 148
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->sportCode:Ljava/lang/String;

    .line 149
    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public getStartTime()Ljava/lang/String;
    .locals 1

    .prologue
    .line 93
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->startTime:Ljava/lang/String;

    return-object v0
.end method

.method public getType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->type:Ljava/lang/String;

    return-object v0
.end method

.method public getcoverageType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->coverageType:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 160
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->coverageType:Ljava/lang/String;

    .line 161
    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public getprogramingCode()Ljava/lang/String;
    .locals 1

    .prologue
    .line 153
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->programinCode:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 154
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EPEvents;->programinCode:Ljava/lang/String;

    .line 155
    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method
