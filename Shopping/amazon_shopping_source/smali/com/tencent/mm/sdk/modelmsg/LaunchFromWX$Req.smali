.class public Lcom/tencent/mm/sdk/modelmsg/LaunchFromWX$Req;
.super Lcom/tencent/mm/sdk/modelbase/BaseReq;
.source "LaunchFromWX.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/mm/sdk/modelmsg/LaunchFromWX;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Req"
.end annotation


# instance fields
.field public country:Ljava/lang/String;

.field public lang:Ljava/lang/String;

.field public messageAction:Ljava/lang/String;

.field public messageExt:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/tencent/mm/sdk/modelbase/BaseReq;-><init>()V

    .line 51
    return-void
.end method

.method public constructor <init>(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "data"    # Landroid/os/Bundle;

    .prologue
    .line 61
    invoke-direct {p0}, Lcom/tencent/mm/sdk/modelbase/BaseReq;-><init>()V

    .line 62
    invoke-virtual {p0, p1}, Lcom/tencent/mm/sdk/modelmsg/LaunchFromWX$Req;->fromBundle(Landroid/os/Bundle;)V

    .line 63
    return-void
.end method


# virtual methods
.method public checkArgs()Z
    .locals 3

    .prologue
    const/16 v2, 0x800

    const/4 v0, 0x0

    .line 90
    iget-object v1, p0, Lcom/tencent/mm/sdk/modelmsg/LaunchFromWX$Req;->messageAction:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/tencent/mm/sdk/modelmsg/LaunchFromWX$Req;->messageAction:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-le v1, v2, :cond_0

    .line 91
    const-string/jumbo v1, "MicroMsg.SDK.LaunchFromWX.Req"

    const-string/jumbo v2, "checkArgs fail, messageAction is too long"

    invoke-static {v1, v2}, Lcom/tencent/mm/sdk/platformtools/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 100
    :goto_0
    return v0

    .line 95
    :cond_0
    iget-object v1, p0, Lcom/tencent/mm/sdk/modelmsg/LaunchFromWX$Req;->messageExt:Ljava/lang/String;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/tencent/mm/sdk/modelmsg/LaunchFromWX$Req;->messageExt:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-le v1, v2, :cond_1

    .line 96
    const-string/jumbo v1, "MicroMsg.SDK.LaunchFromWX.Req"

    const-string/jumbo v2, "checkArgs fail, messageExt is too long"

    invoke-static {v1, v2}, Lcom/tencent/mm/sdk/platformtools/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 100
    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public fromBundle(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "data"    # Landroid/os/Bundle;

    .prologue
    .line 76
    invoke-super {p0, p1}, Lcom/tencent/mm/sdk/modelbase/BaseReq;->fromBundle(Landroid/os/Bundle;)V

    .line 77
    const-string/jumbo v0, "_wxobject_message_action"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/mm/sdk/modelmsg/LaunchFromWX$Req;->messageAction:Ljava/lang/String;

    .line 78
    const-string/jumbo v0, "_wxobject_message_ext"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/mm/sdk/modelmsg/LaunchFromWX$Req;->messageExt:Ljava/lang/String;

    .line 79
    const-string/jumbo v0, "_wxapi_launch_req_lang"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/mm/sdk/modelmsg/LaunchFromWX$Req;->lang:Ljava/lang/String;

    .line 80
    const-string/jumbo v0, "_wxapi_launch_req_country"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/mm/sdk/modelmsg/LaunchFromWX$Req;->country:Ljava/lang/String;

    .line 81
    return-void
.end method

.method public getType()I
    .locals 1

    .prologue
    .line 85
    const/4 v0, 0x6

    return v0
.end method

.method public toBundle(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "data"    # Landroid/os/Bundle;

    .prologue
    .line 67
    invoke-super {p0, p1}, Lcom/tencent/mm/sdk/modelbase/BaseReq;->toBundle(Landroid/os/Bundle;)V

    .line 68
    const-string/jumbo v0, "_wxobject_message_action"

    iget-object v1, p0, Lcom/tencent/mm/sdk/modelmsg/LaunchFromWX$Req;->messageAction:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 69
    const-string/jumbo v0, "_wxobject_message_ext"

    iget-object v1, p0, Lcom/tencent/mm/sdk/modelmsg/LaunchFromWX$Req;->messageExt:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 70
    const-string/jumbo v0, "_wxapi_launch_req_lang"

    iget-object v1, p0, Lcom/tencent/mm/sdk/modelmsg/LaunchFromWX$Req;->lang:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 71
    const-string/jumbo v0, "_wxapi_launch_req_country"

    iget-object v1, p0, Lcom/tencent/mm/sdk/modelmsg/LaunchFromWX$Req;->country:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 72
    return-void
.end method
