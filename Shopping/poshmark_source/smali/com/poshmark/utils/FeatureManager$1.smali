.class Lcom/poshmark/utils/FeatureManager$1;
.super Ljava/lang/Object;
.source "FeatureManager.java"

# interfaces
.implements Lcom/poshmark/http/api/PMApiResponseHandler;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/poshmark/utils/FeatureManager;->getFeatures()V
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
        "Lcom/poshmark/data_model/models/Features;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/poshmark/utils/FeatureManager;


# direct methods
.method constructor <init>(Lcom/poshmark/utils/FeatureManager;)V
    .locals 0

    .prologue
    .line 348
    iput-object p1, p0, Lcom/poshmark/utils/FeatureManager$1;->this$0:Lcom/poshmark/utils/FeatureManager;

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
            "Lcom/poshmark/data_model/models/Features;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 351
    .local p1, "apiResponse":Lcom/poshmark/http/api/PMApiResponse;, "Lcom/poshmark/http/api/PMApiResponse<Lcom/poshmark/data_model/models/Features;>;"
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager$1;->this$0:Lcom/poshmark/utils/FeatureManager;

    iget-object v1, v0, Lcom/poshmark/utils/FeatureManager;->mutex:Ljava/lang/Object;

    monitor-enter v1

    .line 352
    :try_start_0
    invoke-virtual {p1}, Lcom/poshmark/http/api/PMApiResponse;->hasError()Z

    move-result v0

    if-nez v0, :cond_0

    .line 353
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager$1;->this$0:Lcom/poshmark/utils/FeatureManager;

    new-instance v2, Ljava/util/Date;

    invoke-direct {v2}, Ljava/util/Date;-><init>()V

    iput-object v2, v0, Lcom/poshmark/utils/FeatureManager;->lastFetchTime:Ljava/util/Date;

    .line 354
    iget-object v2, p0, Lcom/poshmark/utils/FeatureManager$1;->this$0:Lcom/poshmark/utils/FeatureManager;

    iget-object v0, p1, Lcom/poshmark/http/api/PMApiResponse;->data:Ljava/lang/Object;

    check-cast v0, Lcom/poshmark/data_model/models/Features;

    iput-object v0, v2, Lcom/poshmark/utils/FeatureManager;->currentFeatures:Lcom/poshmark/data_model/models/Features;

    .line 355
    iget-object v0, p0, Lcom/poshmark/utils/FeatureManager$1;->this$0:Lcom/poshmark/utils/FeatureManager;

    # invokes: Lcom/poshmark/utils/FeatureManager;->saveFeaturesToCache()V
    invoke-static {v0}, Lcom/poshmark/utils/FeatureManager;->access$000(Lcom/poshmark/utils/FeatureManager;)V

    .line 357
    :cond_0
    monitor-exit v1

    .line 358
    return-void

    .line 357
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
