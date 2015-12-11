.class public Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;
.super Landroid/widget/FrameLayout;
.source "ViewItPhotoCaptureView.java"


# instance fields
.field private mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

.field private mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

.field private mCameraFrameLayout:Landroid/widget/FrameLayout;

.field private mDBHelper:Lcom/amazon/mShop/search/viewit/ViewItDBHelper;

.field private mDialogHelper:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

.field private mOnDrawerCloseListener:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerCloseListener;

.field private mOnDrawerOpenListener:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerOpenListener;

.field private mScannedItemAnimationFrame:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

.field private mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

.field private mTopFlashButton:Landroid/widget/ToggleButton;

.field private mTopFlashButtonGroup:Landroid/view/View;

.field private mTopTitle:Landroid/widget/TextView;

.field private mTopToolBar:Landroid/view/View;

.field private mWindowOverCamera:Landroid/view/View;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "att"    # Landroid/util/AttributeSet;

    .prologue
    .line 80
    invoke-direct {p0, p1, p2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 190
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$3;-><init>(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mOnDrawerOpenListener:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerOpenListener;

    .line 222
    new-instance v0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$4;-><init>(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)V

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mOnDrawerCloseListener:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerCloseListener;

    .line 81
    check-cast p1, Lcom/amazon/mShop/search/viewit/ViewItActivity;

    .end local p1    # "context":Landroid/content/Context;
    iput-object p1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    .line 82
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mDialogHelper:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Landroid/widget/ToggleButton;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mTopFlashButton:Landroid/widget/ToggleButton;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mScannedItemAnimationFrame:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    return-object v0
.end method

.method private existsInHistoryList(Ljava/util/List;Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;)Z
    .locals 6
    .param p2, "outPutType"    # Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;",
            ")Z"
        }
    .end annotation

    .prologue
    .local p1, "scannedOutput":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 166
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    invoke-virtual {v4, v3}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->getObjectAtIndex(I)Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    move-result-object v0

    .line 167
    .local v0, "firstObject":Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    if-eqz v0, :cond_0

    invoke-static {p1, v0, p2, v2}, Lcom/amazon/mShop/search/viewit/ViewItUtil;->isSimilarObject(Ljava/util/List;Lcom/amazon/mShop/search/viewit/ResultWrapper;Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;Z)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 183
    :goto_0
    return v2

    .line 171
    :cond_0
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    iget-object v5, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mDBHelper:Lcom/amazon/mShop/search/viewit/ViewItDBHelper;

    invoke-static {p1, p2, v4, v5, v2}, Lcom/amazon/mShop/search/viewit/ViewItUtil;->removeSimilarObjectFromHistory(Ljava/util/List;Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;Lcom/amazon/mShop/search/viewit/ViewItDBHelper;Z)Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    move-result-object v1

    .line 172
    .local v1, "removedObject":Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;
    if-eqz v1, :cond_1

    .line 174
    const/4 v4, 0x0

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->setDeletedAsin(Ljava/lang/String;)V

    .line 175
    invoke-virtual {v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->setRecentlyScanned(Z)V

    .line 176
    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->updateScannedDate()V

    .line 177
    iget-object v4, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    invoke-virtual {v4}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->getRecentlyScannedObjects()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4, v3, v1}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 178
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mDBHelper:Lcom/amazon/mShop/search/viewit/ViewItDBHelper;

    invoke-virtual {v3, v1}, Lcom/amazon/mShop/search/viewit/ViewItDBHelper;->update(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)V

    .line 179
    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    invoke-virtual {v3}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->getViewItSlidingDrawerItemAdapter()Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView$ViewItSlidingDrawerItemAdapter;->notifyDataSetChanged()V

    goto :goto_0

    :cond_1
    move v2, v3

    .line 183
    goto :goto_0
.end method


# virtual methods
.method public getCameraFrameLayout()Landroid/widget/FrameLayout;
    .locals 1

    .prologue
    .line 68
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mCameraFrameLayout:Landroid/widget/FrameLayout;

    return-object v0
.end method

.method public getTopToolBar()Landroid/view/View;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mTopToolBar:Landroid/view/View;

    return-object v0
.end method

.method public getViewItDialogHelper()Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mDialogHelper:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    return-object v0
.end method

.method public getViewItScannedItemAnimationFrame()Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mScannedItemAnimationFrame:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    return-object v0
.end method

.method public getViewItSlidingDrawerBrowser()Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    return-object v0
.end method

.method public getViewItSlidingDrawerView()Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    return-object v0
.end method

.method public getWindowOverCamera()Landroid/view/View;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mWindowOverCamera:Landroid/view/View;

    return-object v0
.end method

.method protected onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 271
    invoke-super {p0}, Landroid/widget/FrameLayout;->onDetachedFromWindow()V

    .line 273
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mDialogHelper:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->clearErrorWindow()V

    .line 274
    return-void
.end method

.method public onFinishInflate()V
    .locals 5

    .prologue
    const/4 v3, -0x1

    .line 86
    invoke-super {p0}, Landroid/widget/FrameLayout;->onFinishInflate()V

    .line 89
    new-instance v1, Landroid/widget/FrameLayout;

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-direct {v1, v2}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mCameraFrameLayout:Landroid/widget/FrameLayout;

    .line 90
    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v0, v3, v3}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    .line 91
    .local v0, "lp":Landroid/widget/FrameLayout$LayoutParams;
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mCameraFrameLayout:Landroid/widget/FrameLayout;

    invoke-virtual {v1, v0}, Landroid/widget/FrameLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 92
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mCameraFrameLayout:Landroid/widget/FrameLayout;

    const/4 v2, 0x0

    invoke-virtual {p0, v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->addView(Landroid/view/View;I)V

    .line 93
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mCameraFrameLayout:Landroid/widget/FrameLayout;

    sget v2, Lcom/amazon/mShop/android/lib/R$color;->view_it_dark_background:I

    invoke-virtual {v1, v2}, Landroid/widget/FrameLayout;->setBackgroundResource(I)V

    .line 94
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mCameraFrameLayout:Landroid/widget/FrameLayout;

    new-instance v2, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$1;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$1;-><init>(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)V

    invoke-virtual {v1, v2}, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 105
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->view_it_window_over_camera:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mWindowOverCamera:Landroid/view/View;

    .line 107
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->sliding_drawer:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    .line 108
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mOnDrawerOpenListener:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerOpenListener;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->setOnDrawerOpenListener(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerOpenListener;)V

    .line 109
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mOnDrawerCloseListener:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerCloseListener;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->setOnDrawerCloseListener(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawer$OnDrawerCloseListener;)V

    .line 110
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->getBrowser()Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    .line 111
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mBrowser:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerBrowser;->getViewItDBHelper()Lcom/amazon/mShop/search/viewit/ViewItDBHelper;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mDBHelper:Lcom/amazon/mShop/search/viewit/ViewItDBHelper;

    .line 113
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->view_it_animation_frame:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mScannedItemAnimationFrame:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    .line 114
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mScannedItemAnimationFrame:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->setViewItSlidingDrawer(Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;)V

    .line 116
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->view_it_top_tool_bar:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mTopToolBar:Landroid/view/View;

    .line 117
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mTopToolBar:Landroid/view/View;

    sget v2, Lcom/amazon/mShop/android/lib/R$id;->view_it_top_title:I

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mTopTitle:Landroid/widget/TextView;

    .line 119
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->view_it_top_camera_flash_button_group:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mTopFlashButtonGroup:Landroid/view/View;

    .line 120
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->view_it_top_camera_flash_btn:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ToggleButton;

    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mTopFlashButton:Landroid/widget/ToggleButton;

    .line 121
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mTopFlashButtonGroup:Landroid/view/View;

    new-instance v2, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$2;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$2;-><init>(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)V

    invoke-virtual {v1, v2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 129
    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    iget-object v2, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-direct {v1, v2, p0}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;-><init>(Lcom/amazon/mShop/search/viewit/ViewItActivity;Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;)V

    iput-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mDialogHelper:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    .line 130
    invoke-static {}, Lcom/amazon/mShop/net/NetInfo;->hasNetworkConnection()Z

    move-result v1

    if-nez v1, :cond_0

    .line 131
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mDialogHelper:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;

    const/4 v2, 0x0

    iget-object v3, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->view_it_error_network_error:I

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    sget-object v4, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;->ERROR_NETWORK:Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/mShop/search/viewit/ViewItDialogHelper;->showDialog(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/search/viewit/ViewItDialogHelper$DialogType;)V

    .line 133
    :cond_0
    return-void
.end method

.method public showLoadingWindow(Ljava/util/List;Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;)V
    .locals 2
    .param p2, "outPutType"    # Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;",
            ")V"
        }
    .end annotation

    .prologue
    .line 139
    .local p1, "scannedOutput":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->existsInHistoryList(Ljava/util/List;Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 140
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mScannedItemAnimationFrame:Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/mShop/search/viewit/ViewItScannedItemAnimationFrame;->popUpLoadingWindow(Ljava/util/List;Lcom/amazon/mShop/search/viewit/ResultWrapper$ResultType;)V

    .line 144
    :goto_0
    return-void

    .line 142
    :cond_0
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->view_it_product_found:I

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->view_it_searching:I

    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->updateTitleForPeriod(II)V

    goto :goto_0
.end method

.method public updateFlashModeButtonVisibility()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 281
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mActivity:Lcom/amazon/mShop/search/viewit/ViewItActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItActivity;->getCameraBgHelper()Lcom/amazon/mShop/search/viewit/CameraBgHelper;

    move-result-object v0

    .line 282
    .local v0, "cameraBgHelper":Lcom/amazon/mShop/search/viewit/CameraBgHelper;
    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->isCameraFlashModeOff()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 283
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mTopFlashButton:Landroid/widget/ToggleButton;

    invoke-virtual {v1, v2}, Landroid/widget/ToggleButton;->setChecked(Z)V

    .line 286
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mSlidingDrawer:Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;

    invoke-virtual {v1}, Lcom/amazon/mShop/search/viewit/ViewItSlidingDrawerView;->isOpened()Z

    move-result v1

    if-nez v1, :cond_1

    invoke-virtual {v0}, Lcom/amazon/mShop/search/viewit/CameraBgHelper;->isSupportedFlashTorchMode()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 287
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mTopFlashButtonGroup:Landroid/view/View;

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 291
    :goto_0
    return-void

    .line 289
    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mTopFlashButtonGroup:Landroid/view/View;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method public updateTitle(I)V
    .locals 1
    .param p1, "resid"    # I

    .prologue
    .line 308
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mTopTitle:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 309
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->mTopTitle:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(I)V

    .line 311
    :cond_0
    return-void
.end method

.method public updateTitleForPeriod(II)V
    .locals 4
    .param p1, "resid"    # I
    .param p2, "back_resid"    # I

    .prologue
    .line 319
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;->updateTitle(I)V

    .line 320
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$5;

    invoke-direct {v1, p0, p2}, Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView$5;-><init>(Lcom/amazon/mShop/search/viewit/ViewItPhotoCaptureView;I)V

    const-wide/16 v2, 0x3e8

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;J)V

    .line 330
    return-void
.end method
