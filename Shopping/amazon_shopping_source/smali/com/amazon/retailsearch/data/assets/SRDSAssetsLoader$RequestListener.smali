.class Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;
.super Lcom/amazon/searchapp/retailsearch/client/web/AbstractServiceCallListener;
.source "SRDSAssetsLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "RequestListener"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/searchapp/retailsearch/client/web/AbstractServiceCallListener",
        "<",
        "Lcom/amazon/searchapp/retailsearch/model/Assets;",
        ">;"
    }
.end annotation


# instance fields
.field private cancelled:Z

.field final synthetic this$0:Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;


# direct methods
.method private constructor <init>(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;)V
    .locals 0

    .prologue
    .line 275
    iput-object p1, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;->this$0:Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    invoke-direct {p0}, Lcom/amazon/searchapp/retailsearch/client/web/AbstractServiceCallListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;
    .param p2, "x1"    # Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$1;

    .prologue
    .line 275
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;-><init>(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;)V

    return-void
.end method

.method static synthetic access$102(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;
    .param p1, "x1"    # Z

    .prologue
    .line 275
    iput-boolean p1, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;->cancelled:Z

    return p1
.end method


# virtual methods
.method public endRequest()V
    .locals 2

    .prologue
    .line 325
    iget-boolean v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;->cancelled:Z

    if-eqz v0, :cond_0

    .line 339
    :goto_0
    return-void

    .line 330
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;->this$0:Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    # getter for: Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->gotData:Z
    invoke-static {v0}, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->access$700(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 332
    iget-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;->this$0:Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    const/4 v1, 0x1

    # setter for: Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->doLoad:Z
    invoke-static {v0, v1}, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->access$202(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;Z)Z

    goto :goto_0

    .line 337
    :cond_1
    iget-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;->this$0:Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    # getter for: Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;
    invoke-static {v0}, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->access$500(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;)Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->searchSRDSAssetsCompleted()V

    goto :goto_0
.end method

.method public error(Ljava/lang/Exception;)V
    .locals 4
    .param p1, "error"    # Ljava/lang/Exception;

    .prologue
    .line 311
    iget-boolean v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;->cancelled:Z

    if-nez v0, :cond_0

    .line 313
    iget-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;->this$0:Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    # getter for: Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;
    invoke-static {v0}, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->access$500(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;)Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v0

    const-string/jumbo v1, "Assets request error"

    iget-object v2, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;->this$0:Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    # getter for: Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->serviceCall:Lcom/amazon/searchapp/retailsearch/client/AssetsServiceCall;
    invoke-static {v2}, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->access$800(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;)Lcom/amazon/searchapp/retailsearch/client/AssetsServiceCall;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;->this$0:Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    # getter for: Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->fetchType:Lcom/amazon/retailsearch/data/assets/AssetFetchType;
    invoke-static {v3}, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->access$400(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;)Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    move-result-object v3

    invoke-interface {v0, v1, p1, v2, v3}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->searchSRDSAssetsError(Ljava/lang/String;Ljava/lang/Throwable;Lcom/amazon/searchapp/retailsearch/client/AssetsServiceCall;Lcom/amazon/retailsearch/data/assets/AssetFetchType;)V

    .line 314
    iget-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;->this$0:Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    const/4 v1, 0x1

    # setter for: Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->doLoad:Z
    invoke-static {v0, v1}, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->access$202(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;Z)Z

    .line 317
    :cond_0
    return-void
.end method

.method public result(Lcom/amazon/searchapp/retailsearch/model/Assets;)V
    .locals 2
    .param p1, "result"    # Lcom/amazon/searchapp/retailsearch/model/Assets;

    .prologue
    .line 298
    iget-boolean v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;->cancelled:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;->this$0:Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    # invokes: Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->retreiveBadges(Lcom/amazon/searchapp/retailsearch/model/Assets;)Ljava/util/Map;
    invoke-static {v0, p1}, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->access$600(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;Lcom/amazon/searchapp/retailsearch/model/Assets;)Ljava/util/Map;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 300
    iget-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;->this$0:Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    const/4 v1, 0x1

    # setter for: Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->gotData:Z
    invoke-static {v0, v1}, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->access$702(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;Z)Z

    .line 302
    :cond_0
    return-void
.end method

.method public bridge synthetic result(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 275
    check-cast p1, Lcom/amazon/searchapp/retailsearch/model/Assets;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;->result(Lcom/amazon/searchapp/retailsearch/model/Assets;)V

    return-void
.end method

.method public startRequest()V
    .locals 2

    .prologue
    .line 286
    iget-boolean v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;->cancelled:Z

    if-nez v0, :cond_0

    .line 288
    iget-object v0, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;->this$0:Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    # getter for: Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;
    invoke-static {v0}, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->access$500(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;)Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader$RequestListener;->this$0:Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;

    # getter for: Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->fetchType:Lcom/amazon/retailsearch/data/assets/AssetFetchType;
    invoke-static {v1}, Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;->access$400(Lcom/amazon/retailsearch/data/assets/SRDSAssetsLoader;)Lcom/amazon/retailsearch/data/assets/AssetFetchType;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;->searchSRDSAssetsStarted(Lcom/amazon/retailsearch/data/assets/AssetFetchType;)V

    .line 290
    :cond_0
    return-void
.end method
