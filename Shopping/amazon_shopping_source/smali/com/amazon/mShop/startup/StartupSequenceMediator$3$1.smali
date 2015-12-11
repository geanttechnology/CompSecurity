.class Lcom/amazon/mShop/startup/StartupSequenceMediator$3$1;
.super Ljava/lang/Object;
.source "StartupSequenceMediator.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/startup/StartupSequenceMediator$3;->start()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/startup/StartupSequenceMediator$3;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/startup/StartupSequenceMediator$3;)V
    .locals 0

    .prologue
    .line 135
    iput-object p1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$3$1;->this$1:Lcom/amazon/mShop/startup/StartupSequenceMediator$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 141
    iget-object v0, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$3$1;->this$1:Lcom/amazon/mShop/startup/StartupSequenceMediator$3;

    iget-object v0, v0, Lcom/amazon/mShop/startup/StartupSequenceMediator$3;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    iget-object v1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$3$1;->this$1:Lcom/amazon/mShop/startup/StartupSequenceMediator$3;

    iget-object v1, v1, Lcom/amazon/mShop/startup/StartupSequenceMediator$3;->val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    # invokes: Lcom/amazon/mShop/startup/StartupSequenceMediator;->handleCookiesAndAccount(Landroid/content/Context;)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/startup/StartupSequenceMediator;->access$000(Lcom/amazon/mShop/startup/StartupSequenceMediator;Landroid/content/Context;)V

    .line 143
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/startup/StartupSequenceMediator$3$1$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/startup/StartupSequenceMediator$3$1$1;-><init>(Lcom/amazon/mShop/startup/StartupSequenceMediator$3$1;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->runOnUiThread(Ljava/lang/Runnable;)V

    .line 151
    return-void
.end method
