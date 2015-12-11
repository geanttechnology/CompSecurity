.class Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$15;
.super Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 516
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$15;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-direct {p0, p2}, Lcom/mixerbox/mixerbox3b/classes/MixerBoxAsyncHttpResponseHandler;-><init>(Landroid/content/Context;)V

    return-void
.end method


# virtual methods
.method public onFailure(Ljava/lang/Throwable;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 557
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 558
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 559
    const-string v2, "islogin"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 560
    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 561
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$15;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-class v2, Lcom/mixerbox/mixerbox3b/LoginBridge;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 562
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$15;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v1, v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->startActivity(Landroid/content/Intent;)V

    .line 563
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$15;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 564
    return-void
.end method

.method public onSuccess(Ljava/lang/String;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 520
    if-eqz p1, :cond_2

    .line 521
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 522
    const-string v1, "sysinfo"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 523
    const-string v1, "sysinfo"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 524
    const-string v1, "showAd"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 525
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$15;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-string v2, "showAd"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    invoke-static {v1, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->putShouldShowAd(Landroid/content/Context;Z)V

    .line 527
    :cond_0
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 528
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 529
    const-string v2, "islogin"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 530
    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 531
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$15;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-class v2, Lcom/mixerbox/mixerbox3b/LoginBridge;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 532
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$15;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v1, v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->startActivity(Landroid/content/Intent;)V

    .line 533
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$15;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 553
    :cond_1
    :goto_0
    return-void

    .line 536
    :cond_2
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 537
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 538
    const-string v2, "islogin"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 539
    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 540
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$15;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-class v2, Lcom/mixerbox/mixerbox3b/LoginBridge;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 541
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$15;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v1, v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->startActivity(Landroid/content/Intent;)V

    .line 542
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$15;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 545
    :catch_0
    move-exception v0

    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 546
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 547
    const-string v2, "islogin"

    invoke-virtual {v1, v2, v4}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 548
    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 549
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$15;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v1}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const-class v2, Lcom/mixerbox/mixerbox3b/LoginBridge;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 550
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$15;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v1, v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->startActivity(Landroid/content/Intent;)V

    .line 551
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment$15;->this$0:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    goto :goto_0
.end method
