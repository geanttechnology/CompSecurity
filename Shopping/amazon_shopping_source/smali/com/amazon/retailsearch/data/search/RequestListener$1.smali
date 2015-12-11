.class Lcom/amazon/retailsearch/data/search/RequestListener$1;
.super Lcom/amazon/retailsearch/data/search/ResultEvent;
.source "RequestListener.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/data/search/RequestListener;->startRequest()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/data/search/RequestListener;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/data/search/RequestListener;)V
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lcom/amazon/retailsearch/data/search/RequestListener$1;->this$0:Lcom/amazon/retailsearch/data/search/RequestListener;

    invoke-direct {p0}, Lcom/amazon/retailsearch/data/search/ResultEvent;-><init>()V

    return-void
.end method


# virtual methods
.method public send(Lcom/amazon/retailsearch/data/search/ResultStreamListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/retailsearch/data/search/ResultStreamListener;

    .prologue
    .line 72
    invoke-interface {p1}, Lcom/amazon/retailsearch/data/search/ResultStreamListener;->startResult()V

    .line 73
    return-void
.end method
