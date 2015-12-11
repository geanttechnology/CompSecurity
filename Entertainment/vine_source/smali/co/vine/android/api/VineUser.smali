.class public Lco/vine/android/api/VineUser;
.super Ljava/lang/Object;
.source "VineUser.java"

# interfaces
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lco/vine/android/api/VineUser;",
            ">;"
        }
    .end annotation
.end field

.field public static final FOLLOW_STATUS_APPROVAL_PENDING:I = 0x1

.field public static final FOLLOW_STATUS_REQUESTED:I = 0x2

.field public static final VERIFIED_EMAIL:I = 0x1

.field public static final VERIFIED_PHONE:I = 0x2


# instance fields
.field public acceptsOutOfNetworkConversations:Z

.field public authoredPostCount:I

.field public avatarUrl:Ljava/lang/String;

.field public blocked:I

.field public blocking:I

.field public description:Ljava/lang/String;

.field public disableAddressBook:Z

.field public edition:Ljava/lang/String;

.field public email:Ljava/lang/String;

.field public explicit:I

.field public followStatus:I

.field public followerCount:I

.field public following:I

.field public followingCount:I

.field public friendIndex:J

.field public hiddenEmail:Z

.field public hiddenPhoneNumber:Z

.field public id:J

.field public includePromoted:I

.field public likeCount:I

.field public location:Ljava/lang/String;

.field public loopCount:J

.field public orderId:J

.field public phoneNumber:Ljava/lang/String;

.field public postCount:I

.field public privateAccount:I

.field public profileBackground:I

.field public repostsEnabled:I

.field public sectionId:I

.field public sectionTitle:Ljava/lang/String;

.field public twitterConnected:I

.field public userId:J

.field public username:Ljava/lang/String;

.field public verified:I

