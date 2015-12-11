.class Lcom/amazon/sdk/availability/FileStore$Iterator;
.super Ljava/lang/Object;
.source "FileStore.java"

# interfaces
.implements Lcom/amazon/sdk/availability/DataStoreIterator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/sdk/availability/FileStore;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Iterator"
.end annotation


# instance fields
.field private calledHasNext:Z

.field private currentFile:Ljava/io/File;

.field private currentIndex:I

.field private currentLineContents:Ljava/lang/String;

.field private final encryptionKeyState:Lcom/amazon/sdk/availability/EncryptionKeyState;

.field private final filesMarkedForDeletion:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/io/File;",
            ">;"
        }
    .end annotation
.end field

.field private final filter:Ljava/io/FilenameFilter;

.field private final measurementFiles:[Ljava/io/File;

.field private reader:Ljava/io/BufferedReader;


# direct methods
.method public constructor <init>(Ljava/io/File;JLcom/amazon/sdk/availability/EncryptionKeyState;)V
    .locals 1
    .param p1, "dataDirectory"    # Ljava/io/File;
    .param p2, "timeStamp"    # J
    .param p4, "encryptionKeyState"    # Lcom/amazon/sdk/availability/EncryptionKeyState;

    .prologue
    .line 330
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 331
    new-instance v0, Lcom/amazon/sdk/availability/FileStore$MeasureMentFilter;

    invoke-direct {v0, p2, p3}, Lcom/amazon/sdk/availability/FileStore$MeasureMentFilter;-><init>(J)V

    iput-object v0, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->filter:Ljava/io/FilenameFilter;

    .line 332
    iget-object v0, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->filter:Ljava/io/FilenameFilter;

    invoke-virtual {p1, v0}, Ljava/io/File;->listFiles(Ljava/io/FilenameFilter;)[Ljava/io/File;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->measurementFiles:[Ljava/io/File;

    .line 333
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->filesMarkedForDeletion:Ljava/util/List;

    .line 334
    iput-object p4, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->encryptionKeyState:Lcom/amazon/sdk/availability/EncryptionKeyState;

    .line 335
    const/4 v0, -0x1

    iput v0, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->currentIndex:I

    .line 336
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->calledHasNext:Z

    .line 337
    return-void
.end method

.method private filesAreLeft()Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 375
    iget-object v1, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->measurementFiles:[Ljava/io/File;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->measurementFiles:[Ljava/io/File;

    array-length v1, v1

    if-nez v1, :cond_1

    .line 379
    :cond_0
    :goto_0
    return v0

    :cond_1
    iget v1, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->currentIndex:I

    iget-object v2, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->measurementFiles:[Ljava/io/File;

    array-length v2, v2

    if-ge v1, v2, :cond_0

    const/4 v0, 0x1

    goto :goto_0
.end method

.method private getReader(Ljava/io/File;)Ljava/io/BufferedReader;
    .locals 5
    .param p1, "file"    # Ljava/io/File;

    .prologue
    .line 410
    if-nez p1, :cond_0

    .line 411
    const/4 v1, 0x0

    .line 415
    :goto_0
    return-object v1

    :cond_0
    :try_start_0
    new-instance v1, Ljava/io/BufferedReader;

    new-instance v2, Ljava/io/InputStreamReader;

    new-instance v3, Ljava/io/FileInputStream;

    iget-object v4, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->currentFile:Ljava/io/File;

    invoke-direct {v3, v4}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V

    invoke-direct {v2, v3}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v1, v2}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 416
    :catch_0
    move-exception v0

    .line 417
    .local v0, "ex":Ljava/io/IOException;
    new-instance v1, Lcom/amazon/sdk/availability/DataStoreException;

    invoke-direct {v1, v0}, Lcom/amazon/sdk/availability/DataStoreException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method


# virtual methods
.method public clear()V
    .locals 4

    .prologue
    .line 493
    iget-object v2, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->filesMarkedForDeletion:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_1

    .line 494
    iget-object v2, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->filesMarkedForDeletion:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/io/File;

    .line 495
    .local v0, "file":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    move-result v2

    if-nez v2, :cond_0

    .line 496
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "Could not delete file "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/sdk/availability/Logger;->w(Ljava/lang/String;)V

    goto :goto_0

    .line 500
    .end local v0    # "file":Ljava/io/File;
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_1
    return-void
.end method

.method public closeAfterUse()V
    .locals 1

    .prologue
    .line 504
    iget-object v0, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->reader:Ljava/io/BufferedReader;

    invoke-virtual {p0, v0}, Lcom/amazon/sdk/availability/FileStore$Iterator;->safelyClose(Ljava/io/Closeable;)V

    .line 505
    return-void
.end method

.method protected ensureReaderIsInitialized()V
    .locals 1

    .prologue
    .line 362
    iget-object v0, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->reader:Ljava/io/BufferedReader;

    if-nez v0, :cond_1

    .line 363
    iget-object v0, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->currentFile:Ljava/io/File;

    if-nez v0, :cond_0

    .line 364
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/FileStore$Iterator;->getNextFile()Ljava/io/File;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->currentFile:Ljava/io/File;

    .line 366
    :cond_0
    iget-object v0, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->currentFile:Ljava/io/File;

    invoke-direct {p0, v0}, Lcom/amazon/sdk/availability/FileStore$Iterator;->getReader(Ljava/io/File;)Ljava/io/BufferedReader;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->reader:Ljava/io/BufferedReader;

    .line 368
    :cond_1
    return-void
.end method

.method protected getNextFile()Ljava/io/File;
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 512
    iget-object v1, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->measurementFiles:[Ljava/io/File;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->measurementFiles:[Ljava/io/File;

    array-length v1, v1

    if-gtz v1, :cond_1

    .line 519
    :cond_0
    :goto_0
    return-object v0

    .line 515
    :cond_1
    iget v1, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->currentIndex:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->currentIndex:I

    .line 516
    iget v1, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->currentIndex:I

    iget-object v2, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->measurementFiles:[Ljava/io/File;

    array-length v2, v2

    if-ge v1, v2, :cond_0

    .line 517
    iget-object v0, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->measurementFiles:[Ljava/io/File;

    iget v1, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->currentIndex:I

    aget-object v0, v0, v1

    goto :goto_0
.end method

.method public hasNext()Z
    .locals 3

    .prologue
    const/4 v0, 0x1

    .line 341
    iput-boolean v0, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->calledHasNext:Z

    .line 342
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/FileStore$Iterator;->ensureReaderIsInitialized()V

    .line 343
    :goto_0
    invoke-direct {p0}, Lcom/amazon/sdk/availability/FileStore$Iterator;->filesAreLeft()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 344
    iget-object v1, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->reader:Ljava/io/BufferedReader;

    invoke-virtual {p0, v1}, Lcom/amazon/sdk/availability/FileStore$Iterator;->readNextLine(Ljava/io/BufferedReader;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 354
    :goto_1
    return v0

    .line 348
    :cond_0
    iget-object v1, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->filesMarkedForDeletion:Ljava/util/List;

    iget-object v2, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->currentFile:Ljava/io/File;

    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 349
    iget-object v1, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->reader:Ljava/io/BufferedReader;

    invoke-virtual {p0, v1}, Lcom/amazon/sdk/availability/FileStore$Iterator;->safelyClose(Ljava/io/Closeable;)V

    .line 351
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/FileStore$Iterator;->getNextFile()Ljava/io/File;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->currentFile:Ljava/io/File;

    .line 352
    iget-object v1, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->currentFile:Ljava/io/File;

    invoke-direct {p0, v1}, Lcom/amazon/sdk/availability/FileStore$Iterator;->getReader(Ljava/io/File;)Ljava/io/BufferedReader;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->reader:Ljava/io/BufferedReader;

    goto :goto_0

    .line 354
    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public next()Ljava/lang/Object;
    .locals 10

    .prologue
    .line 426
    iget-boolean v8, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->calledHasNext:Z

    if-nez v8, :cond_0

    .line 427
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/FileStore$Iterator;->hasNext()Z

    .line 430
    :cond_0
    const/4 v8, 0x0

    iput-boolean v8, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->calledHasNext:Z

    .line 432
    iget-object v8, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->currentLineContents:Ljava/lang/String;

    invoke-static {v8}, Lcom/amazon/sdk/availability/StringUtil;->isEmpty(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_3

    .line 434
    :try_start_0
    new-instance v4, Lorg/json/JSONObject;

    iget-object v8, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->currentLineContents:Ljava/lang/String;

    invoke-direct {v4, v8}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 435
    .local v4, "jobj":Lorg/json/JSONObject;
    const-string/jumbo v8, "timestamp"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->optLong(Ljava/lang/String;)J

    move-result-wide v6

    .line 436
    .local v6, "timeStamp":J
    const-string/jumbo v8, "content"

    invoke-virtual {v4, v8}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 438
    .local v0, "content":Ljava/lang/String;
    iget-object v8, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->encryptionKeyState:Lcom/amazon/sdk/availability/EncryptionKeyState;

    invoke-virtual {v8, v6, v7}, Lcom/amazon/sdk/availability/EncryptionKeyState;->getApplicableKeySpec(J)Lcom/amazon/sdk/availability/KeySpec;

    move-result-object v5

    .line 439
    .local v5, "keySpec":Lcom/amazon/sdk/availability/KeySpec;
    const/4 v3, 0x0

    .line 440
    .local v3, "encryptionManager":Lcom/amazon/sdk/availability/EncryptionManager;
    if-eqz v5, :cond_1

    .line 441
    invoke-virtual {v5}, Lcom/amazon/sdk/availability/KeySpec;->getEncryptionAlgorithm()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5}, Lcom/amazon/sdk/availability/KeySpec;->getKey()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Lcom/amazon/sdk/availability/EncryptionFactory;->getEncryptionManager(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/sdk/availability/EncryptionManager;

    move-result-object v3

    .line 444
    :cond_1
    if-eqz v3, :cond_2

    .line 446
    const/16 v8, 0xb

    invoke-static {v0, v8}, Landroid/util/Base64;->decode(Ljava/lang/String;I)[B

    move-result-object v2

    .line 448
    .local v2, "encryptedBlob":[B
    invoke-interface {v3, v2}, Lcom/amazon/sdk/availability/EncryptionManager;->decrypt([B)Ljava/lang/String;

    move-result-object v8

    .line 450
    .end local v2    # "encryptedBlob":[B
    :goto_0
    return-object v8

    :cond_2
    iget-object v8, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->currentLineContents:Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 452
    .end local v0    # "content":Ljava/lang/String;
    .end local v3    # "encryptionManager":Lcom/amazon/sdk/availability/EncryptionManager;
    .end local v4    # "jobj":Lorg/json/JSONObject;
    .end local v5    # "keySpec":Lcom/amazon/sdk/availability/KeySpec;
    .end local v6    # "timeStamp":J
    :catch_0
    move-exception v1

    .line 453
    .local v1, "e":Lorg/json/JSONException;
    new-instance v8, Lcom/amazon/sdk/availability/DataStoreException;

    invoke-direct {v8, v1}, Lcom/amazon/sdk/availability/DataStoreException;-><init>(Ljava/lang/Throwable;)V

    throw v8

    .line 457
    .end local v1    # "e":Lorg/json/JSONException;
    :cond_3
    new-instance v8, Ljava/util/NoSuchElementException;

    invoke-direct {v8}, Ljava/util/NoSuchElementException;-><init>()V

    throw v8
.end method

.method protected readNextLine(Ljava/io/BufferedReader;)Z
    .locals 3
    .param p1, "file"    # Ljava/io/BufferedReader;

    .prologue
    const/4 v1, 0x0

    .line 390
    if-nez p1, :cond_1

    .line 396
    :cond_0
    :goto_0
    return v1

    .line 395
    :cond_1
    :try_start_0
    invoke-virtual {p1}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->currentLineContents:Ljava/lang/String;

    .line 396
    iget-object v2, p0, Lcom/amazon/sdk/availability/FileStore$Iterator;->currentLineContents:Ljava/lang/String;

    invoke-static {v2}, Lcom/amazon/sdk/availability/StringUtil;->isEmpty(Ljava/lang/String;)Z
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    if-nez v2, :cond_0

    const/4 v1, 0x1

    goto :goto_0

    .line 397
    :catch_0
    move-exception v0

    .line 398
    .local v0, "ex":Ljava/io/IOException;
    new-instance v1, Lcom/amazon/sdk/availability/DataStoreException;

    invoke-direct {v1, v0}, Lcom/amazon/sdk/availability/DataStoreException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method

.method public remove()V
    .locals 1

    .prologue
    .line 480
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method

.method safelyClose(Ljava/io/Closeable;)V
    .locals 2
    .param p1, "c"    # Ljava/io/Closeable;

    .prologue
    .line 467
    if-eqz p1, :cond_0

    .line 468
    :try_start_0
    invoke-interface {p1}, Ljava/io/Closeable;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 473
    :cond_0
    return-void

    .line 470
    :catch_0
    move-exception v0

    .line 471
    .local v0, "e":Ljava/io/IOException;
    new-instance v1, Lcom/amazon/sdk/availability/DataStoreException;

    invoke-direct {v1, v0}, Lcom/amazon/sdk/availability/DataStoreException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method
