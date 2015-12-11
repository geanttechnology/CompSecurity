.class Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$1;
.super Ljava/lang/Object;
.source "PlayNowPreferenceDelegate.java"

# interfaces
.implements Landroid/preference/Preference$OnPreferenceChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->initPreferences()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

.field final synthetic val$settings:Lcom/xfinity/playerlib/model/user/PlayerUserSettings;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 113
    iput-object p1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$1;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$1;->val$settings:Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPreferenceChange(Landroid/preference/Preference;Ljava/lang/Object;)Z
    .locals 5
    .param p1, "preference"    # Landroid/preference/Preference;
    .param p2, "newValue"    # Ljava/lang/Object;

    .prologue
    .line 115
    iget-object v3, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$1;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->parentalControlsCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$000(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v3

    invoke-interface {v3}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getCachedResultIfAvailable()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;

    .line 116
    .local v2, "pinOption":Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;
    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v1

    .line 117
    .local v1, "newWantsAdultContentValue":Ljava/lang/Boolean;
    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    if-eqz v3, :cond_0

    if-eqz v2, :cond_1

    invoke-virtual {v2}, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->getParentalPin()Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;

    move-result-object v3

    if-nez v3, :cond_1

    .line 119
    :cond_0
    iget-object v3, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$1;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->notificationQueueManager:Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$100(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;->cancelAdultDownloadNotifications()V

    .line 120
    iget-object v3, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$1;->val$settings:Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setWantsAdultContent(Z)V

    .line 121
    const/4 v3, 0x1

    .line 127
    :goto_0
    return v3

    .line 124
    :cond_1
    new-instance v0, Landroid/content/Intent;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$1;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->context:Landroid/app/Activity;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$200(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Landroid/app/Activity;

    move-result-object v3

    const-class v4, Lcom/xfinity/playerlib/view/common/AdultContentSettingChangeActivity;

    invoke-direct {v0, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 125
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v3, 0x40000000    # 2.0f

    invoke-virtual {v0, v3}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 126
    iget-object v3, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$1;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->context:Landroid/app/Activity;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$200(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v3, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 127
    const/4 v3, 0x0

    goto :goto_0
.end method
