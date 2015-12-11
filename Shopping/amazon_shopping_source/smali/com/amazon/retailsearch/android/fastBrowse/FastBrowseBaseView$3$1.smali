.class Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$3$1;
.super Ljava/lang/Object;
.source "FastBrowseBaseView.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RefinementResultListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$3;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$3;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$3;)V
    .locals 0

    .prologue
    .line 222
    iput-object p1, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$3$1;->this$1:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Ljava/lang/Exception;)V
    .locals 0
    .param p1, "error"    # Ljava/lang/Exception;

    .prologue
    .line 233
    return-void
.end method

.method public onResult(Lcom/amazon/searchapp/retailsearch/model/SearchResult;)V
    .locals 1
    .param p1, "result"    # Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    .prologue
    .line 226
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$3$1;->this$1:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$3;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$3;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    # setter for: Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->rst:Lcom/amazon/searchapp/retailsearch/model/SearchResult;
    invoke-static {v0, p1}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->access$302(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;Lcom/amazon/searchapp/retailsearch/model/SearchResult;)Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    .line 227
    iget-object v0, p0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$3$1;->this$1:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$3;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$3;->this$0:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->onRefresh()V

    .line 228
    return-void
.end method
