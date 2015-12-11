.class Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$2;
.super Ljava/lang/Object;
.source "BackedUpNoRootFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;

.field private final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$2;->this$1:Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;

    iput p2, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$2;->val$position:I

    .line 248
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 254
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$2;->this$1:Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->access$0(Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;)Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    move-result-object v0

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->dbUtils:Lcom/aio/downloader/db/TypeDbUtilsBackup;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$0(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Lcom/aio/downloader/db/TypeDbUtilsBackup;

    move-result-object v1

    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$2;->this$1:Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->access$0(Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;)Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    move-result-object v0

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->listdd:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$2(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Ljava/util/List;

    move-result-object v0

    iget v2, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$2;->val$position:I

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/model/BackupModel;

    invoke-virtual {v0}, Lcom/aio/downloader/model/BackupModel;->getPackage_name()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/aio/downloader/db/TypeDbUtilsBackup;->deletefile(Ljava/lang/String;)V

    .line 255
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$2;->this$1:Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->access$0(Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;)Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$2;->this$1:Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;
    invoke-static {v1}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->access$0(Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;)Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    move-result-object v1

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->dbUtils:Lcom/aio/downloader/db/TypeDbUtilsBackup;
    invoke-static {v1}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$0(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Lcom/aio/downloader/db/TypeDbUtilsBackup;

    move-result-object v1

    const-string v2, "game_app"

    const-string v3, "timesort"

    invoke-virtual {v1, v2, v3}, Lcom/aio/downloader/db/TypeDbUtilsBackup;->queryApk(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$1(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;Ljava/util/List;)V

    .line 256
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$2;->this$1:Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->access$0(Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;)Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    move-result-object v0

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->listdd:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$2(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Ljava/util/List;

    move-result-object v0

    if-nez v0, :cond_0

    .line 257
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$2;->this$1:Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->access$0(Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;)Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    move-result-object v0

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    invoke-static {v0, v1}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$1(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;Ljava/util/List;)V

    .line 260
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$2;->this$1:Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->access$0(Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;)Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    move-result-object v0

    new-instance v1, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;

    iget-object v2, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$2;->this$1:Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;
    invoke-static {v2}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->access$0(Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;)Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;-><init>(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)V

    invoke-static {v0, v1}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$3(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;)V

    .line 261
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$2;->this$1:Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->access$0(Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;)Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    move-result-object v0

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->lv_uninstall:Landroid/widget/ListView;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$4(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Landroid/widget/ListView;

    move-result-object v0

    iget-object v1, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$2;->this$1:Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;
    invoke-static {v1}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->access$0(Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;)Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    move-result-object v1

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->musicListAdapter:Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;
    invoke-static {v1}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$5(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 262
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$2;->this$1:Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->access$0(Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;)Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    move-result-object v0

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->musicListAdapter:Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->access$5(Lcom/aio/downloader/fragments/BackedUpNoRootFragment;)Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->notifyDataSetChanged()V

    .line 264
    iget-object v0, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$2;->this$1:Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;
    invoke-static {v0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->access$0(Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;)Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    move-result-object v0

    invoke-virtual {v0}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const-string v1, "Delete successfully"

    .line 265
    const/4 v2, 0x0

    .line 264
    invoke-static {v0, v1, v2}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 265
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 266
    return-void
.end method
