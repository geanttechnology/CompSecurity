.class Lcom/amazon/mShop/startup/StartupSequenceMediator$3;
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

.field final synthetic val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/startup/StartupSequenceMediator;Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;Lcom/amazon/mShop/splashscreen/StartupActivity;)V
    .locals 0
    .param p2, "x0"    # Lcom/amazon/mShop/util/mediator/Mediator;
    .param p3, "x1"    # Ljava/lang/String;

    .prologue
    .line 131
    iput-object p1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$3;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    iput-object p4, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$3;->val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/startup/StartupTask;-><init>(Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public start()V
    .locals 3

    .prologue
    .line 134
    const-string/jumbo v0, "StartupSequenceMediator"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "start "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/mShop/startup/StartupSequenceMediator$3;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 135
    # getter for: Lcom/amazon/mShop/startup/StartupSequenceMediator;->sExecutor:Ljava/util/concurrent/Executor;
    invoke-static {}, Lcom/amazon/mShop/startup/StartupSequenceMediator;->access$100()Ljava/util/concurrent/Executor;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/startup/StartupSequenceMediator$3$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/startup/StartupSequenceMediator$3$1;-><init>(Lcom/amazon/mShop/startup/StartupSequenceMediator$3;)V

    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 154
    return-void
.end method