.field public verifiedInformation:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 363
    new-instance v0, Lco/vine/android/api/VineUser$1;

    invoke-direct {v0}, Lco/vine/android/api/VineUser$1;-><init>()V

    sput-object v0, Lco/vine/android/api/VineUser;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 74
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 76
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 5
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 125
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 126
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineUser;->username:Ljava/lang/String;

    .line 127
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineUser;->avatarUrl:Ljava/lang/String;

    .line 128
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineUser;->description:Ljava/lang/String;

    .line 129
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineUser;->location:Ljava/lang/String;

    .line 130
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineUser;->email:Ljava/lang/String;

    .line 131
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineUser;->phoneNumber:Ljava/lang/String;

    .line 132
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v3

    iput-wide v3, p0, Lco/vine/android/api/VineUser;->userId:J

    .line 133
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v3

    iput-wide v3, p0, Lco/vine/android/api/VineUser;->orderId:J

    .line 134
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineUser;->blocked:I

    .line 135
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineUser;->blocking:I

    .line 136
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineUser;->explicit:I

    .line 137
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineUser;->followerCount:I

    .line 138
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineUser;->followingCount:I

    .line 139
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineUser;->following:I

    .line 140
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineUser;->likeCount:I

    .line 141
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineUser;->postCount:I

    .line 142
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineUser;->verified:I

    .line 143
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineUser;->twitterConnected:I

    .line 144
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineUser;->includePromoted:I

    .line 145
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineUser;->privateAccount:I

    .line 146
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineUser;->followStatus:I

    .line 147
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineUser;->repostsEnabled:I

    .line 148
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineUser;->edition:Ljava/lang/String;

    .line 149
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-ne v0, v1, :cond_0

    move v0, v1

    :goto_0
    iput-boolean v0, p0, Lco/vine/android/api/VineUser;->acceptsOutOfNetworkConversations:Z

    .line 150
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineUser;->profileBackground:I

    .line 151
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineUser;->authoredPostCount:I

    .line 152
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineUser;->verifiedInformation:I

    .line 153
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-ne v0, v1, :cond_1

    move v0, v1

    :goto_1
    iput-boolean v0, p0, Lco/vine/android/api/VineUser;->disableAddressBook:Z

    .line 154
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-ne v0, v1, :cond_2

    move v0, v1

    :goto_2
    iput-boolean v0, p0, Lco/vine/android/api/VineUser;->hiddenEmail:Z

    .line 155
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-ne v0, v1, :cond_3

    :goto_3
    iput-boolean v1, p0, Lco/vine/android/api/VineUser;->hiddenPhoneNumber:Z

    .line 156
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VineUser;->loopCount:J

    .line 157
    return-void

    :cond_0
    move v0, v2

    .line 149
    goto :goto_0

    :cond_1
    move v0, v2

    .line 153
    goto :goto_1

    :cond_2
    move v0, v2

    .line 154
    goto :goto_2

    :cond_3
    move v1, v2

    .line 155
    goto :goto_3
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JJIIIIIIIIILjava/lang/String;Ljava/lang/String;IIIILjava/lang/String;ZIILjava/lang/String;ZZZJ)V
    .locals 3
    .param p1, "username"    # Ljava/lang/String;
    .param p2, "avatarUrl"    # Ljava/lang/String;
    .param p3, "description"    # Ljava/lang/String;
    .param p4, "location"    # Ljava/lang/String;
    .param p5, "userId"    # J
    .param p7, "orderId"    # J
    .param p9, "blocked"    # I
    .param p10, "blocking"    # I
    .param p11, "explicit"    # I
    .param p12, "followerCount"    # I
    .param p13, "followingCount"    # I
    .param p14, "following"    # I
    .param p15, "likeCount"    # I
    .param p16, "postCount"    # I
    .param p17, "verified"    # I
    .param p18, "email"    # Ljava/lang/String;
    .param p19, "phoneNumber"    # Ljava/lang/String;
    .param p20, "twitterConnected"    # I
    .param p21, "includePromoted"    # I
    .param p22, "privateAccount"    # I
    .param p23, "repostsEnabled"    # I
    .param p24, "edition"    # Ljava/lang/String;
    .param p25, "acceptsOutOfNetworkConversations"    # Z
    .param p26, "profileBackground"    # I
    .param p27, "authoredPostCount"    # I
    .param p28, "sectionTitle"    # Ljava/lang/String;
    .param p29, "disableAddressBook"    # Z
    .param p30, "hiddenEmail"    # Z
    .param p31, "hiddenPhoneNumber"    # Z
    .param p32, "loopCount"    # J

    .prologue
    .line 85
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 86
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 87
    invoke-static/range {p19 .. p19}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 88
    move-object/from16 p1, p19

    .line 93
    :cond_0
    :goto_0
    iput-object p1, p0, Lco/vine/android/api/VineUser;->username:Ljava/lang/String;

    .line 94
    iput-object p2, p0, Lco/vine/android/api/VineUser;->avatarUrl:Ljava/lang/String;

    .line 95
    iput-object p3, p0, Lco/vine/android/api/VineUser;->description:Ljava/lang/String;

    .line 96
    iput-object p4, p0, Lco/vine/android/api/VineUser;->location:Ljava/lang/String;

    .line 97
    iput-wide p5, p0, Lco/vine/android/api/VineUser;->userId:J

    .line 98
    iput-wide p7, p0, Lco/vine/android/api/VineUser;->orderId:J

    .line 99
    iput p9, p0, Lco/vine/android/api/VineUser;->blocked:I

    .line 100
    iput p10, p0, Lco/vine/android/api/VineUser;->blocking:I

    .line 101
    iput p11, p0, Lco/vine/android/api/VineUser;->explicit:I

    .line 102
    iput p12, p0, Lco/vine/android/api/VineUser;->followerCount:I

    .line 103
    move/from16 v0, p13

    iput v0, p0, Lco/vine/android/api/VineUser;->followingCount:I

    .line 104
    move/from16 v0, p14

    iput v0, p0, Lco/vine/android/api/VineUser;->following:I

    .line 105
    move/from16 v0, p15

    iput v0, p0, Lco/vine/android/api/VineUser;->likeCount:I

    .line 106
    move/from16 v0, p16

    iput v0, p0, Lco/vine/android/api/VineUser;->postCount:I

    .line 107
    move/from16 v0, p17

    iput v0, p0, Lco/vine/android/api/VineUser;->verified:I

    .line 108
    move-object/from16 v0, p18

    iput-object v0, p0, Lco/vine/android/api/VineUser;->email:Ljava/lang/String;

    .line 109
    move-object/from16 v0, p19

    iput-object v0, p0, Lco/vine/android/api/VineUser;->phoneNumber:Ljava/lang/String;

    .line 110
    move/from16 v0, p20

    iput v0, p0, Lco/vine/android/api/VineUser;->twitterConnected:I

    .line 111
    move/from16 v0, p21

    iput v0, p0, Lco/vine/android/api/VineUser;->includePromoted:I

    .line 112
    move/from16 v0, p22

    iput v0, p0, Lco/vine/android/api/VineUser;->privateAccount:I

    .line 113
    move/from16 v0, p23

    iput v0, p0, Lco/vine/android/api/VineUser;->repostsEnabled:I

    .line 114
    move-object/from16 v0, p24

    iput-object v0, p0, Lco/vine/android/api/VineUser;->edition:Ljava/lang/String;

    .line 115
    move/from16 v0, p25

    iput-boolean v0, p0, Lco/vine/android/api/VineUser;->acceptsOutOfNetworkConversations:Z

    .line 116
    move/from16 v0, p26

    iput v0, p0, Lco/vine/android/api/VineUser;->profileBackground:I

    .line 117
    move/from16 v0, p27

    iput v0, p0, Lco/vine/android/api/VineUser;->authoredPostCount:I

    .line 118
    move-object/from16 v0, p28

    iput-object v0, p0, Lco/vine/android/api/VineUser;->sectionTitle:Ljava/lang/String;

    .line 119
    move/from16 v0, p29

    iput-boolean v0, p0, Lco/vine/android/api/VineUser;->disableAddressBook:Z

    .line 120
    move/from16 v0, p30

    iput-boolean v0, p0, Lco/vine/android/api/VineUser;->hiddenEmail:Z

    .line 121
    move/from16 v0, p31

    iput-boolean v0, p0, Lco/vine/android/api/VineUser;->hiddenPhoneNumber:Z

    .line 122
    move-wide/from16 v0, p32

    iput-wide v0, p0, Lco/vine/android/api/VineUser;->loopCount:J

    .line 123
    return-void

    .line 89
    :cond_1
    invoke-static/range {p18 .. p18}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 90
    move-object/from16 p1, p18

    goto :goto_0
