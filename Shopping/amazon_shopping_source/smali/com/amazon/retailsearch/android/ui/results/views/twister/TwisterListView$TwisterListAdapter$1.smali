.class Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter$1;
.super Ljava/lang/Object;
.source "TwisterListView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter;

.field final synthetic val$resultItem:Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter;Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;)V
    .locals 0

    .prologue
    .line 156
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter$1;->this$1:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter;

    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter$1;->val$resultItem:Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 160
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter$1;->this$1:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;->dialog:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;->access$100(Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;)Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter$1;->this$1:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    if-eqz v0, :cond_0

    .line 162
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter$1;->this$1:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;->userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter$1;->val$resultItem:Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;

    sget-object v2, Lcom/amazon/retailsearch/metrics/DetailPageType;->TWISTER:Lcom/amazon/retailsearch/metrics/DetailPageType;

    invoke-interface {v0, v1, v2}, Lcom/amazon/retailsearch/interaction/UserInteractionListener;->resultItemSelected(Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;Lcom/amazon/retailsearch/metrics/DetailPageType;)V

    .line 163
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter$1;->this$1:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;

    # getter for: Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;->dialog:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;
    invoke-static {v0}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;->access$100(Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;)Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;->dismiss()V

    .line 165
    :cond_0
    return-void
.end method
