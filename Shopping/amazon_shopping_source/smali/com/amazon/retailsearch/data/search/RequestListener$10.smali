.class Lcom/amazon/retailsearch/data/search/RequestListener$10;
.super Lcom/amazon/retailsearch/data/search/ResultModel;
.source "RequestListener.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/data/search/RequestListener;->preloadImages(Lcom/amazon/searchapp/retailsearch/model/PreloadImages;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/retailsearch/data/search/ResultModel",
        "<",
        "Lcom/amazon/searchapp/retailsearch/model/PreloadImages;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/data/search/RequestListener;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/data/search/RequestListener;Lcom/amazon/searchapp/retailsearch/model/PreloadImages;)V
    .locals 0
    .param p2, "x0"    # Lcom/amazon/searchapp/retailsearch/model/PreloadImages;

    .prologue
    .line 182
    iput-object p1, p0, Lcom/amazon/retailsearch/data/search/RequestListener$10;->this$0:Lcom/amazon/retailsearch/data/search/RequestListener;

    invoke-direct {p0, p2}, Lcom/amazon/retailsearch/data/search/ResultModel;-><init>(Ljava/lang/Object;)V

    return-void
.end method


# virtual methods
.method public send(Lcom/amazon/retailsearch/data/search/ResultStreamListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/data/search/ResultStreamListener;

    .prologue
    .line 185
    invoke-virtual {p0}, Lcom/amazon/retailsearch/data/search/RequestListener$10;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/model/PreloadImages;

    invoke-interface {p1, v0}, Lcom/amazon/retailsearch/data/search/ResultStreamListener;->preloadImages(Lcom/amazon/searchapp/retailsearch/model/PreloadImages;)V

    .line 186
    return-void
.end method
