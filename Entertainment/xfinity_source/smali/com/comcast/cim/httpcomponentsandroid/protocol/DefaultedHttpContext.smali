.class public final Lcom/comcast/cim/httpcomponentsandroid/protocol/DefaultedHttpContext;
.super Ljava/lang/Object;
.source "DefaultedHttpContext.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;


# instance fields
.field private final defaults:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

.field private final local:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)V
    .locals 2
    .param p1, "local"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .param p2, "defaults"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    .prologue
    .line 44
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 45
    if-nez p1, :cond_0

    .line 46
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "HTTP context may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 48
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/DefaultedHttpContext;->local:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    .line 49
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/DefaultedHttpContext;->defaults:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    .line 50
    return-void
.end method


# virtual methods
.method public getAttribute(Ljava/lang/String;)Ljava/lang/Object;
    .locals 2
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 53
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/DefaultedHttpContext;->local:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    invoke-interface {v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->getAttribute(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 54
    .local v0, "obj":Ljava/lang/Object;
    if-nez v0, :cond_0

    .line 55
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/DefaultedHttpContext;->defaults:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    invoke-interface {v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->getAttribute(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 57
    .end local v0    # "obj":Ljava/lang/Object;
    :cond_0
    return-object v0
.end method

.method public getDefaults()Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .locals 1

    .prologue
    .line 70
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/DefaultedHttpContext;->defaults:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    return-object v0
.end method

.method public setAttribute(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "obj"    # Ljava/lang/Object;

    .prologue
    .line 66
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/protocol/DefaultedHttpContext;->local:Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V

    .line 67
    return-void
.end method
