.class Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "BrowseFilterDialog.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->initialize()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener",
        "<",
        "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    .prologue
    .line 273
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 3
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 296
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->access$400(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;)Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    move-result-object v1

    new-instance v2, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5$1;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5$1;-><init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5;)V

    invoke-virtual {v1, p1, v2}, Lcom/comcast/cim/android/view/common/ErrorDialogFactory;->createErrorDialogForThrowable(Ljava/lang/Throwable;Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;)Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v0

    .line 303
    .local v0, "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    new-instance v1, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5$2;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5$2;-><init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5;)V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 310
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    const-string v2, "caldialogfragment"

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 311
    return-void
.end method

.method public onPostExecute(Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;)V
    .locals 4
    .param p1, "tagsRoot"    # Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    .prologue
    .line 277
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    iput-object p1, v2, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    .line 278
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getPendingFilter()Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    move-result-object v1

    .line 280
    .local v1, "filter":Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v2

    sget-object v3, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;

    .line 281
    .local v0, "browseFilterCategoriesPanel":Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;
    if-eqz v0, :cond_0

    .line 282
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->category:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    invoke-virtual {v0, p1, v1, v2}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->initializeCategoriesList(Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V

    .line 283
    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->isDownloadableOn()Z

    move-result v2

    invoke-virtual {v0, v2}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->updateDownloadableCheckbox(Z)V

    .line 284
    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->isHideLockOn()Z

    move-result v2

    invoke-virtual {v0, v2}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->updateHideLockedCheckbox(Z)V

    .line 286
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    iget-boolean v2, v2, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->isDualPanel:Z

    if-eqz v2, :cond_0

    .line 287
    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterCategoriesPanel;->getFilterChangeListener()Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->registerOnChangeListener(Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;)Z

    .line 291
    :cond_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    # invokes: Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->hideLoading()V
    invoke-static {v2}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->access$300(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;)V

    .line 292
    return-void
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 273
    check-cast p1, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5;->onPostExecute(Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;)V

    return-void
.end method
