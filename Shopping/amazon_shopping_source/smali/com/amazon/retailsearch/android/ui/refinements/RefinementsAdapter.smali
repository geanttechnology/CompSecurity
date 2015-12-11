.class public Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;
.super Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;
.source "RefinementsAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;,
        Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;
    }
.end annotation


# static fields
.field private static final FILTER_TYPE_ADDRESS:Ljava/lang/String; = "Address"

.field private static final FILTER_TYPE_MULTI:Ljava/lang/String; = "MultiSelectOR"

.field public static final ID_DEPARTMENT:Ljava/lang/String; = "dept"

.field public static final ID_SEEMORE_FILTERS:Ljava/lang/String; = "seeMoreFilters"

.field public static final ID_SORT:Ljava/lang/String; = "sort"

.field public static final REFINEMENT_LINK_CHILD_ID:J = 0x3L

.field public static final SELECTED_OPTION_CHILD_ID:J = 0x4L


# instance fields
.field private final ancestryDepartmentSize:I

.field private final mContext:Landroid/content/Context;

.field private final mDepartment:Lcom/amazon/searchapp/retailsearch/model/Department;

.field private final mFilters:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;",
            ">;"
        }
    .end annotation
.end field

.field private final mPrioritizedFilters:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;",
            ">;"
        }
    .end annotation
.end field

.field private final mResources:Landroid/content/res/Resources;

.field private final mSort:Lcom/amazon/searchapp/retailsearch/model/Sort;

.field preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field retailSearchDataProvider:Ldagger/Lazy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ldagger/Lazy",
            "<",
            "Lcom/amazon/retailsearch/data/IRetailSearchDataProvider;",
            ">;"
        }
    .end annotation

    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private final viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;


# direct methods
.method public constructor <init>(Lcom/amazon/searchapp/retailsearch/model/Department;Ljava/util/List;Lcom/amazon/searchapp/retailsearch/model/Sort;Ljava/util/List;Landroid/content/Context;)V
    .locals 2
    .param p1, "department"    # Lcom/amazon/searchapp/retailsearch/model/Department;
    .param p3, "sort"    # Lcom/amazon/searchapp/retailsearch/model/Sort;
    .param p5, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/searchapp/retailsearch/model/Department;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;",
            ">;",
            "Lcom/amazon/searchapp/retailsearch/model/Sort;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Landroid/content/Context;",
            ")V"
        }
    .end annotation

    .prologue
    .line 151
    .local p2, "filters":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;>;"
    .local p4, "prioritizedFilterIds":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/AnimatedExpandableListView$AnimatedExpandableListAdapter;-><init>()V

    .line 138
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mFilters:Ljava/util/List;

    .line 139
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mPrioritizedFilters:Ljava/util/List;

    .line 152
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 153
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mDepartment:Lcom/amazon/searchapp/retailsearch/model/Department;

    .line 154
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mDepartment:Lcom/amazon/searchapp/retailsearch/model/Department;

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Department;->getAncestry()Ljava/util/List;

    move-result-object v0

    if-nez v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    iput v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->ancestryDepartmentSize:I

    .line 155
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mFilters:Ljava/util/List;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mPrioritizedFilters:Ljava/util/List;

    invoke-direct {p0, p2, p4, v0, v1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->splitFilters(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V

    .line 156
    iput-object p3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mSort:Lcom/amazon/searchapp/retailsearch/model/Sort;

    .line 157
    iput-object p5, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mContext:Landroid/content/Context;

    .line 158
    invoke-virtual {p5}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mResources:Landroid/content/res/Resources;

    .line 159
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->getViewType()Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .line 160
    return-void

    .line 154
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mDepartment:Lcom/amazon/searchapp/retailsearch/model/Department;

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/Department;->getAncestry()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    goto :goto_0
.end method

.method private filterOffset()I
    .locals 5

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 745
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mDepartment:Lcom/amazon/searchapp/retailsearch/model/Department;

    if-nez v4, :cond_0

    move v0, v2

    .line 746
    .local v0, "dept":I
    :goto_0
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mSort:Lcom/amazon/searchapp/retailsearch/model/Sort;

    if-nez v4, :cond_1

    move v1, v2

    .line 747
    .local v1, "sort":I
    :goto_1
    add-int v2, v0, v1

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mPrioritizedFilters:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    add-int/2addr v2, v3

    return v2

    .end local v0    # "dept":I
    .end local v1    # "sort":I
    :cond_0
    move v0, v3

    .line 745
    goto :goto_0

    .restart local v0    # "dept":I
    :cond_1
    move v1, v3

    .line 746
    goto :goto_1
.end method

.method private getFilterLabelText(Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;)Ljava/lang/String;
    .locals 6
    .param p1, "filter"    # Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;

    .prologue
    .line 712
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 713
    .local v3, "stringBuilder":Ljava/lang/StringBuilder;
    const/4 v2, 0x0

    .line 715
    .local v2, "selected":Z
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;->getValues()Ljava/util/List;

    move-result-object v4

    if-eqz v4, :cond_2

    .line 717
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;->getValues()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

    .line 719
    .local v1, "node":Lcom/amazon/searchapp/retailsearch/model/RefinementLink;
    if-eqz v1, :cond_0

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;->getSelected()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 721
    const/4 v2, 0x1

    .line 722
    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;->getText()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 724
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->length()I

    move-result v4

    if-lez v4, :cond_1

    .line 726
    const-string/jumbo v4, ", "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 728
    :cond_1
    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;->getText()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 733
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "node":Lcom/amazon/searchapp/retailsearch/model/RefinementLink;
    :cond_2
    if-eqz v2, :cond_3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->length()I

    move-result v4

    const/4 v5, 0x1

    if-ge v4, v5, :cond_3

    .line 735
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mResources:Landroid/content/res/Resources;

    sget v5, Lcom/amazon/retailsearch/R$string;->refine_selected:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 737
    :goto_1
    return-object v4

    :cond_3
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    goto :goto_1
.end method

.method private getFilterMessage(Landroid/widget/TextView;Lcom/amazon/searchapp/retailsearch/model/RefinementLink;)Landroid/text/SpannableStringBuilder;
    .locals 5
    .param p1, "textView"    # Landroid/widget/TextView;
    .param p2, "refinementLink"    # Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

    .prologue
    .line 758
    new-instance v0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->viewType:Lcom/amazon/retailsearch/android/ui/results/ViewType;

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mContext:Landroid/content/Context;

    invoke-direct {v0, v3, v4}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;-><init>(Lcom/amazon/retailsearch/android/ui/results/ViewType;Landroid/content/Context;)V

    .line 759
    .local v0, "sss":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    if-nez p2, :cond_1

    .line 774
    :cond_0
    :goto_0
    return-object v0

    .line 763
    :cond_1
    invoke-interface {p2}, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;->getStyleText()Ljava/util/List;

    move-result-object v2

    .line 764
    .local v2, "styledTexts":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    if-eqz v2, :cond_3

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_3

    .line 767
    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v3

    const/4 v4, 0x1

    if-le v3, v4, :cond_2

    sget v1, Lcom/amazon/retailsearch/R$style;->Rs_Refinement_ChildPanel_Header_MultiText:I

    .line 768
    .local v1, "style":I
    :goto_1
    invoke-virtual {v0, v2, v1}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/util/List;I)V

    goto :goto_0

    .line 767
    .end local v1    # "style":I
    :cond_2
    sget v1, Lcom/amazon/retailsearch/R$style;->Rs_Refinement_ChildPanel_Header:I

    goto :goto_1

    .line 770
    :cond_3
    invoke-interface {p2}, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;->getText()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 772
    invoke-interface {p2}, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;->getText()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/CharSequence;)Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    goto :goto_0
