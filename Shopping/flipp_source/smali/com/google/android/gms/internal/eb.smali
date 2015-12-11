.class public final Lcom/google/android/gms/internal/eb;
.super Ljava/lang/Object;


# instance fields
.field public final a:Lcom/google/android/gms/internal/v;

.field public final b:Lcom/google/android/gms/internal/ew;

.field public final c:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public final d:I

.field public final e:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public final f:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field public final g:I

.field public final h:J

.field public final i:Ljava/lang/String;

.field public final j:Z

.field public final k:Lcom/google/android/gms/internal/an;

.field public final l:Lcom/google/android/gms/internal/bq;

.field public final m:Ljava/lang/String;

.field public final n:Lcom/google/android/gms/internal/ao;

.field public final o:Lcom/google/android/gms/internal/aq;

.field public final p:J

.field public final q:Lcom/google/android/gms/internal/x;

.field public final r:J


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/v;Lcom/google/android/gms/internal/ew;Ljava/util/List;ILjava/util/List;Ljava/util/List;IJLjava/lang/String;ZLcom/google/android/gms/internal/an;Lcom/google/android/gms/internal/bq;Ljava/lang/String;Lcom/google/android/gms/internal/ao;Lcom/google/android/gms/internal/aq;JLcom/google/android/gms/internal/x;J)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/v;",
            "Lcom/google/android/gms/internal/ew;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;I",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;IJ",
            "Ljava/lang/String;",
            "Z",
            "Lcom/google/android/gms/internal/an;",
            "Lcom/google/android/gms/internal/bq;",
            "Ljava/lang/String;",
            "Lcom/google/android/gms/internal/ao;",
            "Lcom/google/android/gms/internal/aq;",
            "J",
            "Lcom/google/android/gms/internal/x;",
            "J)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/eb;->a:Lcom/google/android/gms/internal/v;

    iput-object p2, p0, Lcom/google/android/gms/internal/eb;->b:Lcom/google/android/gms/internal/ew;

    if-eqz p3, :cond_0

    invoke-static {p3}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v2

    :goto_0
    iput-object v2, p0, Lcom/google/android/gms/internal/eb;->c:Ljava/util/List;

    iput p4, p0, Lcom/google/android/gms/internal/eb;->d:I

    if-eqz p5, :cond_1

    invoke-static {p5}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v2

    :goto_1
    iput-object v2, p0, Lcom/google/android/gms/internal/eb;->e:Ljava/util/List;

    if-eqz p6, :cond_2

    invoke-static {p6}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v2

    :goto_2
    iput-object v2, p0, Lcom/google/android/gms/internal/eb;->f:Ljava/util/List;

    iput p7, p0, Lcom/google/android/gms/internal/eb;->g:I

    iput-wide p8, p0, Lcom/google/android/gms/internal/eb;->h:J

    iput-object p10, p0, Lcom/google/android/gms/internal/eb;->i:Ljava/lang/String;

    iput-boolean p11, p0, Lcom/google/android/gms/internal/eb;->j:Z

    move-object/from16 v0, p12

    iput-object v0, p0, Lcom/google/android/gms/internal/eb;->k:Lcom/google/android/gms/internal/an;

    move-object/from16 v0, p13

    iput-object v0, p0, Lcom/google/android/gms/internal/eb;->l:Lcom/google/android/gms/internal/bq;

    move-object/from16 v0, p14

    iput-object v0, p0, Lcom/google/android/gms/internal/eb;->m:Ljava/lang/String;

    move-object/from16 v0, p15

    iput-object v0, p0, Lcom/google/android/gms/internal/eb;->n:Lcom/google/android/gms/internal/ao;

    move-object/from16 v0, p16

    iput-object v0, p0, Lcom/google/android/gms/internal/eb;->o:Lcom/google/android/gms/internal/aq;

    move-wide/from16 v0, p17

    iput-wide v0, p0, Lcom/google/android/gms/internal/eb;->p:J

    move-object/from16 v0, p19

    iput-object v0, p0, Lcom/google/android/gms/internal/eb;->q:Lcom/google/android/gms/internal/x;

    move-wide/from16 v0, p20

    iput-wide v0, p0, Lcom/google/android/gms/internal/eb;->r:J

    return-void

    :cond_0
    const/4 v2, 0x0

    goto :goto_0

    :cond_1
    const/4 v2, 0x0

    goto :goto_1

    :cond_2
    const/4 v2, 0x0

    goto :goto_2
.end method
