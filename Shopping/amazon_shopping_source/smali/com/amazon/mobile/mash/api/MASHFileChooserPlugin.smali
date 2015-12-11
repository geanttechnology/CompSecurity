.class public Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;
.super Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;
.source "MASHFileChooserPlugin.java"


# instance fields
.field private mCallback:Lorg/apache/cordova/CallbackContext;

.field private mCameraFilePath:Ljava/lang/String;

.field private mMaxFileSize:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/amazon/mobile/mash/api/MASHCordovaPlugin;-><init>()V

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;Ljava/lang/String;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 33
    invoke-direct {p0, p1}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->mimeTypeNotSupported(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$100(Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;)Lorg/apache/cordova/CallbackContext;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;

    .prologue
    .line 33
    iget-object v0, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;Ljava/lang/String;ZI)Landroid/content/Intent;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Z
    .param p3, "x3"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 33
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->createChooserIntent(Ljava/lang/String;ZI)Landroid/content/Intent;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;Landroid/content/Intent;I)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;
    .param p1, "x1"    # Landroid/content/Intent;
    .param p2, "x2"    # I

    .prologue
    .line 33
    invoke-direct {p0, p1, p2}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->startActivityForResult(Landroid/content/Intent;I)V

    return-void
.end method

.method private checkFileSizeAndExistence(Landroid/net/Uri;)Z
    .locals 5
    .param p1, "filePath"    # Landroid/net/Uri;

    .prologue
    const/4 v2, 0x0

    .line 334
    :try_start_0
    invoke-direct {p0, p1}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->getFileSize(Landroid/net/Uri;)I
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_1

    move-result v1

    .line 345
    .local v1, "fileSize":I
    iget v3, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->mMaxFileSize:I

    if-lez v3, :cond_0

    iget v3, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->mMaxFileSize:I

    if-ge v3, v1, :cond_0

    .line 346
    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    sget-object v4, Lcom/amazon/mobile/mash/error/OpenFileChooserError;->FILE_SIZE_EXCEEDED:Lcom/amazon/mobile/mash/error/OpenFileChooserError;

    invoke-virtual {v4}, Lcom/amazon/mobile/mash/error/OpenFileChooserError;->toJSONObject()Lorg/json/JSONObject;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    .line 349
    .end local v1    # "fileSize":I
    :goto_0
    return v2

    .line 335
    :catch_0
    move-exception v0

    .line 336
    .local v0, "e":Ljava/io/FileNotFoundException;
    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    sget-object v4, Lcom/amazon/mobile/mash/error/OpenFileChooserError;->FILE_NOT_FOUND:Lcom/amazon/mobile/mash/error/OpenFileChooserError;

    invoke-virtual {v4}, Lcom/amazon/mobile/mash/error/OpenFileChooserError;->toJSONObject()Lorg/json/JSONObject;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0

    .line 338
    .end local v0    # "e":Ljava/io/FileNotFoundException;
    :catch_1
    move-exception v0

    .line 339
    .local v0, "e":Ljava/io/IOException;
    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    sget-object v4, Lcom/amazon/mobile/mash/error/MASHError;->UNKNOWN:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v4}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0

    .line 349
    .end local v0    # "e":Ljava/io/IOException;
    .restart local v1    # "fileSize":I
    :cond_0
    const/4 v2, 0x1

    goto :goto_0
.end method

.method private createCamcorderIntent(I)Landroid/content/Intent;
    .locals 2
    .param p1, "duration"    # I

    .prologue
    .line 257
    new-instance v0, Landroid/content/Intent;

    const-string/jumbo v1, "android.media.action.VIDEO_CAPTURE"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 258
    .local v0, "intent":Landroid/content/Intent;
    if-lez p1, :cond_0

    .line 259
    const-string/jumbo v1, "android.intent.extra.durationLimit"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 261
    :cond_0
    return-object v0
.end method

