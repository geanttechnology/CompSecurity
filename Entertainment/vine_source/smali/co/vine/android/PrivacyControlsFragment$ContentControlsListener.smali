.class Lco/vine/android/PrivacyControlsFragment$ContentControlsListener;
.super Lco/vine/android/client/AppSessionListener;
.source "PrivacyControlsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/PrivacyControlsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ContentControlsListener"
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/PrivacyControlsFragment;


# direct methods
.method constructor <init>(Lco/vine/android/PrivacyControlsFragment;)V
    .locals 0

    .prologue
    .line 132
    iput-object p1, p0, Lco/vine/android/PrivacyControlsFragment$ContentControlsListener;->this$0:Lco/vine/android/PrivacyControlsFragment;

    invoke-direct {p0}, Lco/vine/android/client/AppSessionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onUpdateAcceptOonComplete(Ljava/lang/String;ILjava/lang/String;Z)V
    .locals 3
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "acceptOon"    # Z

    .prologue
    .line 136
    iget-object v2, p0, Lco/vine/android/PrivacyControlsFragment$ContentControlsListener;->this$0:Lco/vine/android/PrivacyControlsFragment;

    # getter for: Lco/vine/android/PrivacyControlsFragment;->mProgress:Landroid/app/ProgressDialog;
    invoke-static {v2}, Lco/vine/android/PrivacyControlsFragment;->access$000(Lco/vine/android/PrivacyControlsFragment;)Landroid/app/ProgressDialog;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 137
    iget-object v2, p0, Lco/vine/android/PrivacyControlsFragment$ContentControlsListener;->this$0:Lco/vine/android/PrivacyControlsFragment;

    # getter for: Lco/vine/android/PrivacyControlsFragment;->mProgress:Landroid/app/ProgressDialog;
    invoke-static {v2}, Lco/vine/android/PrivacyControlsFragment;->access$000(Lco/vine/android/PrivacyControlsFragment;)Landroid/app/ProgressDialog;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/ProgressDialog;->dismiss()V

    .line 139
    :cond_0
    iget-object v2, p0, Lco/vine/android/PrivacyControlsFragment$ContentControlsListener;->this$0:Lco/vine/android/PrivacyControlsFragment;

    invoke-virtual {v2}, Lco/vine/android/PrivacyControlsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 140
    .local v0, "activity":Landroid/app/Activity;
    const/16 v2, 0xc8

    if-ne p2, v2, :cond_1

    .line 141
    invoke-static {v0}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 142
    .local v1, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "accept_out_of_network_messages"

    invoke-interface {v1, v2, p4}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 143
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 151
    .end local v1    # "editor":Landroid/content/SharedPreferences$Editor;
    :goto_0
    return-void

    .line 145
    :cond_1
    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 146
    invoke-static {v0, p3}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    goto :goto_0

    .line 148
    :cond_2
    const v2, 0x7f0e0189

    invoke-static {v0, v2}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    goto :goto_0
.end method

