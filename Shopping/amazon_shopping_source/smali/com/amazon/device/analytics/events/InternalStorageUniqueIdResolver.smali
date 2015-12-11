.class public Lcom/amazon/device/analytics/events/InternalStorageUniqueIdResolver;
.super Lcom/amazon/device/analytics/events/UniqueIdResolverChain;
.source "InternalStorageUniqueIdResolver.java"

# interfaces
.implements Lcom/amazon/device/analytics/util/JSONSerializable;


# static fields
.field protected static final PREFS_NAME:Ljava/lang/String;

.field private static logger:Lcom/amazon/device/analytics/log/Logger;


# instance fields
.field private final sharedPreferences:Landroid/content/SharedPreferences;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    const-class v0, Lcom/amazon/device/analytics/events/InternalStorageUniqueIdResolver;

    invoke-static {v0}, Lcom/amazon/device/analytics/log/Logging;->getLogger(Ljava/lang/Class;)Lcom/amazon/device/analytics/log/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/analytics/events/InternalStorageUniqueIdResolver;->logger:Lcom/amazon/device/analytics/log/Logger;

    .line 19
    const-class v0, Lcom/amazon/device/analytics/events/InternalStorageUniqueIdResolver;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/analytics/events/InternalStorageUniqueIdResolver;->PREFS_NAME:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/device/analytics/events/UniqueIdResolver;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "resolver"    # Lcom/amazon/device/analytics/events/UniqueIdResolver;

    .prologue
    .line 29
    invoke-direct {p0, p2}, Lcom/amazon/device/analytics/events/UniqueIdResolverChain;-><init>(Lcom/amazon/device/analytics/events/UniqueIdResolver;)V

    .line 30
    sget-object v0, Lcom/amazon/device/analytics/events/InternalStorageUniqueIdResolver;->PREFS_NAME:Ljava/lang/String;

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/analytics/events/InternalStorageUniqueIdResolver;->sharedPreferences:Landroid/content/SharedPreferences;

    .line 31
    return-void
.end method


# virtual methods
.method public tryResolve()Ljava/lang/String;
    .locals 5

    .prologue
    const/4 v1, 0x0

    .line 38
    iget-object v2, p0, Lcom/amazon/device/analytics/events/InternalStorageUniqueIdResolver;->sharedPreferences:Landroid/content/SharedPreferences;

    if-nez v2, :cond_0

    .line 39
    sget-object v2, Lcom/amazon/device/analytics/events/InternalStorageUniqueIdResolver;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v3, "SharedPreferences is null"

    invoke-virtual {v2, v3}, Lcom/amazon/device/analytics/log/Logger;->w(Ljava/lang/String;)V

    .line 47
    :goto_0
    return-object v1

    .line 44
    :cond_0
    :try_start_0
    iget-object v2, p0, Lcom/amazon/device/analytics/events/InternalStorageUniqueIdResolver;->sharedPreferences:Landroid/content/SharedPreferences;

    const-string/jumbo v3, "UniqueId"

    const/4 v4, 0x0

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    goto :goto_0

    .line 45
    :catch_0
    move-exception v0

    .line 46
    .local v0, "ex":Ljava/lang/Exception;
    sget-object v2, Lcom/amazon/device/analytics/events/InternalStorageUniqueIdResolver;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v3, "There was an exception when trying to retrieve the unique id from the SharedPreferences"

    invoke-virtual {v2, v3, v0}, Lcom/amazon/device/analytics/log/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public tryStore(Ljava/lang/String;)Z
    .locals 5
    .param p1, "uniqueId"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 56
    iget-object v3, p0, Lcom/amazon/device/analytics/events/InternalStorageUniqueIdResolver;->sharedPreferences:Landroid/content/SharedPreferences;

    if-nez v3, :cond_0

    .line 57
    sget-object v3, Lcom/amazon/device/analytics/events/InternalStorageUniqueIdResolver;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v4, "sharedPreferences is null"

    invoke-virtual {v3, v4}, Lcom/amazon/device/analytics/log/Logger;->w(Ljava/lang/String;)V

    .line 67
    :goto_0
    return v2

    .line 62
    :cond_0
    :try_start_0
    iget-object v3, p0, Lcom/amazon/device/analytics/events/InternalStorageUniqueIdResolver;->sharedPreferences:Landroid/content/SharedPreferences;

    invoke-interface {v3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 63
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string/jumbo v3, "UniqueId"

    invoke-interface {v0, v3, p1}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 64
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    goto :goto_0

    .line 65
    .end local v0    # "editor":Landroid/content/SharedPreferences$Editor;
    :catch_0
    move-exception v1

    .line 66
    .local v1, "ex":Ljava/lang/Exception;
    sget-object v3, Lcom/amazon/device/analytics/events/InternalStorageUniqueIdResolver;->logger:Lcom/amazon/device/analytics/log/Logger;

    const-string/jumbo v4, "There was an exception when trying to store the unique id into the SharedPreferences"

    invoke-virtual {v3, v4, v1}, Lcom/amazon/device/analytics/log/Logger;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
