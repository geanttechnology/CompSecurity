.class public Lcom/exacttarget/etpushsdk/ETAnalytics;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/exacttarget/etpushsdk/event/AnalyticItemEventListener;
.implements Lcom/exacttarget/etpushsdk/event/BackgroundEventListener;


# static fields
.field private static a:Lcom/exacttarget/etpushsdk/ETAnalytics;


# instance fields
.field private b:Landroid/content/Context;


# direct methods
.method private constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 88
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 89
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/ETAnalytics;->b:Landroid/content/Context;

    .line 91
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/exacttarget/etpushsdk/util/EventBus;->register(Ljava/lang/Object;)V

    .line 92
    return-void
.end method

.method public static a()Lcom/exacttarget/etpushsdk/ETAnalytics;
    .locals 2

    .prologue
    .line 100
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->f()Z

    move-result v0

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->g()Z

    move-result v1

    or-int/2addr v0, v1

    if-eqz v0, :cond_1

    .line 101
    sget-object v0, Lcom/exacttarget/etpushsdk/ETAnalytics;->a:Lcom/exacttarget/etpushsdk/ETAnalytics;

    if-nez v0, :cond_0

    .line 102
    new-instance v0, Lcom/exacttarget/etpushsdk/ETException;

    const-string v1, "You forgot to call readyAimFire first."

    invoke-direct {v0, v1}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 105
    :cond_0
    sget-object v0, Lcom/exacttarget/etpushsdk/ETAnalytics;->a:Lcom/exacttarget/etpushsdk/ETAnalytics;

    return-object v0

    .line 107
    :cond_1
    new-instance v0, Lcom/exacttarget/etpushsdk/ETException;

    const-string v1, "Analytics are disabled."

    invoke-direct {v0, v1}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method protected static a(Landroid/content/Context;)V
    .locals 2

    .prologue
    .line 117
    sget-object v0, Lcom/exacttarget/etpushsdk/ETAnalytics;->a:Lcom/exacttarget/etpushsdk/ETAnalytics;

    if-nez v0, :cond_0

    .line 118
    const-string v0, "~!ETAnalytics"

    const-string v1, "readyAimFire()"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 119
    new-instance v0, Lcom/exacttarget/etpushsdk/ETAnalytics;

    invoke-direct {v0, p0}, Lcom/exacttarget/etpushsdk/ETAnalytics;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/exacttarget/etpushsdk/ETAnalytics;->a:Lcom/exacttarget/etpushsdk/ETAnalytics;

    .line 123
    return-void

    .line 121
    :cond_0
    new-instance v0, Lcom/exacttarget/etpushsdk/ETException;

    const-string v1, "You must have called readyAimFire more than once."

    invoke-direct {v0, v1}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private d()Z
    .locals 8

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 225
    :try_start_0
    const-string v2, "pi_app_key IS NULL AND analytic_types LIKE ? AND value IS NULL"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v5, "%4%"

    aput-object v5, v3, v4

    const/4 v4, 0x0

    const/4 v5, 0x0

    const-string v6, "id ASC "

    invoke-static {v2, v3, v4, v5, v6}, Lcom/exacttarget/etpushsdk/database/a;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    .line 234
    const-string v4, "~!ETAnalytics"

    const-string v5, "isCountingTimeInApp: %1$s"

    const/4 v2, 0x1

    new-array v6, v2, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    move v2, v0

    :goto_0
    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    aput-object v2, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v4, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 236
    invoke-interface {v3}, Ljava/util/List;->size()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    if-lez v2, :cond_1

    .line 241
    :goto_1
    return v0

    :cond_0
    move v2, v1

    .line 234
    goto :goto_0

    :cond_1
    move v0, v1

    .line 236
    goto :goto_1

    .line 237
    :catch_0
    move-exception v0

    .line 238
    const-string v2, "~!ETAnalytics"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    move v0, v1

    .line 241
    goto :goto_1
.end method


