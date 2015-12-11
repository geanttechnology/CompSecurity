.class Lcom/aio/downloader/activity/MinigamesSearchResultActivity$1;
.super Ljava/lang/Object;
.source "MinigamesSearchResultActivity.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->init()V
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
.field final synthetic this$0:Lcom/aio/downloader/activity/MinigamesSearchResultActivity;


# direct methods
.method constructor <init>(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$1;->this$0:Lcom/aio/downloader/activity/MinigamesSearchResultActivity;

    .line 78
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 3
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
    .line 81
    .local p1, "arg0":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$1;->this$0:Lcom/aio/downloader/activity/MinigamesSearchResultActivity;

    const-class v2, Lcom/aio/downloader/activity/MiniGameDetails;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 82
    .local v0, "tidetail":Landroid/content/Intent;
    const-string v1, "pos"

    invoke-virtual {v0, v1, p3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 83
    const-string v1, "list"

    iget-object v2, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$1;->this$0:Lcom/aio/downloader/activity/MinigamesSearchResultActivity;

    # getter for: Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->list:Ljava/util/ArrayList;
    invoke-static {v2}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->access$6(Lcom/aio/downloader/activity/MinigamesSearchResultActivity;)Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 84
    iget-object v1, p0, Lcom/aio/downloader/activity/MinigamesSearchResultActivity$1;->this$0:Lcom/aio/downloader/activity/MinigamesSearchResultActivity;

    invoke-virtual {v1, v0}, Lcom/aio/downloader/activity/MinigamesSearchResultActivity;->startActivity(Landroid/content/Intent;)V

    .line 85
    return-void
.end method
