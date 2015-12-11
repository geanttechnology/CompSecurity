.class Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$15;
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

.field private url_share:Ljava/lang/String;

.field private final synthetic val$ppp:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$15;->this$0:Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

    iput p2, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$15;->val$ppp:I

    .line 702
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$15;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 704
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$15;->url_share:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 710
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v1, "http://welaf.com/fun/stat.php?serial="

    invoke-direct {v2, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 711
    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$15;->this$0:Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->list_fun:Ljava/util/ArrayList;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->access$1(Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;)Ljava/util/ArrayList;

    move-result-object v1

    iget v3, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$15;->val$ppp:I

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/Fun_appModel;

    invoke-virtual {v1}, Lcom/aio/downloader/model/Fun_appModel;->getSerial()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "&type=share"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 710
    iput-object v1, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$15;->url_share:Ljava/lang/String;

    .line 712
    new-instance v1, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$15$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$15$1;-><init>(Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$15;)V

    .line 723
    invoke-virtual {v1}, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$15$1;->start()V

    .line 725
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.SEND"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 726
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "text/plain"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 727
    const-string v1, "android.intent.extra.TEXT"

    .line 728
    const-string v2, "http://tinyurl.com/allinone-downloader"

    .line 727
    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 729
    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$15;->this$0:Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->access$0(Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;)Landroid/content/Context;

    move-result-object v1

    .line 730
    const-string v2, "AIO Downloaded"

    invoke-static {v0, v2}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v2

    const/high16 v3, 0x10000000

    invoke-virtual {v2, v3}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    move-result-object v2

    .line 729
    invoke-virtual {v1, v2}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 731
    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$15;->this$0:Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->access$0(Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;)Landroid/content/Context;

    move-result-object v1

    const-string v2, "share"

    invoke-static {v1, v2}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 732
    return-void
.end method
