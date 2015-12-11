.class public Lcom/poshmark/controllers/ShowroomsController;
.super Ljava/lang/Object;
.source "ShowroomsController.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;


# static fields
.field static globalShowroomsController:Lcom/poshmark/controllers/ShowroomsController;


# instance fields
.field lastFetchTime:Ljava/util/Date;

.field showroomGroupList:Lcom/poshmark/data_model/models/ShowroomGroupList;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 29
    const/4 v0, 0x0

    sput-object v0, Lcom/poshmark/controllers/ShowroomsController;->globalShowroomsController:Lcom/poshmark/controllers/ShowroomsController;

    return-void
.end method

.method private constructor <init>()V
    .locals 2

    .prologue
    const/4 v0, 0x0

    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    iput-object v0, p0, Lcom/poshmark/controllers/ShowroomsController;->showroomGroupList:Lcom/poshmark/data_model/models/ShowroomGroupList;

    .line 40
    iput-object v0, p0, Lcom/poshmark/controllers/ShowroomsController;->lastFetchTime:Ljava/util/Date;

    .line 43
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.NEW_SHOWROOMS_ON_SERVER"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 44
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGOUT_COMPLETE"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 45
    return-void
.end method

.method public static getGlobalShowroomsController()Lcom/poshmark/controllers/ShowroomsController;
    .locals 1

    .prologue
    .line 32
    sget-object v0, Lcom/poshmark/controllers/ShowroomsController;->globalShowroomsController:Lcom/poshmark/controllers/ShowroomsController;

    if-nez v0, :cond_0

    .line 33
    new-instance v0, Lcom/poshmark/controllers/ShowroomsController;

    invoke-direct {v0}, Lcom/poshmark/controllers/ShowroomsController;-><init>()V

    sput-object v0, Lcom/poshmark/controllers/ShowroomsController;->globalShowroomsController:Lcom/poshmark/controllers/ShowroomsController;

    .line 35
    :cond_0
    sget-object v0, Lcom/poshmark/controllers/ShowroomsController;->globalShowroomsController:Lcom/poshmark/controllers/ShowroomsController;

    return-object v0
.end method


# virtual methods
.method public fillCursor(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;)V
    .locals 8
    .param p1, "cursor"    # Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .prologue
    const/4 v7, 0x0

    .line 55
    iget-object v5, p0, Lcom/poshmark/controllers/ShowroomsController;->showroomGroupList:Lcom/poshmark/data_model/models/ShowroomGroupList;

    invoke-virtual {v5}, Lcom/poshmark/data_model/models/ShowroomGroupList;->getList()Ljava/util/List;

    move-result-object v1

    .line 56
    .local v1, "groupList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/ShowroomGroup;>;"
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v5

    if-ge v2, v5, :cond_1

    .line 57
    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/ShowroomGroup;

    .line 58
    .local v0, "group":Lcom/poshmark/data_model/models/ShowroomGroup;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ShowroomGroup;->getCollections()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->listIterator()Ljava/util/ListIterator;

    move-result-object v3

    .line 59
    .local v3, "itr":Ljava/util/ListIterator;, "Ljava/util/ListIterator<Lcom/poshmark/data_model/models/Showroom;>;"
    :goto_1
    invoke-interface {v3}, Ljava/util/ListIterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 60
    invoke-interface {v3}, Ljava/util/ListIterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/poshmark/data_model/models/Showroom;

    .line 61
    .local v4, "showroom":Lcom/poshmark/data_model/models/Showroom;
    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v7

    const/4 v6, 0x1

    aput-object v4, v5, v6

    invoke-virtual {p1, v5}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->addRow([Ljava/lang/Object;)V

    goto :goto_1

    .line 56
    .end local v4    # "showroom":Lcom/poshmark/data_model/models/Showroom;
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 64
    .end local v0    # "group":Lcom/poshmark/data_model/models/ShowroomGroup;
    .end local v3    # "itr":Ljava/util/ListIterator;, "Ljava/util/ListIterator<Lcom/poshmark/data_model/models/Showroom;>;"
    :cond_1
    return-void
.end method

.method public getAllShowrooms()Ljava/util/List;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/Showroom;",
            ">;"
        }
    .end annotation

    .prologue
    .line 134
    iget-object v4, p0, Lcom/poshmark/controllers/ShowroomsController;->showroomGroupList:Lcom/poshmark/data_model/models/ShowroomGroupList;

    if-nez v4, :cond_1

    .line 135
    const/4 v3, 0x0

    .line 145
    :cond_0
    return-object v3

    .line 137
    :cond_1
    iget-object v4, p0, Lcom/poshmark/controllers/ShowroomsController;->showroomGroupList:Lcom/poshmark/data_model/models/ShowroomGroupList;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/ShowroomGroupList;->getList()Ljava/util/List;

    move-result-object v1

    .line 138
    .local v1, "groupList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/ShowroomGroup;>;"
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 140
    .local v3, "showrooms":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/Showroom;>;"
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v4

    if-ge v2, v4, :cond_0

    .line 141
    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/ShowroomGroup;

    .line 142
    .local v0, "group":Lcom/poshmark/data_model/models/ShowroomGroup;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ShowroomGroup;->getCollections()Ljava/util/List;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 140
    add-int/lit8 v2, v2, 0x1

    goto :goto_0
.end method

