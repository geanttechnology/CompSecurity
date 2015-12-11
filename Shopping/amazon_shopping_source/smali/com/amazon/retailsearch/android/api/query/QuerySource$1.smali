.class final Lcom/amazon/retailsearch/android/api/query/QuerySource$1;
.super Ljava/lang/Object;
.source "QuerySource.java"

# interfaces
.implements Landroid/os/Parcelable$Creator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/api/query/QuerySource;
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
        "Lcom/amazon/retailsearch/android/api/query/QuerySource;",
        ">;"
    }
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public createFromParcel(Landroid/os/Parcel;)Lcom/amazon/retailsearch/android/api/query/QuerySource;
    .locals 2
    .param p1, "srcParcel"    # Landroid/os/Parcel;

    .prologue
    .line 63
    # getter for: Lcom/amazon/retailsearch/android/api/query/QuerySource;->sources:[Lcom/amazon/retailsearch/android/api/query/QuerySource;
    invoke-static {}, Lcom/amazon/retailsearch/android/api/query/QuerySource;->access$000()[Lcom/amazon/retailsearch/android/api/query/QuerySource;

    move-result-object v0

    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    aget-object v0, v0, v1

    return-object v0
.end method

.method public bridge synthetic createFromParcel(Landroid/os/Parcel;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # Landroid/os/Parcel;

    .prologue
    .line 57
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/api/query/QuerySource$1;->createFromParcel(Landroid/os/Parcel;)Lcom/amazon/retailsearch/android/api/query/QuerySource;

    move-result-object v0

    return-object v0
.end method

.method public newArray(I)[Lcom/amazon/retailsearch/android/api/query/QuerySource;
    .locals 1
    .param p1, "size"    # I

    .prologue
    .line 72
    new-array v0, p1, [Lcom/amazon/retailsearch/android/api/query/QuerySource;

    return-object v0
.end method

.method public bridge synthetic newArray(I)[Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 57
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/api/query/QuerySource$1;->newArray(I)[Lcom/amazon/retailsearch/android/api/query/QuerySource;

    move-result-object v0

    return-object v0
.end method
