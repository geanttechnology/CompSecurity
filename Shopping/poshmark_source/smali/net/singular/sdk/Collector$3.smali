.class Lnet/singular/sdk/Collector$3;
.super Ljava/lang/Object;
.source "Collector.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lnet/singular/sdk/Collector;->setReferralId(Ljava/lang/String;Lnet/singular/sdk/PostableWorker;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lnet/singular/sdk/Collector;

.field final synthetic val$referralId:Ljava/lang/String;


# direct methods
.method constructor <init>(Lnet/singular/sdk/Collector;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 326
    iput-object p1, p0, Lnet/singular/sdk/Collector$3;->this$0:Lnet/singular/sdk/Collector;

    iput-object p2, p0, Lnet/singular/sdk/Collector$3;->val$referralId:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 330
    :try_start_0
    iget-object v1, p0, Lnet/singular/sdk/Collector$3;->this$0:Lnet/singular/sdk/Collector;

    # invokes: Lnet/singular/sdk/Collector;->initKeyValueStore()V
    invoke-static {v1}, Lnet/singular/sdk/Collector;->access$300(Lnet/singular/sdk/Collector;)V

    .line 331
    iget-object v1, p0, Lnet/singular/sdk/Collector$3;->this$0:Lnet/singular/sdk/Collector;

    # getter for: Lnet/singular/sdk/Collector;->preferences:Lnet/singular/sdk/KeyValueStore;
    invoke-static {v1}, Lnet/singular/sdk/Collector;->access$400(Lnet/singular/sdk/Collector;)Lnet/singular/sdk/KeyValueStore;

    move-result-object v1

    const-string v2, "referral_id"

    iget-object v3, p0, Lnet/singular/sdk/Collector$3;->val$referralId:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lnet/singular/sdk/KeyValueStore;->put(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 333
    iget-object v1, p0, Lnet/singular/sdk/Collector$3;->this$0:Lnet/singular/sdk/Collector;

    # getter for: Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;
    invoke-static {v1}, Lnet/singular/sdk/Collector;->access$200(Lnet/singular/sdk/Collector;)Lnet/singular/sdk/SingularLog;

    move-result-object v1

    const-string v2, "singular_sdk"

    const-string v3, "setReferralIdRunnable: couldn\'t save the referralId"

    invoke-virtual {v1, v2, v3}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;)V

    .line 340
    :goto_0
    return-void

    .line 335
    :cond_0
    iget-object v1, p0, Lnet/singular/sdk/Collector$3;->this$0:Lnet/singular/sdk/Collector;

    # getter for: Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;
    invoke-static {v1}, Lnet/singular/sdk/Collector;->access$200(Lnet/singular/sdk/Collector;)Lnet/singular/sdk/SingularLog;

    move-result-object v1

    const-string v2, "singular_sdk"

    const-string v3, "setReferralIdRunnable: Successful!"

    invoke-virtual {v1, v2, v3}, Lnet/singular/sdk/SingularLog;->v(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 337
    :catch_0
    move-exception v0

    .line 338
    .local v0, "e":Ljava/lang/RuntimeException;
    iget-object v1, p0, Lnet/singular/sdk/Collector$3;->this$0:Lnet/singular/sdk/Collector;

    # getter for: Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;
    invoke-static {v1}, Lnet/singular/sdk/Collector;->access$200(Lnet/singular/sdk/Collector;)Lnet/singular/sdk/SingularLog;

    move-result-object v1

    const-string v2, "singular_sdk"

    const-string v3, "setReferralIdRunnable: couldn\'t save the referralId"

    invoke-virtual {v1, v2, v3}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
