.class Lg;
.super Las;
.source "SourceFile"

# interfaces
.implements Lal;


# static fields
.field private static final k:Ld;


# instance fields
.field a:Ldalvik/system/DexClassLoader;

.field private volatile e:Z

.field private f:Lm;

.field private g:J

.field private h:Lj;

.field private i:Lao;

.field private j:Lag;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 32
    new-instance v0, Lg$1;

    invoke-direct {v0}, Lg$1;-><init>()V

    sput-object v0, Lg;->k:Ld;

    return-void
.end method

.method constructor <init>()V
    .locals 2

    .prologue
    .line 54
    invoke-direct {p0}, Las;-><init>()V

    .line 24
    const/4 v0, 0x0

    iput-boolean v0, p0, Lg;->e:Z

    .line 26
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lg;->g:J

    .line 55
    return-void
.end method

.method static synthetic a(Lg;)J
    .locals 2

    .prologue
    .line 23
    iget-wide v0, p0, Lg;->g:J

    return-wide v0
.end method

.method static synthetic a(Lg;J)J
    .locals 1

    .prologue
    .line 23
    iput-wide p1, p0, Lg;->g:J

    return-wide p1
.end method

.method static synthetic a(Lg;Ljava/lang/ClassLoader;)Lh;
    .locals 1

    .prologue
    .line 23
    invoke-static {p1}, Lg;->a(Ljava/lang/ClassLoader;)Lh;

    move-result-object v0

    return-object v0
.end method

