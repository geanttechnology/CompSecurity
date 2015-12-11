.class public final Lcom/google/android/gms/internal/y;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/common/internal/safeparcel/SafeParcelable;


# annotations
.annotation runtime Lzf;
.end annotation


# static fields
.field public static final CREATOR:Lahq;


# instance fields
.field public final a:I

.field public final b:Z

.field public final c:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lahq;

    invoke-direct {v0}, Lahq;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/y;->CREATOR:Lahq;

    return-void
.end method

.method public constructor <init>(IZZ)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lcom/google/android/gms/internal/y;->a:I

    iput-boolean p2, p0, Lcom/google/android/gms/internal/y;->b:Z

    iput-boolean p3, p0, Lcom/google/android/gms/internal/y;->c:Z

    return-void
.end method

.method public constructor <init>(ZZ)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x1

    iput v0, p0, Lcom/google/android/gms/internal/y;->a:I

    iput-boolean p1, p0, Lcom/google/android/gms/internal/y;->b:Z

    iput-boolean p2, p0, Lcom/google/android/gms/internal/y;->c:Z

    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 0

    invoke-static {p0, p1, p2}, Lahq;->a(Lcom/google/android/gms/internal/y;Landroid/os/Parcel;I)V

    return-void
.end method
