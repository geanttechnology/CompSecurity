.class Lcom/aio/downloader/service/ServiceUpdate$9;
.super Ljava/lang/Object;
.source "ServiceUpdate.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/service/ServiceUpdate;->getNewApps()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/service/ServiceUpdate;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/ServiceUpdate;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/ServiceUpdate$9;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    .line 2018
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    .line 2023
    sget-object v4, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-static {v4}, Landroid/net/Uri;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 2025
    .local v1, "encode":Ljava/lang/String;
    const/4 v2, 0x0

    .line 2027
    .local v2, "ids_map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v2, Ljava/util/HashMap;

    .end local v2    # "ids_map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 2029
    .restart local v2    # "ids_map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    :try_start_0
    const-string v4, "content"

    iget-object v5, p0, Lcom/aio/downloader/service/ServiceUpdate$9;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->jsonArray:Lorg/json/JSONArray;
    invoke-static {v5}, Lcom/aio/downloader/service/ServiceUpdate;->access$57(Lcom/aio/downloader/service/ServiceUpdate;)Lorg/json/JSONArray;

    move-result-object v5

    invoke-virtual {v5}, Lorg/json/JSONArray;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2030
    const-string v4, "ucode"

    iget-object v5, p0, Lcom/aio/downloader/service/ServiceUpdate$9;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->dEVICE_ID:Ljava/lang/String;
    invoke-static {v5}, Lcom/aio/downloader/service/ServiceUpdate;->access$58(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2031
    const-string v4, "os_version"

    sget-object v5, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual {v2, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2032
    const-string v4, "source"

    const-string v5, "aio"

    invoke-virtual {v2, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 2033
    const-string v4, "device"

    invoke-virtual {v2, v4, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 2047
    :goto_0
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceUpdate$9;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    .line 2049
    const-string v5, "http://android.downloadatoz.com/_201409/market/app_version_check.php"

    .line 2048
    invoke-static {v5, v2}, Lcom/aio/downloader/utils/Myutils;->doHttpPost(Ljava/lang/String;Ljava/util/HashMap;)Ljava/lang/String;

    move-result-object v5

    .line 2047
    invoke-static {v4, v5}, Lcom/aio/downloader/service/ServiceUpdate;->access$59(Lcom/aio/downloader/service/ServiceUpdate;Ljava/lang/String;)V

    .line 2055
    const-string v4, "qaz"

    new-instance v5, Ljava/lang/StringBuilder;

    iget-object v6, p0, Lcom/aio/downloader/service/ServiceUpdate$9;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->upJsonStr:Ljava/lang/String;
    invoke-static {v6}, Lcom/aio/downloader/service/ServiceUpdate;->access$51(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 2057
    new-instance v3, Landroid/os/Message;

    invoke-direct {v3}, Landroid/os/Message;-><init>()V

    .line 2059
    .local v3, "msg":Landroid/os/Message;
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceUpdate$9;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->upJsonStr:Ljava/lang/String;
    invoke-static {v4}, Lcom/aio/downloader/service/ServiceUpdate;->access$51(Lcom/aio/downloader/service/ServiceUpdate;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, v3, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 2061
    const/16 v4, 0x3e9

    iput v4, v3, Landroid/os/Message;->what:I

    .line 2063
    iget-object v4, p0, Lcom/aio/downloader/service/ServiceUpdate$9;->this$0:Lcom/aio/downloader/service/ServiceUpdate;

    # getter for: Lcom/aio/downloader/service/ServiceUpdate;->appHandler:Landroid/os/Handler;
    invoke-static {v4}, Lcom/aio/downloader/service/ServiceUpdate;->access$60(Lcom/aio/downloader/service/ServiceUpdate;)Landroid/os/Handler;

    move-result-object v4

    invoke-virtual {v4, v3}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 2065
    return-void

    .line 2034
    .end local v3    # "msg":Landroid/os/Message;
    :catch_0
    move-exception v0

    .line 2036
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method
