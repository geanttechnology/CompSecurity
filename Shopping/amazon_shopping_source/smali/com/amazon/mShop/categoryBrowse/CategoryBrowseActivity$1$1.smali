.class Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity$1$1;
.super Ljava/lang/Object;
.source "CategoryBrowseActivity.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/fastBrowse/RefinementsLoader$RefinementResultListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity$1;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity$1;)V
    .locals 0

    .prologue
    .line 86
    iput-object p1, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity$1$1;->this$1:Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Ljava/lang/Exception;)V
    .locals 0
    .param p1, "error"    # Ljava/lang/Exception;

    .prologue
    .line 101
    return-void
.end method

.method public onResult(Lcom/amazon/searchapp/retailsearch/model/SearchResult;)V
    .locals 7
    .param p1, "result"    # Lcom/amazon/searchapp/retailsearch/model/SearchResult;

    .prologue
    .line 90
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/SearchResult;->getTrackingInfo()Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/SearchResult;->getRefinements()Lcom/amazon/searchapp/retailsearch/model/Refinements;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 91
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/SearchResult;->getRefinements()Lcom/amazon/searchapp/retailsearch/model/Refinements;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/retailsearch/android/categoryBrowse/CategoryBrowseController;->getCurrentRefinement(Lcom/amazon/searchapp/retailsearch/model/Refinements;)Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

    move-result-object v0

    .line 92
    .local v0, "refinementNode":Lcom/amazon/searchapp/retailsearch/model/RefinementLink;
    if-eqz v0, :cond_0

    .line 93
    iget-object v1, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity$1$1;->this$1:Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity$1;

    iget-object v1, v1, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity$1;->this$0:Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;

    # getter for: Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;->mMetadataCache:Ljava/util/concurrent/ConcurrentHashMap;
    invoke-static {v1}, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;->access$000(Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity;)Ljava/util/concurrent/ConcurrentHashMap;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity$1$1;->this$1:Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity$1;

    iget-object v2, v2, Lcom/amazon/mShop/categoryBrowse/CategoryBrowseActivity$1;->val$url:Ljava/lang/String;

    new-instance v3, Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;->getText()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;->getUrl()Ljava/lang/String;

    move-result-object v5

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/SearchResult;->getTrackingInfo()Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;

    move-result-object v6

    invoke-interface {v6}, Lcom/amazon/searchapp/retailsearch/model/TrackingInfo;->getSearchAlias()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v3, v4, v5, v6}, Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2, v3}, Ljava/util/concurrent/ConcurrentHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 96
    .end local v0    # "refinementNode":Lcom/amazon/searchapp/retailsearch/model/RefinementLink;
    :cond_0
    return-void
.end method
