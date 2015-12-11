.class public Lcom/exacttarget/etpushsdk/util/m;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static a:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const/4 v0, 0x0

    sput-object v0, Lcom/exacttarget/etpushsdk/util/m;->a:Ljava/lang/String;

    return-void
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;)I
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 50
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->getLogLevel()I

    move-result v1

    const/4 v2, 0x3

    if-gt v1, v2, :cond_0

    .line 51
    invoke-static {p0}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 52
    invoke-static {p1}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 54
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/ETLogger;->getInstance()Lcom/exacttarget/etpushsdk/util/ETLogger;

    move-result-object v3

    new-array v0, v0, [Ljava/lang/Object;

    invoke-virtual {v3, v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/ETLogger;->captureLog(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 56
    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    .line 58
    :cond_0
    return v0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    .locals 5

    .prologue
    const/4 v0, 0x0

    .line 63
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->getLogLevel()I

    move-result v1

    const/4 v2, 0x3

    if-gt v1, v2, :cond_0

    .line 64
    invoke-static {p0}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 65
    invoke-static {p1}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 67
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/ETLogger;->getInstance()Lcom/exacttarget/etpushsdk/util/ETLogger;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    aput-object p2, v4, v0

    invoke-virtual {v3, v1, v2, v4}, Lcom/exacttarget/etpushsdk/util/ETLogger;->captureLog(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 69
    invoke-static {v1, v2, p2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    move-result v0

    .line 71
    :cond_0
    return v0
.end method

.method private static a(Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 220
    const-string v0, "%-25s"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p0, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static b(Ljava/lang/String;Ljava/lang/String;)I
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 76
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->getLogLevel()I

    move-result v1

    const/4 v2, 0x4

    if-gt v1, v2, :cond_0

    .line 77
    invoke-static {p0}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 78
    invoke-static {p1}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 80
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/ETLogger;->getInstance()Lcom/exacttarget/etpushsdk/util/ETLogger;

    move-result-object v3

    new-array v0, v0, [Ljava/lang/Object;

    invoke-virtual {v3, v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/ETLogger;->captureLog(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 82
    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    .line 84
    :cond_0
    return v0
.end method

.method public static b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    .locals 5

    .prologue
    const/4 v0, 0x0

    .line 127
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->getLogLevel()I

    move-result v1

    const/4 v2, 0x5

    if-gt v1, v2, :cond_0

    .line 128
    invoke-static {p0}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 129
    invoke-static {p1}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 131
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/ETLogger;->getInstance()Lcom/exacttarget/etpushsdk/util/ETLogger;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    aput-object p2, v4, v0

    invoke-virtual {v3, v1, v2, v4}, Lcom/exacttarget/etpushsdk/util/ETLogger;->captureLog(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 133
    invoke-static {v1, v2, p2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    move-result v0

    .line 135
    :cond_0
    return v0
.end method

.method private static b(Ljava/lang/String;)Ljava/lang/String;
    .locals 9

    .prologue
    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 228
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 249
    :cond_0
    :goto_0
    return-object p0

    .line 231
    :cond_1
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->c()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 234
    const-string v0, "\n"

    .line 236
    new-instance v1, Ljava/lang/StringBuilder;

    const/16 v2, 0x40

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(I)V

    .line 237
    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "ET PUSH SDK VERSION: %1$s build %2$d"

    new-array v4, v8, [Ljava/lang/Object;

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/o;->a()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/o;->b()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v7

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "APP VERSION: %1$s : %2$s"

    new-array v4, v8, [Ljava/lang/Object;

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/n;->b()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/n;->a()I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v7

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "readyAimFire() Initialized with: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "Context: %1$s"

    new-array v4, v7, [Ljava/lang/Object;

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "ET App Id: %1$s"

    new-array v4, v7, [Ljava/lang/Object;

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->b()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "Access Token: %1$s"

    new-array v4, v7, [Ljava/lang/Object;

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->c()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "GCM Sender ID: %1$s"

    new-array v4, v7, [Ljava/lang/Object;

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->d()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "Analytics: %1$s"

    new-array v4, v7, [Ljava/lang/Object;

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->f()Z

    move-result v5

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "PIAnalytics: %1$s"

    new-array v4, v7, [Ljava/lang/Object;

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->g()Z

    move-result v5

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "Location: %1$s"

    new-array v4, v7, [Ljava/lang/Object;

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->h()Z

    move-result v5

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "CloudPages: %1$s"

    new-array v4, v7, [Ljava/lang/Object;

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->j()Z

    move-result v5

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 249
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p0

    goto/16 :goto_0
.end method

.method public static c(Ljava/lang/String;Ljava/lang/String;)I
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 114
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->getLogLevel()I

    move-result v1

    const/4 v2, 0x5

    if-gt v1, v2, :cond_0

    .line 115
    invoke-static {p0}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 116
    invoke-static {p1}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 118
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/ETLogger;->getInstance()Lcom/exacttarget/etpushsdk/util/ETLogger;

    move-result-object v3

    new-array v0, v0, [Ljava/lang/Object;

    invoke-virtual {v3, v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/ETLogger;->captureLog(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 120
    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    .line 122
    :cond_0
    return v0
.end method

.method public static c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    .locals 5

    .prologue
    const/4 v0, 0x0

    .line 153
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->getLogLevel()I

    move-result v1

    const/4 v2, 0x6

    if-gt v1, v2, :cond_0

    .line 154
    invoke-static {p0}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 155
    invoke-static {p1}, Lcom/exacttarget/etpushsdk/util/m;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 157
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/ETLogger;->getInstance()Lcom/exacttarget/etpushsdk/util/ETLogger;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    aput-object p2, v4, v0

    invoke-virtual {v3, v1, v2, v4}, Lcom/exacttarget/etpushsdk/util/ETLogger;->captureLog(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 159
    invoke-static {v1, v2, p2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    move-result v0

    .line 161
    :cond_0
    return v0
.end method

.method private static declared-synchronized c(Ljava/lang/String;)Ljava/lang/String;
    .locals 6

    .prologue
    .line 256
    const-class v1, Lcom/exacttarget/etpushsdk/util/m;

    monitor-enter v1

    :try_start_0
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-eqz v0, :cond_0

    .line 282
    :goto_0
    monitor-exit v1

    return-object p0

    .line 260
    :cond_0
    :try_start_1
    sget-object v0, Lcom/exacttarget/etpushsdk/util/m;->a:Ljava/lang/String;

    if-nez v0, :cond_1

    .line 261
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 262
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v0

    .line 263
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v2

    iget-object v2, v2, Landroid/content/pm/ApplicationInfo;->className:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "."

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v3, ""

    invoke-virtual {v2, v0, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/util/m;->a:Ljava/lang/String;

    .line 267
    :cond_1
    sget-object v0, Lcom/exacttarget/etpushsdk/util/m;->a:Ljava/lang/String;

    if-nez v0, :cond_5

    move-object v0, p0

    .line 268
    :goto_1
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->b()Ljava/lang/String;

    move-result-object v2

    .line 269
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->c()Ljava/lang/String;

    move-result-object v3

    .line 270
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->d()Ljava/lang/String;

    move-result-object v4

    .line 272
    if-eqz v2, :cond_2

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 273
    const-string v5, "{et_app_id}"

    invoke-virtual {v0, v2, v5}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 275
    :cond_2
    if-eqz v3, :cond_3

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 276
    const-string v2, "{access_token}"

    invoke-virtual {v0, v3, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 278
    :cond_3
    if-eqz v4, :cond_4

    invoke-virtual {v0, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 279
    const-string v2, "{gcm_sender_id}"

    invoke-virtual {v0, v4, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    :cond_4
    move-object p0, v0

    .line 282
    goto :goto_0

    .line 267
    :cond_5
    const-string v0, "%1$s : %2$s"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    sget-object v4, Lcom/exacttarget/etpushsdk/util/m;->a:Ljava/lang/String;

    aput-object v4, v2, v3

    const/4 v3, 0x1

    aput-object p0, v2, v3

    invoke-static {v0, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v0

    goto :goto_1

    .line 256
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static d(Ljava/lang/String;Ljava/lang/String;)I
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 140
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->getLogLevel()I

    move-result v1

    const/4 v2, 0x6

    if-gt v1, v2, :cond_0

    .line 141
    invoke-static {p0}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 142
    invoke-static {p1}, Lcom/exacttarget/etpushsdk/util/m;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 144
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/ETLogger;->getInstance()Lcom/exacttarget/etpushsdk/util/ETLogger;

    move-result-object v3

    new-array v0, v0, [Ljava/lang/Object;

    invoke-virtual {v3, v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/ETLogger;->captureLog(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 146
    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    .line 148
    :cond_0
    return v0
.end method

.method public static e(Ljava/lang/String;Ljava/lang/String;)I
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 183
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->getLogLevel()I

    move-result v1

    const/4 v2, 0x7

    if-gt v1, v2, :cond_0

    .line 184
    invoke-static {p0}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 185
    invoke-static {p1}, Lcom/exacttarget/etpushsdk/util/m;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 187
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/ETLogger;->getInstance()Lcom/exacttarget/etpushsdk/util/ETLogger;

    move-result-object v3

    new-array v0, v0, [Ljava/lang/Object;

    invoke-virtual {v3, v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/ETLogger;->captureLog(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 189
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x8

    if-lt v0, v3, :cond_1

    .line 190
    invoke-static {v1, v2}, Landroid/util/Log;->wtf(Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    .line 195
    :cond_0
    :goto_0
    return v0

    .line 192
    :cond_1
    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    move-result v0

    goto :goto_0
.end method
