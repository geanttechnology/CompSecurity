.class Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "PlayNowPreferenceDelegate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->fetchDevices()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener",
        "<",
        "Ljava/util/List",
        "<",
        "Lcom/xfinity/playerlib/downloads/RegisteredDevice;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 375
    iput-object p1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 4
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 411
    iget-object v2, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;->getCause()Ljava/lang/Throwable;

    move-result-object v1

    check-cast v1, Ljava/lang/Exception;

    # invokes: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->getErrorDialogBuilder(Ljava/lang/Exception;)Landroid/app/AlertDialog$Builder;
    invoke-static {v2, v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$1500(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;Ljava/lang/Exception;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 412
    .local v0, "builder":Landroid/app/AlertDialog$Builder;
    sget v1, Lcom/xfinity/playerlib/R$string;->dlg_btn_try_again:I

    new-instance v2, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12$4;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12$4;-><init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$string;->dlg_btn_cancel:I

    new-instance v3, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12$3;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12$3;-><init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;)V

    .line 418
    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    new-instance v2, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12$2;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12$2;-><init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;)V

    .line 423
    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)Landroid/app/AlertDialog$Builder;

    .line 433
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/AlertDialog;->show()V

    .line 434
    return-void
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 375
    check-cast p1, Ljava/util/List;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;->onPostExecute(Ljava/util/List;)V

    return-void
.end method

.method public onPostExecute(Ljava/util/List;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/downloads/RegisteredDevice;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 378
    .local p1, "resource":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/downloads/RegisteredDevice;>;"
    iget-object v5, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # setter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->deviceList:Ljava/util/List;
    invoke-static {v5, p1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$1102(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;Ljava/util/List;)Ljava/util/List;

    .line 379
    iget-object v5, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    sget v6, Lcom/xfinity/playerlib/R$string;->settings_manage_devices_loading_key:I

    # invokes: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;
    invoke-static {v5, v6}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$1200(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;I)Landroid/preference/Preference;

    move-result-object v2

    .line 380
    .local v2, "loadingDevices":Landroid/preference/Preference;
    if-eqz v2, :cond_0

    .line 381
    iget-object v5, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # invokes: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->getPreferenceScreen()Landroid/preference/PreferenceScreen;
    invoke-static {v5}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$1300(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Landroid/preference/PreferenceScreen;

    move-result-object v5

    invoke-virtual {v5, v2}, Landroid/preference/PreferenceScreen;->removePreference(Landroid/preference/Preference;)Z

    .line 384
    :cond_0
    iget-object v5, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    invoke-static {v5}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$900(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v5

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v5

    check-cast v5, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getDeviceRegistration()Lcom/xfinity/playerlib/downloads/DeviceRegistration;

    move-result-object v3

    .line 385
    .local v3, "registration":Lcom/xfinity/playerlib/downloads/DeviceRegistration;
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_2

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/downloads/RegisteredDevice;

    .line 386
    .local v1, "device":Lcom/xfinity/playerlib/downloads/RegisteredDevice;
    new-instance v0, Lcom/xfinity/playerlib/view/settings/ButtonPreference;

    iget-object v6, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->context:Landroid/app/Activity;
    invoke-static {v6}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$200(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Landroid/app/Activity;

    move-result-object v6

    const/4 v7, 0x0

    invoke-direct {v0, v6, v7}, Lcom/xfinity/playerlib/view/settings/ButtonPreference;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 387
    .local v0, "button":Lcom/xfinity/playerlib/view/settings/ButtonPreference;
    invoke-virtual {v1}, Lcom/xfinity/playerlib/downloads/RegisteredDevice;->getDeviceId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->setKey(Ljava/lang/String;)V

    .line 388
    invoke-virtual {v1}, Lcom/xfinity/playerlib/downloads/RegisteredDevice;->getDeviceName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->setTitleText(Ljava/lang/String;)V

    .line 390
    if-eqz v3, :cond_1

    .line 391
    invoke-virtual {v1}, Lcom/xfinity/playerlib/downloads/RegisteredDevice;->getDeviceId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v3}, Lcom/xfinity/playerlib/downloads/DeviceRegistration;->getDeviceId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 392
    iget-object v6, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # invokes: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->getPreferenceScreen()Landroid/preference/PreferenceScreen;
    invoke-static {v6}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$1300(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Landroid/preference/PreferenceScreen;

    move-result-object v6

    invoke-virtual {v6}, Landroid/preference/PreferenceScreen;->getContext()Landroid/content/Context;

    move-result-object v6

    invoke-virtual {v6}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    .line 393
    .local v4, "res":Landroid/content/res/Resources;
    sget v6, Lcom/xfinity/playerlib/R$string;->settings_dl_devices_this_device:I

    invoke-virtual {v4, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->setTitleText(Ljava/lang/String;)V

    .line 394
    sget v6, Lcom/xfinity/playerlib/R$string;->settings_dl_devices_remove:I

    invoke-virtual {v4, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->setRightButtonText(Ljava/lang/String;)V

    .line 395
    new-instance v6, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12$1;

    invoke-direct {v6, p0, v0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12$1;-><init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;Lcom/xfinity/playerlib/view/settings/ButtonPreference;)V

    invoke-virtual {v0, v6}, Lcom/xfinity/playerlib/view/settings/ButtonPreference;->setRightButtonClickListener(Landroid/view/View$OnClickListener;)V

    .line 405
    .end local v4    # "res":Landroid/content/res/Resources;
    :cond_1
    iget-object v6, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # invokes: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->getPreferenceScreen()Landroid/preference/PreferenceScreen;
    invoke-static {v6}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$1300(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Landroid/preference/PreferenceScreen;

    move-result-object v6

    invoke-virtual {v6, v0}, Landroid/preference/PreferenceScreen;->addPreference(Landroid/preference/Preference;)Z

    goto :goto_0

    .line 407
    .end local v0    # "button":Lcom/xfinity/playerlib/view/settings/ButtonPreference;
    .end local v1    # "device":Lcom/xfinity/playerlib/downloads/RegisteredDevice;
    :cond_2
    return-void
.end method
