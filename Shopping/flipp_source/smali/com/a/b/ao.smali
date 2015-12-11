.class public final Lcom/a/b/ao;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field public final a:Landroid/net/Uri;

.field public final b:I

.field public final c:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/a/b/ay;",
            ">;"
        }
    .end annotation
.end field

.field public final d:I

.field public final e:I

.field public final f:Z

.field public final g:Z

.field public final h:F

.field public final i:F

.field public final j:F

.field public final k:Z

.field public final l:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end field

.field public final m:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<[B>;"
        }
    .end annotation
.end field

.field public final n:I

.field public final o:Ljava/util/concurrent/atomic/AtomicInteger;


# direct methods
.method private constructor <init>(Landroid/net/Uri;ILjava/util/List;IIZZFFFZLandroid/graphics/Bitmap;[BILjava/util/concurrent/atomic/AtomicInteger;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/net/Uri;",
            "I",
            "Ljava/util/List",
            "<",
            "Lcom/a/b/ay;",
            ">;IIZZFFFZ",
            "Landroid/graphics/Bitmap;",
            "[BI",
            "Ljava/util/concurrent/atomic/AtomicInteger;",
            ")V"
        }
    .end annotation

    .prologue
    .line 80
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 81
    iput-object p1, p0, Lcom/a/b/ao;->a:Landroid/net/Uri;

    .line 82
    iput p2, p0, Lcom/a/b/ao;->b:I

    .line 83
    if-nez p3, :cond_0

    .line 84
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/a/b/ao;->c:Ljava/util/List;

    .line 88
    :goto_0
    iput p4, p0, Lcom/a/b/ao;->d:I

    .line 89
    iput p5, p0, Lcom/a/b/ao;->e:I

    .line 90
    iput-boolean p6, p0, Lcom/a/b/ao;->f:Z

    .line 91
    iput-boolean p7, p0, Lcom/a/b/ao;->g:Z

    .line 92
    iput p8, p0, Lcom/a/b/ao;->h:F

    .line 93
    iput p9, p0, Lcom/a/b/ao;->i:F

    .line 94
    iput p10, p0, Lcom/a/b/ao;->j:F

    .line 95
    iput-boolean p11, p0, Lcom/a/b/ao;->k:Z

    .line 96
    new-instance v1, Ljava/lang/ref/WeakReference;

    invoke-direct {v1, p12}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v1, p0, Lcom/a/b/ao;->l:Ljava/lang/ref/WeakReference;

    .line 97
    new-instance v1, Ljava/lang/ref/WeakReference;

    invoke-direct {v1, p13}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v1, p0, Lcom/a/b/ao;->m:Ljava/lang/ref/WeakReference;

    .line 98
    move/from16 v0, p14

    iput v0, p0, Lcom/a/b/ao;->n:I

    .line 99
    move-object/from16 v0, p15

    iput-object v0, p0, Lcom/a/b/ao;->o:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 100
    return-void

    .line 86
    :cond_0
    invoke-static {p3}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v1

    iput-object v1, p0, Lcom/a/b/ao;->c:Ljava/util/List;

    goto :goto_0
.end method

.method synthetic constructor <init>(Landroid/net/Uri;ILjava/util/List;IIZZFFFZLandroid/graphics/Bitmap;[BILjava/util/concurrent/atomic/AtomicInteger;B)V
    .locals 0

    .prologue
    .line 29
    invoke-direct/range {p0 .. p15}, Lcom/a/b/ao;-><init>(Landroid/net/Uri;ILjava/util/List;IIZZFFFZLandroid/graphics/Bitmap;[BILjava/util/concurrent/atomic/AtomicInteger;)V

    return-void
.end method


# virtual methods
.method public final a()Z
    .locals 1

    .prologue
    .line 110
    iget v0, p0, Lcom/a/b/ao;->d:I

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method final b()Z
    .locals 2

    .prologue
    .line 118
    iget v0, p0, Lcom/a/b/ao;->d:I

    if-nez v0, :cond_0

    iget v0, p0, Lcom/a/b/ao;->h:F

    const/4 v1, 0x0

    cmpl-float v0, v0, v1

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method final c()Z
    .locals 1

    .prologue
    .line 122
    iget-object v0, p0, Lcom/a/b/ao;->c:Ljava/util/List;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
