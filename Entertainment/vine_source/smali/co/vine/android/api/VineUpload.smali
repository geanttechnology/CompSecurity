.class public Lco/vine/android/api/VineUpload;
.super Ljava/lang/Object;
.source "VineUpload.java"

# interfaces
.implements Landroid/os/Parcelable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/api/VineUpload$PostInfo;
    }
.end annotation


# static fields
.field public static final CREATOR:Landroid/os/Parcelable$Creator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/os/Parcelable$Creator",
            "<",
            "Lco/vine/android/api/VineUpload;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field public captchaUrl:Ljava/lang/String;

.field public conversationRowId:J

.field public hash:Ljava/lang/String;

.field public id:J

.field public isPrivate:Z

.field public mergedMessageId:J

.field public path:Ljava/lang/String;

.field public postInfo:Ljava/lang/String;

.field public reference:Ljava/lang/String;

.field public status:I

.field public thumbnailPath:Ljava/lang/String;

.field public thumbnailUrl:Ljava/lang/String;

.field public uploadTime:J

.field public videoUrl:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 159
    new-instance v0, Lco/vine/android/api/VineUpload$1;

    invoke-direct {v0}, Lco/vine/android/api/VineUpload$1;-><init>()V

    sput-object v0, Lco/vine/android/api/VineUpload;->CREATOR:Landroid/os/Parcelable$Creator;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 71
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 72
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/api/VineUpload;->status:I

    .line 73
    return-void
.end method

