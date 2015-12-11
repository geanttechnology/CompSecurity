.class public Lcom/tencent/mm/sdk/channel/MMessageActV2;
.super Ljava/lang/Object;
.source "MMessageActV2.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 14
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 81
    return-void
.end method

.method public static send(Landroid/content/Context;Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;)Z
    .locals 10
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "args"    # Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;

    .prologue
    const v9, 0x22010003

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 23
    if-eqz p0, :cond_0

    if-nez p1, :cond_1

    .line 24
    :cond_0
    const-string/jumbo v5, "MicroMsg.SDK.MMessageAct"

    const-string/jumbo v6, "send fail, invalid argument"

    invoke-static {v5, v6}, Lcom/tencent/mm/sdk/platformtools/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 67
    :goto_0
    return v4

    .line 28
    :cond_1
    iget-object v6, p1, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;->targetPkgName:Ljava/lang/String;

    invoke-static {v6}, Lcom/tencent/mm/sdk/platformtools/Util;->isNullOrNil(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 29
    const-string/jumbo v5, "MicroMsg.SDK.MMessageAct"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "send fail, invalid targetPkgName, targetPkgName = "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p1, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;->targetPkgName:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/tencent/mm/sdk/platformtools/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 33
    :cond_2
    iget-object v6, p1, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;->targetClassName:Ljava/lang/String;

    invoke-static {v6}, Lcom/tencent/mm/sdk/platformtools/Util;->isNullOrNil(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 34
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v7, p1, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;->targetPkgName:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, ".wxapi.WXEntryActivity"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    iput-object v6, p1, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;->targetClassName:Ljava/lang/String;

    .line 37
    :cond_3
    const-string/jumbo v6, "MicroMsg.SDK.MMessageAct"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "send, targetPkgName = "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p1, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;->targetPkgName:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string/jumbo v8, ", targetClassName = "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-object v8, p1, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;->targetClassName:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/tencent/mm/sdk/platformtools/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 39
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 40
    .local v1, "intent":Landroid/content/Intent;
    iget-object v6, p1, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;->targetPkgName:Ljava/lang/String;

    iget-object v7, p1, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;->targetClassName:Ljava/lang/String;

    invoke-virtual {v1, v6, v7}, Landroid/content/Intent;->setClassName(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 41
    iget-object v6, p1, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;->bundle:Landroid/os/Bundle;

    if-eqz v6, :cond_4

    .line 42
    iget-object v6, p1, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;->bundle:Landroid/os/Bundle;

    invoke-virtual {v1, v6}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 45
    :cond_4
    const v2, 0x22010003

    .line 46
    .local v2, "sdkVersion":I
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    .line 48
    .local v3, "senderPkgName":Ljava/lang/String;
    const-string/jumbo v6, "_mmessage_sdkVersion"

    invoke-virtual {v1, v6, v9}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 49
    const-string/jumbo v6, "_mmessage_appPackage"

    invoke-virtual {v1, v6, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 50
    const-string/jumbo v6, "_mmessage_content"

    iget-object v7, p1, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;->content:Ljava/lang/String;

    invoke-virtual {v1, v6, v7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 51
    const-string/jumbo v6, "_mmessage_checksum"

    iget-object v7, p1, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;->content:Ljava/lang/String;

    invoke-static {v7, v9, v3}, Lcom/tencent/mm/sdk/channel/compatible/MMessageUtil;->genCheckSum(Ljava/lang/String;ILjava/lang/String;)[B

    move-result-object v7

    invoke-virtual {v1, v6, v7}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[B)Landroid/content/Intent;

    .line 53
    iget v6, p1, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;->flags:I

    const/4 v7, -0x1

    if-ne v6, v7, :cond_5

    .line 54
    const/high16 v6, 0x10000000

    invoke-virtual {v1, v6}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    move-result-object v6

    const/high16 v7, 0x8000000

    invoke-virtual {v6, v7}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 60
    :goto_1
    :try_start_0
    invoke-virtual {p0, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 66
    const-string/jumbo v4, "MicroMsg.SDK.MMessageAct"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "send mm message, intent="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v4, v6}, Lcom/tencent/mm/sdk/platformtools/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    move v4, v5

    .line 67
    goto/16 :goto_0

    .line 56
    :cond_5
    iget v6, p1, Lcom/tencent/mm/sdk/channel/MMessageActV2$Args;->flags:I

    invoke-virtual {v1, v6}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    goto :goto_1

    .line 61
    :catch_0
    move-exception v0

    .line 62
    .local v0, "e":Ljava/lang/Exception;
    const-string/jumbo v6, "MicroMsg.SDK.MMessageAct"

    const-string/jumbo v7, "send fail, ex = %s"

    new-array v5, v5, [Ljava/lang/Object;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v5, v4

    invoke-static {v6, v7, v5}, Lcom/tencent/mm/sdk/platformtools/Log;->e(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_0
.end method
