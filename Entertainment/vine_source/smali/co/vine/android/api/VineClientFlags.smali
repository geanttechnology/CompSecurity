.class public Lco/vine/android/api/VineClientFlags;
.super Ljava/lang/Object;
.source "VineClientFlags.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lco/vine/android/api/VineClientFlags;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public apiHost:Ljava/lang/String;

.field public exploreHost:Ljava/lang/String;

.field public mediaHost:Ljava/lang/String;

.field public messageText:Ljava/lang/String;

.field public messageTitle:Ljava/lang/String;

.field public rtcHost:Ljava/lang/String;

.field public ttlSeconds:J


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 58
    new-instance v0, Lco/vine/android/api/VineClientFlags$1;

    invoke-direct {v0}, Lco/vine/android/api/VineClientFlags$1;-><init>()V

    sput-object v0, Lco/vine/android/api/VineClientFlags;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 2
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    const/4 v0, 0x0

    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput-object v0, p0, Lco/vine/android/api/VineClientFlags;->messageTitle:Ljava/lang/String;

    .line 14
    iput-object v0, p0, Lco/vine/android/api/VineClientFlags;->messageText:Ljava/lang/String;

    .line 15
    iput-object v0, p0, Lco/vine/android/api/VineClientFlags;->apiHost:Ljava/lang/String;

    .line 16
    iput-object v0, p0, Lco/vine/android/api/VineClientFlags;->rtcHost:Ljava/lang/String;

    .line 17
    iput-object v0, p0, Lco/vine/android/api/VineClientFlags;->mediaHost:Ljava/lang/String;

    .line 18
    iput-object v0, p0, Lco/vine/android/api/VineClientFlags;->exploreHost:Ljava/lang/String;

    .line 19
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lco/vine/android/api/VineClientFlags;->ttlSeconds:J

    .line 33
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineClientFlags;->messageTitle:Ljava/lang/String;

    .line 34
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineClientFlags;->messageText:Ljava/lang/String;

    .line 35
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineClientFlags;->apiHost:Ljava/lang/String;

    .line 36
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineClientFlags;->rtcHost:Ljava/lang/String;

    .line 37
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineClientFlags;->mediaHost:Ljava/lang/String;

    .line 38
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineClientFlags;->exploreHost:Ljava/lang/String;

    .line 39
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VineClientFlags;->ttlSeconds:J

    .line 40
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    .locals 2
    .param p1, "messageTitle"    # Ljava/lang/String;
    .param p2, "messageText"    # Ljava/lang/String;
    .param p3, "apiHost"    # Ljava/lang/String;
    .param p4, "rtcHost"    # Ljava/lang/String;
    .param p5, "mediaHost"    # Ljava/lang/String;
    .param p6, "exploreHost"    # Ljava/lang/String;
    .param p7, "ttlSeconds"    # J

    .prologue
    const/4 v0, 0x0

    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput-object v0, p0, Lco/vine/android/api/VineClientFlags;->messageTitle:Ljava/lang/String;

    .line 14
    iput-object v0, p0, Lco/vine/android/api/VineClientFlags;->messageText:Ljava/lang/String;

    .line 15
    iput-object v0, p0, Lco/vine/android/api/VineClientFlags;->apiHost:Ljava/lang/String;

    .line 16
    iput-object v0, p0, Lco/vine/android/api/VineClientFlags;->rtcHost:Ljava/lang/String;

    .line 17
    iput-object v0, p0, Lco/vine/android/api/VineClientFlags;->mediaHost:Ljava/lang/String;

    .line 18
    iput-object v0, p0, Lco/vine/android/api/VineClientFlags;->exploreHost:Ljava/lang/String;

    .line 19
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lco/vine/android/api/VineClientFlags;->ttlSeconds:J

    .line 23
    iput-object p1, p0, Lco/vine/android/api/VineClientFlags;->messageTitle:Ljava/lang/String;

    .line 24
    iput-object p2, p0, Lco/vine/android/api/VineClientFlags;->messageText:Ljava/lang/String;

    .line 25
    iput-object p3, p0, Lco/vine/android/api/VineClientFlags;->apiHost:Ljava/lang/String;

    .line 26
    iput-object p4, p0, Lco/vine/android/api/VineClientFlags;->rtcHost:Ljava/lang/String;

    .line 27
    iput-object p5, p0, Lco/vine/android/api/VineClientFlags;->mediaHost:Ljava/lang/String;

    .line 28
    iput-object p6, p0, Lco/vine/android/api/VineClientFlags;->exploreHost:Ljava/lang/String;

    .line 29
    iput-wide p7, p0, Lco/vine/android/api/VineClientFlags;->ttlSeconds:J

    .line 30
    return-void
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 44
    const/4 v0, 0x0

    return v0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 49
    iget-object v0, p0, Lco/vine/android/api/VineClientFlags;->messageTitle:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 50
    iget-object v0, p0, Lco/vine/android/api/VineClientFlags;->messageText:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 51
    iget-object v0, p0, Lco/vine/android/api/VineClientFlags;->apiHost:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 52
    iget-object v0, p0, Lco/vine/android/api/VineClientFlags;->rtcHost:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 53
    iget-object v0, p0, Lco/vine/android/api/VineClientFlags;->mediaHost:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 54
    iget-object v0, p0, Lco/vine/android/api/VineClientFlags;->exploreHost:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 55
    iget-wide v0, p0, Lco/vine/android/api/VineClientFlags;->ttlSeconds:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 56
    return-void
.end method
