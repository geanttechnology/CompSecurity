.class Lcom/amazon/retailsearch/data/search/RequestListener$7;
.super Lcom/amazon/retailsearch/data/search/ResultModel;
.source "RequestListener.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/data/search/RequestListener;->result(Lcom/amazon/searchapp/retailsearch/model/SearchResult;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/retailsearch/data/search/ResultModel",
        "<",
        "Lcom/amazon/searchapp/retailsearch/model/SearchResult;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/data/search/RequestListener;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/data/search/RequestListener;Lcom/amazon/searchapp/retailsearch/model/SearchResult;)V
    .locals 0
    .param p2, "x0"    # Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    .prologue
    .line 145
    iput-object p1, p0, Lcom/amazon/retailsearch/data/search/RequestListener$7;->this$0:Lcom/amazon/retailsearch/data/search/RequestListener;

    invoke-direct {p0, p2}, Lcom/amazon/retailsearch/data/search/ResultModel;-><init>(Ljava/lang/Object;)V

    return-void
.end method


# virtual methods
.method public send(Lcom/amazon/retailsearch/data/search/ResultStreamListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/data/search/ResultStreamListener;

    .prologue
    .line 148
    invoke-virtual {p0}, Lcom/amazon/retailsearch/data/search/RequestListener$7;->get()Ljava/lang/Object;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/amazon/retailsearch/data/search/ResultStreamListener;->result(Ljava/lang/Object;)V

    .line 149
    return-void
.end method
