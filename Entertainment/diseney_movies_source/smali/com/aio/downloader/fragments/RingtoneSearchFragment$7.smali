.class Lcom/aio/downloader/fragments/RingtoneSearchFragment$7;
.super Ljava/lang/Object;
.source "RingtoneSearchFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/fragments/RingtoneSearchFragment;->init(Landroid/view/View;)V
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
.field final synthetic this$0:Lcom/aio/downloader/fragments/RingtoneSearchFragment;


# direct methods
.method constructor <init>(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$7;->this$0:Lcom/aio/downloader/fragments/RingtoneSearchFragment;

    .line 216
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/fragments/RingtoneSearchFragment$7;)Lcom/aio/downloader/fragments/RingtoneSearchFragment;
    .locals 1

    .prologue
    .line 216
    iget-object v0, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$7;->this$0:Lcom/aio/downloader/fragments/RingtoneSearchFragment;

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

    .line 220
    iget-object v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$7;->this$0:Lcom/aio/downloader/fragments/RingtoneSearchFragment;

    invoke-virtual {v1}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    .line 221
    const-string v2, "ringtone_search_data"

    .line 220
    invoke-virtual {v1, v2, v3}, Landroid/support/v4/app/FragmentActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 221
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 222
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v1, "ringtone_search_selector"

    invoke-interface {v0, v1, p3}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 223
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 224
    iget-object v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$7;->this$0:Lcom/aio/downloader/fragments/RingtoneSearchFragment;

    # getter for: Lcom/aio/downloader/fragments/RingtoneSearchFragment;->playbar:Landroid/widget/RelativeLayout;
    invoke-static {v1}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->access$3(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)Landroid/widget/RelativeLayout;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 225
    iget-object v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$7;->this$0:Lcom/aio/downloader/fragments/RingtoneSearchFragment;

    # getter for: Lcom/aio/downloader/fragments/RingtoneSearchFragment;->title:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->access$10(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)Landroid/widget/TextView;

    move-result-object v2

    iget-object v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$7;->this$0:Lcom/aio/downloader/fragments/RingtoneSearchFragment;

    # getter for: Lcom/aio/downloader/fragments/RingtoneSearchFragment;->list:Ljava/util/ArrayList;
    invoke-static {v1}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->access$5(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v1}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getTitle()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 226
    iget-object v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$7;->this$0:Lcom/aio/downloader/fragments/RingtoneSearchFragment;

    # getter for: Lcom/aio/downloader/fragments/RingtoneSearchFragment;->playpause:Landroid/widget/ImageView;
    invoke-static {v1}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->access$11(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)Landroid/widget/ImageView;

    move-result-object v1

    const v2, 0x7f02015e

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 229
    new-instance v1, Lcom/aio/downloader/fragments/RingtoneSearchFragment$7$1;

    invoke-direct {v1, p0, p3}, Lcom/aio/downloader/fragments/RingtoneSearchFragment$7$1;-><init>(Lcom/aio/downloader/fragments/RingtoneSearchFragment$7;I)V

    new-array v2, v3, [Ljava/lang/Void;

    .line 307
    invoke-virtual {v1, v2}, Lcom/aio/downloader/fragments/RingtoneSearchFragment$7$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 308
    iget-object v1, p0, Lcom/aio/downloader/fragments/RingtoneSearchFragment$7;->this$0:Lcom/aio/downloader/fragments/RingtoneSearchFragment;

    # getter for: Lcom/aio/downloader/fragments/RingtoneSearchFragment;->adapter:Lcom/aio/downloader/adapter/RingtoneListviewAdapter;
    invoke-static {v1}, Lcom/aio/downloader/fragments/RingtoneSearchFragment;->access$18(Lcom/aio/downloader/fragments/RingtoneSearchFragment;)Lcom/aio/downloader/adapter/RingtoneListviewAdapter;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/adapter/RingtoneListviewAdapter;->notifyDataSetChanged()V

    .line 309
    return-void
.end method
