.class Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$14;
.super Ljava/lang/Object;
.source "Home_app_Listview_Adapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->jiexie(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

.field private url_like:Ljava/lang/String;

.field private final synthetic val$ppp:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$14;->this$0:Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

    iput p2, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$14;->val$ppp:I

    .line 669
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$14;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 671
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$14;->url_like:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 675
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v1, "http://welaf.com/fun/stat.php?type=like&serial="

    invoke-direct {v2, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 676
    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$14;->this$0:Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->list_fun:Ljava/util/ArrayList;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->access$1(Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;)Ljava/util/ArrayList;

    move-result-object v1

    iget v3, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$14;->val$ppp:I

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/Fun_appModel;

    invoke-virtual {v1}, Lcom/aio/downloader/model/Fun_appModel;->getSerial()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 675
    iput-object v1, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$14;->url_like:Ljava/lang/String;

    .line 677
    new-instance v1, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$14$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$14$1;-><init>(Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$14;)V

    .line 687
    invoke-virtual {v1}, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$14$1;->start()V

    .line 688
    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$14;->this$0:Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->list_fun:Ljava/util/ArrayList;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->access$1(Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;)Ljava/util/ArrayList;

    move-result-object v1

    iget v2, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$14;->val$ppp:I

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/Fun_appModel;

    invoke-virtual {v1}, Lcom/aio/downloader/model/Fun_appModel;->isLikenum()Z

    move-result v1

    if-nez v1, :cond_0

    .line 689
    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$14;->this$0:Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->list_fun:Ljava/util/ArrayList;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->access$1(Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;)Ljava/util/ArrayList;

    move-result-object v1

    iget v2, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$14;->val$ppp:I

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/Fun_appModel;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/aio/downloader/model/Fun_appModel;->setLikenum(Z)V

    move-object v0, p1

    .line 690
    check-cast v0, Landroid/widget/ImageView;

    .line 691
    .local v0, "imageView":Landroid/widget/ImageView;
    const v1, 0x7f0200bd

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 698
    :goto_0
    return-void

    .line 693
    .end local v0    # "imageView":Landroid/widget/ImageView;
    :cond_0
    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$14;->this$0:Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->list_fun:Ljava/util/ArrayList;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->access$1(Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;)Ljava/util/ArrayList;

    move-result-object v1

    iget v2, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$14;->val$ppp:I

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/Fun_appModel;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/aio/downloader/model/Fun_appModel;->setLikenum(Z)V

    move-object v0, p1

    .line 694
    check-cast v0, Landroid/widget/ImageView;

    .line 695
    .restart local v0    # "imageView":Landroid/widget/ImageView;
    const v1, 0x7f0200bc

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0
.end method
