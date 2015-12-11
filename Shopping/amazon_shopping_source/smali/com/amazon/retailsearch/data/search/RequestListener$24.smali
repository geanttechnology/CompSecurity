.class Lcom/amazon/retailsearch/data/search/RequestListener$24;
.super Lcom/amazon/retailsearch/data/search/ResultModel;
.source "RequestListener.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/data/search/RequestListener;->noResultsSet(Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/retailsearch/data/search/ResultModel",
        "<",
        "Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/data/search/RequestListener;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/data/search/RequestListener;Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;)V
    .locals 0
    .param p2, "x0"    # Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;

    .prologue
    .line 331
    iput-object p1, p0, Lcom/amazon/retailsearch/data/search/RequestListener$24;->this$0:Lcom/amazon/retailsearch/data/search/RequestListener;

    invoke-direct {p0, p2}, Lcom/amazon/retailsearch/data/search/ResultModel;-><init>(Ljava/lang/Object;)V

    return-void
.end method


# virtual methods
.method public send(Lcom/amazon/retailsearch/data/search/ResultStreamListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/data/search/ResultStreamListener;

    .prologue
    .line 334
    invoke-virtual {p0}, Lcom/amazon/retailsearch/data/search/RequestListener$24;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;

    invoke-interface {p1, v0}, Lcom/amazon/retailsearch/data/search/ResultStreamListener;->noResultsSet(Lcom/amazon/searchapp/retailsearch/model/NoResultsSet;)V

    .line 335
    return-void
.end method
