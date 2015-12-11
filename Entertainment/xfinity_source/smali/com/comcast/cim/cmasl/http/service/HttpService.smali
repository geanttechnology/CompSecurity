.class public interface abstract Lcom/comcast/cim/cmasl/http/service/HttpService;
.super Ljava/lang/Object;
.source "HttpService.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "RQ::",
        "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
        "<TT;>;>",
        "Ljava/lang/Object;"
    }
.end annotation


# virtual methods
.method public abstract executeRequest(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<RS::",
            "Lcom/comcast/cim/cmasl/http/response/ResponseHandler;",
            ">(TRQ;",
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<TRS;>;)TRS;"
        }
    .end annotation
.end method
