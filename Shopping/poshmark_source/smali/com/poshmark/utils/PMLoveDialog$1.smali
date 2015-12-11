.class Lcom/poshmark/utils/PMLoveDialog$1;
.super Ljava/lang/Object;
.source "PMLoveDialog.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/PMLoveDialog;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/PMLoveDialog;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/PMLoveDialog;)V
    .locals 0

    .prologue
    .line 43
    iput-object p1, p0, Lcom/poshmark/utils/PMLoveDialog$1;->this$0:Lcom/poshmark/utils/PMLoveDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v5, 0x0

    .line 46
    iget-object v1, p0, Lcom/poshmark/utils/PMLoveDialog$1;->this$0:Lcom/poshmark/utils/PMLoveDialog;

    iget-object v1, v1, Lcom/poshmark/utils/PMLoveDialog;->trigger:Lcom/poshmark/triggers/PMTrigger;

    sget-object v2, Lcom/poshmark/triggers/PMTrigger$TriggerState;->DISMISSED:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    invoke-virtual {v1, v2}, Lcom/poshmark/triggers/PMTrigger;->setNewState(Lcom/poshmark/triggers/PMTrigger$TriggerState;)V

    .line 47
    iget-object v1, p0, Lcom/poshmark/utils/PMLoveDialog$1;->this$0:Lcom/poshmark/utils/PMLoveDialog;

    invoke-virtual {v1}, Lcom/poshmark/utils/PMLoveDialog;->dismiss()V

    .line 48
    new-instance v0, Lcom/poshmark/utils/PMSendFeedbackAlert;

    invoke-direct {v0}, Lcom/poshmark/utils/PMSendFeedbackAlert;-><init>()V

    .line 49
    .local v0, "feedbackAlert":Lcom/poshmark/utils/PMSendFeedbackAlert;
    iget-object v1, p0, Lcom/poshmark/utils/PMLoveDialog$1;->this$0:Lcom/poshmark/utils/PMLoveDialog;

    invoke-virtual {v1}, Lcom/poshmark/utils/PMLoveDialog;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-string v2, "feedbackAlert"

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/utils/PMSendFeedbackAlert;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 50
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    const-string v2, "listings_feed_screen"

    const-string v3, "app"

    const-string v4, "app_love_alert_no_button_tapped"

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 51
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    const-string v2, "listings_feed_screen"

    const-string v3, "app"

    const-string v4, "app_rating_send_feedback_alert_displayed"

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 52
    return-void
.end method
