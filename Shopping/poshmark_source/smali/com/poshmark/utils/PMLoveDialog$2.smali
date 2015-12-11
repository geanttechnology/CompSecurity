.class Lcom/poshmark/utils/PMLoveDialog$2;
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
    .line 57
    iput-object p1, p0, Lcom/poshmark/utils/PMLoveDialog$2;->this$0:Lcom/poshmark/utils/PMLoveDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 60
    new-instance v0, Lcom/poshmark/utils/PMAppRateDialog;

    iget-object v1, p0, Lcom/poshmark/utils/PMLoveDialog$2;->this$0:Lcom/poshmark/utils/PMLoveDialog;

    iget-object v1, v1, Lcom/poshmark/utils/PMLoveDialog;->trigger:Lcom/poshmark/triggers/PMTrigger;

    invoke-direct {v0, v1}, Lcom/poshmark/utils/PMAppRateDialog;-><init>(Lcom/poshmark/triggers/PMTrigger;)V

    .line 61
    .local v0, "dlg":Lcom/poshmark/utils/PMAppRateDialog;
    iget-object v1, p0, Lcom/poshmark/utils/PMLoveDialog$2;->this$0:Lcom/poshmark/utils/PMLoveDialog;

    invoke-virtual {v1}, Lcom/poshmark/utils/PMLoveDialog;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    const-string v2, "appRateDlg"

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/utils/PMAppRateDialog;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 62
    iget-object v1, p0, Lcom/poshmark/utils/PMLoveDialog$2;->this$0:Lcom/poshmark/utils/PMLoveDialog;

    invoke-virtual {v1}, Lcom/poshmark/utils/PMLoveDialog;->dismiss()V

    .line 63
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    const-string v2, "listings_feed_screen"

    const-string v3, "app"

    const-string v4, "app_love_alert_yes_button_tapped"

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 64
    return-void
.end method
