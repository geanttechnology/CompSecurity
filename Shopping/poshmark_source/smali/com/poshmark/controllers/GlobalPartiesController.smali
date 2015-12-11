.class public Lcom/poshmark/controllers/GlobalPartiesController;
.super Ljava/lang/Object;
.source "GlobalPartiesController.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;


# static fields
.field static globalModelStore:Lcom/poshmark/controllers/GlobalPartiesController;


# instance fields
.field final CURRENT_PARTY_END_MSG:I

.field disableAlerts:Z

.field eventList:Lcom/poshmark/data_model/models/EventList;

.field lastFetchTime:Ljava/util/Date;

.field public partyMessageHandler:Landroid/os/Handler;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 31
    const/4 v0, 0x0

    sput-object v0, Lcom/poshmark/controllers/GlobalPartiesController;->globalModelStore:Lcom/poshmark/controllers/GlobalPartiesController;

    return-void
.end method

.method constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    iput-object v1, p0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    .line 42
    const/4 v0, 0x1

    iput v0, p0, Lcom/poshmark/controllers/GlobalPartiesController;->CURRENT_PARTY_END_MSG:I

    .line 43
    iput-object v1, p0, Lcom/poshmark/controllers/GlobalPartiesController;->lastFetchTime:Ljava/util/Date;

    .line 44
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/controllers/GlobalPartiesController;->disableAlerts:Z

    .line 281
    new-instance v0, Lcom/poshmark/controllers/GlobalPartiesController$2;

    invoke-direct {v0, p0}, Lcom/poshmark/controllers/GlobalPartiesController$2;-><init>(Lcom/poshmark/controllers/GlobalPartiesController;)V

    iput-object v0, p0, Lcom/poshmark/controllers/GlobalPartiesController;->partyMessageHandler:Landroid/os/Handler;

    .line 49
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.NEW_EVENTS_ON_SERVER"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 50
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGOUT_COMPLETE"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 51
    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/controllers/GlobalPartiesController;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/controllers/GlobalPartiesController;

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/poshmark/controllers/GlobalPartiesController;->setupPartyNotifications()V

    return-void
.end method

