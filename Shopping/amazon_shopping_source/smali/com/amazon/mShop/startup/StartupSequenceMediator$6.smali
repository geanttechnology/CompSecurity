.class Lcom/amazon/mShop/startup/StartupSequenceMediator$6;
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
    .line 197
    iput-object p1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$6;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/startup/StartupTask;-><init>(Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public start()V
    .locals 3

    .prologue
    .line 200
    const-string/jumbo v0, "StartupSequenceMediator"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "start "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/mShop/startup/StartupSequenceMediator$6;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 201
    iget-object v0, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$6;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    # invokes: Lcom/amazon/mShop/startup/StartupSequenceMediator;->requestFeatureStates(Lcom/amazon/mShop/startup/StartupTask;)V
    invoke-static {v0, p0}, Lcom/amazon/mShop/startup/StartupSequenceMediator;->access$200(Lcom/amazon/mShop/startup/StartupSequenceMediator;Lcom/amazon/mShop/startup/StartupTask;)V

    .line 202
    return-void
.end method
