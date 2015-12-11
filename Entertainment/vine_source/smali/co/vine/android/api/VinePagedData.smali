.class public Lco/vine/android/api/VinePagedData;
.super Ljava/lang/Object;
.source "VinePagedData.java"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T::",
        "Landroid/os/Parcelable;",
        ">",
        "Ljava/lang/Object;",
        "Landroid/os/Parcelable;"
    }
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lco/vine/android/api/VinePagedData;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public anchor:J

.field public count:I

.field public items:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<TT;>;"
        }
    .end annotation
.end field

.field public nextPage:I

.field public previousPage:I

.field public size:I

.field public stringAnchor:Ljava/lang/String;

.field public title:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 66
    new-instance v0, Lco/vine/android/api/VinePagedData$1;

    invoke-direct {v0}, Lco/vine/android/api/VinePagedData$1;-><init>()V

    sput-object v0, Lco/vine/android/api/VinePagedData;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 22
    .local p0, "this":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    const/4 v0, -0x1

    iput v0, p0, Lco/vine/android/api/VinePagedData;->previousPage:I

    .line 24
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 7
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 27
    .local p0, "this":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    const/4 v5, -0x1

    iput v5, p0, Lco/vine/android/api/VinePagedData;->previousPage:I

    .line 28
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v5

    iput-wide v5, p0, Lco/vine/android/api/VinePagedData;->anchor:J

    .line 29
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v5

    iput v5, p0, Lco/vine/android/api/VinePagedData;->count:I

    .line 30
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v5

    iput v5, p0, Lco/vine/android/api/VinePagedData;->nextPage:I

    .line 31
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v5

    iput v5, p0, Lco/vine/android/api/VinePagedData;->previousPage:I

    .line 32
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v5

    iput v5, p0, Lco/vine/android/api/VinePagedData;->size:I

    .line 33
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    iput-object v5, p0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    .line 34
    const-class v5, Lco/vine/android/api/VinePagedData;

    invoke-virtual {v5}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v5

    invoke-virtual {p1, v5}, Landroid/os/Parcel;->readParcelableArray(Ljava/lang/ClassLoader;)[Landroid/os/Parcelable;

    move-result-object v1

    .line 35
    .local v1, "array":[Landroid/os/Parcelable;
    move-object v0, v1

    .local v0, "arr$":[Landroid/os/Parcelable;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v4, v0, v2

    .line 36
    .local v4, "p":Landroid/os/Parcelable;
    iget-object v5, p0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    invoke-virtual {v5, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 35
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 38
    .end local v4    # "p":Landroid/os/Parcelable;
    :cond_0
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Lco/vine/android/api/VinePagedData;->title:Ljava/lang/String;

    .line 39
    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 43
    .local p0, "this":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<TT;>;"
    const/4 v0, 0x0

    return v0
.end method

.method public isEmpty()Z
    .locals 1

    .prologue
    .line 62
    .local p0, "this":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<TT;>;"
    iget-object v0, p0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 48
    .local p0, "this":Lco/vine/android/api/VinePagedData;, "Lco/vine/android/api/VinePagedData<TT;>;"
    iget-wide v0, p0, Lco/vine/android/api/VinePagedData;->anchor:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 49
    iget v0, p0, Lco/vine/android/api/VinePagedData;->count:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 50
    iget v0, p0, Lco/vine/android/api/VinePagedData;->nextPage:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 51
    iget v0, p0, Lco/vine/android/api/VinePagedData;->previousPage:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 52
    iget v0, p0, Lco/vine/android/api/VinePagedData;->size:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 53
    iget-object v0, p0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    if-nez v0, :cond_0

    .line 54
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    const/4 v1, 0x0

    new-array v1, v1, [Landroid/os/Parcelable;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/os/Parcelable;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeParcelableArray([Landroid/os/Parcelable;I)V

    .line 58
    :goto_0
    iget-object v0, p0, Lco/vine/android/api/VinePagedData;->title:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 59
    return-void

    .line 56
    :cond_0
    iget-object v0, p0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    iget-object v1, p0, Lco/vine/android/api/VinePagedData;->items:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    new-array v1, v1, [Landroid/os/Parcelable;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Landroid/os/Parcelable;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeParcelableArray([Landroid/os/Parcelable;I)V

    goto :goto_0
.end method
