.class Lcom/amazon/mShop/startup/StartupSequenceMediator$10;
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
    .line 271
    iput-object p1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$10;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/startup/StartupTask;-><init>(Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public start()V
    .locals 4

    .prologue
    .line 274
    invoke-static {}, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;->getInstance()Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/init/RetailSearchInitializer;->onStartup()V

    .line 278
    new-instance v1, Lcom/amazon/mShop/startup/StartupSequenceMediator$AppExtensionInitializationTask;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/startup/StartupSequenceMediator$AppExtensionInitializationTask;-><init>(Lcom/amazon/mShop/startup/StartupTask;)V

    const/4 v0, 0x1

    new-array v2, v0, [Ljava/lang/Void;

    const/4 v3, 0x0

    const/4 v0, 0x0

    check-cast v0, Ljava/lang/Void;

    aput-object v0, v2, v3

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/startup/StartupSequenceMediator$AppExtensionInitializationTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 279
    return-void
.end method
