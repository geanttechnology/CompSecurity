.class Lcom/poshmark/ui/fragments/CameraFiltersFragment$8;
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
    .line 207
    iput-object p1, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 210
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    sget-object v2, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->FILTER_TYPE_CHIC:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    iput-object v2, v1, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->currentFilter:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    .line 211
    new-instance v1, Lcom/poshmark/ui/fragments/CameraFiltersFragment$ApplyFilter;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    const/4 v3, 0x0

    invoke-direct {v1, v2, v3}, Lcom/poshmark/ui/fragments/CameraFiltersFragment$ApplyFilter;-><init>(Lcom/poshmark/ui/fragments/CameraFiltersFragment;Lcom/poshmark/ui/fragments/CameraFiltersFragment$1;)V

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    iget-object v4, v4, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->currentFilter:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    instance-of v3, v1, Landroid/os/AsyncTask;

    if-nez v3, :cond_0

    invoke-virtual {v1, v2}, Lcom/poshmark/ui/fragments/CameraFiltersFragment$ApplyFilter;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 213
    :goto_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->currentFilter:Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;

    # invokes: Lcom/poshmark/ui/fragments/CameraFiltersFragment;->getFilterNameForType(Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;)Ljava/lang/String;
    invoke-static {v1, v2}, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->access$000(Lcom/poshmark/ui/fragments/CameraFiltersFragment;Lcom/poshmark/ui/fragments/CameraFiltersFragment$FilterType;)Ljava/lang/String;

    move-result-object v0

    .line 214
    .local v0, "label":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/CameraFiltersFragment$8;->this$0:Lcom/poshmark/ui/fragments/CameraFiltersFragment;

    iget-object v2, v2, Lcom/poshmark/ui/fragments/CameraFiltersFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "listing"

    const-string v4, "image_filter_preview"

    invoke-virtual {v1, v2, v3, v4, v0}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 215
    return-void

    .line 211
    .end local v0    # "label":Ljava/lang/String;
    :cond_0
    check-cast v1, Landroid/os/AsyncTask;

    invoke-static {v1, v2}, Lcom/newrelic/agent/android/instrumentation/AsyncTaskInstrumentation;->execute(Landroid/os/AsyncTask;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method
