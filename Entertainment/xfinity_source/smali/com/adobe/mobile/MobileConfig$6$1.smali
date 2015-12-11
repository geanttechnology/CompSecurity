.class Lcom/adobe/mobile/MobileConfig$6$1;
.super Ljava/lang/Object;
.source "MobileConfig.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/adobe/mobile/MobileConfig$6;->call(ZLjava/io/File;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/adobe/mobile/MobileConfig$6;

.field final synthetic val$file:Ljava/io/File;


# direct methods
.method constructor <init>(Lcom/adobe/mobile/MobileConfig$6;Ljava/io/File;)V
    .locals 0
    .param p1, "this$1"    # Lcom/adobe/mobile/MobileConfig$6;

    .prologue
    .line 638
    iput-object p1, p0, Lcom/adobe/mobile/MobileConfig$6$1;->this$1:Lcom/adobe/mobile/MobileConfig$6;

    iput-object p2, p0, Lcom/adobe/mobile/MobileConfig$6$1;->val$file:Ljava/io/File;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 641
    iget-object v0, p0, Lcom/adobe/mobile/MobileConfig$6$1;->val$file:Ljava/io/File;

    if-eqz v0, :cond_0

    .line 642
    const-string v0, "Config - Using remote definition for points of interest"

    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Object;

    invoke-static {v0, v1}, Lcom/adobe/mobile/StaticMethods;->logDebugFormat(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 643
    iget-object v0, p0, Lcom/adobe/mobile/MobileConfig$6$1;->this$1:Lcom/adobe/mobile/MobileConfig$6;

    iget-object v0, v0, Lcom/adobe/mobile/MobileConfig$6;->this$0:Lcom/adobe/mobile/MobileConfig;

    iget-object v1, p0, Lcom/adobe/mobile/MobileConfig$6$1;->val$file:Ljava/io/File;

    invoke-virtual {v0, v1}, Lcom/adobe/mobile/MobileConfig;->updatePOIData(Ljava/io/File;)V

    .line 645
    :cond_0
    return-void
.end method
