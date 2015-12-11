.class Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$2;
.super Ljava/lang/Object;
.source "EmergencyAlertProvider.java"

# interfaces
.implements Lcom/comcast/playerplatform/util/android/Clock$ClockEventListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;


# direct methods
.method constructor <init>(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;)V
    .locals 0

    .prologue
    .line 118
    iput-object p1, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$2;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onTick(Ljava/lang/String;)V
    .locals 9
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 121
    iget-object v0, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$2;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    # invokes: Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->playAlertIfReady()V
    invoke-static {v0}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->access$700(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;)V

    .line 122
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->getInstance()Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;

    move-result-object v8

    new-instance v0, Lcom/comcast/playerplatform/util/android/XrestHelper;

    const-string v1, ""

    iget-object v2, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$2;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->alertServiceUrl:Ljava/net/URI;
    invoke-static {v2}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->access$800(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;)Ljava/net/URI;

    move-result-object v2

    invoke-virtual {v2}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "GET"

    iget-object v4, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$2;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->requestHeaders:Ljava/util/HashMap;
    invoke-static {v4}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->access$900(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;)Ljava/util/HashMap;

    move-result-object v4

    iget-object v5, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$2;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->alertResponseHandler:Lcom/comcast/playerplatform/primetime/android/eas/AlertResponseHandler;
    invoke-static {v5}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->access$1000(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;)Lcom/comcast/playerplatform/primetime/android/eas/AlertResponseHandler;

    move-result-object v5

    iget-object v6, p0, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider$2;->this$0:Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;

    # getter for: Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    invoke-static {v6}, Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;->access$1100(Lcom/comcast/playerplatform/primetime/android/eas/EmergencyAlertProvider;)Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v6

    const/4 v7, 0x0

    invoke-direct/range {v0 .. v7}, Lcom/comcast/playerplatform/util/android/XrestHelper;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Lcom/comcast/playerplatform/util/android/AbstractResponseEventListener;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/comcast/playerplatform/util/android/MoneyTrace;)V

    invoke-virtual {v8, v0}, Lcom/comcast/playerplatform/primetime/android/util/ThreadManager;->executeRunnable(Ljava/lang/Runnable;)V

    .line 123
    return-void
.end method
