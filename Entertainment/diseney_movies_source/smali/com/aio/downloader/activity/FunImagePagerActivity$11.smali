.class Lcom/aio/downloader/activity/FunImagePagerActivity$11;
.super Ljava/lang/Object;
.source "FunImagePagerActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/FunImagePagerActivity;->onResume()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

.field private url_share:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/FunImagePagerActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$11;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    .line 569
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/FunImagePagerActivity$11;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 570
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$11;->url_share:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 575
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "http://welaf.com/fun/stat.php?type=share&serial="

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 576
    iget-object v3, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$11;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->detailserial:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$17(Lcom/aio/downloader/activity/FunImagePagerActivity;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 575
    iput-object v2, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$11;->url_share:Ljava/lang/String;

    .line 577
    new-instance v2, Lcom/aio/downloader/activity/FunImagePagerActivity$11$1;

    invoke-direct {v2, p0}, Lcom/aio/downloader/activity/FunImagePagerActivity$11$1;-><init>(Lcom/aio/downloader/activity/FunImagePagerActivity$11;)V

    .line 587
    invoke-virtual {v2}, Lcom/aio/downloader/activity/FunImagePagerActivity$11$1;->start()V

    .line 588
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "Share: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$11;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->detailtitle:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$18(Lcom/aio/downloader/activity/FunImagePagerActivity;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 589
    const-string v3, "\nhttp://welaf.com/fun/share.php?id="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 590
    iget-object v3, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$11;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->detailserial:Ljava/lang/String;
    invoke-static {v3}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$17(Lcom/aio/downloader/activity/FunImagePagerActivity;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 588
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 591
    .local v1, "share_t":Ljava/lang/String;
    new-instance v0, Landroid/content/Intent;

    const-string v2, "android.intent.action.SEND"

    invoke-direct {v0, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 592
    .local v0, "intent":Landroid/content/Intent;
    const-string v2, "text/plain"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 593
    const-string v2, "android.intent.extra.TEXT"

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 594
    iget-object v2, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$11;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    .line 595
    const-string v3, "AIO Downloaded"

    invoke-static {v0, v3}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v3

    .line 594
    invoke-virtual {v2, v3}, Lcom/aio/downloader/activity/FunImagePagerActivity;->startActivity(Landroid/content/Intent;)V

    .line 596
    return-void
.end method
