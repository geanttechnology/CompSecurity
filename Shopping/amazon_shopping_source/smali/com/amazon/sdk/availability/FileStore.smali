.class public Lcom/amazon/sdk/availability/FileStore;
.super Ljava/lang/Object;
.source "FileStore.java"

# interfaces
.implements Lcom/amazon/sdk/availability/DataStore;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/sdk/availability/FileStore$MeasureMentFilter;,
        Lcom/amazon/sdk/availability/FileStore$Iterator;
    }
.end annotation


# static fields
.field private static final PATTERN:Ljava/util/regex/Pattern;


# instance fields
.field private final clientId:Ljava/lang/String;

.field private context:Landroid/content/Context;

.field private encryptionKeyState:Lcom/amazon/sdk/availability/EncryptionKeyState;

.field private encryptionManager:Lcom/amazon/sdk/availability/EncryptionManager;

.field private file:Ljava/io/File;

.field private isOpen:Z

.field private final localStorageMaxRollOver:Ljava/lang/Long;

.field private final localStorageMaxRollOverSize:Ljava/lang/Long;

.field private out:Ljava/io/OutputStream;

.field private preferences:Lcom/amazon/sdk/availability/Preferences;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 39
    const-string/jumbo v0, "availability_measurements_(.*)\\.measure"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/amazon/sdk/availability/FileStore;->PATTERN:Ljava/util/regex/Pattern;

    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/Long;Ljava/lang/Long;)V
    .locals 2
    .param p1, "clientId"    # Ljava/lang/String;
    .param p2, "localStorageMaxRollOver"    # Ljava/lang/Long;
    .param p3, "localStorageMaxRollOverSize"    # Ljava/lang/Long;

    .prologue
    .line 94
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 95
    invoke-static {p1}, Lcom/amazon/sdk/availability/StringUtil;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 96
    new-instance v0, Lcom/amazon/sdk/availability/DataStoreException;

    const-string/jumbo v1, "\'clientId\' cannot be null/empty"

    invoke-direct {v0, v1}, Lcom/amazon/sdk/availability/DataStoreException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 98
    :cond_0
    iput-object p1, p0, Lcom/amazon/sdk/availability/FileStore;->clientId:Ljava/lang/String;

    .line 99
    iput-object p2, p0, Lcom/amazon/sdk/availability/FileStore;->localStorageMaxRollOver:Ljava/lang/Long;

    .line 100
    iput-object p3, p0, Lcom/amazon/sdk/availability/FileStore;->localStorageMaxRollOverSize:Ljava/lang/Long;

    .line 101
    return-void
.end method

.method static synthetic access$000()Ljava/util/regex/Pattern;
    .locals 1

    .prologue
    .line 31
    sget-object v0, Lcom/amazon/sdk/availability/FileStore;->PATTERN:Ljava/util/regex/Pattern;

    return-object v0
.end method

.method private initFileStore()V
    .locals 5

    .prologue
    .line 164
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/FileStore;->lastFile()Ljava/io/File;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/sdk/availability/FileStore;->file:Ljava/io/File;

    .line 165
    new-instance v1, Ljava/io/BufferedOutputStream;

    new-instance v2, Ljava/io/FileOutputStream;

    iget-object v3, p0, Lcom/amazon/sdk/availability/FileStore;->file:Ljava/io/File;

    const/4 v4, 0x1

    invoke-direct {v2, v3, v4}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;Z)V

    const v3, 0x8000

    invoke-direct {v1, v2, v3}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;I)V

    iput-object v1, p0, Lcom/amazon/sdk/availability/FileStore;->out:Ljava/io/OutputStream;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 173
    return-void

    .line 166
    :catch_0
    move-exception v0

    .line 167
    .local v0, "e":Ljava/lang/Exception;
    instance-of v1, v0, Lcom/amazon/sdk/availability/DataStoreException;

    if-eqz v1, :cond_0

    .line 168
    check-cast v0, Lcom/amazon/sdk/availability/DataStoreException;

    .end local v0    # "e":Ljava/lang/Exception;
    throw v0

    .line 170
    .restart local v0    # "e":Ljava/lang/Exception;
    :cond_0
    new-instance v1, Lcom/amazon/sdk/availability/DataStoreException;

    invoke-direct {v1, v0}, Lcom/amazon/sdk/availability/DataStoreException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method


