.class Lcom/exacttarget/etpushsdk/ETPush$a;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field private a:Z

.field private b:Ljava/util/concurrent/CountDownLatch;


# direct methods
.method public constructor <init>(I)V
    .locals 1

    .prologue
    .line 1980
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1981
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    invoke-direct {v0, p1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/ETPush$a;->b:Ljava/util/concurrent/CountDownLatch;

    .line 1982
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 2002
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/exacttarget/etpushsdk/ETPush$a;->a:Z

    .line 2003
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPush$a;->b:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 2004
    return-void
.end method

.method public a(JLjava/util/concurrent/TimeUnit;)Z
    .locals 5

    .prologue
    .line 1987
    :try_start_0
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPush$a;->b:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0, p1, p2, p3}, Ljava/util/concurrent/CountDownLatch;->await(JLjava/util/concurrent/TimeUnit;)Z
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    .line 1992
    iget-boolean v1, p0, Lcom/exacttarget/etpushsdk/ETPush$a;->a:Z

    if-eqz v1, :cond_1

    .line 1993
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->w()Ljava/lang/Thread;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1994
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->w()Ljava/lang/Thread;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Thread;->interrupt()V

    .line 1996
    :cond_0
    new-instance v0, Lcom/exacttarget/etpushsdk/ETException;

    const-string v1, "Aborting readyAimFire() due to Exception in initialization.  See logcat for more information."

    invoke-direct {v0, v1}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 1988
    :catch_0
    move-exception v0

    .line 1989
    const-string v1, "~!ETPush"

    invoke-virtual {v0}, Ljava/lang/InterruptedException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 1990
    new-instance v1, Lcom/exacttarget/etpushsdk/ETException;

    const-string v2, "Exception in latch.await: %1$s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v0}, Ljava/lang/InterruptedException;->getMessage()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 1998
    :cond_1
    return v0
.end method

.method public b()Z
    .locals 1

    .prologue
    .line 2007
    iget-boolean v0, p0, Lcom/exacttarget/etpushsdk/ETPush$a;->a:Z

    return v0
.end method

.method public c()V
    .locals 1

    .prologue
    .line 2011
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPush$a;->b:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 2012
    return-void
.end method

.method public d()J
    .locals 2

    .prologue
    .line 2015
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETPush$a;->b:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->getCount()J

    move-result-wide v0

    return-wide v0
.end method
