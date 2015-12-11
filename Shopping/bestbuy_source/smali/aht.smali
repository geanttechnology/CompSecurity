.class public final Laht;
.super Ljava/lang/Object;


# instance fields
.field private a:Ljava/lang/String;

.field private b:I

.field private c:J

.field private d:S

.field private e:D

.field private f:D

.field private g:F

.field private h:I

.field private i:I


# direct methods
.method public constructor <init>()V
    .locals 4

    const/4 v3, 0x0

    const/4 v2, -0x1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Laht;->a:Ljava/lang/String;

    iput v3, p0, Laht;->b:I

    const-wide/high16 v0, -0x8000000000000000L

    iput-wide v0, p0, Laht;->c:J

    iput-short v2, p0, Laht;->d:S

    iput v3, p0, Laht;->h:I

    iput v2, p0, Laht;->i:I

    return-void
.end method


# virtual methods
.method public a()Lahs;
    .locals 13

    iget-object v0, p0, Laht;->a:Ljava/lang/String;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Request ID not set."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iget v0, p0, Laht;->b:I

    if-nez v0, :cond_1

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Transitions types not set."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    iget v0, p0, Laht;->b:I

    and-int/lit8 v0, v0, 0x4

    if-eqz v0, :cond_2

    iget v0, p0, Laht;->i:I

    if-gez v0, :cond_2

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Non-negative loitering delay needs to be set when transition types include GEOFENCE_TRANSITION_DWELLING."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_2
    iget-wide v0, p0, Laht;->c:J

    const-wide/high16 v2, -0x8000000000000000L

    cmp-long v0, v0, v2

    if-nez v0, :cond_3

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Expiration not set."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_3
    iget-short v0, p0, Laht;->d:S

    const/4 v1, -0x1

    if-ne v0, v1, :cond_4

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Geofence region not set."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_4
    iget v0, p0, Laht;->h:I

    if-gez v0, :cond_5

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Notification responsiveness should be nonnegative."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_5
    new-instance v0, Lcom/google/android/gms/internal/nn;

    iget-object v1, p0, Laht;->a:Ljava/lang/String;

    iget v2, p0, Laht;->b:I

    const/4 v3, 0x1

    iget-wide v4, p0, Laht;->e:D

    iget-wide v6, p0, Laht;->f:D

    iget v8, p0, Laht;->g:F

    iget-wide v9, p0, Laht;->c:J

    iget v11, p0, Laht;->h:I

    iget v12, p0, Laht;->i:I

    invoke-direct/range {v0 .. v12}, Lcom/google/android/gms/internal/nn;-><init>(Ljava/lang/String;ISDDFJII)V

    return-object v0
.end method

.method public a(DDF)Laht;
    .locals 1

    const/4 v0, 0x1

    iput-short v0, p0, Laht;->d:S

    iput-wide p1, p0, Laht;->e:D

    iput-wide p3, p0, Laht;->f:D

    iput p5, p0, Laht;->g:F

    return-object p0
.end method

.method public a(I)Laht;
    .locals 0

    iput p1, p0, Laht;->b:I

    return-object p0
.end method

.method public a(J)Laht;
    .locals 3

    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-gez v0, :cond_0

    const-wide/16 v0, -0x1

    iput-wide v0, p0, Laht;->c:J

    :goto_0
    return-object p0

    :cond_0
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    add-long/2addr v0, p1

    iput-wide v0, p0, Laht;->c:J

    goto :goto_0
.end method

.method public a(Ljava/lang/String;)Laht;
    .locals 0

    iput-object p1, p0, Laht;->a:Ljava/lang/String;

    return-object p0
.end method
