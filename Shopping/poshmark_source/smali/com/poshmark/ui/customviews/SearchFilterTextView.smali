.class public Lcom/poshmark/ui/customviews/SearchFilterTextView;
.super Lcom/poshmark/ui/customviews/PMTextView;
.source "SearchFilterTextView.java"


# instance fields
.field NWT_condition:Ljava/lang/Boolean;

.field Retail_condition:Ljava/lang/Boolean;

.field brand:Ljava/lang/String;

.field category:Ljava/lang/String;

.field listener:Landroid/view/View$OnClickListener;

.field screenNameForAnalytics:Ljava/lang/String;

.field searchTriggerType:Ljava/lang/String;

.field size:Ljava/lang/String;

.field subCategoryList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v1, 0x0

    .line 38
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/customviews/PMTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 32
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView;->NWT_condition:Ljava/lang/Boolean;

    .line 33
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView;->Retail_condition:Ljava/lang/Boolean;

    .line 34
    new-instance v0, Ljava/lang/String;

    invoke-direct {v0}, Ljava/lang/String;-><init>()V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView;->searchTriggerType:Ljava/lang/String;

    .line 35
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView;->screenNameForAnalytics:Ljava/lang/String;

    .line 76
    new-instance v0, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/customviews/SearchFilterTextView$1;-><init>(Lcom/poshmark/ui/customviews/SearchFilterTextView;)V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView;->listener:Landroid/view/View$OnClickListener;

    .line 39
    iget-object v0, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 40
    const/4 v0, 0x2

    const/high16 v1, 0x41800000    # 16.0f

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/customviews/SearchFilterTextView;->setTextSize(IF)V

    .line 41
    return-void
.end method


# virtual methods
.method public setBrand(Ljava/lang/String;)V
    .locals 1
    .param p1, "brand"    # Ljava/lang/String;

    .prologue
    .line 58
    iput-object p1, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView;->brand:Ljava/lang/String;

    .line 59
    const-string v0, "br"

    iput-object v0, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView;->searchTriggerType:Ljava/lang/String;

    .line 60
    return-void
.end method

.method public setCategory(Ljava/lang/String;)V
    .locals 1
    .param p1, "category"    # Ljava/lang/String;

    .prologue
    .line 44
    iput-object p1, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView;->category:Ljava/lang/String;

    .line 45
    const-string v0, "ct"

    iput-object v0, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView;->searchTriggerType:Ljava/lang/String;

    .line 46
    return-void
.end method

.method public setNWTConditionFlag(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "condition"    # Ljava/lang/Boolean;

    .prologue
    .line 68
    iput-object p1, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView;->NWT_condition:Ljava/lang/Boolean;

    .line 69
    return-void
.end method

.method public setParentScreenNameForAnalytics(Ljava/lang/String;)V
    .locals 0
    .param p1, "viewNameForAnalytics"    # Ljava/lang/String;

    .prologue
    .line 63
    iput-object p1, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView;->screenNameForAnalytics:Ljava/lang/String;

    .line 64
    return-void
.end method

.method public setRetailConditionFlag(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "condition"    # Ljava/lang/Boolean;

    .prologue
    .line 72
    iput-object p1, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView;->Retail_condition:Ljava/lang/Boolean;

    .line 73
    return-void
.end method

.method public setSize(Ljava/lang/String;)V
    .locals 0
    .param p1, "size"    # Ljava/lang/String;

    .prologue
    .line 54
    iput-object p1, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView;->size:Ljava/lang/String;

    .line 55
    return-void
.end method

.method public setSubCategoryList(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/MetaItem;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 49
    .local p1, "list":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/MetaItem;>;"
    iput-object p1, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView;->subCategoryList:Ljava/util/List;

    .line 50
    const-string v0, "ct"

    iput-object v0, p0, Lcom/poshmark/ui/customviews/SearchFilterTextView;->searchTriggerType:Ljava/lang/String;

    .line 51
    return-void
.end method