.end method


# virtual methods
.method public acceptsOutOfNetworkConversations()Z
    .locals 1

    .prologue
    .line 328
    iget-boolean v0, p0, Lco/vine/android/api/VineUser;->acceptsOutOfNetworkConversations:Z

    return v0
.end method

.method public areRepostsEnabled()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 270
    iget v1, p0, Lco/vine/android/api/VineUser;->repostsEnabled:I

    if-ne v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public describeContents()I
    .locals 1

    .prologue
    .line 161
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 7
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 201
    if-ne p0, p1, :cond_1

    .line 250
    :cond_0
    :goto_0
    return v1

    .line 202
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

    .line 204
    check-cast v0, Lco/vine/android/api/VineUser;

    .line 206
    .local v0, "vineUser":Lco/vine/android/api/VineUser;
    iget v3, p0, Lco/vine/android/api/VineUser;->blocked:I

    iget v4, v0, Lco/vine/android/api/VineUser;->blocked:I

    if-eq v3, v4, :cond_4

    move v1, v2

    goto :goto_0

    .line 207
    :cond_4
    iget v3, p0, Lco/vine/android/api/VineUser;->blocking:I

    iget v4, v0, Lco/vine/android/api/VineUser;->blocking:I

    if-eq v3, v4, :cond_5

    move v1, v2

    goto :goto_0

    .line 208
    :cond_5
    iget v3, p0, Lco/vine/android/api/VineUser;->explicit:I

    iget v4, v0, Lco/vine/android/api/VineUser;->explicit:I

    if-eq v3, v4, :cond_6

    move v1, v2

    goto :goto_0

    .line 209
    :cond_6
    iget v3, p0, Lco/vine/android/api/VineUser;->followerCount:I

    iget v4, v0, Lco/vine/android/api/VineUser;->followerCount:I

    if-eq v3, v4, :cond_7

    move v1, v2

    goto :goto_0

    .line 210
    :cond_7
    iget v3, p0, Lco/vine/android/api/VineUser;->following:I

    iget v4, v0, Lco/vine/android/api/VineUser;->following:I

    if-eq v3, v4, :cond_8

    move v1, v2

    goto :goto_0

    .line 211
    :cond_8
    iget v3, p0, Lco/vine/android/api/VineUser;->followingCount:I

    iget v4, v0, Lco/vine/android/api/VineUser;->followingCount:I

    if-eq v3, v4, :cond_9

    move v1, v2

    goto :goto_0

    .line 212
    :cond_9
    iget v3, p0, Lco/vine/android/api/VineUser;->likeCount:I

    iget v4, v0, Lco/vine/android/api/VineUser;->likeCount:I

    if-eq v3, v4, :cond_a

    move v1, v2

    goto :goto_0

    .line 213
    :cond_a
    iget-wide v3, p0, Lco/vine/android/api/VineUser;->orderId:J

    iget-wide v5, v0, Lco/vine/android/api/VineUser;->orderId:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_b

    move v1, v2

    goto :goto_0

    .line 214
    :cond_b
    iget v3, p0, Lco/vine/android/api/VineUser;->postCount:I

    iget v4, v0, Lco/vine/android/api/VineUser;->postCount:I

    if-eq v3, v4, :cond_c

    move v1, v2

    goto :goto_0

    .line 215
    :cond_c
    iget v3, p0, Lco/vine/android/api/VineUser;->twitterConnected:I

    iget v4, v0, Lco/vine/android/api/VineUser;->twitterConnected:I

    if-eq v3, v4, :cond_d

    move v1, v2

    goto :goto_0

    .line 216
    :cond_d
    iget v3, p0, Lco/vine/android/api/VineUser;->includePromoted:I

    iget v4, v0, Lco/vine/android/api/VineUser;->includePromoted:I

    if-eq v3, v4, :cond_e

    move v1, v2

    goto :goto_0

    .line 217
    :cond_e
    iget-wide v3, p0, Lco/vine/android/api/VineUser;->userId:J

    iget-wide v5, v0, Lco/vine/android/api/VineUser;->userId:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_f

    move v1, v2

    goto :goto_0

    .line 218
    :cond_f
    iget v3, p0, Lco/vine/android/api/VineUser;->verified:I

    iget v4, v0, Lco/vine/android/api/VineUser;->verified:I

    if-eq v3, v4, :cond_10

    move v1, v2

    goto :goto_0

    .line 219
    :cond_10
    iget v3, p0, Lco/vine/android/api/VineUser;->privateAccount:I

    iget v4, v0, Lco/vine/android/api/VineUser;->privateAccount:I

    if-eq v3, v4, :cond_11

    move v1, v2

    goto/16 :goto_0

    .line 220
    :cond_11
    iget v3, p0, Lco/vine/android/api/VineUser;->followStatus:I

    iget v4, v0, Lco/vine/android/api/VineUser;->followStatus:I

    if-eq v3, v4, :cond_12

    move v1, v2

    goto/16 :goto_0

    .line 221
    :cond_12
    iget-object v3, p0, Lco/vine/android/api/VineUser;->avatarUrl:Ljava/lang/String;

    if-eqz v3, :cond_14

    iget-object v3, p0, Lco/vine/android/api/VineUser;->avatarUrl:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VineUser;->avatarUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_15

    :cond_13
    move v1, v2

    .line 222
    goto/16 :goto_0

    .line 221
    :cond_14
    iget-object v3, v0, Lco/vine/android/api/VineUser;->avatarUrl:Ljava/lang/String;

    if-nez v3, :cond_13

    .line 223
    :cond_15
    iget-object v3, p0, Lco/vine/android/api/VineUser;->description:Ljava/lang/String;

    if-eqz v3, :cond_17

    iget-object v3, p0, Lco/vine/android/api/VineUser;->description:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VineUser;->description:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_18

    :cond_16
    move v1, v2

    .line 225
    goto/16 :goto_0

    .line 223
    :cond_17
    iget-object v3, v0, Lco/vine/android/api/VineUser;->description:Ljava/lang/String;

    if-nez v3, :cond_16

    .line 226
    :cond_18
    iget-object v3, p0, Lco/vine/android/api/VineUser;->email:Ljava/lang/String;

    if-eqz v3, :cond_1a

    iget-object v3, p0, Lco/vine/android/api/VineUser;->email:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VineUser;->email:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1b

    :cond_19
    move v1, v2

    goto/16 :goto_0

    :cond_1a
    iget-object v3, v0, Lco/vine/android/api/VineUser;->email:Ljava/lang/String;

    if-nez v3, :cond_19

    .line 227
    :cond_1b
    iget-object v3, p0, Lco/vine/android/api/VineUser;->location:Ljava/lang/String;

    if-eqz v3, :cond_1d

    iget-object v3, p0, Lco/vine/android/api/VineUser;->location:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VineUser;->location:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1e

    :cond_1c
    move v1, v2

    .line 228
    goto/16 :goto_0

    .line 227
    :cond_1d
    iget-object v3, v0, Lco/vine/android/api/VineUser;->location:Ljava/lang/String;

    if-nez v3, :cond_1c

    .line 229
    :cond_1e
    iget-object v3, p0, Lco/vine/android/api/VineUser;->phoneNumber:Ljava/lang/String;

    if-eqz v3, :cond_20

    iget-object v3, p0, Lco/vine/android/api/VineUser;->phoneNumber:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VineUser;->phoneNumber:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_21

    :cond_1f
    move v1, v2

    .line 231
    goto/16 :goto_0

    .line 229
    :cond_20
    iget-object v3, v0, Lco/vine/android/api/VineUser;->phoneNumber:Ljava/lang/String;

    if-nez v3, :cond_1f

    .line 232
    :cond_21
    iget-object v3, p0, Lco/vine/android/api/VineUser;->username:Ljava/lang/String;

    if-eqz v3, :cond_23

    iget-object v3, p0, Lco/vine/android/api/VineUser;->username:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VineUser;->username:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_24

    :cond_22
    move v1, v2

    .line 233
    goto/16 :goto_0

    .line 232
    :cond_23
    iget-object v3, v0, Lco/vine/android/api/VineUser;->username:Ljava/lang/String;

    if-nez v3, :cond_22

    .line 234
    :cond_24
    iget v3, p0, Lco/vine/android/api/VineUser;->repostsEnabled:I

    iget v4, v0, Lco/vine/android/api/VineUser;->repostsEnabled:I

    if-eq v3, v4, :cond_25

    move v1, v2

    goto/16 :goto_0

    .line 235
    :cond_25
    iget-object v3, p0, Lco/vine/android/api/VineUser;->edition:Ljava/lang/String;

    if-eqz v3, :cond_27

    iget-object v3, p0, Lco/vine/android/api/VineUser;->edition:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VineUser;->edition:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_28

    :cond_26
    move v1, v2

    .line 236
    goto/16 :goto_0

    .line 235
    :cond_27
    iget-object v3, v0, Lco/vine/android/api/VineUser;->edition:Ljava/lang/String;

    if-nez v3, :cond_26

    .line 237
    :cond_28
    iget-boolean v3, p0, Lco/vine/android/api/VineUser;->acceptsOutOfNetworkConversations:Z

    iget-boolean v4, v0, Lco/vine/android/api/VineUser;->acceptsOutOfNetworkConversations:Z

    if-eq v3, v4, :cond_29

    move v1, v2

    .line 238
    goto/16 :goto_0

    .line 240
    :cond_29
    iget v3, p0, Lco/vine/android/api/VineUser;->profileBackground:I

    iget v4, v0, Lco/vine/android/api/VineUser;->profileBackground:I

    if-eq v3, v4, :cond_2a

    move v1, v2

    .line 241
    goto/16 :goto_0

    .line 243
    :cond_2a
    iget v3, p0, Lco/vine/android/api/VineUser;->authoredPostCount:I

    iget v4, v0, Lco/vine/android/api/VineUser;->authoredPostCount:I

    if-eq v3, v4, :cond_2b

    move v1, v2

    goto/16 :goto_0

    .line 244
    :cond_2b
    iget v3, p0, Lco/vine/android/api/VineUser;->verifiedInformation:I

    iget v4, v0, Lco/vine/android/api/VineUser;->verifiedInformation:I

    if-eq v3, v4, :cond_2c

    move v1, v2

    goto/16 :goto_0

    .line 245
    :cond_2c
    iget-boolean v3, p0, Lco/vine/android/api/VineUser;->disableAddressBook:Z

    iget-boolean v4, v0, Lco/vine/android/api/VineUser;->disableAddressBook:Z

    if-eq v3, v4, :cond_2d

    move v1, v2

    goto/16 :goto_0

    .line 246
    :cond_2d
    iget-boolean v3, p0, Lco/vine/android/api/VineUser;->hiddenEmail:Z

    iget-boolean v4, v0, Lco/vine/android/api/VineUser;->hiddenEmail:Z

    if-eq v3, v4, :cond_2e

    move v1, v2

    goto/16 :goto_0

    .line 247
    :cond_2e
    iget-boolean v3, p0, Lco/vine/android/api/VineUser;->hiddenPhoneNumber:Z

    iget-boolean v4, v0, Lco/vine/android/api/VineUser;->hiddenPhoneNumber:Z

    if-eq v3, v4, :cond_2f

    move v1, v2

    goto/16 :goto_0

    .line 248
    :cond_2f
    iget-wide v3, p0, Lco/vine/android/api/VineUser;->loopCount:J

    iget-wide v5, v0, Lco/vine/android/api/VineUser;->loopCount:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_0

    move v1, v2

    goto/16 :goto_0
