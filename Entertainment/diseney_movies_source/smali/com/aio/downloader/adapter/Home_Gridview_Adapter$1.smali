.class Lcom/aio/downloader/adapter/Home_Gridview_Adapter$1;
.super Landroid/os/Handler;
.source "Home_Gridview_Adapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/adapter/Home_Gridview_Adapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$1;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    .line 57
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 7
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const/4 v2, 0x1

    const/4 v6, 0x0

    .line 61
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 62
    iget v1, p1, Landroid/os/Message;->what:I

    packed-switch v1, :pswitch_data_0

    .line 104
    :goto_0
    return-void

    .line 64
    :pswitch_0
    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$1;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$0(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Landroid/content/Context;

    move-result-object v1

    const-string v2, "Failed to connect server."

    invoke-static {v1, v2, v6}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    .line 65
    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 71
    :pswitch_1
    :try_start_0
    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$1;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$0(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Landroid/content/Context;

    move-result-object v1

    .line 72
    const-string v2, "It has been in downloading list already."

    const/4 v3, 0x1

    .line 71
    invoke-static {v1, v2, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    .line 73
    invoke-virtual {v1}, Landroid/widget/Toast;->show()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 74
    :catch_0
    move-exception v1

    goto :goto_0

    .line 79
    :pswitch_2
    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$1;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$1(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;Ljava/lang/Boolean;)V

    .line 81
    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$1;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$0(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Landroid/content/Context;

    move-result-object v1

    .line 82
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "\'"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$1;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->sp2:Landroid/content/SharedPreferences;
    invoke-static {v3}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$2(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Landroid/content/SharedPreferences;

    move-result-object v3

    const-string v4, "appname"

    const-string v5, "this app"

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 83
    const-string v3, "\' is added to download queue."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 82
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 80
    invoke-static {v1, v2, v6}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    .line 84
    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    .line 86
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 87
    .local v0, "ti":Landroid/content/Intent;
    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$1;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$3(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "appfeatured"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 88
    const-string v1, "appfeatured"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 89
    const-string v1, "app"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 100
    :cond_0
    :goto_1
    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$1;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$0(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 90
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$1;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$3(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "homefeatured"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 91
    const-string v1, "homeapp"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_1

    .line 92
    :cond_2
    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$1;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$3(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "gamefeatured"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 93
    const-string v1, "gamefeatured"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 94
    const-string v1, "game"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_1

    .line 95
    :cond_3
    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$1;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$3(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "homefeatured"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 96
    const-string v1, "homefeatured"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_1

    .line 97
    :cond_4
    iget-object v1, p0, Lcom/aio/downloader/adapter/Home_Gridview_Adapter$1;->this$0:Lcom/aio/downloader/adapter/Home_Gridview_Adapter;

    # getter for: Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/Home_Gridview_Adapter;->access$3(Lcom/aio/downloader/adapter/Home_Gridview_Adapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "appdetail"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 98
    const-string v1, "appdetail"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_1

    .line 62
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
