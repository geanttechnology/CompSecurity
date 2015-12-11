.class public final Lcom/exacttarget/etpushsdk/ETPushService;
.super Landroid/app/IntentService;
.source "SourceFile"


# static fields
.field private static final a:Ljava/lang/Long;

.field private static final b:Ljava/lang/Object;


# instance fields
.field private final c:Ljava/text/DecimalFormat;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 87
    const-wide/32 v0, 0x493e0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/ETPushService;->a:Ljava/lang/Long;

    .line 97
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/exacttarget/etpushsdk/ETPushService;->b:Ljava/lang/Object;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 113
    const-string v0, "~!ETPushService"

    invoke-direct {p0, v0}, Landroid/app/IntentService;-><init>(Ljava/lang/String;)V

    .line 110
    new-instance v0, Ljava/text/DecimalFormat;

    const-string v1, "#.######"

    invoke-direct {v0, v1}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushService;->c:Ljava/text/DecimalFormat;

    .line 114
    return-void
.end method

.method private a(Ljava/lang/String;)Ljava/lang/Class;
    .locals 6

    .prologue
    const/4 v3, 0x1

    const/4 v5, 0x0

    .line 909
    const-string v0, "~!ETPushService"

    const-string v1, "Build Factory From Response Type: %1$s"

    new-array v2, v3, [Ljava/lang/Object;

    aput-object p1, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 911
    :try_start_0
    invoke-static {p1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 916
    :goto_0
    return-object v0

    .line 914
    :catch_0
    move-exception v0

    .line 915
    const-string v1, "~!ETPushService"

    const-string v2, "Error building our EventFactory from HttpResponseType: %1$s"

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/ClassNotFoundException;->getMessage()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 916
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private a(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 6

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 885
    const-string v0, "~!ETPushService"

    const-string v1, "Build Event From Factory: %1$s"

    new-array v2, v4, [Ljava/lang/Object;

    invoke-virtual {p4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 887
    :try_start_0
    invoke-virtual {p4}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/event/IEventFactory;

    .line 888
    invoke-interface {v0, p3}, Lcom/exacttarget/etpushsdk/event/IEventFactory;->fromJson(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    .line 889
    if-nez v1, :cond_1

    .line 895
    if-eqz p2, :cond_0

    invoke-interface {p2}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 897
    invoke-interface {v0, v0, p2}, Lcom/exacttarget/etpushsdk/event/IEventFactory;->setDatabaseIds(Ljava/lang/Object;Ljava/util/List;)V

    .line 900
    :cond_0
    :goto_0
    invoke-direct {p0, p1, p2, v0}, Lcom/exacttarget/etpushsdk/ETPushService;->a(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 904
    :goto_1
    return-object v0

    .line 902
    :catch_0
    move-exception v0

    .line 903
    const-string v1, "~!ETPushService"

    const-string v2, "Error building our Event from EventFactory: %1$s"

    new-array v3, v4, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 904
    const/4 v0, 0x0

    goto :goto_1

    :cond_1
    move-object v0, v1

    goto :goto_0
.end method

.method private a()Ljava/lang/String;
    .locals 2

    .prologue
    .line 959
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "ETPushSDK/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/o;->a()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " (Android)"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private a(Landroid/content/Intent;)V
    .locals 8

    .prologue
    const/4 v7, 0x2

    const/4 v6, -0x1

    .line 338
    const-string v0, "~!ETPushService"

    const-string v1, "Open intent."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 339
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 340
    const-string v0, "et_push_open_intent"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/content/Intent;

    .line 342
    const-string v2, "et_auto_cancel"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    .line 343
    const-string v3, "~!ETPushService"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "AUTOCANCEL: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 344
    const-string v3, "et_notification_id_key"

    invoke-virtual {v1, v3, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v3

    .line 345
    const-string v1, "~!ETPushService"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "NOTIFICATION_ID: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v1, v4}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 346
    if-eqz v2, :cond_0

    if-le v3, v6, :cond_0

    .line 347
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "notification"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/app/NotificationManager;

    .line 348
    invoke-virtual {v1, v3}, Landroid/app/NotificationManager;->cancel(I)V

    .line 351
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    new-instance v2, Landroid/content/Intent;

    const-string v3, "android.intent.action.CLOSE_SYSTEM_DIALOGS"

    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 354
    :cond_0
    if-eqz v0, :cond_6

    .line 355
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 356
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 358
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->f()Z

    move-result v1

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->g()Z

    move-result v2

    or-int/2addr v1, v2

    if-eqz v1, :cond_3

    .line 359
    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "_m"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 360
    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "transitionType"

    invoke-virtual {v2, v3, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v2

    .line 361
    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    const-string v3, "regionId"

    invoke-virtual {v0, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 362
    if-eqz v1, :cond_3

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_3

    .line 365
    :try_start_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETAnalytics;->a()Lcom/exacttarget/etpushsdk/ETAnalytics;

    move-result-object v3

    const-wide/16 v4, 0x0

    invoke-virtual {v3, v4, v5}, Lcom/exacttarget/etpushsdk/ETAnalytics;->a(J)V

    .line 368
    new-instance v3, Lcom/exacttarget/etpushsdk/data/AnalyticItem;

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-direct {v3, v4}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;-><init>(Landroid/content/Context;)V

    .line 369
    new-instance v4, Ljava/util/Date;

    invoke-direct {v4}, Ljava/util/Date;-><init>()V

    invoke-virtual {v3, v4}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setEventDate(Ljava/util/Date;)V

    .line 370
    const/4 v4, 0x2

    invoke-virtual {v3, v4}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->a(I)V

    .line 371
    invoke-virtual {v3, v1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->a(Ljava/lang/String;)V

    .line 372
    if-eqz v0, :cond_1

    .line 374
    const/4 v1, 0x1

    if-ne v2, v1, :cond_4

    .line 375
    const/4 v1, 0x6

    invoke-virtual {v3, v1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->a(I)V

    .line 381
    :goto_0
    invoke-virtual {v3, v0}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->a(Ljava/lang/String;)V

    .line 384
    :cond_1
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->f()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 386
    new-instance v0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;

    invoke-direct {v0, v3}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;-><init>(Lcom/exacttarget/etpushsdk/data/AnalyticItem;)V

    .line 387
    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->a(I)V

    .line 388
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/a;->a(Lcom/exacttarget/etpushsdk/data/AnalyticItem;)V

    .line 391
    :cond_2
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->g()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 393
    new-instance v0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;

    invoke-direct {v0, v3}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;-><init>(Lcom/exacttarget/etpushsdk/data/AnalyticItem;)V

    .line 394
    const/4 v1, 0x5

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->a(I)V

    .line 395
    const-string v1, "849f26e2-2df6-11e4-ab12-14109fdc48df"

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setPiAppKey(Ljava/lang/String;)V

    .line 396
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/a;->a(Lcom/exacttarget/etpushsdk/data/AnalyticItem;)V

    .line 406
    :cond_3
    :goto_1
    return-void

    .line 376
    :cond_4
    if-ne v2, v7, :cond_5

    .line 377
    const/4 v1, 0x7

    invoke-virtual {v3, v1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->a(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 398
    :catch_0
    move-exception v0

    .line 399
    const-string v1, "~!ETPushService"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1

    .line 379
    :cond_5
    const/16 v1, 0xc

    :try_start_1
    invoke-virtual {v3, v1}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->a(I)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    .line 404
    :cond_6
    const-string v0, "~!ETPushService"

    const-string v1, "Received invalid Intent."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1
.end method

.method private a(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/Object;)V
    .locals 10

    .prologue
    const/4 v9, 0x1

    const/4 v3, 0x0

    .line 921
    const-string v2, "~!ETPushService"

    const-string v4, "Update Event with Received Database ID: %1$s or ID List with %2$s ID(s)"

    const/4 v1, 0x2

    new-array v5, v1, [Ljava/lang/Object;

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    if-lez v1, :cond_1

    const-string v1, "null"

    :goto_0
    aput-object v1, v5, v3

    if-nez p2, :cond_2

    const-string v1, "null"

    :goto_1
    aput-object v1, v5, v9

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 924
    const/4 v2, 0x0

    .line 926
    if-eqz p2, :cond_5

    :try_start_0
    invoke-interface {p2}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_5

    .line 927
    const-string v1, "~!ETPushService"

    const-string v4, "Adding %1$d ID(s) from database list"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v7

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v1, v4}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 928
    instance-of v1, p3, Ljava/util/ArrayList;

    if-eqz v1, :cond_3

    .line 929
    move-object v0, p3

    check-cast v0, Ljava/util/ArrayList;

    move-object v1, v0

    invoke-virtual {v1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_4

    move-object v4, v2

    move v2, v3

    .line 930
    :goto_2
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v1

    if-ge v2, v1, :cond_4

    .line 931
    move-object v0, p3

    check-cast v0, Ljava/util/ArrayList;

    move-object v1, v0

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    .line 932
    if-nez v4, :cond_0

    .line 933
    invoke-virtual {v1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    const-string v5, "setId"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Class;

    const/4 v7, 0x0

    const-class v8, Ljava/lang/Integer;

    aput-object v8, v6, v7

    invoke-virtual {v4, v5, v6}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v4

    .line 935
    :cond_0
    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-interface {p2, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-virtual {v4, v1, v5}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 936
    const-string v1, "~!ETPushService"

    const-string v5, "Added ID %s"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-interface {p2, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    invoke-static {v8}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v1, v5}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 930
    add-int/lit8 v1, v2, 0x1

    move v2, v1

    goto :goto_2

    .line 921
    :cond_1
    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_0

    :cond_2
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v1

    invoke-static {v1}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_1

    .line 940
    :cond_3
    :try_start_1
    const-string v1, "~!ETPushService"

    const-string v2, "Adding to single class"

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 942
    invoke-virtual {p3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    const-string v2, "setDatabaseIds"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Class;

    const/4 v5, 0x0

    const-class v6, Ljava/util/List;

    aput-object v6, v4, v5

    invoke-virtual {v1, v2, v4}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 943
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p2, v2, v4

    invoke-virtual {v1, p3, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    .line 956
    :cond_4
    :goto_3
    return-void

    .line 945
    :cond_5
    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    if-lez v1, :cond_6

    .line 946
    const-string v1, "~!ETPushService"

    const-string v2, "Adding ID %1$d"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    invoke-static {v2, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 947
    invoke-virtual {p3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    const-string v2, "setId"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Class;

    const/4 v5, 0x0

    const-class v6, Ljava/lang/Integer;

    aput-object v6, v4, v5

    invoke-virtual {v1, v2, v4}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v1

    .line 948
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v2, v4

    invoke-virtual {v1, p3, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_3

    .line 953
    :catch_0
    move-exception v1

    .line 954
    const-string v2, "~!ETPushService"

    const-string v4, "Error updating our Event with Received Database IDs: %1$s"

    new-array v5, v9, [Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v3

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3, v1}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_3

    .line 951
    :cond_6
    :try_start_2
    const-string v1, "~!ETPushService"

    const-string v2, "Nothing to do, no databaseIds sent"

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_3
.end method

.method private a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;)V
    .locals 10

    .prologue
    .line 775
    :try_start_0
    const-string v2, "~!ETPushService"

    const-string v3, "Sending data..."

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 778
    const-string v2, "\\{et_app_id\\}"

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->b()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p2, v2, v3}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 781
    new-instance v5, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v5}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>()V

    .line 784
    const/4 v2, -0x1

    invoke-virtual {p1}, Ljava/lang/String;->hashCode()I

    move-result v3

    sparse-switch v3, :sswitch_data_0

    :cond_0
    :goto_0
    packed-switch v2, :pswitch_data_0

    .line 801
    new-instance v2, Lcom/exacttarget/etpushsdk/ETException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Invalid Request Method: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", only GET, POST, PUT supported."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 879
    :catch_0
    move-exception v2

    .line 880
    const-string v3, "~!ETPushService"

    const-string v4, "Error sending data: %1$s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-virtual {v2}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4, v2}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 882
    :goto_1
    return-void

    .line 784
    :sswitch_0
    :try_start_1
    const-string v3, "GET"

    invoke-virtual {p1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    const/4 v2, 0x0

    goto :goto_0

    :sswitch_1
    const-string v3, "POST"

    invoke-virtual {p1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    const/4 v2, 0x1

    goto :goto_0

    :sswitch_2
    const-string v3, "PUT"

    invoke-virtual {p1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    const/4 v2, 0x2

    goto :goto_0

    .line 787
    :pswitch_0
    new-instance v3, Lorg/apache/http/client/methods/HttpGet;

    invoke-direct {v3, v4}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    .line 804
    :goto_2
    const-string v2, "Accept"

    const-string v6, "application/json"

    invoke-interface {v3, v2, v6}, Lorg/apache/http/client/methods/HttpUriRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 805
    const-string v2, "User-Agent"

    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->a()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v3, v2, v6}, Lorg/apache/http/client/methods/HttpUriRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 806
    const-string v2, "Authorization"

    const-string v6, "Bearer %1$s"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->c()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-interface {v3, v2, v6}, Lorg/apache/http/client/methods/HttpUriRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 808
    const-string v2, "~!ETPushService"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Request Url: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v4}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 809
    const-string v2, "~!ETPushService"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Request data: "

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-object/from16 v0, p6

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v4}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 811
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v6

    .line 812
    invoke-static {v5, v3}, Lp;->a(Lorg/apache/http/client/HttpClient;Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v3

    .line 813
    const-string v2, "~!ETPushService"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Request took: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v8

    sub-long v6, v8, v6

    invoke-virtual {v4, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "ms"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v4}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 814
    invoke-interface {v3}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v2

    invoke-interface {v2}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v4

    .line 816
    const/16 v2, 0xc8

    if-lt v4, v2, :cond_4

    const/16 v2, 0x12b

    if-gt v4, v2, :cond_4

    .line 817
    const-string v2, "~!ETPushService"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Success with StatusCode: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v2, v5}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 829
    :goto_3
    invoke-interface {v3}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v5

    .line 830
    const/4 v2, 0x0

    .line 831
    if-eqz v5, :cond_1

    .line 832
    invoke-static {v5}, Lorg/apache/http/util/EntityUtils;->toString(Lorg/apache/http/HttpEntity;)Ljava/lang/String;

    move-result-object v2

    .line 833
    const/16 v5, 0xc8

    if-lt v4, v5, :cond_7

    const/16 v5, 0x12b

    if-gt v4, v5, :cond_7

    .line 834
    const-string v5, "~!ETPushService"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Success Response: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 851
    :cond_1
    :goto_4
    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_9

    const/16 v5, 0xc8

    if-lt v4, v5, :cond_9

    const/16 v5, 0x12b

    if-gt v4, v5, :cond_9

    .line 852
    const-string v3, "~!ETPushService"

    const-string v4, "Creating Event: %1$s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object p3, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 853
    invoke-direct {p0, p3}, Lcom/exacttarget/etpushsdk/ETPushService;->a(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v3

    .line 854
    if-eqz v3, :cond_3

    .line 858
    invoke-direct {p0, p4, p5, v2, v3}, Lcom/exacttarget/etpushsdk/ETPushService;->a(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v3

    .line 859
    if-eqz v3, :cond_3

    .line 860
    instance-of v2, v3, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;

    if-eqz v2, :cond_2

    .line 865
    const-string v2, "~!ETPushService"

    const-string v4, "Saving a hash of our registration."

    invoke-static {v2, v4}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 866
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v4

    const-string v5, "previousRegistrationHash"

    move-object v0, v3

    check-cast v0, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;

    move-object v2, v0

    invoke-virtual {v2}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->toJson()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/exacttarget/etpushsdk/ETPushService;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v4, v5, v2}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 868
    :cond_2
    const-string v2, "~!ETPushService"

    const-string v4, "Posting %1$s to EventBus"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-virtual {v3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v4}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 869
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v2

    invoke-virtual {v2, v3}, Lcom/exacttarget/etpushsdk/util/EventBus;->a(Ljava/lang/Object;)V

    .line 877
    :cond_3
    :goto_5
    const-string v2, "~!ETPushService"

    const-string v3, "Sending data done."

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_1

    .line 791
    :pswitch_1
    new-instance v3, Lorg/apache/http/client/methods/HttpPost;

    invoke-direct {v3, v4}, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/lang/String;)V

    .line 792
    move-object v0, v3

    check-cast v0, Lorg/apache/http/client/methods/HttpPost;

    move-object v2, v0

    new-instance v6, Lorg/apache/http/entity/StringEntity;

    move-object/from16 v0, p6

    invoke-direct {v6, v0}, Lorg/apache/http/entity/StringEntity;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v6}, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V

    .line 793
    const-string v2, "Content-type"

    const-string v6, "application/json"

    invoke-interface {v3, v2, v6}, Lorg/apache/http/client/methods/HttpUriRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_2

    .line 796
    :pswitch_2
    new-instance v3, Lorg/apache/http/client/methods/HttpPut;

    invoke-direct {v3, v4}, Lorg/apache/http/client/methods/HttpPut;-><init>(Ljava/lang/String;)V

    .line 797
    move-object v0, v3

    check-cast v0, Lorg/apache/http/client/methods/HttpPut;

    move-object v2, v0

    new-instance v6, Lorg/apache/http/entity/StringEntity;

    move-object/from16 v0, p6

    invoke-direct {v6, v0}, Lorg/apache/http/entity/StringEntity;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v6}, Lorg/apache/http/client/methods/HttpPut;->setEntity(Lorg/apache/http/HttpEntity;)V

    .line 798
    const-string v2, "Content-type"

    const-string v6, "application/json"

    invoke-interface {v3, v2, v6}, Lorg/apache/http/client/methods/HttpUriRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_2

    .line 818
    :cond_4
    const/16 v2, 0x190

    if-lt v4, v2, :cond_6

    const/16 v2, 0x1f3

    if-gt v4, v2, :cond_6

    .line 819
    const-string v2, "~!ETPushService"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Warning with StatusCode: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v2, v5}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;)I

    .line 820
    const/16 v2, 0x192

    if-ne v4, v2, :cond_5

    .line 821
    const-string v2, "~!ETPushService"

    const-string v5, "You are attempting to use a feature that is not enabled in your account. If you believe this is incorrect, please contact Global Support."

    invoke-static {v2, v5}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_3

    .line 823
    :cond_5
    const-string v2, "~!ETPushService"

    const-string v5, "A client error occurred while communicating with ExactTarget. Please verify that you have everything configured correctly."

    invoke-static {v2, v5}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_3

    .line 826
    :cond_6
    const-string v2, "~!ETPushService"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Error with StatusCode: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v2, v5}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_3

    .line 835
    :cond_7
    const/16 v5, 0x190

    if-lt v4, v5, :cond_8

    const/16 v5, 0x1f3

    if-gt v4, v5, :cond_8

    .line 836
    const-string v5, "~!ETPushService"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Warning Response: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_4

    .line 838
    :cond_8
    const-string v5, "~!ETPushService"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Error Response: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 841
    const-class v5, Lcom/exacttarget/etpushsdk/event/GeofenceResponseEvent;

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p3, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 843
    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object p4

    goto/16 :goto_4

    .line 873
    :cond_9
    const-string v2, "~!ETPushService"

    const-string v5, "Posting an error event to EventBus.  Error was: %1$s"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-interface {v3}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v8

    invoke-interface {v8}, Lorg/apache/http/StatusLine;->getReasonPhrase()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v2, v5}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 874
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v2

    new-instance v5, Lcom/exacttarget/etpushsdk/event/ServerErrorEvent;

    invoke-interface {v3}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v3

    invoke-interface {v3}, Lorg/apache/http/StatusLine;->getReasonPhrase()Ljava/lang/String;

    move-result-object v3

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-direct {v5, v3, v4}, Lcom/exacttarget/etpushsdk/event/ServerErrorEvent;-><init>(Ljava/lang/String;Ljava/lang/Integer;)V

    invoke-virtual {v2, v5}, Lcom/exacttarget/etpushsdk/util/EventBus;->a(Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_5

    .line 784
    :sswitch_data_0
    .sparse-switch
        0x11336 -> :sswitch_0
        0x136ef -> :sswitch_2
        0x2590a0 -> :sswitch_1
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private a(Z)V
    .locals 4

    .prologue
    .line 990
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    .line 991
    new-instance v2, Landroid/content/ComponentName;

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-class v3, Lcom/exacttarget/etpushsdk/ETLocationReceiver;

    invoke-direct {v2, v0, v3}, Landroid/content/ComponentName;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 996
    if-eqz p1, :cond_0

    const/4 v0, 0x2

    :goto_0
    const/4 v3, 0x1

    invoke-virtual {v1, v2, v0, v3}, Landroid/content/pm/PackageManager;->setComponentEnabledSetting(Landroid/content/ComponentName;II)V

    .line 998
    return-void

    .line 996
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private b(Ljava/lang/String;)Ljava/lang/String;
    .locals 7

    .prologue
    const/4 v3, 0x1

    const/4 v0, 0x0

    .line 963
    const-string v1, "~!ETPushService"

    const-string v2, "createHash(final String string) // string = \'%s\'"

    new-array v3, v3, [Ljava/lang/Object;

    aput-object p1, v3, v0

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 964
    const-string v1, "MD5"

    .line 967
    :try_start_0
    const-string v1, "MD5"

    invoke-static {v1}, Ljava/security/MessageDigest;->getInstance(Ljava/lang/String;)Ljava/security/MessageDigest;

    move-result-object v1

    .line 968
    invoke-virtual {p1}, Ljava/lang/String;->getBytes()[B

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/security/MessageDigest;->update([B)V

    .line 969
    invoke-virtual {v1}, Ljava/security/MessageDigest;->digest()[B

    move-result-object v2

    .line 972
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 973
    array-length v4, v2

    move v1, v0

    :goto_0
    if-ge v1, v4, :cond_1

    aget-byte v0, v2, v1

    .line 974
    and-int/lit16 v0, v0, 0xff

    invoke-static {v0}, Ljava/lang/Integer;->toHexString(I)Ljava/lang/String;

    move-result-object v0

    .line 975
    :goto_1
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v5

    const/4 v6, 0x2

    if-ge v5, v6, :cond_0

    .line 976
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "0"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 977
    :cond_0
    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 973
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 979
    :cond_1
    const-string v0, "~!ETPushService"

    const-string v1, "return %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 980
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catch Ljava/security/NoSuchAlgorithmException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 985
    :goto_2
    return-object v0

    .line 982
    :catch_0
    move-exception v0

    .line 983
    invoke-virtual {v0}, Ljava/security/NoSuchAlgorithmException;->printStackTrace()V

    .line 985
    const-string v0, ""

    goto :goto_2
.end method

.method private b()V
    .locals 7

    .prologue
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 1001
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->h()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1002
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->isWatchingLocation()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->isWatchingProximity()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1003
    :cond_0
    const-string v0, "~!ETPushService"

    const-string v1, "Location on and watching location..."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1005
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v1, "et_key_run_once"

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    new-array v3, v5, [Ljava/lang/Object;

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v0, v1, v2, v3}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    .line 1007
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1008
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v1, "location"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    .line 1013
    new-instance v1, Lcom/exacttarget/etpushsdk/location/b;

    invoke-direct {v1, v0}, Lcom/exacttarget/etpushsdk/location/b;-><init>(Landroid/location/LocationManager;)V

    .line 1017
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v2, "et_key_follow_location_changes"

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    new-array v4, v5, [Ljava/lang/Object;

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v5

    invoke-static {v5}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v0, v2, v3, v4}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    .line 1022
    :try_start_0
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 1023
    const-string v3, "active"

    sget-object v4, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 1024
    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-static {v3, v4, v2}, Lcom/exacttarget/etpushsdk/database/g;->a(Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1029
    :goto_0
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1032
    new-instance v0, Landroid/content/Intent;

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v2

    const-class v3, Lcom/exacttarget/etpushsdk/ETLocationReceiver;

    invoke-direct {v0, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1033
    const-string v2, "et_location_action_passive_location_change"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 1034
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v2

    const/16 v3, 0x3eb

    const/high16 v4, 0x8000000

    invoke-static {v2, v3, v0, v4}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v6

    .line 1035
    const-wide/32 v2, 0x493e0

    const-wide/16 v4, 0x0

    invoke-virtual/range {v1 .. v6}, Lcom/exacttarget/etpushsdk/location/g;->a(JJLandroid/app/PendingIntent;)V

    .line 1039
    :cond_1
    :try_start_1
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->isWatchingLocation()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1040
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->f(Z)V

    .line 1041
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->a(Z)V

    .line 1043
    :cond_2
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->isWatchingProximity()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 1044
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->h(Z)V

    .line 1045
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->b(Z)Z
    :try_end_1
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_1 .. :try_end_1} :catch_1

    .line 1053
    :cond_3
    :goto_1
    return-void

    .line 1025
    :catch_0
    move-exception v2

    .line 1026
    const-string v3, "~!ETPushService"

    invoke-virtual {v2}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4, v2}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 1047
    :catch_1
    move-exception v0

    .line 1048
    const-string v1, "~!ETPushService"

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_1
.end method

.method private b(Landroid/content/Intent;)V
    .locals 5

    .prologue
    .line 409
    const-string v0, "~!ETPushService"

    const-string v1, "packageReplaced() started."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 410
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    .line 412
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "android.intent.extra.UID"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    .line 413
    invoke-static {}, Landroid/os/Process;->myUid()I

    move-result v2

    .line 414
    if-ne v1, v2, :cond_0

    .line 415
    const-string v1, "~!ETPushService"

    const-string v2, "Package replace started for %1$s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 416
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->getInstance()Lcom/exacttarget/etpushsdk/ETPush;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETPush;->i()V

    .line 420
    :goto_0
    const-string v0, "~!ETPushService"

    const-string v1, "packageReplaced() ended."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 421
    return-void

    .line 418
    :cond_0
    const-string v0, "~!ETPushService"

    const-string v1, "Some other application updated.  Nothing to see here."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method private c(Landroid/content/Intent;)V
    .locals 12

    .prologue
    const-wide/16 v10, -0x1

    const/4 v2, 0x0

    .line 424
    const-string v0, "~!ETPushService"

    const-string v1, "appShutdown() started."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 427
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->h()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 428
    const-string v0, "~!ETPushService"

    const-string v1, "Checking if we are currently tracking geoFence entry times."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 429
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETAnalytics;->a()Lcom/exacttarget/etpushsdk/ETAnalytics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETAnalytics;->b()Z

    move-result v0

    move v1, v0

    .line 433
    :goto_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->i()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 434
    const-string v0, "~!ETPushService"

    const-string v3, "Checking if we are currently tracking Beacon entry times."

    invoke-static {v0, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 435
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETAnalytics;->a()Lcom/exacttarget/etpushsdk/ETAnalytics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETAnalytics;->c()Z

    move-result v0

    move v3, v0

    .line 438
    :goto_1
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v4, "pause_time_key"

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    new-array v6, v2, [Ljava/lang/Object;

    invoke-static {v0, v4, v5, v6}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    .line 439
    const-string v0, "~!ETPushService"

    const-string v6, "Pause time: %d"

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    aput-object v8, v7, v2

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 441
    cmp-long v0, v4, v10

    if-eqz v0, :cond_1

    .line 445
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->d()V

    .line 449
    invoke-direct {p0, p1}, Lcom/exacttarget/etpushsdk/ETPushService;->d(Landroid/content/Intent;)V

    .line 463
    :cond_0
    :goto_2
    const-string v0, "~!ETPushService"

    const-string v1, "appShutdown() ended."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 464
    return-void

    .line 451
    :cond_1
    if-nez v1, :cond_2

    if-eqz v3, :cond_0

    .line 457
    :cond_2
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 458
    const-string v1, "et_send_type_extra"

    const-string v2, "et_send_type_analytic_events"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 459
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    goto :goto_2

    :cond_3
    move v3, v2

    goto :goto_1

    :cond_4
    move v1, v2

    goto :goto_0
.end method

.method private d(Landroid/content/Intent;)V
    .locals 7

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x1

    .line 467
    const-string v0, "~!ETPushService"

    const-string v1, "appInBackground() started."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 471
    :try_start_0
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "pause_time_key"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;)V

    .line 472
    const-string v0, "~!ETPushService"

    const-string v1, "%s removed"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    const-string v4, "pause_time_key"

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 474
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/i;->a()Lcom/exacttarget/etpushsdk/util/i;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/util/i;->c()V

    .line 475
    const-string v0, "~!ETPushService"

    const-string v1, "SQLite VACUUM complete"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 480
    :goto_0
    const-string v0, "time_went_in_background"

    const-wide/16 v2, -0x1

    invoke-virtual {p1, v0, v2, v3}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v0

    .line 482
    const-string v2, "~!ETPushService"

    const-string v3, "Notify that app has gone into background."

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 483
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v2

    new-instance v3, Lcom/exacttarget/etpushsdk/event/BackgroundEvent;

    invoke-direct {v3, v5, v0, v1}, Lcom/exacttarget/etpushsdk/event/BackgroundEvent;-><init>(ZJ)V

    invoke-virtual {v2, v3}, Lcom/exacttarget/etpushsdk/util/EventBus;->b(Ljava/lang/Object;)V

    .line 484
    const-string v0, "~!ETPushService"

    const-string v1, "appInBackground() ended."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 485
    return-void

    .line 476
    :catch_0
    move-exception v0

    .line 477
    const-string v1, "~!ETPushService"

    const-string v2, "SQLite VACUUM had an exception that we will ignore: %s"

    new-array v3, v5, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method private e(Landroid/content/Intent;)V
    .locals 18

    .prologue
    .line 488
    const-string v2, "et_send_type_extra"

    move-object/from16 v0, p1

    invoke-virtual {v0, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 489
    const-string v3, "~!ETPushService"

    const-string v4, "Sending data for: %s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v2, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 490
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v11

    .line 492
    const-string v3, "et_send_type_analytic_events"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    invoke-virtual/range {p0 .. p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;)Z

    move-result v3

    if-nez v3, :cond_3

    .line 494
    const-string v2, "pi_app_key IS NULL AND ready_to_send = ? "

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v5, "1"

    aput-object v5, v3, v4

    const/4 v4, 0x0

    const/4 v5, 0x0

    const-string v6, "id ASC "

    invoke-static {v2, v3, v4, v5, v6}, Lcom/exacttarget/etpushsdk/database/a;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    .line 502
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 503
    const-string v4, ""

    .line 504
    const-string v3, "["

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 505
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 506
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/exacttarget/etpushsdk/data/AnalyticItem;

    .line 507
    invoke-virtual {v2, v11}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setLastSent(Ljava/lang/Long;)V

    .line 508
    invoke-static {v2}, Lcom/exacttarget/etpushsdk/database/a;->b(Lcom/exacttarget/etpushsdk/data/AnalyticItem;)I

    .line 510
    invoke-virtual {v2}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getValue()Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Integer;->intValue()I

    move-result v7

    if-gtz v7, :cond_0

    .line 512
    invoke-virtual {v2}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getId()Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-static {v2}, Lcom/exacttarget/etpushsdk/database/a;->a(I)I

    move-object v2, v4

    :goto_1
    move-object v4, v2

    .line 518
    goto :goto_0

    .line 514
    :cond_0
    invoke-virtual {v2}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getId()Ljava/lang/Integer;

    move-result-object v7

    invoke-interface {v3, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 515
    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v2}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->a()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 516
    const-string v2, ","

    goto :goto_1

    .line 520
    :cond_1
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->length()I

    move-result v2

    if-lez v2, :cond_2

    .line 521
    const-string v2, "]"

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 523
    const-string v2, "~!ETPushService"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "AnalyticItems (JSON): "

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v4}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 525
    new-instance v4, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const-class v6, Lcom/exacttarget/etpushsdk/ETPushService;

    invoke-direct {v4, v2, v6}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 526
    const-string v6, "param_database_ids"

    move-object v2, v3

    check-cast v2, Ljava/io/Serializable;

    invoke-virtual {v4, v6, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 527
    const-string v2, "param_http_method"

    const-string v3, "POST"

    invoke-virtual {v4, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 528
    const-string v2, "param_http_url"

    const-string v3, "https://consumer.exacttargetapis.com/device/v1/event/analytic"

    invoke-virtual {v4, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 529
    const-string v2, "param_http_response_type"

    const-class v3, Lcom/exacttarget/etpushsdk/event/AnalyticItemEvent;

    invoke-virtual {v3}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 530
    const-string v2, "param_data_json"

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 531
    move-object/from16 v0, p0

    invoke-direct {v0, v4}, Lcom/exacttarget/etpushsdk/ETPushService;->f(Landroid/content/Intent;)V

    .line 752
    :cond_2
    :goto_2
    return-void

    .line 533
    :cond_3
    const-string v3, "pi_send_type_analytic_events"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_a

    invoke-virtual/range {p0 .. p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;)Z

    move-result v3

    if-nez v3, :cond_a

    .line 537
    :try_start_0
    const-string v2, "pi_app_key IS NOT NULL AND ready_to_send = ? "

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string v5, "1"

    aput-object v5, v3, v4

    const/4 v4, 0x0

    const/4 v5, 0x0

    const-string v6, "id ASC "

    invoke-static {v2, v3, v4, v5, v6}, Lcom/exacttarget/etpushsdk/database/a;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v4

    .line 546
    invoke-virtual/range {p0 .. p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const-string v3, "et_user_id_cache"

    const/4 v5, 0x0

    const/4 v6, 0x0

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {v2, v3, v5, v6}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 547
    invoke-virtual/range {p0 .. p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    const-string v5, "et_session_id_cache"

    const/4 v6, 0x0

    const/4 v7, 0x0

    new-array v7, v7, [Ljava/lang/Object;

    invoke-static {v3, v5, v6, v7}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 549
    const/4 v5, 0x0

    .line 551
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 552
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v12

    :goto_3
    invoke-interface {v12}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_9

    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    move-object v0, v4

    check-cast v0, Lcom/exacttarget/etpushsdk/data/AnalyticItem;

    move-object v6, v0

    .line 553
    invoke-virtual {v6, v11}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->setLastSent(Ljava/lang/Long;)V

    .line 554
    invoke-static {v6}, Lcom/exacttarget/etpushsdk/database/a;->b(Lcom/exacttarget/etpushsdk/data/AnalyticItem;)I

    .line 556
    invoke-virtual {v6}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getValue()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    if-gtz v4, :cond_5

    .line 558
    invoke-virtual {v6}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getId()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-static {v4}, Lcom/exacttarget/etpushsdk/database/a;->a(I)I

    move-object v4, v5

    :cond_4
    :goto_4
    move-object v5, v4

    .line 606
    goto :goto_3

    .line 561
    :cond_5
    invoke-virtual {v6}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getId()Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {v7, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 563
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v13

    .line 564
    invoke-virtual {v6}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getEventDate()Ljava/util/Date;

    move-result-object v4

    invoke-virtual {v13, v4}, Ljava/util/Calendar;->setTime(Ljava/util/Date;)V

    .line 566
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v14

    .line 567
    invoke-virtual {v13}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v8

    invoke-virtual {v14, v8, v9}, Ljava/util/Calendar;->setTimeInMillis(J)V

    .line 568
    const/16 v4, 0xd

    invoke-virtual {v6}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getValue()Ljava/lang/Integer;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Integer;->intValue()I

    move-result v8

    invoke-virtual {v14, v4, v8}, Ljava/util/Calendar;->add(II)V

    .line 570
    if-nez v5, :cond_16

    .line 571
    new-instance v8, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;

    invoke-virtual/range {p0 .. p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-direct {v8, v4}, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;-><init>(Landroid/content/Context;)V

    .line 573
    const-string v4, "849f26e2-2df6-11e4-ab12-14109fdc48df"

    invoke-virtual {v8, v4}, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->setApiKey(Ljava/lang/String;)V

    .line 574
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->b()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v8, v4}, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->setAppId(Ljava/lang/String;)V

    .line 575
    invoke-virtual {v8, v2}, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->setUserId(Ljava/lang/String;)V

    .line 576
    invoke-virtual {v8, v3}, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->setSessionId(Ljava/lang/String;)V

    .line 578
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->getInstance()Lcom/exacttarget/etpushsdk/ETPush;

    move-result-object v4

    invoke-virtual {v4}, Lcom/exacttarget/etpushsdk/ETPush;->isPushEnabled()Z

    move-result v4

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v8, v4}, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->setPushEnabled(Ljava/lang/Boolean;)V

    .line 579
    invoke-virtual/range {p0 .. p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    const-string v5, "et_manufacturer_cache"

    const/4 v9, 0x0

    const/4 v10, 0x0

    new-array v10, v10, [Ljava/lang/Object;

    invoke-static {v4, v5, v9, v10}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v8, v4}, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->setManufacturer(Ljava/lang/String;)V

    .line 580
    invoke-virtual/range {p0 .. p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    const-string v5, "et_platform_cache"

    const/4 v9, 0x0

    const/4 v10, 0x0

    new-array v10, v10, [Ljava/lang/Object;

    invoke-static {v4, v5, v9, v10}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v8, v4}, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->setPlatform(Ljava/lang/String;)V

    .line 581
    invoke-virtual/range {p0 .. p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    const-string v5, "et_platform_version_cache"

    const/4 v9, 0x0

    const/4 v10, 0x0

    new-array v10, v10, [Ljava/lang/Object;

    invoke-static {v4, v5, v9, v10}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v8, v4}, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->setPlatformVersion(Ljava/lang/String;)V

    .line 582
    invoke-virtual/range {p0 .. p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    const-string v5, "et_model_cache"

    const/4 v9, 0x0

    const/4 v10, 0x0

    new-array v10, v10, [Ljava/lang/Object;

    invoke-static {v4, v5, v9, v10}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v8, v4}, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->setDeviceType(Ljava/lang/String;)V

    .line 583
    invoke-virtual/range {p0 .. p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    const-string v5, "et_device_id_cache"

    const/4 v9, 0x0

    const/4 v10, 0x0

    new-array v10, v10, [Ljava/lang/Object;

    invoke-static {v4, v5, v9, v10}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    invoke-virtual {v8, v4}, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->setDeviceId(Ljava/lang/String;)Ljava/lang/String;

    .line 585
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->h()Z

    move-result v4

    if-eqz v4, :cond_6

    .line 586
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v4

    .line 587
    invoke-virtual {v4}, Lcom/exacttarget/etpushsdk/ETLocationManager;->isWatchingLocation()Z

    move-result v4

    if-eqz v4, :cond_6

    .line 588
    invoke-virtual/range {p0 .. p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    const-string v5, "et_last_location_latitude"

    const/4 v9, 0x0

    const/4 v10, 0x0

    new-array v10, v10, [Ljava/lang/Object;

    invoke-static {v4, v5, v9, v10}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 589
    invoke-virtual/range {p0 .. p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    const-string v9, "et_last_location_longitude"

    const/4 v10, 0x0

    const/4 v15, 0x0

    new-array v15, v15, [Ljava/lang/Object;

    invoke-static {v5, v9, v10, v15}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 590
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_7

    const/4 v9, 0x1

    move v10, v9

    :goto_5
    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_8

    const/4 v9, 0x1

    :goto_6
    and-int/2addr v9, v10

    if-eqz v9, :cond_6

    .line 591
    invoke-static {v4}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v16

    move-wide/from16 v0, v16

    invoke-virtual {v8, v0, v1}, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->setLatitude(D)V

    .line 592
    invoke-static {v5}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v4

    invoke-virtual {v8, v4, v5}, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->setLongitude(D)V

    :cond_6
    move-object v4, v8

    .line 598
    :goto_7
    invoke-virtual {v13}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v5

    invoke-virtual {v14}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v8

    invoke-virtual {v6}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getAnalyticTypes()Ljava/util/List;

    move-result-object v9

    const/4 v10, 0x2

    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v10

    invoke-interface {v9, v10}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v9

    invoke-virtual {v4, v5, v8, v9}, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->a(Ljava/util/Date;Ljava/util/Date;Z)V

    .line 600
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->getLogLevel()I

    move-result v5

    const/4 v8, 0x3

    if-gt v5, v8, :cond_4

    .line 601
    new-instance v5, Ljava/text/SimpleDateFormat;

    const-string v8, "yyyy-MM-dd\'T\'HH:mm:ss\'Z\'"

    sget-object v9, Ljava/util/Locale;->ENGLISH:Ljava/util/Locale;

    invoke-direct {v5, v8, v9}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 602
    const-string v8, "UTC"

    invoke-static {v8}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v8

    invoke-virtual {v5, v8}, Ljava/text/SimpleDateFormat;->setTimeZone(Ljava/util/TimeZone;)V

    .line 603
    const-string v8, "~!ETPushService"

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v10, "Time in app start time: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v13}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v10

    invoke-virtual {v5, v10}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, " end time: "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v14}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v10

    invoke-virtual {v5, v10}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v9, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v9, " from push: "

    invoke-virtual {v5, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v6}, Lcom/exacttarget/etpushsdk/data/AnalyticItem;->getAnalyticTypes()Ljava/util/List;

    move-result-object v6

    const/4 v9, 0x2

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-interface {v6, v9}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v8, v5}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_4

    .line 619
    :catch_0
    move-exception v2

    .line 620
    const-string v3, "~!ETPushService"

    invoke-virtual {v2}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4, v2}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto/16 :goto_2

    .line 590
    :cond_7
    const/4 v9, 0x0

    move v10, v9

    goto/16 :goto_5

    :cond_8
    const/4 v9, 0x0

    goto/16 :goto_6

    .line 608
    :cond_9
    if-eqz v5, :cond_2

    .line 609
    :try_start_1
    const-string v2, "~!ETPushService"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "PI Items:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v5}, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->a()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 611
    new-instance v3, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const-class v4, Lcom/exacttarget/etpushsdk/ETPushService;

    invoke-direct {v3, v2, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 612
    const-string v4, "param_database_ids"

    move-object v0, v7

    check-cast v0, Ljava/io/Serializable;

    move-object v2, v0

    invoke-virtual {v3, v4, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 613
    const-string v2, "param_http_method"

    const-string v4, "POST"

    invoke-virtual {v3, v2, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 614
    const-string v2, "param_http_url"

    const-string v4, "https://app.igodigital.com/api/v1/collect/process_batch"

    invoke-virtual {v3, v2, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 615
    const-string v2, "param_http_response_type"

    const-class v4, Lcom/exacttarget/etpushsdk/event/AnalyticPiItemEvent;

    invoke-virtual {v4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v2, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 616
    const-string v2, "param_data_json"

    invoke-virtual {v5}, Lcom/exacttarget/etpushsdk/data/AnalyticPiItem;->a()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v2, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 617
    move-object/from16 v0, p0

    invoke-direct {v0, v3}, Lcom/exacttarget/etpushsdk/ETPushService;->f(Landroid/content/Intent;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_2

    .line 622
    :cond_a
    const-string v3, "et_send_type_registration"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_d

    invoke-virtual/range {p0 .. p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;)Z

    move-result v3

    if-nez v3, :cond_d

    .line 624
    invoke-static {}, Lcom/exacttarget/etpushsdk/database/h;->a()Lcom/exacttarget/etpushsdk/data/Registration;

    move-result-object v3

    .line 625
    if-eqz v3, :cond_c

    .line 626
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v2

    const-string v4, "previousRegistrationHash"

    const/4 v5, 0x0

    const/4 v6, 0x0

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {v2, v4, v5, v6}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 627
    const-string v4, "~!ETPushService"

    const-string v5, "%s = %s"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    const-string v8, "previousRegistrationHash"

    aput-object v8, v6, v7

    const/4 v7, 0x1

    aput-object v2, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 628
    invoke-virtual {v3}, Lcom/exacttarget/etpushsdk/data/Registration;->toJson()Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, p0

    invoke-direct {v0, v4}, Lcom/exacttarget/etpushsdk/ETPushService;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 629
    if-eqz v2, :cond_b

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_b

    .line 633
    const-string v2, "~!ETPushService"

    const-string v3, "This registration contained no changes.  SKIP registration send."

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_2

    .line 636
    :cond_b
    invoke-virtual {v3, v11}, Lcom/exacttarget/etpushsdk/data/Registration;->setLastSent(Ljava/lang/Long;)V

    .line 637
    invoke-static {v3}, Lcom/exacttarget/etpushsdk/database/h;->b(Lcom/exacttarget/etpushsdk/data/Registration;)I

    .line 639
    new-instance v2, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    const-class v5, Lcom/exacttarget/etpushsdk/ETPushService;

    invoke-direct {v2, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 640
    const-string v4, "param_database_id"

    invoke-virtual {v3}, Lcom/exacttarget/etpushsdk/data/Registration;->getId()Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 641
    const-string v4, "~!ETPushService"

    const-string v5, "Registration (JSON): %1$s"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-virtual {v3}, Lcom/exacttarget/etpushsdk/data/Registration;->toJson()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 642
    const-string v4, "~!ETPushService"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "REGISTRATION ID: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v3}, Lcom/exacttarget/etpushsdk/data/Registration;->getId()Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 643
    const-string v4, "param_http_method"

    const-string v5, "POST"

    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 644
    const-string v4, "param_http_url"

    const-string v5, "https://consumer.exacttargetapis.com/device/v1/registration"

    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 645
    const-string v4, "param_http_response_type"

    const-class v5, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 646
    const-string v4, "param_data_json"

    invoke-virtual {v3}, Lcom/exacttarget/etpushsdk/data/Registration;->toJson()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v4, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 647
    move-object/from16 v0, p0

    invoke-direct {v0, v2}, Lcom/exacttarget/etpushsdk/ETPushService;->f(Landroid/content/Intent;)V

    goto/16 :goto_2

    .line 649
    :cond_c
    const-string v2, "~!ETPushService"

    const-string v3, "Nothing to send.  SKIP registration send."

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_2

    .line 652
    :cond_d
    const-string v3, "et_send_type_location"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_e

    invoke-virtual/range {p0 .. p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;)Z

    move-result v3

    if-nez v3, :cond_e

    .line 653
    const-string v2, "last_sent < ?"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/String;

    const/4 v4, 0x0

    invoke-virtual {v11}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    sget-object v5, Lcom/exacttarget/etpushsdk/ETPushService;->a:Ljava/lang/Long;

    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    sub-long/2addr v6, v8

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x0

    const/4 v5, 0x0

    const-string v6, "id ASC "

    invoke-static {v2, v3, v4, v5, v6}, Lcom/exacttarget/etpushsdk/database/d;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    .line 661
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_8
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/exacttarget/etpushsdk/data/LocationUpdate;

    .line 662
    invoke-virtual {v2, v11}, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->setLastSent(Ljava/lang/Long;)V

    .line 663
    invoke-static {v2}, Lcom/exacttarget/etpushsdk/database/d;->b(Lcom/exacttarget/etpushsdk/data/LocationUpdate;)I

    .line 665
    const-string v4, "~!ETPushService"

    const-string v5, "LocationUpdate (JSON): %1$s"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-virtual {v2}, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->toJson()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 666
    const-string v4, "~!ETPushService"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Send Location Update for: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v2}, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->getId()Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 667
    new-instance v4, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    const-class v6, Lcom/exacttarget/etpushsdk/ETPushService;

    invoke-direct {v4, v5, v6}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 668
    const-string v5, "param_database_id"

    invoke-virtual {v2}, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->getId()Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 669
    const-string v5, "param_http_method"

    const-string v6, "POST"

    invoke-virtual {v4, v5, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 670
    const-string v5, "param_http_url"

    const-string v6, "https://consumer.exacttargetapis.com/device/v1/location/{et_app_id}"

    invoke-virtual {v4, v5, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 671
    const-string v5, "param_http_response_type"

    const-class v6, Lcom/exacttarget/etpushsdk/event/LocationUpdateEvent;

    invoke-virtual {v6}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 672
    const-string v5, "param_data_json"

    invoke-virtual {v2}, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->toJson()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v4, v5, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 673
    move-object/from16 v0, p0

    invoke-direct {v0, v4}, Lcom/exacttarget/etpushsdk/ETPushService;->f(Landroid/content/Intent;)V

    goto :goto_8

    .line 675
    :cond_e
    const-string v3, "et_send_type_geofence"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_10

    .line 676
    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-static {v2, v3, v4, v5, v6}, Lcom/exacttarget/etpushsdk/database/c;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    .line 683
    if-eqz v3, :cond_2

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_2

    .line 684
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-interface {v3, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/exacttarget/etpushsdk/event/GeofenceRequest;

    .line 685
    invoke-static {v3}, Lcom/exacttarget/etpushsdk/database/c;->a(Ljava/util/List;)I

    .line 687
    const-string v3, "https://consumer.exacttargetapis.com/device/v1/location/{et_app_id}/fence/?latitude={latitude}&longitude={longitude}&deviceid={device_id}"

    const-string v4, "\\{device_id\\}"

    invoke-virtual {v2}, Lcom/exacttarget/etpushsdk/event/GeofenceRequest;->getDeviceId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "\\{latitude\\}"

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/exacttarget/etpushsdk/ETPushService;->c:Ljava/text/DecimalFormat;

    invoke-virtual {v2}, Lcom/exacttarget/etpushsdk/event/GeofenceRequest;->getLatitude()Ljava/lang/Double;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/text/DecimalFormat;->format(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "\\{longitude\\}"

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/exacttarget/etpushsdk/ETPushService;->c:Ljava/text/DecimalFormat;

    invoke-virtual {v2}, Lcom/exacttarget/etpushsdk/event/GeofenceRequest;->getLongitude()Ljava/lang/Double;

    move-result-object v2

    invoke-virtual {v5, v2}, Ljava/text/DecimalFormat;->format(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v4, v2}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 691
    invoke-virtual/range {p0 .. p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;)Z

    move-result v3

    if-eqz v3, :cond_f

    .line 692
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "&all=true"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 694
    :cond_f
    new-instance v3, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    const-class v5, Lcom/exacttarget/etpushsdk/ETPushService;

    invoke-direct {v3, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 695
    const-string v4, "param_http_method"

    const-string v5, "GET"

    invoke-virtual {v3, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 696
    const-string v4, "param_http_url"

    invoke-virtual {v3, v4, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 697
    const-string v2, "param_http_response_type"

    const-class v4, Lcom/exacttarget/etpushsdk/event/GeofenceResponseEvent;

    invoke-virtual {v4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v2, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 698
    move-object/from16 v0, p0

    invoke-direct {v0, v3}, Lcom/exacttarget/etpushsdk/ETPushService;->f(Landroid/content/Intent;)V

    goto/16 :goto_2

    .line 700
    :cond_10
    const-string v3, "et_send_type_proximity"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_12

    .line 701
    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-static {v2, v3, v4, v5, v6}, Lcom/exacttarget/etpushsdk/database/b;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    .line 708
    if-eqz v3, :cond_2

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_2

    .line 709
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    invoke-interface {v3, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/exacttarget/etpushsdk/event/BeaconRequest;

    .line 710
    invoke-static {v3}, Lcom/exacttarget/etpushsdk/database/b;->a(Ljava/util/List;)I

    .line 712
    const-string v3, "https://consumer.exacttargetapis.com/device/v1/location/{et_app_id}/proximity/?latitude={latitude}&longitude={longitude}&deviceid={device_id}"

    const-string v4, "\\{device_id\\}"

    invoke-virtual {v2}, Lcom/exacttarget/etpushsdk/event/BeaconRequest;->getDeviceId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "\\{latitude\\}"

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/exacttarget/etpushsdk/ETPushService;->c:Ljava/text/DecimalFormat;

    invoke-virtual {v2}, Lcom/exacttarget/etpushsdk/event/BeaconRequest;->getLatitude()Ljava/lang/Double;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/text/DecimalFormat;->format(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const-string v4, "\\{longitude\\}"

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/exacttarget/etpushsdk/ETPushService;->c:Ljava/text/DecimalFormat;

    invoke-virtual {v2}, Lcom/exacttarget/etpushsdk/event/BeaconRequest;->getLongitude()Ljava/lang/Double;

    move-result-object v2

    invoke-virtual {v5, v2}, Ljava/text/DecimalFormat;->format(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v4, v2}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 716
    invoke-virtual/range {p0 .. p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;)Z

    move-result v3

    if-eqz v3, :cond_11

    .line 717
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "&all=true"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 719
    :cond_11
    new-instance v3, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    const-class v5, Lcom/exacttarget/etpushsdk/ETPushService;

    invoke-direct {v3, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 720
    const-string v4, "param_http_method"

    const-string v5, "GET"

    invoke-virtual {v3, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 721
    const-string v4, "param_http_url"

    invoke-virtual {v3, v4, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 722
    const-string v2, "param_http_response_type"

    const-class v4, Lcom/exacttarget/etpushsdk/event/BeaconResponseEvent;

    invoke-virtual {v4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v2, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 723
    move-object/from16 v0, p0

    invoke-direct {v0, v3}, Lcom/exacttarget/etpushsdk/ETPushService;->f(Landroid/content/Intent;)V

    goto/16 :goto_2

    .line 725
    :cond_12
    const-string v3, "et_send_type_cloudpage"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_13

    .line 726
    const-string v2, "https://consumer.exacttargetapis.com/device/v1/{et_app_id}/message/?deviceid={device_id}&messagetype={messagetype}&contenttype={contenttype}"

    const-string v3, "\\{device_id\\}"

    invoke-virtual/range {p0 .. p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {v4}, Lcom/exacttarget/etpushsdk/util/g;->uniqueDeviceIdentifier(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "\\{messagetype\\}"

    sget-object v4, Lcom/exacttarget/etpushsdk/data/Message;->b:Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "\\{contenttype\\}"

    sget-object v4, Lcom/exacttarget/etpushsdk/data/Message;->i:Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 731
    new-instance v3, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    const-class v5, Lcom/exacttarget/etpushsdk/ETPushService;

    invoke-direct {v3, v4, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 732
    const-string v4, "param_http_method"

    const-string v5, "GET"

    invoke-virtual {v3, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 733
    const-string v4, "param_http_url"

    invoke-virtual {v3, v4, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 734
    const-string v2, "param_http_response_type"

    const-class v4, Lcom/exacttarget/etpushsdk/event/CloudPagesResponse;

    invoke-virtual {v4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v2, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 735
    move-object/from16 v0, p0

    invoke-direct {v0, v3}, Lcom/exacttarget/etpushsdk/ETPushService;->f(Landroid/content/Intent;)V

    goto/16 :goto_2

    .line 736
    :cond_13
    const-string v3, "et_send_type_custom_app_request"

    invoke-virtual {v3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_15

    .line 738
    new-instance v2, Landroid/content/Intent;

    invoke-virtual/range {p0 .. p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    const-class v4, Lcom/exacttarget/etpushsdk/ETPushService;

    invoke-direct {v2, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 739
    const-string v3, "param_http_method"

    const-string v4, "param_http_method"

    move-object/from16 v0, p1

    invoke-virtual {v0, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 740
    const-string v3, "param_http_url"

    const-string v4, "param_http_url"

    move-object/from16 v0, p1

    invoke-virtual {v0, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 741
    const-string v3, "param_http_response_type"

    const-string v4, "param_http_response_type"

    move-object/from16 v0, p1

    invoke-virtual {v0, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 742
    const-string v3, "param_data_json"

    move-object/from16 v0, p1

    invoke-virtual {v0, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 743
    if-eqz v3, :cond_14

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v4

    if-lez v4, :cond_14

    .line 744
    const-string v4, "param_data_json"

    invoke-virtual {v2, v4, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 746
    :cond_14
    move-object/from16 v0, p0

    invoke-direct {v0, v2}, Lcom/exacttarget/etpushsdk/ETPushService;->f(Landroid/content/Intent;)V

    goto/16 :goto_2

    .line 748
    :cond_15
    invoke-virtual/range {p0 .. p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 749
    const-string v3, "~!ETPushService"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Unknown SEND_TYPE for ETSendDataReceiver: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v3, v2}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_2

    :cond_16
    move-object v4, v5

    goto/16 :goto_7
.end method

.method private f(Landroid/content/Intent;)V
    .locals 7

    .prologue
    .line 755
    const-string v0, "~!ETPushService"

    const-string v1, "initiateHttpSend()"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 757
    const-string v0, "param_database_id"

    const/4 v1, -0x1

    invoke-virtual {p1, v0, v1}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    .line 758
    const-string v1, "~!ETPushService"

    const-string v2, "Database ID from Intent: %s"

    const/4 v0, 0x1

    new-array v3, v0, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-lez v0, :cond_0

    const-string v0, "null"

    :goto_0
    aput-object v0, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 760
    const-string v0, "param_database_ids"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v5

    check-cast v5, Ljava/util/List;

    .line 762
    const-string v0, "param_http_method"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 763
    const-string v0, "param_http_url"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 764
    const-string v0, "param_http_response_type"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 765
    const-string v0, "param_data_json"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 766
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/n;->b(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_1

    move-object v0, p0

    .line 767
    invoke-direct/range {v0 .. v6}, Lcom/exacttarget/etpushsdk/ETPushService;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;)V

    .line 771
    :goto_1
    return-void

    .line 758
    :cond_0
    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 769
    :cond_1
    const-string v0, "~!ETPushService"

    const-string v1, "SendUpdate: Network not available"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1
.end method


# virtual methods
.method protected onHandleIntent(Landroid/content/Intent;)V
    .locals 11

    .prologue
    const/4 v3, 0x3

    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 118
    const-string v0, "~!ETPushService"

    const-string v4, "%s.onHandleIntent()"

    new-array v5, v1, [Ljava/lang/Object;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v2

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v0, v4}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 120
    const-string v0, "power"

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/ETPushService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/PowerManager;

    .line 121
    const-string v4, "~!ETPushService"

    invoke-virtual {v0, v1, v4}, Landroid/os/PowerManager;->newWakeLock(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;

    move-result-object v4

    .line 122
    invoke-virtual {v4}, Landroid/os/PowerManager$WakeLock;->acquire()V

    .line 124
    invoke-static {p1}, Lcom/exacttarget/etpushsdk/ETPushReceiver;->completeWakefulIntent(Landroid/content/Intent;)Z

    .line 127
    :try_start_0
    const-string v0, "et_push_action"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 129
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->c()V

    .line 131
    const-string v0, "registration_id"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 132
    const-string v0, "error"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 133
    const-string v0, "unregistered"

    invoke-virtual {p1, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 135
    const/4 v0, -0x1

    invoke-virtual {v5}, Ljava/lang/String;->hashCode()I

    move-result v9

    sparse-switch v9, :sswitch_data_0

    :cond_0
    :goto_0
    packed-switch v0, :pswitch_data_0

    .line 324
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 325
    const-string v0, "~!ETPushService"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Unknown PUSH_ACTION for ETPushService: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 334
    :cond_1
    :goto_1
    invoke-virtual {v4}, Landroid/os/PowerManager$WakeLock;->release()V

    .line 335
    :goto_2
    return-void

    .line 135
    :sswitch_0
    :try_start_1
    const-string v9, "android.intent.action.BOOT_COMPLETED"

    invoke-virtual {v5, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_0

    move v0, v2

    goto :goto_0

    :sswitch_1
    const-string v9, "android.intent.action.BATTERY_LOW"

    invoke-virtual {v5, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_0

    move v0, v1

    goto :goto_0

    :sswitch_2
    const-string v9, "android.intent.action.BATTERY_OKAY"

    invoke-virtual {v5, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_0

    const/4 v0, 0x2

    goto :goto_0

    :sswitch_3
    const-string v9, "android.intent.action.PACKAGE_REPLACED"

    invoke-virtual {v5, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_0

    move v0, v3

    goto :goto_0

    :sswitch_4
    const-string v9, "android.intent.action.ACTION_SHUTDOWN"

    invoke-virtual {v5, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_0

    const/4 v0, 0x4

    goto :goto_0

    :sswitch_5
    const-string v9, "com.google.android.c2dm.intent.REGISTRATION"

    invoke-virtual {v5, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_0

    const/4 v0, 0x5

    goto :goto_0

    :sswitch_6
    const-string v9, "com.amazon.device.messaging.intent.REGISTRATION"

    invoke-virtual {v5, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_0

    const/4 v0, 0x6

    goto :goto_0

    :sswitch_7
    const-string v9, "com.google.android.c2dm.intent.RECEIVE"

    invoke-virtual {v5, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_0

    const/4 v0, 0x7

    goto :goto_0

    :sswitch_8
    const-string v9, "com.amazon.device.messaging.intent.RECEIVE"

    invoke-virtual {v5, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_0

    const/16 v0, 0x8

    goto/16 :goto_0

    :sswitch_9
    const-string v9, "android.net.conn.CONNECTIVITY_CHANGE"

    invoke-virtual {v5, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_0

    const/16 v0, 0x9

    goto/16 :goto_0

    :sswitch_a
    const-string v9, "et_push_action_open"

    invoke-virtual {v5, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_0

    const/16 v0, 0xa

    goto/16 :goto_0

    :sswitch_b
    const-string v9, "et_push_action_send"

    invoke-virtual {v5, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_0

    const/16 v0, 0xb

    goto/16 :goto_0

    :sswitch_c
    const-string v9, "et_push_app_in_background"

    invoke-virtual {v5, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_0

    const/16 v0, 0xc

    goto/16 :goto_0

    .line 137
    :pswitch_0
    const-string v0, "~!ETPushService"

    const-string v1, "Boot completed."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 139
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->b()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_1

    .line 330
    :catch_0
    move-exception v0

    .line 331
    const-string v1, "~!ETPushService"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto/16 :goto_1

    .line 142
    :pswitch_1
    :try_start_2
    const-string v0, "~!ETPushService"

    const-string v1, "Battery low."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 144
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/exacttarget/etpushsdk/ETPushService;->a(Z)V

    .line 145
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->a()V

    goto/16 :goto_1

    .line 149
    :pswitch_2
    const-string v0, "~!ETPushService"

    const-string v1, "Battery okay now."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 151
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/exacttarget/etpushsdk/ETPushService;->a(Z)V

    .line 152
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->b()V

    goto/16 :goto_1

    .line 155
    :pswitch_3
    const-string v0, "~!ETPushService"

    const-string v1, "Package replaced has been called."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 156
    invoke-direct {p0, p1}, Lcom/exacttarget/etpushsdk/ETPushService;->b(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 159
    :pswitch_4
    const-string v0, "~!ETPushService"

    const-string v1, "Device is shutting down."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 160
    invoke-direct {p0, p1}, Lcom/exacttarget/etpushsdk/ETPushService;->c(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 164
    :pswitch_5
    const-string v0, "~!ETPushService"

    const-string v1, "Received a registration event from Google."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 166
    if-eqz v7, :cond_2

    .line 167
    const-string v0, "~!ETPushService"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "GCM Registration error: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 168
    new-instance v0, Lcom/exacttarget/etpushsdk/event/ServerErrorEvent;

    invoke-direct {v0}, Lcom/exacttarget/etpushsdk/event/ServerErrorEvent;-><init>()V

    .line 169
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "GCM Registration error: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/event/ServerErrorEvent;->setMessage(Ljava/lang/String;)V

    .line 170
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/exacttarget/etpushsdk/util/EventBus;->a(Ljava/lang/Object;)V

    goto/16 :goto_1

    .line 171
    :cond_2
    if-eqz v8, :cond_3

    .line 172
    const-string v0, "~!ETPushService"

    const-string v1, "GCM Unregistered.  This should not happen."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_1

    .line 173
    :cond_3
    if-eqz v6, :cond_1

    .line 174
    const-string v0, "~!ETPushService"

    const-string v1, "GCM Registration complete. System Token received: %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object v6, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 175
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->getInstance()Lcom/exacttarget/etpushsdk/ETPush;

    move-result-object v0

    invoke-virtual {v0, v6}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 180
    :pswitch_6
    const-string v0, "~!ETPushService"

    const-string v1, "Received a registration event from Amazon."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 182
    if-eqz v7, :cond_4

    .line 183
    const-string v0, "~!ETPushService"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "ADM Registration error: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_1

    .line 184
    :cond_4
    if-eqz v8, :cond_5

    .line 185
    const-string v0, "~!ETPushService"

    const-string v1, "ADM Unregistered.  This should not happen"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_1

    .line 186
    :cond_5
    if-eqz v6, :cond_1

    .line 187
    const-string v0, "~!ETPushService"

    const-string v1, "ADM Registration complete. System Token received: %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object v6, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 188
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->getInstance()Lcom/exacttarget/etpushsdk/ETPush;

    move-result-object v0

    invoke-virtual {v0, v6}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 194
    :pswitch_7
    const-string v0, "~!ETPushService"

    const-string v1, "Hello from ExactTarget! Push Message received."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 196
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->getInstance()Lcom/exacttarget/etpushsdk/ETPush;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETPush;->isPushEnabled()Z

    move-result v0

    if-nez v0, :cond_6

    .line 197
    const-string v0, "~!ETPushService"

    const-string v1, "Push is disabled. Thanks for playing."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_2

    .line 202
    :cond_6
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    .line 204
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->getLogLevel()I

    move-result v0

    if-gt v0, v3, :cond_8

    .line 205
    const-string v0, ""

    .line 206
    invoke-virtual {v2}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    move-object v1, v0

    :goto_3
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_7

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 207
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v5, "["

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v5, ":"

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v2, v0}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "] "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    move-object v1, v0

    .line 208
    goto :goto_3

    .line 210
    :cond_7
    const-string v0, "~!ETPushService"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Payload: "

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 213
    :cond_8
    const-string v0, "regionId"

    invoke-virtual {v2, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_9

    const-string v0, "_m"

    invoke-virtual {v2, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 215
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->f()Z

    move-result v0

    if-eqz v0, :cond_9

    .line 216
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETAnalytics;->a()Lcom/exacttarget/etpushsdk/ETAnalytics;

    move-result-object v0

    const-string v1, "_m"

    invoke-virtual {v2, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/ETAnalytics;->b(Ljava/lang/String;)V

    .line 222
    :cond_9
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETNotifications;->getNotificationLaunchIntent()Lcom/exacttarget/etpushsdk/ETNotificationLaunchIntent;

    move-result-object v0

    if-eqz v0, :cond_d

    .line 224
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETNotifications;->getNotificationLaunchIntent()Lcom/exacttarget/etpushsdk/ETNotificationLaunchIntent;

    move-result-object v0

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-interface {v0, v1, v2}, Lcom/exacttarget/etpushsdk/ETNotificationLaunchIntent;->setupLaunchIntent(Landroid/content/Context;Landroid/os/Bundle;)Landroid/content/Intent;

    move-result-object v0

    move-object v1, v0

    .line 229
    :goto_4
    new-instance v3, Landroid/content/Intent;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v5, ".MESSAGE_OPENED"

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v3, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 230
    const-string v0, "et_open_type_extra"

    const-string v5, "et_push_action_open"

    invoke-virtual {v3, v0, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 231
    const-string v0, "et_push_open_intent"

    invoke-virtual {v3, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 234
    sget-object v5, Lcom/exacttarget/etpushsdk/ETPushService;->b:Ljava/lang/Object;

    monitor-enter v5
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    .line 235
    :try_start_3
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v6, "et_notification_id_key"

    const/4 v7, 0x0

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v10

    invoke-static {v10}, Landroid/preference/PreferenceManager;->getDefaultSharedPreferences(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v0, v6, v7, v8}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v6

    .line 236
    const-string v0, "~!ETPushService"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "NOTIFICATION_ID: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v0, v7}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 237
    const-string v0, "et_notification_id_key"

    invoke-virtual {v3, v0, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 239
    const-string v0, "_m"

    invoke-virtual {v2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result-object v0

    if-eqz v0, :cond_a

    .line 241
    :try_start_4
    const-string v0, "_m"

    invoke-virtual {v2, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/e;->a(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/data/Message;

    move-result-object v0

    .line 242
    if-eqz v0, :cond_a

    .line 243
    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v0, v7}, Lcom/exacttarget/etpushsdk/data/Message;->setNotifyId(Ljava/lang/Integer;)V

    .line 244
    new-instance v7, Landroid/content/ContentValues;

    invoke-direct {v7}, Landroid/content/ContentValues;-><init>()V

    .line 245
    const-string v8, "notify_id"

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 246
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Message;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v7}, Lcom/exacttarget/etpushsdk/database/e;->a(Ljava/lang/String;Landroid/content/ContentValues;)I
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 252
    :cond_a
    :goto_5
    add-int/lit8 v6, v6, 0x1

    .line 253
    :try_start_5
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v7, "et_notification_id_key"

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    invoke-static {v0, v7, v8}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;)V

    .line 254
    monitor-exit v5
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    .line 257
    :try_start_6
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETNotifications;->getNotificationBuilder()Lcom/exacttarget/etpushsdk/ETNotificationBuilder;

    move-result-object v0

    if-eqz v0, :cond_e

    .line 259
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETNotifications;->getNotificationBuilder()Lcom/exacttarget/etpushsdk/ETNotificationBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    invoke-interface {v0, v5, v2}, Lcom/exacttarget/etpushsdk/ETNotificationBuilder;->setupNotificationBuilder(Landroid/content/Context;Landroid/os/Bundle;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    .line 264
    :goto_6
    if-eqz v0, :cond_b

    if-eqz v1, :cond_b

    .line 265
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const/4 v5, 0x0

    invoke-static {v1, v3, v5}, Lcom/exacttarget/etpushsdk/ETNotifications;->setupLaunchPendingIntent(Landroid/content/Context;Landroid/content/Intent;Z)Landroid/app/PendingIntent;

    move-result-object v1

    .line 266
    invoke-virtual {v0, v1}, Landroid/support/v4/app/NotificationCompat$Builder;->setContentIntent(Landroid/app/PendingIntent;)Landroid/support/v4/app/NotificationCompat$Builder;

    .line 269
    :cond_b
    if-eqz v0, :cond_c

    .line 270
    invoke-virtual {v0}, Landroid/support/v4/app/NotificationCompat$Builder;->build()Landroid/app/Notification;

    move-result-object v1

    .line 271
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v3, "notification"

    invoke-virtual {v0, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    .line 272
    invoke-virtual {v0, v6, v1}, Landroid/app/NotificationManager;->notify(ILandroid/app/Notification;)V

    .line 275
    :cond_c
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v0

    new-instance v1, Lcom/exacttarget/etpushsdk/event/PushReceivedEvent;

    invoke-direct {v1, v2}, Lcom/exacttarget/etpushsdk/event/PushReceivedEvent;-><init>(Landroid/os/Bundle;)V

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/util/EventBus;->a(Ljava/lang/Object;)V

    goto/16 :goto_1

    .line 226
    :cond_d
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, v2}, Lcom/exacttarget/etpushsdk/ETNotifications;->setupLaunchIntent(Landroid/content/Context;Landroid/os/Bundle;)Landroid/content/Intent;
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_0

    move-result-object v0

    move-object v1, v0

    goto/16 :goto_4

    .line 248
    :catch_1
    move-exception v0

    .line 249
    :try_start_7
    const-string v7, "~!ETPushService"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_5

    .line 254
    :catchall_0
    move-exception v0

    monitor-exit v5
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    :try_start_8
    throw v0

    .line 261
    :cond_e
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0, v2}, Lcom/exacttarget/etpushsdk/ETNotifications;->setupNotificationBuilder(Landroid/content/Context;Landroid/os/Bundle;)Landroid/support/v4/app/NotificationCompat$Builder;

    move-result-object v0

    goto :goto_6

    .line 279
    :pswitch_8
    const-string v0, "~!ETPushService"

    const-string v3, "Received a connectivity change."

    invoke-static {v0, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 281
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v3, "et_last_connection_state"

    const/16 v5, 0x63

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    const/4 v6, 0x0

    new-array v6, v6, [Ljava/lang/Object;

    invoke-static {v0, v3, v5, v6}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 283
    packed-switch v0, :pswitch_data_1

    .line 302
    const-string v0, "~!ETPushService"

    const-string v3, "Last connection state was UNKNOWN."

    invoke-static {v0, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 306
    :cond_f
    :goto_7
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/n;->b(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_10

    move v0, v1

    .line 307
    :goto_8
    const-string v1, "~!ETPushService"

    const-string v2, "Saving state: %1d"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v3, v5

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 308
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-string v2, "et_last_connection_state"

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Integer;)V

    goto/16 :goto_1

    .line 285
    :pswitch_9
    const-string v0, "~!ETPushService"

    const-string v3, "Last connection state was OFF."

    invoke-static {v0, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 286
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/n;->b(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_f

    .line 287
    const-string v0, "~!ETPushService"

    const-string v3, "Now online, check if registrations need to be sent"

    invoke-static {v0, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 289
    invoke-static {}, Lcom/exacttarget/etpushsdk/database/h;->a()Lcom/exacttarget/etpushsdk/data/Registration;

    move-result-object v0

    if-eqz v0, :cond_f

    .line 290
    const-string v0, "~!ETPushService"

    const-string v3, "There are saved registrations.  Send them."

    invoke-static {v0, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 292
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    const-class v5, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-direct {v0, v3, v5}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 293
    const-string v3, "et_send_type_extra"

    const-string v5, "et_send_type_registration"

    invoke-virtual {v0, v3, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 294
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETPushService;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    goto :goto_7

    .line 299
    :pswitch_a
    const-string v0, "~!ETPushService"

    const-string v3, "Last connection state was ON."

    invoke-static {v0, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_7

    :cond_10
    move v0, v2

    .line 306
    goto :goto_8

    .line 312
    :pswitch_b
    const-string v0, "~!ETPushService"

    const-string v1, "Open from notification."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 313
    invoke-direct {p0, p1}, Lcom/exacttarget/etpushsdk/ETPushService;->a(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 316
    :pswitch_c
    const-string v0, "~!ETPushService"

    const-string v1, "Send data to Marketing Cloud."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 317
    invoke-direct {p0, p1}, Lcom/exacttarget/etpushsdk/ETPushService;->e(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 320
    :pswitch_d
    const-string v0, "~!ETPushService"

    const-string v1, "App in background."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 321
    invoke-direct {p0, p1}, Lcom/exacttarget/etpushsdk/ETPushService;->d(Landroid/content/Intent;)V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_0

    goto/16 :goto_1

    .line 135
    :sswitch_data_0
    .sparse-switch
        -0x7606c095 -> :sswitch_2
        -0x45e5283a -> :sswitch_9
        -0x304ed112 -> :sswitch_3
        -0x2c4aaffa -> :sswitch_6
        0x15d8a480 -> :sswitch_7
        0x1d398bfd -> :sswitch_1
        0x2f94f923 -> :sswitch_0
        0x3f326356 -> :sswitch_8
        0x677b391c -> :sswitch_5
        0x741706da -> :sswitch_4
        0x7ba1729e -> :sswitch_a
        0x7ba31bdc -> :sswitch_b
        0x7ea6a695 -> :sswitch_c
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_7
        :pswitch_8
        :pswitch_b
        :pswitch_c
        :pswitch_d
    .end packed-switch

    .line 283
    :pswitch_data_1
    .packed-switch 0x0
        :pswitch_9
        :pswitch_a
    .end packed-switch
.end method