.method private static a(Ljava/lang/ClassLoader;)Lh;
    .locals 1

    .prologue
    .line 231
    const-string v0, "com.appdynamics.eumagent.runtime.InfoPointInitializer"

    invoke-virtual {p0, v0}, Ljava/lang/ClassLoader;->loadClass(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->newInstance()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lh;

    return-object v0
.end method

.method static synthetic a(Lg;Lb$1;)V
    .locals 2

    .prologue
    .line 23
    const-wide/16 v0, -0x1

    invoke-virtual {p1, v0, v1}, Lb$1;->a(J)V

    return-void
.end method

.method static synthetic b(Lg;)Le;
    .locals 1

    .prologue
    .line 23
    invoke-virtual {p0}, Lg;->b()Lm;

    move-result-object v0

    invoke-virtual {v0}, Lm;->c()Le;

    move-result-object v0

    return-object v0
.end method

.method private static e()I
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 59
    :try_start_0
    const-string v1, "com.appdynamics.eumagent.runtime.InfoPointRegister"

    invoke-static {v1}, Ljava/lang/Class;->forName(Ljava/lang/String;)Ljava/lang/Class;

    move-result-object v1

    .line 60
    invoke-virtual {v1}, Ljava/lang/Class;->getFields()[Ljava/lang/reflect/Field;

    move-result-object v1

    .line 61
    if-nez v1, :cond_0

    .line 64
    :goto_0
    return v0

    .line 61
    :cond_0
    array-length v0, v1
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 62
    :catch_0
    move-exception v1

    .line 63
    const-string v2, "Error accessing total number of fields in InfoPointRegister"

    invoke-static {v2, v1}, Lbc;->b(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method


# virtual methods
.method public final a()V
    .locals 1

    .prologue
    .line 158
    iget-object v0, p0, Lg;->h:Lj;

    if-eqz v0, :cond_0

    .line 159
    iget-object v0, p0, Lg;->h:Lj;

    invoke-virtual {v0}, Lj;->a()V

    .line 161
    :cond_0
    return-void
.end method

.method final a(Lag;)V
    .locals 0

    .prologue
    .line 492
    iput-object p1, p0, Lg;->j:Lag;

    .line 493
    return-void
.end method

.method final a(Lah;)V
    .locals 4

    .prologue
    .line 87
    new-instance v0, Lbb;

    invoke-direct {v0}, Lbb;-><init>()V

    invoke-static {}, Lg;->e()I

    move-result v1

    const-string v2, "%d classes support dynamic infopoints."

    invoke-static {v2, v1}, Lbc;->a(Ljava/lang/String;I)V

    if-nez v1, :cond_0

    const-string v0, "This application does not support dynamic infopoints. Scheduler not enabled."

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    .line 88
    :goto_0
    return-void

    .line 87
    :cond_0
    sget-object v1, Ll;->d:Lb$1;

    if-eqz v1, :cond_1

    sget-object v1, Ll;->d:Lb$1;

    invoke-virtual {v1}, Lb$1;->h()Z

    move-result v1

    if-eqz v1, :cond_1

    const-string v0, "Safety flag for dynamic infopoints was not turned off. Disabling Scheduler."

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    iget-object v1, p0, Lg;->h:Lj;

    if-nez v1, :cond_2

    new-instance v1, Lj;

    invoke-direct {v1, p0, v0, p1}, Lj;-><init>(Lg;Lbb;Lah;)V

    iput-object v1, p0, Lg;->h:Lj;

    :cond_2
    iget-object v0, p0, Lg;->h:Lj;

    sget-object v1, Ljava/util/concurrent/TimeUnit;->MINUTES:Ljava/util/concurrent/TimeUnit;

    const-wide/16 v2, 0x3c

    invoke-virtual {v1, v2, v3}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v2

    long-to-int v1, v2

    invoke-virtual {p1, v0, v1}, Lah;->a(Ljava/lang/Runnable;I)V

    iget-object v0, p0, Lg;->h:Lj;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-static {v0, v2, v3}, Lj;->a(Lj;J)J

    goto :goto_0
.end method

.method final a(Landroid/content/Context;)V
    .locals 10

    .prologue
    const-wide/16 v8, -0x1

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 182
    sget-object v1, Ll;->d:Lb$1;

    .line 183
    invoke-virtual {v1}, Lb$1;->c()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 184
    invoke-virtual {v1}, Lb$1;->h()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 185
    const-string v0, "Safety flag for dynamic infopoints was not turned off. Assuming previous attempt to setup failed and disabling all future attempts"

    invoke-static {v0}, Lbc;->a(Ljava/lang/String;)V

    .line 224
    :cond_0
    :goto_0
    return-void

    .line 189
    :cond_1
    invoke-virtual {v1}, Lb$1;->d()J

    move-result-wide v2

    .line 190
    const-wide/16 v4, 0x1

    cmp-long v0, v2, v4

    if-lez v0, :cond_2

    .line 191
    const-string v0, "VersionCounter = %d has exceeded limit of %d. Not initializing info points"

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lbc;->a(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    goto :goto_0

    .line 197
    :cond_2
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 198
    new-instance v0, Lk;

    invoke-virtual {v1}, Lb$1;->e()J

    move-result-wide v4

    invoke-direct {v0, p1, v4, v5, v6}, Lk;-><init>(Landroid/content/Context;JB)V

    .line 199
    iget-object v4, v0, Lk;->c:Ljava/io/File;

    invoke-virtual {v4}, Ljava/io/File;->exists()Z

    move-result v4

    if-nez v4, :cond_3

    .line 200
    const-string v2, "Info point enabled, but dex file %s is missing. Not initializing info points"

    iget-object v0, v0, Lk;->c:Ljava/io/File;

    invoke-static {v2, v0}, Lbc;->a(Ljava/lang/String;Ljava/lang/Object;)V

    .line 201
    invoke-virtual {v1, v8, v9}, Lb$1;->a(J)V

    goto :goto_0

    .line 206
    :cond_3
    const/4 v4, 0x1

    :try_start_0
    invoke-virtual {v1, v4}, Lb$1;->a(Z)V

    .line 207
    new-instance v4, Ldalvik/system/DexClassLoader;

    iget-object v5, v0, Lk;->c:Ljava/io/File;

    invoke-virtual {v5}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v5

    iget-object v0, v0, Lk;->a:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v0

    const/4 v6, 0x0

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v7

    invoke-direct {v4, v5, v0, v6, v7}, Ldalvik/system/DexClassLoader;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/ClassLoader;)V

    iput-object v4, p0, Lg;->a:Ldalvik/system/DexClassLoader;

    .line 214
    iget-object v0, p0, Lg;->a:Ldalvik/system/DexClassLoader;

    invoke-static {v0}, Lg;->a(Ljava/lang/ClassLoader;)Lh;

    move-result-object v0

    .line 215
    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lbc;->a(Ljava/lang/String;)V

    .line 216
    invoke-interface {v0}, Lh;->a()V

    .line 217
    const-string v0, "Total time taken to initialize info points = %s ms."

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    sub-long v2, v4, v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-static {v0, v2}, Lbc;->a(Ljava/lang/String;Ljava/lang/Object;)V

    .line 218
    const/4 v0, 0x0

    invoke-virtual {v1, v0}, Lb$1;->a(Z)V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 219
    :catch_0
    move-exception v0

    .line 220
    const-string v2, "Error setting up info points"

    invoke-static {v2, v0}, Lbc;->b(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 221
    invoke-virtual {v1, v8, v9}, Lb$1;->a(J)V

    goto/16 :goto_0
.end method

.method final a(Lao;)V
    .locals 0

    .prologue
    .line 488
    iput-object p1, p0, Lg;->i:Lao;

    .line 489
    return-void
.end method

.method final declared-synchronized b()Lm;
    .locals 1

    .prologue
    .line 363
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lg;->f:Lm;

    if-nez v0, :cond_0

    .line 364
    sget-object v0, Ll;->c:Ll;

    iget-object v0, v0, Ll;->k:Lao;

    invoke-virtual {v0}, Lao;->a()Laq;

    move-result-object v0

    invoke-virtual {v0}, Laq;->a()Lm;

    move-result-object v0

    iput-object v0, p0, Lg;->f:Lm;

    .line 367
    :cond_0
    iget-object v0, p0, Lg;->f:Lm;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 363
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public final c()Z
    .locals 1

    .prologue
    .line 518
    iget-boolean v0, p0, Lg;->e:Z

    return v0
.end method

.method public final d()V
    .locals 1

    .prologue
    .line 522
    const/4 v0, 0x0

    iput-boolean v0, p0, Lg;->e:Z

    .line 523
    return-void
.end method