.method static synthetic access$100(Lcom/poshmark/controllers/GlobalPartiesController;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/controllers/GlobalPartiesController;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 28
    invoke-direct {p0, p1}, Lcom/poshmark/controllers/GlobalPartiesController;->handleEndOfPartyTimerMessage(Ljava/lang/String;)V

    return-void
.end method

.method public static getGlobalPartiesController()Lcom/poshmark/controllers/GlobalPartiesController;
    .locals 1

    .prologue
    .line 34
    sget-object v0, Lcom/poshmark/controllers/GlobalPartiesController;->globalModelStore:Lcom/poshmark/controllers/GlobalPartiesController;

    if-nez v0, :cond_0

    .line 35
    new-instance v0, Lcom/poshmark/controllers/GlobalPartiesController;

    invoke-direct {v0}, Lcom/poshmark/controllers/GlobalPartiesController;-><init>()V

    sput-object v0, Lcom/poshmark/controllers/GlobalPartiesController;->globalModelStore:Lcom/poshmark/controllers/GlobalPartiesController;

    .line 37
    :cond_0
    sget-object v0, Lcom/poshmark/controllers/GlobalPartiesController;->globalModelStore:Lcom/poshmark/controllers/GlobalPartiesController;

    return-object v0
.end method

.method private handleCurrentParties()V
    .locals 18

    .prologue
    .line 121
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/poshmark/controllers/GlobalPartiesController;->partyMessageHandler:Landroid/os/Handler;

    const/4 v12, 0x1

    invoke-virtual {v11, v12}, Landroid/os/Handler;->removeMessages(I)V

    .line 122
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    invoke-virtual {v11}, Lcom/poshmark/data_model/models/EventList;->getCurrentParties()Ljava/util/List;

    move-result-object v11

    invoke-interface {v11}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    .line 124
    .local v9, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PartyEvent;>;"
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v11

    if-eqz v11, :cond_0

    .line 125
    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/poshmark/data_model/models/PartyEvent;

    .line 127
    .local v8, "event":Lcom/poshmark/data_model/models/PartyEvent;
    invoke-virtual {v8}, Lcom/poshmark/data_model/models/PartyEvent;->getStartTime()Ljava/lang/String;

    move-result-object v11

    invoke-static {v11}, Lcom/poshmark/utils/DateUtils;->getDateFromString(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v4

    .line 128
    .local v4, "date":Ljava/util/Date;
    new-instance v3, Ljava/util/Date;

    invoke-direct {v3}, Ljava/util/Date;-><init>()V

    .line 129
    .local v3, "currentTime":Ljava/util/Date;
    new-instance v5, Ljava/util/Date;

    invoke-direct {v5}, Ljava/util/Date;-><init>()V

    .line 130
    .local v5, "endTime":Ljava/util/Date;
    invoke-virtual {v4}, Ljava/util/Date;->getTime()J

    move-result-wide v12

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/PartyEvent;->getDuration()J

    move-result-wide v14

    const-wide/16 v16, 0x3e8

    mul-long v14, v14, v16

    add-long/2addr v12, v14

    invoke-virtual {v5, v12, v13}, Ljava/util/Date;->setTime(J)V

    .line 131
    invoke-virtual {v5}, Ljava/util/Date;->getTime()J

    move-result-wide v12

    invoke-virtual {v3}, Ljava/util/Date;->getTime()J

    move-result-wide v14

    sub-long v6, v12, v14

    .line 133
    .local v6, "delay":J
    new-instance v10, Landroid/os/Message;

    invoke-direct {v10}, Landroid/os/Message;-><init>()V

    .line 134
    .local v10, "msg":Landroid/os/Message;
    invoke-virtual {v8}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v11

    iput-object v11, v10, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 135
    const/4 v11, 0x1

    iput v11, v10, Landroid/os/Message;->what:I

    .line 136
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/poshmark/controllers/GlobalPartiesController;->partyMessageHandler:Landroid/os/Handler;

    invoke-virtual {v11, v10, v6, v7}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    .line 138
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 139
    .local v2, "b":Landroid/os/Bundle;
    const-string v11, "ID"

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v2, v11, v12}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 140
    const-string v11, "PARTY_TITLE"

    invoke-virtual {v8}, Lcom/poshmark/data_model/models/PartyEvent;->getName()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v2, v11, v12}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 142
    invoke-virtual {v8}, Lcom/poshmark/data_model/models/PartyEvent;->isReminderEnabled()Z

    move-result v11

    if-eqz v11, :cond_0

    .line 143
    invoke-virtual {v8}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v11

    invoke-static {v11}, Lcom/poshmark/notifications/PMDisplayedAlerts;->isEventAlertDisplayed(Ljava/lang/String;)Z

    move-result v11

    if-nez v11, :cond_0

    .line 144
    invoke-virtual {v8}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v11

    invoke-static {v11}, Lcom/poshmark/notifications/PMDisplayedAlerts;->addEventToDisplayedList(Ljava/lang/String;)V

    .line 145
    move-object/from16 v0, p0

    iget-boolean v11, v0, Lcom/poshmark/controllers/GlobalPartiesController;->disableAlerts:Z

    if-nez v11, :cond_0

    .line 146
    invoke-static {v2}, Lcom/poshmark/notifications/PartyAlert;->showPartyAlert(Landroid/os/Bundle;)V

    .line 152
    .end local v2    # "b":Landroid/os/Bundle;
    .end local v3    # "currentTime":Ljava/util/Date;
    .end local v4    # "date":Ljava/util/Date;
    .end local v5    # "endTime":Ljava/util/Date;
    .end local v6    # "delay":J
    .end local v8    # "event":Lcom/poshmark/data_model/models/PartyEvent;
    .end local v10    # "msg":Landroid/os/Message;
    :cond_0
    return-void
