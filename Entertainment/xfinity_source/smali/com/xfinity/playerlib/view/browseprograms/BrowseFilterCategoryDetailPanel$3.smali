.class Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$3;
.super Landroid/widget/ArrayAdapter;
.source "BrowseFilterCategoryDetailPanel.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->buildCategoryDetailPanel(Landroid/content/Context;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;[Landroid/util/Pair;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Landroid/util/Pair",
        "<",
        "Ljava/lang/String;",
        "Ljava/lang/String;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;

.field final synthetic val$category:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

.field final synthetic val$filter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;Landroid/content/Context;I[Landroid/util/Pair;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;
    .param p2, "x0"    # Landroid/content/Context;
    .param p3, "x1"    # I

    .prologue
    .line 190
    .local p4, "x2":[Landroid/util/Pair;, "[Landroid/util/Pair<Ljava/lang/String;Ljava/lang/String;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$3;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;

    iput-object p5, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$3;->val$filter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    iput-object p6, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$3;->val$category:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-direct {p0, p2, p3, p4}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;I[Ljava/lang/Object;)V

    return-void
.end method


# virtual methods
.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 193
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$3;->getItem(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/util/Pair;

    .line 195
    .local v1, "idLabelPair":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/String;Ljava/lang/String;>;"
    if-nez p2, :cond_0

    .line 196
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$3;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->inflater:Landroid/view/LayoutInflater;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->access$000(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;)Landroid/view/LayoutInflater;

    move-result-object v3

    sget v4, Lcom/xfinity/playerlib/R$layout;->filter_dialog_list_item:I

    const/4 v5, 0x0

    invoke-virtual {v3, v4, p3, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    .line 199
    :cond_0
    sget v3, Lcom/xfinity/playerlib/R$id;->filter_title:I

    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/CheckedTextView;

    .line 200
    .local v2, "textView":Landroid/widget/CheckedTextView;
    iget-object v3, v1, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v3, Ljava/lang/CharSequence;

    invoke-virtual {v2, v3}, Landroid/widget/CheckedTextView;->setText(Ljava/lang/CharSequence;)V

    .line 202
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$3;->val$filter:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$3;->val$category:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getFiltersForCategory(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)Ljava/util/Map;

    move-result-object v0

    .line 203
    .local v0, "currentCategoryFilters":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    iget-object v3, v1, Landroid/util/Pair;->first:Ljava/lang/Object;

    invoke-interface {v0, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v3

    invoke-virtual {v2, v3}, Landroid/widget/CheckedTextView;->setChecked(Z)V

    .line 205
    return-object p2
.end method
