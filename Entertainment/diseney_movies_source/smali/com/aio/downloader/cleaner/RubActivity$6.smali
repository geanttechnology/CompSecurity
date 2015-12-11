.class Lcom/aio/downloader/cleaner/RubActivity$6;
.super Ljava/lang/Object;
.source "RubActivity.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/cleaner/RubActivity;->onCreate(Landroid/os/Bundle;)V
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
.field final synthetic this$0:Lcom/aio/downloader/cleaner/RubActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/cleaner/RubActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/cleaner/RubActivity$6;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    .line 475
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 6
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
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
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 480
    iget-object v2, p0, Lcom/aio/downloader/cleaner/RubActivity$6;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->lv_process_list:Landroid/widget/ListView;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/RubActivity;->access$5(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/ListView;

    move-result-object v2

    invoke-virtual {v2, p3}, Landroid/widget/ListView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v0

    .line 481
    .local v0, "obj":Ljava/lang/Object;
    instance-of v2, v0, Lcom/aio/downloader/cleaner/TaskInfo;

    if-eqz v2, :cond_1

    .line 482
    iget-object v3, p0, Lcom/aio/downloader/cleaner/RubActivity$6;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    .line 483
    const v2, 0x7f070131

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/CheckBox;

    .line 482
    invoke-static {v3, v2}, Lcom/aio/downloader/cleaner/RubActivity;->access$23(Lcom/aio/downloader/cleaner/RubActivity;Landroid/widget/CheckBox;)V

    move-object v1, v0

    .line 484
    check-cast v1, Lcom/aio/downloader/cleaner/TaskInfo;

    .line 486
    .local v1, "taskInfo":Lcom/aio/downloader/cleaner/TaskInfo;
    const-string v2, "com.allinone.free"

    invoke-virtual {v1}, Lcom/aio/downloader/cleaner/TaskInfo;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 487
    const-string v2, "system"

    invoke-virtual {v1}, Lcom/aio/downloader/cleaner/TaskInfo;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 488
    const-string v2, "android.process.media"

    .line 489
    invoke-virtual {v1}, Lcom/aio/downloader/cleaner/TaskInfo;->getPackageName()Ljava/lang/String;

    move-result-object v3

    .line 488
    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    .line 489
    if-eqz v2, :cond_2

    .line 490
    :cond_0
    iget-object v2, p0, Lcom/aio/downloader/cleaner/RubActivity$6;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->cb_process_state:Landroid/widget/CheckBox;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/RubActivity;->access$24(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/CheckBox;

    move-result-object v2

    const/4 v3, 0x4

    invoke-virtual {v2, v3}, Landroid/widget/CheckBox;->setVisibility(I)V

    .line 504
    .end local v1    # "taskInfo":Lcom/aio/downloader/cleaner/TaskInfo;
    :cond_1
    :goto_0
    return-void

    .line 493
    .restart local v1    # "taskInfo":Lcom/aio/downloader/cleaner/TaskInfo;
    :cond_2
    invoke-virtual {v1}, Lcom/aio/downloader/cleaner/TaskInfo;->isCheck()Z

    move-result v2

    if-eqz v2, :cond_3

    .line 494
    invoke-virtual {v1, v4}, Lcom/aio/downloader/cleaner/TaskInfo;->setCheck(Z)V

    .line 495
    iget-object v2, p0, Lcom/aio/downloader/cleaner/RubActivity$6;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->cb_process_state:Landroid/widget/CheckBox;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/RubActivity;->access$24(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/CheckBox;

    move-result-object v2

    invoke-virtual {v2, v4}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto :goto_0

    .line 498
    :cond_3
    invoke-virtual {v1, v5}, Lcom/aio/downloader/cleaner/TaskInfo;->setCheck(Z)V

    .line 499
    iget-object v2, p0, Lcom/aio/downloader/cleaner/RubActivity$6;->this$0:Lcom/aio/downloader/cleaner/RubActivity;

    # getter for: Lcom/aio/downloader/cleaner/RubActivity;->cb_process_state:Landroid/widget/CheckBox;
    invoke-static {v2}, Lcom/aio/downloader/cleaner/RubActivity;->access$24(Lcom/aio/downloader/cleaner/RubActivity;)Landroid/widget/CheckBox;

    move-result-object v2

    invoke-virtual {v2, v5}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto :goto_0
.end method
