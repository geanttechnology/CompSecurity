.class public final Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;
.super Landroid/app/Activity;
.source "SourceFile"

# interfaces
.implements Landroid/view/SurfaceHolder$Callback;


# static fields
.field private static final a:Ljava/lang/String;

.field private static final b:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/google/zxing/ResultMetadataType;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private c:Llw;

.field private d:Lcom/bestbuy/android/managers/bbyscan/ViewfinderView;

.field private e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private f:Landroid/view/View;

.field private g:Lcom/google/zxing/Result;

.field private h:Z

.field private i:Lbr;

.field private j:Ljava/lang/String;

.field private k:Ljava/lang/String;

.field private l:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lcom/google/zxing/BarcodeFormat;",
            ">;"
        }
    .end annotation
.end field

.field private m:Ljava/lang/String;

.field private n:Lmc;

.field private o:Llv;

.field private p:Ljava/lang/String;

.field private q:Ljava/lang/String;

.field private r:Ljava/lang/String;

.field private s:Landroid/widget/RelativeLayout;

.field private t:Landroid/view/SurfaceView;

.field private u:Z

.field private v:Landroid/widget/LinearLayout;

.field private w:Landroid/widget/LinearLayout;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 57
    const-class v0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->a:Ljava/lang/String;

    .line 65
    new-instance v0, Ljava/util/HashSet;

    const/4 v1, 0x5

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(I)V

    sput-object v0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->b:Ljava/util/Set;

    .line 66
    sget-object v0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->b:Ljava/util/Set;

    sget-object v1, Lcom/google/zxing/ResultMetadataType;->ISSUE_NUMBER:Lcom/google/zxing/ResultMetadataType;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 67
    sget-object v0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->b:Ljava/util/Set;

    sget-object v1, Lcom/google/zxing/ResultMetadataType;->SUGGESTED_PRICE:Lcom/google/zxing/ResultMetadataType;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 68
    sget-object v0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->b:Ljava/util/Set;

    sget-object v1, Lcom/google/zxing/ResultMetadataType;->ERROR_CORRECTION_LEVEL:Lcom/google/zxing/ResultMetadataType;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 69
    sget-object v0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->b:Ljava/util/Set;

    sget-object v1, Lcom/google/zxing/ResultMetadataType;->POSSIBLE_COUNTRY:Lcom/google/zxing/ResultMetadataType;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 70
    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 56
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 97
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->u:Z

    return-void
.end method

