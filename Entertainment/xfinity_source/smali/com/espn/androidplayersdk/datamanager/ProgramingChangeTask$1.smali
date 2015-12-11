.class Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask$1;
.super Ljava/lang/Object;
.source "ProgramingChangeTask.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;


# direct methods
.method constructor <init>(Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask$1;->this$0:Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;

    .line 96
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 102
    :try_start_0
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask$1;->this$0:Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;

    iget-object v1, v1, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->feedsManager:Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    new-instance v2, Ljava/lang/StringBuilder;

    iget-object v3, p0, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask$1;->this$0:Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;

    iget-object v3, v3, Lcom/espn/androidplayersdk/datamanager/ProgramingChangeTask;->epStream:Lcom/espn/androidplayersdk/datamanager/EPStream;

    invoke-virtual {v3}, Lcom/espn/androidplayersdk/datamanager/EPStream;->getProgramChangeUrl()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "&"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getApiKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "&v=2.0.0"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getProgramingChangeResponse(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 106
    :goto_0
    return-void

    .line 103
    :catch_0
    move-exception v0

    .line 104
    .local v0, "e":Ljava/lang/Exception;
    const-string v1, "URL encoding failed"

    const/4 v2, 0x5

    invoke-static {v1, v2, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method
