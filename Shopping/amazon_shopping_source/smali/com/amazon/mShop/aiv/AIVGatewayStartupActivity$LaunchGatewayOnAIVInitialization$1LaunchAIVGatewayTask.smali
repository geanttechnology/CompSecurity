.class Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity$LaunchGatewayOnAIVInitialization$1LaunchAIVGatewayTask;
.super Ljava/lang/Object;
.source "AIVGatewayStartupActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity$LaunchGatewayOnAIVInitialization;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "LaunchAIVGatewayTask"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity$LaunchGatewayOnAIVInitialization;

.field final synthetic val$activity:Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity$LaunchGatewayOnAIVInitialization;Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 115
    iput-object p1, p0, Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity$LaunchGatewayOnAIVInitialization$1LaunchAIVGatewayTask;->this$0:Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity$LaunchGatewayOnAIVInitialization;

    iput-object p2, p0, Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity$LaunchGatewayOnAIVInitialization$1LaunchAIVGatewayTask;->val$activity:Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 118
    iget-object v0, p0, Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity$LaunchGatewayOnAIVInitialization$1LaunchAIVGatewayTask;->val$activity:Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_0

    .line 119
    iget-object v0, p0, Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity$LaunchGatewayOnAIVInitialization$1LaunchAIVGatewayTask;->val$activity:Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;

    # invokes: Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;->launchAIVGatewayPage()V
    invoke-static {v0}, Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;->access$100(Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;)V

    .line 121
    :cond_0
    return-void
.end method
