.class Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$7;
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


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 260
    iput-object p1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$7;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPreferenceChange(Landroid/preference/Preference;Ljava/lang/Object;)Z
    .locals 6
    .param p1, "preference"    # Landroid/preference/Preference;
    .param p2, "newValue"    # Ljava/lang/Object;

    .prologue
    const/4 v5, 0x0

    .line 263
    move-object v1, p2

    check-cast v1, Ljava/lang/String;

    .local v1, "newValueString":Ljava/lang/String;
    move-object v2, p1

    .line 264
    check-cast v2, Landroid/preference/ListPreference;

    invoke-virtual {v2, v1}, Landroid/preference/ListPreference;->setValue(Ljava/lang/String;)V

    .line 265
    iget-object v2, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$7;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->context:Landroid/app/Activity;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$200(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$string;->settings_title_developer_configuration:I

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    aput-object v1, v4, v5

    invoke-virtual {v2, v3, v4}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Landroid/preference/Preference;->setTitle(Ljava/lang/CharSequence;)V

    .line 266
    iget-object v2, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$7;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->app:Lcom/xfinity/playerlib/PlayerApplication;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$500(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$string;->settings_developer_configuration_default:I

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/PlayerApplication;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 267
    iget-object v2, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$7;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$600(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->setDeveloperConfiguration(Lcom/xfinity/playerlib/config/PlayerConfiguration;)V

    .line 276
    :cond_0
    :goto_0
    return v5

    .line 269
    :cond_1
    iget-object v2, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$7;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->availableConfigurations:Ljava/util/List;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$700(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/config/PlayerConfiguration;

    .line 270
    .local v0, "config":Lcom/xfinity/playerlib/config/PlayerConfiguration;
    invoke-virtual {v0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 271
    iget-object v2, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$7;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$600(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->setDeveloperConfiguration(Lcom/xfinity/playerlib/config/PlayerConfiguration;)V

    goto :goto_0
.end method
