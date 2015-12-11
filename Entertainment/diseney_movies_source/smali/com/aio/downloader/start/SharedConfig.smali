.class public Lcom/aio/downloader/start/SharedConfig;
.super Ljava/lang/Object;
.source "SharedConfig.java"


# static fields
.field private static instance:Lcom/aio/downloader/start/SharedConfig;

.field private static shared:Landroid/content/SharedPreferences;


# direct methods
.method private constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    const-string v0, "config"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    sput-object v0, Lcom/aio/downloader/start/SharedConfig;->shared:Landroid/content/SharedPreferences;

    .line 19
    return-void
.end method

.method public static ClearConfig()V
    .locals 1

    .prologue
    .line 37
    sget-object v0, Lcom/aio/downloader/start/SharedConfig;->shared:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->clear()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 38
    return-void
.end method

.method public static GetConfig()Landroid/content/SharedPreferences;
    .locals 1

    .prologue
    .line 29
    sget-object v0, Lcom/aio/downloader/start/SharedConfig;->shared:Landroid/content/SharedPreferences;

    return-object v0
.end method

.method public static GetEditor()Landroid/content/SharedPreferences$Editor;
    .locals 1

    .prologue
    .line 33
    sget-object v0, Lcom/aio/downloader/start/SharedConfig;->shared:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    return-object v0
.end method

.method public static getInstance(Landroid/content/Context;)Lcom/aio/downloader/start/SharedConfig;
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 22
    sget-object v0, Lcom/aio/downloader/start/SharedConfig;->instance:Lcom/aio/downloader/start/SharedConfig;

    if-nez v0, :cond_0

    .line 23
    new-instance v0, Lcom/aio/downloader/start/SharedConfig;

    invoke-direct {v0, p0}, Lcom/aio/downloader/start/SharedConfig;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/aio/downloader/start/SharedConfig;->instance:Lcom/aio/downloader/start/SharedConfig;

    .line 25
    :cond_0
    sget-object v0, Lcom/aio/downloader/start/SharedConfig;->instance:Lcom/aio/downloader/start/SharedConfig;

    return-object v0
.end method
