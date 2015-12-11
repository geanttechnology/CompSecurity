.class public Lcom/exacttarget/etpushsdk/ETPush;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/exacttarget/etpushsdk/event/RegistrationEventListener;


# static fields
.field private static final a:Ljava/lang/Object;

.field private static final b:Ljava/lang/Object;

.field private static c:Ljava/util/concurrent/CountDownLatch;

.field private static d:Ljava/util/concurrent/CountDownLatch;

.field private static e:Landroid/app/AlarmManager;

.field private static f:Landroid/content/Context;

.field private static g:Lcom/exacttarget/etpushsdk/ETPush;

.field private static h:Ljava/lang/Boolean;

.field private static i:Lcom/exacttarget/etpushsdk/data/Registration;

.field private static j:Ljava/lang/Integer;

.field private static k:Lcom/exacttarget/etpushsdk/ETPush$a;

.field private static l:Lcom/exacttarget/etpushsdk/ETPush$a;

.field private static m:Lcom/exacttarget/etpushsdk/ETPush$a;

.field private static n:Ljava/lang/Thread;

.field private static o:Ljava/lang/Class;

.field private static p:Ljava/lang/Class;

.field private static q:Ljava/lang/Class;

.field private static r:Ljava/lang/String;

.field private static s:Landroid/net/Uri;

.field private static t:Ljava/lang/Integer;


# instance fields
.field private u:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 92
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/exacttarget/etpushsdk/ETPush;->a:Ljava/lang/Object;

    .line 93
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/exacttarget/etpushsdk/ETPush;->b:Ljava/lang/Object;

    .line 94
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    sput-object v0, Lcom/exacttarget/etpushsdk/ETPush;->c:Ljava/util/concurrent/CountDownLatch;

    .line 95
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    sput-object v0, Lcom/exacttarget/etpushsdk/ETPush;->d:Ljava/util/concurrent/CountDownLatch;

    .line 101
    sput-object v2, Lcom/exacttarget/etpushsdk/ETPush;->h:Ljava/lang/Boolean;

    .line 103
    const/4 v0, 0x5

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/ETPush;->j:Ljava/lang/Integer;

    .line 104
    sput-object v2, Lcom/exacttarget/etpushsdk/ETPush;->k:Lcom/exacttarget/etpushsdk/ETPush$a;

    .line 105
    sput-object v2, Lcom/exacttarget/etpushsdk/ETPush;->l:Lcom/exacttarget/etpushsdk/ETPush$a;

    .line 106
    new-instance v0, Lcom/exacttarget/etpushsdk/ETPush$a;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Lcom/exacttarget/etpushsdk/ETPush$a;-><init>(I)V

    sput-object v0, Lcom/exacttarget/etpushsdk/ETPush;->m:Lcom/exacttarget/etpushsdk/ETPush$a;

    .line 107
    sput-object v2, Lcom/exacttarget/etpushsdk/ETPush;->n:Ljava/lang/Thread;

    .line 112
    sput-object v2, Lcom/exacttarget/etpushsdk/ETPush;->r:Ljava/lang/String;

    .line 113
    sput-object v2, Lcom/exacttarget/etpushsdk/ETPush;->s:Landroid/net/Uri;

    .line 114
    sput-object v2, Lcom/exacttarget/etpushsdk/ETPush;->t:Ljava/lang/Integer;

    return-void
.end method

.method private constructor <init>()V
    .locals 1

    .prologue
    .line 117
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 115
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/ETPush;->u:Ljava/lang/Object;

    .line 118
    return-void
.end method

.method synthetic constructor <init>(Lcom/exacttarget/etpushsdk/o;)V
    .locals 0

    .prologue
    .line 76
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/ETPush;-><init>()V

    return-void
.end method

.method private static A()V
    .locals 4

    .prologue
    const-wide/16 v2, 0x0

    .line 1091
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->k:Lcom/exacttarget/etpushsdk/ETPush$a;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETPush$a;->d()J

    move-result-wide v0

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    .line 1092
    const-string v0, "~!ETPush"

    const-string v1, "waitForRAF_toInitializeLatch aborted."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1093
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->k:Lcom/exacttarget/etpushsdk/ETPush$a;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETPush$a;->a()V

    .line 1095
    :cond_0
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->l:Lcom/exacttarget/etpushsdk/ETPush$a;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETPush$a;->d()J

    move-result-wide v0

    cmp-long v0, v0, v2

    if-lez v0, :cond_1

    .line 1096
    const-string v0, "~!ETPush"

    const-string v1, "waitForPushManager_toInitializeLatch aborted."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1097
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->l:Lcom/exacttarget/etpushsdk/ETPush$a;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETPush$a;->a()V

    .line 1099
    :cond_1
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->m:Lcom/exacttarget/etpushsdk/ETPush$a;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETPush$a;->d()J

    move-result-wide v0

    cmp-long v0, v0, v2

    if-lez v0, :cond_2

    .line 1100
    const-string v0, "~!ETPush"

    const-string v1, "waitForRAF_toStartLatch aborted."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1101
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->m:Lcom/exacttarget/etpushsdk/ETPush$a;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETPush$a;->a()V

    .line 1103
    :cond_2
    return-void
.end method

