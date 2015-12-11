.class Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity$LaunchGatewayOnAIVInitialization;
.super Ljava/lang/Object;
.source "AIVGatewayStartupActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "LaunchGatewayOnAIVInitialization"
.end annotation


# instance fields
.field private final mCallerActivity:Ljava/lang/ref/WeakReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;)V
    .locals 2
    .param p1, "activity"    # Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;

    .prologue
    .line 95
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 96
    if-nez p1, :cond_0

    .line 97
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "AIVGatewayStartupActivity cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 99
    :cond_0
    new-instance v0, Ljava/lang/ref/WeakReference;

    invoke-direct {v0, p1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    iput-object v0, p0, Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity$LaunchGatewayOnAIVInitialization;->mCallerActivity:Ljava/lang/ref/WeakReference;

    .line 100
    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;
    .param p2, "x1"    # Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity$1;

    .prologue
    .line 92
    invoke-direct {p0, p1}, Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity$LaunchGatewayOnAIVInitialization;-><init>(Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 103
    iget-object v1, p0, Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity$LaunchGatewayOnAIVInitialization;->mCallerActivity:Ljava/lang/ref/WeakReference;

    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v1

    if-nez v1, :cond_1

    .line 125
    :cond_0
    :goto_0
    return-void

    .line 108
    :cond_1
    invoke-static {}, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->waitForAIVInitialize()V

    .line 110
    iget-object v1, p0, Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity$LaunchGatewayOnAIVInitialization;->mCallerActivity:Ljava/lang/ref/WeakReference;

    invoke-virtual {v1}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;

    .line 111
    .local v0, "activity":Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;
    if-eqz v0, :cond_0

    .line 124
    new-instance v1, Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity$LaunchGatewayOnAIVInitialization$1LaunchAIVGatewayTask;

    invoke-direct {v1, p0, v0}, Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity$LaunchGatewayOnAIVInitialization$1LaunchAIVGatewayTask;-><init>(Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity$LaunchGatewayOnAIVInitialization;Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;->runOnUiThread(Ljava/lang/Runnable;)V

    goto :goto_0
.end method
