.class public Lcom/igexin/sdk/data/BasicDataManager;
.super Ljava/lang/Object;
.source "BasicDataManager.java"


# static fields
.field public static SDcardVersion:Ljava/lang/String;

.field private static final chars:[C

.field public static checkSDcardnumber:Ljava/lang/String;

.field private static dbHelper:Lcom/igexin/sdk/db/DBHelper;

.field private static deviceIdPath:Ljava/lang/String;

.field public static dirName:Ljava/lang/String;

.field public static internalBroadcastAccessToken:Ljava/lang/String;

.field public static lastBindAppTime:J

.field public static lastCidLists:Ljava/lang/String;

.field public static lastGetConfigTime:J

.field public static lastPhoneInfo:Ljava/lang/String;

.field public static phoneInfo:Lcom/igexin/sdk/data/PhoneInfo;

.field public static pushMessageMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/igexin/sdk/bean/PushMessageBean;",
            ">;"
        }
    .end annotation
.end field

.field public static regId:Ljava/lang/String;

.field public static vcid:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 46
    const-string/jumbo v0, ""

    sput-object v0, Lcom/igexin/sdk/data/BasicDataManager;->vcid:Ljava/lang/String;

    .line 64
    const-string/jumbo v0, "0"

    sput-object v0, Lcom/igexin/sdk/data/BasicDataManager;->checkSDcardnumber:Ljava/lang/String;

    .line 65
    const-string/jumbo v0, "v01"

    sput-object v0, Lcom/igexin/sdk/data/BasicDataManager;->SDcardVersion:Ljava/lang/String;

    .line 67
    const-string/jumbo v0, "/sdcard/libs/"

    sput-object v0, Lcom/igexin/sdk/data/BasicDataManager;->dirName:Ljava/lang/String;

    .line 68
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v1, Lcom/igexin/sdk/data/BasicDataManager;->dirName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "/com.igexin.sdk.deviceId.db"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/igexin/sdk/data/BasicDataManager;->deviceIdPath:Ljava/lang/String;

    .line 541
    const/16 v0, 0x3e

    new-array v0, v0, [C

    fill-array-data v0, :array_0

    sput-object v0, Lcom/igexin/sdk/data/BasicDataManager;->chars:[C

    return-void

    :array_0
    .array-data 2
        0x61s
        0x62s
        0x63s
        0x64s
        0x65s
        0x66s
        0x67s
        0x68s
        0x69s
        0x6as
        0x6bs
        0x6cs
        0x6ds
        0x6es
        0x6fs
        0x70s
        0x71s
        0x72s
        0x73s
        0x74s
        0x75s
        0x76s
        0x77s
        0x78s
        0x79s
        0x7as
        0x30s
        0x31s
        0x32s
        0x33s
        0x34s
        0x35s
        0x36s
        0x37s
        0x38s
        0x39s
        0x41s
        0x42s
        0x43s
        0x44s
        0x45s
        0x46s
        0x47s
        0x48s
        0x49s
        0x4as
        0x4bs
        0x4cs
        0x4ds
        0x4es
        0x4fs
        0x50s
        0x51s
        0x52s
        0x53s
        0x54s
        0x55s
        0x56s
        0x57s
        0x58s
        0x59s
        0x5as
    .end array-data
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 42
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static generateUUID(Landroid/content/Context;)Ljava/lang/String;
    .locals 8
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 119
    const-string/jumbo v5, "UUID"

    invoke-static {p0, v5}, Lcom/igexin/sdk/data/BasicDataManager;->getStringFromDataStore(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 120
    .local v3, "uuid":Ljava/lang/String;
    if-eqz v3, :cond_0

    const-string/jumbo v5, ""

    invoke-virtual {v5, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_0

    move-object v4, v3

    .line 131
    .end local v3    # "uuid":Ljava/lang/String;
    .local v4, "uuid":Ljava/lang/String;
    :goto_0
    return-object v4

    .line 124
    .end local v4    # "uuid":Ljava/lang/String;
    .restart local v3    # "uuid":Ljava/lang/String;
    :cond_0
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v5

    const-string/jumbo v6, "-"

    const-string/jumbo v7, ""

    invoke-virtual {v5, v6, v7}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    .line 125
    .local v2, "temp":Ljava/lang/String;
    new-instance v0, Ljava/util/Random;

    invoke-direct {v0}, Ljava/util/Random;-><init>()V

    .line 126
    .local v0, "rand":Ljava/util/Random;
    new-instance v5, Ljava/util/Date;

    invoke-direct {v5}, Ljava/util/Date;-><init>()V

    invoke-virtual {v5}, Ljava/util/Date;->getTime()J

    move-result-wide v5

    invoke-virtual {v0, v5, v6}, Ljava/util/Random;->setSeed(J)V

    .line 127
    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v5

    add-int/lit8 v5, v5, -0xf

    invoke-virtual {v0, v5}, Ljava/util/Random;->nextInt(I)I

    move-result v1

    .line 128
    .local v1, "start":I
    add-int/lit8 v5, v1, 0xf

    invoke-virtual {v2, v1, v5}, Ljava/lang/String;->subSequence(II)Ljava/lang/CharSequence;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v3

    .line 130
    const-string/jumbo v5, "UUID"

    invoke-static {p0, v5, v3}, Lcom/igexin/sdk/data/BasicDataManager;->putStringToDataStore(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    move-object v4, v3

    .line 131
    .end local v3    # "uuid":Ljava/lang/String;
    .restart local v4    # "uuid":Ljava/lang/String;
    goto :goto_0
.end method

.method public static getClientid(Ljava/lang/String;)Ljava/lang/String;
    .locals 12
    .param p0, "fileName"    # Ljava/lang/String;

    .prologue
    const/16 v11, 0x14

    const/4 v10, 0x7

    const/4 v9, 0x0

    .line 370
    const-wide/16 v1, 0x0

    .line 371
    .local v1, "session":J
    invoke-static {p0}, Lcom/igexin/sdk/data/BasicDataManager;->getSessionFromFile(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v6

    .line 372
    .local v6, "sessionTmp":Ljava/lang/String;
    if-eqz v6, :cond_2

    .line 373
    const/4 v5, 0x0

    .line 374
    .local v5, "sessionStr":Ljava/lang/String;
    const-string/jumbo v7, "null"

    invoke-virtual {v6, v7}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v7

    if-ltz v7, :cond_3

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v7

    if-lt v7, v10, :cond_3

    sget-object v7, Lcom/igexin/sdk/data/BasicDataManager;->checkSDcardnumber:Ljava/lang/String;

    invoke-virtual {v6, v9, v10}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 376
    invoke-virtual {v6, v10}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v5

    .line 382
    :cond_0
    :goto_0
    if-eqz v5, :cond_2

    .line 383
    const-string/jumbo v7, "|"

    invoke-virtual {v5, v7}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    .line 384
    .local v0, "seperator":I
    if-ltz v0, :cond_1

    .line 385
    invoke-virtual {v5, v9, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    .line 387
    :cond_1
    invoke-static {v5}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v3

    .line 388
    .local v3, "sessionFile":J
    const-wide/16 v7, 0x0

    cmp-long v7, v3, v7

    if-eqz v7, :cond_2

    .line 389
    move-wide v1, v3

    .line 393
    .end local v0    # "seperator":I
    .end local v3    # "sessionFile":J
    .end local v5    # "sessionStr":Ljava/lang/String;
    :cond_2
    invoke-static {v1, v2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/igexin/sdk/util/StringUtils;->getMD5Str(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    return-object v7

    .line 377
    .restart local v5    # "sessionStr":Ljava/lang/String;
    :cond_3
    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v7

    if-lt v7, v11, :cond_0

    sget-object v7, Lcom/igexin/sdk/data/BasicDataManager;->checkSDcardnumber:Ljava/lang/String;

    invoke-virtual {v6, v9, v11}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 379
    invoke-virtual {v6, v11}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v5

    goto :goto_0
.end method

.method public static getDeviceIdFromFile()Ljava/lang/String;
    .locals 13

    .prologue
    .line 211
    new-instance v8, Ljava/io/File;

    sget-object v12, Lcom/igexin/sdk/data/BasicDataManager;->dirName:Ljava/lang/String;

    invoke-direct {v8, v12}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 212
    .local v8, "f":Ljava/io/File;
    invoke-virtual {v8}, Ljava/io/File;->exists()Z

    move-result v12

    if-nez v12, :cond_1

    .line 213
    const-string/jumbo v4, ""

    .line 256
    :cond_0
    :goto_0
    return-object v4

    .line 215
    :cond_1
    new-instance v6, Ljava/io/File;

    sget-object v12, Lcom/igexin/sdk/data/BasicDataManager;->deviceIdPath:Ljava/lang/String;

    invoke-direct {v6, v12}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 216
    .local v6, "deviceidFile":Ljava/io/File;
    invoke-virtual {v6}, Ljava/io/File;->exists()Z

    move-result v12

    if-nez v12, :cond_2

    .line 217
    const-string/jumbo v4, ""

    goto :goto_0

    .line 220
    :cond_2
    const-string/jumbo v4, ""

    .line 221
    .local v4, "deviceId":Ljava/lang/String;
    const/4 v9, 0x0

    .line 222
    .local v9, "in":Ljava/io/FileInputStream;
    const/4 v0, 0x0

    .line 223
    .local v0, "baos":Ljava/io/ByteArrayOutputStream;
    const/16 v12, 0x400

    new-array v2, v12, [B

    .line 225
    .local v2, "buffer":[B
    :try_start_0
    new-instance v10, Ljava/io/FileInputStream;

    sget-object v12, Lcom/igexin/sdk/data/BasicDataManager;->deviceIdPath:Ljava/lang/String;

    invoke-direct {v10, v12}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_7
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 226
    .end local v9    # "in":Ljava/io/FileInputStream;
    .local v10, "in":Ljava/io/FileInputStream;
    :try_start_1
    new-instance v1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v1}, Ljava/io/ByteArrayOutputStream;-><init>()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_8
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 227
    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .local v1, "baos":Ljava/io/ByteArrayOutputStream;
    const/4 v11, -0x1

    .line 228
    .local v11, "len":I
    :goto_1
    :try_start_2
    invoke-virtual {v10, v2}, Ljava/io/FileInputStream;->read([B)I

    move-result v11

    const/4 v12, -0x1

    if-eq v11, v12, :cond_4

    .line 229
    const/4 v12, 0x0

    invoke-virtual {v1, v2, v12, v11}, Ljava/io/ByteArrayOutputStream;->write([BII)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    goto :goto_1

    .line 235
    :catch_0
    move-exception v7

    move-object v0, v1

    .end local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    move-object v9, v10

    .line 236
    .end local v10    # "in":Ljava/io/FileInputStream;
    .end local v11    # "len":I
    .local v7, "e":Ljava/lang/Exception;
    .restart local v9    # "in":Ljava/io/FileInputStream;
    :goto_2
    :try_start_3
    invoke-virtual {v7}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 239
    if-eqz v9, :cond_3

    .line 241
    :try_start_4
    invoke-virtual {v9}, Ljava/io/FileInputStream;->close()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_4

    .line 247
    :cond_3
    :goto_3
    if-eqz v0, :cond_0

    .line 249
    :try_start_5
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1

    goto :goto_0

    .line 250
    :catch_1
    move-exception v7

    .line 252
    invoke-virtual {v7}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 233
    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v7    # "e":Ljava/lang/Exception;
    .end local v9    # "in":Ljava/io/FileInputStream;
    .restart local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v10    # "in":Ljava/io/FileInputStream;
    .restart local v11    # "len":I
    :cond_4
    :try_start_6
    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v3

    .line 234
    .local v3, "bytes":[B
    new-instance v5, Ljava/lang/String;

    const-string/jumbo v12, "utf-8"

    invoke-direct {v5, v3, v12}, Ljava/lang/String;-><init>([BLjava/lang/String;)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_0
    .catchall {:try_start_6 .. :try_end_6} :catchall_2

    .line 239
    .end local v4    # "deviceId":Ljava/lang/String;
    .local v5, "deviceId":Ljava/lang/String;
    if-eqz v10, :cond_5

    .line 241
    :try_start_7
    invoke-virtual {v10}, Ljava/io/FileInputStream;->close()V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_2

    .line 247
    :cond_5
    :goto_4
    if-eqz v1, :cond_8

    .line 249
    :try_start_8
    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_3

    move-object v0, v1

    .end local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    move-object v9, v10

    .end local v10    # "in":Ljava/io/FileInputStream;
    .restart local v9    # "in":Ljava/io/FileInputStream;
    move-object v4, v5

    .line 253
    .end local v5    # "deviceId":Ljava/lang/String;
    .restart local v4    # "deviceId":Ljava/lang/String;
    goto :goto_0

    .line 242
    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v4    # "deviceId":Ljava/lang/String;
    .end local v9    # "in":Ljava/io/FileInputStream;
    .restart local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v5    # "deviceId":Ljava/lang/String;
    .restart local v10    # "in":Ljava/io/FileInputStream;
    :catch_2
    move-exception v7

    .line 244
    .restart local v7    # "e":Ljava/lang/Exception;
    invoke-virtual {v7}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_4

    .line 250
    .end local v7    # "e":Ljava/lang/Exception;
    :catch_3
    move-exception v7

    .line 252
    .restart local v7    # "e":Ljava/lang/Exception;
    invoke-virtual {v7}, Ljava/lang/Exception;->printStackTrace()V

    move-object v0, v1

    .end local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    move-object v9, v10

    .end local v10    # "in":Ljava/io/FileInputStream;
    .restart local v9    # "in":Ljava/io/FileInputStream;
    move-object v4, v5

    .line 253
    .end local v5    # "deviceId":Ljava/lang/String;
    .restart local v4    # "deviceId":Ljava/lang/String;
    goto :goto_0

    .line 242
    .end local v3    # "bytes":[B
    .end local v11    # "len":I
    :catch_4
    move-exception v7

    .line 244
    invoke-virtual {v7}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_3

    .line 239
    .end local v7    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v12

    :goto_5
    if-eqz v9, :cond_6

    .line 241
    :try_start_9
    invoke-virtual {v9}, Ljava/io/FileInputStream;->close()V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_5

    .line 247
    :cond_6
    :goto_6
    if-eqz v0, :cond_7

    .line 249
    :try_start_a
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_6

    .line 253
    :cond_7
    :goto_7
    throw v12

    .line 242
    :catch_5
    move-exception v7

    .line 244
    .restart local v7    # "e":Ljava/lang/Exception;
    invoke-virtual {v7}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_6

    .line 250
    .end local v7    # "e":Ljava/lang/Exception;
    :catch_6
    move-exception v7

    .line 252
    .restart local v7    # "e":Ljava/lang/Exception;
    invoke-virtual {v7}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_7

    .line 239
    .end local v7    # "e":Ljava/lang/Exception;
    .end local v9    # "in":Ljava/io/FileInputStream;
    .restart local v10    # "in":Ljava/io/FileInputStream;
    :catchall_1
    move-exception v12

    move-object v9, v10

    .end local v10    # "in":Ljava/io/FileInputStream;
    .restart local v9    # "in":Ljava/io/FileInputStream;
    goto :goto_5

    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v9    # "in":Ljava/io/FileInputStream;
    .restart local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v10    # "in":Ljava/io/FileInputStream;
    .restart local v11    # "len":I
    :catchall_2
    move-exception v12

    move-object v0, v1

    .end local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    move-object v9, v10

    .end local v10    # "in":Ljava/io/FileInputStream;
    .restart local v9    # "in":Ljava/io/FileInputStream;
    goto :goto_5

    .line 235
    .end local v11    # "len":I
    :catch_7
    move-exception v7

    goto :goto_2

    .end local v9    # "in":Ljava/io/FileInputStream;
    .restart local v10    # "in":Ljava/io/FileInputStream;
    :catch_8
    move-exception v7

    move-object v9, v10

    .end local v10    # "in":Ljava/io/FileInputStream;
    .restart local v9    # "in":Ljava/io/FileInputStream;
    goto :goto_2

    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v4    # "deviceId":Ljava/lang/String;
    .end local v9    # "in":Ljava/io/FileInputStream;
    .restart local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v3    # "bytes":[B
    .restart local v5    # "deviceId":Ljava/lang/String;
    .restart local v10    # "in":Ljava/io/FileInputStream;
    .restart local v11    # "len":I
    :cond_8
    move-object v0, v1

    .end local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    move-object v9, v10

    .end local v10    # "in":Ljava/io/FileInputStream;
    .restart local v9    # "in":Ljava/io/FileInputStream;
    move-object v4, v5

    .end local v5    # "deviceId":Ljava/lang/String;
    .restart local v4    # "deviceId":Ljava/lang/String;
    goto/16 :goto_0
.end method

.method private static getExtraConfigFileName()Ljava/lang/String;
    .locals 2

    .prologue
    .line 397
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "/data/data/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/igexin/sdk/SdkService;->pkgName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "/files/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Lcom/igexin/sdk/SdkService;->pkgName:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".properties"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static getLibsPath()Ljava/lang/String;
    .locals 4

    .prologue
    .line 278
    const/4 v0, 0x0

    .line 279
    .local v0, "libsDir":Ljava/lang/String;
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "mounted"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 280
    invoke-static {}, Landroid/os/Environment;->getExternalStorageDirectory()Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v1

    .line 281
    .local v1, "rootPath":Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "/libs/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 283
    .end local v1    # "rootPath":Ljava/lang/String;
    :cond_0
    return-object v0
.end method

.method public static getLocalMacAddress(Landroid/content/Context;)Ljava/lang/String;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 272
    const-string/jumbo v2, "wifi"

    invoke-virtual {p0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/wifi/WifiManager;

    .line 273
    .local v1, "wifi":Landroid/net/wifi/WifiManager;
    invoke-virtual {v1}, Landroid/net/wifi/WifiManager;->getConnectionInfo()Landroid/net/wifi/WifiInfo;

    move-result-object v0

    .line 274
    .local v0, "info":Landroid/net/wifi/WifiInfo;
    invoke-virtual {v0}, Landroid/net/wifi/WifiInfo;->getMacAddress()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method private static getMD5Key()Ljava/lang/String;
    .locals 2

    .prologue
    .line 148
    sget-object v1, Lcom/igexin/sdk/data/BasicDataManager;->phoneInfo:Lcom/igexin/sdk/data/PhoneInfo;

    invoke-virtual {v1}, Lcom/igexin/sdk/data/PhoneInfo;->getImei()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_0

    const-string/jumbo v0, "cantgetimei"

    .line 149
    .local v0, "key":Ljava/lang/String;
    :goto_0
    invoke-static {v0}, Lcom/igexin/sdk/util/StringUtils;->getMD5Str(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 148
    .end local v0    # "key":Ljava/lang/String;
    :cond_0
    sget-object v1, Lcom/igexin/sdk/data/BasicDataManager;->phoneInfo:Lcom/igexin/sdk/data/PhoneInfo;

    invoke-virtual {v1}, Lcom/igexin/sdk/data/PhoneInfo;->getImei()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private static getRandomString(I)Ljava/lang/String;
    .locals 5
    .param p0, "length"    # I

    .prologue
    .line 546
    if-gez p0, :cond_0

    .line 547
    const/16 p0, 0x64

    .line 548
    :cond_0
    const/16 v3, 0x64

    if-le p0, v3, :cond_1

    .line 549
    const/16 p0, 0xa

    .line 550
    :cond_1
    new-instance v1, Ljava/util/Random;

    invoke-direct {v1}, Ljava/util/Random;-><init>()V

    .line 551
    .local v1, "ran":Ljava/util/Random;
    new-array v2, p0, [C

    .line 552
    .local v2, "textChars":[C
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, p0, :cond_2

    .line 553
    sget-object v3, Lcom/igexin/sdk/data/BasicDataManager;->chars:[C

    sget-object v4, Lcom/igexin/sdk/data/BasicDataManager;->chars:[C

    array-length v4, v4

    invoke-virtual {v1, v4}, Ljava/util/Random;->nextInt(I)I

    move-result v4

    aget-char v3, v3, v4

    aput-char v3, v2, v0

    .line 552
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 555
    :cond_2
    new-instance v3, Ljava/lang/String;

    invoke-direct {v3, v2}, Ljava/lang/String;-><init>([C)V

    return-object v3
.end method

.method private static getSessionFromFile(Ljava/lang/String;)Ljava/lang/String;
    .locals 14
    .param p0, "fileName"    # Ljava/lang/String;

    .prologue
    .line 477
    const/4 v10, 0x0

    .line 478
    .local v10, "tmpsession":Ljava/lang/String;
    const/4 v5, 0x0

    .line 479
    .local v5, "in":Ljava/io/FileInputStream;
    const/4 v0, 0x0

    .line 480
    .local v0, "baos":Ljava/io/ByteArrayOutputStream;
    const/16 v12, 0x400

    new-array v2, v12, [B

    .line 482
    .local v2, "buffer":[B
    :try_start_0
    new-instance v6, Ljava/io/FileInputStream;

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/igexin/sdk/data/BasicDataManager;->getLibsPath()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-direct {v6, v12}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_7
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 483
    .end local v5    # "in":Ljava/io/FileInputStream;
    .local v6, "in":Ljava/io/FileInputStream;
    :try_start_1
    new-instance v1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v1}, Ljava/io/ByteArrayOutputStream;-><init>()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_8
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 484
    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .local v1, "baos":Ljava/io/ByteArrayOutputStream;
    const/4 v8, -0x1

    .line 485
    .local v8, "len":I
    :goto_0
    :try_start_2
    invoke-virtual {v6, v2}, Ljava/io/FileInputStream;->read([B)I

    move-result v8

    const/4 v12, -0x1

    if-eq v8, v12, :cond_2

    .line 486
    const/4 v12, 0x0

    invoke-virtual {v1, v2, v12, v8}, Ljava/io/ByteArrayOutputStream;->write([BII)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    goto :goto_0

    .line 495
    :catch_0
    move-exception v4

    move-object v0, v1

    .end local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    move-object v5, v6

    .line 499
    .end local v6    # "in":Ljava/io/FileInputStream;
    .end local v8    # "len":I
    .local v4, "e":Ljava/lang/Exception;
    .restart local v5    # "in":Ljava/io/FileInputStream;
    :goto_1
    if-eqz v5, :cond_0

    .line 501
    :try_start_3
    invoke-virtual {v5}, Ljava/io/FileInputStream;->close()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_3

    .line 507
    :cond_0
    :goto_2
    if-eqz v0, :cond_1

    .line 509
    :try_start_4
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_4

    :cond_1
    :goto_3
    move-object v11, v10

    .line 515
    .end local v4    # "e":Ljava/lang/Exception;
    .end local v10    # "tmpsession":Ljava/lang/String;
    .local v11, "tmpsession":Ljava/lang/String;
    :goto_4
    return-object v11

    .line 490
    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v5    # "in":Ljava/io/FileInputStream;
    .end local v11    # "tmpsession":Ljava/lang/String;
    .restart local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v6    # "in":Ljava/io/FileInputStream;
    .restart local v8    # "len":I
    .restart local v10    # "tmpsession":Ljava/lang/String;
    :cond_2
    :try_start_5
    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v3

    .line 491
    .local v3, "bytes":[B
    invoke-static {}, Lcom/igexin/sdk/data/BasicDataManager;->getMD5Key()Ljava/lang/String;

    move-result-object v7

    .line 492
    .local v7, "key":Ljava/lang/String;
    new-instance v9, Ljava/lang/String;

    invoke-static {v3, v7}, Lcom/igexin/sdk/encrypt/RC4Carder;->Dencrypt([BLjava/lang/String;)[B

    move-result-object v12

    invoke-direct {v9, v12}, Ljava/lang/String;-><init>([B)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_0
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    .line 494
    .local v9, "sessionReal":Ljava/lang/String;
    move-object v10, v9

    .line 499
    if-eqz v6, :cond_3

    .line 501
    :try_start_6
    invoke-virtual {v6}, Ljava/io/FileInputStream;->close()V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_1

    .line 507
    :cond_3
    :goto_5
    if-eqz v1, :cond_4

    .line 509
    :try_start_7
    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_2

    :cond_4
    :goto_6
    move-object v0, v1

    .end local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    move-object v5, v6

    .end local v6    # "in":Ljava/io/FileInputStream;
    .restart local v5    # "in":Ljava/io/FileInputStream;
    move-object v11, v10

    .line 515
    .end local v10    # "tmpsession":Ljava/lang/String;
    .restart local v11    # "tmpsession":Ljava/lang/String;
    goto :goto_4

    .line 502
    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v5    # "in":Ljava/io/FileInputStream;
    .end local v11    # "tmpsession":Ljava/lang/String;
    .restart local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v6    # "in":Ljava/io/FileInputStream;
    .restart local v10    # "tmpsession":Ljava/lang/String;
    :catch_1
    move-exception v4

    .line 504
    .restart local v4    # "e":Ljava/lang/Exception;
    invoke-virtual {v4}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_5

    .line 510
    .end local v4    # "e":Ljava/lang/Exception;
    :catch_2
    move-exception v4

    .line 512
    .restart local v4    # "e":Ljava/lang/Exception;
    invoke-virtual {v4}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_6

    .line 502
    .end local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v3    # "bytes":[B
    .end local v6    # "in":Ljava/io/FileInputStream;
    .end local v7    # "key":Ljava/lang/String;
    .end local v8    # "len":I
    .end local v9    # "sessionReal":Ljava/lang/String;
    .restart local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v5    # "in":Ljava/io/FileInputStream;
    :catch_3
    move-exception v4

    .line 504
    invoke-virtual {v4}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_2

    .line 510
    :catch_4
    move-exception v4

    .line 512
    invoke-virtual {v4}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_3

    .line 499
    .end local v4    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v12

    :goto_7
    if-eqz v5, :cond_5

    .line 501
    :try_start_8
    invoke-virtual {v5}, Ljava/io/FileInputStream;->close()V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_5

    .line 507
    :cond_5
    :goto_8
    if-eqz v0, :cond_6

    .line 509
    :try_start_9
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_6

    .line 513
    :cond_6
    :goto_9
    throw v12

    .line 502
    :catch_5
    move-exception v4

    .line 504
    .restart local v4    # "e":Ljava/lang/Exception;
    invoke-virtual {v4}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_8

    .line 510
    .end local v4    # "e":Ljava/lang/Exception;
    :catch_6
    move-exception v4

    .line 512
    .restart local v4    # "e":Ljava/lang/Exception;
    invoke-virtual {v4}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_9

    .line 499
    .end local v4    # "e":Ljava/lang/Exception;
    .end local v5    # "in":Ljava/io/FileInputStream;
    .restart local v6    # "in":Ljava/io/FileInputStream;
    :catchall_1
    move-exception v12

    move-object v5, v6

    .end local v6    # "in":Ljava/io/FileInputStream;
    .restart local v5    # "in":Ljava/io/FileInputStream;
    goto :goto_7

    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v5    # "in":Ljava/io/FileInputStream;
    .restart local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v6    # "in":Ljava/io/FileInputStream;
    .restart local v8    # "len":I
    :catchall_2
    move-exception v12

    move-object v0, v1

    .end local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    move-object v5, v6

    .end local v6    # "in":Ljava/io/FileInputStream;
    .restart local v5    # "in":Ljava/io/FileInputStream;
    goto :goto_7

    .line 495
    .end local v8    # "len":I
    :catch_7
    move-exception v4

    goto :goto_1

    .end local v5    # "in":Ljava/io/FileInputStream;
    .restart local v6    # "in":Ljava/io/FileInputStream;
    :catch_8
    move-exception v4

    move-object v5, v6

    .end local v6    # "in":Ljava/io/FileInputStream;
    .restart local v5    # "in":Ljava/io/FileInputStream;
    goto :goto_1
.end method

.method private static getStringFromDataStore(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 143
    const-string/jumbo v1, "GETUI_DATA_STORE"

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    .line 144
    .local v0, "preferences":Landroid/content/SharedPreferences;
    const/4 v1, 0x0

    invoke-interface {v0, p1, v1}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private static getVcidFromFile()Ljava/lang/String;
    .locals 16

    .prologue
    .line 321
    invoke-static {}, Lcom/igexin/sdk/data/BasicDataManager;->getLibsPath()Ljava/lang/String;

    move-result-object v9

    .line 322
    .local v9, "libsPath":Ljava/lang/String;
    if-nez v9, :cond_1

    .line 323
    const-string/jumbo v10, ""

    .line 366
    :cond_0
    :goto_0
    return-object v10

    .line 325
    :cond_1
    new-instance v14, Ljava/lang/StringBuilder;

    invoke-direct {v14}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v14, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    sget-object v15, Lcom/igexin/sdk/SdkService;->pkgName:Ljava/lang/String;

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    const-string/jumbo v15, ".slave.db"

    invoke-virtual {v14, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v13

    .line 326
    .local v13, "vcidPath":Ljava/lang/String;
    new-instance v12, Ljava/io/File;

    invoke-direct {v12, v13}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 327
    .local v12, "vcidFile":Ljava/io/File;
    invoke-virtual {v12}, Ljava/io/File;->exists()Z

    move-result v14

    if-nez v14, :cond_2

    .line 328
    const-string/jumbo v10, ""

    goto :goto_0

    .line 330
    :cond_2
    const/4 v0, 0x0

    .line 331
    .local v0, "baos":Ljava/io/ByteArrayOutputStream;
    const/4 v5, 0x0

    .line 332
    .local v5, "in":Ljava/io/FileInputStream;
    const-string/jumbo v10, ""

    .line 333
    .local v10, "vcid":Ljava/lang/String;
    const/16 v14, 0x400

    new-array v2, v14, [B

    .line 335
    .local v2, "buffer":[B
    :try_start_0
    new-instance v6, Ljava/io/FileInputStream;

    invoke-direct {v6, v13}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_7
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 336
    .end local v5    # "in":Ljava/io/FileInputStream;
    .local v6, "in":Ljava/io/FileInputStream;
    :try_start_1
    new-instance v1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v1}, Ljava/io/ByteArrayOutputStream;-><init>()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_8
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 337
    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .local v1, "baos":Ljava/io/ByteArrayOutputStream;
    const/4 v8, -0x1

    .line 338
    .local v8, "len":I
    :goto_1
    :try_start_2
    invoke-virtual {v6, v2}, Ljava/io/FileInputStream;->read([B)I

    move-result v8

    const/4 v14, -0x1

    if-eq v8, v14, :cond_4

    .line 339
    const/4 v14, 0x0

    invoke-virtual {v1, v2, v14, v8}, Ljava/io/ByteArrayOutputStream;->write([BII)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    goto :goto_1

    .line 347
    :catch_0
    move-exception v4

    move-object v5, v6

    .end local v6    # "in":Ljava/io/FileInputStream;
    .restart local v5    # "in":Ljava/io/FileInputStream;
    move-object v0, v1

    .line 348
    .end local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v8    # "len":I
    .restart local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .local v4, "e":Ljava/lang/Exception;
    :goto_2
    :try_start_3
    invoke-virtual {v4}, Ljava/lang/Exception;->printStackTrace()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 350
    if-eqz v5, :cond_3

    .line 352
    :try_start_4
    invoke-virtual {v5}, Ljava/io/FileInputStream;->close()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_4

    .line 358
    :cond_3
    :goto_3
    if-eqz v0, :cond_0

    .line 360
    :try_start_5
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1

    goto :goto_0

    .line 361
    :catch_1
    move-exception v4

    .line 363
    invoke-virtual {v4}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 343
    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v4    # "e":Ljava/lang/Exception;
    .end local v5    # "in":Ljava/io/FileInputStream;
    .restart local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v6    # "in":Ljava/io/FileInputStream;
    .restart local v8    # "len":I
    :cond_4
    :try_start_6
    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v3

    .line 344
    .local v3, "bytes":[B
    invoke-static {}, Lcom/igexin/sdk/data/BasicDataManager;->getMD5Key()Ljava/lang/String;

    move-result-object v7

    .line 345
    .local v7, "key":Ljava/lang/String;
    new-instance v11, Ljava/lang/String;

    invoke-static {v3, v7}, Lcom/igexin/sdk/encrypt/RC4Carder;->Dencrypt([BLjava/lang/String;)[B

    move-result-object v14

    invoke-direct {v11, v14}, Ljava/lang/String;-><init>([B)V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_0
    .catchall {:try_start_6 .. :try_end_6} :catchall_2

    .line 350
    .end local v10    # "vcid":Ljava/lang/String;
    .local v11, "vcid":Ljava/lang/String;
    if-eqz v6, :cond_5

    .line 352
    :try_start_7
    invoke-virtual {v6}, Ljava/io/FileInputStream;->close()V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_2

    .line 358
    :cond_5
    :goto_4
    if-eqz v1, :cond_8

    .line 360
    :try_start_8
    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_3

    move-object v10, v11

    .end local v11    # "vcid":Ljava/lang/String;
    .restart local v10    # "vcid":Ljava/lang/String;
    move-object v5, v6

    .end local v6    # "in":Ljava/io/FileInputStream;
    .restart local v5    # "in":Ljava/io/FileInputStream;
    move-object v0, v1

    .line 364
    .end local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    goto :goto_0

    .line 353
    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v5    # "in":Ljava/io/FileInputStream;
    .end local v10    # "vcid":Ljava/lang/String;
    .restart local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v6    # "in":Ljava/io/FileInputStream;
    .restart local v11    # "vcid":Ljava/lang/String;
    :catch_2
    move-exception v4

    .line 355
    .restart local v4    # "e":Ljava/lang/Exception;
    invoke-virtual {v4}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_4

    .line 361
    .end local v4    # "e":Ljava/lang/Exception;
    :catch_3
    move-exception v4

    .line 363
    .restart local v4    # "e":Ljava/lang/Exception;
    invoke-virtual {v4}, Ljava/lang/Exception;->printStackTrace()V

    move-object v10, v11

    .end local v11    # "vcid":Ljava/lang/String;
    .restart local v10    # "vcid":Ljava/lang/String;
    move-object v5, v6

    .end local v6    # "in":Ljava/io/FileInputStream;
    .restart local v5    # "in":Ljava/io/FileInputStream;
    move-object v0, v1

    .line 364
    .end local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    goto/16 :goto_0

    .line 353
    .end local v3    # "bytes":[B
    .end local v7    # "key":Ljava/lang/String;
    .end local v8    # "len":I
    :catch_4
    move-exception v4

    .line 355
    invoke-virtual {v4}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_3

    .line 350
    .end local v4    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v14

    :goto_5
    if-eqz v5, :cond_6

    .line 352
    :try_start_9
    invoke-virtual {v5}, Ljava/io/FileInputStream;->close()V
    :try_end_9
    .catch Ljava/lang/Exception; {:try_start_9 .. :try_end_9} :catch_5

    .line 358
    :cond_6
    :goto_6
    if-eqz v0, :cond_7

    .line 360
    :try_start_a
    invoke-virtual {v0}, Ljava/io/ByteArrayOutputStream;->close()V
    :try_end_a
    .catch Ljava/lang/Exception; {:try_start_a .. :try_end_a} :catch_6

    .line 364
    :cond_7
    :goto_7
    throw v14

    .line 353
    :catch_5
    move-exception v4

    .line 355
    .restart local v4    # "e":Ljava/lang/Exception;
    invoke-virtual {v4}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_6

    .line 361
    .end local v4    # "e":Ljava/lang/Exception;
    :catch_6
    move-exception v4

    .line 363
    .restart local v4    # "e":Ljava/lang/Exception;
    invoke-virtual {v4}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_7

    .line 350
    .end local v4    # "e":Ljava/lang/Exception;
    .end local v5    # "in":Ljava/io/FileInputStream;
    .restart local v6    # "in":Ljava/io/FileInputStream;
    :catchall_1
    move-exception v14

    move-object v5, v6

    .end local v6    # "in":Ljava/io/FileInputStream;
    .restart local v5    # "in":Ljava/io/FileInputStream;
    goto :goto_5

    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v5    # "in":Ljava/io/FileInputStream;
    .restart local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v6    # "in":Ljava/io/FileInputStream;
    .restart local v8    # "len":I
    :catchall_2
    move-exception v14

    move-object v5, v6

    .end local v6    # "in":Ljava/io/FileInputStream;
    .restart local v5    # "in":Ljava/io/FileInputStream;
    move-object v0, v1

    .end local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    goto :goto_5

    .line 347
    .end local v8    # "len":I
    :catch_7
    move-exception v4

    goto :goto_2

    .end local v5    # "in":Ljava/io/FileInputStream;
    .restart local v6    # "in":Ljava/io/FileInputStream;
    :catch_8
    move-exception v4

    move-object v5, v6

    .end local v6    # "in":Ljava/io/FileInputStream;
    .restart local v5    # "in":Ljava/io/FileInputStream;
    goto :goto_2

    .end local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    .end local v5    # "in":Ljava/io/FileInputStream;
    .end local v10    # "vcid":Ljava/lang/String;
    .restart local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v3    # "bytes":[B
    .restart local v6    # "in":Ljava/io/FileInputStream;
    .restart local v7    # "key":Ljava/lang/String;
    .restart local v8    # "len":I
    .restart local v11    # "vcid":Ljava/lang/String;
    :cond_8
    move-object v10, v11

    .end local v11    # "vcid":Ljava/lang/String;
    .restart local v10    # "vcid":Ljava/lang/String;
    move-object v5, v6

    .end local v6    # "in":Ljava/io/FileInputStream;
    .restart local v5    # "in":Ljava/io/FileInputStream;
    move-object v0, v1

    .end local v1    # "baos":Ljava/io/ByteArrayOutputStream;
    .restart local v0    # "baos":Ljava/io/ByteArrayOutputStream;
    goto/16 :goto_0
.end method

.method public static init(Landroid/content/Context;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 84
    const-string/jumbo v2, "phone"

    invoke-virtual {p0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/telephony/TelephonyManager;

    .line 86
    .local v1, "tm":Landroid/telephony/TelephonyManager;
    new-instance v2, Lcom/igexin/sdk/data/PhoneInfo;

    invoke-direct {v2}, Lcom/igexin/sdk/data/PhoneInfo;-><init>()V

    sput-object v2, Lcom/igexin/sdk/data/BasicDataManager;->phoneInfo:Lcom/igexin/sdk/data/PhoneInfo;

    .line 87
    sget-object v2, Lcom/igexin/sdk/data/BasicDataManager;->phoneInfo:Lcom/igexin/sdk/data/PhoneInfo;

    sget-object v3, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/igexin/sdk/data/PhoneInfo;->setModel(Ljava/lang/String;)V

    .line 88
    sget-object v2, Lcom/igexin/sdk/data/BasicDataManager;->phoneInfo:Lcom/igexin/sdk/data/PhoneInfo;

    const-string/jumbo v3, "v1.0.0"

    invoke-virtual {v2, v3}, Lcom/igexin/sdk/data/PhoneInfo;->setVersion(Ljava/lang/String;)V

    .line 89
    sget-object v2, Lcom/igexin/sdk/data/BasicDataManager;->phoneInfo:Lcom/igexin/sdk/data/PhoneInfo;

    sget-object v3, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual {v2, v3}, Lcom/igexin/sdk/data/PhoneInfo;->setSystem_version(Ljava/lang/String;)V

    .line 90
    sget-object v2, Lcom/igexin/sdk/data/BasicDataManager;->phoneInfo:Lcom/igexin/sdk/data/PhoneInfo;

    invoke-virtual {v1}, Landroid/telephony/TelephonyManager;->getDeviceId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/igexin/sdk/data/PhoneInfo;->setImei(Ljava/lang/String;)V

    .line 91
    sget-object v2, Lcom/igexin/sdk/data/BasicDataManager;->phoneInfo:Lcom/igexin/sdk/data/PhoneInfo;

    const-string/jumbo v3, "ANDROID"

    invoke-virtual {v2, v3}, Lcom/igexin/sdk/data/PhoneInfo;->setType(Ljava/lang/String;)V

    .line 92
    sget-object v2, Lcom/igexin/sdk/data/BasicDataManager;->phoneInfo:Lcom/igexin/sdk/data/PhoneInfo;

    invoke-static {}, Lcom/igexin/sdk/data/BasicDataManager;->getDeviceIdFromFile()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/igexin/sdk/data/PhoneInfo;->setDeviceid(Ljava/lang/String;)V

    .line 93
    sget-object v2, Lcom/igexin/sdk/data/BasicDataManager;->phoneInfo:Lcom/igexin/sdk/data/PhoneInfo;

    const-string/jumbo v3, "GW"

    invoke-virtual {v2, v3}, Lcom/igexin/sdk/data/PhoneInfo;->setChannelid(Ljava/lang/String;)V

    .line 94
    sget-object v2, Lcom/igexin/sdk/data/BasicDataManager;->phoneInfo:Lcom/igexin/sdk/data/PhoneInfo;

    invoke-static {p0}, Lcom/igexin/sdk/data/BasicDataManager;->generateUUID(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/igexin/sdk/data/PhoneInfo;->setUuid(Ljava/lang/String;)V

    .line 96
    const-string/jumbo v0, "00:00:00:00:00:00"

    .line 97
    .local v0, "phoneMac":Ljava/lang/String;
    invoke-static {p0}, Lcom/igexin/sdk/data/BasicDataManager;->getLocalMacAddress(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 98
    invoke-static {p0}, Lcom/igexin/sdk/data/BasicDataManager;->getLocalMacAddress(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 99
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/igexin/sdk/data/BasicDataManager;->SDcardVersion:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/igexin/sdk/data/BasicDataManager;->checkSDcardnumber:Ljava/lang/String;

    .line 101
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v2

    invoke-virtual {v2}, Lcom/igexin/sdk/SdkService;->getDBHelper()Lcom/igexin/sdk/db/DBHelper;

    move-result-object v2

    sput-object v2, Lcom/igexin/sdk/data/BasicDataManager;->dbHelper:Lcom/igexin/sdk/db/DBHelper;

    .line 103
    invoke-static {}, Lcom/igexin/sdk/data/BasicDataManager;->read()V

    .line 105
    const/16 v2, 0x20

    invoke-static {v2}, Lcom/igexin/sdk/data/BasicDataManager;->getRandomString(I)Ljava/lang/String;

    move-result-object v2

    sput-object v2, Lcom/igexin/sdk/data/BasicDataManager;->internalBroadcastAccessToken:Ljava/lang/String;

    .line 107
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    sput-object v2, Lcom/igexin/sdk/data/BasicDataManager;->pushMessageMap:Ljava/util/Map;

    .line 108
    return-void
.end method

.method public static loadConfigFile(Ljava/io/InputStream;)V
    .locals 9
    .param p0, "in"    # Ljava/io/InputStream;

    .prologue
    .line 448
    :try_start_0
    new-instance v4, Ljava/io/BufferedReader;

    new-instance v6, Ljava/io/InputStreamReader;

    const-string/jumbo v7, "UTF-8"

    invoke-direct {v6, p0, v7}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;Ljava/lang/String;)V

    invoke-direct {v4, v6}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 451
    .local v4, "reader":Ljava/io/BufferedReader;
    :cond_0
    :goto_0
    invoke-virtual {v4}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v2

    .local v2, "line":Ljava/lang/String;
    if-eqz v2, :cond_2

    .line 452
    const-string/jumbo v6, "#"

    invoke-virtual {v2, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 455
    const-string/jumbo v6, "="

    invoke-virtual {v2, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 457
    .local v3, "pair":[Ljava/lang/String;
    array-length v6, v3

    const/4 v7, 0x2

    if-lt v6, v7, :cond_0

    .line 460
    const/4 v6, 0x0

    aget-object v6, v3, v6

    invoke-virtual {v6}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 461
    .local v1, "key":Ljava/lang/String;
    const/4 v6, 0x1

    aget-object v6, v3, v6

    invoke-virtual {v6}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v5

    .line 463
    .local v5, "value":Ljava/lang/String;
    const-string/jumbo v6, "sdk.phone_service_address"

    invoke-virtual {v1, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 464
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    sget-object v7, Lcom/igexin/sdk/Consts;->PS_SUB_URL:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    sput-object v6, Lcom/igexin/sdk/Consts;->PS_URL:Ljava/lang/String;

    .line 465
    sget-object v6, Ljava/lang/System;->out:Ljava/io/PrintStream;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "final phone service address:"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    sget-object v8, Lcom/igexin/sdk/Consts;->PS_URL:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/io/PrintStream;->println(Ljava/lang/String;)V

    goto :goto_0

    .line 471
    .end local v1    # "key":Ljava/lang/String;
    .end local v2    # "line":Ljava/lang/String;
    .end local v3    # "pair":[Ljava/lang/String;
    .end local v4    # "reader":Ljava/io/BufferedReader;
    .end local v5    # "value":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 474
    :goto_1
    return-void

    .line 466
    .restart local v1    # "key":Ljava/lang/String;
    .restart local v2    # "line":Ljava/lang/String;
    .restart local v3    # "pair":[Ljava/lang/String;
    .restart local v4    # "reader":Ljava/io/BufferedReader;
    .restart local v5    # "value":Ljava/lang/String;
    :cond_1
    const-string/jumbo v6, "sdk.debug"

    invoke-virtual {v1, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    goto :goto_0

    .line 469
    .end local v1    # "key":Ljava/lang/String;
    .end local v3    # "pair":[Ljava/lang/String;
    .end local v5    # "value":Ljava/lang/String;
    :cond_2
    invoke-virtual {v4}, Ljava/io/BufferedReader;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1
.end method

.method public static loadConfigFromFile()V
    .locals 8

    .prologue
    .line 401
    new-instance v1, Ljava/io/File;

    invoke-static {}, Lcom/igexin/sdk/data/BasicDataManager;->getExtraConfigFileName()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v1, v6}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 402
    .local v1, "dataFile":Ljava/io/File;
    invoke-virtual {v1}, Ljava/io/File;->exists()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 403
    const/4 v4, 0x0

    .line 405
    .local v4, "in":Ljava/io/FileInputStream;
    :try_start_0
    new-instance v5, Ljava/io/FileInputStream;

    invoke-static {}, Lcom/igexin/sdk/data/BasicDataManager;->getExtraConfigFileName()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 407
    .end local v4    # "in":Ljava/io/FileInputStream;
    .local v5, "in":Ljava/io/FileInputStream;
    :try_start_1
    invoke-static {v5}, Lcom/igexin/sdk/data/BasicDataManager;->loadConfigFile(Ljava/io/InputStream;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_8
    .catchall {:try_start_1 .. :try_end_1} :catchall_2

    .line 412
    if-eqz v5, :cond_0

    .line 414
    :try_start_2
    invoke-virtual {v5}, Ljava/io/FileInputStream;->close()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    .line 443
    .end local v5    # "in":Ljava/io/FileInputStream;
    :cond_0
    :goto_0
    return-void

    .line 415
    .restart local v5    # "in":Ljava/io/FileInputStream;
    :catch_0
    move-exception v2

    .line 417
    .local v2, "e":Ljava/lang/Exception;
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 408
    .end local v2    # "e":Ljava/lang/Exception;
    .end local v5    # "in":Ljava/io/FileInputStream;
    .restart local v4    # "in":Ljava/io/FileInputStream;
    :catch_1
    move-exception v2

    .line 412
    .restart local v2    # "e":Ljava/lang/Exception;
    :goto_1
    if-eqz v4, :cond_0

    .line 414
    :try_start_3
    invoke-virtual {v4}, Ljava/io/FileInputStream;->close()V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_2

    goto :goto_0

    .line 415
    :catch_2
    move-exception v2

    .line 417
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 412
    .end local v2    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v6

    :goto_2
    if-eqz v4, :cond_1

    .line 414
    :try_start_4
    invoke-virtual {v4}, Ljava/io/FileInputStream;->close()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_3

    .line 418
    :cond_1
    :goto_3
    throw v6

    .line 415
    :catch_3
    move-exception v2

    .line 417
    .restart local v2    # "e":Ljava/lang/Exception;
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_3

    .line 422
    .end local v2    # "e":Ljava/lang/Exception;
    .end local v4    # "in":Ljava/io/FileInputStream;
    :cond_2
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v7, Lcom/igexin/sdk/SdkService;->pkgName:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, ".properties"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 423
    .local v3, "fileName":Ljava/lang/String;
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v6

    invoke-virtual {v6}, Lcom/igexin/sdk/SdkService;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/res/Resources;->getAssets()Landroid/content/res/AssetManager;

    move-result-object v0

    .line 424
    .local v0, "am":Landroid/content/res/AssetManager;
    const/4 v4, 0x0

    .line 426
    .local v4, "in":Ljava/io/InputStream;
    :try_start_5
    invoke-virtual {v0, v3}, Landroid/content/res/AssetManager;->open(Ljava/lang/String;)Ljava/io/InputStream;

    move-result-object v4

    .line 428
    invoke-static {v4}, Lcom/igexin/sdk/data/BasicDataManager;->loadConfigFile(Ljava/io/InputStream;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 432
    if-eqz v4, :cond_0

    .line 434
    :try_start_6
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_4

    goto :goto_0

    .line 435
    :catch_4
    move-exception v2

    .line 437
    .restart local v2    # "e":Ljava/lang/Exception;
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 429
    .end local v2    # "e":Ljava/lang/Exception;
    :catch_5
    move-exception v2

    .line 432
    .restart local v2    # "e":Ljava/lang/Exception;
    if-eqz v4, :cond_0

    .line 434
    :try_start_7
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_6

    goto :goto_0

    .line 435
    :catch_6
    move-exception v2

    .line 437
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 432
    .end local v2    # "e":Ljava/lang/Exception;
    :catchall_1
    move-exception v6

    if-eqz v4, :cond_3

    .line 434
    :try_start_8
    invoke-virtual {v4}, Ljava/io/InputStream;->close()V
    :try_end_8
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_7

    .line 438
    :cond_3
    :goto_4
    throw v6

    .line 435
    :catch_7
    move-exception v2

    .line 437
    .restart local v2    # "e":Ljava/lang/Exception;
    invoke-virtual {v2}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_4

    .line 412
    .end local v0    # "am":Landroid/content/res/AssetManager;
    .end local v2    # "e":Ljava/lang/Exception;
    .end local v3    # "fileName":Ljava/lang/String;
    .end local v4    # "in":Ljava/io/InputStream;
    .restart local v5    # "in":Ljava/io/FileInputStream;
    :catchall_2
    move-exception v6

    move-object v4, v5

    .end local v5    # "in":Ljava/io/FileInputStream;
    .local v4, "in":Ljava/io/FileInputStream;
    goto :goto_2

    .line 408
    .end local v4    # "in":Ljava/io/FileInputStream;
    .restart local v5    # "in":Ljava/io/FileInputStream;
    :catch_8
    move-exception v2

    move-object v4, v5

    .end local v5    # "in":Ljava/io/FileInputStream;
    .restart local v4    # "in":Ljava/io/FileInputStream;
    goto :goto_1
.end method

.method private static putStringToDataStore(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 136
    const-string/jumbo v2, "GETUI_DATA_STORE"

    const/4 v3, 0x0

    invoke-virtual {p0, v2, v3}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 137
    .local v1, "preferences":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 138
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v0, p1, p2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 139
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 140
    return-void
.end method

.method private static read()V
    .locals 10

    .prologue
    const/4 v7, 0x0

    .line 153
    sget-object v8, Lcom/igexin/sdk/data/BasicDataManager;->dbHelper:Lcom/igexin/sdk/db/DBHelper;

    invoke-virtual {v8}, Lcom/igexin/sdk/db/DBHelper;->getReadableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v8

    const-string/jumbo v9, "select id, value from runtime order by id"

    invoke-virtual {v8, v9, v7}, Landroid/database/sqlite/SQLiteDatabase;->rawQuery(Ljava/lang/String;[Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v1

    .line 154
    .local v1, "cursor":Landroid/database/Cursor;
    if-eqz v1, :cond_7

    .line 155
    :goto_0
    invoke-interface {v1}, Landroid/database/Cursor;->moveToNext()Z

    move-result v8

    if-eqz v8, :cond_6

    .line 156
    const/4 v2, 0x0

    .line 157
    .local v2, "i":I
    add-int/lit8 v3, v2, 0x1

    .end local v2    # "i":I
    .local v3, "i":I
    invoke-interface {v1, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v4

    .line 159
    .local v4, "id":I
    const/4 v6, 0x0

    .line 160
    .local v6, "value":Ljava/lang/String;
    const/4 v0, 0x0

    .line 162
    .local v0, "blob":[B
    const/4 v8, 0x1

    if-ne v4, v8, :cond_0

    .line 163
    add-int/lit8 v2, v3, 0x1

    .end local v3    # "i":I
    .restart local v2    # "i":I
    invoke-interface {v1, v3}, Landroid/database/Cursor;->getBlob(I)[B

    move-result-object v0

    .line 167
    :goto_1
    packed-switch v4, :pswitch_data_0

    goto :goto_0

    .line 170
    :pswitch_0
    invoke-static {}, Lcom/igexin/sdk/data/BasicDataManager;->getMD5Key()Ljava/lang/String;

    move-result-object v5

    .line 171
    .local v5, "key":Ljava/lang/String;
    new-instance v8, Ljava/lang/String;

    invoke-static {v0, v5}, Lcom/igexin/sdk/encrypt/RC4Carder;->Dencrypt([BLjava/lang/String;)[B

    move-result-object v9

    invoke-direct {v8, v9}, Ljava/lang/String;-><init>([B)V

    sput-object v8, Lcom/igexin/sdk/data/BasicDataManager;->vcid:Ljava/lang/String;

    goto :goto_0

    .line 165
    .end local v2    # "i":I
    .end local v5    # "key":Ljava/lang/String;
    .restart local v3    # "i":I
    :cond_0
    add-int/lit8 v2, v3, 0x1

    .end local v3    # "i":I
    .restart local v2    # "i":I
    invoke-interface {v1, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    goto :goto_1

    .line 174
    :pswitch_1
    const-string/jumbo v8, "null"

    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_1

    move-object v6, v7

    .end local v6    # "value":Ljava/lang/String;
    :cond_1
    sput-object v6, Lcom/igexin/sdk/data/BasicDataManager;->regId:Ljava/lang/String;

    goto :goto_0

    .line 177
    .restart local v6    # "value":Ljava/lang/String;
    :pswitch_2
    const-string/jumbo v8, "null"

    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_2

    const-string/jumbo v6, "0"

    .end local v6    # "value":Ljava/lang/String;
    :cond_2
    invoke-static {v6}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v8

    sput-wide v8, Lcom/igexin/sdk/data/BasicDataManager;->lastBindAppTime:J

    goto :goto_0

    .line 180
    .restart local v6    # "value":Ljava/lang/String;
    :pswitch_3
    const-string/jumbo v8, "null"

    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_3

    const-string/jumbo v6, "0"

    .end local v6    # "value":Ljava/lang/String;
    :cond_3
    invoke-static {v6}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v8

    sput-wide v8, Lcom/igexin/sdk/data/BasicDataManager;->lastGetConfigTime:J

    goto :goto_0

    .line 183
    .restart local v6    # "value":Ljava/lang/String;
    :pswitch_4
    const-string/jumbo v8, "null"

    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_4

    move-object v6, v7

    .end local v6    # "value":Ljava/lang/String;
    :cond_4
    sput-object v6, Lcom/igexin/sdk/data/BasicDataManager;->lastCidLists:Ljava/lang/String;

    goto :goto_0

    .line 186
    .restart local v6    # "value":Ljava/lang/String;
    :pswitch_5
    const-string/jumbo v8, "null"

    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_5

    move-object v6, v7

    .end local v6    # "value":Ljava/lang/String;
    :cond_5
    sput-object v6, Lcom/igexin/sdk/data/BasicDataManager;->lastPhoneInfo:Ljava/lang/String;

    goto :goto_0

    .line 190
    .end local v0    # "blob":[B
    .end local v2    # "i":I
    .end local v4    # "id":I
    :cond_6
    invoke-interface {v1}, Landroid/database/Cursor;->close()V

    .line 195
    :cond_7
    sget-object v7, Lcom/igexin/sdk/data/BasicDataManager;->regId:Ljava/lang/String;

    if-nez v7, :cond_8

    .line 196
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "A-"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    sget-object v8, Lcom/igexin/sdk/data/BasicDataManager;->phoneInfo:Lcom/igexin/sdk/data/PhoneInfo;

    invoke-virtual {v8}, Lcom/igexin/sdk/data/PhoneInfo;->getUuid()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string/jumbo v8, "-"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v8

    invoke-virtual {v7, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    sput-object v7, Lcom/igexin/sdk/data/BasicDataManager;->regId:Ljava/lang/String;

    .line 200
    :cond_8
    sget-object v7, Lcom/igexin/sdk/data/BasicDataManager;->vcid:Ljava/lang/String;

    const-string/jumbo v8, ""

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_9

    .line 201
    invoke-static {}, Lcom/igexin/sdk/data/BasicDataManager;->getVcidFromFile()Ljava/lang/String;

    move-result-object v7

    sput-object v7, Lcom/igexin/sdk/data/BasicDataManager;->vcid:Ljava/lang/String;

    .line 203
    :cond_9
    return-void

    .line 167
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_5
    .end packed-switch
.end method

.method public static saveVcidToFile(Ljava/lang/String;)V
    .locals 10
    .param p0, "vcid"    # Ljava/lang/String;

    .prologue
    .line 293
    invoke-static {}, Lcom/igexin/sdk/data/BasicDataManager;->getLibsPath()Ljava/lang/String;

    move-result-object v4

    .line 294
    .local v4, "libsPath":Ljava/lang/String;
    if-nez v4, :cond_0

    .line 318
    :goto_0
    return-void

    .line 297
    :cond_0
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    sget-object v9, Lcom/igexin/sdk/SdkService;->pkgName:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, ".slave.db"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 298
    .local v7, "vcidPath":Ljava/lang/String;
    new-instance v6, Ljava/io/File;

    invoke-direct {v6, v7}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 299
    .local v6, "vcidFile":Ljava/io/File;
    invoke-virtual {v6}, Ljava/io/File;->exists()Z

    move-result v8

    if-eqz v8, :cond_1

    .line 300
    invoke-virtual {v6}, Ljava/io/File;->delete()Z

    .line 303
    :cond_1
    :try_start_0
    invoke-virtual {v6}, Ljava/io/File;->createNewFile()Z

    .line 306
    invoke-virtual {p0}, Ljava/lang/String;->getBytes()[B

    move-result-object v0

    .line 307
    .local v0, "bytes":[B
    invoke-static {}, Lcom/igexin/sdk/data/BasicDataManager;->getMD5Key()Ljava/lang/String;

    move-result-object v3

    .line 309
    .local v3, "key":Ljava/lang/String;
    invoke-static {v0, v3}, Lcom/igexin/sdk/encrypt/RC4Carder;->Encrypt([BLjava/lang/String;)[B

    move-result-object v5

    .line 311
    .local v5, "vcidBytes":[B
    new-instance v2, Ljava/io/FileOutputStream;

    invoke-direct {v2, v6}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;)V

    .line 312
    .local v2, "fos":Ljava/io/FileOutputStream;
    invoke-virtual {v2, v5}, Ljava/io/FileOutputStream;->write([B)V

    .line 313
    invoke-virtual {v2}, Ljava/io/FileOutputStream;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 315
    .end local v0    # "bytes":[B
    .end local v2    # "fos":Ljava/io/FileOutputStream;
    .end local v3    # "key":Ljava/lang/String;
    .end local v5    # "vcidBytes":[B
    :catch_0
    move-exception v1

    .line 316
    .local v1, "e":Ljava/io/IOException;
    invoke-virtual {v1}, Ljava/io/IOException;->printStackTrace()V

    goto :goto_0
.end method

.method public static updateDBValue(ILjava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p0, "valueID"    # I
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 519
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 520
    .local v0, "values":Landroid/content/ContentValues;
    const-string/jumbo v1, "id"

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 521
    const-string/jumbo v1, "name"

    invoke-virtual {v0, v1, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 522
    const-string/jumbo v1, "value"

    invoke-virtual {v0, v1, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 523
    sget-object v1, Lcom/igexin/sdk/data/BasicDataManager;->dbHelper:Lcom/igexin/sdk/db/DBHelper;

    invoke-virtual {v1}, Lcom/igexin/sdk/db/DBHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    const-string/jumbo v2, "runtime"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3, v0}, Landroid/database/sqlite/SQLiteDatabase;->replace(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 524
    return-void
.end method

.method public static updateDBValue(ILjava/lang/String;[B)V
    .locals 4
    .param p0, "valueID"    # I
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "valueBytes"    # [B

    .prologue
    .line 527
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 528
    .local v0, "values":Landroid/content/ContentValues;
    const-string/jumbo v1, "id"

    invoke-static {p0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 529
    const-string/jumbo v1, "name"

    invoke-virtual {v0, v1, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 530
    const-string/jumbo v1, "value"

    invoke-virtual {v0, v1, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;[B)V

    .line 531
    sget-object v1, Lcom/igexin/sdk/data/BasicDataManager;->dbHelper:Lcom/igexin/sdk/db/DBHelper;

    invoke-virtual {v1}, Lcom/igexin/sdk/db/DBHelper;->getWritableDatabase()Landroid/database/sqlite/SQLiteDatabase;

    move-result-object v1

    const-string/jumbo v2, "runtime"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3, v0}, Landroid/database/sqlite/SQLiteDatabase;->replace(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J

    .line 532
    return-void
.end method

.method public static updateVcidValue(ILjava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p0, "valueID"    # I
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "vcid"    # Ljava/lang/String;

    .prologue
    .line 535
    invoke-static {}, Lcom/igexin/sdk/data/BasicDataManager;->getMD5Key()Ljava/lang/String;

    move-result-object v0

    .line 536
    .local v0, "key":Ljava/lang/String;
    invoke-virtual {p2}, Ljava/lang/String;->getBytes()[B

    move-result-object v2

    invoke-static {v2, v0}, Lcom/igexin/sdk/encrypt/RC4Carder;->Encrypt([BLjava/lang/String;)[B

    move-result-object v1

    .line 538
    .local v1, "vcidDB":[B
    invoke-static {p0, p1, v1}, Lcom/igexin/sdk/data/BasicDataManager;->updateDBValue(ILjava/lang/String;[B)V

    .line 539
    return-void
.end method
