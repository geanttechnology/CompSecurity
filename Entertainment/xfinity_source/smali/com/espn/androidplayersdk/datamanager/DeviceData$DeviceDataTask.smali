.class Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask;
.super Landroid/os/AsyncTask;
.source "DeviceData.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/espn/androidplayersdk/datamanager/DeviceData;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "DeviceDataTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field DeviceDataListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

.field feedsServerCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

.field msg:Ljava/lang/String;

.field final synthetic this$0:Lcom/espn/androidplayersdk/datamanager/DeviceData;

.field url:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/espn/androidplayersdk/datamanager/DeviceData;)V
    .locals 1

    .prologue
    .line 84
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask;->this$0:Lcom/espn/androidplayersdk/datamanager/DeviceData;

    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 80
    const-string v0, ""

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask;->url:Ljava/lang/String;

    .line 81
    const-string v0, ""

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask;->msg:Ljava/lang/String;

    .line 125
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask$1;

    invoke-direct {v0, p0}, Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask$1;-><init>(Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask;)V

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask;->DeviceDataListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    .line 85
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;-><init>()V

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask;->feedsServerCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    .line 86
    return-void
.end method


# virtual methods
.method protected bridge varargs synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1
    check-cast p1, [Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 7
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    const/4 v6, 0x0

    .line 90
    const-string v0, "Device not identified. Initiating ID task"

    const/4 v1, 0x2

    invoke-static {v0, v1, v6}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 91
    const-string v0, "https://authorization.go.com/token"

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask;->url:Ljava/lang/String;

    .line 92
    const-string v0, "client_id=DTSS-DEVICE.DATA.WATCH.ESPN.ANDROID-PROD&client_secret=859517d7b6f33154bd9b5b74ca528a9a&grant_type=client_credentials&scope=mcon-devicedata-oneshot"

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask;->msg:Ljava/lang/String;

    .line 93
    new-instance v5, Ljava/util/HashMap;

    invoke-direct {v5}, Ljava/util/HashMap;-><init>()V

    .line 94
    .local v5, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const-string v0, "POSTMSG"

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask;->msg:Ljava/lang/String;

    invoke-virtual {v5, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 95
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask;->feedsServerCom:Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask;->url:Ljava/lang/String;

    const/4 v2, 0x3

    const/4 v3, 0x5

    iget-object v4, p0, Lcom/espn/androidplayersdk/datamanager/DeviceData$DeviceDataTask;->DeviceDataListener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    invoke-virtual/range {v0 .. v5}, Lcom/espn/androidplayersdk/datamanager/FeedsServerCom;->execTask(Ljava/lang/String;IILcom/espn/androidplayersdk/datamanager/FeedsCommListener;Ljava/util/HashMap;)V

    .line 96
    return-object v6
.end method

.method getRequest(Ljava/lang/String;)Lorg/json/JSONObject;
    .locals 10
    .param p1, "pUrl"    # Ljava/lang/String;

    .prologue
    const/4 v9, 0x5

    .line 100
    const/4 v2, 0x0

    .line 102
    .local v2, "is":Ljava/io/InputStream;
    :try_start_0
    new-instance v6, Ljava/net/URL;

    invoke-direct {v6, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 103
    .local v6, "url":Ljava/net/URL;
    invoke-virtual {v6}, Ljava/net/URL;->openConnection()Ljava/net/URLConnection;

    move-result-object v0

    .line 104
    .local v0, "conn":Ljava/net/URLConnection;
    invoke-virtual {v0}, Ljava/net/URLConnection;->getInputStream()Ljava/io/InputStream;

    move-result-object v2

    .line 105
    new-instance v4, Ljava/io/BufferedReader;

    new-instance v7, Ljava/io/InputStreamReader;

    invoke-direct {v7, v2}, Ljava/io/InputStreamReader;-><init>(Ljava/io/InputStream;)V

    invoke-direct {v4, v7}, Ljava/io/BufferedReader;-><init>(Ljava/io/Reader;)V

    .line 106
    .local v4, "reader":Ljava/io/BufferedReader;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 107
    .local v5, "sb":Ljava/lang/StringBuilder;
    const/4 v3, 0x0

    .line 108
    .local v3, "line":Ljava/lang/String;
    :goto_0
    invoke-virtual {v4}, Ljava/io/BufferedReader;->readLine()Ljava/lang/String;

    move-result-object v3

    if-nez v3, :cond_1

    .line 111
    new-instance v7, Lorg/json/JSONObject;

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 115
    if-eqz v2, :cond_0

    .line 117
    :try_start_1
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_1

    .line 122
    .end local v0    # "conn":Ljava/net/URLConnection;
    .end local v3    # "line":Ljava/lang/String;
    .end local v4    # "reader":Ljava/io/BufferedReader;
    .end local v5    # "sb":Ljava/lang/StringBuilder;
    .end local v6    # "url":Ljava/net/URL;
    :cond_0
    :goto_1
    return-object v7

    .line 109
    .restart local v0    # "conn":Ljava/net/URLConnection;
    .restart local v3    # "line":Ljava/lang/String;
    .restart local v4    # "reader":Ljava/io/BufferedReader;
    .restart local v5    # "sb":Ljava/lang/StringBuilder;
    .restart local v6    # "url":Ljava/net/URL;
    :cond_1
    :try_start_2
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v8, "\n"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 112
    .end local v0    # "conn":Ljava/net/URLConnection;
    .end local v3    # "line":Ljava/lang/String;
    .end local v4    # "reader":Ljava/io/BufferedReader;
    .end local v5    # "sb":Ljava/lang/StringBuilder;
    .end local v6    # "url":Ljava/net/URL;
    :catch_0
    move-exception v1

    .line 113
    .local v1, "e":Ljava/lang/Exception;
    :try_start_3
    const-string v7, "Error: Device ID failed"

    const/4 v8, 0x5

    invoke-static {v7, v8, v1}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 115
    if-eqz v2, :cond_2

    .line 117
    :try_start_4
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_2

    .line 122
    .end local v1    # "e":Ljava/lang/Exception;
    :cond_2
    :goto_2
    const/4 v7, 0x0

    goto :goto_1

    .line 118
    .restart local v0    # "conn":Ljava/net/URLConnection;
    .restart local v3    # "line":Ljava/lang/String;
    .restart local v4    # "reader":Ljava/io/BufferedReader;
    .restart local v5    # "sb":Ljava/lang/StringBuilder;
    .restart local v6    # "url":Ljava/net/URL;
    :catch_1
    move-exception v1

    .line 119
    .local v1, "e":Ljava/io/IOException;
    const-string v8, "Error: Device ID failed"

    invoke-static {v8, v9, v1}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_1

    .line 118
    .end local v0    # "conn":Ljava/net/URLConnection;
    .end local v3    # "line":Ljava/lang/String;
    .end local v4    # "reader":Ljava/io/BufferedReader;
    .end local v5    # "sb":Ljava/lang/StringBuilder;
    .end local v6    # "url":Ljava/net/URL;
    .local v1, "e":Ljava/lang/Exception;
    :catch_2
    move-exception v1

    .line 119
    .local v1, "e":Ljava/io/IOException;
    const-string v7, "Error: Device ID failed"

    invoke-static {v7, v9, v1}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_2

    .line 114
    .end local v1    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v7

    .line 115
    if-eqz v2, :cond_3

    .line 117
    :try_start_5
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_3

    .line 121
    :cond_3
    :goto_3
    throw v7

    .line 118
    :catch_3
    move-exception v1

    .line 119
    .restart local v1    # "e":Ljava/io/IOException;
    const-string v8, "Error: Device ID failed"

    invoke-static {v8, v9, v1}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_3
.end method
