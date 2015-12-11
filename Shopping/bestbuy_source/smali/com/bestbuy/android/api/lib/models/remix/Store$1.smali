.class final Lcom/bestbuy/android/api/lib/models/remix/Store$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bestbuy/android/api/lib/models/remix/Store;
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable$Creator",
        "<",
        "Lcom/bestbuy/android/api/lib/models/remix/Store;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 218
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lcom/bestbuy/android/api/lib/models/remix/Store;
    .locals 1

    .prologue
    .line 228
    new-instance v0, Lcom/bestbuy/android/api/lib/models/remix/Store;

    invoke-direct {v0, p1}, Lcom/bestbuy/android/api/lib/models/remix/Store;-><init>(Landroid/os/Parcel;)V

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 218
    invoke-virtual {p0, p1}, Lcom/bestbuy/android/api/lib/models/remix/Store$1;->createFromParcel(Landroid/os/Parcel;)Lcom/bestbuy/android/api/lib/models/remix/Store;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/bestbuy/android/api/lib/models/remix/Store;
    .locals 1

    .prologue
    .line 222
    new-array v0, p1, [Lcom/bestbuy/android/api/lib/models/remix/Store;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1

    .prologue
    .line 218
    invoke-virtual {p0, p1}, Lcom/bestbuy/android/api/lib/models/remix/Store$1;->newArray(I)[Lcom/bestbuy/android/api/lib/models/remix/Store;

    move-result-object v0

    return-object v0
.end method