# virtual methods
.method protected a(J)V
    .locals 9

    .prologue
    .line 180
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    sub-long v2, v0, p1

    .line 182
    :try_start_0
    const-string v0, "pi_app_key IS NULL AND analytic_types LIKE ? AND value IS NULL"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v5, "%4%"

    aput-object v5, v1, v4

    const/4 v4, 0x0

    const/4 v5, 0x0

    const-string v6, "id ASC "

    invoke-static {v0, v1, v4, v5, v6}, Lcom/exacttarget/etpushsdk/database/a;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 191
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;

    .line 194
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getEventDate()Ljava/util/Date;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/Date;->getTime()J

    move-result-wide v4

    sub-long v4, v2, v4

    const-wide/16 v6, 0x3e8

    div-long/2addr v4, v6

    long-to-int v4, v4

    .line 195
    const-string v5, "~!ETAnalytics"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "ET Time in app was "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " seconds"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 196
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setValue(Ljava/lang/Integer;)V

    .line 197
    sget-object v4, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v0, v4}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setReadyToSend(Ljava/lang/Boolean;)V

    .line 198
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/a;->b(Lcom/exacttarget/etpushsdk/data/AnalyticItem;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 218
    :catch_0
    move-exception v0

    .line 219
    const-string v1, "~!ETAnalytics"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 221
    :cond_0
    return-void

    .line 201
    :cond_1
    :try_start_1
    const-string v0, "pi_app_key IS NOT NULL AND analytic_types LIKE ? AND value IS NULL"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v5, "%5%"

    aput-object v5, v1, v4

    const/4 v4, 0x0

    const/4 v5, 0x0

    const-string v6, "id ASC "

    invoke-static {v0, v1, v4, v5, v6}, Lcom/exacttarget/etpushsdk/database/a;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 210
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;

    .line 211
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getEventDate()Ljava/util/Date;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/Date;->getTime()J

    move-result-wide v4

    sub-long v4, v2, v4

    const-wide/16 v6, 0x3e8

    div-long/2addr v4, v6

    long-to-int v4, v4

    .line 212
    const-string v5, "~!ETAnalytics"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "PI Time in app was "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " seconds"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 213
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setValue(Ljava/lang/Integer;)V

    .line 214
    sget-object v4, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v0, v4}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setReadyToSend(Ljava/lang/Boolean;)V

    .line 215
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/a;->b(Lcom/exacttarget/etpushsdk/data/AnalyticItem;)I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1
.end method

