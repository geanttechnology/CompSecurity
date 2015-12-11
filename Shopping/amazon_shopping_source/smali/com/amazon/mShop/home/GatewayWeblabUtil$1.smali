.class Lcom/amazon/mShop/home/GatewayWeblabUtil$1;
.super Ljava/lang/Object;
.source "GatewayWeblabUtil.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/home/GatewayWeblabUtil;->postGatewayFeatureTriggerWithTreatment(Ljava/lang/String;Ljava/lang/Integer;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/home/GatewayWeblabUtil;

.field final synthetic val$cachedTimeStamp:Ljava/lang/Integer;

.field final synthetic val$treatment:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/home/GatewayWeblabUtil;Ljava/lang/String;Ljava/lang/Integer;)V
    .locals 0

    .prologue
    .line 107
    iput-object p1, p0, Lcom/amazon/mShop/home/GatewayWeblabUtil$1;->this$0:Lcom/amazon/mShop/home/GatewayWeblabUtil;

    iput-object p2, p0, Lcom/amazon/mShop/home/GatewayWeblabUtil$1;->val$treatment:Ljava/lang/String;

    iput-object p3, p0, Lcom/amazon/mShop/home/GatewayWeblabUtil$1;->val$cachedTimeStamp:Ljava/lang/Integer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 110
    const-string/jumbo v0, "Android_ShopAppHTMLGateway"

    iget-object v1, p0, Lcom/amazon/mShop/home/GatewayWeblabUtil$1;->val$treatment:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/mShop/home/GatewayWeblabUtil$1;->val$cachedTimeStamp:Ljava/lang/Integer;

    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/feature/WeblabCsmUtils;->postFeatureTriggerWithTreatment(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V

    .line 111
    # getter for: Lcom/amazon/mShop/home/GatewayWeblabUtil;->DEBUG:Z
    invoke-static {}, Lcom/amazon/mShop/home/GatewayWeblabUtil;->access$000()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 112
    const-string/jumbo v1, "GatewayWeblabUtil"

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "post the Android_ShopAppHTMLGateway with treatment "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v0, p0, Lcom/amazon/mShop/home/GatewayWeblabUtil$1;->val$treatment:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    const-string/jumbo v0, ""

    :goto_0
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v2, ", and cached stamp "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v0, p0, Lcom/amazon/mShop/home/GatewayWeblabUtil$1;->val$cachedTimeStamp:Ljava/lang/Integer;

    if-nez v0, :cond_2

    const-string/jumbo v0, ""

    :goto_1
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 115
    :cond_0
    return-void

    .line 112
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/home/GatewayWeblabUtil$1;->val$treatment:Ljava/lang/String;

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lcom/amazon/mShop/home/GatewayWeblabUtil$1;->val$cachedTimeStamp:Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method
