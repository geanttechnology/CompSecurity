.class public Lco/vine/android/api/VinePrivateMessage;
.super Ljava/lang/Object;
.source "VinePrivateMessage.java"

# interfaces
.implements Ljava/io/Externalizable;
.implements Landroid/os/Parcelable;


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lco/vine/android/api/VinePrivateMessage;",
            ">;"
        }
    .end annotation
.end field

.field public static final NO_LOOP_LIMIT:I = 0x7fffffff


# instance fields
.field public avatarUrl:Ljava/lang/String;

.field public conversationId:J

.field public conversationRowId:J

.field public created:J

.field public ephemeral:Z

.field public errorCode:I

.field public errorReason:Ljava/lang/String;

.field public hasVideo:Z

.field public isInNetwork:Z

.field public isLast:Z

.field public localStartTime:J

.field public maxLoops:I

.field public message:Ljava/lang/String;

.field public messageId:J

.field public messageRowId:J

.field public networkType:I

.field public post:Lco/vine/android/api/VinePost;

.field public postId:J

.field public thumbnailUrl:Ljava/lang/String;

.field public uploadPath:Ljava/lang/String;

.field public userId:J

.field public vanished:Z

.field public vanishedDate:J

.field public vanishedViewedSb:Landroid/text/SpannableStringBuilder;

.field public videoUrl:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 307
    new-instance v0, Lco/vine/android/api/VinePrivateMessage$1;

    invoke-direct {v0}, Lco/vine/android/api/VinePrivateMessage$1;-><init>()V

    sput-object v0, Lco/vine/android/api/VinePrivateMessage;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 59
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/api/VinePrivateMessage;->maxLoops:I

    .line 59
    return-void
.end method

.method public constructor <init>(JJJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZIJZJJILjava/lang/String;)V
    .locals 28
    .param p1, "messageRowId"    # J
    .param p3, "conversationId"    # J
    .param p5, "messageId"    # J
    .param p7, "userId"    # J
    .param p9, "created"    # J
    .param p11, "message"    # Ljava/lang/String;
    .param p12, "videoUrl"    # Ljava/lang/String;
    .param p13, "thumbnailUrl"    # Ljava/lang/String;
    .param p14, "networkType"    # I
    .param p15, "isLast"    # Z
    .param p16, "vanished"    # Z
    .param p17, "maxLoops"    # I
    .param p18, "vanishedDate"    # J
    .param p20, "ephmeral"    # Z
    .param p21, "localStartTime"    # J
    .param p23, "postId"    # J
    .param p25, "errorCode"    # I
    .param p26, "errorReason"    # Ljava/lang/String;

    .prologue
    .line 92
    const/16 v27, 0x0

    move-object/from16 v0, p0

    move-wide/from16 v1, p1

    move-wide/from16 v3, p3

    move-wide/from16 v5, p5

    move-wide/from16 v7, p7

    move-wide/from16 v9, p9

    move-object/from16 v11, p11

    move-object/from16 v12, p12

    move-object/from16 v13, p13

    move/from16 v14, p14

    move/from16 v15, p15

    move/from16 v16, p16

    move/from16 v17, p17

    move-wide/from16 v18, p18

    move/from16 v20, p20

    move-wide/from16 v21, p21

    move-wide/from16 v23, p23

    move/from16 v25, p25

    move-object/from16 v26, p26

    invoke-direct/range {v0 .. v27}, Lco/vine/android/api/VinePrivateMessage;-><init>(JJJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZIJZJJILjava/lang/String;Ljava/lang/String;)V

    .line 94
    return-void
.end method

