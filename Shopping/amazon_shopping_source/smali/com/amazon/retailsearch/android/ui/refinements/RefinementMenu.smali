.class public Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;
.super Landroid/widget/RelativeLayout;
.source "RefinementMenu.java"

# interfaces
.implements Lcom/amazon/retailsearch/popup/PopupDialog;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$RefinementsMenuListener;
    }
.end annotation


# instance fields
.field dataSource:Lcom/amazon/retailsearch/interaction/SearchDataSource;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private dialogHeight:I

.field private dialogSizeChangedListener:Lcom/amazon/retailsearch/popup/DialogSizeChangedListener;

.field private filtersCount:I

.field private listener:Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;

.field private mClearAll:Landroid/widget/TextView;

.field private mContent:Landroid/view/View;

.field private mContext:Landroid/content/Context;

.field private mPopupBackground:Landroid/view/View;

.field private mPopupBackgroundPaddingTop:I

.field private mPopupHeaderHeight:I

.field private refinementListView:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

.field private spinner:Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 76
    invoke-direct {p0, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 77
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->init(Landroid/content/Context;)V

    .line 78
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 66
    invoke-direct {p0, p1, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 67
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->init(Landroid/content/Context;)V

    .line 68
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 55
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 56
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->init(Landroid/content/Context;)V

    .line 57
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;)Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->listener:Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;)Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    .prologue
    .line 30
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->getSpinner()Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->refinementListView:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    return-object v0
.end method

.method private getFiltersCount(Lcom/amazon/searchapp/retailsearch/model/Refinements;)I
    .locals 6
    .param p1, "refinements"    # Lcom/amazon/searchapp/retailsearch/model/Refinements;

    .prologue
    .line 279
    const/4 v0, 0x0

    .line 280
    .local v0, "count":I
    if-nez p1, :cond_0

    move v1, v0

    .line 300
    .end local v0    # "count":I
    .local v1, "count":I
    :goto_0
    return v1

    .line 284
    .end local v1    # "count":I
    .restart local v0    # "count":I
    :cond_0
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Refinements;->getDepartments()Lcom/amazon/searchapp/retailsearch/model/Department;

    move-result-object v4

    if-eqz v4, :cond_1

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Refinements;->getDepartments()Lcom/amazon/searchapp/retailsearch/model/Department;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/Department;->getAncestry()Ljava/util/List;

    move-result-object v4

    if-eqz v4, :cond_1

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Refinements;->getDepartments()Lcom/amazon/searchapp/retailsearch/model/Department;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/Department;->getAncestry()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    const/4 v5, 0x1

    if-le v4, v5, :cond_1

    .line 288
    add-int/lit8 v0, v0, 0x1

    .line 290
    :cond_1
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Refinements;->getFilters()Ljava/util/List;

    move-result-object v4

    if-eqz v4, :cond_3

    .line 292
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/Refinements;->getFilters()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;

    .line 294
    .local v2, "filter":Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;
    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;->getClearLink()Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

    move-result-object v4

    if-eqz v4, :cond_2

    .line 296
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .end local v2    # "filter":Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;
    .end local v3    # "i$":Ljava/util/Iterator;
    :cond_3
    move v1, v0

    .line 300
    .end local v0    # "count":I
    .restart local v1    # "count":I
    goto :goto_0
.end method

.method private getSpinner()Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;
    .locals 1

    .prologue
    .line 239
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->spinner:Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;

    if-nez v0, :cond_0

    .line 241
    sget v0, Lcom/amazon/retailsearch/R$id;->refinements_menu_spinner:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->spinner:Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;

    .line 243
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->spinner:Lcom/amazon/retailsearch/android/ui/refinements/SpinnerHiderRelativeLayout;

    return-object v0
.end method

