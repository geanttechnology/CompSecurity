.class public final Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;
.super Ljava/lang/Object;
.source "JsonFileIo.java"

# interfaces
.implements Lcom/comcast/playerplatform/analytics/java/util/FileIo;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonFileWriteRunnable;,
        Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonFileReadRunnable;,
        Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonInterpreter;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/playerplatform/analytics/java/util/FileIo",
        "<TT;>;"
    }
.end annotation


# static fields
.field private static final logger:Lorg/slf4j/Logger;


# instance fields
.field private itemList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation
.end field

.field private final jsonInterpreter:Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonInterpreter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonInterpreter",
            "<TT;>;"
        }
    .end annotation
.end field

.field private maxItems:I

.field private final streams:Lcom/comcast/playerplatform/analytics/java/util/ObjectStream;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const-class v0, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->logger:Lorg/slf4j/Logger;

    return-void
.end method

.method private closeStream(Ljava/io/Closeable;)V
    .locals 1
    .param p1, "stream"    # Ljava/io/Closeable;

    .prologue
    .line 194
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;, "Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo<TT;>;"
    if-eqz p1, :cond_0

    .line 195
    :try_start_0
    invoke-interface {p1}, Ljava/io/Closeable;->close()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 200
    :cond_0
    :goto_0
    return-void

    .line 197
    :catch_0
    move-exception v0

    .line 198
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method private readItemsFromDisk(Ljava/io/ObjectInputStream;I)Ljava/util/List;
    .locals 5
    .param p1, "ois"    # Ljava/io/ObjectInputStream;
    .param p2, "numItems"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/ObjectInputStream;",
            "I)",
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/ClassNotFoundException;
        }
    .end annotation

    .prologue
    .line 175
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;, "Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo<TT;>;"
    sget-object v3, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->logger:Lorg/slf4j/Logger;

    const-string v4, "readItemsFromDisk"

    invoke-interface {v3, v4}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 176
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2, p2}, Ljava/util/ArrayList;-><init>(I)V

    .line 178
    .local v2, "result":Ljava/util/List;, "Ljava/util/List<TT;>;"
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    if-ge v0, p2, :cond_0

    .line 179
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->readNextObject(Ljava/io/ObjectInputStream;)Ljava/lang/Object;

    move-result-object v1

    .line 180
    .local v1, "msg":Ljava/lang/Object;, "TT;"
    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 178
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 183
    .end local v1    # "msg":Ljava/lang/Object;, "TT;"
    :cond_0
    return-object v2
.end method

