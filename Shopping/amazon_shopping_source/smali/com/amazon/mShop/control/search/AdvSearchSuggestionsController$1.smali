.class Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController$1;
.super Ljava/lang/Object;
.source "AdvSearchSuggestionsController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;->completed(Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsResponse;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsResponse;)V
    .locals 0

    .prologue
    .line 43
    iput-object p1, p0, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController$1;->this$0:Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;

    iput-object p2, p0, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput-object p3, p0, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsResponse;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController$1;->this$0:Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;

    iget-object v1, p0, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;->access$000(Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 48
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController$1;->this$0:Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;

    # invokes: Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;->serviceCallCompleted()V
    invoke-static {v0}, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;->access$100(Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;)V

    .line 49
    iget-object v0, p0, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController$1;->this$0:Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;

    # getter for: Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;->mSubscriber:Lcom/amazon/mShop/control/search/AdvSearchSuggestionsSubscriber;
    invoke-static {v0}, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;->access$200(Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController;)Lcom/amazon/mShop/control/search/AdvSearchSuggestionsSubscriber;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsResponse;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/AdvSearchSuggestionsResponse;->getSuggestions()Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/mShop/control/search/AdvSearchSuggestionsSubscriber;->onSearchSuggestionsReceived(Ljava/util/List;)V

    .line 51
    :cond_0
    return-void
.end method
