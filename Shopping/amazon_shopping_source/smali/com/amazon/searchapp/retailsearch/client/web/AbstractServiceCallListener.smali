.class public abstract Lcom/amazon/searchapp/retailsearch/client/web/AbstractServiceCallListener;
.super Ljava/lang/Object;
.source "AbstractServiceCallListener.java"

# interfaces
.implements Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<TResult:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/amazon/searchapp/retailsearch/client/web/ServiceCallListener",
        "<TTResult;>;"
    }
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/AbstractServiceCallListener;, "Lcom/amazon/searchapp/retailsearch/client/web/AbstractServiceCallListener<TTResult;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public endRequest()V
    .locals 0

    .prologue
    .line 38
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/AbstractServiceCallListener;, "Lcom/amazon/searchapp/retailsearch/client/web/AbstractServiceCallListener<TTResult;>;"
    return-void
.end method

.method public error(Ljava/lang/Exception;)V
    .locals 0
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 31
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/AbstractServiceCallListener;, "Lcom/amazon/searchapp/retailsearch/client/web/AbstractServiceCallListener<TTResult;>;"
    return-void
.end method

.method public result(Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TTResult;)V"
        }
    .end annotation

    .prologue
    .line 24
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/AbstractServiceCallListener;, "Lcom/amazon/searchapp/retailsearch/client/web/AbstractServiceCallListener<TTResult;>;"
    .local p1, "result":Ljava/lang/Object;, "TTResult;"
    return-void
.end method

.method public startRequest()V
    .locals 0

    .prologue
    .line 17
    .local p0, "this":Lcom/amazon/searchapp/retailsearch/client/web/AbstractServiceCallListener;, "Lcom/amazon/searchapp/retailsearch/client/web/AbstractServiceCallListener<TTResult;>;"
    return-void
.end method
