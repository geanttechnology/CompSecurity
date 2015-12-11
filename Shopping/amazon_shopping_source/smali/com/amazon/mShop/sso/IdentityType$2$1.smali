.class Lcom/amazon/mShop/sso/IdentityType$2$1;
.super Ljava/lang/Object;
.source "IdentityType.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/sso/IdentityType$2;->handleBackgroundService(Lcom/amazon/mShop/sso/SSOBackgroundAccountService;Landroid/content/Intent;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/sso/IdentityType$2;

.field final synthetic val$applicationContext:Landroid/content/Context;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/sso/IdentityType$2;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 481
    iput-object p1, p0, Lcom/amazon/mShop/sso/IdentityType$2$1;->this$0:Lcom/amazon/mShop/sso/IdentityType$2;

    iput-object p2, p0, Lcom/amazon/mShop/sso/IdentityType$2$1;->val$applicationContext:Landroid/content/Context;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 484
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->userSignedOut()V

    .line 485
    iget-object v0, p0, Lcom/amazon/mShop/sso/IdentityType$2$1;->val$applicationContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/mShop/ActivityTerminationReceiver;->sendTerminationBroadcast(Landroid/content/Context;)V

    .line 486
    return-void
.end method
