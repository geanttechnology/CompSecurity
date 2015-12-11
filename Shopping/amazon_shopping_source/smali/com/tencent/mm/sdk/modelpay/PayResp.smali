.class public Lcom/tencent/mm/sdk/modelpay/PayResp;
.super Lcom/tencent/mm/sdk/modelbase/BaseResp;
.source "PayResp.java"


# instance fields
.field public extData:Ljava/lang/String;

.field public prepayId:Ljava/lang/String;

.field public returnKey:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Lcom/tencent/mm/sdk/modelbase/BaseResp;-><init>()V

    return-void
.end method

.method public constructor <init>(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "data"    # Landroid/os/Bundle;

    .prologue
    .line 39
    invoke-direct {p0}, Lcom/tencent/mm/sdk/modelbase/BaseResp;-><init>()V

    .line 40
    invoke-virtual {p0, p1}, Lcom/tencent/mm/sdk/modelpay/PayResp;->fromBundle(Landroid/os/Bundle;)V

    .line 41
    return-void
.end method


# virtual methods
.method public checkArgs()Z
    .locals 1

    .prologue
    .line 66
    const/4 v0, 0x1

    return v0
.end method

.method public fromBundle(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "data"    # Landroid/os/Bundle;

    .prologue
    .line 53
    invoke-super {p0, p1}, Lcom/tencent/mm/sdk/modelbase/BaseResp;->fromBundle(Landroid/os/Bundle;)V

    .line 54
    const-string/jumbo v0, "_wxapi_payresp_prepayid"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/mm/sdk/modelpay/PayResp;->prepayId:Ljava/lang/String;

    .line 55
    const-string/jumbo v0, "_wxapi_payresp_returnkey"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/mm/sdk/modelpay/PayResp;->returnKey:Ljava/lang/String;

    .line 56
    const-string/jumbo v0, "_wxapi_payresp_extdata"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/mm/sdk/modelpay/PayResp;->extData:Ljava/lang/String;

    .line 57
    return-void
.end method

.method public getType()I
    .locals 1

    .prologue
    .line 61
    const/4 v0, 0x5

    return v0
.end method

.method public toBundle(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "data"    # Landroid/os/Bundle;

    .prologue
    .line 45
    invoke-super {p0, p1}, Lcom/tencent/mm/sdk/modelbase/BaseResp;->toBundle(Landroid/os/Bundle;)V

    .line 46
    const-string/jumbo v0, "_wxapi_payresp_prepayid"

    iget-object v1, p0, Lcom/tencent/mm/sdk/modelpay/PayResp;->prepayId:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 47
    const-string/jumbo v0, "_wxapi_payresp_returnkey"

    iget-object v1, p0, Lcom/tencent/mm/sdk/modelpay/PayResp;->returnKey:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 48
    const-string/jumbo v0, "_wxapi_payresp_extdata"

    iget-object v1, p0, Lcom/tencent/mm/sdk/modelpay/PayResp;->extData:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 49
    return-void
.end method
