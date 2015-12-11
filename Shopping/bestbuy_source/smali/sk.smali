.class public Lsk;
.super Ljava/lang/Object;


# annotations
.annotation runtime Lzf;
.end annotation


# instance fields
.field private final a:Lsl;

.field private final b:Ljava/lang/Runnable;

.field private c:Lcom/google/android/gms/internal/av;

.field private d:Z

.field private e:Z

.field private f:J


# direct methods
.method public constructor <init>(Lahi;)V
    .locals 2

    new-instance v0, Lsl;

    sget-object v1, Laca;->a:Landroid/os/Handler;

    invoke-direct {v0, v1}, Lsl;-><init>(Landroid/os/Handler;)V

    invoke-direct {p0, p1, v0}, Lsk;-><init>(Lahi;Lsl;)V

    return-void
.end method

.method constructor <init>(Lahi;Lsl;)V
    .locals 2

    const/4 v0, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-boolean v0, p0, Lsk;->d:Z

    iput-boolean v0, p0, Lsk;->e:Z

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lsk;->f:J

    iput-object p2, p0, Lsk;->a:Lsl;

    new-instance v0, Lsk$1;

    invoke-direct {v0, p0, p1}, Lsk$1;-><init>(Lsk;Lahi;)V

    iput-object v0, p0, Lsk;->b:Ljava/lang/Runnable;

    return-void
.end method

.method static synthetic a(Lsk;)Lcom/google/android/gms/internal/av;
    .locals 1

    iget-object v0, p0, Lsk;->c:Lcom/google/android/gms/internal/av;

    return-object v0
.end method

.method static synthetic a(Lsk;Z)Z
    .locals 0

    iput-boolean p1, p0, Lsk;->d:Z

    return p1
.end method


# virtual methods
.method public a()V
    .locals 2

    const/4 v0, 0x0

    iput-boolean v0, p0, Lsk;->d:Z

    iget-object v0, p0, Lsk;->a:Lsl;

    iget-object v1, p0, Lsk;->b:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Lsl;->a(Ljava/lang/Runnable;)V

    return-void
.end method

.method public a(Lcom/google/android/gms/internal/av;)V
    .locals 2

    const-wide/32 v0, 0xea60

    invoke-virtual {p0, p1, v0, v1}, Lsk;->a(Lcom/google/android/gms/internal/av;J)V

    return-void
.end method

.method public a(Lcom/google/android/gms/internal/av;J)V
    .locals 2

    iget-boolean v0, p0, Lsk;->d:Z

    if-eqz v0, :cond_1

    const-string v0, "An ad refresh is already scheduled."

    invoke-static {v0}, Lacb;->e(Ljava/lang/String;)V

    :cond_0
    :goto_0
    return-void

    :cond_1
    iput-object p1, p0, Lsk;->c:Lcom/google/android/gms/internal/av;

    const/4 v0, 0x1

    iput-boolean v0, p0, Lsk;->d:Z

    iput-wide p2, p0, Lsk;->f:J

    iget-boolean v0, p0, Lsk;->e:Z

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "Scheduling ad refresh "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2, p3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " milliseconds from now."

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lacb;->c(Ljava/lang/String;)V

    iget-object v0, p0, Lsk;->a:Lsl;

    iget-object v1, p0, Lsk;->b:Ljava/lang/Runnable;

    invoke-virtual {v0, v1, p2, p3}, Lsl;->a(Ljava/lang/Runnable;J)Z

    goto :goto_0
.end method

.method public b()V
    .locals 2

    const/4 v0, 0x1

    iput-boolean v0, p0, Lsk;->e:Z

    iget-boolean v0, p0, Lsk;->d:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lsk;->a:Lsl;

    iget-object v1, p0, Lsk;->b:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Lsl;->a(Ljava/lang/Runnable;)V

    :cond_0
    return-void
.end method

.method public c()V
    .locals 4

    const/4 v1, 0x0

    iput-boolean v1, p0, Lsk;->e:Z

    iget-boolean v0, p0, Lsk;->d:Z

    if-eqz v0, :cond_0

    iput-boolean v1, p0, Lsk;->d:Z

    iget-object v0, p0, Lsk;->c:Lcom/google/android/gms/internal/av;

    iget-wide v2, p0, Lsk;->f:J

    invoke-virtual {p0, v0, v2, v3}, Lsk;->a(Lcom/google/android/gms/internal/av;J)V

    :cond_0
    return-void
.end method

.method public d()Z
    .locals 1

    iget-boolean v0, p0, Lsk;->d:Z

    return v0
.end method
