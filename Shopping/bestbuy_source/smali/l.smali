.class public Ll;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field static volatile a:Lab;

.field static volatile b:Ls;

.field static volatile c:Ll;

.field static volatile d:Lb$1;

.field static volatile e:Z

.field static final f:Lbg;

.field static final g:Lg;

.field static final h:Lbi;

.field private static p:Lav;

.field private static q:Lf;


# instance fields
.field final i:Lbk;

.field final j:Lax;

.field final k:Lao;

.field final l:Lbf;

.field final m:Landroid/content/Context;

.field final n:Lam;

.field final o:La;

.field private volatile r:Ljava/lang/String;

.field private s:Laa;

.field private t:Ljava/util/concurrent/ScheduledExecutorService;

.field private u:Lag;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 141
    const/4 v0, 0x0

    sput-object v0, Ll;->c:Ll;

    .line 143
    const/4 v0, 0x0

    sput-boolean v0, Ll;->e:Z

    .line 144
    new-instance v0, Lbg;

    invoke-direct {v0}, Lbg;-><init>()V

    sput-object v0, Ll;->f:Lbg;

    .line 145
    new-instance v0, Lg;

    invoke-direct {v0}, Lg;-><init>()V

    sput-object v0, Ll;->g:Lg;

    .line 148
    new-instance v0, Lbi;

    invoke-direct {v0}, Lbi;-><init>()V

    sput-object v0, Ll;->h:Lbi;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;Lao;Laa;Lbk;Lax;Lbf;Landroid/content/Context;Lam;Ljava/util/concurrent/ScheduledExecutorService;Lag;Lae;La;)V
    .locals 0

    .prologue
    .line 542
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 543
    iput-object p1, p0, Ll;->r:Ljava/lang/String;

    .line 544
    iput-object p2, p0, Ll;->k:Lao;

    .line 545
    iput-object p3, p0, Ll;->s:Laa;

    .line 546
    iput-object p4, p0, Ll;->i:Lbk;

    .line 547
    iput-object p5, p0, Ll;->j:Lax;

    .line 548
    iput-object p6, p0, Ll;->l:Lbf;

    .line 549
    iput-object p7, p0, Ll;->m:Landroid/content/Context;

    .line 550
    iput-object p8, p0, Ll;->n:Lam;

    .line 551
    iput-object p9, p0, Ll;->t:Ljava/util/concurrent/ScheduledExecutorService;

    .line 552
    iput-object p10, p0, Ll;->u:Lag;

    .line 553
    iput-object p12, p0, Ll;->o:La;

    .line 555
    return-void
.end method

.method synthetic constructor <init>(Ljava/lang/String;Lao;Laa;Lbk;Lax;Lbf;Landroid/content/Context;Lam;Ljava/util/concurrent/ScheduledExecutorService;Lag;Lae;La;B)V
    .locals 0

    .prologue
    .line 133
    invoke-direct/range {p0 .. p12}, Ll;-><init>(Ljava/lang/String;Lao;Laa;Lbk;Lax;Lbf;Landroid/content/Context;Lam;Ljava/util/concurrent/ScheduledExecutorService;Lag;Lae;La;)V

    return-void
.end method

.method static a(J)V
    .locals 2

    .prologue
    .line 752
    const-wide/16 v0, 0x0

    cmp-long v0, p0, v0

    if-lez v0, :cond_0

    sget-object v0, Ll;->c:Ll;

    if-eqz v0, :cond_0

    .line 753
    sget-object v0, Ll;->c:Ll;

    iget-object v0, v0, Ll;->s:Laa;

    const-string v1, "disable_until"

    invoke-virtual {v0, v1, p0, p1}, Laa;->a(Ljava/lang/String;J)V

    .line 754
    sget-object v0, Ll;->c:Ll;

    iget-object v0, v0, Ll;->s:Laa;

    invoke-virtual {v0}, Laa;->b()V

    .line 756
    :cond_0
    const/4 v0, 0x0

    sput-boolean v0, Ll;->e:Z

    .line 757
    const/4 v0, 0x0

    sput-object v0, Ll;->c:Ll;

    .line 758
    return-void
.end method

