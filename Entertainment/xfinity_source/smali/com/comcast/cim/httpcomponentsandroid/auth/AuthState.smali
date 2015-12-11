.class public Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;
.super Ljava/lang/Object;
.source "AuthState.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# instance fields
.field private authScheme:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;

.field private authScope:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScope;

.field private credentials:Lcom/comcast/cim/httpcomponentsandroid/auth/Credentials;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 56
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 57
    return-void
.end method


# virtual methods
.method public getAuthScheme()Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->authScheme:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;

    return-object v0
.end method

.method public getAuthScope()Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScope;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->authScope:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScope;

    return-object v0
.end method

.method public getCredentials()Lcom/comcast/cim/httpcomponentsandroid/auth/Credentials;
    .locals 1

    .prologue
    .line 101
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->credentials:Lcom/comcast/cim/httpcomponentsandroid/auth/Credentials;

    return-object v0
.end method

.method public invalidate()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 63
    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->authScheme:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;

    .line 64
    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->authScope:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScope;

    .line 65
    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->credentials:Lcom/comcast/cim/httpcomponentsandroid/auth/Credentials;

    .line 66
    return-void
.end method

.method public isValid()Z
    .locals 1

    .prologue
    .line 69
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->authScheme:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setAuthScheme(Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;)V
    .locals 0
    .param p1, "authScheme"    # Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;

    .prologue
    .line 78
    if-nez p1, :cond_0

    .line 79
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->invalidate()V

    .line 83
    :goto_0
    return-void

    .line 82
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->authScheme:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;

    goto :goto_0
.end method

.method public setAuthScope(Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScope;)V
    .locals 0
    .param p1, "authScope"    # Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScope;

    .prologue
    .line 130
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->authScope:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScope;

    .line 131
    return-void
.end method

.method public setCredentials(Lcom/comcast/cim/httpcomponentsandroid/auth/Credentials;)V
    .locals 0
    .param p1, "credentials"    # Lcom/comcast/cim/httpcomponentsandroid/auth/Credentials;

    .prologue
    .line 111
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->credentials:Lcom/comcast/cim/httpcomponentsandroid/auth/Credentials;

    .line 112
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 136
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 137
    .local v0, "buffer":Ljava/lang/StringBuilder;
    const-string v1, "auth scope ["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 138
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->authScope:Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScope;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 139
    const-string v1, "]; credentials set ["

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 140
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthState;->credentials:Lcom/comcast/cim/httpcomponentsandroid/auth/Credentials;

    if-eqz v1, :cond_0

    const-string v1, "true"

    :goto_0
    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 141
    const-string v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 142
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 140
    :cond_0
    const-string v1, "false"

    goto :goto_0
.end method
