.class Lcom/aio/downloader/adapter/FunAllAdapter$2;
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

.field private url_pics_bt:Ljava/lang/String;

.field private final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/FunAllAdapter;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/FunAllAdapter$2;->this$0:Lcom/aio/downloader/adapter/FunAllAdapter;

    iput p2, p0, Lcom/aio/downloader/adapter/FunAllAdapter$2;->val$position:I

    .line 272
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/FunAllAdapter$2;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 274
    iget-object v0, p0, Lcom/aio/downloader/adapter/FunAllAdapter$2;->url_pics_bt:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 279
    const-string v2, "www"

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v1, "(Serializable) Myutils.list_array="

    invoke-direct {v3, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 280
    iget-object v1, p0, Lcom/aio/downloader/adapter/FunAllAdapter$2;->this$0:Lcom/aio/downloader/adapter/FunAllAdapter;

    # getter for: Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/adapter/FunAllAdapter;->access$0(Lcom/aio/downloader/adapter/FunAllAdapter;)Ljava/util/List;

    move-result-object v1

    iget v4, p0, Lcom/aio/downloader/adapter/FunAllAdapter$2;->val$position:I

    invoke-interface {v1, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v1}, Lcom/aio/downloader/model/FunModel;->getFunlist()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 279
    invoke-static {v2, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 281
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v1, "http://welaf.com/fun/stat.php?type=hit&serial="

    invoke-direct {v2, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 282
    iget-object v1, p0, Lcom/aio/downloader/adapter/FunAllAdapter$2;->this$0:Lcom/aio/downloader/adapter/FunAllAdapter;

    # getter for: Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/adapter/FunAllAdapter;->access$0(Lcom/aio/downloader/adapter/FunAllAdapter;)Ljava/util/List;

    move-result-object v1

    iget v3, p0, Lcom/aio/downloader/adapter/FunAllAdapter$2;->val$position:I

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v1}, Lcom/aio/downloader/model/FunModel;->getSerial()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 281
    iput-object v1, p0, Lcom/aio/downloader/adapter/FunAllAdapter$2;->url_pics_bt:Ljava/lang/String;

    .line 283
    new-instance v1, Lcom/aio/downloader/adapter/FunAllAdapter$2$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/adapter/FunAllAdapter$2$1;-><init>(Lcom/aio/downloader/adapter/FunAllAdapter$2;)V

    .line 293
    invoke-virtual {v1}, Lcom/aio/downloader/adapter/FunAllAdapter$2$1;->start()V

    .line 294
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/aio/downloader/adapter/FunAllAdapter$2;->this$0:Lcom/aio/downloader/adapter/FunAllAdapter;

    # getter for: Lcom/aio/downloader/adapter/FunAllAdapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/FunAllAdapter;->access$1(Lcom/aio/downloader/adapter/FunAllAdapter;)Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/aio/downloader/activity/FunImagePagerActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 295
    .local v0, "intent":Landroid/content/Intent;
    const-string v2, "screenshotlist"

    iget-object v1, p0, Lcom/aio/downloader/adapter/FunAllAdapter$2;->this$0:Lcom/aio/downloader/adapter/FunAllAdapter;

    # getter for: Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/adapter/FunAllAdapter;->access$0(Lcom/aio/downloader/adapter/FunAllAdapter;)Ljava/util/List;

    move-result-object v1

    iget v3, p0, Lcom/aio/downloader/adapter/FunAllAdapter$2;->val$position:I

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/FunModel;

    .line 296
    invoke-virtual {v1}, Lcom/aio/downloader/model/FunModel;->getFunlist()Ljava/util/ArrayList;

    move-result-object v1

    .line 295
    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 297
    const-string v2, "detailtitle"

    iget-object v1, p0, Lcom/aio/downloader/adapter/FunAllAdapter$2;->this$0:Lcom/aio/downloader/adapter/FunAllAdapter;

    # getter for: Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/adapter/FunAllAdapter;->access$0(Lcom/aio/downloader/adapter/FunAllAdapter;)Ljava/util/List;

    move-result-object v1

    iget v3, p0, Lcom/aio/downloader/adapter/FunAllAdapter$2;->val$position:I

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/FunModel;

    .line 298
    invoke-virtual {v1}, Lcom/aio/downloader/model/FunModel;->getTitle()Ljava/lang/String;

    move-result-object v1

    .line 297
    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 299
    const-string v2, "detailcount"

    iget-object v1, p0, Lcom/aio/downloader/adapter/FunAllAdapter$2;->this$0:Lcom/aio/downloader/adapter/FunAllAdapter;

    # getter for: Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/adapter/FunAllAdapter;->access$0(Lcom/aio/downloader/adapter/FunAllAdapter;)Ljava/util/List;

    move-result-object v1

    iget v3, p0, Lcom/aio/downloader/adapter/FunAllAdapter$2;->val$position:I

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/FunModel;

    .line 300
    invoke-virtual {v1}, Lcom/aio/downloader/model/FunModel;->getImg_count()I

    move-result v1

    .line 299
    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 301
    const-string v2, "detailserial"

    iget-object v1, p0, Lcom/aio/downloader/adapter/FunAllAdapter$2;->this$0:Lcom/aio/downloader/adapter/FunAllAdapter;

    # getter for: Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/adapter/FunAllAdapter;->access$0(Lcom/aio/downloader/adapter/FunAllAdapter;)Ljava/util/List;

    move-result-object v1

    iget v3, p0, Lcom/aio/downloader/adapter/FunAllAdapter$2;->val$position:I

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/FunModel;

    .line 302
    invoke-virtual {v1}, Lcom/aio/downloader/model/FunModel;->getSerial()Ljava/lang/String;

    move-result-object v1

    .line 301
    invoke-virtual {v0, v2, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 303
    const-string v1, "gag"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 304
    iget-object v1, p0, Lcom/aio/downloader/adapter/FunAllAdapter$2;->this$0:Lcom/aio/downloader/adapter/FunAllAdapter;

    # getter for: Lcom/aio/downloader/adapter/FunAllAdapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/FunAllAdapter;->access$1(Lcom/aio/downloader/adapter/FunAllAdapter;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 305
    return-void
.end method
