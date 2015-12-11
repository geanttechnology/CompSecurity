.class public Lcom/comcast/cim/httpcomponentsandroid/auth/UsernamePasswordCredentials;
.super Ljava/lang/Object;
.source "UsernamePasswordCredentials.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/auth/Credentials;
.implements Ljava/io/Serializable;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# instance fields
.field private final password:Ljava/lang/String;

.field private final principal:Lcom/comcast/cim/httpcomponentsandroid/auth/BasicUserPrincipal;


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    .line 106
    if-ne p0, p1, :cond_1

    .line 113
    :cond_0
    :goto_0
    return v1

    .line 107
    :cond_1
    instance-of v2, p1, Lcom/comcast/cim/httpcomponentsandroid/auth/UsernamePasswordCredentials;

    if-eqz v2, :cond_2

    move-object v0, p1

    .line 108
    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/auth/UsernamePasswordCredentials;

    .line 109
    .local v0, "that":Lcom/comcast/cim/httpcomponentsandroid/auth/UsernamePasswordCredentials;
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/UsernamePasswordCredentials;->principal:Lcom/comcast/cim/httpcomponentsandroid/auth/BasicUserPrincipal;

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/auth/UsernamePasswordCredentials;->principal:Lcom/comcast/cim/httpcomponentsandroid/auth/BasicUserPrincipal;

    invoke-static {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/util/LangUtils;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 113
    .end local v0    # "that":Lcom/comcast/cim/httpcomponentsandroid/auth/UsernamePasswordCredentials;
    :cond_2
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getPassword()Ljava/lang/String;
    .locals 1

    .prologue
    .line 96
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/UsernamePasswordCredentials;->password:Ljava/lang/String;

    return-object v0
.end method

.method public getUserName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/UsernamePasswordCredentials;->principal:Lcom/comcast/cim/httpcomponentsandroid/auth/BasicUserPrincipal;

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/auth/BasicUserPrincipal;->getName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getUserPrincipal()Ljava/security/Principal;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/UsernamePasswordCredentials;->principal:Lcom/comcast/cim/httpcomponentsandroid/auth/BasicUserPrincipal;

    return-object v0
.end method

.method public hashCode()I
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/UsernamePasswordCredentials;->principal:Lcom/comcast/cim/httpcomponentsandroid/auth/BasicUserPrincipal;

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/auth/BasicUserPrincipal;->hashCode()I

    move-result v0

    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 118
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/UsernamePasswordCredentials;->principal:Lcom/comcast/cim/httpcomponentsandroid/auth/BasicUserPrincipal;

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/auth/BasicUserPrincipal;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
