.class final Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent$1;
.super Ljava/lang/Object;
.source "HalLiveFeaturedContent.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;
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
        "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 128
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;
    .locals 1
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 131
    new-instance v0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;

    invoke-direct {v0, p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 128
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent$1;->createFromParcel(Landroid/os/Parcel;)Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;
    .locals 1
    .param p1, "size"    # I

    .prologue
    .line 136
    new-array v0, p1, [Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1

    .prologue
    .line 128
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent$1;->newArray(I)[Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;

    move-result-object v0

    return-object v0
.end method
