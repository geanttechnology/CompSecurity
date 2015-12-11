.class Lcom/penthera/virtuososdk/service/VirtuosoService$2;
.super Landroid/content/BroadcastReceiver;
.source "VirtuosoService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/service/VirtuosoService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;


# direct methods
.method constructor <init>(Lcom/penthera/virtuososdk/service/VirtuosoService;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$2;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    .line 1063
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "aIntent"    # Landroid/content/Intent;

    .prologue
    .line 1068
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 1069
    .local v0, "action":Ljava/lang/String;
    if-nez v0, :cond_1

    .line 1070
    const-string v2, "VirtuosoService-ApiReceiver"

    const-string v3, "onReceive(): null action"

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1112
    :cond_0
    :goto_0
    return-void

    .line 1074
    :cond_1
    const-string v2, "VirtuosoService-ApiReceiver"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "got action ["

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "]"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1075
    const-string v2, "virtuoso.intent.action.COMMS_FAILURE"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 1079
    const-string v2, "virtuoso.intent.action.QUEUE_CHANGED"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 1081
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 1082
    .local v1, "extras":Landroid/os/Bundle;
    iget-object v2, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$2;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    const-string v3, "com.penthera.virtuososdk.client.pckg"

    invoke-virtual {v1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    sget-object v4, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EDownloadQueueChanged:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    # invokes: Lcom/penthera/virtuososdk/service/VirtuosoService;->performDownloadEngineCallback(Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V
    invoke-static {v2, v3, v4, v1}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$8(Lcom/penthera/virtuososdk/service/VirtuosoService;Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V

    .line 1083
    iget-object v2, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$2;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    const-string v3, "com.penthera.virtuososdk.client.pckg"

    invoke-virtual {v1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    sget-object v4, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EFullListChanged:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    # invokes: Lcom/penthera/virtuososdk/service/VirtuosoService;->performEngineCallback(Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V
    invoke-static {v2, v3, v4, v1}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$9(Lcom/penthera/virtuososdk/service/VirtuosoService;Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V

    goto :goto_0

    .line 1085
    .end local v1    # "extras":Landroid/os/Bundle;
    :cond_2
    const-string v2, "virtuoso.intent.action.DOWNLOAD_LIST_CHANGED"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 1087
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 1088
    .restart local v1    # "extras":Landroid/os/Bundle;
    iget-object v2, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$2;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    const-string v3, "com.penthera.virtuososdk.client.pckg"

    invoke-virtual {v1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    sget-object v4, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EDownloadedListChanged:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    # invokes: Lcom/penthera/virtuososdk/service/VirtuosoService;->performDownloadEngineCallback(Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V
    invoke-static {v2, v3, v4, v1}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$8(Lcom/penthera/virtuososdk/service/VirtuosoService;Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V

    .line 1089
    iget-object v2, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$2;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    const-string v3, "com.penthera.virtuososdk.client.pckg"

    invoke-virtual {v1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    sget-object v4, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EFullListChanged:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    # invokes: Lcom/penthera/virtuososdk/service/VirtuosoService;->performEngineCallback(Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V
    invoke-static {v2, v3, v4, v1}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$9(Lcom/penthera/virtuososdk/service/VirtuosoService;Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V

    goto :goto_0

    .line 1091
    .end local v1    # "extras":Landroid/os/Bundle;
    :cond_3
    const-string v2, "virtuoso.intent.action.INTENT_FRAGMENT_COMPLETE_CALLBACK"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 1093
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 1094
    .restart local v1    # "extras":Landroid/os/Bundle;
    iget-object v2, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$2;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    const-string v3, "com.penthera.virtuososdk.client.pckg"

    invoke-virtual {v1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    sget-object v4, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EFragmentComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    # invokes: Lcom/penthera/virtuososdk/service/VirtuosoService;->performQueueCallback(Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V
    invoke-static {v2, v3, v4, v1}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$10(Lcom/penthera/virtuososdk/service/VirtuosoService;Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V

    goto/16 :goto_0

    .line 1096
    .end local v1    # "extras":Landroid/os/Bundle;
    :cond_4
    const-string v2, "virtuoso.intent.action.DOWNLOAD_CALLBACK"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 1098
    iget-object v2, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$2;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iServiceStarted:Z
    invoke-static {v2}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$11(Lcom/penthera/virtuososdk/service/VirtuosoService;)Z

    move-result v2

    if-nez v2, :cond_5

    .line 1100
    const-string v2, "virtuoso.intent.action.DOWNLOAD_UPDATE"

    invoke-static {v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendBroadcast(Ljava/lang/String;)V

    .line 1103
    :cond_5
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 1104
    .restart local v1    # "extras":Landroid/os/Bundle;
    iget-object v2, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$2;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    const-string v3, "com.penthera.virtuososdk.client.pckg"

    invoke-virtual {v1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->values()[Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    move-result-object v4

    const-string v5, "download_update_type"

    invoke-virtual {v1, v5}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v5

    aget-object v4, v4, v5

    const-string v5, "download_update_data"

    invoke-virtual {v1, v5}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v5

    # invokes: Lcom/penthera/virtuososdk/service/VirtuosoService;->performDownloadEngineCallback(Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V
    invoke-static {v2, v3, v4, v5}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$8(Lcom/penthera/virtuososdk/service/VirtuosoService;Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V

    goto/16 :goto_0

    .line 1105
    .end local v1    # "extras":Landroid/os/Bundle;
    :cond_6
    const-string v2, "virtuoso.intent.action.SETTING_CHANGED"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 1106
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 1107
    .restart local v1    # "extras":Landroid/os/Bundle;
    iget-object v2, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$2;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    const-string v3, "com.penthera.virtuososdk.client.pckg"

    invoke-virtual {v1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    sget-object v4, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ESettingsChanged:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    # invokes: Lcom/penthera/virtuososdk/service/VirtuosoService;->performDownloadEngineCallback(Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V
    invoke-static {v2, v3, v4, v1}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$8(Lcom/penthera/virtuososdk/service/VirtuosoService;Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V

    goto/16 :goto_0

    .line 1109
    .end local v1    # "extras":Landroid/os/Bundle;
    :cond_7
    const-string v2, "VirtuosoService-ApiReceiver"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "onReceive(): unknown action: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0
.end method
