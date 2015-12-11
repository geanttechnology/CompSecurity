.class Lcom/poshmark/utils/PMAppRateDialog$2;
.super Ljava/lang/Object;
.source "PMAppRateDialog.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/PMAppRateDialog;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/PMAppRateDialog;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/PMAppRateDialog;)V
    .locals 0

    .prologue
    .line 57
    iput-object p1, p0, Lcom/poshmark/utils/PMAppRateDialog$2;->this$0:Lcom/poshmark/utils/PMAppRateDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 60
    iget-object v0, p0, Lcom/poshmark/utils/PMAppRateDialog$2;->this$0:Lcom/poshmark/utils/PMAppRateDialog;

    iget-object v0, v0, Lcom/poshmark/utils/PMAppRateDialog;->trigger:Lcom/poshmark/triggers/PMTrigger;

    sget-object v1, Lcom/poshmark/triggers/PMTrigger$TriggerState;->IGNORED:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    invoke-virtual {v0, v1}, Lcom/poshmark/triggers/PMTrigger;->setNewState(Lcom/poshmark/triggers/PMTrigger$TriggerState;)V

    .line 61
    iget-object v0, p0, Lcom/poshmark/utils/PMAppRateDialog$2;->this$0:Lcom/poshmark/utils/PMAppRateDialog;

    invoke-virtual {v0}, Lcom/poshmark/utils/PMAppRateDialog;->dismiss()V

    .line 62
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    const-string v1, "listings_feed_screen"

    const-string v2, "app"

    const-string v3, "app_rating_alert_remind_later_button_tapped"

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 63
    return-void
.end method
