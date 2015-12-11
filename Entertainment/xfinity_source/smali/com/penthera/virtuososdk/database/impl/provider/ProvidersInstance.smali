.class public Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;
.super Ljava/lang/Object;
.source "ProvidersInstance.java"


# static fields
.field private static final LOG_TAG:Ljava/lang/String;

.field private static iLock:Ljava/util/concurrent/locks/Lock;


# instance fields
.field private iAuthority:Ljava/lang/String;

.field private resolver:Landroid/content/ContentResolver;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-class v0, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->LOG_TAG:Ljava/lang/String;

    .line 30
    new-instance v0, Ljava/util/concurrent/locks/ReentrantLock;

    invoke-direct {v0}, Ljava/util/concurrent/locks/ReentrantLock;-><init>()V

    sput-object v0, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->iLock:Ljava/util/concurrent/locks/Lock;

    .line 18
    return-void
.end method

.method public constructor <init>(Landroid/content/ContentResolver;Ljava/lang/String;)V
    .locals 0
    .param p1, "resolver"    # Landroid/content/ContentResolver;
    .param p2, "aAuthority"    # Ljava/lang/String;

    .prologue
    .line 35
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 36
    iput-object p1, p0, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->resolver:Landroid/content/ContentResolver;

    .line 37
    iput-object p2, p0, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->iAuthority:Ljava/lang/String;

    .line 38
    return-void
.end method