.method public constructor <init>(Landroid/os/Parcel;)V
    .locals 2
    .param p1, "in"    # Landroid/os/Parcel;

    .prologue
    .line 75
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 76
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    iput v0, p0, Lco/vine/android/api/VineUpload;->status:I

    .line 77
    invoke-virtual {p1}, Landroid/os/Parcel;->readInt()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lco/vine/android/api/VineUpload;->isPrivate:Z

    .line 78
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VineUpload;->id:J

    .line 79
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VineUpload;->uploadTime:J

    .line 80
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VineUpload;->conversationRowId:J

    .line 81
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    .line 82
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineUpload;->hash:Ljava/lang/String;

    .line 83
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineUpload;->postInfo:Ljava/lang/String;

    .line 84
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineUpload;->thumbnailPath:Ljava/lang/String;

    .line 85
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineUpload;->thumbnailUrl:Ljava/lang/String;

    .line 86
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineUpload;->reference:Ljava/lang/String;

    .line 87
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineUpload;->captchaUrl:Ljava/lang/String;

    .line 88
    invoke-virtual {p1}, Landroid/os/Parcel;->readLong()J

    move-result-wide v0

    iput-wide v0, p0, Lco/vine/android/api/VineUpload;->mergedMessageId:J

    .line 89
    invoke-virtual {p1}, Landroid/os/Parcel;->readString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/api/VineUpload;->videoUrl:Ljava/lang/String;

    .line 90
    return-void

    .line 77
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZJJ)V
    .locals 4
    .param p1, "path"    # Ljava/lang/String;
    .param p2, "hash"    # Ljava/lang/String;
    .param p3, "postInfo"    # Ljava/lang/String;
    .param p4, "videoUrl"    # Ljava/lang/String;
    .param p5, "thumbnailPath"    # Ljava/lang/String;
    .param p6, "thumbnailUrl"    # Ljava/lang/String;
    .param p7, "uploadTime"    # Ljava/lang/String;
    .param p8, "reference"    # Ljava/lang/String;
    .param p9, "status"    # I
    .param p10, "captchaUrl"    # Ljava/lang/String;
    .param p11, "isPrivate"    # Z
    .param p12, "conversationRowId"    # J
    .param p14, "mergedMessageId"    # J

    .prologue
    .line 48
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    iput-object p1, p0, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    .line 50
    iput-object p2, p0, Lco/vine/android/api/VineUpload;->hash:Ljava/lang/String;

    .line 51
    iput-object p3, p0, Lco/vine/android/api/VineUpload;->postInfo:Ljava/lang/String;

    .line 52
    iput-object p4, p0, Lco/vine/android/api/VineUpload;->videoUrl:Ljava/lang/String;

    .line 53
    iput-object p5, p0, Lco/vine/android/api/VineUpload;->thumbnailPath:Ljava/lang/String;

    .line 54
    iput-object p6, p0, Lco/vine/android/api/VineUpload;->thumbnailUrl:Ljava/lang/String;

    .line 55
    iput-object p8, p0, Lco/vine/android/api/VineUpload;->reference:Ljava/lang/String;

    .line 56
    iput p9, p0, Lco/vine/android/api/VineUpload;->status:I

    .line 57
    iput-boolean p11, p0, Lco/vine/android/api/VineUpload;->isPrivate:Z

    .line 58
    move-wide/from16 v0, p12

    iput-wide v0, p0, Lco/vine/android/api/VineUpload;->conversationRowId:J

    .line 61
    invoke-static {p7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 62
    invoke-static {p7}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    iput-wide v2, p0, Lco/vine/android/api/VineUpload;->uploadTime:J

    .line 67
    :goto_0
    iput-object p10, p0, Lco/vine/android/api/VineUpload;->captchaUrl:Ljava/lang/String;

    .line 68
    move-wide/from16 v0, p14

    iput-wide v0, p0, Lco/vine/android/api/VineUpload;->mergedMessageId:J

    .line 69
    return-void

    .line 64
    :cond_0
    const-wide/16 v2, 0x0

    iput-wide v2, p0, Lco/vine/android/api/VineUpload;->uploadTime:J

    goto :goto_0
.end method

.method public static declared-synchronized fromCursor(Ljava/lang/String;Landroid/database/Cursor;)Lco/vine/android/api/VineUpload;
    .locals 18
    .param p0, "path"    # Ljava/lang/String;
    .param p1, "c"    # Landroid/database/Cursor;

    .prologue
    .line 98
    const-class v17, Lco/vine/android/api/VineUpload;

    monitor-enter v17

    const/4 v1, 0x2

    :try_start_0
    move-object/from16 v0, p1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 99
    .local v3, "hash":Ljava/lang/String;
    const/4 v1, 0x4

    move-object/from16 v0, p1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 100
    .local v4, "postInfo":Ljava/lang/String;
    const/4 v1, 0x5

    move-object/from16 v0, p1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 101
    .local v5, "videoUrl":Ljava/lang/String;
    const/4 v1, 0x6

    move-object/from16 v0, p1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 102
    .local v6, "thumbnailPath":Ljava/lang/String;
    const/4 v1, 0x7

    move-object/from16 v0, p1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v7

    .line 103
    .local v7, "thumbnailUrl":Ljava/lang/String;
    const/16 v1, 0x8

    move-object/from16 v0, p1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v8

    .line 104
    .local v8, "uploadTime":Ljava/lang/String;
    const/16 v1, 0xb

    move-object/from16 v0, p1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v9

    .line 105
    .local v9, "reference":Ljava/lang/String;
    const/4 v1, 0x3

    move-object/from16 v0, p1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v10

    .line 106
    .local v10, "status":I
    const/16 v1, 0x9

    move-object/from16 v0, p1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getInt(I)I

    move-result v1

    if-lez v1, :cond_0

    const/4 v12, 0x1

    .line 107
    .local v12, "isPrivate":Z
    :goto_0
    const/16 v1, 0xa

    move-object/from16 v0, p1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v13

    .line 108
    .local v13, "conversationRowId":J
    const/16 v1, 0xd

    move-object/from16 v0, p1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v11

    .line 109
    .local v11, "captchaUrl":Ljava/lang/String;
    const/16 v1, 0xf

    move-object/from16 v0, p1

    invoke-interface {v0, v1}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v15

    .line 111
    .local v15, "mergedMessageId":J
    new-instance v1, Lco/vine/android/api/VineUpload;

    move-object/from16 v2, p0

    invoke-direct/range {v1 .. v16}, Lco/vine/android/api/VineUpload;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;ZJJ)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v17

    return-object v1

    .line 106
    .end local v11    # "captchaUrl":Ljava/lang/String;
    .end local v12    # "isPrivate":Z
    .end local v13    # "conversationRowId":J
    .end local v15    # "mergedMessageId":J
    :cond_0
    const/4 v12, 0x0

    goto :goto_0

    .line 98
    .end local v3    # "hash":Ljava/lang/String;
    .end local v4    # "postInfo":Ljava/lang/String;
    .end local v5    # "videoUrl":Ljava/lang/String;
    .end local v6    # "thumbnailPath":Ljava/lang/String;
    .end local v7    # "thumbnailUrl":Ljava/lang/String;
    .end local v8    # "uploadTime":Ljava/lang/String;
    .end local v9    # "reference":Ljava/lang/String;
    .end local v10    # "status":I
    :catchall_0
    move-exception v1

    monitor-exit v17

    throw v1
