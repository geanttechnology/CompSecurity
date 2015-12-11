.class public final Lcom/google/android/gms/internal/hb;
.super Lcom/google/android/gms/internal/iz;

# interfaces
.implements Lcom/google/android/gms/common/internal/safeparcel/SafeParcelable;


# static fields
.field public static final CREATOR:Lcom/google/android/gms/internal/ji;

.field private static final e:Lcom/google/android/gms/internal/hb;


# instance fields
.field final a:I

.field final b:[Lcom/google/android/gms/internal/hd;

.field final c:[F

.field final d:J


# direct methods
.method static constructor <clinit>()V
    .locals 6

    const/4 v1, 0x0

    new-instance v0, Lcom/google/android/gms/internal/ji;

    invoke-direct {v0}, Lcom/google/android/gms/internal/ji;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/hb;->CREATOR:Lcom/google/android/gms/internal/ji;

    new-instance v0, Lcom/google/android/gms/internal/hb;

    new-array v2, v1, [Lcom/google/android/gms/internal/hd;

    new-array v3, v1, [F

    const-wide/16 v4, 0x0

    invoke-direct/range {v0 .. v5}, Lcom/google/android/gms/internal/hb;-><init>(I[Lcom/google/android/gms/internal/hd;[FJ)V

    sput-object v0, Lcom/google/android/gms/internal/hb;->e:Lcom/google/android/gms/internal/hb;

    return-void
.end method

.method constructor <init>(I[Lcom/google/android/gms/internal/hd;[FJ)V
    .locals 2

    invoke-direct {p0}, Lcom/google/android/gms/internal/iz;-><init>()V

    array-length v0, p2

    array-length v1, p3

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    const-string v1, "mismatched places to probabilities arrays"

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/ha;->a(ZLjava/lang/Object;)V

    iput p1, p0, Lcom/google/android/gms/internal/hb;->a:I

    iput-object p2, p0, Lcom/google/android/gms/internal/hb;->b:[Lcom/google/android/gms/internal/hd;

    iput-object p3, p0, Lcom/google/android/gms/internal/hb;->c:[F

    iput-wide p4, p0, Lcom/google/android/gms/internal/hb;->d:J

    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public final describeContents()I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public final equals(Ljava/lang/Object;)Z
    .locals 4

    const/4 v0, 0x1

    const/4 v1, 0x0

    if-ne p0, p1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    instance-of v2, p1, Lcom/google/android/gms/internal/hb;

    if-nez v2, :cond_2

    move v0, v1

    goto :goto_0

    :cond_2
    check-cast p1, Lcom/google/android/gms/internal/hb;

    iget-object v2, p0, Lcom/google/android/gms/internal/hb;->b:[Lcom/google/android/gms/internal/hd;

    iget-object v3, p1, Lcom/google/android/gms/internal/hb;->b:[Lcom/google/android/gms/internal/hd;

    invoke-virtual {v2, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/google/android/gms/internal/hb;->c:[F

    iget-object v3, p1, Lcom/google/android/gms/internal/hb;->c:[F

    invoke-virtual {v2, v3}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    :cond_3
    move v0, v1

    goto :goto_0
.end method

.method public final hashCode()I
    .locals 3

    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/Object;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/google/android/gms/internal/hb;->b:[Lcom/google/android/gms/internal/hd;

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget-object v2, p0, Lcom/google/android/gms/internal/hb;->c:[F

    aput-object v2, v0, v1

    invoke-static {v0}, Ljava/util/Arrays;->hashCode([Ljava/lang/Object;)I

    move-result v0

    return v0
.end method

.method public final toString()Ljava/lang/String;
    .locals 7

    const/4 v1, 0x0

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v0, "PlaceEstimate{"

    invoke-direct {v2, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move v0, v1

    :goto_0
    iget-object v3, p0, Lcom/google/android/gms/internal/hb;->b:[Lcom/google/android/gms/internal/hd;

    array-length v3, v3

    if-ge v0, v3, :cond_1

    const-string v3, "(%f, %s)"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    iget-object v5, p0, Lcom/google/android/gms/internal/hb;->c:[F

    aget v5, v5, v0

    invoke-static {v5}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v5

    aput-object v5, v4, v1

    const/4 v5, 0x1

    iget-object v6, p0, Lcom/google/android/gms/internal/hb;->b:[Lcom/google/android/gms/internal/hd;

    aget-object v6, v6, v0

    invoke-virtual {v6}, Lcom/google/android/gms/internal/hd;->toString()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    iget-object v3, p0, Lcom/google/android/gms/internal/hb;->b:[Lcom/google/android/gms/internal/hd;

    array-length v3, v3

    add-int/lit8 v3, v3, -0x1

    if-eq v0, v3, :cond_0

    const-string v3, ","

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    const-string v0, "}"

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public final writeToParcel(Landroid/os/Parcel;I)V
    .locals 0

    invoke-static {p0, p1, p2}, Lcom/google/android/gms/internal/ji;->a(Lcom/google/android/gms/internal/hb;Landroid/os/Parcel;I)V

    return-void
.end method
