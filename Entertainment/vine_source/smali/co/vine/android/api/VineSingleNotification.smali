.class public Lco/vine/android/api/VineSingleNotification;
.super Lco/vine/android/api/VineNotification;
.source "VineSingleNotification.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final BaseConversationMessageNotification:I = 0x12

.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lco/vine/android/api/VineSingleNotification;",
            ">;"
        }
    .end annotation
.end field

.field public static final ConversationMessageTextNotification:I = 0x19

.field public static final FOLLOWING:I = 0x1

.field public static final FOLLOW_REQUESTED:I = 0x2

.field public static final PRIVATE:I = 0x4


# instance fields
.field public avatarUrl:Ljava/lang/String;

.field public conversationId:J

.field public conversationRowId:J

.field public followStatus:I

.field public final imageKeys:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/util/image/ImageKey;",
            ">;"
        }
    .end annotation
.end field

.field public messageCount:I

.field public notificationType:I

.field public postId:J

.field public recipientUserId:J

.field public thumbnailUrl:Ljava/lang/String;

.field public unreadMessageCount:J

.field public userId:J

.field public username:Ljava/lang/String;

.field public verified:Z

.field public final videoKeys:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/util/video/VideoKey;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 150
    new-instance v0, Lco/vine/android/api/VineSingleNotification$1;

    invoke-direct {v0}, Lco/vine/android/api/VineSingleNotification$1;-><init>()V

    sput-object v0, Lco/vine/android/api/VineSingleNotification;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Landroid/database/Cursor;)V
    .locals 2
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 64
    invoke-direct {p0}, Lco/vine/android/api/VineNotification;-><init>()V

    .line 40
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/api/VineSingleNotification;->imageKeys:Ljava/util/ArrayList;

    .line 41
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/api/VineSingleNotification;->videoKeys:Ljava/util/ArrayList;

    .line 65
    const/4 v0, 0x6

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineSingleNotification;->avatarUrl:Ljava/lang/String;

    .line 66
    const/4 v0, 0x3

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineSingleNotification;->comment:Ljava/lang/String;

    .line 67
    const/4 v0, 0x1

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VineSingleNotification;->notificationId:J

    .line 68
    const/4 v0, 0x5

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VineSingleNotification;->conversationRowId:J

    .line 69
    const/4 v0, 0x2

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineSingleNotification;->notificationType:I

    .line 70
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 3
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    const/4 v0, 0x1

    .line 78
    invoke-direct {p0}, Lco/vine/android/api/VineNotification;-><init>()V

    .line 40
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lco/vine/android/api/VineSingleNotification;->imageKeys:Ljava/util/ArrayList;

    .line 41
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lco/vine/android/api/VineSingleNotification;->videoKeys:Ljava/util/ArrayList;

    .line 79
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/api/VineSingleNotification;->avatarUrl:Ljava/lang/String;

    .line 80
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/api/VineSingleNotification;->username:Ljava/lang/String;

    .line 81
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/api/VineSingleNotification;->thumbnailUrl:Ljava/lang/String;

    .line 82
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/api/VineSingleNotification;->comment:Ljava/lang/String;

    .line 83
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v1

    iput-wide v1, p0, Lco/vine/android/api/VineSingleNotification;->notificationId:J

    .line 84
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v1

    iput-wide v1, p0, Lco/vine/android/api/VineSingleNotification;->userId:J

    .line 85
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v1

    iput-wide v1, p0, Lco/vine/android/api/VineSingleNotification;->postId:J

    .line 86
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v1

    iput-wide v1, p0, Lco/vine/android/api/VineSingleNotification;->createdAt:J

    .line 87
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v1

    iput-wide v1, p0, Lco/vine/android/api/VineSingleNotification;->conversationId:J

    .line 88
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v1

    iput-wide v1, p0, Lco/vine/android/api/VineSingleNotification;->unreadMessageCount:J

    .line 89
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-ne v1, v0, :cond_0

    :goto_0
    iput-boolean v0, p0, Lco/vine/android/api/VineSingleNotification;->verified:Z

    .line 90
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineSingleNotification;->notificationType:I

    .line 91
    invoke-virtual {p1}, Landroid/os/Parcel;->readSerializable()Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    iput-object v0, p0, Lco/vine/android/api/VineSingleNotification;->entities:Ljava/util/ArrayList;

    .line 92
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineSingleNotification;->followStatus:I

    .line 93
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VineSingleNotification;->conversationRowId:J

    .line 94
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineSingleNotification;->messageCount:I

    .line 95
    iget-object v0, p0, Lco/vine/android/api/VineSingleNotification;->imageKeys:Ljava/util/ArrayList;

    const-class v1, Lco/vine/android/api/VineSingleNotification;

    invoke-virtual {v1}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->readList(Ljava/util/List;Ljava/lang/ClassLoader;)V

    .line 96
    iget-object v0, p0, Lco/vine/android/api/VineSingleNotification;->videoKeys:Ljava/util/ArrayList;

    const-class v1, Lco/vine/android/api/VineSingleNotification;

    invoke-virtual {v1}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->readList(Ljava/util/List;Ljava/lang/ClassLoader;)V

    .line 97
    return-void

    .line 89
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJJJZIJLjava/util/ArrayList;JJ)V
    .locals 3
    .param p1, "avatarUrl"    # Ljava/lang/String;
    .param p2, "username"    # Ljava/lang/String;
    .param p3, "thumbnailUrl"    # Ljava/lang/String;
    .param p4, "comment"    # Ljava/lang/String;
    .param p5, "notificationId"    # J
    .param p7, "userId"    # J
    .param p9, "postId"    # J
    .param p11, "createdAt"    # J
    .param p13, "verified"    # Z
    .param p14, "notificationType"    # I
    .param p15, "conversationId"    # J
    .param p18, "unreadMessageCount"    # J
    .param p20, "recipientUserId"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "JJJJZIJ",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineEntity;",
            ">;JJ)V"
        }
    .end annotation

    .prologue
    .line 47
    .local p17, "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    invoke-direct {p0}, Lco/vine/android/api/VineNotification;-><init>()V

    .line 40
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, p0, Lco/vine/android/api/VineSingleNotification;->imageKeys:Ljava/util/ArrayList;

    .line 41
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iput-object v2, p0, Lco/vine/android/api/VineSingleNotification;->videoKeys:Ljava/util/ArrayList;

    .line 48
    iput-object p1, p0, Lco/vine/android/api/VineSingleNotification;->avatarUrl:Ljava/lang/String;

    .line 49
    iput-object p2, p0, Lco/vine/android/api/VineSingleNotification;->username:Ljava/lang/String;

    .line 50
    iput-object p3, p0, Lco/vine/android/api/VineSingleNotification;->thumbnailUrl:Ljava/lang/String;

    .line 51
    iput-object p4, p0, Lco/vine/android/api/VineSingleNotification;->comment:Ljava/lang/String;

    .line 52
    iput-wide p5, p0, Lco/vine/android/api/VineSingleNotification;->notificationId:J

    .line 53
    iput-wide p7, p0, Lco/vine/android/api/VineSingleNotification;->userId:J

    .line 54
    iput-wide p9, p0, Lco/vine/android/api/VineSingleNotification;->postId:J

    .line 55
    iput-wide p11, p0, Lco/vine/android/api/VineSingleNotification;->createdAt:J

    .line 56
    move-wide/from16 v0, p15

    iput-wide v0, p0, Lco/vine/android/api/VineSingleNotification;->conversationId:J

    .line 57
    move-wide/from16 v0, p18

    iput-wide v0, p0, Lco/vine/android/api/VineSingleNotification;->unreadMessageCount:J

    .line 58
    move/from16 v0, p13

    iput-boolean v0, p0, Lco/vine/android/api/VineSingleNotification;->verified:Z

    .line 59
    move/from16 v0, p14

    iput v0, p0, Lco/vine/android/api/VineSingleNotification;->notificationType:I

    .line 60
    move-object/from16 v0, p17

    iput-object v0, p0, Lco/vine/android/api/VineSingleNotification;->entities:Ljava/util/ArrayList;

    .line 61
    move-wide/from16 v0, p20

    iput-wide v0, p0, Lco/vine/android/api/VineSingleNotification;->recipientUserId:J

    .line 62
    return-void
