.class Lcom/poshmark/utils/PMSendFeedbackAlert$1;
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
    .line 41
    iput-object p1, p0, Lcom/poshmark/utils/PMSendFeedbackAlert$1;->this$0:Lcom/poshmark/utils/PMSendFeedbackAlert;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 44
    iget-object v0, p0, Lcom/poshmark/utils/PMSendFeedbackAlert$1;->this$0:Lcom/poshmark/utils/PMSendFeedbackAlert;

    invoke-virtual {v0}, Lcom/poshmark/utils/PMSendFeedbackAlert;->dismiss()V

    .line 45
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    const-string v1, "listings_feed_screen"

    const-string v2, "app"

    const-string v3, "app_rating_send_feedback_dismissed"

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 46
    return-void
.end method
