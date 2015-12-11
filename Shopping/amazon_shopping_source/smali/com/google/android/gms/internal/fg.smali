.class public Lcom/google/android/gms/internal/fg;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/android/gms/common/internal/safeparcel/SafeParcelable;


# static fields
.field public static final CREATOR:Lcom/google/android/gms/internal/fh;


# instance fields
.field final xM:I

.field final xN:[Lcom/google/android/gms/internal/fk;

.field public final xO:Ljava/lang/String;

.field public final xP:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    new-instance v0, Lcom/google/android/gms/internal/fh;

    invoke-direct {v0}, Lcom/google/android/gms/internal/fh;-><init>()V

    sput-object v0, Lcom/google/android/gms/internal/fg;->CREATOR:Lcom/google/android/gms/internal/fh;

    return-void
.end method

.method constructor <init>(I[Lcom/google/android/gms/internal/fk;Ljava/lang/String;Z)V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput p1, p0, Lcom/google/android/gms/internal/fg;->xM:I

    iput-object p2, p0, Lcom/google/android/gms/internal/fg;->xN:[Lcom/google/android/gms/internal/fk;

    iput-object p3, p0, Lcom/google/android/gms/internal/fg;->xO:Ljava/lang/String;

    iput-boolean p4, p0, Lcom/google/android/gms/internal/fg;->xP:Z

    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    sget-object v0, Lcom/google/android/gms/internal/fg;->CREATOR:Lcom/google/android/gms/internal/fh;

    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    sget-object v0, Lcom/google/android/gms/internal/fg;->CREATOR:Lcom/google/android/gms/internal/fh;

    invoke-static {p0, p1, p2}, Lcom/google/android/gms/internal/fh;->a(Lcom/google/android/gms/internal/fg;Landroid/os/Parcel;I)V

    return-void
.end method
