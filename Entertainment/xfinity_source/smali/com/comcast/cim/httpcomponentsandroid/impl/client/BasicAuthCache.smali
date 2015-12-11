.class public Lcom/comcast/cim/httpcomponentsandroid/impl/client/BasicAuthCache;
.super Ljava/lang/Object;
.source "BasicAuthCache.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/client/AuthCache;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# instance fields
.field private final map:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/HttpHost;",
            "Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 51
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/BasicAuthCache;->map:Ljava/util/HashMap;

    .line 52
    return-void
.end method


# virtual methods
.method public get(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;)Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;
    .locals 2
    .param p1, "host"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    .prologue
    .line 62
    if-nez p1, :cond_0

    .line 63
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "HTTP host may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 65
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/BasicAuthCache;->map:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;

    return-object v0
.end method

.method public put(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;)V
    .locals 2
    .param p1, "host"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "authScheme"    # Lcom/comcast/cim/httpcomponentsandroid/auth/AuthScheme;

    .prologue
    .line 55
    if-nez p1, :cond_0

    .line 56
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "HTTP host may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 58
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/BasicAuthCache;->map:Ljava/util/HashMap;

    invoke-virtual {v0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 59
    return-void
.end method

.method public remove(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;)V
    .locals 2
    .param p1, "host"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    .prologue
    .line 69
    if-nez p1, :cond_0

    .line 70
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "HTTP host may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 72
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/BasicAuthCache;->map:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 73
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/BasicAuthCache;->map:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