.end method

.method public getProfileBackgroundForShowing()I
    .locals 2

    .prologue
    .line 324
    iget v0, p0, Lco/vine/android/api/VineUser;->profileBackground:I

    const/high16 v1, -0x1000000

    or-int/2addr v0, v1

    return v0
.end method

.method public hasFollowApprovalPending()Z
    .locals 1

    .prologue
    .line 277
    iget v0, p0, Lco/vine/android/api/VineUser;->followStatus:I

    and-int/lit8 v0, v0, 0x1

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasFollowRequested()Z
    .locals 1

    .prologue
    .line 284
    iget v0, p0, Lco/vine/android/api/VineUser;->followStatus:I

    and-int/lit8 v0, v0, 0x2

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hashCode()I
    .locals 8

    .prologue
    const/16 v7, 0x20

    const/4 v1, 0x0

    .line 333
    iget-object v2, p0, Lco/vine/android/api/VineUser;->username:Ljava/lang/String;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lco/vine/android/api/VineUser;->username:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v0

    .line 334
    .local v0, "result":I
    :goto_0
    mul-int/lit8 v3, v0, 0x1f

    iget-object v2, p0, Lco/vine/android/api/VineUser;->edition:Ljava/lang/String;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lco/vine/android/api/VineUser;->edition:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    :goto_1
    add-int v0, v3, v2

    .line 335
    mul-int/lit8 v3, v0, 0x1f

    iget-object v2, p0, Lco/vine/android/api/VineUser;->avatarUrl:Ljava/lang/String;

    if-eqz v2, :cond_3

    iget-object v2, p0, Lco/vine/android/api/VineUser;->avatarUrl:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    :goto_2
    add-int v0, v3, v2

    .line 336
    mul-int/lit8 v3, v0, 0x1f

    iget-object v2, p0, Lco/vine/android/api/VineUser;->description:Ljava/lang/String;

    if-eqz v2, :cond_4

    iget-object v2, p0, Lco/vine/android/api/VineUser;->description:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    :goto_3
    add-int v0, v3, v2

    .line 337
    mul-int/lit8 v3, v0, 0x1f

    iget-object v2, p0, Lco/vine/android/api/VineUser;->location:Ljava/lang/String;

    if-eqz v2, :cond_5

    iget-object v2, p0, Lco/vine/android/api/VineUser;->location:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    :goto_4
    add-int v0, v3, v2

    .line 338
    mul-int/lit8 v3, v0, 0x1f

    iget-object v2, p0, Lco/vine/android/api/VineUser;->phoneNumber:Ljava/lang/String;

    if-eqz v2, :cond_6

    iget-object v2, p0, Lco/vine/android/api/VineUser;->phoneNumber:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    :goto_5
    add-int v0, v3, v2

    .line 339
    mul-int/lit8 v3, v0, 0x1f

    iget-object v2, p0, Lco/vine/android/api/VineUser;->email:Ljava/lang/String;

    if-eqz v2, :cond_7

    iget-object v2, p0, Lco/vine/android/api/VineUser;->email:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->hashCode()I

    move-result v2

    :goto_6
    add-int v0, v3, v2

    .line 340
    mul-int/lit8 v2, v0, 0x1f

    iget-wide v3, p0, Lco/vine/android/api/VineUser;->userId:J

    iget-wide v5, p0, Lco/vine/android/api/VineUser;->userId:J

    ushr-long/2addr v5, v7

    xor-long/2addr v3, v5

    long-to-int v3, v3

    add-int v0, v2, v3

    .line 341
    mul-int/lit8 v2, v0, 0x1f

    iget-wide v3, p0, Lco/vine/android/api/VineUser;->orderId:J

    iget-wide v5, p0, Lco/vine/android/api/VineUser;->orderId:J

    ushr-long/2addr v5, v7

    xor-long/2addr v3, v5

    long-to-int v3, v3

    add-int v0, v2, v3

    .line 342
    mul-int/lit8 v2, v0, 0x1f

    iget-wide v3, p0, Lco/vine/android/api/VineUser;->loopCount:J

    iget-wide v5, p0, Lco/vine/android/api/VineUser;->loopCount:J

    ushr-long/2addr v5, v7

    xor-long/2addr v3, v5

    long-to-int v3, v3

    add-int v0, v2, v3

    .line 343
    mul-int/lit8 v2, v0, 0x1f

    iget v3, p0, Lco/vine/android/api/VineUser;->blocked:I

    add-int v0, v2, v3

    .line 344
    mul-int/lit8 v2, v0, 0x1f

    iget v3, p0, Lco/vine/android/api/VineUser;->blocking:I

    add-int v0, v2, v3

    .line 345
    mul-int/lit8 v2, v0, 0x1f

    iget v3, p0, Lco/vine/android/api/VineUser;->explicit:I

    add-int v0, v2, v3

    .line 346
    mul-int/lit8 v2, v0, 0x1f

    iget v3, p0, Lco/vine/android/api/VineUser;->followerCount:I

    add-int v0, v2, v3

    .line 347
    mul-int/lit8 v2, v0, 0x1f

    iget v3, p0, Lco/vine/android/api/VineUser;->followingCount:I

    add-int v0, v2, v3

    .line 348
    mul-int/lit8 v2, v0, 0x1f

    iget v3, p0, Lco/vine/android/api/VineUser;->following:I

    add-int v0, v2, v3

    .line 349
    mul-int/lit8 v2, v0, 0x1f

    iget v3, p0, Lco/vine/android/api/VineUser;->likeCount:I

    add-int v0, v2, v3

    .line 350
    mul-int/lit8 v2, v0, 0x1f

    iget v3, p0, Lco/vine/android/api/VineUser;->postCount:I

    add-int v0, v2, v3

    .line 351
    mul-int/lit8 v2, v0, 0x1f

    iget v3, p0, Lco/vine/android/api/VineUser;->verified:I

    add-int v0, v2, v3

    .line 352
    mul-int/lit8 v2, v0, 0x1f

    iget v3, p0, Lco/vine/android/api/VineUser;->twitterConnected:I

    add-int v0, v2, v3

    .line 353
    mul-int/lit8 v2, v0, 0x1f

    iget v3, p0, Lco/vine/android/api/VineUser;->includePromoted:I

    add-int v0, v2, v3

    .line 354
    mul-int/lit8 v2, v0, 0x1f

    iget v3, p0, Lco/vine/android/api/VineUser;->privateAccount:I

    add-int v0, v2, v3

    .line 355
    mul-int/lit8 v2, v0, 0x1f

    iget v3, p0, Lco/vine/android/api/VineUser;->followStatus:I

    add-int v0, v2, v3

    .line 356
    mul-int/lit8 v2, v0, 0x1f

    iget v3, p0, Lco/vine/android/api/VineUser;->repostsEnabled:I

    add-int v0, v2, v3

    .line 357
    mul-int/lit8 v2, v0, 0x1f

    iget-boolean v3, p0, Lco/vine/android/api/VineUser;->acceptsOutOfNetworkConversations:Z

    if-eqz v3, :cond_0

    const/4 v1, 0x1

    :cond_0
    add-int v0, v2, v1

    .line 358
    mul-int/lit8 v1, v0, 0x1f

    iget v2, p0, Lco/vine/android/api/VineUser;->profileBackground:I

    add-int v0, v1, v2

    .line 359
    mul-int/lit8 v1, v0, 0x1f

    iget v2, p0, Lco/vine/android/api/VineUser;->verifiedInformation:I

    add-int v0, v1, v2

    .line 360
    return v0

    .end local v0    # "result":I
    :cond_1
    move v0, v1

    .line 333
    goto/16 :goto_0

    .restart local v0    # "result":I
    :cond_2
    move v2, v1

    .line 334
    goto/16 :goto_1

    :cond_3
    move v2, v1

    .line 335
    goto/16 :goto_2

    :cond_4
    move v2, v1

    .line 336
    goto/16 :goto_3

    :cond_5
    move v2, v1

    .line 337
    goto/16 :goto_4

    :cond_6
    move v2, v1

    .line 338
    goto/16 :goto_5

    :cond_7
    move v2, v1

    .line 339
    goto/16 :goto_6
