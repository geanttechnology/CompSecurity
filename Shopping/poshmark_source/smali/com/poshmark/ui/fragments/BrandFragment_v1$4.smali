.class Lcom/poshmark/ui/fragments/BrandFragment_v1$4;
.super Ljava/lang/Object;
.source "BrandFragment_v1.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/BrandFragment_v1;->setupHeaderViewHolder(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/BrandFragment_v1;)V
    .locals 0

    .prologue
    .line 284
    iput-object p1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1$4;->this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 287
    iget-object v1, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1$4;->this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;

    # getter for: Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandHeaderViewHolder:Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;
    invoke-static {v1}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->access$500(Lcom/poshmark/ui/fragments/BrandFragment_v1;)Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;

    move-result-object v1

    iget-object v1, v1, Lcom/poshmark/utils/view_holders/BrandHeaderViewHolder;->shareTriggerLayout:Landroid/widget/RelativeLayout;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 288
    invoke-static {}, Lcom/poshmark/triggers/PMTriggerManager;->getGlobalTriggerManager()Lcom/poshmark/triggers/PMTriggerManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/triggers/PMTriggerManager;->getBrandShareTrigger()Lcom/poshmark/triggers/BrandShareTrigger;

    move-result-object v0

    .line 289
    .local v0, "trigger":Lcom/poshmark/triggers/BrandShareTrigger;
    if-eqz v0, :cond_0

    .line 290
    sget-object v1, Lcom/poshmark/triggers/PMTrigger$TriggerState;->DISMISSED:Lcom/poshmark/triggers/PMTrigger$TriggerState;

    invoke-virtual {v0, v1}, Lcom/poshmark/triggers/BrandShareTrigger;->setNewState(Lcom/poshmark/triggers/PMTrigger$TriggerState;)V

    .line 291
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1$4;->this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/BrandFragment_v1;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "brand"

    const-string v4, "brand_share_banner_close_button_tapped"

    iget-object v5, p0, Lcom/poshmark/ui/fragments/BrandFragment_v1$4;->this$0:Lcom/poshmark/ui/fragments/BrandFragment_v1;

    # getter for: Lcom/poshmark/ui/fragments/BrandFragment_v1;->brandName:Ljava/lang/String;
    invoke-static {v5}, Lcom/poshmark/ui/fragments/BrandFragment_v1;->access$200(Lcom/poshmark/ui/fragments/BrandFragment_v1;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 294
    :cond_0
    return-void
.end method