.method private createCameraIntent()Landroid/content/Intent;
    .locals 6
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 237
    new-instance v1, Landroid/content/Intent;

    const-string/jumbo v3, "android.media.action.IMAGE_CAPTURE"

    invoke-direct {v1, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 238
    .local v1, "cameraIntent":Landroid/content/Intent;
    sget-object v3, Landroid/os/Environment;->DIRECTORY_DCIM:Ljava/lang/String;

    invoke-static {v3}, Landroid/os/Environment;->getExternalStoragePublicDirectory(Ljava/lang/String;)Ljava/io/File;

    move-result-object v2

    .line 240
    .local v2, "externalDataDir":Ljava/io/File;
    new-instance v0, Ljava/io/File;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v4, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "browser-photos"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 242
    .local v0, "cameraDataDir":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    move-result v3

    if-nez v3, :cond_0

    invoke-virtual {v0}, Ljava/io/File;->isDirectory()Z

    move-result v3

    if-nez v3, :cond_0

    .line 244
    new-instance v3, Ljava/io/IOException;

    invoke-direct {v3}, Ljava/io/IOException;-><init>()V

    throw v3

    .line 246
    :cond_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v4, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, ".jpg"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->mCameraFilePath:Ljava/lang/String;

    .line 248
    const-string/jumbo v3, "output"

    new-instance v4, Ljava/io/File;

    iget-object v5, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->mCameraFilePath:Ljava/lang/String;

    invoke-direct {v4, v5}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-static {v4}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;

    move-result-object v4

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 249
    return-object v1
.end method

.method private createChooserIntent(Ljava/lang/String;ZI)Landroid/content/Intent;
    .locals 4
    .param p1, "mimeType"    # Ljava/lang/String;
    .param p2, "capture"    # Z
    .param p3, "duration"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 137
    const/4 v0, 0x0

    .line 139
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v1, "image/*"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 140
    if-eqz p2, :cond_1

    .line 142
    invoke-direct {p0}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->createCameraIntent()Landroid/content/Intent;

    move-result-object v0

    .line 175
    :cond_0
    :goto_0
    return-object v0

    .line 146
    :cond_1
    new-array v1, v2, [Landroid/content/Intent;

    invoke-direct {p0}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->createCameraIntent()Landroid/content/Intent;

    move-result-object v2

    aput-object v2, v1, v3

    invoke-direct {p0, v1}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->createChooserIntent([Landroid/content/Intent;)Landroid/content/Intent;

    move-result-object v0

    .line 147
    const-string/jumbo v1, "android.intent.extra.INTENT"

    const-string/jumbo v2, "image/*"

    invoke-direct {p0, v2}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->createOpenableIntent(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    goto :goto_0

    .line 149
    :cond_2
    const-string/jumbo v1, "video/*"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 150
    if-eqz p2, :cond_3

    .line 153
    invoke-direct {p0, p3}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->createCamcorderIntent(I)Landroid/content/Intent;

    move-result-object v0

    goto :goto_0

    .line 157
    :cond_3
    new-array v1, v2, [Landroid/content/Intent;

    invoke-direct {p0, p3}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->createCamcorderIntent(I)Landroid/content/Intent;

    move-result-object v2

    aput-object v2, v1, v3

    invoke-direct {p0, v1}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->createChooserIntent([Landroid/content/Intent;)Landroid/content/Intent;

    move-result-object v0

    .line 158
    const-string/jumbo v1, "android.intent.extra.INTENT"

    const-string/jumbo v2, "video/*"

    invoke-direct {p0, v2}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->createOpenableIntent(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    goto :goto_0

    .line 160
    :cond_4
    const-string/jumbo v1, "audio/*"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 161
    if-eqz p2, :cond_5

    .line 164
    invoke-direct {p0}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->createSoundRecorderIntent()Landroid/content/Intent;

    move-result-object v0

    goto :goto_0

    .line 168
    :cond_5
    new-array v1, v2, [Landroid/content/Intent;

    invoke-direct {p0}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->createSoundRecorderIntent()Landroid/content/Intent;

    move-result-object v2

    aput-object v2, v1, v3

    invoke-direct {p0, v1}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->createChooserIntent([Landroid/content/Intent;)Landroid/content/Intent;

    move-result-object v0

    .line 169
    const-string/jumbo v1, "android.intent.extra.INTENT"

    const-string/jumbo v2, "audio/*"

    invoke-direct {p0, v2}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->createOpenableIntent(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    goto :goto_0

    .line 171
    :cond_6
    const-string/jumbo v1, "*/*"

    invoke-virtual {v1, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 173
    invoke-direct {p0, p3}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->createDefaultOpenableIntent(I)Landroid/content/Intent;

    move-result-object v0

    goto :goto_0
.end method

.method private varargs createChooserIntent([Landroid/content/Intent;)Landroid/content/Intent;
    .locals 2
    .param p1, "intents"    # [Landroid/content/Intent;

    .prologue
    .line 213
    new-instance v0, Landroid/content/Intent;

    const-string/jumbo v1, "android.intent.action.CHOOSER"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 214
    .local v0, "chooser":Landroid/content/Intent;
    const-string/jumbo v1, "android.intent.extra.INITIAL_INTENTS"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 215
    return-object v0
.end method

.method private createDefaultOpenableIntent(I)Landroid/content/Intent;
    .locals 4
    .param p1, "duration"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 199
    const/4 v1, 0x3

    new-array v1, v1, [Landroid/content/Intent;

    const/4 v2, 0x0

    invoke-direct {p0}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->createCameraIntent()Landroid/content/Intent;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    invoke-direct {p0, p1}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->createCamcorderIntent(I)Landroid/content/Intent;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x2

    invoke-direct {p0}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->createSoundRecorderIntent()Landroid/content/Intent;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-direct {p0, v1}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->createChooserIntent([Landroid/content/Intent;)Landroid/content/Intent;

    move-result-object v0

    .line 203
    .local v0, "chooser":Landroid/content/Intent;
    const-string/jumbo v1, "android.intent.extra.INTENT"

    const-string/jumbo v2, "*/*"

    invoke-direct {p0, v2}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->createOpenableIntent(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Landroid/os/Parcelable;)Landroid/content/Intent;

    .line 204
    return-object v0
.end method

.method private createOpenableIntent(Ljava/lang/String;)Landroid/content/Intent;
    .locals 2
    .param p1, "type"    # Ljava/lang/String;

    .prologue
    .line 224
    new-instance v0, Landroid/content/Intent;

    const-string/jumbo v1, "android.intent.action.GET_CONTENT"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 225
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v1, "android.intent.category.OPENABLE"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 226
    invoke-virtual {v0, p1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 227
    return-object v0
.end method

.method private createSoundRecorderIntent()Landroid/content/Intent;
    .locals 2

    .prologue
    .line 269
    new-instance v0, Landroid/content/Intent;

    const-string/jumbo v1, "android.provider.MediaStore.RECORD_SOUND"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 270
    .local v0, "intent":Landroid/content/Intent;
    return-object v0
.end method

.method private getFileSize(Landroid/net/Uri;)I
    .locals 3
    .param p1, "filePath"    # Landroid/net/Uri;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 358
    invoke-virtual {p1}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-static {v1, v2}, Lorg/apache/cordova/FileHelper;->getInputStreamFromUriString(Ljava/lang/String;Lorg/apache/cordova/CordovaInterface;)Ljava/io/InputStream;

    move-result-object v0

    .line 359
    .local v0, "stream":Ljava/io/InputStream;
    check-cast v0, Ljava/io/FileInputStream;

    .end local v0    # "stream":Ljava/io/InputStream;
    invoke-virtual {v0}, Ljava/io/FileInputStream;->getChannel()Ljava/nio/channels/FileChannel;

    move-result-object v1

    invoke-virtual {v1}, Ljava/nio/channels/FileChannel;->size()J

    move-result-wide v1

    long-to-int v1, v1

    return v1
.end method

.method private mimeTypeNotSupported(Ljava/lang/String;)Z
    .locals 1
    .param p1, "mimeType"    # Ljava/lang/String;

    .prologue
    .line 117
    const-string/jumbo v0, "image/*"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "audio/*"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "video/*"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "*/*"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private startActivityForResult(Landroid/content/Intent;I)V
    .locals 3
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "duration"    # I

    .prologue
    .line 183
    :try_start_0
    iget-object v1, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    const/16 v2, 0x2714

    invoke-interface {v1, p0, p1, v2}, Lorg/apache/cordova/CordovaInterface;->startActivityForResult(Lorg/apache/cordova/CordovaPlugin;Landroid/content/Intent;I)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 188
    :goto_0
    return-void

    .line 184
    :catch_0
    move-exception v0

    .line 186
    .local v0, "e":Landroid/content/ActivityNotFoundException;
    iget-object v1, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    sget-object v2, Lcom/amazon/mobile/mash/error/OpenFileChooserError;->CANNOT_OPEN_CAPTURE_MECHANISM:Lcom/amazon/mobile/mash/error/OpenFileChooserError;

    invoke-virtual {v2}, Lcom/amazon/mobile/mash/error/OpenFileChooserError;->toJSONObject()Lorg/json/JSONObject;

    move-result-object v2

    invoke-virtual {v1, v2}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0
.end method


# virtual methods
.method public execute(Ljava/lang/String;Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)Z
    .locals 1
    .param p1, "action"    # Ljava/lang/String;
    .param p2, "args"    # Lorg/json/JSONArray;
    .param p3, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 53
    const-string/jumbo v0, "OpenFileChooser"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 54
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->openFileChooser(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V

    .line 55
    const/4 v0, 0x1

    .line 57
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method handlePickFileResult(ILandroid/content/Intent;)V
    .locals 6
    .param p1, "resultCode"    # I
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v3, -0x1

    .line 281
    if-nez p1, :cond_1

    .line 282
    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    sget-object v4, Lcom/amazon/mobile/mash/error/MASHError;->USER_CANCELLED:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v4}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    .line 322
    :cond_0
    :goto_0
    return-void

    .line 286
    :cond_1
    if-eqz p2, :cond_2

    if-eq p1, v3, :cond_4

    :cond_2
    const/4 v1, 0x0

    .line 296
    .local v1, "filePath":Landroid/net/Uri;
    :goto_1
    if-nez v1, :cond_3

    if-nez p2, :cond_3

    if-ne p1, v3, :cond_3

    .line 297
    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->mCameraFilePath:Ljava/lang/String;

    if-eqz v3, :cond_3

    .line 298
    new-instance v0, Ljava/io/File;

    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->mCameraFilePath:Ljava/lang/String;

    invoke-direct {v0, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 299
    .local v0, "cameraFile":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 300
    invoke-static {v0}, Landroid/net/Uri;->fromFile(Ljava/io/File;)Landroid/net/Uri;

    move-result-object v1

    .line 303
    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v3}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v3

    new-instance v4, Landroid/content/Intent;

    const-string/jumbo v5, "android.intent.action.MEDIA_SCANNER_SCAN_FILE"

    invoke-direct {v4, v5, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    invoke-virtual {v3, v4}, Landroid/app/Activity;->sendBroadcast(Landroid/content/Intent;)V

    .line 310
    .end local v0    # "cameraFile":Ljava/io/File;
    :cond_3
    if-nez v1, :cond_5

    .line 311
    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    sget-object v4, Lcom/amazon/mobile/mash/error/MASHError;->UNKNOWN:Lcom/amazon/mobile/mash/error/MASHError;

    invoke-virtual {v4}, Lcom/amazon/mobile/mash/error/MASHError;->toJSONObejct()Lorg/json/JSONObject;

    move-result-object v4

    invoke-virtual {v3, v4}, Lorg/apache/cordova/CallbackContext;->error(Lorg/json/JSONObject;)V

    goto :goto_0

    .line 286
    .end local v1    # "filePath":Landroid/net/Uri;
    :cond_4
    invoke-virtual {p2}, Landroid/content/Intent;->getData()Landroid/net/Uri;

    move-result-object v1

    goto :goto_1

    .line 315
    .restart local v1    # "filePath":Landroid/net/Uri;
    :cond_5
    invoke-direct {p0, v1}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->checkFileSizeAndExistence(Landroid/net/Uri;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 319
    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->cordova:Lorg/apache/cordova/CordovaInterface;

    invoke-interface {v3}, Lorg/apache/cordova/CordovaInterface;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-static {v3, v1}, Lcom/amazon/mobile/mash/util/MASHFileUtil;->getFilePath(Landroid/content/Context;Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v2

    .line 321
    .local v2, "result":Ljava/lang/String;
    iget-object v3, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    invoke-virtual {v3, v2}, Lorg/apache/cordova/CallbackContext;->success(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 62
    const/16 v0, 0x2714

    if-ne p1, v0, :cond_0

    .line 63
    invoke-virtual {p0, p2, p3}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->handlePickFileResult(ILandroid/content/Intent;)V

    .line 65
    :cond_0
    return-void
.end method

.method openFileChooser(Lorg/json/JSONArray;Lorg/apache/cordova/CallbackContext;)V
    .locals 4
    .param p1, "args"    # Lorg/json/JSONArray;
    .param p2, "callback"    # Lorg/apache/cordova/CallbackContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 80
    iput-object p2, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->mCallback:Lorg/apache/cordova/CallbackContext;

    .line 81
    const/4 v3, 0x0

    iput-object v3, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->mCameraFilePath:Ljava/lang/String;

    .line 84
    const/4 v3, 0x0

    invoke-virtual {p1, v3}, Lorg/json/JSONArray;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 85
    .local v2, "mimeType":Ljava/lang/String;
    const/4 v3, 0x1

    invoke-virtual {p1, v3}, Lorg/json/JSONArray;->getBoolean(I)Z

    move-result v0

    .line 87
    .local v0, "capture":Z
    const/4 v3, 0x2

    invoke-virtual {p1, v3}, Lorg/json/JSONArray;->getInt(I)I

    move-result v3

    iput v3, p0, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->mMaxFileSize:I

    .line 88
    const/4 v3, 0x3

    invoke-virtual {p1, v3}, Lorg/json/JSONArray;->getInt(I)I

    move-result v1

    .line 90
    .local v1, "duration":I
    new-instance v3, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin$1;

    invoke-direct {v3, p0, v2, v0, v1}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin$1;-><init>(Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;Ljava/lang/String;ZI)V

    invoke-virtual {p0, v3}, Lcom/amazon/mobile/mash/api/MASHFileChooserPlugin;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 109
    return-void
.end method
