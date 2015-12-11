.class public Lcom/comcast/cim/httpcomponentsandroid/auth/NTCredentials;
.super Ljava/lang/Object;
.source "NTCredentials.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/auth/Credentials;
.implements Ljava/io/Serializable;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# instance fields
.field private final password:Ljava/lang/String;

.field private final principal:Lcom/comcast/cim/httpcomponentsandroid/auth/NTUserPrincipal;

.field private final workstation:Ljava/lang/String;


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    .line 157
    if-ne p0, p1, :cond_1

    .line 165
    :cond_0
    :goto_0
    return v1

    .line 158
    :cond_1
    instance-of v2, p1, Lcom/comcast/cim/httpcomponentsandroid/auth/NTCredentials;

    if-eqz v2, :cond_2

    move-object v0, p1

    .line 159
    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/auth/NTCredentials;

    .line 160
    .local v0, "that":Lcom/comcast/cim/httpcomponentsandroid/auth/NTCredentials;
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/NTCredentials;->principal:Lcom/comcast/cim/httpcomponentsandroid/auth/NTUserPrincipal;

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/auth/NTCredentials;->principal:Lcom/comcast/cim/httpcomponentsandroid/auth/NTUserPrincipal;

    invoke-static {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/util/LangUtils;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/NTCredentials;->workstation:Ljava/lang/String;

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/auth/NTCredentials;->workstation:Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/util/LangUtils;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 165
    .end local v0    # "that":Lcom/comcast/cim/httpcomponentsandroid/auth/NTCredentials;
    :cond_2
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 135
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/NTCredentials;->principal:Lcom/comcast/cim/httpcomponentsandroid/auth/NTUserPrincipal;

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/auth/NTUserPrincipal;->getDomain()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPassword()Ljava/lang/String;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/NTCredentials;->password:Ljava/lang/String;

    return-object v0
.end method

.method public getUserName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 122
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/NTCredentials;->principal:Lcom/comcast/cim/httpcomponentsandroid/auth/NTUserPrincipal;

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/auth/NTUserPrincipal;->getUsername()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getUserPrincipal()Ljava/security/Principal;
    .locals 1

    .prologue
    .line 118
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/NTCredentials;->principal:Lcom/comcast/cim/httpcomponentsandroid/auth/NTUserPrincipal;

    return-object v0
.end method

.method public getWorkstation()Ljava/lang/String;
    .locals 1

    .prologue
    .line 144
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/NTCredentials;->workstation:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 2

    .prologue
    .line 149
    const/16 v0, 0x11

    .line 150
    .local v0, "hash":I
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/NTCredentials;->principal:Lcom/comcast/cim/httpcomponentsandroid/auth/NTUserPrincipal;

    invoke-static {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/LangUtils;->hashCode(ILjava/lang/Object;)I

    move-result v0

    .line 151
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/NTCredentials;->workstation:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/LangUtils;->hashCode(ILjava/lang/Object;)I

    move-result v0

    .line 152
    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 170
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 171
    .local v0, "buffer":Ljava/lang/StringBuilder;
    const-string v1, "[principal: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 172
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/NTCredentials;->principal:Lcom/comcast/cim/httpcomponentsandroid/auth/NTUserPrincipal;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 173
    const-string v1, "][workstation: "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 174
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/NTCredentials;->workstation:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 175
    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 176
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
