.class public Lco/vine/android/ConfirmationFlowActivity;
.super Lco/vine/android/BaseActionBarActivity;
.source "ConfirmationFlowActivity.java"


# static fields
.field public static final DIALOG_VERIFY_PHONE:I = 0x1

.field public static final EXTRA_FROM_SIGN_UP:Ljava/lang/String; = "from_sign_up"

.field public static final EXTRA_PHONE_NUMBER:Ljava/lang/String; = "phone_number"

.field public static final RESULT_VERIFY_PHONE_FAILURE:I = 0x5f8

.field public static final RESULT_VERIFY_PHONE_SUCCESS:I = 0x5f7

.field private static final TAG:Ljava/lang/String; = "confirmationFlow"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Lco/vine/android/BaseActionBarActivity;-><init>()V

    return-void
.end method

.method public static getIntent(Landroid/content/Context;Ljava/lang/String;Z)Landroid/content/Intent;
    .locals 2
    .param p0, "c"    # Landroid/content/Context;
    .param p1, "phone"    # Ljava/lang/String;
    .param p2, "fromSignup"    # Z

    .prologue
    .line 26
    new-instance v0, Landroid/content/Intent;

    const-class v1, Lco/vine/android/ConfirmationFlowActivity;

    invoke-direct {v0, p0, v1}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 27
    .local v0, "i":Landroid/content/Intent;
    const-string v1, "phone_number"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 28
    const-string v1, "from_sign_up"

    invoke-virtual {v0, v1, p2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 29
    return-object v0
.end method

.method public static requestPhoneVerification(Lco/vine/android/client/AppController;Ljava/lang/String;)V
    .locals 3
    .param p0, "appController"    # Lco/vine/android/client/AppController;
    .param p1, "phone"    # Ljava/lang/String;

    .prologue
    .line 36
    invoke-virtual {p0}, Lco/vine/android/client/AppController;->getActiveSession()Lco/vine/android/client/Session;

    move-result-object v0

    invoke-virtual {p0}, Lco/vine/android/client/AppController;->getActiveId()J

    move-result-wide v1

    invoke-virtual {p0, v0, p1, v1, v2}, Lco/vine/android/client/AppController;->requestPhoneVerification(Lco/vine/android/client/Session;Ljava/lang/String;J)Ljava/lang/String;

    .line 38
    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 9
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v8, 0x0

    const/4 v7, 0x1

    .line 42
    const v4, 0x7f030045

    invoke-super {p0, p1, v4, v7, v7}, Lco/vine/android/BaseActionBarActivity;->onCreate(Landroid/os/Bundle;IZZ)V

    .line 44
    invoke-virtual {p0}, Lco/vine/android/ConfirmationFlowActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    .line 45
    .local v3, "intent":Landroid/content/Intent;
    const-string v4, "from_sign_up"

    invoke-virtual {v3, v4, v8}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v2

    .line 47
    .local v2, "fromSignup":Z
    if-eqz v2, :cond_1

    .line 48
    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    const v6, 0x7f0e0124

    invoke-static {v8}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    invoke-virtual {p0, v4, v5, v6, v7}, Lco/vine/android/ConfirmationFlowActivity;->setupActionBar(Ljava/lang/Boolean;Ljava/lang/Boolean;ILjava/lang/Boolean;)V

    .line 53
    :goto_0
    if-nez p1, :cond_0

    .line 55
    if-eqz v2, :cond_2

    .line 56
    new-instance v1, Lco/vine/android/ConfirmationFlowVerificationFragment;

    invoke-direct {v1}, Lco/vine/android/ConfirmationFlowVerificationFragment;-><init>()V

    .line 60
    .local v1, "frag":Landroid/support/v4/app/Fragment;
    :goto_1
    invoke-static {v3}, Lco/vine/android/BaseFragment;->prepareArguments(Landroid/content/Intent;)Landroid/os/Bundle;

    move-result-object v0

    .line 61
    .local v0, "args":Landroid/os/Bundle;
    const-string v4, "phone_number"

    const-string v5, "phone_number"

    invoke-virtual {v3, v5}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 63
    invoke-virtual {v1, v0}, Landroid/support/v4/app/Fragment;->setArguments(Landroid/os/Bundle;)V

    .line 65
    invoke-virtual {p0}, Lco/vine/android/ConfirmationFlowActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v4

    invoke-virtual {v4}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v4

    const v5, 0x7f0a0102

    const-string v6, "confirmationFlow"

    invoke-virtual {v4, v5, v1, v6}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v4

    invoke-virtual {v4}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 70
    .end local v0    # "args":Landroid/os/Bundle;
    .end local v1    # "frag":Landroid/support/v4/app/Fragment;
    :cond_0
    return-void

    .line 50
    :cond_1
    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v5

    const v6, 0x7f0e008d

    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v7

    invoke-virtual {p0, v4, v5, v6, v7}, Lco/vine/android/ConfirmationFlowActivity;->setupActionBar(Ljava/lang/Boolean;Ljava/lang/Boolean;ILjava/lang/Boolean;)V

    goto :goto_0

    .line 58
    :cond_2
    new-instance v1, Lco/vine/android/ConfirmationFlowEntryFragment;

    invoke-direct {v1}, Lco/vine/android/ConfirmationFlowEntryFragment;-><init>()V

    .restart local v1    # "frag":Landroid/support/v4/app/Fragment;
    goto :goto_1
.end method
