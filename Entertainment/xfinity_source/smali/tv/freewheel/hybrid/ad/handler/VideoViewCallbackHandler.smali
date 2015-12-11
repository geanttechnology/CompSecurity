.class public Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;
.super Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;
.source "VideoViewCallbackHandler.java"


# static fields
.field private static intervals:[I


# instance fields
.field private initSent:Z

.field private interval_index:I

.field public replay:Z

.field private scheduler:Ltv/freewheel/hybrid/utils/Scheduler;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 11
    const/16 v0, 0x8

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->intervals:[I

    return-void

    :array_0
    .array-data 4
        0x5
        0xa
        0xf
        0x1e
        0x3c
        0x78
        0xb4
        0x12c
    .end array-data
.end method

.method public constructor <init>(Ltv/freewheel/hybrid/ad/EventCallback;)V
    .locals 2
    .param p1, "callback"    # Ltv/freewheel/hybrid/ad/EventCallback;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/MalformedURLException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 19
    invoke-direct {p0, p1}, Ltv/freewheel/hybrid/ad/handler/EventCallbackHandler;-><init>(Ltv/freewheel/hybrid/ad/EventCallback;)V

    .line 12
    const/4 v0, -0x1

    iput v0, p0, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->interval_index:I

    .line 14
    iput-boolean v1, p0, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->initSent:Z

    .line 16
    iput-boolean v1, p0, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->replay:Z

    .line 20
    new-instance v0, Ltv/freewheel/hybrid/utils/Scheduler;

    invoke-direct {v0}, Ltv/freewheel/hybrid/utils/Scheduler;-><init>()V

    iput-object v0, p0, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->scheduler:Ltv/freewheel/hybrid/utils/Scheduler;

    .line 21
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->scheduler:Ltv/freewheel/hybrid/utils/Scheduler;

    new-instance v1, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler$1;

    invoke-direct {v1, p0}, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler$1;-><init>(Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;)V

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Scheduler;->setTask(Ljava/lang/Runnable;)V

    .line 31
    return-void
.end method

.method static synthetic access$000(Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;)Ltv/freewheel/hybrid/utils/Scheduler;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;

    .prologue
    .line 9
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->scheduler:Ltv/freewheel/hybrid/utils/Scheduler;

    return-object v0
.end method

.method static synthetic access$100(Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;)I
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;

    .prologue
    .line 9
    iget v0, p0, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->interval_index:I

    return v0
.end method

.method static synthetic access$102(Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;I)I
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;
    .param p1, "x1"    # I

    .prologue
    .line 9
    iput p1, p0, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->interval_index:I

    return p1
.end method

.method static synthetic access$104(Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;)I
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;

    .prologue
    .line 9
    iget v0, p0, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->interval_index:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->interval_index:I

    return v0
.end method

.method static synthetic access$200()[I
    .locals 1

    .prologue
    .line 9
    sget-object v0, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->intervals:[I

    return-object v0
.end method


# virtual methods
.method public resume()V
    .locals 1

    .prologue
    .line 79
    iget-object v0, p0, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->scheduler:Ltv/freewheel/hybrid/utils/Scheduler;

    invoke-virtual {v0}, Ltv/freewheel/hybrid/utils/Scheduler;->resume()V

    .line 80
    return-void
.end method

.method public send(J)V
    .locals 3
    .param p1, "ctValue"    # J

    .prologue
    .line 49
    iget-boolean v0, p0, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->replay:Z

    if-eqz v0, :cond_0

    .line 50
    const-string v0, "init"

    const-string v1, "2"

    invoke-virtual {p0, v0, v1}, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 60
    :goto_0
    const-string v0, "ct"

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 61
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->send()V

    .line 62
    return-void

    .line 52
    :cond_0
    iget-boolean v0, p0, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->initSent:Z

    if-eqz v0, :cond_1

    .line 53
    const-string v0, "init"

    const-string v1, "0"

    invoke-virtual {p0, v0, v1}, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 55
    :cond_1
    const-string v0, "init"

    const-string v1, "1"

    invoke-virtual {p0, v0, v1}, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->setParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 56
    invoke-virtual {p0}, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->sendTrackingCallback()V

    .line 57
    const/4 v0, 0x1

    iput-boolean v0, p0, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->initSent:Z

    goto :goto_0
.end method

.method public start(J)V
    .locals 5
    .param p1, "delaySeconds"    # J

    .prologue
    .line 34
    iget-object v1, p0, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "delaySeconds: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/hybrid/utils/Logger;->info(Ljava/lang/String;)V

    .line 35
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    sget-object v1, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->intervals:[I

    array-length v1, v1

    if-ge v0, v1, :cond_0

    .line 36
    sget-object v1, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->intervals:[I

    aget v1, v1, v0

    int-to-long v2, v1

    cmp-long v1, p1, v2

    if-gez v1, :cond_2

    .line 37
    iput v0, p0, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->interval_index:I

    .line 41
    :cond_0
    invoke-virtual {p0, p1, p2}, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->send(J)V

    .line 42
    iget v1, p0, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->interval_index:I

    if-gez v1, :cond_1

    .line 43
    const/4 v1, 0x7

    iput v1, p0, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->interval_index:I

    .line 45
    :cond_1
    iget-object v1, p0, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->scheduler:Ltv/freewheel/hybrid/utils/Scheduler;

    sget-object v2, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->intervals:[I

    iget v3, p0, Ltv/freewheel/hybrid/ad/handler/VideoViewCallbackHandler;->interval_index:I

    aget v2, v2, v3

    int-to-double v2, v2

    const/4 v4, 0x0

    invoke-virtual {v1, v2, v3, v4}, Ltv/freewheel/hybrid/utils/Scheduler;->start(DZ)V

    .line 46
    return-void

    .line 35
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method
