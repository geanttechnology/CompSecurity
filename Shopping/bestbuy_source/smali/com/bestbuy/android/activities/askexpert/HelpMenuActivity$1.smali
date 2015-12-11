.class Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;)V
    .locals 0

    .prologue
    .line 101
    iput-object p1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$1;->a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 104
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$1;->a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    invoke-static {v0, v2}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->a(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;Z)Z

    .line 106
    invoke-static {}, Lcom/inc247/ApplicationStatusModel/ChatRunningStatus;->getChatRunning()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 108
    invoke-static {}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->c()Lcom/inc247/ChatSDK;

    move-result-object v0

    invoke-virtual {v0}, Lcom/inc247/ChatSDK;->maximizeChat()V

    .line 110
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$1;->a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    new-instance v1, Landroid/content/Intent;

    iget-object v2, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$1;->a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    invoke-virtual {v2}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    const-class v3, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$ChatBubbleService;

    invoke-direct {v1, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->stopService(Landroid/content/Intent;)Z

    .line 131
    :goto_0
    return-void

    .line 112
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$1;->a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    invoke-static {v0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->a(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 113
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$1;->a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    invoke-static {v0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->b(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;)Landroid/widget/ProgressBar;

    move-result-object v0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 115
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$1;->a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    const-string v1, "bestbuy-App-Sales"

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->a(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;Ljava/lang/String;)V

    goto :goto_0

    .line 117
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$1;->a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->a(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;Z)Z

    .line 118
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$1;->a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 119
    invoke-virtual {v0, v2}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    .line 120
    iget-object v1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$1;->a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    const v2, 0x7f080210

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 121
    const v1, 0x7f080283

    new-instance v2, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$1$1;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$1$1;-><init>(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$1;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNeutralButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 127
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 128
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    goto :goto_0
.end method
