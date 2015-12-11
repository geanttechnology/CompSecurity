.class Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5$2;
.super Ljava/lang/Object;
.source "BrowseFilterDialog.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


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
    .line 303
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5$2;->this$1:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 306
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5$2;->this$1:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog$5;->this$0:Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;

    # invokes: Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->hideLoading()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;->access$300(Lcom/xfinity/playerlib/view/browseprograms/BrowseFilterDialog;)V

    .line 307
    return-void
.end method
