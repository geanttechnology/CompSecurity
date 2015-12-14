.class Lcom/google/android/gms/analytics/internal/zzaj;
.super Ljava/lang/Object;


# instance fields
.field private zzOC:J

.field private final zzpO:Lcom/google/android/gms/internal/zzlm;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/zzlm;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-static {p1}, Lcom/google/android/gms/common/internal/zzx;->zzv(Ljava/lang/Object;)Ljava/lang/Object;

    iput-object p1, p0, Lcom/google/android/gms/analytics/internal/zzaj;->zzpO:Lcom/google/android/gms/internal/zzlm;

    return-void
.end method

.method public constructor <init>(Lcom/google/android/gms/internal/zzlm;J)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    invoke-static {p1}, Lcom/google/android/gms/common/internal/zzx;->zzv(Ljava/lang/Object;)Ljava/lang/Object;

    iput-object p1, p0, Lcom/google/android/gms/analytics/internal/zzaj;->zzpO:Lcom/google/android/gms/internal/zzlm;

    iput-wide p2, p0, Lcom/google/android/gms/analytics/internal/zzaj;->zzOC:J

    return-void
.end method


# virtual methods
.method public clear()V
    .locals 2

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/google/android/gms/analytics/internal/zzaj;->zzOC:J

    return-void
.end method

.method public start()V
    .locals 2

    iget-object v0, p0, Lcom/google/android/gms/analytics/internal/zzaj;->zzpO:Lcom/google/android/gms/internal/zzlm;

    invoke-interface {v0}, Lcom/google/android/gms/internal/zzlm;->elapsedRealtime()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/google/android/gms/analytics/internal/zzaj;->zzOC:J

    return-void
.end method

.method public zzv(J)Z
    .locals 5

    const/4 v0, 0x1

    iget-wide v1, p0, Lcom/google/android/gms/analytics/internal/zzaj;->zzOC:J

    const-wide/16 v3, 0x0

    cmp-long v1, v1, v3

    if-nez v1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    iget-object v1, p0, Lcom/google/android/gms/analytics/internal/zzaj;->zzpO:Lcom/google/android/gms/internal/zzlm;

    invoke-interface {v1}, Lcom/google/android/gms/internal/zzlm;->elapsedRealtime()J

    move-result-wide v1

    iget-wide v3, p0, Lcom/google/android/gms/analytics/internal/zzaj;->zzOC:J

    sub-long/2addr v1, v3

    cmp-long v1, v1, p1

    if-gtz v1, :cond_0

    const/4 v0, 0x0

    goto :goto_0
.end method
