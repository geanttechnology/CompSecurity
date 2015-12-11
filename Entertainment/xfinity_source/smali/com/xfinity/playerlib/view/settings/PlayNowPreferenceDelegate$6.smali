.class Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$6;
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
    .line 219
    iput-object p1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$6;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$6;->val$settings:Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPreferenceChange(Landroid/preference/Preference;Ljava/lang/Object;)Z
    .locals 3
    .param p1, "preference"    # Landroid/preference/Preference;
    .param p2, "newValue"    # Ljava/lang/Object;

    .prologue
    .line 222
    move-object v0, p2

    check-cast v0, Ljava/lang/String;

    .local v0, "newValueString":Ljava/lang/String;
    move-object v1, p1

    .line 223
    check-cast v1, Landroid/preference/ListPreference;

    invoke-virtual {v1, v0}, Landroid/preference/ListPreference;->setValue(Ljava/lang/String;)V

    move-object v1, p1

    .line 224
    check-cast v1, Landroid/preference/ListPreference;

    invoke-virtual {v1}, Landroid/preference/ListPreference;->getEntry()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/preference/Preference;->setSummary(Ljava/lang/CharSequence;)V

    .line 225
    iget-object v1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$6;->val$settings:Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setWantsStaticBitrate(Z)V

    .line 226
    const/4 v1, 0x0

    return v1
.end method
