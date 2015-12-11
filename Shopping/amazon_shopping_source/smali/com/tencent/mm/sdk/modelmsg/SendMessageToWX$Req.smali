.class public Lcom/tencent/mm/sdk/modelmsg/SendMessageToWX$Req;
.super Lcom/tencent/mm/sdk/modelbase/BaseReq;
.source "SendMessageToWX.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/mm/sdk/modelmsg/SendMessageToWX;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Req"
.end annotation


# instance fields
.field public message:Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage;

.field public scene:I


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 71
    invoke-direct {p0}, Lcom/tencent/mm/sdk/modelbase/BaseReq;-><init>()V

    .line 73
    return-void
.end method


# virtual methods
.method public checkArgs()Z
    .locals 3

    .prologue
    .line 108
    iget-object v1, p0, Lcom/tencent/mm/sdk/modelmsg/SendMessageToWX$Req;->message:Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage;

    if-nez v1, :cond_0

    .line 109
    const-string/jumbo v1, "MicroMsg.SDK.SendMessageToWX.Req"

    const-string/jumbo v2, "checkArgs fail ,message is null"

    invoke-static {v1, v2}, Lcom/tencent/mm/sdk/platformtools/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 110
    const/4 v1, 0x0

    .line 118
    :goto_0
    return v1

    .line 113
    :cond_0
    iget-object v1, p0, Lcom/tencent/mm/sdk/modelmsg/SendMessageToWX$Req;->message:Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage;

    iget-object v1, v1, Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage;->mediaObject:Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage$IMediaObject;

    invoke-interface {v1}, Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage$IMediaObject;->type()I

    move-result v1

    const/4 v2, 0x6

    if-ne v1, v2, :cond_1

    iget v1, p0, Lcom/tencent/mm/sdk/modelmsg/SendMessageToWX$Req;->scene:I

    const/4 v2, 0x2

    if-ne v1, v2, :cond_1

    .line 115
    iget-object v1, p0, Lcom/tencent/mm/sdk/modelmsg/SendMessageToWX$Req;->message:Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage;

    iget-object v1, v1, Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage;->mediaObject:Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage$IMediaObject;

    check-cast v1, Lcom/tencent/mm/sdk/modelmsg/WXFileObject;

    move-object v0, v1

    check-cast v0, Lcom/tencent/mm/sdk/modelmsg/WXFileObject;

    .line 116
    .local v0, "fileObject":Lcom/tencent/mm/sdk/modelmsg/WXFileObject;
    const/high16 v1, 0x1900000

    invoke-virtual {v0, v1}, Lcom/tencent/mm/sdk/modelmsg/WXFileObject;->setContentLengthLimit(I)V

    .line 118
    .end local v0    # "fileObject":Lcom/tencent/mm/sdk/modelmsg/WXFileObject;
    :cond_1
    iget-object v1, p0, Lcom/tencent/mm/sdk/modelmsg/SendMessageToWX$Req;->message:Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage;

    invoke-virtual {v1}, Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage;->checkArgs()Z

    move-result v1

    goto :goto_0
.end method

.method public fromBundle(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "data"    # Landroid/os/Bundle;

    .prologue
    .line 94
    invoke-super {p0, p1}, Lcom/tencent/mm/sdk/modelbase/BaseReq;->fromBundle(Landroid/os/Bundle;)V

    .line 95
    invoke-static {p1}, Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage$Builder;->fromBundle(Landroid/os/Bundle;)Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/mm/sdk/modelmsg/SendMessageToWX$Req;->message:Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage;

    .line 96
    const-string/jumbo v0, "_wxapi_sendmessagetowx_req_scene"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/tencent/mm/sdk/modelmsg/SendMessageToWX$Req;->scene:I

    .line 97
    return-void
.end method

.method public getType()I
    .locals 1

    .prologue
    .line 89
    const/4 v0, 0x2

    return v0
.end method

.method public toBundle(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "data"    # Landroid/os/Bundle;

    .prologue
    .line 101
    invoke-super {p0, p1}, Lcom/tencent/mm/sdk/modelbase/BaseReq;->toBundle(Landroid/os/Bundle;)V

    .line 102
    iget-object v0, p0, Lcom/tencent/mm/sdk/modelmsg/SendMessageToWX$Req;->message:Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage;

    invoke-static {v0}, Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage$Builder;->toBundle(Lcom/tencent/mm/sdk/modelmsg/WXMediaMessage;)Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 103
    const-string/jumbo v0, "_wxapi_sendmessagetowx_req_scene"

    iget v1, p0, Lcom/tencent/mm/sdk/modelmsg/SendMessageToWX$Req;->scene:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 104
    return-void
.end method
