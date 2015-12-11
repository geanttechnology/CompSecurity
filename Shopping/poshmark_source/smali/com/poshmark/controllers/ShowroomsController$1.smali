.class Lcom/poshmark/controllers/ShowroomsController$1;
.super Ljava/lang/Object;
.source "ShowroomsController.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/controllers/ShowroomsController;->getShowroomsData()V
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
        "Lcom/poshmark/data_model/models/ShowroomGroupList;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/controllers/ShowroomsController;


# direct methods
.method constructor <init>(Lcom/poshmark/controllers/ShowroomsController;)V
    .locals 0

    .prologue
    .line 67
    iput-object p1, p0, Lcom/poshmark/controllers/ShowroomsController$1;->this$0:Lcom/poshmark/controllers/ShowroomsController;

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
            "Lcom/poshmark/data_model/models/ShowroomGroupList;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 70
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/ShowroomGroupList;>;"
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_0

    .line 71
    iget-object v1, p0, Lcom/poshmark/controllers/ShowroomsController$1;->this$0:Lcom/poshmark/controllers/ShowroomsController;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/ShowroomGroupList;

    iput-object v0, v1, Lcom/poshmark/controllers/ShowroomsController;->showroomGroupList:Lcom/poshmark/data_model/models/ShowroomGroupList;

    .line 72
    iget-object v0, p0, Lcom/poshmark/controllers/ShowroomsController$1;->this$0:Lcom/poshmark/controllers/ShowroomsController;

    new-instance v1, Ljava/util/Date;

    invoke-direct {v1}, Ljava/util/Date;-><init>()V

    iput-object v1, v0, Lcom/poshmark/controllers/ShowroomsController;->lastFetchTime:Ljava/util/Date;

    .line 73
    iget-object v0, p0, Lcom/poshmark/controllers/ShowroomsController$1;->this$0:Lcom/poshmark/controllers/ShowroomsController;

    iget-object v0, v0, Lcom/poshmark/controllers/ShowroomsController;->showroomGroupList:Lcom/poshmark/data_model/models/ShowroomGroupList;

    if-eqz v0, :cond_0

    .line 74
    const-string v0, "com.poshmark.intents.SHOWROOMS_FETCH_COMPLETE"

    invoke-static {v0}, Lcom/poshmark/notifications/PMNotificationManager;->fireNotification(Ljava/lang/String;)V

    .line 77
    :cond_0
    return-void
.end method
