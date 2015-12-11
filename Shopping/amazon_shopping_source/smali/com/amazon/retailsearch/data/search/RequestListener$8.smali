.class Lcom/amazon/retailsearch/data/search/RequestListener$8;
.super Lcom/amazon/retailsearch/data/search/ResultModel;
.source "RequestListener.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/data/search/RequestListener;->error(Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/retailsearch/data/search/ResultModel",
        "<",
        "Ljava/lang/Exception;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/data/search/RequestListener;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/data/search/RequestListener;Ljava/lang/Exception;)V
    .locals 0
    .param p2, "x0"    # Ljava/lang/Exception;

    .prologue
    .line 161
    iput-object p1, p0, Lcom/amazon/retailsearch/data/search/RequestListener$8;->this$0:Lcom/amazon/retailsearch/data/search/RequestListener;

    invoke-direct {p0, p2}, Lcom/amazon/retailsearch/data/search/ResultModel;-><init>(Ljava/lang/Object;)V

    return-void
.end method


# virtual methods
.method public send(Lcom/amazon/retailsearch/data/search/ResultStreamListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/retailsearch/data/search/ResultStreamListener;

    .prologue
    .line 165
    invoke-virtual {p0}, Lcom/amazon/retailsearch/data/search/RequestListener$8;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Exception;

    invoke-interface {p1, v0}, Lcom/amazon/retailsearch/data/search/ResultStreamListener;->error(Ljava/lang/Exception;)V

    .line 166
    return-void
.end method
