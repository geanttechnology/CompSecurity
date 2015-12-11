.class public final Lcom/adobe/adms/testandtarget/MboxFactory;
.super Ljava/lang/Object;
.source "MboxFactory.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/adms/testandtarget/MboxFactory$TargetBackgroundTask;,
        Lcom/adobe/adms/testandtarget/MboxFactory$TargetCallback;,
        Lcom/adobe/adms/testandtarget/MboxFactory$RecordEventTask;
    }
.end annotation


# static fields
.field private static final BUFFER_SIZE:I = 0x200

.field private static final COOKIE_EXPIRES_KEY_SUFFIX:Ljava/lang/String; = "_Expires"

.field private static final COOKIE_VALUE_KEY_SUFFIX:Ljava/lang/String; = "_Value"

.field private static final DEFAULT_DISABLE_DURATION:J = 0xdbba0L

.field private static final LOG_TAG:Ljava/lang/String; = "MboxFactory"

.field private static final MBOX_DEFAULT:Ljava/lang/String; = "/images/log.gif"

.field private static final MBOX_DEFAULT_CONTENT_TYPE:Ljava/lang/String; = "image/gif"

.field private static final MBOX_SERVER_PROTOCOL:Ljava/lang/String; = "http://"

.field private static final MBOX_SERVER_SUFFIX:Ljava/lang/String; = ".tt.omtrdc.net"

.field private static final OFFER_ENCODING:Ljava/lang/String; = "UTF-8"

.field private static final PREFERENCES_DISABLE_KEY:Ljava/lang/String; = "DisableTime"

.field private static final PREFERENCES_PREFIX:Ljava/lang/String; = "TestAndTarget"

.field protected static final USER_AGENT:Ljava/lang/String; = "Apache-HttpClient (Test&Target Android SDK)"


# instance fields
.field private clientCode:Ljava/lang/String;

.field private cookies:Ljava/lang/String;

.field private disableDuration:J

.field private factoryEnabled:Z

.field private mboxList:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/adobe/adms/testandtarget/Mbox;",
            ">;"
        }
    .end annotation
.end field

.field private mboxServerURL:Ljava/lang/String;

.field private parentContext:Landroid/content/Context;

.field private preferences:Landroid/content/SharedPreferences;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 2
    .param p1, "parentContext"    # Landroid/content/Context;
    .param p2, "clientCode"    # Ljava/lang/String;

    .prologue
    .line 128
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 111
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->mboxList:Ljava/util/concurrent/ConcurrentHashMap;

    .line 129
    if-nez p1, :cond_0

    .line 130
    const-string v0, "TARGET"

    const-string v1, "Parameter \'parentContext\' in MboxFactory() cannot be null"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 147
    :goto_0
    return-void

    .line 134
    :cond_0
    if-eqz p2, :cond_1

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_2

    .line 135
    :cond_1
    const-string v0, "TARGET"

    const-string v1, "Parameter \'clientCode\' in MboxFactory() cannot be null or empty"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 139
    :cond_2
    iput-object p1, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->parentContext:Landroid/content/Context;

    .line 140
    iput-object p2, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->clientCode:Ljava/lang/String;

    .line 141
    const-wide/32 v0, 0xdbba0

    iput-wide v0, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->disableDuration:J

    .line 142
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->factoryEnabled:Z

    .line 143
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "http://"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ".tt.omtrdc.net"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->mboxServerURL:Ljava/lang/String;

    .line 144
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "TestAndTarget"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->preferences:Landroid/content/SharedPreferences;

    .line 145
    const-string v0, "mboxPC"

    invoke-direct {p0, v0}, Lcom/adobe/adms/testandtarget/MboxFactory;->loadCookie(Ljava/lang/String;)V

    .line 146
    const-string v0, "mboxSession"

    invoke-direct {p0, v0}, Lcom/adobe/adms/testandtarget/MboxFactory;->loadCookie(Ljava/lang/String;)V

    goto :goto_0
.end method

