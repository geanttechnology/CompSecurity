.class Lcom/espn/androidplayersdk/datamanager/EventByIdRequest$1;
.super Ljava/lang/Object;
.source "EventByIdRequest.java"

# interfaces
.implements Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;


# direct methods
.method constructor <init>(Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest$1;->this$0:Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;

    .line 385
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleError(I)V
    .locals 1
    .param p1, "errorCode"    # I

    .prologue
    .line 410
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest$1;->this$0:Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;->mCallBack:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;

    invoke-interface {v0, p1}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;->onEventRetrivalError(I)V

    .line 411
    return-void
.end method

.method public update(Lorg/apache/http/HttpEntity;Ljava/lang/String;)V
    .locals 0
    .param p1, "entity"    # Lorg/apache/http/HttpEntity;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 416
    return-void
.end method

.method public update(Lorg/json/JSONObject;Ljava/lang/String;Ljava/util/HashMap;)V
    .locals 6
    .param p1, "object"    # Lorg/json/JSONObject;
    .param p2, "url"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lorg/json/JSONObject;",
            "Ljava/lang/String;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p3, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    const/16 v5, 0x9

    const/4 v4, 0x5

    .line 392
    :try_start_0
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest$1;->this$0:Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;

    invoke-virtual {v2, p1, p3}, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;->parse(Lorg/json/JSONObject;Ljava/util/HashMap;)Lcom/espn/androidplayersdk/datamanager/EPEvents;

    move-result-object v1

    .line 393
    .local v1, "event":Lcom/espn/androidplayersdk/datamanager/EPEvents;
    if-eqz v1, :cond_0

    .line 394
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest$1;->this$0:Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;

    iget-object v2, v2, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;->mCallBack:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;

    invoke-interface {v2, v1}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;->onEventUpdate(Lcom/espn/androidplayersdk/datamanager/EPEvents;)V

    .line 406
    .end local v1    # "event":Lcom/espn/androidplayersdk/datamanager/EPEvents;
    :goto_0
    return-void

    .line 396
    .restart local v1    # "event":Lcom/espn/androidplayersdk/datamanager/EPEvents;
    :cond_0
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest$1;->this$0:Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;

    iget-object v2, v2, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;->mCallBack:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;

    const/16 v3, 0x8

    invoke-interface {v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;->onEventRetrivalError(I)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 398
    .end local v1    # "event":Lcom/espn/androidplayersdk/datamanager/EPEvents;
    :catch_0
    move-exception v0

    .line 399
    .local v0, "e":Lorg/json/JSONException;
    const-string v2, "EventByIdRequest"

    invoke-static {v2, v4, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 400
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest$1;->this$0:Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;

    iget-object v2, v2, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;->mCallBack:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;

    invoke-interface {v2, v5}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;->onEventRetrivalError(I)V

    goto :goto_0

    .line 401
    .end local v0    # "e":Lorg/json/JSONException;
    :catch_1
    move-exception v0

    .line 402
    .local v0, "e":Ljava/lang/Exception;
    const-string v2, "EventByIdRequest"

    invoke-static {v2, v4, v0}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    .line 403
    iget-object v2, p0, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest$1;->this$0:Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;

    iget-object v2, v2, Lcom/espn/androidplayersdk/datamanager/EventByIdRequest;->mCallBack:Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;

    invoke-interface {v2, v5}, Lcom/espn/androidplayersdk/datamanager/EPCatalogManager$Callback;->onEventRetrivalError(I)V

    goto :goto_0
.end method