.end method

.method public isBlocked()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 266
    iget v1, p0, Lco/vine/android/api/VineUser;->blocked:I

    if-ne v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isEmailVerified()Z
    .locals 1

    .prologue
    .line 320
    iget v0, p0, Lco/vine/android/api/VineUser;->verifiedInformation:I

    and-int/lit8 v0, v0, 0x1

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isFollowing()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 258
    iget v1, p0, Lco/vine/android/api/VineUser;->following:I

    if-ne v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isPhoneVerified()Z
    .locals 1

    .prologue
    .line 316
    iget v0, p0, Lco/vine/android/api/VineUser;->verifiedInformation:I

    and-int/lit8 v0, v0, 0x2

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isPrivate()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 254
    iget v1, p0, Lco/vine/android/api/VineUser;->privateAccount:I

    if-ne v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isPrivateLocked()Z
    .locals 1

    .prologue
    .line 262
    invoke-virtual {p0}, Lco/vine/android/api/VineUser;->isPrivate()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lco/vine/android/api/VineUser;->isFollowing()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lco/vine/android/api/VineUser;->hasFollowRequested()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isVerified()Z
    .locals 2

    .prologue
    const/4 v0, 0x1

    .line 312
    iget v1, p0, Lco/vine/android/api/VineUser;->verified:I

    if-ne v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setApprovalPending()V
    .locals 1

    .prologue
    .line 288
    iget v0, p0, Lco/vine/android/api/VineUser;->followStatus:I

    or-int/lit8 v0, v0, 0x1

    iput v0, p0, Lco/vine/android/api/VineUser;->followStatus:I

    .line 289
    return-void
