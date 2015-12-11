.class public Lco/vine/android/api/VineActivityCounts;
.super Ljava/lang/Object;
.source "VineActivityCounts.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lco/vine/android/api/VineActivityCounts;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public messages:I

.field public notifications:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 35
    new-instance v0, Lco/vine/android/api/VineActivityCounts$1;

    invoke-direct {v0}, Lco/vine/android/api/VineActivityCounts$1;-><init>()V

    sput-object v0, Lco/vine/android/api/VineActivityCounts;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(II)V
    .locals 0
    .param p1, "messages"    # I
    .param p2, "notifications"    # I

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    iput p1, p0, Lco/vine/android/api/VineActivityCounts;->messages:I

    .line 16
    iput p2, p0, Lco/vine/android/api/VineActivityCounts;->notifications:I

    .line 17
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineActivityCounts;->messages:I

    .line 21
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineActivityCounts;->notifications:I

    .line 22
    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 32
    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 1
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 26
    iget v0, p0, Lco/vine/android/api/VineActivityCounts;->messages:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 27
    iget v0, p0, Lco/vine/android/api/VineActivityCounts;->notifications:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 28
    return-void
.end method
