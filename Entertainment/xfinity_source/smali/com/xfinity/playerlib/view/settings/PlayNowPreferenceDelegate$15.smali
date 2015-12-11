.class Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$15;
.super Ljava/lang/Object;
.source "PlayNowPreferenceDelegate.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->showUnregisterErrorDialog(Ljava/lang/Exception;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 540
    iput-object p1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$15;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 5
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 544
    iget-object v3, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$15;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->deviceList:Ljava/util/List;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$1100(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Ljava/util/List;

    move-result-object v3

    if-eqz v3, :cond_1

    .line 545
    iget-object v3, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$15;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->deviceList:Ljava/util/List;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$1100(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/downloads/RegisteredDevice;

    .line 546
    .local v0, "device":Lcom/xfinity/playerlib/downloads/RegisteredDevice;
    iget-object v4, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$15;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # invokes: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->getPreferenceScreen()Landroid/preference/PreferenceScreen;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$1300(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Landroid/preference/PreferenceScreen;

    move-result-object v2

    .line 548
    .local v2, "preferenceScreen":Landroid/preference/PreferenceScreen;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/downloads/RegisteredDevice;->getDeviceId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/preference/PreferenceScreen;->findPreference(Ljava/lang/CharSequence;)Landroid/preference/Preference;

    move-result-object v1

    .line 549
    .local v1, "devicePreference":Landroid/preference/Preference;
    if-eqz v1, :cond_0

    .line 550
    invoke-virtual {v2, v1}, Landroid/preference/PreferenceScreen;->removePreference(Landroid/preference/Preference;)Z

    goto :goto_0

    .line 554
    .end local v0    # "device":Lcom/xfinity/playerlib/downloads/RegisteredDevice;
    .end local v1    # "devicePreference":Landroid/preference/Preference;
    .end local v2    # "preferenceScreen":Landroid/preference/PreferenceScreen;
    :cond_1
    iget-object v3, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$15;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # invokes: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->fetchDevices()V
    invoke-static {v3}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$2200(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)V

    .line 555
    return-void
.end method
