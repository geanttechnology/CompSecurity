.class Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$2;
.super Ljava/lang/Object;
.source "WidgetPaidGridviewAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;

.field private final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$2;->this$0:Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;

    iput p2, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$2;->val$position:I

    .line 289
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 294
    new-instance v0, Landroid/content/ComponentName;

    .line 295
    const-string v2, "com.aio.downloader"

    .line 296
    const-string v3, "com.aio.downloader.activity.AppDetailsActivity"

    .line 294
    invoke-direct {v0, v2, v3}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 297
    .local v0, "componetName":Landroid/content/ComponentName;
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 298
    .local v1, "intent2":Landroid/content/Intent;
    const-string v3, "myid"

    iget-object v2, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$2;->this$0:Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->list:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->access$4(Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;)Ljava/util/List;

    move-result-object v2

    iget v4, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$2;->val$position:I

    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/mydownload/DownloadMovieItem;

    invoke-virtual {v2}, Lcom/aio/downloader/mydownload/DownloadMovieItem;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v3, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 299
    const/4 v2, 0x0

    sput-boolean v2, Lcom/aio/downloader/utils/Myutils;->iswidget:Z

    .line 300
    const/high16 v2, 0x10000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 301
    invoke-virtual {v1, v0}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;

    .line 302
    iget-object v2, p0, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter$2;->this$0:Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;->access$0(Lcom/aio/downloader/adapter/WidgetPaidGridviewAdapter;)Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 360
    return-void
.end method
