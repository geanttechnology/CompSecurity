.class final Lco/vine/android/api/VineError$1;
.super Ljava/lang/Object;
.source "VineError.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/api/VineError;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator",
        "<",
        "Lco/vine/android/api/VineError;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 220
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lco/vine/android/api/VineError;
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 222
    new-instance v0, Lco/vine/android/api/VineError;

    invoke-direct {v0, p1}, Lco/vine/android/api/VineError;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Landroid/os/Parcel;

    .prologue
    .line 220
    invoke-virtual {p0, p1}, Lco/vine/android/api/VineError$1;->createFromParcel(Landroid/os/Parcel;)Lco/vine/android/api/VineError;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lco/vine/android/api/VineError;
    .locals 1
    .param p1, "size"    # I

    .prologue
    .line 226
    new-array v0, p1, [Lco/vine/android/api/VineError;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 220
    invoke-virtual {p0, p1}, Lco/vine/android/api/VineError$1;->newArray(I)[Lco/vine/android/api/VineError;

    move-result-object v0

    return-object v0
.end method
