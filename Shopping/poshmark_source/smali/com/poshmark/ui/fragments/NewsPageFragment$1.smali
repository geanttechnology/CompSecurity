.class Lcom/poshmark/ui/fragments/NewsPageFragment$1;
.super Ljava/lang/Object;
.source "NewsPageFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/NewsPageFragment;->setupActionBar()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/NewsPageFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/NewsPageFragment;)V
    .locals 0

    .prologue
    .line 51
    iput-object p1, p0, Lcom/poshmark/ui/fragments/NewsPageFragment$1;->this$0:Lcom/poshmark/ui/fragments/NewsPageFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 55
    sget-object v0, Lcom/poshmark/utils/NewRelicCustomInteractions;->NEWS_FEED_REFRESH:Ljava/lang/String;

    invoke-static {v0}, Lcom/poshmark/config/NewRelicWrapper;->startCustomInteraction(Ljava/lang/String;)V

    .line 56
    iget-object v0, p0, Lcom/poshmark/ui/fragments/NewsPageFragment$1;->this$0:Lcom/poshmark/ui/fragments/NewsPageFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/NewsPageFragment;->webView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->reload()V

    .line 57
    const-string v0, "com.poshmark.intents.CLEAR_NEWS_BADGE"

    invoke-static {v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 58
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/NewsPageFragment$1;->this$0:Lcom/poshmark/ui/fragments/NewsPageFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/NewsPageFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v2, "user"

    const-string v3, "refresh_news_clicked"

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 59
    return-void
.end method