.method public getShowroomWithId(Ljava/lang/String;)Lcom/poshmark/data_model/models/Showroom;
    .locals 8
    .param p1, "showroomId"    # Ljava/lang/String;

    .prologue
    const/4 v6, 0x0

    .line 114
    if-nez p1, :cond_1

    move-object v4, v6

    .line 130
    :cond_0
    :goto_0
    return-object v4

    .line 117
    :cond_1
    iget-object v7, p0, Lcom/poshmark/controllers/ShowroomsController;->showroomGroupList:Lcom/poshmark/data_model/models/ShowroomGroupList;

    if-eqz v7, :cond_3

    .line 118
    iget-object v7, p0, Lcom/poshmark/controllers/ShowroomsController;->showroomGroupList:Lcom/poshmark/data_model/models/ShowroomGroupList;

    invoke-virtual {v7}, Lcom/poshmark/data_model/models/ShowroomGroupList;->getList()Ljava/util/List;

    move-result-object v1

    .line 119
    .local v1, "groupList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/ShowroomGroup;>;"
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v7

    if-ge v2, v7, :cond_3

    .line 120
    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/ShowroomGroup;

    .line 121
    .local v0, "group":Lcom/poshmark/data_model/models/ShowroomGroup;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ShowroomGroup;->getCollections()Ljava/util/List;

    move-result-object v5

    .line 122
    .local v5, "showrooms":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/Showroom;>;"
    const/4 v3, 0x0

    .local v3, "j":I
    :goto_2
    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v7

    if-ge v3, v7, :cond_2

    .line 123
    invoke-interface {v5, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/poshmark/data_model/models/Showroom;

    .line 124
    .local v4, "showroom":Lcom/poshmark/data_model/models/Showroom;
    invoke-virtual {v4}, Lcom/poshmark/data_model/models/Showroom;->getId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-nez v7, :cond_0

    .line 122
    add-int/lit8 v3, v3, 0x1

    goto :goto_2

    .line 119
    .end local v4    # "showroom":Lcom/poshmark/data_model/models/Showroom;
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .end local v0    # "group":Lcom/poshmark/data_model/models/ShowroomGroup;
    .end local v1    # "groupList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/ShowroomGroup;>;"
    .end local v2    # "i":I
    .end local v3    # "j":I
    .end local v5    # "showrooms":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/Showroom;>;"
    :cond_3
    move-object v4, v6

    .line 130
    goto :goto_0
.end method

.method getShowroomsData()V
    .locals 1

    .prologue
    .line 67
    new-instance v0, Lcom/poshmark/controllers/ShowroomsController$1;

    invoke-direct {v0, p0}, Lcom/poshmark/controllers/ShowroomsController$1;-><init>(Lcom/poshmark/controllers/ShowroomsController;)V

    invoke-static {v0}, Lcom/poshmark/http/api/PMApi;->getShowrooms(Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 79
    return-void
.end method

.method public getTrendingShowroomGroup()Lcom/poshmark/data_model/models/ShowroomGroup;
    .locals 6

    .prologue
    const/4 v3, 0x0

    .line 99
    iget-object v4, p0, Lcom/poshmark/controllers/ShowroomsController;->showroomGroupList:Lcom/poshmark/data_model/models/ShowroomGroupList;

    if-nez v4, :cond_1

    move-object v0, v3

    .line 110
    :cond_0
    :goto_0
    return-object v0

    .line 102
    :cond_1
    iget-object v4, p0, Lcom/poshmark/controllers/ShowroomsController;->showroomGroupList:Lcom/poshmark/data_model/models/ShowroomGroupList;

    invoke-virtual {v4}, Lcom/poshmark/data_model/models/ShowroomGroupList;->getList()Ljava/util/List;

    move-result-object v1

    .line 103
    .local v1, "groupList":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/ShowroomGroup;>;"
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v4

    if-ge v2, v4, :cond_2

    .line 104
    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/ShowroomGroup;

    .line 105
    .local v0, "group":Lcom/poshmark/data_model/models/ShowroomGroup;
    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ShowroomGroup;->getTag()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    const-string v5, "trending"

    invoke-virtual {v4, v5}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 103
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .end local v0    # "group":Lcom/poshmark/data_model/models/ShowroomGroup;
    :cond_2
    move-object v0, v3

    .line 110
    goto :goto_0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 3
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v2, 0x0

    .line 90
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGOUT_COMPLETE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 91
    iput-object v2, p0, Lcom/poshmark/controllers/ShowroomsController;->showroomGroupList:Lcom/poshmark/data_model/models/ShowroomGroupList;

    .line 92
    iput-object v2, p0, Lcom/poshmark/controllers/ShowroomsController;->lastFetchTime:Ljava/util/Date;

    .line 96
    :cond_0
    :goto_0
    return-void

    .line 93
    :cond_1
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.NEW_SHOWROOMS_ON_SERVER"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 94
    invoke-virtual {p0}, Lcom/poshmark/controllers/ShowroomsController;->getShowroomsData()V

    goto :goto_0
.end method

.method public isModelPopulated()Z
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/poshmark/controllers/ShowroomsController;->showroomGroupList:Lcom/poshmark/data_model/models/ShowroomGroupList;

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
    .line 82
    iget-object v0, p0, Lcom/poshmark/controllers/ShowroomsController;->lastFetchTime:Ljava/util/Date;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/poshmark/controllers/ShowroomsController;->lastFetchTime:Ljava/util/Date;

    invoke-virtual {v0, p1}, Ljava/util/Date;->before(Ljava/util/Date;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 83
    :cond_0
    const/4 v0, 0x1

    .line 85
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method
