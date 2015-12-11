.class Lcom/amazon/identity/auth/device/api/MAPInit$1;
.super Ljava/lang/Object;
.source "MAPInit.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/api/MAPInit;->initialize()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/api/MAPInit;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/api/MAPInit;)V
    .locals 0

    .prologue
    .line 86
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/MAPInit$1;->this$0:Lcom/amazon/identity/auth/device/api/MAPInit;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInit$1;->this$0:Lcom/amazon/identity/auth/device/api/MAPInit;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/MAPInit;->access$000(Lcom/amazon/identity/auth/device/api/MAPInit;)V

    .line 93
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInit$1;->this$0:Lcom/amazon/identity/auth/device/api/MAPInit;

    # getter for: Lcom/amazon/identity/auth/device/api/MAPInit;->mApplicationContext:Landroid/content/Context;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/MAPInit;->access$100(Lcom/amazon/identity/auth/device/api/MAPInit;)Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/platform/setting/PlatformSettings;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/platform/setting/PlatformSettings;

    .line 97
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInit$1;->this$0:Lcom/amazon/identity/auth/device/api/MAPInit;

    # getter for: Lcom/amazon/identity/auth/device/api/MAPInit;->mApplicationContext:Landroid/content/Context;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/MAPInit;->access$100(Lcom/amazon/identity/auth/device/api/MAPInit;)Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/auth/device/CommonInfoGetter;->needToGenerateCommonInfoOnThisPlatform(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 99
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInit$1;->this$0:Lcom/amazon/identity/auth/device/api/MAPInit;

    # getter for: Lcom/amazon/identity/auth/device/api/MAPInit;->mApplicationContext:Landroid/content/Context;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/MAPInit;->access$100(Lcom/amazon/identity/auth/device/api/MAPInit;)Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/auth/device/CommonInfoGetter;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/CommonInfoGetter;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/CommonInfoGetter;->init()V

    .line 103
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInit$1;->this$0:Lcom/amazon/identity/auth/device/api/MAPInit;

    # getter for: Lcom/amazon/identity/auth/device/api/MAPInit;->mApplicationContext:Landroid/content/Context;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/MAPInit;->access$100(Lcom/amazon/identity/auth/device/api/MAPInit;)Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/auth/device/metrics/WebserviceCallMetrics;->init(Landroid/content/Context;)V

    .line 104
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInit$1;->this$0:Lcom/amazon/identity/auth/device/api/MAPInit;

    # getter for: Lcom/amazon/identity/auth/device/api/MAPInit;->mApplicationContext:Landroid/content/Context;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/MAPInit;->access$100(Lcom/amazon/identity/auth/device/api/MAPInit;)Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/auth/device/metrics/SSOMetrics;->init(Landroid/content/Context;)V

    .line 105
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInit$1;->this$0:Lcom/amazon/identity/auth/device/api/MAPInit;

    # getter for: Lcom/amazon/identity/auth/device/api/MAPInit;->mApplicationContext:Landroid/content/Context;
    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/MAPInit;->access$100(Lcom/amazon/identity/auth/device/api/MAPInit;)Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/platform/metric/MetricsHelper;->init(Landroid/content/Context;)V

    .line 110
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInit$1;->this$0:Lcom/amazon/identity/auth/device/api/MAPInit;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/MAPInit;->access$200(Lcom/amazon/identity/auth/device/api/MAPInit;)V

    .line 112
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPInit$1;->this$0:Lcom/amazon/identity/auth/device/api/MAPInit;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/MAPInit;->access$300(Lcom/amazon/identity/auth/device/api/MAPInit;)V

    .line 113
    return-void
.end method
