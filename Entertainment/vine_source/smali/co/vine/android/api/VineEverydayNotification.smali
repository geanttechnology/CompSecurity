.class public Lco/vine/android/api/VineEverydayNotification;
.super Lco/vine/android/api/VineNotification;
.source "VineEverydayNotification.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lco/vine/android/api/VineEverydayNotification;",
            ">;"
        }
    .end annotation
.end field

.field public static final FOLLOWING:I = 0x1

.field public static final FOLLOW_REQUESTED:I = 0x2

.field public static final PRIVATE:I = 0x4

.field public static final TYPE_ADDRESS_BOOK_FRIEND_JOINED:Ljava/lang/String; = "address book friend joined"

.field public static final TYPE_COMMENTED:Ljava/lang/String; = "commented"

.field public static final TYPE_COMMENT_MENTION:Ljava/lang/String; = "mentioned comment"

.field public static final TYPE_COUNT:Ljava/lang/String; = "count"

.field public static final TYPE_FOLLOWED:Ljava/lang/String; = "followed"

.field public static final TYPE_FOLLOW_APPROVED:Ljava/lang/String; = "follow approved"

.field public static final TYPE_GROUP_COMMENTED:Ljava/lang/String; = "grouped comment"

.field public static final TYPE_LIKED:Ljava/lang/String; = "liked"

.field public static final TYPE_MENTION:Ljava/lang/String; = "mentioned"

.field public static final TYPE_POST_MENTION:Ljava/lang/String; = "mentioned post"

.field public static final TYPE_REVINED:Ljava/lang/String; = "reposted"

.field public static final TYPE_TWITTER_FRIEND_JOINED:Ljava/lang/String; = "twitter friend joined"


# instance fields
.field public anchor:J

.field public followStatus:I

.field public isNew:Z

.field public milestone:Lco/vine/android/api/VineMilestone;

.field public post:Lco/vine/android/api/VinePost;

.field public type:Ljava/lang/String;

.field public user:Lco/vine/android/api/VineUser;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 113
    new-instance v0, Lco/vine/android/api/VineEverydayNotification$1;

    invoke-direct {v0}, Lco/vine/android/api/VineEverydayNotification$1;-><init>()V

    sput-object v0, Lco/vine/android/api/VineEverydayNotification;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 5
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    const/4 v2, 0x1

    .line 61
    invoke-direct {p0}, Lco/vine/android/api/VineNotification;-><init>()V

    .line 62
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    .line 63
    .local v0, "cl":Ljava/lang/ClassLoader;
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/api/VineEverydayNotification;->comment:Ljava/lang/String;

    .line 64
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v3

    iput-wide v3, p0, Lco/vine/android/api/VineEverydayNotification;->notificationId:J

    .line 65
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lco/vine/android/api/VineEverydayNotification;->type:Ljava/lang/String;

    .line 66
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VinePost;

    iput-object v1, p0, Lco/vine/android/api/VineEverydayNotification;->post:Lco/vine/android/api/VinePost;

    .line 67
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VineUser;

    iput-object v1, p0, Lco/vine/android/api/VineEverydayNotification;->user:Lco/vine/android/api/VineUser;

    .line 68
    invoke-virtual {p1}, Landroid/os/Parcel;->readSerializable()Ljava/io/Serializable;

    move-result-object v1

    check-cast v1, Ljava/util/ArrayList;

    iput-object v1, p0, Lco/vine/android/api/VineEverydayNotification;->entities:Ljava/util/ArrayList;

    .line 69
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    iput v1, p0, Lco/vine/android/api/VineEverydayNotification;->followStatus:I

    .line 70
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->readParcelable(Ljava/lang/ClassLoader;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Lco/vine/android/api/VineMilestone;

    iput-object v1, p0, Lco/vine/android/api/VineEverydayNotification;->milestone:Lco/vine/android/api/VineMilestone;

    .line 71
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v1

    if-ne v1, v2, :cond_0

    move v1, v2

    :goto_0
    iput-boolean v1, p0, Lco/vine/android/api/VineEverydayNotification;->isNew:Z

    .line 72
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v1

    iput-wide v1, p0, Lco/vine/android/api/VineEverydayNotification;->anchor:J

    .line 73
    return-void

    .line 71
    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public constructor <init>(Ljava/lang/String;JLjava/lang/String;Lco/vine/android/api/VinePost;Lco/vine/android/api/VineUser;Ljava/util/ArrayList;Lco/vine/android/api/VineMilestone;JZJ)V
    .locals 0
    .param p1, "comment"    # Ljava/lang/String;
    .param p2, "notificationId"    # J
    .param p4, "type"    # Ljava/lang/String;
    .param p5, "post"    # Lco/vine/android/api/VinePost;
    .param p6, "user"    # Lco/vine/android/api/VineUser;
    .param p8, "milestone"    # Lco/vine/android/api/VineMilestone;
    .param p9, "createdAt"    # J
    .param p11, "isNew"    # Z
    .param p12, "anchor"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "J",
            "Ljava/lang/String;",
            "Lco/vine/android/api/VinePost;",
            "Lco/vine/android/api/VineUser;",
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/api/VineEntity;",
            ">;",
            "Lco/vine/android/api/VineMilestone;",
            "JZJ)V"
        }
    .end annotation

    .prologue
    .line 42
    .local p7, "entities":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/api/VineEntity;>;"
    invoke-direct {p0}, Lco/vine/android/api/VineNotification;-><init>()V

    .line 43
    iput-object p1, p0, Lco/vine/android/api/VineEverydayNotification;->comment:Ljava/lang/String;

    .line 44
    iput-wide p2, p0, Lco/vine/android/api/VineEverydayNotification;->notificationId:J

    .line 45
    iput-object p4, p0, Lco/vine/android/api/VineEverydayNotification;->type:Ljava/lang/String;

    .line 46
    iput-object p7, p0, Lco/vine/android/api/VineEverydayNotification;->entities:Ljava/util/ArrayList;

    .line 47
    iput-object p6, p0, Lco/vine/android/api/VineEverydayNotification;->user:Lco/vine/android/api/VineUser;

    .line 48
    iput-object p5, p0, Lco/vine/android/api/VineEverydayNotification;->post:Lco/vine/android/api/VinePost;

    .line 49
    iput-object p8, p0, Lco/vine/android/api/VineEverydayNotification;->milestone:Lco/vine/android/api/VineMilestone;

    .line 50
    iput-wide p9, p0, Lco/vine/android/api/VineEverydayNotification;->createdAt:J

    .line 51
    iput-boolean p11, p0, Lco/vine/android/api/VineEverydayNotification;->isNew:Z

    .line 52
    iput-wide p12, p0, Lco/vine/android/api/VineEverydayNotification;->anchor:J

    .line 53
    return-void
