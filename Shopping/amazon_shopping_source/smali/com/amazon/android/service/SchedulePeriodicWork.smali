.class public final Lcom/amazon/android/service/SchedulePeriodicWork;
.super Ljava/lang/Object;
.source "SchedulePeriodicWork.java"


# static fields
.field private static final LOG:Lcom/amazon/logging/Logger;

.field private static final SHARED_PREFS_NAME:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 29
    const-class v0, Lcom/amazon/android/service/SchedulePeriodicWork;

    invoke-virtual {v0}, Ljava/lang/Class;->getCanonicalName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/service/SchedulePeriodicWork;->SHARED_PREFS_NAME:Ljava/lang/String;

    .line 32
    const-class v0, Lcom/amazon/android/service/SchedulePeriodicWork;

    invoke-static {v0}, Lcom/amazon/logging/Logger;->getLogger(Ljava/lang/Class;)Lcom/amazon/logging/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/service/SchedulePeriodicWork;->LOG:Lcom/amazon/logging/Logger;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 102
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 103
    return-void
.end method

.method private static cancelAlarmsAndPendingIntentsForIntent(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "serviceIntent"    # Landroid/content/Intent;

    .prologue
    .line 266
    const/4 v2, 0x0

    const/high16 v3, 0x20000000

    invoke-static {p0, v2, p1, v3}, Landroid/app/PendingIntent;->getService(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v1

    .line 269
    .local v1, "pendingIntent":Landroid/app/PendingIntent;
    if-eqz v1, :cond_0

    .line 270
    sget-object v2, Lcom/amazon/android/service/SchedulePeriodicWork;->LOG:Lcom/amazon/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "Cancelling pending intent for "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {p1}, Lcom/amazon/android/service/SchedulePeriodicWork;->getWorkIdentifier(Landroid/content/Intent;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "  (SCHEDULER)"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/logging/Logger;->v(Ljava/lang/String;)V

    .line 273
    const-string/jumbo v2, "alarm"

    invoke-virtual {p0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AlarmManager;

    .line 274
    .local v0, "alarmManager":Landroid/app/AlarmManager;
    invoke-virtual {v0, v1}, Landroid/app/AlarmManager;->cancel(Landroid/app/PendingIntent;)V

    .line 275
    invoke-virtual {v1}, Landroid/app/PendingIntent;->cancel()V

    .line 277
    .end local v0    # "alarmManager":Landroid/app/AlarmManager;
    :cond_0
    return-void
.end method

.method public static cancelWork(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "serviceIntent"    # Landroid/content/Intent;

    .prologue
    .line 243
    invoke-static {p1}, Lcom/amazon/android/service/SchedulePeriodicWork;->getWorkIdentifier(Landroid/content/Intent;)Ljava/lang/String;

    move-result-object v0

    .line 244
    .local v0, "workIdentifier":Ljava/lang/String;
    sget-object v1, Lcom/amazon/android/service/SchedulePeriodicWork;->LOG:Lcom/amazon/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Cancelling work for "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " (SCHEDULER)"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/logging/Logger;->d(Ljava/lang/String;)V

    .line 247
    invoke-static {p0}, Lcom/amazon/android/service/SchedulePeriodicWork;->getSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string/jumbo v2, ".lastRun"

    invoke-virtual {v0, v2}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string/jumbo v2, ".scheduleTime"

    invoke-virtual {v0, v2}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string/jumbo v2, ".period"

    invoke-virtual {v0, v2}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string/jumbo v2, ".scheduledFor"

    invoke-virtual {v0, v2}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    const-string/jumbo v2, ".timeout"

    invoke-virtual {v0, v2}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 255
    invoke-static {p0, p1}, Lcom/amazon/android/service/SchedulePeriodicWork;->cancelAlarmsAndPendingIntentsForIntent(Landroid/content/Context;Landroid/content/Intent;)V

    .line 257
    return-void
.end method

.method public static forceRescheduleWork(Landroid/content/Context;Landroid/content/Intent;J)V
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "serviceIntent"    # Landroid/content/Intent;
    .param p2, "periodMillis"    # J
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 330
    const-wide/32 v4, 0xea60

    move-object v0, p0

    move-object v1, p1

    move-wide v2, p2

    invoke-static/range {v0 .. v5}, Lcom/amazon/android/service/SchedulePeriodicWork;->forceRescheduleWork(Landroid/content/Context;Landroid/content/Intent;JJ)V

    .line 331
    return-void
.end method

.method public static forceRescheduleWork(Landroid/content/Context;Landroid/content/Intent;JJ)V
    .locals 10
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "serviceIntent"    # Landroid/content/Intent;
    .param p2, "periodMillis"    # J
    .param p4, "delayMillis"    # J
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    const-wide/16 v6, 0x0

    .line 295
    cmp-long v0, p2, v6

    if-ltz v0, :cond_0

    cmp-long v0, p4, v6

    if-gez v0, :cond_1

    .line 296
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v6, "Negative period or delay, not continuing. (SCHEDULER)"

    invoke-direct {v0, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 300
    :cond_1
    invoke-static {p0, p1}, Lcom/amazon/android/service/SchedulePeriodicWork;->cancelAlarmsAndPendingIntentsForIntent(Landroid/content/Context;Landroid/content/Intent;)V

    .line 302
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 303
    .local v2, "currentTime":J
    invoke-static {p1}, Lcom/amazon/android/service/SchedulePeriodicWork;->getWorkIdentifier(Landroid/content/Intent;)Ljava/lang/String;

    move-result-object v1

    .line 305
    .local v1, "workIdentifier":Ljava/lang/String;
    add-long v4, v2, p4

    .local v4, "willRunAtMillis":J
    move-object v0, p0

    move-wide v6, p2

    .line 310
    invoke-static/range {v0 .. v7}, Lcom/amazon/android/service/SchedulePeriodicWork;->setPrefValues(Landroid/content/Context;Ljava/lang/String;JJJ)V

    .line 312
    invoke-static {p0, p1}, Lcom/amazon/android/service/SchedulePeriodicWork;->getPendingIntent(Landroid/content/Context;Landroid/content/Intent;)Landroid/app/PendingIntent;

    move-result-object v9

    .line 313
    .local v9, "pendingIntent":Landroid/app/PendingIntent;
    const-string/jumbo v0, "alarm"

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/app/AlarmManager;

    .line 314
    .local v8, "alarmManager":Landroid/app/AlarmManager;
    const/4 v0, 0x1

    invoke-virtual {v8, v0, v4, v5, v9}, Landroid/app/AlarmManager;->set(IJLandroid/app/PendingIntent;)V

    .line 315
    return-void
.end method

.method private static getLastRunTime(Landroid/content/Context;Ljava/lang/String;)J
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "workIdentifier"    # Ljava/lang/String;

    .prologue
    .line 508
    invoke-static {p0}, Lcom/amazon/android/service/SchedulePeriodicWork;->getSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string/jumbo v1, ".lastRun"

    invoke-virtual {p1, v1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-wide/16 v2, -0x1

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v0

    return-wide v0
.end method

.method private static getPendingIntent(Landroid/content/Context;Landroid/content/Intent;)Landroid/app/PendingIntent;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "serviceIntent"    # Landroid/content/Intent;

    .prologue
    .line 411
    const/4 v0, 0x0

    const/high16 v1, 0x10000000

    invoke-static {p0, v0, p1, v1}, Landroid/app/PendingIntent;->getService(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    return-object v0
.end method

.method private static getPeriod(Landroid/content/Context;Ljava/lang/String;)J
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "workIdentifier"    # Ljava/lang/String;

    .prologue
    .line 593
    invoke-static {p0}, Lcom/amazon/android/service/SchedulePeriodicWork;->getSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string/jumbo v1, ".period"

    invoke-virtual {p1, v1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-wide/16 v2, -0x1

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v0

    return-wide v0
.end method

.method private static getScheduleOriginTime(Landroid/content/Context;)J
    .locals 6
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 189
    invoke-static {p0}, Lcom/amazon/android/service/SchedulePeriodicWork;->getSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 190
    .local v2, "prefs":Landroid/content/SharedPreferences;
    const-string/jumbo v3, "alarmOrigin"

    invoke-interface {v2, v3}, Landroid/content/SharedPreferences;->contains(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 192
    new-instance v3, Ljava/util/Date;

    invoke-direct {v3}, Ljava/util/Date;-><init>()V

    invoke-virtual {v3}, Ljava/util/Date;->getTime()J

    move-result-wide v0

    .line 193
    .local v0, "now":J
    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    const-string/jumbo v4, "alarmOrigin"

    invoke-interface {v3, v4, v0, v1}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    invoke-interface {v3}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 195
    sget-object v3, Lcom/amazon/android/service/SchedulePeriodicWork;->LOG:Lcom/amazon/logging/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "(SCHEDULER) Origin time set to "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    new-instance v5, Ljava/util/Date;

    invoke-direct {v5, v0, v1}, Ljava/util/Date;-><init>(J)V

    invoke-virtual {v5}, Ljava/util/Date;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/logging/Logger;->d(Ljava/lang/String;)V

    .line 198
    .end local v0    # "now":J
    :goto_0
    return-wide v0

    :cond_0
    const-string/jumbo v3, "alarmOrigin"

    const-wide/16 v4, -0x1

    invoke-interface {v2, v3, v4, v5}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v0

    goto :goto_0
.end method

.method private static getScheduleTime(Landroid/content/Context;Ljava/lang/String;)J
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "workIdentifier"    # Ljava/lang/String;

    .prologue
    .line 541
    invoke-static {p0}, Lcom/amazon/android/service/SchedulePeriodicWork;->getSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string/jumbo v1, ".scheduleTime"

    invoke-virtual {p1, v1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-wide/16 v2, -0x1

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v0

    return-wide v0
.end method

.method private static getScheduledFor(Landroid/content/Context;Ljava/lang/String;)J
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "workIdentifier"    # Ljava/lang/String;

    .prologue
    .line 580
    invoke-static {p0}, Lcom/amazon/android/service/SchedulePeriodicWork;->getSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    const-string/jumbo v1, ".scheduledFor"

    invoke-virtual {p1, v1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-wide/16 v2, -0x1

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v0

    return-wide v0
.end method

.method private static getSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 621
    sget-object v0, Lcom/amazon/android/service/SchedulePeriodicWork;->SHARED_PREFS_NAME:Ljava/lang/String;

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    return-object v0
.end method

.method private static getSuitableRetryDelayMillis(J)J
    .locals 5
    .param p0, "periodMillis"    # J

    .prologue
    const-wide/32 v2, 0x5265c00

    const-wide/32 v0, 0x1499700

    .line 478
    cmp-long v4, p0, v0

    if-gtz v4, :cond_1

    .line 479
    const-wide/16 v0, -0x1

    .line 483
    :cond_0
    :goto_0
    return-wide v0

    .line 480
    :cond_1
    cmp-long v4, p0, v2

    if-lez v4, :cond_0

    move-wide v0, v2

    .line 483
    goto :goto_0
.end method

.method private static getWorkIdentifier(Landroid/content/Intent;)Ljava/lang/String;
    .locals 5
    .param p0, "serviceIntent"    # Landroid/content/Intent;

    .prologue
    .line 632
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 634
    .local v2, "workIdentifierBuilder":Ljava/lang/StringBuilder;
    invoke-virtual {p0}, Landroid/content/Intent;->getComponent()Landroid/content/ComponentName;

    move-result-object v1

    .line 635
    .local v1, "componentName":Landroid/content/ComponentName;
    if-eqz v1, :cond_0

    .line 636
    invoke-virtual {v1}, Landroid/content/ComponentName;->flattenToString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "-"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 638
    :cond_0
    invoke-virtual {p0}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 639
    .local v0, "action":Ljava/lang/String;
    if-eqz v0, :cond_1

    .line 640
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 643
    :cond_1
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method

.method private static scheduleToWindow(Landroid/content/Context;Landroid/content/Intent;JLjava/lang/String;)V
    .locals 23
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "serviceIntent"    # Landroid/content/Intent;
    .param p2, "periodMillis"    # J
    .param p4, "workIdentifier"    # Ljava/lang/String;

    .prologue
    .line 381
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    invoke-static {v3, v4}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v11

    .line 383
    .local v11, "currentTime":Ljava/lang/Long;
    invoke-static/range {p0 .. p0}, Lcom/amazon/android/service/SchedulePeriodicWork;->getScheduleOriginTime(Landroid/content/Context;)J

    move-result-wide v12

    .line 384
    .local v12, "originTime":J
    invoke-virtual {v11}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    add-long v21, v3, p2

    .line 385
    .local v21, "wouldScheduleAt":J
    sub-long v3, v21, v12

    long-to-double v3, v3

    const-wide v5, 0x414b774000000000L    # 3600000.0

    div-double v14, v3, v5

    .line 386
    .local v14, "phases":D
    invoke-static {v14, v15}, Ljava/lang/Math;->ceil(D)D

    move-result-wide v3

    double-to-long v9, v3

    .line 388
    .local v9, "actualPhases":J
    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v3

    const-wide v5, 0x4066800000000000L    # 180.0

    mul-double/2addr v3, v5

    const-wide v5, 0x408f400000000000L    # 1000.0

    mul-double/2addr v3, v5

    invoke-static {v3, v4}, Ljava/lang/Math;->round(D)J

    move-result-wide v16

    .line 389
    .local v16, "randomJitter":J
    const-wide/32 v3, 0x36ee80

    mul-long/2addr v3, v9

    add-long/2addr v3, v12

    add-long v18, v3, v16

    .line 391
    .local v18, "rightTime":J
    invoke-virtual {v11}, Ljava/lang/Long;->longValue()J

    move-result-wide v3

    sub-long v7, v18, v3

    .line 397
    .local v7, "adjustedDelayMillis":J
    new-instance v20, Ljava/util/Date;

    move-object/from16 v0, v20

    move-wide/from16 v1, v18

    invoke-direct {v0, v1, v2}, Ljava/util/Date;-><init>(J)V

    .line 399
    .local v20, "willRunAt":Ljava/util/Date;
    sget-object v3, Lcom/amazon/android/service/SchedulePeriodicWork;->LOG:Lcom/amazon/logging/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, " - next work will occur at "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual/range {v20 .. v20}, Ljava/util/Date;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, " (SCHEDULER)"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/logging/Logger;->i(Ljava/lang/String;)V

    move-object/from16 v3, p0

    move-object/from16 v4, p1

    move-wide/from16 v5, p2

    .line 401
    invoke-static/range {v3 .. v8}, Lcom/amazon/android/service/SchedulePeriodicWork;->forceRescheduleWork(Landroid/content/Context;Landroid/content/Intent;JJ)V

    .line 402
    return-void
.end method

.method public static scheduleWork(Landroid/content/Context;Landroid/content/Intent;J)V
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "serviceIntent"    # Landroid/content/Intent;
    .param p2, "periodMillis"    # J

    .prologue
    .line 232
    const-wide/32 v4, 0xea60

    move-object v0, p0

    move-object v1, p1

    move-wide v2, p2

    invoke-static/range {v0 .. v5}, Lcom/amazon/android/service/SchedulePeriodicWork;->scheduleWork(Landroid/content/Context;Landroid/content/Intent;JJ)V

    .line 233
    return-void
.end method

.method public static scheduleWork(Landroid/content/Context;Landroid/content/Intent;JJ)V
    .locals 8
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "serviceIntent"    # Landroid/content/Intent;
    .param p2, "periodMillis"    # J
    .param p4, "delayMillis"    # J

    .prologue
    .line 217
    const-wide/16 v0, 0x2

    mul-long v6, p2, v0

    move-object v0, p0

    move-object v1, p1

    move-wide v2, p2

    move-wide v4, p4

    invoke-static/range {v0 .. v7}, Lcom/amazon/android/service/SchedulePeriodicWork;->scheduleWork(Landroid/content/Context;Landroid/content/Intent;JJJ)V

    .line 219
    return-void
.end method

.method public static scheduleWork(Landroid/content/Context;Landroid/content/Intent;JJJ)V
    .locals 20
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "serviceIntent"    # Landroid/content/Intent;
    .param p2, "periodMillis"    # J
    .param p4, "delayMillis"    # J
    .param p6, "timeoutMillis"    # J

    .prologue
    .line 134
    cmp-long v5, p6, p2

    if-gez v5, :cond_0

    .line 135
    new-instance v5, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v6, "Timeout must be greater than period!"

    invoke-direct {v5, v6}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v5

    .line 138
    :cond_0
    invoke-static/range {p1 .. p1}, Lcom/amazon/android/service/SchedulePeriodicWork;->getWorkIdentifier(Landroid/content/Intent;)Ljava/lang/String;

    move-result-object v19

    .line 139
    .local v19, "workIdentifier":Ljava/lang/String;
    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-static {v0, v1}, Lcom/amazon/android/service/SchedulePeriodicWork;->getLastRunTime(Landroid/content/Context;Ljava/lang/String;)J

    move-result-wide v12

    .line 140
    .local v12, "lastRun":J
    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-static {v0, v1}, Lcom/amazon/android/service/SchedulePeriodicWork;->getScheduleTime(Landroid/content/Context;Ljava/lang/String;)J

    move-result-wide v16

    .line 142
    .local v16, "scheduleTime":J
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v11

    .line 144
    .local v11, "currentTime":Ljava/lang/Long;
    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-static {v0, v1}, Lcom/amazon/android/service/SchedulePeriodicWork;->getScheduledFor(Landroid/content/Context;Ljava/lang/String;)J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v18

    .line 147
    .local v18, "scheduledFor":Ljava/lang/Long;
    const-wide/16 v5, 0x0

    cmp-long v5, v16, v5

    if-ltz v5, :cond_1

    add-long v5, v16, p4

    invoke-virtual {v11}, Ljava/lang/Long;->longValue()J

    move-result-wide v7

    cmp-long v5, v5, v7

    if-gez v5, :cond_2

    invoke-virtual {v11}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    cmp-long v5, v5, v12

    if-ltz v5, :cond_1

    invoke-virtual {v11}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    add-long v7, v12, p6

    cmp-long v5, v5, v7

    if-lez v5, :cond_2

    :cond_1
    const/4 v15, 0x1

    .line 152
    .local v15, "reschedule":Z
    :goto_0
    if-nez v15, :cond_3

    .line 157
    const/4 v5, 0x0

    const/high16 v6, 0x20000000

    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-static {v0, v5, v1, v6}, Landroid/app/PendingIntent;->getService(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v14

    .line 159
    .local v14, "pendingIntent":Landroid/app/PendingIntent;
    if-eqz v14, :cond_3

    .line 161
    sget-object v5, Lcom/amazon/android/service/SchedulePeriodicWork;->LOG:Lcom/amazon/logging/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, " is within acceptable timeout period of "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-wide/32 v7, 0x36ee80

    div-long v7, p6, v7

    invoke-virtual {v6, v7, v8}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, " hours and is scheduled to run at "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    new-instance v7, Ljava/util/Date;

    invoke-virtual/range {v18 .. v18}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    invoke-direct {v7, v8, v9}, Ljava/util/Date;-><init>(J)V

    invoke-virtual {v7}, Ljava/util/Date;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, ". No need to "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, "reschedule now (SCHEDULER)"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/amazon/logging/Logger;->d(Ljava/lang/String;)V

    .line 180
    .end local v14    # "pendingIntent":Landroid/app/PendingIntent;
    :goto_1
    return-void

    .line 147
    .end local v15    # "reschedule":Z
    :cond_2
    const/4 v15, 0x0

    goto :goto_0

    .line 169
    .restart local v15    # "reschedule":Z
    :cond_3
    move-object/from16 v0, p0

    move-object/from16 v1, v19

    move-wide/from16 v2, p6

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/android/service/SchedulePeriodicWork;->setTimeout(Landroid/content/Context;Ljava/lang/String;J)V

    .line 171
    const-wide/16 v5, 0x0

    cmp-long v5, v16, v5

    if-ltz v5, :cond_4

    const-wide/16 v5, 0x0

    cmp-long v5, v12, v5

    if-ltz v5, :cond_4

    add-long v5, v12, p2

    const-wide/32 v7, 0x36ee80

    add-long/2addr v5, v7

    invoke-virtual {v11}, Ljava/lang/Long;->longValue()J

    move-result-wide v7

    cmp-long v5, v5, v7

    if-gez v5, :cond_5

    .line 172
    :cond_4
    sget-object v5, Lcom/amazon/android/service/SchedulePeriodicWork;->LOG:Lcom/amazon/logging/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, " is being scheduled for now, skipping windowing logic. (SCHEDULER)"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/amazon/logging/Logger;->i(Ljava/lang/String;)V

    .line 173
    const-wide/32 v9, 0xea60

    move-object/from16 v5, p0

    move-object/from16 v6, p1

    move-wide/from16 v7, p2

    invoke-static/range {v5 .. v10}, Lcom/amazon/android/service/SchedulePeriodicWork;->forceRescheduleWork(Landroid/content/Context;Landroid/content/Intent;JJ)V

    goto :goto_1

    .line 175
    :cond_5
    sget-object v5, Lcom/amazon/android/service/SchedulePeriodicWork;->LOG:Lcom/amazon/logging/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v19

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, " is being scheduled into a window. lastRun = "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    new-instance v7, Ljava/util/Date;

    invoke-direct {v7, v12, v13}, Ljava/util/Date;-><init>(J)V

    invoke-virtual {v7}, Ljava/util/Date;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, ""

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, " (SCHEDULER)"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/amazon/logging/Logger;->d(Ljava/lang/String;)V

    .line 177
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    move-wide/from16 v2, p2

    move-object/from16 v4, v19

    invoke-static {v0, v1, v2, v3, v4}, Lcom/amazon/android/service/SchedulePeriodicWork;->scheduleToWindow(Landroid/content/Context;Landroid/content/Intent;JLjava/lang/String;)V

    goto/16 :goto_1
.end method

.method private static setLastRunTime(Landroid/content/Context;Ljava/lang/String;J)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "workIdentifier"    # Ljava/lang/String;
    .param p2, "timeMillis"    # J

    .prologue
    .line 523
    invoke-static {p0}, Lcom/amazon/android/service/SchedulePeriodicWork;->getSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 525
    .local v0, "prefs":Landroid/content/SharedPreferences$Editor;
    const-string/jumbo v1, ".lastRun"

    invoke-virtual {p1, v1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p2, p3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 527
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 529
    return-void
.end method

.method private static setPrefValues(Landroid/content/Context;Ljava/lang/String;JJJ)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "workIdentifier"    # Ljava/lang/String;
    .param p2, "timeMillis"    # J
    .param p4, "scheduledForTimeMillis"    # J
    .param p6, "periodMillis"    # J

    .prologue
    .line 561
    invoke-static {p0}, Lcom/amazon/android/service/SchedulePeriodicWork;->getSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v1

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 563
    .local v0, "prefs":Landroid/content/SharedPreferences$Editor;
    const-string/jumbo v1, ".scheduleTime"

    invoke-virtual {p1, v1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p2, p3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 564
    const-string/jumbo v1, ".scheduledFor"

    invoke-virtual {p1, v1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p4, p5}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 565
    const-string/jumbo v1, ".period"

    invoke-virtual {p1, v1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p6, p7}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 567
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 568
    return-void
.end method

.method private static setTimeout(Landroid/content/Context;Ljava/lang/String;J)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "workIdentifier"    # Ljava/lang/String;
    .param p2, "timeMillis"    # J

    .prologue
    .line 608
    invoke-static {p0}, Lcom/amazon/android/service/SchedulePeriodicWork;->getSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string/jumbo v1, ".timeout"

    invoke-virtual {p1, v1}, Ljava/lang/String;->concat(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p2, p3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 610
    return-void
.end method

.method public static workComplete(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "serviceIntent"    # Landroid/content/Intent;

    .prologue
    .line 427
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-static {p0, p1, v0, v1}, Lcom/amazon/android/service/SchedulePeriodicWork;->workComplete(Landroid/content/Context;Landroid/content/Intent;J)V

    .line 428
    return-void
.end method

.method public static workComplete(Landroid/content/Context;Landroid/content/Intent;J)V
    .locals 10
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "serviceIntent"    # Landroid/content/Intent;
    .param p2, "timeMillis"    # J

    .prologue
    .line 347
    invoke-static {p1}, Lcom/amazon/android/service/SchedulePeriodicWork;->getWorkIdentifier(Landroid/content/Intent;)Ljava/lang/String;

    move-result-object v6

    .line 349
    .local v6, "workIdentifier":Ljava/lang/String;
    invoke-static {p0, v6}, Lcom/amazon/android/service/SchedulePeriodicWork;->getLastRunTime(Landroid/content/Context;Ljava/lang/String;)J

    move-result-wide v0

    .line 350
    .local v0, "lastRunTime":J
    invoke-static {p0, v6}, Lcom/amazon/android/service/SchedulePeriodicWork;->getScheduleTime(Landroid/content/Context;Ljava/lang/String;)J

    move-result-wide v4

    .line 351
    .local v4, "scheduleTime":J
    invoke-static {p0, v6}, Lcom/amazon/android/service/SchedulePeriodicWork;->getPeriod(Landroid/content/Context;Ljava/lang/String;)J

    move-result-wide v2

    .line 353
    .local v2, "periodMillis":J
    cmp-long v7, v0, v4

    if-gez v7, :cond_0

    .line 354
    sget-object v7, Lcom/amazon/android/service/SchedulePeriodicWork;->LOG:Lcom/amazon/logging/Logger;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, " work complete, scheduling next alarm (SCHEDULER)"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/amazon/logging/Logger;->d(Ljava/lang/String;)V

    .line 355
    invoke-static {p0, p1, v2, v3, v6}, Lcom/amazon/android/service/SchedulePeriodicWork;->scheduleToWindow(Landroid/content/Context;Landroid/content/Intent;JLjava/lang/String;)V

    .line 361
    :goto_0
    invoke-static {p0, v6, p2, p3}, Lcom/amazon/android/service/SchedulePeriodicWork;->setLastRunTime(Landroid/content/Context;Ljava/lang/String;J)V

    .line 362
    return-void

    .line 358
    :cond_0
    sget-object v7, Lcom/amazon/android/service/SchedulePeriodicWork;->LOG:Lcom/amazon/logging/Logger;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, " already scheduled for repeating alarm, doing nothing. (SCHEDULER)"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/amazon/logging/Logger;->d(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static workFailed(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 13
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "serviceIntent"    # Landroid/content/Intent;

    .prologue
    const-wide/16 v11, 0x0

    .line 438
    invoke-static {p1}, Lcom/amazon/android/service/SchedulePeriodicWork;->getWorkIdentifier(Landroid/content/Intent;)Ljava/lang/String;

    move-result-object v10

    .line 440
    .local v10, "workIdentifier":Ljava/lang/String;
    invoke-static {p0, v10}, Lcom/amazon/android/service/SchedulePeriodicWork;->getScheduleTime(Landroid/content/Context;Ljava/lang/String;)J

    move-result-wide v8

    .line 441
    .local v8, "scheduleTime":J
    invoke-static {p0, v10}, Lcom/amazon/android/service/SchedulePeriodicWork;->getPeriod(Landroid/content/Context;Ljava/lang/String;)J

    move-result-wide v2

    .line 442
    .local v2, "periodMillis":J
    invoke-static {p0, v10}, Lcom/amazon/android/service/SchedulePeriodicWork;->getLastRunTime(Landroid/content/Context;Ljava/lang/String;)J

    move-result-wide v6

    .line 444
    .local v6, "lastRun":J
    cmp-long v0, v8, v11

    if-ltz v0, :cond_0

    cmp-long v0, v2, v11

    if-gez v0, :cond_1

    .line 445
    :cond_0
    sget-object v0, Lcom/amazon/android/service/SchedulePeriodicWork;->LOG:Lcom/amazon/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v11, " encountered workFailed() concurrent with clear data, ignoring (SCHEDULER)"

    invoke-virtual {v1, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/logging/Logger;->i(Ljava/lang/String;)V

    .line 469
    :goto_0
    return-void

    .line 449
    :cond_1
    cmp-long v0, v6, v11

    if-gez v0, :cond_2

    .line 450
    sget-object v0, Lcom/amazon/android/service/SchedulePeriodicWork;->LOG:Lcom/amazon/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v11, " workFailed() but will retry on next run of Appstore, ignoring (SCHEDULER)"

    invoke-virtual {v1, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/logging/Logger;->w(Ljava/lang/String;)V

    goto :goto_0

    .line 454
    :cond_2
    cmp-long v0, v6, v8

    if-lez v0, :cond_3

    .line 455
    sget-object v0, Lcom/amazon/android/service/SchedulePeriodicWork;->LOG:Lcom/amazon/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v11, " encountered workFailed() concurrent with workComplete(), ignoring (SCHEDULER)"

    invoke-virtual {v1, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/logging/Logger;->w(Ljava/lang/String;)V

    goto :goto_0

    .line 459
    :cond_3
    invoke-static {v2, v3}, Lcom/amazon/android/service/SchedulePeriodicWork;->getSuitableRetryDelayMillis(J)J

    move-result-wide v4

    .line 460
    .local v4, "retryDelayMillis":J
    cmp-long v0, v4, v11

    if-gez v0, :cond_4

    .line 461
    sget-object v0, Lcom/amazon/android/service/SchedulePeriodicWork;->LOG:Lcom/amazon/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v11, " workFailed() and retry is not applicable, using normal windowing (SCHEDULER)"

    invoke-virtual {v1, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/logging/Logger;->w(Ljava/lang/String;)V

    .line 462
    invoke-static {p0, p1, v2, v3, v10}, Lcom/amazon/android/service/SchedulePeriodicWork;->scheduleToWindow(Landroid/content/Context;Landroid/content/Intent;JLjava/lang/String;)V

    goto :goto_0

    .line 466
    :cond_4
    sget-object v0, Lcom/amazon/android/service/SchedulePeriodicWork;->LOG:Lcom/amazon/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v11, " retry is being scheduled for "

    invoke-virtual {v1, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-wide/16 v11, 0x3e8

    div-long v11, v4, v11

    invoke-virtual {v1, v11, v12}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v11, " seconds from now, skipping windowing logic. (SCHEDULER)"

    invoke-virtual {v1, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/logging/Logger;->v(Ljava/lang/String;)V

    move-object v0, p0

    move-object v1, p1

    .line 468
    invoke-static/range {v0 .. v5}, Lcom/amazon/android/service/SchedulePeriodicWork;->forceRescheduleWork(Landroid/content/Context;Landroid/content/Intent;JJ)V

    goto/16 :goto_0
.end method
