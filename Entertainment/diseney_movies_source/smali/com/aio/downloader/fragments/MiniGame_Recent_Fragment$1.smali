.class Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment$1;
.super Ljava/lang/Object;
.source "MiniGame_Recent_Fragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/widget/AdapterView$OnItemClickListener;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment$1;->this$0:Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;

    .line 52
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 3
    .param p2, "arg1"    # Landroid/view/View;
    .param p3, "pos"    # I
    .param p4, "arg3"    # J
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
    .line 55
    .local p1, "arg0":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment$1;->this$0:Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;

    invoke-virtual {v1}, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-class v2, Lcom/aio/downloader/activity/MiniGameDetails;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 56
    .local v0, "tidetail":Landroid/content/Intent;
    const-string v1, "pos"

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 57
    const-string v1, "list"

    iget-object v2, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment$1;->this$0:Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;

    # getter for: Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->list:Ljava/util/ArrayList;
    invoke-static {v2}, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->access$3(Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 58
    iget-object v1, p0, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment$1;->this$0:Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;

    invoke-virtual {v1}, Lcom/aio/downloader/fragments/MiniGame_Recent_Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/support/v4/app/FragmentActivity;->startActivity(Landroid/content/Intent;)V

    .line 60
    return-void
.end method
