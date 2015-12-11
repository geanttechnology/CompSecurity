.class Lcom/aio/downloader/adapter/FunAllAdapter$8;
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

.field private url_like:Ljava/lang/String;

.field private final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/FunAllAdapter;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/FunAllAdapter$8;->this$0:Lcom/aio/downloader/adapter/FunAllAdapter;

    iput p2, p0, Lcom/aio/downloader/adapter/FunAllAdapter$8;->val$position:I

    .line 468
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/FunAllAdapter$8;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 470
    iget-object v0, p0, Lcom/aio/downloader/adapter/FunAllAdapter$8;->url_like:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 474
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v1, "http://welaf.com/fun/stat.php?type=like&serial="

    invoke-direct {v2, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 475
    iget-object v1, p0, Lcom/aio/downloader/adapter/FunAllAdapter$8;->this$0:Lcom/aio/downloader/adapter/FunAllAdapter;

    # getter for: Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/adapter/FunAllAdapter;->access$0(Lcom/aio/downloader/adapter/FunAllAdapter;)Ljava/util/List;

    move-result-object v1

    iget v3, p0, Lcom/aio/downloader/adapter/FunAllAdapter$8;->val$position:I

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v1}, Lcom/aio/downloader/model/FunModel;->getSerial()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 474
    iput-object v1, p0, Lcom/aio/downloader/adapter/FunAllAdapter$8;->url_like:Ljava/lang/String;

    .line 476
    new-instance v1, Lcom/aio/downloader/adapter/FunAllAdapter$8$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/adapter/FunAllAdapter$8$1;-><init>(Lcom/aio/downloader/adapter/FunAllAdapter$8;)V

    .line 486
    invoke-virtual {v1}, Lcom/aio/downloader/adapter/FunAllAdapter$8$1;->start()V

    .line 487
    iget-object v1, p0, Lcom/aio/downloader/adapter/FunAllAdapter$8;->this$0:Lcom/aio/downloader/adapter/FunAllAdapter;

    # getter for: Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/adapter/FunAllAdapter;->access$0(Lcom/aio/downloader/adapter/FunAllAdapter;)Ljava/util/List;

    move-result-object v1

    iget v2, p0, Lcom/aio/downloader/adapter/FunAllAdapter$8;->val$position:I

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/FunModel;

    invoke-virtual {v1}, Lcom/aio/downloader/model/FunModel;->isLikenum()Z

    move-result v1

    if-nez v1, :cond_0

    .line 488
    iget-object v1, p0, Lcom/aio/downloader/adapter/FunAllAdapter$8;->this$0:Lcom/aio/downloader/adapter/FunAllAdapter;

    # getter for: Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/adapter/FunAllAdapter;->access$0(Lcom/aio/downloader/adapter/FunAllAdapter;)Ljava/util/List;

    move-result-object v1

    iget v2, p0, Lcom/aio/downloader/adapter/FunAllAdapter$8;->val$position:I

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/FunModel;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/aio/downloader/model/FunModel;->setLikenum(Z)V

    move-object v0, p1

    .line 489
    check-cast v0, Landroid/widget/ImageView;

    .line 490
    .local v0, "imageView":Landroid/widget/ImageView;
    const v1, 0x7f0200bd

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 496
    :goto_0
    return-void

    .line 492
    .end local v0    # "imageView":Landroid/widget/ImageView;
    :cond_0
    iget-object v1, p0, Lcom/aio/downloader/adapter/FunAllAdapter$8;->this$0:Lcom/aio/downloader/adapter/FunAllAdapter;

    # getter for: Lcom/aio/downloader/adapter/FunAllAdapter;->list:Ljava/util/List;
    invoke-static {v1}, Lcom/aio/downloader/adapter/FunAllAdapter;->access$0(Lcom/aio/downloader/adapter/FunAllAdapter;)Ljava/util/List;

    move-result-object v1

    iget v2, p0, Lcom/aio/downloader/adapter/FunAllAdapter$8;->val$position:I

    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/model/FunModel;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/aio/downloader/model/FunModel;->setLikenum(Z)V

    move-object v0, p1

    .line 493
    check-cast v0, Landroid/widget/ImageView;

    .line 494
    .restart local v0    # "imageView":Landroid/widget/ImageView;
    const v1, 0x7f0200bc

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0
.end method
