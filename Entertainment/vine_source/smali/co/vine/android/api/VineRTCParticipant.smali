.class public Lco/vine/android/api/VineRTCParticipant;
.super Ljava/lang/Object;
.source "VineRTCParticipant.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lco/vine/android/api/VineRTCParticipant;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public isConnected:Z

.field public isTyping:Z

.field public lastMessageId:J

.field public userId:J


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 42
    new-instance v0, Lco/vine/android/api/VineRTCParticipant$1;

    invoke-direct {v0}, Lco/vine/android/api/VineRTCParticipant$1;-><init>()V

    sput-object v0, Lco/vine/android/api/VineRTCParticipant;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(JZZJ)V
    .locals 0
    .param p1, "userId"    # J
    .param p3, "connected"    # Z
    .param p4, "typing"    # Z
    .param p5, "lastMessageId"    # J

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-wide p1, p0, Lco/vine/android/api/VineRTCParticipant;->userId:J

    .line 17
    iput-wide p5, p0, Lco/vine/android/api/VineRTCParticipant;->lastMessageId:J

    .line 18
    iput-boolean p3, p0, Lco/vine/android/api/VineRTCParticipant;->isConnected:Z

    .line 19
    iput-boolean p4, p0, Lco/vine/android/api/VineRTCParticipant;->isTyping:Z

    .line 20
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 5
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v3

    iput-wide v3, p0, Lco/vine/android/api/VineRTCParticipant;->userId:J

    .line 24
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v3

    iput-wide v3, p0, Lco/vine/android/api/VineRTCParticipant;->lastMessageId:J

    .line 25
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-ne v0, v1, :cond_0

    move v0, v1

    :goto_0
    iput-boolean v0, p0, Lco/vine/android/api/VineRTCParticipant;->isConnected:Z

    .line 26
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-ne v0, v1, :cond_1

    :goto_1
    iput-boolean v1, p0, Lco/vine/android/api/VineRTCParticipant;->isTyping:Z

    .line 27
    return-void

    :cond_0
    move v0, v2

    .line 25
    goto :goto_0

    :cond_1
    move v1, v2

    .line 26
    goto :goto_1
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
    .locals 5
    .param p1, "dest"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 36
    iget-wide v3, p0, Lco/vine/android/api/VineRTCParticipant;->userId:J

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeLong(J)V

    .line 37
    iget-wide v3, p0, Lco/vine/android/api/VineRTCParticipant;->lastMessageId:J

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeLong(J)V

    .line 38
    iget-boolean v0, p0, Lco/vine/android/api/VineRTCParticipant;->isConnected:Z

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 39
    iget-boolean v0, p0, Lco/vine/android/api/VineRTCParticipant;->isTyping:Z

    if-eqz v0, :cond_1

    :goto_1
    invoke-virtual {p1, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 40
    return-void

    :cond_0
    move v0, v2

    .line 38
    goto :goto_0

    :cond_1
    move v1, v2

    .line 39
    goto :goto_1
.end method
