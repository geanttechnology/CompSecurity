.class Lcom/poshmark/ui/fragments/CameraFiltersFragment$3;
.super Ljava/lang/Object;
.source "CameraFiltersFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/CameraFiltersFragment;->setupFilterButtonHandlers()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/CameraFiltersFragment;)V
    .locals 0

    .prologue
    .line 147
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$3;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 150
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$3;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    sget-object v2, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->FILTER_TYPE_TIMELESS:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    iput-object v2, v1, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->currentFilter:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    .line 152
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$3;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$3;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->currentFilter:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    # invokes: Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getFilterNameForType(Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;)Ljava/lang/String;
    invoke-static {v1, v2}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->access$000(Lcom/poshmark/ui/fragments/CameraFiltersFragment;Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;)Ljava/lang/String;

    move-result-object v0

    .line 153
    .local v0, "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$3;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "listing"

    const-string v4, "image_filter_preview"

    invoke-virtual {v1, v2, v3, v4, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 154
    return-void
.end method
