.class public Lcom/comcast/playerplatform/primetime/android/eas/AlertResponseHandler;
.super Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;
.source "AlertResponseHandler.java"


# instance fields
.field private listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;


# direct methods
.method public constructor <init>(Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;-><init>()V

    .line 15
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertResponseHandler;->listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    .line 16
    return-void
.end method

.method private declared-synchronized handleResponse(Ljava/lang/String;)V
    .locals 5
    .param p1, "response"    # Ljava/lang/String;

    .prologue
    .line 29
    monitor-enter p0

    :try_start_0
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v2

    if-nez v2, :cond_0

    .line 31
    :try_start_1
    invoke-static {p1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertsXmlParser;->parseAlertXML(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v1

    .line 33
    .local v1, "newAlerts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/comcast/playerplatform/primetime/android/eas/Alert;>;"
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertResponseHandler;->listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    invoke-virtual {v2, v1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;->updateAlertsReceived(Ljava/util/ArrayList;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 38
    .end local v1    # "newAlerts":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/comcast/playerplatform/primetime/android/eas/Alert;>;"
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 34
    :catch_0
    move-exception v0

    .line 35
    .local v0, "e":Ljava/lang/Exception;
    :try_start_2
    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertResponseHandler;->listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "An Exception occured parsing the emergency alert response {"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "}"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;->requestFailed(Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 29
    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method


# virtual methods
.method public requestFailed(Ljava/lang/String;)V
    .locals 1
    .param p1, "response"    # Ljava/lang/String;

    .prologue
    .line 25
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/AlertResponseHandler;->listener:Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;

    invoke-virtual {v0, p1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertEventListener;->requestFailed(Ljava/lang/String;)V

    .line 26
    return-void
.end method

.method public responseReceived(Ljava/lang/String;)V
    .locals 0
    .param p1, "response"    # Ljava/lang/String;

    .prologue
    .line 20
    invoke-direct {p0, p1}, Lcom/comcast/playerplatform/primetime/android/eas/AlertResponseHandler;->handleResponse(Ljava/lang/String;)V

    .line 21
    return-void
.end method
