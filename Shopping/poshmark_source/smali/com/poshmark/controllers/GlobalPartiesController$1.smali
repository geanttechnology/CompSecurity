.class Lcom/poshmark/controllers/GlobalPartiesController$1;
.super Ljava/lang/Object;
.source "GlobalPartiesController.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/controllers/GlobalPartiesController;->getEventsData()V
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
        "Lcom/poshmark/data_model/models/EventList;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/controllers/GlobalPartiesController;


# direct methods
.method constructor <init>(Lcom/poshmark/controllers/GlobalPartiesController;)V
    .locals 0

    .prologue
    .line 55
    iput-object p1, p0, Lcom/poshmark/controllers/GlobalPartiesController$1;->this$0:Lcom/poshmark/controllers/GlobalPartiesController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleResponse(Lcom/poshmark/http/api/PMApiResponse;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/http/api/PMApiResponse",
            "<",
            "Lcom/poshmark/data_model/models/EventList;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 58
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/EventList;>;"
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_0

    .line 59
    iget-object v1, p0, Lcom/poshmark/controllers/GlobalPartiesController$1;->this$0:Lcom/poshmark/controllers/GlobalPartiesController;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/EventList;

    iput-object v0, v1, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    .line 60
    iget-object v0, p0, Lcom/poshmark/controllers/GlobalPartiesController$1;->this$0:Lcom/poshmark/controllers/GlobalPartiesController;

    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    iput-object v1, v0, Lcom/poshmark/controllers/GlobalPartiesController;->lastFetchTime:Ljava/util/Date;

    .line 61
    iget-object v0, p0, Lcom/poshmark/controllers/GlobalPartiesController$1;->this$0:Lcom/poshmark/controllers/GlobalPartiesController;

    iget-object v0, v0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    if-eqz v0, :cond_0

    .line 62
    iget-object v0, p0, Lcom/poshmark/controllers/GlobalPartiesController$1;->this$0:Lcom/poshmark/controllers/GlobalPartiesController;

    iget-object v0, v0, Lcom/poshmark/controllers/GlobalPartiesController;->eventList:Lcom/poshmark/data_model/models/EventList;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/EventList;->filterParties()Ljava/util/List;

    .line 63
    iget-object v0, p0, Lcom/poshmark/controllers/GlobalPartiesController$1;->this$0:Lcom/poshmark/controllers/GlobalPartiesController;

    # invokes: Lcom/poshmark/controllers/GlobalPartiesController;->setupPartyNotifications()V
    invoke-static {v0}, Lcom/poshmark/controllers/GlobalPartiesController;->access$000(Lcom/poshmark/controllers/GlobalPartiesController;)V

    .line 64
    const-string v0, "com.poshmark.intents.EVENTS_FETCH_COMPLETE"

    invoke-static {v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 67
    :cond_0
    return-void
.end method
