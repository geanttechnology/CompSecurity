.class Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RequestListener;
.super Lcom/amazon/searchapp/retailsearch/client/web/AbstractServiceCallListener;
.source "RefinementsLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "RequestListener"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/searchapp/retailsearch/client/web/AbstractServiceCallListener",
        "<",
        "Lcom/amazon/searchapp/retailsearch/model/SearchResult;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;


# direct methods
.method private constructor <init>(Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;)V
    .locals 0

    .prologue
    .line 54
    iput-object p1, p0, Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RequestListener;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;

    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/client/web/AbstractServiceCallListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$1;

    .prologue
    .line 54
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RequestListener;-><init>(Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;)V

    return-void
.end method


# virtual methods
.method public endRequest()V
    .locals 0

    .prologue
    .line 88
    return-void
.end method

.method public error(Ljava/lang/Exception;)V
    .locals 1
    .param p1, "error"    # Ljava/lang/Exception;

    .prologue
    .line 79
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RequestListener;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;->listener:Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RefinementResultListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;->access$100(Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;)Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RefinementResultListener;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RefinementResultListener;->onError(Ljava/lang/Exception;)V

    .line 80
    return-void
.end method

.method public result(Lcom/amazon/searchapp/retailsearch/model/SearchResult;)V
    .locals 1
    .param p1, "result"    # Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RequestListener;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;

    # getter for: Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;->listener:Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RefinementResultListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;->access$100(Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader;)Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RefinementResultListener;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RefinementResultListener;->onResult(Lcom/amazon/searchapp/retailsearch/model/SearchResult;)V

    .line 71
    return-void
.end method

.method public bridge synthetic result(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 54
    check-cast p1, Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RequestListener;->result(Lcom/amazon/searchapp/retailsearch/model/SearchResult;)V

    return-void
.end method

.method public startRequest()V
    .locals 0

    .prologue
    .line 62
    return-void
.end method
