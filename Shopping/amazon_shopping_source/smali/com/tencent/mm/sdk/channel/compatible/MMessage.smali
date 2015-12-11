.class public Lcom/tencent/mm/sdk/channel/compatible/MMessage;
.super Ljava/lang/Object;
.source "MMessage.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/tencent/mm/sdk/channel/compatible/MMessage$Args;
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 63
    return-void
.end method

.method public static send(Landroid/content/Context;Lcom/tencent/mm/sdk/channel/compatible/MMessage$Args;)Z
    .locals 7
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "args"    # Lcom/tencent/mm/sdk/channel/compatible/MMessage$Args;

    .prologue
    const v6, 0x22010003

    const/4 v4, 0x0

    .line 28
    if-eqz p0, :cond_0

    if-nez p1, :cond_1

    .line 29
    :cond_0
    const-string/jumbo v5, "MicroMsg.SDK.MMessage"

    const-string/jumbo v6, "send fail, invalid argument"

    invoke-static {v5, v6}, Lcom/tencent/mm/sdk/platformtools/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 60
    :goto_0
    return v4

    .line 33
    :cond_1
    iget-object v5, p1, Lcom/tencent/mm/sdk/channel/compatible/MMessage$Args;->action:Ljava/lang/String;

    invoke-static {v5}, Lcom/tencent/mm/sdk/platformtools/Util;->isNullOrNil(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 34
    const-string/jumbo v5, "MicroMsg.SDK.MMessage"

    const-string/jumbo v6, "send fail, action is null"

    invoke-static {v5, v6}, Lcom/tencent/mm/sdk/platformtools/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 38
    :cond_2
    const/4 v2, 0x0

    .line 39
    .local v2, "perm":Ljava/lang/String;
    iget-object v4, p1, Lcom/tencent/mm/sdk/channel/compatible/MMessage$Args;->targetPkg:Ljava/lang/String;

    invoke-static {v4}, Lcom/tencent/mm/sdk/platformtools/Util;->isNullOrNil(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_3

    .line 40
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v5, p1, Lcom/tencent/mm/sdk/channel/compatible/MMessage$Args;->targetPkg:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, ".permission.MM_MESSAGE"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 43
    :cond_3
    new-instance v0, Landroid/content/Intent;

    iget-object v4, p1, Lcom/tencent/mm/sdk/channel/compatible/MMessage$Args;->action:Ljava/lang/String;

    invoke-direct {v0, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 45
    .local v0, "intent":Landroid/content/Intent;
    iget-object v4, p1, Lcom/tencent/mm/sdk/channel/compatible/MMessage$Args;->bundle:Landroid/os/Bundle;

    if-eqz v4, :cond_4

    .line 46
    iget-object v4, p1, Lcom/tencent/mm/sdk/channel/compatible/MMessage$Args;->bundle:Landroid/os/Bundle;

    invoke-virtual {v0, v4}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 49
    :cond_4
    const v3, 0x22010003

    .line 50
    .local v3, "sdkVersion":I
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    .line 52
    .local v1, "packageName":Ljava/lang/String;
    const-string/jumbo v4, "_mmessage_sdkVersion"

    invoke-virtual {v0, v4, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 53
    const-string/jumbo v4, "_mmessage_appPackage"

    invoke-virtual {v0, v4, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 54
    const-string/jumbo v4, "_mmessage_content"

    iget-object v5, p1, Lcom/tencent/mm/sdk/channel/compatible/MMessage$Args;->content:Ljava/lang/String;

    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 55
    const-string/jumbo v4, "_mmessage_checksum"

    iget-object v5, p1, Lcom/tencent/mm/sdk/channel/compatible/MMessage$Args;->content:Ljava/lang/String;

    invoke-static {v5, v6, v1}, Lcom/tencent/mm/sdk/channel/compatible/MMessageUtil;->genCheckSum(Ljava/lang/String;ILjava/lang/String;)[B

    move-result-object v5

    invoke-virtual {v0, v4, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;[B)Landroid/content/Intent;

    .line 57
    invoke-virtual {p0, v0, v2}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    .line 59
    const-string/jumbo v4, "MicroMsg.SDK.MMessage"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "send mm message, intent="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, ", perm="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/tencent/mm/sdk/platformtools/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 60
    const/4 v4, 0x1

    goto/16 :goto_0
.end method
