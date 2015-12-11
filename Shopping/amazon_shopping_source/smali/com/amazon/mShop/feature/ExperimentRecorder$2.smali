.class Lcom/amazon/mShop/feature/ExperimentRecorder$2;
.super Ljava/lang/Object;
.source "ExperimentRecorder.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/PostMetricsResponseListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/feature/ExperimentRecorder;->sendMetrics(Lcom/amazon/rio/j2me/client/services/mShop/ClientMetrics;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/feature/ExperimentRecorder;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/feature/ExperimentRecorder;)V
    .locals 0

    .prologue
    .line 231
    iput-object p1, p0, Lcom/amazon/mShop/feature/ExperimentRecorder$2;->this$0:Lcom/amazon/mShop/feature/ExperimentRecorder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 239
    # getter for: Lcom/amazon/mShop/feature/ExperimentRecorder;->DEBUG:Z
    invoke-static {}, Lcom/amazon/mShop/feature/ExperimentRecorder;->access$900()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 240
    # getter for: Lcom/amazon/mShop/feature/ExperimentRecorder;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/feature/ExperimentRecorder;->access$600()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Post metrics cancelled"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 242
    :cond_0
    return-void
.end method

.method public completed(Lcom/amazon/rio/j2me/client/services/mShop/Null;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/Null;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 246
    # getter for: Lcom/amazon/mShop/feature/ExperimentRecorder;->DEBUG:Z
    invoke-static {}, Lcom/amazon/mShop/feature/ExperimentRecorder;->access$900()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 247
    # getter for: Lcom/amazon/mShop/feature/ExperimentRecorder;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/feature/ExperimentRecorder;->access$600()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Finished posting metrics"

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 249
    :cond_0
    return-void
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 234
    # getter for: Lcom/amazon/mShop/feature/ExperimentRecorder;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/feature/ExperimentRecorder;->access$600()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "Failed to post metrics"

    invoke-static {v0, v1, p1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 235
    return-void
.end method