# virtual methods
.method public close()V
    .locals 5

    .prologue
    .line 272
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/FileStore;->closeCurrentStream()V

    .line 274
    iget-object v0, p0, Lcom/amazon/sdk/availability/FileStore;->file:Ljava/io/File;

    if-eqz v0, :cond_0

    .line 275
    iget-object v0, p0, Lcom/amazon/sdk/availability/FileStore;->preferences:Lcom/amazon/sdk/availability/Preferences;

    const-string/jumbo v1, "last-file-used"

    iget-object v2, p0, Lcom/amazon/sdk/availability/FileStore;->file:Ljava/io/File;

    invoke-virtual {v2}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/amazon/sdk/availability/Preferences;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 278
    :cond_0
    iget-object v0, p0, Lcom/amazon/sdk/availability/FileStore;->encryptionKeyState:Lcom/amazon/sdk/availability/EncryptionKeyState;

    if-eqz v0, :cond_1

    .line 279
    iget-object v0, p0, Lcom/amazon/sdk/availability/FileStore;->preferences:Lcom/amazon/sdk/availability/Preferences;

    const-string/jumbo v1, "%s-encryption-key-state"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/amazon/sdk/availability/FileStore;->clientId:Ljava/lang/String;

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/sdk/availability/FileStore;->encryptionKeyState:Lcom/amazon/sdk/availability/EncryptionKeyState;

    invoke-virtual {v2}, Lcom/amazon/sdk/availability/EncryptionKeyState;->toJSON()Lorg/json/JSONObject;

    move-result-object v2

    invoke-virtual {v2}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/amazon/sdk/availability/Preferences;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 283
    :cond_1
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/sdk/availability/FileStore;->context:Landroid/content/Context;

    .line 284
    return-void
.end method

