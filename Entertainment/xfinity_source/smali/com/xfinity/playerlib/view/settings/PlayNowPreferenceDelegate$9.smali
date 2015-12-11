.class Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$9;
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

.field final synthetic val$darkStreams:Landroid/preference/CheckBoxPreference;

.field final synthetic val$devConfiguration:Landroid/preference/ListPreference;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;Landroid/preference/ListPreference;Landroid/preference/CheckBoxPreference;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 302
    iput-object p1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$9;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$9;->val$devConfiguration:Landroid/preference/ListPreference;

    iput-object p3, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$9;->val$darkStreams:Landroid/preference/CheckBoxPreference;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPreferenceChange(Landroid/preference/Preference;Ljava/lang/Object;)Z
    .locals 3
    .param p1, "preference"    # Landroid/preference/Preference;
    .param p2, "newValue"    # Ljava/lang/Object;

    .prologue
    .line 305
    move-object v0, p2

    check-cast v0, Ljava/lang/Boolean;

    .line 306
    .local v0, "isChecked":Ljava/lang/Boolean;
    check-cast p1, Landroid/preference/CheckBoxPreference;

    .end local p1    # "preference":Landroid/preference/Preference;
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    invoke-virtual {p1, v1}, Landroid/preference/CheckBoxPreference;->setChecked(Z)V

    .line 307
    iget-object v1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$9;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$600(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v1

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->setDeveloperModeEnabled(Z)V

    .line 308
    iget-object v1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$9;->val$devConfiguration:Landroid/preference/ListPreference;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$9;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$600(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->isDeveloperModeEnabled()Z

    move-result v2

    invoke-virtual {v1, v2}, Landroid/preference/ListPreference;->setEnabled(Z)V

    .line 309
    iget-object v1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$9;->val$darkStreams:Landroid/preference/CheckBoxPreference;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$9;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$600(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->isDeveloperModeEnabled()Z

    move-result v2

    invoke-virtual {v1, v2}, Landroid/preference/CheckBoxPreference;->setEnabled(Z)V

    .line 310
    const/4 v1, 0x0

    return v1
.end method
