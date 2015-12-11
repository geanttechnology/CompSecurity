.class final Lcom/github/ignition/support/cache/CachedList$1;
.super Ljava/lang/Object;
.source "CachedList.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/github/ignition/support/cache/CachedList;
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
        "Lcom/github/ignition/support/cache/CachedList",
        "<",
        "Lcom/github/ignition/support/cache/CachedModel;",
        ">;>;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 201
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lcom/github/ignition/support/cache/CachedList;
    .locals 2
    .param p1, "source"    # Landroid/os/Parcel;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/Parcel;",
            ")",
            "Lcom/github/ignition/support/cache/CachedList",
            "<",
            "Lcom/github/ignition/support/cache/CachedModel;",
            ">;"
        }
    .end annotation

    .prologue
    .line 210
    :try_start_0
    new-instance v1, Lcom/github/ignition/support/cache/CachedList;

    invoke-direct {v1, p1}, Lcom/github/ignition/support/cache/CachedList;-><init>(Landroid/os/Parcel;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 213
    :goto_0
    return-object v1

    .line 211
    :catch_0
    move-exception v0

    .line 212
    .local v0, "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    .line 213
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Landroid/os/Parcel;

    .prologue
    .line 201
    invoke-virtual {p0, p1}, Lcom/github/ignition/support/cache/CachedList$1;->createFromParcel(Landroid/os/Parcel;)Lcom/github/ignition/support/cache/CachedList;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/github/ignition/support/cache/CachedList;
    .locals 1
    .param p1, "size"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)[",
            "Lcom/github/ignition/support/cache/CachedList",
            "<",
            "Lcom/github/ignition/support/cache/CachedModel;",
            ">;"
        }
    .end annotation

    .prologue
    .line 223
    new-array v0, p1, [Lcom/github/ignition/support/cache/CachedList;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 201
    invoke-virtual {p0, p1}, Lcom/github/ignition/support/cache/CachedList$1;->newArray(I)[Lcom/github/ignition/support/cache/CachedList;

    move-result-object v0

    return-object v0
.end method
