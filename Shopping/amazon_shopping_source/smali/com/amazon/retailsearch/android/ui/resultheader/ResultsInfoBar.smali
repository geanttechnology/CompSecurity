.class public Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;
.super Landroid/widget/LinearLayout;
.source "ResultsInfoBar.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$HeaderSearchTaskListener;
    }
.end annotation


# instance fields
.field private breadcrumb:Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;

.field private count:J

.field private countView:Landroid/widget/TextView;

.field private department:Ljava/lang/String;

.field private departmentView:Landroid/widget/TextView;

.field featureConfig:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private filterView:Landroid/widget/TextView;

.field private filtersCount:J

.field private hasMetadata:Z

.field private hasRefinements:Z

.field headerBarView:Landroid/view/View;

.field private listener:Lcom/amazon/retailsearch/android/ui/resultheader/IHeaderContentListener;

.field preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field

.field private refinementMenu:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

.field private resultsCountLabel:Ljava/lang/String;

.field private retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

.field private searchTaskListener:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$HeaderSearchTaskListener;

.field private showDepartment:Z

.field private viewSelector:Lcom/amazon/retailsearch/android/ui/results/ViewSelector;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 82
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 74
    invoke-static {}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getInstance()Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getRetailSearchLogger()Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    .line 83
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->init()V

    .line 84
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 88
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 74
    invoke-static {}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getInstance()Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getRetailSearchLogger()Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    .line 89
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->init()V

    .line 90
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->filterView:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;Landroid/support/v4/app/FragmentActivity;Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;
    .param p1, "x1"    # Landroid/support/v4/app/FragmentActivity;
    .param p2, "x2"    # Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;

    .prologue
    .line 44
    invoke-direct {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->showRefinementDialog(Landroid/support/v4/app/FragmentActivity;Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;)V

    return-void
.end method

.method static synthetic access$300(Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;Landroid/app/Activity;Lcom/amazon/retailsearch/popup/PopupDialogFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;
    .param p1, "x1"    # Landroid/app/Activity;
    .param p2, "x2"    # Lcom/amazon/retailsearch/popup/PopupDialogFragment;

    .prologue
    .line 44
    invoke-direct {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->showRefinementDialog(Landroid/app/Activity;Lcom/amazon/retailsearch/popup/PopupDialogFragment;)V

    return-void
.end method

.method static synthetic access$400(Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;)Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;

    .prologue
    .line 44
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->hasMetadata:Z

    return v0
.end method

.method static synthetic access$502(Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;
    .param p1, "x1"    # Z

    .prologue
    .line 44
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->hasMetadata:Z

    return p1
.end method

.method private buildDepartmentLabel(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 268
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->showDepartment:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->department:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 270
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->departmentView:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 277
    :goto_0
    return-void

    .line 274
    :cond_1
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->departmentView:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->department:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 275
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->departmentView:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method private buildFilterLabel(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 286
    new-instance v0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;-><init>(Landroid/content/Context;)V

    .line 287
    .local v0, "text":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/retailsearch/R$string;->refine_filter:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    sget v2, Lcom/amazon/retailsearch/R$style;->Rs_Header_Filter:I

    invoke-virtual {v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/String;I)V

    .line 288
    iget-wide v1, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->filtersCount:J

    const-wide/16 v3, 0x0

    cmp-long v1, v1, v3

    if-lez v1, :cond_0

    .line 290
    const-string/jumbo v1, " ("

    sget v2, Lcom/amazon/retailsearch/R$style;->Rs_Header_Filter:I

    invoke-virtual {v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/String;I)V

    .line 291
    iget-wide v1, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->filtersCount:J

    invoke-static {v1, v2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    sget v2, Lcom/amazon/retailsearch/R$style;->Rs_Header_Filter_Count:I

    invoke-virtual {v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/String;I)V

    .line 292
    const-string/jumbo v1, ")"

    sget v2, Lcom/amazon/retailsearch/R$style;->Rs_Header_Filter:I

    invoke-virtual {v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/String;I)V

    .line 294
    :cond_0
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->filterView:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 295
    return-void
.end method

.method private buildRefinements(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->filterView:Landroid/widget/TextView;

    new-instance v1, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$1;

    invoke-direct {v1, p0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$1;-><init>(Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;)V

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 152
    return-void
.end method

.method private buildResultCountLabel(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 245
    iget-wide v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->count:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->resultsCountLabel:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 247
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->countView:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->resultsCountLabel:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 250
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->countView:Landroid/widget/TextView;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setSingleLine(Z)V

    .line 251
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->countView:Landroid/widget/TextView;

    sget-object v1, Landroid/text/TextUtils$TruncateAt;->END:Landroid/text/TextUtils$TruncateAt;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V

    .line 252
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->countView:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 258
    :goto_0
    return-void

    .line 256
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->countView:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method private init()V
    .locals 3

    .prologue
    .line 94
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 95
    new-instance v0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBarContentListener;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBarContentListener;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->listener:Lcom/amazon/retailsearch/android/ui/resultheader/IHeaderContentListener;

    .line 96
    new-instance v0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$HeaderSearchTaskListener;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$HeaderSearchTaskListener;-><init>(Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$1;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->searchTaskListener:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$HeaderSearchTaskListener;

    .line 98
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$layout;->refinements_menu:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, p0, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->refinementMenu:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    .line 101
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->refinementMenu:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->listener:Lcom/amazon/retailsearch/android/ui/resultheader/IHeaderContentListener;

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->setListener(Lcom/amazon/retailsearch/android/ui/refinements/IRefinementsMenuListener;)V

    .line 102
    return-void
.end method

.method private showRefinementDialog(Landroid/app/Activity;Lcom/amazon/retailsearch/popup/PopupDialogFragment;)V
    .locals 11
    .param p1, "context"    # Landroid/app/Activity;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/amazon/retailsearch/popup/PopupDialogFragment",
            "<",
            "Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 161
    .local p2, "dialog":Lcom/amazon/retailsearch/popup/PopupDialogFragment;, "Lcom/amazon/retailsearch/popup/PopupDialogFragment<Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;>;"
    invoke-virtual {p1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$dimen;->rs_refinement_menu_popup_shadow_padding_left:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v9

    .line 164
    .local v9, "shadowPadding":I
    invoke-virtual {p1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$dimen;->rs_refinement_menu_popup_width:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v7

    .line 167
    .local v7, "width":I
    invoke-virtual {p1}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    sget v2, Lcom/amazon/retailsearch/R$id;->rs_filter_header_label:I

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->refinementMenu:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    sget-object v4, Lcom/amazon/retailsearch/popup/Position;->BELOW_LEFT:Lcom/amazon/retailsearch/popup/Position;

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->filterView:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getPaddingLeft()I

    move-result v0

    sub-int v5, v0, v9

    const/4 v6, 0x0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->refinementMenu:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->getDialogHeight()I

    move-result v8

    move-object v0, p2

    invoke-virtual/range {v0 .. v8}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->show(Landroid/app/FragmentManager;ILandroid/view/View;Lcom/amazon/retailsearch/popup/Position;IIII)V

    .line 179
    new-instance v0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$2;

    invoke-direct {v0, p0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$2;-><init>(Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;)V

    invoke-virtual {p2, v0}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->setOnCloseListener(Lcom/amazon/retailsearch/popup/PopupDialogFragment$OnCloseListener;)V

    .line 188
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->getViewType()Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-result-object v10

    .line 189
    .local v10, "viewType":Lcom/amazon/retailsearch/android/ui/results/ViewType;
    if-nez v10, :cond_0

    .line 194
    :goto_0
    return-void

    .line 193
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    invoke-virtual {v10}, Lcom/amazon/retailsearch/android/ui/results/ViewType;->name()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->filterMenuInvoked(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private showRefinementDialog(Landroid/support/v4/app/FragmentActivity;Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;)V
    .locals 11
    .param p1, "context"    # Landroid/support/v4/app/FragmentActivity;
    .param p2, "dialog"    # Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;

    .prologue
    .line 203
    invoke-virtual {p1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$dimen;->rs_refinement_menu_popup_shadow_padding_left:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v9

    .line 206
    .local v9, "shadowPadding":I
    invoke-virtual {p1}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$dimen;->rs_refinement_menu_popup_width:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v7

    .line 209
    .local v7, "width":I
    invoke-virtual {p1}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    sget v2, Lcom/amazon/retailsearch/R$id;->rs_filter_header_label:I

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->refinementMenu:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    sget-object v4, Lcom/amazon/retailsearch/popup/Position;->BELOW_LEFT:Lcom/amazon/retailsearch/popup/Position;

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->filterView:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getPaddingLeft()I

    move-result v0

    sub-int v5, v0, v9

    const/4 v6, 0x0

    const/4 v8, -0x1

    move-object v0, p2

    invoke-virtual/range {v0 .. v8}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->show(Landroid/support/v4/app/FragmentManager;ILandroid/view/View;Lcom/amazon/retailsearch/popup/Position;IIII)V

    .line 221
    new-instance v0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$3;

    invoke-direct {v0, p0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$3;-><init>(Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;)V

    invoke-virtual {p2, v0}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->setOnCloseListener(Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$OnCloseListener;)V

    .line 230
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->preferencesManager:Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/userpreferences/UserPreferenceManager;->getViewType()Lcom/amazon/retailsearch/android/ui/results/ViewType;

    move-result-object v10

    .line 231
    .local v10, "viewType":Lcom/amazon/retailsearch/android/ui/results/ViewType;
    if-nez v10, :cond_0

    .line 236
    :goto_0
    return-void

    .line 235
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    invoke-virtual {v10}, Lcom/amazon/retailsearch/android/ui/results/ViewType;->name()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->filterMenuInvoked(Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method public clearAll()V
    .locals 5

    .prologue
    const-wide/16 v3, 0x0

    const/4 v0, 0x0

    const/4 v2, 0x0

    .line 408
    iput-wide v3, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->count:J

    .line 409
    iput-object v2, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->resultsCountLabel:Ljava/lang/String;

    .line 410
    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->hasMetadata:Z

    .line 411
    iput-wide v3, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->filtersCount:J

    .line 412
    iput-object v2, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->breadcrumb:Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;

    .line 413
    iput-object v2, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->department:Ljava/lang/String;

    .line 414
    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->hasRefinements:Z

    .line 415
    invoke-direct {p0, p0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->buildResultCountLabel(Landroid/view/View;)V

    .line 416
    invoke-direct {p0, p0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->buildFilterLabel(Landroid/view/View;)V

    .line 417
    invoke-direct {p0, p0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->buildDepartmentLabel(Landroid/view/View;)V

    .line 419
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->viewSelector:Lcom/amazon/retailsearch/android/ui/results/ViewSelector;

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->featureConfig:Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;

    invoke-static {v0, v1}, Lcom/amazon/retailsearch/experiment/DisplaySettingsUtil;->displaySettingsEnabled(Landroid/content/res/Resources;Lcom/amazon/retailsearch/android/api/experimentation/FeatureConfiguration;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 421
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->viewSelector:Lcom/amazon/retailsearch/android/ui/results/ViewSelector;

    invoke-interface {v0, v2}, Lcom/amazon/retailsearch/android/ui/results/ViewSelector;->updateView(Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    .line 423
    :cond_0
    return-void
.end method

.method public getBreadcrumb()Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;
    .locals 1

    .prologue
    .line 339
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->breadcrumb:Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;

    return-object v0
.end method

.method public getCount()J
    .locals 2

    .prologue
    .line 302
    iget-wide v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->count:J

    return-wide v0
.end method

.method public getDepartment()Ljava/lang/String;
    .locals 1

    .prologue
    .line 321
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->department:Ljava/lang/String;

    return-object v0
.end method

.method public getSearchTaskListener()Lcom/amazon/retailsearch/data/SearchTask$SearchTaskListener;
    .locals 1

    .prologue
    .line 400
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->searchTaskListener:Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar$HeaderSearchTaskListener;

    return-object v0
.end method

.method public getViewSelector()Lcom/amazon/retailsearch/android/ui/results/ViewSelector;
    .locals 1

    .prologue
    .line 427
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->viewSelector:Lcom/amazon/retailsearch/android/ui/results/ViewSelector;

    return-object v0
.end method

.method public notifyRefinementsChanged()V
    .locals 1

    .prologue
    .line 395
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->refinementMenu:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->notifyRefinementsChanged()V

    .line 396
    return-void
.end method

.method protected onFinishInflate()V
    .locals 2

    .prologue
    .line 107
    invoke-super {p0}, Landroid/widget/LinearLayout;->onFinishInflate()V

    .line 108
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_department_label:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->departmentView:Landroid/widget/TextView;

    .line 109
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->departmentView:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getVisibility()I

    move-result v0

    const/16 v1, 0x8

    if-eq v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->showDepartment:Z

    .line 110
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_result_count_label:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->countView:Landroid/widget/TextView;

    .line 111
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_view_selector:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/android/ui/results/ViewSelector;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->viewSelector:Lcom/amazon/retailsearch/android/ui/results/ViewSelector;

    .line 112
    sget v0, Lcom/amazon/retailsearch/R$id;->rs_filter_header_label:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->filterView:Landroid/widget/TextView;

    .line 114
    invoke-direct {p0, p0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->buildDepartmentLabel(Landroid/view/View;)V

    .line 115
    invoke-direct {p0, p0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->buildResultCountLabel(Landroid/view/View;)V

    .line 117
    invoke-direct {p0, p0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->buildRefinements(Landroid/view/View;)V

    .line 118
    invoke-direct {p0, p0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->buildFilterLabel(Landroid/view/View;)V

    .line 119
    return-void

    .line 109
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setBreadcrumb(Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;)V
    .locals 0
    .param p1, "breadcrumb"    # Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;

    .prologue
    .line 348
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->breadcrumb:Lcom/amazon/searchapp/retailsearch/model/Breadcrumb;

    .line 349
    invoke-direct {p0, p0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->buildResultCountLabel(Landroid/view/View;)V

    .line 350
    return-void
.end method

.method public setCountAndLabel(JLjava/lang/String;)V
    .locals 0
    .param p1, "count"    # J
    .param p3, "resultsCountLabel"    # Ljava/lang/String;

    .prologue
    .line 311
    iput-wide p1, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->count:J

    .line 312
    iput-object p3, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->resultsCountLabel:Ljava/lang/String;

    .line 313
    invoke-direct {p0, p0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->buildResultCountLabel(Landroid/view/View;)V

    .line 314
    return-void
.end method

.method public setDepartment(Ljava/lang/String;)V
    .locals 0
    .param p1, "department"    # Ljava/lang/String;

    .prologue
    .line 330
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->department:Ljava/lang/String;

    .line 331
    invoke-direct {p0, p0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->buildDepartmentLabel(Landroid/view/View;)V

    .line 332
    return-void
.end method

.method public setRefinements(Lcom/amazon/searchapp/retailsearch/model/Refinements;)V
    .locals 2
    .param p1, "refinements"    # Lcom/amazon/searchapp/retailsearch/model/Refinements;

    .prologue
    .line 359
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->hasRefinements:Z

    if-eqz v0, :cond_0

    .line 378
    :goto_0
    return-void

    .line 363
    :cond_0
    if-nez p1, :cond_1

    .line 365
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->filterView:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 377
    :goto_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->hasRefinements:Z

    goto :goto_0

    .line 369
    :cond_1
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->refinementMenu:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->setRefinements(Lcom/amazon/searchapp/retailsearch/model/Refinements;)V

    .line 370
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->refinementMenu:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->getFiltersCount()I

    move-result v0

    int-to-long v0, v0

    iput-wide v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->filtersCount:J

    .line 371
    invoke-direct {p0, p0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->buildRefinements(Landroid/view/View;)V

    .line 372
    invoke-direct {p0, p0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->buildFilterLabel(Landroid/view/View;)V

    .line 373
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->notifyRefinementsChanged()V

    .line 374
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->filterView:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1
.end method

.method public setSort(Lcom/amazon/searchapp/retailsearch/model/Sort;)V
    .locals 1
    .param p1, "sort"    # Lcom/amazon/searchapp/retailsearch/model/Sort;

    .prologue
    .line 387
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/resultheader/ResultsInfoBar;->refinementMenu:Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/android/ui/refinements/RefinementMenu;->setSort(Lcom/amazon/searchapp/retailsearch/model/Sort;)V

    .line 388
    return-void
.end method
