.class Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$1;
.super Ljava/lang/Object;
.source "BrowseFilterCategoryDetailPanel.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;
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
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;

    .prologue
    .line 66
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onFilterChange(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V
    .locals 1
    .param p1, "filterValue"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    .prologue
    .line 69
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->adapter:Landroid/widget/ArrayAdapter;

    if-eqz v0, :cond_0

    .line 70
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel;->adapter:Landroid/widget/ArrayAdapter;

    invoke-virtual {v0}, Landroid/widget/ArrayAdapter;->notifyDataSetChanged()V

    .line 72
    :cond_0
    return-void
.end method

.method public bridge synthetic onFilterChange(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 66
    check-cast p1, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoryDetailPanel$1;->onFilterChange(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V

    return-void
.end method
