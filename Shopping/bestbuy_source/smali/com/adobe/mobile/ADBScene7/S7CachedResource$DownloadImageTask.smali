.class Lcom/adobe/mobile/ADBScene7/S7CachedResource$DownloadImageTask;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field private _callback:Lcom/adobe/mobile/ADBScene7/S7CachedResource$S7Callback;

.field private _url:Ljava/lang/String;

.field final synthetic this$0:Lcom/adobe/mobile/ADBScene7/S7CachedResource;


# direct methods
.method public constructor <init>(Lcom/adobe/mobile/ADBScene7/S7CachedResource;Ljava/lang/String;Lcom/adobe/mobile/ADBScene7/S7CachedResource$S7Callback;)V
    .locals 0

    .prologue
    .line 43
    iput-object p1, p0, Lcom/adobe/mobile/ADBScene7/S7CachedResource$DownloadImageTask;->this$0:Lcom/adobe/mobile/ADBScene7/S7CachedResource;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    iput-object p2, p0, Lcom/adobe/mobile/ADBScene7/S7CachedResource$DownloadImageTask;->_url:Ljava/lang/String;

    .line 45
    iput-object p3, p0, Lcom/adobe/mobile/ADBScene7/S7CachedResource$DownloadImageTask;->_callback:Lcom/adobe/mobile/ADBScene7/S7CachedResource$S7Callback;

    .line 46
    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 51
    const/4 v0, 0x0

    .line 54
    :try_start_0
    const-string v1, "ADBMobile"

    const-string v2, "Scene 7 - About to get image %s"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/adobe/mobile/ADBScene7/S7CachedResource$DownloadImageTask;->_url:Ljava/lang/String;

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 55
    new-instance v1, Ljava/net/URL;

    iget-object v2, p0, Lcom/adobe/mobile/ADBScene7/S7CachedResource$DownloadImageTask;->_url:Ljava/lang/String;

    invoke-direct {v1, v2}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/net/URL;->openStream()Ljava/io/InputStream;

    move-result-object v1

    .line 56
    invoke-static {v1}, Landroid/graphics/BitmapFactory;->decodeStream(Ljava/io/InputStream;)Landroid/graphics/Bitmap;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 66
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/adobe/mobile/ADBScene7/S7CachedResource$DownloadImageTask;->_callback:Lcom/adobe/mobile/ADBScene7/S7CachedResource$S7Callback;

    if-eqz v1, :cond_1

    .line 67
    iget-object v1, p0, Lcom/adobe/mobile/ADBScene7/S7CachedResource$DownloadImageTask;->_callback:Lcom/adobe/mobile/ADBScene7/S7CachedResource$S7Callback;

    invoke-interface {v1, v0}, Lcom/adobe/mobile/ADBScene7/S7CachedResource$S7Callback;->call(Ljava/lang/Object;)V

    .line 69
    :cond_1
    return-void

    .line 58
    :catch_0
    move-exception v1

    .line 59
    const-string v2, "ADBMobile"

    const-string v3, "Scene 7 - %s"

    new-array v4, v7, [Ljava/lang/Object;

    invoke-virtual {v1}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 60
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    .line 61
    iget-object v1, p0, Lcom/adobe/mobile/ADBScene7/S7CachedResource$DownloadImageTask;->_callback:Lcom/adobe/mobile/ADBScene7/S7CachedResource$S7Callback;

    if-eqz v1, :cond_0

    .line 62
    iget-object v1, p0, Lcom/adobe/mobile/ADBScene7/S7CachedResource$DownloadImageTask;->_callback:Lcom/adobe/mobile/ADBScene7/S7CachedResource$S7Callback;

    invoke-interface {v1, v0}, Lcom/adobe/mobile/ADBScene7/S7CachedResource$S7Callback;->call(Ljava/lang/Object;)V

    goto :goto_0
.end method
