.class Lcom/amazon/retailsearch/data/search/RequestListener$12;
.super Lcom/amazon/retailsearch/data/search/ResultModel;
.source "RequestListener.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/data/search/RequestListener;->resources(Lcom/amazon/searchapp/retailsearch/model/SearchResources;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/retailsearch/data/search/ResultModel",
        "<",
        "Lcom/amazon/searchapp/retailsearch/model/SearchResources;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/data/search/RequestListener;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/data/search/RequestListener;Lcom/amazon/searchapp/retailsearch/model/SearchResources;)V
    .locals 0
    .param p2, "x0"    # Lcom/amazon/searchapp/retailsearch/model/SearchResources;

    .prologue
    .line 202
    iput-object p1, p0, Lcom/amazon/retailsearch/data/search/RequestListener$12;->this$0:Lcom/amazon/retailsearch/data/search/RequestListener;

    invoke-direct {p0, p2}, Lcom/amazon/retailsearch/data/search/ResultModel;-><init>(Ljava/lang/Object;)V

    return-void
.end method


# virtual methods
.method public send(Lcom/amazon/retailsearch/data/search/ResultStreamListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/data/search/ResultStreamListener;

    .prologue
    .line 205
    invoke-virtual {p0}, Lcom/amazon/retailsearch/data/search/RequestListener$12;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/model/SearchResources;

    invoke-interface {p1, v0}, Lcom/amazon/retailsearch/data/search/ResultStreamListener;->resources(Lcom/amazon/searchapp/retailsearch/model/SearchResources;)V

    .line 206
    return-void
.end method
