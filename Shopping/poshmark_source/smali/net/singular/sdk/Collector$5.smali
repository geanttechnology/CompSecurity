.class Lnet/singular/sdk/Collector$5;
.super Ljava/lang/Object;
.source "Collector.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lnet/singular/sdk/Collector;->getAdvertisingIdBackupMethodAndAndroidIdAndMacOnFailure()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lnet/singular/sdk/Collector;


# direct methods
.method constructor <init>(Lnet/singular/sdk/Collector;)V
    .locals 0

    .prologue
    .line 530
    iput-object p1, p0, Lnet/singular/sdk/Collector$5;->this$0:Lnet/singular/sdk/Collector;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 533
    iget-object v0, p0, Lnet/singular/sdk/Collector$5;->this$0:Lnet/singular/sdk/Collector;

    iget-object v1, p0, Lnet/singular/sdk/Collector$5;->this$0:Lnet/singular/sdk/Collector;

    # getter for: Lnet/singular/sdk/Collector;->facebookAttributionGetter:Lnet/singular/sdk/FacebookAttributionIdGetter;
    invoke-static {v1}, Lnet/singular/sdk/Collector;->access$100(Lnet/singular/sdk/Collector;)Lnet/singular/sdk/FacebookAttributionIdGetter;

    move-result-object v1

    invoke-virtual {v1}, Lnet/singular/sdk/FacebookAttributionIdGetter;->getAdvertisingId()Ljava/lang/String;

    move-result-object v1

    # setter for: Lnet/singular/sdk/Collector;->advertisingId:Ljava/lang/String;
    invoke-static {v0, v1}, Lnet/singular/sdk/Collector;->access$602(Lnet/singular/sdk/Collector;Ljava/lang/String;)Ljava/lang/String;

    .line 534
    iget-object v0, p0, Lnet/singular/sdk/Collector$5;->this$0:Lnet/singular/sdk/Collector;

    # getter for: Lnet/singular/sdk/Collector;->advertisingId:Ljava/lang/String;
    invoke-static {v0}, Lnet/singular/sdk/Collector;->access$600(Lnet/singular/sdk/Collector;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 535
    iget-object v0, p0, Lnet/singular/sdk/Collector$5;->this$0:Lnet/singular/sdk/Collector;

    # getter for: Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;
    invoke-static {v0}, Lnet/singular/sdk/Collector;->access$200(Lnet/singular/sdk/Collector;)Lnet/singular/sdk/SingularLog;

    move-result-object v0

    const-string v1, "singular_sdk"

    const-string v2, "getAdvertisingIdBackupMethod: ok"

    invoke-virtual {v0, v1, v2}, Lnet/singular/sdk/SingularLog;->trackInternalDebugEvent(Ljava/lang/String;Ljava/lang/String;)V

    .line 538
    :cond_0
    return-void
.end method