.end method

.method public static isLocked(I)Z
    .locals 2
    .param p0, "followStatus"    # I

    .prologue
    const/4 v0, 0x1

    .line 109
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
    .line 57
    const/4 v0, 0x0

    return v0
.end method

.method public setFollowRequested()V
    .locals 1

    .prologue
    .line 90
    iget v0, p0, Lco/vine/android/api/VineEverydayNotification;->followStatus:I

    or-int/lit8 v0, v0, 0x2

    iput v0, p0, Lco/vine/android/api/VineEverydayNotification;->followStatus:I

    .line 91
    return-void
.end method

.method public setFollowing()V
    .locals 1

    .prologue
    .line 94
    iget v0, p0, Lco/vine/android/api/VineEverydayNotification;->followStatus:I

    or-int/lit8 v0, v0, 0x1

    iput v0, p0, Lco/vine/android/api/VineEverydayNotification;->followStatus:I

    .line 95
    return-void
.end method

.method public setPrivate()V
    .locals 1

    .prologue
    .line 98
    iget v0, p0, Lco/vine/android/api/VineEverydayNotification;->followStatus:I

    or-int/lit8 v0, v0, 0x4

    iput v0, p0, Lco/vine/android/api/VineEverydayNotification;->followStatus:I

    .line 99
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 77
    iget-object v0, p0, Lco/vine/android/api/VineEverydayNotification;->comment:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 78
    iget-wide v0, p0, Lco/vine/android/api/VineEverydayNotification;->notificationId:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 79
    iget-object v0, p0, Lco/vine/android/api/VineEverydayNotification;->type:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 80
    iget-object v0, p0, Lco/vine/android/api/VineEverydayNotification;->post:Lco/vine/android/api/VinePost;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 81
    iget-object v0, p0, Lco/vine/android/api/VineEverydayNotification;->user:Lco/vine/android/api/VineUser;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 82
    iget-object v0, p0, Lco/vine/android/api/VineEverydayNotification;->entities:Ljava/util/ArrayList;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeSerializable(Ljava/io/Serializable;)V

    .line 83
    iget v0, p0, Lco/vine/android/api/VineEverydayNotification;->followStatus:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 84
    iget-object v0, p0, Lco/vine/android/api/VineEverydayNotification;->milestone:Lco/vine/android/api/VineMilestone;

    invoke-virtual {p1, v0, p2}, Landroid/os/Parcel;->writeParcelable(Landroid/os/Parcelable;I)V

    .line 85
    iget-boolean v0, p0, Lco/vine/android/api/VineEverydayNotification;->isNew:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 86
    iget-wide v0, p0, Lco/vine/android/api/VineEverydayNotification;->anchor:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 87
    return-void

    .line 85
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
