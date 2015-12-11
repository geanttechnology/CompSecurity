.class Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$1;
.super Ljava/lang/Object;
.source "BrowseFilterCategoriesPanel.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener",
        "<",
        "Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;

    .prologue
    .line 39
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFilterChange(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V
    .locals 2
    .param p1, "filterValue"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    .prologue
    .line 42
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->updateCategoriesList(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V

    .line 43
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->isDownloadableOn()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->updateDownloadableCheckbox(Z)V

    .line 44
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->isHideLockOn()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->updateHideLockedCheckbox(Z)V

    .line 45
    return-void
.end method

.method public bridge synthetic onFilterChange(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 39
    check-cast p1, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel$1;->onFilterChange(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V

    return-void
.end method