.end method

.method public static isLocked(I)Z
    .locals 2
    .param p0, "followStatus"    # I

    .prologue
    const/4 v0, 0x1

    .line 146
    and-int/lit8 v1, p0, 0x4

    if-lt v1, v0, :cond_1

    and-int/lit8 v1, p0, 0x2

    if-ge v1, v0, :cond_0

    and-int/lit8 v1, p0, 0x1

    if-ge v1, v0, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 74
    const/4 v0, 0x0

    return v0
.end method

.method public isMessaging()Z
    .locals 2

    .prologue
    .line 100
    iget v0, p0, Lco/vine/android/api/VineSingleNotification;->notificationType:I

    const/16 v1, 0x12

    if-eq v0, v1, :cond_0

    iget v0, p0, Lco/vine/android/api/VineSingleNotification;->notificationType:I

    const/16 v1, 0x19

    if-ne v0, v1, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setFollowRequested()V
    .locals 1

    .prologue
    .line 127
    iget v0, p0, Lco/vine/android/api/VineSingleNotification;->followStatus:I

    or-int/lit8 v0, v0, 0x2

    iput v0, p0, Lco/vine/android/api/VineSingleNotification;->followStatus:I

    .line 128
    return-void
.end method

.method public setFollowing()V
    .locals 1

    .prologue
    .line 131
    iget v0, p0, Lco/vine/android/api/VineSingleNotification;->followStatus:I

    or-int/lit8 v0, v0, 0x1

    iput v0, p0, Lco/vine/android/api/VineSingleNotification;->followStatus:I

    .line 132
    return-void
