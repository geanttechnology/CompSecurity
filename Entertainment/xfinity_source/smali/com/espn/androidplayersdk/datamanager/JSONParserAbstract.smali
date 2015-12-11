.class abstract Lcom/espn/androidplayersdk/datamanager/JSONParserAbstract;
.super Ljava/lang/Object;
.source "JSONParserAbstract.java"

# interfaces
.implements Lcom/espn/androidplayersdk/datamanager/JSONParserInterface;


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method protected sendBroadcast(Ljava/lang/String;)V
    .locals 5
    .param p1, "espnIntent"    # Ljava/lang/String;

    .prologue
    .line 20
    :try_start_0
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 21
    .local v1, "intent":Landroid/content/Intent;
    invoke-virtual {v1, p1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 23
    sget-object v2, Lcom/espn/androidplayersdk/datamanager/DataManager;->mCtx:Landroid/content/Context;

    invoke-virtual {v2, v1}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 27
    .end local v1    # "intent":Landroid/content/Intent;
    :goto_0
    return-void

    .line 24
    :catch_0
    move-exception v0

    .line 25
    .local v0, "e":Ljava/lang/Exception;
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Error sending broadcast():"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    :goto_1
    const/4 v3, 0x5

    const/4 v4, 0x0

    invoke-static {v2, v3, v4}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0

    :cond_0
    const-string v2, ""

    goto :goto_1
.end method
