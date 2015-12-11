.class public Lcom/amazon/mShop/crash/CrashDetailsCollector;
.super Ljava/lang/Object;
.source "CrashDetailsCollector.java"

# interfaces
.implements Lcom/amazon/device/crashmanager/CrashDetailsCollectable;


# static fields
.field static final TAG:Ljava/lang/String;


# instance fields
.field private final mContext:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const-class v0, Lcom/amazon/mShop/crash/CrashDetailsCollector;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/crash/CrashDetailsCollector;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 22
    if-nez p1, :cond_0

    .line 23
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Context must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 25
    :cond_0
    iput-object p1, p0, Lcom/amazon/mShop/crash/CrashDetailsCollector;->mContext:Landroid/content/Context;

    .line 26
    return-void
.end method


# virtual methods
.method public collect(Ljava/lang/Throwable;)Ljava/util/Map;
    .locals 4
    .param p1, "ex"    # Ljava/lang/Throwable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Throwable;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 30
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 31
    .local v0, "details":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v1, "SelectedMarketplace"

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 32
    const-string/jumbo v1, "PublicHttpCookies"

    iget-object v2, p0, Lcom/amazon/mShop/crash/CrashDetailsCollector;->mContext:Landroid/content/Context;

    const/4 v3, 0x0

    invoke-static {v2, v3}, Lcom/amazon/mShop/net/CookieBridge;->getCookiesOfCurrentLocale(Landroid/content/Context;Z)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 34
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/crash/CrashDetailsCollector;->putBrazilVersion(Ljava/util/Map;)V

    .line 35
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/crash/CrashDetailsCollector;->putLogCat(Ljava/util/Map;)V

    .line 36
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/crash/CrashDetailsCollector;->putWebViewHistory(Ljava/util/Map;)V

    .line 38
    iget-object v1, p0, Lcom/amazon/mShop/crash/CrashDetailsCollector;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/mShop/util/BuildUtils;->getRevisionNumber(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 39
    const-string/jumbo v1, "packageVersionName"

    iget-object v2, p0, Lcom/amazon/mShop/crash/CrashDetailsCollector;->mContext:Landroid/content/Context;

    invoke-static {v2}, Lcom/amazon/mShop/util/BuildUtils;->getRevisionNumber(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 42
    :cond_0
    return-object v0
.end method

.method putBrazilVersion(Ljava/util/Map;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 46
    .local p1, "details":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v1, p0, Lcom/amazon/mShop/crash/CrashDetailsCollector;->mContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/mShop/util/BuildUtils;->getRevisionNumber(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 47
    .local v0, "buildVersionString":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 48
    iget-object v1, p0, Lcom/amazon/mShop/crash/CrashDetailsCollector;->mContext:Landroid/content/Context;

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->about_missing_placeholder:I

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 51
    :cond_0
    const-string/jumbo v1, "BrazilVersion"

    invoke-interface {p1, v1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 52
    return-void
.end method

.method putLogCat(Ljava/util/Map;)V
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p1, "details":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v9, 0x0

    .line 55
    const-string/jumbo v4, ""

    .line 56
    .local v4, "logcat":Ljava/lang/String;
    const/4 v8, 0x4

    new-array v1, v8, [Ljava/lang/String;

    const-string/jumbo v8, "logcat"

    aput-object v8, v1, v9

    const/4 v8, 0x1

    const-string/jumbo v9, "-d"

    aput-object v9, v1, v8

    const/4 v8, 0x2

    const-string/jumbo v9, "-v"

    aput-object v9, v1, v8

    const/4 v8, 0x3

    const-string/jumbo v9, "threadtime"

    aput-object v9, v1, v8

    .line 58
    .local v1, "command":[Ljava/lang/String;
    :try_start_0
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v8

    invoke-virtual {v8, v1}, Ljava/lang/Runtime;->exec([Ljava/lang/String;)Ljava/lang/Process;

    move-result-object v7

    .line 59
    .local v7, "process":Ljava/lang/Process;
    invoke-virtual {v7}, Ljava/lang/Process;->getInputStream()Ljava/io/InputStream;

    move-result-object v3

    .line 60
    .local v3, "is":Ljava/io/InputStream;
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    .line 61
    .local v6, "output":Ljava/lang/StringBuilder;
    const/16 v8, 0x2000

    new-array v0, v8, [B

    .line 62
    .local v0, "bytes":[B
    const/4 v5, 0x0

    .line 63
    .local v5, "numRead":I
    :goto_0
    invoke-virtual {v3, v0}, Ljava/io/InputStream;->read([B)I

    move-result v5

    if-ltz v5, :cond_0

    .line 64
    new-instance v8, Ljava/lang/String;

    const/4 v9, 0x0

    invoke-direct {v8, v0, v9, v5}, Ljava/lang/String;-><init>([BII)V

    invoke-virtual {v6, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 67
    .end local v0    # "bytes":[B
    .end local v3    # "is":Ljava/io/InputStream;
    .end local v5    # "numRead":I
    .end local v6    # "output":Ljava/lang/StringBuilder;
    .end local v7    # "process":Ljava/lang/Process;
    :catch_0
    move-exception v2

    .line 68
    .local v2, "e":Ljava/lang/Exception;
    sget-object v8, Lcom/amazon/mShop/crash/CrashDetailsCollector;->TAG:Ljava/lang/String;

    const-string/jumbo v9, "collectLogCat encountered an exception: "

    invoke-static {v8, v9, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 70
    .end local v2    # "e":Ljava/lang/Exception;
    :goto_1
    const-string/jumbo v8, "LogCat"

    invoke-interface {p1, v8, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 71
    return-void

    .line 66
    .restart local v0    # "bytes":[B
    .restart local v3    # "is":Ljava/io/InputStream;
    .restart local v5    # "numRead":I
    .restart local v6    # "output":Ljava/lang/StringBuilder;
    .restart local v7    # "process":Ljava/lang/Process;
    :cond_0
    :try_start_1
    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v4

    goto :goto_1
.end method

.method putWebViewHistory(Ljava/util/Map;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 74
    .local p1, "details":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v0, "WebViewHistory"

    invoke-static {}, Lcom/amazon/mShop/crash/WebViewLogger;->getWebViewHistory()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 75
    return-void
.end method
