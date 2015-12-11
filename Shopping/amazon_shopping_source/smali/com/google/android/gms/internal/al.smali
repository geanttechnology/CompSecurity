.class public final Lcom/google/android/gms/internal/al;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/common/internal/safeparcel/SafeParcelable;


# static fields
.field public static final CREATOR:Lcom/google/android/gms/internal/am;


# instance fields
.field public final height:I

.field public final heightPixels:I

.field public final me:Ljava/lang/String;

.field public final mf:Z

.field public final mg:[Lcom/google/android/gms/internal/al;

.field public final versionCode:I

.field public final width:I

.field public final widthPixels:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/google/android/gms/internal/am;

    invoke-direct {v0}, Lcom/google/android/gms/internal/am;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/al;->CREATOR:Lcom/google/android/gms/internal/am;

    return-void
.end method

.method public constructor <init>()V
    .locals 9

    const/4 v3, 0x0

    const/4 v1, 0x2

    const-string/jumbo v2, "interstitial_mb"

    const/4 v5, 0x1

    const/4 v8, 0x0

    move-object v0, p0

    move v4, v3

    move v6, v3

    move v7, v3

    invoke-direct/range {v0 .. v8}, Lcom/google/android/gms/internal/al;-><init>(ILjava/lang/String;IIZII[Lcom/google/android/gms/internal/al;)V

    return-void
.end method

.method constructor <init>(ILjava/lang/String;IIZII[Lcom/google/android/gms/internal/al;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lcom/google/android/gms/internal/al;->versionCode:I

    iput-object p2, p0, Lcom/google/android/gms/internal/al;->me:Ljava/lang/String;

    iput p3, p0, Lcom/google/android/gms/internal/al;->height:I

    iput p4, p0, Lcom/google/android/gms/internal/al;->heightPixels:I

    iput-boolean p5, p0, Lcom/google/android/gms/internal/al;->mf:Z

    iput p6, p0, Lcom/google/android/gms/internal/al;->width:I

    iput p7, p0, Lcom/google/android/gms/internal/al;->widthPixels:I

    iput-object p8, p0, Lcom/google/android/gms/internal/al;->mg:[Lcom/google/android/gms/internal/al;

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
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    invoke-static {p0, p1, p2}, Lcom/google/android/gms/internal/am;->a(Lcom/google/android/gms/internal/al;Landroid/os/Parcel;I)V

    return-void
.end method
