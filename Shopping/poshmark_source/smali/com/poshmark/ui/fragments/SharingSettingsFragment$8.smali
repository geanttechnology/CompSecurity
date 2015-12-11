.class Lcom/poshmark/ui/fragments/SharingSettingsFragment$8;
.super Ljava/lang/Object;
.source "SharingSettingsFragment.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/ui/fragments/SharingSettingsFragment;->setSearchSettings(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/poshmark/http/api/PMApiResponseHandler",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

.field final synthetic val$bSearchVisibility:Z


# direct methods
.method constructor <init>(Lcom/poshmark/ui/fragments/SharingSettingsFragment;Z)V
    .locals 0

    .prologue
    .line 390
    iput-object p1, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$8;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    iput-boolean p2, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$8;->val$bSearchVisibility:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Ljava/lang/Void;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 393
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$8;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    # invokes: Lcom/poshmark/ui/fragments/SharingSettingsFragment;->handleChangeSettingsResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    invoke-static {v0, p1}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->access$900(Lcom/poshmark/ui/fragments/SharingSettingsFragment;Lcom/poshmark/http/api/PMApiResponse;)V

    .line 394
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$8;->val$bSearchVisibility:Z

    if-nez v0, :cond_0

    .line 395
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$8;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v2, "user"

    const-string v3, "turn_off_search_visibility"

    const/4 v4, 0x0

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 397
    :cond_0
    iget-object v0, p0, Lcom/poshmark/ui/fragments/SharingSettingsFragment$8;->this$0:Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/SharingSettingsFragment;->hideProgressDialog()V

    .line 398
    return-void
.end method
