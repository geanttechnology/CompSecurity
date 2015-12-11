.class public Lfq;
.super Ljava/lang/Object;
.source "SourceFile"


# direct methods
.method public static a(Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;)V
    .locals 6

    .prologue
    .line 20
    invoke-static {}, Lfo;->a()Lfo;

    move-result-object v0

    .line 22
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 23
    const-string v2, "appointment_id"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->getAppointmentId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 24
    const-string v2, "store_id"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->getStoreId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 25
    const-string v2, "store_name"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->getStoreName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 26
    const-string v2, "store_address"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->getStoreAddress()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 27
    const-string v2, "store_city"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->getStoreCity()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 28
    const-string v2, "store_opentime"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->getStoreOpenTime()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 29
    const-string v2, "appointment_time"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->getAppointmentTime()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 30
    const-string v2, "reminder_time"

    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/models/blueshirt/StoreAppointment;->getReminderTime()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 31
    const-string v2, "survey_shown"

    const/4 v3, 0x0

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 32
    if-eqz v0, :cond_0

    .line 33
    const-string v2, "store_appointment_time"

    invoke-virtual {v0, v2, v1}, Lfo;->a(Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 34
    :cond_0
    return-void
.end method

.method public static a(Ljava/lang/String;)V
    .locals 6

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x1

    .line 42
    invoke-static {}, Lfo;->a()Lfo;

    move-result-object v0

    .line 43
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 44
    const-string v2, "survey_shown"

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 45
    invoke-virtual {p0}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 46
    const-string v2, "store_appointment_time"

    invoke-virtual {v0, v2, v1, v5, v5}, Lfo;->a(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 51
    :goto_0
    return-void

    .line 48
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "appointment_id"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "=?"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 49
    const-string v3, "store_appointment_time"

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    aput-object p0, v4, v5

    invoke-virtual {v0, v3, v1, v2, v4}, Lfo;->a(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    goto :goto_0
.end method

.method public static a(Ljava/lang/String;J)V
    .locals 7

    .prologue
    .line 70
    invoke-static {}, Lfo;->a()Lfo;

    move-result-object v0

    .line 71
    new-instance v1, Landroid/content/ContentValues;

    invoke-direct {v1}, Landroid/content/ContentValues;-><init>()V

    .line 72
    const-string v2, "appointment_time"

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 73
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "appointment_id"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "=?"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 74
    const-string v3, "store_appointment_time"

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    aput-object p0, v4, v5

    invoke-virtual {v0, v3, v1, v2, v4}, Lfo;->a(Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    .line 75
    return-void
.end method

.method public static a(J)Z
    .locals 10

    .prologue
    const/4 v6, 0x1

    const/4 v2, 0x0

    const/4 v7, 0x0

    .line 83
    invoke-static {}, Lfo;->a()Lfo;

    move-result-object v0

    .line 85
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v3, "survey_shown"

    invoke-direct {v1, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "=?"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    .line 86
    const-string v1, "store_appointment_time"

    const-string v5, "appointment_time"

    move-object v3, v2

    move-object v4, v2

    invoke-virtual/range {v0 .. v5}, Lfo;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    .line 88
    const-string v1, "store_appointment_time"

    new-array v4, v6, [Ljava/lang/String;

    const-string v3, "0"

    aput-object v3, v4, v7

    const-string v5, "appointment_time"

    move-object v3, v8

    invoke-virtual/range {v0 .. v5}, Lfo;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 89
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_1

    .line 90
    invoke-interface {v1, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/ContentValues;

    const-string v2, "appointment_time"

    invoke-virtual {v0, v2}, Landroid/content/ContentValues;->getAsLong(Ljava/lang/String;)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    .line 91
    invoke-interface {v1, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/ContentValues;

    const-string v1, "appointment_id"

    invoke-virtual {v0, v1}, Landroid/content/ContentValues;->getAsString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 92
    const-wide/32 v4, 0xa4cb80

    add-long/2addr v4, v2

    .line 93
    const-wide/32 v8, 0x48190800

    add-long/2addr v2, v8

    .line 95
    cmp-long v1, p0, v4

    if-lez v1, :cond_0

    cmp-long v1, p0, v2

    if-gez v1, :cond_0

    .line 96
    const-string v0, ""

    invoke-static {v0}, Lfq;->a(Ljava/lang/String;)V

    move v0, v6

    .line 103
    :goto_0
    return v0

    .line 98
    :cond_0
    cmp-long v1, p0, v2

    if-lez v1, :cond_1

    .line 99
    invoke-static {v0}, Lfq;->a(Ljava/lang/String;)V

    move v0, v7

    .line 100
    goto :goto_0

    :cond_1
    move v0, v7

    .line 103
    goto :goto_0
.end method

.method public static b(Ljava/lang/String;)V
    .locals 5

    .prologue
    .line 58
    invoke-static {}, Lfo;->a()Lfo;

    move-result-object v0

    .line 59
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "appointment_id"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, "=?"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 60
    const-string v2, "store_appointment_time"

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    aput-object p0, v3, v4

    invoke-virtual {v0, v2, v1, v3}, Lfo;->a(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I

    .line 61
    return-void
.end method
