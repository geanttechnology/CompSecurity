.class Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->a()V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;)V
    .locals 0

    .prologue
    .line 567
    iput-object p1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$1;->a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5

    .prologue
    .line 570
    invoke-static {}, Lcom/inc247/ApplicationStatusModel/ChatRunningStatus;->getChatRunning()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 572
    invoke-static {}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->c()Lcom/inc247/ChatSDK;

    move-result-object v0

    invoke-virtual {v0}, Lcom/inc247/ChatSDK;->maximizeChat()V

    .line 578
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$1;->a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;

    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService$1;->a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;

    invoke-virtual {v2}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const-class v3, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;->stopService(Landroid/content/Intent;)Z

    .line 579
    return-void

    .line 574
    :cond_0
    const/4 v0, 0x1

    invoke-static {v0}, Lcom/inc247/ApplicationStatusModel/ChatRunningStatus;->setChatRunning(Z)V

    .line 575
    invoke-static {}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->c()Lcom/inc247/ChatSDK;

    move-result-object v0

    invoke-static {}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->e()Lorg/json/JSONObject;

    move-result-object v1

    invoke-static {}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->f()Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    move-result-object v2

    invoke-static {}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->g()Lorg/json/JSONObject;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/inc247/ChatSDK;->startChat(Lorg/json/JSONObject;Landroid/app/Activity;Lorg/json/JSONObject;Z)V

    goto :goto_0
.end method
