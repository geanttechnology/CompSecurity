.class public Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;
.super Ljava/lang/Object;
.source "RegistryInstance.java"


# static fields
.field private static final LOG_TAG:Ljava/lang/String;

.field protected static iLock:Ljava/util/concurrent/locks/Lock;


# instance fields
.field protected iAuthority:Ljava/lang/String;

.field protected resolver:Landroid/content/ContentResolver;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const-class v0, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->LOG_TAG:Ljava/lang/String;

    .line 31
    new-instance v0, Ljava/util/concurrent/locks/ReentrantLock;

    invoke-direct {v0}, Ljava/util/concurrent/locks/ReentrantLock;-><init>()V

    sput-object v0, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->iLock:Ljava/util/concurrent/locks/Lock;

    .line 19
    return-void
.end method

.method public constructor <init>(Landroid/content/ContentResolver;Ljava/lang/String;)V
    .locals 0
    .param p1, "resolver"    # Landroid/content/ContentResolver;
    .param p2, "aAuthority"    # Ljava/lang/String;

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 37
    iput-object p1, p0, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->resolver:Landroid/content/ContentResolver;

    .line 38
    iput-object p2, p0, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->iAuthority:Ljava/lang/String;

    .line 39
    return-void
.end method

.method private queue(Ljava/lang/String;)Ljava/util/List;
    .locals 7
    .param p1, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 274
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 275
    .local v1, "l":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 276
    .local v2, "queue_ids":Ljava/lang/String;
    if-eqz v2, :cond_0

    .line 277
    const-string v4, ","

    invoke-virtual {v2, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 278
    .local v0, "ids":[Ljava/lang/String;
    array-length v5, v0

    const/4 v4, 0x0

    :goto_0
    if-lt v4, v5, :cond_1

    .line 284
    .end local v0    # "ids":[Ljava/lang/String;
    :cond_0
    return-object v1

    .line 278
    .restart local v0    # "ids":[Ljava/lang/String;
    :cond_1
    aget-object v3, v0, v4

    .line 279
    .local v3, "s":Ljava/lang/String;
    if-eqz v3, :cond_2

    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    if-lez v6, :cond_2

    .line 280
    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 278
    :cond_2
    add-int/lit8 v4, v4, 0x1

    goto :goto_0
.end method

.method private saveErrorQueue(Ljava/lang/String;Ljava/util/List;Z)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p3, "canAdd"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 305
    .local p2, "l":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-nez p1, :cond_0

    .line 306
    const-string p1, ""

    .line 308
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, "errorQueue"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0, p2, p3}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->saveQueue(Ljava/lang/String;Ljava/util/List;Z)V

    .line 309
    return-void
.end method

.method private savePendingQueue(Ljava/lang/String;Ljava/util/List;Z)V
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p3, "canAdd"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 287
    .local p2, "l":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-nez p1, :cond_0

    .line 288
    const-string p1, ""

    .line 290
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, "pendingQueue"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0, p2, p3}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->saveQueue(Ljava/lang/String;Ljava/util/List;Z)V

    .line 291
    return-void
.end method

