.class public Lcom/amazon/mShop/android/platform/content/ProxyContentProvider;
.super Landroid/content/ContentProvider;
.source "ProxyContentProvider.java"


# instance fields
.field private mDelegate:Lcom/amazon/mShop/android/platform/content/ContentProviderDelegateBase;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/mShop/android/platform/content/ContentProviderDelegateBase",
            "<",
            "Lcom/amazon/mShop/android/platform/content/ProxyContentProvider;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Landroid/content/ContentProvider;-><init>()V

    return-void
.end method

.method private declared-synchronized getDelegate()Lcom/amazon/mShop/android/platform/content/ContentProviderDelegateBase;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/mShop/android/platform/content/ContentProviderDelegateBase",
            "<",
            "Lcom/amazon/mShop/android/platform/content/ProxyContentProvider;",
            ">;"
        }
    .end annotation

    .prologue
    .line 17
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/android/platform/content/ProxyContentProvider;->mDelegate:Lcom/amazon/mShop/android/platform/content/ContentProviderDelegateBase;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v1, :cond_0

    .line 19
    :try_start_1
    invoke-static {}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->getInstance()Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;

    move-result-object v1

    invoke-virtual {v1, p0}, Lcom/amazon/mShop/android/platform/dex/SecondDexEntry;->createContentProviderDelegate(Landroid/content/ContentProvider;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/android/platform/content/ContentProviderDelegateBase;

    iput-object v1, p0, Lcom/amazon/mShop/android/platform/content/ProxyContentProvider;->mDelegate:Lcom/amazon/mShop/android/platform/content/ContentProviderDelegateBase;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 26
    :cond_0
    :goto_0
    :try_start_2
    iget-object v1, p0, Lcom/amazon/mShop/android/platform/content/ProxyContentProvider;->mDelegate:Lcom/amazon/mShop/android/platform/content/ContentProviderDelegateBase;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    monitor-exit p0

    return-object v1

    .line 20
    :catch_0
    move-exception v0

    .line 23
    .local v0, "e":Ljava/lang/Exception;
    :try_start_3
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v0}, Lcom/amazon/mShop/android/platform/dex/ExceptionUtil;->reportExceptions(Ljava/lang/String;Ljava/lang/Exception;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 17
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method


# virtual methods
.method public delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "selection"    # Ljava/lang/String;
    .param p3, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/amazon/mShop/android/platform/content/ProxyContentProvider;->getDelegate()Lcom/amazon/mShop/android/platform/content/ContentProviderDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/mShop/android/platform/content/ContentProviderDelegateBase;->delete_impl(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public getType(Landroid/net/Uri;)Ljava/lang/String;
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/amazon/mShop/android/platform/content/ProxyContentProvider;->getDelegate()Lcom/amazon/mShop/android/platform/content/ContentProviderDelegateBase;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/android/platform/content/ProxyContentProvider;->getDelegate()Lcom/amazon/mShop/android/platform/content/ContentProviderDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/android/platform/content/ContentProviderDelegateBase;->getType_impl(Landroid/net/Uri;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;

    .prologue
    .line 69
    invoke-direct {p0}, Lcom/amazon/mShop/android/platform/content/ProxyContentProvider;->getDelegate()Lcom/amazon/mShop/android/platform/content/ContentProviderDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/amazon/mShop/android/platform/content/ContentProviderDelegateBase;->insert_impl(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;

    move-result-object v0

    return-object v0
.end method

.method public onCreate()Z
    .locals 1

    .prologue
    .line 39
    const/4 v0, 0x1

    return v0
.end method

.method public query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 6
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "projection"    # [Ljava/lang/String;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;
    .param p5, "sortOrder"    # Ljava/lang/String;

    .prologue
    .line 79
    invoke-direct {p0}, Lcom/amazon/mShop/android/platform/content/ProxyContentProvider;->getDelegate()Lcom/amazon/mShop/android/platform/content/ContentProviderDelegateBase;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/android/platform/content/ProxyContentProvider;->getDelegate()Lcom/amazon/mShop/android/platform/content/ContentProviderDelegateBase;

    move-result-object v0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/mShop/android/platform/content/ContentProviderDelegateBase;->query_impl(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v0

    goto :goto_0
.end method

.method public update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 1
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 89
    invoke-direct {p0}, Lcom/amazon/mShop/android/platform/content/ProxyContentProvider;->getDelegate()Lcom/amazon/mShop/android/platform/content/ContentProviderDelegateBase;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/amazon/mShop/android/platform/content/ContentProviderDelegateBase;->update_impl(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I

    move-result v0

    return v0
.end method