.method protected a(Ljava/lang/String;)V
    .locals 8

    .prologue
    .line 387
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 389
    :try_start_0
    const-string v0, "object_ids LIKE ? AND value IS NULL"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v4, 0x0

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "%"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "%"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v1, v4

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-static {v0, v1, v4, v5, v6}, Lcom/exacttarget/etpushsdk/database/a;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 397
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_0

    .line 398
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;

    .line 399
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getEventDate()Ljava/util/Date;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/Date;->getTime()J

    move-result-wide v4

    sub-long v4, v2, v4

    const-wide/16 v6, 0x3e8

    div-long/2addr v4, v6

    long-to-int v4, v4

    .line 400
    const-string v5, "~!ETAnalytics"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Time in region: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " was "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " seconds"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 401
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setValue(Ljava/lang/Integer;)V

    .line 402
    sget-object v4, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v0, v4}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setReadyToSend(Ljava/lang/Boolean;)V

    .line 403
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/a;->b(Lcom/exacttarget/etpushsdk/data/AnalyticItem;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 406
    :catch_0
    move-exception v0

    .line 407
    const-string v1, "~!ETAnalytics"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 409
    :cond_0
    return-void
.end method

.method protected a(Ljava/lang/String;IILjava/util/List;)V
    .locals 3

    .prologue
    .line 346
    :try_start_0
    new-instance v1, Lcom/exacttarget/etpushsdk/data/AnalyticItem;

    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETAnalytics;->b:Landroid/content/Context;

    invoke-direct {v1, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;-><init>(Landroid/content/Context;)V

    .line 347
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    invoke-virtual {v1, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setEventDate(Ljava/util/Date;)V

    .line 348
    const/4 v0, 0x1

    if-ne p2, v0, :cond_0

    .line 349
    const/4 v0, 0x6

    invoke-virtual {v1, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->a(I)V

    .line 350
    invoke-virtual {v1, p1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->a(Ljava/lang/String;)V

    .line 359
    :goto_0
    const/4 v0, 0x3

    invoke-virtual {v1, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->a(I)V

    .line 360
    invoke-interface {p4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 361
    invoke-virtual {v1, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->a(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 365
    :catch_0
    move-exception v0

    .line 366
    const-string v1, "~!ETAnalytics"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 368
    :goto_2
    return-void

    .line 351
    :cond_0
    const/4 v0, 0x2

    if-ne p2, v0, :cond_1

    .line 352
    const/4 v0, 0x7

    :try_start_1
    invoke-virtual {v1, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->a(I)V

    .line 353
    invoke-virtual {v1, p1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->a(Ljava/lang/String;)V

    goto :goto_0

    .line 355
    :cond_1
    const/16 v0, 0xc

    invoke-virtual {v1, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->a(I)V

    .line 356
    invoke-virtual {v1, p1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->a(Ljava/lang/String;)V

    goto :goto_0

    .line 363
    :cond_2
    sget-object v0, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v1, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setReadyToSend(Ljava/lang/Boolean;)V

    .line 364
    invoke-static {v1}, Lcom/exacttarget/etpushsdk/database/a;->a(Lcom/exacttarget/etpushsdk/data/AnalyticItem;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_2
.end method

.method protected a(Ljava/lang/String;Z)V
    .locals 3

    .prologue
    .line 372
    :try_start_0
    new-instance v0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETAnalytics;->b:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;-><init>(Landroid/content/Context;)V

    .line 373
    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setEventDate(Ljava/util/Date;)V

    .line 374
    if-nez p2, :cond_0

    .line 375
    const/16 v1, 0xb

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->a(I)V

    .line 379
    :goto_0
    invoke-virtual {v0, p1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->a(Ljava/lang/String;)V

    .line 380
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/a;->a(Lcom/exacttarget/etpushsdk/data/AnalyticItem;)V

    .line 384
    :goto_1
    return-void

    .line 377
    :cond_0
    const/16 v1, 0xd

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->a(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 381
    :catch_0
    move-exception v0

    .line 382
    const-string v1, "~!ETAnalytics"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1
.end method

.method protected b(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 470
    :try_start_0
    new-instance v0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETAnalytics;->b:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;-><init>(Landroid/content/Context;)V

    .line 471
    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setEventDate(Ljava/util/Date;)V

    .line 472
    const/16 v1, 0xa

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->a(I)V

    .line 473
    invoke-virtual {v0, p1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->a(Ljava/lang/String;)V

    .line 474
    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setReadyToSend(Ljava/lang/Boolean;)V

    .line 475
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/a;->a(Lcom/exacttarget/etpushsdk/data/AnalyticItem;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 479
    :goto_0
    return-void

    .line 476
    :catch_0
    move-exception v0

    .line 477
    const-string v1, "~!ETAnalytics"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method protected b()Z
    .locals 11

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 412
    .line 413
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 415
    :try_start_0
    const-string v4, "analytic_types LIKE ? AND ready_to_send = ? "

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "%"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const/16 v8, 0xb

    invoke-static {v8}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "%"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    const-string v7, "0"

    aput-object v7, v5, v6

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-static {v4, v5, v6, v7, v8}, Lcom/exacttarget/etpushsdk/database/a;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v4

    .line 423
    if-eqz v4, :cond_0

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v5

    if-lez v5, :cond_0

    .line 424
    const-string v5, "~!ETAnalytics"

    const-string v6, "There are %d geofences currently being tracked"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 426
    :try_start_1
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;

    .line 427
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getEventDate()Ljava/util/Date;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/Date;->getTime()J

    move-result-wide v6

    sub-long v6, v2, v6

    const-wide/16 v8, 0x3e8

    div-long/2addr v6, v8

    long-to-int v5, v6

    .line 428
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v0, v5}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setValue(Ljava/lang/Integer;)V

    .line 429
    sget-object v5, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v0, v5}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setReadyToSend(Ljava/lang/Boolean;)V

    .line 430
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/a;->b(Lcom/exacttarget/etpushsdk/data/AnalyticItem;)I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 433
    :catch_0
    move-exception v0

    move-object v10, v0

    move v0, v1

    move-object v1, v10

    .line 434
    :goto_1
    const-string v2, "~!ETAnalytics"

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3, v1}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 437
    :cond_0
    :goto_2
    return v0

    .line 433
    :catch_1
    move-exception v1

    goto :goto_1

    :cond_1
    move v0, v1

    goto :goto_2
.end method

.method protected c()Z
    .locals 11

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 441
    .line 442
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 444
    :try_start_0
    const-string v4, "analytic_types LIKE ? AND ready_to_send = ? "

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "%"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const/16 v8, 0xd

    invoke-static {v8}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "%"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    const-string v7, "0"

    aput-object v7, v5, v6

    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-static {v4, v5, v6, v7, v8}, Lcom/exacttarget/etpushsdk/database/a;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v4

    .line 452
    if-eqz v4, :cond_0

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v5

    if-lez v5, :cond_0

    .line 453
    const-string v5, "~!ETAnalytics"

    const-string v6, "There are %d beacons currently being tracked"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v9

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 455
    :try_start_1
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;

    .line 456
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getEventDate()Ljava/util/Date;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/Date;->getTime()J

    move-result-wide v6

    sub-long v6, v2, v6

    const-wide/16 v8, 0x3e8

    div-long/2addr v6, v8

    long-to-int v5, v6

    .line 457
    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v0, v5}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setValue(Ljava/lang/Integer;)V

    .line 458
    sget-object v5, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v0, v5}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setReadyToSend(Ljava/lang/Boolean;)V

    .line 459
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/a;->b(Lcom/exacttarget/etpushsdk/data/AnalyticItem;)I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 462
    :catch_0
    move-exception v0

    move-object v10, v0

    move v0, v1

    move-object v1, v10

    .line 463
    :goto_1
    const-string v2, "~!ETAnalytics"

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3, v1}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 465
    :cond_0
    :goto_2
    return v0

    .line 462
    :catch_1
    move-exception v1

    goto :goto_1

    :cond_1
    move v0, v1

    goto :goto_2
.end method

.method public onEvent(Lcom/exacttarget/etpushsdk/event/AnalyticItemEvent;)V
    .locals 5

    .prologue
    .line 132
    :try_start_0
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/AnalyticItemEvent;->getDatabaseIds()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/AnalyticItemEvent;->getDatabaseIds()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_1

    .line 133
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/AnalyticItemEvent;->getDatabaseIds()Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/a;->a(Ljava/util/List;)I

    move-result v0

    .line 134
    const-string v1, "~!ETAnalytics"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Error: analytic_item rows deleted = "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 152
    :cond_0
    :goto_0
    return-void

    .line 136
    :cond_1
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/AnalyticItemEvent;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;

    .line 137
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getId()Ljava/lang/Integer;

    move-result-object v2

    if-nez v2, :cond_2

    .line 138
    const-string v2, "~!ETAnalytics"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Error, AnalyticItem had no ID: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 149
    :catch_0
    move-exception v0

    .line 150
    const-string v1, "~!ETAnalytics"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 141
    :cond_2
    :try_start_1
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getId()Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-static {v2}, Lcom/exacttarget/etpushsdk/database/a;->a(I)I

    move-result v2

    .line 142
    const/4 v3, 0x1

    if-ne v2, v3, :cond_3

    .line 143
    const-string v2, "~!ETAnalytics"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "removed analytic_item types: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getAnalyticTypes()Ljava/util/List;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 145
    :cond_3
    const-string v0, "~!ETAnalytics"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Error: rowsUpdated = "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1
.end method

.method public onEvent(Lcom/exacttarget/etpushsdk/event/AnalyticPiItemEvent;)V
    .locals 4

    .prologue
    .line 162
    :try_start_0
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETAnalytics;->b:Landroid/content/Context;

    const-string v1, "et_user_id_cache"

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/AnalyticPiItemEvent;->getUserId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 163
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETAnalytics;->b:Landroid/content/Context;

    const-string v1, "et_session_id_cache"

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/AnalyticPiItemEvent;->getSessionId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 165
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/AnalyticPiItemEvent;->getDatabaseIds()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/AnalyticPiItemEvent;->getDatabaseIds()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 166
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/AnalyticPiItemEvent;->getDatabaseIds()Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/a;->a(Ljava/util/List;)I

    move-result v0

    .line 168
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/AnalyticPiItemEvent;->getDatabaseIds()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-ne v0, v1, :cond_1

    .line 169
    const-string v1, "~!ETAnalytics"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "pi_analytic_item rows deleted = "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 177
    :cond_0
    :goto_0
    return-void

    .line 171
    :cond_1
    const-string v1, "~!ETAnalytics"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Error: mis-match on pi_analytic_item rows deleted.  rows deleted:"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " expected: "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/AnalyticPiItemEvent;->getDatabaseIds()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 174
    :catch_0
    move-exception v0

    .line 175
    const-string v1, "~!ETAnalytics"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public onEvent(Lcom/exacttarget/etpushsdk/event/BackgroundEvent;)V
    .locals 10
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "CommitPrefEdits"
        }
    .end annotation

    .prologue
    const-wide/16 v6, -0x1

    const/4 v8, 0x0

    .line 246
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->f()Z

    move-result v0

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->g()Z

    move-result v1

    or-int/2addr v0, v1

    if-eqz v0, :cond_1

    .line 247
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/BackgroundEvent;->isInBackground()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 249
    const-string v0, "~!ETAnalytics"

    const-string v1, "App is now in background."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 252
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 253
    const-string v2, "~!ETAnalytics"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Save background time: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 254
    iget-object v2, p0, Lcom/exacttarget/etpushsdk/ETAnalytics;->b:Landroid/content/Context;

    const-string v3, "et_background_time_cache"

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-static {v2, v3, v0}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Long;)V

    .line 256
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/BackgroundEvent;->getTimeWentInBackground()J

    move-result-wide v0

    cmp-long v0, v0, v6

    if-eqz v0, :cond_2

    .line 257
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/BackgroundEvent;->getTimeWentInBackground()J

    move-result-wide v2

    sub-long/2addr v0, v2

    invoke-virtual {p0, v0, v1}, Lcom/exacttarget/etpushsdk/ETAnalytics;->a(J)V

    .line 263
    :goto_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->f()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 265
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETAnalytics;->b:Landroid/content/Context;

    const-class v2, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 266
    const-string v1, "et_send_type_extra"

    const-string v2, "et_send_type_analytic_events"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 267
    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETAnalytics;->b:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 270
    :cond_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->g()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 272
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETAnalytics;->b:Landroid/content/Context;

    const-class v2, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 273
    const-string v1, "et_send_type_extra"

    const-string v2, "pi_send_type_analytic_events"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 274
    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETAnalytics;->b:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 342
    :cond_1
    :goto_1
    return-void

    .line 259
    :cond_2
    const-wide/16 v0, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/exacttarget/etpushsdk/ETAnalytics;->a(J)V

    goto :goto_0

    .line 278
    :cond_3
    const-string v0, "~!ETAnalytics"

    const-string v1, "App is now in foreground."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 281
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETAnalytics;->b:Landroid/content/Context;

    const-string v1, "et_background_time_cache"

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    new-array v3, v8, [Ljava/lang/Object;

    invoke-static {v0, v1, v2, v3}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    .line 283
    cmp-long v2, v0, v6

    if-eqz v2, :cond_5

    .line 284
    const-string v2, "~!ETAnalytics"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Found background time.  Checking if app has been in background for over 30 minutes: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 286
    iget-object v2, p0, Lcom/exacttarget/etpushsdk/ETAnalytics;->b:Landroid/content/Context;

    const-string v3, "ETPush"

    invoke-virtual {v2, v3, v8}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v2

    .line 287
    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    .line 288
    const-string v3, "et_background_time_cache"

    invoke-static {v3}, Lcom/exacttarget/etpushsdk/util/d;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 290
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v3

    .line 291
    invoke-virtual {v3, v0, v1}, Ljava/util/Calendar;->setTimeInMillis(J)V

    .line 293
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v0

    .line 294
    const/16 v1, 0xc

    const/16 v4, -0x1e

    invoke-virtual {v0, v1, v4}, Ljava/util/Calendar;->add(II)V

    .line 296
    const-string v1, "~!ETAnalytics"

    const-string v4, "timeWentInBackground: %d and thirtyMinsAgo: %d"

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    invoke-virtual {v3}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v5, v8

    const/4 v6, 0x1

    invoke-virtual {v0}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v1, v4}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 298
    invoke-virtual {v3, v0}, Ljava/util/Calendar;->before(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 299
    const-string v0, "~!ETAnalytics"

    const-string v1, "App has been in background for more than 30 minutes, so reset PI session Id."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 301
    const-string v0, "et_session_id_cache"

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/d;->d(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v0}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 304
    :cond_4
    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 309
    :cond_5
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/ETAnalytics;->d()Z

    move-result v0

    if-nez v0, :cond_1

    .line 310
    const-string v0, "~!ETAnalytics"

    const-string v1, "Not counting time in App, so start a new counter."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 315
    :try_start_0
    new-instance v0, Ljava/util/Date;

    invoke-direct {v0}, Ljava/util/Date;-><init>()V

    .line 316
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->f()Z

    move-result v1

    if-eqz v1, :cond_6

    .line 318
    new-instance v1, Lcom/exacttarget/etpushsdk/data/AnalyticItem;

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/ETAnalytics;->b:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;-><init>(Landroid/content/Context;)V

    .line 319
    invoke-virtual {v1, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setEventDate(Ljava/util/Date;)V

    .line 320
    const/4 v2, 0x4

    invoke-virtual {v1, v2}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->a(I)V

    .line 321
    invoke-static {v1}, Lcom/exacttarget/etpushsdk/database/a;->a(Lcom/exacttarget/etpushsdk/data/AnalyticItem;)V

    .line 322
    const-string v2, "~!ETAnalytics"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Added new ET analytic item: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getId()Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 325
    :cond_6
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->g()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 327
    new-instance v1, Lcom/exacttarget/etpushsdk/data/AnalyticItem;

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/ETAnalytics;->b:Landroid/content/Context;

    invoke-direct {v1, v2}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;-><init>(Landroid/content/Context;)V

    .line 328
    invoke-virtual {v1, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setEventDate(Ljava/util/Date;)V

    .line 329
    const/4 v0, 0x5

    invoke-virtual {v1, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->a(I)V

    .line 331
    const-string v0, "849f26e2-2df6-11e4-ab12-14109fdc48df"

    invoke-virtual {v1, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setPiAppKey(Ljava/lang/String;)V

    .line 332
    invoke-static {v1}, Lcom/exacttarget/etpushsdk/database/a;->a(Lcom/exacttarget/etpushsdk/data/AnalyticItem;)V

    .line 333
    const-string v0, "~!ETAnalytics"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Added new PI analytic item: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getId()Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_1

    .line 336
    :catch_0
    move-exception v0

    .line 337
    const-string v1, "~!ETAnalytics"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto/16 :goto_1
.end method