.method protected closeCurrentStream()V
    .locals 2

    .prologue
    .line 626
    iget-object v1, p0, Lcom/amazon/sdk/availability/FileStore;->out:Ljava/io/OutputStream;

    if-eqz v1, :cond_0

    .line 628
    :try_start_0
    iget-object v1, p0, Lcom/amazon/sdk/availability/FileStore;->out:Ljava/io/OutputStream;

    invoke-virtual {v1}, Ljava/io/OutputStream;->flush()V

    .line 629
    iget-object v1, p0, Lcom/amazon/sdk/availability/FileStore;->out:Ljava/io/OutputStream;

    invoke-virtual {v1}, Ljava/io/OutputStream;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 634
    :cond_0
    :goto_0
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/amazon/sdk/availability/FileStore;->out:Ljava/io/OutputStream;

    .line 635
    return-void

    .line 630
    :catch_0
    move-exception v0

    .line 631
    .local v0, "e":Ljava/lang/Exception;
    const-string/jumbo v1, "error closing output stream"

    invoke-static {v1, v0}, Lcom/amazon/sdk/availability/Logger;->w(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public getDataDirectory()Ljava/io/File;
    .locals 3

    .prologue
    .line 108
    iget-object v0, p0, Lcom/amazon/sdk/availability/FileStore;->context:Landroid/content/Context;

    iget-object v1, p0, Lcom/amazon/sdk/availability/FileStore;->clientId:Ljava/lang/String;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Context;->getDir(Ljava/lang/String;I)Ljava/io/File;

    move-result-object v0

    return-object v0
.end method

.method protected getLastUsedFile()Ljava/lang/String;
    .locals 7

    .prologue
    .line 642
    iget-object v0, p0, Lcom/amazon/sdk/availability/FileStore;->preferences:Lcom/amazon/sdk/availability/Preferences;

    const-string/jumbo v1, "last-file-used"

    const-string/jumbo v2, "availability_measurements_%s.measure"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/amazon/sdk/availability/Preferences;->get(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getMeasurementsAfter(J)Lcom/amazon/sdk/availability/DataStoreIterator;
    .locals 3
    .param p1, "timeStamp"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J)",
            "Lcom/amazon/sdk/availability/DataStoreIterator",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 261
    iget-object v0, p0, Lcom/amazon/sdk/availability/FileStore;->encryptionKeyState:Lcom/amazon/sdk/availability/EncryptionKeyState;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/sdk/availability/EncryptionKeyState;->clearKeySpecsBefore(J)V

    .line 262
    new-instance v0, Lcom/amazon/sdk/availability/FileStore$Iterator;

    invoke-virtual {p0}, Lcom/amazon/sdk/availability/FileStore;->getDataDirectory()Ljava/io/File;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/sdk/availability/FileStore;->encryptionKeyState:Lcom/amazon/sdk/availability/EncryptionKeyState;

    invoke-direct {v0, v1, p1, p2, v2}, Lcom/amazon/sdk/availability/FileStore$Iterator;-><init>(Ljava/io/File;JLcom/amazon/sdk/availability/EncryptionKeyState;)V

    return-object v0
.end method

.method protected getRollOverCount()I
    .locals 5

    .prologue
    .line 612
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/FileStore;->getDataDirectory()Ljava/io/File;

    move-result-object v0

    .line 614
    .local v0, "dataDirectory":Ljava/io/File;
    new-instance v2, Lcom/amazon/sdk/availability/FileStore$MeasureMentFilter;

    const-wide/16 v3, 0x0

    invoke-direct {v2, v3, v4}, Lcom/amazon/sdk/availability/FileStore$MeasureMentFilter;-><init>(J)V

    .line 615
    .local v2, "measurementFilter":Lcom/amazon/sdk/availability/FileStore$MeasureMentFilter;
    invoke-virtual {v0, v2}, Ljava/io/File;->listFiles(Ljava/io/FilenameFilter;)[Ljava/io/File;

    move-result-object v1

    .line 616
    .local v1, "files":[Ljava/io/File;
    if-nez v1, :cond_0

    .line 617
    const/4 v3, 0x0

    .line 619
    :goto_0
    return v3

    :cond_0
    array-length v3, v1

    goto :goto_0
.end method

.method protected lastFile()Ljava/io/File;
    .locals 3

    .prologue
    .line 650
    new-instance v0, Ljava/io/File;

    invoke-virtual {p0}, Lcom/amazon/sdk/availability/FileStore;->getDataDirectory()Ljava/io/File;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/sdk/availability/FileStore;->getLastUsedFile()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    .line 651
    .local v0, "lastUsed":Ljava/io/File;
    return-object v0
.end method

.method public open(Landroid/content/Context;Lcom/amazon/sdk/availability/EncryptionManager;)V
    .locals 13
    .param p1, "ctx"    # Landroid/content/Context;
    .param p2, "manager"    # Lcom/amazon/sdk/availability/EncryptionManager;

    .prologue
    .line 117
    const-class v8, Lcom/amazon/sdk/availability/FileStore;

    const-string/jumbo v9, "open"

    invoke-static {v8, v9}, Lcom/amazon/profiling/Profiler;->methodScopeStart(Ljava/lang/Class;Ljava/lang/String;)Lcom/amazon/profiling/ProfilerScope;

    move-result-object v6

    .line 119
    .local v6, "methodScope":Lcom/amazon/profiling/ProfilerScope;
    if-nez p1, :cond_0

    .line 120
    :try_start_0
    new-instance v8, Lcom/amazon/sdk/availability/DataStoreException;

    const-string/jumbo v9, "\'context\' is null"

    invoke-direct {v8, v9}, Lcom/amazon/sdk/availability/DataStoreException;-><init>(Ljava/lang/String;)V

    throw v8
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 155
    :catchall_0
    move-exception v8

    invoke-static {v6}, Lcom/amazon/profiling/Profiler;->scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V

    throw v8

    .line 122
    :cond_0
    const/4 v8, 0x1

    :try_start_1
    iput-boolean v8, p0, Lcom/amazon/sdk/availability/FileStore;->isOpen:Z

    .line 123
    iput-object p1, p0, Lcom/amazon/sdk/availability/FileStore;->context:Landroid/content/Context;

    .line 124
    new-instance v8, Lcom/amazon/sdk/availability/Preferences;

    iget-object v9, p0, Lcom/amazon/sdk/availability/FileStore;->context:Landroid/content/Context;

    invoke-direct {v8, v9}, Lcom/amazon/sdk/availability/Preferences;-><init>(Landroid/content/Context;)V

    iput-object v8, p0, Lcom/amazon/sdk/availability/FileStore;->preferences:Lcom/amazon/sdk/availability/Preferences;

    .line 125
    iget-object v8, p0, Lcom/amazon/sdk/availability/FileStore;->preferences:Lcom/amazon/sdk/availability/Preferences;

    const-string/jumbo v9, "%s-encryption-key-state"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    iget-object v12, p0, Lcom/amazon/sdk/availability/FileStore;->clientId:Ljava/lang/String;

    aput-object v12, v10, v11

    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    const/4 v10, 0x0

    invoke-virtual {v8, v9, v10}, Lcom/amazon/sdk/availability/Preferences;->get(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 126
    .local v5, "keyState":Ljava/lang/String;
    invoke-static {v5}, Lcom/amazon/sdk/availability/StringUtil;->isEmpty(Ljava/lang/String;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v8

    if-nez v8, :cond_2

    .line 128
    :try_start_2
    new-instance v8, Lorg/json/JSONObject;

    invoke-direct {v8, v5}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    invoke-static {v8}, Lcom/amazon/sdk/availability/EncryptionKeyState;->fromJSON(Lorg/json/JSONObject;)Lcom/amazon/sdk/availability/EncryptionKeyState;

    move-result-object v8

    iput-object v8, p0, Lcom/amazon/sdk/availability/FileStore;->encryptionKeyState:Lcom/amazon/sdk/availability/EncryptionKeyState;
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 136
    :goto_0
    if-eqz p2, :cond_4

    .line 138
    :try_start_3
    new-instance v7, Lcom/amazon/sdk/availability/KeySpec;

    invoke-interface {p2}, Lcom/amazon/sdk/availability/EncryptionManager;->getKey()Ljava/lang/String;

    move-result-object v8

    invoke-interface {p2}, Lcom/amazon/sdk/availability/EncryptionManager;->getEncryptionAlgorithm()Ljava/lang/String;

    move-result-object v9

    const-wide/16 v10, 0x0

    invoke-direct {v7, v8, v9, v10, v11}, Lcom/amazon/sdk/availability/KeySpec;-><init>(Ljava/lang/String;Ljava/lang/String;J)V

    .line 140
    .local v7, "potentialKeySpec":Lcom/amazon/sdk/availability/KeySpec;
    iget-object v8, p0, Lcom/amazon/sdk/availability/FileStore;->encryptionKeyState:Lcom/amazon/sdk/availability/EncryptionKeyState;

    invoke-virtual {v8}, Lcom/amazon/sdk/availability/EncryptionKeyState;->getState()Ljava/util/List;

    move-result-object v4

    .line 141
    .local v4, "keySpecs":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/sdk/availability/KeySpec;>;"
    const/4 v1, 0x0

    .line 142
    .local v1, "exists":Z
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/sdk/availability/KeySpec;

    .line 143
    .local v3, "keySpec":Lcom/amazon/sdk/availability/KeySpec;
    invoke-virtual {v3, v7}, Lcom/amazon/sdk/availability/KeySpec;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 144
    const/4 v1, 0x1

    goto :goto_1

    .line 129
    .end local v1    # "exists":Z
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "keySpec":Lcom/amazon/sdk/availability/KeySpec;
    .end local v4    # "keySpecs":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/sdk/availability/KeySpec;>;"
    .end local v7    # "potentialKeySpec":Lcom/amazon/sdk/availability/KeySpec;
    :catch_0
    move-exception v0

    .line 131
    .local v0, "e":Lorg/json/JSONException;
    new-instance v8, Lcom/amazon/sdk/availability/EncryptionKeyState;

    invoke-direct {v8}, Lcom/amazon/sdk/availability/EncryptionKeyState;-><init>()V

    iput-object v8, p0, Lcom/amazon/sdk/availability/FileStore;->encryptionKeyState:Lcom/amazon/sdk/availability/EncryptionKeyState;

    goto :goto_0

    .line 134
    .end local v0    # "e":Lorg/json/JSONException;
    :cond_2
    new-instance v8, Lcom/amazon/sdk/availability/EncryptionKeyState;

    invoke-direct {v8}, Lcom/amazon/sdk/availability/EncryptionKeyState;-><init>()V

    iput-object v8, p0, Lcom/amazon/sdk/availability/FileStore;->encryptionKeyState:Lcom/amazon/sdk/availability/EncryptionKeyState;

    goto :goto_0

    .line 147
    .restart local v1    # "exists":Z
    .restart local v2    # "i$":Ljava/util/Iterator;
    .restart local v4    # "keySpecs":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/sdk/availability/KeySpec;>;"
    .restart local v7    # "potentialKeySpec":Lcom/amazon/sdk/availability/KeySpec;
    :cond_3
    if-nez v1, :cond_4

    .line 148
    iget-object v8, p0, Lcom/amazon/sdk/availability/FileStore;->encryptionKeyState:Lcom/amazon/sdk/availability/EncryptionKeyState;

    invoke-virtual {v8, v7}, Lcom/amazon/sdk/availability/EncryptionKeyState;->addKeySpec(Lcom/amazon/sdk/availability/KeySpec;)V

    .line 152
    .end local v1    # "exists":Z
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v4    # "keySpecs":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/sdk/availability/KeySpec;>;"
    .end local v7    # "potentialKeySpec":Lcom/amazon/sdk/availability/KeySpec;
    :cond_4
    iput-object p2, p0, Lcom/amazon/sdk/availability/FileStore;->encryptionManager:Lcom/amazon/sdk/availability/EncryptionManager;

    .line 153
    invoke-direct {p0}, Lcom/amazon/sdk/availability/FileStore;->initFileStore()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 155
    invoke-static {v6}, Lcom/amazon/profiling/Profiler;->scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V

    .line 157
    return-void
.end method

.method public put(Lorg/json/JSONObject;)Z
    .locals 14
    .param p1, "jobj"    # Lorg/json/JSONObject;

    .prologue
    .line 182
    const-class v8, Lcom/amazon/sdk/availability/FileStore;

    const-string/jumbo v9, "put"

    invoke-static {v8, v9}, Lcom/amazon/profiling/Profiler;->methodScopeStart(Ljava/lang/Class;Ljava/lang/String;)Lcom/amazon/profiling/ProfilerScope;

    move-result-object v5

    .line 185
    .local v5, "methodScope":Lcom/amazon/profiling/ProfilerScope;
    if-nez p1, :cond_0

    .line 186
    :try_start_0
    new-instance v8, Lcom/amazon/sdk/availability/DataStoreException;

    const-string/jumbo v9, "\'json\' cannot be null"

    invoke-direct {v8, v9}, Lcom/amazon/sdk/availability/DataStoreException;-><init>(Ljava/lang/String;)V

    throw v8
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 249
    :catchall_0
    move-exception v8

    invoke-static {v5}, Lcom/amazon/profiling/Profiler;->scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V

    throw v8

    .line 190
    :cond_0
    :try_start_1
    iget-boolean v8, p0, Lcom/amazon/sdk/availability/FileStore;->isOpen:Z

    if-nez v8, :cond_1

    .line 191
    new-instance v8, Lcom/amazon/sdk/availability/DataStoreException;

    const-string/jumbo v9, "must call open() before calling put()"

    invoke-direct {v8, v9}, Lcom/amazon/sdk/availability/DataStoreException;-><init>(Ljava/lang/String;)V

    throw v8

    .line 194
    :cond_1
    iget-object v8, p0, Lcom/amazon/sdk/availability/FileStore;->localStorageMaxRollOver:Ljava/lang/Long;

    if-eqz v8, :cond_2

    iget-object v8, p0, Lcom/amazon/sdk/availability/FileStore;->localStorageMaxRollOverSize:Ljava/lang/Long;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    if-nez v8, :cond_3

    .line 196
    :cond_2
    const/4 v6, 0x0

    .line 249
    invoke-static {v5}, Lcom/amazon/profiling/Profiler;->scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V

    :goto_0
    return v6

    .line 199
    :cond_3
    const/4 v6, 0x0

    .line 202
    .local v6, "putSucceeded":Z
    :try_start_2
    iget-object v8, p0, Lcom/amazon/sdk/availability/FileStore;->file:Ljava/io/File;

    if-eqz v8, :cond_4

    iget-object v8, p0, Lcom/amazon/sdk/availability/FileStore;->file:Ljava/io/File;

    invoke-virtual {v8}, Ljava/io/File;->exists()Z

    move-result v8

    if-nez v8, :cond_5

    .line 203
    :cond_4
    invoke-direct {p0}, Lcom/amazon/sdk/availability/FileStore;->initFileStore()V

    .line 206
    :cond_5
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/FileStore;->getRollOverCount()I

    move-result v2

    .line 207
    .local v2, "currentCount":I
    add-int/lit8 v7, v2, 0x1

    .line 213
    .local v7, "rollOverCount":I
    int-to-long v8, v7

    iget-object v10, p0, Lcom/amazon/sdk/availability/FileStore;->localStorageMaxRollOver:Ljava/lang/Long;

    invoke-virtual {v10}, Ljava/lang/Long;->longValue()J

    move-result-wide v10

    const-wide/16 v12, 0x1

    add-long/2addr v10, v12

    cmp-long v8, v8, v10

    if-gtz v8, :cond_7

    .line 219
    iget-object v8, p0, Lcom/amazon/sdk/availability/FileStore;->encryptionManager:Lcom/amazon/sdk/availability/EncryptionManager;

    if-nez v8, :cond_6

    .line 220
    invoke-virtual {p1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v1

    .line 228
    .local v1, "content":Ljava/lang/String;
    :goto_1
    new-instance v4, Lorg/json/JSONObject;

    invoke-direct {v4}, Lorg/json/JSONObject;-><init>()V

    .line 229
    .local v4, "jsonToWrite":Lorg/json/JSONObject;
    const-string/jumbo v8, "timestamp"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v9

    invoke-virtual {v4, v8, v9, v10}, Lorg/json/JSONObject;->put(Ljava/lang/String;J)Lorg/json/JSONObject;

    .line 230
    const-string/jumbo v8, "content"

    invoke-virtual {v4, v8, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 232
    iget-object v8, p0, Lcom/amazon/sdk/availability/FileStore;->out:Ljava/io/OutputStream;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string/jumbo v10, "\r\n"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    const-string/jumbo v10, "UTF-8"

    invoke-virtual {v9, v10}, Ljava/lang/String;->getBytes(Ljava/lang/String;)[B

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/io/OutputStream;->write([B)V

    .line 236
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/FileStore;->rollOverIfNeeded()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 238
    const/4 v6, 0x1

    .line 249
    .end local v1    # "content":Ljava/lang/String;
    .end local v4    # "jsonToWrite":Lorg/json/JSONObject;
    :goto_2
    invoke-static {v5}, Lcom/amazon/profiling/Profiler;->scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V

    goto :goto_0

    .line 222
    :cond_6
    :try_start_3
    const-class v8, Lcom/amazon/sdk/availability/FileStore;

    const-string/jumbo v9, "put/b64"

    invoke-static {v8, v9}, Lcom/amazon/profiling/Profiler;->methodScopeStart(Ljava/lang/Class;Ljava/lang/String;)Lcom/amazon/profiling/ProfilerScope;

    move-result-object v0

    .line 223
    .local v0, "blockScope":Lcom/amazon/profiling/ProfilerScope;
    iget-object v8, p0, Lcom/amazon/sdk/availability/FileStore;->encryptionManager:Lcom/amazon/sdk/availability/EncryptionManager;

    invoke-interface {v8, p1}, Lcom/amazon/sdk/availability/EncryptionManager;->encrypt(Lorg/json/JSONObject;)[B

    move-result-object v8

    const/16 v9, 0xb

    invoke-static {v8, v9}, Landroid/util/Base64;->encodeToString([BI)Ljava/lang/String;

    move-result-object v1

    .line 225
    .restart local v1    # "content":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/profiling/Profiler;->scopeEnd(Lcom/amazon/profiling/ProfilerScope;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_1

    .line 244
    .end local v0    # "blockScope":Lcom/amazon/profiling/ProfilerScope;
    .end local v1    # "content":Ljava/lang/String;
    .end local v2    # "currentCount":I
    .end local v7    # "rollOverCount":I
    :catch_0
    move-exception v3

    .line 245
    .local v3, "e":Ljava/lang/Exception;
    :try_start_4
    new-instance v8, Lcom/amazon/sdk/availability/DataStoreException;

    invoke-direct {v8, v3}, Lcom/amazon/sdk/availability/DataStoreException;-><init>(Ljava/lang/Throwable;)V

    throw v8
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 240
    .end local v3    # "e":Ljava/lang/Exception;
    .restart local v2    # "currentCount":I
    .restart local v7    # "rollOverCount":I
    :cond_7
    :try_start_5
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "Ignoring a put() as exceeded persistence config: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    iget-object v9, p0, Lcom/amazon/sdk/availability/FileStore;->localStorageMaxRollOver:Ljava/lang/Long;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, "x "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    iget-object v9, p0, Lcom/amazon/sdk/availability/FileStore;->localStorageMaxRollOverSize:Ljava/lang/Long;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, "B"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Lcom/amazon/sdk/availability/Logger;->i(Ljava/lang/String;)V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_0
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_2
.end method

.method protected rollOverIfNeeded()V
    .locals 10
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v9, 0x1

    .line 579
    iget-object v3, p0, Lcom/amazon/sdk/availability/FileStore;->localStorageMaxRollOver:Ljava/lang/Long;

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/amazon/sdk/availability/FileStore;->localStorageMaxRollOverSize:Ljava/lang/Long;

    if-nez v3, :cond_1

    .line 605
    :cond_0
    :goto_0
    return-void

    .line 584
    :cond_1
    iget-object v3, p0, Lcom/amazon/sdk/availability/FileStore;->file:Ljava/io/File;

    invoke-virtual {v3}, Ljava/io/File;->length()J

    move-result-wide v3

    iget-object v5, p0, Lcom/amazon/sdk/availability/FileStore;->localStorageMaxRollOverSize:Ljava/lang/Long;

    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    cmp-long v3, v3, v5

    if-lez v3, :cond_0

    .line 587
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/FileStore;->getRollOverCount()I

    move-result v0

    .line 588
    .local v0, "currentCount":I
    add-int/lit8 v1, v0, 0x1

    .line 592
    .local v1, "rollOverCount":I
    int-to-long v3, v1

    iget-object v5, p0, Lcom/amazon/sdk/availability/FileStore;->localStorageMaxRollOver:Ljava/lang/Long;

    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v5

    const-wide/16 v7, 0x1

    add-long/2addr v5, v7

    cmp-long v3, v3, v5

    if-gtz v3, :cond_2

    .line 593
    const-string/jumbo v3, "availability_measurements_%s.measure"

    new-array v4, v9, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 595
    .local v2, "rollOverFile":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/FileStore;->closeCurrentStream()V

    .line 597
    iget-object v3, p0, Lcom/amazon/sdk/availability/FileStore;->preferences:Lcom/amazon/sdk/availability/Preferences;

    const-string/jumbo v4, "last-file-used"

    invoke-virtual {v3, v4, v2}, Lcom/amazon/sdk/availability/Preferences;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 598
    new-instance v3, Ljava/io/File;

    invoke-virtual {p0}, Lcom/amazon/sdk/availability/FileStore;->getDataDirectory()Ljava/io/File;

    move-result-object v4

    invoke-direct {v3, v4, v2}, Ljava/io/File;-><init>(Ljava/io/File;Ljava/lang/String;)V

    iput-object v3, p0, Lcom/amazon/sdk/availability/FileStore;->file:Ljava/io/File;

    .line 599
    new-instance v3, Ljava/io/BufferedOutputStream;

    new-instance v4, Ljava/io/FileOutputStream;

    iget-object v5, p0, Lcom/amazon/sdk/availability/FileStore;->file:Ljava/io/File;

    invoke-direct {v4, v5, v9}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;Z)V

    const v5, 0x8000

    invoke-direct {v3, v4, v5}, Ljava/io/BufferedOutputStream;-><init>(Ljava/io/OutputStream;I)V

    iput-object v3, p0, Lcom/amazon/sdk/availability/FileStore;->out:Ljava/io/OutputStream;

    goto :goto_0

    .line 601
    .end local v2    # "rollOverFile":Ljava/lang/String;
    :cond_2
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "not rolling over, as exceeded \'localStorageMaxRollOver\': "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/sdk/availability/FileStore;->localStorageMaxRollOver:Ljava/lang/Long;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "x "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/sdk/availability/FileStore;->localStorageMaxRollOverSize:Ljava/lang/Long;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "B"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/sdk/availability/Logger;->i(Ljava/lang/String;)V

    goto/16 :goto_0
.end method
