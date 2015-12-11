.class Lcom/aio/downloader/adapter/FunAllAdapter$9;
.super Ljava/lang/Object;
.source "FunAllAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/adapter/FunAllAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/FunAllAdapter;

.field private url_share:Ljava/lang/String;

.field private final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/FunAllAdapter;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/FunAllAdapter$9;->this$0:Lcom/aio/downloader/adapter/FunAllAdapter;

    iput p2, p0, Lcom/aio/downloader/adapter/FunAllAdapter$9;->val$position:I

    .line 523
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/FunAllAdapter$9;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 525
    iget-object v0, p0, Lcom/aio/downloader/adapter/FunAllAdapter$9;->url_share:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 529
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v2, "http://welaf.com/fun/stat.php?type=share&serial="

    invoke-direct {v3, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 530
    iget-object v2, p0, Lcom/aio/downloader/adapter/FunAllAdapter$9;->this$0:Lcom/aio/downloader/adapter/FunAllAdapter;

    # getter for: Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/adapter/FunAllAdapter;->access$0(Lcom/aio/downloader/adapter/FunAllAdapter;)Ljava/util/List;

    move-result-object v2

    iget v4, p0, Lcom/aio/downloader/adapter/FunAllAdapter$9;->val$position:I

    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v2}, Lcom/aio/downloader/model/FunModel;->getSerial()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 529
    iput-object v2, p0, Lcom/aio/downloader/adapter/FunAllAdapter$9;->url_share:Ljava/lang/String;

    .line 531
    new-instance v2, Lcom/aio/downloader/adapter/FunAllAdapter$9$1;

    invoke-direct {v2, p0}, Lcom/aio/downloader/adapter/FunAllAdapter$9$1;-><init>(Lcom/aio/downloader/adapter/FunAllAdapter$9;)V

    .line 541
    invoke-virtual {v2}, Lcom/aio/downloader/adapter/FunAllAdapter$9$1;->start()V

    .line 542
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v2, "Share: "

    invoke-direct {v3, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/adapter/FunAllAdapter$9;->this$0:Lcom/aio/downloader/adapter/FunAllAdapter;

    # getter for: Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/adapter/FunAllAdapter;->access$0(Lcom/aio/downloader/adapter/FunAllAdapter;)Ljava/util/List;

    move-result-object v2

    iget v4, p0, Lcom/aio/downloader/adapter/FunAllAdapter$9;->val$position:I

    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v2}, Lcom/aio/downloader/model/FunModel;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 543
    const-string v3, "\nhttp://welaf.com/fun/share.php?id="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    .line 544
    iget-object v2, p0, Lcom/aio/downloader/adapter/FunAllAdapter$9;->this$0:Lcom/aio/downloader/adapter/FunAllAdapter;

    # getter for: Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/adapter/FunAllAdapter;->access$0(Lcom/aio/downloader/adapter/FunAllAdapter;)Ljava/util/List;

    move-result-object v2

    iget v4, p0, Lcom/aio/downloader/adapter/FunAllAdapter$9;->val$position:I

    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v2}, Lcom/aio/downloader/model/FunModel;->getSerial()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 542
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 545
    .local v1, "share_t":Ljava/lang/String;
    new-instance v0, Landroid/content/Intent;

    const-string v2, "android.intent.action.SEND"

    invoke-direct {v0, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 546
    .local v0, "intent":Landroid/content/Intent;
    const-string v2, "text/plain"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->setType(Ljava/lang/String;)Landroid/content/Intent;

    .line 547
    const-string v2, "android.intent.extra.TEXT"

    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 548
    iget-object v2, p0, Lcom/aio/downloader/adapter/FunAllAdapter$9;->this$0:Lcom/aio/downloader/adapter/FunAllAdapter;

    # getter for: Lcom/aio/downloader/adapter/FunAllAdapter;->ctx:Landroid/content/Context;
    invoke-static {v2}, Lcom/aio/downloader/adapter/FunAllAdapter;->access$1(Lcom/aio/downloader/adapter/FunAllAdapter;)Landroid/content/Context;

    move-result-object v2

    .line 549
    const-string v3, "AIO Downloaded"

    invoke-static {v0, v3}, Landroid/content/Intent;->createChooser(Landroid/content/Intent;Ljava/lang/CharSequence;)Landroid/content/Intent;

    move-result-object v3

    .line 548
    invoke-virtual {v2, v3}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 550
    return-void
.end method