.end method

.method private getFilterSize(Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;)I
    .locals 2
    .param p1, "filter"    # Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;

    .prologue
    .line 355
    const/4 v0, 0x0

    .line 356
    .local v0, "size":I
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;->getValues()Ljava/util/List;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 358
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;->getValues()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    .line 359
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;->getClearLink()Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 361
    add-int/lit8 v0, v0, 0x1

    .line 364
    :cond_0
    return v0
.end method

.method private getGroupSection(I)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;
    .locals 4
    .param p1, "groupPosition"    # I

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 466
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mPrioritizedFilters:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    add-int/lit8 v0, v3, -0x1

    .line 467
    .local v0, "pos":I
    if-gt p1, v0, :cond_0

    .line 469
    sget-object v1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->PrioritizedFilter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    .line 495
    :goto_0
    return-object v1

    .line 472
    :cond_0
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mDepartment:Lcom/amazon/searchapp/retailsearch/model/Department;

    if-nez v3, :cond_1

    move v3, v1

    :goto_1
    add-int/2addr v0, v3

    .line 473
    if-ne p1, v0, :cond_2

    .line 475
    sget-object v1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Department:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    goto :goto_0

    :cond_1
    move v3, v2

    .line 472
    goto :goto_1

    .line 478
    :cond_2
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mSort:Lcom/amazon/searchapp/retailsearch/model/Sort;

    if-nez v3, :cond_3

    :goto_2
    add-int/2addr v0, v1

    .line 479
    if-ne p1, v0, :cond_4

    .line 481
    sget-object v1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Sort:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    goto :goto_0

    :cond_3
    move v1, v2

    .line 478
    goto :goto_2

    .line 484
    :cond_4
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mFilters:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    add-int/2addr v0, v1

    .line 485
    if-gt p1, v0, :cond_5

    .line 487
    sget-object v1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Filter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    goto :goto_0

    .line 490
    :cond_5
    add-int/lit8 v0, v0, 0x1

    .line 491
    if-ne p1, v0, :cond_6

    .line 493
    sget-object v1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->SeeMore:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    goto :goto_0

    .line 495
    :cond_6
    sget-object v1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Unknown:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    goto :goto_0
.end method

.method private getRefinementID(Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;)Ljava/lang/String;
    .locals 1
    .param p1, "refinementFilter"    # Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;

    .prologue
    .line 856
    if-nez p1, :cond_0

    .line 858
    const/4 v0, 0x0

    .line 862
    :goto_0
    return-object v0

    :cond_0
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;->getId()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_1

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;->getLabel()Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    :cond_1
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;->getId()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method private getRefinementLink(Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;I)Lcom/amazon/searchapp/retailsearch/model/RefinementLink;
    .locals 2
    .param p1, "filter"    # Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;
    .param p2, "childPosition"    # I

    .prologue
    .line 200
    move v0, p2

    .line 201
    .local v0, "index":I
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;->getClearLink()Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 203
    add-int/lit8 v0, v0, -0x1

    .line 205
    :cond_0
    const/4 v1, -0x1

    if-ne v0, v1, :cond_1

    .line 207
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;->getClearLink()Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

    move-result-object v1

    .line 211
    :goto_0
    return-object v1

    :cond_1
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;->getValues()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

    goto :goto_0
.end method