.method static synthetic access$000(Lcom/adobe/adms/testandtarget/MboxFactory;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/adobe/adms/testandtarget/MboxFactory;

    .prologue
    .line 36
    iget-object v0, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->cookies:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100(Lcom/adobe/adms/testandtarget/MboxFactory;Lorg/apache/http/client/CookieStore;)V
    .locals 0
    .param p0, "x0"    # Lcom/adobe/adms/testandtarget/MboxFactory;
    .param p1, "x1"    # Lorg/apache/http/client/CookieStore;

    .prologue
    .line 36
    invoke-direct {p0, p1}, Lcom/adobe/adms/testandtarget/MboxFactory;->saveCookies(Lorg/apache/http/client/CookieStore;)V

    return-void
.end method

.method private deleteCookie(Ljava/lang/String;)V
    .locals 3
    .param p1, "cookieName"    # Ljava/lang/String;

    .prologue
    .line 410
    iget-object v1, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->preferences:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 411
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "_Value"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 412
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "_Expires"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 413
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 414
    return-void
.end method

.method private loadCookie(Ljava/lang/String;)V
    .locals 12
    .param p1, "cookieName"    # Ljava/lang/String;

    .prologue
    const-wide/16 v10, 0x0

    .line 420
    monitor-enter p0

    .line 421
    :try_start_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    .line 422
    .local v4, "now":J
    iget-object v3, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->preferences:Landroid/content/SharedPreferences;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "_Expires"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    const-wide/16 v8, 0x0

    invoke-interface {v3, v6, v8, v9}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v0

    .line 424
    .local v0, "cookieExpires":J
    cmp-long v3, v0, v10

    if-lez v3, :cond_0

    .line 425
    cmp-long v3, v0, v4

    if-lez v3, :cond_2

    .line 426
    iget-object v3, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->preferences:Landroid/content/SharedPreferences;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "_Value"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    const-string v7, ""

    invoke-interface {v3, v6, v7}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 428
    .local v2, "cookieValue":Ljava/lang/String;
    iget-object v3, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->cookies:Ljava/lang/String;

    if-nez v3, :cond_1

    .line 429
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v6, "="

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->cookies:Ljava/lang/String;

    .line 437
    .end local v2    # "cookieValue":Ljava/lang/String;
    :cond_0
    :goto_0
    monitor-exit p0

    .line 438
    return-void

    .line 431
    .restart local v2    # "cookieValue":Ljava/lang/String;
    :cond_1
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v6, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->cookies:Ljava/lang/String;

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v6, "; "

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v6, "="

    invoke-virtual {v3, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->cookies:Ljava/lang/String;

    goto :goto_0

    .line 437
    .end local v0    # "cookieExpires":J
    .end local v2    # "cookieValue":Ljava/lang/String;
    .end local v4    # "now":J
    :catchall_0
    move-exception v3

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3

    .line 434
    .restart local v0    # "cookieExpires":J
    .restart local v4    # "now":J
    :cond_2
    :try_start_1
    invoke-direct {p0, p1}, Lcom/adobe/adms/testandtarget/MboxFactory;->deleteCookie(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0
.end method

.method private saveCookies(Lorg/apache/http/client/CookieStore;)V
    .locals 5
    .param p1, "cookieStore"    # Lorg/apache/http/client/CookieStore;

    .prologue
    .line 444
    monitor-enter p0

    .line 445
    :try_start_0
    invoke-interface {p1}, Lorg/apache/http/client/CookieStore;->getCookies()Ljava/util/List;

    move-result-object v2

    .line 446
    .local v2, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/apache/http/cookie/Cookie;

    .line 447
    .local v0, "c":Lorg/apache/http/cookie/Cookie;
    invoke-interface {v0}, Lorg/apache/http/cookie/Cookie;->getName()Ljava/lang/String;

    move-result-object v1

    .line 448
    .local v1, "cookieName":Ljava/lang/String;
    const-string v4, "mboxSession"

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_1

    const-string v4, "mboxPC"

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 449
    :cond_1
    invoke-direct {p0, v1, v0}, Lcom/adobe/adms/testandtarget/MboxFactory;->storeCookie(Ljava/lang/String;Lorg/apache/http/cookie/Cookie;)V

    goto :goto_0

    .line 454
    .end local v0    # "c":Lorg/apache/http/cookie/Cookie;
    .end local v1    # "cookieName":Ljava/lang/String;
    .end local v2    # "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    .end local v3    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v4

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v4

    .line 452
    .restart local v2    # "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    .restart local v3    # "i$":Ljava/util/Iterator;
    :cond_2
    :try_start_1
    const-string v4, "mboxPC"

    invoke-direct {p0, v4}, Lcom/adobe/adms/testandtarget/MboxFactory;->loadCookie(Ljava/lang/String;)V

    .line 453
    const-string v4, "mboxSession"

    invoke-direct {p0, v4}, Lcom/adobe/adms/testandtarget/MboxFactory;->loadCookie(Ljava/lang/String;)V

    .line 454
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 455
    return-void
.end method

.method private declared-synchronized storeCookie(Ljava/lang/String;Lorg/apache/http/cookie/Cookie;)V
    .locals 4
    .param p1, "cookieName"    # Ljava/lang/String;
    .param p2, "cookie"    # Lorg/apache/http/cookie/Cookie;

    .prologue
    .line 462
    monitor-enter p0

    :try_start_0
    monitor-enter p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 463
    :try_start_1
    iget-object v1, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->preferences:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 464
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "_Value"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p2}, Lorg/apache/http/cookie/Cookie;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 465
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "_Expires"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p2}, Lorg/apache/http/cookie/Cookie;->getExpiryDate()Ljava/util/Date;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 467
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 468
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 469
    monitor-exit p0

    return-void

    .line 468
    .end local v0    # "editor":Landroid/content/SharedPreferences$Editor;
    :catchall_0
    move-exception v1

    :try_start_2
    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :try_start_3
    throw v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 462
    :catchall_1
    move-exception v1

    monitor-exit p0

    throw v1
.end method


# virtual methods
.method public clearCookies()V
    .locals 1

    .prologue
    .line 155
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->cookies:Ljava/lang/String;

    .line 156
    const-string v0, "mboxPC"

    invoke-direct {p0, v0}, Lcom/adobe/adms/testandtarget/MboxFactory;->deleteCookie(Ljava/lang/String;)V

    .line 157
    const-string v0, "mboxSession"

    invoke-direct {p0, v0}, Lcom/adobe/adms/testandtarget/MboxFactory;->deleteCookie(Ljava/lang/String;)V

    .line 158
    return-void
.end method

.method public create(Ljava/lang/String;)Lcom/adobe/adms/testandtarget/Mbox;
    .locals 3
    .param p1, "mboxName"    # Ljava/lang/String;

    .prologue
    .line 174
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_1

    .line 175
    :cond_0
    const-string v1, "TARGET"

    const-string v2, "Parameter \'mboxName\' in create() cannot be null or empty"

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 176
    const/4 v0, 0x0

    .line 181
    :goto_0
    return-object v0

    .line 179
    :cond_1
    new-instance v0, Lcom/adobe/adms/testandtarget/Mbox;

    invoke-direct {v0, p0, p1}, Lcom/adobe/adms/testandtarget/Mbox;-><init>(Lcom/adobe/adms/testandtarget/MboxFactory;Ljava/lang/String;)V

    .line 180
    .local v0, "newMbox":Lcom/adobe/adms/testandtarget/Mbox;
    iget-object v1, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->mboxList:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v1, p1, v0}, Ljava/util/concurrent/ConcurrentHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public disable()V
    .locals 4

    .prologue
    .line 189
    monitor-enter p0

    .line 190
    const/4 v1, 0x0

    :try_start_0
    iput-boolean v1, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->factoryEnabled:Z

    .line 191
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 192
    .local v2, "now":J
    iget-object v1, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->preferences:Landroid/content/SharedPreferences;

    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 193
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "DisableTime"

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 194
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 195
    monitor-exit p0

    .line 196
    return-void

    .line 195
    .end local v0    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v2    # "now":J
    :catchall_0
    move-exception v1

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method protected encode(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "content"    # Ljava/lang/String;

    .prologue
    .line 269
    :try_start_0
    const-string v1, "UTF-8"

    invoke-static {p1, v1}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p1

    .line 273
    .end local p1    # "content":Ljava/lang/String;
    :goto_0
    return-object p1

    .line 271
    .restart local p1    # "content":Ljava/lang/String;
    :catch_0
    move-exception v0

    .line 272
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    const-string v1, "MboxFactory"

    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method protected getBaseRequestURL()Ljava/lang/String;
    .locals 2

    .prologue
    .line 283
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->mboxServerURL:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/m2/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->clientCode:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/ubox/raw?"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getCookies()Ljava/lang/String;
    .locals 1

    .prologue
    .line 294
    iget-object v0, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->cookies:Ljava/lang/String;

    return-object v0
.end method

.method protected declared-synchronized getMboxResponse(Lcom/adobe/adms/testandtarget/Mbox;Ljava/lang/String;)V
    .locals 2
    .param p1, "mbox"    # Lcom/adobe/adms/testandtarget/Mbox;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 304
    monitor-enter p0

    :try_start_0
    new-instance v0, Lcom/adobe/adms/testandtarget/MboxFactory$TargetBackgroundTask;

    new-instance v1, Lcom/adobe/adms/testandtarget/MboxFactory$1;

    invoke-direct {v1, p0, p1}, Lcom/adobe/adms/testandtarget/MboxFactory$1;-><init>(Lcom/adobe/adms/testandtarget/MboxFactory;Lcom/adobe/adms/testandtarget/Mbox;)V

    invoke-direct {v0, p0, p1, p2, v1}, Lcom/adobe/adms/testandtarget/MboxFactory$TargetBackgroundTask;-><init>(Lcom/adobe/adms/testandtarget/MboxFactory;Lcom/adobe/adms/testandtarget/Mbox;Ljava/lang/String;Lcom/adobe/adms/testandtarget/MboxFactory$TargetCallback;)V

    .line 311
    .local v0, "bgTask":Lcom/adobe/adms/testandtarget/MboxFactory$TargetBackgroundTask;
    new-instance v1, Ljava/lang/Thread;

    invoke-direct {v1, v0}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v1}, Ljava/lang/Thread;->start()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 312
    monitor-exit p0

    return-void

    .line 304
    .end local v0    # "bgTask":Lcom/adobe/adms/testandtarget/MboxFactory$TargetBackgroundTask;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method protected declared-synchronized isEnabled()Z
    .locals 12

    .prologue
    const-wide/16 v10, 0x0

    .line 386
    monitor-enter p0

    :try_start_0
    iget-object v6, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->preferences:Landroid/content/SharedPreferences;

    if-nez v6, :cond_0

    .line 387
    iget-object v6, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->parentContext:Landroid/content/Context;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "TestAndTarget"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->clientCode:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    const/4 v8, 0x0

    invoke-virtual {v6, v7, v8}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v6

    iput-object v6, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->preferences:Landroid/content/SharedPreferences;

    .line 390
    :cond_0
    iget-object v6, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->preferences:Landroid/content/SharedPreferences;

    const-string v7, "DisableTime"

    const-wide/16 v8, 0x0

    invoke-interface {v6, v7, v8, v9}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v0

    .line 391
    .local v0, "disableTimestamp":J
    cmp-long v6, v0, v10

    if-lez v6, :cond_1

    .line 392
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    .line 393
    .local v4, "now":J
    sub-long v2, v4, v0

    .line 394
    .local v2, "elapsed":J
    iget-wide v6, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->disableDuration:J

    cmp-long v6, v2, v6

    if-gez v6, :cond_2

    .line 395
    const-string v6, "MboxFactory"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "WARNING: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-wide v8, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->disableDuration:J

    sub-long/2addr v8, v2

    invoke-static {v8, v9}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "ms until MboxFactory is re-enabled."

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 397
    const/4 v6, 0x0

    iput-boolean v6, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->factoryEnabled:Z

    .line 402
    .end local v2    # "elapsed":J
    .end local v4    # "now":J
    :cond_1
    :goto_0
    iget-boolean v6, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->factoryEnabled:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v6

    .line 399
    .restart local v2    # "elapsed":J
    .restart local v4    # "now":J
    :cond_2
    const/4 v6, 0x1

    :try_start_1
    iput-boolean v6, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->factoryEnabled:Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 386
    .end local v0    # "disableTimestamp":J
    .end local v2    # "elapsed":J
    .end local v4    # "now":J
    :catchall_0
    move-exception v6

    monitor-exit p0

    throw v6
