.class public Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;
.super Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;
.source "RefinementsListView.java"


# instance fields
.field private lastExpandedGroupItemId:Ljava/lang/String;

.field private listener:Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;

.field private mAdapter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

.field private mItemHeight:I

.field private mRefinements:Lcom/amazon/searchapp/retailsearch/model/Refinements;

.field private mSort:Lcom/amazon/searchapp/retailsearch/model/Sort;

.field private selectedChildPosition:I

.field private selectedGroupItemId:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 45
    invoke-direct {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 34
    const/4 v1, -0x1

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->selectedChildPosition:I

    .line 35
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->lastExpandedGroupItemId:Ljava/lang/String;

    .line 46
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/retailsearch/R$drawable;->horizontal_divider_dark_rs:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 47
    .local v0, "divider":Landroid/graphics/drawable/Drawable;
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->setDivider(Landroid/graphics/drawable/Drawable;)V

    .line 48
    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->setChildDivider(Landroid/graphics/drawable/Drawable;)V

    .line 49
    const/4 v1, 0x2

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->setOverScrollMode(I)V

    .line 50
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/retailsearch/R$dimen;->rs_refinement_menu_item_height:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    invoke-virtual {v0}, Landroid/graphics/drawable/Drawable;->getIntrinsicHeight()I

    move-result v2

    add-int/2addr v1, v2

    iput v1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mItemHeight:I

    .line 52
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->createListeners()V

    .line 53
    return-void
.end method

.method static synthetic access$002(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->selectedGroupItemId:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mAdapter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;
    .param p1, "x1"    # Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;

    .prologue
    .line 26
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->getRefinementID(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$302(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;I)I
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;
    .param p1, "x1"    # I

    .prologue
    .line 26
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->selectedChildPosition:I

    return p1
.end method

.method static synthetic access$400(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->listener:Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    .prologue
    .line 26
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->notifyItemCountChanged()V

    return-void
.end method

.method static synthetic access$600(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->lastExpandedGroupItemId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$602(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->lastExpandedGroupItemId:Ljava/lang/String;

    return-object p1
.end method

.method private buildView()V
    .locals 6

    .prologue
    .line 91
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mRefinements:Lcom/amazon/searchapp/retailsearch/model/Refinements;

    if-nez v0, :cond_1

    .line 108
    :cond_0
    :goto_0
    return-void

    .line 95
    :cond_1
    new-instance v0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mRefinements:Lcom/amazon/searchapp/retailsearch/model/Refinements;

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Refinements;->getDepartments()Lcom/amazon/searchapp/retailsearch/model/Department;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mRefinements:Lcom/amazon/searchapp/retailsearch/model/Refinements;

    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/Refinements;->getFilters()Ljava/util/List;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mSort:Lcom/amazon/searchapp/retailsearch/model/Sort;

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mRefinements:Lcom/amazon/searchapp/retailsearch/model/Refinements;

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/Refinements;->getPrioritizedFilterIds()Ljava/util/List;

    move-result-object v4

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;-><init>(Lcom/amazon/searchapp/retailsearch/model/Department;Ljava/util/List;Lcom/amazon/searchapp/retailsearch/model/Sort;Ljava/util/List;Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mAdapter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    .line 97
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mAdapter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->setAdapter(Landroid/widget/ExpandableListAdapter;)V

    .line 99
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->selectedGroupItemId:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 101
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->selectedGroupItemId:Ljava/lang/String;

    iget v1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->selectedChildPosition:I

    invoke-direct {p0, v0, v1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->openGroup(Ljava/lang/String;I)V

    .line 103
    :cond_2
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->listener:Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;

    if-eqz v0, :cond_0

    .line 105
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->listener:Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mRefinements:Lcom/amazon/searchapp/retailsearch/model/Refinements;

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;->onUpdate(Lcom/amazon/searchapp/retailsearch/model/Refinements;)V

    .line 106
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->listener:Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;->onViewSizeChanged()V

    goto :goto_0
.end method

.method private createListeners()V
    .locals 1

    .prologue
    .line 115
    new-instance v0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$1;

    invoke-direct {v0, p0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$1;-><init>(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)V

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->setOnChildClickListener(Landroid/widget/ExpandableListView$OnChildClickListener;)V

    .line 158
    new-instance v0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$2;

    invoke-direct {v0, p0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$2;-><init>(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)V

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->setOnGroupExpandListener(Landroid/widget/ExpandableListView$OnGroupExpandListener;)V

    .line 167
    new-instance v0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$3;

    invoke-direct {v0, p0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$3;-><init>(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)V

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->setOnGroupCollapseListener(Landroid/widget/ExpandableListView$OnGroupCollapseListener;)V

    .line 176
    new-instance v0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$4;

    invoke-direct {v0, p0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView$4;-><init>(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;)V

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->setOnGroupClickListener(Landroid/widget/ExpandableListView$OnGroupClickListener;)V

    .line 217
    return-void
.end method

.method private getRefinementID(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;)Ljava/lang/String;
    .locals 1
    .param p1, "refinementItem"    # Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;

    .prologue
    .line 293
    if-nez p1, :cond_0

    .line 295
    const/4 v0, 0x0

    .line 299
    :goto_0
    return-object v0

    :cond_0
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->getId()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_1

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->getLabel()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_1
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->getId()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private notifyItemCountChanged()V
    .locals 1

    .prologue
    .line 221
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->listener:Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;

    if-eqz v0, :cond_0

    .line 223
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->listener:Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;->onViewSizeChanged()V

    .line 225
    :cond_0
    return-void
.end method

.method private openGroup(Ljava/lang/String;I)V
    .locals 5
    .param p1, "selectedGroupItemId"    # Ljava/lang/String;
    .param p2, "childPosition"    # I

    .prologue
    const/4 v4, -0x1

    .line 263
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mAdapter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    invoke-virtual {v3, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getGroupPosition(Ljava/lang/String;)I

    move-result v1

    .line 264
    .local v1, "groupPosition":I
    if-le v1, v4, :cond_0

    .line 266
    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->expandGroup(I)Z

    .line 268
    if-le p2, v4, :cond_2

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mAdapter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    invoke-virtual {v3, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->isFilterGroup(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    iget v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mItemHeight:I

    add-int/lit8 v4, p2, 0x2

    mul-int/2addr v3, v4

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->getHeight()I

    move-result v4

    if-le v3, v4, :cond_2

    .line 271
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mAdapter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    invoke-virtual {v3, v1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getRealChildrenCount(I)I

    move-result v0

    .line 272
    .local v0, "childrenCount":I
    add-int/lit8 v3, v0, -0x1

    if-le p2, v3, :cond_1

    add-int/lit8 v2, v0, -0x1

    .line 273
    .local v2, "position":I
    :goto_0
    const/4 v3, 0x1

    invoke-virtual {p0, v1, v2, v3}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->setSelectedChild(IIZ)Z

    .line 281
    .end local v0    # "childrenCount":I
    .end local v2    # "position":I
    :cond_0
    :goto_1
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->clearAll()V

    .line 282
    return-void

    .restart local v0    # "childrenCount":I
    :cond_1
    move v2, p2

    .line 272
    goto :goto_0

    .line 278
    .end local v0    # "childrenCount":I
    :cond_2
    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->setSelectedGroup(I)V

    goto :goto_1
.end method


# virtual methods
.method public clearAll()V
    .locals 1

    .prologue
    .line 253
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->selectedGroupItemId:Ljava/lang/String;

    .line 254
    const/4 v0, -0x1

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->selectedChildPosition:I

    .line 255
    return-void
.end method

.method public getItemsHeight(I)I
    .locals 6
    .param p1, "maxHeight"    # I

    .prologue
    const/4 v3, -0x1

    .line 229
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->lastExpandedGroupItemId:Ljava/lang/String;

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_1

    move v0, v3

    .line 230
    .local v0, "expandedGroupPosition":I
    :goto_0
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mAdapter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getGroupCount()I

    move-result v4

    if-le v0, v3, :cond_2

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mAdapter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    invoke-virtual {v3, v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getRealChildrenCount(I)I

    move-result v3

    :goto_1
    add-int v2, v4, v3

    .line 232
    .local v2, "itemsCount":I
    iget v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mItemHeight:I

    mul-int v1, v2, v3

    .line 233
    .local v1, "height":I
    if-le v1, p1, :cond_0

    move v1, p1

    .line 234
    :cond_0
    return v1

    .line 229
    .end local v0    # "expandedGroupPosition":I
    .end local v1    # "height":I
    .end local v2    # "itemsCount":I
    :cond_1
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mAdapter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->lastExpandedGroupItemId:Ljava/lang/String;

    invoke-virtual {v4, v5}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getGroupPosition(Ljava/lang/String;)I

    move-result v0

    goto :goto_0

    .line 230
    .restart local v0    # "expandedGroupPosition":I
    :cond_2
    const/4 v3, 0x0

    goto :goto_1
.end method

.method public refresh()V
    .locals 1

    .prologue
    .line 242
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mAdapter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    if-eqz v0, :cond_0

    .line 244
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mAdapter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->notifyDataSetChanged()V

    .line 246
    :cond_0
    return-void
.end method

.method public setListener(Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;

    .prologue
    .line 62
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->listener:Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsViewListener;

    .line 63
    return-void
.end method

.method public setRefinements(Lcom/amazon/searchapp/retailsearch/model/Refinements;)V
    .locals 0
    .param p1, "refinements"    # Lcom/amazon/searchapp/retailsearch/model/Refinements;

    .prologue
    .line 72
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mRefinements:Lcom/amazon/searchapp/retailsearch/model/Refinements;

    .line 73
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->buildView()V

    .line 74
    return-void
.end method

.method public setSort(Lcom/amazon/searchapp/retailsearch/model/Sort;)V
    .locals 0
    .param p1, "sort"    # Lcom/amazon/searchapp/retailsearch/model/Sort;

    .prologue
    .line 83
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsListView;->mSort:Lcom/amazon/searchapp/retailsearch/model/Sort;

    .line 84
    return-void
.end method
