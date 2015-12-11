.class Lcom/poshmark/ui/fragments/FeedFragment$3;
.super Ljava/lang/Object;
.source "FeedFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/FeedFragment;->setupActionBar()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/FeedFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/FeedFragment;)V
    .locals 0

    .prologue
    .line 116
    iput-object p1, p0, Lcom/poshmark/ui/fragments/FeedFragment$3;->this$0:Lcom/poshmark/ui/fragments/FeedFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 119
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedFragment$3;->this$0:Lcom/poshmark/ui/fragments/FeedFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/FeedFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "app"

    const-string v4, "search_listings_button_clicked"

    const/4 v5, 0x0

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 120
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 121
    .local v0, "b":Landroid/os/Bundle;
    const-string v1, "TAB_INDEX"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 122
    const-string v1, "com.poshmark.intents.SWITCH_TAB"

    invoke-static {v1, v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 124
    return-void
.end method
