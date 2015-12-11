.class public Lcom/igexin/sdk/data/DynamicConfig;
.super Ljava/lang/Object;
.source "DynamicConfig.java"


# instance fields
.field private downloadUrl:Ljava/lang/String;

.field private isEncrypt:Z

.field private masterAppID:Ljava/lang/String;

.field private masterPkgName:Ljava/lang/String;

.field private masterServiceAction:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 10
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getDownloadUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/igexin/sdk/data/DynamicConfig;->downloadUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getMasterAppID()Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/igexin/sdk/data/DynamicConfig;->masterAppID:Ljava/lang/String;

    return-object v0
.end method

.method public getMasterPkgName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/igexin/sdk/data/DynamicConfig;->masterPkgName:Ljava/lang/String;

    return-object v0
.end method

.method public getMasterServiceAction()Ljava/lang/String;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/igexin/sdk/data/DynamicConfig;->masterServiceAction:Ljava/lang/String;

    return-object v0
.end method

.method public isEncrypt()Z
    .locals 1

    .prologue
    .line 19
    iget-boolean v0, p0, Lcom/igexin/sdk/data/DynamicConfig;->isEncrypt:Z

    return v0
.end method

.method public setDownloadUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "downloadUrl"    # Ljava/lang/String;

    .prologue
    .line 31
    iput-object p1, p0, Lcom/igexin/sdk/data/DynamicConfig;->downloadUrl:Ljava/lang/String;

    .line 32
    return-void
.end method

.method public setEncrypt(Z)V
    .locals 0
    .param p1, "isEncrypt"    # Z

    .prologue
    .line 23
    iput-boolean p1, p0, Lcom/igexin/sdk/data/DynamicConfig;->isEncrypt:Z

    .line 24
    return-void
.end method

.method public setMasterAppID(Ljava/lang/String;)V
    .locals 0
    .param p1, "masterAppID"    # Ljava/lang/String;

    .prologue
    .line 47
    iput-object p1, p0, Lcom/igexin/sdk/data/DynamicConfig;->masterAppID:Ljava/lang/String;

    .line 48
    return-void
.end method

.method public setMasterPkgName(Ljava/lang/String;)V
    .locals 0
    .param p1, "masterPkgName"    # Ljava/lang/String;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/igexin/sdk/data/DynamicConfig;->masterPkgName:Ljava/lang/String;

    .line 40
    return-void
.end method

.method public setMasterServiceAction(Ljava/lang/String;)V
    .locals 0
    .param p1, "masterServiceAction"    # Ljava/lang/String;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/igexin/sdk/data/DynamicConfig;->masterServiceAction:Ljava/lang/String;

    .line 56
    return-void
.end method