.end method

.method private handleEndOfPartyTimerMessage(Ljava/lang/String;)V
    .locals 1
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 270
    invoke-virtual {p0}, Lcom/poshmark/controllers/GlobalPartiesController;->reorganizeParties()V

    .line 271
    invoke-static {p1}, Lcom/poshmark/notifications/PMDisplayedAlerts;->removeDisplayedAlertFromList(Ljava/lang/String;)V

    .line 272
    const-string v0, "com.poshmark.intents.PARTY_EVENT_END"

    invoke-static {v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 273
    return-void
.end method

.method private handleFutureParties()V
    .locals 8

    .prologue
    .line 102
    invoke-static {}, Lcom/poshmark/notifications/PMFiredNotifications;->cancelAllSavedNotifications()V

    .line 105
    iget-object v4, p0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/EventList;->getFutureParties()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .line 106
    .local v3, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PartyEvent;>;"
    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 107
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/PartyEvent;

    .line 108
    .local v2, "event":Lcom/poshmark/data_model/models/PartyEvent;
    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PartyEvent;->isReminderEnabled()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 109
    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PartyEvent;->getStartTime()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/poshmark/utils/DateUtils;->getDateFromString(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v1

    .line 111
    .local v1, "date":Ljava/util/Date;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 112
    .local v0, "b":Landroid/os/Bundle;
    const-string v4, "ID"

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 113
    const-string v4, "PARTY_TITLE"

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/PartyEvent;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 115
    const-string v4, "com.poshmark.intents.PARTY_ALARM"

    invoke-virtual {v1}, Ljava/util/Date;->getTime()J

    move-result-wide v6

    invoke-static {v4, v0, v6, v7}, Lcom/poshmark/notifications/PMNotificationManager;->fireDelayedNotification(Ljava/lang/String;Landroid/os/Bundle;J)V

    goto :goto_0

    .line 118
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "date":Ljava/util/Date;
    .end local v2    # "event":Lcom/poshmark/data_model/models/PartyEvent;
    :cond_1
    return-void
.end method

.method private setupPartyNotifications()V
    .locals 0

    .prologue
    .line 95
    invoke-direct {p0}, Lcom/poshmark/controllers/GlobalPartiesController;->handleFutureParties()V

    .line 96
    invoke-direct {p0}, Lcom/poshmark/controllers/GlobalPartiesController;->handleCurrentParties()V

    .line 97
    return-void
.end method


# virtual methods
.method public disableAllControllerNotifications()V
    .locals 2

    .prologue
    .line 266
    iget-object v0, p0, Lcom/poshmark/controllers/GlobalPartiesController;->partyMessageHandler:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 267
    return-void
.end method

.method public disablePartyAlerts()V
    .locals 1

    .prologue
    .line 87
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/controllers/GlobalPartiesController;->disableAlerts:Z

    .line 88
    return-void
.end method

.method public enablePartyAlerts()V
    .locals 1

    .prologue
    .line 91
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/controllers/GlobalPartiesController;->disableAlerts:Z

    .line 92
    return-void
.end method

.method public fillCursor(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;)V
    .locals 7
    .param p1, "cursor"    # Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .prologue
    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 176
    iget-object v2, p0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/EventList;->getCurrentParties()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->listIterator()Ljava/util/ListIterator;

    move-result-object v1

    .line 177
    .local v1, "itr":Ljava/util/ListIterator;, "Ljava/util/ListIterator<Lcom/poshmark/data_model/models/PartyEvent;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/ListIterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 178
    invoke-interface {v1}, Ljava/util/ListIterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/PartyEvent;

    .line 179
    .local v0, "event":Lcom/poshmark/data_model/models/PartyEvent;
    new-array v2, v6, [Ljava/lang/Object;

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v4

    aput-object v0, v2, v5

    invoke-virtual {p1, v2}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->addRow([Ljava/lang/Object;)V

    goto :goto_0

    .line 182
    .end local v0    # "event":Lcom/poshmark/data_model/models/PartyEvent;
    :cond_0
    iget-object v2, p0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/EventList;->getFutureParties()Ljava/util/List;

    move-result-object v2

    iget-object v3, p0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/EventList;->getFutureParties()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    invoke-interface {v2, v3}, Ljava/util/List;->listIterator(I)Ljava/util/ListIterator;

    move-result-object v1

    .line 183
    :goto_1
    invoke-interface {v1}, Ljava/util/ListIterator;->hasPrevious()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 184
    invoke-interface {v1}, Ljava/util/ListIterator;->previous()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/PartyEvent;

    .line 185
    .restart local v0    # "event":Lcom/poshmark/data_model/models/PartyEvent;
    new-array v2, v6, [Ljava/lang/Object;

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v4

    aput-object v0, v2, v5

    invoke-virtual {p1, v2}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->addRow([Ljava/lang/Object;)V

    goto :goto_1

    .line 188
    .end local v0    # "event":Lcom/poshmark/data_model/models/PartyEvent;
    :cond_1
    iget-object v2, p0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/EventList;->getPastParties()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->listIterator()Ljava/util/ListIterator;

    move-result-object v1

    .line 189
    :goto_2
    invoke-interface {v1}, Ljava/util/ListIterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 190
    invoke-interface {v1}, Ljava/util/ListIterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/PartyEvent;

    .line 191
    .restart local v0    # "event":Lcom/poshmark/data_model/models/PartyEvent;
    new-array v2, v6, [Ljava/lang/Object;

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v4

    aput-object v0, v2, v5

    invoke-virtual {p1, v2}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->addRow([Ljava/lang/Object;)V

    goto :goto_2

    .line 193
    .end local v0    # "event":Lcom/poshmark/data_model/models/PartyEvent;
    :cond_2
    return-void
.end method

.method public declared-synchronized firePartyAlert(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "b"    # Landroid/os/Bundle;

    .prologue
    .line 257
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    if-eqz v0, :cond_0

    .line 259
    invoke-virtual {p0}, Lcom/poshmark/controllers/GlobalPartiesController;->reorganizeParties()V

    .line 260
    invoke-direct {p0}, Lcom/poshmark/controllers/GlobalPartiesController;->handleCurrentParties()V

    .line 261
    const-string v0, "com.poshmark.intents.PARTY_EVENT_START"

    invoke-static {v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 263
    :cond_0
    monitor-exit p0

    return-void

    .line 257
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public forceRefreshOfEventData()V
    .locals 2

    .prologue
    .line 73
    invoke-static {}, Lcom/poshmark/notifications/PMFiredNotifications;->cancelAllSavedNotifications()V

    .line 75
    iget-object v0, p0, Lcom/poshmark/controllers/GlobalPartiesController;->partyMessageHandler:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeMessages(I)V

    .line 76
    invoke-virtual {p0}, Lcom/poshmark/controllers/GlobalPartiesController;->getEventsData()V

    .line 77
    return-void
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
    .line 229
    iget-object v0, p0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    if-eqz v0, :cond_0

    .line 230
    iget-object v0, p0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/EventList;->getCurrentParties()Ljava/util/List;

    move-result-object v0

    .line 231
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCurrentPartiesCount()I
    .locals 1

    .prologue
    .line 222
    iget-object v0, p0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    if-eqz v0, :cond_0

    .line 223
    iget-object v0, p0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/EventList;->getCurrentPartiesCount()I

    move-result v0

    .line 225
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getEventsCount()I
    .locals 1

    .prologue
    .line 203
    iget-object v0, p0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    if-eqz v0, :cond_0

    .line 204
    iget-object v0, p0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/EventList;->getEventsCount()I

    move-result v0

    .line 206
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method getEventsData()V
    .locals 1

    .prologue
    .line 55
    new-instance v0, Lcom/poshmark/controllers/GlobalPartiesController$1;

    invoke-direct {v0, p0}, Lcom/poshmark/controllers/GlobalPartiesController$1;-><init>(Lcom/poshmark/controllers/GlobalPartiesController;)V

    invoke-static {v0}, Lcom/poshmark/http/api/PMApi;->getEvents(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 69
    return-void
.end method

.method public getParty(Ljava/lang/String;)Lcom/poshmark/data_model/models/PartyEvent;
    .locals 1
    .param p1, "partyId"    # Ljava/lang/String;

    .prologue
    .line 235
    iget-object v0, p0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    if-eqz v0, :cond_0

    .line 236
    iget-object v0, p0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    invoke-virtual {v0, p1}, Lcom/poshmark/data_model/models/EventList;->getParty(Ljava/lang/String;)Lcom/poshmark/data_model/models/PartyEvent;

    move-result-object v0

    .line 237
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getPastPartiesCount()I
    .locals 1

    .prologue
    .line 210
    iget-object v0, p0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    if-eqz v0, :cond_0

    .line 211
    iget-object v0, p0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/EventList;->getPastPartiesCount()I

    move-result v0

    .line 212
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getUpcomingPartiesCount()I
    .locals 1

    .prologue
    .line 216
    iget-object v0, p0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    if-eqz v0, :cond_0

    .line 217
    iget-object v0, p0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/EventList;->getUpcomingPartiesCount()I

    move-result v0

    .line 218
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 3
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v2, 0x0

    .line 157
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGOUT_COMPLETE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 158
    invoke-virtual {p0}, Lcom/poshmark/controllers/GlobalPartiesController;->disableAllControllerNotifications()V

    .line 159
    invoke-static {}, Lcom/poshmark/notifications/PMFiredNotifications;->cancelAllSavedNotifications()V

    .line 160
    iput-object v2, p0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    .line 161
    iput-object v2, p0, Lcom/poshmark/controllers/GlobalPartiesController;->lastFetchTime:Ljava/util/Date;

    .line 165
    :cond_0
    :goto_0
    return-void

    .line 162
    :cond_1
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.NEW_EVENTS_ON_SERVER"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 163
    invoke-virtual {p0}, Lcom/poshmark/controllers/GlobalPartiesController;->getEventsData()V

    goto :goto_0
.end method

.method public isCurrentParty(Ljava/lang/String;)Z
    .locals 4
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 241
    iget-object v3, p0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    if-nez v3, :cond_1

    .line 251
    :cond_0
    :goto_0
    return v2

    .line 244
    :cond_1
    iget-object v3, p0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    invoke-virtual {v3}, Lcom/poshmark/data_model/models/EventList;->getCurrentParties()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 245
    .local v1, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/poshmark/data_model/models/PartyEvent;>;"
    :cond_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 246
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/PartyEvent;

    .line 247
    .local v0, "event":Lcom/poshmark/data_model/models/PartyEvent;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 248
    const/4 v2, 0x1

    goto :goto_0
.end method

.method public isModelPopulated()Z
    .locals 1

    .prologue
    .line 168
    iget-object v0, p0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public lastUpdatedBefore(Ljava/util/Date;)Z
    .locals 1
    .param p1, "lastUpdatedAt"    # Ljava/util/Date;

    .prologue
    .line 80
    iget-object v0, p0, Lcom/poshmark/controllers/GlobalPartiesController;->lastFetchTime:Ljava/util/Date;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/controllers/GlobalPartiesController;->lastFetchTime:Ljava/util/Date;

    invoke-virtual {v0, p1}, Ljava/util/Date;->before(Ljava/util/Date;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 81
    :cond_0
    const/4 v0, 0x1

    .line 83
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public declared-synchronized reorganizeParties()V
    .locals 1

    .prologue
    .line 197
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    if-eqz v0, :cond_0

    .line 198
    iget-object v0, p0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/EventList;->filterParties()Ljava/util/List;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 200
    :cond_0
    monitor-exit p0

    return-void

    .line 197
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
