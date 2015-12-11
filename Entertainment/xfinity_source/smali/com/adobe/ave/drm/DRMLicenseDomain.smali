.class public Lcom/adobe/ave/drm/DRMLicenseDomain;
.super Ljava/lang/Object;
.source "DRMLicenseDomain.java"


# instance fields
.field private authDomain:Ljava/lang/String;

.field private authMethod:Lcom/adobe/ave/drm/DRMAuthenticationMethod;

.field private peerObject:J

.field private serverURL:Ljava/lang/String;


# direct methods
.method protected constructor <init>(ILjava/lang/String;Ljava/lang/String;J)V
    .locals 2
    .param p1, "authMethod"    # I
    .param p2, "authDomain"    # Ljava/lang/String;
    .param p3, "serverURL"    # Ljava/lang/String;
    .param p4, "peerObject"    # J

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    invoke-static {}, Lcom/adobe/ave/drm/DRMAuthenticationMethod;->values()[Lcom/adobe/ave/drm/DRMAuthenticationMethod;

    move-result-object v0

    aget-object v0, v0, p1

    iput-object v0, p0, Lcom/adobe/ave/drm/DRMLicenseDomain;->authMethod:Lcom/adobe/ave/drm/DRMAuthenticationMethod;

    .line 33
    iput-object p2, p0, Lcom/adobe/ave/drm/DRMLicenseDomain;->authDomain:Ljava/lang/String;

    .line 34
    iput-object p3, p0, Lcom/adobe/ave/drm/DRMLicenseDomain;->serverURL:Ljava/lang/String;

    .line 35
    iput-wide p4, p0, Lcom/adobe/ave/drm/DRMLicenseDomain;->peerObject:J

    .line 36
    return-void
.end method


# virtual methods
.method protected native finalize()V
.end method

.method public getAuthenticationDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/adobe/ave/drm/DRMLicenseDomain;->authDomain:Ljava/lang/String;

    return-object v0
.end method

.method public getAuthenticationMethod()Lcom/adobe/ave/drm/DRMAuthenticationMethod;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/adobe/ave/drm/DRMLicenseDomain;->authMethod:Lcom/adobe/ave/drm/DRMAuthenticationMethod;

    return-object v0
.end method

.method public getServerURL()Ljava/lang/String;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/adobe/ave/drm/DRMLicenseDomain;->serverURL:Ljava/lang/String;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 56
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "License domain registration URL: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 57
    invoke-virtual {p0}, Lcom/adobe/ave/drm/DRMLicenseDomain;->getServerURL()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "Authentication method: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 58
    invoke-virtual {p0}, Lcom/adobe/ave/drm/DRMLicenseDomain;->getAuthenticationMethod()Lcom/adobe/ave/drm/DRMAuthenticationMethod;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "Authentication domain: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    .line 59
    invoke-virtual {p0}, Lcom/adobe/ave/drm/DRMLicenseDomain;->getAuthenticationDomain()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
