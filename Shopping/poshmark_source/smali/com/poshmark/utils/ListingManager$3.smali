.class Lcom/poshmark/utils/ListingManager$3;
.super Ljava/lang/Object;
.source "ListingManager.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/ListingManager;->publishNewListing()V
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
.field final synthetic this$0:Lcom/poshmark/utils/ListingManager;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/ListingManager;)V
    .locals 0

    .prologue
    .line 200
    iput-object p1, p0, Lcom/poshmark/utils/ListingManager$3;->this$0:Lcom/poshmark/utils/ListingManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 8
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
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    const/4 v7, 0x0

    .line 203
    sget-object v3, Lcom/poshmark/utils/NewRelicCustomInteractions;->CREATE_LISTING:Ljava/lang/String;

    invoke-static {v3}, Lcom/poshmark/config/NewRelicWrapper;->stopCustomInteraction(Ljava/lang/String;)V

    .line 204
    iget-object v3, p0, Lcom/poshmark/utils/ListingManager$3;->this$0:Lcom/poshmark/utils/ListingManager;

    iget-object v3, v3, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/PMFragment;->isAdded()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 205
    iget-object v3, p0, Lcom/poshmark/utils/ListingManager$3;->this$0:Lcom/poshmark/utils/ListingManager;

    iget-object v3, v3, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/PMFragment;->hideProgressDialog()V

    .line 206
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v3

    if-nez v3, :cond_2

    .line 207
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v3

    const-string v4, "new_listing_screen"

    const-string v5, "listing"

    const-string v6, "new_listing_complete"

    invoke-virtual {v3, v4, v5, v6, v7}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 209
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getHasOffersObject()Lcom/mobileapptracker/MobileAppTracker;

    move-result-object v0

    .line 210
    .local v0, "hasOffersObj":Lcom/mobileapptracker/MobileAppTracker;
    if-eqz v0, :cond_0

    .line 211
    const-string v3, "listing"

    invoke-virtual {v0, v3}, Lcom/mobileapptracker/MobileAppTracker;->measureAction(Ljava/lang/String;)V

    .line 213
    :cond_0
    const-string v3, "listing"

    invoke-static {v3}, Lnet/singular/sdk/Singular;->trackEvent(Ljava/lang/String;)V

    .line 214
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/facebook/appevents/AppEventsLogger;->newLogger(Landroid/content/Context;)Lcom/facebook/appevents/AppEventsLogger;

    move-result-object v1

    .line 215
    .local v1, "logger":Lcom/facebook/appevents/AppEventsLogger;
    const-string v3, "listing"

    invoke-virtual {v1, v3}, Lcom/facebook/appevents/AppEventsLogger;->logEvent(Ljava/lang/String;)V

    .line 216
    invoke-static {}, Lcom/poshmark/notifications/ListingNotificationManager;->getListingNotificationManager()Lcom/poshmark/notifications/ListingNotificationManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/notifications/ListingNotificationManager;->fireNewListingCreatedMessage()V

    .line 217
    iget-object v3, p0, Lcom/poshmark/utils/ListingManager$3;->this$0:Lcom/poshmark/utils/ListingManager;

    iget-object v3, v3, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const/16 v4, 0x66

    invoke-virtual {v3, v4, v7}, Lcom/poshmark/ui/fragments/PMFragment;->finishActivityWithResult(ILandroid/content/Intent;)V

    .line 230
    .end local v0    # "hasOffersObj":Lcom/mobileapptracker/MobileAppTracker;
    .end local v1    # "logger":Lcom/facebook/appevents/AppEventsLogger;
    :cond_1
    :goto_0
    return-void

    .line 219
    :cond_2
    iget-object v3, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    iget-object v3, v3, Lcom/poshmark/http/api/PMApiError;->pmErrorType:Lcom/poshmark/data_model/models/PMErrorType;

    sget-object v4, Lcom/poshmark/data_model/models/PMErrorType;->INVALID_LISTING:Lcom/poshmark/data_model/models/PMErrorType;

    if-ne v3, v4, :cond_3

    .line 220
    iget-object v3, p0, Lcom/poshmark/utils/ListingManager$3;->this$0:Lcom/poshmark/utils/ListingManager;

    # invokes: Lcom/poshmark/utils/ListingManager;->loadInvalidListingMappPage(Lcom/poshmark/http/api/PMApiResponse;)V
    invoke-static {v3, p1}, Lcom/poshmark/utils/ListingManager;->access$300(Lcom/poshmark/utils/ListingManager;Lcom/poshmark/http/api/PMApiResponse;)V

    goto :goto_0

    .line 222
    :cond_3
    iget-object v3, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    iget-object v3, v3, Lcom/poshmark/http/api/PMApiError;->pmErrorType:Lcom/poshmark/data_model/models/PMErrorType;

    sget-object v4, Lcom/poshmark/data_model/models/PMErrorType;->BRAND_CHANGE_LIMIT_EXCEEDED:Lcom/poshmark/data_model/models/PMErrorType;

    if-ne v3, v4, :cond_4

    .line 223
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f0600d0

    invoke-virtual {v3, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 224
    .local v2, "title":Ljava/lang/String;
    iget-object v3, p0, Lcom/poshmark/utils/ListingManager$3;->this$0:Lcom/poshmark/utils/ListingManager;

    iget-object v3, v3, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    iget-object v4, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    invoke-virtual {v4}, Lcom/poshmark/http/api/PMApiError;->getUserMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v2, v4}, Lcom/poshmark/ui/fragments/PMFragment;->showAlertMessage(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 227
    .end local v2    # "title":Ljava/lang/String;
    :cond_4
    iget-object v3, p0, Lcom/poshmark/utils/ListingManager$3;->this$0:Lcom/poshmark/utils/ListingManager;

    iget-object v4, p0, Lcom/poshmark/utils/ListingManager$3;->this$0:Lcom/poshmark/utils/ListingManager;

    iget-object v5, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    # invokes: Lcom/poshmark/utils/ListingManager;->getRetryMessageForError(Lcom/poshmark/http/api/PMApiError;)Ljava/lang/String;
    invoke-static {v4, v5}, Lcom/poshmark/utils/ListingManager;->access$100(Lcom/poshmark/utils/ListingManager;Lcom/poshmark/http/api/PMApiError;)Ljava/lang/String;

    move-result-object v4

    # invokes: Lcom/poshmark/utils/ListingManager;->presentRetryAlert(Ljava/lang/String;)V
    invoke-static {v3, v4}, Lcom/poshmark/utils/ListingManager;->access$200(Lcom/poshmark/utils/ListingManager;Ljava/lang/String;)V

    goto :goto_0
.end method