.method private addProvider(Landroid/content/ContentValues;Ljava/lang/String;)V
    .locals 3
    .param p1, "values"    # Landroid/content/ContentValues;
    .param p2, "Auth"    # Ljava/lang/String;

    .prologue
    .line 86
    :try_start_0
    iget-object v1, p0, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->resolver:Landroid/content/ContentResolver;

    invoke-static {p2}, Lcom/penthera/virtuososdk/database/impl/provider/Provider$ProviderColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-virtual {v1, v2, p1}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 91
    :goto_0
    return-void

    .line 87
    :catch_0
    move-exception v0

    .line 89
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {p0, p2}, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->removeProvider(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private remove(Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p1, "provider_name"    # Ljava/lang/String;
    .param p2, "Auth"    # Ljava/lang/String;

    .prologue
    .line 152
    :try_start_0
    sget-object v2, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->iLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->lock()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 159
    :goto_0
    :try_start_1
    const-string v0, "provider=?"

    .line 160
    .local v0, "WHERE_CLAUSE":Ljava/lang/String;
    iget-object v2, p0, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->resolver:Landroid/content/ContentResolver;

    invoke-static {p2}, Lcom/penthera/virtuososdk/database/impl/provider/Provider$ProviderColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    invoke-virtual {v2, v3, v0, v4}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 167
    :try_start_2
    sget-object v2, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->iLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->unlock()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_3

    .line 170
    .end local v0    # "WHERE_CLAUSE":Ljava/lang/String;
    :goto_1
    return-void

    .line 153
    :catch_0
    move-exception v1

    .line 154
    .local v1, "e":Ljava/lang/Exception;
    sget-object v2, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->LOG_TAG:Ljava/lang/String;

    const-string v3, "Lock Failed in provider remove"

    invoke-static {v2, v3, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 162
    .end local v1    # "e":Ljava/lang/Exception;
    :catch_1
    move-exception v1

    .line 163
    .local v1, "e":Ljava/lang/IllegalArgumentException;
    :try_start_3
    sget-object v2, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->LOG_TAG:Ljava/lang/String;

    const-string v3, "remove(provider): delete issue "

    invoke-static {v2, v3, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 167
    :try_start_4
    sget-object v2, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->iLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->unlock()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2

    goto :goto_1

    .line 168
    :catch_2
    move-exception v2

    goto :goto_1

    .line 165
    .end local v1    # "e":Ljava/lang/IllegalArgumentException;
    :catchall_0
    move-exception v2

    .line 167
    :try_start_5
    sget-object v3, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->iLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v3}, Ljava/util/concurrent/locks/Lock;->unlock()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_4

    .line 169
    :goto_2
    throw v2

    .line 168
    .restart local v0    # "WHERE_CLAUSE":Ljava/lang/String;
    :catch_3
    move-exception v2

    goto :goto_1

    .end local v0    # "WHERE_CLAUSE":Ljava/lang/String;
    :catch_4
    move-exception v3

    goto :goto_2
.end method


# virtual methods
.method public addProvider(Ljava/lang/String;)Ljava/util/List;
    .locals 5
    .param p1, "provider_name"    # Ljava/lang/String;
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
    .line 68
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->getProviders()Ljava/util/List;

    move-result-object v1

    .line 69
    .local v1, "pl":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v1, p1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 70
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 71
    .local v2, "values":Landroid/content/ContentValues;
    const-string v3, "provider"

    invoke-virtual {v2, v3, p1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 72
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_2

    .line 73
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-nez v4, :cond_1

    .line 81
    .end local v2    # "values":Landroid/content/ContentValues;
    :cond_0
    :goto_1
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->getProviders()Ljava/util/List;

    move-result-object v3

    return-object v3

    .line 73
    .restart local v2    # "values":Landroid/content/ContentValues;
    :cond_1
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 74
    .local v0, "auth":Ljava/lang/String;
    invoke-direct {p0, v2, v0}, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->addProvider(Landroid/content/ContentValues;Ljava/lang/String;)V

    goto :goto_0

    .line 78
    .end local v0    # "auth":Ljava/lang/String;
    :cond_2
    iget-object v3, p0, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->iAuthority:Ljava/lang/String;

    invoke-direct {p0, v2, v3}, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->addProvider(Landroid/content/ContentValues;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public getProviders()Ljava/util/List;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 41
    const/4 v0, 0x1

    new-array v2, v0, [Ljava/lang/String;

    const/4 v0, 0x0

    .line 42
    const-string v3, "provider"

    aput-object v3, v2, v0

    .line 44
    .local v2, "PROJECTION":[Ljava/lang/String;
    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    .line 45
    .local v8, "pl":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->iAuthority:Ljava/lang/String;

    invoke-static {v0}, Lcom/penthera/virtuososdk/database/impl/provider/Provider$ProviderColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 46
    .local v1, "provUri":Landroid/net/Uri;
    const/4 v6, 0x0

    .line 48
    .local v6, "cursor":Landroid/database/Cursor;
    :try_start_0
    iget-object v0, p0, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->resolver:Landroid/content/ContentResolver;

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 50
    if-eqz v6, :cond_1

    invoke-interface {v6}, Landroid/database/Cursor;->moveToNext()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 51
    const-string v0, "provider"

    invoke-interface {v6, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v9

    .line 53
    .local v9, "valueColumn":I
    :cond_0
    invoke-interface {v6, v9}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v8, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 54
    invoke-interface {v6}, Landroid/database/Cursor;->moveToNext()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    .line 52
    if-nez v0, :cond_0

    .line 60
    .end local v9    # "valueColumn":I
    :cond_1
    if-eqz v6, :cond_2

    .line 61
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 64
    :cond_2
    :goto_0
    return-object v8

    .line 57
    :catch_0
    move-exception v7

    .line 58
    .local v7, "e":Ljava/lang/Exception;
    :try_start_1
    sget-object v0, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->LOG_TAG:Ljava/lang/String;

    const-string v3, "Providers get exception: "

    invoke-static {v0, v3, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 60
    if-eqz v6, :cond_2

    .line 61
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    goto :goto_0

    .line 59
    .end local v7    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v0

    .line 60
    if-eqz v6, :cond_3

    .line 61
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 63
    :cond_3
    throw v0
.end method

.method public removeProvider(Ljava/lang/String;)V
    .locals 8
    .param p1, "provider"    # Ljava/lang/String;

    .prologue
    .line 122
    if-nez p1, :cond_0

    .line 148
    :goto_0
    return-void

    .line 124
    :cond_0
    :try_start_0
    sget-object v4, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->iLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v4}, Ljava/util/concurrent/locks/Lock;->lock()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 131
    :goto_1
    :try_start_1
    const-string v0, "provider=?"

    .line 132
    .local v0, "WHERE_CLAUSE":Ljava/lang/String;
    iget-object v4, p0, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->resolver:Landroid/content/ContentResolver;

    iget-object v5, p0, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->iAuthority:Ljava/lang/String;

    invoke-static {v5}, Lcom/penthera/virtuososdk/database/impl/provider/Provider$ProviderColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/String;

    const/4 v7, 0x0

    aput-object p1, v6, v7

    invoke-virtual {v4, v5, v0, v6}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    .line 134
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->getProviders()Ljava/util/List;

    move-result-object v3

    .line 135
    .local v3, "pl":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_1
    :goto_2
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v5

    if-nez v5, :cond_2

    .line 145
    :try_start_2
    sget-object v4, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->iLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v4}, Ljava/util/concurrent/locks/Lock;->unlock()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_0

    .line 146
    :catch_0
    move-exception v4

    goto :goto_0

    .line 125
    .end local v0    # "WHERE_CLAUSE":Ljava/lang/String;
    .end local v3    # "pl":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :catch_1
    move-exception v2

    .line 126
    .local v2, "e":Ljava/lang/Exception;
    sget-object v4, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->LOG_TAG:Ljava/lang/String;

    const-string v5, "Lock Failed in provider removeProvider"

    invoke-static {v4, v5, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1

    .line 135
    .end local v2    # "e":Ljava/lang/Exception;
    .restart local v0    # "WHERE_CLAUSE":Ljava/lang/String;
    .restart local v3    # "pl":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_2
    :try_start_3
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 136
    .local v1, "auth":Ljava/lang/String;
    iget-object v5, p0, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->iAuthority:Ljava/lang/String;

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_1

    .line 137
    invoke-direct {p0, p1, v1}, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->remove(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_3
    .catch Ljava/lang/IllegalArgumentException; {:try_start_3 .. :try_end_3} :catch_2
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_2

    .line 140
    .end local v0    # "WHERE_CLAUSE":Ljava/lang/String;
    .end local v1    # "auth":Ljava/lang/String;
    .end local v3    # "pl":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :catch_2
    move-exception v2

    .line 141
    .local v2, "e":Ljava/lang/IllegalArgumentException;
    :try_start_4
    sget-object v4, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->LOG_TAG:Ljava/lang/String;

    const-string v5, "removeProvider(provider): delete issue in current auth"

    invoke-static {v4, v5, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 145
    :try_start_5
    sget-object v4, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->iLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v4}, Ljava/util/concurrent/locks/Lock;->unlock()V
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_3

    goto :goto_0

    .line 146
    :catch_3
    move-exception v4

    goto :goto_0

    .line 143
    .end local v2    # "e":Ljava/lang/IllegalArgumentException;
    :catchall_0
    move-exception v4

    .line 145
    :try_start_6
    sget-object v5, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->iLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v5}, Ljava/util/concurrent/locks/Lock;->unlock()V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_4

    .line 147
    :goto_3
    throw v4

    .line 146
    :catch_4
    move-exception v5

    goto :goto_3
.end method
