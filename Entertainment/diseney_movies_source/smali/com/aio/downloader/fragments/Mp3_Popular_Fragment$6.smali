.class Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$6;
.super Ljava/lang/Object;
.source "Mp3_Popular_Fragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
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
.field final synthetic this$0:Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$6;->this$0:Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;

    .line 174
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$6;)Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$6;->this$0:Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;

    return-object v0
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 4
    .param p2, "arg1"    # Landroid/view/View;
    .param p3, "arg2"    # I
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
    .local p1, "arg0":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    const/4 v3, 0x0

    .line 179
    iget-object v1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$6;->this$0:Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;

    invoke-virtual {v1}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    .line 180
    const-string v2, "mp3_popular_data"

    .line 179
    invoke-virtual {v1, v2, v3}, Landroid/support/v4/app/FragmentActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 180
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 181
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "mp3_popular_selector"

    invoke-interface {v0, v1, p3}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 182
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 184
    iget-object v1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$6;->this$0:Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;

    # getter for: Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->playbar:Landroid/widget/RelativeLayout;
    invoke-static {v1}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->access$3(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)Landroid/widget/RelativeLayout;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 185
    iget-object v1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$6;->this$0:Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;

    # getter for: Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->title:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->access$8(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)Landroid/widget/TextView;

    move-result-object v2

    iget-object v1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$6;->this$0:Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;

    # getter for: Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->list:Ljava/util/ArrayList;
    invoke-static {v1}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->access$9(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 186
    iget-object v1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$6;->this$0:Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;

    # getter for: Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->playpause:Landroid/widget/ImageView;
    invoke-static {v1}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->access$10(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)Landroid/widget/ImageView;

    move-result-object v1

    const v2, 0x7f02015e

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 189
    new-instance v1, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$6$1;

    invoke-direct {v1, p0, p3}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$6$1;-><init>(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$6;I)V

    new-array v2, v3, [Ljava/lang/Void;

    .line 256
    invoke-virtual {v1, v2}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$6$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 258
    iget-object v1, p0, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment$6;->this$0:Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;

    # getter for: Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->adapter:Lcom/aio/downloader/adapter/Mp3ListviewAdapter;
    invoke-static {v1}, Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;->access$17(Lcom/aio/downloader/fragments/Mp3_Popular_Fragment;)Lcom/aio/downloader/adapter/Mp3ListviewAdapter;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/adapter/Mp3ListviewAdapter;->notifyDataSetChanged()V

    .line 260
    return-void
.end method
