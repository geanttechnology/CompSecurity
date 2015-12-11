.class public final Lcom/google/android/gms/drive/internal/h;
.super Lcom/google/android/gms/internal/kf;


# static fields
.field public static final a:[Lcom/google/android/gms/drive/internal/h;


# instance fields
.field public b:I

.field public c:Ljava/lang/String;

.field public d:J

.field public e:J

.field private g:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    const/4 v0, 0x0

    new-array v0, v0, [Lcom/google/android/gms/drive/internal/h;

    sput-object v0, Lcom/google/android/gms/drive/internal/h;->a:[Lcom/google/android/gms/drive/internal/h;

    return-void
.end method

.method public constructor <init>()V
    .locals 4

    const-wide/16 v2, -0x1

    invoke-direct {p0}, Lcom/google/android/gms/internal/kf;-><init>()V

    const/4 v0, 0x1

    iput v0, p0, Lcom/google/android/gms/drive/internal/h;->b:I

    const-string v0, ""

    iput-object v0, p0, Lcom/google/android/gms/drive/internal/h;->c:Ljava/lang/String;

    iput-wide v2, p0, Lcom/google/android/gms/drive/internal/h;->d:J

    iput-wide v2, p0, Lcom/google/android/gms/drive/internal/h;->e:J

    const/4 v0, -0x1

    iput v0, p0, Lcom/google/android/gms/drive/internal/h;->g:I

    return-void
.end method


# virtual methods
.method public final a()I
    .locals 4

    iget v0, p0, Lcom/google/android/gms/drive/internal/h;->b:I

    const/4 v1, 0x1

    invoke-static {v1}, Lcom/google/android/gms/internal/kd;->a(I)I

    move-result v1

    if-ltz v0, :cond_0

    invoke-static {v0}, Lcom/google/android/gms/internal/kd;->c(I)I

    move-result v0

    :goto_0
    add-int/2addr v0, v1

    add-int/lit8 v0, v0, 0x0

    iget-object v1, p0, Lcom/google/android/gms/drive/internal/h;->c:Ljava/lang/String;

    const/4 v2, 0x2

    invoke-static {v2}, Lcom/google/android/gms/internal/kd;->a(I)I

    move-result v2

    invoke-static {v1}, Lcom/google/android/gms/internal/kd;->a(Ljava/lang/String;)I

    move-result v1

    add-int/2addr v1, v2

    add-int/2addr v0, v1

    const/4 v1, 0x3

    iget-wide v2, p0, Lcom/google/android/gms/drive/internal/h;->d:J

    invoke-static {v1, v2, v3}, Lcom/google/android/gms/internal/kd;->b(IJ)I

    move-result v1

    add-int/2addr v0, v1

    const/4 v1, 0x4

    iget-wide v2, p0, Lcom/google/android/gms/drive/internal/h;->e:J

    invoke-static {v1, v2, v3}, Lcom/google/android/gms/internal/kd;->b(IJ)I

    move-result v1

    add-int/2addr v0, v1

    iput v0, p0, Lcom/google/android/gms/drive/internal/h;->g:I

    return v0

    :cond_0
    const/16 v0, 0xa

    goto :goto_0
.end method

.method public final a(Lcom/google/android/gms/internal/kd;)V
    .locals 4

    iget v0, p0, Lcom/google/android/gms/drive/internal/h;->b:I

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-virtual {p1, v1, v2}, Lcom/google/android/gms/internal/kd;->a(II)V

    if-ltz v0, :cond_0

    invoke-virtual {p1, v0}, Lcom/google/android/gms/internal/kd;->b(I)V

    :goto_0
    const/4 v0, 0x2

    iget-object v1, p0, Lcom/google/android/gms/drive/internal/h;->c:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Lcom/google/android/gms/internal/kd;->a(ILjava/lang/String;)V

    const/4 v0, 0x3

    iget-wide v2, p0, Lcom/google/android/gms/drive/internal/h;->d:J

    invoke-virtual {p1, v0, v2, v3}, Lcom/google/android/gms/internal/kd;->a(IJ)V

    const/4 v0, 0x4

    iget-wide v2, p0, Lcom/google/android/gms/drive/internal/h;->e:J

    invoke-virtual {p1, v0, v2, v3}, Lcom/google/android/gms/internal/kd;->a(IJ)V

    return-void

    :cond_0
    int-to-long v0, v0

    invoke-virtual {p1, v0, v1}, Lcom/google/android/gms/internal/kd;->a(J)V

    goto :goto_0
.end method
