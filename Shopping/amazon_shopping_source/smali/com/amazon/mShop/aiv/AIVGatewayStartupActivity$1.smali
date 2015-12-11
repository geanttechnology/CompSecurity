.class Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity$1;
.super Ljava/lang/Object;
.source "AIVGatewayStartupActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;->launchAIVGatewayPage()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;)V
    .locals 0

    .prologue
    .line 57
    iput-object p1, p0, Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity$1;->this$0:Lcom/amazon/mShop/aiv/AIVGatewayStartupActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 60
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    .line 61
    .local v0, "applicationContext":Landroid/content/Context;
    sget v1, Lcom/amazon/mShop/android/lib/R$string;->aiv_unavailable:I

    invoke-static {v0, v1}, Lcom/amazon/mShop/util/UIUtils;->info(Landroid/content/Context;I)V

    .line 62
    return-void
.end method
