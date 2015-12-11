.class Lcom/amazon/mShop/startup/StartupSequenceMediator$AppExtensionInitializationTask;
.super Landroid/os/AsyncTask;
.source "StartupSequenceMediator.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/startup/StartupSequenceMediator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "AppExtensionInitializationTask"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/os/AsyncTask",
        "<",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field private mTask:Lcom/amazon/mShop/startup/StartupTask;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/startup/StartupTask;)V
    .locals 0
    .param p1, "task"    # Lcom/amazon/mShop/startup/StartupTask;

    .prologue
    .line 610
    invoke-direct {p0}, Landroid/os/AsyncTask;-><init>()V

    .line 611
    iput-object p1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$AppExtensionInitializationTask;->mTask:Lcom/amazon/mShop/startup/StartupTask;

    .line 612
    return-void
.end method


# virtual methods
.method protected bridge synthetic doInBackground([Ljava/lang/Object;)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # [Ljava/lang/Object;

    .prologue
    .line 607
    check-cast p1, [Ljava/lang/Void;

    .end local p1    # "x0":[Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/startup/StartupSequenceMediator$AppExtensionInitializationTask;->doInBackground([Ljava/lang/Void;)Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method protected varargs doInBackground([Ljava/lang/Void;)Ljava/lang/Void;
    .locals 1
    .param p1, "params"    # [Ljava/lang/Void;

    .prologue
    .line 616
    invoke-static {}, Lcom/amazon/mShop/aiv/AIVAvailabilityUtils;->waitForAIVInitialize()V

    .line 617
    invoke-static {}, Lcom/amazon/mShop/clouddrive/CloudDriveAvailability;->getInstance()Lcom/amazon/mShop/clouddrive/CloudDriveAvailability;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/clouddrive/CloudDriveAvailability;->waitForInitialization()V

    .line 618
    invoke-static {}, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->getInstance()Lcom/amazon/mShop/voice/MShopVoicePackageProxy;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/voice/MShopVoicePackageProxy;->waitForInitialization()V

    .line 619
    const/4 v0, 0x0

    return-object v0
.end method

.method protected bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 607
    check-cast p1, Ljava/lang/Void;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/startup/StartupSequenceMediator$AppExtensionInitializationTask;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method protected onPostExecute(Ljava/lang/Void;)V
    .locals 2
    .param p1, "result"    # Ljava/lang/Void;

    .prologue
    .line 624
    iget-object v0, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$AppExtensionInitializationTask;->mTask:Lcom/amazon/mShop/startup/StartupTask;

    const-string/jumbo v1, "taskResultSucceed"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/startup/StartupTask;->end(Ljava/lang/String;)V

    .line 625
    return-void
.end method
