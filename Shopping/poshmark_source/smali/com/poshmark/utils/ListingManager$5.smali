.class Lcom/poshmark/utils/ListingManager$5;
.super Ljava/lang/Object;
.source "ListingManager.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/ListingManager;->updateListing()V
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
    .line 288
    iput-object p1, p0, Lcom/poshmark/utils/ListingManager$5;->this$0:Lcom/poshmark/utils/ListingManager;

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
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Ljava/lang/Void;>;"
    const/4 v4, 0x0

    .line 291
    iget-object v0, p0, Lcom/poshmark/utils/ListingManager$5;->this$0:Lcom/poshmark/utils/ListingManager;

    iget-object v0, v0, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 292
    iget-object v0, p0, Lcom/poshmark/utils/ListingManager$5;->this$0:Lcom/poshmark/utils/ListingManager;

    iget-object v0, v0, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->hideProgressDialog()V

    .line 293
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_2

    .line 294
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v0

    const-string v1, "new_listing_screen"

    const-string v2, "listing"

    const-string v3, "edit_listing_complete"

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 296
    invoke-static {}, Lcom/poshmark/notifications/ListingNotificationManager;->getListingNotificationManager()Lcom/poshmark/notifications/ListingNotificationManager;

    move-result-object v0

    iget-object v1, p0, Lcom/poshmark/utils/ListingManager$5;->this$0:Lcom/poshmark/utils/ListingManager;

    iget-object v1, v1, Lcom/poshmark/utils/ListingManager;->listingId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/poshmark/notifications/ListingNotificationManager;->fireListingEditedMessage(Ljava/lang/String;)V

    .line 297
    iget-object v0, p0, Lcom/poshmark/utils/ListingManager$5;->this$0:Lcom/poshmark/utils/ListingManager;

    # invokes: Lcom/poshmark/utils/ListingManager;->shouldShareListing()Z
    invoke-static {v0}, Lcom/poshmark/utils/ListingManager;->access$400(Lcom/poshmark/utils/ListingManager;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 298
    iget-object v0, p0, Lcom/poshmark/utils/ListingManager$5;->this$0:Lcom/poshmark/utils/ListingManager;

    # invokes: Lcom/poshmark/utils/ListingManager;->shareListing()V
    invoke-static {v0}, Lcom/poshmark/utils/ListingManager;->access$500(Lcom/poshmark/utils/ListingManager;)V

    .line 300
    :cond_0
    iget-object v0, p0, Lcom/poshmark/utils/ListingManager$5;->this$0:Lcom/poshmark/utils/ListingManager;

    iget-object v0, v0, Lcom/poshmark/utils/ListingManager;->callingFragment:Lcom/poshmark/ui/fragments/PMFragment;

    const/4 v1, -0x1

    invoke-virtual {v0, v1, v4}, Lcom/poshmark/ui/fragments/PMFragment;->finishActivityWithResult(ILandroid/content/Intent;)V

    .line 306
    :cond_1
    :goto_0
    return-void

    .line 303
    :cond_2
    iget-object v0, p0, Lcom/poshmark/utils/ListingManager$5;->this$0:Lcom/poshmark/utils/ListingManager;

    iget-object v1, p0, Lcom/poshmark/utils/ListingManager$5;->this$0:Lcom/poshmark/utils/ListingManager;

    iget-object v2, p1, Lcom/poshmark/http/api/PMApiResponse;->apiError:Lcom/poshmark/http/api/PMApiError;

    # invokes: Lcom/poshmark/utils/ListingManager;->getRetryMessageForError(Lcom/poshmark/http/api/PMApiError;)Ljava/lang/String;
    invoke-static {v1, v2}, Lcom/poshmark/utils/ListingManager;->access$100(Lcom/poshmark/utils/ListingManager;Lcom/poshmark/http/api/PMApiError;)Ljava/lang/String;

    move-result-object v1

    # invokes: Lcom/poshmark/utils/ListingManager;->presentRetryAlert(Ljava/lang/String;)V
    invoke-static {v0, v1}, Lcom/poshmark/utils/ListingManager;->access$200(Lcom/poshmark/utils/ListingManager;Ljava/lang/String;)V

    goto :goto_0
.end method
