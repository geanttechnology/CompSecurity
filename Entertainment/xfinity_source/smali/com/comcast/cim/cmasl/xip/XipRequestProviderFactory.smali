.class public Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;
.super Ljava/lang/Object;
.source "XipRequestProviderFactory.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T::",
        "Lcom/comcast/cim/cmasl/http/request/RequestProvider;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private final basicRequestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory",
            "<TT;>;"
        }
    .end annotation
.end field

.field private final xipServer:Lcom/comcast/cim/cmasl/xip/XipServer;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;Lcom/comcast/cim/cmasl/xip/XipServer;)V
    .locals 0
    .param p2, "xipServer"    # Lcom/comcast/cim/cmasl/xip/XipServer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory",
            "<TT;>;",
            "Lcom/comcast/cim/cmasl/xip/XipServer;",
            ")V"
        }
    .end annotation

    .prologue
    .line 12
    .local p0, "this":Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;, "Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory<TT;>;"
    .local p1, "basicRequestProviderFactory":Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;, "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 13
    iput-object p1, p0, Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;->basicRequestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    .line 14
    iput-object p2, p0, Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;->xipServer:Lcom/comcast/cim/cmasl/xip/XipServer;

    .line 15
    return-void
.end method


# virtual methods
.method public create(Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;
    .locals 3
    .param p1, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")TT;"
        }
    .end annotation

    .prologue
    .line 20
    .local p0, "this":Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;, "Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;->basicRequestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;->xipServer:Lcom/comcast/cim/cmasl/xip/XipServer;

    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/xip/XipServer;->getURI()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;->create(Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    move-result-object v0

    return-object v0
.end method

.method public create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;
    .locals 3
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "method"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")TT;"
        }
    .end annotation

    .prologue
    .line 25
    .local p0, "this":Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;, "Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory<TT;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;->basicRequestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;->xipServer:Lcom/comcast/cim/cmasl/xip/XipServer;

    invoke-virtual {v2}, Lcom/comcast/cim/cmasl/xip/XipServer;->getURI()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1, p2}, Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;->create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    move-result-object v0

    return-object v0
.end method
