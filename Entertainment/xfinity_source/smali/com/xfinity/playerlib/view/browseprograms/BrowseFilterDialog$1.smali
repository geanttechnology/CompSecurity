.class Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$1;
.super Ljava/lang/Object;
.source "BrowseFilterDialog.java"

# interfaces
.implements Landroid/app/FragmentManager$OnBackStackChangedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    .prologue
    .line 77
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onBackStackChanged()V
    .locals 4

    .prologue
    .line 80
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    sget-object v2, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;

    .line 82
    .local v0, "browseFilterCategoriesPanel":Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    iget-boolean v1, v1, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->isDualPanel:Z

    if-nez v1, :cond_1

    .line 83
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->isVisible()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 84
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getPendingFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->updateCategoriesList(Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V

    .line 85
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->backButton:Landroid/view/View;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->access$000(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;)Landroid/view/View;

    move-result-object v1

    const/4 v2, 0x4

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 86
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->headerLabel:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->access$100(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;)Landroid/widget/TextView;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    sget v3, Lcom/xfinity/playerlib/R$string;->filter_title:I

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 87
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->headerLabel:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->access$100(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;)Landroid/widget/TextView;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    sget v3, Lcom/xfinity/playerlib/R$string;->filter_title:I

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 89
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getPendingFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v1

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->getFilterChangeListener()Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->registerOnChangeListener(Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;)Z

    .line 91
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$1;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->resetFocus()V

    .line 93
    :cond_1
    return-void
.end method
