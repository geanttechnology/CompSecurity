.class public final Lcom/google/android/gms/internal/at;
.super Ljava/lang/Object;


# instance fields
.field public final a:I

.field public final b:Lcom/google/android/gms/internal/an;

.field public final c:Lcom/google/android/gms/internal/bq;

.field public final d:Ljava/lang/String;

.field public final e:Lcom/google/android/gms/internal/aq;


# direct methods
.method public constructor <init>(I)V
    .locals 6

    const/4 v1, 0x0

    move-object v0, p0

    move-object v2, v1

    move-object v3, v1

    move-object v4, v1

    move v5, p1

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/at;-><init>(Lcom/google/android/gms/internal/an;Lcom/google/android/gms/internal/bq;Ljava/lang/String;Lcom/google/android/gms/internal/aq;I)V

    return-void
.end method

.method public constructor <init>(Lcom/google/android/gms/internal/an;Lcom/google/android/gms/internal/bq;Ljava/lang/String;Lcom/google/android/gms/internal/aq;I)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput-object p1, p0, Lcom/google/android/gms/internal/at;->b:Lcom/google/android/gms/internal/an;

    iput-object p2, p0, Lcom/google/android/gms/internal/at;->c:Lcom/google/android/gms/internal/bq;

    iput-object p3, p0, Lcom/google/android/gms/internal/at;->d:Ljava/lang/String;

    iput-object p4, p0, Lcom/google/android/gms/internal/at;->e:Lcom/google/android/gms/internal/aq;

    iput p5, p0, Lcom/google/android/gms/internal/at;->a:I

    return-void
.end method
