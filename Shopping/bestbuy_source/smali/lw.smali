.class public final Llw;
.super Landroid/os/Handler;
.source "SourceFile"


# instance fields
.field private final a:Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

.field private final b:Lma;

.field private c:Llx;


# direct methods
.method public constructor <init>(Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;Ljava/util/Vector;Ljava/lang/String;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;",
            "Ljava/util/Vector",
            "<",
            "Lcom/google/zxing/BarcodeFormat;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 30
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    .line 31
    iput-object p1, p0, Llw;->a:Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

    .line 32
    new-instance v0, Lma;

    new-instance v1, Lmg;

    invoke-virtual {p1}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->a()Lcom/bestbuy/android/managers/bbyscan/ViewfinderView;

    move-result-object v2

    invoke-direct {v1, v2}, Lmg;-><init>(Lcom/bestbuy/android/managers/bbyscan/ViewfinderView;)V

    invoke-direct {v0, p1, p2, p3, v1}, Lma;-><init>(Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;Ljava/util/Vector;Ljava/lang/String;Lcom/google/zxing/ResultPointCallback;)V

    iput-object v0, p0, Llw;->b:Lma;

    .line 34
    iget-object v0, p0, Llw;->b:Lma;

    invoke-virtual {v0}, Lma;->start()V

    .line 35
    sget-object v0, Llx;->b:Llx;

    iput-object v0, p0, Llw;->c:Llx;

    .line 37
    invoke-static {}, Lmj;->a()Lmj;

    move-result-object v0

    invoke-virtual {v0}, Lmj;->e()V

    .line 38
    invoke-direct {p0}, Llw;->b()V

    .line 39
    return-void
.end method

.method private b()V
    .locals 3

    .prologue
    .line 104
    iget-object v0, p0, Llw;->c:Llx;

    sget-object v1, Llx;->b:Llx;

    if-ne v0, v1, :cond_0

    .line 105
    sget-object v0, Llx;->a:Llx;

    iput-object v0, p0, Llw;->c:Llx;

    .line 106
    invoke-static {}, Lmj;->a()Lmj;

    move-result-object v0

    iget-object v1, p0, Llw;->b:Lma;

    invoke-virtual {v1}, Lma;->a()Landroid/os/Handler;

    move-result-object v1

    const v2, 0x7f0c0001

    invoke-virtual {v0, v1, v2}, Lmj;->a(Landroid/os/Handler;I)V

    .line 108
    invoke-static {}, Lmj;->a()Lmj;

    move-result-object v0

    const/high16 v1, 0x7f0c0000

    invoke-virtual {v0, p0, v1}, Lmj;->b(Landroid/os/Handler;I)V

    .line 109
    iget-object v0, p0, Llw;->a:Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->c()V

    .line 111
    :cond_0
    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 89
    sget-object v0, Llx;->c:Llx;

    iput-object v0, p0, Llw;->c:Llx;

    .line 90
    invoke-static {}, Lmj;->a()Lmj;

    move-result-object v0

    invoke-virtual {v0}, Lmj;->f()V

    .line 91
    iget-object v0, p0, Llw;->b:Lma;

    invoke-virtual {v0}, Lma;->a()Landroid/os/Handler;

    move-result-object v0

    const v1, 0x7f0c0005

    invoke-static {v0, v1}, Landroid/os/Message;->obtain(Landroid/os/Handler;I)Landroid/os/Message;

    move-result-object v0

    .line 92
    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    .line 94
    :try_start_0
    iget-object v0, p0, Llw;->b:Lma;

    invoke-virtual {v0}, Lma;->join()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 99
    :goto_0
    const v0, 0x7f0c0003

    invoke-virtual {p0, v0}, Llw;->removeMessages(I)V

    .line 100
    const v0, 0x7f0c0002

    invoke-virtual {p0, v0}, Llw;->removeMessages(I)V

    .line 101
    return-void

    .line 95
    :catch_0
    move-exception v0

    .line 96
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_0
.end method

.method public handleMessage(Landroid/os/Message;)V
    .locals 3

    .prologue
    .line 43
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 86
    :cond_0
    :goto_0
    :pswitch_0
    return-void

    .line 45
    :pswitch_1
    iget-object v0, p0, Llw;->c:Llx;

    sget-object v1, Llx;->a:Llx;

    if-ne v0, v1, :cond_0

    .line 46
    invoke-static {}, Lmj;->a()Lmj;

    move-result-object v0

    const/high16 v1, 0x7f0c0000

    invoke-virtual {v0, p0, v1}, Lmj;->b(Landroid/os/Handler;I)V

    goto :goto_0

    .line 50
    :pswitch_2
    invoke-direct {p0}, Llw;->b()V

    goto :goto_0

    .line 53
    :pswitch_3
    invoke-virtual {p1}, Landroid/os/Message;->getData()Landroid/os/Bundle;

    move-result-object v0

    .line 54
    if-nez v0, :cond_1

    const/4 v0, 0x0

    move-object v1, v0

    .line 56
    :goto_1
    iget-object v2, p0, Llw;->a:Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Lcom/google/zxing/Result;

    invoke-virtual {v2, v0, v1}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->a(Lcom/google/zxing/Result;Landroid/graphics/Bitmap;)V

    .line 63
    const-wide/16 v0, 0x7d0

    :try_start_0
    invoke-static {v0, v1}, Ljava/lang/Thread;->sleep(J)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 68
    :goto_2
    sget-object v0, Llx;->b:Llx;

    iput-object v0, p0, Llw;->c:Llx;

    goto :goto_0

    .line 54
    :cond_1
    const-string v1, "barcode_bitmap"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/graphics/Bitmap;

    move-object v1, v0

    goto :goto_1

    .line 64
    :catch_0
    move-exception v0

    .line 66
    invoke-virtual {v0}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_2

    .line 71
    :pswitch_4
    sget-object v0, Llx;->a:Llx;

    iput-object v0, p0, Llw;->c:Llx;

    .line 72
    invoke-static {}, Lmj;->a()Lmj;

    move-result-object v0

    iget-object v1, p0, Llw;->b:Lma;

    invoke-virtual {v1}, Lma;->a()Landroid/os/Handler;

    move-result-object v1

    const v2, 0x7f0c0001

    invoke-virtual {v0, v1, v2}, Lmj;->a(Landroid/os/Handler;I)V

    goto :goto_0

    .line 80
    :pswitch_5
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Ljava/lang/String;

    .line 81
    new-instance v1, Landroid/content/Intent;

    const-string v2, "android.intent.action.VIEW"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    invoke-direct {v1, v2, v0}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 82
    const/high16 v0, 0x80000

    invoke-virtual {v1, v0}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 83
    iget-object v0, p0, Llw;->a:Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 43
    nop

    :pswitch_data_0
    .packed-switch 0x7f0c0000
        :pswitch_1
        :pswitch_0
        :pswitch_4
        :pswitch_3
        :pswitch_5
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method
