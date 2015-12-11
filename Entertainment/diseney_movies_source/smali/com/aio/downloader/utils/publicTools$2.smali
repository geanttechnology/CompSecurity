.class Lcom/aio/downloader/utils/publicTools$2;
.super Ljava/lang/Object;
.source "publicTools.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/utils/publicTools;->getKey()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 695
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1
    return-void
.end method


# virtual methods
.method public run()V
    .locals 6

    .prologue
    .line 699
    :try_start_0
    const-string v3, "http://android.downloadatoz.com/_201409/api/_maket_process/aio_fingerprint_verify.php"

    invoke-static {v3}, Lcom/aio/downloader/utils/publicTools;->getUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 700
    .local v1, "keyurlcontent":Ljava/lang/String;
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 701
    .local v2, "object":Lorg/json/JSONObject;
    const-string v3, "key"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/aio/downloader/utils/publicTools;->access$0(Ljava/lang/String;)V

    .line 702
    sget-object v3, Lcom/aio/downloader/utils/publicTools;->spkey:Landroid/content/SharedPreferences;

    invoke-interface {v3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    const-string v4, "aiokey"

    # getter for: Lcom/aio/downloader/utils/publicTools;->aiokey:Ljava/lang/String;
    invoke-static {}, Lcom/aio/downloader/utils/publicTools;->access$1()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v3

    invoke-interface {v3}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 703
    # getter for: Lcom/aio/downloader/utils/publicTools;->aiokey:Ljava/lang/String;
    invoke-static {}, Lcom/aio/downloader/utils/publicTools;->access$1()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 704
    # getter for: Lcom/aio/downloader/utils/publicTools;->aiokey:Ljava/lang/String;
    invoke-static {}, Lcom/aio/downloader/utils/publicTools;->access$1()Ljava/lang/String;

    move-result-object v3

    sput-object v3, Lcom/aio/downloader/utils/publicTools;->downkey:Ljava/lang/String;

    .line 713
    .end local v1    # "keyurlcontent":Ljava/lang/String;
    .end local v2    # "object":Lorg/json/JSONObject;
    :goto_0
    return-void

    .line 706
    .restart local v1    # "keyurlcontent":Ljava/lang/String;
    .restart local v2    # "object":Lorg/json/JSONObject;
    :cond_0
    const-string v3, "aio_fingerprint"

    sput-object v3, Lcom/aio/downloader/utils/publicTools;->downkey:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 709
    .end local v1    # "keyurlcontent":Ljava/lang/String;
    .end local v2    # "object":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 710
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method