.end method

.method public recordEvent(Ljava/lang/String;)V
    .locals 6
    .param p1, "mboxName"    # Ljava/lang/String;

    .prologue
    .line 205
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    .line 207
    .local v1, "timeStamp":Ljava/lang/String;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 208
    .local v2, "urlSb":Ljava/lang/StringBuilder;
    invoke-virtual {p0}, Lcom/adobe/adms/testandtarget/MboxFactory;->getBaseRequestURL()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "mbox="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0, p1}, Lcom/adobe/adms/testandtarget/MboxFactory;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "&mboxDefault="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/images/log.gif"

    invoke-virtual {p0, v4}, Lcom/adobe/adms/testandtarget/MboxFactory;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "&mboxTime="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 216
    new-instance v0, Lcom/adobe/adms/testandtarget/MboxFactory$RecordEventTask;

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v0, p0, v3}, Lcom/adobe/adms/testandtarget/MboxFactory$RecordEventTask;-><init>(Lcom/adobe/adms/testandtarget/MboxFactory;Ljava/lang/String;)V

    .line 217
    .local v0, "bgTask":Lcom/adobe/adms/testandtarget/MboxFactory$RecordEventTask;
    new-instance v3, Ljava/lang/Thread;

    invoke-direct {v3, v0}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v3}, Ljava/lang/Thread;->start()V

    .line 218
    return-void
.end method

.method public declared-synchronized setDisableDuration(J)V
    .locals 1
    .param p1, "milliseconds"    # J

    .prologue
    .line 258
    monitor-enter p0

    :try_start_0
    iput-wide p1, p0, Lcom/adobe/adms/testandtarget/MboxFactory;->disableDuration:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 259
    monitor-exit p0

    return-void

    .line 258
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
