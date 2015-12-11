.class Lco/vine/android/SettingsFragment$SettingsListener;
.super Lco/vine/android/client/AppSessionListener;
.source "SettingsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/SettingsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "SettingsListener"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/SettingsFragment;


# direct methods
.method constructor <init>(Lco/vine/android/SettingsFragment;)V
    .locals 0

    .prologue
    .line 730
    iput-object p1, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    invoke-direct {p0}, Lco/vine/android/client/AppSessionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onClearCacheComplete(Ljava/lang/String;ILjava/lang/String;)V
    .locals 5
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;

    .prologue
    .line 831
    iget-object v1, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;
    invoke-static {v1}, Lco/vine/android/SettingsFragment;->access$1600(Lco/vine/android/SettingsFragment;)Landroid/app/ProgressDialog;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 832
    iget-object v1, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;
    invoke-static {v1}, Lco/vine/android/SettingsFragment;->access$1600(Lco/vine/android/SettingsFragment;)Landroid/app/ProgressDialog;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/ProgressDialog;->dismiss()V

    .line 835
    :cond_0
    :try_start_0
    iget-object v1, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mClearCacheValue:Landroid/widget/TextView;
    invoke-static {v1}, Lco/vine/android/SettingsFragment;->access$000(Lco/vine/android/SettingsFragment;)Landroid/widget/TextView;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    invoke-virtual {v2}, Lco/vine/android/SettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    invoke-virtual {v3}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-static {v3}, Lco/vine/android/util/Util;->getCacheSize(Landroid/content/Context;)J

    move-result-wide v3

    invoke-static {v2, v3, v4}, Lco/vine/android/util/Util;->formatFileSize(Landroid/content/res/Resources;J)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_0
    .catch Lco/vine/android/VineLoggingException; {:try_start_0 .. :try_end_0} :catch_0

    .line 840
    :goto_0
    iget-object v1, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    invoke-virtual {v1}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/support/v4/app/FragmentActivity;->setResult(I)V

    .line 841
    return-void

    .line 837
    :catch_0
    move-exception v0

    .line 838
    .local v0, "e":Lco/vine/android/VineLoggingException;
    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public onConnectFacebookComplete(Ljava/lang/String;ILjava/lang/String;)V
    .locals 2
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;

    .prologue
    .line 743
    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;
    invoke-static {v0}, Lco/vine/android/SettingsFragment;->access$1600(Lco/vine/android/SettingsFragment;)Landroid/app/ProgressDialog;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 744
    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;
    invoke-static {v0}, Lco/vine/android/SettingsFragment;->access$1600(Lco/vine/android/SettingsFragment;)Landroid/app/ProgressDialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 746
    :cond_0
    const/16 v0, 0xc8

    if-eq p2, v0, :cond_1

    .line 747
    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    invoke-virtual {v0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const v1, 0x7f0e00ca

    invoke-static {v0, v1}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    .line 749
    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mFacebookValue:Landroid/widget/TextView;
    invoke-static {v0}, Lco/vine/android/SettingsFragment;->access$1700(Lco/vine/android/SettingsFragment;)Landroid/widget/TextView;

    move-result-object v0

    const v1, 0x7f0e01f1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 753
    :goto_0
    return-void

    .line 751
    :cond_1
    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # invokes: Lco/vine/android/SettingsFragment;->invalidateFacebookSessionUI()V
    invoke-static {v0}, Lco/vine/android/SettingsFragment;->access$1800(Lco/vine/android/SettingsFragment;)V

    goto :goto_0
.end method

.method public onConnectTwitterComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V
    .locals 10
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "username"    # Ljava/lang/String;
    .param p5, "token"    # Ljava/lang/String;
    .param p6, "secret"    # Ljava/lang/String;
    .param p7, "userId"    # J

    .prologue
    .line 847
    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;
    invoke-static {v0}, Lco/vine/android/SettingsFragment;->access$1600(Lco/vine/android/SettingsFragment;)Landroid/app/ProgressDialog;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 848
    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;
    invoke-static {v0}, Lco/vine/android/SettingsFragment;->access$1600(Lco/vine/android/SettingsFragment;)Landroid/app/ProgressDialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 850
    :cond_0
    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    invoke-virtual {v0}, Lco/vine/android/SettingsFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0a0204

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/TextView;

    .line 852
    .local v9, "valueTextView":Landroid/widget/TextView;
    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    invoke-virtual {v0}, Lco/vine/android/SettingsFragment;->getView()Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0a0203

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/TextView;

    .line 854
    .local v8, "label":Landroid/widget/TextView;
    const/16 v0, 0xc8

    if-ne p2, v0, :cond_1

    const-wide/16 v0, 0x0

    cmp-long v0, p7, v0

    if-lez v0, :cond_1

    invoke-static {p5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    invoke-static/range {p6 .. p6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 856
    const v0, 0x7f0e01db

    invoke-virtual {v8, v0}, Landroid/widget/TextView;->setText(I)V

    .line 857
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const/16 v1, 0x40

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v9, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 858
    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    invoke-virtual {v0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    iget-object v1, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;
    invoke-static {v1}, Lco/vine/android/SettingsFragment;->access$2200(Lco/vine/android/SettingsFragment;)Lco/vine/android/client/AppController;

    move-result-object v1

    invoke-virtual {v1}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v1

    invoke-virtual {v1}, Lco/vine/android/client/Session;->getLoginEmail()Ljava/lang/String;

    move-result-object v1

    move-object v2, p4

    move-object v3, p5

    move-object/from16 v4, p6

    move-wide/from16 v5, p7

    invoke-static/range {v0 .. v6}, Lco/vine/android/client/VineAccountHelper;->saveTwitterInfo(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;J)V

    .line 861
    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    const/4 v1, 0x1

    # setter for: Lco/vine/android/SettingsFragment;->mTwitterLogin:Z
    invoke-static {v0, v1}, Lco/vine/android/SettingsFragment;->access$2302(Lco/vine/android/SettingsFragment;Z)Z

    .line 862
    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mPrefs:Landroid/content/SharedPreferences;
    invoke-static {v0}, Lco/vine/android/SettingsFragment;->access$2400(Lco/vine/android/SettingsFragment;)Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v7

    .line 863
    .local v7, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v0, "settings_twitter_connected"

    const/4 v1, 0x1

    invoke-interface {v7, v0, v1}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 864
    invoke-interface {v7}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 875
    .end local v7    # "editor":Landroid/content/SharedPreferences$Editor;
    :goto_0
    return-void

    .line 866
    :cond_1
    const v0, 0x7f0e01d8

    invoke-virtual {v8, v0}, Landroid/widget/TextView;->setText(I)V

    .line 867
    const v0, 0x7f0e01d9

    invoke-virtual {v9, v0}, Landroid/widget/TextView;->setText(I)V

    .line 868
    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    const/4 v1, 0x0

    # setter for: Lco/vine/android/SettingsFragment;->mTwitterLogin:Z
    invoke-static {v0, v1}, Lco/vine/android/SettingsFragment;->access$2302(Lco/vine/android/SettingsFragment;Z)Z

    .line 869
    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 870
    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    invoke-virtual {v0}, Lco/vine/android/SettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0e01e9

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object p3

    .line 873
    :cond_2
    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    invoke-virtual {v0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0, p3}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    goto :goto_0
.end method

.method public onDeactivateAccountComplete(Ljava/lang/String;ILjava/lang/String;Z)V
    .locals 3
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "success"    # Z

    .prologue
    .line 917
    iget-object v1, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;
    invoke-static {v1}, Lco/vine/android/SettingsFragment;->access$1600(Lco/vine/android/SettingsFragment;)Landroid/app/ProgressDialog;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 918
    iget-object v1, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;
    invoke-static {v1}, Lco/vine/android/SettingsFragment;->access$1600(Lco/vine/android/SettingsFragment;)Landroid/app/ProgressDialog;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/ProgressDialog;->dismiss()V

    .line 922
    :cond_0
    if-eqz p4, :cond_1

    .line 923
    iget-object v1, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;
    invoke-static {v1}, Lco/vine/android/SettingsFragment;->access$2200(Lco/vine/android/SettingsFragment;)Lco/vine/android/client/AppController;

    move-result-object v1

    iget-object v2, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;
    invoke-static {v2}, Lco/vine/android/SettingsFragment;->access$2200(Lco/vine/android/SettingsFragment;)Lco/vine/android/client/AppController;

    move-result-object v2

    invoke-virtual {v2}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v2

    invoke-virtual {v1, v2}, Lco/vine/android/client/AppController;->logout(Lco/vine/android/client/Session;)Ljava/lang/String;

    .line 924
    const v0, 0x7f0e01cc

    .line 925
    .local v0, "messageId":I
    const-string v1, "User account successfully deactivated"

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    .line 930
    :goto_0
    iget-object v1, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    invoke-virtual {v1}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    invoke-static {v1, v0}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    .line 931
    return-void

    .line 927
    .end local v0    # "messageId":I
    :cond_1
    const v0, 0x7f0e01cb

    .line 928
    .restart local v0    # "messageId":I
    const-string v1, "User account deactivation failed"

    invoke-static {v1}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onDisconnectTwitterComplete(Ljava/lang/String;ILjava/lang/String;)V
    .locals 5
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x0

    .line 879
    iget-object v2, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;
    invoke-static {v2}, Lco/vine/android/SettingsFragment;->access$1600(Lco/vine/android/SettingsFragment;)Landroid/app/ProgressDialog;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 880
    iget-object v2, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;
    invoke-static {v2}, Lco/vine/android/SettingsFragment;->access$1600(Lco/vine/android/SettingsFragment;)Landroid/app/ProgressDialog;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/ProgressDialog;->dismiss()V

    .line 882
    :cond_0
    iget-object v2, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    invoke-virtual {v2}, Lco/vine/android/SettingsFragment;->getView()Landroid/view/View;

    move-result-object v2

    const v3, 0x7f0a0204

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 884
    .local v1, "valueTextView":Landroid/widget/TextView;
    iget-object v2, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    invoke-virtual {v2}, Lco/vine/android/SettingsFragment;->getView()Landroid/view/View;

    move-result-object v2

    const v3, 0x7f0a0203

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 886
    .local v0, "label":Landroid/widget/TextView;
    const/16 v2, 0xc8

    if-ne p2, v2, :cond_1

    .line 887
    const v2, 0x7f0e01d8

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(I)V

    .line 888
    const v2, 0x7f0e01d9

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(I)V

    .line 889
    iget-object v2, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    invoke-virtual {v2}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mAppController:Lco/vine/android/client/AppController;
    invoke-static {v3}, Lco/vine/android/SettingsFragment;->access$2200(Lco/vine/android/SettingsFragment;)Lco/vine/android/client/AppController;

    move-result-object v3

    invoke-virtual {v3}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v3

    invoke-virtual {v3}, Lco/vine/android/client/Session;->getLoginEmail()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lco/vine/android/client/VineAccountHelper;->removeTwitterInfo(Landroid/content/Context;Ljava/lang/String;)V

    .line 891
    iget-object v2, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # setter for: Lco/vine/android/SettingsFragment;->mTwitterLogin:Z
    invoke-static {v2, v4}, Lco/vine/android/SettingsFragment;->access$2302(Lco/vine/android/SettingsFragment;Z)Z

    .line 892
    iget-object v2, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mEditor:Landroid/content/SharedPreferences$Editor;
    invoke-static {v2}, Lco/vine/android/SettingsFragment;->access$1900(Lco/vine/android/SettingsFragment;)Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    const-string v3, "settings_twitter_connected"

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 893
    iget-object v2, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mEditor:Landroid/content/SharedPreferences$Editor;
    invoke-static {v2}, Lco/vine/android/SettingsFragment;->access$1900(Lco/vine/android/SettingsFragment;)Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 901
    :goto_0
    return-void

    .line 895
    :cond_1
    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 896
    iget-object v2, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    invoke-virtual {v2}, Lco/vine/android/SettingsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0e01ea

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object p3

    .line 899
    :cond_2
    iget-object v2, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    invoke-virtual {v2}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2, p3}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    goto :goto_0
.end method

.method public onGetEditionsComplete(ILjava/util/ArrayList;)V
    .locals 2
    .param p1, "statusCode"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Ljava/util/ArrayList",
            "<",
            "Landroid/util/Pair",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 945
    .local p2, "editions":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Landroid/util/Pair<Ljava/lang/String;Ljava/lang/String;>;>;"
    const/16 v0, 0xc8

    if-ne p1, v0, :cond_0

    .line 946
    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    const/4 v1, 0x1

    # setter for: Lco/vine/android/SettingsFragment;->mEditionsFetched:Z
    invoke-static {v0, v1}, Lco/vine/android/SettingsFragment;->access$2602(Lco/vine/android/SettingsFragment;Z)Z

    .line 948
    :cond_0
    return-void
.end method

.method public onGetUsersMeComplete(Ljava/lang/String;ILjava/lang/String;JLco/vine/android/api/VineUser;)V
    .locals 2
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "sessionOwnerId"    # J
    .param p6, "meUser"    # Lco/vine/android/api/VineUser;

    .prologue
    .line 936
    if-eqz p6, :cond_0

    .line 937
    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    invoke-virtual {p6}, Lco/vine/android/api/VineUser;->isEmailVerified()Z

    move-result v1

    # setter for: Lco/vine/android/SettingsFragment;->mIsEmailVerified:Z
    invoke-static {v0, v1}, Lco/vine/android/SettingsFragment;->access$702(Lco/vine/android/SettingsFragment;Z)Z

    .line 938
    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    invoke-virtual {p6}, Lco/vine/android/api/VineUser;->isPhoneVerified()Z

    move-result v1

    # setter for: Lco/vine/android/SettingsFragment;->mIsPhoneVerified:Z
    invoke-static {v0, v1}, Lco/vine/android/SettingsFragment;->access$1002(Lco/vine/android/SettingsFragment;Z)Z

    .line 939
    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # invokes: Lco/vine/android/SettingsFragment;->updateVerificationIcons()V
    invoke-static {v0}, Lco/vine/android/SettingsFragment;->access$2500(Lco/vine/android/SettingsFragment;)V

    .line 941
    :cond_0
    return-void
.end method

.method public onLogoutComplete(Ljava/lang/String;)V
    .locals 1
    .param p1, "reqId"    # Ljava/lang/String;

    .prologue
    .line 905
    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    invoke-virtual {v0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    invoke-virtual {v0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->isFinishing()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 912
    :cond_0
    :goto_0
    return-void

    .line 908
    :cond_1
    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;
    invoke-static {v0}, Lco/vine/android/SettingsFragment;->access$1600(Lco/vine/android/SettingsFragment;)Landroid/app/ProgressDialog;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 909
    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;
    invoke-static {v0}, Lco/vine/android/SettingsFragment;->access$1600(Lco/vine/android/SettingsFragment;)Landroid/app/ProgressDialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 911
    :cond_2
    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    invoke-virtual {v0}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-static {v0}, Lco/vine/android/StartActivity;->toStart(Landroid/content/Context;)V

    goto :goto_0
.end method

.method public onPhotoImageLoaded(Ljava/util/HashMap;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Lco/vine/android/util/image/ImageKey;",
            "Lco/vine/android/util/image/UrlImage;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 734
    .local p1, "images":Ljava/util/HashMap;, "Ljava/util/HashMap<Lco/vine/android/util/image/ImageKey;Lco/vine/android/util/image/UrlImage;>;"
    iget-object v1, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mAvatarKey:Lco/vine/android/util/image/ImageKey;
    invoke-static {v1}, Lco/vine/android/SettingsFragment;->access$1400(Lco/vine/android/SettingsFragment;)Lco/vine/android/util/image/ImageKey;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/util/image/UrlImage;

    .line 735
    .local v0, "urlImage":Lco/vine/android/util/image/UrlImage;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lco/vine/android/util/image/UrlImage;->isValid()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 736
    iget-object v1, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mAvatarImageView:Landroid/widget/ImageView;
    invoke-static {v1}, Lco/vine/android/SettingsFragment;->access$1500(Lco/vine/android/SettingsFragment;)Landroid/widget/ImageView;

    move-result-object v1

    new-instance v2, Lco/vine/android/drawable/RecyclableBitmapDrawable;

    iget-object v3, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mAvatarImageView:Landroid/widget/ImageView;
    invoke-static {v3}, Lco/vine/android/SettingsFragment;->access$1500(Lco/vine/android/SettingsFragment;)Landroid/widget/ImageView;

    move-result-object v3

    invoke-virtual {v3}, Landroid/widget/ImageView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    iget-object v4, v0, Lco/vine/android/util/image/UrlImage;->bitmap:Landroid/graphics/Bitmap;

    invoke-direct {v2, v3, v4}, Lco/vine/android/drawable/RecyclableBitmapDrawable;-><init>(Landroid/content/res/Resources;Landroid/graphics/Bitmap;)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 739
    :cond_0
    return-void
.end method

.method public onRequestEmailVerificationComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "email"    # Ljava/lang/String;

    .prologue
    .line 953
    const/16 v2, 0xc8

    if-ne p2, v2, :cond_0

    .line 954
    const/16 v2, 0xa

    invoke-static {v2}, Lco/vine/android/widgets/PromptDialogSupportFragment;->newInstance(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v0

    .line 956
    .local v0, "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    iget-object v2, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setTargetFragment(Landroid/support/v4/app/Fragment;I)V

    .line 957
    const v2, 0x104000a

    invoke-virtual {v0, v2}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setNeutralButton(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v2

    const v3, 0x7f0e0082

    invoke-virtual {v2, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->setMessage(I)Lco/vine/android/widgets/PromptDialogSupportFragment;

    move-result-object v2

    iget-object v3, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    invoke-virtual {v3}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v3

    invoke-virtual {v2, v3}, Lco/vine/android/widgets/PromptDialogSupportFragment;->show(Landroid/support/v4/app/FragmentManager;)V

    .line 965
    .end local v0    # "p":Lco/vine/android/widgets/PromptDialogSupportFragment;
    :goto_0
    return-void

    .line 961
    :cond_0
    if-eqz p3, :cond_1

    move-object v1, p3

    .line 963
    .local v1, "reason":Ljava/lang/String;
    :goto_1
    iget-object v2, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    invoke-virtual {v2}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2, v1}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    goto :goto_0

    .line 961
    .end local v1    # "reason":Ljava/lang/String;
    :cond_1
    iget-object v2, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    const v3, 0x7f0e0105

    invoke-virtual {v2, v3}, Lco/vine/android/SettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    goto :goto_1
.end method

.method public onUpdateEditionComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "edition"    # Ljava/lang/String;

    .prologue
    .line 799
    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;
    invoke-static {v0}, Lco/vine/android/SettingsFragment;->access$1600(Lco/vine/android/SettingsFragment;)Landroid/app/ProgressDialog;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 800
    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;
    invoke-static {v0}, Lco/vine/android/SettingsFragment;->access$1600(Lco/vine/android/SettingsFragment;)Landroid/app/ProgressDialog;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 802
    :cond_0
    const/16 v0, 0xc8

    if-ne p2, v0, :cond_1

    .line 803
    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # setter for: Lco/vine/android/SettingsFragment;->mEdition:Ljava/lang/String;
    invoke-static {v0, p4}, Lco/vine/android/SettingsFragment;->access$1202(Lco/vine/android/SettingsFragment;Ljava/lang/String;)Ljava/lang/String;

    .line 804
    iget-object v0, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # setter for: Lco/vine/android/SettingsFragment;->mOriginalEdition:Ljava/lang/String;
    invoke-static {v0, p4}, Lco/vine/android/SettingsFragment;->access$2102(Lco/vine/android/SettingsFragment;Ljava/lang/String;)Ljava/lang/String;

    .line 806
    :cond_1
    return-void
.end method

.method public onUpdateProfileComplete(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "avatarUrl"    # Ljava/lang/String;

    .prologue
    .line 758
    iget-object v2, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;
    invoke-static {v2}, Lco/vine/android/SettingsFragment;->access$1600(Lco/vine/android/SettingsFragment;)Landroid/app/ProgressDialog;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 759
    iget-object v2, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mProgress:Landroid/app/ProgressDialog;
    invoke-static {v2}, Lco/vine/android/SettingsFragment;->access$1600(Lco/vine/android/SettingsFragment;)Landroid/app/ProgressDialog;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/ProgressDialog;->dismiss()V

    .line 761
    :cond_0
    iget-object v2, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    invoke-virtual {v2}, Lco/vine/android/SettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 762
    .local v0, "activity":Landroid/support/v4/app/FragmentActivity;
    const/16 v2, 0xc8

    if-ne p2, v2, :cond_5

    .line 763
    iget-object v2, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mEditor:Landroid/content/SharedPreferences$Editor;
    invoke-static {v2}, Lco/vine/android/SettingsFragment;->access$1900(Lco/vine/android/SettingsFragment;)Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 764
    .local v1, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-static {p4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 765
    iget-object v2, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mEditor:Landroid/content/SharedPreferences$Editor;
    invoke-static {v2}, Lco/vine/android/SettingsFragment;->access$1900(Lco/vine/android/SettingsFragment;)Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    const-string v3, "settings_profile_avatar_url"

    invoke-interface {v2, v3, p4}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 767
    :cond_1
    const-string v2, "settings_profile_name"

    iget-object v3, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mName:Ljava/lang/String;
    invoke-static {v3}, Lco/vine/android/SettingsFragment;->access$100(Lco/vine/android/SettingsFragment;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 768
    const-string v2, "settings_profile_description"

    iget-object v3, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mDescription:Ljava/lang/String;
    invoke-static {v3}, Lco/vine/android/SettingsFragment;->access$200(Lco/vine/android/SettingsFragment;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 769
    const-string v2, "settings_profile_location"

    iget-object v3, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mLocation:Ljava/lang/String;
    invoke-static {v3}, Lco/vine/android/SettingsFragment;->access$300(Lco/vine/android/SettingsFragment;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 770
    const-string v2, "settings_profile_email"

    iget-object v3, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mEmail:Ljava/lang/String;
    invoke-static {v3}, Lco/vine/android/SettingsFragment;->access$400(Lco/vine/android/SettingsFragment;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 771
    const-string v2, "settings_profile_phone"

    iget-object v3, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mPhone:Ljava/lang/String;
    invoke-static {v3}, Lco/vine/android/SettingsFragment;->access$900(Lco/vine/android/SettingsFragment;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 773
    iget-object v2, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mColorIndex:I
    invoke-static {v2}, Lco/vine/android/SettingsFragment;->access$2000(Lco/vine/android/SettingsFragment;)I

    move-result v2

    if-ltz v2, :cond_2

    iget-object v2, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mColorIndex:I
    invoke-static {v2}, Lco/vine/android/SettingsFragment;->access$2000(Lco/vine/android/SettingsFragment;)I

    move-result v2

    sget-object v3, Lco/vine/android/Settings;->PROFILE_BACKGROUND_COLORS:[I

    array-length v3, v3

    if-lt v2, v3, :cond_3

    .line 774
    :cond_2
    iget-object v2, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    const/4 v3, 0x0

    # setter for: Lco/vine/android/SettingsFragment;->mColorIndex:I
    invoke-static {v2, v3}, Lco/vine/android/SettingsFragment;->access$2002(Lco/vine/android/SettingsFragment;I)I

    .line 777
    :cond_3
    const-string v2, "profile_background"

    sget-object v3, Lco/vine/android/Settings;->PROFILE_BACKGROUND_COLORS:[I

    iget-object v4, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mColorIndex:I
    invoke-static {v4}, Lco/vine/android/SettingsFragment;->access$2000(Lco/vine/android/SettingsFragment;)I

    move-result v4

    aget v3, v3, v4

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 779
    const-string v2, "color_index"

    iget-object v3, p0, Lco/vine/android/SettingsFragment$SettingsListener;->this$0:Lco/vine/android/SettingsFragment;

    # getter for: Lco/vine/android/SettingsFragment;->mColorIndex:I
    invoke-static {v3}, Lco/vine/android/SettingsFragment;->access$2000(Lco/vine/android/SettingsFragment;)I

    move-result v3

    invoke-interface {v1, v2, v3}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 781
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 782
    if-eqz v0, :cond_4

    .line 783
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->finish()V

    .line 786
    :cond_4
    invoke-static {v0}, Lco/vine/android/util/Util;->changeProfileColor(Landroid/app/Activity;)V

    .line 795
    .end local v1    # "editor":Landroid/content/SharedPreferences$Editor;
    :goto_0
    return-void

    .line 789
    :cond_5
    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 790
    const v2, 0x7f0e0258

    invoke-static {v0, v2}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    goto :goto_0

    .line 792
    :cond_6
    invoke-static {v0, p3}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    goto :goto_0
.end method
