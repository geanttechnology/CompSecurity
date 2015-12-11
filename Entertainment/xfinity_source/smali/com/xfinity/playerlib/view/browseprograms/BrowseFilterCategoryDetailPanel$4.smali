.class Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$4;
.super Ljava/lang/Object;
.source "BrowseFilterCategoryDetailPanel.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->setFilterListOnItemClickListener(Landroid/widget/ListView;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;

.field final synthetic val$category:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;

    .prologue
    .line 222
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$4;->val$category:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 6
    .param p2, "view"    # Landroid/view/View;
    .param p3, "i"    # I
    .param p4, "l"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 225
    .local p1, "adapterView":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    sget v2, Lcom/xfinity/playerlib/R$id;->filter_title:I

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/CheckedTextView;

    .line 226
    .local v1, "textView":Landroid/widget/CheckedTextView;
    invoke-virtual {p1, p3}, Landroid/widget/AdapterView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v2

    invoke-static {v2}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/util/Pair;

    .line 228
    .local v0, "idLabelPair":Landroid/util/Pair;, "Landroid/util/Pair<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {v1}, Landroid/widget/CheckedTextView;->toggle()V

    .line 230
    invoke-virtual {v1}, Landroid/widget/CheckedTextView;->isChecked()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 231
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;

    iget-object v4, v2, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->filterEventListener:Lcom/xfinity/playerlib/view/browseprograms/FilterEventListener;

    iget-object v2, v0, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v2, Ljava/lang/String;

    iget-object v3, v0, Landroid/util/Pair;->second:Ljava/lang/Object;

    check-cast v3, Ljava/lang/String;

    iget-object v5, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$4;->val$category:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-interface {v4, v2, v3, v5}, Lcom/xfinity/playerlib/view/browseprograms/FilterEventListener;->onFilterItemSelected(Ljava/lang/String;Ljava/lang/String;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V

    .line 232
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;

    sget v3, Lcom/xfinity/playerlib/R$string;->content_description_changed_to_checked:I

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->speak(I)V

    .line 238
    :goto_0
    return-void

    .line 234
    :cond_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;

    iget-object v3, v2, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->filterEventListener:Lcom/xfinity/playerlib/view/browseprograms/FilterEventListener;

    iget-object v2, v0, Landroid/util/Pair;->first:Ljava/lang/Object;

    check-cast v2, Ljava/lang/String;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$4;->val$category:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-interface {v3, v2, v4}, Lcom/xfinity/playerlib/view/browseprograms/FilterEventListener;->onFilterItemDeselected(Ljava/lang/String;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V

    .line 235
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$4;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;

    sget v3, Lcom/xfinity/playerlib/R$string;->content_description_changed_to_unchecked:I

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->speak(I)V

    goto :goto_0
.end method
