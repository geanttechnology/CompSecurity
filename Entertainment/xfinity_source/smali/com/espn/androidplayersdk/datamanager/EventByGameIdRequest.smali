.class Lcom/espn/androidplayersdk/datamanager/EventByGameIdRequest;
.super Ljava/lang/Object;
.source "EventByGameIdRequest.java"


# instance fields
.field listener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

.field mCallBack:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;


# direct methods
.method constructor <init>(Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;)V
    .locals 1
    .param p1, "pCallback"    # Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventByGameIdRequest;->mCallBack:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;

    .line 35
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EventByGameIdRequest$1;

    invoke-direct {v0, p0}, Lcom/espn/androidplayersdk/datamanager/EventByGameIdRequest$1;-><init>(Lcom/espn/androidplayersdk/datamanager/EventByGameIdRequest;)V

    iput-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventByGameIdRequest;->listener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    .line 28
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/EventByGameIdRequest;->mCallBack:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;

    .line 29
    return-void
.end method


# virtual methods
.method getEvent(Ljava/lang/String;)V
    .locals 2
    .param p1, "gameID"    # Ljava/lang/String;

    .prologue
    .line 32
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;

    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/EventByGameIdRequest;->listener:Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;

    invoke-direct {v0, v1}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;-><init>(Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;)V

    invoke-virtual {v0, p1}, Lcom/espn/androidplayersdk/datamanager/FeedsManagerAPI;->getEventByGameId(Ljava/lang/String;)V

    .line 33
    return-void
.end method