.end method


# virtual methods
.method public describeContents()I
    .locals 1

    .prologue
    .line 94
    const/4 v0, 0x0

    return v0
.end method

.method public getPostInfo()Lco/vine/android/api/VineUpload$PostInfo;
    .locals 2

    .prologue
    .line 120
    const-string v0, "Post info: {}."

    iget-object v1, p0, Lco/vine/android/api/VineUpload;->postInfo:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 121
    iget-object v0, p0, Lco/vine/android/api/VineUpload;->postInfo:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 122
    const/4 v0, 0x0

    .line 124
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lco/vine/android/api/VineUpload;->postInfo:Ljava/lang/String;

    invoke-static {v0}, Lco/vine/android/api/VineUpload$PostInfo;->fromJsonString(Ljava/lang/String;)Lco/vine/android/api/VineUpload$PostInfo;

    move-result-object v0

    goto :goto_0
.end method

.method public getUris()[Ljava/lang/String;
    .locals 3

    .prologue
    .line 129
    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    iget-object v2, p0, Lco/vine/android/api/VineUpload;->videoUrl:Ljava/lang/String;

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget-object v2, p0, Lco/vine/android/api/VineUpload;->thumbnailUrl:Ljava/lang/String;

    aput-object v2, v0, v1

    return-object v0
.end method

.method public isExpired()Z
    .locals 4

    .prologue
    .line 116
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iget-wide v2, p0, Lco/vine/android/api/VineUpload;->uploadTime:J

    sub-long/2addr v0, v2

    const-wide/32 v2, 0x5265c00

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setCaptchaUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "captchaUrl"    # Ljava/lang/String;

    .prologue
    .line 138
    iput-object p1, p0, Lco/vine/android/api/VineUpload;->captchaUrl:Ljava/lang/String;

    .line 139
    return-void
.end method

.method public setUris([Ljava/lang/String;)V
    .locals 1
    .param p1, "uris"    # [Ljava/lang/String;

    .prologue
    .line 133
    const/4 v0, 0x0

    aget-object v0, p1, v0

    iput-object v0, p0, Lco/vine/android/api/VineUpload;->videoUrl:Ljava/lang/String;

    .line 134
    const/4 v0, 0x1

    aget-object v0, p1, v0

    iput-object v0, p0, Lco/vine/android/api/VineUpload;->thumbnailUrl:Ljava/lang/String;

    .line 135
    return-void
.end method

.method public writeToParcel(Landroid/os/Parcel;I)V
    .locals 2
    .param p1, "out"    # Landroid/os/Parcel;
    .param p2, "flags"    # I

    .prologue
    .line 143
    iget v0, p0, Lco/vine/android/api/VineUpload;->status:I

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 144
    iget-boolean v0, p0, Lco/vine/android/api/VineUpload;->isPrivate:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeInt(I)V

    .line 145
    iget-wide v0, p0, Lco/vine/android/api/VineUpload;->id:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 146
    iget-wide v0, p0, Lco/vine/android/api/VineUpload;->uploadTime:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 147
    iget-wide v0, p0, Lco/vine/android/api/VineUpload;->conversationRowId:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 148
    iget-object v0, p0, Lco/vine/android/api/VineUpload;->path:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 149
    iget-object v0, p0, Lco/vine/android/api/VineUpload;->hash:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 150
    iget-object v0, p0, Lco/vine/android/api/VineUpload;->postInfo:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 151
    iget-object v0, p0, Lco/vine/android/api/VineUpload;->thumbnailPath:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 152
    iget-object v0, p0, Lco/vine/android/api/VineUpload;->thumbnailUrl:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 153
    iget-object v0, p0, Lco/vine/android/api/VineUpload;->reference:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 154
    iget-object v0, p0, Lco/vine/android/api/VineUpload;->captchaUrl:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 155
    iget-wide v0, p0, Lco/vine/android/api/VineUpload;->mergedMessageId:J

    invoke-virtual {p1, v0, v1}, Landroid/os/Parcel;->writeLong(J)V

    .line 156
    iget-object v0, p0, Lco/vine/android/api/VineUpload;->videoUrl:Ljava/lang/String;

    invoke-virtual {p1, v0}, Landroid/os/Parcel;->writeString(Ljava/lang/String;)V

    .line 157
    return-void

    .line 144
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
