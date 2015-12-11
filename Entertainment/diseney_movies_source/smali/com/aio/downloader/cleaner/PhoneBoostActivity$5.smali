.class Lcom/aio/downloader/cleaner/PhoneBoostActivity$5;
.super Ljava/lang/Object;
.source "PhoneBoostActivity.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/PhoneBoostActivity;->initView()V
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
.field final synthetic this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$5;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    .line 332
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 2
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
    .line 337
    .local p1, "arg0":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$5;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->listdata:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$1(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wjj/eneity/RuningApp;

    iget-boolean v0, v0, Lcom/wjj/eneity/RuningApp;->ischecked:Z

    if-eqz v0, :cond_0

    .line 338
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$5;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->listdata:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$1(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wjj/eneity/RuningApp;

    const/4 v1, 0x0

    iput-boolean v1, v0, Lcom/wjj/eneity/RuningApp;->ischecked:Z

    .line 339
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$5;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->adapter:Lcom/wjj/adapter/base/BoostPhoneAdapter;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$2(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Lcom/wjj/adapter/base/BoostPhoneAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wjj/adapter/base/BoostPhoneAdapter;->notifyDataSetChanged()V

    .line 344
    :goto_0
    return-void

    .line 341
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$5;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->listdata:Ljava/util/List;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$1(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/wjj/eneity/RuningApp;

    const/4 v1, 0x1

    iput-boolean v1, v0, Lcom/wjj/eneity/RuningApp;->ischecked:Z

    .line 342
    iget-object v0, p0, Lcom/aio/downloader/cleaner/PhoneBoostActivity$5;->this$0:Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    # getter for: Lcom/aio/downloader/cleaner/PhoneBoostActivity;->adapter:Lcom/wjj/adapter/base/BoostPhoneAdapter;
    invoke-static {v0}, Lcom/aio/downloader/cleaner/PhoneBoostActivity;->access$2(Lcom/aio/downloader/cleaner/PhoneBoostActivity;)Lcom/wjj/adapter/base/BoostPhoneAdapter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/wjj/adapter/base/BoostPhoneAdapter;->notifyDataSetChanged()V

    goto :goto_0
.end method
