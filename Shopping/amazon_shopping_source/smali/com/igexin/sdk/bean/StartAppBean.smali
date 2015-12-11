.class public Lcom/igexin/sdk/bean/StartAppBean;
.super Lcom/igexin/sdk/bean/BaseBean;
.source "StartAppBean.java"


# instance fields
.field private appid:Ljava/lang/String;

.field private doUninstallId:Ljava/lang/String;

.field private isAutoStart:Ljava/lang/String;

.field private packageName:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 9
    invoke-direct {p0}, Lcom/igexin/sdk/bean/BaseBean;-><init>()V

    .line 12
    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/igexin/sdk/bean/StartAppBean;->packageName:Ljava/lang/String;

    .line 13
    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/igexin/sdk/bean/StartAppBean;->appid:Ljava/lang/String;

    .line 14
    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/igexin/sdk/bean/StartAppBean;->doUninstallId:Ljava/lang/String;

    .line 15
    const-string/jumbo v0, "false"

    iput-object v0, p0, Lcom/igexin/sdk/bean/StartAppBean;->isAutoStart:Ljava/lang/String;

    return-void
.end method


# virtual methods
.method public getAppid()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/igexin/sdk/bean/StartAppBean;->appid:Ljava/lang/String;

    return-object v0
.end method

.method public getDoUninstallId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/igexin/sdk/bean/StartAppBean;->doUninstallId:Ljava/lang/String;

    return-object v0
.end method

.method public getIsAutoStart()Ljava/lang/String;
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lcom/igexin/sdk/bean/StartAppBean;->isAutoStart:Ljava/lang/String;

    return-object v0
.end method

.method public getPackageName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    iget-object v0, p0, Lcom/igexin/sdk/bean/StartAppBean;->packageName:Ljava/lang/String;

    return-object v0
.end method

.method public setAppid(Ljava/lang/String;)V
    .locals 0
    .param p1, "appid"    # Ljava/lang/String;

    .prologue
    .line 38
    iput-object p1, p0, Lcom/igexin/sdk/bean/StartAppBean;->appid:Ljava/lang/String;

    .line 39
    return-void
.end method

.method public setDoUninstallId(Ljava/lang/String;)V
    .locals 0
    .param p1, "doUninstallId"    # Ljava/lang/String;

    .prologue
    .line 42
    iput-object p1, p0, Lcom/igexin/sdk/bean/StartAppBean;->doUninstallId:Ljava/lang/String;

    .line 43
    return-void
.end method

.method public setIsAutoStart(Ljava/lang/String;)V
    .locals 0
    .param p1, "isAutoStart"    # Ljava/lang/String;

    .prologue
    .line 54
    iput-object p1, p0, Lcom/igexin/sdk/bean/StartAppBean;->isAutoStart:Ljava/lang/String;

    .line 55
    return-void
.end method

.method public setPackageName(Ljava/lang/String;)V
    .locals 0
    .param p1, "packageName"    # Ljava/lang/String;

    .prologue
    .line 30
    iput-object p1, p0, Lcom/igexin/sdk/bean/StartAppBean;->packageName:Ljava/lang/String;

    .line 31
    return-void
.end method
