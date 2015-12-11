.class public Lcom/google/android/gms/internal/en;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/common/internal/safeparcel/SafeParcelable;


# static fields
.field public static final CREATOR:Lcom/google/android/gms/internal/hg;


# instance fields
.field final a:I

.field final b:Lcom/google/android/gms/internal/ep;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/google/android/gms/internal/hg;

    invoke-direct {v0}, Lcom/google/android/gms/internal/hg;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/en;->CREATOR:Lcom/google/android/gms/internal/hg;

    return-void
.end method

.method constructor <init>(ILcom/google/android/gms/internal/ep;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lcom/google/android/gms/internal/en;->a:I

    iput-object p2, p0, Lcom/google/android/gms/internal/en;->b:Lcom/google/android/gms/internal/ep;

    return-void
.end method

.method private constructor <init>(Lcom/google/android/gms/internal/ep;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x1

    iput v0, p0, Lcom/google/android/gms/internal/en;->a:I

    iput-object p1, p0, Lcom/google/android/gms/internal/en;->b:Lcom/google/android/gms/internal/ep;

    return-void
.end method

.method public static a(Lcom/google/android/gms/internal/hk;)Lcom/google/android/gms/internal/en;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/internal/hk",
            "<**>;)",
            "Lcom/google/android/gms/internal/en;"
        }
    .end annotation

    instance-of v0, p0, Lcom/google/android/gms/internal/ep;

    if-eqz v0, :cond_0

    new-instance v0, Lcom/google/android/gms/internal/en;

    check-cast p0, Lcom/google/android/gms/internal/ep;

    invoke-direct {v0, p0}, Lcom/google/android/gms/internal/en;-><init>(Lcom/google/android/gms/internal/ep;)V

    return-object v0

    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Unsupported safe parcelable field converter class."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 0

    invoke-static {p0, p1, p2}, Lcom/google/android/gms/internal/hg;->a(Lcom/google/android/gms/internal/en;Landroid/os/Parcel;I)V

    return-void
.end method