.method private a(Landroid/graphics/Bitmap;Lcom/google/zxing/Result;)V
    .locals 8

    .prologue
    const/4 v0, 0x0

    const/4 v7, 0x2

    .line 334
    invoke-virtual {p2}, Lcom/google/zxing/Result;->getResultPoints()[Lcom/google/zxing/ResultPoint;

    move-result-object v1

    .line 335
    if-eqz v1, :cond_0

    array-length v2, v1

    if-lez v2, :cond_0

    .line 336
    new-instance v2, Landroid/graphics/Canvas;

    invoke-direct {v2, p1}, Landroid/graphics/Canvas;-><init>(Landroid/graphics/Bitmap;)V

    .line 337
    new-instance v3, Landroid/graphics/Paint;

    invoke-direct {v3}, Landroid/graphics/Paint;-><init>()V

    .line 338
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f0b0063

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/graphics/Paint;->setColor(I)V

    .line 339
    const/high16 v4, 0x40400000    # 3.0f

    invoke-virtual {v3, v4}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 340
    sget-object v4, Landroid/graphics/Paint$Style;->STROKE:Landroid/graphics/Paint$Style;

    invoke-virtual {v3, v4}, Landroid/graphics/Paint;->setStyle(Landroid/graphics/Paint$Style;)V

    .line 341
    new-instance v4, Landroid/graphics/Rect;

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v5

    add-int/lit8 v5, v5, -0x2

    invoke-virtual {p1}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v6

    add-int/lit8 v6, v6, -0x2

    invoke-direct {v4, v7, v7, v5, v6}, Landroid/graphics/Rect;-><init>(IIII)V

    .line 342
    invoke-virtual {v2, v4, v3}, Landroid/graphics/Canvas;->drawRect(Landroid/graphics/Rect;Landroid/graphics/Paint;)V

    .line 344
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f0b0007

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/graphics/Paint;->setColor(I)V

    .line 345
    array-length v4, v1

    if-ne v4, v7, :cond_1

    .line 360
    :cond_0
    :goto_0
    return-void

    .line 347
    :cond_1
    array-length v4, v1

    const/4 v5, 0x4

    if-ne v4, v5, :cond_2

    invoke-virtual {p2}, Lcom/google/zxing/Result;->getBarcodeFormat()Lcom/google/zxing/BarcodeFormat;

    move-result-object v4

    sget-object v5, Lcom/google/zxing/BarcodeFormat;->UPC_A:Lcom/google/zxing/BarcodeFormat;

    invoke-virtual {v4, v5}, Lcom/google/zxing/BarcodeFormat;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_3

    :cond_2
    invoke-virtual {p2}, Lcom/google/zxing/Result;->getBarcodeFormat()Lcom/google/zxing/BarcodeFormat;

    move-result-object v4

    sget-object v5, Lcom/google/zxing/BarcodeFormat;->EAN_13:Lcom/google/zxing/BarcodeFormat;

    invoke-virtual {v4, v5}, Lcom/google/zxing/BarcodeFormat;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 351
    :cond_3
    aget-object v0, v1, v0

    const/4 v4, 0x1

    aget-object v4, v1, v4

    invoke-direct {p0, v2, v3, v0, v4}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->a(Landroid/graphics/Canvas;Landroid/graphics/Paint;Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;)V

    .line 352
    aget-object v0, v1, v7

    const/4 v4, 0x3

    aget-object v1, v1, v4

    invoke-direct {p0, v2, v3, v0, v1}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->a(Landroid/graphics/Canvas;Landroid/graphics/Paint;Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;)V

    goto :goto_0

    .line 354
    :cond_4
    const/high16 v4, 0x41200000    # 10.0f

    invoke-virtual {v3, v4}, Landroid/graphics/Paint;->setStrokeWidth(F)V

    .line 355
    array-length v4, v1

    :goto_1
    if-ge v0, v4, :cond_0

    aget-object v5, v1, v0

    .line 356
    invoke-virtual {v5}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v6

    invoke-virtual {v5}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v5

    invoke-virtual {v2, v6, v5, v3}, Landroid/graphics/Canvas;->drawPoint(FFLandroid/graphics/Paint;)V

    .line 355
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method private a(Landroid/graphics/Canvas;Landroid/graphics/Paint;Lcom/google/zxing/ResultPoint;Lcom/google/zxing/ResultPoint;)V
    .locals 6

    .prologue
    .line 363
    invoke-virtual {p3}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v1

    invoke-virtual {p3}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v2

    invoke-virtual {p4}, Lcom/google/zxing/ResultPoint;->getX()F

    move-result v3

    invoke-virtual {p4}, Lcom/google/zxing/ResultPoint;->getY()F

    move-result v4

    move-object v0, p1

    move-object v5, p2

    invoke-virtual/range {v0 .. v5}, Landroid/graphics/Canvas;->drawLine(FFFFLandroid/graphics/Paint;)V

    .line 364
    return-void
.end method

.method private a(Landroid/view/SurfaceHolder;)V
    .locals 4

    .prologue
    .line 462
    :try_start_0
    invoke-static {}, Lmj;->a()Lmj;

    move-result-object v0

    invoke-virtual {v0, p1}, Lmj;->a(Landroid/view/SurfaceHolder;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 475
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->c:Llw;

    if-nez v0, :cond_0

    .line 476
    new-instance v0, Llw;

    iget-object v1, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->l:Ljava/util/Vector;

    iget-object v2, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->m:Ljava/lang/String;

    invoke-direct {v0, p0, v1, v2}, Llw;-><init>(Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;Ljava/util/Vector;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->c:Llw;

    .line 479
    :cond_0
    :goto_0
    return-void

    .line 463
    :catch_0
    move-exception v0

    .line 466
    sget-object v1, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->a:Ljava/lang/String;

    const-string v2, "Unexpected error initializating camera"

    invoke-static {v1, v2, v0}, Lkf;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 467
    invoke-direct {p0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->f()V

    goto :goto_0

    .line 470
    :catch_1
    move-exception v0

    .line 471
    sget-object v1, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->a:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "IOException Error : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lkf;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 472
    invoke-direct {p0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->f()V

    goto :goto_0
.end method

.method private a(Ljava/lang/String;Lcom/google/zxing/Result;)V
    .locals 3

    .prologue
    .line 447
    const-string v0, "LIFE_EVENTS_PRODUCT_SCAN"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 448
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 449
    const/high16 v1, 0x80000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 450
    const-string v1, "SCAN_RESULT"

    invoke-virtual {p2}, Lcom/google/zxing/Result;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 451
    const-string v1, "SCAN_RESULT_FORMAT"

    invoke-virtual {p2}, Lcom/google/zxing/Result;->getBarcodeFormat()Lcom/google/zxing/BarcodeFormat;

    move-result-object v2

    invoke-virtual {v2}, Lcom/google/zxing/BarcodeFormat;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 456
    :cond_0
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;)Z
    .locals 1

    .prologue
    .line 56
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->u:Z

    return v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;Z)Z
    .locals 0

    .prologue
    .line 56
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->u:Z

    return p1
.end method

.method private b(Lcom/google/zxing/Result;Landroid/graphics/Bitmap;)V
    .locals 8

    .prologue
    const-wide/16 v6, 0x0

    const/4 v5, 0x0

    const v2, 0x7f0c0004

    const/4 v4, 0x7

    const/4 v3, 0x0

    .line 385
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->d:Lcom/bestbuy/android/managers/bbyscan/ViewfinderView;

    invoke-virtual {v0, p2}, Lcom/bestbuy/android/managers/bbyscan/ViewfinderView;->a(Landroid/graphics/Bitmap;)V

    .line 390
    sget-object v0, Lbr;->a:Lbr;

    iput-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->i:Lbr;

    .line 391
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->i:Lbr;

    sget-object v1, Lbr;->a:Lbr;

    if-ne v0, v1, :cond_6

    .line 394
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->k:Ljava/lang/String;

    const-string v1, "GIFT_CARD"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 395
    invoke-virtual {p1}, Lcom/google/zxing/Result;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0x10

    if-ne v0, v1, :cond_1

    .line 396
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->k:Ljava/lang/String;

    invoke-direct {p0, v0, p1}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->a(Ljava/lang/String;Lcom/google/zxing/Result;)V

    .line 397
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 398
    const-string v1, "gift_id"

    invoke-virtual {p1}, Lcom/google/zxing/Result;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 399
    sget v1, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->GC_SCAN_SUCCESS:I

    invoke-virtual {p0, v1, v0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->setResult(ILandroid/content/Intent;)V

    .line 400
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->finish()V

    .line 444
    :cond_0
    :goto_0
    return-void

    .line 402
    :cond_1
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->d()V

    goto :goto_0

    .line 404
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->k:Ljava/lang/String;

    const-string v1, "CODE_SCAN"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 406
    invoke-virtual {p1}, Lcom/google/zxing/Result;->toString()Ljava/lang/String;

    move-result-object v0

    .line 407
    const-string v1, "?c="

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 408
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->k:Ljava/lang/String;

    invoke-direct {p0, v0, p1}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->a(Ljava/lang/String;Lcom/google/zxing/Result;)V

    .line 409
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 410
    const-string v1, "ProductScan"

    invoke-virtual {p1}, Lcom/google/zxing/Result;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 411
    sget v1, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->PRODUCT_SCAN:I

    invoke-virtual {p0, v1, v0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->setResult(ILandroid/content/Intent;)V

    .line 412
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->finish()V

    goto :goto_0

    .line 415
    :cond_3
    new-instance v0, Liv;

    invoke-direct {v0, p0, v5, p1}, Liv;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/google/zxing/Result;)V

    new-array v1, v3, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Liv;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 418
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->k:Ljava/lang/String;

    const-string v1, "LIFE_EVENTS_PRODUCT_SCAN"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 420
    invoke-virtual {p1}, Lcom/google/zxing/Result;->toString()Ljava/lang/String;

    move-result-object v0

    .line 421
    const-string v1, "?c="

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 422
    const-string v1, "?c="

    invoke-virtual {v0, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 423
    const-string v1, "?c="

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 424
    invoke-virtual {v0, v3, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    .line 425
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v1

    invoke-virtual {v0, v4, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 427
    invoke-virtual {p0, p1, v0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->a(Lcom/google/zxing/Result;Ljava/lang/String;)V

    goto :goto_0

    .line 430
    :cond_5
    new-instance v0, Liv;

    const/4 v1, 0x1

    invoke-direct {v0, p0, v5, p1, v1}, Liv;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/google/zxing/Result;Z)V

    new-array v1, v3, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Liv;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0

    .line 433
    :cond_6
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->i:Lbr;

    sget-object v1, Lbr;->b:Lbr;

    if-ne v0, v1, :cond_7

    .line 436
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->c:Llw;

    invoke-static {v0, v2}, Landroid/os/Message;->obtain(Landroid/os/Handler;I)Landroid/os/Message;

    move-result-object v0

    .line 437
    iget-object v1, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->c:Llw;

    invoke-virtual {v1, v0, v6, v7}, Llw;->sendMessageDelayed(Landroid/os/Message;J)Z

    goto/16 :goto_0

    .line 438
    :cond_7
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->i:Lbr;

    sget-object v1, Lbr;->c:Lbr;

    if-ne v0, v1, :cond_0

    .line 441
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->c:Llw;

    invoke-static {v0, v2}, Landroid/os/Message;->obtain(Landroid/os/Handler;I)Landroid/os/Message;

    move-result-object v0

    .line 442
    iget-object v1, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->c:Llw;

    invoke-virtual {v1, v0, v6, v7}, Llw;->sendMessageDelayed(Landroid/os/Message;J)Z

    goto/16 :goto_0
.end method

.method private f()V
    .locals 3

    .prologue
    .line 482
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->isFinishing()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 491
    :cond_0
    :goto_0
    return-void

    .line 485
    :cond_1
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p0}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 486
    const v1, 0x7f0800b4

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 487
    const v1, 0x7f08023c

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 488
    const v1, 0x7f080284

    new-instance v2, Lmb;

    invoke-direct {v2, p0}, Lmb;-><init>(Landroid/app/Activity;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 489
    new-instance v1, Lmb;

    invoke-direct {v1, p0}, Lmb;-><init>(Landroid/app/Activity;)V

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)Landroid/app/AlertDialog$Builder;

    .line 490
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    goto :goto_0
.end method

.method private g()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 494
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->f:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 496
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 497
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->d:Lcom/bestbuy/android/managers/bbyscan/ViewfinderView;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/managers/bbyscan/ViewfinderView;->setVisibility(I)V

    .line 498
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->g:Lcom/google/zxing/Result;

    .line 499
    return-void
.end method


# virtual methods
.method public a()Lcom/bestbuy/android/managers/bbyscan/ViewfinderView;
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->d:Lcom/bestbuy/android/managers/bbyscan/ViewfinderView;

    return-object v0
.end method

.method public a(Lcom/google/zxing/Result;Landroid/graphics/Bitmap;)V
    .locals 1

    .prologue
    .line 319
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->n:Lmc;

    invoke-virtual {v0}, Lmc;->a()V

    .line 320
    iput-object p1, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->g:Lcom/google/zxing/Result;

    .line 322
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->o:Llv;

    invoke-virtual {v0}, Llv;->b()V

    .line 323
    invoke-direct {p0, p2, p1}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->a(Landroid/graphics/Bitmap;Lcom/google/zxing/Result;)V

    .line 324
    invoke-direct {p0, p1, p2}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->b(Lcom/google/zxing/Result;Landroid/graphics/Bitmap;)V

    .line 325
    return-void
.end method

.method public a(Lcom/google/zxing/Result;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 368
    if-nez p2, :cond_0

    .line 369
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->d()V

    .line 381
    :goto_0
    return-void

    .line 371
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->k:Ljava/lang/String;

    invoke-direct {p0, v0, p1}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->a(Ljava/lang/String;Lcom/google/zxing/Result;)V

    .line 372
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 373
    const-string v1, "ProductScan"

    invoke-virtual {p1}, Lcom/google/zxing/Result;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 374
    const-string v1, "skuid"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 375
    const-string v1, "uuid"

    iget-object v2, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->q:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 376
    const-string v1, "type"

    iget-object v2, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->r:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 377
    const-string v1, "fromLifeEventsProductScan"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 378
    sget v1, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->PRODUCT_SCAN:I

    invoke-virtual {p0, v1, v0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->setResult(ILandroid/content/Intent;)V

    .line 379
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->finish()V

    goto :goto_0
.end method

.method public a(Lcom/google/zxing/Result;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 538
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->k:Ljava/lang/String;

    invoke-direct {p0, v0, p1}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->a(Ljava/lang/String;Lcom/google/zxing/Result;)V

    .line 539
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 540
    const-string v1, "ProductScan"

    invoke-virtual {p1}, Lcom/google/zxing/Result;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 541
    const-string v1, "SkuId"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 542
    const-string v1, "ProductId"

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 543
    sget v1, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->PRODUCT_SCAN:I

    invoke-virtual {p0, v1, v0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->setResult(ILandroid/content/Intent;)V

    .line 544
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->finish()V

    .line 545
    return-void
.end method

.method public b()Landroid/os/Handler;
    .locals 1

    .prologue
    .line 106
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->c:Llw;

    return-object v0
.end method

.method public c()V
    .locals 1

    .prologue
    .line 502
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->d:Lcom/bestbuy/android/managers/bbyscan/ViewfinderView;

    invoke-virtual {v0}, Lcom/bestbuy/android/managers/bbyscan/ViewfinderView;->a()V

    .line 503
    return-void
.end method

.method public d()V
    .locals 4

    .prologue
    .line 506
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->w:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->b(Landroid/view/View;)V

    .line 507
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->c:Llw;

    const v1, 0x7f0c0006

    const-wide/16 v2, 0x1388

    invoke-virtual {v0, v1, v2, v3}, Llw;->sendEmptyMessageDelayed(IJ)Z

    .line 508
    return-void
.end method

.method public e()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 511
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "Item Added"

    const/4 v2, 0x0

    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 512
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->v:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->b(Landroid/view/View;)V

    .line 513
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    .line 514
    iget-object v1, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->r:Ljava/lang/String;

    const-string v2, "weddingregistrylists"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 515
    invoke-virtual {v0, v3}, Lnb;->l(Z)V

    .line 519
    :goto_0
    invoke-virtual {v0, v3}, Lnb;->k(Z)V

    .line 520
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->c:Llw;

    const v1, 0x7f0c0006

    const-wide/16 v2, 0x1388

    invoke-virtual {v0, v1, v2, v3}, Llw;->sendEmptyMessageDelayed(IJ)Z

    .line 521
    return-void

    .line 517
    :cond_0
    invoke-virtual {v0, v3}, Lnb;->j(Z)V

    goto :goto_0
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 0

    .prologue
    .line 526
    invoke-super {p0, p1, p2, p3}, Landroid/app/Activity;->onActivityResult(IILandroid/content/Intent;)V

    .line 527
    packed-switch p1, :pswitch_data_0

    .line 535
    :goto_0
    return-void

    .line 529
    :pswitch_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->finish()V

    goto :goto_0

    .line 527
    nop

    :pswitch_data_0
    .packed-switch 0x8ae
        :pswitch_0
    .end packed-switch
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 0

    .prologue
    .line 294
    invoke-super {p0, p1}, Landroid/app/Activity;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 295
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    const v2, 0x7f0c009c

    const v3, 0x7f0c0097

    invoke-static {p0}, Lp;->a(Landroid/app/Activity;)V

    .line 111
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 113
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    .line 114
    const/16 v1, 0x80

    invoke-virtual {v0, v1}, Landroid/view/Window;->addFlags(I)V

    .line 115
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 116
    if-eqz v0, :cond_3

    .line 117
    const-string v1, "screen_name"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 118
    const-string v1, "screen_name"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->k:Ljava/lang/String;

    .line 120
    :cond_0
    const-string v1, "screen_title"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 121
    const-string v1, "screen_title"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->p:Ljava/lang/String;

    .line 123
    :cond_1
    const-string v1, "uuid"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 124
    const-string v1, "uuid"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->q:Ljava/lang/String;

    .line 126
    :cond_2
    const-string v1, "type"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 127
    const-string v1, "type"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->r:Ljava/lang/String;

    .line 131
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->k:Ljava/lang/String;

    const-string v1, "GIFT_CARD"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 132
    const v0, 0x7f03001e

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->setContentView(I)V

    .line 133
    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 134
    invoke-virtual {v0}, Landroid/widget/Button;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    const/16 v2, 0x40

    invoke-virtual {v1, v2}, Landroid/graphics/drawable/Drawable;->setAlpha(I)V

    .line 135
    new-instance v1, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity$1;-><init>(Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 158
    :goto_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    invoke-static {v0}, Lmj;->a(Landroid/content/Context;)V

    .line 159
    const v0, 0x7f0c0087

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/managers/bbyscan/ViewfinderView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->d:Lcom/bestbuy/android/managers/bbyscan/ViewfinderView;

    .line 160
    const v0, 0x7f0c0038

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->v:Landroid/widget/LinearLayout;

    .line 161
    const v0, 0x7f0c0098

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->w:Landroid/widget/LinearLayout;

    .line 162
    const v0, 0x7f0c0088

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->f:Landroid/view/View;

    .line 163
    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 164
    const v0, 0x7f0c0096

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    new-instance v1, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity$3;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity$3;-><init>(Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 176
    iput-object v4, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->c:Llw;

    .line 177
    iput-object v4, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->g:Lcom/google/zxing/Result;

    .line 178
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->h:Z

    .line 179
    new-instance v0, Lmc;

    invoke-direct {v0, p0}, Lmc;-><init>(Landroid/app/Activity;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->n:Lmc;

    .line 180
    new-instance v0, Llv;

    invoke-direct {v0, p0}, Llv;-><init>(Landroid/app/Activity;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->o:Llv;

    .line 182
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->k:Ljava/lang/String;

    const-string v1, "GAMING_SCAN"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 183
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const v1, 0x7f0800c4

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(I)V

    .line 185
    :cond_4
    return-void

    .line 142
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->k:Ljava/lang/String;

    const-string v1, "LIFE_EVENTS_PRODUCT_SCAN"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 143
    const v0, 0x7f03001d

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->setContentView(I)V

    .line 144
    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 145
    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 146
    const v2, 0x7f080204

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 147
    new-instance v1, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity$2;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity$2;-><init>(Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_0

    .line 155
    :cond_6
    const v0, 0x7f03001c

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->setContentView(I)V

    goto/16 :goto_0
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    invoke-static {p0}, Lp;->d(Landroid/app/Activity;)V

    .line 266
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->n:Lmc;

    invoke-virtual {v0}, Lmc;->b()V

    .line 267
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 268
    return-void
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 3

    .prologue
    const/4 v0, 0x1

    .line 272
    const/4 v1, 0x4

    if-ne p1, v1, :cond_3

    .line 273
    iget-object v1, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->i:Lbr;

    sget-object v2, Lbr;->a:Lbr;

    if-ne v1, v2, :cond_1

    .line 274
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->setResult(I)V

    .line 275
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->finish()V

    .line 288
    :cond_0
    :goto_0
    return v0

    .line 277
    :cond_1
    iget-object v1, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->i:Lbr;

    sget-object v2, Lbr;->d:Lbr;

    if-eq v1, v2, :cond_2

    iget-object v1, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->i:Lbr;

    sget-object v2, Lbr;->c:Lbr;

    if-ne v1, v2, :cond_4

    :cond_2
    iget-object v1, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->g:Lcom/google/zxing/Result;

    if-eqz v1, :cond_4

    .line 278
    invoke-direct {p0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->g()V

    .line 279
    iget-object v1, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->c:Llw;

    if-eqz v1, :cond_0

    .line 280
    iget-object v1, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->c:Llw;

    const v2, 0x7f0c0006

    invoke-virtual {v1, v2}, Llw;->sendEmptyMessage(I)Z

    goto :goto_0

    .line 284
    :cond_3
    const/16 v1, 0x50

    if-eq p1, v1, :cond_0

    const/16 v1, 0x1b

    if-eq p1, v1, :cond_0

    .line 288
    :cond_4
    invoke-super {p0, p1, p2}, Landroid/app/Activity;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method protected onPause()V
    .locals 3

    .prologue
    invoke-static {p0}, Lp;->g(Landroid/app/Activity;)V

    .line 251
    invoke-super {p0}, Landroid/app/Activity;->onPause()V

    .line 252
    invoke-static {}, Llu;->a()V

    .line 253
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->c:Llw;

    if-eqz v0, :cond_0

    .line 254
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->c:Llw;

    invoke-virtual {v0}, Llw;->a()V

    .line 255
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->c:Llw;

    .line 257
    :cond_0
    invoke-static {}, Lmj;->a()Lmj;

    move-result-object v0

    invoke-virtual {v0}, Lmj;->b()V

    .line 258
    sget-boolean v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->a:Z

    if-eqz v0, :cond_1

    .line 260
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->stopService(Landroid/content/Intent;)Z

    .line 262
    :cond_1
    return-void
.end method

.method protected onRestart()V
    .locals 0

    invoke-super {p0}, Landroid/app/Activity;->onRestart()V

    invoke-static {p0}, Lp;->e(Landroid/app/Activity;)V

    return-void
.end method

.method protected onResume()V
    .locals 5

    .prologue
    const/4 v1, 0x0

    invoke-static {p0}, Lp;->f(Landroid/app/Activity;)V

    .line 189
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 190
    invoke-static {p0}, Llu;->a(Landroid/app/Activity;)V

    .line 191
    invoke-direct {p0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->g()V

    .line 193
    const v0, 0x7f0c0086

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->s:Landroid/widget/RelativeLayout;

    .line 194
    const v0, 0x7f0c009d

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    .line 195
    new-instance v2, Landroid/view/SurfaceView;

    invoke-direct {v2, p0}, Landroid/view/SurfaceView;-><init>(Landroid/content/Context;)V

    iput-object v2, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->t:Landroid/view/SurfaceView;

    .line 196
    iget-object v2, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->t:Landroid/view/SurfaceView;

    invoke-virtual {v2}, Landroid/view/SurfaceView;->getHolder()Landroid/view/SurfaceHolder;

    move-result-object v2

    .line 197
    iget-boolean v3, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->h:Z

    if-eqz v3, :cond_3

    .line 200
    invoke-direct {p0, v2}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->a(Landroid/view/SurfaceHolder;)V

    .line 206
    :goto_0
    iget-object v2, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->t:Landroid/view/SurfaceView;

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->s:Landroid/widget/RelativeLayout;

    if-eqz v2, :cond_0

    .line 207
    iget-object v2, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->s:Landroid/widget/RelativeLayout;

    iget-object v3, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->t:Landroid/view/SurfaceView;

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;)V

    .line 208
    if-eqz v0, :cond_0

    .line 210
    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->bringToFront()V

    .line 213
    :cond_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    .line 214
    if-nez v3, :cond_4

    move-object v2, v1

    .line 215
    :goto_1
    if-nez v3, :cond_5

    move-object v0, v1

    .line 216
    :goto_2
    if-eqz v3, :cond_8

    if-eqz v2, :cond_8

    .line 217
    const-string v4, "com.google.zxing.client.android.SCAN"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 219
    sget-object v0, Lbr;->a:Lbr;

    iput-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->i:Lbr;

    .line 220
    invoke-static {v3}, Lly;->a(Landroid/content/Intent;)Ljava/util/Vector;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->l:Ljava/util/Vector;

    .line 232
    :goto_3
    const-string v0, "CHARACTER_SET"

    invoke-virtual {v3, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->m:Ljava/lang/String;

    .line 238
    :goto_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->o:Llv;

    invoke-virtual {v0}, Llv;->a()V

    .line 240
    invoke-static {}, Lcom/inc247/ApplicationStatusModel/ChatRunningStatus;->getChatRunning()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 241
    invoke-static {}, Lcom/inc247/ChatSDK;->getSDKInstance()Lcom/inc247/ChatSDK;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/inc247/ChatSDK;->addChat(Landroid/app/Activity;)V

    .line 243
    :cond_1
    sget-boolean v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->a:Z

    if-eqz v0, :cond_2

    .line 245
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;

    .line 247
    :cond_2
    return-void

    .line 203
    :cond_3
    invoke-interface {v2, p0}, Landroid/view/SurfaceHolder;->addCallback(Landroid/view/SurfaceHolder$Callback;)V

    .line 204
    const/4 v3, 0x3

    invoke-interface {v2, v3}, Landroid/view/SurfaceHolder;->setType(I)V

    goto :goto_0

    .line 214
    :cond_4
    invoke-virtual {v3}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    move-object v2, v0

    goto :goto_1

    .line 215
    :cond_5
    invoke-virtual {v3}, Landroid/content/Intent;->getDataString()Ljava/lang/String;

    move-result-object v0

    goto :goto_2

    .line 221
    :cond_6
    if-eqz v0, :cond_7

    const-string v2, "http://www.google"

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_7

    const-string v2, "/m/products/scan"

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 224
    sget-object v1, Lbr;->b:Lbr;

    iput-object v1, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->i:Lbr;

    .line 225
    iput-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->j:Ljava/lang/String;

    .line 226
    sget-object v0, Lly;->a:Ljava/util/Vector;

    iput-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->l:Ljava/util/Vector;

    goto :goto_3

    .line 229
    :cond_7
    sget-object v0, Lbr;->d:Lbr;

    iput-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->i:Lbr;

    .line 230
    iput-object v1, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->l:Ljava/util/Vector;

    goto :goto_3

    .line 234
    :cond_8
    sget-object v0, Lbr;->d:Lbr;

    iput-object v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->i:Lbr;

    .line 235
    iput-object v1, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->l:Ljava/util/Vector;

    .line 236
    iput-object v1, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->m:Ljava/lang/String;

    goto :goto_4
.end method

.method protected onStart()V
    .locals 0

    invoke-super {p0}, Landroid/app/Activity;->onStart()V

    invoke-static {p0}, Lp;->b(Landroid/app/Activity;)V

    return-void
.end method

.method protected onStop()V
    .locals 0

    invoke-super {p0}, Landroid/app/Activity;->onStop()V

    invoke-static {p0}, Lp;->c(Landroid/app/Activity;)V

    return-void
.end method

.method public surfaceChanged(Landroid/view/SurfaceHolder;III)V
    .locals 0

    .prologue
    .line 310
    return-void
.end method

.method public surfaceCreated(Landroid/view/SurfaceHolder;)V
    .locals 1

    .prologue
    .line 298
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->h:Z

    if-nez v0, :cond_0

    .line 299
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->h:Z

    .line 300
    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->a(Landroid/view/SurfaceHolder;)V

    .line 302
    :cond_0
    return-void
.end method

.method public surfaceDestroyed(Landroid/view/SurfaceHolder;)V
    .locals 1

    .prologue
    .line 305
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/bbyscan/CaptureQRCodeActivity;->h:Z

    .line 306
    return-void
.end method
