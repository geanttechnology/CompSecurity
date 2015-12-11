.class public final Lcom/google/android/gms/internal/ce;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/common/internal/safeparcel/SafeParcelable;


# static fields
.field public static final CREATOR:Lcom/google/android/gms/internal/cd;


# instance fields
.field public final mimeType:Ljava/lang/String;

.field public final oa:Ljava/lang/String;

.field public final ob:Ljava/lang/String;

.field public final oc:Ljava/lang/String;

.field public final od:Ljava/lang/String;

.field public final oe:Ljava/lang/String;

.field public final packageName:Ljava/lang/String;

.field public final versionCode:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/google/android/gms/internal/cd;

    invoke-direct {v0}, Lcom/google/android/gms/internal/cd;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/ce;->CREATOR:Lcom/google/android/gms/internal/cd;

    return-void
.end method

.method public constructor <init>(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lcom/google/android/gms/internal/ce;->versionCode:I

    iput-object p2, p0, Lcom/google/android/gms/internal/ce;->oa:Ljava/lang/String;

    iput-object p3, p0, Lcom/google/android/gms/internal/ce;->ob:Ljava/lang/String;

    iput-object p4, p0, Lcom/google/android/gms/internal/ce;->mimeType:Ljava/lang/String;

    iput-object p5, p0, Lcom/google/android/gms/internal/ce;->packageName:Ljava/lang/String;

    iput-object p6, p0, Lcom/google/android/gms/internal/ce;->oc:Ljava/lang/String;

    iput-object p7, p0, Lcom/google/android/gms/internal/ce;->od:Ljava/lang/String;

    iput-object p8, p0, Lcom/google/android/gms/internal/ce;->oe:Ljava/lang/String;

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
    invoke-static {p0, p1, p2}, Lcom/google/android/gms/internal/cd;->a(Lcom/google/android/gms/internal/ce;Landroid/os/Parcel;I)V

    return-void
.end method
