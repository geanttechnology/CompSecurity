.class Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12$2;
.super Ljava/lang/Object;
.source "PlayNowPreferenceDelegate.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;->onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;

    .prologue
    .line 423
    iput-object p1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12$2;->this$1:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 4
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 426
    iget-object v1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12$2;->this$1:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12$2;->this$1:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->context:Landroid/app/Activity;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$200(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Landroid/app/Activity;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$string;->settings_manage_devices_loading_key:I

    invoke-virtual {v2, v3}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v2

    # invokes: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->findPreference(Ljava/lang/String;)Landroid/preference/Preference;
    invoke-static {v1, v2}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$1600(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;Ljava/lang/String;)Landroid/preference/Preference;

    move-result-object v0

    .line 427
    .local v0, "loadingPreference":Landroid/preference/Preference;
    if-eqz v0, :cond_0

    .line 428
    iget-object v1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12$2;->this$1:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;

    iget-object v1, v1, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # invokes: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->getPreferenceScreen()Landroid/preference/PreferenceScreen;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$1300(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Landroid/preference/PreferenceScreen;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/preference/PreferenceScreen;->removePreference(Landroid/preference/Preference;)Z

    .line 430
    :cond_0
    return-void
.end method
