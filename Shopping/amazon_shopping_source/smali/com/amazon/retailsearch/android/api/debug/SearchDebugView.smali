.class public Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;
.super Landroid/widget/LinearLayout;
.source "SearchDebugView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/api/debug/SearchDebugView$1;,
        Lcom/amazon/retailsearch/android/api/debug/SearchDebugView$SearchDebugOnCheckedChangeListener;
    }
.end annotation


# instance fields
.field private final envUrl:Landroid/widget/TextView;

.field private final info:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 33
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 34
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;->setOrientation(I)V

    .line 35
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v2, -0x1

    const/4 v3, -0x2

    invoke-direct {v1, v2, v3}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 37
    sget v1, Lcom/amazon/retailsearch/R$layout;->rs_debug_settings:I

    invoke-static {p1, v1, p0}, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 38
    sget v1, Lcom/amazon/retailsearch/R$id;->retail_search_env_url:I

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;->envUrl:Landroid/widget/TextView;

    .line 39
    sget v1, Lcom/amazon/retailsearch/R$id;->retail_search_debug_info_line:I

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;->info:Landroid/widget/TextView;

    .line 40
    sget v1, Lcom/amazon/retailsearch/R$id;->retail_search_env_group:I

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RadioGroup;

    .line 41
    .local v0, "envGroup":Landroid/widget/RadioGroup;
    new-instance v1, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView$SearchDebugOnCheckedChangeListener;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView$SearchDebugOnCheckedChangeListener;-><init>(Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;Lcom/amazon/retailsearch/android/api/debug/SearchDebugView$1;)V

    invoke-virtual {v0, v1}, Landroid/widget/RadioGroup;->setOnCheckedChangeListener(Landroid/widget/RadioGroup$OnCheckedChangeListener;)V

    .line 42
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;->info:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/retailsearch/android/api/debug/SearchDebugView;->envUrl:Landroid/widget/TextView;

    return-object v0
.end method
