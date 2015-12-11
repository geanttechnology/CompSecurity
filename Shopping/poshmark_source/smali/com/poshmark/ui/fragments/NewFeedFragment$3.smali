.class Lcom/poshmark/ui/fragments/NewFeedFragment$3;
.super Ljava/lang/Object;
.source "NewFeedFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/NewFeedFragment;->setupActionBar()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/NewFeedFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/NewFeedFragment;)V
    .locals 0

    .prologue
    .line 141
    iput-object p1, p0, Lcom/poshmark/ui/fragments/NewFeedFragment$3;->this$0:Lcom/poshmark/ui/fragments/NewFeedFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 144
    sget-object v0, Lcom/poshmark/utils/NewRelicCustomInteractions;->USER_TRIGGERED_FEED_REFRESH:Ljava/lang/String;

    invoke-static {v0}, Lcom/poshmark/config/NewRelicWrapper;->startCustomInteraction(Ljava/lang/String;)V

    .line 145
    iget-object v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment$3;->this$0:Lcom/poshmark/ui/fragments/NewFeedFragment;

    iget-object v0, v0, Lcom/poshmark/ui/fragments/NewFeedFragment;->newItemsBubble:Lcom/poshmark/ui/customviews/PMButton;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMButton;->setVisibility(I)V

    .line 146
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/NewFeedFragment$3;->this$0:Lcom/poshmark/ui/fragments/NewFeedFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/NewFeedFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v2, "listing"

    const-string v3, "refresh_myfeed_clicked"

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 147
    const-string v0, "fd"

    invoke-static {v0}, Lcom/poshmark/http/api/PMApi;->getViewTrackingInfo(Ljava/lang/String;)V

    .line 148
    iget-object v0, p0, Lcom/poshmark/ui/fragments/NewFeedFragment$3;->this$0:Lcom/poshmark/ui/fragments/NewFeedFragment;

    const/4 v1, 0x0

    # invokes: Lcom/poshmark/ui/fragments/NewFeedFragment;->getFeed(Z)V
    invoke-static {v0, v1}, Lcom/poshmark/ui/fragments/NewFeedFragment;->access$000(Lcom/poshmark/ui/fragments/NewFeedFragment;Z)V

    .line 149
    return-void
.end method
