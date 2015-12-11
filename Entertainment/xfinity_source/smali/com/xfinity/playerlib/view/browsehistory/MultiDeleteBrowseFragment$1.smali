.class Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$1;
.super Ljava/lang/Object;
.source "MultiDeleteBrowseFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->onResumeInternal()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    .prologue
    .line 101
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$1;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$1;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$1;->this$0:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 1
    .param p1, "dialogInterface"    # Landroid/content/DialogInterface;

    .prologue
    .line 104
    .local p0, "this":Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$1;, "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$1;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$1;->this$0:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->hideLoading()V

    .line 105
    return-void
.end method
