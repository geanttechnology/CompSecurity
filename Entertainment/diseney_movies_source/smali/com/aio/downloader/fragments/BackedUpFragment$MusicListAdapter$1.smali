.class Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter$1;
.super Ljava/lang/Object;
.source "BackedUpFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private pInfo:Landroid/content/pm/PackageInfo;

.field final synthetic this$1:Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;

.field private final synthetic val$archiveFilePath:Ljava/lang/String;

.field private final synthetic val$packageName:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter$1;->this$1:Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;

    iput-object p2, p0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter$1;->val$packageName:Ljava/lang/String;

    iput-object p3, p0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter$1;->val$archiveFilePath:Ljava/lang/String;

    .line 243
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const/4 v4, 0x0

    .line 251
    :try_start_0
    iget-object v1, p0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter$1;->this$1:Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;

    # getter for: Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;
    invoke-static {v1}, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->access$0(Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;)Lcom/aio/downloader/fragments/BackedUpFragment;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/fragments/BackedUpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v1

    .line 252
    iget-object v2, p0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter$1;->val$packageName:Ljava/lang/String;

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    .line 251
    iput-object v1, p0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter$1;->pInfo:Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 257
    :goto_0
    const-string v1, "backup"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "packageinfo="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter$1;->pInfo:Landroid/content/pm/PackageInfo;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 258
    iget-object v1, p0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter$1;->pInfo:Landroid/content/pm/PackageInfo;

    if-nez v1, :cond_0

    .line 259
    const-string v1, "backup"

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "click="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter$1;->val$archiveFilePath:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 260
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 262
    .local v0, "aa":Landroid/content/Intent;
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "file://"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter$1;->val$archiveFilePath:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 263
    const-string v2, "application/vnd.android.package-archive"

    .line 261
    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 264
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 265
    iget-object v1, p0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter$1;->this$1:Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;

    # getter for: Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;
    invoke-static {v1}, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->access$0(Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;)Lcom/aio/downloader/fragments/BackedUpFragment;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/fragments/BackedUpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/support/v4/app/FragmentActivity;->startActivity(Landroid/content/Intent;)V

    .line 272
    .end local v0    # "aa":Landroid/content/Intent;
    :goto_1
    return-void

    .line 267
    :cond_0
    iget-object v1, p0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter$1;->this$1:Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;

    # getter for: Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;
    invoke-static {v1}, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->access$0(Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;)Lcom/aio/downloader/fragments/BackedUpFragment;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/fragments/BackedUpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    .line 268
    const-string v2, "App is already installed."

    .line 267
    invoke-static {v1, v2, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    .line 269
    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    goto :goto_1

    .line 254
    :catch_0
    move-exception v1

    goto :goto_0
.end method