.method public onUpdateDiscoverability(Ljava/lang/String;ILjava/lang/String;IZ)V
    .locals 4
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "type"    # I
    .param p5, "enable"    # Z

    .prologue
    .line 179
    iget-object v3, p0, Lco/vine/android/PrivacyControlsFragment$ContentControlsListener;->this$0:Lco/vine/android/PrivacyControlsFragment;

    # getter for: Lco/vine/android/PrivacyControlsFragment;->mProgress:Landroid/app/ProgressDialog;
    invoke-static {v3}, Lco/vine/android/PrivacyControlsFragment;->access$000(Lco/vine/android/PrivacyControlsFragment;)Landroid/app/ProgressDialog;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 180
    iget-object v3, p0, Lco/vine/android/PrivacyControlsFragment$ContentControlsListener;->this$0:Lco/vine/android/PrivacyControlsFragment;

    # getter for: Lco/vine/android/PrivacyControlsFragment;->mProgress:Landroid/app/ProgressDialog;
    invoke-static {v3}, Lco/vine/android/PrivacyControlsFragment;->access$000(Lco/vine/android/PrivacyControlsFragment;)Landroid/app/ProgressDialog;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/ProgressDialog;->dismiss()V

    .line 182
    :cond_0
    iget-object v3, p0, Lco/vine/android/PrivacyControlsFragment$ContentControlsListener;->this$0:Lco/vine/android/PrivacyControlsFragment;

    invoke-virtual {v3}, Lco/vine/android/PrivacyControlsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 183
    .local v0, "activity":Landroid/app/Activity;
    const/16 v3, 0xc8

    if-ne p2, v3, :cond_2

    .line 185
    if-nez p4, :cond_1

    .line 186
    const-string v2, "email_discoverable"

    .line 191
    .local v2, "pref":Ljava/lang/String;
    :goto_0
    iget-object v3, p0, Lco/vine/android/PrivacyControlsFragment$ContentControlsListener;->this$0:Lco/vine/android/PrivacyControlsFragment;

    invoke-virtual {v3}, Lco/vine/android/PrivacyControlsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v3

    invoke-static {v3}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v3

    invoke-interface {v3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 192
    .local v1, "editor":Landroid/content/SharedPreferences$Editor;
    invoke-interface {v1, v2, p5}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 193
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 201
    .end local v1    # "editor":Landroid/content/SharedPreferences$Editor;
    .end local v2    # "pref":Ljava/lang/String;
    :goto_1
    return-void

    .line 188
    :cond_1
    const-string v2, "phone_discoverable"

    .restart local v2    # "pref":Ljava/lang/String;
    goto :goto_0

    .line 195
    .end local v2    # "pref":Ljava/lang/String;
    :cond_2
    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_3

    .line 196
    invoke-static {v0, p3}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    goto :goto_1

    .line 198
    :cond_3
    const v3, 0x7f0e0189

    invoke-static {v0, v3}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    goto :goto_1
.end method

.method public onUpdateEnableAddressBookComplete(Ljava/lang/String;ILjava/lang/String;Z)V
    .locals 3
    .param p1, "reqId"    # Ljava/lang/String;
    .param p2, "statusCode"    # I
    .param p3, "reasonPhrase"    # Ljava/lang/String;
    .param p4, "enableAddressBook"    # Z

    .prologue
    .line 156
    iget-object v2, p0, Lco/vine/android/PrivacyControlsFragment$ContentControlsListener;->this$0:Lco/vine/android/PrivacyControlsFragment;

    # getter for: Lco/vine/android/PrivacyControlsFragment;->mProgress:Landroid/app/ProgressDialog;
    invoke-static {v2}, Lco/vine/android/PrivacyControlsFragment;->access$000(Lco/vine/android/PrivacyControlsFragment;)Landroid/app/ProgressDialog;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 157
    iget-object v2, p0, Lco/vine/android/PrivacyControlsFragment$ContentControlsListener;->this$0:Lco/vine/android/PrivacyControlsFragment;

    # getter for: Lco/vine/android/PrivacyControlsFragment;->mProgress:Landroid/app/ProgressDialog;
    invoke-static {v2}, Lco/vine/android/PrivacyControlsFragment;->access$000(Lco/vine/android/PrivacyControlsFragment;)Landroid/app/ProgressDialog;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/ProgressDialog;->dismiss()V

    .line 159
    :cond_0
    iget-object v2, p0, Lco/vine/android/PrivacyControlsFragment$ContentControlsListener;->this$0:Lco/vine/android/PrivacyControlsFragment;

    invoke-virtual {v2}, Lco/vine/android/PrivacyControlsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    .line 160
    .local v0, "activity":Landroid/app/Activity;
    const/16 v2, 0xc8

    if-ne p2, v2, :cond_2

    .line 161
    iget-object v2, p0, Lco/vine/android/PrivacyControlsFragment$ContentControlsListener;->this$0:Lco/vine/android/PrivacyControlsFragment;

    invoke-virtual {v2}, Lco/vine/android/PrivacyControlsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Lco/vine/android/util/Util;->getDefaultSharedPrefs(Landroid/content/Context;)Landroid/content/SharedPreferences;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 162
    .local v1, "editor":Landroid/content/SharedPreferences$Editor;
    const-string v2, "enable_address_book"

    invoke-interface {v1, v2, p4}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    .line 163
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->apply()V

    .line 164
    if-eqz p4, :cond_1

    .line 165
    iget-object v2, p0, Lco/vine/android/PrivacyControlsFragment$ContentControlsListener;->this$0:Lco/vine/android/PrivacyControlsFragment;

    iget-object v2, v2, Lco/vine/android/PrivacyControlsFragment;->mAppController:Lco/vine/android/client/AppController;

    invoke-virtual {v2}, Lco/vine/android/client/AppController;->sendAddressBook()Ljava/lang/String;

    .line 174
    .end local v1    # "editor":Landroid/content/SharedPreferences$Editor;
    :cond_1
    :goto_0
    return-void

    .line 168
    :cond_2
    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 169
    invoke-static {v0, p3}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;Ljava/lang/String;)Landroid/widget/Toast;

    goto :goto_0

    .line 171
    :cond_3
    const v2, 0x7f0e0189

    invoke-static {v0, v2}, Lco/vine/android/util/Util;->showCenteredToast(Landroid/content/Context;I)V

    goto :goto_0
.end method
