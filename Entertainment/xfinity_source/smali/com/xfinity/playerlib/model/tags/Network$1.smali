.class final Lcom/xfinity/playerlib/model/tags/Network$1;
.super Ljava/lang/Object;
.source "Network.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/model/tags/Network;
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
        "Lcom/xfinity/playerlib/model/tags/Network;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 124
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lcom/xfinity/playerlib/model/tags/Network;
    .locals 2
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 127
    new-instance v0, Lcom/xfinity/playerlib/model/tags/Network;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Lcom/xfinity/playerlib/model/tags/Network;-><init>(Landroid/os/Parcel;Lcom/xfinity/playerlib/model/tags/Network$1;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 124
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/model/tags/Network$1;->createFromParcel(Landroid/os/Parcel;)Lcom/xfinity/playerlib/model/tags/Network;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/xfinity/playerlib/model/tags/Network;
    .locals 1
    .param p1, "size"    # I

    .prologue
    .line 132
    new-array v0, p1, [Lcom/xfinity/playerlib/model/tags/Network;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1

    .prologue
    .line 124
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/model/tags/Network$1;->newArray(I)[Lcom/xfinity/playerlib/model/tags/Network;

    move-result-object v0

    return-object v0
.end method
