.class public Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
.super Lcom/googlecode/javacpp/Pointer;
.source "opencv_core.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/googlecode/javacv/cpp/opencv_core;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "CvScalar"
.end annotation


# static fields
.field public static final ALPHA1:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

.field public static final ALPHA255:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

.field public static final BLACK:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

.field public static final BLUE:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

.field public static final CYAN:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

.field public static final GRAY:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

.field public static final GREEN:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

.field public static final MAGENTA:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

.field public static final ONE:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

.field public static final ONEHALF:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

.field public static final RED:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

.field public static final WHITE:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

.field public static final YELLOW:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

.field public static final ZERO:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;


# direct methods
.method static constructor <clinit>()V
    .locals 12

    .prologue
    const/4 v11, 0x1

    const/4 v10, 0x0

    const-wide/high16 v6, 0x3ff0000000000000L    # 1.0

    const-wide v0, 0x406fe00000000000L    # 255.0

    const-wide/16 v8, 0x0

    .line 2388
    invoke-static {}, Lcom/googlecode/javacpp/Loader;->load()Ljava/lang/String;

    .line 2451
    new-instance v2, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    invoke-direct {v2}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;-><init>()V

    invoke-virtual {v2, v10, v8, v9}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    invoke-virtual {v2, v11, v8, v9}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    const/4 v3, 0x2

    invoke-virtual {v2, v3, v8, v9}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    const/4 v3, 0x3

    invoke-virtual {v2, v3, v8, v9}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    sput-object v2, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->ZERO:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    .line 2452
    new-instance v2, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    invoke-direct {v2}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;-><init>()V

    invoke-virtual {v2, v10, v6, v7}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    invoke-virtual {v2, v11, v6, v7}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    const/4 v3, 0x2

    invoke-virtual {v2, v3, v6, v7}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    const/4 v3, 0x3

    invoke-virtual {v2, v3, v6, v7}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    sput-object v2, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->ONE:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    .line 2453
    new-instance v2, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    invoke-direct {v2}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;-><init>()V

    const-wide/high16 v3, 0x3fe0000000000000L    # 0.5

    invoke-virtual {v2, v10, v3, v4}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    const-wide/high16 v3, 0x3fe0000000000000L    # 0.5

    invoke-virtual {v2, v11, v3, v4}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    const/4 v3, 0x2

    const-wide/high16 v4, 0x3fe0000000000000L    # 0.5

    invoke-virtual {v2, v3, v4, v5}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    const/4 v3, 0x3

    const-wide/high16 v4, 0x3fe0000000000000L    # 0.5

    invoke-virtual {v2, v3, v4, v5}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    sput-object v2, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->ONEHALF:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    .line 2454
    new-instance v2, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    invoke-direct {v2}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;-><init>()V

    invoke-virtual {v2, v10, v8, v9}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    invoke-virtual {v2, v11, v8, v9}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    const/4 v3, 0x2

    invoke-virtual {v2, v3, v8, v9}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    const/4 v3, 0x3

    invoke-virtual {v2, v3, v6, v7}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    sput-object v2, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->ALPHA1:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    .line 2455
    new-instance v2, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    invoke-direct {v2}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;-><init>()V

    invoke-virtual {v2, v10, v8, v9}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    invoke-virtual {v2, v11, v8, v9}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    const/4 v3, 0x2

    invoke-virtual {v2, v3, v8, v9}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    const/4 v3, 0x3

    invoke-virtual {v2, v3, v0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    sput-object v2, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->ALPHA255:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-wide v2, v0

    move-wide v4, v0

    .line 2457
    invoke-static/range {v0 .. v5}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_RGB(DDD)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    sput-object v2, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->WHITE:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    .line 2458
    const-wide/high16 v2, 0x4060000000000000L    # 128.0

    const-wide/high16 v4, 0x4060000000000000L    # 128.0

    const-wide/high16 v6, 0x4060000000000000L    # 128.0

    invoke-static/range {v2 .. v7}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_RGB(DDD)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    sput-object v2, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->GRAY:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-wide v2, v8

    move-wide v4, v8

    move-wide v6, v8

    .line 2459
    invoke-static/range {v2 .. v7}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_RGB(DDD)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    sput-object v2, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->BLACK:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-wide v2, v8

    move-wide v4, v8

    .line 2460
    invoke-static/range {v0 .. v5}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_RGB(DDD)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    sput-object v2, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->RED:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-wide v2, v8

    move-wide v4, v0

    move-wide v6, v8

    .line 2461
    invoke-static/range {v2 .. v7}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_RGB(DDD)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    sput-object v2, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->GREEN:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-wide v2, v8

    move-wide v4, v8

    move-wide v6, v0

    .line 2462
    invoke-static/range {v2 .. v7}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_RGB(DDD)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    sput-object v2, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->BLUE:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-wide v2, v8

    move-wide v4, v0

    move-wide v6, v0

    .line 2463
    invoke-static/range {v2 .. v7}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_RGB(DDD)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    sput-object v2, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->CYAN:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-wide v2, v8

    move-wide v4, v0

    .line 2464
    invoke-static/range {v0 .. v5}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_RGB(DDD)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v2

    sput-object v2, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->MAGENTA:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-wide v2, v0

    move-wide v4, v8

    .line 2465
    invoke-static/range {v0 .. v5}, Lcom/googlecode/javacv/cpp/opencv_core;->CV_RGB(DDD)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v0

    sput-object v0, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->YELLOW:Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 2389
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->allocate()V

    return-void
.end method

.method public constructor <init>(DDDD)V
    .locals 2
    .param p1, "val0"    # D
    .param p3, "val1"    # D
    .param p5, "val2"    # D
    .param p7, "val3"    # D

    .prologue
    .line 2399
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    .line 2400
    invoke-direct {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->allocate()V

    const/4 v0, 0x0

    invoke-virtual {p0, v0, p1, p2}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1, p3, p4}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v0

    const/4 v1, 0x2

    invoke-virtual {v0, v1, p5, p6}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v0

    const/4 v1, 0x3

    invoke-virtual {v0, v1, p7, p8}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    .line 2401
    return-void
.end method

.method public constructor <init>(I)V
    .locals 0
    .param p1, "size"    # I

    .prologue
    .line 2390
    invoke-direct {p0}, Lcom/googlecode/javacpp/Pointer;-><init>()V

    invoke-direct {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->allocateArray(I)V

    return-void
.end method

.method public constructor <init>(Lcom/googlecode/javacpp/Pointer;)V
    .locals 0
    .param p1, "p"    # Lcom/googlecode/javacpp/Pointer;

    .prologue
    .line 2391
    invoke-direct {p0, p1}, Lcom/googlecode/javacpp/Pointer;-><init>(Lcom/googlecode/javacpp/Pointer;)V

    return-void
.end method

.method private native allocate()V
.end method

.method private native allocateArray(I)V
.end method


# virtual methods
.method public blue()D
    .locals 2

    .prologue
    .line 2421
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(I)D

    move-result-wide v0

    return-wide v0
.end method

.method public blue(D)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
    .locals 1
    .param p1, "b"    # D

    .prologue
    .line 2424
    const/4 v0, 0x0

    invoke-virtual {p0, v0, p1, p2}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    return-object p0
.end method

.method public native getDoublePointerVal()Lcom/googlecode/javacpp/DoublePointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/Name;
        value = {
            "val"
        }
    .end annotation
.end method

.method public native getLongPointerVal()Lcom/googlecode/javacpp/LongPointer;
    .annotation runtime Lcom/googlecode/javacpp/annotation/Cast;
        value = {
            "double*"
        }
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/MemberGetter;
    .end annotation

    .annotation runtime Lcom/googlecode/javacpp/annotation/Name;
        value = {
            "val"
        }
    .end annotation
.end method

.method public getVal(I)D
    .locals 2
    .param p1, "i"    # I

    .prologue
    .line 2404
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(I)D

    move-result-wide v0

    return-wide v0
.end method

.method public green()D
    .locals 2

    .prologue
    .line 2420
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(I)D

    move-result-wide v0

    return-wide v0
.end method

.method public green(D)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
    .locals 1
    .param p1, "g"    # D

    .prologue
    .line 2423
    const/4 v0, 0x1

    invoke-virtual {p0, v0, p1, p2}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    return-object p0
.end method

.method public magnitude()D
    .locals 8

    .prologue
    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v4, 0x1

    const/4 v2, 0x0

    .line 2427
    invoke-virtual {p0, v2}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(I)D

    move-result-wide v0

    invoke-virtual {p0, v2}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(I)D

    move-result-wide v2

    mul-double/2addr v0, v2

    invoke-virtual {p0, v4}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(I)D

    move-result-wide v2

    invoke-virtual {p0, v4}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(I)D

    move-result-wide v4

    mul-double/2addr v2, v4

    add-double/2addr v0, v2

    invoke-virtual {p0, v6}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(I)D

    move-result-wide v2

    invoke-virtual {p0, v6}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(I)D

    move-result-wide v4

    mul-double/2addr v2, v4

    add-double/2addr v0, v2

    invoke-virtual {p0, v7}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(I)D

    move-result-wide v2

    invoke-virtual {p0, v7}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(I)D

    move-result-wide v4

    mul-double/2addr v2, v4

    add-double/2addr v0, v2

    invoke-static {v0, v1}, Ljava/lang/Math;->sqrt(D)D

    move-result-wide v0

    return-wide v0
.end method

.method public bridge synthetic position(I)Lcom/googlecode/javacpp/Pointer;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 2387
    invoke-virtual {p0, p1}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v0

    return-object v0
.end method

.method public position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 2396
    invoke-super {p0, p1}, Lcom/googlecode/javacpp/Pointer;->position(I)Lcom/googlecode/javacpp/Pointer;

    move-result-object v0

    check-cast v0, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    return-object v0
.end method

.method public red()D
    .locals 2

    .prologue
    .line 2419
    const/4 v0, 0x2

    invoke-virtual {p0, v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(I)D

    move-result-wide v0

    return-wide v0
.end method

.method public red(D)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
    .locals 1
    .param p1, "r"    # D

    .prologue
    .line 2422
    const/4 v0, 0x2

    invoke-virtual {p0, v0, p1, p2}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    return-object p0
.end method

.method public scale(D)V
    .locals 3
    .param p1, "s"    # D

    .prologue
    .line 2414
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    const/4 v1, 0x4

    if-ge v0, v1, :cond_0

    .line 2415
    invoke-virtual {p0, v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(I)D

    move-result-wide v1

    mul-double/2addr v1, p1

    invoke-virtual {p0, v0, v1, v2}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    .line 2414
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 2417
    :cond_0
    return-void
.end method

.method public setVal(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
    .locals 1
    .param p1, "i"    # I
    .param p2, "val"    # D

    .prologue
    .line 2405
    invoke-virtual {p0, p1, p2, p3}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    move-result-object v0

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 10

    .prologue
    const/4 v9, 0x3

    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 2431
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->isNull()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 2432
    invoke-super {p0}, Lcom/googlecode/javacpp/Pointer;->toString()Ljava/lang/String;

    move-result-object v2

    .line 2446
    :goto_0
    return-object v2

    .line 2434
    :cond_0
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->capacity()I

    move-result v3

    if-nez v3, :cond_1

    .line 2435
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "("

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0, v6}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(I)D

    move-result-wide v4

    double-to-float v4, v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0, v7}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(I)D

    move-result-wide v4

    double-to-float v4, v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0, v8}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(I)D

    move-result-wide v4

    double-to-float v4, v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0, v9}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(I)D

    move-result-wide v4

    double-to-float v4, v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ")"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 2438
    :cond_1
    const-string v2, ""

    .line 2439
    .local v2, "s":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->position()I

    move-result v1

    .line 2440
    .local v1, "p":I
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    invoke-virtual {p0}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->capacity()I

    move-result v3

    if-ge v0, v3, :cond_3

    .line 2441
    invoke-virtual {p0, v0}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    .line 2442
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    if-nez v0, :cond_2

    const-string v3, "("

    :goto_2
    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0, v6}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(I)D

    move-result-wide v4

    double-to-float v4, v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0, v7}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(I)D

    move-result-wide v4

    double-to-float v4, v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0, v8}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(I)D

    move-result-wide v4

    double-to-float v4, v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0, v9}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->val(I)D

    move-result-wide v4

    double-to-float v4, v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ")"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 2440
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 2442
    :cond_2
    const-string v3, " ("

    goto :goto_2

    .line 2445
    :cond_3
    invoke-virtual {p0, v1}, Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;->position(I)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;

    goto/16 :goto_0
.end method

.method public native val(I)D
.end method

.method public native val(ID)Lcom/googlecode/javacv/cpp/opencv_core$CvScalar;
.end method
