.class Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$12;
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

.field private url_video_bt:Ljava/lang/String;

.field private final synthetic val$ppp:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$12;->this$0:Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

    iput p2, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$12;->val$ppp:I

    .line 583
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$12;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 585
    iget-object v0, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$12;->url_video_bt:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 589
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v1, "http://welaf.com/fun/stat.php?type=hit&serial="

    invoke-direct {v2, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 590
    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$12;->this$0:Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->list_fun:Ljava/util/ArrayList;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->access$1(Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;)Ljava/util/ArrayList;

    move-result-object v1

    iget v3, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$12;->val$ppp:I

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/Fun_appModel;

    invoke-virtual {v1}, Lcom/aio/downloader/model/Fun_appModel;->getSerial()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 589
    iput-object v1, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$12;->url_video_bt:Ljava/lang/String;

    .line 591
    new-instance v1, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$12$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$12$1;-><init>(Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$12;)V

    .line 601
    invoke-virtual {v1}, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$12$1;->start()V

    .line 602
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$12;->this$0:Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->access$0(Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;)Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/aio/downloader/activity/ShowAideoActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 603
    .local v0, "intent":Landroid/content/Intent;
    const-string v2, "strurl"

    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$12;->this$0:Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->list_fun:Ljava/util/ArrayList;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->access$1(Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;)Ljava/util/ArrayList;

    move-result-object v1

    iget v3, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$12;->val$ppp:I

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/Fun_appModel;

    invoke-virtual {v1}, Lcom/aio/downloader/model/Fun_appModel;->getVideo_src()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 604
    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter$12;->this$0:Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;->access$0(Lcom/aio/downloader/adapter/Home_app_Listview_Adapter;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 605
    return-void
.end method
