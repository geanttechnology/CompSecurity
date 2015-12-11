.class Larv;
.super Laru;


# static fields
.field private static final a:Ljava/lang/Object;

.field private static k:Larv;


# instance fields
.field private b:Laqs;

.field private volatile c:Laqr;

.field private d:I

.field private e:Z

.field private f:Z

.field private g:Z

.field private h:Z

.field private i:Laqt;

.field private j:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Larv;->a:Ljava/lang/Object;

    return-void
.end method

.method private constructor <init>()V
    .locals 3

    const/4 v2, 0x0

    const/4 v1, 0x1

    invoke-direct {p0}, Laru;-><init>()V

    const v0, 0x1b7740

    iput v0, p0, Larv;->d:I

    iput-boolean v1, p0, Larv;->e:Z

    iput-boolean v2, p0, Larv;->f:Z

    iput-boolean v1, p0, Larv;->g:Z

    iput-boolean v1, p0, Larv;->h:Z

    new-instance v0, Larv$1;

    invoke-direct {v0, p0}, Larv$1;-><init>(Larv;)V

    iput-object v0, p0, Larv;->i:Laqt;

    iput-boolean v2, p0, Larv;->j:Z

    return-void
.end method

.method static synthetic a(Larv;)Laqs;
    .locals 1

    iget-object v0, p0, Larv;->b:Laqs;

    return-object v0
.end method

.method public static b()Larv;
    .locals 1

    sget-object v0, Larv;->k:Larv;

    if-nez v0, :cond_0

    new-instance v0, Larv;

    invoke-direct {v0}, Larv;-><init>()V

    sput-object v0, Larv;->k:Larv;

    :cond_0
    sget-object v0, Larv;->k:Larv;

    return-object v0
.end method


# virtual methods
.method public declared-synchronized a()V
    .locals 2

    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Larv;->f:Z

    if-nez v0, :cond_0

    const-string v0, "Dispatch call queued. Dispatch will run once initialization is complete."

    invoke-static {v0}, Laqv;->d(Ljava/lang/String;)V

    const/4 v0, 0x1

    iput-boolean v0, p0, Larv;->e:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :goto_0
    monitor-exit p0

    return-void

    :cond_0
    :try_start_1
    iget-object v0, p0, Larv;->c:Laqr;

    new-instance v1, Larv$2;

    invoke-direct {v1, p0}, Larv$2;-><init>(Larv;)V

    invoke-interface {v0, v1}, Laqr;->a(Ljava/lang/Runnable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
