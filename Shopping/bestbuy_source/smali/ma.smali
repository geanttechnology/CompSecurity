.class final Lma;
.super Ljava/lang/Thread;
.source "SourceFile"


# instance fields
.field private final a:Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

.field private final b:Ljava/util/Hashtable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Hashtable",
            "<",
            "Lcom/google/zxing/DecodeHintType;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private c:Landroid/os/Handler;

.field private final d:Ljava/util/concurrent/CountDownLatch;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;Ljava/util/Vector;Ljava/lang/String;Lcom/google/zxing/ResultPointCallback;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;",
            "Ljava/util/Vector",
            "<",
            "Lcom/google/zxing/BarcodeFormat;",
            ">;",
            "Ljava/lang/String;",
            "Lcom/google/zxing/ResultPointCallback;",
            ")V"
        }
    .end annotation

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Thread;-><init>()V

    .line 27
    iput-object p1, p0, Lma;->a:Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

    .line 28
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    iput-object v0, p0, Lma;->d:Ljava/util/concurrent/CountDownLatch;

    .line 30
    new-instance v0, Ljava/util/Hashtable;

    const/4 v1, 0x3

    invoke-direct {v0, v1}, Ljava/util/Hashtable;-><init>(I)V

    iput-object v0, p0, Lma;->b:Ljava/util/Hashtable;

    .line 32
    if-eqz p2, :cond_0

    invoke-virtual {p2}, Ljava/util/Vector;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 33
    :cond_0
    new-instance p2, Ljava/util/Vector;

    invoke-direct {p2}, Ljava/util/Vector;-><init>()V

    .line 34
    sget-object v0, Lly;->b:Ljava/util/Vector;

    invoke-virtual {p2, v0}, Ljava/util/Vector;->addAll(Ljava/util/Collection;)Z

    .line 35
    sget-object v0, Lly;->c:Ljava/util/Vector;

    invoke-virtual {p2, v0}, Ljava/util/Vector;->addAll(Ljava/util/Collection;)Z

    .line 36
    sget-object v0, Lly;->d:Ljava/util/Vector;

    invoke-virtual {p2, v0}, Ljava/util/Vector;->addAll(Ljava/util/Collection;)Z

    .line 38
    :cond_1
    iget-object v0, p0, Lma;->b:Ljava/util/Hashtable;

    sget-object v1, Lcom/google/zxing/DecodeHintType;->POSSIBLE_FORMATS:Lcom/google/zxing/DecodeHintType;

    invoke-virtual {v0, v1, p2}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 40
    if-eqz p3, :cond_2

    .line 41
    iget-object v0, p0, Lma;->b:Ljava/util/Hashtable;

    sget-object v1, Lcom/google/zxing/DecodeHintType;->CHARACTER_SET:Lcom/google/zxing/DecodeHintType;

    invoke-virtual {v0, v1, p3}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 44
    :cond_2
    iget-object v0, p0, Lma;->b:Ljava/util/Hashtable;

    sget-object v1, Lcom/google/zxing/DecodeHintType;->NEED_RESULT_POINT_CALLBACK:Lcom/google/zxing/DecodeHintType;

    invoke-virtual {v0, v1, p4}, Ljava/util/Hashtable;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 46
    return-void
.end method


# virtual methods
.method a()Landroid/os/Handler;
    .locals 1

    .prologue
    .line 50
    :try_start_0
    iget-object v0, p0, Lma;->d:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->await()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 54
    :goto_0
    iget-object v0, p0, Lma;->c:Landroid/os/Handler;

    return-object v0

    .line 51
    :catch_0
    move-exception v0

    .line 52
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_0
.end method

.method public run()V
    .locals 3

    .prologue
    .line 59
    invoke-static {}, Landroid/os/Looper;->prepare()V

    .line 60
    new-instance v0, Llz;

    iget-object v1, p0, Lma;->a:Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

    iget-object v2, p0, Lma;->b:Ljava/util/Hashtable;

    invoke-direct {v0, v1, v2}, Llz;-><init>(Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;Ljava/util/Hashtable;)V

    iput-object v0, p0, Lma;->c:Landroid/os/Handler;

    .line 61
    iget-object v0, p0, Lma;->d:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 62
    invoke-static {}, Landroid/os/Looper;->loop()V

    .line 63
    return-void
.end method