.method private readNextObject(Ljava/io/ObjectInputStream;)Ljava/lang/Object;
    .locals 3
    .param p1, "stream"    # Ljava/io/ObjectInputStream;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/ObjectInputStream;",
            ")TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;,
            Ljava/lang/ClassNotFoundException;
        }
    .end annotation

    .prologue
    .line 187
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;, "Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo<TT;>;"
    invoke-virtual {p1}, Ljava/io/ObjectInputStream;->readObject()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 188
    .local v0, "jsonStr":Ljava/lang/String;
    iget-object v2, p0, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->jsonInterpreter:Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonInterpreter;

    invoke-interface {v2, v0}, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonInterpreter;->fromJson(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    .line 189
    .local v1, "msg":Ljava/lang/Object;, "TT;"
    return-object v1
.end method

.method private readNumSavedItems(Ljava/io/ObjectInputStream;)I
    .locals 1
    .param p1, "ois"    # Ljava/io/ObjectInputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 203
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;, "Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo<TT;>;"
    invoke-virtual {p1}, Ljava/io/ObjectInputStream;->readInt()I

    move-result v0

    return v0
.end method

.method private saveItemsToDisk(Ljava/io/ObjectOutputStream;Ljava/util/List;)V
    .locals 5
    .param p1, "oos"    # Ljava/io/ObjectOutputStream;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/io/ObjectOutputStream;",
            "Ljava/util/List",
            "<TT;>;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 255
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;, "Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo<TT;>;"
    .local p2, "items":Ljava/util/List;, "Ljava/util/List<TT;>;"
    sget-object v3, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->logger:Lorg/slf4j/Logger;

    const-string v4, "saveItemsToDisk"

    invoke-interface {v3, v4}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 257
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v3

    invoke-virtual {p1, v3}, Ljava/io/ObjectOutputStream;->writeInt(I)V

    .line 259
    invoke-interface {p2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    .line 260
    .local v2, "msg":Ljava/lang/Object;, "TT;"
    iget-object v3, p0, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->jsonInterpreter:Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonInterpreter;

    invoke-interface {v3, v2}, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo$JsonInterpreter;->toJson(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 261
    .local v1, "jsonMsg":Ljava/lang/String;
    invoke-virtual {p1, v1}, Ljava/io/ObjectOutputStream;->writeObject(Ljava/lang/Object;)V

    goto :goto_0

    .line 263
    .end local v1    # "jsonMsg":Ljava/lang/String;
    .end local v2    # "msg":Ljava/lang/Object;, "TT;"
    :cond_0
    return-void
.end method


# virtual methods
.method public append(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 241
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;, "Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo<TT;>;"
    .local p1, "input":Ljava/util/List;, "Ljava/util/List<TT;>;"
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->itemList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 242
    return-void
.end method

.method public hasSavedItems()Z
    .locals 1

    .prologue
    .line 266
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;, "Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo<TT;>;"
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->itemList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public declared-synchronized loadItems()Ljava/util/List;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 104
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;, "Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo<TT;>;"
    monitor-enter p0

    :try_start_0
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v2

    .line 105
    .local v2, "result":Ljava/util/List;, "Ljava/util/List<TT;>;"
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v5

    iput-object v5, p0, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->itemList:Ljava/util/List;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 106
    const/4 v1, 0x0

    .line 109
    .local v1, "ois":Ljava/io/ObjectInputStream;
    :try_start_1
    iget-object v5, p0, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->streams:Lcom/comcast/playerplatform/analytics/java/util/ObjectStream;

    invoke-interface {v5}, Lcom/comcast/playerplatform/analytics/java/util/ObjectStream;->objectInputStream()Ljava/io/ObjectInputStream;

    move-result-object v1

    .line 110
    invoke-direct {p0, v1}, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->readNumSavedItems(Ljava/io/ObjectInputStream;)I

    move-result v4

    .line 112
    .local v4, "size":I
    if-lez v4, :cond_0

    .line 113
    invoke-direct {p0, v1, v4}, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->readItemsFromDisk(Ljava/io/ObjectInputStream;I)Ljava/util/List;

    move-result-object v5

    iput-object v5, p0, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->itemList:Ljava/util/List;

    .line 114
    new-instance v3, Ljava/util/ArrayList;

    iget-object v5, p0, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->itemList:Ljava/util/List;

    invoke-direct {v3, v5}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
    :try_end_1
    .catch Ljava/io/EOFException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .end local v2    # "result":Ljava/util/List;, "Ljava/util/List<TT;>;"
    .local v3, "result":Ljava/util/List;, "Ljava/util/List<TT;>;"
    move-object v2, v3

    .line 121
    .end local v3    # "result":Ljava/util/List;, "Ljava/util/List<TT;>;"
    .restart local v2    # "result":Ljava/util/List;, "Ljava/util/List<TT;>;"
    :cond_0
    :try_start_2
    invoke-direct {p0, v1}, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->closeStream(Ljava/io/Closeable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 124
    .end local v4    # "size":I
    :goto_0
    monitor-exit p0

    return-object v2

    .line 116
    :catch_0
    move-exception v5

    .line 121
    :try_start_3
    invoke-direct {p0, v1}, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->closeStream(Ljava/io/Closeable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 104
    .end local v1    # "ois":Ljava/io/ObjectInputStream;
    .end local v2    # "result":Ljava/util/List;, "Ljava/util/List<TT;>;"
    :catchall_0
    move-exception v5

    monitor-exit p0

    throw v5

    .line 118
    .restart local v1    # "ois":Ljava/io/ObjectInputStream;
    .restart local v2    # "result":Ljava/util/List;, "Ljava/util/List<TT;>;"
    :catch_1
    move-exception v0

    .line 119
    .local v0, "e":Ljava/lang/Exception;
    :try_start_4
    sget-object v5, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->logger:Lorg/slf4j/Logger;

    const-string v6, "Exception while executing loadItems()"

    invoke-interface {v5, v6, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 121
    :try_start_5
    invoke-direct {p0, v1}, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->closeStream(Ljava/io/Closeable;)V

    goto :goto_0

    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_1
    move-exception v5

    invoke-direct {p0, v1}, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->closeStream(Ljava/io/Closeable;)V

    throw v5
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0
.end method

.method public removeItems(I)Ljava/util/List;
    .locals 1
    .param p1, "length"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 135
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;, "Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo<TT;>;"
    const/4 v0, 0x0

    invoke-virtual {p0, v0, p1}, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->removeItems(II)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public declared-synchronized removeItems(II)Ljava/util/List;
    .locals 6
    .param p1, "start"    # I
    .param p2, "end"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(II)",
            "Ljava/util/List",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 148
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;, "Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo<TT;>;"
    monitor-enter p0

    if-le p1, p2, :cond_0

    :try_start_0
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string v5, "Start value must be smaller than end value."

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4

    .line 150
    :cond_0
    :try_start_1
    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v2

    .line 151
    .local v2, "result":Ljava/util/List;, "Ljava/util/List<TT;>;"
    sub-int v3, p2, p1

    .line 152
    .local v3, "size":I
    if-lez v3, :cond_1

    .line 153
    new-instance v2, Ljava/util/ArrayList;

    .end local v2    # "result":Ljava/util/List;, "Ljava/util/List<TT;>;"
    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(I)V

    .line 155
    .restart local v2    # "result":Ljava/util/List;, "Ljava/util/List<TT;>;"
    move v0, p1

    .local v0, "i":I
    :goto_0
    if-ge v0, p2, :cond_1

    .line 156
    iget-object v4, p0, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->itemList:Ljava/util/List;

    const/4 v5, 0x0

    invoke-interface {v4, v5}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    move-result-object v1

    .line 157
    .local v1, "item":Ljava/lang/Object;, "TT;"
    invoke-interface {v2, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 155
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 161
    .end local v0    # "i":I
    .end local v1    # "item":Ljava/lang/Object;, "TT;"
    :cond_1
    monitor-exit p0

    return-object v2
.end method

.method public save()V
    .locals 1

    .prologue
    .line 231
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;, "Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo<TT;>;"
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->itemList:Ljava/util/List;

    invoke-virtual {p0, v0}, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->saveItems(Ljava/util/List;)V

    .line 232
    return-void
.end method

.method public declared-synchronized saveItems(Ljava/util/List;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 208
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;, "Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo<TT;>;"
    .local p1, "input":Ljava/util/List;, "Ljava/util/List<TT;>;"
    monitor-enter p0

    :try_start_0
    sget-object v5, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->logger:Lorg/slf4j/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "saveItems: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 209
    const/4 v3, 0x0

    .line 210
    .local v3, "oos":Ljava/io/ObjectOutputStream;
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2, p1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 212
    .local v2, "items":Ljava/util/List;, "Ljava/util/List<TT;>;"
    :try_start_1
    iget-object v5, p0, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->streams:Lcom/comcast/playerplatform/analytics/java/util/ObjectStream;

    invoke-interface {v5}, Lcom/comcast/playerplatform/analytics/java/util/ObjectStream;->objectOutputStream()Ljava/io/ObjectOutputStream;

    move-result-object v3

    .line 213
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v1

    .line 214
    .local v1, "inputSize":I
    iget v5, p0, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->maxItems:I

    if-le v1, v5, :cond_0

    .line 215
    iget v5, p0, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->maxItems:I

    sub-int v4, v5, v1

    .line 216
    .local v4, "start":I
    invoke-interface {v2, v4, v1}, Ljava/util/List;->subList(II)Ljava/util/List;

    move-result-object v2

    .line 218
    .end local v4    # "start":I
    :cond_0
    invoke-direct {p0, v3, v2}, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->saveItemsToDisk(Ljava/io/ObjectOutputStream;Ljava/util/List;)V

    .line 219
    iput-object v2, p0, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->itemList:Ljava/util/List;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 223
    :try_start_2
    invoke-direct {p0, v3}, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->closeStream(Ljava/io/Closeable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 225
    .end local v1    # "inputSize":I
    :goto_0
    monitor-exit p0

    return-void

    .line 220
    :catch_0
    move-exception v0

    .line 221
    .local v0, "e":Ljava/lang/Exception;
    :try_start_3
    sget-object v5, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->logger:Lorg/slf4j/Logger;

    const-string v6, "Exception while executing saveItems()"

    invoke-interface {v5, v6, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 223
    :try_start_4
    invoke-direct {p0, v3}, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->closeStream(Ljava/io/Closeable;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_0

    .line 208
    .end local v0    # "e":Ljava/lang/Exception;
    .end local v2    # "items":Ljava/util/List;, "Ljava/util/List<TT;>;"
    .end local v3    # "oos":Ljava/io/ObjectOutputStream;
    :catchall_0
    move-exception v5

    monitor-exit p0

    throw v5

    .line 223
    .restart local v2    # "items":Ljava/util/List;, "Ljava/util/List<TT;>;"
    .restart local v3    # "oos":Ljava/io/ObjectOutputStream;
    :catchall_1
    move-exception v5

    :try_start_5
    invoke-direct {p0, v3}, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->closeStream(Ljava/io/Closeable;)V

    throw v5
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0
.end method

.method public size()I
    .locals 1

    .prologue
    .line 270
    .local p0, "this":Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;, "Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo<TT;>;"
    iget-object v0, p0, Lcom/comcast/playerplatform/analytics/java/util/JsonFileIo;->itemList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method