.method private B()V
    .locals 2

    .prologue
    .line 1278
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/ETPush;->C()V

    .line 1279
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/exacttarget/etpushsdk/y;

    invoke-direct {v1, p0}, Lcom/exacttarget/etpushsdk/y;-><init>(Lcom/exacttarget/etpushsdk/ETPush;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 1295
    return-void
.end method

.method private C()V
    .locals 3

    .prologue
    .line 1298
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    const-string v1, "et_android_version"

    sget-object v2, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 1299
    return-void
.end method

.method private D()Ljava/lang/Object;
    .locals 4

    .prologue
    .line 1570
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPush;->u:Ljava/lang/Object;

    if-nez v0, :cond_0

    .line 1572
    :try_start_0
    const-string v0, "com.amazon.device.messaging.ADM"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 1573
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Class;

    const/4 v2, 0x0

    const-class v3, Landroid/content/Context;

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/Class;->getConstructor([Ljava/lang/Class;)Ljava/lang/reflect/Constructor;

    move-result-object v0

    .line 1574
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    sget-object v3, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Ljava/lang/reflect/Constructor;->newInstance([Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/ETPush;->u:Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 1585
    :cond_0
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPush;->u:Ljava/lang/Object;

    return-object v0

    .line 1575
    :catch_0
    move-exception v0

    .line 1576
    const-string v1, "~!ETPush"

    invoke-virtual {v0}, Ljava/lang/ClassNotFoundException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 1577
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->A()V

    .line 1578
    new-instance v0, Lcom/exacttarget/etpushsdk/ETException;

    const-string v1, "unable to find com.amazon.device.messaging.ADM"

    invoke-direct {v0, v1}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1579
    :catch_1
    move-exception v0

    .line 1580
    const-string v1, "~!ETPush"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 1581
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->A()V

    .line 1582
    new-instance v1, Lcom/exacttarget/etpushsdk/ETException;

    invoke-virtual {v0}, Ljava/lang/Exception;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method private E()V
    .locals 3

    .prologue
    .line 1589
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/ETPush;->C()V

    .line 1591
    :try_start_0
    const-string v0, "~!ETPush"

    const-string v1, "Requesting ADM Registration"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1592
    const-string v0, "com.amazon.device.messaging.ADM"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 1593
    const-string v1, "startRegister"

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Class;

    invoke-virtual {v0, v1, v2}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/ETPush;->D()Ljava/lang/Object;

    move-result-object v1

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/ClassNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 1603
    return-void

    .line 1594
    :catch_0
    move-exception v0

    .line 1595
    const-string v1, "~!ETPush"

    invoke-virtual {v0}, Ljava/lang/ClassNotFoundException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 1596
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->A()V

    .line 1597
    new-instance v0, Lcom/exacttarget/etpushsdk/ETException;

    const-string v1, "unable to find com.amazon.device.messaging.ADM"

    invoke-direct {v0, v1}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1598
    :catch_1
    move-exception v0

    .line 1599
    const-string v1, "~!ETPush"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 1600
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->A()V

    .line 1601
    new-instance v1, Lcom/exacttarget/etpushsdk/ETException;

    invoke-virtual {v0}, Ljava/lang/Exception;->getCause()Ljava/lang/Throwable;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v1
.end method

.method public static a()Landroid/content/Context;
    .locals 1

    .prologue
    .line 121
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic a(Lcom/exacttarget/etpushsdk/ETPush$a;)Lcom/exacttarget/etpushsdk/ETPush$a;
    .locals 0

    .prologue
    .line 76
    sput-object p0, Lcom/exacttarget/etpushsdk/ETPush;->l:Lcom/exacttarget/etpushsdk/ETPush$a;

    return-object p0
.end method

.method static synthetic a(Lcom/exacttarget/etpushsdk/ETPush;)Lcom/exacttarget/etpushsdk/ETPush;
    .locals 0

    .prologue
    .line 76
    sput-object p0, Lcom/exacttarget/etpushsdk/ETPush;->g:Lcom/exacttarget/etpushsdk/ETPush;

    return-object p0
.end method

.method static synthetic a(Lcom/exacttarget/etpushsdk/data/Registration;)Lcom/exacttarget/etpushsdk/data/Registration;
    .locals 0

    .prologue
    .line 76
    sput-object p0, Lcom/exacttarget/etpushsdk/ETPush;->i:Lcom/exacttarget/etpushsdk/data/Registration;

    return-object p0
.end method

.method static synthetic a(Ljava/lang/Boolean;)Ljava/lang/Boolean;
    .locals 0

    .prologue
    .line 76
    sput-object p0, Lcom/exacttarget/etpushsdk/ETPush;->h:Ljava/lang/Boolean;

    return-object p0
.end method

.method static synthetic a(Ljava/util/concurrent/CountDownLatch;)Ljava/util/concurrent/CountDownLatch;
    .locals 0

    .prologue
    .line 76
    sput-object p0, Lcom/exacttarget/etpushsdk/ETPush;->c:Ljava/util/concurrent/CountDownLatch;

    return-object p0
.end method

.method static synthetic a(Landroid/app/Activity;Z)V
    .locals 0

    .prologue
    .line 76
    invoke-static {p0, p1}, Lcom/exacttarget/etpushsdk/ETPush;->d(Landroid/app/Activity;Z)V

    return-void
.end method

.method private static a(Landroid/app/Application;)V
    .locals 2
    .annotation build Landroid/annotation/TargetApi;
        value = 0xe
    .end annotation

    .prologue
    .line 849
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xe

    if-ge v0, v1, :cond_0

    .line 886
    :goto_0
    return-void

    .line 852
    :cond_0
    new-instance v0, Lcom/exacttarget/etpushsdk/s;

    invoke-direct {v0}, Lcom/exacttarget/etpushsdk/s;-><init>()V

    invoke-virtual {p0, v0}, Landroid/app/Application;->registerActivityLifecycleCallbacks(Landroid/app/Application$ActivityLifecycleCallbacks;)V

    goto :goto_0
.end method

.method protected static a(Landroid/net/Uri;Z)V
    .locals 2

    .prologue
    .line 1246
    if-eqz p0, :cond_0

    .line 1247
    sput-object p0, Lcom/exacttarget/etpushsdk/ETPush;->s:Landroid/net/Uri;

    .line 1251
    return-void

    .line 1249
    :cond_0
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Notification Action URI may not be null."

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method static synthetic a(Lcom/exacttarget/etpushsdk/ETPush;Z)V
    .locals 0

    .prologue
    .line 76
    invoke-direct {p0, p1}, Lcom/exacttarget/etpushsdk/ETPush;->a(Z)V

    return-void
.end method

.method protected static a(Ljava/lang/Class;Z)V
    .locals 5

    .prologue
    .line 1150
    if-eqz p1, :cond_0

    .line 1151
    invoke-static {p0}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/lang/Class;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1152
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "%s is not found in AndroidManifest."

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-virtual {p0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1155
    :cond_0
    sput-object p0, Lcom/exacttarget/etpushsdk/ETPush;->o:Ljava/lang/Class;

    .line 1156
    return-void
.end method

.method protected static a(Ljava/lang/Integer;Z)V
    .locals 2

    .prologue
    .line 1179
    if-eqz p1, :cond_0

    .line 1180
    invoke-static {p0}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/lang/Integer;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1181
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Notification Icon is not found in Application Resources."

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1184
    :cond_0
    sput-object p0, Lcom/exacttarget/etpushsdk/ETPush;->t:Ljava/lang/Integer;

    .line 1185
    return-void
.end method

.method protected static a(Ljava/lang/String;Z)V
    .locals 2

    .prologue
    .line 1238
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1239
    sput-object p0, Lcom/exacttarget/etpushsdk/ETPush;->r:Ljava/lang/String;

    .line 1243
    return-void

    .line 1241
    :cond_0
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Notification Action may not be empty or null."

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method private a(Z)V
    .locals 3

    .prologue
    .line 1087
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    const-string v1, "et_push_enabled"

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 1088
    return-void
.end method

.method private static a(Ljava/lang/Class;)Z
    .locals 4

    .prologue
    const/4 v0, 0x1

    .line 808
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 809
    sget-object v2, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    invoke-virtual {v1, v2, p0}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 811
    sget-object v2, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    const/high16 v3, 0x10000

    invoke-virtual {v2, v1, v3}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v1

    .line 812
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-lt v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static a(Ljava/lang/Integer;)Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 1188
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/Integer;->intValue()I

    move-result v1

    if-nez v1, :cond_1

    .line 1202
    :cond_0
    :goto_0
    return v0

    .line 1191
    :cond_1
    sget-object v1, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {p0}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getResourceName(I)Ljava/lang/String;

    move-result-object v1

    .line 1192
    if-eqz v1, :cond_0

    sget-object v2, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1195
    sget-object v1, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {p0}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-static {v1, v2}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v1

    .line 1196
    if-eqz v1, :cond_0

    .line 1199
    invoke-virtual {v1}, Landroid/graphics/Bitmap;->hasAlpha()Z

    move-result v0

    if-nez v0, :cond_2

    .line 1200
    const-string v0, "~!ETPush"

    const-string v1, "Notification icon should have alpha channel colors only to be properly displayed in Android 5.0"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;)I

    .line 1202
    :cond_2
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private static a(Ljava/util/List;Ljava/lang/Class;Ljava/lang/String;)Z
    .locals 9
    .param p1    # Ljava/lang/Class;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param
    .param p2    # Ljava/lang/String;
        .annotation build Landroid/support/annotation/NonNull;
        .end annotation
    .end param

    .prologue
    const/4 v8, 0x2

    const/4 v3, 0x1

    const/4 v1, 0x0

    .line 787
    const-string v2, "~!ETPush"

    const-string v4, "Receivers Info Size: %d, Receiver Class Name: %s, Package Name: %s"

    const/4 v0, 0x3

    new-array v5, v0, [Ljava/lang/Object;

    if-eqz p0, :cond_2

    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v0

    :goto_0
    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v5, v1

    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v5, v3

    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    move-object v0, p2

    :goto_1
    aput-object v0, v5, v8

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->b(Ljava/lang/String;Ljava/lang/String;)I

    .line 790
    if-eqz p0, :cond_6

    .line 791
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/pm/ResolveInfo;

    .line 792
    const-string v5, "~!ETPush"

    const-string v6, "ActivityInfo Name: %s, ActivityInfo Package: %s"

    new-array v7, v8, [Ljava/lang/Object;

    iget-object v2, v0, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    if-eqz v2, :cond_4

    iget-object v2, v0, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v2, v2, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    :goto_2
    aput-object v2, v7, v1

    iget-object v2, v0, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    if-eqz v2, :cond_5

    iget-object v2, v0, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v2, v2, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    :goto_3
    aput-object v2, v7, v3

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v5, v2}, Lcom/exacttarget/etpushsdk/util/m;->b(Ljava/lang/String;Ljava/lang/String;)I

    .line 793
    iget-object v2, v0, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    if-eqz v2, :cond_0

    iget-object v2, v0, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v2, v2, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-object v0, v0, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v0, v0, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v0, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 794
    const-string v0, "~!ETPush"

    const-string v2, "Receiver %s Found"

    new-array v4, v3, [Ljava/lang/Object;

    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v1

    invoke-static {v2, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    move v0, v3

    .line 800
    :goto_4
    if-nez v0, :cond_1

    .line 801
    const-string v2, "~!ETPush"

    const-string v4, "Did NOT find %s Receiver"

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {p1}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v1

    invoke-static {v4, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 804
    :cond_1
    return v0

    :cond_2
    move v0, v1

    .line 787
    goto/16 :goto_0

    :cond_3
    const-string v0, "NULL or Empty String"

    goto/16 :goto_1

    .line 792
    :cond_4
    const-string v2, "NULL"

    goto :goto_2

    :cond_5
    const-string v2, "NULL"

    goto :goto_3

    :cond_6
    move v0, v1

    goto :goto_4
.end method

.method public static declared-synchronized activityPaused(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 1051
    const-class v0, Lcom/exacttarget/etpushsdk/ETPush;

    monitor-enter v0

    const/4 v1, 0x0

    :try_start_0
    invoke-static {p0, v1}, Lcom/exacttarget/etpushsdk/ETPush;->c(Landroid/app/Activity;Z)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1052
    monitor-exit v0

    return-void

    .line 1051
    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method public static declared-synchronized activityResumed(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 1061
    const-class v0, Lcom/exacttarget/etpushsdk/ETPush;

    monitor-enter v0

    const/4 v1, 0x0

    :try_start_0
    invoke-static {p0, v1}, Lcom/exacttarget/etpushsdk/ETPush;->d(Landroid/app/Activity;Z)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1062
    monitor-exit v0

    return-void

    .line 1061
    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method protected static b()Lcom/exacttarget/etpushsdk/data/Registration;
    .locals 1

    .prologue
    .line 125
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->i:Lcom/exacttarget/etpushsdk/data/Registration;

    return-object v0
.end method

.method static synthetic b(Ljava/util/concurrent/CountDownLatch;)Ljava/util/concurrent/CountDownLatch;
    .locals 0

    .prologue
    .line 76
    sput-object p0, Lcom/exacttarget/etpushsdk/ETPush;->d:Ljava/util/concurrent/CountDownLatch;

    return-object p0
.end method

.method static synthetic b(Landroid/app/Activity;Z)V
    .locals 0

    .prologue
    .line 76
    invoke-static {p0, p1}, Lcom/exacttarget/etpushsdk/ETPush;->c(Landroid/app/Activity;Z)V

    return-void
.end method

.method protected static b(Ljava/lang/Class;Z)V
    .locals 3

    .prologue
    .line 1213
    if-eqz p1, :cond_0

    .line 1214
    invoke-static {p0}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/lang/Class;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1215
    new-instance v0, Ljava/lang/RuntimeException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " is not found in AndroidManifest."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1218
    :cond_0
    sput-object p0, Lcom/exacttarget/etpushsdk/ETPush;->p:Ljava/lang/Class;

    .line 1219
    return-void
.end method

.method protected static declared-synchronized c()V
    .locals 6

    .prologue
    .line 198
    const-class v1, Lcom/exacttarget/etpushsdk/ETPush;

    monitor-enter v1

    :try_start_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->x()V

    .line 203
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->k:Lcom/exacttarget/etpushsdk/ETPush$a;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETPush$a;->d()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v0, v2, v4

    if-lez v0, :cond_0

    .line 205
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->k:Lcom/exacttarget/etpushsdk/ETPush$a;

    const-wide/16 v2, 0x7530

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v2, v3, v4}, Lcom/exacttarget/etpushsdk/ETPush$a;->a(JLjava/util/concurrent/TimeUnit;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 206
    new-instance v0, Lcom/exacttarget/etpushsdk/ETException;

    const-string v2, "ETPush did not initialize in a timely fashion."

    invoke-direct {v0, v2}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 209
    :catch_0
    move-exception v0

    .line 210
    :try_start_1
    new-instance v2, Lcom/exacttarget/etpushsdk/ETException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Error waiting for ETPush to be initialized. Our error was: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 198
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0

    .line 212
    :cond_0
    monitor-exit v1

    return-void
.end method

.method private static c(Landroid/app/Activity;Z)V
    .locals 6

    .prologue
    const/4 v2, 0x1

    .line 889
    if-nez p1, :cond_0

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xe

    if-lt v0, v1, :cond_0

    .line 951
    :goto_0
    return-void

    .line 897
    :cond_0
    const-string v0, "~!ETPush"

    const-string v1, "Pausing as a result of callback? \'%1$s\'"

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p1}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 899
    sget-object v1, Lcom/exacttarget/etpushsdk/ETPush;->a:Ljava/lang/Object;

    monitor-enter v1

    .line 900
    :try_start_0
    new-instance v0, Ljava/lang/Thread;

    new-instance v2, Lcom/exacttarget/etpushsdk/t;

    invoke-direct {v2, p0}, Lcom/exacttarget/etpushsdk/t;-><init>(Landroid/app/Activity;)V

    invoke-direct {v0, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 928
    sget-object v2, Lcom/exacttarget/etpushsdk/ETPush;->c:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v2}, Ljava/util/concurrent/CountDownLatch;->getCount()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-nez v2, :cond_1

    .line 929
    const-string v2, "~!ETPush"

    const-string v3, "activityResumedThread is not running.  So continue with pausing activity."

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 930
    new-instance v2, Ljava/util/concurrent/CountDownLatch;

    const/4 v3, 0x1

    invoke-direct {v2, v3}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    sput-object v2, Lcom/exacttarget/etpushsdk/ETPush;->c:Ljava/util/concurrent/CountDownLatch;

    .line 931
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 950
    :goto_1
    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 934
    :cond_1
    :try_start_1
    new-instance v2, Ljava/lang/Thread;

    new-instance v3, Lcom/exacttarget/etpushsdk/u;

    invoke-direct {v3, v0}, Lcom/exacttarget/etpushsdk/u;-><init>(Ljava/lang/Thread;)V

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v2}, Ljava/lang/Thread;->start()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1
.end method

.method protected static c(Ljava/lang/Class;Z)V
    .locals 3

    .prologue
    .line 1229
    if-eqz p1, :cond_0

    .line 1230
    invoke-static {p0}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/lang/Class;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1231
    new-instance v0, Ljava/lang/RuntimeException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " is not found in AndroidManifest."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1234
    :cond_0
    sput-object p0, Lcom/exacttarget/etpushsdk/ETPush;->q:Ljava/lang/Class;

    .line 1235
    return-void
.end method

.method protected static d()V
    .locals 2

    .prologue
    .line 1033
    const-string v0, "~!ETPush"

    const-string v1, "Cancelling activityPausedPendingIntent"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1034
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->e:Landroid/app/AlarmManager;

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->e()Landroid/app/PendingIntent;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlarmManager;->cancel(Landroid/app/PendingIntent;)V

    .line 1035
    return-void
.end method

.method private static d(Landroid/app/Activity;Z)V
    .locals 6

    .prologue
    const/4 v2, 0x1

    .line 954
    if-nez p1, :cond_0

    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xe

    if-lt v0, v1, :cond_0

    .line 1030
    :goto_0
    return-void

    .line 962
    :cond_0
    const-string v0, "~!ETPush"

    const-string v1, "Resuming as a result of callback? \'%1$s\'"

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p1}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 963
    sget-object v1, Lcom/exacttarget/etpushsdk/ETPush;->a:Ljava/lang/Object;

    monitor-enter v1

    .line 964
    :try_start_0
    new-instance v0, Ljava/lang/Thread;

    new-instance v2, Lcom/exacttarget/etpushsdk/v;

    invoke-direct {v2, p0}, Lcom/exacttarget/etpushsdk/v;-><init>(Landroid/app/Activity;)V

    invoke-direct {v0, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 1007
    sget-object v2, Lcom/exacttarget/etpushsdk/ETPush;->c:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v2}, Ljava/util/concurrent/CountDownLatch;->getCount()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-nez v2, :cond_1

    .line 1008
    const-string v2, "~!ETPush"

    const-string v3, "activityPausedThread is not running.  So continue with resuming activity."

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1009
    new-instance v2, Ljava/util/concurrent/CountDownLatch;

    const/4 v3, 0x1

    invoke-direct {v2, v3}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    sput-object v2, Lcom/exacttarget/etpushsdk/ETPush;->c:Ljava/util/concurrent/CountDownLatch;

    .line 1010
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 1029
    :goto_1
    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 1013
    :cond_1
    :try_start_1
    new-instance v2, Ljava/lang/Thread;

    new-instance v3, Lcom/exacttarget/etpushsdk/w;

    invoke-direct {v3, v0}, Lcom/exacttarget/etpushsdk/w;-><init>(Ljava/lang/Thread;)V

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v2}, Ljava/lang/Thread;->start()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1
.end method

.method protected static e()Landroid/app/PendingIntent;
    .locals 4

    .prologue
    .line 1038
    new-instance v0, Landroid/content/Intent;

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1039
    const-string v1, "et_push_app_in_background"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 1040
    const-string v1, "time_went_in_background"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 1041
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v1

    const/16 v2, 0x3e8

    const/high16 v3, 0x8000000

    invoke-static {v1, v2, v0, v3}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    return-object v0
.end method

.method protected static f()V
    .locals 2

    .prologue
    .line 1106
    const-string v0, "~!ETPush"

    const-string v1, "sendRegistration() started..."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1107
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->i:Lcom/exacttarget/etpushsdk/data/Registration;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Registration;->getSystemToken()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1108
    const-string v0, "~!ETPush"

    const-string v1, "have systemToken, send registration..."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1109
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/exacttarget/etpushsdk/x;

    invoke-direct {v1}, Lcom/exacttarget/etpushsdk/x;-><init>()V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 1127
    :cond_0
    const-string v0, "~!ETPush"

    const-string v1, "sendRegistration() ended..."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1128
    return-void
.end method

.method protected static g()Ljava/lang/Class;
    .locals 1

    .prologue
    .line 1209
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->p:Ljava/lang/Class;

    return-object v0
.end method

.method public static declared-synchronized getInstance()Lcom/exacttarget/etpushsdk/ETPush;
    .locals 6

    .prologue
    .line 142
    const-class v1, Lcom/exacttarget/etpushsdk/ETPush;

    monitor-enter v1

    :try_start_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->x()V

    .line 147
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->l:Lcom/exacttarget/etpushsdk/ETPush$a;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETPush$a;->d()J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v0, v2, v4

    if-lez v0, :cond_0

    .line 150
    :try_start_1
    const-string v0, "~!ETPush"

    const-string v2, "Waiting for PushManager to initialize"

    invoke-static {v0, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 151
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->l:Lcom/exacttarget/etpushsdk/ETPush$a;

    const-wide/16 v2, 0x61a8

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v2, v3, v4}, Lcom/exacttarget/etpushsdk/ETPush$a;->a(JLjava/util/concurrent/TimeUnit;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 152
    new-instance v0, Lcom/exacttarget/etpushsdk/ETException;

    const-string v2, "ETPush singleton getInstance did not initialize in a timely fashion."

    invoke-direct {v0, v2}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_1
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 154
    :catch_0
    move-exception v0

    .line 155
    :try_start_2
    new-instance v2, Lcom/exacttarget/etpushsdk/ETException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "ETPush singleton getInstance initialized failed with an error. Our error was: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v2
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 142
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0

    .line 159
    :cond_0
    :try_start_3
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->g:Lcom/exacttarget/etpushsdk/ETPush;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    monitor-exit v1

    return-object v0
.end method

.method public static getLogLevel()I
    .locals 1

    .prologue
    .line 821
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->j:Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    return v0
.end method

.method public static getNotificationRecipientClass()Ljava/lang/Class;
    .locals 1

    .prologue
    .line 1136
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->o:Ljava/lang/Class;

    return-object v0
.end method

.method public static getNotificationResourceId()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 1164
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->t:Ljava/lang/Integer;

    return-object v0
.end method

.method public static getSdkVersionCode()I
    .locals 1

    .prologue
    .line 1079
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/o;->b()I

    move-result v0

    return v0
.end method

.method public static getSdkVersionName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1070
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/o;->a()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected static h()Ljava/lang/Class;
    .locals 1

    .prologue
    .line 1225
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->q:Ljava/lang/Class;

    return-object v0
.end method

.method static synthetic k()Landroid/content/Context;
    .locals 1

    .prologue
    .line 76
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic l()Z
    .locals 1

    .prologue
    .line 76
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->z()Z

    move-result v0

    return v0
.end method

.method static synthetic m()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 76
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->h:Ljava/lang/Boolean;

    return-object v0
.end method

.method static synthetic n()Lcom/exacttarget/etpushsdk/data/Registration;
    .locals 1

    .prologue
    .line 76
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->i:Lcom/exacttarget/etpushsdk/data/Registration;

    return-object v0
.end method

.method static synthetic o()Lcom/exacttarget/etpushsdk/ETPush$a;
    .locals 1

    .prologue
    .line 76
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->l:Lcom/exacttarget/etpushsdk/ETPush$a;

    return-object v0
.end method

.method static synthetic p()V
    .locals 0

    .prologue
    .line 76
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->y()V

    return-void
.end method

.method public static declared-synchronized pushManager()Lcom/exacttarget/etpushsdk/ETPush;
    .locals 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 170
    const-class v0, Lcom/exacttarget/etpushsdk/ETPush;

    monitor-enter v0

    :try_start_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->getInstance()Lcom/exacttarget/etpushsdk/ETPush;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    monitor-exit v0

    return-object v1

    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method static synthetic q()V
    .locals 0

    .prologue
    .line 76
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->A()V

    return-void
.end method

.method static synthetic r()Lcom/exacttarget/etpushsdk/ETPush$a;
    .locals 1

    .prologue
    .line 76
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->k:Lcom/exacttarget/etpushsdk/ETPush$a;

    return-object v0
.end method

.method public static readyAimFire(Landroid/app/Application;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZ)V
    .locals 8
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 313
    const/4 v5, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move v4, p4

    move v6, p5

    move v7, p6

    invoke-static/range {v0 .. v7}, Lcom/exacttarget/etpushsdk/ETPush;->readyAimFire(Landroid/app/Application;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZ)V

    .line 314
    return-void
.end method

.method public static readyAimFire(Landroid/app/Application;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZZZ)V
    .locals 1

    .prologue
    .line 281
    new-instance v0, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;

    invoke-direct {v0, p0}, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;-><init>(Landroid/app/Application;)V

    invoke-virtual {v0, p1}, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->setEtAppId(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;

    move-result-object v0

    invoke-virtual {v0, p2}, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->setAccessToken(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;

    move-result-object v0

    invoke-virtual {v0, p3}, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->setGcmSenderId(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;

    move-result-object v0

    invoke-virtual {v0, p4}, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->setAnalyticsEnabled(Z)Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;

    move-result-object v0

    invoke-virtual {v0, p5}, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->setPiAnalyticsEnabled(Z)Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;

    move-result-object v0

    invoke-virtual {v0, p6}, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->setLocationEnabled(Z)Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;

    move-result-object v0

    invoke-virtual {v0, p7}, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->setCloudPagesEnabled(Z)Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETPushConfig$Builder;->build()Lcom/exacttarget/etpushsdk/ETPushConfig;

    move-result-object v0

    .line 290
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETPush;->readyAimFire(Lcom/exacttarget/etpushsdk/ETPushConfig;)V

    .line 291
    return-void
.end method

.method public static readyAimFire(Lcom/exacttarget/etpushsdk/ETPushConfig;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 326
    const-string v0, "~!ETPush"

    const-string v1, "readyAimFire()"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 331
    new-instance v0, Lcom/exacttarget/etpushsdk/ETPush$a;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Lcom/exacttarget/etpushsdk/ETPush$a;-><init>(I)V

    sput-object v0, Lcom/exacttarget/etpushsdk/ETPush;->k:Lcom/exacttarget/etpushsdk/ETPush$a;

    .line 335
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig;->a:Landroid/app/Application;

    sput-object v0, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    .line 336
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    check-cast v0, Landroid/app/Application;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETPush;->a(Landroid/app/Application;)V

    .line 337
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    const-string v1, "alarm"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AlarmManager;

    sput-object v0, Lcom/exacttarget/etpushsdk/ETPush;->e:Landroid/app/AlarmManager;

    .line 341
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->m:Lcom/exacttarget/etpushsdk/ETPush$a;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETPush$a;->c()V

    .line 345
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->g:Lcom/exacttarget/etpushsdk/ETPush;

    if-nez v0, :cond_6

    .line 348
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig;->b:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig;->b:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    const-string v1, "[0-9a-f]{8}-[a-f0-9]{4}-4[a-f0-9]{3}-[89aAbB][a-f0-9]{3}-[a-f0-9]{12}"

    invoke-virtual {v0, v1}, Ljava/lang/String;->matches(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 349
    :cond_0
    const-string v0, "~!ETPush:readyAimFire"

    const-string v1, "ERROR: The etAppId is not a valid UUID. Did you copy/paste incorrectly?"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 350
    new-instance v0, Lcom/exacttarget/etpushsdk/ETException;

    const-string v1, "The etAppId is not a valid UUID. Did you copy/paste incorrectly?"

    invoke-direct {v0, v1}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    .line 351
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v1

    new-instance v2, Lcom/exacttarget/etpushsdk/event/ReadyAimFireInitCompletedEvent;

    invoke-direct {v2, v3, v0}, Lcom/exacttarget/etpushsdk/event/ReadyAimFireInitCompletedEvent;-><init>(ZLjava/lang/Exception;)V

    invoke-virtual {v1, v2}, Lcom/exacttarget/etpushsdk/util/EventBus;->a(Ljava/lang/Object;)V

    .line 352
    throw v0

    .line 355
    :cond_1
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig;->c:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig;->c:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0x18

    if-eq v0, v1, :cond_3

    .line 356
    :cond_2
    const-string v0, "~!ETPush:readyAimFire"

    const-string v1, "ERROR: The accessToken is not 24 characters. Did you copy/paste incorrectly?"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 357
    new-instance v0, Lcom/exacttarget/etpushsdk/ETException;

    const-string v1, "The accessToken is not 24 characters. Did you copy/paste incorrectly?"

    invoke-direct {v0, v1}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    .line 358
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v1

    new-instance v2, Lcom/exacttarget/etpushsdk/event/ReadyAimFireInitCompletedEvent;

    invoke-direct {v2, v3, v0}, Lcom/exacttarget/etpushsdk/event/ReadyAimFireInitCompletedEvent;-><init>(ZLjava/lang/Exception;)V

    invoke-virtual {v1, v2}, Lcom/exacttarget/etpushsdk/util/EventBus;->a(Ljava/lang/Object;)V

    .line 359
    throw v0

    .line 362
    :cond_3
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig;->d:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 363
    const-string v0, "~!ETPush:readyAimFire"

    const-string v1, "ERROR: The gcmSenderId may not be null or empty. Did you copy/paste incorrectly?"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 364
    new-instance v0, Lcom/exacttarget/etpushsdk/ETException;

    const-string v1, "The gcmSenderId may not be null or empty. Did you copy/paste incorrectly?"

    invoke-direct {v0, v1}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    .line 365
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v1

    new-instance v2, Lcom/exacttarget/etpushsdk/event/ReadyAimFireInitCompletedEvent;

    invoke-direct {v2, v3, v0}, Lcom/exacttarget/etpushsdk/event/ReadyAimFireInitCompletedEvent;-><init>(ZLjava/lang/Exception;)V

    invoke-virtual {v1, v2}, Lcom/exacttarget/etpushsdk/util/EventBus;->a(Ljava/lang/Object;)V

    .line 366
    throw v0

    .line 369
    :cond_4
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/b;->a()Z

    move-result v0

    if-eqz v0, :cond_5

    iget-boolean v0, p0, Lcom/exacttarget/etpushsdk/ETPushConfig;->g:Z

    if-eqz v0, :cond_5

    .line 370
    const-string v0, "~!ETPush:readyAimFire"

    const-string v1, "ERROR: LocationManager is enabled but Location Services are not available on this Amazon Device."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 371
    new-instance v0, Lcom/exacttarget/etpushsdk/ETException;

    const-string v1, "LocationManager is enabled but Location Services are not available on this Amazon Device."

    invoke-direct {v0, v1}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    .line 372
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v1

    new-instance v2, Lcom/exacttarget/etpushsdk/event/ReadyAimFireInitCompletedEvent;

    invoke-direct {v2, v3, v0}, Lcom/exacttarget/etpushsdk/event/ReadyAimFireInitCompletedEvent;-><init>(ZLjava/lang/Exception;)V

    invoke-virtual {v1, v2}, Lcom/exacttarget/etpushsdk/util/EventBus;->a(Ljava/lang/Object;)V

    .line 373
    throw v0

    .line 376
    :cond_5
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/exacttarget/etpushsdk/o;

    invoke-direct {v1, p0}, Lcom/exacttarget/etpushsdk/o;-><init>(Lcom/exacttarget/etpushsdk/ETPushConfig;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    sput-object v0, Lcom/exacttarget/etpushsdk/ETPush;->n:Ljava/lang/Thread;

    .line 504
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->n:Ljava/lang/Thread;

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 509
    return-void

    .line 507
    :cond_6
    new-instance v0, Lcom/exacttarget/etpushsdk/ETException;

    const-string v1, "You must have called readyAimFire more than once. It should only be called from your Application\'s Application#onCreate() method."

    invoke-direct {v0, v1}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method static synthetic s()Lcom/exacttarget/etpushsdk/ETPush;
    .locals 1

    .prologue
    .line 76
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->g:Lcom/exacttarget/etpushsdk/ETPush;

    return-object v0
.end method

.method public static setLogLevel(I)V
    .locals 3

    .prologue
    .line 830
    const/4 v0, 0x2

    if-lt p0, v0, :cond_1

    const/4 v0, 0x7

    if-gt p0, v0, :cond_1

    .line 831
    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/ETPush;->j:Ljava/lang/Integer;

    .line 841
    :goto_0
    const/4 v0, 0x3

    if-lt p0, v0, :cond_0

    .line 843
    const-string v0, "~!ETPush"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Logging set to :"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcom/exacttarget/etpushsdk/ETPush;->j:Ljava/lang/Integer;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 845
    :cond_0
    return-void

    .line 833
    :cond_1
    const-string v0, "~!ETPush"

    const-string v1, "Invalid log level set.  Setting to Log.WARN."

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 834
    const/4 v0, 0x5

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/ETPush;->j:Ljava/lang/Integer;

    goto :goto_0
.end method

.method static synthetic t()Landroid/app/AlarmManager;
    .locals 1

    .prologue
    .line 76
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->e:Landroid/app/AlarmManager;

    return-object v0
.end method

.method static synthetic u()Ljava/util/concurrent/CountDownLatch;
    .locals 1

    .prologue
    .line 76
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->c:Ljava/util/concurrent/CountDownLatch;

    return-object v0
.end method

.method static synthetic v()Ljava/util/concurrent/CountDownLatch;
    .locals 1

    .prologue
    .line 76
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->d:Ljava/util/concurrent/CountDownLatch;

    return-object v0
.end method

.method static synthetic w()Ljava/lang/Thread;
    .locals 1

    .prologue
    .line 76
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->n:Ljava/lang/Thread;

    return-object v0
.end method

.method private static declared-synchronized x()V
    .locals 5

    .prologue
    .line 215
    const-class v1, Lcom/exacttarget/etpushsdk/ETPush;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->m:Lcom/exacttarget/etpushsdk/ETPush$a;

    if-nez v0, :cond_0

    .line 228
    new-instance v0, Lcom/exacttarget/etpushsdk/ETException;

    const-string v2, "No readyAimFire() call.  Please see documentation and add to your Application class."

    invoke-direct {v0, v2}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 215
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0

    .line 231
    :cond_0
    :try_start_1
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->k:Lcom/exacttarget/etpushsdk/ETPush$a;

    if-nez v0, :cond_1

    .line 240
    const-string v0, "~!ETPush"

    const-string v2, "Wait for readyAimFire() to be called."

    invoke-static {v0, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 243
    :try_start_2
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->m:Lcom/exacttarget/etpushsdk/ETPush$a;

    const-wide/16 v2, 0x3a98

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v2, v3, v4}, Lcom/exacttarget/etpushsdk/ETPush$a;->a(JLjava/util/concurrent/TimeUnit;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 247
    const/4 v0, 0x0

    sput-object v0, Lcom/exacttarget/etpushsdk/ETPush;->m:Lcom/exacttarget/etpushsdk/ETPush$a;

    .line 248
    new-instance v0, Lcom/exacttarget/etpushsdk/ETException;

    const-string v2, "Waiting for readyAimFire() to be called timed out.  Did you forget to call readyAimFire()?"

    invoke-direct {v0, v2}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_2
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 250
    :catch_0
    move-exception v0

    .line 251
    const/4 v2, 0x0

    :try_start_3
    sput-object v2, Lcom/exacttarget/etpushsdk/ETPush;->m:Lcom/exacttarget/etpushsdk/ETPush$a;

    .line 252
    new-instance v2, Lcom/exacttarget/etpushsdk/ETException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Error waiting for readyAimFire() to be called. Our error was: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v2, v0}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 256
    :cond_1
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->k:Lcom/exacttarget/etpushsdk/ETPush$a;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETPush$a;->b()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 257
    new-instance v0, Lcom/exacttarget/etpushsdk/ETException;

    const-string v2, "readyAimFire() initialization aborted.  See LogCat for more information."

    invoke-direct {v0, v2}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 259
    :cond_2
    monitor-exit v1

    return-void
.end method

.method private static y()V
    .locals 11

    .prologue
    const/4 v10, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 512
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v5

    .line 513
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v6

    .line 516
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 519
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/j;->a(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 520
    const-string v0, "~!ETPush"

    const-string v1, "Google Device."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 521
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".permission.C2D_MESSAGE"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 522
    const-string v0, "com.google.android.c2dm.permission.RECEIVE"

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 523
    const-string v0, "com.google.android.c2dm.permission.SEND"

    move-object v1, v0

    .line 534
    :goto_0
    const-string v0, "android.permission.INTERNET"

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 535
    const-string v0, "android.permission.GET_ACCOUNTS"

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 536
    const-string v0, "android.permission.WAKE_LOCK"

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 537
    const-string v0, "android.permission.ACCESS_NETWORK_STATE"

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 538
    const-string v0, "android.permission.ACCESS_WIFI_STATE"

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 540
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->h()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 541
    const-string v0, "android.permission.ACCESS_COARSE_LOCATION"

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 542
    const-string v0, "android.permission.ACCESS_FINE_LOCATION"

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 543
    const-string v0, "android.permission.RECEIVE_BOOT_COMPLETED"

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 546
    :cond_0
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 547
    invoke-virtual {v5, v0, v6}, Landroid/content/pm/PackageManager;->checkPermission(Ljava/lang/String;Ljava/lang/String;)I

    move-result v7

    if-eqz v7, :cond_1

    .line 548
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->A()V

    .line 549
    new-instance v1, Ljava/lang/RuntimeException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "ApplicationManifest.xml missing required permission: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 524
    :cond_2
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/b;->a(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 525
    const-string v0, "~!ETPush"

    const-string v1, "Amazon Device."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 526
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".permission.RECEIVE_ADM_MESSAGE"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 527
    const-string v0, "com.amazon.device.messaging.permission.RECEIVE"

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 528
    const-string v0, "com.amazon.device.messaging.permission.SEND"

    move-object v1, v0

    goto/16 :goto_0

    .line 530
    :cond_3
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->A()V

    .line 531
    new-instance v0, Lcom/exacttarget/etpushsdk/ETException;

    const-string v1, "Unable to continue.  Neither Google Services nor Amazon Device Messaging is available"

    invoke-direct {v0, v1}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 555
    :cond_4
    new-instance v0, Landroid/content/Intent;

    sget-object v2, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    const-class v7, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-direct {v0, v2, v7}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 556
    invoke-virtual {v5, v0, v3}, Landroid/content/pm/PackageManager;->queryBroadcastReceivers(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    .line 560
    if-eqz v0, :cond_7

    .line 561
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    move v2, v3

    :goto_1
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/pm/ResolveInfo;

    .line 562
    iget-object v8, v0, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    if-eqz v8, :cond_24

    iget-object v8, v0, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v8, v8, Landroid/content/pm/ActivityInfo;->name:Ljava/lang/String;

    const-class v9, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-virtual {v9}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_24

    iget-object v8, v0, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v8, v8, Landroid/content/pm/ActivityInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v8, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_24

    .line 564
    iget-object v2, v0, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v2, v2, Landroid/content/pm/ActivityInfo;->permission:Ljava/lang/String;

    if-eqz v2, :cond_5

    iget-object v0, v0, Landroid/content/pm/ResolveInfo;->activityInfo:Landroid/content/pm/ActivityInfo;

    iget-object v0, v0, Landroid/content/pm/ActivityInfo;->permission:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_6

    .line 565
    :cond_5
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->A()V

    .line 566
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v2, "%1$s definition in AndroidManifest.xml missing permission %2$s"

    new-array v5, v10, [Ljava/lang/Object;

    const-class v6, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-virtual {v6}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v3

    aput-object v1, v5, v4

    invoke-static {v2, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_6
    move v0, v4

    :goto_2
    move v2, v0

    .line 569
    goto :goto_1

    :cond_7
    move v2, v3

    .line 572
    :cond_8
    if-nez v2, :cond_9

    .line 573
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->A()V

    .line 574
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "%1$s definition not found in AndroidManifest.xml"

    new-array v2, v4, [Ljava/lang/Object;

    const-class v4, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-virtual {v4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 577
    :cond_9
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/j;->a(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 579
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.google.android.c2dm.intent.REGISTRATION"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 580
    invoke-virtual {v0, v6}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 581
    invoke-virtual {v5, v0, v3}, Landroid/content/pm/PackageManager;->queryBroadcastReceivers(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    .line 582
    const-string v1, "~!ETPush"

    const-string v2, "Looking for com.google.android.c2dm.intent.REGISTRATION Intent Filter w/Category %s"

    new-array v7, v4, [Ljava/lang/Object;

    aput-object v6, v7, v3

    invoke-static {v2, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 583
    const-class v1, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-static {v0, v1, v6}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/util/List;Ljava/lang/Class;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_a

    .line 584
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->A()V

    .line 585
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "%1$s definition in AndroidManifest.xml missing intent filter for com.google.android.c2dm.intent.REGISTRATION with category %2$s"

    new-array v2, v10, [Ljava/lang/Object;

    const-class v5, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v3

    aput-object v6, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 588
    :cond_a
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.google.android.c2dm.intent.RECEIVE"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 589
    invoke-virtual {v0, v6}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 590
    invoke-virtual {v5, v0, v3}, Landroid/content/pm/PackageManager;->queryBroadcastReceivers(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    .line 591
    const-string v1, "~!ETPush"

    const-string v2, "Looking for com.google.android.c2dm.intent.RECEIVE Intent Filter w/Category %s"

    new-array v7, v4, [Ljava/lang/Object;

    aput-object v6, v7, v3

    invoke-static {v2, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 592
    const-class v1, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-static {v0, v1, v6}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/util/List;Ljava/lang/Class;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_e

    .line 593
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->A()V

    .line 594
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "%1$s definition in AndroidManifest.xml missing intent filter for com.google.android.c2dm.intent.RECEIVE with category %2$s"

    new-array v2, v10, [Ljava/lang/Object;

    const-class v5, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v3

    aput-object v6, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 597
    :cond_b
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/b;->a(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_d

    .line 599
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.amazon.device.messaging.intent.REGISTRATION"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 600
    invoke-virtual {v0, v6}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 601
    invoke-virtual {v5, v0, v3}, Landroid/content/pm/PackageManager;->queryBroadcastReceivers(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    .line 602
    const-string v1, "~!ETPush"

    const-string v2, "Looking for com.amazon.device.messaging.intent.REGISTRATION Intent Filter w/Category %s"

    new-array v7, v4, [Ljava/lang/Object;

    aput-object v6, v7, v3

    invoke-static {v2, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 603
    const-class v1, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-static {v0, v1, v6}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/util/List;Ljava/lang/Class;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_c

    .line 604
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->A()V

    .line 605
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "%1$s definition in AndroidManifest.xml missing intent filter for com.amazon.device.messaging.intent.REGISTRATION with category %2$s"

    new-array v2, v10, [Ljava/lang/Object;

    const-class v5, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v3

    aput-object v6, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 608
    :cond_c
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.amazon.device.messaging.intent.RECEIVE"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 609
    invoke-virtual {v0, v6}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 610
    invoke-virtual {v5, v0, v3}, Landroid/content/pm/PackageManager;->queryBroadcastReceivers(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    .line 611
    const-string v1, "~!ETPush"

    const-string v2, "Looking for com.amazon.device.messaging.intent.RECEIVE Intent Filter w/Category %s"

    new-array v7, v4, [Ljava/lang/Object;

    aput-object v6, v7, v3

    invoke-static {v2, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 612
    const-class v1, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-static {v0, v1, v6}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/util/List;Ljava/lang/Class;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_e

    .line 613
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->A()V

    .line 614
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "%1$s definition in AndroidManifest.xml missing intent filter for com.amazon.device.messaging.intent.RECEIVE with category %2$s"

    new-array v2, v10, [Ljava/lang/Object;

    const-class v5, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v3

    aput-object v6, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 617
    :cond_d
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->A()V

    .line 618
    new-instance v0, Lcom/exacttarget/etpushsdk/ETException;

    const-string v1, "Unable to continue.  Neither Google Services nor Amazon Device Messaging is available"

    invoke-direct {v0, v1}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 622
    :cond_e
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.PACKAGE_REPLACED"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 623
    const-string v1, "package://"

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 624
    invoke-virtual {v0, v1}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 625
    invoke-virtual {v5, v0, v3}, Landroid/content/pm/PackageManager;->queryBroadcastReceivers(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    .line 626
    const-string v1, "~!ETPush"

    const-string v2, "Looking for %s Intent Filter w/Scheme %s"

    new-array v7, v10, [Ljava/lang/Object;

    const-string v8, "android.intent.action.PACKAGE_REPLACED"

    aput-object v8, v7, v3

    const-string v8, "package"

    aput-object v8, v7, v4

    invoke-static {v2, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 627
    const-class v1, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-static {v0, v1, v6}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/util/List;Ljava/lang/Class;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_f

    .line 628
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->A()V

    .line 629
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "%1$s definition in AndroidManifest.xml missing intent filter for %2$s with data element containing <data android:scheme=\"package\" />"

    new-array v2, v10, [Ljava/lang/Object;

    const-class v5, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v3

    const-string v3, "android.intent.action.PACKAGE_REPLACED"

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 633
    :cond_f
    new-instance v0, Landroid/content/Intent;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ".MESSAGE_OPENED"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 634
    invoke-virtual {v5, v0, v3}, Landroid/content/pm/PackageManager;->queryBroadcastReceivers(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    .line 635
    const-string v1, "~!ETPush"

    const-string v2, "Looking for %s Intent Filter"

    new-array v7, v4, [Ljava/lang/Object;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, ".MESSAGE_OPENED"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v3

    invoke-static {v2, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 636
    const-class v1, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-static {v0, v1, v6}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/util/List;Ljava/lang/Class;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_10

    .line 637
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->A()V

    .line 638
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "%1$s definition in AndroidManifest.xml missing intent filter for %2$s"

    new-array v2, v10, [Ljava/lang/Object;

    const-class v5, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v3

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v5, ".MESSAGE_OPENED"

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 642
    :cond_10
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.net.conn.CONNECTIVITY_CHANGE"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 643
    invoke-virtual {v5, v0, v3}, Landroid/content/pm/PackageManager;->queryBroadcastReceivers(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    .line 644
    const-string v1, "~!ETPush"

    const-string v2, "Looking for %s Intent Filter"

    new-array v7, v4, [Ljava/lang/Object;

    const-string v8, "android.net.conn.CONNECTIVITY_CHANGE"

    aput-object v8, v7, v3

    invoke-static {v2, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 645
    const-class v1, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-static {v0, v1, v6}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/util/List;Ljava/lang/Class;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_11

    .line 646
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->A()V

    .line 647
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "%1$s definition in AndroidManifest.xml missing intent filter for android.net.conn.CONNECTIVITY_CHANGE"

    new-array v2, v4, [Ljava/lang/Object;

    const-class v4, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-virtual {v4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 652
    :cond_11
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.ACTION_SHUTDOWN"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 653
    invoke-virtual {v5, v0, v3}, Landroid/content/pm/PackageManager;->queryBroadcastReceivers(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    .line 654
    const-string v1, "~!ETPush"

    const-string v2, "Looking for %s Intent Filter"

    new-array v7, v4, [Ljava/lang/Object;

    const-string v8, "android.intent.action.ACTION_SHUTDOWN"

    aput-object v8, v7, v3

    invoke-static {v2, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 655
    const-class v1, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-static {v0, v1, v6}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/util/List;Ljava/lang/Class;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_12

    .line 656
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->A()V

    .line 657
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "%1$s definition in AndroidManifest.xml missing intent filter for %2$s"

    new-array v2, v10, [Ljava/lang/Object;

    const-class v5, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v3

    const-string v3, "android.intent.action.ACTION_SHUTDOWN"

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 664
    :cond_12
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->h()Z

    move-result v0

    if-eqz v0, :cond_15

    .line 666
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.BOOT_COMPLETED"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 667
    invoke-virtual {v5, v0, v3}, Landroid/content/pm/PackageManager;->queryBroadcastReceivers(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    .line 668
    const-string v1, "~!ETPush"

    const-string v2, "Looking for %s Intent Filter"

    new-array v7, v4, [Ljava/lang/Object;

    const-string v8, "android.intent.action.BOOT_COMPLETED"

    aput-object v8, v7, v3

    invoke-static {v2, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 669
    const-class v1, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-static {v0, v1, v6}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/util/List;Ljava/lang/Class;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_13

    .line 670
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->A()V

    .line 671
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "%1$s definition in AndroidManifest.xml missing intent filter for %2$s"

    new-array v2, v10, [Ljava/lang/Object;

    const-class v5, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v3

    const-string v3, "android.intent.action.BOOT_COMPLETED"

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 675
    :cond_13
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.BATTERY_LOW"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 676
    invoke-virtual {v5, v0, v3}, Landroid/content/pm/PackageManager;->queryBroadcastReceivers(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    .line 677
    const-string v1, "~!ETPush"

    const-string v2, "Looking for %s Intent Filter"

    new-array v7, v4, [Ljava/lang/Object;

    const-string v8, "android.intent.action.BATTERY_LOW"

    aput-object v8, v7, v3

    invoke-static {v2, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 678
    const-class v1, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-static {v0, v1, v6}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/util/List;Ljava/lang/Class;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_14

    .line 679
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->A()V

    .line 680
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "%1$s definition in AndroidManifest.xml missing intent filter for %2$s"

    new-array v2, v10, [Ljava/lang/Object;

    const-class v5, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v3

    const-string v3, "android.intent.action.BATTERY_LOW"

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 684
    :cond_14
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.BATTERY_OKAY"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 685
    invoke-virtual {v5, v0, v3}, Landroid/content/pm/PackageManager;->queryBroadcastReceivers(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    .line 686
    const-string v1, "~!ETPush"

    const-string v2, "Looking for %s Intent Filter"

    new-array v7, v4, [Ljava/lang/Object;

    const-string v8, "android.intent.action.BATTERY_OKAY"

    aput-object v8, v7, v3

    invoke-static {v2, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 687
    const-class v1, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-static {v0, v1, v6}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/util/List;Ljava/lang/Class;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_15

    .line 688
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->A()V

    .line 689
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "%1$s definition in AndroidManifest.xml missing intent filter for %2$s"

    new-array v2, v10, [Ljava/lang/Object;

    const-class v5, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v3

    const-string v3, "android.intent.action.BATTERY_OKAY"

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 698
    :cond_15
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v0

    .line 699
    new-instance v1, Landroid/content/ComponentName;

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v2

    const-class v7, Lcom/exacttarget/etpushsdk/ETLocationReceiver;

    invoke-direct {v1, v2, v7}, Landroid/content/ComponentName;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 700
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->h()Z

    move-result v2

    if-eqz v2, :cond_17

    invoke-virtual {v0, v1}, Landroid/content/pm/PackageManager;->getComponentEnabledSetting(Landroid/content/ComponentName;)I

    move-result v0

    if-nez v0, :cond_17

    .line 703
    new-instance v0, Landroid/content/Intent;

    sget-object v1, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    const-class v2, Lcom/exacttarget/etpushsdk/ETLocationReceiver;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 704
    invoke-virtual {v5, v0, v3}, Landroid/content/pm/PackageManager;->queryBroadcastReceivers(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    .line 705
    const-string v1, "~!ETPush"

    const-string v2, "Looking for instanceof ETLocationReceiver"

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 706
    const-class v1, Lcom/exacttarget/etpushsdk/ETLocationReceiver;

    invoke-static {v0, v1, v6}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/util/List;Ljava/lang/Class;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_16

    .line 707
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->A()V

    .line 708
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "%1$s definition in AndroidManifest.xml is missing."

    new-array v2, v4, [Ljava/lang/Object;

    const-class v4, Lcom/exacttarget/etpushsdk/ETLocationReceiver;

    invoke-virtual {v4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 713
    :cond_16
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.location.PROVIDERS_CHANGED"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 714
    const-string v1, "android.intent.category.DEFAULT"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 715
    invoke-virtual {v5, v0, v3}, Landroid/content/pm/PackageManager;->queryBroadcastReceivers(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v0

    .line 716
    const-string v1, "~!ETPush"

    const-string v2, "Looking for android.location.PROVIDERS_CHANGED Intent Filter w/Category %s"

    new-array v7, v4, [Ljava/lang/Object;

    const-string v8, "android.intent.category.DEFAULT"

    aput-object v8, v7, v3

    invoke-static {v2, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 717
    const-class v1, Lcom/exacttarget/etpushsdk/ETLocationReceiver;

    invoke-static {v0, v1, v6}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/util/List;Ljava/lang/Class;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_17

    .line 718
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->A()V

    .line 719
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "%1$s definition in AndroidManifest.xml missing intent filter for android.location.PROVIDERS_CHANGED with category %2$s"

    new-array v2, v10, [Ljava/lang/Object;

    const-class v5, Lcom/exacttarget/etpushsdk/ETLocationReceiver;

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v3

    const-string v3, "android.intent.category.DEFAULT"

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 724
    :cond_17
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 725
    const-class v1, Lcom/exacttarget/etpushsdk/ETPushService;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 726
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->h()Z

    move-result v1

    if-eqz v1, :cond_18

    .line 727
    const-class v1, Lcom/exacttarget/etpushsdk/ETLocationService;

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 729
    :cond_18
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_19
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1c

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Class;

    .line 730
    new-instance v1, Landroid/content/Intent;

    sget-object v2, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    invoke-direct {v1, v2, v0}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 731
    invoke-virtual {v5, v1, v3}, Landroid/content/pm/PackageManager;->queryIntentServices(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v1

    .line 734
    if-eqz v1, :cond_1a

    .line 735
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    move v2, v3

    :goto_3
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1b

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/content/pm/ResolveInfo;

    .line 736
    iget-object v9, v1, Landroid/content/pm/ResolveInfo;->serviceInfo:Landroid/content/pm/ServiceInfo;

    if-eqz v9, :cond_23

    iget-object v9, v1, Landroid/content/pm/ResolveInfo;->serviceInfo:Landroid/content/pm/ServiceInfo;

    iget-object v9, v9, Landroid/content/pm/ServiceInfo;->name:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_23

    iget-object v1, v1, Landroid/content/pm/ResolveInfo;->serviceInfo:Landroid/content/pm/ServiceInfo;

    iget-object v1, v1, Landroid/content/pm/ServiceInfo;->packageName:Ljava/lang/String;

    invoke-virtual {v1, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_23

    move v1, v4

    :goto_4
    move v2, v1

    .line 739
    goto :goto_3

    :cond_1a
    move v2, v3

    .line 741
    :cond_1b
    if-nez v2, :cond_19

    .line 742
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->A()V

    .line 743
    new-instance v1, Ljava/lang/RuntimeException;

    const-string v2, "ApplicationManifest.xml missing definition for service: %1$s"

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v4, v3

    invoke-static {v2, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 755
    :cond_1c
    const-class v0, Lcom/exacttarget/etpushsdk/ETLandingPagePresenter;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/lang/Class;)Z

    move-result v0

    if-nez v0, :cond_1f

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->j()Z

    move-result v0

    if-eqz v0, :cond_1f

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->h()Ljava/lang/Class;

    move-result-object v0

    if-nez v0, :cond_1f

    .line 756
    const-string v0, "~!ETPush"

    const-string v1, "%s is not found in AndroidManifest.  This will impact the ability to display CloudPages without setting a class with setCloudPageRecipient(Class<?>). If you\'re setting this class after the call to readyAimFire() you can remove this warning by adding your class in the ETPushConfig.Builder() implementation of readyAimFire()."

    new-array v2, v4, [Ljava/lang/Object;

    const-class v5, Lcom/exacttarget/etpushsdk/ETLandingPagePresenter;

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;)I

    .line 769
    :cond_1d
    const-class v0, Lcom/exacttarget/etpushsdk/ETLandingPagePresenter;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/lang/Class;)Z

    move-result v0

    if-nez v0, :cond_20

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->g()Ljava/lang/Class;

    move-result-object v0

    if-nez v0, :cond_20

    .line 770
    const-string v0, "~!ETPush"

    const-string v1, "%s is not found in AndroidManifest.  This will impact the ability to display OpenDirect URLs without setting a class with setOpenDirectRecipient(Class<?>). If you\'re setting this class after the call to readyAimFire() you can remove this warning by adding your class in the ETPushConfig.Builder() implementation of readyAimFire()."

    new-array v2, v4, [Ljava/lang/Object;

    const-class v5, Lcom/exacttarget/etpushsdk/ETLandingPagePresenter;

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;)I

    .line 775
    :cond_1e
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->getNotificationRecipientClass()Ljava/lang/Class;

    move-result-object v0

    if-eqz v0, :cond_21

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->getNotificationRecipientClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/lang/Class;)Z

    move-result v0

    if-nez v0, :cond_21

    .line 776
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "%s is not found in AndroidManifest."

    new-array v2, v4, [Ljava/lang/Object;

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->getNotificationRecipientClass()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 757
    :cond_1f
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->h()Ljava/lang/Class;

    move-result-object v0

    if-eqz v0, :cond_1d

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->h()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/lang/Class;)Z

    move-result v0

    if-nez v0, :cond_1d

    .line 758
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "%s is not found in AndroidManifest."

    new-array v2, v4, [Ljava/lang/Object;

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->h()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 771
    :cond_20
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->g()Ljava/lang/Class;

    move-result-object v0

    if-eqz v0, :cond_1e

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->g()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/lang/Class;)Z

    move-result v0

    if-nez v0, :cond_1e

    .line 772
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "%s is not found in AndroidManifest."

    new-array v2, v4, [Ljava/lang/Object;

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->g()Ljava/lang/Class;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 779
    :cond_21
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->getNotificationResourceId()Ljava/lang/Integer;

    move-result-object v0

    if-eqz v0, :cond_22

    .line 780
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->getNotificationResourceId()Ljava/lang/Integer;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/lang/Integer;)Z

    move-result v0

    if-nez v0, :cond_22

    .line 781
    new-instance v0, Ljava/lang/RuntimeException;

    const-string v1, "Notification Icon is not found in Application Resources."

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 784
    :cond_22
    return-void

    :cond_23
    move v1, v2

    goto/16 :goto_4

    :cond_24
    move v0, v2

    goto/16 :goto_2
.end method

.method private static z()Z
    .locals 7

    .prologue
    const/4 v3, 0x1

    const/4 v6, 0x0

    .line 1083
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    const-string v1, "et_push_enabled"

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    new-array v3, v3, [Ljava/lang/Object;

    sget-object v4, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    const-string v5, "~!ETPush"

    invoke-virtual {v4, v5, v6}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v0, v1, v2, v3}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    return v0
.end method


# virtual methods
.method protected a(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 1620
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1621
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->i:Lcom/exacttarget/etpushsdk/data/Registration;

    invoke-virtual {v0, p1}, Lcom/exacttarget/etpushsdk/data/Registration;->setSystemTokenInCache(Ljava/lang/String;)V

    .line 1624
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->f()V

    .line 1626
    :cond_0
    return-void
.end method

.method protected a(Ljava/lang/String;II)V
    .locals 18

    .prologue
    .line 1712
    const-string v4, "~!ETPush"

    const-string v5, "showFenceOrProximityMessage()"

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1714
    :try_start_0
    invoke-virtual/range {p0 .. p0}, Lcom/exacttarget/etpushsdk/ETPush;->isPushEnabled()Z

    move-result v4

    if-nez v4, :cond_1

    .line 1715
    const-string v4, "~!ETPush"

    const-string v5, "Push is disabled, no fence or proximity messages will show. Thanks for playing."

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1974
    :cond_0
    :goto_0
    return-void

    .line 1719
    :cond_1
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v4

    invoke-virtual {v4}, Lcom/exacttarget/etpushsdk/ETLocationManager;->isWatchingLocation()Z

    move-result v4

    if-nez v4, :cond_6

    const/4 v4, 0x1

    move/from16 v0, p2

    if-eq v0, v4, :cond_2

    const/4 v4, 0x2

    move/from16 v0, p2

    if-ne v0, v4, :cond_6

    .line 1720
    :cond_2
    const-string v4, "~!ETPush"

    const-string v5, "Location is disabled, no fence messages will show. Thanks for playing."

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1727
    :catch_0
    move-exception v4

    .line 1728
    const-string v5, "~!ETPush"

    invoke-virtual {v4}, Lcom/exacttarget/etpushsdk/ETException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6, v4}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 1731
    :cond_3
    new-instance v6, Ljava/util/Date;

    invoke-direct {v6}, Ljava/util/Date;-><init>()V

    .line 1734
    :try_start_1
    invoke-static/range {p1 .. p1}, Lcom/exacttarget/etpushsdk/database/g;->a(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/data/Region;

    move-result-object v7

    .line 1735
    const-string v4, "~!ETPush"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Geofence Region: "

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v7}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1736
    packed-switch p2, :pswitch_data_0

    .line 1755
    :cond_4
    :goto_1
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    .line 1756
    const-string v4, "region_id = ?"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v9, 0x0

    aput-object p1, v5, v9

    const/4 v9, 0x0

    const/4 v10, 0x0

    const/4 v11, 0x0

    invoke-static {v4, v5, v9, v10, v11}, Lcom/exacttarget/etpushsdk/database/f;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v4

    .line 1763
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :cond_5
    :goto_2
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_20

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/exacttarget/etpushsdk/data/RegionMessage;

    .line 1764
    invoke-virtual {v4}, Lcom/exacttarget/etpushsdk/data/RegionMessage;->getMessage()Lcom/exacttarget/etpushsdk/data/Message;

    move-result-object v5

    invoke-virtual {v5}, Lcom/exacttarget/etpushsdk/data/Message;->getId()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/exacttarget/etpushsdk/database/e;->a(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/data/Message;

    move-result-object v10

    .line 1765
    if-eqz v10, :cond_5

    .line 1766
    sget-object v5, Lcom/exacttarget/etpushsdk/data/Message;->d:Ljava/lang/Integer;

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getMessageType()Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v5, v11}, Ljava/lang/Integer;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_7

    const/4 v5, 0x2

    move/from16 v0, p2

    if-ne v5, v0, :cond_7

    .line 1767
    const-string v4, "~!ETPush"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "ignoring message "

    invoke-virtual {v5, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getId()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v10, " because it\'s an entry and we were triggered by an exit"

    invoke-virtual {v5, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_2

    .line 1971
    :catch_1
    move-exception v4

    .line 1972
    const-string v5, "~!ETPush"

    invoke-virtual {v4}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6, v4}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto/16 :goto_0

    .line 1723
    :cond_6
    :try_start_2
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v4

    invoke-virtual {v4}, Lcom/exacttarget/etpushsdk/ETLocationManager;->isWatchingProximity()Z

    move-result v4

    if-nez v4, :cond_3

    const/4 v4, 0x1

    move/from16 v0, p2

    if-eq v0, v4, :cond_3

    const/4 v4, 0x2

    move/from16 v0, p2

    if-eq v0, v4, :cond_3

    .line 1724
    const-string v4, "~!ETPush"

    const-string v5, "Proximity is disabled, no beacon messages will show. Thanks for playing."

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_2
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_2 .. :try_end_2} :catch_0

    goto/16 :goto_0

    .line 1738
    :pswitch_0
    :try_start_3
    invoke-virtual {v7}, Lcom/exacttarget/etpushsdk/data/Region;->getExitCount()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    add-int/lit8 v4, v4, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v7, v4}, Lcom/exacttarget/etpushsdk/data/Region;->setExitCount(Ljava/lang/Integer;)V

    .line 1739
    invoke-static {v7}, Lcom/exacttarget/etpushsdk/database/g;->c(Lcom/exacttarget/etpushsdk/data/Region;)I

    .line 1740
    const-string v4, "~!ETPush"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "GeofenceExitCount: "

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v7}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v8, ": "

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v7}, Lcom/exacttarget/etpushsdk/data/Region;->getExitCount()Ljava/lang/Integer;

    move-result-object v8

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1741
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->f()Z

    move-result v4

    if-eqz v4, :cond_4

    .line 1742
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETAnalytics;->a()Lcom/exacttarget/etpushsdk/ETAnalytics;

    move-result-object v4

    move-object/from16 v0, p1

    invoke-virtual {v4, v0}, Lcom/exacttarget/etpushsdk/ETAnalytics;->a(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 1746
    :pswitch_1
    invoke-virtual {v7}, Lcom/exacttarget/etpushsdk/data/Region;->getEntryCount()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    add-int/lit8 v4, v4, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v7, v4}, Lcom/exacttarget/etpushsdk/data/Region;->setEntryCount(Ljava/lang/Integer;)V

    .line 1747
    invoke-static {v7}, Lcom/exacttarget/etpushsdk/database/g;->c(Lcom/exacttarget/etpushsdk/data/Region;)I

    .line 1748
    const-string v4, "~!ETPush"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "GeofenceEntryCount: "

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v7}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v8, ": "

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v7}, Lcom/exacttarget/etpushsdk/data/Region;->getEntryCount()Ljava/lang/Integer;

    move-result-object v8

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1749
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->f()Z

    move-result v4

    if-eqz v4, :cond_4

    .line 1750
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETAnalytics;->a()Lcom/exacttarget/etpushsdk/ETAnalytics;

    move-result-object v4

    const/4 v5, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v4, v0, v5}, Lcom/exacttarget/etpushsdk/ETAnalytics;->a(Ljava/lang/String;Z)V

    goto/16 :goto_1

    .line 1771
    :cond_7
    sget-object v5, Lcom/exacttarget/etpushsdk/data/Message;->e:Ljava/lang/Integer;

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getMessageType()Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v5, v11}, Ljava/lang/Integer;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_8

    const/4 v5, 0x1

    move/from16 v0, p2

    if-ne v5, v0, :cond_8

    .line 1772
    const-string v4, "~!ETPush"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "ignoring message "

    invoke-virtual {v5, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getId()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v10, " because it\'s an exit and we were triggered by an entry"

    invoke-virtual {v5, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_2

    .line 1776
    :cond_8
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getEndDate()Ljava/util/Date;

    move-result-object v5

    if-eqz v5, :cond_9

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getEndDate()Ljava/util/Date;

    move-result-object v5

    invoke-virtual {v5, v6}, Ljava/util/Date;->before(Ljava/util/Date;)Z

    move-result v5

    if-eqz v5, :cond_9

    .line 1777
    const-string v5, "~!ETPush"

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "fence or proximity message "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getId()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, " has expired, deleting..."

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v5, v11}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1778
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getId()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/exacttarget/etpushsdk/database/e;->b(Ljava/lang/String;)I

    .line 1779
    invoke-virtual {v4}, Lcom/exacttarget/etpushsdk/data/RegionMessage;->getId()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-static {v4}, Lcom/exacttarget/etpushsdk/database/f;->a(I)I

    goto/16 :goto_2

    .line 1783
    :cond_9
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getStartDate()Ljava/util/Date;

    move-result-object v4

    if-eqz v4, :cond_a

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getStartDate()Ljava/util/Date;

    move-result-object v4

    invoke-virtual {v4, v6}, Ljava/util/Date;->after(Ljava/util/Date;)Z

    move-result v4

    if-eqz v4, :cond_a

    .line 1784
    const-string v4, "~!ETPush"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "fence or proximity message "

    invoke-virtual {v5, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getId()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v5, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v11, " hasn\'t started yet: "

    invoke-virtual {v5, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getStartDate()Ljava/util/Date;

    move-result-object v10

    invoke-virtual {v5, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_2

    .line 1788
    :cond_a
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getMessageLimit()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    const/4 v5, -0x1

    if-le v4, v5, :cond_b

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getShowCount()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getMessageLimit()Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    if-lt v4, v5, :cond_b

    .line 1789
    const-string v4, "~!ETPush"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "fence or proximity message "

    invoke-virtual {v5, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getId()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v10, " hit its messageLimit, not showing."

    invoke-virtual {v5, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_2

    .line 1793
    :cond_b
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getMessagesPerPeriod()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    const/4 v5, -0x1

    if-le v4, v5, :cond_c

    .line 1794
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getPeriodShowCount()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getMessagesPerPeriod()Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    if-lt v4, v5, :cond_c

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getNextAllowedShow()Ljava/util/Date;

    move-result-object v4

    invoke-virtual {v4, v6}, Ljava/util/Date;->after(Ljava/util/Date;)Z

    move-result v4

    if-eqz v4, :cond_c

    .line 1795
    const-string v4, "~!ETPush"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "fence or proximity message "

    invoke-virtual {v5, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getId()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v10, " hit its messagesPerPeriod Limit, not showing."

    invoke-virtual {v5, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_2

    .line 1800
    :cond_c
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getNextAllowedShow()Ljava/util/Date;

    move-result-object v4

    invoke-virtual {v4, v6}, Ljava/util/Date;->after(Ljava/util/Date;)Z

    move-result v4

    if-eqz v4, :cond_d

    .line 1801
    const-string v4, "~!ETPush"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "fence or proximity message "

    invoke-virtual {v5, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getId()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v10, " hit before nextAllowedShow, not showing."

    invoke-virtual {v5, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_2

    .line 1806
    :cond_d
    const/4 v4, 0x2

    move/from16 v0, p2

    if-ne v4, v0, :cond_e

    .line 1807
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getMinTripped()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-virtual {v7}, Lcom/exacttarget/etpushsdk/data/Region;->getExitCount()Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    if-le v4, v5, :cond_f

    .line 1808
    const-string v4, "~!ETPush"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "fence message "

    invoke-virtual {v5, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getId()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v10, " hit before minTripped reached, not showing."

    invoke-virtual {v5, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_2

    .line 1812
    :cond_e
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getMinTripped()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-virtual {v7}, Lcom/exacttarget/etpushsdk/data/Region;->getEntryCount()Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    if-le v4, v5, :cond_f

    .line 1813
    const-string v4, "~!ETPush"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "fence or proximity message "

    invoke-virtual {v5, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getId()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v5, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v10, " hit before minTripped reached, not showing."

    invoke-virtual {v5, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    goto/16 :goto_2

    .line 1820
    :cond_f
    :try_start_4
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v4

    invoke-virtual {v4}, Lcom/exacttarget/etpushsdk/ETLocationManager;->isWatchingProximity()Z

    move-result v4

    if-eqz v4, :cond_12

    const/4 v4, 0x1

    move/from16 v0, p2

    if-eq v0, v4, :cond_12

    const/4 v4, 0x2

    move/from16 v0, p2

    if-eq v0, v4, :cond_12

    .line 1821
    if-eqz p3, :cond_10

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getProximity()I

    move-result v4

    move/from16 v0, p3

    if-le v0, v4, :cond_11

    .line 1822
    :cond_10
    const-string v4, "~!ETPush"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "Proximity was "

    invoke-virtual {v5, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    move/from16 v0, p3

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v11, ", but message.proximity was "

    invoke-virtual {v5, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getProximity()I

    move-result v10

    invoke-virtual {v5, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v10, ", not showing."

    invoke-virtual {v5, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_4
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_4 .. :try_end_4} :catch_2
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1

    goto/16 :goto_2

    .line 1831
    :catch_2
    move-exception v4

    .line 1832
    :try_start_5
    const-string v5, "~!ETPush"

    invoke-virtual {v4}, Lcom/exacttarget/etpushsdk/ETException;->getMessage()Ljava/lang/String;

    move-result-object v10

    invoke-static {v5, v10, v4}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1

    goto/16 :goto_2

    .line 1826
    :cond_11
    :try_start_6
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getHasEntered()Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-eqz v4, :cond_12

    .line 1827
    const-string v4, "~!ETPush"

    const-string v5, "We\'re still inside the region and have never left, not showing."

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_6
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_6 .. :try_end_6} :catch_2
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_1

    goto/16 :goto_2

    .line 1837
    :cond_12
    :try_start_7
    invoke-virtual {v10, v6}, Lcom/exacttarget/etpushsdk/data/Message;->setLastShownDate(Ljava/util/Date;)V

    .line 1838
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getShowCount()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    add-int/lit8 v4, v4, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v10, v4}, Lcom/exacttarget/etpushsdk/data/Message;->setShowCount(Ljava/lang/Integer;)V

    .line 1840
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getMessagesPerPeriod()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    const/4 v5, -0x1

    if-le v4, v5, :cond_13

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getNumberOfPeriods()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    const/4 v5, -0x1

    if-le v4, v5, :cond_13

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getPeriodType()Ljava/lang/Integer;

    move-result-object v4

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/Integer;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_13

    .line 1841
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getPeriodShowCount()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    add-int/lit8 v4, v4, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v10, v4}, Lcom/exacttarget/etpushsdk/data/Message;->setPeriodShowCount(Ljava/lang/Integer;)V

    .line 1842
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getPeriodShowCount()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getMessagesPerPeriod()Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    if-lt v4, v5, :cond_13

    .line 1843
    const-wide/16 v4, 0x0

    .line 1844
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getPeriodType()Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Integer;->intValue()I

    move-result v11

    packed-switch v11, :pswitch_data_1

    .line 1861
    :goto_3
    new-instance v11, Ljava/util/Date;

    invoke-virtual {v6}, Ljava/util/Date;->getTime()J

    move-result-wide v12

    add-long/2addr v4, v12

    invoke-direct {v11, v4, v5}, Ljava/util/Date;-><init>(J)V

    invoke-virtual {v10, v11}, Lcom/exacttarget/etpushsdk/data/Message;->setNextAllowedShow(Ljava/util/Date;)V

    .line 1863
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getIsRollingPeriod()Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-nez v4, :cond_13

    .line 1864
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v4

    .line 1865
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getNextAllowedShow()Ljava/util/Date;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/Date;->getTime()J

    move-result-wide v12

    invoke-virtual {v4, v12, v13}, Ljava/util/Calendar;->setTimeInMillis(J)V

    .line 1866
    const/16 v5, 0xe

    const/4 v11, 0x0

    invoke-virtual {v4, v5, v11}, Ljava/util/Calendar;->set(II)V

    .line 1867
    const/16 v5, 0xd

    const/4 v11, 0x0

    invoke-virtual {v4, v5, v11}, Ljava/util/Calendar;->set(II)V

    .line 1869
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getPeriodType()Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    packed-switch v5, :pswitch_data_2

    .line 1895
    :goto_4
    invoke-virtual {v4}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v4

    invoke-virtual {v10, v4}, Lcom/exacttarget/etpushsdk/data/Message;->setNextAllowedShow(Ljava/util/Date;)V

    .line 1901
    :cond_13
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getPeriodShowCount()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    const/4 v5, -0x1

    if-le v4, v5, :cond_14

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getMessagesPerPeriod()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    const/4 v5, -0x1

    if-le v4, v5, :cond_14

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getPeriodShowCount()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getMessagesPerPeriod()Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    if-le v4, v5, :cond_14

    .line 1902
    const/4 v4, 0x0

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v10, v4}, Lcom/exacttarget/etpushsdk/data/Message;->setPeriodShowCount(Ljava/lang/Integer;)V

    .line 1905
    :cond_14
    const/4 v4, 0x1

    move/from16 v0, p2

    if-eq v0, v4, :cond_16

    const/4 v4, 0x2

    move/from16 v0, p2

    if-eq v0, v4, :cond_16

    .line 1907
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    .line 1908
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getLoiterSeconds()Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Integer;->intValue()I

    move-result v11

    if-lez v11, :cond_1d

    .line 1909
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getEntryTime()Ljava/lang/Long;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Long;->longValue()J

    move-result-wide v12

    const-wide/16 v14, 0x0

    cmp-long v11, v12, v14

    if-nez v11, :cond_15

    .line 1910
    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v10, v4}, Lcom/exacttarget/etpushsdk/data/Message;->setEntryTime(Ljava/lang/Long;)V

    .line 1911
    const-string v4, "~!ETPush"

    const-string v5, "Entered, but loiteringTime has not yet triggered."

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1912
    invoke-static {v10}, Lcom/exacttarget/etpushsdk/database/e;->c(Lcom/exacttarget/etpushsdk/data/Message;)I

    goto/16 :goto_2

    .line 1846
    :pswitch_2
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getNumberOfPeriods()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    int-to-long v4, v4

    const-wide/32 v12, 0x36ee80

    mul-long/2addr v4, v12

    .line 1847
    goto/16 :goto_3

    .line 1849
    :pswitch_3
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getNumberOfPeriods()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    int-to-long v4, v4

    const-wide/32 v12, 0x5265c00

    mul-long/2addr v4, v12

    .line 1850
    goto/16 :goto_3

    .line 1852
    :pswitch_4
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getNumberOfPeriods()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    int-to-long v4, v4

    const-wide/32 v12, 0x240c8400

    mul-long/2addr v4, v12

    .line 1853
    goto/16 :goto_3

    .line 1855
    :pswitch_5
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getNumberOfPeriods()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    int-to-long v4, v4

    const-wide v12, 0x9a7ec800L

    mul-long/2addr v4, v12

    .line 1856
    goto/16 :goto_3

    .line 1858
    :pswitch_6
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getNumberOfPeriods()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    int-to-long v4, v4

    const-wide v12, 0x757b12c00L

    mul-long/2addr v4, v12

    goto/16 :goto_3

    .line 1871
    :pswitch_7
    const/16 v5, 0xc

    const/4 v11, 0x0

    invoke-virtual {v4, v5, v11}, Ljava/util/Calendar;->set(II)V

    goto/16 :goto_4

    .line 1874
    :pswitch_8
    const/16 v5, 0xa

    const/4 v11, 0x0

    invoke-virtual {v4, v5, v11}, Ljava/util/Calendar;->set(II)V

    .line 1875
    const/16 v5, 0xc

    const/4 v11, 0x0

    invoke-virtual {v4, v5, v11}, Ljava/util/Calendar;->set(II)V

    goto/16 :goto_4

    .line 1878
    :pswitch_9
    const/4 v5, 0x7

    const/4 v11, 0x1

    invoke-virtual {v4, v5, v11}, Ljava/util/Calendar;->set(II)V

    .line 1879
    const/16 v5, 0xa

    const/4 v11, 0x0

    invoke-virtual {v4, v5, v11}, Ljava/util/Calendar;->set(II)V

    .line 1880
    const/16 v5, 0xc

    const/4 v11, 0x0

    invoke-virtual {v4, v5, v11}, Ljava/util/Calendar;->set(II)V

    goto/16 :goto_4

    .line 1883
    :pswitch_a
    const/4 v5, 0x5

    const/4 v11, 0x1

    invoke-virtual {v4, v5, v11}, Ljava/util/Calendar;->set(II)V

    .line 1884
    const/16 v5, 0xa

    const/4 v11, 0x0

    invoke-virtual {v4, v5, v11}, Ljava/util/Calendar;->set(II)V

    .line 1885
    const/16 v5, 0xc

    const/4 v11, 0x0

    invoke-virtual {v4, v5, v11}, Ljava/util/Calendar;->set(II)V

    goto/16 :goto_4

    .line 1888
    :pswitch_b
    const/4 v5, 0x2

    const/4 v11, 0x0

    invoke-virtual {v4, v5, v11}, Ljava/util/Calendar;->set(II)V

    .line 1889
    const/4 v5, 0x5

    const/4 v11, 0x1

    invoke-virtual {v4, v5, v11}, Ljava/util/Calendar;->set(II)V

    .line 1890
    const/16 v5, 0xa

    const/4 v11, 0x0

    invoke-virtual {v4, v5, v11}, Ljava/util/Calendar;->set(II)V

    .line 1891
    const/16 v5, 0xc

    const/4 v11, 0x0

    invoke-virtual {v4, v5, v11}, Ljava/util/Calendar;->set(II)V

    goto/16 :goto_4

    .line 1915
    :cond_15
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getEntryTime()Ljava/lang/Long;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Long;->longValue()J

    move-result-wide v12

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getLoiterSeconds()Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Integer;->intValue()I

    move-result v11

    int-to-long v14, v11

    const-wide/16 v16, 0x3e8

    mul-long v14, v14, v16

    add-long/2addr v12, v14

    cmp-long v4, v4, v12

    if-lez v4, :cond_1c

    .line 1916
    sget-object v4, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v10, v4}, Lcom/exacttarget/etpushsdk/data/Message;->setHasEntered(Ljava/lang/Boolean;)V

    .line 1926
    :cond_16
    :goto_5
    invoke-static {v10}, Lcom/exacttarget/etpushsdk/database/e;->c(Lcom/exacttarget/etpushsdk/data/Message;)I

    .line 1928
    new-instance v5, Landroid/content/Intent;

    const-string v4, "com.google.android.c2dm.intent.RECEIVE"

    invoke-direct {v5, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 1929
    sget-object v4, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v5, v4}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 1930
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getCategory()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_17

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getCategory()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    if-lez v4, :cond_17

    .line 1931
    const-string v4, "category"

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getCategory()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v5, v4, v11}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1933
    :cond_17
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getOpenDirect()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_18

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getOpenDirect()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    if-lez v4, :cond_18

    .line 1934
    const-string v4, "_od"

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getOpenDirect()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v5, v4, v11}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1936
    :cond_18
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getContentType()Ljava/lang/Integer;

    move-result-object v4

    if-eqz v4, :cond_19

    sget-object v4, Lcom/exacttarget/etpushsdk/data/Message;->j:Ljava/lang/Integer;

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getContentType()Ljava/lang/Integer;

    move-result-object v11

    invoke-virtual {v4, v11}, Ljava/lang/Integer;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_19

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getUrl()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_19

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getUrl()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    if-lez v4, :cond_19

    .line 1938
    const-string v4, "_x"

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getUrl()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v5, v4, v11}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1940
    :cond_19
    const-string v4, "_m"

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getId()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v5, v4, v11}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1941
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getSubject()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_1a

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getSubject()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    const/4 v11, -0x1

    if-le v4, v11, :cond_1a

    .line 1943
    const-string v4, "alert"

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getSubject()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v5, v4, v11}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1945
    :cond_1a
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getSound()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_1b

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getSound()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    if-lez v4, :cond_1b

    .line 1946
    const-string v4, "sound"

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getSound()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v5, v4, v11}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1948
    :cond_1b
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getKeys()Ljava/util/ArrayList;

    move-result-object v4

    if-eqz v4, :cond_1e

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getKeys()Ljava/util/ArrayList;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v4

    if-lez v4, :cond_1e

    .line 1949
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getKeys()Ljava/util/ArrayList;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v11

    :goto_6
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1e

    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/exacttarget/etpushsdk/data/Attribute;

    .line 1950
    invoke-virtual {v4}, Lcom/exacttarget/etpushsdk/data/Attribute;->getKey()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v4}, Lcom/exacttarget/etpushsdk/data/Attribute;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v5, v12, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_6

    .line 1918
    :cond_1c
    const-string v4, "~!ETPush"

    const-string v5, "Entered, but loiteringTime has not yet triggered."

    invoke-static {v4, v5}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_2

    .line 1923
    :cond_1d
    sget-object v4, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v10, v4}, Lcom/exacttarget/etpushsdk/data/Message;->setHasEntered(Ljava/lang/Boolean;)V

    goto/16 :goto_5

    .line 1953
    :cond_1e
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getCustom()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_1f

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getCustom()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    if-lez v4, :cond_1f

    .line 1954
    const-string v4, "custom"

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getCustom()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v5, v4, v11}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1958
    :cond_1f
    const-string v4, "transitionType"

    move/from16 v0, p2

    invoke-virtual {v5, v4, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 1959
    const-string v4, "regionId"

    move-object/from16 v0, p1

    invoke-virtual {v5, v4, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1961
    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v8, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1963
    const-string v4, "~!ETPush"

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "Sending broadcast Intent to display fence/proximity message: "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v10}, Lcom/exacttarget/etpushsdk/data/Message;->getId()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v11, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-static {v4, v10}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1964
    sget-object v4, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    invoke-virtual {v4, v5}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    goto/16 :goto_2

    .line 1968
    :cond_20
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->f()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v8}, Ljava/util/List;->size()I

    move-result v4

    if-lez v4, :cond_0

    .line 1969
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETAnalytics;->a()Lcom/exacttarget/etpushsdk/ETAnalytics;

    move-result-object v4

    move-object/from16 v0, p1

    move/from16 v1, p2

    move/from16 v2, p3

    invoke-virtual {v4, v0, v1, v2, v8}, Lcom/exacttarget/etpushsdk/ETAnalytics;->a(Ljava/lang/String;IILjava/util/List;)V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_1

    goto/16 :goto_0

    .line 1736
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
    .end packed-switch

    .line 1844
    :pswitch_data_1
    .packed-switch 0x1
        :pswitch_6
        :pswitch_5
        :pswitch_4
        :pswitch_3
        :pswitch_2
    .end packed-switch

    .line 1869
    :pswitch_data_2
    .packed-switch 0x1
        :pswitch_b
        :pswitch_a
        :pswitch_9
        :pswitch_8
        :pswitch_7
    .end packed-switch
.end method

.method public addAttribute(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 1468
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1469
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->i:Lcom/exacttarget/etpushsdk/data/Registration;

    new-instance v1, Lcom/exacttarget/etpushsdk/data/Attribute;

    invoke-direct {v1, p1, p2}, Lcom/exacttarget/etpushsdk/data/Attribute;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/Registration;->addAttribute(Lcom/exacttarget/etpushsdk/data/Attribute;)V

    .line 1472
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->f()V

    .line 1474
    :cond_0
    return-void
.end method

.method public addTag(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 1507
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1508
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->i:Lcom/exacttarget/etpushsdk/data/Registration;

    invoke-virtual {v0, p1}, Lcom/exacttarget/etpushsdk/data/Registration;->addTag(Ljava/lang/String;)V

    .line 1511
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->f()V

    .line 1513
    :cond_0
    return-void
.end method

.method public declared-synchronized disablePush()V
    .locals 6

    .prologue
    .line 1406
    monitor-enter p0

    :try_start_0
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1407
    sget-object v1, Lcom/exacttarget/etpushsdk/ETPush;->b:Ljava/lang/Object;

    monitor-enter v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 1408
    const/4 v0, 0x0

    :try_start_1
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/ETPush;->h:Ljava/lang/Boolean;

    .line 1409
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->i:Lcom/exacttarget/etpushsdk/data/Registration;

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/exacttarget/etpushsdk/data/Registration;->setPushEnabled(Ljava/lang/Boolean;)V

    .line 1410
    new-instance v0, Ljava/lang/Thread;

    new-instance v2, Lcom/exacttarget/etpushsdk/q;

    invoke-direct {v2, p0}, Lcom/exacttarget/etpushsdk/q;-><init>(Lcom/exacttarget/etpushsdk/ETPush;)V

    invoke-direct {v0, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 1431
    sget-object v2, Lcom/exacttarget/etpushsdk/ETPush;->d:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v2}, Ljava/util/concurrent/CountDownLatch;->getCount()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-nez v2, :cond_1

    .line 1432
    const-string v2, "~!ETPush"

    const-string v3, "enablePushThread is not running.  So continue with disabling push."

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1433
    new-instance v2, Ljava/util/concurrent/CountDownLatch;

    const/4 v3, 0x1

    invoke-direct {v2, v3}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    sput-object v2, Lcom/exacttarget/etpushsdk/ETPush;->d:Ljava/util/concurrent/CountDownLatch;

    .line 1434
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 1453
    :goto_0
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1455
    :cond_0
    monitor-exit p0

    return-void

    .line 1437
    :cond_1
    :try_start_2
    new-instance v2, Ljava/lang/Thread;

    new-instance v3, Lcom/exacttarget/etpushsdk/r;

    invoke-direct {v3, p0, v0}, Lcom/exacttarget/etpushsdk/r;-><init>(Lcom/exacttarget/etpushsdk/ETPush;Ljava/lang/Thread;)V

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    goto :goto_0

    .line 1453
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :try_start_3
    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 1406
    :catchall_1
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized enablePush()V
    .locals 6

    .prologue
    .line 1330
    monitor-enter p0

    :try_start_0
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1331
    sget-object v1, Lcom/exacttarget/etpushsdk/ETPush;->b:Ljava/lang/Object;

    monitor-enter v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 1333
    const/4 v0, 0x1

    :try_start_1
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/ETPush;->h:Ljava/lang/Boolean;

    .line 1334
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->i:Lcom/exacttarget/etpushsdk/data/Registration;

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/exacttarget/etpushsdk/data/Registration;->setPushEnabled(Ljava/lang/Boolean;)V

    .line 1336
    new-instance v0, Ljava/lang/Thread;

    new-instance v2, Lcom/exacttarget/etpushsdk/z;

    invoke-direct {v2, p0}, Lcom/exacttarget/etpushsdk/z;-><init>(Lcom/exacttarget/etpushsdk/ETPush;)V

    invoke-direct {v0, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 1357
    sget-object v2, Lcom/exacttarget/etpushsdk/ETPush;->d:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v2}, Ljava/util/concurrent/CountDownLatch;->getCount()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-nez v2, :cond_1

    .line 1358
    const-string v2, "~!ETPush"

    const-string v3, "disablePushThread is not running.  So continue with enabling push."

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1359
    new-instance v2, Ljava/util/concurrent/CountDownLatch;

    const/4 v3, 0x1

    invoke-direct {v2, v3}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    sput-object v2, Lcom/exacttarget/etpushsdk/ETPush;->d:Ljava/util/concurrent/CountDownLatch;

    .line 1360
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 1379
    :goto_0
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 1381
    :cond_0
    monitor-exit p0

    return-void

    .line 1363
    :cond_1
    :try_start_2
    new-instance v2, Ljava/lang/Thread;

    new-instance v3, Lcom/exacttarget/etpushsdk/p;

    invoke-direct {v3, p0, v0}, Lcom/exacttarget/etpushsdk/p;-><init>(Lcom/exacttarget/etpushsdk/ETPush;Ljava/lang/Thread;)V

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    goto :goto_0

    .line 1379
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :try_start_3
    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 1330
    :catchall_1
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getAttributes()Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 1496
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->i:Lcom/exacttarget/etpushsdk/data/Registration;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Registration;->getAttributes()Ljava/util/ArrayList;

    move-result-object v0

    return-object v0
.end method

.method public getCloudPageRecipient()Ljava/lang/Class;
    .locals 1
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 1654
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->q:Ljava/lang/Class;

    return-object v0
.end method

.method public getNotificationAction()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1673
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->r:Ljava/lang/String;

    return-object v0
.end method

.method public getNotificationActionUri()Landroid/net/Uri;
    .locals 1

    .prologue
    .line 1692
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->s:Landroid/net/Uri;

    return-object v0
.end method

.method public getOpenDirectRecipient()Ljava/lang/Class;
    .locals 1

    .prologue
    .line 1634
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->p:Ljava/lang/Class;

    return-object v0
.end method

.method public getSystemToken()Ljava/lang/String;
    .locals 1

    .prologue
    .line 1611
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->i:Lcom/exacttarget/etpushsdk/data/Registration;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Registration;->getSystemTokenFromCache()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTags()Ljava/util/TreeSet;
    .locals 1

    .prologue
    .line 1533
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->i:Lcom/exacttarget/etpushsdk/data/Registration;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Registration;->getTags()Ljava/util/TreeSet;

    move-result-object v0

    return-object v0
.end method

.method protected i()V
    .locals 2

    .prologue
    .line 1260
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/b;->a(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1262
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/ETPush;->E()V

    .line 1269
    :goto_0
    return-void

    .line 1263
    :cond_0
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/j;->a(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1264
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/ETPush;->B()V

    goto :goto_0

    .line 1266
    :cond_1
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->A()V

    .line 1267
    new-instance v0, Lcom/exacttarget/etpushsdk/ETException;

    const-string v1, "Unable to continue.  Neither Google Services nor Amazon Device Messaging is available"

    invoke-direct {v0, v1}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public isPushEnabled()Z
    .locals 3

    .prologue
    .line 1309
    :try_start_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->c()V

    .line 1311
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->h:Ljava/lang/Boolean;

    if-nez v0, :cond_0

    .line 1312
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->z()Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/ETPush;->h:Ljava/lang/Boolean;
    :try_end_0
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_0 .. :try_end_0} :catch_0

    .line 1319
    :cond_0
    :goto_0
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->h:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    return v0

    .line 1314
    :catch_0
    move-exception v0

    .line 1315
    const-string v1, "~!ETPush"

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 1316
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/ETPush;->h:Ljava/lang/Boolean;

    goto :goto_0
.end method

.method protected j()Z
    .locals 1

    .prologue
    .line 1393
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/j;->a(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/b;->a(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onEvent(Lcom/exacttarget/etpushsdk/event/RegistrationEvent;)V
    .locals 6

    .prologue
    const/4 v5, 0x0

    const/4 v4, 0x1

    .line 1551
    const-string v0, "~!ETPush"

    const-string v1, "onEvent(final RegistrationEvent event){ event.getId(); } // ID = %d"

    new-array v2, v4, [Ljava/lang/Object;

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->getId()Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1552
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->getId()Ljava/lang/Integer;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->getId()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    if-lez v0, :cond_0

    .line 1554
    :try_start_0
    const-string v0, "id <= ?"

    .line 1555
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->getId()Ljava/lang/Integer;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    .line 1556
    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/database/h;->a(Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    .line 1558
    if-lt v0, v4, :cond_1

    .line 1559
    const-string v0, "~!ETPush"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "success, removed sent registration id from db: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/RegistrationEvent;->getId()Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1567
    :cond_0
    :goto_0
    return-void

    .line 1561
    :cond_1
    const-string v1, "~!ETPush"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Error: rowsUpdated = "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1563
    :catch_0
    move-exception v0

    .line 1564
    const-string v1, "~!ETPush"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public removeAttribute(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 1484
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1485
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->i:Lcom/exacttarget/etpushsdk/data/Registration;

    new-instance v1, Lcom/exacttarget/etpushsdk/data/Attribute;

    const-string v2, ""

    invoke-direct {v1, p1, v2}, Lcom/exacttarget/etpushsdk/data/Attribute;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/Registration;->removeAttribute(Lcom/exacttarget/etpushsdk/data/Attribute;)V

    .line 1488
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->f()V

    .line 1490
    :cond_0
    return-void
.end method

.method public removeTag(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 1521
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1522
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->i:Lcom/exacttarget/etpushsdk/data/Registration;

    invoke-virtual {v0, p1}, Lcom/exacttarget/etpushsdk/data/Registration;->removeTag(Ljava/lang/String;)V

    .line 1525
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->f()V

    .line 1527
    :cond_0
    return-void
.end method

.method public setCloudPageRecipient(Ljava/lang/Class;)V
    .locals 1

    .prologue
    .line 1664
    const/4 v0, 0x1

    invoke-static {p1, v0}, Lcom/exacttarget/etpushsdk/ETPush;->c(Ljava/lang/Class;Z)V

    .line 1665
    return-void
.end method

.method public setNotificationAction(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 1683
    const/4 v0, 0x1

    invoke-static {p1, v0}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/lang/String;Z)V

    .line 1684
    return-void
.end method

.method public setNotificationActionUri(Landroid/net/Uri;)V
    .locals 1

    .prologue
    .line 1702
    const/4 v0, 0x1

    invoke-static {p1, v0}, Lcom/exacttarget/etpushsdk/ETPush;->a(Landroid/net/Uri;Z)V

    .line 1703
    return-void
.end method

.method public setNotificationRecipientClass(Ljava/lang/Class;)V
    .locals 1

    .prologue
    .line 1146
    const/4 v0, 0x1

    invoke-static {p1, v0}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/lang/Class;Z)V

    .line 1147
    return-void
.end method

.method public setNotificationResourceId(Ljava/lang/Integer;)V
    .locals 1

    .prologue
    .line 1175
    const/4 v0, 0x1

    invoke-static {p1, v0}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/lang/Integer;Z)V

    .line 1176
    return-void
.end method

.method public setOpenDirectRecipient(Ljava/lang/Class;)V
    .locals 1

    .prologue
    .line 1644
    const/4 v0, 0x1

    invoke-static {p1, v0}, Lcom/exacttarget/etpushsdk/ETPush;->b(Ljava/lang/Class;Z)V

    .line 1645
    return-void
.end method

.method public setSubscriberKey(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 1542
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->f:Landroid/content/Context;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 1543
    sget-object v0, Lcom/exacttarget/etpushsdk/ETPush;->i:Lcom/exacttarget/etpushsdk/data/Registration;

    invoke-virtual {v0, p1}, Lcom/exacttarget/etpushsdk/data/Registration;->setSubscriberKey(Ljava/lang/String;)V

    .line 1546
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->f()V

    .line 1548
    :cond_0
    return-void
.end method
