.class public Lcom/adobe/ave/drm/DRMPolicy;
.super Ljava/lang/Object;
.source "DRMPolicy.java"


# instance fields
.field authDomain:Ljava/lang/String;

.field authMethod:Lcom/adobe/ave/drm/DRMAuthenticationMethod;

.field dispName:Ljava/lang/String;

.field licenseDomain:Lcom/adobe/ave/drm/DRMLicenseDomain;


# direct methods
.method protected constructor <init>(Ljava/lang/String;ILjava/lang/String;Lcom/adobe/ave/drm/DRMLicenseDomain;)V
    .locals 1
    .param p1, "dispName"    # Ljava/lang/String;
    .param p2, "authMethod"    # I
    .param p3, "authDomain"    # Ljava/lang/String;
    .param p4, "ld"    # Lcom/adobe/ave/drm/DRMLicenseDomain;

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 33
    iput-object p1, p0, Lcom/adobe/ave/drm/DRMPolicy;->dispName:Ljava/lang/String;

    .line 34
    invoke-static {}, Lcom/adobe/ave/drm/DRMAuthenticationMethod;->values()[Lcom/adobe/ave/drm/DRMAuthenticationMethod;

    move-result-object v0

    aget-object v0, v0, p2

    iput-object v0, p0, Lcom/adobe/ave/drm/DRMPolicy;->authMethod:Lcom/adobe/ave/drm/DRMAuthenticationMethod;

    .line 35
    iput-object p3, p0, Lcom/adobe/ave/drm/DRMPolicy;->authDomain:Ljava/lang/String;

    .line 36
    iput-object p4, p0, Lcom/adobe/ave/drm/DRMPolicy;->licenseDomain:Lcom/adobe/ave/drm/DRMLicenseDomain;

    .line 37
    return-void
.end method


# virtual methods
.method public getAuthenticationDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/adobe/ave/drm/DRMPolicy;->authDomain:Ljava/lang/String;

    return-object v0
.end method

.method public getAuthenticationMethod()Lcom/adobe/ave/drm/DRMAuthenticationMethod;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/adobe/ave/drm/DRMPolicy;->authMethod:Lcom/adobe/ave/drm/DRMAuthenticationMethod;

    return-object v0
.end method

.method public getDisplayName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/adobe/ave/drm/DRMPolicy;->dispName:Ljava/lang/String;

    return-object v0
.end method

.method public getLicenseDomain()Lcom/adobe/ave/drm/DRMLicenseDomain;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/adobe/ave/drm/DRMPolicy;->licenseDomain:Lcom/adobe/ave/drm/DRMLicenseDomain;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 56
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 57
    .local v0, "sb":Ljava/lang/StringBuffer;
    invoke-virtual {p0}, Lcom/adobe/ave/drm/DRMPolicy;->getDisplayName()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 58
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Display name: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/adobe/ave/drm/DRMPolicy;->getDisplayName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 59
    :cond_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Authentication method: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/adobe/ave/drm/DRMPolicy;->getAuthenticationMethod()Lcom/adobe/ave/drm/DRMAuthenticationMethod;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\n"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 60
    invoke-virtual {p0}, Lcom/adobe/ave/drm/DRMPolicy;->getLicenseDomain()Lcom/adobe/ave/drm/DRMLicenseDomain;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 61
    invoke-virtual {p0}, Lcom/adobe/ave/drm/DRMPolicy;->getLicenseDomain()Lcom/adobe/ave/drm/DRMLicenseDomain;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/Object;)Ljava/lang/StringBuffer;

    .line 62
    :cond_1
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
