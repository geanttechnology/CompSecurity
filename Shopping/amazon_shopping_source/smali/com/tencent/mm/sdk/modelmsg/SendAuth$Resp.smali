.class public Lcom/tencent/mm/sdk/modelmsg/SendAuth$Resp;
.super Lcom/tencent/mm/sdk/modelbase/BaseResp;
.source "SendAuth.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/mm/sdk/modelmsg/SendAuth;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Resp"
.end annotation


# instance fields
.field public code:Ljava/lang/String;

.field public country:Ljava/lang/String;

.field public lang:Ljava/lang/String;

.field public state:Ljava/lang/String;

.field public url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 166
    invoke-direct {p0}, Lcom/tencent/mm/sdk/modelbase/BaseResp;-><init>()V

    .line 168
    return-void
.end method

.method public constructor <init>(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "data"    # Landroid/os/Bundle;

    .prologue
    .line 178
    invoke-direct {p0}, Lcom/tencent/mm/sdk/modelbase/BaseResp;-><init>()V

    .line 179
    invoke-virtual {p0, p1}, Lcom/tencent/mm/sdk/modelmsg/SendAuth$Resp;->fromBundle(Landroid/os/Bundle;)V

    .line 180
    return-void
.end method


# virtual methods
.method public checkArgs()Z
    .locals 2

    .prologue
    .line 209
    iget-object v0, p0, Lcom/tencent/mm/sdk/modelmsg/SendAuth$Resp;->state:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/tencent/mm/sdk/modelmsg/SendAuth$Resp;->state:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0x400

    if-le v0, v1, :cond_0

    .line 210
    const-string/jumbo v0, "MicroMsg.SDK.SendAuth.Resp"

    const-string/jumbo v1, "checkArgs fail, state is invalid"

    invoke-static {v0, v1}, Lcom/tencent/mm/sdk/platformtools/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 211
    const/4 v0, 0x0

    .line 214
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public fromBundle(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "data"    # Landroid/os/Bundle;

    .prologue
    .line 189
    invoke-super {p0, p1}, Lcom/tencent/mm/sdk/modelbase/BaseResp;->fromBundle(Landroid/os/Bundle;)V

    .line 190
    const-string/jumbo v0, "_wxapi_sendauth_resp_token"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/mm/sdk/modelmsg/SendAuth$Resp;->code:Ljava/lang/String;

    .line 191
    const-string/jumbo v0, "_wxapi_sendauth_resp_state"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/mm/sdk/modelmsg/SendAuth$Resp;->state:Ljava/lang/String;

    .line 192
    const-string/jumbo v0, "_wxapi_sendauth_resp_url"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/mm/sdk/modelmsg/SendAuth$Resp;->url:Ljava/lang/String;

    .line 193
    const-string/jumbo v0, "_wxapi_sendauth_resp_lang"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/mm/sdk/modelmsg/SendAuth$Resp;->lang:Ljava/lang/String;

    .line 194
    const-string/jumbo v0, "_wxapi_sendauth_resp_country"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/mm/sdk/modelmsg/SendAuth$Resp;->country:Ljava/lang/String;

    .line 195
    return-void
.end method

.method public getType()I
    .locals 1

    .prologue
    .line 184
    const/4 v0, 0x1

    return v0
.end method

.method public toBundle(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "data"    # Landroid/os/Bundle;

    .prologue
    .line 199
    invoke-super {p0, p1}, Lcom/tencent/mm/sdk/modelbase/BaseResp;->toBundle(Landroid/os/Bundle;)V

    .line 200
    const-string/jumbo v0, "_wxapi_sendauth_resp_token"

    iget-object v1, p0, Lcom/tencent/mm/sdk/modelmsg/SendAuth$Resp;->code:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 201
    const-string/jumbo v0, "_wxapi_sendauth_resp_state"

    iget-object v1, p0, Lcom/tencent/mm/sdk/modelmsg/SendAuth$Resp;->state:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 202
    const-string/jumbo v0, "_wxapi_sendauth_resp_url"

    iget-object v1, p0, Lcom/tencent/mm/sdk/modelmsg/SendAuth$Resp;->url:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 203
    const-string/jumbo v0, "_wxapi_sendauth_resp_lang"

    iget-object v1, p0, Lcom/tencent/mm/sdk/modelmsg/SendAuth$Resp;->lang:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 204
    const-string/jumbo v0, "_wxapi_sendauth_resp_country"

    iget-object v1, p0, Lcom/tencent/mm/sdk/modelmsg/SendAuth$Resp;->country:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 205
    return-void
.end method
