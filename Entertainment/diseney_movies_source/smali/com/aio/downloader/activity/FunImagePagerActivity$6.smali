.class Lcom/aio/downloader/activity/FunImagePagerActivity$6;
.super Ljava/lang/Object;
.source "FunImagePagerActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/FunImagePagerActivity;->onPageSelected(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

.field private url_like:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/FunImagePagerActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$6;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    .line 444
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/activity/FunImagePagerActivity$6;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 445
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$6;->url_like:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 450
    iget-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$6;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->iv_fun_likeshow:Landroid/widget/ImageView;
    invoke-static {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$16(Lcom/aio/downloader/activity/FunImagePagerActivity;)Landroid/widget/ImageView;

    move-result-object v0

    const v1, 0x7f0200ba

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 451
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "http://welaf.com/fun/stat.php?type=like&serial="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 452
    iget-object v1, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$6;->this$0:Lcom/aio/downloader/activity/FunImagePagerActivity;

    # getter for: Lcom/aio/downloader/activity/FunImagePagerActivity;->detailserial:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/activity/FunImagePagerActivity;->access$17(Lcom/aio/downloader/activity/FunImagePagerActivity;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 451
    iput-object v0, p0, Lcom/aio/downloader/activity/FunImagePagerActivity$6;->url_like:Ljava/lang/String;

    .line 453
    new-instance v0, Lcom/aio/downloader/activity/FunImagePagerActivity$6$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/activity/FunImagePagerActivity$6$1;-><init>(Lcom/aio/downloader/activity/FunImagePagerActivity$6;)V

    .line 463
    invoke-virtual {v0}, Lcom/aio/downloader/activity/FunImagePagerActivity$6$1;->start()V

    .line 464
    return-void
.end method
