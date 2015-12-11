.class public Lcom/lifevibes/mediacoder/LVMediaCoderFactory;
.super Ljava/lang/Object;
.source "LVMediaCoderFactory.java"


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0x10
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String; = "LVMediaCoderFactory"

.field private static inputAudioFile:Ljava/io/File;

.field private static inputVideoFile:Ljava/io/File;

.field private static mLogFile:Ljava/io/File;

.field private static mPrintLogStream:Ljava/io/PrintStream;

.field private static mUnsupportedColorFormat:Ljava/lang/String;


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 86
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 88
    return-void
.end method

.method private static checkColorFormat()Z
    .locals 15

    .prologue
    const/4 v12, 0x0

    .line 123
    const/4 v8, 0x0

    .line 124
    .local v8, "index":I
    sget-boolean v13, Lcom/lifevibes/mediacoder/LVMediaCoderProperties;->DEBUG:Z

    if-eqz v13, :cond_2

    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 125
    .local v5, "compatibleEncoders":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/media/MediaCodecInfo;>;"
    :goto_0
    const/4 v6, 0x0

    .local v6, "i":I
    :goto_1
    invoke-static {}, Landroid/media/MediaCodecList;->getCodecCount()I

    move-result v13

    if-ge v6, v13, :cond_6

    .line 126
    invoke-static {v6}, Landroid/media/MediaCodecList;->getCodecInfoAt(I)Landroid/media/MediaCodecInfo;

    move-result-object v2

    .line 127
    .local v2, "codecInfo":Landroid/media/MediaCodecInfo;
    sget-boolean v13, Lcom/lifevibes/mediacoder/LVMediaCoderProperties;->DEBUG:Z

    if-eqz v13, :cond_0

    .line 128
    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string v14, "[LVMediaCoderFactory] Encoder "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, ": "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v2}, Landroid/media/MediaCodecInfo;->getName()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-static {v13, v12}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 130
    :cond_0
    invoke-virtual {v2}, Landroid/media/MediaCodecInfo;->isEncoder()Z

    move-result v13

    if-nez v13, :cond_3

    .line 125
    :cond_1
    :goto_2
    add-int/lit8 v6, v6, 0x1

    goto :goto_1

    .line 124
    .end local v2    # "codecInfo":Landroid/media/MediaCodecInfo;
    .end local v5    # "compatibleEncoders":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/media/MediaCodecInfo;>;"
    .end local v6    # "i":I
    :cond_2
    const/4 v5, 0x0

    goto :goto_0

    .line 133
    .restart local v2    # "codecInfo":Landroid/media/MediaCodecInfo;
    .restart local v5    # "compatibleEncoders":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/media/MediaCodecInfo;>;"
    .restart local v6    # "i":I
    :cond_3
    invoke-virtual {v2}, Landroid/media/MediaCodecInfo;->getSupportedTypes()[Ljava/lang/String;

    move-result-object v10

    .line 134
    .local v10, "supportedTypes":[Ljava/lang/String;
    move-object v0, v10

    .local v0, "arr$":[Ljava/lang/String;
    array-length v9, v0

    .local v9, "len$":I
    const/4 v7, 0x0

    .local v7, "i$":I
    :goto_3
    if-ge v7, v9, :cond_1

    aget-object v11, v0, v7

    .line 135
    .local v11, "type":Ljava/lang/String;
    const-string v13, "avc"

    invoke-virtual {v11, v13}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v13

    if-eqz v13, :cond_5

    .line 136
    sget-boolean v13, Lcom/lifevibes/mediacoder/LVMediaCoderProperties;->DEBUG:Z

    if-eqz v13, :cond_4

    .line 137
    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string v14, "[LVMediaCoderFactory] Encoder "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, "/"

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-static {}, Landroid/media/MediaCodecList;->getCodecCount()I

    move-result v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, ": "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v2}, Landroid/media/MediaCodecInfo;->getName()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, " supports ["

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, "]"

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-static {v13, v12}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 138
    if-eqz v5, :cond_4

    .line 139
    invoke-virtual {v5, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 142
    :cond_4
    move v8, v6

    .line 143
    goto :goto_2

    .line 134
    :cond_5
    add-int/lit8 v7, v7, 0x1

    goto :goto_3

    .line 148
    .end local v0    # "arr$":[Ljava/lang/String;
    .end local v2    # "codecInfo":Landroid/media/MediaCodecInfo;
    .end local v7    # "i$":I
    .end local v9    # "len$":I
    .end local v10    # "supportedTypes":[Ljava/lang/String;
    .end local v11    # "type":Ljava/lang/String;
    :cond_6
    invoke-static {v8}, Landroid/media/MediaCodecList;->getCodecInfoAt(I)Landroid/media/MediaCodecInfo;

    move-result-object v13

    const-string v14, "video/avc"

    invoke-virtual {v13, v14}, Landroid/media/MediaCodecInfo;->getCapabilitiesForType(Ljava/lang/String;)Landroid/media/MediaCodecInfo$CodecCapabilities;

    move-result-object v1

    .line 150
    .local v1, "capabilities":Landroid/media/MediaCodecInfo$CodecCapabilities;
    sget-boolean v13, Lcom/lifevibes/mediacoder/LVMediaCoderProperties;->DEBUG:Z

    if-eqz v13, :cond_7

    .line 151
    iget-object v0, v1, Landroid/media/MediaCodecInfo$CodecCapabilities;->colorFormats:[I

    .local v0, "arr$":[I
    array-length v9, v0

    .restart local v9    # "len$":I
    const/4 v7, 0x0

    .restart local v7    # "i$":I
    :goto_4
    if-ge v7, v9, :cond_7

    aget v3, v0, v7

    .line 152
    .local v3, "colorFormat":I
    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    const-string v14, "[LVMediaCoderFactory] Color Format: "

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-static {v13, v12}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 151
    add-int/lit8 v7, v7, 0x1

    goto :goto_4

    .line 156
    .end local v0    # "arr$":[I
    .end local v3    # "colorFormat":I
    .end local v7    # "i$":I
    .end local v9    # "len$":I
    :cond_7
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 157
    .local v4, "colorFormats":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    const/4 v6, 0x0

    :goto_5
    iget-object v13, v1, Landroid/media/MediaCodecInfo$CodecCapabilities;->colorFormats:[I

    array-length v13, v13

    if-ge v6, v13, :cond_8

    .line 158
    iget-object v13, v1, Landroid/media/MediaCodecInfo$CodecCapabilities;->colorFormats:[I

    aget v13, v13, v6

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    invoke-virtual {v4, v13}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 157
    add-int/lit8 v6, v6, 0x1

    goto :goto_5

    .line 161
    :cond_8
    const/16 v13, 0x13

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    invoke-virtual {v4, v13}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v13

    if-nez v13, :cond_9

    const/16 v13, 0x14

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    invoke-virtual {v4, v13}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v13

    if-nez v13, :cond_9

    const/16 v13, 0x15

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    invoke-virtual {v4, v13}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v13

    if-nez v13, :cond_9

    const/16 v13, 0x27

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    invoke-virtual {v4, v13}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v13

    if-nez v13, :cond_9

    const v13, 0x7f000100

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v13

    invoke-virtual {v4, v13}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_a

    .line 167
    :cond_9
    const/4 v12, 0x1

    .line 170
    :goto_6
    return v12

    .line 169
    :cond_a
    new-instance v13, Ljava/lang/StringBuilder;

    invoke-direct {v13}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v12}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v13

    const-string v14, ""

    invoke-virtual {v13, v14}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v13

    invoke-virtual {v13}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    sput-object v13, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->mUnsupportedColorFormat:Ljava/lang/String;

    goto :goto_6
.end method

.method public static create(Landroid/content/Context;Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;)Lcom/lifevibes/mediacoder/LVMediaCoderImpl;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "configuration"    # Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 101
    sget-boolean v0, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v0, :cond_0

    .line 102
    new-instance v0, Ljava/io/File;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/Twitter/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->mkdirs()Z

    move-result v0

    if-nez v0, :cond_0

    .line 103
    const-string v0, "Logs may not be working."

    invoke-static {v0}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    .line 108
    :cond_0
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xf

    if-gt v0, v1, :cond_2

    .line 109
    const/4 v0, 0x1

    sput-boolean v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;->isRunningOnICS:Z

    .line 118
    :cond_1
    invoke-static {p1}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->validateConfiguration(Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;)V

    .line 119
    new-instance v0, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;

    invoke-direct {v0, p0, p1}, Lcom/lifevibes/mediacoder/LVMediaCoderImpl;-><init>(Landroid/content/Context;Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;)V

    return-object v0

    .line 112
    :cond_2
    invoke-static {}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->checkColorFormat()Z

    move-result v0

    if-nez v0, :cond_1

    .line 113
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Currently color format "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->mUnsupportedColorFormat:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " is NOT supported"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method static dumpInputAudioData([B)V
    .locals 4
    .param p0, "audioData"    # [B

    .prologue
    .line 291
    sget-boolean v2, Lcom/lifevibes/mediacoder/LVMediaCoderProperties;->DUMPS:Z

    if-nez v2, :cond_0

    sget-object v2, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->inputAudioFile:Ljava/io/File;

    if-nez v2, :cond_0

    .line 302
    :goto_0
    return-void

    .line 295
    :cond_0
    :try_start_0
    new-instance v1, Ljava/io/FileOutputStream;

    sget-object v2, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->inputAudioFile:Ljava/io/File;

    const/4 v3, 0x1

    invoke-direct {v1, v2, v3}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;Z)V

    .line 296
    .local v1, "outputStreamAudio":Ljava/io/FileOutputStream;
    invoke-virtual {v1, p0}, Ljava/io/FileOutputStream;->write([B)V

    .line 297
    invoke-virtual {v1}, Ljava/io/FileOutputStream;->flush()V

    .line 298
    invoke-virtual {v1}, Ljava/io/FileOutputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 299
    .end local v1    # "outputStreamAudio":Ljava/io/FileOutputStream;
    :catch_0
    move-exception v0

    .line 300
    .local v0, "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0
.end method

.method static dumpInputVideoData([B)V
    .locals 4
    .param p0, "videoData"    # [B

    .prologue
    .line 277
    sget-boolean v2, Lcom/lifevibes/mediacoder/LVMediaCoderProperties;->DUMPS:Z

    if-nez v2, :cond_0

    sget-object v2, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->inputVideoFile:Ljava/io/File;

    if-nez v2, :cond_0

    .line 288
    :goto_0
    return-void

    .line 281
    :cond_0
    :try_start_0
    new-instance v1, Ljava/io/FileOutputStream;

    sget-object v2, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->inputVideoFile:Ljava/io/File;

    const/4 v3, 0x1

    invoke-direct {v1, v2, v3}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;Z)V

    .line 282
    .local v1, "outputStreamVideo":Ljava/io/FileOutputStream;
    invoke-virtual {v1, p0}, Ljava/io/FileOutputStream;->write([B)V

    .line 283
    invoke-virtual {v1}, Ljava/io/FileOutputStream;->flush()V

    .line 284
    invoke-virtual {v1}, Ljava/io/FileOutputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 285
    .end local v1    # "outputStreamVideo":Ljava/io/FileOutputStream;
    :catch_0
    move-exception v0

    .line 286
    .local v0, "e":Ljava/io/IOException;
    invoke-virtual {v0}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0
.end method

.method static printLog(Ljava/lang/String;Z)V
    .locals 3
    .param p0, "log"    # Ljava/lang/String;
    .param p1, "exception"    # Z

    .prologue
    .line 237
    sget-boolean v0, Lcom/lifevibes/mediacoder/LVMediaCoderProperties;->DEBUG:Z

    if-nez v0, :cond_1

    .line 256
    :cond_0
    :goto_0
    return-void

    .line 240
    :cond_1
    sget-object v0, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->mPrintLogStream:Ljava/io/PrintStream;

    if-eqz v0, :cond_2

    sget-object v0, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->mLogFile:Ljava/io/File;

    if-eqz v0, :cond_2

    sget-object v0, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->mLogFile:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-nez v0, :cond_3

    .line 241
    :cond_2
    const-string v0, "LVMediaCoderFactory"

    const-string v1, "Exception while writing to the log file."

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 245
    :cond_3
    const-string v0, "LVMediaCoderFactory"

    const-string v1, "[LVMediaCoderFactory] "

    const-string v2, ""

    invoke-virtual {p0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 246
    if-eqz p1, :cond_4

    .line 247
    sget-object v0, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->mPrintLogStream:Ljava/io/PrintStream;

    const-string v1, "======================= EXCEPTION [START] ======================="

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 248
    sget-object v0, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->mPrintLogStream:Ljava/io/PrintStream;

    invoke-virtual {v0}, Ljava/io/PrintStream;->flush()V

    .line 250
    :cond_4
    sget-object v0, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->mPrintLogStream:Ljava/io/PrintStream;

    invoke-virtual {v0, p0}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 251
    sget-object v0, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->mPrintLogStream:Ljava/io/PrintStream;

    invoke-virtual {v0}, Ljava/io/PrintStream;->flush()V

    .line 252
    if-eqz p1, :cond_0

    .line 253
    sget-object v0, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->mPrintLogStream:Ljava/io/PrintStream;

    const-string v1, "======================== EXCEPTION [END] ========================"

    invoke-virtual {v0, v1}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    .line 254
    sget-object v0, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->mPrintLogStream:Ljava/io/PrintStream;

    invoke-virtual {v0}, Ljava/io/PrintStream;->flush()V

    goto :goto_0
.end method

.method public static setDumpingEnabled(Z)V
    .locals 2
    .param p0, "dumping"    # Z

    .prologue
    .line 259
    sput-boolean p0, Lcom/lifevibes/mediacoder/LVMediaCoderProperties;->DUMPS:Z

    .line 260
    if-eqz p0, :cond_2

    .line 261
    new-instance v0, Ljava/io/File;

    const-string v1, "/mnt/sdcard/Twitter/"

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/File;->mkdir()Z

    .line 263
    new-instance v0, Ljava/io/File;

    const-string v1, "/mnt/sdcard/Twitter/Twitter_Input_Video.raw"

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->inputVideoFile:Ljava/io/File;

    .line 264
    new-instance v0, Ljava/io/File;

    const-string v1, "/mnt/sdcard/Twitter/Twitter_Input_Audio.raw"

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->inputAudioFile:Ljava/io/File;

    .line 265
    sget-object v0, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->inputVideoFile:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 266
    sget-object v0, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->inputVideoFile:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    .line 268
    :cond_0
    sget-object v0, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->inputAudioFile:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 269
    sget-object v0, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->inputAudioFile:Ljava/io/File;

    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    .line 271
    :cond_1
    new-instance v0, Ljava/io/File;

    const-string v1, "/mnt/sdcard/Twitter/Twitter_Input_Video.raw"

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->inputVideoFile:Ljava/io/File;

    .line 272
    new-instance v0, Ljava/io/File;

    const-string v1, "/mnt/sdcard/Twitter/Twitter_Input_Audio.raw"

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->inputAudioFile:Ljava/io/File;

    .line 274
    :cond_2
    return-void
.end method

.method public static setLoggingEnabled(Z)V
    .locals 3
    .param p0, "debug"    # Z

    .prologue
    .line 219
    sput-boolean p0, Lcom/lifevibes/mediacoder/LVMediaCoderProperties;->DEBUG:Z

    .line 220
    if-eqz p0, :cond_1

    .line 221
    new-instance v1, Ljava/io/File;

    const-string v2, "/mnt/sdcard/Twitter/"

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/io/File;->mkdirs()Z

    .line 223
    new-instance v1, Ljava/io/File;

    const-string v2, "/mnt/sdcard/Twitter/LVMediaCoderLog.txt"

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    sput-object v1, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->mLogFile:Ljava/io/File;

    .line 224
    sget-object v1, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->mLogFile:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 225
    sget-object v1, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->mLogFile:Ljava/io/File;

    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    .line 227
    :cond_0
    new-instance v1, Ljava/io/File;

    const-string v2, "/mnt/sdcard/Twitter/LVMediaCoderLog.txt"

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    sput-object v1, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->mLogFile:Ljava/io/File;

    .line 229
    :try_start_0
    new-instance v1, Ljava/io/PrintStream;

    sget-object v2, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->mLogFile:Ljava/io/File;

    invoke-direct {v1, v2}, Ljava/io/PrintStream;-><init>(Ljava/io/File;)V

    sput-object v1, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->mPrintLogStream:Ljava/io/PrintStream;
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 234
    :cond_1
    :goto_0
    return-void

    .line 230
    :catch_0
    move-exception v0

    .line 231
    .local v0, "e":Ljava/io/FileNotFoundException;
    invoke-virtual {v0}, Ljava/io/FileNotFoundException;->printStackTrace()V

    goto :goto_0
.end method

.method private static validateConfiguration(Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;)V
    .locals 3
    .param p0, "configuration"    # Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;

    .prologue
    .line 174
    if-nez p0, :cond_0

    .line 175
    new-instance v0, Ljava/lang/NullPointerException;

    const-string v1, "Configuration is null."

    invoke-direct {v0, v1}, Ljava/lang/NullPointerException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 178
    :cond_0
    sget-boolean v0, Lcom/lifevibes/mediacoder/LVMediaCoderProperties;->DEBUG:Z

    if-eqz v0, :cond_1

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[LVMediaCoderFactory] Session configuration:\n\t\t\t\t Video BitRate:\t\t"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoBitRate:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\n\t\t\t\t Video Frame Rate:\t"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoFrameRate:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\n\t\t\t\t Video I-Frame Int:\t"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoIFrameInterval:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\n\t\t\t\t Audio Bit Rate:\t"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioBitRate:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\n\t\t\t\t Audio Channels:\t"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioChannelCount:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\n\t\t\t\t Audio Sample Rate:\t"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioSampleRate:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/lifevibes/mediacoder/LVMediaCoderFactory;->printLog(Ljava/lang/String;Z)V

    .line 186
    :cond_1
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoIFrameInterval:I

    if-gtz v0, :cond_2

    .line 187
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Video IFrame interval should be greater than 0."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 189
    :cond_2
    invoke-static {}, Lcom/lifevibes/mediacoder/LVMediaCoderProperties;->getSupportedVideoBitrates()Ljava/util/ArrayList;

    move-result-object v0

    iget v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoBitRate:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 190
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoBitRate:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " video bit-rate is not supported. Use LVMediaCoderProperties.getSupportedBitrates() to get the list of supported video bit-rates."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 192
    :cond_3
    invoke-static {}, Lcom/lifevibes/mediacoder/LVMediaCoderProperties;->getSupportedHeightAndWidth()Ljava/util/ArrayList;

    move-result-object v0

    iget v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoWidth:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-static {}, Lcom/lifevibes/mediacoder/LVMediaCoderProperties;->getSupportedHeightAndWidth()Ljava/util/ArrayList;

    move-result-object v0

    iget v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoHeight:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_5

    .line 193
    :cond_4
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Video resolution: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoWidth:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "x"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoHeight:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " is not supported. Please use LVMediaCoderProperties.getSupportedHeightAndWidth() to get the list of supported Heights and Widths."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 195
    :cond_5
    iget v0, p0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoWidth:I

    iget v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoHeight:I

    if-eq v0, v1, :cond_6

    .line 196
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Video resolution: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoWidth:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "x"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoHeight:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " is not supported. Currenly only aspect ratio of 1:1 is supported."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 198
    :cond_6
    invoke-static {}, Lcom/lifevibes/mediacoder/LVMediaCoderProperties;->getSupportedFrameRates()Ljava/util/ArrayList;

    move-result-object v0

    iget v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoFrameRate:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_7

    .line 199
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->videoFrameRate:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " frame-rate is not supported. Use LVMediaCoderProperties.getSupportedFrameRates() to get the list of supported frame-rates."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 201
    :cond_7
    invoke-static {}, Lcom/lifevibes/mediacoder/LVMediaCoderProperties;->getSupportedAudioBitrates()Ljava/util/ArrayList;

    move-result-object v0

    iget v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioBitRate:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_8

    .line 202
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioBitRate:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " audio bit-rate is not supported. Use LVMediaCoderProperties.getSupportedBitrates() to get the list of supported audio bit-rates."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 204
    :cond_8
    invoke-static {}, Lcom/lifevibes/mediacoder/LVMediaCoderProperties;->getSupportedChannelCounts()Ljava/util/ArrayList;

    move-result-object v0

    iget v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioChannelCount:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_9

    .line 205
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioChannelCount:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " audio channel count is not supported. Use LVMediaCoderProperties.getSupportedChannelCounts() to get the list of supported audio channel counts."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 207
    :cond_9
    invoke-static {}, Lcom/lifevibes/mediacoder/LVMediaCoderProperties;->getSupportedSampleRates()Ljava/util/ArrayList;

    move-result-object v0

    iget v1, p0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioSampleRate:I

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_a

    .line 208
    new-instance v0, Ljava/lang/IllegalArgumentException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget v2, p0, Lcom/lifevibes/mediacoder/LVMediaCoderConfiguration;->audioSampleRate:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " audio sample rate is not supported. Use LVMediaCoderProperties.getSupportedSampleRates()to get the list of supported audio sample rates."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 210
    :cond_a
    return-void
.end method
