.class Lcom/aio/downloader/adapter/AppListviewAdapter$1;
.super Landroid/os/Handler;
.source "AppListviewAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/adapter/AppListviewAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/AppListviewAdapter;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    .line 61
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/AppListviewAdapter$1;)Lcom/aio/downloader/adapter/AppListviewAdapter;
    .locals 1

    .prologue
    .line 61
    iget-object v0, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    return-object v0
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 7
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const/4 v6, 0x0

    .line 66
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 67
    iget v1, p1, Landroid/os/Message;->what:I

    packed-switch v1, :pswitch_data_0

    .line 124
    :goto_0
    return-void

    .line 69
    :pswitch_0
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$0(Lcom/aio/downloader/adapter/AppListviewAdapter;)Landroid/content/Context;

    move-result-object v1

    const-string v2, "Failed to connect server."

    invoke-static {v1, v2, v6}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    .line 70
    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 74
    :pswitch_1
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # invokes: Lcom/aio/downloader/adapter/AppListviewAdapter;->Mydialog()V
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$1(Lcom/aio/downloader/adapter/AppListviewAdapter;)V

    goto :goto_0

    .line 77
    :pswitch_2
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$2(Lcom/aio/downloader/adapter/AppListviewAdapter;Ljava/lang/Boolean;)V

    .line 79
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$0(Lcom/aio/downloader/adapter/AppListviewAdapter;)Landroid/content/Context;

    move-result-object v1

    .line 80
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "\'"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->sp2:Landroid/content/SharedPreferences;
    invoke-static {v3}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$3(Lcom/aio/downloader/adapter/AppListviewAdapter;)Landroid/content/SharedPreferences;

    move-result-object v3

    const-string v4, "appname"

    const-string v5, ": this app"

    invoke-interface {v3, v4, v5}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 81
    const-string v3, "\' is added to download queue."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    .line 80
    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 78
    invoke-static {v1, v2, v6}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v1

    .line 82
    invoke-virtual {v1}, Landroid/widget/Toast;->show()V

    .line 84
    new-instance v1, Ljava/lang/Thread;

    new-instance v2, Lcom/aio/downloader/adapter/AppListviewAdapter$1$1;

    invoke-direct {v2, p0}, Lcom/aio/downloader/adapter/AppListviewAdapter$1$1;-><init>(Lcom/aio/downloader/adapter/AppListviewAdapter$1;)V

    invoke-direct {v1, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 91
    invoke-virtual {v1}, Ljava/lang/Thread;->start()V

    .line 93
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 94
    .local v0, "ti":Landroid/content/Intent;
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "app1"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "app2"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 95
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "app3"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "app4"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 96
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "app5"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 98
    :cond_0
    const-string v1, "app"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 120
    :cond_1
    :goto_1
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$0(Lcom/aio/downloader/adapter/AppListviewAdapter;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 99
    :cond_2
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "game1"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3

    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "game2"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 100
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "game3"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3

    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "game4"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 101
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "game5"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 102
    :cond_3
    const-string v1, "game"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto :goto_1

    .line 103
    :cond_4
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "paid1"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_5

    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "paid2"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_5

    .line 104
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "paid3"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_5

    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "paid4"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_5

    .line 105
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "paid5"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 106
    :cond_5
    const-string v1, "paid_wyc"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_1

    .line 107
    :cond_6
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "adult1"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_7

    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "adult2"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_7

    .line 108
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "adult3"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_7

    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "adult4"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_8

    .line 109
    :cond_7
    const-string v1, "adult"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_1

    .line 112
    :cond_8
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "homeapp"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_9

    .line 113
    const-string v1, "homeapp"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_1

    .line 115
    :cond_9
    iget-object v1, p0, Lcom/aio/downloader/adapter/AppListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/AppListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/AppListviewAdapter;->apptag:Ljava/lang/String;
    invoke-static {v1}, Lcom/aio/downloader/adapter/AppListviewAdapter;->access$5(Lcom/aio/downloader/adapter/AppListviewAdapter;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "appsearch"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 117
    const-string v1, "hideappsearch"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    goto/16 :goto_1

    .line 67
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
