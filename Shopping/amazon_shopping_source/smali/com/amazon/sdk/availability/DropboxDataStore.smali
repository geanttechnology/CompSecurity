.class public Lcom/amazon/sdk/availability/DropboxDataStore;
.super Ljava/lang/Object;
.source "DropboxDataStore.java"

# interfaces
.implements Lcom/amazon/sdk/availability/DataStore;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;
    }
.end annotation


# instance fields
.field private final clientId:Ljava/lang/String;

.field private dropboxManager:Landroid/os/DropBoxManager;

.field private isOpen:Z

.field private tag:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 2
    .param p1, "clientId"    # Ljava/lang/String;

    .prologue
    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    invoke-static {p1}, Lcom/amazon/sdk/availability/StringUtil;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 39
    new-instance v0, Lcom/amazon/sdk/availability/DataStoreException;

    const-string/jumbo v1, "\'clientId\' cannot be null/empty"

    invoke-direct {v0, v1}, Lcom/amazon/sdk/availability/DataStoreException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 41
    :cond_0
    iput-object p1, p0, Lcom/amazon/sdk/availability/DropboxDataStore;->clientId:Ljava/lang/String;

    .line 42
    return-void
.end method


# virtual methods
.method public close()V
    .locals 1

    .prologue
    .line 110
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/sdk/availability/DropboxDataStore;->dropboxManager:Landroid/os/DropBoxManager;

    .line 111
    return-void
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
    .line 100
    new-instance v0, Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;

    iget-object v1, p0, Lcom/amazon/sdk/availability/DropboxDataStore;->tag:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/sdk/availability/DropboxDataStore;->dropboxManager:Landroid/os/DropBoxManager;

    invoke-direct {v0, v1, v2, p1, p2}, Lcom/amazon/sdk/availability/DropboxDataStore$Iterator;-><init>(Ljava/lang/String;Landroid/os/DropBoxManager;J)V

    return-object v0
.end method

.method public getTag()Ljava/lang/String;
    .locals 4

    .prologue
    .line 48
    const-string/jumbo v0, "com.amazon.sdk.availability.(%s)"

    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/amazon/sdk/availability/DropboxDataStore;->clientId:Ljava/lang/String;

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public open(Landroid/content/Context;Lcom/amazon/sdk/availability/EncryptionManager;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "encryptionManager"    # Lcom/amazon/sdk/availability/EncryptionManager;

    .prologue
    .line 57
    if-nez p1, :cond_0

    .line 58
    new-instance v0, Lcom/amazon/sdk/availability/DataStoreException;

    const-string/jumbo v1, "\'context\' is null"

    invoke-direct {v0, v1}, Lcom/amazon/sdk/availability/DataStoreException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 62
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/sdk/availability/DropboxDataStore;->isOpen:Z

    .line 63
    invoke-virtual {p0}, Lcom/amazon/sdk/availability/DropboxDataStore;->getTag()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/sdk/availability/DropboxDataStore;->tag:Ljava/lang/String;

    .line 64
    const-string/jumbo v0, "dropbox"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/DropBoxManager;

    iput-object v0, p0, Lcom/amazon/sdk/availability/DropboxDataStore;->dropboxManager:Landroid/os/DropBoxManager;

    .line 65
    return-void
.end method

.method public put(Lorg/json/JSONObject;)Z
    .locals 4
    .param p1, "jobj"    # Lorg/json/JSONObject;

    .prologue
    .line 74
    if-nez p1, :cond_0

    .line 75
    new-instance v1, Lcom/amazon/sdk/availability/DataStoreException;

    const-string/jumbo v2, "\'json\' cannot be null"

    invoke-direct {v1, v2}, Lcom/amazon/sdk/availability/DataStoreException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 79
    :cond_0
    iget-boolean v1, p0, Lcom/amazon/sdk/availability/DropboxDataStore;->isOpen:Z

    if-nez v1, :cond_1

    .line 80
    new-instance v1, Lcom/amazon/sdk/availability/DataStoreException;

    const-string/jumbo v2, "must call open() before calling put()"

    invoke-direct {v1, v2}, Lcom/amazon/sdk/availability/DataStoreException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 84
    :cond_1
    :try_start_0
    iget-object v1, p0, Lcom/amazon/sdk/availability/DropboxDataStore;->dropboxManager:Landroid/os/DropBoxManager;

    iget-object v2, p0, Lcom/amazon/sdk/availability/DropboxDataStore;->tag:Ljava/lang/String;

    invoke-virtual {p1}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/DropBoxManager;->addText(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 89
    const/4 v1, 0x1

    return v1

    .line 85
    :catch_0
    move-exception v0

    .line 86
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Lcom/amazon/sdk/availability/DataStoreException;

    invoke-direct {v1, v0}, Lcom/amazon/sdk/availability/DataStoreException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method
