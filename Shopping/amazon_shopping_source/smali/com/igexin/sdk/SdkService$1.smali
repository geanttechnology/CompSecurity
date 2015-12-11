.class Lcom/igexin/sdk/SdkService$1;
.super Ljava/lang/Object;
.source "SdkService.java"

# interfaces
.implements Lcom/igexin/sdk/CallbackListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/igexin/sdk/SdkService;->getDynamicConfigAndRegister()V
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
    .line 155
    iput-object p1, p0, Lcom/igexin/sdk/SdkService$1;->this$0:Lcom/igexin/sdk/SdkService;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public exceptionHandler(Ljava/lang/Exception;)V
    .locals 1
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 179
    iget-object v0, p0, Lcom/igexin/sdk/SdkService$1;->this$0:Lcom/igexin/sdk/SdkService;

    # invokes: Lcom/igexin/sdk/SdkService;->register()V
    invoke-static {v0}, Lcom/igexin/sdk/SdkService;->access$100(Lcom/igexin/sdk/SdkService;)V

    .line 180
    return-void
.end method

.method public getCallbackData(Ljava/lang/Object;)V
    .locals 5
    .param p1, "data"    # Ljava/lang/Object;

    .prologue
    .line 159
    move-object v0, p1

    check-cast v0, Lcom/igexin/sdk/data/DynamicConfig;

    .line 161
    .local v0, "cfg":Lcom/igexin/sdk/data/DynamicConfig;
    invoke-virtual {v0}, Lcom/igexin/sdk/data/DynamicConfig;->isEncrypt()Z

    move-result v1

    invoke-static {v1}, Lcom/igexin/sdk/data/ConfigDataManager;->setEncryptEnable(Z)V

    .line 162
    invoke-virtual {v0}, Lcom/igexin/sdk/data/DynamicConfig;->getDownloadUrl()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/igexin/sdk/data/ConfigDataManager;->setDownloadUrl(Ljava/lang/String;)V

    .line 163
    invoke-virtual {v0}, Lcom/igexin/sdk/data/DynamicConfig;->getMasterAppID()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/igexin/sdk/data/ConfigDataManager;->setMasterAppID(Ljava/lang/String;)V

    .line 164
    invoke-virtual {v0}, Lcom/igexin/sdk/data/DynamicConfig;->getMasterPkgName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/igexin/sdk/data/ConfigDataManager;->setMasterPkgName(Ljava/lang/String;)V

    .line 165
    invoke-virtual {v0}, Lcom/igexin/sdk/data/DynamicConfig;->getMasterServiceAction()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/igexin/sdk/data/ConfigDataManager;->setMasterServiceAction(Ljava/lang/String;)V

    .line 166
    invoke-static {v0}, Lcom/igexin/sdk/data/ConfigDataManager;->write(Lcom/igexin/sdk/data/DynamicConfig;)V

    .line 168
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    sput-wide v1, Lcom/igexin/sdk/data/BasicDataManager;->lastGetConfigTime:J

    .line 169
    const/4 v1, 0x4

    const-string/jumbo v2, "lastGetConfigTime"

    sget-wide v3, Lcom/igexin/sdk/data/BasicDataManager;->lastGetConfigTime:J

    invoke-static {v3, v4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-static {v1, v2, v3}, Lcom/igexin/sdk/data/BasicDataManager;->updateDBValue(ILjava/lang/String;Ljava/lang/String;)V

    .line 173
    iget-object v1, p0, Lcom/igexin/sdk/SdkService$1;->this$0:Lcom/igexin/sdk/SdkService;

    # invokes: Lcom/igexin/sdk/SdkService;->initClientIDReceiver()V
    invoke-static {v1}, Lcom/igexin/sdk/SdkService;->access$000(Lcom/igexin/sdk/SdkService;)V

    .line 174
    iget-object v1, p0, Lcom/igexin/sdk/SdkService$1;->this$0:Lcom/igexin/sdk/SdkService;

    # invokes: Lcom/igexin/sdk/SdkService;->register()V
    invoke-static {v1}, Lcom/igexin/sdk/SdkService;->access$100(Lcom/igexin/sdk/SdkService;)V

    .line 175
    return-void
.end method
