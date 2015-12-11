.class public Lcom/amazon/identity/auth/device/framework/SecureContentResolver;
.super Ljava/lang/Object;
.source "SecureContentResolver.java"


# static fields
.field public static final NUM_RETRY:I = 0x1

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mContentResolver:Landroid/content/ContentResolver;

.field private final mContext:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    const-class v0, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 30
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;-><init>(Landroid/content/Context;Landroid/content/ContentResolver;)V

    .line 31
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/content/ContentResolver;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "contentResolver"    # Landroid/content/ContentResolver;

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 35
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->mContext:Landroid/content/Context;

    .line 37
    iput-object p2, p0, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->mContentResolver:Landroid/content/ContentResolver;

    .line 38
    return-void
.end method

.method private logExceptionError(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "method"    # Ljava/lang/String;
    .param p2, "exception"    # Ljava/lang/String;

    .prologue
    .line 237
    sget-object v0, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ": Remote ContentResolver threw exception: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 238
    return-void
.end method

.method private logSecurityException(Ljava/lang/SecurityException;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/SecurityException;

    .prologue
    .line 242
    sget-object v0, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "SecurityException while accessing content provider. This error usually means that there are multiple MAP enabled apps signed with different certificates on the device. Please uninstall all MAP enabled apps, and reinstall only apps which share the same certificate."

    invoke-static {v0, v1, p1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 245
    return-void
.end method


# virtual methods
.method public acquireContentProviderClient(Landroid/net/Uri;Lcom/amazon/identity/auth/device/framework/ContentProviderClientCallback;)Ljava/lang/Object;
    .locals 8
    .param p1, "uri"    # Landroid/net/Uri;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Landroid/net/Uri;",
            "Lcom/amazon/identity/auth/device/framework/ContentProviderClientCallback",
            "<TT;>;)TT;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/util/concurrent/ExecutionException;
        }
    .end annotation

    .prologue
    .line 155
    .local p2, "callback":Lcom/amazon/identity/auth/device/framework/ContentProviderClientCallback;, "Lcom/amazon/identity/auth/device/framework/ContentProviderClientCallback<TT;>;"
    :try_start_0
    iget-object v5, p0, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->mContext:Landroid/content/Context;

    invoke-static {v5, p1}, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->checkIsAmazonOwnedContentProvider(Landroid/content/Context;Landroid/net/Uri;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 163
    const/4 v4, 0x0

    .line 166
    .local v4, "retryCount":I
    :goto_0
    const/4 v2, 0x0

    .line 175
    .local v2, "client":Landroid/content/ContentProviderClient;
    invoke-static {}, Landroid/os/Binder;->clearCallingIdentity()J

    move-result-wide v0

    .line 178
    .local v0, "callingIdentity":J
    :try_start_1
    sget v5, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v6, 0x10

    if-lt v5, v6, :cond_1

    .line 183
    iget-object v5, p0, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->mContentResolver:Landroid/content/ContentResolver;

    invoke-virtual {v5, p1}, Landroid/content/ContentResolver;->acquireUnstableContentProviderClient(Landroid/net/Uri;)Landroid/content/ContentProviderClient;

    move-result-object v2

    .line 190
    :goto_1
    invoke-interface {p2, v2}, Lcom/amazon/identity/auth/device/framework/ContentProviderClientCallback;->useContentProviderClient(Landroid/content/ContentProviderClient;)Ljava/lang/Object;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v5

    .line 210
    if-eqz v2, :cond_0

    .line 212
    invoke-virtual {v2}, Landroid/content/ContentProviderClient;->release()Z

    .line 216
    :cond_0
    invoke-static {v0, v1}, Landroid/os/Binder;->restoreCallingIdentity(J)V

    return-object v5

    .line 157
    .end local v0    # "callingIdentity":J
    .end local v2    # "client":Landroid/content/ContentProviderClient;
    .end local v4    # "retryCount":I
    :catch_0
    move-exception v3

    .line 161
    .local v3, "e":Ljava/lang/Exception;
    new-instance v5, Ljava/util/concurrent/ExecutionException;

    invoke-direct {v5, v3}, Ljava/util/concurrent/ExecutionException;-><init>(Ljava/lang/Throwable;)V

    throw v5

    .line 187
    .end local v3    # "e":Ljava/lang/Exception;
    .restart local v0    # "callingIdentity":J
    .restart local v2    # "client":Landroid/content/ContentProviderClient;
    .restart local v4    # "retryCount":I
    :cond_1
    :try_start_2
    iget-object v5, p0, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->mContentResolver:Landroid/content/ContentResolver;

    invoke-virtual {v5, p1}, Landroid/content/ContentResolver;->acquireContentProviderClient(Landroid/net/Uri;)Landroid/content/ContentProviderClient;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v2

    goto :goto_1

    .line 192
    :catch_1
    move-exception v3

    .line 194
    .restart local v3    # "e":Ljava/lang/Exception;
    if-lez v4, :cond_3

    .line 196
    :try_start_3
    sget-object v5, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "Got exception querying content provider. Failing after "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, " retries."

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 199
    const-string/jumbo v5, "ContentProviderFailure"

    const/4 v6, 0x0

    new-array v6, v6, [Ljava/lang/String;

    invoke-static {v5, v6}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 200
    new-instance v5, Ljava/util/concurrent/ExecutionException;

    invoke-direct {v5, v3}, Ljava/util/concurrent/ExecutionException;-><init>(Ljava/lang/Throwable;)V

    throw v5
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 210
    .end local v3    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v5

    if-eqz v2, :cond_2

    .line 212
    invoke-virtual {v2}, Landroid/content/ContentProviderClient;->release()Z

    .line 216
    :cond_2
    invoke-static {v0, v1}, Landroid/os/Binder;->restoreCallingIdentity(J)V

    throw v5

    .line 204
    .restart local v3    # "e":Ljava/lang/Exception;
    :cond_3
    :try_start_4
    sget-object v5, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Got exception querying content provider. Retrying."

    invoke-static {v5, v6, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 205
    const-string/jumbo v5, "ContentProviderRetry"

    const/4 v6, 0x0

    new-array v6, v6, [Ljava/lang/String;

    invoke-static {v5, v6}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 210
    if-eqz v2, :cond_4

    .line 212
    invoke-virtual {v2}, Landroid/content/ContentProviderClient;->release()Z

    .line 216
    :cond_4
    invoke-static {v0, v1}, Landroid/os/Binder;->restoreCallingIdentity(J)V

    .line 221
    if-gtz v4, :cond_5

    .line 223
    const-wide/16 v5, 0xa

    :try_start_5
    invoke-static {v5, v6}, Ljava/lang/Thread;->sleep(J)V
    :try_end_5
    .catch Ljava/lang/InterruptedException; {:try_start_5 .. :try_end_5} :catch_2

    .line 231
    .end local v3    # "e":Ljava/lang/Exception;
    :cond_5
    :goto_2
    add-int/lit8 v4, v4, 0x1

    .line 232
    goto/16 :goto_0

    .line 226
    .restart local v3    # "e":Ljava/lang/Exception;
    :catch_2
    move-exception v3

    .line 228
    .local v3, "e":Ljava/lang/InterruptedException;
    sget-object v5, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Got an InterruptedException while retrying calling Generic IPC central store."

    invoke-static {v5, v6, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_2
.end method

.method public delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 3
    .param p1, "url"    # Landroid/net/Uri;
    .param p2, "where"    # Ljava/lang/String;
    .param p3, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 79
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->mContext:Landroid/content/Context;

    invoke-static {v2, p1}, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->checkIsAmazonOwnedContentProvider(Landroid/content/Context;Landroid/net/Uri;)V

    .line 80
    const-string/jumbo v1, "delete()"

    .line 83
    .local v1, "method":Ljava/lang/String;
    :try_start_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->mContentResolver:Landroid/content/ContentResolver;

    invoke-virtual {v2, p1, p2, p3}, Landroid/content/ContentResolver;->delete(Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_1

    move-result v2

    .line 95
    :goto_0
    return v2

    .line 85
    :catch_0
    move-exception v0

    .line 87
    .local v0, "e":Ljava/lang/IllegalStateException;
    invoke-virtual {v0}, Ljava/lang/IllegalStateException;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->logExceptionError(Ljava/lang/String;Ljava/lang/String;)V

    .line 95
    const/4 v2, 0x0

    goto :goto_0

    .line 90
    .end local v0    # "e":Ljava/lang/IllegalStateException;
    :catch_1
    move-exception v0

    .line 92
    .local v0, "e":Ljava/lang/SecurityException;
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->logSecurityException(Ljava/lang/SecurityException;)V

    .line 93
    throw v0
.end method

.method public insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    .locals 3
    .param p1, "url"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;

    .prologue
    .line 100
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->mContext:Landroid/content/Context;

    invoke-static {v2, p1}, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->checkIsAmazonOwnedContentProvider(Landroid/content/Context;Landroid/net/Uri;)V

    .line 101
    const-string/jumbo v1, "insert()"

    .line 104
    .local v1, "method":Ljava/lang/String;
    :try_start_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->mContentResolver:Landroid/content/ContentResolver;

    invoke-virtual {v2, p1, p2}, Landroid/content/ContentResolver;->insert(Landroid/net/Uri;Landroid/content/ContentValues;)Landroid/net/Uri;
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v2

    .line 116
    :goto_0
    return-object v2

    .line 106
    :catch_0
    move-exception v0

    .line 108
    .local v0, "e":Ljava/lang/IllegalStateException;
    invoke-virtual {v0}, Ljava/lang/IllegalStateException;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->logExceptionError(Ljava/lang/String;Ljava/lang/String;)V

    .line 116
    const/4 v2, 0x0

    goto :goto_0

    .line 111
    .end local v0    # "e":Ljava/lang/IllegalStateException;
    :catch_1
    move-exception v0

    .line 113
    .local v0, "e":Ljava/lang/SecurityException;
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->logSecurityException(Ljava/lang/SecurityException;)V

    .line 114
    throw v0
.end method

.method public query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    .locals 8
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "projection"    # [Ljava/lang/String;
    .param p3, "selection"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;
    .param p5, "sortOrder"    # Ljava/lang/String;

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->mContext:Landroid/content/Context;

    invoke-static {v0, p1}, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->checkIsAmazonOwnedContentProvider(Landroid/content/Context;Landroid/net/Uri;)V

    .line 59
    const-string/jumbo v7, "query()"

    .line 62
    .local v7, "method":Ljava/lang/String;
    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->mContentResolver:Landroid/content/ContentResolver;

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v0

    .line 74
    :goto_0
    return-object v0

    .line 64
    :catch_0
    move-exception v6

    .line 66
    .local v6, "e":Ljava/lang/IllegalStateException;
    invoke-virtual {v6}, Ljava/lang/IllegalStateException;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v7, v0}, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->logExceptionError(Ljava/lang/String;Ljava/lang/String;)V

    .line 74
    const/4 v0, 0x0

    goto :goto_0

    .line 69
    .end local v6    # "e":Ljava/lang/IllegalStateException;
    :catch_1
    move-exception v6

    .line 71
    .local v6, "e":Ljava/lang/SecurityException;
    invoke-direct {p0, v6}, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->logSecurityException(Ljava/lang/SecurityException;)V

    .line 72
    throw v6
.end method

.method public update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    .locals 3
    .param p1, "uri"    # Landroid/net/Uri;
    .param p2, "values"    # Landroid/content/ContentValues;
    .param p3, "where"    # Ljava/lang/String;
    .param p4, "selectionArgs"    # [Ljava/lang/String;

    .prologue
    .line 121
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->mContext:Landroid/content/Context;

    invoke-static {v2, p1}, Lcom/amazon/identity/auth/device/utils/SecurityHelpers;->checkIsAmazonOwnedContentProvider(Landroid/content/Context;Landroid/net/Uri;)V

    .line 122
    const-string/jumbo v1, "update()"

    .line 125
    .local v1, "method":Ljava/lang/String;
    :try_start_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->mContentResolver:Landroid/content/ContentResolver;

    invoke-virtual {v2, p1, p2, p3, p4}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_1

    move-result v2

    .line 137
    :goto_0
    return v2

    .line 127
    :catch_0
    move-exception v0

    .line 129
    .local v0, "e":Ljava/lang/IllegalStateException;
    invoke-virtual {v0}, Ljava/lang/IllegalStateException;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->logExceptionError(Ljava/lang/String;Ljava/lang/String;)V

    .line 137
    const/4 v2, 0x0

    goto :goto_0

    .line 132
    .end local v0    # "e":Ljava/lang/IllegalStateException;
    :catch_1
    move-exception v0

    .line 134
    .local v0, "e":Ljava/lang/SecurityException;
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/framework/SecureContentResolver;->logSecurityException(Ljava/lang/SecurityException;)V

    .line 135
    throw v0
.end method
