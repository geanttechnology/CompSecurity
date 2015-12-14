.class Lcom/livemixtapes/NowPlayingActivity$2;
.super Ljava/lang/Object;
.source "NowPlayingActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/NowPlayingActivity;->setListeners()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/NowPlayingActivity;


# direct methods
.method constructor <init>(Lcom/livemixtapes/NowPlayingActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/NowPlayingActivity$2;->this$0:Lcom/livemixtapes/NowPlayingActivity;

    .line 532
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 535
    # getter for: Lcom/livemixtapes/NowPlayingActivity;->playing:Ljava/lang/Boolean;
    invoke-static {}, Lcom/livemixtapes/NowPlayingActivity;->access$0()Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x0

    :goto_0
    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v1}, Lcom/livemixtapes/NowPlayingActivity;->access$1(Ljava/lang/Boolean;)V

    .line 536
    # getter for: Lcom/livemixtapes/NowPlayingActivity;->playing:Ljava/lang/Boolean;
    invoke-static {}, Lcom/livemixtapes/NowPlayingActivity;->access$0()Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 538
    :try_start_0
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.livemixtapes.action.PLAY"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 539
    .local v0, "i":Landroid/content/Intent;
    const-string v1, "com.livemixtapes"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 540
    sget-object v1, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 544
    .end local v0    # "i":Landroid/content/Intent;
    :goto_1
    sget-object v1, Lcom/livemixtapes/NowPlayingActivity;->playOrPause:Lcom/livemixtapes/ui/FadeImageButton;

    const v2, 0x7f02008e

    invoke-virtual {v1, v2}, Lcom/livemixtapes/ui/FadeImageButton;->setImageResource(I)V

    .line 561
    :goto_2
    return-void

    .line 535
    :cond_0
    const/4 v1, 0x1

    goto :goto_0

    .line 550
    :cond_1
    :try_start_1
    new-instance v0, Landroid/content/Intent;

    const-string v1, "com.livemixtapes.action.PAUSE"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 551
    .restart local v0    # "i":Landroid/content/Intent;
    const-string v1, "com.livemixtapes"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setPackage(Ljava/lang/String;)Landroid/content/Intent;

    .line 552
    sget-object v1, Lcom/livemixtapes/App;->context:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->startService(Landroid/content/Intent;)Landroid/content/ComponentName;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    .line 559
    .end local v0    # "i":Landroid/content/Intent;
    :goto_3
    sget-object v1, Lcom/livemixtapes/NowPlayingActivity;->playOrPause:Lcom/livemixtapes/ui/FadeImageButton;

    const v2, 0x7f02008f

    invoke-virtual {v1, v2}, Lcom/livemixtapes/ui/FadeImageButton;->setImageResource(I)V

    goto :goto_2

    .line 555
    :catch_0
    move-exception v1

    goto :goto_3

    .line 542
    :catch_1
    move-exception v1

    goto :goto_1
.end method
