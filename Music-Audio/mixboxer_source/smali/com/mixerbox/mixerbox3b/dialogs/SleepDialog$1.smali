.class Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;

.field final synthetic val$etName:Landroid/widget/EditText;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;Landroid/widget/EditText;)V
    .locals 0

    .prologue
    .line 44
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;

    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog$1;->val$etName:Landroid/widget/EditText;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 7

    .prologue
    const v4, 0x7f0800f4

    const/16 v0, 0x5a0

    const/16 v5, 0xc

    const/4 v3, 0x1

    const/4 v6, 0x0

    .line 47
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog$1;->val$etName:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog$1;->val$etName:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-nez v1, :cond_1

    .line 48
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;)Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 49
    new-instance v0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;)Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;-><init>(Landroid/content/Context;)V

    .line 50
    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->show()Landroid/app/AlertDialog;

    .line 84
    :goto_0
    return-void

    .line 53
    :cond_1
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog$1;->val$etName:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    const/4 v2, 0x4

    if-le v1, v2, :cond_2

    .line 54
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog$1;->val$etName:Landroid/widget/EditText;

    const-string v2, "1440"

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 57
    :cond_2
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog$1;->val$etName:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(Ljava/lang/String;)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    .line 58
    if-gtz v1, :cond_3

    .line 59
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;)Landroid/content/Context;

    move-result-object v0

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v3}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 60
    new-instance v0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->ctx:Landroid/content/Context;
    invoke-static {v1}, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;)Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;-><init>(Landroid/content/Context;)V

    .line 61
    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->show()Landroid/app/AlertDialog;

    goto :goto_0

    .line 65
    :cond_3
    if-le v1, v0, :cond_4

    move v1, v0

    .line 67
    :cond_4
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;)Landroid/content/Context;

    move-result-object v0

    const-string v2, "alarm"

    invoke-virtual {v0, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AlarmManager;

    .line 68
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v2

    .line 69
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    invoke-virtual {v2, v3, v4}, Ljava/util/Calendar;->setTimeInMillis(J)V

    .line 70
    invoke-virtual {v2, v5}, Ljava/util/Calendar;->get(I)I

    move-result v3

    add-int/2addr v3, v1

    invoke-virtual {v2, v5, v3}, Ljava/util/Calendar;->set(II)V

    .line 71
    new-instance v3, Landroid/content/Intent;

    const-string v4, "SleepService"

    invoke-direct {v3, v4}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 72
    const-string v4, "t"

    invoke-virtual {v3, v4, v6}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 73
    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->ctx:Landroid/content/Context;
    invoke-static {v4}, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;)Landroid/content/Context;

    move-result-object v4

    invoke-static {v4, v6, v3, v6}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v3

    .line 74
    invoke-virtual {v2}, Ljava/util/Calendar;->getTimeInMillis()J

    move-result-wide v4

    invoke-virtual {v0, v6, v4, v5, v3}, Landroid/app/AlarmManager;->set(IJLandroid/app/PendingIntent;)V

    .line 76
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;)Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentSettings:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->btnSleep:Landroid/widget/Button;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->ctx:Landroid/content/Context;
    invoke-static {v3}, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;)Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0800f0

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ":  "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->ctx:Landroid/content/Context;
    invoke-static {v3}, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;)Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f08007d

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 77
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->ctx:Landroid/content/Context;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;)Landroid/content/Context;

    move-result-object v0

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->ctx:Landroid/content/Context;
    invoke-static {v3}, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;)Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0800f1

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog$1;->this$0:Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;

    # getter for: Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->ctx:Landroid/content/Context;
    invoke-static {v2}, Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;->access$000(Lcom/mixerbox/mixerbox3b/dialogs/SleepDialog;)Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0800f2

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v6}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 79
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 80
    const-string v1, "val"

    const-string v2, "on"

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 81
    const-string v1, "action:set_sleep_timer"

    invoke-static {v1, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    goto/16 :goto_0
.end method