.method public constructor <init>(JJJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZIJZJJILjava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "messageRowId"    # J
    .param p3, "conversationId"    # J
    .param p5, "messageId"    # J
    .param p7, "userId"    # J
    .param p9, "created"    # J
    .param p11, "message"    # Ljava/lang/String;
    .param p12, "videoUrl"    # Ljava/lang/String;
    .param p13, "thumbnailUrl"    # Ljava/lang/String;
    .param p14, "networkType"    # I
    .param p15, "isLast"    # Z
    .param p16, "vanished"    # Z
    .param p17, "maxLoops"    # I
    .param p18, "vanishedDate"    # J
    .param p20, "ephmeral"    # Z
    .param p21, "localStartTime"    # J
    .param p23, "postId"    # J
    .param p25, "errorCode"    # I
    .param p26, "errorReason"    # Ljava/lang/String;
    .param p27, "uploadPath"    # Ljava/lang/String;

    .prologue
    .line 64
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    const/4 v2, 0x0

    iput v2, p0, Lco/vine/android/api/VinePrivateMessage;->maxLoops:I

    .line 65
    iput-wide p1, p0, Lco/vine/android/api/VinePrivateMessage;->messageRowId:J

    .line 66
    iput-wide p3, p0, Lco/vine/android/api/VinePrivateMessage;->conversationId:J

    .line 67
    iput-wide p5, p0, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    .line 68
    iput-wide p7, p0, Lco/vine/android/api/VinePrivateMessage;->userId:J

    .line 69
    iput-wide p9, p0, Lco/vine/android/api/VinePrivateMessage;->created:J

    .line 70
    iput-object p11, p0, Lco/vine/android/api/VinePrivateMessage;->message:Ljava/lang/String;

    .line 71
    iput-object p12, p0, Lco/vine/android/api/VinePrivateMessage;->videoUrl:Ljava/lang/String;

    .line 72
    move-object/from16 v0, p13

    iput-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->thumbnailUrl:Ljava/lang/String;

    .line 73
    move/from16 v0, p14

    iput v0, p0, Lco/vine/android/api/VinePrivateMessage;->networkType:I

    .line 74
    invoke-static {p12}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    const/4 v2, 0x1

    :goto_0
    iput-boolean v2, p0, Lco/vine/android/api/VinePrivateMessage;->hasVideo:Z

    .line 75
    const/4 v2, 0x1

    move/from16 v0, p14

    if-ne v0, v2, :cond_1

    const/4 v2, 0x1

    :goto_1
    iput-boolean v2, p0, Lco/vine/android/api/VinePrivateMessage;->isInNetwork:Z

    .line 76
    move/from16 v0, p15

    iput-boolean v0, p0, Lco/vine/android/api/VinePrivateMessage;->isLast:Z

    .line 77
    move/from16 v0, p16

    iput-boolean v0, p0, Lco/vine/android/api/VinePrivateMessage;->vanished:Z

    .line 78
    move/from16 v0, p17

    iput v0, p0, Lco/vine/android/api/VinePrivateMessage;->maxLoops:I

    .line 79
    move-wide/from16 v0, p18

    iput-wide v0, p0, Lco/vine/android/api/VinePrivateMessage;->vanishedDate:J

    .line 80
    move/from16 v0, p20

    iput-boolean v0, p0, Lco/vine/android/api/VinePrivateMessage;->ephemeral:Z

    .line 81
    move-wide/from16 v0, p21

    iput-wide v0, p0, Lco/vine/android/api/VinePrivateMessage;->localStartTime:J

    .line 82
    move-wide/from16 v0, p23

    iput-wide v0, p0, Lco/vine/android/api/VinePrivateMessage;->postId:J

    .line 83
    move/from16 v0, p25

    iput v0, p0, Lco/vine/android/api/VinePrivateMessage;->errorCode:I

    .line 84
    move-object/from16 v0, p26

    iput-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->errorReason:Ljava/lang/String;

    .line 85
    move-object/from16 v0, p27

    iput-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->uploadPath:Ljava/lang/String;

    .line 86
    return-void

    .line 74
    :cond_0
    const/4 v2, 0x0

    goto :goto_0

    .line 75
    :cond_1
    const/4 v2, 0x0

    goto :goto_1
.end method

.method public constructor <init>(JJJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZIJZJLco/vine/android/api/VinePost;ILjava/lang/String;)V
    .locals 29
    .param p1, "messageRowId"    # J
    .param p3, "conversationId"    # J
    .param p5, "messageId"    # J
    .param p7, "userId"    # J
    .param p9, "created"    # J
    .param p11, "message"    # Ljava/lang/String;
    .param p12, "videoUrl"    # Ljava/lang/String;
    .param p13, "thumbnailUrl"    # Ljava/lang/String;
    .param p14, "networkType"    # I
    .param p15, "isLast"    # Z
    .param p16, "vanished"    # Z
    .param p17, "maxLoops"    # I
    .param p18, "vanishedDate"    # J
    .param p20, "ephmeral"    # Z
    .param p21, "localStartTime"    # J
    .param p23, "post"    # Lco/vine/android/api/VinePost;
    .param p24, "errorCode"    # I
    .param p25, "errorReason"    # Ljava/lang/String;

    .prologue
    .line 100
    if-eqz p23, :cond_0

    move-object/from16 v0, p23

    iget-wide v0, v0, Lco/vine/android/api/VinePost;->postId:J

    move-wide/from16 v25, v0

    :goto_0
    move-object/from16 v2, p0

    move-wide/from16 v3, p1

    move-wide/from16 v5, p3

    move-wide/from16 v7, p5

    move-wide/from16 v9, p7

    move-wide/from16 v11, p9

    move-object/from16 v13, p11

    move-object/from16 v14, p12

    move-object/from16 v15, p13

    move/from16 v16, p14

    move/from16 v17, p15

    move/from16 v18, p16

    move/from16 v19, p17

    move-wide/from16 v20, p18

    move/from16 v22, p20

    move-wide/from16 v23, p21

    move/from16 v27, p24

    move-object/from16 v28, p25

    invoke-direct/range {v2 .. v28}, Lco/vine/android/api/VinePrivateMessage;-><init>(JJJJJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;IZZIJZJJILjava/lang/String;)V

    .line 102
    move-object/from16 v0, p23

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/api/VinePrivateMessage;->post:Lco/vine/android/api/VinePost;

    .line 103
    return-void

    .line 100
    :cond_0
    const-wide/16 v25, 0x0

    goto :goto_0
.end method

.method public constructor <init>(Landroid/database/Cursor;)V
    .locals 5
    .param p1, "cursor"    # Landroid/database/Cursor;

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 105
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    iput v2, p0, Lco/vine/android/api/VinePrivateMessage;->maxLoops:I

    .line 106
    invoke-interface {p1, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v3

    iput-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->messageRowId:J

    .line 107
    const/16 v0, 0x13

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v3

    iput-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->conversationId:J

    .line 108
    invoke-interface {p1, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v3

    iput-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->conversationRowId:J

    .line 109
    const/4 v0, 0x2

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v3

    iput-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    .line 110
    const/4 v0, 0x5

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->message:Ljava/lang/String;

    .line 111
    const/4 v0, 0x3

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v3

    iput-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->userId:J

    .line 112
    const/4 v0, 0x4

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v3

    iput-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->created:J

    .line 113
    const/4 v0, 0x6

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->videoUrl:Ljava/lang/String;

    .line 114
    const/4 v0, 0x7

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->thumbnailUrl:Ljava/lang/String;

    .line 115
    const/16 v0, 0x18

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->avatarUrl:Ljava/lang/String;

    .line 116
    const/16 v0, 0x14

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VinePrivateMessage;->networkType:I

    .line 117
    iget-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->videoUrl:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    move v0, v1

    :goto_0
    iput-boolean v0, p0, Lco/vine/android/api/VinePrivateMessage;->hasVideo:Z

    .line 118
    iget v0, p0, Lco/vine/android/api/VinePrivateMessage;->networkType:I

    if-ne v0, v1, :cond_2

    move v0, v1

    :goto_1
    iput-boolean v0, p0, Lco/vine/android/api/VinePrivateMessage;->isInNetwork:Z

    .line 119
    const/16 v0, 0x8

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    if-ne v0, v1, :cond_3

    move v0, v1

    :goto_2
    iput-boolean v0, p0, Lco/vine/android/api/VinePrivateMessage;->isLast:Z

    .line 120
    const/16 v0, 0x9

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    if-ne v0, v1, :cond_4

    move v0, v1

    :goto_3
    iput-boolean v0, p0, Lco/vine/android/api/VinePrivateMessage;->vanished:Z

    .line 121
    const/16 v0, 0xa

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VinePrivateMessage;->maxLoops:I

    .line 122
    const/16 v0, 0xb

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v3

    iput-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->vanishedDate:J

    .line 123
    const/16 v0, 0xc

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    if-ne v0, v1, :cond_5

    :goto_4
    iput-boolean v1, p0, Lco/vine/android/api/VinePrivateMessage;->ephemeral:Z

    .line 124
    const/16 v0, 0xd

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VinePrivateMessage;->localStartTime:J

    .line 125
    const/16 v0, 0xf

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VinePrivateMessage;->postId:J

    .line 126
    const/16 v0, 0x11

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getInt(I)I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VinePrivateMessage;->errorCode:I

    .line 127
    const/16 v0, 0x12

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->errorReason:Ljava/lang/String;

    .line 128
    const/16 v0, 0x10

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->uploadPath:Ljava/lang/String;

    .line 130
    iget-wide v0, p0, Lco/vine/android/api/VinePrivateMessage;->postId:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    .line 131
    new-instance v0, Lco/vine/android/api/VinePost;

    invoke-direct {v0}, Lco/vine/android/api/VinePost;-><init>()V

    iput-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->post:Lco/vine/android/api/VinePost;

    .line 132
    iget-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->post:Lco/vine/android/api/VinePost;

    iget-wide v1, p0, Lco/vine/android/api/VinePrivateMessage;->postId:J

    iput-wide v1, v0, Lco/vine/android/api/VinePost;->postId:J

    .line 133
    iget-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->post:Lco/vine/android/api/VinePost;

    const/16 v1, 0x1a

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v1

    iput-wide v1, v0, Lco/vine/android/api/VinePost;->userId:J

    .line 134
    iget-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->post:Lco/vine/android/api/VinePost;

    const/16 v1, 0x1b

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VinePost;->username:Ljava/lang/String;

    .line 135
    iget-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->post:Lco/vine/android/api/VinePost;

    const/16 v1, 0x1c

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VinePost;->avatarUrl:Ljava/lang/String;

    .line 136
    iget-object v1, p0, Lco/vine/android/api/VinePrivateMessage;->post:Lco/vine/android/api/VinePost;

    const/16 v0, 0x1d

    invoke-interface {p1, v0}, Landroid/database/Cursor;->getBlob(I)[B

    move-result-object v0

    invoke-static {v0}, Lco/vine/android/util/Util;->fromByteArray([B)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    iput-object v0, v1, Lco/vine/android/api/VinePost;->entities:Ljava/util/ArrayList;

    .line 137
    iget-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->post:Lco/vine/android/api/VinePost;

    const/16 v1, 0x1e

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VinePost;->description:Ljava/lang/String;

    .line 138
    iget-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->post:Lco/vine/android/api/VinePost;

    const/16 v1, 0x1f

    invoke-interface {p1, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lco/vine/android/api/VinePost;->shareUrl:Ljava/lang/String;

    .line 140
    :cond_0
    return-void

    :cond_1
    move v0, v2

    .line 117
    goto/16 :goto_0

    :cond_2
    move v0, v2

    .line 118
    goto/16 :goto_1

    :cond_3
    move v0, v2

    .line 119
    goto/16 :goto_2

    :cond_4
    move v0, v2

    .line 120
    goto/16 :goto_3

    :cond_5
    move v1, v2

    .line 123
    goto/16 :goto_4
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 5
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 148
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 39
    iput v2, p0, Lco/vine/android/api/VinePrivateMessage;->maxLoops:I

    .line 149
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v3

    iput-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->messageRowId:J

    .line 150
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v3

    iput-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->conversationId:J

    .line 151
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v3

    iput-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    .line 152
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v3

    iput-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->userId:J

    .line 153
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v3

    iput-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->created:J

    .line 154
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->message:Ljava/lang/String;

    .line 155
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->videoUrl:Ljava/lang/String;

    .line 156
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->avatarUrl:Ljava/lang/String;

    .line 157
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->thumbnailUrl:Ljava/lang/String;

    .line 158
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VinePrivateMessage;->networkType:I

    .line 159
    iget-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->videoUrl:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    iput-boolean v0, p0, Lco/vine/android/api/VinePrivateMessage;->hasVideo:Z

    .line 160
    iget v0, p0, Lco/vine/android/api/VinePrivateMessage;->networkType:I

    if-ne v0, v1, :cond_1

    move v0, v1

    :goto_1
    iput-boolean v0, p0, Lco/vine/android/api/VinePrivateMessage;->isInNetwork:Z

    .line 161
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-ne v0, v1, :cond_2

    move v0, v1

    :goto_2
    iput-boolean v0, p0, Lco/vine/android/api/VinePrivateMessage;->isLast:Z

    .line 162
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-ne v0, v1, :cond_3

    move v0, v1

    :goto_3
    iput-boolean v0, p0, Lco/vine/android/api/VinePrivateMessage;->vanished:Z

    .line 163
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VinePrivateMessage;->maxLoops:I

    .line 164
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v3

    iput-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->vanishedDate:J

    .line 165
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-ne v0, v1, :cond_4

    :goto_4
    iput-boolean v1, p0, Lco/vine/android/api/VinePrivateMessage;->ephemeral:Z

    .line 166
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VinePrivateMessage;->localStartTime:J

    .line 167
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VinePrivateMessage;->postId:J

    .line 168
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VinePrivateMessage;->errorCode:I

    .line 169
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->errorReason:Ljava/lang/String;

    .line 170
    return-void

    :cond_0
    move v0, v2

    .line 159
    goto :goto_0

    :cond_1
    move v0, v2

    .line 160
    goto :goto_1

    :cond_2
    move v0, v2

    .line 161
    goto :goto_2

    :cond_3
    move v0, v2

    .line 162
    goto :goto_3

    :cond_4
    move v1, v2

    .line 165
    goto :goto_4
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 144
    const/4 v0, 0x0

    return v0
.end method

.method public equals(Ljava/lang/Object;)Z
    .locals 7
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 245
    if-ne p0, p1, :cond_1

    .line 282
    :cond_0
    :goto_0
    return v1

    .line 246
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

    .line 248
    check-cast v0, Lco/vine/android/api/VinePrivateMessage;

    .line 250
    .local v0, "that":Lco/vine/android/api/VinePrivateMessage;
    iget-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->conversationId:J

    iget-wide v5, v0, Lco/vine/android/api/VinePrivateMessage;->conversationId:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_4

    move v1, v2

    goto :goto_0

    .line 251
    :cond_4
    iget-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    iget-wide v5, v0, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_5

    move v1, v2

    goto :goto_0

    .line 252
    :cond_5
    iget-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->userId:J

    iget-wide v5, v0, Lco/vine/android/api/VinePrivateMessage;->userId:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_6

    move v1, v2

    goto :goto_0

    .line 253
    :cond_6
    iget-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->created:J

    iget-wide v5, v0, Lco/vine/android/api/VinePrivateMessage;->created:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_7

    move v1, v2

    goto :goto_0

    .line 254
    :cond_7
    iget-object v3, p0, Lco/vine/android/api/VinePrivateMessage;->message:Ljava/lang/String;

    if-eqz v3, :cond_9

    iget-object v3, p0, Lco/vine/android/api/VinePrivateMessage;->message:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VinePrivateMessage;->message:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_a

    :cond_8
    move v1, v2

    .line 255
    goto :goto_0

    .line 254
    :cond_9
    iget-object v3, v0, Lco/vine/android/api/VinePrivateMessage;->message:Ljava/lang/String;

    if-nez v3, :cond_8

    .line 256
    :cond_a
    iget-object v3, p0, Lco/vine/android/api/VinePrivateMessage;->videoUrl:Ljava/lang/String;

    if-eqz v3, :cond_c

    iget-object v3, p0, Lco/vine/android/api/VinePrivateMessage;->videoUrl:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VinePrivateMessage;->videoUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_d

    :cond_b
    move v1, v2

    .line 257
    goto :goto_0

    .line 256
    :cond_c
    iget-object v3, v0, Lco/vine/android/api/VinePrivateMessage;->videoUrl:Ljava/lang/String;

    if-nez v3, :cond_b

    .line 258
    :cond_d
    iget-object v3, p0, Lco/vine/android/api/VinePrivateMessage;->avatarUrl:Ljava/lang/String;

    if-eqz v3, :cond_f

    iget-object v3, p0, Lco/vine/android/api/VinePrivateMessage;->avatarUrl:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VinePrivateMessage;->avatarUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_10

    :cond_e
    move v1, v2

    .line 259
    goto :goto_0

    .line 258
    :cond_f
    iget-object v3, v0, Lco/vine/android/api/VinePrivateMessage;->avatarUrl:Ljava/lang/String;

    if-nez v3, :cond_e

    .line 260
    :cond_10
    iget-object v3, p0, Lco/vine/android/api/VinePrivateMessage;->thumbnailUrl:Ljava/lang/String;

    if-eqz v3, :cond_12

    iget-object v3, p0, Lco/vine/android/api/VinePrivateMessage;->thumbnailUrl:Ljava/lang/String;

    iget-object v4, v0, Lco/vine/android/api/VinePrivateMessage;->thumbnailUrl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_13

    :cond_11
    move v1, v2

    .line 261
    goto/16 :goto_0

    .line 260
    :cond_12
    iget-object v3, v0, Lco/vine/android/api/VinePrivateMessage;->thumbnailUrl:Ljava/lang/String;

    if-nez v3, :cond_11

    .line 263
    :cond_13
    iget v3, p0, Lco/vine/android/api/VinePrivateMessage;->networkType:I

    iget v4, v0, Lco/vine/android/api/VinePrivateMessage;->networkType:I

    if-eq v3, v4, :cond_14

    move v1, v2

    .line 264
    goto/16 :goto_0

    .line 267
    :cond_14
    iget-boolean v3, p0, Lco/vine/android/api/VinePrivateMessage;->ephemeral:Z

    iget-boolean v4, v0, Lco/vine/android/api/VinePrivateMessage;->ephemeral:Z

    if-eq v3, v4, :cond_15

    move v1, v2

    goto/16 :goto_0

    .line 269
    :cond_15
    iget-boolean v3, p0, Lco/vine/android/api/VinePrivateMessage;->isLast:Z

    iget-boolean v4, v0, Lco/vine/android/api/VinePrivateMessage;->isLast:Z

    if-eq v3, v4, :cond_16

    move v1, v2

    goto/16 :goto_0

    .line 270
    :cond_16
    iget-boolean v3, p0, Lco/vine/android/api/VinePrivateMessage;->vanished:Z

    iget-boolean v4, v0, Lco/vine/android/api/VinePrivateMessage;->vanished:Z

    if-eq v3, v4, :cond_17

    move v1, v2

    goto/16 :goto_0

    .line 272
    :cond_17
    iget v3, p0, Lco/vine/android/api/VinePrivateMessage;->maxLoops:I

    iget v4, v0, Lco/vine/android/api/VinePrivateMessage;->maxLoops:I

    if-eq v3, v4, :cond_18

    move v1, v2

    goto/16 :goto_0

    .line 274
    :cond_18
    iget-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->vanishedDate:J

    iget-wide v5, v0, Lco/vine/android/api/VinePrivateMessage;->vanishedDate:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_19

    move v1, v2

    goto/16 :goto_0

    .line 276
    :cond_19
    iget-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->localStartTime:J

    iget-wide v5, v0, Lco/vine/android/api/VinePrivateMessage;->localStartTime:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_1a

    move v1, v2

    goto/16 :goto_0

    .line 278
    :cond_1a
    iget-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->postId:J

    iget-wide v5, v0, Lco/vine/android/api/VinePrivateMessage;->postId:J

    cmp-long v3, v3, v5

    if-eqz v3, :cond_1b

    move v1, v2

    goto/16 :goto_0

    .line 280
    :cond_1b
    iget v3, p0, Lco/vine/android/api/VinePrivateMessage;->errorCode:I

    iget v4, v0, Lco/vine/android/api/VinePrivateMessage;->errorCode:I

    if-eq v3, v4, :cond_0

    move v1, v2

    goto/16 :goto_0
.end method

.method public hashCode()I
    .locals 9

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    const/16 v8, 0x20

    .line 287
    iget-wide v4, p0, Lco/vine/android/api/VinePrivateMessage;->conversationId:J

    iget-wide v6, p0, Lco/vine/android/api/VinePrivateMessage;->conversationId:J

    ushr-long/2addr v6, v8

    xor-long/2addr v4, v6

    long-to-int v0, v4

    .line 288
    .local v0, "result":I
    mul-int/lit8 v1, v0, 0x1f

    iget-wide v4, p0, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    iget-wide v6, p0, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    ushr-long/2addr v6, v8

    xor-long/2addr v4, v6

    long-to-int v4, v4

    add-int v0, v1, v4

    .line 289
    mul-int/lit8 v1, v0, 0x1f

    iget-wide v4, p0, Lco/vine/android/api/VinePrivateMessage;->userId:J

    iget-wide v6, p0, Lco/vine/android/api/VinePrivateMessage;->userId:J

    ushr-long/2addr v6, v8

    xor-long/2addr v4, v6

    long-to-int v4, v4

    add-int v0, v1, v4

    .line 290
    mul-int/lit8 v1, v0, 0x1f

    iget-wide v4, p0, Lco/vine/android/api/VinePrivateMessage;->created:J

    iget-wide v6, p0, Lco/vine/android/api/VinePrivateMessage;->created:J

    ushr-long/2addr v6, v8

    xor-long/2addr v4, v6

    long-to-int v4, v4

    add-int v0, v1, v4

    .line 291
    mul-int/lit8 v1, v0, 0x1f

    iget v4, p0, Lco/vine/android/api/VinePrivateMessage;->networkType:I

    add-int v0, v1, v4

    .line 292
    mul-int/lit8 v4, v0, 0x1f

    iget-object v1, p0, Lco/vine/android/api/VinePrivateMessage;->message:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lco/vine/android/api/VinePrivateMessage;->message:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_0
    add-int v0, v4, v1

    .line 293
    mul-int/lit8 v4, v0, 0x1f

    iget-object v1, p0, Lco/vine/android/api/VinePrivateMessage;->videoUrl:Ljava/lang/String;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lco/vine/android/api/VinePrivateMessage;->videoUrl:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_1
    add-int v0, v4, v1

    .line 294
    mul-int/lit8 v4, v0, 0x1f

    iget-object v1, p0, Lco/vine/android/api/VinePrivateMessage;->avatarUrl:Ljava/lang/String;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lco/vine/android/api/VinePrivateMessage;->avatarUrl:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_2
    add-int v0, v4, v1

    .line 295
    mul-int/lit8 v4, v0, 0x1f

    iget-object v1, p0, Lco/vine/android/api/VinePrivateMessage;->thumbnailUrl:Ljava/lang/String;

    if-eqz v1, :cond_3

    iget-object v1, p0, Lco/vine/android/api/VinePrivateMessage;->thumbnailUrl:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->hashCode()I

    move-result v1

    :goto_3
    add-int v0, v4, v1

    .line 296
    mul-int/lit8 v4, v0, 0x1f

    iget-boolean v1, p0, Lco/vine/android/api/VinePrivateMessage;->isLast:Z

    if-eqz v1, :cond_4

    move v1, v3

    :goto_4
    add-int v0, v4, v1

    .line 297
    mul-int/lit8 v1, v0, 0x1f

    iget-boolean v4, p0, Lco/vine/android/api/VinePrivateMessage;->vanished:Z

    if-eqz v4, :cond_5

    :goto_5
    add-int v0, v1, v3

    .line 298
    mul-int/lit8 v1, v0, 0x1f

    iget v2, p0, Lco/vine/android/api/VinePrivateMessage;->maxLoops:I

    add-int v0, v1, v2

    .line 299
    mul-int/lit8 v1, v0, 0x1f

    iget-wide v2, p0, Lco/vine/android/api/VinePrivateMessage;->vanishedDate:J

    iget-wide v4, p0, Lco/vine/android/api/VinePrivateMessage;->vanishedDate:J

    ushr-long/2addr v4, v8

    xor-long/2addr v2, v4

    long-to-int v2, v2

    add-int v0, v1, v2

    .line 300
    mul-int/lit8 v1, v0, 0x1f

    iget-wide v2, p0, Lco/vine/android/api/VinePrivateMessage;->localStartTime:J

    iget-wide v4, p0, Lco/vine/android/api/VinePrivateMessage;->localStartTime:J

    ushr-long/2addr v4, v8

    xor-long/2addr v2, v4

    long-to-int v2, v2

    add-int v0, v1, v2

    .line 301
    mul-int/lit8 v1, v0, 0x1f

    iget-wide v2, p0, Lco/vine/android/api/VinePrivateMessage;->postId:J

    iget-wide v4, p0, Lco/vine/android/api/VinePrivateMessage;->postId:J

    ushr-long/2addr v4, v8

    xor-long/2addr v2, v4

    long-to-int v2, v2

    add-int v0, v1, v2

    .line 302
    mul-int/lit8 v1, v0, 0x1f

    iget v2, p0, Lco/vine/android/api/VinePrivateMessage;->errorCode:I

    iget v3, p0, Lco/vine/android/api/VinePrivateMessage;->errorCode:I

    ushr-int/lit8 v3, v3, 0x20

    xor-int/2addr v2, v3

    add-int v0, v1, v2

    .line 304
    return v0

    :cond_0
    move v1, v2

    .line 292
    goto :goto_0

    :cond_1
    move v1, v2

    .line 293
    goto :goto_1

    :cond_2
    move v1, v2

    .line 294
    goto :goto_2

    :cond_3
    move v1, v2

    .line 295
    goto :goto_3

    :cond_4
    move v1, v2

    .line 296
    goto :goto_4

    :cond_5
    move v3, v2

    .line 297
    goto :goto_5
.end method

.method public readExternal(Ljava/io/ObjectInput;)V
    .locals 5
    .param p1, "objectInput"    # Ljava/io/ObjectInput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/ClassNotFoundException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x1

    .line 197
    invoke-interface {p1}, Ljava/io/ObjectInput;->readLong()J

    move-result-wide v3

    iput-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->messageRowId:J

    .line 198
    invoke-interface {p1}, Ljava/io/ObjectInput;->readLong()J

    move-result-wide v3

    iput-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->conversationId:J

    .line 199
    invoke-interface {p1}, Ljava/io/ObjectInput;->readLong()J

    move-result-wide v3

    iput-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    .line 200
    invoke-interface {p1}, Ljava/io/ObjectInput;->readLong()J

    move-result-wide v3

    iput-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->userId:J

    .line 201
    invoke-interface {p1}, Ljava/io/ObjectInput;->readLong()J

    move-result-wide v3

    iput-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->created:J

    .line 202
    invoke-interface {p1}, Ljava/io/ObjectInput;->readObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->message:Ljava/lang/String;

    .line 203
    invoke-interface {p1}, Ljava/io/ObjectInput;->readObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->videoUrl:Ljava/lang/String;

    .line 204
    invoke-interface {p1}, Ljava/io/ObjectInput;->readObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->avatarUrl:Ljava/lang/String;

    .line 205
    invoke-interface {p1}, Ljava/io/ObjectInput;->readObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->thumbnailUrl:Ljava/lang/String;

    .line 206
    invoke-interface {p1}, Ljava/io/ObjectInput;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VinePrivateMessage;->networkType:I

    .line 207
    iget-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->videoUrl:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    move v0, v1

    :goto_0
    iput-boolean v0, p0, Lco/vine/android/api/VinePrivateMessage;->hasVideo:Z

    .line 208
    iget v0, p0, Lco/vine/android/api/VinePrivateMessage;->networkType:I

    if-ne v0, v1, :cond_1

    move v0, v1

    :goto_1
    iput-boolean v0, p0, Lco/vine/android/api/VinePrivateMessage;->isInNetwork:Z

    .line 209
    invoke-interface {p1}, Ljava/io/ObjectInput;->readInt()I

    move-result v0

    if-ne v0, v1, :cond_2

    move v0, v1

    :goto_2
    iput-boolean v0, p0, Lco/vine/android/api/VinePrivateMessage;->isLast:Z

    .line 210
    invoke-interface {p1}, Ljava/io/ObjectInput;->readInt()I

    move-result v0

    if-ne v0, v1, :cond_3

    move v0, v1

    :goto_3
    iput-boolean v0, p0, Lco/vine/android/api/VinePrivateMessage;->vanished:Z

    .line 211
    invoke-interface {p1}, Ljava/io/ObjectInput;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VinePrivateMessage;->maxLoops:I

    .line 212
    invoke-interface {p1}, Ljava/io/ObjectInput;->readLong()J

    move-result-wide v3

    iput-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->vanishedDate:J

    .line 213
    invoke-interface {p1}, Ljava/io/ObjectInput;->readInt()I

    move-result v0

    if-ne v0, v1, :cond_4

    :goto_4
    iput-boolean v1, p0, Lco/vine/android/api/VinePrivateMessage;->ephemeral:Z

    .line 214
    invoke-interface {p1}, Ljava/io/ObjectInput;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VinePrivateMessage;->localStartTime:J

    .line 215
    invoke-interface {p1}, Ljava/io/ObjectInput;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VinePrivateMessage;->postId:J

    .line 216
    invoke-interface {p1}, Ljava/io/ObjectInput;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VinePrivateMessage;->errorCode:I

    .line 217
    invoke-interface {p1}, Ljava/io/ObjectInput;->readLine()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->errorReason:Ljava/lang/String;

    .line 218
    return-void

    :cond_0
    move v0, v2

    .line 207
    goto :goto_0

    :cond_1
    move v0, v2

    .line 208
    goto :goto_1

    :cond_2
    move v0, v2

    .line 209
    goto :goto_2

    :cond_3
    move v0, v2

    .line 210
    goto :goto_3

    :cond_4
    move v1, v2

    .line 213
    goto :goto_4
.end method

.method public writeExternal(Ljava/io/ObjectOutput;)V
    .locals 5
    .param p1, "objectOutput"    # Ljava/io/ObjectOutput;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 222
    iget-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->messageRowId:J

    invoke-interface {p1, v3, v4}, Ljava/io/ObjectOutput;->writeLong(J)V

    .line 223
    iget-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->conversationId:J

    invoke-interface {p1, v3, v4}, Ljava/io/ObjectOutput;->writeLong(J)V

    .line 224
    iget-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    invoke-interface {p1, v3, v4}, Ljava/io/ObjectOutput;->writeLong(J)V

    .line 225
    iget-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->userId:J

    invoke-interface {p1, v3, v4}, Ljava/io/ObjectOutput;->writeLong(J)V

    .line 226
    iget-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->created:J

    invoke-interface {p1, v3, v4}, Ljava/io/ObjectOutput;->writeLong(J)V

    .line 227
    iget-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->message:Ljava/lang/String;

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeObject(Ljava/lang/Object;)V

    .line 228
    iget-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->videoUrl:Ljava/lang/String;

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeObject(Ljava/lang/Object;)V

    .line 229
    iget-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->avatarUrl:Ljava/lang/String;

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeObject(Ljava/lang/Object;)V

    .line 230
    iget-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->thumbnailUrl:Ljava/lang/String;

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeObject(Ljava/lang/Object;)V

    .line 231
    iget v0, p0, Lco/vine/android/api/VinePrivateMessage;->networkType:I

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeInt(I)V

    .line 232
    iget-boolean v0, p0, Lco/vine/android/api/VinePrivateMessage;->isLast:Z

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeInt(I)V

    .line 233
    iget-boolean v0, p0, Lco/vine/android/api/VinePrivateMessage;->vanished:Z

    if-eqz v0, :cond_1

    move v0, v1

    :goto_1
    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeInt(I)V

    .line 234
    iget v0, p0, Lco/vine/android/api/VinePrivateMessage;->maxLoops:I

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeInt(I)V

    .line 235
    iget-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->vanishedDate:J

    invoke-interface {p1, v3, v4}, Ljava/io/ObjectOutput;->writeLong(J)V

    .line 236
    iget-boolean v0, p0, Lco/vine/android/api/VinePrivateMessage;->ephemeral:Z

    if-eqz v0, :cond_2

    :goto_2
    invoke-interface {p1, v1}, Ljava/io/ObjectOutput;->writeInt(I)V

    .line 237
    iget-wide v0, p0, Lco/vine/android/api/VinePrivateMessage;->localStartTime:J

    invoke-interface {p1, v0, v1}, Ljava/io/ObjectOutput;->writeLong(J)V

    .line 238
    iget-wide v0, p0, Lco/vine/android/api/VinePrivateMessage;->postId:J

    invoke-interface {p1, v0, v1}, Ljava/io/ObjectOutput;->writeLong(J)V

    .line 239
    iget v0, p0, Lco/vine/android/api/VinePrivateMessage;->errorCode:I

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeInt(I)V

    .line 240
    iget-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->errorReason:Ljava/lang/String;

    invoke-interface {p1, v0}, Ljava/io/ObjectOutput;->writeChars(Ljava/lang/String;)V

    .line 241
    return-void

    :cond_0
    move v0, v2

    .line 232
    goto :goto_0

    :cond_1
    move v0, v2

    .line 233
    goto :goto_1

    :cond_2
    move v1, v2

    .line 236
    goto :goto_2
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 5
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 174
    iget-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->messageRowId:J

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeLong(J)V

    .line 175
    iget-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->conversationId:J

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeLong(J)V

    .line 176
    iget-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->messageId:J

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeLong(J)V

    .line 177
    iget-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->userId:J

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeLong(J)V

    .line 178
    iget-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->created:J

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeLong(J)V

    .line 179
    iget-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->message:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 180
    iget-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->videoUrl:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 181
    iget-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->avatarUrl:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 182
    iget-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->thumbnailUrl:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 183
    iget v0, p0, Lco/vine/android/api/VinePrivateMessage;->networkType:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 184
    iget-boolean v0, p0, Lco/vine/android/api/VinePrivateMessage;->isLast:Z

    if-eqz v0, :cond_0

    move v0, v1

    :goto_0
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 185
    iget-boolean v0, p0, Lco/vine/android/api/VinePrivateMessage;->vanished:Z

    if-eqz v0, :cond_1

    move v0, v1

    :goto_1
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 186
    iget v0, p0, Lco/vine/android/api/VinePrivateMessage;->maxLoops:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 187
    iget-wide v3, p0, Lco/vine/android/api/VinePrivateMessage;->vanishedDate:J

    invoke-virtual {p1, v3, v4}, Landroid/os/Parcel;->writeLong(J)V

    .line 188
    iget-boolean v0, p0, Lco/vine/android/api/VinePrivateMessage;->ephemeral:Z

    if-eqz v0, :cond_2

    :goto_2
    invoke-virtual {p1, v1}, Landroid/os/Parcel;->writeInt(I)V

    .line 189
    iget-wide v0, p0, Lco/vine/android/api/VinePrivateMessage;->localStartTime:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 190
    iget-wide v0, p0, Lco/vine/android/api/VinePrivateMessage;->postId:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 191
    iget v0, p0, Lco/vine/android/api/VinePrivateMessage;->errorCode:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 192
    iget-object v0, p0, Lco/vine/android/api/VinePrivateMessage;->errorReason:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 193
    return-void

    :cond_0
    move v0, v2

    .line 184
    goto :goto_0

    :cond_1
    move v0, v2

    .line 185
    goto :goto_1

    :cond_2
    move v1, v2

    .line 188
    goto :goto_2
.end method
