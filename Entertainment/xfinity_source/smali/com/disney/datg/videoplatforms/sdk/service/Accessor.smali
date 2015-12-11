.class public abstract Lcom/disney/datg/videoplatforms/sdk/service/Accessor;
.super Ljava/lang/Object;
.source "Accessor.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private requestHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler",
            "<TT;>;"
        }
    .end annotation
.end field

.field private serviceEndpoint:Ljava/lang/String;

.field private timeout:I


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)V
    .locals 1
    .param p1, "serviceEndpoint"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 23
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/Accessor;, "Lcom/disney/datg/videoplatforms/sdk/service/Accessor<TT;>;"
    .local p2, "requestHandler":Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;, "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    const v0, 0x7fffffff

    iput v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/Accessor;->timeout:I

    .line 24
    invoke-virtual {p0, p1}, Lcom/disney/datg/videoplatforms/sdk/service/Accessor;->setServiceEndpoint(Ljava/lang/String;)V

    .line 25
    invoke-virtual {p0, p2}, Lcom/disney/datg/videoplatforms/sdk/service/Accessor;->setRequestHandler(Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)V

    .line 26
    return-void
.end method


# virtual methods
.method protected getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler",
            "<TT;>;"
        }
    .end annotation

    .prologue
    .line 52
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/Accessor;, "Lcom/disney/datg/videoplatforms/sdk/service/Accessor<TT;>;"
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/Accessor;->requestHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    return-object v0
.end method

.method protected getServiceEndpoint()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/Accessor;, "Lcom/disney/datg/videoplatforms/sdk/service/Accessor<TT;>;"
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/Accessor;->serviceEndpoint:Ljava/lang/String;

    return-object v0
.end method

.method protected getTimeout()I
    .locals 1

    .prologue
    .line 44
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/Accessor;, "Lcom/disney/datg/videoplatforms/sdk/service/Accessor<TT;>;"
    iget v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/Accessor;->timeout:I

    return v0
.end method

.method protected setRequestHandler(Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 56
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/Accessor;, "Lcom/disney/datg/videoplatforms/sdk/service/Accessor<TT;>;"
    .local p1, "requestHandler":Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;, "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler<TT;>;"
    iput-object p1, p0, Lcom/disney/datg/videoplatforms/sdk/service/Accessor;->requestHandler:Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    .line 57
    return-void
.end method

.method protected setServiceEndpoint(Ljava/lang/String;)V
    .locals 1
    .param p1, "serviceEndpoint"    # Ljava/lang/String;

    .prologue
    .line 38
    .local p0, "this":Lcom/disney/datg/videoplatforms/sdk/service/Accessor;, "Lcom/disney/datg/videoplatforms/sdk/service/Accessor<TT;>;"
    if-eqz p1, :cond_0

    .line 39
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/service/Accessor;->serviceEndpoint:Ljava/lang/String;

    .line 41
    :cond_0
    return-void
.end method
