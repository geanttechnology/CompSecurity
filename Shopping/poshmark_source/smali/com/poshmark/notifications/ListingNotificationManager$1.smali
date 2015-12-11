.class Lcom/poshmark/notifications/ListingNotificationManager$1;
.super Ljava/lang/Object;
.source "ListingNotificationManager.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/notifications/ListingNotificationManager;->fireListingEditedMessage(Ljava/lang/String;)V
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
        "Lcom/poshmark/data_model/models/ListingDetails;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/notifications/ListingNotificationManager;


# direct methods
.method constructor <init>(Lcom/poshmark/notifications/ListingNotificationManager;)V
    .locals 0

    .prologue
    .line 97
    iput-object p1, p0, Lcom/poshmark/notifications/ListingNotificationManager$1;->this$0:Lcom/poshmark/notifications/ListingNotificationManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/ListingDetails;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 100
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/ListingDetails;>;"
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v2

    if-nez v2, :cond_0

    .line 101
    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/ListingDetails;

    .line 102
    .local v0, "listingDetails":Lcom/poshmark/data_model/models/ListingDetails;
    iget-object v2, p0, Lcom/poshmark/notifications/ListingNotificationManager$1;->this$0:Lcom/poshmark/notifications/ListingNotificationManager;

    # invokes: Lcom/poshmark/notifications/ListingNotificationManager;->launchAllEditMessages(Lcom/poshmark/data_model/models/ListingDetails;)V
    invoke-static {v2, v0}, Lcom/poshmark/notifications/ListingNotificationManager;->access$000(Lcom/poshmark/notifications/ListingNotificationManager;Lcom/poshmark/data_model/models/ListingDetails;)V

    .line 103
    new-instance v1, Landroid/os/Message;

    invoke-direct {v1}, Landroid/os/Message;-><init>()V

    .line 104
    .local v1, "msg":Landroid/os/Message;
    iput-object v0, v1, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 105
    const/4 v2, 0x1

    iput v2, v1, Landroid/os/Message;->what:I

    .line 106
    iget-object v2, p0, Lcom/poshmark/notifications/ListingNotificationManager$1;->this$0:Lcom/poshmark/notifications/ListingNotificationManager;

    iget-object v2, v2, Lcom/poshmark/notifications/ListingNotificationManager;->listingNotificationMsgHandler:Landroid/os/Handler;

    invoke-virtual {v2, v1}, Landroid/os/Handler;->sendMessage(Landroid/os/Message;)Z

    .line 108
    .end local v0    # "listingDetails":Lcom/poshmark/data_model/models/ListingDetails;
    .end local v1    # "msg":Landroid/os/Message;
    :cond_0
    return-void
.end method
