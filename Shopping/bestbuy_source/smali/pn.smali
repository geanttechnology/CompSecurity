.class public Lpn;
.super Ljava/lang/Object;


# static fields
.field private static a:Lpk;

.field private static volatile b:Z

.field private static c:Lpl;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/4 v0, 0x0

    sput-boolean v0, Lpn;->b:Z

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static a()Lpl;
    .locals 2

    const-class v1, Lpn;

    monitor-enter v1

    :try_start_0
    sget-boolean v0, Lpn;->b:Z

    if-eqz v0, :cond_1

    sget-object v0, Lpn;->c:Lpl;

    if-nez v0, :cond_0

    new-instance v0, Lpo;

    invoke-direct {v0}, Lpo;-><init>()V

    sput-object v0, Lpn;->c:Lpl;

    :cond_0
    sget-object v0, Lpn;->c:Lpl;

    monitor-exit v1

    :goto_0
    return-object v0

    :cond_1
    sget-object v0, Lpn;->a:Lpk;

    if-nez v0, :cond_2

    invoke-static {}, Lpk;->a()Lpk;

    move-result-object v0

    sput-object v0, Lpn;->a:Lpk;

    :cond_2
    sget-object v0, Lpn;->a:Lpk;

    if-eqz v0, :cond_3

    sget-object v0, Lpn;->a:Lpk;

    invoke-virtual {v0}, Lpk;->b()Lpl;

    move-result-object v0

    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_3
    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static a(Ljava/lang/String;)V
    .locals 1

    invoke-static {}, Lpn;->a()Lpl;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-interface {v0, p0}, Lpl;->b(Ljava/lang/String;)V

    :cond_0
    return-void
.end method

.method public static b(Ljava/lang/String;)V
    .locals 1

    invoke-static {}, Lpn;->a()Lpl;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-interface {v0, p0}, Lpl;->a(Ljava/lang/String;)V

    :cond_0
    return-void
.end method
