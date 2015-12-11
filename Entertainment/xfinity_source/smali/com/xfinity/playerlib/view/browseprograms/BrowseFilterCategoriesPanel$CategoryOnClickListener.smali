.class Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$CategoryOnClickListener;
.super Ljava/lang/Object;
.source "BrowseFilterCategoriesPanel.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "CategoryOnClickListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;


# direct methods
.method private constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;)V
    .locals 0

    .prologue
    .line 241
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$CategoryOnClickListener;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;
    .param p2, "x1"    # Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$1;

    .prologue
    .line 241
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$CategoryOnClickListener;-><init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;)V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 245
    invoke-virtual {p1}, Landroid/view/View;->isSelected()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 251
    :goto_0
    return-void

    .line 249
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$CategoryOnClickListener;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->setSelectedCategoryView(Landroid/view/View;)V

    .line 250
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$CategoryOnClickListener;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->filterEventListener:Lcom/xfinity/playerlib/view/browseprograms/FilterEventListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->access$000(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;)Lcom/xfinity/playerlib/view/browseprograms/FilterEventListener;

    move-result-object v1

    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-interface {v1, v0}, Lcom/xfinity/playerlib/view/browseprograms/FilterEventListener;->onCategoryChanged(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V

    goto :goto_0
.end method