.end method

.method public setEmailVerified()V
    .locals 1

    .prologue
    .line 296
    iget v0, p0, Lco/vine/android/api/VineUser;->verifiedInformation:I

    or-int/lit8 v0, v0, 0x1

    iput v0, p0, Lco/vine/android/api/VineUser;->verifiedInformation:I

    .line 297
    return-void
.end method

.method public setFollowRequested()V
    .locals 1

    .prologue
    .line 292
    iget v0, p0, Lco/vine/android/api/VineUser;->followStatus:I

    or-int/lit8 v0, v0, 0x2

    iput v0, p0, Lco/vine/android/api/VineUser;->followStatus:I

    .line 293
    return-void
.end method

.method public setPhoneVerified()V
    .locals 1

    .prologue
    .line 300
    iget v0, p0, Lco/vine/android/api/VineUser;->verifiedInformation:I

    or-int/lit8 v0, v0, 0x2

    iput v0, p0, Lco/vine/android/api/VineUser;->verifiedInformation:I

    .line 301
    return-void
.end method

.method public unsetEmailVerified()V
    .locals 1

    .prologue
    .line 304
    iget v0, p0, Lco/vine/android/api/VineUser;->verifiedInformation:I

    and-int/lit8 v0, v0, -0x2

    iput v0, p0, Lco/vine/android/api/VineUser;->verifiedInformation:I

    .line 305
    return-void
