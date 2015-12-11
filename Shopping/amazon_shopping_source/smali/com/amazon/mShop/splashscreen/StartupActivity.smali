.class public Lcom/amazon/mShop/splashscreen/StartupActivity;
.super Lcom/amazon/mShop/startup/BaseActivity;
.source "StartupActivity.java"


# instance fields
.field private final mStartupSequenceMediator:Lcom/amazon/mShop/startup/StartupSequenceMediator;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/amazon/mShop/startup/BaseActivity;-><init>()V

    .line 13
    new-instance v0, Lcom/amazon/mShop/startup/StartupSequenceMediator;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/startup/StartupSequenceMediator;-><init>(Lcom/amazon/mShop/splashscreen/StartupActivity;)V

    iput-object v0, p0, Lcom/amazon/mShop/splashscreen/StartupActivity;->mStartupSequenceMediator:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    return-void
.end method


# virtual methods
.method public getStartupMediator()Lcom/amazon/mShop/startup/StartupSequenceMediator;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/amazon/mShop/splashscreen/StartupActivity;->mStartupSequenceMediator:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    return-object v0
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 3
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "resultIntent"    # Landroid/content/Intent;

    .prologue
    .line 27
    invoke-super {p0, p1, p2, p3}, Lcom/amazon/mShop/startup/BaseActivity;->onActivityResult(IILandroid/content/Intent;)V

    .line 28
    const/16 v2, 0x10

    if-ne v2, p1, :cond_0

    if-eqz p3, :cond_0

    .line 29
    const-string/jumbo v2, "intentExtraDataTaskId"

    invoke-virtual {p3, v2}, Landroid/content/Intent;->getCharSequenceExtra(Ljava/lang/String;)Ljava/lang/CharSequence;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 30
    .local v0, "taskId":Ljava/lang/String;
    const-string/jumbo v2, "intentExtraDataTaskResult"

    invoke-virtual {p3, v2}, Landroid/content/Intent;->getCharSequenceExtra(Ljava/lang/String;)Ljava/lang/CharSequence;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 31
    .local v1, "taskResult":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/splashscreen/StartupActivity;->mStartupSequenceMediator:Lcom/amazon/mShop/startup/StartupSequenceMediator;

    invoke-virtual {v2, v0, v1}, Lcom/amazon/mShop/startup/StartupSequenceMediator;->endTask(Ljava/lang/String;Ljava/lang/String;)V

    .line 33
    .end local v0    # "taskId":Ljava/lang/String;
    .end local v1    # "taskResult":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 17
    invoke-super {p0, p1}, Lcom/amazon/mShop/startup/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 18
    sget v0, Lcom/amazon/mShop/android/lib/R$layout;->splash_screen:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/splashscreen/StartupActivity;->setContentView(I)V

    .line 19
    return-void
.end method
