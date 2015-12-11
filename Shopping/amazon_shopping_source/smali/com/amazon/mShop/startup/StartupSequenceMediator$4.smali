.class Lcom/amazon/mShop/startup/StartupSequenceMediator$4;
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
    .line 161
    iput-object p1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$4;->this$0:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    iput-object p4, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$4;->val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/startup/StartupTask;-><init>(Lcom/amazon/mShop/util/mediator/Mediator;Ljava/lang/String;)V

    return-void
.end method


# virtual methods
.method public start()V
    .locals 2

    .prologue
    .line 166
    invoke-static {}, Lcom/amazon/mShop/appstore/AppstoreUtils;->isAppstoreAvailable()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 169
    invoke-static {}, Lamazon/android/dexload/SupplementalDexLoader;->getInstance()Lamazon/android/dexload/SupplementalDexLoader;

    move-result-object v1

    invoke-virtual {v1}, Lamazon/android/dexload/SupplementalDexLoader;->waitForLoad()V

    .line 172
    iget-object v1, p0, Lcom/amazon/mShop/startup/StartupSequenceMediator$4;->val$activity:Lcom/amazon/mShop/splashscreen/StartupActivity;

    invoke-virtual {v1}, Lcom/amazon/mShop/splashscreen/StartupActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 173
    .local v0, "applicationContext":Landroid/content/Context;
    invoke-static {v0}, Lcom/amazon/mShop/appstore/AppstoreUtils;->setAppstoreDeviceInfoCookie(Landroid/content/Context;)V

    .line 176
    invoke-static {}, Lcom/amazon/mShop/appstore/AppstoreUtils;->setUpAppstoreDeviceInfoCookieListener()V

    .line 179
    .end local v0    # "applicationContext":Landroid/content/Context;
    :cond_0
    const-string/jumbo v1, "taskResultSucceed"

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/startup/StartupSequenceMediator$4;->end(Ljava/lang/String;)V

    .line 180
    return-void
.end method
