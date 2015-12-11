.class public Lcom/comcast/playerplatform/drm/java/util/MetadataUtil;
.super Ljava/lang/Object;
.source "MetadataUtil.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$000(Ljava/net/URI;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Ljava/net/URI;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 21
    invoke-static {p0}, Lcom/comcast/playerplatform/drm/java/util/MetadataUtil;->readFile(Ljava/net/URI;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static attachMetadata(Ljava/lang/String;Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V
    .locals 10
    .param p0, "manifestUri"    # Ljava/lang/String;
    .param p1, "responseEventListener"    # Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;
    .param p2, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .prologue
    .line 23
    invoke-static {p0}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v8

    .line 25
    .local v8, "uri":Ljava/net/URI;
    invoke-virtual {v8}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v8}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    move-result-object v0

    const-string v1, "file"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 26
    :cond_0
    invoke-static {}, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/drm/java/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$1;

    invoke-direct {v1, v8, p1, p0}, Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$1;-><init>(Ljava/net/URI;Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->executeRunnable(Ljava/lang/Runnable;)V

    .line 69
    :goto_0
    return-void

    .line 53
    :cond_1
    invoke-virtual {v8}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    move-result-object v0

    const-string v1, "http"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    invoke-virtual {v8}, Ljava/net/URI;->getScheme()Ljava/lang/String;

    move-result-object v0

    const-string v1, "https"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 54
    :cond_2
    invoke-static {}, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/drm/java/util/ThreadManager;

    move-result-object v9

    new-instance v0, Lcom/comcast/playerplatform/util/android/XrestHelper;

    const-string v1, ""

    const-string v3, "GET"

    const/4 v4, 0x0

    move-object v2, p0

    move-object v5, p1

    move-object v6, p2

    invoke-direct/range {v0 .. v6}, Lcom/comcast/playerplatform/util/android/XrestHelper;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    invoke-virtual {v9, v0}, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->executeRunnable(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 56
    :cond_3
    move-object v7, p0

    .line 57
    .local v7, "manifestUrl":Ljava/lang/String;
    invoke-static {}, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/drm/java/util/ThreadManager;

    move-result-object v0

    new-instance v1, Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$2;

    invoke-direct {v1, p1, p0}, Lcom/comcast/playerplatform/drm/java/util/MetadataUtil$2;-><init>(Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/comcast/playerplatform/drm/java/util/ThreadManager;->executeOnUIThread(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method private static readFile(Ljava/net/URI;)Ljava/lang/String;
    .locals 5
    .param p0, "uri"    # Ljava/net/URI;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 72
    const/4 v1, 0x0

    .line 74
    .local v1, "inputFile":Ljava/io/InputStream;
    :try_start_0
    new-instance v0, Ljava/io/File;

    invoke-direct {v0, p0}, Ljava/io/File;-><init>(Ljava/net/URI;)V

    .line 75
    .local v0, "file":Ljava/io/File;
    new-instance v2, Ljava/io/FileInputStream;

    invoke-direct {v2, v0}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 76
    .end local v1    # "inputFile":Ljava/io/InputStream;
    .local v2, "inputFile":Ljava/io/InputStream;
    :try_start_1
    const-string v3, "UTF-8"

    invoke-static {v2, v3}, Lorg/apache/commons/io/IOUtils;->toString(Ljava/io/InputStream;Ljava/lang/String;)Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-result-object v3

    .line 78
    if-eqz v2, :cond_0

    .line 80
    :try_start_2
    invoke-virtual {v2}, Ljava/io/InputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0

    .line 81
    :cond_0
    :goto_0
    return-object v3

    .line 78
    .end local v0    # "file":Ljava/io/File;
    .end local v2    # "inputFile":Ljava/io/InputStream;
    .restart local v1    # "inputFile":Ljava/io/InputStream;
    :catchall_0
    move-exception v3

    :goto_1
    if-eqz v1, :cond_1

    .line 80
    :try_start_3
    invoke-virtual {v1}, Ljava/io/InputStream;->close()V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_1

    .line 81
    :cond_1
    :goto_2
    throw v3

    .end local v1    # "inputFile":Ljava/io/InputStream;
    .restart local v0    # "file":Ljava/io/File;
    .restart local v2    # "inputFile":Ljava/io/InputStream;
    :catch_0
    move-exception v4

    goto :goto_0

    .end local v0    # "file":Ljava/io/File;
    .end local v2    # "inputFile":Ljava/io/InputStream;
    .restart local v1    # "inputFile":Ljava/io/InputStream;
    :catch_1
    move-exception v4

    goto :goto_2

    .line 78
    .end local v1    # "inputFile":Ljava/io/InputStream;
    .restart local v0    # "file":Ljava/io/File;
    .restart local v2    # "inputFile":Ljava/io/InputStream;
    :catchall_1
    move-exception v3

    move-object v1, v2

    .end local v2    # "inputFile":Ljava/io/InputStream;
    .restart local v1    # "inputFile":Ljava/io/InputStream;
    goto :goto_1
.end method
