.class Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$14;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "PlayNowPreferenceDelegate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->unregisterDevice()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

.field final synthetic val$settings:Lcom/xfinity/playerlib/model/user/PlayerUserSettings;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 458
    iput-object p1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$14;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$14;->val$settings:Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 3
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 490
    :try_start_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$14;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;->getCause()Ljava/lang/Throwable;

    move-result-object v1

    check-cast v1, Ljava/lang/Exception;

    # invokes: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->showUnregisterErrorDialog(Ljava/lang/Exception;)V
    invoke-static {v2, v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$2100(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;Ljava/lang/Exception;)V
    :try_end_0
    .catch Landroid/view/WindowManager$BadTokenException; {:try_start_0 .. :try_end_0} :catch_0

    .line 495
    :goto_0
    return-void

    .line 491
    :catch_0
    move-exception v0

    .line 492
    .local v0, "e":Landroid/view/WindowManager$BadTokenException;
    const-string v1, "Settings"

    const-string v2, "Failed to show Alert Dialog for Unregister Failure!"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 458
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$14;->onPostExecute(Ljava/lang/Void;)V

    return-void
.end method

.method public onPostExecute(Ljava/lang/Void;)V
    .locals 7
    .param p1, "resource"    # Ljava/lang/Void;

    .prologue
    .line 461
    iget-object v4, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$14;->val$settings:Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getDeviceRegistration()Lcom/xfinity/playerlib/downloads/DeviceRegistration;

    move-result-object v4

    invoke-virtual {v4}, Lcom/xfinity/playerlib/downloads/DeviceRegistration;->getDeviceId()Ljava/lang/String;

    move-result-object v1

    .line 462
    .local v1, "deviceId":Ljava/lang/String;
    iget-object v4, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$14;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # invokes: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->findPreference(Ljava/lang/String;)Landroid/preference/Preference;
    invoke-static {v4, v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$2000(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;Ljava/lang/String;)Landroid/preference/Preference;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/view/settings/ButtonPreference;

    .line 464
    .local v2, "deviceItem":Lcom/xfinity/playerlib/view/settings/ButtonPreference;
    :try_start_0
    iget-object v4, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$14;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$400(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v4

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->deleteAllContent()Ljava/util/Map;

    .line 465
    iget-object v4, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$14;->val$settings:Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setDeviceRegistration(Lcom/xfinity/playerlib/downloads/DeviceRegistration;)V

    .line 467
    if-eqz v2, :cond_0

    .line 468
    iget-object v4, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$14;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # invokes: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->getPreferenceScreen()Landroid/preference/PreferenceScreen;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$1300(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Landroid/preference/PreferenceScreen;

    move-result-object v4

    invoke-virtual {v4, v2}, Landroid/preference/PreferenceScreen;->removePreference(Landroid/preference/Preference;)Z

    .line 471
    :cond_0
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$14;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->context:Landroid/app/Activity;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$200(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Landroid/app/Activity;

    move-result-object v4

    invoke-direct {v0, v4}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 472
    .local v0, "builder":Landroid/app/AlertDialog$Builder;
    const-string v4, "Device has been unregistered"

    invoke-virtual {v0, v4}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v4

    const-string v5, "Device Unregistration"

    .line 473
    invoke-virtual {v4, v5}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$14;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .line 474
    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->context:Landroid/app/Activity;
    invoke-static {v5}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$200(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Landroid/app/Activity;

    move-result-object v5

    sget v6, Lcom/xfinity/playerlib/R$string;->dlg_btn_ok:I

    invoke-virtual {v5, v6}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v5

    new-instance v6, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$14$1;

    invoke-direct {v6, p0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$14$1;-><init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$14;)V

    invoke-virtual {v4, v5, v6}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 478
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v4

    invoke-virtual {v4}, Landroid/app/AlertDialog;->show()V
    :try_end_0
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Landroid/view/WindowManager$BadTokenException; {:try_start_0 .. :try_end_0} :catch_1

    .line 485
    .end local v0    # "builder":Landroid/app/AlertDialog$Builder;
    :goto_0
    return-void

    .line 479
    :catch_0
    move-exception v3

    .line 480
    .local v3, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    iget-object v4, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$14;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # invokes: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->showUnregisterErrorDialog(Ljava/lang/Exception;)V
    invoke-static {v4, v3}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$2100(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;Ljava/lang/Exception;)V

    goto :goto_0

    .line 481
    .end local v3    # "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    :catch_1
    move-exception v3

    .line 482
    .local v3, "e":Landroid/view/WindowManager$BadTokenException;
    const-string v4, "Settings"

    const-string v5, "Failed to show Alert Dialog for Unregister Success!"

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
