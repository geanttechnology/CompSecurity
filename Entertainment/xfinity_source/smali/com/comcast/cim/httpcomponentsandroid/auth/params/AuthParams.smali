.class public final Lcom/comcast/cim/httpcomponentsandroid/auth/params/AuthParams;
.super Ljava/lang/Object;
.source "AuthParams.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# direct methods
.method private constructor <init>()V
    .locals 0

    .prologue
    .line 47
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    return-void
.end method

.method public static getCredentialCharset(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Ljava/lang/String;
    .locals 3
    .param p0, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 58
    if-nez p0, :cond_0

    .line 59
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "HTTP parameters may not be null"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 61
    :cond_0
    const-string v1, "http.auth.credential-charset"

    invoke-interface {p0, v1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 63
    .local v0, "charset":Ljava/lang/String;
    if-nez v0, :cond_1

    .line 64
    const-string v0, "US-ASCII"

    .line 66
    :cond_1
    return-object v0
.end method

.method public static setCredentialCharset(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;Ljava/lang/String;)V
    .locals 2
    .param p0, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .param p1, "charset"    # Ljava/lang/String;

    .prologue
    .line 77
    if-nez p0, :cond_0

    .line 78
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "HTTP parameters may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 80
    :cond_0
    const-string v0, "http.auth.credential-charset"

    invoke-interface {p0, v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 81
    return-void
.end method