.method public static declared-synchronized a(Lb;)V
    .locals 9

    .prologue
    const/4 v1, 0x0

    const/4 v0, 0x1

    .line 244
    const-class v8, Ll;

    monitor-enter v8

    const/4 v2, 0x1

    :try_start_0
    invoke-static {v2}, Lbc;->a(Z)V

    .line 245
    invoke-static {p0}, Ll;->b(Lb;)Ljava/lang/String;

    move-result-object v6

    .line 246
    iget-boolean v2, p0, Lb;->e:Z

    invoke-static {v2}, Lbc;->a(Z)V

    .line 247
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Agent version = 4.1.5.0, agent build = 4a7494a184c449ed1cdc3f18d8c1d70e96674133, appBuildID = "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", starting up with appkey ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lb;->a:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lbc;->a(Ljava/lang/String;)V

    .line 251
    const-string v2, "start called from activity: %s, initializationStarted = %s, instance is null = %s"

    const/4 v3, 0x3

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lb;->b:Landroid/content/Context;

    invoke-virtual {v5}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x1

    sget-boolean v5, Ll;->e:Z

    invoke-static {v5}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    aput-object v5, v3, v4

    const/4 v4, 0x2

    sget-object v5, Ll;->c:Ll;

    if-nez v5, :cond_1

    :goto_0
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    aput-object v0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    .line 260
    sget-object v0, Ll;->c:Ll;

    if-nez v0, :cond_2

    sget-boolean v0, Ll;->e:Z

    if-nez v0, :cond_2

    .line 261
    new-instance v0, Lab;

    invoke-direct {v0}, Lab;-><init>()V

    sput-object v0, Ll;->a:Lab;

    .line 263
    new-instance v0, Lb$1;

    iget-object v1, p0, Lb;->b:Landroid/content/Context;

    invoke-direct {v0, v1, v6}, Lb$1;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    sput-object v0, Ll;->d:Lb$1;

    .line 264
    sget-object v0, Ll;->g:Lg;

    iget-object v1, p0, Lb;->b:Landroid/content/Context;

    invoke-virtual {v0, v1}, Lg;->a(Landroid/content/Context;)V

    .line 266
    new-instance v0, Ls;

    const-wide/16 v2, 0x7d0

    sget-object v1, Ll;->a:Lab;

    invoke-direct {v0, v2, v3, v1}, Ls;-><init>(JLab;)V

    .line 267
    sput-object v0, Ll;->b:Ls;

    invoke-virtual {v0}, Ls;->start()V

    .line 269
    new-instance v3, Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    const/4 v0, 0x1

    new-instance v1, Ll$1;

    invoke-direct {v1}, Ll$1;-><init>()V

    new-instance v2, Ljava/util/concurrent/ThreadPoolExecutor$DiscardPolicy;

    invoke-direct {v2}, Ljava/util/concurrent/ThreadPoolExecutor$DiscardPolicy;-><init>()V

    invoke-direct {v3, v0, v1, v2}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;-><init>(ILjava/util/concurrent/ThreadFactory;Ljava/util/concurrent/RejectedExecutionHandler;)V

    .line 270
    new-instance v0, Lav;

    iget-object v1, p0, Lb;->b:Landroid/content/Context;

    invoke-static {}, Ljava/lang/Thread;->getDefaultUncaughtExceptionHandler()Ljava/lang/Thread$UncaughtExceptionHandler;

    move-result-object v2

    invoke-direct {v0, v1, v3, v2}, Lav;-><init>(Landroid/content/Context;Ljava/util/concurrent/ScheduledExecutorService;Ljava/lang/Thread$UncaughtExceptionHandler;)V

    .line 273
    sput-object v0, Ll;->p:Lav;

    invoke-static {v0}, Ljava/lang/Thread;->setDefaultUncaughtExceptionHandler(Ljava/lang/Thread$UncaughtExceptionHandler;)V

    .line 274
    iget-object v0, p0, Lb;->f:Lf;

    sput-object v0, Ll;->q:Lf;

    .line 275
    const/4 v0, 0x1

    sput-boolean v0, Ll;->e:Z

    .line 276
    new-instance v0, Ln;

    iget-object v1, p0, Lb;->a:Ljava/lang/String;

    iget-object v2, p0, Lb;->b:Landroid/content/Context;

    iget-object v4, p0, Lb;->c:Ljava/lang/String;

    iget-object v5, p0, Lb;->d:Ljava/lang/String;

    const/4 v7, 0x0

    invoke-direct/range {v0 .. v7}, Ln;-><init>(Ljava/lang/String;Landroid/content/Context;Ljava/util/concurrent/ScheduledExecutorService;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;B)V

    invoke-interface {v3, v0}, Ljava/util/concurrent/ScheduledExecutorService;->execute(Ljava/lang/Runnable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 288
    :cond_0
    monitor-exit v8

    return-void

    :cond_1
    move v0, v1

    .line 251
    goto :goto_0

    .line 282
    :cond_2
    :try_start_1
    sget-object v0, Ll;->c:Ll;

    if-eqz v0, :cond_0

    sget-object v0, Ll;->c:Ll;

    iget-object v0, v0, Ll;->r:Ljava/lang/String;

    iget-object v1, p0, Lb;->a:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 286
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Instrumentation framework was already initialized with a different key"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 244
    :catchall_0
    move-exception v0

    monitor-exit v8

    throw v0
.end method

.method private static a(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 584
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_1

    .line 585
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "AppKey cannot be null or empty"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 587
    :cond_1
    const-string v0, "[a-zA-Z0-9]{1,}(-[A-Z]{3}){2,}"

    invoke-static {v0, p0}, Ljava/util/regex/Pattern;->matches(Ljava/lang/String;Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 588
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "AppKey is malformed: "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", it should look like: AD-AAA-BBB"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 590
    :cond_2
    return-void
.end method

.method public static a(Ljava/lang/String;Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 175
    invoke-static {}, Lb;->a()Lc;

    move-result-object v0

    invoke-virtual {v0, p0}, Lc;->a(Ljava/lang/String;)Lc;

    move-result-object v0

    invoke-virtual {v0, p1}, Lc;->a(Landroid/content/Context;)Lc;

    move-result-object v0

    invoke-virtual {v0}, Lc;->a()Lb;

    move-result-object v0

    invoke-static {v0}, Ll;->a(Lb;)V

    .line 179
    return-void
.end method

.method static synthetic b()Lav;
    .locals 1

    .prologue
    .line 133
    sget-object v0, Ll;->p:Lav;

    return-object v0
.end method

.method private static b(Lb;)Ljava/lang/String;
    .locals 6

    .prologue
    .line 291
    iget-object v0, p0, Lb;->a:Ljava/lang/String;

    invoke-static {v0}, Ll;->a(Ljava/lang/String;)V

    .line 293
    :try_start_0
    new-instance v0, Ljava/net/URL;

    iget-object v1, p0, Lb;->c:Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 298
    iget-object v0, p0, Lb;->b:Landroid/content/Context;

    if-nez v0, :cond_0

    .line 299
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Context cannot be null!"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 294
    :catch_0
    move-exception v0

    .line 295
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "["

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lb;->c:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "] is not a valid collector url."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1

    .line 302
    :cond_0
    iget-boolean v0, p0, Lb;->g:Z

    if-nez v0, :cond_1

    .line 303
    const-string v0, "WARNING: Compile time instrumentation check is disabled."

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    .line 304
    const/4 v0, 0x0

    .line 314
    :goto_0
    return-object v0

    .line 309
    :cond_1
    :try_start_1
    const-string v0, "com.appdynamics.eumagent.runtime.BuildInfo"

    invoke-static {v0}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    .line 310
    invoke-virtual {v0}, Ljava/lang/Class;->getDeclaredFields()[Ljava/lang/reflect/Field;

    move-result-object v1

    array-length v2, v1

    const/4 v0, 0x0

    :goto_1
    if-ge v0, v2, :cond_3

    aget-object v3, v1, v0

    .line 311
    invoke-virtual {v3}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v4

    const-string v5, "appdynamicsGeneratedBuildId_"

    invoke-virtual {v4, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 312
    invoke-virtual {v3}, Ljava/lang/reflect/Field;->getName()Ljava/lang/String;

    move-result-object v0

    const/16 v1, 0x1c

    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    .line 313
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "APK\'s build id = "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lbc;->a(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/lang/ClassNotFoundException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_0

    .line 323
    :catch_1
    move-exception v0

    .line 324
    const-string v1, "App not instrumented!"

    invoke-static {v1, v0}, Lbc;->b(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 325
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Unable to start Appdynamics\' android agent. Your application doesn\'t seem to be instrumented by AppDynamics\'s compile time instrumentation. Please ensure that you have configured your build system (ant/gradle/maven) to run AppDynamics\' instrumentation. For more information please consult the documentation."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 310
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 319
    :cond_3
    :try_start_2
    const-string v0, "BuildInfo class exists, but no field beginning with prefix: appdynamicsGeneratedBuildId_"

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    .line 321
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Application has to be instrumented before calling Instrumentation.start()"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_2
    .catch Ljava/lang/ClassNotFoundException; {:try_start_2 .. :try_end_2} :catch_1
.end method

.method static synthetic c()Lf;
    .locals 1

    .prologue
    .line 133
    sget-object v0, Ll;->q:Lf;

    return-object v0
.end method


# virtual methods
.method final a()V
    .locals 1

    .prologue
    .line 558
    iget-object v0, p0, Ll;->t:Ljava/util/concurrent/ScheduledExecutorService;

    invoke-interface {v0}, Ljava/util/concurrent/ScheduledExecutorService;->isShutdown()Z

    move-result v0

    if-nez v0, :cond_0

    .line 559
    const-string v0, "Shutting down executor pool and anr detector."

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    .line 560
    sget-object v0, Ll;->b:Ls;

    invoke-virtual {v0}, Ls;->a()V

    .line 561
    iget-object v0, p0, Ll;->t:Ljava/util/concurrent/ScheduledExecutorService;

    invoke-interface {v0}, Ljava/util/concurrent/ScheduledExecutorService;->shutdownNow()Ljava/util/List;

    .line 563
    :cond_0
    return-void
.end method
