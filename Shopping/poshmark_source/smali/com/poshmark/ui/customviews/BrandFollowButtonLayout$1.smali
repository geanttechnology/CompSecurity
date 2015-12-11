.class Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;
.super Ljava/lang/Object;
.source "BrandFollowButtonLayout.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->setup()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;)V
    .locals 0

    .prologue
    .line 71
    iput-object p1, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v4, 0x0

    .line 74
    iget-object v0, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    const/4 v1, 0x0

    # invokes: Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->setButtonVisibility(Z)V
    invoke-static {v0, v1}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->access$000(Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;Z)V

    .line 75
    iget-object v0, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    iget-boolean v0, v0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->isFollowing:Z

    if-nez v0, :cond_1

    .line 76
    iget-object v0, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->screenNameForAnalytics:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 77
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    iget-object v1, v1, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->screenNameForAnalytics:Ljava/lang/String;

    const-string v2, "brand"

    const-string v3, "brand_followed"

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 79
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->brandName:Ljava/lang/String;

    new-instance v1, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1$1;-><init>(Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->followBrand(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    .line 118
    :goto_0
    return-void

    .line 97
    :cond_1
    iget-object v0, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->screenNameForAnalytics:Ljava/lang/String;

    if-eqz v0, :cond_2

    .line 98
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    iget-object v1, v1, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->screenNameForAnalytics:Ljava/lang/String;

    const-string v2, "brand"

    const-string v3, "brand_unfollowed"

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 100
    :cond_2
    iget-object v0, p0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;->this$0:Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;

    iget-object v0, v0, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout;->brandName:Ljava/lang/String;

    new-instance v1, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1$2;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1$2;-><init>(Lcom/poshmark/ui/customviews/BrandFollowButtonLayout$1;)V

    invoke-static {v0, v1}, Lcom/poshmark/http/api/PMApi;->unFollowBrand(Ljava/lang/String;Lcom/poshmark/http/api/PMApiResponseHandler;)V

    goto :goto_0
.end method
