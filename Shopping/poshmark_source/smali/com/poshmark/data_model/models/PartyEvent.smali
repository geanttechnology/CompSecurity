.class public Lcom/poshmark/data_model/models/PartyEvent;
.super Ljava/lang/Object;
.source "PartyEvent.java"


# instance fields
.field aggregates:Lcom/poshmark/data_model/models/inner_models/PartyAggregates;

.field collections:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;",
            ">;"
        }
    .end annotation
.end field

.field cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

.field created_at:Ljava/lang/String;

.field creator_id:Ljava/lang/String;

.field description:Ljava/lang/String;

.field duration:Ljava/math/BigDecimal;

.field hosts:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/Host;",
            ">;"
        }
    .end annotation
.end field

.field id:Ljava/lang/String;

.field name:Ljava/lang/String;

.field reminder:Ljava/lang/String;

.field rsvp:Ljava/lang/String;

.field rsvp_at:Ljava/lang/String;

.field send_push:Z

.field short_url:Ljava/lang/String;

.field start_time:Ljava/lang/String;

.field status:Ljava/lang/String;

.field status_changed_at:Ljava/lang/String;

.field theme:Lcom/poshmark/data_model/models/inner_models/Theme;

.field updated_at:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/data_model/models/PartyEvent;->collections:Ljava/util/List;

    .line 48
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/data_model/models/PartyEvent;->hosts:Ljava/util/List;

    return-void
.end method


# virtual methods
.method public fillCursor(Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;)V
    .locals 6
    .param p1, "cursor"    # Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .prologue
    .line 196
    iget-object v2, p0, Lcom/poshmark/data_model/models/PartyEvent;->collections:Ljava/util/List;

    if-eqz v2, :cond_1

    .line 197
    iget-object v3, p0, Lcom/poshmark/data_model/models/PartyEvent;->collections:Ljava/util/List;

    monitor-enter v3

    .line 198
    :try_start_0
    iget-object v2, p0, Lcom/poshmark/data_model/models/PartyEvent;->collections:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;

    .line 199
    .local v1, "info":Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;
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

    .line 201
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "info":Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 203
    .end local v0    # "i$":Ljava/util/Iterator;
    :cond_1
    return-void
.end method

.method public getCollections()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;",
            ">;"
        }
    .end annotation

    .prologue
    .line 130
    iget-object v0, p0, Lcom/poshmark/data_model/models/PartyEvent;->collections:Ljava/util/List;

    return-object v0
.end method

.method public getCommaSeparatedHostNames()Ljava/lang/String;
    .locals 5

    .prologue
    .line 64
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 65
    .local v2, "result":Ljava/lang/StringBuilder;
    iget-object v3, p0, Lcom/poshmark/data_model/models/PartyEvent;->hosts:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/inner_models/Host;

    .line 66
    .local v0, "host":Lcom/poshmark/data_model/models/inner_models/Host;
    iget-object v3, v0, Lcom/poshmark/data_model/models/inner_models/Host;->username:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 67
    const-string v3, ", "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 69
    .end local v0    # "host":Lcom/poshmark/data_model/models/inner_models/Host;
    :cond_0
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->length()I

    move-result v3

    if-lez v3, :cond_1

    const/4 v3, 0x0

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->length()I

    move-result v4

    add-int/lit8 v4, v4, -0x2

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->substring(II)Ljava/lang/String;

    move-result-object v3

    :goto_1
    return-object v3

    :cond_1
    const-string v3, ""

    goto :goto_1
.end method

.method public getCovershot()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/poshmark/data_model/models/PartyEvent;->cover_shot:Lcom/poshmark/data_model/models/inner_models/CoverShot;

    iget-object v0, v0, Lcom/poshmark/data_model/models/inner_models/CoverShot;->url_small:Ljava/lang/String;

    return-object v0
.end method

