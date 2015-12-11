.class public Lco/vine/android/api/VinePost;
.super Ljava/lang/Object;
.source "VinePost.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lco/vine/android/api/VinePost;",
            ">;"
        }
    .end annotation
.end field

.field public static final FLAG_EXPLICIT:I = 0x4

.field public static final FLAG_LIKED:I = 0x8

.field public static final FLAG_POST_VERIFIED:I = 0x20

.field public static final FLAG_PRIVATE:I = 0x40

.field public static final FLAG_PROMOTED:I = 0x2

.field public static final FLAG_REVINED:I = 0x10

.field public static final FLAG_VERIFIED:I = 0x1


# instance fields
.field public avatarUrl:Ljava/lang/String;

.field public comments:Lco/vine/android/api/VinePagedData;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lco/vine/android/api/VinePagedData",
            "<",
            "Lco/vine/android/api/VineComment;",
            ">;"
        }
    .end annotation
.end field

.field public commentsCount:I

.field public created:J

.field public description:Ljava/lang/String;

.field public descriptionSb:Landroid/text/SpannableStringBuilder;

.field public entities:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineEntity;",
            ">;"
        }
    .end annotation
.end field

.field public foursquareVenueId:Ljava/lang/String;

.field public isLast:Z

.field public lastRefresh:J

.field public likes:Lco/vine/android/api/VinePagedData;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lco/vine/android/api/VinePagedData",
            "<",
            "Lco/vine/android/api/VineLike;",
            ">;"
        }
    .end annotation
.end field

.field public likesCount:I

.field public location:Ljava/lang/String;

.field public loops:J

.field public metadataFlags:I

.field public myRepostId:J

.field public onFire:Z

.field public orderId:Ljava/lang/String;

.field public postFlags:I

.field public postId:J

.field public repost:Lco/vine/android/api/VineRepost;

.field public revinersCount:I

.field public shareUrl:Ljava/lang/String;

.field public sharedVmSb:Landroid/text/SpannableStringBuilder;

.field public tag:Ljava/lang/String;

.field public tags:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineTag;",
            ">;"
        }
    .end annotation
.end field

.field public thumbnailUrl:Ljava/lang/String;

.field public transientEntities:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineEntity;",
            ">;"
        }
    .end annotation
.end field

.field public user:Lco/vine/android/api/VineUser;

.field public userBackgroundColor:I

.field public userId:J

.field public username:Ljava/lang/String;

.field public velocity:D

.field public venueData:Lco/vine/android/api/VineVenue;

.field public videoLowURL:Ljava/lang/String;

.field public videoUrl:Ljava/lang/String;

.field public videoWebmURL:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 474
    new-instance v0, Lco/vine/android/api/VinePost$1;

    invoke-direct {v0}, Lco/vine/android/api/VinePost$1;-><init>()V

    sput-object v0, Lco/vine/android/api/VinePost;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 77
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 79
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 6
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 86
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 87
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    .line 88
    .local v0, "cl":Ljava/lang/ClassLoader;
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v4

    iput-wide v4, p0, Lco/vine/android/api/VinePost;->created:J

    .line 89
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    iput v1, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    .line 90
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-ne v1, v2, :cond_0

    move v1, v2

    :goto_0
    iput-boolean v1, p0, Lco/vine/android/api/VinePost;->isLast:Z

    .line 91
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    iput v1, p0, Lco/vine/android/api/VinePost;->postFlags:I

    .line 92
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    iput v1, p0, Lco/vine/android/api/VinePost;->likesCount:I

    .line 93
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    iput v1, p0, Lco/vine/android/api/VinePost;->revinersCount:I

    .line 94
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    iput v1, p0, Lco/vine/android/api/VinePost;->commentsCount:I

    .line 95
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v4

    iput-wide v4, p0, Lco/vine/android/api/VinePost;->userId:J

    .line 96
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v4

    iput-wide v4, p0, Lco/vine/android/api/VinePost;->postId:J

    .line 97
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v4

    iput-wide v4, p0, Lco/vine/android/api/VinePost;->myRepostId:J

    .line 98
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/api/VinePost;->orderId:Ljava/lang/String;

    .line 99
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/api/VinePost;->tag:Ljava/lang/String;

    .line 100
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/api/VinePost;->foursquareVenueId:Ljava/lang/String;

    .line 101
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/api/VinePost;->description:Ljava/lang/String;

    .line 102
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/api/VinePost;->avatarUrl:Ljava/lang/String;

    .line 103
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/api/VinePost;->location:Ljava/lang/String;

    .line 104
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/api/VinePost;->videoLowURL:Ljava/lang/String;

    .line 105
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/api/VinePost;->videoUrl:Ljava/lang/String;

    .line 106
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/api/VinePost;->username:Ljava/lang/String;

    .line 107
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/api/VinePost;->shareUrl:Ljava/lang/String;

    .line 108
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/api/VinePost;->thumbnailUrl:Ljava/lang/String;

    .line 109
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VinePagedData;

    iput-object v1, p0, Lco/vine/android/api/VinePost;->comments:Lco/vine/android/api/VinePagedData;

    .line 110
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VinePagedData;

    iput-object v1, p0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    .line 111
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VineUser;

    iput-object v1, p0, Lco/vine/android/api/VinePost;->user:Lco/vine/android/api/VineUser;

    .line 112
    invoke-virtual {p1}, Landroid/os/Parcel;->readSerializable()Ljava/io/Serializable;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VineVenue;

    iput-object v1, p0, Lco/vine/android/api/VinePost;->venueData:Lco/vine/android/api/VineVenue;

    .line 113
    invoke-virtual {p1}, Landroid/os/Parcel;->readSerializable()Ljava/io/Serializable;

    move-result-object v1

    check-cast v1, Ljava/util/ArrayList;

    iput-object v1, p0, Lco/vine/android/api/VinePost;->entities:Ljava/util/ArrayList;

    .line 114
    invoke-virtual {p1}, Landroid/os/Parcel;->readSerializable()Ljava/io/Serializable;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VineRepost;

    iput-object v1, p0, Lco/vine/android/api/VinePost;->repost:Lco/vine/android/api/VineRepost;

    .line 115
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    iput v1, p0, Lco/vine/android/api/VinePost;->userBackgroundColor:I

    .line 116
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v4

    iput-wide v4, p0, Lco/vine/android/api/VinePost;->loops:J

    .line 117
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v4

    long-to-double v4, v4

    iput-wide v4, p0, Lco/vine/android/api/VinePost;->velocity:D

    .line 118
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v4

    iput-wide v4, p0, Lco/vine/android/api/VinePost;->lastRefresh:J

    .line 119
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-ne v1, v2, :cond_1

    :goto_1
    iput-boolean v2, p0, Lco/vine/android/api/VinePost;->onFire:Z

    .line 120
    return-void

    :cond_0
    move v1, v3

    .line 90
    goto/16 :goto_0

    :cond_1
    move v2, v3

    .line 119
    goto :goto_1
.end method

