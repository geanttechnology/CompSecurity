.class Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter$2;
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
.field final synthetic this$1:Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;

.field private final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter$2;->this$1:Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;

    iput p2, p0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter$2;->val$position:I

    .line 288
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 293
    new-instance v0, Ljava/io/File;

    iget-object v1, p0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter$2;->this$1:Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;

    # getter for: Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;
    invoke-static {v1}, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->access$0(Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;)Lcom/aio/downloader/fragments/BackedUpFragment;

    move-result-object v1

    # getter for: Lcom/aio/downloader/fragments/BackedUpFragment;->list:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/fragments/BackedUpFragment;->access$3(Lcom/aio/downloader/fragments/BackedUpFragment;)Ljava/util/List;

    move-result-object v1

    iget v2, p0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter$2;->val$position:I

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-direct {v0, v1}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 294
    .local v0, "df":Ljava/io/File;
    invoke-virtual {v0}, Ljava/io/File;->exists()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 296
    invoke-virtual {v0}, Ljava/io/File;->delete()Z

    .line 299
    :cond_0
    iget-object v1, p0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter$2;->this$1:Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;

    # getter for: Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;
    invoke-static {v1}, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->access$0(Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;)Lcom/aio/downloader/fragments/BackedUpFragment;

    move-result-object v1

    # getter for: Lcom/aio/downloader/fragments/BackedUpFragment;->list:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/fragments/BackedUpFragment;->access$3(Lcom/aio/downloader/fragments/BackedUpFragment;)Ljava/util/List;

    move-result-object v1

    iget v2, p0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter$2;->val$position:I

    invoke-interface {v1, v2}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 300
    iget-object v1, p0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter$2;->this$1:Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;

    # getter for: Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;
    invoke-static {v1}, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->access$0(Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;)Lcom/aio/downloader/fragments/BackedUpFragment;

    move-result-object v1

    # getter for: Lcom/aio/downloader/fragments/BackedUpFragment;->ma:Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;
    invoke-static {v1}, Lcom/aio/downloader/fragments/BackedUpFragment;->access$2(Lcom/aio/downloader/fragments/BackedUpFragment;)Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->notifyDataSetChanged()V

    .line 301
    iget-object v1, p0, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter$2;->this$1:Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;

    # getter for: Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->this$0:Lcom/aio/downloader/fragments/BackedUpFragment;
    invoke-static {v1}, Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;->access$0(Lcom/aio/downloader/fragments/BackedUpFragment$MusicListAdapter;)Lcom/aio/downloader/fragments/BackedUpFragment;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/fragments/BackedUpFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-string v2, "Delete successfully"

    .line 302
    const/4 v3, 0x0

    .line 301
    invoke-static {v1, v2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    .line 302
    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    .line 303
    return-void
.end method
