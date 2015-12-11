.class Lcom/amazon/mShop/startup/StartupSequenceMediator$13;
.super Lcom/amazon/mShop/startup/StartupTask;
.source "StartupSequenceMediator.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/startup/StartupSequenceMediator;-><init>(Lcom/amazon/mShop/splashscreen/StartupActivity;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/startup/StartupSequenceMediator;Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;)V
    .locals 0
    .param p2, "x0"    # Lcom/amazon/mShop/util/mediator/Mediator;
    .param p3, "x1"    # Ljava/lang/String;

    .prologue
    .line 368
    iput-object p1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$13;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/startup/StartupTask;-><init>(Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public start()V
    .locals 2

    .prologue
    .line 372
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/startup/StartupSequenceMediator$13$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/startup/StartupSequenceMediator$13$1;-><init>(Lcom/amazon/mShop/startup/StartupSequenceMediator$13;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 385
    return-void
.end method
