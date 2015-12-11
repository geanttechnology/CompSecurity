.class public Lco/vine/android/api/VineTag;
.super Ljava/lang/Object;
.source "VineTag.java"

# interfaces
.implements Landroid/os/Parcelable;
.implements Ljava/io/Serializable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lco/vine/android/api/VineTag;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public tagId:J

.field public tagName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 40
    new-instance v0, Lco/vine/android/api/VineTag$1;

    invoke-direct {v0}, Lco/vine/android/api/VineTag$1;-><init>()V

    sput-object v0, Lco/vine/android/api/VineTag;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 17
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 2
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineTag;->tagName:Ljava/lang/String;

    .line 26
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VineTag;->tagId:J

    .line 27
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;J)V
    .locals 0
    .param p1, "tagName"    # Ljava/lang/String;
    .param p2, "tagId"    # J

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput-object p1, p0, Lco/vine/android/api/VineTag;->tagName:Ljava/lang/String;

    .line 21
    iput-wide p2, p0, Lco/vine/android/api/VineTag;->tagId:J

    .line 22
    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 31
    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 36
    iget-object v0, p0, Lco/vine/android/api/VineTag;->tagName:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 37
    iget-wide v0, p0, Lco/vine/android/api/VineTag;->tagId:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 38
    return-void
.end method
