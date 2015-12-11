.class Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;
.super Ljava/lang/Object;
.source "DropboxDataStore.java"

# interfaces
.implements Lcom/amazon/sdk/availability/DataStoreIterator;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/sdk/availability/DropboxDataStore;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "Iterator"
.end annotation


# instance fields
.field private calledHasNext:Z

.field private currentEntry:Landroid/os/DropBoxManager$Entry;

.field private final dropBoxManager:Landroid/os/DropBoxManager;

.field private lastEntry:Landroid/os/DropBoxManager$Entry;

.field private final tag:Ljava/lang/String;

.field private final timeStamp:J


# direct methods
.method constructor <init>(Ljava/lang/String;Landroid/os/DropBoxManager;J)V
    .locals 1
    .param p1, "tag"    # Ljava/lang/String;
    .param p2, "dropBoxManager"    # Landroid/os/DropBoxManager;
    .param p3, "timeStamp"    # J

    .prologue
    const/4 v0, 0x0

    .line 144
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 145
    iput-object p1, p0, Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;->tag:Ljava/lang/String;

    .line 146
    iput-object p2, p0, Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;->dropBoxManager:Landroid/os/DropBoxManager;

    .line 147
    iput-wide p3, p0, Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;->timeStamp:J

    .line 148
    iput-object v0, p0, Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;->lastEntry:Landroid/os/DropBoxManager$Entry;

    .line 149
    iput-object v0, p0, Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;->currentEntry:Landroid/os/DropBoxManager$Entry;

    .line 150
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;->calledHasNext:Z

    .line 151
    return-void
.end method

.method protected static transform(Landroid/os/DropBoxManager$Entry;)Ljava/lang/String;
    .locals 7
    .param p0, "entry"    # Landroid/os/DropBoxManager$Entry;

    .prologue
    .line 193
    const/4 v2, 0x0

    .line 196
    .local v2, "reader":Ljava/io/BufferedReader;
    :try_start_0
    new-instance v3, Ljava/io/BufferedReader;

    new-instance v5, Ljava/io/InputStreamReader;

    invoke-virtual {p0}, Landroid/os/DropBoxManager$Entry;->getInputStream()Ljava/io/InputStream;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v3, v5}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 197
    .end local v2    # "reader":Ljava/io/BufferedReader;
    .local v3, "reader":Ljava/io/BufferedReader;
    :try_start_1
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    .line 198
    .local v4, "sb":Ljava/lang/StringBuilder;
    invoke-virtual {v3}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v0

    .line 199
    .local v0, "contents":Ljava/lang/String;
    :goto_0
    invoke-static {v0}, Lcom/amazon/sdk/availability/StringUtil;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 200
    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 201
    invoke-virtual {v3}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 203
    :cond_0
    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_3
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v5

    .line 208
    if-eqz v3, :cond_2

    .line 210
    :try_start_2
    invoke-virtual {v3}, Ljava/io/BufferedReader;->close()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    .line 215
    const/4 v2, 0x0

    .line 217
    .end local v3    # "reader":Ljava/io/BufferedReader;
    .restart local v2    # "reader":Ljava/io/BufferedReader;
    :goto_1
    invoke-virtual {p0}, Landroid/os/DropBoxManager$Entry;->close()V

    return-object v5

    .line 211
    .end local v2    # "reader":Ljava/io/BufferedReader;
    .restart local v3    # "reader":Ljava/io/BufferedReader;
    :catch_0
    move-exception v1

    .line 212
    .local v1, "e":Ljava/lang/Exception;
    new-instance v5, Lcom/amazon/sdk/availability/DataStoreException;

    invoke-direct {v5, v1}, Lcom/amazon/sdk/availability/DataStoreException;-><init>(Ljava/lang/Throwable;)V

    throw v5

    .line 204
    .end local v0    # "contents":Ljava/lang/String;
    .end local v1    # "e":Ljava/lang/Exception;
    .end local v3    # "reader":Ljava/io/BufferedReader;
    .end local v4    # "sb":Ljava/lang/StringBuilder;
    .restart local v2    # "reader":Ljava/io/BufferedReader;
    :catch_1
    move-exception v1

    .line 205
    .restart local v1    # "e":Ljava/lang/Exception;
    :goto_2
    :try_start_3
    new-instance v5, Lcom/amazon/sdk/availability/DataStoreException;

    invoke-direct {v5, v1}, Lcom/amazon/sdk/availability/DataStoreException;-><init>(Ljava/lang/Throwable;)V

    throw v5
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 208
    .end local v1    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v5

    :goto_3
    if-eqz v2, :cond_1

    .line 210
    :try_start_4
    invoke-virtual {v2}, Ljava/io/BufferedReader;->close()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2

    .line 215
    const/4 v2, 0x0

    .line 217
    :cond_1
    invoke-virtual {p0}, Landroid/os/DropBoxManager$Entry;->close()V

    throw v5

    .line 211
    :catch_2
    move-exception v1

    .line 212
    .restart local v1    # "e":Ljava/lang/Exception;
    new-instance v5, Lcom/amazon/sdk/availability/DataStoreException;

    invoke-direct {v5, v1}, Lcom/amazon/sdk/availability/DataStoreException;-><init>(Ljava/lang/Throwable;)V

    throw v5

    .line 208
    .end local v1    # "e":Ljava/lang/Exception;
    .end local v2    # "reader":Ljava/io/BufferedReader;
    .restart local v3    # "reader":Ljava/io/BufferedReader;
    :catchall_1
    move-exception v5

    move-object v2, v3

    .end local v3    # "reader":Ljava/io/BufferedReader;
    .restart local v2    # "reader":Ljava/io/BufferedReader;
    goto :goto_3

    .line 204
    .end local v2    # "reader":Ljava/io/BufferedReader;
    .restart local v3    # "reader":Ljava/io/BufferedReader;
    :catch_3
    move-exception v1

    move-object v2, v3

    .end local v3    # "reader":Ljava/io/BufferedReader;
    .restart local v2    # "reader":Ljava/io/BufferedReader;
    goto :goto_2

    .end local v2    # "reader":Ljava/io/BufferedReader;
    .restart local v0    # "contents":Ljava/lang/String;
    .restart local v3    # "reader":Ljava/io/BufferedReader;
    .restart local v4    # "sb":Ljava/lang/StringBuilder;
    :cond_2
    move-object v2, v3

    .end local v3    # "reader":Ljava/io/BufferedReader;
    .restart local v2    # "reader":Ljava/io/BufferedReader;
    goto :goto_1
