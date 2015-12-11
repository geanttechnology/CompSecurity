.class public Lco/vine/android/util/MediaUtility;
.super Ljava/lang/Object;
.source "MediaUtility.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/util/MediaUtility$FileInfo;
    }
.end annotation


# static fields
.field public static final MEDIA:I = 0x2

.field public static final S3:I = 0x1


# instance fields
.field private final mAmazonBucket:Ljava/lang/String;

.field private final mContext:Landroid/content/Context;

.field private final mMediaUrl:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    iput-object p1, p0, Lco/vine/android/util/MediaUtility;->mContext:Landroid/content/Context;

    .line 37
    invoke-static {p1}, Lco/vine/android/client/VineAPI;->getInstance(Landroid/content/Context;)Lco/vine/android/client/VineAPI;

    move-result-object v0

    invoke-virtual {v0}, Lco/vine/android/client/VineAPI;->getMediaUrl()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/util/MediaUtility;->mMediaUrl:Ljava/lang/String;

    .line 38
    invoke-static {p1}, Lco/vine/android/client/Amazon;->getBucket(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/util/MediaUtility;->mAmazonBucket:Ljava/lang/String;

    .line 39
    return-void
.end method

.method public static getUploadType(Landroid/content/Context;)I
    .locals 5
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x1

    .line 42
    invoke-static {p0, v1}, Lco/vine/android/client/VineAccountHelper;->isLoggedIn(Landroid/content/Context;Z)Z

    move-result v2

    if-nez v2, :cond_1

    .line 50
    :cond_0
    :goto_0
    return v1

    .line 45
    :cond_1
    invoke-static {p0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v2

    const-string v3, "server_upload_type"

    const-string v4, "media"

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 47
    .local v0, "uploadType":Ljava/lang/String;
    const-string v2, "s3"

    invoke-virtual {v2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 50
    const/4 v1, 0x2

    goto :goto_0
.end method


# virtual methods
.method public getPhotoUri(Landroid/net/Uri;Ljava/lang/String;Landroid/content/Context;)Ljava/lang/String;
    .locals 8
    .param p1, "avatarFileUri"    # Landroid/net/Uri;
    .param p2, "pictureBucket"    # Ljava/lang/String;
    .param p3, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 172
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "avatars/"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, ".jpg"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 174
    .local v2, "filename":Ljava/lang/String;
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 175
    invoke-static {p3, p1}, Lco/vine/android/util/image/ImageUtils;->getRealPathFromImageUri(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v7

    .line 177
    .local v7, "realFileUrl":Ljava/lang/String;
    new-instance v3, Ljava/io/File;

    invoke-direct {v3, v7}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    const-string v5, "avatars"

    move-object v0, p0

    move-object v4, p2

    invoke-virtual/range {v0 .. v5}, Lco/vine/android/util/MediaUtility;->upload(Lco/vine/android/util/VineProgressListener;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)Lco/vine/android/util/MediaUtility$FileInfo;

    move-result-object v6

    .line 179
    .local v6, "info":Lco/vine/android/util/MediaUtility$FileInfo;
    if-eqz v6, :cond_0

    .line 180
    iget-object v1, v6, Lco/vine/android/util/MediaUtility$FileInfo;->uploadKey:Ljava/lang/String;

    .line 185
    .end local v6    # "info":Lco/vine/android/util/MediaUtility$FileInfo;
    .end local v7    # "realFileUrl":Ljava/lang/String;
    :cond_0
    return-object v1
.end method

.method public getThumbnailUri(Lco/vine/android/util/VineProgressListener;Ljava/lang/String;Ljava/io/File;Landroid/content/Context;)Ljava/lang/String;
    .locals 7
    .param p1, "listener"    # Lco/vine/android/util/VineProgressListener;
    .param p2, "filename"    # Ljava/lang/String;
    .param p3, "thumbnail"    # Ljava/io/File;
    .param p4, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 147
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "thumbs/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".jpg"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p2

    .line 148
    iget-object v4, p0, Lco/vine/android/util/MediaUtility;->mAmazonBucket:Ljava/lang/String;

    const-string v5, "thumbs"

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    invoke-virtual/range {v0 .. v5}, Lco/vine/android/util/MediaUtility;->upload(Lco/vine/android/util/VineProgressListener;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)Lco/vine/android/util/MediaUtility$FileInfo;

    move-result-object v6

    .line 149
    .local v6, "info":Lco/vine/android/util/MediaUtility$FileInfo;
    if-eqz v6, :cond_0

    .line 150
    iget-object v0, v6, Lco/vine/android/util/MediaUtility$FileInfo;->uploadKey:Ljava/lang/String;

    .line 152
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getVideoUri(Lco/vine/android/util/VineProgressListener;Ljava/io/File;Landroid/content/Context;Ljava/lang/String;Z)Ljava/lang/String;
    .locals 8
    .param p1, "listener"    # Lco/vine/android/util/VineProgressListener;
    .param p2, "file"    # Ljava/io/File;
    .param p3, "context"    # Landroid/content/Context;
    .param p4, "filename"    # Ljava/lang/String;
    .param p5, "isPrivate"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 159
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "videos/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p4

    .line 160
    iget-object v4, p0, Lco/vine/android/util/MediaUtility;->mAmazonBucket:Ljava/lang/String;

    const-string v5, "videos"

    move-object v0, p0

    move-object v1, p1

    move-object v2, p4

    move-object v3, p2

    move v6, p5

    invoke-virtual/range {v0 .. v6}, Lco/vine/android/util/MediaUtility;->upload(Lco/vine/android/util/VineProgressListener;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Z)Lco/vine/android/util/MediaUtility$FileInfo;

    move-result-object v7

    .line 161
    .local v7, "info":Lco/vine/android/util/MediaUtility$FileInfo;
    if-eqz v7, :cond_0

    .line 162
    iget-object v0, v7, Lco/vine/android/util/MediaUtility$FileInfo;->uploadKey:Ljava/lang/String;

    .line 164
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public upload(Lco/vine/android/util/VineProgressListener;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;Ljava/lang/String;)Lco/vine/android/util/MediaUtility$FileInfo;
    .locals 7
    .param p1, "listener"    # Lco/vine/android/util/VineProgressListener;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "fileToUpload"    # Ljava/io/File;
    .param p4, "bucket"    # Ljava/lang/String;
    .param p5, "type"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 56
    const/4 v6, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-virtual/range {v0 .. v6}, Lco/vine/android/util/MediaUtility;->upload(Lco/vine/android/util/VineProgressListener;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Z)Lco/vine/android/util/MediaUtility$FileInfo;

    move-result-object v0

    return-object v0
.end method

.method public upload(Lco/vine/android/util/VineProgressListener;Ljava/lang/String;Ljava/io/File;Ljava/lang/String;Ljava/lang/String;Z)Lco/vine/android/util/MediaUtility$FileInfo;
    .locals 10
    .param p1, "listener"    # Lco/vine/android/util/VineProgressListener;
    .param p2, "key"    # Ljava/lang/String;
    .param p3, "fileToUpload"    # Ljava/io/File;
    .param p4, "bucket"    # Ljava/lang/String;
    .param p5, "type"    # Ljava/lang/String;
    .param p6, "isPrivate"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 62
    const-string v5, "Upload started for {}."

    invoke-static {v5, p3}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 63
    iget-object v5, p0, Lco/vine/android/util/MediaUtility;->mContext:Landroid/content/Context;

    invoke-static {v5}, Lco/vine/android/util/MediaUtility;->getUploadType(Landroid/content/Context;)I

    move-result v5

    packed-switch v5, :pswitch_data_0

    .line 142
    :cond_0
    :goto_0
    const/4 v5, 0x0

    :goto_1
    return-object v5

    .line 95
    :pswitch_0
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Uploading key: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 96
    invoke-virtual {p3}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lco/vine/android/util/UploadManager;->getVersionFromPath(Ljava/lang/String;)Lco/vine/android/recorder/RecordSessionVersion;

    move-result-object v4

    .line 97
    .local v4, "version":Lco/vine/android/recorder/RecordSessionVersion;
    iget-object v5, v4, Lco/vine/android/recorder/RecordSessionVersion;->videoOutputExtension:Ljava/lang/String;

    invoke-virtual {p2, v5}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 98
    iget-object v5, p0, Lco/vine/android/util/MediaUtility;->mMediaUrl:Ljava/lang/String;

    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    const-string v8, "upload"

    aput-object v8, v6, v7

    const/4 v7, 0x1

    const-string v8, "videos"

    aput-object v8, v6, v7

    const/4 v7, 0x2

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p3}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    iget-object v9, v4, Lco/vine/android/recorder/RecordSessionVersion;->videoOutputExtension:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 102
    .local v3, "url":Ljava/lang/StringBuilder;
    if-eqz p6, :cond_1

    .line 103
    const-string v5, "private"

    const-string v6, "1"

    invoke-static {v3, v5, v6}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V

    .line 105
    :cond_1
    new-instance v0, Lco/vine/android/util/MeasureOutputStream;

    iget-object v5, v4, Lco/vine/android/recorder/RecordSessionVersion;->mimeType:Ljava/lang/String;

    invoke-direct {v0, p3, v5, p1}, Lco/vine/android/util/MeasureOutputStream;-><init>(Ljava/io/File;Ljava/lang/String;Lco/vine/android/util/VineProgressListener;)V

    .line 106
    .local v0, "entity":Lco/vine/android/util/MeasureOutputStream;
    const/16 v5, 0x10

    invoke-static {v5}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v2

    .line 108
    .local v2, "reader":Lco/vine/android/api/VineParserReader;
    iget-object v5, p0, Lco/vine/android/util/MediaUtility;->mContext:Landroid/content/Context;

    invoke-static {v5}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v5

    iget-object v6, p0, Lco/vine/android/util/MediaUtility;->mContext:Landroid/content/Context;

    invoke-static {v6}, Lco/vine/android/client/VineAPI;->getInstance(Landroid/content/Context;)Lco/vine/android/client/VineAPI;

    move-result-object v6

    invoke-static {v5, v3, v2, v0, v6}, Lco/vine/android/network/HttpOperation;->createMediaPutRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/network/HttpOperationReader;Lorg/apache/http/HttpEntity;Lco/vine/android/client/VineAPI;)Lco/vine/android/network/HttpOperation;

    move-result-object v5

    invoke-virtual {v5}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v1

    .line 111
    .local v1, "op":Lco/vine/android/network/HttpOperation;
    invoke-virtual {v1}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 112
    const-string v5, "Upload {} successful."

    iget-object v6, v1, Lco/vine/android/network/HttpOperation;->uploadKey:Ljava/lang/String;

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 113
    new-instance v5, Lco/vine/android/util/MediaUtility$FileInfo;

    invoke-virtual {p3}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v6

    iget-object v7, v1, Lco/vine/android/network/HttpOperation;->uploadKey:Ljava/lang/String;

    invoke-direct {v5, v6, p3, v7}, Lco/vine/android/util/MediaUtility$FileInfo;-><init>(Ljava/lang/String;Ljava/io/File;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 115
    :cond_2
    const-string v5, "{} {} {}"

    iget v6, v1, Lco/vine/android/network/HttpOperation;->statusCode:I

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    iget-object v7, v1, Lco/vine/android/network/HttpOperation;->statusPhrase:Ljava/lang/String;

    invoke-static {v5, v3, v6, v7}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 117
    .end local v0    # "entity":Lco/vine/android/util/MeasureOutputStream;
    .end local v1    # "op":Lco/vine/android/network/HttpOperation;
    .end local v2    # "reader":Lco/vine/android/api/VineParserReader;
    .end local v3    # "url":Ljava/lang/StringBuilder;
    :cond_3
    const-string v5, "jpg"

    invoke-virtual {p2, v5}, Ljava/lang/String;->endsWith(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 118
    const-string v5, "Upload image through media."

    invoke-static {v5}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 119
    iget-object v5, p0, Lco/vine/android/util/MediaUtility;->mMediaUrl:Ljava/lang/String;

    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    const-string v8, "upload"

    aput-object v8, v6, v7

    const/4 v7, 0x1

    aput-object p5, v6, v7

    const/4 v7, 0x2

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p3}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, ".jpg"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Lco/vine/android/client/VineAPI;->buildUponUrl(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 123
    .restart local v3    # "url":Ljava/lang/StringBuilder;
    if-eqz p6, :cond_4

    .line 124
    const-string v5, "private"

    const-string v6, "1"

    invoke-static {v3, v5, v6}, Lco/vine/android/client/VineAPI;->addParam(Ljava/lang/StringBuilder;Ljava/lang/String;Ljava/lang/String;)V

    .line 126
    :cond_4
    new-instance v0, Lco/vine/android/util/MeasureOutputStream;

    const-string v5, "image/jpeg"

    invoke-direct {v0, p3, v5, p1}, Lco/vine/android/util/MeasureOutputStream;-><init>(Ljava/io/File;Ljava/lang/String;Lco/vine/android/util/VineProgressListener;)V

    .line 127
    .restart local v0    # "entity":Lco/vine/android/util/MeasureOutputStream;
    const/16 v5, 0x10

    invoke-static {v5}, Lco/vine/android/api/VineParserReader;->createParserReader(I)Lco/vine/android/api/VineParserReader;

    move-result-object v2

    .line 129
    .restart local v2    # "reader":Lco/vine/android/api/VineParserReader;
    iget-object v5, p0, Lco/vine/android/util/MediaUtility;->mContext:Landroid/content/Context;

    invoke-static {v5}, Lco/vine/android/network/ThreadedHttpOperationClient;->getInstance(Landroid/content/Context;)Lco/vine/android/network/ThreadedHttpOperationClient;

    move-result-object v5

    iget-object v6, p0, Lco/vine/android/util/MediaUtility;->mContext:Landroid/content/Context;

    invoke-static {v6}, Lco/vine/android/client/VineAPI;->getInstance(Landroid/content/Context;)Lco/vine/android/client/VineAPI;

    move-result-object v6

    invoke-static {v5, v3, v2, v0, v6}, Lco/vine/android/network/HttpOperation;->createMediaPutRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/network/HttpOperationReader;Lorg/apache/http/HttpEntity;Lco/vine/android/client/VineAPI;)Lco/vine/android/network/HttpOperation;

    move-result-object v5

    invoke-virtual {v5}, Lco/vine/android/network/HttpOperation;->execute()Lco/vine/android/network/HttpOperation;

    move-result-object v1

    .line 132
    .restart local v1    # "op":Lco/vine/android/network/HttpOperation;
    invoke-virtual {v1}, Lco/vine/android/network/HttpOperation;->isOK()Z

    move-result v5

    if-eqz v5, :cond_5

    .line 133
    const-string v5, "Upload {} successful."

    iget-object v6, v1, Lco/vine/android/network/HttpOperation;->uploadKey:Ljava/lang/String;

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 134
    new-instance v5, Lco/vine/android/util/MediaUtility$FileInfo;

    invoke-virtual {p3}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v6

    iget-object v7, v1, Lco/vine/android/network/HttpOperation;->uploadKey:Ljava/lang/String;

    invoke-direct {v5, v6, p3, v7}, Lco/vine/android/util/MediaUtility$FileInfo;-><init>(Ljava/lang/String;Ljava/io/File;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 136
    :cond_5
    const-string v5, "{} {} {}"

    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object v3, v6, v7

    const/4 v7, 0x1

    iget v8, v1, Lco/vine/android/network/HttpOperation;->statusCode:I

    invoke-static {v8}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v8

    aput-object v8, v6, v7

    const/4 v7, 0x2

    iget-object v8, v1, Lco/vine/android/network/HttpOperation;->statusPhrase:Ljava/lang/String;

    aput-object v8, v6, v7

    invoke-static {v5, v6}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0

    .line 63
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_0
    .end packed-switch
.end method
