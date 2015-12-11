.class Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$1;
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

.field private final synthetic val$archiveFilePath:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$1;->this$1:Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;

    iput-object p2, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$1;->val$archiveFilePath:Ljava/lang/String;

    .line 219
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const/4 v5, 0x0

    .line 224
    const/4 v1, 0x0

    .line 226
    .local v1, "packageInfo":Landroid/content/pm/PackageInfo;
    :try_start_0
    iget-object v2, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$1;->this$1:Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;
    invoke-static {v2}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->access$0(Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;)Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/support/v4/app/FragmentActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 227
    iget-object v3, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$1;->val$archiveFilePath:Ljava/lang/String;

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 232
    :goto_0
    const-string v2, "backup"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "packageInfo="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 233
    if-nez v1, :cond_0

    .line 234
    new-instance v0, Landroid/content/Intent;

    iget-object v2, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$1;->this$1:Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;
    invoke-static {v2}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->access$0(Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;)Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    .line 235
    const-class v3, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 234
    invoke-direct {v0, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 236
    .local v0, "intent":Landroid/content/Intent;
    const-string v2, "myid"

    iget-object v3, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$1;->val$archiveFilePath:Ljava/lang/String;

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 237
    const-string v2, "linkurl"

    const-string v3, ""

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 238
    const/high16 v2, 0x10000000

    invoke-virtual {v0, v2}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 239
    iget-object v2, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$1;->this$1:Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;
    invoke-static {v2}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->access$0(Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;)Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/support/v4/app/FragmentActivity;->startActivity(Landroid/content/Intent;)V

    .line 245
    .end local v0    # "intent":Landroid/content/Intent;
    :goto_1
    return-void

    .line 241
    :cond_0
    iget-object v2, p0, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter$1;->this$1:Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;

    # getter for: Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpNoRootFragment;
    invoke-static {v2}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;->access$0(Lcom/aio/downloader/fragments/BackedUpNoRootFragment$MusicListAdapter;)Lcom/aio/downloader/fragments/BackedUpNoRootFragment;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/fragments/BackedUpNoRootFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    .line 242
    const-string v3, "App is already installed."

    .line 241
    invoke-static {v2, v3, v5}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    .line 243
    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    goto :goto_1

    .line 229
    :catch_0
    move-exception v2

    goto :goto_0
.end method
