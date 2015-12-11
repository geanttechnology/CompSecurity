.class Lcom/aio/downloader/adapter/TodaypickListviewAdapter$1;
.super Landroid/os/Handler;
.source "TodaypickListviewAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/adapter/TodaypickListviewAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;


# direct methods
.method constructor <init>(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

    .line 49
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    return-void
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 6
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    const/4 v5, 0x0

    .line 54
    invoke-super {p0, p1}, Landroid/os/Handler;->handleMessage(Landroid/os/Message;)V

    .line 55
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 87
    :goto_0
    return-void

    .line 57
    :pswitch_0
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->access$0(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;)Landroid/content/Context;

    move-result-object v0

    const-string v1, "Failed to connect server."

    invoke-static {v0, v1, v5}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 58
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 62
    :pswitch_1
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

    # invokes: Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->Mydialog()V
    invoke-static {v0}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->access$1(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;)V

    goto :goto_0

    .line 65
    :pswitch_2
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->access$2(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;Ljava/lang/Boolean;)V

    .line 67
    iget-object v0, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->access$0(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;)Landroid/content/Context;

    move-result-object v0

    .line 68
    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "\'"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/adapter/TodaypickListviewAdapter$1;->this$0:Lcom/aio/downloader/adapter/TodaypickListviewAdapter;

    # getter for: Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->sp2:Landroid/content/SharedPreferences;
    invoke-static {v2}, Lcom/aio/downloader/adapter/TodaypickListviewAdapter;->access$3(Lcom/aio/downloader/adapter/TodaypickListviewAdapter;)Landroid/content/SharedPreferences;

    move-result-object v2

    const-string v3, "todayname"

    const-string v4, "this app"

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 69
    const-string v2, "\' is added to download queue."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 68
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 66
    invoke-static {v0, v1, v5}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    .line 70
    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    goto :goto_0

    .line 55
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
