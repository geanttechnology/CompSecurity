.class public Lcom/igexin/sdk/bean/StartWebBean;
.super Lcom/igexin/sdk/bean/BaseBean;
.source "StartWebBean.java"


# instance fields
.field private isNetType:Z

.field private isWithCid:Z

.field private url:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/igexin/sdk/bean/BaseBean;-><init>()V

    return-void
.end method


# virtual methods
.method public getFinalUrl()Ljava/lang/String;
    .locals 4

    .prologue
    .line 51
    iget-object v1, p0, Lcom/igexin/sdk/bean/StartWebBean;->url:Ljava/lang/String;

    .line 52
    .local v1, "u":Ljava/lang/String;
    iget-boolean v2, p0, Lcom/igexin/sdk/bean/StartWebBean;->isWithCid:Z

    if-eqz v2, :cond_0

    .line 53
    const-string/jumbo v2, "?"

    invoke-virtual {v1, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    if-lez v2, :cond_2

    .line 54
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "&cid="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Lcom/igexin/sdk/data/BasicDataManager;->vcid:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 59
    :cond_0
    :goto_0
    iget-boolean v2, p0, Lcom/igexin/sdk/bean/StartWebBean;->isNetType:Z

    if-eqz v2, :cond_1

    .line 60
    invoke-static {}, Lcom/igexin/sdk/SdkService;->getInstance()Lcom/igexin/sdk/SdkService;

    move-result-object v2

    invoke-virtual {v2}, Lcom/igexin/sdk/SdkService;->getNetworkType()Ljava/lang/String;

    move-result-object v0

    .line 61
    .local v0, "netType":Ljava/lang/String;
    if-eqz v0, :cond_1

    .line 62
    const-string/jumbo v2, "?"

    invoke-virtual {v1, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    if-lez v2, :cond_3

    .line 63
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "&nettype="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 69
    .end local v0    # "netType":Ljava/lang/String;
    :cond_1
    :goto_1
    return-object v1

    .line 56
    :cond_2
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "?cid="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Lcom/igexin/sdk/data/BasicDataManager;->vcid:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 65
    .restart local v0    # "netType":Ljava/lang/String;
    :cond_3
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "?nettype="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_1
.end method

.method public setNetType(Z)V
    .locals 0
    .param p1, "isNetType"    # Z

    .prologue
    .line 39
    iput-boolean p1, p0, Lcom/igexin/sdk/bean/StartWebBean;->isNetType:Z

    .line 40
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 23
    iput-object p1, p0, Lcom/igexin/sdk/bean/StartWebBean;->url:Ljava/lang/String;

    .line 24
    return-void
.end method

.method public setWithCid(Z)V
    .locals 0
    .param p1, "isWithCid"    # Z

    .prologue
    .line 31
    iput-boolean p1, p0, Lcom/igexin/sdk/bean/StartWebBean;->isWithCid:Z

    .line 32
    return-void
.end method