.method public getDefaultShowroom()Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;
    .locals 3

    .prologue
    .line 186
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lcom/poshmark/data_model/models/PartyEvent;->collections:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 187
    iget-object v2, p0, Lcom/poshmark/data_model/models/PartyEvent;->collections:Ljava/util/List;

    invoke-interface {v2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;

    .line 188
    .local v1, "showroom":Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;
    invoke-virtual {v1}, Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;->isDefault()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 192
    .end local v1    # "showroom":Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;
    :goto_1
    return-object v1

    .line 186
    .restart local v1    # "showroom":Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 192
    .end local v1    # "showroom":Lcom/poshmark/data_model/models/inner_models/PartyRoomInfo;
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method

.method public getDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/poshmark/data_model/models/PartyEvent;->description:Ljava/lang/String;

    return-object v0
.end method

.method public getDuration()J
    .locals 2

    .prologue
    .line 277
    iget-object v0, p0, Lcom/poshmark/data_model/models/PartyEvent;->duration:Ljava/math/BigDecimal;

    invoke-virtual {v0}, Ljava/math/BigDecimal;->longValue()J

    move-result-wide v0

    return-wide v0
.end method

.method public getFormattedPendingTime()Ljava/lang/String;
    .locals 18

    .prologue
    .line 142
    invoke-virtual/range {p0 .. p0}, Lcom/poshmark/data_model/models/PartyEvent;->getMilliSecondsToEnd()J

    move-result-wide v12

    .line 143
    .local v12, "startMilliSeconds":J
    const-wide/16 v14, 0x0

    cmp-long v11, v12, v14

    if-gez v11, :cond_1

    .line 144
    const-string v7, ""

    .line 178
    :cond_0
    :goto_0
    return-object v7

    .line 146
    :cond_1
    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/poshmark/data_model/models/PartyEvent;->duration:Ljava/math/BigDecimal;

    new-instance v14, Ljava/math/BigDecimal;

    const-string v15, "1000"

    invoke-direct {v14, v15}, Ljava/math/BigDecimal;-><init>(Ljava/lang/String;)V

    invoke-virtual {v11, v14}, Ljava/math/BigDecimal;->multiply(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;

    move-result-object v11

    invoke-virtual {v11}, Ljava/math/BigDecimal;->longValue()J

    move-result-wide v14

    add-long v4, v12, v14

    .line 147
    .local v4, "endMilliSeconds":J
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 148
    .local v2, "currentMilliSeconds":J
    sub-long v14, v4, v2

    long-to-int v11, v14

    div-int/lit16 v10, v11, 0x3e8

    .line 150
    .local v10, "pendingSeconds":I
    div-int/lit8 v11, v10, 0x3c

    rem-int/lit8 v9, v11, 0x3c

    .line 151
    .local v9, "pendingMinutes":I
    div-int/lit16 v8, v10, 0xe10

    .line 153
    .local v8, "pendingHours":I
    new-instance v6, Ljava/lang/String;

    invoke-direct {v6}, Ljava/lang/String;-><init>()V

    .line 154
    .local v6, "hrString":Ljava/lang/String;
    new-instance v7, Ljava/lang/String;

    invoke-direct {v7}, Ljava/lang/String;-><init>()V

    .line 156
    .local v7, "minString":Ljava/lang/String;
    const/4 v11, 0x1

    if-ne v8, v11, :cond_4

    .line 157
    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v11, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v14, "%d hr"

    const/4 v15, 0x1

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    aput-object v17, v15, v16

    invoke-static {v14, v15}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v11, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 161
    :cond_2
    :goto_1
    const/4 v11, 0x1

    if-ne v9, v11, :cond_5

    .line 162
    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v11, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v14, "%d min"

    const/4 v15, 0x1

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    aput-object v17, v15, v16

    invoke-static {v14, v15}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v11, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 166
    :cond_3
    :goto_2
    if-nez v8, :cond_6

    if-nez v9, :cond_6

    .line 167
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v11

    const v14, 0x7f060161

    invoke-virtual {v11, v14}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v7

    goto/16 :goto_0

    .line 158
    :cond_4
    const/4 v11, 0x1

    if-le v8, v11, :cond_2

    .line 159
    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v11, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v14, "%d hrs"

    const/4 v15, 0x1

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    aput-object v17, v15, v16

    invoke-static {v14, v15}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v11, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    goto :goto_1

    .line 163
    :cond_5
    const/4 v11, 0x1

    if-le v9, v11, :cond_3

    .line 164
    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v11, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v14, "%d mins"

    const/4 v15, 0x1

    new-array v15, v15, [Ljava/lang/Object;

    const/16 v16, 0x0

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v17

    aput-object v17, v15, v16

    invoke-static {v14, v15}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v11, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    goto :goto_2

    .line 168
    :cond_6
    if-eqz v8, :cond_7

    if-nez v9, :cond_8

    .line 169
    :cond_7
    if-eqz v8, :cond_0

    .line 171
    if-nez v9, :cond_9

    move-object v7, v6

    .line 172
    goto/16 :goto_0

    .line 175
    :cond_8
    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v11, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    goto/16 :goto_0

    .line 178
    :cond_9
    const-string v7, ""

    goto/16 :goto_0
.end method

.method public getHosts()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/Host;",
            ">;"
        }
    .end annotation

    .prologue
    .line 73
    iget-object v0, p0, Lcom/poshmark/data_model/models/PartyEvent;->hosts:Ljava/util/List;

    return-object v0
.end method

.method public getId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/poshmark/data_model/models/PartyEvent;->id:Ljava/lang/String;

    return-object v0
.end method

.method public getListingCount()I
    .locals 1

    .prologue
    .line 114
    iget-object v0, p0, Lcom/poshmark/data_model/models/PartyEvent;->aggregates:Lcom/poshmark/data_model/models/inner_models/PartyAggregates;

    iget v0, v0, Lcom/poshmark/data_model/models/inner_models/PartyAggregates;->posts:I

    return v0
.end method

.method public getMilliSecondsToEnd()J
    .locals 4

    .prologue
    .line 134
    invoke-virtual {p0}, Lcom/poshmark/data_model/models/PartyEvent;->isHappeningNow()Z

    move-result v1

    if-nez v1, :cond_0

    .line 135
    const-wide/16 v2, -0x1

    .line 138
    :goto_0
    return-wide v2

    .line 137
    :cond_0
    iget-object v1, p0, Lcom/poshmark/data_model/models/PartyEvent;->start_time:Ljava/lang/String;

    invoke-static {v1}, Lcom/poshmark/utils/DateUtils;->getDateFromString(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    .line 138
    .local v0, "eventDate":Ljava/util/Date;
    invoke-virtual {v0}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    goto :goto_0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 273
    iget-object v0, p0, Lcom/poshmark/data_model/models/PartyEvent;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getStartDateTimeString(Landroid/content/Context;)Ljava/lang/String;
    .locals 5
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 77
    iget-object v3, p0, Lcom/poshmark/data_model/models/PartyEvent;->start_time:Ljava/lang/String;

    invoke-static {v3}, Lcom/poshmark/utils/DateUtils;->getDateFromString(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v2

    .line 78
    .local v2, "startDate":Ljava/util/Date;
    new-instance v3, Ljava/text/SimpleDateFormat;

    const-string v4, "EEE MMM d"

    invoke-direct {v3, v4}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v2}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v0

    .line 79
    .local v0, "formattedDate":Ljava/lang/String;
    new-instance v3, Ljava/text/SimpleDateFormat;

    const-string v4, "h:mm a"

    invoke-direct {v3, v4}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v2}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v1

    .line 80
    .local v1, "formattedTime":Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const v4, 0x7f06004b

    invoke-virtual {p1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method

.method public getStartTime()Ljava/lang/String;
    .locals 1

    .prologue
    .line 269
    iget-object v0, p0, Lcom/poshmark/data_model/models/PartyEvent;->start_time:Ljava/lang/String;

    return-object v0
.end method

.method public getTheme()Lcom/poshmark/data_model/models/inner_models/Theme;
    .locals 1

    .prologue
    .line 206
    iget-object v0, p0, Lcom/poshmark/data_model/models/PartyEvent;->theme:Lcom/poshmark/data_model/models/inner_models/Theme;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/poshmark/data_model/models/PartyEvent;->name:Ljava/lang/String;

    return-object v0
.end method

.method public getURL()Ljava/lang/String;
    .locals 2

    .prologue
    .line 210
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "https://www.poshmark.com/parties/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/poshmark/data_model/models/PartyEvent;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public hasShowrooms()Z
    .locals 1

    .prologue
    .line 182
    iget-object v0, p0, Lcom/poshmark/data_model/models/PartyEvent;->collections:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isFutureEvent()Z
    .locals 3

    .prologue
    .line 104
    iget-object v2, p0, Lcom/poshmark/data_model/models/PartyEvent;->start_time:Ljava/lang/String;

    invoke-static {v2}, Lcom/poshmark/utils/DateUtils;->getDateFromString(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v1

    .line 105
    .local v1, "startDate":Ljava/util/Date;
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    .line 106
    .local v0, "currentTime":Ljava/util/Date;
    invoke-virtual {v1, v0}, Ljava/util/Date;->after(Ljava/util/Date;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 107
    const/4 v2, 0x1

    .line 110
    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public isHappeningNow()Z
    .locals 4

    .prologue
    .line 84
    iget-object v1, p0, Lcom/poshmark/data_model/models/PartyEvent;->start_time:Ljava/lang/String;

    invoke-static {v1}, Lcom/poshmark/utils/DateUtils;->getDateFromString(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v0

    .line 85
    .local v0, "startDate":Ljava/util/Date;
    iget-object v1, p0, Lcom/poshmark/data_model/models/PartyEvent;->duration:Ljava/math/BigDecimal;

    invoke-virtual {v1}, Ljava/math/BigDecimal;->longValue()J

    move-result-wide v2

    sget-object v1, Lcom/poshmark/utils/DateUtils$TIME_UNIT;->SECONDS:Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    invoke-static {v0, v2, v3, v1}, Lcom/poshmark/utils/DateUtils;->isDateWithinPastWindow(Ljava/util/Date;JLcom/poshmark/utils/DateUtils$TIME_UNIT;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 86
    const/4 v1, 0x1

    .line 88
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public isListingEligibleForParty(Lcom/poshmark/data_model/models/ListingSummary;)Z
    .locals 3
    .param p1, "listingItem"    # Lcom/poshmark/data_model/models/ListingSummary;

    .prologue
    .line 214
    const/4 v0, 0x0

    .line 215
    .local v0, "retVal":Z
    if-eqz p1, :cond_0

    .line 216
    iget-object v1, p0, Lcom/poshmark/data_model/models/PartyEvent;->theme:Lcom/poshmark/data_model/models/inner_models/Theme;

    if-nez v1, :cond_1

    .line 217
    const/4 v0, 0x1

    .line 236
    :cond_0
    :goto_0
    return v0

    .line 219
    :cond_1
    iget-object v1, p0, Lcom/poshmark/data_model/models/PartyEvent;->theme:Lcom/poshmark/data_model/models/inner_models/Theme;

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingSummary;->getCategoryId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/data_model/models/inner_models/Theme;->isMatchingCategory(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 220
    const/4 v0, 0x0

    goto :goto_0

    .line 221
    :cond_2
    iget-object v1, p0, Lcom/poshmark/data_model/models/PartyEvent;->theme:Lcom/poshmark/data_model/models/inner_models/Theme;

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingSummary;->getSubCategoryList()Ljava/util/List;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/data_model/models/inner_models/Theme;->isMatchingSubCategory(Ljava/util/List;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 222
    const/4 v0, 0x0

    goto :goto_0

    .line 223
    :cond_3
    iget-object v1, p0, Lcom/poshmark/data_model/models/PartyEvent;->theme:Lcom/poshmark/data_model/models/inner_models/Theme;

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingSummary;->getColorList()Ljava/util/List;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/data_model/models/inner_models/Theme;->isMatchingColor(Ljava/util/List;)Z

    move-result v1

    if-nez v1, :cond_4

    .line 224
    const/4 v0, 0x0

    goto :goto_0

    .line 225
    :cond_4
    iget-object v1, p0, Lcom/poshmark/data_model/models/PartyEvent;->theme:Lcom/poshmark/data_model/models/inner_models/Theme;

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingSummary;->getSize()Ljava/lang/CharSequence;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/data_model/models/inner_models/Theme;->isMatchingSize(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_5

    .line 226
    const/4 v0, 0x0

    goto :goto_0

    .line 227
    :cond_5
    iget-object v1, p0, Lcom/poshmark/data_model/models/PartyEvent;->theme:Lcom/poshmark/data_model/models/inner_models/Theme;

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingSummary;->getBrand()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/data_model/models/inner_models/Theme;->isMatchingBrand(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_6

    .line 228
    const/4 v0, 0x0

    goto :goto_0

    .line 229
    :cond_6
    iget-object v1, p0, Lcom/poshmark/data_model/models/PartyEvent;->theme:Lcom/poshmark/data_model/models/inner_models/Theme;

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingSummary;->getPrice()Ljava/math/BigDecimal;

    move-result-object v2

    invoke-virtual {v2}, Ljava/math/BigDecimal;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/poshmark/data_model/models/inner_models/Theme;->isMatchingPrice(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_7

    .line 230
    const/4 v0, 0x0

    goto :goto_0

    .line 232
    :cond_7
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public isListingEligibleForParty(Lcom/poshmark/data_model/models/NewListing;)Z
    .locals 4
    .param p1, "listingItem"    # Lcom/poshmark/data_model/models/NewListing;

    .prologue
    .line 240
    const/4 v1, 0x0

    .line 241
    .local v1, "retVal":Z
    if-eqz p1, :cond_0

    .line 242
    iget-object v2, p0, Lcom/poshmark/data_model/models/PartyEvent;->theme:Lcom/poshmark/data_model/models/inner_models/Theme;

    if-nez v2, :cond_1

    .line 243
    const/4 v1, 0x1

    .line 265
    :cond_0
    :goto_0
    return v1

    .line 245
    :cond_1
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/NewListing;->getCategory()Lcom/poshmark/data_model/models/MetaItem;

    move-result-object v0

    .line 246
    .local v0, "categoryMeta":Lcom/poshmark/data_model/models/MetaItem;
    if-eqz v0, :cond_0

    .line 247
    iget-object v2, p0, Lcom/poshmark/data_model/models/PartyEvent;->theme:Lcom/poshmark/data_model/models/inner_models/Theme;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/MetaItem;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/data_model/models/inner_models/Theme;->isMatchingCategory(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 248
    const/4 v1, 0x0

    goto :goto_0

    .line 249
    :cond_2
    iget-object v2, p0, Lcom/poshmark/data_model/models/PartyEvent;->theme:Lcom/poshmark/data_model/models/inner_models/Theme;

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/NewListing;->getSubCategoryList()Ljava/util/List;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/data_model/models/inner_models/Theme;->isMatchingSubCategory(Ljava/util/List;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 250
    const/4 v1, 0x0

    goto :goto_0

    .line 251
    :cond_3
    iget-object v2, p0, Lcom/poshmark/data_model/models/PartyEvent;->theme:Lcom/poshmark/data_model/models/inner_models/Theme;

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/NewListing;->getColors()Ljava/util/List;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/data_model/models/inner_models/Theme;->isMatchingColor(Ljava/util/List;)Z

    move-result v2

    if-nez v2, :cond_4

    .line 252
    const/4 v1, 0x0

    goto :goto_0

    .line 253
    :cond_4
    iget-object v2, p0, Lcom/poshmark/data_model/models/PartyEvent;->theme:Lcom/poshmark/data_model/models/inner_models/Theme;

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/NewListing;->getSize()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/data_model/models/inner_models/Theme;->isMatchingSize(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_5

    .line 254
    const/4 v1, 0x0

    goto :goto_0

    .line 255
    :cond_5
    iget-object v2, p0, Lcom/poshmark/data_model/models/PartyEvent;->theme:Lcom/poshmark/data_model/models/inner_models/Theme;

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/NewListing;->getBrand()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/data_model/models/inner_models/Theme;->isMatchingBrand(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_6

    .line 256
    const/4 v1, 0x0

    goto :goto_0

    .line 257
    :cond_6
    iget-object v2, p0, Lcom/poshmark/data_model/models/PartyEvent;->theme:Lcom/poshmark/data_model/models/inner_models/Theme;

    invoke-virtual {p1}, Lcom/poshmark/data_model/models/NewListing;->getPrice()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/poshmark/data_model/models/inner_models/Theme;->isMatchingPrice(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_7

    .line 258
    const/4 v1, 0x0

    goto :goto_0

    .line 260
    :cond_7
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public isPastEvent()Z
    .locals 6

    .prologue
    const/4 v2, 0x0

    .line 92
    iget-object v3, p0, Lcom/poshmark/data_model/models/PartyEvent;->start_time:Ljava/lang/String;

    invoke-static {v3}, Lcom/poshmark/utils/DateUtils;->getDateFromString(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v1

    .line 93
    .local v1, "startDate":Ljava/util/Date;
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    .line 94
    .local v0, "currentTime":Ljava/util/Date;
    invoke-virtual {v1, v0}, Ljava/util/Date;->after(Ljava/util/Date;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 100
    :cond_0
    :goto_0
    return v2

    .line 97
    :cond_1
    iget-object v3, p0, Lcom/poshmark/data_model/models/PartyEvent;->duration:Ljava/math/BigDecimal;

    invoke-virtual {v3}, Ljava/math/BigDecimal;->longValue()J

    move-result-wide v4

    sget-object v3, Lcom/poshmark/utils/DateUtils$TIME_UNIT;->SECONDS:Lcom/poshmark/utils/DateUtils$TIME_UNIT;

    invoke-static {v1, v4, v5, v3}, Lcom/poshmark/utils/DateUtils;->isDateWithinPastWindow(Ljava/util/Date;JLcom/poshmark/utils/DateUtils$TIME_UNIT;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 100
    const/4 v2, 0x1

    goto :goto_0
.end method

.method public isReminderEnabled()Z
    .locals 2

    .prologue
    .line 118
    iget-object v0, p0, Lcom/poshmark/data_model/models/PartyEvent;->reminder:Ljava/lang/String;

    const-string v1, "local"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 119
    const/4 v0, 0x1

    .line 121
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
