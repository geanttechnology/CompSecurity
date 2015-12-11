.class Lcom/espn/androidplayersdk/datamanager/SearchAPI$1;
.super Ljava/lang/Object;
.source "SearchAPI.java"

# interfaces
.implements Lcom/espn/androidplayersdk/datamanager/FeedsCommListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/espn/androidplayersdk/datamanager/SearchAPI;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/espn/androidplayersdk/datamanager/SearchAPI;


# direct methods
.method constructor <init>(Lcom/espn/androidplayersdk/datamanager/SearchAPI;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/espn/androidplayersdk/datamanager/SearchAPI$1;->this$0:Lcom/espn/androidplayersdk/datamanager/SearchAPI;

    .line 68
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public handleError(I)V
    .locals 1
    .param p1, "errorCode"    # I

    .prologue
    .line 81
    iget-object v0, p0, Lcom/espn/androidplayersdk/datamanager/SearchAPI$1;->this$0:Lcom/espn/androidplayersdk/datamanager/SearchAPI;

    iget-object v0, v0, Lcom/espn/androidplayersdk/datamanager/SearchAPI;->callback:Lcom/espn/androidplayersdk/listenerinterface/SearchCallback;

    invoke-interface {v0, p1}, Lcom/espn/androidplayersdk/listenerinterface/SearchCallback;->onSearchFailed(I)V

    .line 82
    return-void
.end method

.method public update(Lorg/apache/http/HttpEntity;Ljava/lang/String;)V
    .locals 0
    .param p1, "entity"    # Lorg/apache/http/HttpEntity;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 87
    return-void
.end method

.method public update(Lorg/json/JSONObject;Ljava/lang/String;Ljava/util/HashMap;)V
    .locals 3
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
    .line 72
    .local p3, "map":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/SearchAPI$1;->this$0:Lcom/espn/androidplayersdk/datamanager/SearchAPI;

    invoke-virtual {v1, p1}, Lcom/espn/androidplayersdk/datamanager/SearchAPI;->parse(Lorg/json/JSONObject;)Ljava/util/ArrayList;

    move-result-object v0

    .line 73
    .local v0, "events":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/espn/androidplayersdk/datamanager/EPEvents;>;"
    if-eqz v0, :cond_0

    .line 74
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/SearchAPI$1;->this$0:Lcom/espn/androidplayersdk/datamanager/SearchAPI;

    iget-object v1, v1, Lcom/espn/androidplayersdk/datamanager/SearchAPI;->callback:Lcom/espn/androidplayersdk/listenerinterface/SearchCallback;

    invoke-interface {v1, v0}, Lcom/espn/androidplayersdk/listenerinterface/SearchCallback;->onSearchSuccess(Ljava/util/ArrayList;)V

    .line 77
    :goto_0
    return-void

    .line 76
    :cond_0
    iget-object v1, p0, Lcom/espn/androidplayersdk/datamanager/SearchAPI$1;->this$0:Lcom/espn/androidplayersdk/datamanager/SearchAPI;

    iget-object v1, v1, Lcom/espn/androidplayersdk/datamanager/SearchAPI;->callback:Lcom/espn/androidplayersdk/listenerinterface/SearchCallback;

    const/4 v2, 0x7

    invoke-interface {v1, v2}, Lcom/espn/androidplayersdk/listenerinterface/SearchCallback;->onSearchFailed(I)V

    goto :goto_0
.end method