.end method


# virtual methods
.method public clear()V
    .locals 0

    .prologue
    .line 232
    return-void
.end method

.method public closeAfterUse()V
    .locals 1

    .prologue
    .line 236
    iget-object v0, p0, Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;->currentEntry:Landroid/os/DropBoxManager$Entry;

    if-eqz v0, :cond_0

    .line 238
    iget-object v0, p0, Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;->currentEntry:Landroid/os/DropBoxManager$Entry;

    invoke-virtual {v0}, Landroid/os/DropBoxManager$Entry;->close()V

    .line 240
    :cond_0
    return-void
.end method

.method public hasNext()Z
    .locals 7

    .prologue
    const/4 v2, 0x1

    .line 156
    iget-object v3, p0, Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;->currentEntry:Landroid/os/DropBoxManager$Entry;

    if-eqz v3, :cond_0

    .line 157
    iget-object v3, p0, Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;->currentEntry:Landroid/os/DropBoxManager$Entry;

    iput-object v3, p0, Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;->lastEntry:Landroid/os/DropBoxManager$Entry;

    .line 160
    :cond_0
    iget-object v3, p0, Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;->lastEntry:Landroid/os/DropBoxManager$Entry;

    if-eqz v3, :cond_1

    .line 161
    iget-object v3, p0, Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;->lastEntry:Landroid/os/DropBoxManager$Entry;

    invoke-virtual {v3}, Landroid/os/DropBoxManager$Entry;->getTimeMillis()J

    move-result-wide v0

    .line 165
    .local v0, "lastTimeStamp":J
    :goto_0
    iget-object v3, p0, Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;->dropBoxManager:Landroid/os/DropBoxManager;

    iget-object v4, p0, Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;->tag:Ljava/lang/String;

    iget-wide v5, p0, Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;->timeStamp:J

    invoke-static {v5, v6, v0, v1}, Ljava/lang/Math;->max(JJ)J

    move-result-wide v5

    invoke-virtual {v3, v4, v5, v6}, Landroid/os/DropBoxManager;->getNextEntry(Ljava/lang/String;J)Landroid/os/DropBoxManager$Entry;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;->currentEntry:Landroid/os/DropBoxManager$Entry;

    .line 166
    iput-boolean v2, p0, Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;->calledHasNext:Z

    .line 167
    iget-object v3, p0, Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;->currentEntry:Landroid/os/DropBoxManager$Entry;

    if-eqz v3, :cond_2

    :goto_1
    return v2

    .line 163
    .end local v0    # "lastTimeStamp":J
    :cond_1
    const-wide/16 v0, 0x0

    .restart local v0    # "lastTimeStamp":J
    goto :goto_0

    .line 167
    :cond_2
    const/4 v2, 0x0

    goto :goto_1
.end method

.method public next()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 173
    iget-boolean v0, p0, Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;->calledHasNext:Z

    if-nez v0, :cond_0

    .line 174
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;->hasNext()Z

    .line 177
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;->calledHasNext:Z

    .line 179
    iget-object v0, p0, Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;->currentEntry:Landroid/os/DropBoxManager$Entry;

    if-nez v0, :cond_1

    .line 180
    new-instance v0, Ljava/util/NoSuchElementException;

    invoke-direct {v0}, Ljava/util/NoSuchElementException;-><init>()V

    throw v0

    .line 182
    :cond_1
    iget-object v0, p0, Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;->currentEntry:Landroid/os/DropBoxManager$Entry;

    invoke-static {v0}, Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;->transform(Landroid/os/DropBoxManager$Entry;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public remove()V
    .locals 1

    .prologue
    .line 225
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v0}, Ljava/lang/UnsupportedOperationException;-><init>()V

    throw v0
.end method
