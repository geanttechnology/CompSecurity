.class Lcom/igexin/sdk/SdkService$2;
.super Ljava/lang/Object;
.source "SdkService.java"

# interfaces
.implements Lcom/igexin/sdk/CallbackListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/igexin/sdk/SdkService;->registerNow()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/igexin/sdk/SdkService;


# direct methods
.method constructor <init>(Lcom/igexin/sdk/SdkService;)V
    .locals 0

    .prologue
    .line 255
    iput-object p1, p0, Lcom/igexin/sdk/SdkService$2;->this$0:Lcom/igexin/sdk/SdkService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public exceptionHandler(Ljava/lang/Exception;)V
    .locals 0
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 273
    return-void
.end method

.method public getCallbackData(Ljava/lang/Object;)V
    .locals 6
    .param p1, "data"    # Ljava/lang/Object;

    .prologue
    const/4 v5, 0x1

    .line 260
    move-object v0, p1

    check-cast v0, Ljava/lang/String;

    .line 261
    .local v0, "vcid":Ljava/lang/String;
    sput-object v0, Lcom/igexin/sdk/data/BasicDataManager;->vcid:Ljava/lang/String;

    .line 262
    const-string/jumbo v1, "vcid"

    invoke-static {v5, v1, v0}, Lcom/igexin/sdk/data/BasicDataManager;->updateVcidValue(ILjava/lang/String;Ljava/lang/String;)V

    .line 263
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    sput-wide v1, Lcom/igexin/sdk/data/BasicDataManager;->lastBindAppTime:J

    .line 264
    const/4 v1, 0x3

    const-string/jumbo v2, "lastBindAppTime"

    sget-wide v3, Lcom/igexin/sdk/data/BasicDataManager;->lastBindAppTime:J

    invoke-static {v3, v4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v2, v3}, Lcom/igexin/sdk/data/BasicDataManager;->updateDBValue(ILjava/lang/String;Ljava/lang/String;)V

    .line 265
    iget-object v1, p0, Lcom/igexin/sdk/SdkService$2;->this$0:Lcom/igexin/sdk/SdkService;

    const-string/jumbo v2, "vcid"

    # invokes: Lcom/igexin/sdk/SdkService;->broadcastToCarrier(ILjava/lang/String;Ljava/lang/String;)V
    invoke-static {v1, v5, v2, v0}, Lcom/igexin/sdk/SdkService;->access$200(Lcom/igexin/sdk/SdkService;ILjava/lang/String;Ljava/lang/String;)V

    .line 268
    invoke-static {v0}, Lcom/igexin/sdk/data/BasicDataManager;->saveVcidToFile(Ljava/lang/String;)V

    .line 269
    return-void
.end method
