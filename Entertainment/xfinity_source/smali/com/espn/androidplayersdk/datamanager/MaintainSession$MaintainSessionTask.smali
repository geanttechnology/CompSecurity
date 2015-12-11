.class Lcom/espn/androidplayersdk/datamanager/MaintainSession$MaintainSessionTask;
.super Ljava/util/TimerTask;
.source "MaintainSession.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/espn/androidplayersdk/datamanager/MaintainSession;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "MaintainSessionTask"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/espn/androidplayersdk/datamanager/MaintainSession;


# direct methods
.method private constructor <init>(Lcom/espn/androidplayersdk/datamanager/MaintainSession;)V
    .locals 0

    .prologue
    .line 66
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/MaintainSession$MaintainSessionTask;->this$0:Lcom/espn/androidplayersdk/datamanager/MaintainSession;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/espn/androidplayersdk/datamanager/MaintainSession;Lcom/espn/androidplayersdk/datamanager/MaintainSession$MaintainSessionTask;)V
    .locals 0

    .prologue
    .line 66
    invoke-direct {p0, p1}, Lcom/espn/androidplayersdk/datamanager/MaintainSession$MaintainSessionTask;-><init>(Lcom/espn/androidplayersdk/datamanager/MaintainSession;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 71
    :try_start_0
    new-instance v2, Ljava/lang/StringBuilder;

    iget-object v3, p0, Lcom/espn/androidplayersdk/datamanager/MaintainSession$MaintainSessionTask;->this$0:Lcom/espn/androidplayersdk/datamanager/MaintainSession;

    iget-object v3, v3, Lcom/espn/androidplayersdk/datamanager/MaintainSession;->stream:Lcom/espn/androidplayersdk/datamanager/EPStream;

    invoke-virtual {v3}, Lcom/espn/androidplayersdk/datamanager/EPStream;->getMaintainUrl()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v3, "?token="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/espn/androidplayersdk/datamanager/MaintainSession$MaintainSessionTask;->this$0:Lcom/espn/androidplayersdk/datamanager/MaintainSession;

    iget-object v3, v3, Lcom/espn/androidplayersdk/datamanager/MaintainSession;->stream:Lcom/espn/androidplayersdk/datamanager/EPStream;

    invoke-virtual {v3}, Lcom/espn/androidplayersdk/datamanager/EPStream;->getToken()Ljava/lang/String;

    move-result-object v3

    const-string v4, "UTF-8"

    invoke-static {v3, v4}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "&v=2.0.0"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 72
    .local v1, "url":Ljava/lang/String;
    new-instance v2, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    iget-object v3, p0, Lcom/espn/androidplayersdk/datamanager/MaintainSession$MaintainSessionTask;->this$0:Lcom/espn/androidplayersdk/datamanager/MaintainSession;

    iget-object v3, v3, Lcom/espn/androidplayersdk/datamanager/MaintainSession;->listener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    invoke-direct {v2, v3}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;-><init>(Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;)V

    invoke-virtual {v2, v1}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getMaintianSessionResponse(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    .line 76
    .end local v1    # "url":Ljava/lang/String;
    :goto_0
    return-void

    .line 73
    :catch_0
    move-exception v0

    .line 74
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "MaintainSessionTask error: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->getMessage()Ljava/lang/String;

    move-result-object v2

    :goto_1
    const/4 v3, 0x5

    invoke-static {v2, v3, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0

    :cond_0
    const-string v2, ""

    goto :goto_1
.end method
