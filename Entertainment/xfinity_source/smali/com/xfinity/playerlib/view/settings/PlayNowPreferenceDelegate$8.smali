.class Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$8;
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
    .line 287
    iput-object p1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$8;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPreferenceChange(Landroid/preference/Preference;Ljava/lang/Object;)Z
    .locals 2
    .param p1, "preference"    # Landroid/preference/Preference;
    .param p2, "newValue"    # Ljava/lang/Object;

    .prologue
    .line 290
    move-object v0, p2

    check-cast v0, Ljava/lang/Boolean;

    .line 291
    .local v0, "isChecked":Ljava/lang/Boolean;
    check-cast p1, Landroid/preference/CheckBoxPreference;

    .end local p1    # "preference":Landroid/preference/Preference;
    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    invoke-virtual {p1, v1}, Landroid/preference/CheckBoxPreference;->setChecked(Z)V

    .line 292
    iget-object v1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$8;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$600(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->setDarkStreamsEnabled(Ljava/lang/Boolean;)V

    .line 293
    iget-object v1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$8;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$800(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->clearCachedResult()V

    .line 294
    const/4 v1, 0x0

    return v1
.end method
