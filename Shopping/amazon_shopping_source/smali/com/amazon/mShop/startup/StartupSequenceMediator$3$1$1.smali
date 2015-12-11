.class Lcom/amazon/mShop/startup/StartupSequenceMediator$3$1$1;
.super Ljava/lang/Object;
.source "StartupSequenceMediator.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/startup/StartupSequenceMediator$3$1;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/amazon/mShop/startup/StartupSequenceMediator$3$1;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/startup/StartupSequenceMediator$3$1;)V
    .locals 0

    .prologue
    .line 143
    iput-object p1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$3$1$1;->this$2:Lcom/amazon/mShop/startup/StartupSequenceMediator$3$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 147
    iget-object v0, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$3$1$1;->this$2:Lcom/amazon/mShop/startup/StartupSequenceMediator$3$1;

    iget-object v0, v0, Lcom/amazon/mShop/startup/StartupSequenceMediator$3$1;->this$1:Lcom/amazon/mShop/startup/StartupSequenceMediator$3;

    iget-object v0, v0, Lcom/amazon/mShop/startup/StartupSequenceMediator$3;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    const-string/jumbo v1, "taskGetCookiesAndAccount"

    const-string/jumbo v2, "taskResultSucceed"

    invoke-virtual {v0, v1, v2}, Lcom/amazon/mShop/startup/StartupSequenceMediator;->endTask(Ljava/lang/String;Ljava/lang/String;)V

    .line 148
    return-void
.end method
