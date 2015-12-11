.class Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$5;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;)V
    .locals 0

    .prologue
    .line 243
    iput-object p1, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$5;->a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 246
    invoke-static {}, Lcom/inc247/ApplicationStatusModel/ChatRunningStatus;->getChatRunning()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-static {}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->c()Lcom/inc247/ChatSDK;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 247
    invoke-static {}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->c()Lcom/inc247/ChatSDK;

    move-result-object v0

    invoke-virtual {v0}, Lcom/inc247/ChatSDK;->endChat()V

    .line 249
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$5;->a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->finish()V

    .line 250
    iget-object v0, p0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity$5;->a:Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    const v1, 0x7f040005

    const v2, 0x7f040008

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->overridePendingTransition(II)V

    .line 251
    return-void
.end method
