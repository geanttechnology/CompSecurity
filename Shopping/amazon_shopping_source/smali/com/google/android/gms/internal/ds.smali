.class public final Lcom/google/android/gms/internal/ds;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/common/internal/safeparcel/SafeParcelable;


# static fields
.field public static final CREATOR:Lcom/google/android/gms/internal/dt;


# instance fields
.field public final applicationInfo:Landroid/content/pm/ApplicationInfo;

.field public final kN:Ljava/lang/String;

.field public final kQ:Lcom/google/android/gms/internal/ev;

.field public final kT:Lcom/google/android/gms/internal/al;

.field public final pW:Landroid/os/Bundle;

.field public final pX:Lcom/google/android/gms/internal/ai;

.field public final pY:Landroid/content/pm/PackageInfo;

.field public final pZ:Ljava/lang/String;

.field public final qa:Ljava/lang/String;

.field public final qb:Ljava/lang/String;

.field public final qc:Landroid/os/Bundle;

.field public final qd:Ljava/lang/String;

.field public final versionCode:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/google/android/gms/internal/dt;

    invoke-direct {v0}, Lcom/google/android/gms/internal/dt;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/ds;->CREATOR:Lcom/google/android/gms/internal/dt;

    return-void
.end method

.method constructor <init>(ILandroid/os/Bundle;Lcom/google/android/gms/internal/ai;Lcom/google/android/gms/internal/al;Ljava/lang/String;Landroid/content/pm/ApplicationInfo;Landroid/content/pm/PackageInfo;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/google/android/gms/internal/ev;Landroid/os/Bundle;Ljava/lang/String;)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lcom/google/android/gms/internal/ds;->versionCode:I

    iput-object p2, p0, Lcom/google/android/gms/internal/ds;->pW:Landroid/os/Bundle;

    iput-object p3, p0, Lcom/google/android/gms/internal/ds;->pX:Lcom/google/android/gms/internal/ai;

    iput-object p4, p0, Lcom/google/android/gms/internal/ds;->kT:Lcom/google/android/gms/internal/al;

    iput-object p5, p0, Lcom/google/android/gms/internal/ds;->kN:Ljava/lang/String;

    iput-object p6, p0, Lcom/google/android/gms/internal/ds;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iput-object p7, p0, Lcom/google/android/gms/internal/ds;->pY:Landroid/content/pm/PackageInfo;

    iput-object p8, p0, Lcom/google/android/gms/internal/ds;->pZ:Ljava/lang/String;

    iput-object p9, p0, Lcom/google/android/gms/internal/ds;->qa:Ljava/lang/String;

    iput-object p10, p0, Lcom/google/android/gms/internal/ds;->qb:Ljava/lang/String;

    iput-object p11, p0, Lcom/google/android/gms/internal/ds;->kQ:Lcom/google/android/gms/internal/ev;

    iput-object p12, p0, Lcom/google/android/gms/internal/ds;->qc:Landroid/os/Bundle;

    iput-object p13, p0, Lcom/google/android/gms/internal/ds;->qd:Ljava/lang/String;

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
    invoke-static {p0, p1, p2}, Lcom/google/android/gms/internal/dt;->a(Lcom/google/android/gms/internal/ds;Landroid/os/Parcel;I)V

    return-void
.end method
