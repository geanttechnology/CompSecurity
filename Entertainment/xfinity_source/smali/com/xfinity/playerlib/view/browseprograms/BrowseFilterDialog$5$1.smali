.class Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5$1;
.super Ljava/lang/Object;
.source "BrowseFilterDialog.java"

# interfaces
.implements Lcom/comcast/cim/android/view/common/CALDialogFragment$TryAgainListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5;->onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5;

    .prologue
    .line 296
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5$1;->this$1:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public tryAgain()V
    .locals 1

    .prologue
    .line 299
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5$1;->this$1:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->initialize()V

    .line 300
    return-void
.end method
