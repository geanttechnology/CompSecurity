.class Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderService$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderService;->onHandleIntent(Landroid/content/Intent;)V
.end annotation


# instance fields
.field final synthetic a:Landroid/content/Intent;

.field final synthetic b:Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderService;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderService;Landroid/content/Intent;)V
    .locals 0

    .prologue
    .line 25
    iput-object p1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderService$1;->b:Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderService;

    iput-object p2, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderService$1;->a:Landroid/content/Intent;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 28
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderService$1;->b:Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderService;

    invoke-virtual {v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderService;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 29
    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderService$1;->a:Landroid/content/Intent;

    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 30
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 31
    iget-object v1, p0, Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderService$1;->b:Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderService;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistReminderService;->startActivity(Landroid/content/Intent;)V

    .line 32
    return-void
.end method
