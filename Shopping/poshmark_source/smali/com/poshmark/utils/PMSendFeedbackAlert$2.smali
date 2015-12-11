.class Lcom/poshmark/utils/PMSendFeedbackAlert$2;
.super Ljava/lang/Object;
.source "PMSendFeedbackAlert.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/PMSendFeedbackAlert;->onCreateDialog(Landroid/os/Bundle;)Landroid/app/Dialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/PMSendFeedbackAlert;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/PMSendFeedbackAlert;)V
    .locals 0

    .prologue
    .line 51
    iput-object p1, p0, Lcom/poshmark/utils/PMSendFeedbackAlert$2;->this$0:Lcom/poshmark/utils/PMSendFeedbackAlert;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v5, 0x0

    .line 54
    iget-object v1, p0, Lcom/poshmark/utils/PMSendFeedbackAlert$2;->this$0:Lcom/poshmark/utils/PMSendFeedbackAlert;

    invoke-virtual {v1}, Lcom/poshmark/utils/PMSendFeedbackAlert;->dismiss()V

    .line 55
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.SENDTO"

    const-string v2, "mailto"

    const-string v3, "support@poshmark.com"

    invoke-static {v2, v3, v5}, Landroid/net/Uri;->fromParts(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 56
    .local v0, "sendIntent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/poshmark/utils/PMSendFeedbackAlert$2;->this$0:Lcom/poshmark/utils/PMSendFeedbackAlert;

    invoke-virtual {v1, v0}, Lcom/poshmark/utils/PMSendFeedbackAlert;->startActivity(Landroid/content/Intent;)V

    .line 57
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    const-string v2, "listings_feed_screen"

    const-string v3, "app"

    const-string v4, "app_rating_send_feedback"

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 58
    return-void
.end method
