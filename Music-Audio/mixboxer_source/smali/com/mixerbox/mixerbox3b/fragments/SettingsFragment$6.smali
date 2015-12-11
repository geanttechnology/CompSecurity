.class Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$6;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;)V
    .locals 0

    .prologue
    .line 269
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$6;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 272
    if-eqz p2, :cond_1

    .line 273
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$6;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->shouldOpenConfirmDialog:Z

    if-eqz v0, :cond_0

    .line 275
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$6;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/AlertDialogFactory;->AskPostAlertDialog(Landroid/app/Activity;)Landroid/app/AlertDialog;

    move-result-object v0

    .line 276
    invoke-virtual {v0}, Landroid/app/Dialog;->show()V

    .line 289
    :goto_0
    return-void

    .line 279
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$6;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    iput-boolean v3, v0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->shouldOpenConfirmDialog:Z

    goto :goto_0

    .line 282
    :cond_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$6;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    iput-boolean v3, v0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->shouldOpenConfirmDialog:Z

    .line 283
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 284
    const-string v1, "on"

    const-string v2, "0"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 285
    const-string v1, "action:set_publish_activity"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 286
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$6;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putPostFB(Landroid/content/Context;Z)V

    .line 287
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$6;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0, v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putPlaySongCount(Landroid/content/Context;I)V

    goto :goto_0
.end method
