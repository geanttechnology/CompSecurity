.class public Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;
.super Landroid/widget/LinearLayout;
.source "ViewItAllMatchedResultsView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView$ViewItAllMatchesAdapter;
    }
.end annotation


# instance fields
.field private mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

.field private mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

.field private mListView:Landroid/widget/ListView;

.field private mObject:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

.field private final mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 28
    check-cast p1, Lcom/amazon/mShop/search/viewit/ViewItActivity;

    .end local p1    # "context":Landroid/content/Context;
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    .line 29
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getPhotoCaptureView()Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->getViewItSlidingDrawerView()Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    .line 30
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;)Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->mObject:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    return-object v0
.end method


# virtual methods
.method public onDetachedFromWindow()V
    .locals 2

    .prologue
    .line 49
    invoke-super {p0}, Landroid/widget/LinearLayout;->onDetachedFromWindow()V

    .line 50
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->setAllMatchesPageListingAdapter(Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView$ViewItAllMatchesAdapter;)V

    .line 51
    return-void
.end method

.method public updateAllMatchedResultsView(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;)V
    .locals 3
    .param p1, "object"    # Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    .param p2, "browser"    # Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->mObject:Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    .line 34
    iput-object p2, p0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    .line 35
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->items_list:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ListView;

    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->mListView:Landroid/widget/ListView;

    .line 37
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->mListView:Landroid/widget/ListView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setDividerHeight(I)V

    .line 38
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->mListView:Landroid/widget/ListView;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setItemsCanFocus(Z)V

    .line 39
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView$ViewItAllMatchesAdapter;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView$ViewItAllMatchesAdapter;-><init>(Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;)V

    .line 40
    .local v0, "adapter":Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView$ViewItAllMatchesAdapter;
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->mListView:Landroid/widget/ListView;

    invoke-virtual {v1, v0}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 42
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->mListView:Landroid/widget/ListView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 44
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->setAllMatchesPageListingAdapter(Lcom/amazon/mShop/search/viewit/ViewItAllMatchedResultsView$ViewItAllMatchesAdapter;)V

    .line 45
    return-void
.end method
