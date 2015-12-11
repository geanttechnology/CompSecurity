.class public Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;
.super Ljava/lang/Object;
.source "ActionViewBuilder.java"


# static fields
.field public static final BARCODE_SEARCH_QUERY_KEYWORD:Ljava/lang/String; = "BARCODE_SEARCH_QUERY_KEYWORD"

.field public static final IMAGE_SEARCH_QUERY_KEYWORD:Ljava/lang/String; = "IMAGE_SEARCH_QUERY_KEYWORD"

.field public static final VOICE_SEARCH_QUERY_KEYWORD:Ljava/lang/String; = "VOICE_SEARCH_QUERY_KEYWORD"

.field private static final log:Lcom/amazon/retailsearch/log/MessageLogger;


# instance fields
.field private searchBoxLogger:Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

.field private final searchHandler:Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener",
            "<",
            "Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;",
            ">;"
        }
    .end annotation
.end field

.field showFlow:Z

.field showScan:Z

.field showSnap:Z

.field showVisualScan:Z

.field showVoice:Z

.field private final view:Landroid/widget/LinearLayout;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 43
    const-class v0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;

    invoke-static {v0}, Lcom/amazon/retailsearch/log/AppLog;->getLog(Ljava/lang/Class;)Lcom/amazon/retailsearch/log/MessageLogger;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    return-void
.end method

.method constructor <init>(Landroid/widget/LinearLayout;Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;)V
    .locals 1
    .param p1, "view"    # Landroid/widget/LinearLayout;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/LinearLayout;",
            "Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener",
            "<",
            "Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 51
    .local p2, "searchHandler":Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;, "Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener<Lcom/amazon/retailsearch/android/api/query/RetailSearchQuery;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    invoke-static {}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getInstance()Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getSearchBoxLogger()Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->searchBoxLogger:Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

    .line 52
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 53
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->view:Landroid/widget/LinearLayout;

    .line 54
    iput-object p2, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->searchHandler:Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;

    .line 55
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;)Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;

    .prologue
    .line 33
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->searchHandler:Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;)Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;

    .prologue
    .line 33
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->searchBoxLogger:Lcom/amazon/retailsearch/android/api/log/SearchBoxLogger;

    return-object v0
.end method

