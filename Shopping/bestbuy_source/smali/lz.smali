.class final Llz;
.super Landroid/os/Handler;
.source "SourceFile"


# instance fields
.field private final a:Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

.field private final b:Lcom/google/zxing/MultiFormatReader;

.field private c:Lme;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;Ljava/util/Hashtable;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;",
            "Ljava/util/Hashtable",
            "<",
            "Lcom/google/zxing/DecodeHintType;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 27
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    .line 28
    new-instance v0, Lcom/google/zxing/MultiFormatReader;

    invoke-direct {v0}, Lcom/google/zxing/MultiFormatReader;-><init>()V

    iput-object v0, p0, Llz;->b:Lcom/google/zxing/MultiFormatReader;

    .line 29
    iget-object v0, p0, Llz;->b:Lcom/google/zxing/MultiFormatReader;

    invoke-virtual {v0, p2}, Lcom/google/zxing/MultiFormatReader;->setHints(Ljava/util/Map;)V

    .line 30
    iput-object p1, p0, Llz;->a:Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

    .line 31
    return-void
.end method

.method private a([BII)V
    .locals 4

    .prologue
    .line 46
    const/4 v0, 0x0

    .line 47
    invoke-static {}, Lmj;->a()Lmj;

    move-result-object v1

    invoke-virtual {v1, p1, p2, p3}, Lmj;->a([BII)Lme;

    move-result-object v1

    .line 49
    iput-object v1, p0, Llz;->c:Lme;

    .line 50
    new-instance v2, Lcom/google/zxing/BinaryBitmap;

    new-instance v3, Lcom/google/zxing/common/HybridBinarizer;

    invoke-direct {v3, v1}, Lcom/google/zxing/common/HybridBinarizer;-><init>(Lcom/google/zxing/LuminanceSource;)V

    invoke-direct {v2, v3}, Lcom/google/zxing/BinaryBitmap;-><init>(Lcom/google/zxing/Binarizer;)V

    .line 52
    :try_start_0
    iget-object v3, p0, Llz;->b:Lcom/google/zxing/MultiFormatReader;

    invoke-virtual {v3, v2}, Lcom/google/zxing/MultiFormatReader;->decodeWithState(Lcom/google/zxing/BinaryBitmap;)Lcom/google/zxing/Result;
    :try_end_0
    .catch Lcom/google/zxing/ReaderException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 56
    iget-object v2, p0, Llz;->b:Lcom/google/zxing/MultiFormatReader;

    invoke-virtual {v2}, Lcom/google/zxing/MultiFormatReader;->reset()V

    .line 59
    :goto_0
    if-eqz v0, :cond_0

    .line 60
    iget-object v2, p0, Llz;->a:Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

    invoke-virtual {v2}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->b()Landroid/os/Handler;

    move-result-object v2

    const v3, 0x7f0c0003

    invoke-static {v2, v3, v0}, Landroid/os/Message;->obtain(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    .line 62
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 63
    const-string v3, "barcode_bitmap"

    invoke-virtual {v1}, Lme;->a()Landroid/graphics/Bitmap;

    move-result-object v1

    invoke-virtual {v2, v3, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 65
    invoke-virtual {v0, v2}, Landroid/os/Message;->setData(Landroid/os/Bundle;)V

    .line 66
    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    .line 73
    :goto_1
    return-void

    .line 53
    :catch_0
    move-exception v2

    .line 56
    iget-object v2, p0, Llz;->b:Lcom/google/zxing/MultiFormatReader;

    invoke-virtual {v2}, Lcom/google/zxing/MultiFormatReader;->reset()V

    goto :goto_0

    :catchall_0
    move-exception v0

    iget-object v1, p0, Llz;->b:Lcom/google/zxing/MultiFormatReader;

    invoke-virtual {v1}, Lcom/google/zxing/MultiFormatReader;->reset()V

    throw v0

    .line 68
    :cond_0
    invoke-direct {p0, p1, p2, p3}, Llz;->b([BII)V

    .line 69
    iget-object v0, p0, Llz;->a:Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->b()Landroid/os/Handler;

    move-result-object v0

    const v1, 0x7f0c0002

    invoke-static {v0, v1}, Landroid/os/Message;->obtain(Landroid/os/Handler;I)Landroid/os/Message;

    move-result-object v0

    .line 71
    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    goto :goto_1
.end method

.method private b([BII)V
    .locals 7

    .prologue
    const/4 v2, 0x0

    .line 76
    const/4 v0, 0x0

    .line 77
    array-length v1, p1

    new-array v4, v1, [B

    move v3, v2

    .line 78
    :goto_0
    if-ge v3, p3, :cond_1

    move v1, v2

    .line 79
    :goto_1
    if-ge v1, p2, :cond_0

    .line 80
    mul-int v5, v1, p3

    add-int/2addr v5, p3

    sub-int/2addr v5, v3

    add-int/lit8 v5, v5, -0x1

    mul-int v6, v3, p2

    add-int/2addr v6, v1

    aget-byte v6, p1, v6

    aput-byte v6, v4, v5

    .line 79
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 78
    :cond_0
    add-int/lit8 v1, v3, 0x1

    move v3, v1

    goto :goto_0

    .line 82
    :cond_1
    invoke-static {}, Lmj;->a()Lmj;

    move-result-object v1

    invoke-virtual {v1, v4, p2, p3}, Lmj;->b([BII)Lme;

    move-result-object v1

    .line 84
    new-instance v2, Lcom/google/zxing/BinaryBitmap;

    new-instance v3, Lcom/google/zxing/common/HybridBinarizer;

    invoke-direct {v3, v1}, Lcom/google/zxing/common/HybridBinarizer;-><init>(Lcom/google/zxing/LuminanceSource;)V

    invoke-direct {v2, v3}, Lcom/google/zxing/BinaryBitmap;-><init>(Lcom/google/zxing/Binarizer;)V

    .line 86
    :try_start_0
    iget-object v1, p0, Llz;->b:Lcom/google/zxing/MultiFormatReader;

    invoke-virtual {v1, v2}, Lcom/google/zxing/MultiFormatReader;->decodeWithState(Lcom/google/zxing/BinaryBitmap;)Lcom/google/zxing/Result;
    :try_end_0
    .catch Lcom/google/zxing/ReaderException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 90
    iget-object v1, p0, Llz;->b:Lcom/google/zxing/MultiFormatReader;

    invoke-virtual {v1}, Lcom/google/zxing/MultiFormatReader;->reset()V

    .line 93
    :goto_2
    if-eqz v0, :cond_2

    .line 94
    iget-object v1, p0, Llz;->a:Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->b()Landroid/os/Handler;

    move-result-object v1

    const v2, 0x7f0c0003

    invoke-static {v1, v2, v0}, Landroid/os/Message;->obtain(Landroid/os/Handler;ILjava/lang/Object;)Landroid/os/Message;

    move-result-object v0

    .line 96
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 97
    const-string v2, "barcode_bitmap"

    iget-object v3, p0, Llz;->c:Lme;

    invoke-virtual {v3}, Lme;->a()Landroid/graphics/Bitmap;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 99
    invoke-virtual {v0, v1}, Landroid/os/Message;->setData(Landroid/os/Bundle;)V

    .line 100
    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    .line 106
    :goto_3
    return-void

    .line 87
    :catch_0
    move-exception v1

    .line 90
    iget-object v1, p0, Llz;->b:Lcom/google/zxing/MultiFormatReader;

    invoke-virtual {v1}, Lcom/google/zxing/MultiFormatReader;->reset()V

    goto :goto_2

    :catchall_0
    move-exception v0

    iget-object v1, p0, Llz;->b:Lcom/google/zxing/MultiFormatReader;

    invoke-virtual {v1}, Lcom/google/zxing/MultiFormatReader;->reset()V

    throw v0

    .line 102
    :cond_2
    iget-object v0, p0, Llz;->a:Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->b()Landroid/os/Handler;

    move-result-object v0

    const v1, 0x7f0c0002

    invoke-static {v0, v1}, Landroid/os/Message;->obtain(Landroid/os/Handler;I)Landroid/os/Message;

    move-result-object v0

    .line 104
    invoke-virtual {v0}, Landroid/os/Message;->sendToTarget()V

    goto :goto_3
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 3

    .prologue
    .line 35
    iget v0, p1, Landroid/os/Message;->what:I

    sparse-switch v0, :sswitch_data_0

    .line 43
    :goto_0
    return-void

    .line 37
    :sswitch_0
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, [B

    check-cast v0, [B

    iget v1, p1, Landroid/os/Message;->arg1:I

    iget v2, p1, Landroid/os/Message;->arg2:I

    invoke-direct {p0, v0, v1, v2}, Llz;->a([BII)V

    goto :goto_0

    .line 40
    :sswitch_1
    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-virtual {v0}, Landroid/os/Looper;->quit()V

    goto :goto_0

    .line 35
    :sswitch_data_0
    .sparse-switch
        0x7f0c0001 -> :sswitch_0
        0x7f0c0005 -> :sswitch_1
    .end sparse-switch
.end method
