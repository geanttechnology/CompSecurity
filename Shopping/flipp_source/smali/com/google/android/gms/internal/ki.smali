.class public final Lcom/google/android/gms/internal/ki;
.super Ljava/lang/Object;


# static fields
.field static final a:I

.field static final b:I

.field static final c:I

.field static final d:I

.field public static final e:[I

.field public static final f:[J

.field public static final g:[F

.field public static final h:[D

.field public static final i:[Z

.field public static final j:[Ljava/lang/String;

.field public static final k:[[B

.field public static final l:[B


# direct methods
.method static constructor <clinit>()V
    .locals 2

    const/4 v1, 0x0

    const/16 v0, 0xb

    sput v0, Lcom/google/android/gms/internal/ki;->a:I

    const/16 v0, 0xc

    sput v0, Lcom/google/android/gms/internal/ki;->b:I

    const/16 v0, 0x10

    sput v0, Lcom/google/android/gms/internal/ki;->c:I

    const/16 v0, 0x1a

    sput v0, Lcom/google/android/gms/internal/ki;->d:I

    new-array v0, v1, [I

    sput-object v0, Lcom/google/android/gms/internal/ki;->e:[I

    new-array v0, v1, [J

    sput-object v0, Lcom/google/android/gms/internal/ki;->f:[J

    new-array v0, v1, [F

    sput-object v0, Lcom/google/android/gms/internal/ki;->g:[F

    new-array v0, v1, [D

    sput-object v0, Lcom/google/android/gms/internal/ki;->h:[D

    new-array v0, v1, [Z

    sput-object v0, Lcom/google/android/gms/internal/ki;->i:[Z

    new-array v0, v1, [Ljava/lang/String;

    sput-object v0, Lcom/google/android/gms/internal/ki;->j:[Ljava/lang/String;

    new-array v0, v1, [[B

    sput-object v0, Lcom/google/android/gms/internal/ki;->k:[[B

    new-array v0, v1, [B

    sput-object v0, Lcom/google/android/gms/internal/ki;->l:[B

    return-void
.end method

.method static a(II)I
    .locals 1

    shl-int/lit8 v0, p0, 0x3

    or-int/2addr v0, p1

    return v0
.end method
