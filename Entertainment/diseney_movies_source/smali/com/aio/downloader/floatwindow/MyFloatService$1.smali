.class Lcom/aio/downloader/floatwindow/MyFloatService$1;
.super Landroid/content/BroadcastReceiver;
.source "MyFloatService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/floatwindow/MyFloatService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/floatwindow/MyFloatService;


# direct methods
.method constructor <init>(Lcom/aio/downloader/floatwindow/MyFloatService;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/floatwindow/MyFloatService$1;->this$0:Lcom/aio/downloader/floatwindow/MyFloatService;

    .line 169
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    const/high16 v4, 0x10000000

    .line 173
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    const-string v3, "home"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 174
    const-string v2, "floattag"

    const-string v3, "floattag++home"

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 175
    iget-object v2, p0, Lcom/aio/downloader/floatwindow/MyFloatService$1;->this$0:Lcom/aio/downloader/floatwindow/MyFloatService;

    invoke-virtual {v2}, Lcom/aio/downloader/floatwindow/MyFloatService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/aio/downloader/floatwindow/MyFloatService;->collapseStatusBar(Landroid/content/Context;)V

    .line 176
    new-instance p2, Landroid/content/Intent;

    .end local p2    # "intent":Landroid/content/Intent;
    iget-object v2, p0, Lcom/aio/downloader/floatwindow/MyFloatService$1;->this$0:Lcom/aio/downloader/floatwindow/MyFloatService;

    invoke-virtual {v2}, Lcom/aio/downloader/floatwindow/MyFloatService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 177
    const-class v3, Lcom/aio/downloader/activity/MyMainActivity;

    .line 176
    invoke-direct {p2, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 178
    .restart local p2    # "intent":Landroid/content/Intent;
    const-string v2, "acquire_url_start"

    const-string v3, ""

    invoke-virtual {p2, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 179
    invoke-virtual {p2, v4}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 180
    iget-object v2, p0, Lcom/aio/downloader/floatwindow/MyFloatService$1;->this$0:Lcom/aio/downloader/floatwindow/MyFloatService;

    invoke-virtual {v2, p2}, Lcom/aio/downloader/floatwindow/MyFloatService;->startActivity(Landroid/content/Intent;)V

    .line 211
    :cond_0
    :goto_0
    return-void

    .line 182
    :cond_1
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    const-string v3, "boost"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 183
    iget-object v2, p0, Lcom/aio/downloader/floatwindow/MyFloatService$1;->this$0:Lcom/aio/downloader/floatwindow/MyFloatService;

    invoke-virtual {v2}, Lcom/aio/downloader/floatwindow/MyFloatService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/aio/downloader/floatwindow/MyFloatService;->collapseStatusBar(Landroid/content/Context;)V

    .line 184
    new-instance p2, Landroid/content/Intent;

    .end local p2    # "intent":Landroid/content/Intent;
    iget-object v2, p0, Lcom/aio/downloader/floatwindow/MyFloatService$1;->this$0:Lcom/aio/downloader/floatwindow/MyFloatService;

    invoke-virtual {v2}, Lcom/aio/downloader/floatwindow/MyFloatService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 185
    const-class v3, Lcom/aio/downloader/cleaner/PhoneBoostActivity;

    .line 184
    invoke-direct {p2, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 186
    .restart local p2    # "intent":Landroid/content/Intent;
    invoke-virtual {p2, v4}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 187
    iget-object v2, p0, Lcom/aio/downloader/floatwindow/MyFloatService$1;->this$0:Lcom/aio/downloader/floatwindow/MyFloatService;

    invoke-virtual {v2, p2}, Lcom/aio/downloader/floatwindow/MyFloatService;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 188
    :cond_2
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    const-string v3, "games"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 189
    iget-object v2, p0, Lcom/aio/downloader/floatwindow/MyFloatService$1;->this$0:Lcom/aio/downloader/floatwindow/MyFloatService;

    invoke-virtual {v2}, Lcom/aio/downloader/floatwindow/MyFloatService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/aio/downloader/floatwindow/MyFloatService;->collapseStatusBar(Landroid/content/Context;)V

    .line 190
    new-instance p2, Landroid/content/Intent;

    .end local p2    # "intent":Landroid/content/Intent;
    iget-object v2, p0, Lcom/aio/downloader/floatwindow/MyFloatService$1;->this$0:Lcom/aio/downloader/floatwindow/MyFloatService;

    invoke-virtual {v2}, Lcom/aio/downloader/floatwindow/MyFloatService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 191
    const-class v3, Lcom/aio/downloader/activity/GameActivity1;

    .line 190
    invoke-direct {p2, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 192
    .restart local p2    # "intent":Landroid/content/Intent;
    invoke-virtual {p2, v4}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 193
    iget-object v2, p0, Lcom/aio/downloader/floatwindow/MyFloatService$1;->this$0:Lcom/aio/downloader/floatwindow/MyFloatService;

    invoke-virtual {v2, p2}, Lcom/aio/downloader/floatwindow/MyFloatService;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 194
    :cond_3
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    const-string v3, "camera"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 195
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 196
    .local v1, "i":Landroid/content/Intent;
    const-string v2, "android.media.action.STILL_IMAGE_CAMERA"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 197
    invoke-virtual {v1, v4}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 198
    iget-object v2, p0, Lcom/aio/downloader/floatwindow/MyFloatService$1;->this$0:Lcom/aio/downloader/floatwindow/MyFloatService;

    invoke-virtual {v2, v1}, Lcom/aio/downloader/floatwindow/MyFloatService;->startActivity(Landroid/content/Intent;)V

    goto :goto_0

    .line 199
    .end local v1    # "i":Landroid/content/Intent;
    :cond_4
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    const-string v3, "set"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 200
    iget-object v2, p0, Lcom/aio/downloader/floatwindow/MyFloatService$1;->this$0:Lcom/aio/downloader/floatwindow/MyFloatService;

    invoke-virtual {v2}, Lcom/aio/downloader/floatwindow/MyFloatService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/aio/downloader/floatwindow/MyFloatService;->collapseStatusBar(Landroid/content/Context;)V

    .line 201
    new-instance p2, Landroid/content/Intent;

    .end local p2    # "intent":Landroid/content/Intent;
    iget-object v2, p0, Lcom/aio/downloader/floatwindow/MyFloatService$1;->this$0:Lcom/aio/downloader/floatwindow/MyFloatService;

    invoke-virtual {v2}, Lcom/aio/downloader/floatwindow/MyFloatService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    .line 202
    const-class v3, Lcom/aio/downloader/activity/Noti_Set_Activity;

    .line 201
    invoke-direct {p2, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 203
    .restart local p2    # "intent":Landroid/content/Intent;
    invoke-virtual {p2, v4}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 204
    iget-object v2, p0, Lcom/aio/downloader/floatwindow/MyFloatService$1;->this$0:Lcom/aio/downloader/floatwindow/MyFloatService;

    invoke-virtual {v2, p2}, Lcom/aio/downloader/floatwindow/MyFloatService;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 205
    :cond_5
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    const-string v3, "flash"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 206
    iget-object v2, p0, Lcom/aio/downloader/floatwindow/MyFloatService$1;->this$0:Lcom/aio/downloader/floatwindow/MyFloatService;

    invoke-virtual {v2}, Lcom/aio/downloader/floatwindow/MyFloatService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/aio/downloader/floatwindow/MyFloatService;->collapseStatusBar(Landroid/content/Context;)V

    .line 207
    new-instance v0, Landroid/content/Intent;

    const-string v2, "android.intent.action.SET_ALARM"

    invoke-direct {v0, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 208
    .local v0, "alarms":Landroid/content/Intent;
    invoke-virtual {v0, v4}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 209
    iget-object v2, p0, Lcom/aio/downloader/floatwindow/MyFloatService$1;->this$0:Lcom/aio/downloader/floatwindow/MyFloatService;

    invoke-virtual {v2, v0}, Lcom/aio/downloader/floatwindow/MyFloatService;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0
.end method