.method private getSelectedLabelText(I)Ljava/lang/String;
    .locals 7
    .param p1, "groupPosition"    # I

    .prologue
    .line 665
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getGroupSection(I)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    move-result-object v3

    .line 666
    .local v3, "section":Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;
    sget-object v5, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Department:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-ne v3, v5, :cond_0

    .line 668
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mDepartment:Lcom/amazon/searchapp/retailsearch/model/Department;

    if-eqz v5, :cond_4

    .line 670
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mDepartment:Lcom/amazon/searchapp/retailsearch/model/Department;

    invoke-interface {v5}, Lcom/amazon/searchapp/retailsearch/model/Department;->getAncestry()Ljava/util/List;

    move-result-object v0

    .line 671
    .local v0, "ancestry":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/RefinementLink;>;"
    if-eqz v0, :cond_4

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v5

    if-lez v5, :cond_4

    .line 673
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    invoke-interface {v0, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

    invoke-interface {v5}, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;->getText()Ljava/lang/String;

    move-result-object v5

    .line 702
    .end local v0    # "ancestry":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/RefinementLink;>;"
    :goto_0
    return-object v5

    .line 677
    :cond_0
    sget-object v5, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Sort:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-ne v3, v5, :cond_2

    .line 679
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mSort:Lcom/amazon/searchapp/retailsearch/model/Sort;

    if-eqz v5, :cond_4

    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mSort:Lcom/amazon/searchapp/retailsearch/model/Sort;

    invoke-interface {v5}, Lcom/amazon/searchapp/retailsearch/model/Sort;->getOptions()Ljava/util/List;

    move-result-object v5

    if-eqz v5, :cond_4

    .line 681
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mSort:Lcom/amazon/searchapp/retailsearch/model/Sort;

    invoke-interface {v5}, Lcom/amazon/searchapp/retailsearch/model/Sort;->getOptions()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_4

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/searchapp/retailsearch/model/SelectedOption;

    .line 683
    .local v4, "sortOption":Lcom/amazon/searchapp/retailsearch/model/SelectedOption;
    if-eqz v4, :cond_1

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/SelectedOption;->getSelected()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/SelectedOption;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v5

    if-eqz v5, :cond_1

    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/SelectedOption;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v5

    invoke-interface {v5}, Lcom/amazon/searchapp/retailsearch/model/Link;->getText()Ljava/lang/String;

    move-result-object v5

    if-eqz v5, :cond_1

    .line 687
    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/SelectedOption;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v5

    invoke-interface {v5}, Lcom/amazon/searchapp/retailsearch/model/Link;->getText()Ljava/lang/String;

    move-result-object v5

    goto :goto_0

    .line 692
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v4    # "sortOption":Lcom/amazon/searchapp/retailsearch/model/SelectedOption;
    :cond_2
    sget-object v5, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->PrioritizedFilter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-ne v3, v5, :cond_3

    .line 694
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mPrioritizedFilters:Ljava/util/List;

    invoke-interface {v5, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;

    .line 695
    .local v1, "filter":Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;
    invoke-direct {p0, v1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getFilterLabelText(Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;)Ljava/lang/String;

    move-result-object v5

    goto :goto_0

    .line 697
    .end local v1    # "filter":Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;
    :cond_3
    sget-object v5, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Filter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-ne v3, v5, :cond_4

    .line 699
    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mFilters:Ljava/util/List;

    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->filterOffset()I

    move-result v6

    sub-int v6, p1, v6

    invoke-interface {v5, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;

    .line 700
    .restart local v1    # "filter":Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;
    invoke-direct {p0, v1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getFilterLabelText(Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;)Ljava/lang/String;

    move-result-object v5

    goto :goto_0

    .line 702
    .end local v1    # "filter":Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;
    :cond_4
    const-string/jumbo v5, ""

    goto :goto_0
.end method

.method private isDepartmentSelected()Z
    .locals 3

    .prologue
    const/4 v1, 0x1

    .line 811
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mDepartment:Lcom/amazon/searchapp/retailsearch/model/Department;

    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/Department;->getAncestry()Ljava/util/List;

    move-result-object v0

    .line 812
    .local v0, "ancestry":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/RefinementLink;>;"
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v2

    if-le v2, v1, :cond_0

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private setDepartmentChildView(Lcom/amazon/searchapp/retailsearch/model/RefinementLink;ILandroid/widget/TextView;)V
    .locals 3
    .param p1, "department"    # Lcom/amazon/searchapp/retailsearch/model/RefinementLink;
    .param p2, "childPosition"    # I
    .param p3, "textView"    # Landroid/widget/TextView;

    .prologue
    const/4 v2, 0x0

    .line 612
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->ancestryDepartmentSize:I

    if-lt p2, v0, :cond_0

    .line 614
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mResources:Landroid/content/res/Resources;

    sget v1, Lcom/amazon/retailsearch/R$dimen;->pc_27px:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    invoke-virtual {p3, v0, v2, v2, v2}, Landroid/widget/TextView;->setPadding(IIII)V

    .line 616
    :cond_0
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;->getText()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p3, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 617
    return-void
.end method

.method private splitFilters(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 787
    .local p1, "originalfilters":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;>;"
    .local p2, "prioritizedFilterIds":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .local p3, "filters":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;>;"
    .local p4, "prioritizedFilters":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;>;"
    invoke-static {p2}, Lcom/amazon/retailsearch/util/Utils;->isEmpty(Ljava/util/Collection;)Z

    move-result v2

    if-nez v2, :cond_0

    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v2

    if-nez v2, :cond_1

    .line 802
    :cond_0
    return-void

    .line 791
    :cond_1
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;

    .line 793
    .local v0, "filter":Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p2, v2}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 795
    invoke-interface {p4, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 799
    :cond_2
    invoke-interface {p3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method


# virtual methods
.method public getChild(II)Ljava/lang/Object;
    .locals 3
    .param p1, "groupPosition"    # I
    .param p2, "childPosition"    # I

    .prologue
    .line 165
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getGroupSection(I)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    move-result-object v0

    .line 166
    .local v0, "section":Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;
    sget-object v1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Department:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-ne v0, v1, :cond_1

    .line 168
    iget v1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->ancestryDepartmentSize:I

    if-ge p2, v1, :cond_0

    .line 170
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mDepartment:Lcom/amazon/searchapp/retailsearch/model/Department;

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Department;->getAncestry()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    .line 189
    :goto_0
    return-object v1

    .line 174
    :cond_0
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mDepartment:Lcom/amazon/searchapp/retailsearch/model/Department;

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Department;->getCategories()Ljava/util/List;

    move-result-object v1

    iget v2, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->ancestryDepartmentSize:I

    sub-int v2, p2, v2

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    goto :goto_0

    .line 177
    :cond_1
    sget-object v1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Sort:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-ne v0, v1, :cond_2

    .line 179
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mSort:Lcom/amazon/searchapp/retailsearch/model/Sort;

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/Sort;->getOptions()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    goto :goto_0

    .line 181
    :cond_2
    sget-object v1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->PrioritizedFilter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-ne v0, v1, :cond_3

    .line 183
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mPrioritizedFilters:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;

    invoke-direct {p0, v1, p2}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getRefinementLink(Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;I)Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

    move-result-object v1

    goto :goto_0

    .line 185
    :cond_3
    sget-object v1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Filter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-ne v0, v1, :cond_4

    .line 187
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mFilters:Ljava/util/List;

    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->filterOffset()I

    move-result v2

    sub-int v2, p1, v2

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;

    invoke-direct {p0, v1, p2}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getRefinementLink(Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;I)Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

    move-result-object v1

    goto :goto_0

    .line 189
    :cond_4
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getChildId(II)J
    .locals 3
    .param p1, "groupPosition"    # I
    .param p2, "childPosition"    # I

    .prologue
    .line 218
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getGroupSection(I)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    move-result-object v0

    .line 219
    .local v0, "section":Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;
    sget-object v1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Sort:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-ne v0, v1, :cond_0

    .line 221
    const-wide/16 v1, 0x4

    .line 227
    :goto_0
    return-wide v1

    .line 223
    :cond_0
    sget-object v1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Department:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-eq v0, v1, :cond_1

    sget-object v1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Filter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-eq v0, v1, :cond_1

    sget-object v1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->PrioritizedFilter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-ne v0, v1, :cond_2

    .line 225
    :cond_1
    const-wide/16 v1, 0x3

    goto :goto_0

    .line 227
    :cond_2
    const-wide/16 v1, -0x1

    goto :goto_0
.end method

.method public getGroup(I)Ljava/lang/Object;
    .locals 3
    .param p1, "groupPosition"    # I

    .prologue
    .line 370
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getGroupSection(I)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    move-result-object v0

    .line 371
    .local v0, "section":Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;
    sget-object v1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Department:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-ne v0, v1, :cond_0

    .line 373
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mDepartment:Lcom/amazon/searchapp/retailsearch/model/Department;

    .line 389
    :goto_0
    return-object v1

    .line 375
    :cond_0
    sget-object v1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Sort:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-ne v0, v1, :cond_1

    .line 377
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mSort:Lcom/amazon/searchapp/retailsearch/model/Sort;

    goto :goto_0

    .line 379
    :cond_1
    sget-object v1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->PrioritizedFilter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-ne v0, v1, :cond_2

    .line 381
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mPrioritizedFilters:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    goto :goto_0

    .line 383
    :cond_2
    sget-object v1, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Filter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-ne v0, v1, :cond_3

    .line 385
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mFilters:Ljava/util/List;

    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->filterOffset()I

    move-result v2

    sub-int v2, p1, v2

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    goto :goto_0

    .line 389
    :cond_3
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getGroupCount()I
    .locals 5

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 396
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mDepartment:Lcom/amazon/searchapp/retailsearch/model/Department;

    if-nez v3, :cond_0

    move v0, v1

    .line 397
    .local v0, "count":I
    :goto_0
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mSort:Lcom/amazon/searchapp/retailsearch/model/Sort;

    if-nez v3, :cond_1

    move v3, v1

    :goto_1
    add-int/2addr v0, v3

    .line 398
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mFilters:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mPrioritizedFilters:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v4

    add-int/2addr v3, v4

    add-int/2addr v0, v3

    .line 399
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->isDepartmentSelected()Z

    move-result v3

    if-eqz v3, :cond_2

    :goto_2
    add-int/2addr v0, v1

    .line 400
    return v0

    .end local v0    # "count":I
    :cond_0
    move v0, v2

    .line 396
    goto :goto_0

    .restart local v0    # "count":I
    :cond_1
    move v3, v2

    .line 397
    goto :goto_1

    :cond_2
    move v1, v2

    .line 399
    goto :goto_2
.end method

.method public getGroupId(I)J
    .locals 2
    .param p1, "groupPosition"    # I

    .prologue
    .line 406
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public getGroupItem(I)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;
    .locals 6
    .param p1, "groupPosition"    # I

    .prologue
    .line 626
    new-instance v2, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;

    invoke-direct {v2, p0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;-><init>(Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;)V

    .line 627
    .local v2, "item":Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getGroupSection(I)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    move-result-object v3

    .line 628
    .local v3, "section":Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;
    sget-object v4, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Department:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-ne v3, v4, :cond_1

    .line 630
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mResources:Landroid/content/res/Resources;

    sget v5, Lcom/amazon/retailsearch/R$string;->select_department:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->setLabel(Ljava/lang/String;)V

    .line 631
    const-string/jumbo v4, "dept"

    invoke-virtual {v2, v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->setId(Ljava/lang/String;)V

    .line 660
    :cond_0
    :goto_0
    return-object v2

    .line 633
    :cond_1
    sget-object v4, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Sort:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-ne v3, v4, :cond_2

    .line 635
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mResources:Landroid/content/res/Resources;

    sget v5, Lcom/amazon/retailsearch/R$string;->refine_sort:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->setLabel(Ljava/lang/String;)V

    .line 636
    const-string/jumbo v4, "sort"

    invoke-virtual {v2, v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->setId(Ljava/lang/String;)V

    goto :goto_0

    .line 638
    :cond_2
    sget-object v4, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->PrioritizedFilter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-ne v3, v4, :cond_3

    .line 640
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mPrioritizedFilters:Ljava/util/List;

    invoke-interface {v4, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;

    .line 641
    .local v0, "filter":Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;->getLabel()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->setLabel(Ljava/lang/String;)V

    .line 642
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->setId(Ljava/lang/String;)V

    .line 643
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;->getType()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->setType(Ljava/lang/String;)V

    .line 644
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;->getDetail()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->setDetail(Ljava/lang/String;)V

    goto :goto_0

    .line 646
    .end local v0    # "filter":Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;
    :cond_3
    sget-object v4, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Filter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-ne v3, v4, :cond_4

    .line 648
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->filterOffset()I

    move-result v4

    sub-int v1, p1, v4

    .line 649
    .local v1, "idx":I
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mFilters:Ljava/util/List;

    invoke-interface {v4, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;

    .line 650
    .restart local v0    # "filter":Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;->getLabel()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->setLabel(Ljava/lang/String;)V

    .line 651
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->setId(Ljava/lang/String;)V

    .line 652
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;->getType()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->setType(Ljava/lang/String;)V

    .line 653
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;->getDetail()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->setDetail(Ljava/lang/String;)V

    goto :goto_0

    .line 655
    .end local v0    # "filter":Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;
    .end local v1    # "idx":I
    :cond_4
    sget-object v4, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->SeeMore:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-ne v3, v4, :cond_0

    .line 657
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mResources:Landroid/content/res/Resources;

    sget v5, Lcom/amazon/retailsearch/R$string;->rs_refinement_menu_see_more_filters:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->setLabel(Ljava/lang/String;)V

    .line 658
    const-string/jumbo v4, "seeMoreFilters"

    invoke-virtual {v2, v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->setId(Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method public getGroupPosition(Ljava/lang/String;)I
    .locals 5
    .param p1, "refinementItemId"    # Ljava/lang/String;

    .prologue
    const/4 v3, -0x1

    .line 416
    if-nez p1, :cond_1

    move v2, v3

    .line 456
    :cond_0
    :goto_0
    return v2

    .line 420
    :cond_1
    const-string/jumbo v4, "dept"

    invoke-virtual {v4, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 422
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mPrioritizedFilters:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    add-int/lit8 v2, v3, 0x0

    goto :goto_0

    .line 424
    :cond_2
    const-string/jumbo v4, "sort"

    invoke-virtual {v4, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 426
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mPrioritizedFilters:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    add-int/lit8 v2, v3, 0x1

    goto :goto_0

    .line 428
    :cond_3
    const-string/jumbo v4, "seeMoreFilters"

    invoke-virtual {v4, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 430
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getGroupCount()I

    move-result v3

    add-int/lit8 v2, v3, -0x1

    goto :goto_0

    .line 435
    :cond_4
    const/4 v2, 0x0

    .line 436
    .local v2, "pos":I
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mPrioritizedFilters:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_5

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;

    .line 438
    .local v0, "filter":Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;
    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getRefinementID(Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 442
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 446
    .end local v0    # "filter":Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;
    :cond_5
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->filterOffset()I

    move-result v2

    .line 447
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mFilters:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_6

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;

    .line 449
    .restart local v0    # "filter":Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;
    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getRefinementID(Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 453
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    .end local v0    # "filter":Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;
    :cond_6
    move v2, v3

    .line 456
    goto :goto_0
.end method

.method public getGroupView(IZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 10
    .param p1, "groupPosition"    # I
    .param p2, "isExpanded"    # Z
    .param p3, "convertView"    # Landroid/view/View;
    .param p4, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 502
    move-object v6, p3

    .line 503
    .local v6, "view":Landroid/view/View;
    if-nez v6, :cond_0

    .line 505
    invoke-virtual {p4}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v7

    sget v8, Lcom/amazon/retailsearch/R$layout;->refinements_group:I

    const/4 v9, 0x0

    invoke-static {v7, v8, v9}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v6

    .line 507
    :cond_0
    sget v7, Lcom/amazon/retailsearch/R$id;->rs_refinement_label:I

    invoke-static {v6, v7}, Lcom/amazon/retailsearch/android/ui/ViewHolder;->get(Landroid/view/View;I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 508
    .local v2, "labelView":Landroid/widget/TextView;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getGroupItem(I)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;

    move-result-object v0

    .line 510
    .local v0, "groupItem":Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;
    new-instance v5, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    iget-object v7, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mContext:Landroid/content/Context;

    invoke-direct {v5, v7}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;-><init>(Landroid/content/Context;)V

    .line 511
    .local v5, "sss":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->getLabel()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v5, v7}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/CharSequence;)Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    .line 512
    invoke-virtual {v2, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 514
    sget v7, Lcom/amazon/retailsearch/R$id;->rs_refinement_selected_label:I

    invoke-static {v6, v7}, Lcom/amazon/retailsearch/android/ui/ViewHolder;->get(Landroid/view/View;I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 515
    .local v4, "selectedView":Landroid/widget/TextView;
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getSelectedLabelText(I)Ljava/lang/String;

    move-result-object v3

    .line 516
    .local v3, "selectedText":Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v7

    if-nez v7, :cond_1

    .line 518
    invoke-virtual {v4, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 519
    const/4 v7, 0x0

    iget-object v8, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v8}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/amazon/retailsearch/R$dimen;->rs_refinement_menu_text_size_subheader:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v8

    int-to-float v8, v8

    invoke-virtual {v4, v7, v8}, Landroid/widget/TextView;->setTextSize(IF)V

    .line 520
    iget-object v7, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v7}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/amazon/retailsearch/R$color;->rs_refinement_black:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getColor(I)I

    move-result v7

    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setTextColor(I)V

    .line 521
    const/4 v7, 0x0

    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 528
    :goto_0
    sget-object v7, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->SeeMore:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getGroupSection(I)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    move-result-object v8

    if-ne v7, v8, :cond_2

    .line 530
    const/4 v7, 0x0

    iget-object v8, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v8}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/amazon/retailsearch/R$dimen;->rs_refinement_menu_text_size_subheader:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v8

    int-to-float v8, v8

    invoke-virtual {v2, v7, v8}, Landroid/widget/TextView;->setTextSize(IF)V

    .line 531
    iget-object v7, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v7}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/amazon/retailsearch/R$color;->rs_refinement_blue:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getColor(I)I

    move-result v7

    invoke-virtual {v2, v7}, Landroid/widget/TextView;->setTextColor(I)V

    .line 532
    invoke-virtual {v2}, Landroid/widget/TextView;->getTypeface()Landroid/graphics/Typeface;

    move-result-object v7

    const/4 v8, 0x0

    invoke-virtual {v2, v7, v8}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 555
    :goto_1
    sget v7, Lcom/amazon/retailsearch/R$id;->rs_refinements_group_indicator:I

    invoke-virtual {v6, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 556
    .local v1, "indicator":Landroid/widget/ImageView;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getChildrenCount(I)I

    move-result v7

    if-gtz v7, :cond_4

    .line 558
    const/16 v7, 0x8

    invoke-virtual {v1, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 573
    :goto_2
    return-object v6

    .line 525
    .end local v1    # "indicator":Landroid/widget/ImageView;
    :cond_1
    const/16 v7, 0x8

    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 536
    :cond_2
    const-string/jumbo v7, "Address"

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->getType()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 538
    const/4 v7, 0x0

    iget-object v8, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v8}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/amazon/retailsearch/R$dimen;->rs_refinement_menu_text_size_address:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v8

    int-to-float v8, v8

    invoke-virtual {v2, v7, v8}, Landroid/widget/TextView;->setTextSize(IF)V

    .line 539
    iget-object v7, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v7}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/amazon/retailsearch/R$color;->rs_refinement_black:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getColor(I)I

    move-result v7

    invoke-virtual {v2, v7}, Landroid/widget/TextView;->setTextColor(I)V

    .line 540
    invoke-virtual {v2}, Landroid/widget/TextView;->getTypeface()Landroid/graphics/Typeface;

    move-result-object v7

    const/4 v8, 0x1

    invoke-virtual {v2, v7, v8}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 542
    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->getDetail()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 543
    const/4 v7, 0x0

    iget-object v8, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v8}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/amazon/retailsearch/R$dimen;->rs_refinement_menu_text_size_address:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v8

    int-to-float v8, v8

    invoke-virtual {v4, v7, v8}, Landroid/widget/TextView;->setTextSize(IF)V

    .line 544
    iget-object v7, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v7}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/amazon/retailsearch/R$color;->rs_refinement_blue:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getColor(I)I

    move-result v7

    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setTextColor(I)V

    .line 545
    const/4 v7, 0x0

    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1

    .line 549
    :cond_3
    const/4 v7, 0x0

    iget-object v8, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v8}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/amazon/retailsearch/R$dimen;->rs_refinement_menu_text_size_header:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v8

    int-to-float v8, v8

    invoke-virtual {v2, v7, v8}, Landroid/widget/TextView;->setTextSize(IF)V

    .line 550
    iget-object v7, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v7}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/amazon/retailsearch/R$color;->rs_refinement_group_header:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getColor(I)I

    move-result v7

    invoke-virtual {v2, v7}, Landroid/widget/TextView;->setTextColor(I)V

    .line 551
    invoke-virtual {v2}, Landroid/widget/TextView;->getTypeface()Landroid/graphics/Typeface;

    move-result-object v7

    const/4 v8, 0x1

    invoke-virtual {v2, v7, v8}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    goto/16 :goto_1

    .line 562
    .restart local v1    # "indicator":Landroid/widget/ImageView;
    :cond_4
    const/4 v7, 0x0

    invoke-virtual {v1, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 563
    if-eqz p2, :cond_5

    .line 565
    iget-object v7, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v7}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/amazon/retailsearch/R$drawable;->rs_arrow_up:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v7

    invoke-virtual {v1, v7}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto/16 :goto_2

    .line 569
    :cond_5
    iget-object v7, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v7}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/amazon/retailsearch/R$drawable;->rs_arrow_down:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v7

    invoke-virtual {v1, v7}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto/16 :goto_2
.end method

.method public getRealChildView(IIZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 13
    .param p1, "groupPosition"    # I
    .param p2, "childPosition"    # I
    .param p3, "isLastChild"    # Z
    .param p4, "convertView"    # Landroid/view/View;
    .param p5, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 234
    move-object/from16 v8, p4

    .line 235
    .local v8, "view":Landroid/view/View;
    if-nez v8, :cond_0

    .line 237
    invoke-virtual/range {p5 .. p5}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v9

    sget v10, Lcom/amazon/retailsearch/R$layout;->refinements_child:I

    const/4 v11, 0x0

    invoke-static {v9, v10, v11}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v8

    .line 240
    :cond_0
    sget v9, Lcom/amazon/retailsearch/R$id;->rs_refinements_child_label:I

    invoke-static {v8, v9}, Lcom/amazon/retailsearch/android/ui/ViewHolder;->get(Landroid/view/View;I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 241
    .local v3, "refinementLabel":Landroid/widget/TextView;
    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mResources:Landroid/content/res/Resources;

    sget v10, Lcom/amazon/retailsearch/R$dimen;->pc_18px:I

    invoke-virtual {v9, v10}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v9

    const/4 v10, 0x0

    const/4 v11, 0x0

    const/4 v12, 0x0

    invoke-virtual {v3, v9, v10, v11, v12}, Landroid/widget/TextView;->setPadding(IIII)V

    .line 242
    sget v9, Lcom/amazon/retailsearch/R$id;->rs_refinements_child_indicator:I

    invoke-static {v8, v9}, Lcom/amazon/retailsearch/android/ui/ViewHolder;->get(Landroid/view/View;I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    .line 243
    .local v2, "indicator":Landroid/widget/ImageView;
    const/16 v9, 0x8

    invoke-virtual {v2, v9}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 244
    const/4 v6, 0x0

    .line 245
    .local v6, "selected":Z
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getGroupSection(I)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    move-result-object v5

    .line 247
    .local v5, "section":Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;
    sget-object v9, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Department:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-ne v5, v9, :cond_2

    .line 249
    invoke-virtual {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

    .line 250
    .local v0, "department":Lcom/amazon/searchapp/retailsearch/model/RefinementLink;
    if-eqz v0, :cond_1

    .line 252
    invoke-direct {p0, v0, p2, v3}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->setDepartmentChildView(Lcom/amazon/searchapp/retailsearch/model/RefinementLink;ILandroid/widget/TextView;)V

    .line 253
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;->getSelected()Z

    move-result v6

    .line 289
    .end local v0    # "department":Lcom/amazon/searchapp/retailsearch/model/RefinementLink;
    :cond_1
    :goto_0
    if-eqz v6, :cond_9

    .line 291
    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mResources:Landroid/content/res/Resources;

    sget v10, Lcom/amazon/retailsearch/R$color;->rs_refinement_child_text_selected:I

    invoke-virtual {v9, v10}, Landroid/content/res/Resources;->getColor(I)I

    move-result v9

    invoke-virtual {v3, v9}, Landroid/widget/TextView;->setTextColor(I)V

    .line 292
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string/jumbo v10, ". "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    iget-object v10, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mResources:Landroid/content/res/Resources;

    sget v11, Lcom/amazon/retailsearch/R$string;->refine_selected:I

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v3, v9}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 308
    :goto_1
    return-object v8

    .line 256
    :cond_2
    sget-object v9, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Filter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-eq v5, v9, :cond_3

    sget-object v9, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->PrioritizedFilter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-ne v5, v9, :cond_7

    .line 258
    :cond_3
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getGroup(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;

    .line 259
    .local v1, "filter":Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getChild(II)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

    .line 260
    .local v4, "refinementLink":Lcom/amazon/searchapp/retailsearch/model/RefinementLink;
    if-eqz v4, :cond_1

    .line 262
    invoke-interface {v4}, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;->getSelected()Z

    move-result v6

    .line 263
    invoke-direct {p0, v3, v4}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getFilterMessage(Landroid/widget/TextView;Lcom/amazon/searchapp/retailsearch/model/RefinementLink;)Landroid/text/SpannableStringBuilder;

    move-result-object v9

    invoke-virtual {v3, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 264
    const-string/jumbo v9, "MultiSelectOR"

    invoke-interface {v1}, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;->getType()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    if-eqz v9, :cond_5

    .line 266
    const/4 v9, 0x0

    invoke-virtual {v2, v9}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 267
    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v9}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    if-eqz v6, :cond_4

    sget v9, Lcom/amazon/retailsearch/R$drawable;->rs_checkbox_filled:I

    :goto_2
    invoke-virtual {v10, v9}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v9

    invoke-virtual {v2, v9}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    :cond_4
    sget v9, Lcom/amazon/retailsearch/R$drawable;->rs_checkbox:I

    goto :goto_2

    .line 272
    :cond_5
    const/4 v9, 0x0

    invoke-virtual {v2, v9}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 273
    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v9}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    if-eqz v6, :cond_6

    sget v9, Lcom/amazon/retailsearch/R$drawable;->rs_radiobox_filled:I

    :goto_3
    invoke-virtual {v10, v9}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v9

    invoke-virtual {v2, v9}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    goto/16 :goto_0

    :cond_6
    sget v9, Lcom/amazon/retailsearch/R$drawable;->rs_radiobox:I

    goto :goto_3

    .line 278
    .end local v1    # "filter":Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;
    .end local v4    # "refinementLink":Lcom/amazon/searchapp/retailsearch/model/RefinementLink;
    :cond_7
    sget-object v9, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Sort:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-ne v5, v9, :cond_8

    .line 280
    invoke-virtual {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getChild(II)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/amazon/searchapp/retailsearch/model/SelectedOption;

    .line 281
    .local v7, "selectedOption":Lcom/amazon/searchapp/retailsearch/model/SelectedOption;
    invoke-interface {v7}, Lcom/amazon/searchapp/retailsearch/model/SelectedOption;->getSelected()Z

    move-result v6

    .line 282
    invoke-interface {v7}, Lcom/amazon/searchapp/retailsearch/model/SelectedOption;->getLink()Lcom/amazon/searchapp/retailsearch/model/Link;

    move-result-object v9

    invoke-interface {v9}, Lcom/amazon/searchapp/retailsearch/model/Link;->getText()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v3, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 286
    .end local v7    # "selectedOption":Lcom/amazon/searchapp/retailsearch/model/SelectedOption;
    :cond_8
    const-string/jumbo v9, ""

    invoke-virtual {v3, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 295
    :cond_9
    invoke-virtual {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->isChildSelectable(II)Z

    move-result v9

    if-nez v9, :cond_a

    .line 297
    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mResources:Landroid/content/res/Resources;

    sget v10, Lcom/amazon/retailsearch/R$color;->rs_refinement_gray:I

    invoke-virtual {v9, v10}, Landroid/content/res/Resources;->getColor(I)I

    move-result v9

    invoke-virtual {v3, v9}, Landroid/widget/TextView;->setTextColor(I)V

    .line 298
    const/16 v9, 0x8

    invoke-virtual {v2, v9}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 299
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string/jumbo v10, ". "

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    iget-object v10, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mResources:Landroid/content/res/Resources;

    sget v11, Lcom/amazon/retailsearch/R$string;->refine_disabled:I

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v3, v9}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    goto/16 :goto_1

    .line 304
    :cond_a
    iget-object v9, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mResources:Landroid/content/res/Resources;

    sget v10, Lcom/amazon/retailsearch/R$color;->rs_refinement_black:I

    invoke-virtual {v9, v10}, Landroid/content/res/Resources;->getColor(I)I

    move-result v9

    invoke-virtual {v3, v9}, Landroid/widget/TextView;->setTextColor(I)V

    .line 305
    invoke-virtual {v3}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v9

    invoke-virtual {v3, v9}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    goto/16 :goto_1
.end method

.method public getRealChildrenCount(I)I
    .locals 5
    .param p1, "groupPosition"    # I

    .prologue
    .line 314
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getGroupSection(I)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    move-result-object v2

    .line 315
    .local v2, "section":Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;
    sget-object v3, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Department:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-ne v2, v3, :cond_2

    .line 317
    const/4 v1, 0x0

    .line 318
    .local v1, "numDepartments":I
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mDepartment:Lcom/amazon/searchapp/retailsearch/model/Department;

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/Department;->getCategories()Ljava/util/List;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 320
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mDepartment:Lcom/amazon/searchapp/retailsearch/model/Department;

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/Department;->getCategories()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    add-int/2addr v1, v3

    .line 322
    :cond_0
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mDepartment:Lcom/amazon/searchapp/retailsearch/model/Department;

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/Department;->getAncestry()Ljava/util/List;

    move-result-object v3

    if-eqz v3, :cond_1

    .line 324
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mDepartment:Lcom/amazon/searchapp/retailsearch/model/Department;

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/Department;->getAncestry()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    add-int/2addr v1, v3

    .line 345
    .end local v1    # "numDepartments":I
    :cond_1
    :goto_0
    return v1

    .line 328
    :cond_2
    sget-object v3, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Sort:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-ne v2, v3, :cond_3

    .line 330
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mSort:Lcom/amazon/searchapp/retailsearch/model/Sort;

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/Sort;->getOptions()Ljava/util/List;

    move-result-object v3

    if-eqz v3, :cond_5

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mSort:Lcom/amazon/searchapp/retailsearch/model/Sort;

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/Sort;->getOptions()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-eqz v3, :cond_5

    .line 332
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mSort:Lcom/amazon/searchapp/retailsearch/model/Sort;

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/Sort;->getOptions()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v1

    goto :goto_0

    .line 335
    :cond_3
    sget-object v3, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->PrioritizedFilter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-ne v2, v3, :cond_4

    .line 337
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mPrioritizedFilters:Ljava/util/List;

    invoke-interface {v3, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;

    .line 338
    .local v0, "filter":Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;
    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getFilterSize(Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;)I

    move-result v1

    goto :goto_0

    .line 340
    .end local v0    # "filter":Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;
    :cond_4
    sget-object v3, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Filter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-ne v2, v3, :cond_5

    .line 342
    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->mFilters:Ljava/util/List;

    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->filterOffset()I

    move-result v4

    sub-int v4, p1, v4

    invoke-interface {v3, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;

    .line 343
    .restart local v0    # "filter":Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;
    invoke-direct {p0, v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getFilterSize(Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;)I

    move-result v1

    goto :goto_0

    .line 345
    .end local v0    # "filter":Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;
    :cond_5
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public hasStableIds()Z
    .locals 1

    .prologue
    .line 579
    const/4 v0, 0x1

    return v0
.end method

.method public isAddressInfo(I)Z
    .locals 3
    .param p1, "groupPosition"    # I

    .prologue
    .line 832
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getGroupItem(I)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;

    move-result-object v0

    .line 833
    .local v0, "groupItem":Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;
    if-eqz v0, :cond_0

    const-string/jumbo v1, "Address"

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$RefinementItem;->getType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public isChildSelectable(II)Z
    .locals 9
    .param p1, "groupPosition"    # I
    .param p2, "childPosition"    # I

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 585
    invoke-virtual {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getChildId(II)J

    move-result-wide v1

    .line 586
    .local v1, "childId":J
    const-wide/16 v7, 0x3

    cmp-long v7, v1, v7

    if-nez v7, :cond_6

    .line 588
    invoke-virtual {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;

    .line 589
    .local v0, "child":Lcom/amazon/searchapp/retailsearch/model/RefinementLink;
    if-eqz v0, :cond_0

    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;->getUrl()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 606
    .end local v0    # "child":Lcom/amazon/searchapp/retailsearch/model/RefinementLink;
    :cond_0
    :goto_0
    return v5

    .line 593
    .restart local v0    # "child":Lcom/amazon/searchapp/retailsearch/model/RefinementLink;
    :cond_1
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getGroupSection(I)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    move-result-object v4

    .line 594
    .local v4, "section":Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;
    sget-object v7, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->Filter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-eq v4, v7, :cond_2

    sget-object v7, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->PrioritizedFilter:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    if-ne v4, v7, :cond_4

    .line 596
    :cond_2
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getGroup(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;

    .line 597
    .local v3, "group":Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;->getSelected()Z

    move-result v7

    if-eqz v7, :cond_3

    const-string/jumbo v7, "MultiSelectOR"

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;->getType()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_0

    :cond_3
    move v5, v6

    goto :goto_0

    .line 599
    .end local v3    # "group":Lcom/amazon/searchapp/retailsearch/model/RefinementFilter;
    :cond_4
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/RefinementLink;->getSelected()Z

    move-result v7

    if-nez v7, :cond_5

    :goto_1
    move v5, v6

    goto :goto_0

    :cond_5
    move v6, v5

    goto :goto_1

    .line 601
    .end local v0    # "child":Lcom/amazon/searchapp/retailsearch/model/RefinementLink;
    .end local v4    # "section":Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;
    :cond_6
    const-wide/16 v7, 0x4

    cmp-long v7, v1, v7

    if-nez v7, :cond_0

    .line 603
    invoke-virtual {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/searchapp/retailsearch/model/SelectedOption;

    .line 604
    .local v0, "child":Lcom/amazon/searchapp/retailsearch/model/SelectedOption;
    invoke-interface {v0}, Lcom/amazon/searchapp/retailsearch/model/SelectedOption;->getSelected()Z

    move-result v7

    if-nez v7, :cond_7

    :goto_2
    move v5, v6

    goto :goto_0

    :cond_7
    move v6, v5

    goto :goto_2
.end method

.method public isFilterGroup(Ljava/lang/String;)Z
    .locals 1
    .param p1, "groupItemId"    # Ljava/lang/String;

    .prologue
    .line 843
    if-eqz p1, :cond_0

    const-string/jumbo v0, "dept"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "sort"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "seeMoreFilters"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isGroupSeeMoreLink(I)Z
    .locals 2
    .param p1, "groupPosition"    # I

    .prologue
    .line 822
    sget-object v0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;->SeeMore:Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter;->getGroupSection(I)Lcom/amazon/retailsearch/android/ui/refinements/RefinementsAdapter$GroupSection;

    move-result-object v1

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
