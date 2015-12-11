.class public abstract Lcom/comcast/cim/cmasl/http/response/RevalidatingResponseHandler;
.super Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;
.source "RevalidatingResponseHandler.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<R:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/cmasl/http/response/DelegatingResponseHandler;"
    }
.end annotation


# instance fields
.field private final identifyResponseHandler:Lcom/comcast/cim/cmasl/http/response/IdentifyResponseHandler;

.field private resource:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TR;"
        }
    .end annotation
.end field


# virtual methods
.method public getResourceIfNewer()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TR;"
        }
    .end annotation

    .prologue
    .line 35
    .local p0, "this":Lcom/comcast/cim/cmasl/http/response/RevalidatingResponseHandler;, "Lcom/comcast/cim/cmasl/http/response/RevalidatingResponseHandler<TR;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/response/RevalidatingResponseHandler;->resource:Ljava/lang/Object;

    return-object v0
.end method

.method public getResponseId()Lcom/comcast/cim/cmasl/http/response/ResponseId;
    .locals 1

    .prologue
    .line 43
    .local p0, "this":Lcom/comcast/cim/cmasl/http/response/RevalidatingResponseHandler;, "Lcom/comcast/cim/cmasl/http/response/RevalidatingResponseHandler<TR;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/http/response/RevalidatingResponseHandler;->identifyResponseHandler:Lcom/comcast/cim/cmasl/http/response/IdentifyResponseHandler;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/http/response/IdentifyResponseHandler;->getResponseId()Lcom/comcast/cim/cmasl/http/response/ResponseId;

    move-result-object v0

    return-object v0
.end method
