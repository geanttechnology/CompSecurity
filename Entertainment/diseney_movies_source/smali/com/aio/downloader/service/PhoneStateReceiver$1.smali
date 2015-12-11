.class Lcom/aio/downloader/service/PhoneStateReceiver$1;
.super Ljava/lang/Object;
.source "PhoneStateReceiver.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/service/PhoneStateReceiver;->onReceive(Landroid/content/Context;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/service/PhoneStateReceiver;

.field private final synthetic val$context:Landroid/content/Context;


# direct methods
.method constructor <init>(Lcom/aio/downloader/service/PhoneStateReceiver;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/service/PhoneStateReceiver$1;->this$0:Lcom/aio/downloader/service/PhoneStateReceiver;

    iput-object p2, p0, Lcom/aio/downloader/service/PhoneStateReceiver$1;->val$context:Landroid/content/Context;

    .line 85
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/service/PhoneStateReceiver$1;)Lcom/aio/downloader/service/PhoneStateReceiver;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/aio/downloader/service/PhoneStateReceiver$1;->this$0:Lcom/aio/downloader/service/PhoneStateReceiver;

    return-object v0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    const-wide/32 v4, 0x4e87bd

    .line 90
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v2

    packed-switch v2, :pswitch_data_0

    .line 156
    :goto_0
    :pswitch_0
    return-void

    .line 92
    :pswitch_1
    iget-object v2, p0, Lcom/aio/downloader/service/PhoneStateReceiver$1;->this$0:Lcom/aio/downloader/service/PhoneStateReceiver;

    # getter for: Lcom/aio/downloader/service/PhoneStateReceiver;->callerOutDialog:Lcom/aio/downloader/dialog/CallerOutDialog;
    invoke-static {v2}, Lcom/aio/downloader/service/PhoneStateReceiver;->access$0(Lcom/aio/downloader/service/PhoneStateReceiver;)Lcom/aio/downloader/dialog/CallerOutDialog;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/dialog/CallerOutDialog;->dismiss()V

    goto :goto_0

    .line 95
    :pswitch_2
    iget-object v2, p0, Lcom/aio/downloader/service/PhoneStateReceiver$1;->val$context:Landroid/content/Context;

    const-string v3, "call_state_ringing_click"

    invoke-static {v2, v3}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 98
    :try_start_0
    iget-object v2, p0, Lcom/aio/downloader/service/PhoneStateReceiver$1;->this$0:Lcom/aio/downloader/service/PhoneStateReceiver;

    # getter for: Lcom/aio/downloader/service/PhoneStateReceiver;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v2}, Lcom/aio/downloader/service/PhoneStateReceiver;->access$1(Lcom/aio/downloader/service/PhoneStateReceiver;)Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 99
    iget-object v2, p0, Lcom/aio/downloader/service/PhoneStateReceiver$1;->this$0:Lcom/aio/downloader/service/PhoneStateReceiver;

    iget-object v3, p0, Lcom/aio/downloader/service/PhoneStateReceiver$1;->this$0:Lcom/aio/downloader/service/PhoneStateReceiver;

    # getter for: Lcom/aio/downloader/service/PhoneStateReceiver;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v3}, Lcom/aio/downloader/service/PhoneStateReceiver;->access$1(Lcom/aio/downloader/service/PhoneStateReceiver;)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/service/PhoneStateReceiver;->getFileSizes(Ljava/io/File;)J

    move-result-wide v2

    cmp-long v2, v2, v4

    if-ltz v2, :cond_0

    .line 100
    new-instance v1, Landroid/content/Intent;

    .line 101
    const-string v2, "android.intent.action.VIEW"

    .line 100
    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 103
    .local v1, "intent":Landroid/content/Intent;
    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "file://"

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/aio/downloader/service/PhoneStateReceiver$1;->this$0:Lcom/aio/downloader/service/PhoneStateReceiver;

    # getter for: Lcom/aio/downloader/service/PhoneStateReceiver;->AIOCALLERAPK:Ljava/io/File;
    invoke-static {v3}, Lcom/aio/downloader/service/PhoneStateReceiver;->access$1(Lcom/aio/downloader/service/PhoneStateReceiver;)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    .line 104
    const-string v3, "application/vnd.android.package-archive"

    .line 102
    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->setDataAndType(Landroid/net/Uri;Ljava/lang/String;)Landroid/content/Intent;

    .line 105
    const/high16 v2, 0x10000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 106
    iget-object v2, p0, Lcom/aio/downloader/service/PhoneStateReceiver$1;->val$context:Landroid/content/Context;

    invoke-virtual {v2, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 150
    .end local v1    # "intent":Landroid/content/Intent;
    :goto_1
    iget-object v2, p0, Lcom/aio/downloader/service/PhoneStateReceiver$1;->this$0:Lcom/aio/downloader/service/PhoneStateReceiver;

    # getter for: Lcom/aio/downloader/service/PhoneStateReceiver;->callerOutDialog:Lcom/aio/downloader/dialog/CallerOutDialog;
    invoke-static {v2}, Lcom/aio/downloader/service/PhoneStateReceiver;->access$0(Lcom/aio/downloader/service/PhoneStateReceiver;)Lcom/aio/downloader/dialog/CallerOutDialog;

    move-result-object v2

    invoke-virtual {v2}, Lcom/aio/downloader/dialog/CallerOutDialog;->dismiss()V

    goto :goto_0

    .line 107
    :cond_0
    :try_start_1
    iget-object v2, p0, Lcom/aio/downloader/service/PhoneStateReceiver$1;->this$0:Lcom/aio/downloader/service/PhoneStateReceiver;

    # getter for: Lcom/aio/downloader/service/PhoneStateReceiver;->AIOCALLERDOWN:Ljava/io/File;
    invoke-static {v2}, Lcom/aio/downloader/service/PhoneStateReceiver;->access$2(Lcom/aio/downloader/service/PhoneStateReceiver;)Ljava/io/File;

    move-result-object v2

    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 108
    iget-object v2, p0, Lcom/aio/downloader/service/PhoneStateReceiver$1;->this$0:Lcom/aio/downloader/service/PhoneStateReceiver;

    iget-object v3, p0, Lcom/aio/downloader/service/PhoneStateReceiver$1;->this$0:Lcom/aio/downloader/service/PhoneStateReceiver;

    # getter for: Lcom/aio/downloader/service/PhoneStateReceiver;->AIOCALLERDOWN:Ljava/io/File;
    invoke-static {v3}, Lcom/aio/downloader/service/PhoneStateReceiver;->access$2(Lcom/aio/downloader/service/PhoneStateReceiver;)Ljava/io/File;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/aio/downloader/service/PhoneStateReceiver;->getFileSizes(Ljava/io/File;)J

    move-result-wide v2

    cmp-long v2, v2, v4

    if-ltz v2, :cond_1

    .line 110
    new-instance v2, Lcom/aio/downloader/service/PhoneStateReceiver$1$1;

    iget-object v3, p0, Lcom/aio/downloader/service/PhoneStateReceiver$1;->val$context:Landroid/content/Context;

    invoke-direct {v2, p0, v3}, Lcom/aio/downloader/service/PhoneStateReceiver$1$1;-><init>(Lcom/aio/downloader/service/PhoneStateReceiver$1;Landroid/content/Context;)V

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Void;

    .line 136
    invoke-virtual {v2, v3}, Lcom/aio/downloader/service/PhoneStateReceiver$1$1;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    .line 146
    :catch_0
    move-exception v0

    .line 148
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1

    .line 139
    .end local v0    # "e":Ljava/lang/Exception;
    :cond_1
    :try_start_2
    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/aio/downloader/service/PhoneStateReceiver$1;->val$context:Landroid/content/Context;

    .line 140
    const-class v3, Lcom/aio/downloader/activity/AppDetailsActivity;

    .line 139
    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 141
    .restart local v1    # "intent":Landroid/content/Intent;
    const-string v2, "myid"

    .line 142
    const-string v3, "com.allinone.callerid"

    .line 141
    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 143
    const/high16 v2, 0x10000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 144
    iget-object v2, p0, Lcom/aio/downloader/service/PhoneStateReceiver$1;->val$context:Landroid/content/Context;

    invoke-virtual {v2, v1}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto :goto_1

    .line 90
    nop

    :pswitch_data_0
    .packed-switch 0x7f070368
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method
