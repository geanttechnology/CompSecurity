.class public Lcom/tencent/mm/sdk/modelmsg/GetMessageFromWX$Req;
.super Lcom/tencent/mm/sdk/modelbase/BaseReq;
.source "GetMessageFromWX.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/tencent/mm/sdk/modelmsg/GetMessageFromWX;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Req"
.end annotation


# instance fields
.field public country:Ljava/lang/String;

.field public lang:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 51
    invoke-direct {p0}, Lcom/tencent/mm/sdk/modelbase/BaseReq;-><init>()V

    .line 53
    return-void
.end method

.method public constructor <init>(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "data"    # Landroid/os/Bundle;

    .prologue
    .line 63
    invoke-direct {p0}, Lcom/tencent/mm/sdk/modelbase/BaseReq;-><init>()V

    .line 64
    invoke-virtual {p0, p1}, Lcom/tencent/mm/sdk/modelmsg/GetMessageFromWX$Req;->fromBundle(Landroid/os/Bundle;)V

    .line 65
    return-void
.end method


# virtual methods
.method public checkArgs()Z
    .locals 1

    .prologue
    .line 88
    const/4 v0, 0x1

    return v0
.end method

.method public fromBundle(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "data"    # Landroid/os/Bundle;

    .prologue
    .line 81
    invoke-super {p0, p1}, Lcom/tencent/mm/sdk/modelbase/BaseReq;->fromBundle(Landroid/os/Bundle;)V

    .line 82
    const-string/jumbo v0, "_wxapi_getmessage_req_lang"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/mm/sdk/modelmsg/GetMessageFromWX$Req;->lang:Ljava/lang/String;

    .line 83
    const-string/jumbo v0, "_wxapi_getmessage_req_country"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/tencent/mm/sdk/modelmsg/GetMessageFromWX$Req;->country:Ljava/lang/String;

    .line 84
    return-void
.end method

.method public getType()I
    .locals 1

    .prologue
    .line 69
    const/4 v0, 0x3

    return v0
.end method

.method public toBundle(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "data"    # Landroid/os/Bundle;

    .prologue
    .line 74
    invoke-super {p0, p1}, Lcom/tencent/mm/sdk/modelbase/BaseReq;->toBundle(Landroid/os/Bundle;)V

    .line 75
    const-string/jumbo v0, "_wxapi_getmessage_req_lang"

    iget-object v1, p0, Lcom/tencent/mm/sdk/modelmsg/GetMessageFromWX$Req;->lang:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 76
    const-string/jumbo v0, "_wxapi_getmessage_req_country"

    iget-object v1, p0, Lcom/tencent/mm/sdk/modelmsg/GetMessageFromWX$Req;->country:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 77
    return-void
.end method
