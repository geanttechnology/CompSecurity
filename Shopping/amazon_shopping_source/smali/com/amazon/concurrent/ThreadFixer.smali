.class Lcom/amazon/concurrent/ThreadFixer;
.super Ljava/lang/Object;
.source "ThreadFixer.java"


# static fields
.field static final NORMAL_NON_DAEMON_FIXER:Lcom/amazon/concurrent/ThreadFixer;


# instance fields
.field private final daemon:Z

.field private final priority:I


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 12
    new-instance v0, Lcom/amazon/concurrent/ThreadFixer;

    const/4 v1, 0x0

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/amazon/concurrent/ThreadFixer;-><init>(ZI)V

    sput-object v0, Lcom/amazon/concurrent/ThreadFixer;->NORMAL_NON_DAEMON_FIXER:Lcom/amazon/concurrent/ThreadFixer;

    return-void
.end method

.method constructor <init>(ZI)V
    .locals 0
    .param p1, "daemon"    # Z
    .param p2, "priority"    # I

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    iput-boolean p1, p0, Lcom/amazon/concurrent/ThreadFixer;->daemon:Z

    .line 32
    iput p2, p0, Lcom/amazon/concurrent/ThreadFixer;->priority:I

    .line 33
    return-void
.end method


# virtual methods
.method public fix(Ljava/lang/Thread;)V
    .locals 2
    .param p1, "thread"    # Ljava/lang/Thread;

    .prologue
    .line 41
    invoke-virtual {p1}, Ljava/lang/Thread;->isDaemon()Z

    move-result v0

    iget-boolean v1, p0, Lcom/amazon/concurrent/ThreadFixer;->daemon:Z

    if-eq v0, v1, :cond_0

    .line 42
    iget-boolean v0, p0, Lcom/amazon/concurrent/ThreadFixer;->daemon:Z

    invoke-virtual {p1, v0}, Ljava/lang/Thread;->setDaemon(Z)V

    .line 44
    :cond_0
    invoke-virtual {p1}, Ljava/lang/Thread;->getPriority()I

    move-result v0

    iget v1, p0, Lcom/amazon/concurrent/ThreadFixer;->priority:I

    if-eq v0, v1, :cond_1

    .line 45
    iget v0, p0, Lcom/amazon/concurrent/ThreadFixer;->priority:I

    invoke-virtual {p1, v0}, Ljava/lang/Thread;->setPriority(I)V

    .line 47
    :cond_1
    return-void
.end method
