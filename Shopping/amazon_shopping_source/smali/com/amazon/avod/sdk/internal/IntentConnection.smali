.class public Lcom/amazon/avod/sdk/internal/IntentConnection;
.super Ljava/lang/Object;
.source "IntentConnection.java"

# interfaces
.implements Lcom/amazon/avod/sdk/internal/AivConnection;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/avod/sdk/internal/IntentConnection$ActivityStarter;
    }
.end annotation


# static fields
.field private static final NO_ASIN_REQUIRED:Ljava/lang/String;

.field private static final NO_SELECTION:Ljava/lang/String;

.field private static final NO_SELECTION_ARGS:[Ljava/lang/String;

.field private static final NO_SORT_ORDER:Ljava/lang/String;


# instance fields
.field private final mActivityStarter:Lcom/amazon/avod/sdk/internal/IntentConnection$ActivityStarter;

.field private final mContext:Landroid/content/Context;

.field private final mUiHandler:Landroid/os/Handler;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 54
    sput-object v0, Lcom/amazon/avod/sdk/internal/IntentConnection;->NO_SELECTION:Ljava/lang/String;

    .line 55
    sput-object v0, Lcom/amazon/avod/sdk/internal/IntentConnection;->NO_SELECTION_ARGS:[Ljava/lang/String;

    .line 56
    sput-object v0, Lcom/amazon/avod/sdk/internal/IntentConnection;->NO_SORT_ORDER:Ljava/lang/String;

    .line 58
    sput-object v0, Lcom/amazon/avod/sdk/internal/IntentConnection;->NO_ASIN_REQUIRED:Ljava/lang/String;

    return-void
.end method

.method constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 67
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    new-instance v1, Lcom/amazon/avod/sdk/internal/IntentConnection$ActivityStarter;

    const/4 v2, 0x0

    invoke-direct {v1, v2}, Lcom/amazon/avod/sdk/internal/IntentConnection$ActivityStarter;-><init>(Lcom/amazon/avod/sdk/internal/IntentConnection$1;)V

    invoke-direct {p0, p1, v0, v1}, Lcom/amazon/avod/sdk/internal/IntentConnection;-><init>(Landroid/content/Context;Landroid/os/Handler;Lcom/amazon/avod/sdk/internal/IntentConnection$ActivityStarter;)V

    .line 68
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;Landroid/os/Handler;Lcom/amazon/avod/sdk/internal/IntentConnection$ActivityStarter;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "uiHandler"    # Landroid/os/Handler;
    .param p3, "activityStarter"    # Lcom/amazon/avod/sdk/internal/IntentConnection$ActivityStarter;

    .prologue
    .line 70
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 71
    iput-object p1, p0, Lcom/amazon/avod/sdk/internal/IntentConnection;->mContext:Landroid/content/Context;

    .line 72
    iput-object p2, p0, Lcom/amazon/avod/sdk/internal/IntentConnection;->mUiHandler:Landroid/os/Handler;

    .line 73
    iput-object p3, p0, Lcom/amazon/avod/sdk/internal/IntentConnection;->mActivityStarter:Lcom/amazon/avod/sdk/internal/IntentConnection$ActivityStarter;

    .line 74
    return-void
.end method

.method private getIntent(Lcom/amazon/avod/sdk/internal/ModulePath;Ljava/lang/String;Lcom/amazon/avod/sdk/internal/IntentColumn;)Ljava/lang/String;
    .locals 5
    .param p1, "path"    # Lcom/amazon/avod/sdk/internal/ModulePath;
    .param p2, "id"    # Ljava/lang/String;
    .param p3, "column"    # Lcom/amazon/avod/sdk/internal/IntentColumn;

    .prologue
    .line 282
    const-string/jumbo v1, "%s/%s/%s"

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    const-string/jumbo v4, "content://com.amazon.avod.intent"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    invoke-virtual {p1}, Lcom/amazon/avod/sdk/internal/ModulePath;->get()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x2

    aput-object p2, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 283
    .local v0, "uriString":Ljava/lang/String;
    invoke-direct {p0, v0, p3}, Lcom/amazon/avod/sdk/internal/IntentConnection;->makeProviderRequest(Ljava/lang/String;Lcom/amazon/avod/sdk/internal/IntentColumn;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private getIntent(Lcom/amazon/avod/sdk/internal/ModulePath;Ljava/lang/String;Ljava/util/Map;Lcom/amazon/avod/sdk/internal/IntentColumn;)Ljava/lang/String;
    .locals 10
    .param p1, "path"    # Lcom/amazon/avod/sdk/internal/ModulePath;
    .param p2, "id"    # Ljava/lang/String;
    .param p4, "column"    # Lcom/amazon/avod/sdk/internal/IntentColumn;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/avod/sdk/internal/ModulePath;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/avod/sdk/internal/IntentColumn;",
            ")",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .local p3, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v9, 0x2

    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 299
    const-string/jumbo v4, "%s/%s/%s"

    const/4 v5, 0x3

    new-array v5, v5, [Ljava/lang/Object;

    const-string/jumbo v6, "content://com.amazon.avod.intent"

    aput-object v6, v5, v7

    invoke-virtual {p1}, Lcom/amazon/avod/sdk/internal/ModulePath;->get()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v8

    aput-object p2, v5, v9

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 300
    .local v2, "uriString":Ljava/lang/String;
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 301
    .local v3, "uriStringBuilder":Ljava/lang/StringBuilder;
    invoke-interface {p3}, Ljava/util/Map;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_0

    .line 302
    const-string/jumbo v4, "?"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 303
    invoke-interface {p3}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 304
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v4, "%s=%s&"

    new-array v5, v9, [Ljava/lang/Object;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    aput-object v6, v5, v8

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 307
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_0
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {p0, v4, p4}, Lcom/amazon/avod/sdk/internal/IntentConnection;->makeProviderRequest(Ljava/lang/String;Lcom/amazon/avod/sdk/internal/IntentColumn;)Ljava/lang/String;

    move-result-object v4

    return-object v4
.end method

.method private goToApp(Ljava/lang/String;)V
    .locals 8
    .param p1, "intentUri"    # Ljava/lang/String;

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 223
    :try_start_0
    const-string/jumbo v2, "AmazonInstantVideoSDK"

    const-string/jumbo v3, "Invoking AIV intent to go to app: %s"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object p1, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 224
    const/4 v2, 0x0

    invoke-static {p1, v2}, Landroid/content/Intent;->parseUri(Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v1

    .line 225
    .local v1, "intent":Landroid/content/Intent;
    iget-object v2, p0, Lcom/amazon/avod/sdk/internal/IntentConnection;->mActivityStarter:Lcom/amazon/avod/sdk/internal/IntentConnection$ActivityStarter;

    iget-object v3, p0, Lcom/amazon/avod/sdk/internal/IntentConnection;->mContext:Landroid/content/Context;

    invoke-virtual {v2, v3, v1}, Lcom/amazon/avod/sdk/internal/IntentConnection$ActivityStarter;->startActivity(Landroid/content/Context;Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    .line 229
    .end local v1    # "intent":Landroid/content/Intent;
    :goto_0
    return-void

    .line 226
    :catch_0
    move-exception v0

    .line 227
    .local v0, "e":Ljava/net/URISyntaxException;
    const-string/jumbo v2, "AmazonInstantVideoSDK"

    const-string/jumbo v3, "AIV app provided invalid intent uri to activity launcher: %s"

    new-array v4, v7, [Ljava/lang/Object;

    aput-object p1, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method private informApp(Ljava/lang/String;Lcom/amazon/avod/sdk/ResponseHandler;)V
    .locals 11
    .param p1, "intentUri"    # Ljava/lang/String;
    .param p2, "responseHandler"    # Lcom/amazon/avod/sdk/ResponseHandler;

    .prologue
    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 241
    :try_start_0
    const-string/jumbo v0, "AmazonInstantVideoSDK"

    const-string/jumbo v2, "Invoking AIV intent to inform app: %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object p1, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 242
    const/4 v0, 0x0

    invoke-static {p1, v0}, Landroid/content/Intent;->parseUri(Ljava/lang/String;I)Landroid/content/Intent;

    move-result-object v1

    .line 244
    .local v1, "intent":Landroid/content/Intent;
    iget-object v0, p0, Lcom/amazon/avod/sdk/internal/IntentConnection;->mContext:Landroid/content/Context;

    const-string/jumbo v2, "com.amazon.avod.SDK_ACCESS"

    new-instance v3, Lcom/amazon/avod/sdk/internal/IntentConnection$2;

    invoke-direct {v3, p0, p2}, Lcom/amazon/avod/sdk/internal/IntentConnection$2;-><init>(Lcom/amazon/avod/sdk/internal/IntentConnection;Lcom/amazon/avod/sdk/ResponseHandler;)V

    const/4 v4, 0x0

    const/4 v5, -0x1

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual/range {v0 .. v7}, Landroid/content/Context;->sendOrderedBroadcast(Landroid/content/Intent;Ljava/lang/String;Landroid/content/BroadcastReceiver;Landroid/os/Handler;ILjava/lang/String;Landroid/os/Bundle;)V
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    .line 257
    .end local v1    # "intent":Landroid/content/Intent;
    :goto_0
    return-void

    .line 254
    :catch_0
    move-exception v8

    .line 255
    .local v8, "e":Ljava/net/URISyntaxException;
    const-string/jumbo v0, "AmazonInstantVideoSDK"

    const-string/jumbo v2, "AIV app provided invalid intent uri to activity launcher: %s"

    new-array v3, v10, [Ljava/lang/Object;

    aput-object p1, v3, v9

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method private static join(Ljava/lang/String;Ljava/lang/Iterable;)Ljava/lang/String;
    .locals 3
    .param p0, "separator"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/Iterable",
            "<*>;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 355
    .local p1, "parts":Ljava/lang/Iterable;, "Ljava/lang/Iterable<*>;"
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 357
    .local v0, "builder":Ljava/lang/StringBuilder;
    invoke-interface {p1}, Ljava/lang/Iterable;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 358
    .local v1, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<*>;"
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 359
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 360
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 361
    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 362
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 365
    :cond_0
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method private makeProviderRequest(Ljava/lang/String;Lcom/amazon/avod/sdk/internal/IntentColumn;)Ljava/lang/String;
    .locals 9
    .param p1, "uriString"    # Ljava/lang/String;
    .param p2, "column"    # Lcom/amazon/avod/sdk/internal/IntentColumn;

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 320
    iget-object v1, p0, Lcom/amazon/avod/sdk/internal/IntentConnection;->mContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 321
    .local v0, "resolver":Landroid/content/ContentResolver;
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    new-array v2, v8, [Ljava/lang/String;

    invoke-interface {p2}, Lcom/amazon/avod/sdk/internal/IntentColumn;->getColumnName()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v7

    sget-object v3, Lcom/amazon/avod/sdk/internal/IntentConnection;->NO_SELECTION:Ljava/lang/String;

    sget-object v4, Lcom/amazon/avod/sdk/internal/IntentConnection;->NO_SELECTION_ARGS:[Ljava/lang/String;

    sget-object v5, Lcom/amazon/avod/sdk/internal/IntentConnection;->NO_SORT_ORDER:Ljava/lang/String;

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v6

    .line 325
    .local v6, "cursor":Landroid/database/Cursor;
    if-eqz v6, :cond_1

    .line 327
    :try_start_0
    invoke-interface {v6}, Landroid/database/Cursor;->moveToNext()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 328
    const/4 v1, 0x0

    invoke-interface {v6, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 332
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 339
    :goto_0
    return-object v1

    .line 332
    :cond_0
    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    .line 336
    :cond_1
    const-string/jumbo v1, "AmazonInstantVideoSDK"

    const-string/jumbo v2, "com.amazon.avod.intent content provider returned null or empty cursor {URI=%s COLUMN=%s}"

    const/4 v3, 0x2

    new-array v3, v3, [Ljava/lang/Object;

    aput-object p1, v3, v7

    aput-object p2, v3, v8

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 339
    const/4 v1, 0x0

    goto :goto_0

    .line 332
    :catchall_0
    move-exception v1

    invoke-interface {v6}, Landroid/database/Cursor;->close()V

    throw v1
.end method


# virtual methods
.method public disconnect()V
    .locals 0

    .prologue
    .line 88
    return-void
.end method

.method public playVideo(Ljava/lang/String;Ljava/util/Map;)V
    .locals 2
    .param p1, "asin"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 92
    .local p2, "params":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    sget-object v0, Lcom/amazon/avod/sdk/internal/ModulePath;->ITEM:Lcom/amazon/avod/sdk/internal/ModulePath;

    sget-object v1, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->PLAY_VIDEO:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    invoke-direct {p0, v0, p1, p2, v1}, Lcom/amazon/avod/sdk/internal/IntentConnection;->getIntent(Lcom/amazon/avod/sdk/internal/ModulePath;Ljava/lang/String;Ljava/util/Map;Lcom/amazon/avod/sdk/internal/IntentColumn;)Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/avod/sdk/internal/IntentConnection;->goToApp(Ljava/lang/String;)V

    .line 93
    return-void
.end method

.method public queryPlaybackSupport(Lcom/amazon/avod/sdk/PlaybackSupportResponse;)V
    .locals 3
    .param p1, "callback"    # Lcom/amazon/avod/sdk/PlaybackSupportResponse;

    .prologue
    .line 105
    sget-object v0, Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;->FULL_SUPPORT:Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;

    .line 106
    .local v0, "support":Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;
    iget-object v1, p0, Lcom/amazon/avod/sdk/internal/IntentConnection;->mUiHandler:Landroid/os/Handler;

    new-instance v2, Lcom/amazon/avod/sdk/internal/IntentConnection$1;

    invoke-direct {v2, p0, p1, v0}, Lcom/amazon/avod/sdk/internal/IntentConnection$1;-><init>(Lcom/amazon/avod/sdk/internal/IntentConnection;Lcom/amazon/avod/sdk/PlaybackSupportResponse;Lcom/amazon/avod/sdk/PlaybackSupportResponse$PlaybackSupport;)V

    invoke-virtual {v1, v2}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 112
    return-void
.end method

.method public teardownPreparedVideo(Lcom/amazon/avod/sdk/ResponseHandler;)V
    .locals 4
    .param p1, "handler"    # Lcom/amazon/avod/sdk/ResponseHandler;

    .prologue
    .line 125
    sget-object v1, Lcom/amazon/avod/sdk/internal/ModulePath;->ITEM:Lcom/amazon/avod/sdk/internal/ModulePath;

    sget-object v2, Lcom/amazon/avod/sdk/internal/IntentConnection;->NO_ASIN_REQUIRED:Ljava/lang/String;

    sget-object v3, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->TEARDOWN_PLAYER:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    invoke-direct {p0, v1, v2, v3}, Lcom/amazon/avod/sdk/internal/IntentConnection;->getIntent(Lcom/amazon/avod/sdk/internal/ModulePath;Ljava/lang/String;Lcom/amazon/avod/sdk/internal/IntentColumn;)Ljava/lang/String;

    move-result-object v0

    .line 126
    .local v0, "intent":Ljava/lang/String;
    invoke-direct {p0, v0, p1}, Lcom/amazon/avod/sdk/internal/IntentConnection;->informApp(Ljava/lang/String;Lcom/amazon/avod/sdk/ResponseHandler;)V

    .line 127
    return-void
.end method

.method public tryConnect()Z
    .locals 1

    .prologue
    .line 82
    const/4 v0, 0x1

    return v0
.end method

.method public whisperCacheContent(Ljava/util/List;Lcom/amazon/avod/sdk/CacheLevel;)V
    .locals 5
    .param p2, "cacheLevel"    # Lcom/amazon/avod/sdk/CacheLevel;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/avod/sdk/CacheLevel;",
            ")V"
        }
    .end annotation

    .prologue
    .line 131
    .local p1, "asins":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    new-instance v1, Ljava/util/HashMap;

    const/4 v2, 0x2

    invoke-direct {v1, v2}, Ljava/util/HashMap;-><init>(I)V

    .line 132
    .local v1, "parameters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v2, "asinList"

    const-string/jumbo v3, ","

    invoke-static {v3, p1}, Lcom/amazon/avod/sdk/internal/IntentConnection;->join(Ljava/lang/String;Ljava/lang/Iterable;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 133
    const-string/jumbo v2, "whisperCacheLevel"

    invoke-virtual {p2}, Lcom/amazon/avod/sdk/CacheLevel;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 134
    const-string/jumbo v2, "entryPoint"

    const-string/jumbo v3, "SDK"

    invoke-interface {v1, v2, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 135
    sget-object v2, Lcom/amazon/avod/sdk/internal/ModulePath;->ITEM:Lcom/amazon/avod/sdk/internal/ModulePath;

    sget-object v3, Lcom/amazon/avod/sdk/internal/IntentConnection;->NO_ASIN_REQUIRED:Ljava/lang/String;

    sget-object v4, Lcom/amazon/avod/sdk/internal/ItemIntentColumn;->WHISPER_CACHE_CONTENT:Lcom/amazon/avod/sdk/internal/ItemIntentColumn;

    invoke-direct {p0, v2, v3, v1, v4}, Lcom/amazon/avod/sdk/internal/IntentConnection;->getIntent(Lcom/amazon/avod/sdk/internal/ModulePath;Ljava/lang/String;Ljava/util/Map;Lcom/amazon/avod/sdk/internal/IntentColumn;)Ljava/lang/String;

    move-result-object v0

    .line 137
    .local v0, "intent":Ljava/lang/String;
    const/4 v2, 0x0

    invoke-direct {p0, v0, v2}, Lcom/amazon/avod/sdk/internal/IntentConnection;->informApp(Ljava/lang/String;Lcom/amazon/avod/sdk/ResponseHandler;)V

    .line 138
    return-void
.end method