.method private init(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 86
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 87
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->mContext:Landroid/content/Context;

    .line 88
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$dimen;->rs_refinement_menu_popup_header_height:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->mPopupHeaderHeight:I

    .line 90
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$dimen;->rs_refinement_menu_popup_background_padding_top:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->mPopupBackgroundPaddingTop:I

    .line 92
    return-void
.end method

.method private setClearAllEnable(Z)V
    .locals 2
    .param p1, "isEnable"    # Z

    .prologue
    .line 252
    if-eqz p1, :cond_0

    .line 254
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->mClearAll:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 260
    :goto_0
    return-void

    .line 258
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->mClearAll:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method


# virtual methods
.method public getDialogHeight()I
    .locals 1

    .prologue
    .line 306
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->dialogHeight:I

    return v0
.end method

.method public getFiltersCount()I
    .locals 1

    .prologue
    .line 268
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->filtersCount:I

    return v0
.end method

.method public notifyRefinementsChanged()V
    .locals 1

    .prologue
    .line 179
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->refinementListView:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->refresh()V

    .line 180
    return-void
.end method

.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 0
    .param p1, "configuration"    # Landroid/content/res/Configuration;

    .prologue
    .line 123
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->updateDialogHeight()V

    .line 124
    return-void
.end method

.method public onFinishInflate()V
    .locals 3

    .prologue
    .line 97
    invoke-super {p0}, Landroid/widget/RelativeLayout;->onFinishInflate()V

    .line 99
    sget v0, Lcom/amazon/retailsearch/R$id;->refinements_menu_popup_background:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->mPopupBackground:Landroid/view/View;

    .line 100
    sget v0, Lcom/amazon/retailsearch/R$id;->refinements_menu_content:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->mContent:Landroid/view/View;

    .line 101
    sget v0, Lcom/amazon/retailsearch/R$id;->refinements_menu_clear_all:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->mClearAll:Landroid/widget/TextView;

    .line 102
    sget v0, Lcom/amazon/retailsearch/R$id;->refinements_menu_list_view:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->refinementListView:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    .line 103
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->refinementListView:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    new-instance v1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$RefinementsMenuListener;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$RefinementsMenuListener;-><init>(Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$1;)V

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->setListener(Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;)V

    .line 105
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->mClearAll:Landroid/widget/TextView;

    new-instance v1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$1;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu$1;-><init>(Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;)V

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 118
    return-void
.end method

.method public setListener(Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;

    .prologue
    .line 150
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->listener:Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;

    .line 151
    return-void
.end method

.method public setRefinements(Lcom/amazon/searchapp/retailsearch/model/Refinements;)V
    .locals 1
    .param p1, "refinements"    # Lcom/amazon/searchapp/retailsearch/model/Refinements;

    .prologue
    .line 160
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->refinementListView:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->setRefinements(Lcom/amazon/searchapp/retailsearch/model/Refinements;)V

    .line 161
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->getFiltersCount(Lcom/amazon/searchapp/retailsearch/model/Refinements;)I

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->filtersCount:I

    .line 162
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->dataSource:Lcom/amazon/retailsearch/interaction/SearchDataSource;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/interaction/SearchDataSource;->isQueryChangedAfterStaged()Z

    move-result v0

    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->setClearAllEnable(Z)V

    .line 163
    return-void
.end method

.method public setSizeChangeListener(Lcom/amazon/retailsearch/popup/DialogSizeChangedListener;)V
    .locals 0
    .param p1, "dialogSizeChangedListener"    # Lcom/amazon/retailsearch/popup/DialogSizeChangedListener;

    .prologue
    .line 312
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->dialogSizeChangedListener:Lcom/amazon/retailsearch/popup/DialogSizeChangedListener;

    .line 313
    return-void
.end method

.method public setSort(Lcom/amazon/searchapp/retailsearch/model/Sort;)V
    .locals 1
    .param p1, "sort"    # Lcom/amazon/searchapp/retailsearch/model/Sort;

    .prologue
    .line 172
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->refinementListView:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->setSort(Lcom/amazon/searchapp/retailsearch/model/Sort;)V

    .line 173
    return-void
.end method

.method public updateDialogHeight()V
    .locals 4

    .prologue
    .line 131
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->mPopupBackground:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    .line 132
    .local v1, "params":Landroid/view/ViewGroup$LayoutParams;
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v2

    iget v0, v2, Landroid/util/DisplayMetrics;->heightPixels:I

    .line 133
    .local v0, "maxPopupHeight":I
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->refinementListView:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    invoke-virtual {v2, v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->getItemsHeight(I)I

    move-result v2

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->mContent:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getPaddingTop()I

    move-result v3

    add-int/2addr v2, v3

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->mContent:Landroid/view/View;

    invoke-virtual {v3}, Landroid/view/View;->getPaddingBottom()I

    move-result v3

    add-int/2addr v2, v3

    iget v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->mPopupHeaderHeight:I

    add-int/2addr v2, v3

    iget v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->mPopupBackgroundPaddingTop:I

    add-int/2addr v2, v3

    iput v2, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->dialogHeight:I

    .line 135
    iget v2, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->dialogHeight:I

    iput v2, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 136
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->mPopupBackground:Landroid/view/View;

    invoke-virtual {v2, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 137
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->dialogSizeChangedListener:Lcom/amazon/retailsearch/popup/DialogSizeChangedListener;

    if-eqz v2, :cond_0

    .line 139
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->dialogSizeChangedListener:Lcom/amazon/retailsearch/popup/DialogSizeChangedListener;

    iget v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->dialogHeight:I

    invoke-interface {v2, v3}, Lcom/amazon/retailsearch/popup/DialogSizeChangedListener;->onHeightChanged(I)V

    .line 141
    :cond_0
    return-void
.end method