.method private addActionButton(IIILandroid/view/View$OnClickListener;I)V
    .locals 8
    .param p1, "imageId"    # I
    .param p2, "labelId"    # I
    .param p3, "descriptionId"    # I
    .param p4, "click"    # Landroid/view/View$OnClickListener;
    .param p5, "buttonCount"    # I

    .prologue
    const/4 v7, 0x1

    .line 181
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->view:Landroid/widget/LinearLayout;

    invoke-virtual {v4}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v4

    if-lez v4, :cond_0

    .line 183
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->view:Landroid/widget/LinearLayout;

    invoke-virtual {v4}, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;

    move-result-object v4

    sget v5, Lcom/amazon/retailsearch/R$layout;->rs_entry_action_divider:I

    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->view:Landroid/widget/LinearLayout;

    invoke-static {v4, v5, v6}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 186
    :cond_0
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->view:Landroid/widget/LinearLayout;

    invoke-virtual {v4}, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;

    move-result-object v4

    sget v5, Lcom/amazon/retailsearch/R$layout;->rs_entry_btn:I

    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->view:Landroid/widget/LinearLayout;

    invoke-static {v4, v5, v6}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 187
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->view:Landroid/widget/LinearLayout;

    iget-object v5, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->view:Landroid/widget/LinearLayout;

    invoke-virtual {v5}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v5

    add-int/lit8 v5, v5, -0x1

    invoke-virtual {v4, v5}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 188
    .local v0, "btn":Landroid/widget/LinearLayout;
    if-ne p5, v7, :cond_2

    const/4 v4, 0x3

    :goto_0
    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->setGravity(I)V

    .line 190
    sget v4, Lcom/amazon/retailsearch/R$id;->rs_entry_btn_img:I

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    .line 191
    .local v2, "image":Landroid/widget/ImageView;
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->view:Landroid/widget/LinearLayout;

    invoke-virtual {v4}, Landroid/widget/LinearLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4, p1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 193
    sget v4, Lcom/amazon/retailsearch/R$id;->rs_entry_btn_text:I

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 194
    .local v3, "text":Landroid/widget/TextView;
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->view:Landroid/widget/LinearLayout;

    invoke-virtual {v4}, Landroid/widget/LinearLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4, p2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 196
    if-lez p3, :cond_1

    if-ne p5, v7, :cond_1

    const-string/jumbo v4, "en"

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v5

    invoke-virtual {v5}, Ljava/util/Locale;->getLanguage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 197
    sget v4, Lcom/amazon/retailsearch/R$id;->rs_entry_btn_description:I

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 198
    .local v1, "description":Landroid/widget/TextView;
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->view:Landroid/widget/LinearLayout;

    invoke-virtual {v4}, Landroid/widget/LinearLayout;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4, p3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 199
    const/4 v4, 0x0

    invoke-virtual {v1, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 202
    .end local v1    # "description":Landroid/widget/TextView;
    :cond_1
    invoke-virtual {v0, p4}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 203
    return-void

    .line 188
    .end local v2    # "image":Landroid/widget/ImageView;
    .end local v3    # "text":Landroid/widget/TextView;
    :cond_2
    const/16 v4, 0x11

    goto :goto_0
.end method

.method private doBuild()V
    .locals 6

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 77
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->view:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->searchHandler:Lcom/amazon/retailsearch/android/api/display/input/listeners/QuerySubmitListener;

    if-nez v0, :cond_1

    .line 174
    :cond_0
    :goto_0
    return-void

    .line 82
    :cond_1
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->view:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 84
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->showVoice:Z

    if-eqz v0, :cond_6

    move v0, v1

    :goto_1
    iget-boolean v3, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->showScan:Z

    if-eqz v3, :cond_7

    move v3, v1

    :goto_2
    add-int/2addr v0, v3

    iget-boolean v3, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->showFlow:Z

    if-nez v3, :cond_2

    iget-boolean v3, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->showSnap:Z

    if-eqz v3, :cond_3

    :cond_2
    move v2, v1

    :cond_3
    add-int v5, v0, v2

    .line 88
    .local v5, "buttonCount":I
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->showVoice:Z

    if-eqz v0, :cond_4

    .line 90
    new-instance v4, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder$1;

    invoke-direct {v4, p0}, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder$1;-><init>(Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;)V

    .line 100
    .local v4, "click":Landroid/view/View$OnClickListener;
    sget v1, Lcom/amazon/retailsearch/R$drawable;->vs_iss_voice_selector:I

    sget v2, Lcom/amazon/retailsearch/R$string;->rs_entry_voice:I

    sget v3, Lcom/amazon/retailsearch/R$string;->rs_speak_search:I

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->addActionButton(IIILandroid/view/View$OnClickListener;I)V

    .line 111
    .end local v4    # "click":Landroid/view/View$OnClickListener;
    :cond_4
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->showScan:Z

    if-eqz v0, :cond_5

    .line 113
    new-instance v4, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder$2;

    invoke-direct {v4, p0}, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder$2;-><init>(Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;)V

    .line 123
    .restart local v4    # "click":Landroid/view/View$OnClickListener;
    sget v1, Lcom/amazon/retailsearch/R$drawable;->rs_iss_barcode_selector:I

    sget v2, Lcom/amazon/retailsearch/R$string;->rs_bc_search_button:I

    sget v3, Lcom/amazon/retailsearch/R$string;->rs_scan_barcode:I

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->addActionButton(IIILandroid/view/View$OnClickListener;I)V

    .line 134
    .end local v4    # "click":Landroid/view/View$OnClickListener;
    :cond_5
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->showFlow:Z

    if-eqz v0, :cond_9

    .line 136
    new-instance v4, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder$3;

    invoke-direct {v4, p0}, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder$3;-><init>(Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;)V

    .line 146
    .restart local v4    # "click":Landroid/view/View$OnClickListener;
    sget v1, Lcom/amazon/retailsearch/R$drawable;->rs_iss_camera_selector:I

    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->showVisualScan:Z

    if-eqz v0, :cond_8

    sget v2, Lcom/amazon/retailsearch/R$string;->rs_visual_scan:I

    :goto_3
    sget v3, Lcom/amazon/retailsearch/R$string;->rs_scan_product:I

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->addActionButton(IIILandroid/view/View$OnClickListener;I)V

    goto :goto_0

    .end local v4    # "click":Landroid/view/View$OnClickListener;
    .end local v5    # "buttonCount":I
    :cond_6
    move v0, v2

    .line 84
    goto :goto_1

    :cond_7
    move v3, v2

    goto :goto_2

    .line 146
    .restart local v4    # "click":Landroid/view/View$OnClickListener;
    .restart local v5    # "buttonCount":I
    :cond_8
    sget v2, Lcom/amazon/retailsearch/R$string;->rs_view_it_flow:I

    goto :goto_3

    .line 154
    .end local v4    # "click":Landroid/view/View$OnClickListener;
    :cond_9
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->showSnap:Z

    if-eqz v0, :cond_0

    .line 156
    new-instance v4, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder$4;

    invoke-direct {v4, p0}, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder$4;-><init>(Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;)V

    .line 166
    .restart local v4    # "click":Landroid/view/View$OnClickListener;
    sget v1, Lcom/amazon/retailsearch/R$drawable;->rs_search_suggestion_snapit:I

    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->showVisualScan:Z

    if-eqz v0, :cond_a

    sget v2, Lcom/amazon/retailsearch/R$string;->rs_visual_scan:I

    :goto_4
    sget v3, Lcom/amazon/retailsearch/R$string;->rs_scan_product:I

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->addActionButton(IIILandroid/view/View$OnClickListener;I)V

    goto :goto_0

    :cond_a
    sget v2, Lcom/amazon/retailsearch/R$string;->rs_snapit:I

    goto :goto_4
.end method


# virtual methods
.method build()V
    .locals 3

    .prologue
    .line 64
    :try_start_0
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->doBuild()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 70
    :goto_0
    return-void

    .line 66
    :catch_0
    move-exception v0

    .line 68
    .local v0, "e":Ljava/lang/Exception;
    sget-object v1, Lcom/amazon/retailsearch/android/ui/entry/ActionViewBuilder;->log:Lcom/amazon/retailsearch/log/MessageLogger;

    const-string/jumbo v2, "Failed to build action view"

    invoke-interface {v1, v2, v0}, Lcom/amazon/retailsearch/log/MessageLogger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