.method public static from(Landroid/database/Cursor;)Lco/vine/android/api/VinePost;
    .locals 6
    .param p0, "c"    # Landroid/database/Cursor;

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 132
    new-instance v0, Lco/vine/android/api/VinePost;

    invoke-direct {v0}, Lco/vine/android/api/VinePost;-><init>()V

    .line 133
    .local v0, "p":Lco/vine/android/api/VinePost;
    invoke-interface {p0, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    iput-wide v4, v0, Lco/vine/android/api/VinePost;->postId:J

    .line 134
    const/16 v1, 0x31

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VinePost;->orderId:Ljava/lang/String;

    .line 135
    const/16 v1, 0xd

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VinePost;->tag:Ljava/lang/String;

    .line 136
    const/4 v1, 0x2

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    iput-wide v4, v0, Lco/vine/android/api/VinePost;->myRepostId:J

    .line 137
    const/4 v1, 0x5

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VinePost;->shareUrl:Ljava/lang/String;

    .line 138
    const/4 v1, 0x7

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VinePost;->videoUrl:Ljava/lang/String;

    .line 139
    const/4 v1, 0x6

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VinePost;->videoLowURL:Ljava/lang/String;

    .line 140
    const/16 v1, 0x8

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VinePost;->description:Ljava/lang/String;

    .line 141
    const/16 v1, 0x9

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VinePost;->foursquareVenueId:Ljava/lang/String;

    .line 142
    const/16 v1, 0xa

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    iput v1, v0, Lco/vine/android/api/VinePost;->metadataFlags:I

    .line 143
    const/16 v1, 0xe

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    if-ne v1, v2, :cond_0

    move v1, v2

    :goto_0
    iput-boolean v1, v0, Lco/vine/android/api/VinePost;->isLast:Z

    .line 144
    const/16 v1, 0xb

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    iput v1, v0, Lco/vine/android/api/VinePost;->postFlags:I

    .line 145
    const/16 v1, 0x18

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    iput v1, v0, Lco/vine/android/api/VinePost;->likesCount:I

    .line 146
    const/16 v1, 0x19

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    iput v1, v0, Lco/vine/android/api/VinePost;->revinersCount:I

    .line 147
    const/16 v1, 0x1a

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    iput v1, v0, Lco/vine/android/api/VinePost;->commentsCount:I

    .line 148
    const/16 v1, 0x10

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    iput-wide v4, v0, Lco/vine/android/api/VinePost;->userId:J

    .line 149
    const/16 v1, 0x11

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    iput-wide v4, v0, Lco/vine/android/api/VinePost;->created:J

    .line 150
    const/16 v1, 0xf

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VinePost;->avatarUrl:Ljava/lang/String;

    .line 151
    const/16 v1, 0x12

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VinePost;->location:Ljava/lang/String;

    .line 152
    const/16 v1, 0x13

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VinePost;->username:Ljava/lang/String;

    .line 153
    const/4 v1, 0x4

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VinePost;->thumbnailUrl:Ljava/lang/String;

    .line 154
    const/16 v1, 0x2c

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    iput v1, v0, Lco/vine/android/api/VinePost;->userBackgroundColor:I

    .line 155
    new-instance v1, Lco/vine/android/api/VinePagedData;

    invoke-direct {v1}, Lco/vine/android/api/VinePagedData;-><init>()V

    iput-object v1, v0, Lco/vine/android/api/VinePost;->comments:Lco/vine/android/api/VinePagedData;

    .line 156
    new-instance v1, Lco/vine/android/api/VinePagedData;

    invoke-direct {v1}, Lco/vine/android/api/VinePagedData;-><init>()V

    iput-object v1, v0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    .line 157
    const/16 v1, 0x14

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getBlob(I)[B

    move-result-object v1

    invoke-static {v1}, Lco/vine/android/util/Util;->fromByteArray([B)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VineVenue;

    iput-object v1, v0, Lco/vine/android/api/VinePost;->venueData:Lco/vine/android/api/VineVenue;

    .line 159
    const/16 v1, 0x15

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getBlob(I)[B

    move-result-object v1

    invoke-static {v1}, Lco/vine/android/util/Util;->fromByteArray([B)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/ArrayList;

    iput-object v1, v0, Lco/vine/android/api/VinePost;->entities:Ljava/util/ArrayList;

    .line 161
    const/16 v1, 0x16

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getBlob(I)[B

    move-result-object v1

    invoke-static {v1}, Lco/vine/android/util/Util;->fromByteArray([B)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VineRepost;

    iput-object v1, v0, Lco/vine/android/api/VinePost;->repost:Lco/vine/android/api/VineRepost;

    .line 163
    const/16 v1, 0x2d

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    iput-wide v4, v0, Lco/vine/android/api/VinePost;->loops:J

    .line 164
    const/16 v1, 0x2e

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    long-to-double v4, v4

    iput-wide v4, v0, Lco/vine/android/api/VinePost;->velocity:D

    .line 165
    const/16 v1, 0x30

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    iput-wide v4, v0, Lco/vine/android/api/VinePost;->lastRefresh:J

    .line 166
    const/16 v1, 0x2f

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    if-ne v1, v2, :cond_1

    :goto_1
    iput-boolean v2, v0, Lco/vine/android/api/VinePost;->onFire:Z

    .line 167
    return-object v0

    :cond_0
    move v1, v3

    .line 143
    goto/16 :goto_0

    :cond_1
    move v2, v3

    .line 166
    goto :goto_1
.end method

.method public static fromExplore(Landroid/database/Cursor;)Lco/vine/android/api/VinePost;
    .locals 6
    .param p0, "c"    # Landroid/database/Cursor;

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 180
    new-instance v0, Lco/vine/android/api/VinePost;

    invoke-direct {v0}, Lco/vine/android/api/VinePost;-><init>()V

    .line 182
    .local v0, "p":Lco/vine/android/api/VinePost;
    invoke-interface {p0, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    iput-wide v4, v0, Lco/vine/android/api/VinePost;->postId:J

    .line 183
    const/16 v1, 0x20

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VinePost;->orderId:Ljava/lang/String;

    .line 184
    const/16 v1, 0xd

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VinePost;->tag:Ljava/lang/String;

    .line 185
    const/4 v1, 0x2

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    iput-wide v4, v0, Lco/vine/android/api/VinePost;->myRepostId:J

    .line 186
    const/4 v1, 0x5

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VinePost;->shareUrl:Ljava/lang/String;

    .line 187
    const/4 v1, 0x7

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VinePost;->videoUrl:Ljava/lang/String;

    .line 188
    const/4 v1, 0x6

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VinePost;->videoLowURL:Ljava/lang/String;

    .line 189
    const/16 v1, 0x8

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VinePost;->description:Ljava/lang/String;

    .line 190
    const/16 v1, 0x9

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VinePost;->foursquareVenueId:Ljava/lang/String;

    .line 191
    const/16 v1, 0xa

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    iput v1, v0, Lco/vine/android/api/VinePost;->metadataFlags:I

    .line 192
    const/16 v1, 0xe

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    if-ne v1, v2, :cond_0

    move v1, v2

    :goto_0
    iput-boolean v1, v0, Lco/vine/android/api/VinePost;->isLast:Z

    .line 193
    const/16 v1, 0xb

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    iput v1, v0, Lco/vine/android/api/VinePost;->postFlags:I

    .line 194
    const/16 v1, 0x18

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    iput v1, v0, Lco/vine/android/api/VinePost;->likesCount:I

    .line 195
    const/16 v1, 0x19

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    iput v1, v0, Lco/vine/android/api/VinePost;->revinersCount:I

    .line 196
    const/16 v1, 0x1a

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    iput v1, v0, Lco/vine/android/api/VinePost;->commentsCount:I

    .line 197
    const/16 v1, 0x10

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    iput-wide v4, v0, Lco/vine/android/api/VinePost;->userId:J

    .line 198
    const/16 v1, 0x11

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    iput-wide v4, v0, Lco/vine/android/api/VinePost;->created:J

    .line 199
    const/16 v1, 0xf

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VinePost;->avatarUrl:Ljava/lang/String;

    .line 200
    const/16 v1, 0x12

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VinePost;->location:Ljava/lang/String;

    .line 201
    const/16 v1, 0x13

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VinePost;->username:Ljava/lang/String;

    .line 202
    const/4 v1, 0x4

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VinePost;->thumbnailUrl:Ljava/lang/String;

    .line 203
    new-instance v1, Lco/vine/android/api/VinePagedData;

    invoke-direct {v1}, Lco/vine/android/api/VinePagedData;-><init>()V

    iput-object v1, v0, Lco/vine/android/api/VinePost;->comments:Lco/vine/android/api/VinePagedData;

    .line 204
    new-instance v1, Lco/vine/android/api/VinePagedData;

    invoke-direct {v1}, Lco/vine/android/api/VinePagedData;-><init>()V

    iput-object v1, v0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    .line 205
    const/16 v1, 0x14

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getBlob(I)[B

    move-result-object v1

    invoke-static {v1}, Lco/vine/android/util/Util;->fromByteArray([B)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VineVenue;

    iput-object v1, v0, Lco/vine/android/api/VinePost;->venueData:Lco/vine/android/api/VineVenue;

    .line 207
    const/16 v1, 0x15

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getBlob(I)[B

    move-result-object v1

    invoke-static {v1}, Lco/vine/android/util/Util;->fromByteArray([B)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/ArrayList;

    iput-object v1, v0, Lco/vine/android/api/VinePost;->entities:Ljava/util/ArrayList;

    .line 209
    const/16 v1, 0x16

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getBlob(I)[B

    move-result-object v1

    invoke-static {v1}, Lco/vine/android/util/Util;->fromByteArray([B)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VineRepost;

    iput-object v1, v0, Lco/vine/android/api/VinePost;->repost:Lco/vine/android/api/VineRepost;

    .line 211
    const/16 v1, 0x1b

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    iput v1, v0, Lco/vine/android/api/VinePost;->userBackgroundColor:I

    .line 212
    const/16 v1, 0x1c

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    iput-wide v4, v0, Lco/vine/android/api/VinePost;->loops:J

    .line 213
    const/16 v1, 0x1d

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    long-to-double v4, v4

    iput-wide v4, v0, Lco/vine/android/api/VinePost;->velocity:D

    .line 214
    const/16 v1, 0x1f

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    iput-wide v4, v0, Lco/vine/android/api/VinePost;->lastRefresh:J

    .line 215
    const/16 v1, 0x1e

    invoke-interface {p0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    if-ne v1, v2, :cond_1

    :goto_1
    iput-boolean v2, v0, Lco/vine/android/api/VinePost;->onFire:Z

    .line 216
    return-object v0

    :cond_0
    move v1, v3

    .line 192
    goto/16 :goto_0

    :cond_1
    move v2, v3

    .line 215
    goto :goto_1
.end method

.method public static getBytesFromTags(Lco/vine/android/api/VinePost;)[B
    .locals 6
    .param p0, "post"    # Lco/vine/android/api/VinePost;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 220
    new-instance v0, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v0}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 221
    .local v0, "bos":Ljava/io/ByteArrayOutputStream;
    new-instance v2, Ljava/io/ObjectOutputStream;

    invoke-direct {v2, v0}, Ljava/io/ObjectOutputStream;-><init>(Ljava/io/OutputStream;)V

    .line 222
    .local v2, "out":Ljava/io/ObjectOutput;
    iget-object v4, p0, Lco/vine/android/api/VinePost;->tags:Ljava/util/ArrayList;

    if-eqz v4, :cond_0

    .line 223
    iget-object v4, p0, Lco/vine/android/api/VinePost;->tags:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/api/VineTag;

    .line 224
    .local v3, "tag":Lco/vine/android/api/VineTag;
    iget-wide v4, v3, Lco/vine/android/api/VineTag;->tagId:J

    invoke-interface {v2, v4, v5}, Ljava/io/ObjectOutput;->writeLong(J)V

    .line 225
    iget-object v4, v3, Lco/vine/android/api/VineTag;->tagName:Ljava/lang/String;

    invoke-interface {v2, v4}, Ljava/io/ObjectOutput;->writeObject(Ljava/lang/Object;)V

    goto :goto_0

    .line 228
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v3    # "tag":Lco/vine/android/api/VineTag;
    :cond_0
    invoke-interface {v2}, Ljava/io/ObjectOutput;->flush()V

    .line 229
    invoke-interface {v2}, Ljava/io/ObjectOutput;->close()V

    .line 230
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->close()V

    .line 231
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v4

    return-object v4
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 236
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 7
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 277
    if-ne p0, p1, :cond_1

    .line 349
    :cond_0
    :goto_0
    return v1

    .line 278
    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v4

    if-eq v3, v4, :cond_3

    :cond_2
    move v1, v2

    goto :goto_0

    :cond_3
    move-object v0, p1

    .line 280
    check-cast v0, Lco/vine/android/api/VinePost;

    .line 282
    .local v0, "vinePost":Lco/vine/android/api/VinePost;
    iget-wide v3, p0, Lco/vine/android/api/VinePost;->postId:J

    iget-wide v5, v0, Lco/vine/android/api/VinePost;->postId:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_4

    move v1, v2

    goto :goto_0

    .line 283
    :cond_4
    iget-wide v3, p0, Lco/vine/android/api/VinePost;->myRepostId:J

    iget-wide v5, v0, Lco/vine/android/api/VinePost;->myRepostId:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_5

    move v1, v2

    goto :goto_0

    .line 284
    :cond_5
    iget v3, p0, Lco/vine/android/api/VinePost;->commentsCount:I

    iget v4, v0, Lco/vine/android/api/VinePost;->commentsCount:I

    if-eq v3, v4, :cond_6

    move v1, v2

    goto :goto_0

    .line 285
    :cond_6
    iget-wide v3, p0, Lco/vine/android/api/VinePost;->created:J

    iget-wide v5, v0, Lco/vine/android/api/VinePost;->created:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_7

    move v1, v2

    goto :goto_0

    .line 286
    :cond_7
    iget v3, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    iget v4, v0, Lco/vine/android/api/VinePost;->metadataFlags:I

    if-eq v3, v4, :cond_8

    move v1, v2

    goto :goto_0

    .line 287
    :cond_8
    iget-boolean v3, p0, Lco/vine/android/api/VinePost;->isLast:Z

    iget-boolean v4, v0, Lco/vine/android/api/VinePost;->isLast:Z

    if-eq v3, v4, :cond_9

    move v1, v2

    goto :goto_0

    .line 288
    :cond_9
    iget v3, p0, Lco/vine/android/api/VinePost;->likesCount:I

    iget v4, v0, Lco/vine/android/api/VinePost;->likesCount:I

    if-eq v3, v4, :cond_a

    move v1, v2

    goto :goto_0

    .line 289
    :cond_a
    iget v3, p0, Lco/vine/android/api/VinePost;->revinersCount:I

    iget v4, v0, Lco/vine/android/api/VinePost;->revinersCount:I

    if-eq v3, v4, :cond_b

    move v1, v2

    goto :goto_0

    .line 290
    :cond_b
    iget v3, p0, Lco/vine/android/api/VinePost;->postFlags:I

    iget v4, v0, Lco/vine/android/api/VinePost;->postFlags:I

    if-eq v3, v4, :cond_c

    move v1, v2

    goto :goto_0

    .line 291
    :cond_c
    iget-wide v3, p0, Lco/vine/android/api/VinePost;->userId:J

    iget-wide v5, v0, Lco/vine/android/api/VinePost;->userId:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_d

    move v1, v2

    goto :goto_0

    .line 292
    :cond_d
    iget-object v3, p0, Lco/vine/android/api/VinePost;->avatarUrl:Ljava/lang/String;

    if-eqz v3, :cond_f

    iget-object v3, p0, Lco/vine/android/api/VinePost;->avatarUrl:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VinePost;->avatarUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_10

    :cond_e
    move v1, v2

    .line 293
    goto :goto_0

    .line 292
    :cond_f
    iget-object v3, v0, Lco/vine/android/api/VinePost;->avatarUrl:Ljava/lang/String;

    if-nez v3, :cond_e

    .line 294
    :cond_10
    iget-object v3, p0, Lco/vine/android/api/VinePost;->comments:Lco/vine/android/api/VinePagedData;

    if-eqz v3, :cond_12

    iget-object v3, p0, Lco/vine/android/api/VinePost;->comments:Lco/vine/android/api/VinePagedData;

    iget-object v4, v0, Lco/vine/android/api/VinePost;->comments:Lco/vine/android/api/VinePagedData;

    invoke-virtual {v3, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_13

    :cond_11
    move v1, v2

    .line 295
    goto/16 :goto_0

    .line 294
    :cond_12
    iget-object v3, v0, Lco/vine/android/api/VinePost;->comments:Lco/vine/android/api/VinePagedData;

    if-nez v3, :cond_11

    .line 296
    :cond_13
    iget-object v3, p0, Lco/vine/android/api/VinePost;->description:Ljava/lang/String;

    if-eqz v3, :cond_15

    iget-object v3, p0, Lco/vine/android/api/VinePost;->description:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VinePost;->description:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_16

    :cond_14
    move v1, v2

    .line 298
    goto/16 :goto_0

    .line 296
    :cond_15
    iget-object v3, v0, Lco/vine/android/api/VinePost;->description:Ljava/lang/String;

    if-nez v3, :cond_14

    .line 299
    :cond_16
    iget-object v3, p0, Lco/vine/android/api/VinePost;->entities:Ljava/util/ArrayList;

    if-eqz v3, :cond_18

    iget-object v3, p0, Lco/vine/android/api/VinePost;->entities:Ljava/util/ArrayList;

    iget-object v4, v0, Lco/vine/android/api/VinePost;->entities:Ljava/util/ArrayList;

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_19

    :cond_17
    move v1, v2

    .line 300
    goto/16 :goto_0

    .line 299
    :cond_18
    iget-object v3, v0, Lco/vine/android/api/VinePost;->entities:Ljava/util/ArrayList;

    if-nez v3, :cond_17

    .line 301
    :cond_19
    iget-object v3, p0, Lco/vine/android/api/VinePost;->foursquareVenueId:Ljava/lang/String;

    if-eqz v3, :cond_1b

    iget-object v3, p0, Lco/vine/android/api/VinePost;->foursquareVenueId:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VinePost;->foursquareVenueId:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1c

    :cond_1a
    move v1, v2

    .line 303
    goto/16 :goto_0

    .line 301
    :cond_1b
    iget-object v3, v0, Lco/vine/android/api/VinePost;->foursquareVenueId:Ljava/lang/String;

    if-nez v3, :cond_1a

    .line 304
    :cond_1c
    iget-object v3, p0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    if-eqz v3, :cond_1e

    iget-object v3, p0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    iget-object v4, v0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    invoke-virtual {v3, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1f

    :cond_1d
    move v1, v2

    goto/16 :goto_0

    :cond_1e
    iget-object v3, v0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    if-nez v3, :cond_1d

    .line 305
    :cond_1f
    iget-object v3, p0, Lco/vine/android/api/VinePost;->location:Ljava/lang/String;

    if-eqz v3, :cond_21

    iget-object v3, p0, Lco/vine/android/api/VinePost;->location:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VinePost;->location:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_22

    :cond_20
    move v1, v2

    .line 306
    goto/16 :goto_0

    .line 305
    :cond_21
    iget-object v3, v0, Lco/vine/android/api/VinePost;->location:Ljava/lang/String;

    if-nez v3, :cond_20

    .line 307
    :cond_22
    iget-object v3, p0, Lco/vine/android/api/VinePost;->orderId:Ljava/lang/String;

    if-eqz v3, :cond_24

    iget-object v3, p0, Lco/vine/android/api/VinePost;->orderId:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VinePost;->orderId:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_25

    :cond_23
    move v1, v2

    .line 308
    goto/16 :goto_0

    .line 307
    :cond_24
    iget-object v3, v0, Lco/vine/android/api/VinePost;->orderId:Ljava/lang/String;

    if-nez v3, :cond_23

    .line 309
    :cond_25
    iget-object v3, p0, Lco/vine/android/api/VinePost;->tag:Ljava/lang/String;

    if-eqz v3, :cond_27

    iget-object v3, p0, Lco/vine/android/api/VinePost;->tag:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VinePost;->tag:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_28

    :cond_26
    move v1, v2

    .line 310
    goto/16 :goto_0

    .line 309
    :cond_27
    iget-object v3, v0, Lco/vine/android/api/VinePost;->tag:Ljava/lang/String;

    if-nez v3, :cond_26

    .line 311
    :cond_28
    iget-object v3, p0, Lco/vine/android/api/VinePost;->shareUrl:Ljava/lang/String;

    if-eqz v3, :cond_2a

    iget-object v3, p0, Lco/vine/android/api/VinePost;->shareUrl:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VinePost;->shareUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2b

    :cond_29
    move v1, v2

    .line 312
    goto/16 :goto_0

    .line 311
    :cond_2a
    iget-object v3, v0, Lco/vine/android/api/VinePost;->shareUrl:Ljava/lang/String;

    if-nez v3, :cond_29

    .line 313
    :cond_2b
    iget-object v3, p0, Lco/vine/android/api/VinePost;->tags:Ljava/util/ArrayList;

    if-eqz v3, :cond_2d

    iget-object v3, p0, Lco/vine/android/api/VinePost;->tags:Ljava/util/ArrayList;

    iget-object v4, v0, Lco/vine/android/api/VinePost;->tags:Ljava/util/ArrayList;

    invoke-virtual {v3, v4}, Ljava/util/ArrayList;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2e

    :cond_2c
    move v1, v2

    goto/16 :goto_0

    :cond_2d
    iget-object v3, v0, Lco/vine/android/api/VinePost;->tags:Ljava/util/ArrayList;

    if-nez v3, :cond_2c

    .line 314
    :cond_2e
    iget-object v3, p0, Lco/vine/android/api/VinePost;->thumbnailUrl:Ljava/lang/String;

    if-eqz v3, :cond_30

    iget-object v3, p0, Lco/vine/android/api/VinePost;->thumbnailUrl:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VinePost;->thumbnailUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_31

    :cond_2f
    move v1, v2

    .line 316
    goto/16 :goto_0

    .line 314
    :cond_30
    iget-object v3, v0, Lco/vine/android/api/VinePost;->thumbnailUrl:Ljava/lang/String;

    if-nez v3, :cond_2f

    .line 317
    :cond_31
    iget-object v3, p0, Lco/vine/android/api/VinePost;->user:Lco/vine/android/api/VineUser;

    if-eqz v3, :cond_33

    iget-object v3, p0, Lco/vine/android/api/VinePost;->user:Lco/vine/android/api/VineUser;

    iget-object v4, v0, Lco/vine/android/api/VinePost;->user:Lco/vine/android/api/VineUser;

    invoke-virtual {v3, v4}, Lco/vine/android/api/VineUser;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_34

    :cond_32
    move v1, v2

    goto/16 :goto_0

    :cond_33
    iget-object v3, v0, Lco/vine/android/api/VinePost;->user:Lco/vine/android/api/VineUser;

    if-nez v3, :cond_32

    .line 318
    :cond_34
    iget-object v3, p0, Lco/vine/android/api/VinePost;->username:Ljava/lang/String;

    if-eqz v3, :cond_36

    iget-object v3, p0, Lco/vine/android/api/VinePost;->username:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VinePost;->username:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_37

    :cond_35
    move v1, v2

    .line 319
    goto/16 :goto_0

    .line 318
    :cond_36
    iget-object v3, v0, Lco/vine/android/api/VinePost;->username:Ljava/lang/String;

    if-nez v3, :cond_35

    .line 320
    :cond_37
    iget-object v3, p0, Lco/vine/android/api/VinePost;->venueData:Lco/vine/android/api/VineVenue;

    if-eqz v3, :cond_39

    iget-object v3, p0, Lco/vine/android/api/VinePost;->venueData:Lco/vine/android/api/VineVenue;

    iget-object v4, v0, Lco/vine/android/api/VinePost;->venueData:Lco/vine/android/api/VineVenue;

    invoke-virtual {v3, v4}, Lco/vine/android/api/VineVenue;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_3a

    :cond_38
    move v1, v2

    .line 321
    goto/16 :goto_0

    .line 320
    :cond_39
    iget-object v3, v0, Lco/vine/android/api/VinePost;->venueData:Lco/vine/android/api/VineVenue;

    if-nez v3, :cond_38

    .line 322
    :cond_3a
    iget-object v3, p0, Lco/vine/android/api/VinePost;->videoLowURL:Ljava/lang/String;

    if-eqz v3, :cond_3c

    iget-object v3, p0, Lco/vine/android/api/VinePost;->videoLowURL:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VinePost;->videoLowURL:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_3d

    :cond_3b
    move v1, v2

    .line 324
    goto/16 :goto_0

    .line 322
    :cond_3c
    iget-object v3, v0, Lco/vine/android/api/VinePost;->videoLowURL:Ljava/lang/String;

    if-nez v3, :cond_3b

    .line 325
    :cond_3d
    iget-object v3, p0, Lco/vine/android/api/VinePost;->videoUrl:Ljava/lang/String;

    if-eqz v3, :cond_3f

    iget-object v3, p0, Lco/vine/android/api/VinePost;->videoUrl:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VinePost;->videoUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_40

    :cond_3e
    move v1, v2

    .line 326
    goto/16 :goto_0

    .line 325
    :cond_3f
    iget-object v3, v0, Lco/vine/android/api/VinePost;->videoUrl:Ljava/lang/String;

    if-nez v3, :cond_3e

    .line 327
    :cond_40
    iget-object v3, p0, Lco/vine/android/api/VinePost;->repost:Lco/vine/android/api/VineRepost;

    if-eqz v3, :cond_42

    iget-object v3, p0, Lco/vine/android/api/VinePost;->repost:Lco/vine/android/api/VineRepost;

    iget-object v4, v0, Lco/vine/android/api/VinePost;->repost:Lco/vine/android/api/VineRepost;

    invoke-virtual {v3, v4}, Lco/vine/android/api/VineRepost;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_43

    :cond_41
    move v1, v2

    .line 328
    goto/16 :goto_0

    .line 327
    :cond_42
    iget-object v3, v0, Lco/vine/android/api/VinePost;->repost:Lco/vine/android/api/VineRepost;

    if-nez v3, :cond_41

    .line 329
    :cond_43
    iget v3, p0, Lco/vine/android/api/VinePost;->userBackgroundColor:I

    iget v4, v0, Lco/vine/android/api/VinePost;->userBackgroundColor:I

    if-eq v3, v4, :cond_44

    move v1, v2

    .line 330
    goto/16 :goto_0

    .line 333
    :cond_44
    iget-wide v3, p0, Lco/vine/android/api/VinePost;->loops:J

    iget-wide v5, v0, Lco/vine/android/api/VinePost;->loops:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_45

    move v1, v2

    .line 334
    goto/16 :goto_0

    .line 337
    :cond_45
    iget-wide v3, p0, Lco/vine/android/api/VinePost;->velocity:D

    iget-wide v5, v0, Lco/vine/android/api/VinePost;->velocity:D

    cmpl-double v3, v3, v5

    if-eqz v3, :cond_46

    move v1, v2

    .line 338
    goto/16 :goto_0

    .line 341
    :cond_46
    iget-wide v3, p0, Lco/vine/android/api/VinePost;->lastRefresh:J

    iget-wide v5, v0, Lco/vine/android/api/VinePost;->lastRefresh:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_47

    move v1, v2

    .line 342
    goto/16 :goto_0

    .line 345
    :cond_47
    iget-boolean v3, p0, Lco/vine/android/api/VinePost;->onFire:Z

    iget-boolean v4, v0, Lco/vine/android/api/VinePost;->onFire:Z

    if-eq v3, v4, :cond_0

    move v1, v2

    .line 346
    goto/16 :goto_0
.end method

.method public getVideoHighUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lco/vine/android/api/VinePost;->videoUrl:Ljava/lang/String;

    if-nez v0, :cond_0

    iget-object v0, p0, Lco/vine/android/api/VinePost;->videoWebmURL:Ljava/lang/String;

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lco/vine/android/api/VinePost;->videoUrl:Ljava/lang/String;

    goto :goto_0
.end method

.method public hashCode()I
    .locals 9

    .prologue
    const/4 v2, 0x1

    const/16 v8, 0x20

    const/4 v3, 0x0

    .line 354
    iget-wide v4, p0, Lco/vine/android/api/VinePost;->created:J

    iget-wide v6, p0, Lco/vine/android/api/VinePost;->created:J

    ushr-long/2addr v6, v8

    xor-long/2addr v4, v6

    long-to-int v0, v4

    .line 355
    .local v0, "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget v4, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    add-int v0, v1, v4

    .line 356
    mul-int/lit8 v4, v0, 0x1f

    iget-boolean v1, p0, Lco/vine/android/api/VinePost;->isLast:Z

    if-eqz v1, :cond_0

    move v1, v2

    :goto_0
    add-int v0, v4, v1

    .line 357
    mul-int/lit8 v1, v0, 0x1f

    iget v4, p0, Lco/vine/android/api/VinePost;->postFlags:I

    add-int v0, v1, v4

    .line 358
    mul-int/lit8 v1, v0, 0x1f

    iget-wide v4, p0, Lco/vine/android/api/VinePost;->userId:J

    iget-wide v6, p0, Lco/vine/android/api/VinePost;->userId:J

    ushr-long/2addr v6, v8

    xor-long/2addr v4, v6

    long-to-int v4, v4

    add-int v0, v1, v4

    .line 359
    mul-int/lit8 v1, v0, 0x1f

    iget-wide v4, p0, Lco/vine/android/api/VinePost;->postId:J

    iget-wide v6, p0, Lco/vine/android/api/VinePost;->postId:J

    ushr-long/2addr v6, v8

    xor-long/2addr v4, v6

    long-to-int v4, v4

    add-int v0, v1, v4

    .line 360
    mul-int/lit8 v1, v0, 0x1f

    iget-wide v4, p0, Lco/vine/android/api/VinePost;->myRepostId:J

    iget-wide v6, p0, Lco/vine/android/api/VinePost;->myRepostId:J

    ushr-long/2addr v6, v8

    xor-long/2addr v4, v6

    long-to-int v4, v4

    add-int v0, v1, v4

    .line 361
    mul-int/lit8 v1, v0, 0x1f

    iget v4, p0, Lco/vine/android/api/VinePost;->likesCount:I

    add-int v0, v1, v4

    .line 362
    mul-int/lit8 v1, v0, 0x1f

    iget v4, p0, Lco/vine/android/api/VinePost;->revinersCount:I

    add-int v0, v1, v4

    .line 363
    mul-int/lit8 v1, v0, 0x1f

    iget v4, p0, Lco/vine/android/api/VinePost;->commentsCount:I

    add-int v0, v1, v4

    .line 364
    mul-int/lit8 v4, v0, 0x1f

    iget-object v1, p0, Lco/vine/android/api/VinePost;->orderId:Ljava/lang/String;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lco/vine/android/api/VinePost;->orderId:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_1
    add-int v0, v4, v1

    .line 365
    mul-int/lit8 v4, v0, 0x1f

    iget-object v1, p0, Lco/vine/android/api/VinePost;->tag:Ljava/lang/String;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lco/vine/android/api/VinePost;->tag:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_2
    add-int v0, v4, v1

    .line 366
    mul-int/lit8 v4, v0, 0x1f

    iget-object v1, p0, Lco/vine/android/api/VinePost;->foursquareVenueId:Ljava/lang/String;

    if-eqz v1, :cond_3

    iget-object v1, p0, Lco/vine/android/api/VinePost;->foursquareVenueId:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_3
    add-int v0, v4, v1

    .line 367
    mul-int/lit8 v4, v0, 0x1f

    iget-object v1, p0, Lco/vine/android/api/VinePost;->description:Ljava/lang/String;

    if-eqz v1, :cond_4

    iget-object v1, p0, Lco/vine/android/api/VinePost;->description:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_4
    add-int v0, v4, v1

    .line 368
    mul-int/lit8 v4, v0, 0x1f

    iget-object v1, p0, Lco/vine/android/api/VinePost;->avatarUrl:Ljava/lang/String;

    if-eqz v1, :cond_5

    iget-object v1, p0, Lco/vine/android/api/VinePost;->avatarUrl:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_5
    add-int v0, v4, v1

    .line 369
    mul-int/lit8 v4, v0, 0x1f

    iget-object v1, p0, Lco/vine/android/api/VinePost;->location:Ljava/lang/String;

    if-eqz v1, :cond_6

    iget-object v1, p0, Lco/vine/android/api/VinePost;->location:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_6
    add-int v0, v4, v1

    .line 370
    mul-int/lit8 v4, v0, 0x1f

    iget-object v1, p0, Lco/vine/android/api/VinePost;->videoLowURL:Ljava/lang/String;

    if-eqz v1, :cond_7

    iget-object v1, p0, Lco/vine/android/api/VinePost;->videoLowURL:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_7
    add-int v0, v4, v1

    .line 371
    mul-int/lit8 v4, v0, 0x1f

    iget-object v1, p0, Lco/vine/android/api/VinePost;->videoUrl:Ljava/lang/String;

    if-eqz v1, :cond_8

    iget-object v1, p0, Lco/vine/android/api/VinePost;->videoUrl:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_8
    add-int v0, v4, v1

    .line 372
    mul-int/lit8 v4, v0, 0x1f

    iget-object v1, p0, Lco/vine/android/api/VinePost;->username:Ljava/lang/String;

    if-eqz v1, :cond_9

    iget-object v1, p0, Lco/vine/android/api/VinePost;->username:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_9
    add-int v0, v4, v1

    .line 373
    mul-int/lit8 v4, v0, 0x1f

    iget-object v1, p0, Lco/vine/android/api/VinePost;->shareUrl:Ljava/lang/String;

    if-eqz v1, :cond_a

    iget-object v1, p0, Lco/vine/android/api/VinePost;->shareUrl:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_a
    add-int v0, v4, v1

    .line 374
    mul-int/lit8 v4, v0, 0x1f

    iget-object v1, p0, Lco/vine/android/api/VinePost;->thumbnailUrl:Ljava/lang/String;

    if-eqz v1, :cond_b

    iget-object v1, p0, Lco/vine/android/api/VinePost;->thumbnailUrl:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_b
    add-int v0, v4, v1

    .line 375
    mul-int/lit8 v4, v0, 0x1f

    iget-object v1, p0, Lco/vine/android/api/VinePost;->tags:Ljava/util/ArrayList;

    if-eqz v1, :cond_c

    iget-object v1, p0, Lco/vine/android/api/VinePost;->tags:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->hashCode()I

    move-result v1

    :goto_c
    add-int v0, v4, v1

    .line 376
    mul-int/lit8 v4, v0, 0x1f

    iget-object v1, p0, Lco/vine/android/api/VinePost;->entities:Ljava/util/ArrayList;

    if-eqz v1, :cond_d

    iget-object v1, p0, Lco/vine/android/api/VinePost;->entities:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->hashCode()I

    move-result v1

    :goto_d
    add-int v0, v4, v1

    .line 377
    mul-int/lit8 v4, v0, 0x1f

    iget-object v1, p0, Lco/vine/android/api/VinePost;->comments:Lco/vine/android/api/VinePagedData;

    if-eqz v1, :cond_e

    iget-object v1, p0, Lco/vine/android/api/VinePost;->comments:Lco/vine/android/api/VinePagedData;

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    :goto_e
    add-int v0, v4, v1

    .line 378
    mul-int/lit8 v4, v0, 0x1f

    iget-object v1, p0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    if-eqz v1, :cond_f

    iget-object v1, p0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    invoke-virtual {v1}, Ljava/lang/Object;->hashCode()I

    move-result v1

    :goto_f
    add-int v0, v4, v1

    .line 379
    mul-int/lit8 v4, v0, 0x1f

    iget-object v1, p0, Lco/vine/android/api/VinePost;->user:Lco/vine/android/api/VineUser;

    if-eqz v1, :cond_10

    iget-object v1, p0, Lco/vine/android/api/VinePost;->user:Lco/vine/android/api/VineUser;

    invoke-virtual {v1}, Lco/vine/android/api/VineUser;->hashCode()I

    move-result v1

    :goto_10
    add-int v0, v4, v1

    .line 380
    mul-int/lit8 v4, v0, 0x1f

    iget-object v1, p0, Lco/vine/android/api/VinePost;->venueData:Lco/vine/android/api/VineVenue;

    if-eqz v1, :cond_11

    iget-object v1, p0, Lco/vine/android/api/VinePost;->venueData:Lco/vine/android/api/VineVenue;

    invoke-virtual {v1}, Lco/vine/android/api/VineVenue;->hashCode()I

    move-result v1

    :goto_11
    add-int v0, v4, v1

    .line 381
    mul-int/lit8 v4, v0, 0x1f

    iget-object v1, p0, Lco/vine/android/api/VinePost;->repost:Lco/vine/android/api/VineRepost;

    if-eqz v1, :cond_12

    iget-object v1, p0, Lco/vine/android/api/VinePost;->repost:Lco/vine/android/api/VineRepost;

    invoke-virtual {v1}, Lco/vine/android/api/VineRepost;->hashCode()I

    move-result v1

    :goto_12
    add-int v0, v4, v1

    .line 382
    mul-int/lit8 v1, v0, 0x1f

    iget v4, p0, Lco/vine/android/api/VinePost;->userBackgroundColor:I

    add-int v0, v1, v4

    .line 383
    mul-int/lit8 v1, v0, 0x1f

    iget-wide v4, p0, Lco/vine/android/api/VinePost;->loops:J

    iget-wide v6, p0, Lco/vine/android/api/VinePost;->loops:J

    ushr-long/2addr v6, v8

    xor-long/2addr v4, v6

    long-to-int v4, v4

    add-int v0, v1, v4

    .line 384
    mul-int/lit8 v1, v0, 0x1f

    iget-wide v4, p0, Lco/vine/android/api/VinePost;->velocity:D

    const-wide v6, 0x40ac200000000000L    # 3600.0

    mul-double/2addr v4, v6

    double-to-int v4, v4

    add-int v0, v1, v4

    .line 385
    mul-int/lit8 v1, v0, 0x1f

    iget-wide v4, p0, Lco/vine/android/api/VinePost;->lastRefresh:J

    iget-wide v6, p0, Lco/vine/android/api/VinePost;->lastRefresh:J

    ushr-long/2addr v6, v8

    xor-long/2addr v4, v6

    long-to-int v4, v4

    add-int v0, v1, v4

    .line 386
    mul-int/lit8 v1, v0, 0x1f

    iget-boolean v4, p0, Lco/vine/android/api/VinePost;->onFire:Z

    if-eqz v4, :cond_13

    :goto_13
    add-int v0, v1, v2

    .line 387
    return v0

    :cond_0
    move v1, v3

    .line 356
    goto/16 :goto_0

    :cond_1
    move v1, v3

    .line 364
    goto/16 :goto_1

    :cond_2
    move v1, v3

    .line 365
    goto/16 :goto_2

    :cond_3
    move v1, v3

    .line 366
    goto/16 :goto_3

    :cond_4
    move v1, v3

    .line 367
    goto/16 :goto_4

    :cond_5
    move v1, v3

    .line 368
    goto/16 :goto_5

    :cond_6
    move v1, v3

    .line 369
    goto/16 :goto_6

    :cond_7
    move v1, v3

    .line 370
    goto/16 :goto_7

    :cond_8
    move v1, v3

    .line 371
    goto/16 :goto_8

    :cond_9
    move v1, v3

    .line 372
    goto/16 :goto_9

    :cond_a
    move v1, v3

    .line 373
    goto/16 :goto_a

    :cond_b
    move v1, v3

    .line 374
    goto/16 :goto_b

    :cond_c
    move v1, v3

    .line 375
    goto/16 :goto_c

    :cond_d
    move v1, v3

    .line 376
    goto/16 :goto_d

    :cond_e
    move v1, v3

    .line 377
    goto/16 :goto_e

    :cond_f
    move v1, v3

    .line 378
    goto/16 :goto_f

    :cond_10
    move v1, v3

    .line 379
    goto/16 :goto_10

    :cond_11
    move v1, v3

    .line 380
    goto :goto_11

    :cond_12
    move v1, v3

    .line 381
    goto :goto_12

    :cond_13
    move v2, v3

    .line 386
    goto :goto_13
.end method

.method public isExplicit()Z
    .locals 1

    .prologue
    .line 451
    iget v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    and-int/lit8 v0, v0, 0x4

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isLiked()Z
    .locals 1

    .prologue
    .line 459
    iget v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    and-int/lit8 v0, v0, 0x8

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isPrivate()Z
    .locals 1

    .prologue
    .line 467
    iget v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    and-int/lit8 v0, v0, 0x40

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isPromoted()Z
    .locals 1

    .prologue
    .line 455
    iget v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    and-int/lit8 v0, v0, 0x2

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isRevined()Z
    .locals 1

    .prologue
    .line 463
    iget v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    and-int/lit8 v0, v0, 0x10

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isShareable()Z
    .locals 1

    .prologue
    .line 471
    iget-object v0, p0, Lco/vine/android/api/VinePost;->shareUrl:Ljava/lang/String;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isVerified()Z
    .locals 1

    .prologue
    .line 447
    iget v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    and-int/lit8 v0, v0, 0x1

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setFlagExplicit(Z)V
    .locals 1
    .param p1, "explicit"    # Z

    .prologue
    .line 399
    if-eqz p1, :cond_0

    .line 400
    iget v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    or-int/lit8 v0, v0, 0x4

    iput v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    .line 404
    :goto_0
    return-void

    .line 402
    :cond_0
    iget v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    and-int/lit8 v0, v0, -0x5

    iput v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    goto :goto_0
.end method

.method public setFlagLiked(Z)V
    .locals 1
    .param p1, "liked"    # Z

    .prologue
    .line 415
    if-eqz p1, :cond_0

    .line 416
    iget v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    or-int/lit8 v0, v0, 0x8

    iput v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    .line 420
    :goto_0
    return-void

    .line 418
    :cond_0
    iget v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    and-int/lit8 v0, v0, -0x9

    iput v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    goto :goto_0
.end method

.method public setFlagPostVerified(Z)V
    .locals 1
    .param p1, "postVerified"    # Z

    .prologue
    .line 431
    if-eqz p1, :cond_0

    .line 432
    iget v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    or-int/lit8 v0, v0, 0x20

    iput v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    .line 436
    :goto_0
    return-void

    .line 434
    :cond_0
    iget v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    and-int/lit8 v0, v0, -0x21

    iput v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    goto :goto_0
.end method

.method public setFlagPrivate(Z)V
    .locals 1
    .param p1, "priv"    # Z

    .prologue
    .line 439
    if-eqz p1, :cond_0

    .line 440
    iget v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    or-int/lit8 v0, v0, 0x40

    iput v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    .line 444
    :goto_0
    return-void

    .line 442
    :cond_0
    iget v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    and-int/lit8 v0, v0, -0x41

    iput v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    goto :goto_0
.end method

.method public setFlagPromoted(Z)V
    .locals 1
    .param p1, "promoted"    # Z

    .prologue
    .line 407
    if-eqz p1, :cond_0

    .line 408
    iget v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    or-int/lit8 v0, v0, 0x2

    iput v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    .line 412
    :goto_0
    return-void

    .line 410
    :cond_0
    iget v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    and-int/lit8 v0, v0, -0x3

    iput v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    goto :goto_0
.end method

.method public setFlagRevined(Z)V
    .locals 1
    .param p1, "revined"    # Z

    .prologue
    .line 423
    if-eqz p1, :cond_0

    .line 424
    iget v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    or-int/lit8 v0, v0, 0x10

    iput v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    .line 428
    :goto_0
    return-void

    .line 426
    :cond_0
    iget v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    and-int/lit8 v0, v0, -0x11

    iput v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    goto :goto_0
.end method

.method public setFlagVerified(Z)V
    .locals 1
    .param p1, "verified"    # Z

    .prologue
    .line 391
    if-eqz p1, :cond_0

    .line 392
    iget v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    or-int/lit8 v0, v0, 0x1

    iput v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    .line 396
    :goto_0
    return-void

    .line 394
    :cond_0
    iget v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    and-int/lit8 v0, v0, -0x2

    iput v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    goto :goto_0
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 5
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 241
    iget-wide v3, p0, Lco/vine/android/api/VinePost;->created:J

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeLong(J)V

    .line 242
    iget v0, p0, Lco/vine/android/api/VinePost;->metadataFlags:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 243
    iget-boolean v0, p0, Lco/vine/android/api/VinePost;->isLast:Z

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 244
    iget v0, p0, Lco/vine/android/api/VinePost;->postFlags:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 245
    iget v0, p0, Lco/vine/android/api/VinePost;->likesCount:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 246
    iget v0, p0, Lco/vine/android/api/VinePost;->revinersCount:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 247
    iget v0, p0, Lco/vine/android/api/VinePost;->commentsCount:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 248
    iget-wide v3, p0, Lco/vine/android/api/VinePost;->userId:J

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeLong(J)V

    .line 249
    iget-wide v3, p0, Lco/vine/android/api/VinePost;->postId:J

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeLong(J)V

    .line 250
    iget-wide v3, p0, Lco/vine/android/api/VinePost;->myRepostId:J

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeLong(J)V

    .line 251
    iget-object v0, p0, Lco/vine/android/api/VinePost;->orderId:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 252
    iget-object v0, p0, Lco/vine/android/api/VinePost;->tag:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 253
    iget-object v0, p0, Lco/vine/android/api/VinePost;->foursquareVenueId:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 254
    iget-object v0, p0, Lco/vine/android/api/VinePost;->description:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 255
    iget-object v0, p0, Lco/vine/android/api/VinePost;->avatarUrl:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 256
    iget-object v0, p0, Lco/vine/android/api/VinePost;->location:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 257
    iget-object v0, p0, Lco/vine/android/api/VinePost;->videoLowURL:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 258
    iget-object v0, p0, Lco/vine/android/api/VinePost;->videoUrl:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 259
    iget-object v0, p0, Lco/vine/android/api/VinePost;->username:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 260
    iget-object v0, p0, Lco/vine/android/api/VinePost;->shareUrl:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 261
    iget-object v0, p0, Lco/vine/android/api/VinePost;->thumbnailUrl:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 262
    iget-object v0, p0, Lco/vine/android/api/VinePost;->comments:Lco/vine/android/api/VinePagedData;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 263
    iget-object v0, p0, Lco/vine/android/api/VinePost;->likes:Lco/vine/android/api/VinePagedData;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 264
    iget-object v0, p0, Lco/vine/android/api/VinePost;->user:Lco/vine/android/api/VineUser;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 265
    iget-object v0, p0, Lco/vine/android/api/VinePost;->venueData:Lco/vine/android/api/VineVenue;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeSerializable(Ljava/io/Serializable;)V

    .line 266
    iget-object v0, p0, Lco/vine/android/api/VinePost;->entities:Ljava/util/ArrayList;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeSerializable(Ljava/io/Serializable;)V

    .line 267
    iget-object v0, p0, Lco/vine/android/api/VinePost;->repost:Lco/vine/android/api/VineRepost;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeSerializable(Ljava/io/Serializable;)V

    .line 268
    iget v0, p0, Lco/vine/android/api/VinePost;->userBackgroundColor:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 269
    iget-wide v3, p0, Lco/vine/android/api/VinePost;->loops:J

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeLong(J)V

    .line 270
    iget-wide v3, p0, Lco/vine/android/api/VinePost;->velocity:D

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeDouble(D)V

    .line 271
    iget-wide v3, p0, Lco/vine/android/api/VinePost;->lastRefresh:J

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeLong(J)V

    .line 272
    iget-boolean v0, p0, Lco/vine/android/api/VinePost;->onFire:Z

    if-eqz v0, :cond_1

    :goto_1
    invoke-virtual {p1, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 273
    return-void

    :cond_0
    move v0, v2

    .line 243
    goto/16 :goto_0

    :cond_1
    move v1, v2

    .line 272
    goto :goto_1
.end method
