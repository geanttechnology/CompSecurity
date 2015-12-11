.class Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder$2;
.super Ljava/lang/Object;
.source "ActionViewBuilder.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->doBuild()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;)V
    .locals 0

    .prologue
    .line 114
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder$2;->this$0:Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 118
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder$2;->this$0:Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;

    # getter for: Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->searchHandler:Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->access$000(Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;)Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;

    move-result-object v0

    new-instance v1, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;

    const-string/jumbo v2, "BARCODE_SEARCH_QUERY_KEYWORD"

    invoke-direct {v1, v2}, Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;-><init>(Ljava/lang/String;)V

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;->onQuerySubmit(Lcom/amazon/retailsearch/android/api/query/Query;)V

    .line 119
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder$2;->this$0:Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;

    # getter for: Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->searchBoxLogger:Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->access$100(Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;)Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;->recordScanItInvoked()V

    .line 120
    return-void
.end method