.end method

.method public setPrivate()V
    .locals 1

    .prologue
    .line 135
    iget v0, p0, Lco/vine/android/api/VineSingleNotification;->followStatus:I

    or-int/lit8 v0, v0, 0x4

    iput v0, p0, Lco/vine/android/api/VineSingleNotification;->followStatus:I

    .line 136
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 106
    iget-object v0, p0, Lco/vine/android/api/VineSingleNotification;->avatarUrl:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 107
    iget-object v0, p0, Lco/vine/android/api/VineSingleNotification;->username:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 108
    iget-object v0, p0, Lco/vine/android/api/VineSingleNotification;->thumbnailUrl:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 109
    iget-object v0, p0, Lco/vine/android/api/VineSingleNotification;->comment:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 110
    iget-wide v0, p0, Lco/vine/android/api/VineSingleNotification;->notificationId:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 111
    iget-wide v0, p0, Lco/vine/android/api/VineSingleNotification;->userId:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 112
    iget-wide v0, p0, Lco/vine/android/api/VineSingleNotification;->postId:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 113
    iget-wide v0, p0, Lco/vine/android/api/VineSingleNotification;->createdAt:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 114
    iget-wide v0, p0, Lco/vine/android/api/VineSingleNotification;->conversationId:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 115
    iget-wide v0, p0, Lco/vine/android/api/VineSingleNotification;->unreadMessageCount:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 116
    iget-boolean v0, p0, Lco/vine/android/api/VineSingleNotification;->verified:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 117
    iget v0, p0, Lco/vine/android/api/VineSingleNotification;->notificationType:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 118
    iget-object v0, p0, Lco/vine/android/api/VineSingleNotification;->entities:Ljava/util/ArrayList;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeSerializable(Ljava/io/Serializable;)V

    .line 119
    iget v0, p0, Lco/vine/android/api/VineSingleNotification;->followStatus:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 120
    iget-wide v0, p0, Lco/vine/android/api/VineSingleNotification;->conversationRowId:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 121
    iget v0, p0, Lco/vine/android/api/VineSingleNotification;->messageCount:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 122
    iget-object v0, p0, Lco/vine/android/api/VineSingleNotification;->imageKeys:Ljava/util/ArrayList;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeList(Ljava/util/List;)V

    .line 123
    iget-object v0, p0, Lco/vine/android/api/VineSingleNotification;->videoKeys:Ljava/util/ArrayList;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeList(Ljava/util/List;)V

    .line 124
    return-void

    .line 116
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