.method private saveQueue(Ljava/lang/String;Ljava/util/List;Z)V
    .locals 8
    .param p1, "queue_name"    # Ljava/lang/String;
    .param p3, "canAdd"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 323
    .local p2, "l":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    new-instance v3, Ljava/lang/StringBuffer;

    invoke-direct {v3}, Ljava/lang/StringBuffer;-><init>()V

    .line 324
    .local v3, "queue_string":Ljava/lang/StringBuffer;
    const/4 v0, 0x0

    .line 325
    .local v0, "cq":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    if-nez p3, :cond_0

    .line 326
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->queue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 328
    :cond_0
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v2

    .line 329
    .local v2, "q_size":I
    const/4 v1, 0x0

    .local v1, "idx":I
    :goto_0
    if-lt v1, v2, :cond_1

    .line 338
    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, p1, v5}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 339
    sget-object v5, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->LOG_TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "queue["

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "]: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 340
    return-void

    .line 330
    :cond_1
    invoke-interface {p2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/String;

    .line 331
    .local v4, "uuid":Ljava/lang/String;
    if-eqz v0, :cond_3

    invoke-interface {v0, v4}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_3

    .line 329
    :cond_2
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 333
    :cond_3
    invoke-virtual {v3, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 334
    add-int/lit8 v5, v1, 0x1

    if-ge v5, v2, :cond_2

    .line 335
    const-string v5, ","

    invoke-virtual {v3, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_1
.end method


# virtual methods
.method public errorQueue(Ljava/lang/String;)Ljava/util/List;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 261
    if-nez p1, :cond_0

    .line 262
    const-string p1, ""

    .line 264
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, "errorQueue"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->queue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public get(Ljava/lang/String;)Ljava/lang/String;
    .locals 10
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 42
    const/4 v0, 0x2

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    .line 43
    const-string v3, "name"

    aput-object v3, v2, v0

    const/4 v0, 0x1

    .line 44
    const-string v3, "value"

    aput-object v3, v2, v0

    .line 47
    .local v2, "PROJECTION":[Ljava/lang/String;
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->iAuthority:Ljava/lang/String;

    invoke-static {v3}, Lcom/penthera/virtuososdk/database/impl/provider/Registry$RegistryColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "/name/"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 48
    .local v1, "registryNameUri":Landroid/net/Uri;
    const/4 v6, 0x0

    .line 49
    .local v6, "cursor":Landroid/database/Cursor;
    const/4 v8, 0x0

    .line 51
    .local v8, "result":Ljava/lang/String;
    :try_start_0
    iget-object v0, p0, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->resolver:Landroid/content/ContentResolver;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 53
    if-eqz v6, :cond_0

    invoke-interface {v6}, Landroid/database/Cursor;->moveToFirst()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 55
    const-string v0, "value"

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v9

    .line 56
    .local v9, "valueColumn":I
    invoke-interface {v6, v9}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v8

    .line 61
    .end local v9    # "valueColumn":I
    :cond_0
    if-eqz v6, :cond_1

    .line 62
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 66
    :cond_1
    :goto_0
    return-object v8

    .line 58
    :catch_0
    move-exception v7

    .line 59
    .local v7, "e":Ljava/lang/Exception;
    :try_start_1
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->LOG_TAG:Ljava/lang/String;

    const-string v3, "Registry get exception: "

    invoke-static {v0, v3, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 61
    if-eqz v6, :cond_1

    .line 62
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 60
    .end local v7    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v0

    .line 61
    if-eqz v6, :cond_2

    .line 62
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 64
    :cond_2
    throw v0
.end method

.method public getBundle()Landroid/os/Bundle;
    .locals 9

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 98
    const/4 v0, 0x2

    new-array v2, v0, [Ljava/lang/String;

    .line 99
    const-string v0, "name"

    aput-object v0, v2, v3

    .line 100
    const-string v0, "value"

    aput-object v0, v2, v4

    .line 103
    .local v2, "PROJECTION":[Ljava/lang/String;
    iget-object v0, p0, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->iAuthority:Ljava/lang/String;

    invoke-static {v0}, Lcom/penthera/virtuososdk/database/impl/provider/Registry$RegistryColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 104
    .local v1, "registryUri":Landroid/net/Uri;
    const/4 v7, 0x0

    .line 105
    .local v7, "cursor":Landroid/database/Cursor;
    new-instance v6, Landroid/os/Bundle;

    invoke-direct {v6}, Landroid/os/Bundle;-><init>()V

    .line 107
    .local v6, "bundle":Landroid/os/Bundle;
    :try_start_0
    iget-object v0, p0, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->resolver:Landroid/content/ContentResolver;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 109
    if-eqz v7, :cond_0

    .line 110
    invoke-interface {v7}, Landroid/database/Cursor;->moveToFirst()Z

    :goto_0
    invoke-interface {v7}, Landroid/database/Cursor;->isAfterLast()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-eqz v0, :cond_2

    .line 117
    :cond_0
    if-eqz v7, :cond_1

    .line 118
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    .line 122
    :cond_1
    :goto_1
    return-object v6

    .line 111
    :cond_2
    const/4 v0, 0x0

    :try_start_1
    invoke-interface {v7, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v3, 0x1

    invoke-interface {v7, v3}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v6, v0, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 110
    invoke-interface {v7}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 114
    :catch_0
    move-exception v8

    .line 115
    .local v8, "e":Ljava/lang/Exception;
    :try_start_2
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->LOG_TAG:Ljava/lang/String;

    const-string v3, "Registry getBundle exception: "

    invoke-static {v0, v3, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 117
    if-eqz v7, :cond_1

    .line 118
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    goto :goto_1

    .line 116
    .end local v8    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v0

    .line 117
    if-eqz v7, :cond_3

    .line 118
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    .line 120
    :cond_3
    throw v0
.end method

.method public pendingQueue(Ljava/lang/String;)Ljava/util/List;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 255
    if-nez p1, :cond_0

    .line 256
    const-string p1, ""

    .line 258
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, "pendingQueue"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->queue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public removeOverrideValues(Landroid/os/Bundle;)V
    .locals 9
    .param p1, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 167
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->getBundle()Landroid/os/Bundle;

    move-result-object v2

    .line 169
    .local v2, "existingBundle":Landroid/os/Bundle;
    invoke-virtual {p1}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_0
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-nez v6, :cond_1

    .line 194
    return-void

    .line 169
    :cond_1
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 170
    .local v3, "name":Ljava/lang/String;
    invoke-virtual {v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 171
    .local v4, "value":Ljava/lang/String;
    if-eqz v4, :cond_0

    .line 174
    :try_start_0
    sget-object v6, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->iLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v6}, Ljava/util/concurrent/locks/Lock;->lock()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 181
    :goto_1
    :try_start_1
    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "name=\'"

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "\'"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 182
    .local v0, "WHERE_CLAUSE":Ljava/lang/String;
    iget-object v6, p0, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->resolver:Landroid/content/ContentResolver;

    iget-object v7, p0, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->iAuthority:Ljava/lang/String;

    invoke-static {v7}, Lcom/penthera/virtuososdk/database/impl/provider/Registry$RegistryColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v7

    const/4 v8, 0x0

    invoke-virtual {v6, v7, v0, v8}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 189
    :try_start_2
    sget-object v6, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->iLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v6}, Ljava/util/concurrent/locks/Lock;->unlock()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0

    .line 190
    :catch_0
    move-exception v6

    goto :goto_0

    .line 175
    .end local v0    # "WHERE_CLAUSE":Ljava/lang/String;
    :catch_1
    move-exception v1

    .line 176
    .local v1, "e":Ljava/lang/Exception;
    sget-object v6, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->LOG_TAG:Ljava/lang/String;

    const-string v7, "Lock Failed in registry removeOverrideValues"

    invoke-static {v6, v7, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1

    .line 184
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_2
    move-exception v1

    .line 185
    .local v1, "e":Ljava/lang/IllegalArgumentException;
    :try_start_3
    sget-object v6, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->LOG_TAG:Ljava/lang/String;

    const-string v7, "removeOverrideValues(): delete issue "

    invoke-static {v6, v7, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 189
    :try_start_4
    sget-object v6, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->iLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v6}, Ljava/util/concurrent/locks/Lock;->unlock()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_3

    goto :goto_0

    .line 190
    :catch_3
    move-exception v6

    goto :goto_0

    .line 187
    .end local v1    # "e":Ljava/lang/IllegalArgumentException;
    :catchall_0
    move-exception v5

    .line 189
    :try_start_5
    sget-object v6, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->iLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v6}, Ljava/util/concurrent/locks/Lock;->unlock()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_4

    .line 191
    :goto_2
    throw v5

    .line 190
    :catch_4
    move-exception v6

    goto :goto_2
.end method

.method public saveErrorQueue(Ljava/lang/String;Ljava/util/List;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 311
    .local p2, "l":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v0, 0x1

    invoke-direct {p0, p1, p2, v0}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->saveErrorQueue(Ljava/lang/String;Ljava/util/List;Z)V

    .line 312
    return-void
.end method

.method public savePendingQueue(Ljava/lang/String;Ljava/util/List;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 294
    .local p2, "l":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v0, 0x1

    invoke-direct {p0, p1, p2, v0}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->savePendingQueue(Ljava/lang/String;Ljava/util/List;Z)V

    .line 295
    return-void
.end method

.method public savePendingQueueNoAdd(Ljava/lang/String;Ljava/util/List;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 298
    .local p2, "l":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->savePendingQueue(Ljava/lang/String;Ljava/util/List;Z)V

    .line 299
    return-void
.end method

.method public set(Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 71
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 72
    .local v2, "values":Landroid/content/ContentValues;
    const-string v3, "name"

    invoke-virtual {v2, v3, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 73
    const-string v3, "value"

    invoke-virtual {v2, v3, p2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 76
    :try_start_0
    sget-object v3, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->iLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v3}, Ljava/util/concurrent/locks/Lock;->lock()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 83
    :goto_0
    :try_start_1
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "name=\'"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 84
    .local v0, "WHERE_CLAUSE":Ljava/lang/String;
    iget-object v3, p0, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->resolver:Landroid/content/ContentResolver;

    iget-object v4, p0, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->iAuthority:Ljava/lang/String;

    invoke-static {v4}, Lcom/penthera/virtuososdk/database/impl/provider/Registry$RegistryColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v4

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v2, v0, v5}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 92
    :try_start_2
    sget-object v3, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->iLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v3}, Ljava/util/concurrent/locks/Lock;->unlock()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_3

    .line 95
    .end local v0    # "WHERE_CLAUSE":Ljava/lang/String;
    :goto_1
    return-void

    .line 77
    :catch_0
    move-exception v1

    .line 78
    .local v1, "e":Ljava/lang/Exception;
    sget-object v3, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->LOG_TAG:Ljava/lang/String;

    const-string v4, "Lock Failed in registry set"

    invoke-static {v3, v4, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 86
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_1
    move-exception v1

    .line 88
    .local v1, "e":Ljava/lang/IllegalArgumentException;
    :try_start_3
    sget-object v3, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->LOG_TAG:Ljava/lang/String;

    const-string v4, "set(): update issue "

    invoke-static {v3, v4, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 92
    :try_start_4
    sget-object v3, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->iLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v3}, Ljava/util/concurrent/locks/Lock;->unlock()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2

    goto :goto_1

    .line 93
    :catch_2
    move-exception v3

    goto :goto_1

    .line 90
    .end local v1    # "e":Ljava/lang/IllegalArgumentException;
    :catchall_0
    move-exception v3

    .line 92
    :try_start_5
    sget-object v4, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->iLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v4}, Ljava/util/concurrent/locks/Lock;->unlock()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_4

    .line 94
    :goto_2
    throw v3

    .line 93
    .restart local v0    # "WHERE_CLAUSE":Ljava/lang/String;
    :catch_3
    move-exception v3

    goto :goto_1

    .end local v0    # "WHERE_CLAUSE":Ljava/lang/String;
    :catch_4
    move-exception v4

    goto :goto_2
.end method

.method public unqueuedQueue(Ljava/lang/String;)Ljava/util/List;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 267
    if-nez p1, :cond_0

    .line 268
    const-string p1, ""

    .line 270
    :cond_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v1, "unqueued"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->queue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public updateRegistry(Landroid/os/Bundle;)V
    .locals 8
    .param p1, "bundle"    # Landroid/os/Bundle;

    .prologue
    .line 127
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->getBundle()Landroid/os/Bundle;

    move-result-object v0

    .line 129
    .local v0, "existingBundle":Landroid/os/Bundle;
    invoke-virtual {p1}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-nez v5, :cond_0

    .line 140
    return-void

    .line 129
    :cond_0
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 130
    .local v2, "name":Ljava/lang/String;
    invoke-virtual {p1, v2}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    .line 131
    .local v3, "value":Ljava/lang/String;
    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 133
    .local v1, "existingValue":Ljava/lang/String;
    if-eqz v1, :cond_1

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_2

    .line 134
    :cond_1
    sget-object v5, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->LOG_TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "Setting registry for "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " with "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 135
    invoke-virtual {p0, v2, v3}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 137
    :cond_2
    sget-object v5, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->LOG_TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "Not replacing "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " in registry for "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " with "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
