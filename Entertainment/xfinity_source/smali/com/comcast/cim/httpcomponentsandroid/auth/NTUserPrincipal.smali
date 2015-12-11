.class public Lcom/comcast/cim/httpcomponentsandroid/auth/NTUserPrincipal;
.super Ljava/lang/Object;
.source "NTUserPrincipal.java"

# interfaces
.implements Ljava/io/Serializable;
.implements Ljava/security/Principal;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# instance fields
.field private final domain:Ljava/lang/String;

.field private final ntname:Ljava/lang/String;

.field private final username:Ljava/lang/String;


# virtual methods
.method public equals(Ljava/lang/Object;)Z
    .locals 4
    .param p1, "o"    # Ljava/lang/Object;

    .prologue
    const/4 v1, 0x1

    .line 97
    if-ne p0, p1, :cond_1

    .line 105
    :cond_0
    :goto_0
    return v1

    .line 98
    :cond_1
    instance-of v2, p1, Lcom/comcast/cim/httpcomponentsandroid/auth/NTUserPrincipal;

    if-eqz v2, :cond_2

    move-object v0, p1

    .line 99
    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/auth/NTUserPrincipal;

    .line 100
    .local v0, "that":Lcom/comcast/cim/httpcomponentsandroid/auth/NTUserPrincipal;
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/NTUserPrincipal;->username:Ljava/lang/String;

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/auth/NTUserPrincipal;->username:Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/util/LangUtils;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/NTUserPrincipal;->domain:Ljava/lang/String;

    iget-object v3, v0, Lcom/comcast/cim/httpcomponentsandroid/auth/NTUserPrincipal;->domain:Ljava/lang/String;

    invoke-static {v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/util/LangUtils;->equals(Ljava/lang/Object;Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 105
    .end local v0    # "that":Lcom/comcast/cim/httpcomponentsandroid/auth/NTUserPrincipal;
    :cond_2
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getDomain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/NTUserPrincipal;->domain:Ljava/lang/String;

    return-object v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/NTUserPrincipal;->ntname:Ljava/lang/String;

    return-object v0
.end method

.method public getUsername()Ljava/lang/String;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/NTUserPrincipal;->username:Ljava/lang/String;

    return-object v0
.end method

.method public hashCode()I
    .locals 2

    .prologue
    .line 89
    const/16 v0, 0x11

    .line 90
    .local v0, "hash":I
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/NTUserPrincipal;->username:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/LangUtils;->hashCode(ILjava/lang/Object;)I

    move-result v0

    .line 91
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/NTUserPrincipal;->domain:Ljava/lang/String;

    invoke-static {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/util/LangUtils;->hashCode(ILjava/lang/Object;)I

    move-result v0

    .line 92
    return v0
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/NTUserPrincipal;->ntname:Ljava/lang/String;

    return-object v0
.end method
