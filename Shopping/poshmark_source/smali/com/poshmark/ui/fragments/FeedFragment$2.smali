.class Lcom/poshmark/ui/fragments/FeedFragment$2;
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
    .line 105
    iput-object p1, p0, Lcom/poshmark/ui/fragments/FeedFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 108
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/FeedFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/FeedFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v2, "listing"

    const-string v3, "refresh_myfeed_clicked"

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 109
    const-string v0, "fd"

    invoke-static {v0}, Lcom/poshmark/http/api/PMApi;->getViewTrackingInfo(Ljava/lang/String;)V

    .line 110
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedFragment$2;->this$0:Lcom/poshmark/ui/fragments/FeedFragment;

    const/4 v1, 0x0

    # invokes: Lcom/poshmark/ui/fragments/FeedFragment;->getFeed(Z)V
    invoke-static {v0, v1}, Lcom/poshmark/ui/fragments/FeedFragment;->access$000(Lcom/poshmark/ui/fragments/FeedFragment;Z)V

    .line 111
    return-void
.end method
