.class public Lcom/poshmark/data_model/models/EventList;
.super Lcom/poshmark/data_model/models/PMData;
.source "EventList.java"


# instance fields
.field currentParties:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PartyEvent;",
            ">;"
        }
    .end annotation
.end field

.field data:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PartyEvent;",
            ">;"
        }
    .end annotation
.end field

.field futureParties:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PartyEvent;",
            ">;"
        }
    .end annotation
.end field

.field more:Lcom/poshmark/data_model/models/PMData$NextMaxID;

.field pastParties:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PartyEvent;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/poshmark/data_model/models/PMData;-><init>()V

    .line 13
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/data_model/models/EventList;->data:Ljava/util/List;

    .line 14
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/data_model/models/EventList;->more:Lcom/poshmark/data_model/models/PMData$NextMaxID;

    .line 17
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/EventList;->currentParties:Ljava/util/List;

    .line 18
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/EventList;->pastParties:Ljava/util/List;

    .line 19
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/poshmark/data_model/models/EventList;->futureParties:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public fillCursor(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;)V
    .locals 6
    .param p1, "cursor"    # Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .prologue
    .line 23
    iget-object v2, p0, Lcom/poshmark/data_model/models/EventList;->data:Ljava/util/List;

    if-eqz v2, :cond_1

    .line 24
    iget-object v3, p0, Lcom/poshmark/data_model/models/EventList;->data:Ljava/util/List;

    monitor-enter v3

    .line 25
    :try_start_0
    iget-object v2, p0, Lcom/poshmark/data_model/models/EventList;->data:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .line 26
    .local v0, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PartyEvent;>;"
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 27
    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/PartyEvent;

    .line 28
    .local v1, "partyItem":Lcom/poshmark/data_model/models/PartyEvent;
    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v2, v4

    const/4 v4, 0x1

    aput-object v1, v2, v4

    invoke-virtual {p1, v2}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->addRow([Ljava/lang/Object;)V

    goto :goto_0

    .line 30
    .end local v0    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PartyEvent;>;"
    .end local v1    # "partyItem":Lcom/poshmark/data_model/models/PartyEvent;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v0    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PartyEvent;>;"
    :cond_0
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 32
    .end local v0    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PartyEvent;>;"
    :cond_1
    return-void
.end method

.method public filterParties()Ljava/util/List;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PartyEvent;",
            ">;"
        }
    .end annotation

    .prologue
    .line 36
    const/4 v4, 0x0

    .line 37
    .local v4, "reachedPastParties":Z
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    .line 38
    .local v0, "currentTime":Ljava/util/Date;
    iget-object v5, p0, Lcom/poshmark/data_model/models/EventList;->data:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .line 39
    .local v3, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PartyEvent;>;"
    iget-object v5, p0, Lcom/poshmark/data_model/models/EventList;->futureParties:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->clear()V

    .line 40
    iget-object v5, p0, Lcom/poshmark/data_model/models/EventList;->pastParties:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->clear()V

    .line 41
    iget-object v5, p0, Lcom/poshmark/data_model/models/EventList;->currentParties:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->clear()V

    .line 43
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 44
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/PartyEvent;

    .line 46
    .local v1, "event":Lcom/poshmark/data_model/models/PartyEvent;
    if-nez v4, :cond_2

    .line 47
    iget-object v5, v1, Lcom/poshmark/data_model/models/PartyEvent;->start_time:Ljava/lang/String;

    invoke-static {v5}, Lcom/poshmark/utils/DateUtils;->getDateFromString(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v2

    .line 48
    .local v2, "eventDate":Ljava/util/Date;
    invoke-virtual {v2, v0}, Ljava/util/Date;->after(Ljava/util/Date;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 49
    iget-object v5, p0, Lcom/poshmark/data_model/models/EventList;->futureParties:Ljava/util/List;

    invoke-interface {v5, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 50
    :cond_0
    iget-object v5, v1, Lcom/poshmark/data_model/models/PartyEvent;->duration:Ljava/math/BigDecimal;

    invoke-virtual {v5}, Ljava/math/BigDecimal;->longValue()J

    move-result-wide v6

    sget-object v5, Lcom/poshmark/utils/DateUtils$TIME_UNIT;->SECONDS:Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    invoke-static {v2, v6, v7, v5}, Lcom/poshmark/utils/DateUtils;->isDateWithinPastWindow(Ljava/util/Date;JLcom/poshmark/utils/DateUtils$TIME_UNIT;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 51
    iget-object v5, p0, Lcom/poshmark/data_model/models/EventList;->currentParties:Ljava/util/List;

    invoke-interface {v5, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 54
    :cond_1
    iget-object v5, p0, Lcom/poshmark/data_model/models/EventList;->pastParties:Ljava/util/List;

    invoke-interface {v5, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 59
    .end local v2    # "eventDate":Ljava/util/Date;
    :cond_2
    iget-object v5, p0, Lcom/poshmark/data_model/models/EventList;->pastParties:Ljava/util/List;

    invoke-interface {v5, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 62
    .end local v1    # "event":Lcom/poshmark/data_model/models/PartyEvent;
    :cond_3
    iget-object v5, p0, Lcom/poshmark/data_model/models/EventList;->currentParties:Ljava/util/List;

    return-object v5
.end method

.method public getCurrentParties()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PartyEvent;",
            ">;"
        }
    .end annotation

    .prologue
    .line 74
    iget-object v0, p0, Lcom/poshmark/data_model/models/EventList;->currentParties:Ljava/util/List;

    return-object v0
.end method

.method public getCurrentPartiesCount()I
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/poshmark/data_model/models/EventList;->currentParties:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getEventsCount()I
    .locals 2

    .prologue
    .line 78
    iget-object v0, p0, Lcom/poshmark/data_model/models/EventList;->futureParties:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    iget-object v1, p0, Lcom/poshmark/data_model/models/EventList;->currentParties:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/2addr v0, v1

    iget-object v1, p0, Lcom/poshmark/data_model/models/EventList;->pastParties:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/2addr v0, v1

    return v0
.end method

.method public getFutureParties()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PartyEvent;",
            ">;"
        }
    .end annotation

    .prologue
    .line 66
    iget-object v0, p0, Lcom/poshmark/data_model/models/EventList;->futureParties:Ljava/util/List;

    return-object v0
.end method

.method public getParty(Ljava/lang/String;)Lcom/poshmark/data_model/models/PartyEvent;
    .locals 3
    .param p1, "partyId"    # Ljava/lang/String;

    .prologue
    .line 94
    iget-object v2, p0, Lcom/poshmark/data_model/models/EventList;->data:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 95
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PartyEvent;>;"
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 96
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/PartyEvent;

    .line 97
    .local v0, "event":Lcom/poshmark/data_model/models/PartyEvent;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 101
    .end local v0    # "event":Lcom/poshmark/data_model/models/PartyEvent;
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getPastParties()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/PartyEvent;",
            ">;"
        }
    .end annotation

    .prologue
    .line 70
    iget-object v0, p0, Lcom/poshmark/data_model/models/EventList;->pastParties:Ljava/util/List;

    return-object v0
.end method

.method public getPastPartiesCount()I
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/poshmark/data_model/models/EventList;->pastParties:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getUpcomingPartiesCount()I
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/poshmark/data_model/models/EventList;->futureParties:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method
