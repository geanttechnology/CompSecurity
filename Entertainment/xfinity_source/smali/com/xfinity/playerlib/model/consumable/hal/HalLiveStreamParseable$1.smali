.class final Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable$1;
.super Ljava/lang/Object;
.source "HalLiveStreamParseable.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;
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
        "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 87
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 90
    new-instance v0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;

    invoke-direct {v0, p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 87
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable$1;->createFromParcel(Landroid/os/Parcel;)Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;
    .locals 1
    .param p1, "size"    # I

    .prologue
    .line 95
    new-array v0, p1, [Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1

    .prologue
    .line 87
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable$1;->newArray(I)[Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamParseable;

    move-result-object v0

    return-object v0
.end method
