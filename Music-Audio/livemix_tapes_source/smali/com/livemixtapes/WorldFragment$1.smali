.class Lcom/livemixtapes/WorldFragment$1;
.super Ljava/lang/Object;
.source "WorldFragment.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/WorldFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
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
.field final synthetic this$0:Lcom/livemixtapes/WorldFragment;


# direct methods
.method constructor <init>(Lcom/livemixtapes/WorldFragment;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/WorldFragment$1;->this$0:Lcom/livemixtapes/WorldFragment;

    .line 55
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
    .line 59
    .line 60
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    invoke-virtual {p1, p3}, Landroid/widget/AdapterView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v1

    .line 59
    check-cast v1, Ljava/util/HashMap;

    .line 62
    .local v1, "newsMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v3, "mixtape_id"

    invoke-virtual {v1, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 64
    .local v0, "mixtape_id":Ljava/lang/String;
    if-eqz v0, :cond_0

    const-string v3, ""

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 65
    :cond_0
    new-instance v2, Landroid/content/Intent;

    const-string v4, "android.intent.action.VIEW"

    .line 66
    const-string v3, "url"

    invoke-virtual {v1, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    invoke-static {v3}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    .line 65
    invoke-direct {v2, v4, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 67
    .local v2, "urlIntent":Landroid/content/Intent;
    iget-object v3, p0, Lcom/livemixtapes/WorldFragment$1;->this$0:Lcom/livemixtapes/WorldFragment;

    invoke-virtual {v3, v2}, Lcom/livemixtapes/WorldFragment;->startActivity(Landroid/content/Intent;)V

    .line 72
    .end local v2    # "urlIntent":Landroid/content/Intent;
    :goto_0
    return-void

    .line 70
    :cond_1
    new-instance v3, Lcom/livemixtapes/WorldFragment$LoadDownloadData;

    iget-object v4, p0, Lcom/livemixtapes/WorldFragment$1;->this$0:Lcom/livemixtapes/WorldFragment;

    invoke-direct {v3, v4}, Lcom/livemixtapes/WorldFragment$LoadDownloadData;-><init>(Lcom/livemixtapes/WorldFragment;)V

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/String;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    invoke-virtual {v3, v4}, Lcom/livemixtapes/WorldFragment$LoadDownloadData;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method
