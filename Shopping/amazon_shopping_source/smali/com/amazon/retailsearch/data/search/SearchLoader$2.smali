.class Lcom/amazon/retailsearch/data/search/SearchLoader$2;
.super Lcom/amazon/retailsearch/data/search/ResultEvent;
.source "SearchLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/data/search/SearchLoader;->close()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/data/search/SearchLoader;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/data/search/SearchLoader;)V
    .locals 0

    .prologue
    .line 195
    iput-object p1, p0, Lcom/amazon/retailsearch/data/search/SearchLoader$2;->this$0:Lcom/amazon/retailsearch/data/search/SearchLoader;

    invoke-direct {p0}, Lcom/amazon/retailsearch/data/search/ResultEvent;-><init>()V

    return-void
.end method


# virtual methods
.method public send(Lcom/amazon/retailsearch/data/search/ResultStreamListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/retailsearch/data/search/ResultStreamListener;

    .prologue
    .line 199
    invoke-interface {p1}, Lcom/amazon/retailsearch/data/search/ResultStreamListener;->close()V

    .line 200
    return-void
.end method