.end method

.method public unsetPhoneVerified()V
    .locals 1

    .prologue
    .line 308
    iget v0, p0, Lco/vine/android/api/VineUser;->verifiedInformation:I

    and-int/lit8 v0, v0, -0x3

    iput v0, p0, Lco/vine/android/api/VineUser;->verifiedInformation:I

    .line 309
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 5
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 166
    iget-object v0, p0, Lco/vine/android/api/VineUser;->username:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 167
    iget-object v0, p0, Lco/vine/android/api/VineUser;->avatarUrl:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 168
    iget-object v0, p0, Lco/vine/android/api/VineUser;->description:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 169
    iget-object v0, p0, Lco/vine/android/api/VineUser;->location:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 170
    iget-object v0, p0, Lco/vine/android/api/VineUser;->email:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 171
    iget-object v0, p0, Lco/vine/android/api/VineUser;->phoneNumber:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 172
    iget-wide v3, p0, Lco/vine/android/api/VineUser;->userId:J

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeLong(J)V

    .line 173
    iget-wide v3, p0, Lco/vine/android/api/VineUser;->orderId:J

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeLong(J)V

    .line 174
    iget v0, p0, Lco/vine/android/api/VineUser;->blocked:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 175
    iget v0, p0, Lco/vine/android/api/VineUser;->blocking:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 176
    iget v0, p0, Lco/vine/android/api/VineUser;->explicit:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 177
    iget v0, p0, Lco/vine/android/api/VineUser;->followerCount:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 178
    iget v0, p0, Lco/vine/android/api/VineUser;->followingCount:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 179
    iget v0, p0, Lco/vine/android/api/VineUser;->following:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 180
    iget v0, p0, Lco/vine/android/api/VineUser;->likeCount:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 181
    iget v0, p0, Lco/vine/android/api/VineUser;->postCount:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 182
    iget v0, p0, Lco/vine/android/api/VineUser;->verified:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 183
    iget v0, p0, Lco/vine/android/api/VineUser;->twitterConnected:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 184
    iget v0, p0, Lco/vine/android/api/VineUser;->includePromoted:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 185
    iget v0, p0, Lco/vine/android/api/VineUser;->privateAccount:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 186
    iget v0, p0, Lco/vine/android/api/VineUser;->followStatus:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 187
    iget v0, p0, Lco/vine/android/api/VineUser;->repostsEnabled:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 188
    iget-object v0, p0, Lco/vine/android/api/VineUser;->edition:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 189
    iget-boolean v0, p0, Lco/vine/android/api/VineUser;->acceptsOutOfNetworkConversations:Z

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 190
    iget v0, p0, Lco/vine/android/api/VineUser;->profileBackground:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 191
    iget v0, p0, Lco/vine/android/api/VineUser;->authoredPostCount:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 192
    iget v0, p0, Lco/vine/android/api/VineUser;->verifiedInformation:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 193
    iget-boolean v0, p0, Lco/vine/android/api/VineUser;->disableAddressBook:Z

    if-eqz v0, :cond_1

    move v0, v1

    :goto_1
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 194
    iget-boolean v0, p0, Lco/vine/android/api/VineUser;->hiddenEmail:Z

    if-eqz v0, :cond_2

    move v0, v1

    :goto_2
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 195
    iget-boolean v0, p0, Lco/vine/android/api/VineUser;->hiddenPhoneNumber:Z

    if-eqz v0, :cond_3

    :goto_3
    invoke-virtual {p1, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 196
    iget-wide v0, p0, Lco/vine/android/api/VineUser;->loopCount:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 197
    return-void

    :cond_0
    move v0, v2

    .line 189
    goto :goto_0

    :cond_1
    move v0, v2

    .line 193
    goto :goto_1

    :cond_2
    move v0, v2

    .line 194
    goto :goto_2

    :cond_3
    move v1, v2

    .line 195
    goto :goto_3
.end method
