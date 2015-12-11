.class Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$3;
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
    .line 166
    iput-object p1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$3;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$3;->val$settings:Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPreferenceChange(Landroid/preference/Preference;Ljava/lang/Object;)Z
    .locals 6
    .param p1, "preference"    # Landroid/preference/Preference;
    .param p2, "newValue"    # Ljava/lang/Object;

    .prologue
    const/4 v5, 0x1

    .line 168
    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v1

    .line 170
    .local v1, "useCell":Ljava/lang/Boolean;
    :try_start_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$3;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$400(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v4

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_0

    const-wide/high16 v2, -0x4010000000000000L    # -1.0

    :goto_0
    invoke-virtual {v4, v2, v3}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->setCellularDataThreshold(D)V
    :try_end_0
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_0 .. :try_end_0} :catch_0

    .line 175
    iget-object v2, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$3;->val$settings:Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setUseCellularWhenAvailable(Z)V

    .line 176
    :goto_1
    return v5

    .line 170
    :cond_0
    const-wide/16 v2, 0x0

    goto :goto_0

    .line 171
    :catch_0
    move-exception v0

    .line 172
    .local v0, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$3;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$400(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$3;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->context:Landroid/app/Activity;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$200(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v2, v3, v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->showCrashDialog(Landroid/content/Context;Ljava/lang/Exception;)V

    goto :goto_1
.end method
