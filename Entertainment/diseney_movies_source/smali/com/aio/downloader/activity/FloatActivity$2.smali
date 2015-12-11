.class Lcom/aio/downloader/activity/FloatActivity$2;
.super Ljava/lang/Object;
.source "FloatActivity.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/FloatActivity;->onResume()V
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
.field final synthetic this$0:Lcom/aio/downloader/activity/FloatActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/FloatActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/FloatActivity$2;->this$0:Lcom/aio/downloader/activity/FloatActivity;

    .line 407
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 5
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
    .line 414
    .local p1, "arg0":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    :try_start_0
    iget-object v2, p0, Lcom/aio/downloader/activity/FloatActivity$2;->this$0:Lcom/aio/downloader/activity/FloatActivity;

    invoke-virtual {v2}, Lcom/aio/downloader/activity/FloatActivity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    .line 416
    iget-object v2, p0, Lcom/aio/downloader/activity/FloatActivity$2;->this$0:Lcom/aio/downloader/activity/FloatActivity;

    # getter for: Lcom/aio/downloader/activity/FloatActivity;->list:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/activity/FloatActivity;->access$1(Lcom/aio/downloader/activity/FloatActivity;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/model/Programe;

    invoke-virtual {v2}, Lcom/aio/downloader/model/Programe;->getPackagename()Ljava/lang/String;

    move-result-object v2

    .line 415
    invoke-virtual {v3, v2}, Landroid/content/pm/PackageManager;->getLaunchIntentForPackage(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    .line 417
    .local v1, "intent":Landroid/content/Intent;
    const/high16 v2, 0x10000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 418
    iget-object v2, p0, Lcom/aio/downloader/activity/FloatActivity$2;->this$0:Lcom/aio/downloader/activity/FloatActivity;

    invoke-virtual {v2, v1}, Lcom/aio/downloader/activity/FloatActivity;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 426
    .end local v1    # "intent":Landroid/content/Intent;
    :goto_0
    return-void

    .line 419
    :catch_0
    move-exception v0

    .line 421
    .local v0, "e":Ljava/lang/Exception;
    iget-object v2, p0, Lcom/aio/downloader/activity/FloatActivity$2;->this$0:Lcom/aio/downloader/activity/FloatActivity;

    invoke-virtual {v2}, Lcom/aio/downloader/activity/FloatActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    .line 422
    new-instance v4, Ljava/lang/StringBuilder;

    iget-object v2, p0, Lcom/aio/downloader/activity/FloatActivity$2;->this$0:Lcom/aio/downloader/activity/FloatActivity;

    # getter for: Lcom/aio/downloader/activity/FloatActivity;->list:Ljava/util/List;
    invoke-static {v2}, Lcom/aio/downloader/activity/FloatActivity;->access$1(Lcom/aio/downloader/activity/FloatActivity;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/model/Programe;

    invoke-virtual {v2}, Lcom/aio/downloader/model/Programe;->getPackagename()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v4, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v2, " program is protected"

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const/4 v4, 0x0

    .line 421
    invoke-static {v3, v2, v4}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v2

    .line 423
    invoke-virtual {v2}, Landroid/widget/Toast;->show()V

    goto :goto_0
.end method
