.class final Lco/vine/android/api/VineRTCConversation$1;
.super Ljava/lang/Object;
.source "VineRTCConversation.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/api/VineRTCConversation;
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
        "Lco/vine/android/api/VineRTCConversation;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lco/vine/android/api/VineRTCConversation;
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 39
    new-instance v0, Lco/vine/android/api/VineRTCConversation;

    invoke-direct {v0, p1}, Lco/vine/android/api/VineRTCConversation;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Landroid/os/Parcel;

    .prologue
    .line 37
    invoke-virtual {p0, p1}, Lco/vine/android/api/VineRTCConversation$1;->createFromParcel(Landroid/os/Parcel;)Lco/vine/android/api/VineRTCConversation;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lco/vine/android/api/VineRTCConversation;
    .locals 1
    .param p1, "size"    # I

    .prologue
    .line 43
    new-array v0, p1, [Lco/vine/android/api/VineRTCConversation;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 37
    invoke-virtual {p0, p1}, Lco/vine/android/api/VineRTCConversation$1;->newArray(I)[Lco/vine/android/api/VineRTCConversation;

    move-result-object v0

    return-object v0
.end method
