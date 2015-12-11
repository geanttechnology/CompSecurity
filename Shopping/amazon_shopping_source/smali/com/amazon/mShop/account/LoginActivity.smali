.class public Lcom/amazon/mShop/account/LoginActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "LoginActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Landroid/view/View$OnKeyListener;
.implements Lcom/amazon/mShop/control/account/SignInSubscriber;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/account/LoginActivity$LogInTextWatcher;
    }
.end annotation


# instance fields
.field private changeEmailPreference:Landroid/widget/TextView;

.field private createNewButton:Landroid/widget/Button;

.field emailTextWatcher:Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;

.field private hasPostHidePasswordRefMarker:Z

.field private hasPostShowPasswordRefMarker:Z

.field private loginButton:Landroid/widget/Button;

.field private loginEmailEditText:Landroid/widget/EditText;

.field private loginForgotYourPassword:Landroid/widget/TextView;

.field private loginHideMenu:Z

.field private loginLegalInformationLink:Landroid/widget/TextView;

.field private loginPasswordEditText:Landroid/widget/EditText;

.field private mAccountPhoneNumberNeeded:Z

.field private mForceFinishOnStop:Z

.field private mHasSignedIn:Z

.field private mIsUserSignedInCalled:Z

.field private mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

.field private mRefMarkerForCreateAccount:Ljava/lang/String;

.field private mRefMarkerForLogin:Ljava/lang/String;

.field private mShowPassword:Landroid/widget/CheckBox;

.field private mUserForceSignIn:Z

.field passwordTextWatcher:Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;

.field private signInController:Lcom/amazon/mShop/control/account/SignInController;

.field private taskCallback:Lcom/amazon/mShop/control/TaskCallback;

.field private userInitiatedLogin:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 53
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    .line 92
    iput-boolean v0, p0, Lcom/amazon/mShop/account/LoginActivity;->userInitiatedLogin:Z

    .line 97
    iput-boolean v0, p0, Lcom/amazon/mShop/account/LoginActivity;->mUserForceSignIn:Z

    .line 98
    iput-boolean v0, p0, Lcom/amazon/mShop/account/LoginActivity;->mForceFinishOnStop:Z

    .line 102
    iput-boolean v0, p0, Lcom/amazon/mShop/account/LoginActivity;->mIsUserSignedInCalled:Z

    .line 112
    iput-boolean v0, p0, Lcom/amazon/mShop/account/LoginActivity;->loginHideMenu:Z

    .line 136
    iput-boolean v0, p0, Lcom/amazon/mShop/account/LoginActivity;->hasPostShowPasswordRefMarker:Z

    .line 137
    iput-boolean v0, p0, Lcom/amazon/mShop/account/LoginActivity;->hasPostHidePasswordRefMarker:Z

    .line 140
    iput-boolean v0, p0, Lcom/amazon/mShop/account/LoginActivity;->mAccountPhoneNumberNeeded:Z

    .line 497
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/account/LoginActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/account/LoginActivity;

    .prologue
    .line 53
    invoke-direct {p0}, Lcom/amazon/mShop/account/LoginActivity;->updateLoginButtonEnabled()V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/mShop/account/LoginActivity;ZLcom/amazon/rio/j2me/client/services/mShop/Notification;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/account/LoginActivity;
    .param p1, "x1"    # Z
    .param p2, "x2"    # Lcom/amazon/rio/j2me/client/services/mShop/Notification;

    .prologue
    .line 53
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/account/LoginActivity;->postLogin(ZLcom/amazon/rio/j2me/client/services/mShop/Notification;)V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/account/LoginActivity;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/account/LoginActivity;
    .param p1, "x1"    # Z

    .prologue
    .line 53
    invoke-direct {p0, p1}, Lcom/amazon/mShop/account/LoginActivity;->callUserSignedIn(Z)V

    return-void
.end method

.method private callUserSignedIn(Z)V
    .locals 1
    .param p1, "successful"    # Z

    .prologue
    .line 625
    iget-boolean v0, p0, Lcom/amazon/mShop/account/LoginActivity;->mIsUserSignedInCalled:Z

    if-nez v0, :cond_0

    if-eqz p1, :cond_0

    .line 626
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->userSignedIn(Lcom/amazon/mShop/model/auth/User;)V

    .line 627
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/account/LoginActivity;->mIsUserSignedInCalled:Z

    .line 629
    :cond_0
    return-void
.end method

.method private canLogin()Z
    .locals 1

    .prologue
    .line 480
    iget-object v0, p0, Lcom/amazon/mShop/account/LoginActivity;->loginEmailEditText:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->length()I

    move-result v0

    if-lez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/account/LoginActivity;->loginPasswordEditText:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->length()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private cancelMetric()V
    .locals 1

    .prologue
    .line 152
    iget-object v0, p0, Lcom/amazon/mShop/account/LoginActivity;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/account/LoginActivity;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v0

    if-nez v0, :cond_0

    .line 153
    iget-object v0, p0, Lcom/amazon/mShop/account/LoginActivity;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onCancelled()V

    .line 155
    :cond_0
    return-void
.end method

.method private completeMetric()V
    .locals 1

    .prologue
    .line 158
    iget-object v0, p0, Lcom/amazon/mShop/account/LoginActivity;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/account/LoginActivity;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->isFinished()Z

    move-result v0

    if-nez v0, :cond_0

    .line 159
    iget-object v0, p0, Lcom/amazon/mShop/account/LoginActivity;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->onComplete()V

    .line 163
    :cond_0
    const-string/jumbo v0, "si_succeed"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 167
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/account/LoginActivity;->mHasSignedIn:Z

    .line 168
    return-void
.end method

.method private dismissKeyboardAttemptLogin()V
    .locals 7

    .prologue
    .line 454
    iget-object v0, p0, Lcom/amazon/mShop/account/LoginActivity;->signInController:Lcom/amazon/mShop/control/account/SignInController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/account/SignInController;->hasServiceCallRunning()Z

    move-result v0

    if-nez v0, :cond_1

    .line 456
    invoke-direct {p0}, Lcom/amazon/mShop/account/LoginActivity;->startMetric()V

    .line 458
    invoke-virtual {p0}, Lcom/amazon/mShop/account/LoginActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/UIUtils;->closeSoftKeyboard(Landroid/view/View;)V

    .line 460
    const/4 v3, 0x0

    .line 461
    .local v3, "notificationTarget":Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    invoke-static {}, Lcom/amazon/mShop/util/MShopPushNotificationUtils;->isPushNotificationAvailable()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 462
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v6

    .line 463
    .local v6, "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    const/4 v0, 0x0

    invoke-virtual {v6, v0}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getNewNotificationTarget(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    move-result-object v3

    .line 466
    .end local v6    # "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/account/LoginActivity;->signInController:Lcom/amazon/mShop/control/account/SignInController;

    iget-object v1, p0, Lcom/amazon/mShop/account/LoginActivity;->loginEmailEditText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/account/LoginActivity;->loginPasswordEditText:Landroid/widget/EditText;

    invoke-virtual {v2}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v2

    iget-boolean v4, p0, Lcom/amazon/mShop/account/LoginActivity;->userInitiatedLogin:Z

    iget-object v5, p0, Lcom/amazon/mShop/account/LoginActivity;->taskCallback:Lcom/amazon/mShop/control/TaskCallback;

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/mShop/control/account/SignInController;->signIn(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;ZLcom/amazon/mShop/control/TaskCallback;)V

    .line 473
    .end local v3    # "notificationTarget":Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    :cond_1
    return-void
.end method

.method private postLogin(ZLcom/amazon/rio/j2me/client/services/mShop/Notification;)V
    .locals 5
    .param p1, "successful"    # Z
    .param p2, "notification"    # Lcom/amazon/rio/j2me/client/services/mShop/Notification;

    .prologue
    .line 586
    invoke-direct {p0, p1}, Lcom/amazon/mShop/account/LoginActivity;->callUserSignedIn(Z)V

    .line 588
    if-eqz p2, :cond_2

    .line 592
    invoke-static {}, Lcom/amazon/mShop/AmazonActivity;->getTopMostBaseActivity()Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    .line 594
    .local v0, "activity":Lcom/amazon/mShop/AmazonActivity;
    if-eqz v0, :cond_1

    .line 595
    new-instance v3, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    invoke-direct {v3, v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/Notification;->getTitle()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v3

    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/Notification;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v1

    .line 598
    .local v1, "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    invoke-static {p2}, Lcom/amazon/mShop/control/account/OneClickController;->isOneClickNotification(Lcom/amazon/rio/j2me/client/services/mShop/Notification;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 602
    const/4 v2, 0x0

    .line 603
    .local v2, "onClickListener":Landroid/content/DialogInterface$OnClickListener;
    if-eqz p1, :cond_0

    .line 605
    new-instance v2, Lcom/amazon/mShop/account/LoginActivity$2;

    .end local v2    # "onClickListener":Landroid/content/DialogInterface$OnClickListener;
    invoke-direct {v2, p0}, Lcom/amazon/mShop/account/LoginActivity$2;-><init>(Lcom/amazon/mShop/account/LoginActivity;)V

    .line 613
    .restart local v2    # "onClickListener":Landroid/content/DialogInterface$OnClickListener;
    :cond_0
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->alert_dialog_ok_button:I

    invoke-virtual {v1, v3, v2}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 614
    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 621
    .end local v0    # "activity":Lcom/amazon/mShop/AmazonActivity;
    .end local v1    # "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    .end local v2    # "onClickListener":Landroid/content/DialogInterface$OnClickListener;
    :cond_1
    :goto_0
    return-void

    .line 618
    :cond_2
    if-eqz p1, :cond_1

    .line 619
    invoke-virtual {p0}, Lcom/amazon/mShop/account/LoginActivity;->finish()V

    goto :goto_0
.end method

.method private pushSignInView()V
    .locals 8

    .prologue
    const/16 v7, 0x8

    const/4 v6, 0x0

    .line 252
    invoke-virtual {p0}, Lcom/amazon/mShop/account/LoginActivity;->createLoginContentView()Landroid/view/View;

    move-result-object v1

    .line 253
    .local v1, "content":Landroid/view/View;
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/account/LoginActivity;->pushView(Landroid/view/View;)V

    .line 255
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->login_email_edit:I

    invoke-virtual {v1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->loginEmailEditText:Landroid/widget/EditText;

    .line 256
    iget-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->loginEmailEditText:Landroid/widget/EditText;

    invoke-virtual {v4, p0}, Landroid/widget/EditText;->setOnKeyListener(Landroid/view/View$OnKeyListener;)V

    .line 259
    iget-object v5, p0, Lcom/amazon/mShop/account/LoginActivity;->loginEmailEditText:Landroid/widget/EditText;

    iget-boolean v4, p0, Lcom/amazon/mShop/account/LoginActivity;->mAccountPhoneNumberNeeded:Z

    if-eqz v4, :cond_1

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->sign_in_email_phone_number_hint:I

    :goto_0
    invoke-virtual {v5, v4}, Landroid/widget/EditText;->setHint(I)V

    .line 260
    new-instance v4, Lcom/amazon/mShop/account/LoginActivity$LogInTextWatcher;

    iget-object v5, p0, Lcom/amazon/mShop/account/LoginActivity;->loginEmailEditText:Landroid/widget/EditText;

    invoke-direct {v4, p0, v5}, Lcom/amazon/mShop/account/LoginActivity$LogInTextWatcher;-><init>(Lcom/amazon/mShop/account/LoginActivity;Landroid/widget/EditText;)V

    iput-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->emailTextWatcher:Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;

    .line 261
    iget-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->loginEmailEditText:Landroid/widget/EditText;

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->sign_in_email_rule:I

    invoke-static {v4, v5}, Lcom/amazon/mShop/util/UIUtils;->setMaxLengthFromRule(Landroid/widget/TextView;I)V

    .line 263
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->login_password_edit:I

    invoke-virtual {v1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/EditText;

    iput-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->loginPasswordEditText:Landroid/widget/EditText;

    .line 264
    iget-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->loginPasswordEditText:Landroid/widget/EditText;

    invoke-virtual {v4, p0}, Landroid/widget/EditText;->setOnKeyListener(Landroid/view/View$OnKeyListener;)V

    .line 265
    new-instance v4, Lcom/amazon/mShop/account/LoginActivity$LogInTextWatcher;

    iget-object v5, p0, Lcom/amazon/mShop/account/LoginActivity;->loginPasswordEditText:Landroid/widget/EditText;

    invoke-direct {v4, p0, v5}, Lcom/amazon/mShop/account/LoginActivity$LogInTextWatcher;-><init>(Lcom/amazon/mShop/account/LoginActivity;Landroid/widget/EditText;)V

    iput-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->passwordTextWatcher:Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;

    .line 266
    iget-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->loginEmailEditText:Landroid/widget/EditText;

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->sign_in_password_rule:I

    invoke-static {v4, v5}, Lcom/amazon/mShop/util/UIUtils;->setMaxLengthFromRule(Landroid/widget/TextView;I)V

    .line 268
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->login_button:I

    invoke-virtual {v1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/Button;

    iput-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->loginButton:Landroid/widget/Button;

    .line 269
    iget-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->loginButton:Landroid/widget/Button;

    invoke-virtual {v4, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 271
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getLastUserEmail()Ljava/lang/String;

    move-result-object v2

    .line 272
    .local v2, "email":Ljava/lang/String;
    if-eqz v2, :cond_2

    .line 273
    iget-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->loginEmailEditText:Landroid/widget/EditText;

    invoke-virtual {v4, v2}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 274
    iget-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->loginPasswordEditText:Landroid/widget/EditText;

    invoke-virtual {v4}, Landroid/widget/EditText;->requestFocus()Z

    .line 281
    :goto_1
    iget-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->loginButton:Landroid/widget/Button;

    invoke-direct {p0}, Lcom/amazon/mShop/account/LoginActivity;->canLogin()Z

    move-result v5

    invoke-virtual {v4, v5}, Landroid/widget/Button;->setEnabled(Z)V

    .line 283
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->login_forget_your_password:I

    invoke-virtual {v1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    iput-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->loginForgotYourPassword:Landroid/widget/TextView;

    .line 284
    iget-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->loginForgotYourPassword:Landroid/widget/TextView;

    invoke-virtual {v4, p0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 287
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->change_email_preference:I

    invoke-virtual {v1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    iput-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->changeEmailPreference:Landroid/widget/TextView;

    .line 288
    iget-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->changeEmailPreference:Landroid/widget/TextView;

    invoke-virtual {v4, p0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 290
    invoke-virtual {v1}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->ya_site_email_pref_button:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 291
    .local v0, "changeEmailPrefText":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_3

    .line 292
    iget-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->changeEmailPreference:Landroid/widget/TextView;

    invoke-virtual {v4, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 297
    :goto_2
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->login_create_new_button:I

    invoke-virtual {v1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/Button;

    iput-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->createNewButton:Landroid/widget/Button;

    .line 298
    iget-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->createNewButton:Landroid/widget/Button;

    if-eqz v4, :cond_0

    .line 300
    iget-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->createNewButton:Landroid/widget/Button;

    invoke-virtual {v4, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 303
    :cond_0
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->login_legal_information:I

    invoke-virtual {v1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    iput-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->loginLegalInformationLink:Landroid/widget/TextView;

    .line 304
    iget-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->loginLegalInformationLink:Landroid/widget/TextView;

    invoke-virtual {v4, p0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 305
    invoke-virtual {v1}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->sign_in_legal_text:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 306
    .local v3, "legalText":Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_4

    .line 307
    iget-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->loginLegalInformationLink:Landroid/widget/TextView;

    invoke-virtual {v4, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 308
    iget-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->loginLegalInformationLink:Landroid/widget/TextView;

    invoke-virtual {v4, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 313
    :goto_3
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->show_password:I

    invoke-virtual {v1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/CheckBox;

    iput-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->mShowPassword:Landroid/widget/CheckBox;

    .line 314
    iget-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->mShowPassword:Landroid/widget/CheckBox;

    invoke-virtual {v4, p0}, Landroid/widget/CheckBox;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 315
    return-void

    .line 259
    .end local v0    # "changeEmailPrefText":Ljava/lang/String;
    .end local v2    # "email":Ljava/lang/String;
    .end local v3    # "legalText":Ljava/lang/String;
    :cond_1
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->sign_in_email_hint:I

    goto/16 :goto_0

    .line 278
    .restart local v2    # "email":Ljava/lang/String;
    :cond_2
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->login_layout:I

    invoke-virtual {v1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/View;->requestFocus()Z

    goto/16 :goto_1

    .line 294
    .restart local v0    # "changeEmailPrefText":Ljava/lang/String;
    :cond_3
    iget-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->changeEmailPreference:Landroid/widget/TextView;

    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_2

    .line 310
    .restart local v3    # "legalText":Ljava/lang/String;
    :cond_4
    iget-object v4, p0, Lcom/amazon/mShop/account/LoginActivity;->loginLegalInformationLink:Landroid/widget/TextView;

    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_3
.end method

.method private startMetric()V
    .locals 1

    .prologue
    .line 148
    const-string/jumbo v0, "Signin"

    invoke-static {v0}, Lcom/amazon/mShop/net/PageMetricsObserver;->start(Ljava/lang/String;)Lcom/amazon/mShop/net/PageMetricsObserver;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/account/LoginActivity;->mPageMetricsObserver:Lcom/amazon/mShop/net/PageMetricsObserver;

    .line 149
    return-void
.end method

.method private updateLoginButtonEnabled()V
    .locals 2

    .prologue
    .line 476
    iget-object v1, p0, Lcom/amazon/mShop/account/LoginActivity;->loginButton:Landroid/widget/Button;

    iget-object v0, p0, Lcom/amazon/mShop/account/LoginActivity;->emailTextWatcher:Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;

    invoke-virtual {v0}, Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;->isWatchedNonZeroLength()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/account/LoginActivity;->passwordTextWatcher:Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;

    invoke-virtual {v0}, Lcom/amazon/mShop/account/NonZeroLengthTextWatcher;->isWatchedNonZeroLength()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {v1, v0}, Landroid/widget/Button;->setEnabled(Z)V

    .line 477
    return-void

    .line 476
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private updateShowPassword(Z)V
    .locals 2
    .param p1, "isChecked"    # Z

    .prologue
    .line 420
    iget-object v1, p0, Lcom/amazon/mShop/account/LoginActivity;->loginPasswordEditText:Landroid/widget/EditText;

    if-eqz p1, :cond_0

    const/16 v0, 0x90

    :goto_0
    or-int/lit8 v0, v0, 0x1

    invoke-virtual {v1, v0}, Landroid/widget/EditText;->setInputType(I)V

    .line 427
    iget-object v0, p0, Lcom/amazon/mShop/account/LoginActivity;->loginPasswordEditText:Landroid/widget/EditText;

    sget-object v1, Landroid/graphics/Typeface;->DEFAULT:Landroid/graphics/Typeface;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setTypeface(Landroid/graphics/Typeface;)V

    .line 429
    iget-object v0, p0, Lcom/amazon/mShop/account/LoginActivity;->loginPasswordEditText:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/amazon/mShop/account/LoginActivity;->loginPasswordEditText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 430
    iget-object v0, p0, Lcom/amazon/mShop/account/LoginActivity;->loginPasswordEditText:Landroid/widget/EditText;

    iget-object v1, p0, Lcom/amazon/mShop/account/LoginActivity;->loginPasswordEditText:Landroid/widget/EditText;

    invoke-virtual {v1}, Landroid/widget/EditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-interface {v1}, Landroid/text/Editable;->length()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setSelection(I)V

    .line 431
    return-void

    .line 420
    :cond_0
    const/16 v0, 0x80

    goto :goto_0
.end method


# virtual methods
.method protected createLoginContentView()Landroid/view/View;
    .locals 1

    .prologue
    .line 352
    new-instance v0, Lcom/amazon/mShop/account/LoginView;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/account/LoginView;-><init>(Landroid/content/Context;)V

    return-object v0
.end method

.method public hasSignedIn()Z
    .locals 1

    .prologue
    .line 579
    iget-boolean v0, p0, Lcom/amazon/mShop/account/LoginActivity;->mHasSignedIn:Z

    return v0
.end method

.method public isAccountPhoneNumberNeeded()Z
    .locals 1

    .prologue
    .line 144
    iget-boolean v0, p0, Lcom/amazon/mShop/account/LoginActivity;->mAccountPhoneNumberNeeded:Z

    return v0
.end method

.method public isUserForceSignIn()Z
    .locals 1

    .prologue
    .line 105
    iget-boolean v0, p0, Lcom/amazon/mShop/account/LoginActivity;->mUserForceSignIn:Z

    return v0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 11
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 362
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v7

    sget v8, Lcom/amazon/mShop/android/lib/R$id;->login_button:I

    if-ne v7, v8, :cond_2

    .line 363
    iget-object v7, p0, Lcom/amazon/mShop/account/LoginActivity;->mShowPassword:Landroid/widget/CheckBox;

    invoke-virtual {v7}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v7

    if-eqz v7, :cond_0

    .line 366
    iget-object v7, p0, Lcom/amazon/mShop/account/LoginActivity;->mShowPassword:Landroid/widget/CheckBox;

    invoke-virtual {v7, v9}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 367
    invoke-direct {p0, v9}, Lcom/amazon/mShop/account/LoginActivity;->updateShowPassword(Z)V

    .line 370
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/account/LoginActivity;->dismissKeyboardAttemptLogin()V

    .line 372
    iget-object v7, p0, Lcom/amazon/mShop/account/LoginActivity;->mRefMarkerForLogin:Ljava/lang/String;

    invoke-static {v7}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 386
    const-string/jumbo v7, "sign_in"

    invoke-static {v7}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 417
    .end local p1    # "view":Landroid/view/View;
    :cond_1
    :goto_0
    return-void

    .line 388
    .restart local p1    # "view":Landroid/view/View;
    :cond_2
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v7

    sget v8, Lcom/amazon/mShop/android/lib/R$id;->login_forget_your_password:I

    if-ne v7, v8, :cond_3

    .line 389
    invoke-virtual {p0}, Lcom/amazon/mShop/account/LoginActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/amazon/mShop/android/lib/R$string;->sign_in_forgot_your_password_url:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 390
    .local v6, "url":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/mShop/account/LoginActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/amazon/mShop/android/lib/R$string;->sign_in_forgot_your_password:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    .line 391
    .local v5, "title":Ljava/lang/String;
    new-instance v7, Lcom/amazon/mShop/AmazonBrandedWebView;

    invoke-direct {v7, p0, v6, v5}, Lcom/amazon/mShop/AmazonBrandedWebView;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v7}, Lcom/amazon/mShop/account/LoginActivity;->pushView(Landroid/view/View;)V

    goto :goto_0

    .line 392
    .end local v5    # "title":Ljava/lang/String;
    .end local v6    # "url":Ljava/lang/String;
    :cond_3
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v7

    sget v8, Lcom/amazon/mShop/android/lib/R$id;->change_email_preference:I

    if-ne v7, v8, :cond_4

    .line 393
    invoke-virtual {p0}, Lcom/amazon/mShop/account/LoginActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/amazon/mShop/android/lib/R$string;->ya_site_email_pref_url:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 394
    .local v1, "changeEmailPrefUrl":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/mShop/account/LoginActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/amazon/mShop/android/lib/R$string;->ya_site_email_pref_button:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 395
    .local v0, "changeEmailPrefTitle":Ljava/lang/String;
    new-instance v7, Lcom/amazon/mShop/AmazonBrandedWebView;

    invoke-direct {v7, p0, v1, v0}, Lcom/amazon/mShop/AmazonBrandedWebView;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v7}, Lcom/amazon/mShop/account/LoginActivity;->pushView(Landroid/view/View;)V

    goto :goto_0

    .line 396
    .end local v0    # "changeEmailPrefTitle":Ljava/lang/String;
    .end local v1    # "changeEmailPrefUrl":Ljava/lang/String;
    :cond_4
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v7

    sget v8, Lcom/amazon/mShop/android/lib/R$id;->login_create_new_button:I

    if-ne v7, v8, :cond_5

    .line 398
    const-string/jumbo v7, "si_newcust"

    invoke-static {v7}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 399
    new-instance v7, Lcom/amazon/mShop/account/CreateNewAccountView;

    iget-object v8, p0, Lcom/amazon/mShop/account/LoginActivity;->mRefMarkerForCreateAccount:Ljava/lang/String;

    invoke-direct {v7, p0, v8}, Lcom/amazon/mShop/account/CreateNewAccountView;-><init>(Lcom/amazon/mShop/account/LoginActivity;Ljava/lang/String;)V

    invoke-virtual {p0, v7}, Lcom/amazon/mShop/account/LoginActivity;->pushView(Landroid/view/View;)V

    goto :goto_0

    .line 400
    :cond_5
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v7

    sget v8, Lcom/amazon/mShop/android/lib/R$id;->login_legal_information:I

    if-ne v7, v8, :cond_6

    .line 401
    invoke-virtual {p0}, Lcom/amazon/mShop/account/LoginActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/amazon/mShop/android/lib/R$string;->sign_in_legal_link_url:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    .line 402
    .local v4, "legalUrl":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/mShop/account/LoginActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/amazon/mShop/android/lib/R$string;->sign_in_legal_text:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 403
    .local v3, "legalTitle":Ljava/lang/String;
    new-instance v7, Lcom/amazon/mShop/AmazonBrandedWebView;

    invoke-direct {v7, p0, v4, v3}, Lcom/amazon/mShop/AmazonBrandedWebView;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v7}, Lcom/amazon/mShop/account/LoginActivity;->pushView(Landroid/view/View;)V

    goto/16 :goto_0

    .line 404
    .end local v3    # "legalTitle":Ljava/lang/String;
    .end local v4    # "legalUrl":Ljava/lang/String;
    :cond_6
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v7

    sget v8, Lcom/amazon/mShop/android/lib/R$id;->show_password:I

    if-ne v7, v8, :cond_1

    .line 405
    check-cast p1, Landroid/widget/CheckBox;

    .end local p1    # "view":Landroid/view/View;
    invoke-virtual {p1}, Landroid/widget/CheckBox;->isChecked()Z

    move-result v2

    .line 406
    .local v2, "isChecked":Z
    invoke-direct {p0, v2}, Lcom/amazon/mShop/account/LoginActivity;->updateShowPassword(Z)V

    .line 407
    if-eqz v2, :cond_7

    iget-boolean v7, p0, Lcom/amazon/mShop/account/LoginActivity;->hasPostShowPasswordRefMarker:Z

    if-nez v7, :cond_7

    .line 409
    const-string/jumbo v7, "si_pwd_show"

    invoke-static {v7}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 410
    iput-boolean v10, p0, Lcom/amazon/mShop/account/LoginActivity;->hasPostShowPasswordRefMarker:Z

    goto/16 :goto_0

    .line 411
    :cond_7
    if-nez v2, :cond_1

    iget-boolean v7, p0, Lcom/amazon/mShop/account/LoginActivity;->hasPostHidePasswordRefMarker:Z

    if-nez v7, :cond_1

    .line 413
    const-string/jumbo v7, "si_pwd_hide"

    invoke-static {v7}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 414
    iput-boolean v10, p0, Lcom/amazon/mShop/account/LoginActivity;->hasPostHidePasswordRefMarker:Z

    goto/16 :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 172
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 174
    new-instance v1, Lcom/amazon/mShop/control/account/SignInController;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/amazon/mShop/control/account/SignInController;-><init>(Lcom/amazon/mShop/control/account/SignInSubscriber;Z)V

    iput-object v1, p0, Lcom/amazon/mShop/account/LoginActivity;->signInController:Lcom/amazon/mShop/control/account/SignInController;

    .line 175
    new-instance v1, Lcom/amazon/mShop/TaskCallbackFactory;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/TaskCallbackFactory;-><init>(Landroid/content/Context;)V

    iget-object v2, p0, Lcom/amazon/mShop/account/LoginActivity;->signInController:Lcom/amazon/mShop/control/account/SignInController;

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->sign_in_in_progress:I

    invoke-virtual {v1, v2, p0, v3}, Lcom/amazon/mShop/TaskCallbackFactory;->getFinishTaskCallback(Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;I)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/mShop/account/LoginActivity;->taskCallback:Lcom/amazon/mShop/control/TaskCallback;

    .line 186
    sget v1, Lcom/amazon/mShop/android/lib/R$string;->sign_in_title:I

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/account/LoginActivity;->setTitle(I)V

    .line 202
    if-eqz p1, :cond_0

    .line 203
    invoke-virtual {p0}, Lcom/amazon/mShop/account/LoginActivity;->finish()V

    .line 206
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/account/LoginActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    const-string/jumbo v2, "REFMARKER"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 207
    .local v0, "refMarker":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 208
    iput-object v0, p0, Lcom/amazon/mShop/account/LoginActivity;->mRefMarkerForLogin:Ljava/lang/String;

    .line 209
    const-string/jumbo v1, "crt_si"

    iget-object v2, p0, Lcom/amazon/mShop/account/LoginActivity;->mRefMarkerForLogin:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 211
    const-string/jumbo v1, "crt_ca"

    iput-object v1, p0, Lcom/amazon/mShop/account/LoginActivity;->mRefMarkerForCreateAccount:Ljava/lang/String;

    .line 218
    :cond_1
    :goto_0
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isAccountPhoneNumber()Z

    move-result v1

    iput-boolean v1, p0, Lcom/amazon/mShop/account/LoginActivity;->mAccountPhoneNumberNeeded:Z

    .line 219
    return-void

    .line 212
    :cond_2
    const-string/jumbo v1, "hm_si"

    iget-object v2, p0, Lcom/amazon/mShop/account/LoginActivity;->mRefMarkerForLogin:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 214
    const-string/jumbo v1, "hm_ca"

    iput-object v1, p0, Lcom/amazon/mShop/account/LoginActivity;->mRefMarkerForCreateAccount:Ljava/lang/String;

    goto :goto_0
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 485
    iget-boolean v0, p0, Lcom/amazon/mShop/account/LoginActivity;->userInitiatedLogin:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/amazon/mShop/account/LoginActivity;->loginHideMenu:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/amazon/mShop/account/LoginActivity;->mUserForceSignIn:Z

    if-nez v0, :cond_0

    .line 488
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreateOptionsMenu(Landroid/view/Menu;)Z

    move-result v0

    .line 493
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 339
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onDestroy()V

    .line 340
    invoke-direct {p0}, Lcom/amazon/mShop/account/LoginActivity;->cancelMetric()V

    .line 341
    return-void
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    const/4 v1, 0x0

    .line 570
    invoke-direct {p0}, Lcom/amazon/mShop/account/LoginActivity;->cancelMetric()V

    .line 573
    iget-object v0, p0, Lcom/amazon/mShop/account/LoginActivity;->loginPasswordEditText:Landroid/widget/EditText;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setText(Ljava/lang/CharSequence;)V

    .line 575
    invoke-virtual {p0}, Lcom/amazon/mShop/account/LoginActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    invoke-static {p0, v1, v0, p1}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportMShopServerError(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;Ljava/lang/Exception;)V

    .line 576
    return-void
.end method

.method public onKey(Landroid/view/View;ILandroid/view/KeyEvent;)Z
    .locals 3
    .param p1, "v"    # Landroid/view/View;
    .param p2, "keyCode"    # I
    .param p3, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v0, 0x0

    .line 439
    invoke-virtual {p3}, Landroid/view/KeyEvent;->getAction()I

    move-result v1

    if-nez v1, :cond_1

    .line 450
    :cond_0
    :goto_0
    return v0

    .line 443
    :cond_1
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v1

    sget v2, Lcom/amazon/mShop/android/lib/R$id;->login_email_edit:I

    if-eq v1, v2, :cond_2

    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v1

    sget v2, Lcom/amazon/mShop/android/lib/R$id;->login_password_edit:I

    if-ne v1, v2, :cond_0

    .line 444
    :cond_2
    invoke-direct {p0}, Lcom/amazon/mShop/account/LoginActivity;->canLogin()Z

    move-result v1

    if-eqz v1, :cond_0

    const/16 v1, 0x42

    if-eq p2, v1, :cond_3

    const/16 v1, 0x17

    if-ne p2, v1, :cond_0

    .line 445
    :cond_3
    invoke-direct {p0}, Lcom/amazon/mShop/account/LoginActivity;->dismissKeyboardAttemptLogin()V

    .line 446
    const/4 v0, 0x1

    goto :goto_0
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 319
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onPause()V

    .line 322
    invoke-virtual {p0}, Lcom/amazon/mShop/account/LoginActivity;->getCurrentView()Landroid/view/View;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/UIUtils;->closeSoftKeyboard(Landroid/view/View;)V

    .line 323
    return-void
.end method

.method public onSearchRequested()Z
    .locals 1

    .prologue
    .line 635
    iget-boolean v0, p0, Lcom/amazon/mShop/account/LoginActivity;->mUserForceSignIn:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_0
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onSearchRequested()Z

    move-result v0

    goto :goto_0
.end method

.method public onSignInCompleted(ZLcom/amazon/rio/j2me/client/services/mShop/Notification;)V
    .locals 5
    .param p1, "successful"    # Z
    .param p2, "notification"    # Lcom/amazon/rio/j2me/client/services/mShop/Notification;

    .prologue
    .line 515
    if-eqz p1, :cond_0

    .line 516
    const/4 v3, -0x1

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/account/LoginActivity;->setResult(I)V

    .line 517
    invoke-direct {p0}, Lcom/amazon/mShop/account/LoginActivity;->completeMetric()V

    .line 519
    const/4 v3, 0x0

    iput-boolean v3, p0, Lcom/amazon/mShop/account/LoginActivity;->mIsUserSignedInCalled:Z

    .line 528
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/mShop/account/LoginActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    const-string/jumbo v4, "LOGIN_ORIGIN_KEY"

    invoke-virtual {v3, v4}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 529
    .local v0, "origin":Ljava/lang/String;
    iget-boolean v3, p0, Lcom/amazon/mShop/account/LoginActivity;->userInitiatedLogin:Z

    invoke-virtual {p0}, Lcom/amazon/mShop/account/LoginActivity;->isUserForceSignIn()Z

    move-result v4

    invoke-static {v0, v3, v4}, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->shouldTryToShowPrimeAfterLogin(Ljava/lang/String;ZZ)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 530
    new-instance v2, Lcom/amazon/mShop/account/LoginActivity$1;

    invoke-direct {v2, p0, p1, p2}, Lcom/amazon/mShop/account/LoginActivity$1;-><init>(Lcom/amazon/mShop/account/LoginActivity;ZLcom/amazon/rio/j2me/client/services/mShop/Notification;)V

    .line 553
    .local v2, "subscriber":Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeUpsellSubscriber;
    iget-boolean v3, p0, Lcom/amazon/mShop/account/LoginActivity;->mUserForceSignIn:Z

    invoke-static {v3, v0}, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->getPrimeRefMarkerFromLoginOrigin(ZLjava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 555
    .local v1, "refMarker":Ljava/lang/String;
    invoke-static {p0, v2, v1}, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->showPrimeUpsell(Landroid/app/Activity;Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeUpsellSubscriber;Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 556
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/account/LoginActivity;->postLogin(ZLcom/amazon/rio/j2me/client/services/mShop/Notification;)V

    .line 566
    .end local v1    # "refMarker":Ljava/lang/String;
    .end local v2    # "subscriber":Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeUpsellSubscriber;
    :goto_1
    return-void

    .line 521
    .end local v0    # "origin":Ljava/lang/String;
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/account/LoginActivity;->cancelMetric()V

    goto :goto_0

    .line 560
    .restart local v0    # "origin":Ljava/lang/String;
    .restart local v1    # "refMarker":Ljava/lang/String;
    .restart local v2    # "subscriber":Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeUpsellSubscriber;
    :cond_1
    const/4 v3, 0x1

    iput-boolean v3, p0, Lcom/amazon/mShop/account/LoginActivity;->mForceFinishOnStop:Z

    goto :goto_1

    .line 563
    .end local v1    # "refMarker":Ljava/lang/String;
    .end local v2    # "subscriber":Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper$PrimeUpsellSubscriber;
    :cond_2
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/account/LoginActivity;->postLogin(ZLcom/amazon/rio/j2me/client/services/mShop/Notification;)V

    goto :goto_1
.end method

.method public onStart()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 233
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onStart()V

    .line 236
    invoke-virtual {p0}, Lcom/amazon/mShop/account/LoginActivity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    .line 237
    .local v1, "intent":Landroid/content/Intent;
    const-string/jumbo v3, "USER_INITIATED_LOGIN"

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v3

    iput-boolean v3, p0, Lcom/amazon/mShop/account/LoginActivity;->userInitiatedLogin:Z

    .line 238
    const-string/jumbo v3, "LOGIN_HIDE_MENU"

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v3

    iput-boolean v3, p0, Lcom/amazon/mShop/account/LoginActivity;->loginHideMenu:Z

    .line 239
    const-string/jumbo v3, "FORCE_SIGN_IN"

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v3

    iput-boolean v3, p0, Lcom/amazon/mShop/account/LoginActivity;->mUserForceSignIn:Z

    .line 241
    const-string/jumbo v3, "IS_CREATE_NEW_ACCOUNT"

    invoke-virtual {v1, v3, v4}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v2

    .line 243
    .local v2, "isCreateNewAccount":Z
    if-eqz v2, :cond_0

    .line 244
    new-instance v0, Lcom/amazon/mShop/account/CreateNewAccountView;

    iget-object v3, p0, Lcom/amazon/mShop/account/LoginActivity;->mRefMarkerForCreateAccount:Ljava/lang/String;

    invoke-direct {v0, p0, v3}, Lcom/amazon/mShop/account/CreateNewAccountView;-><init>(Lcom/amazon/mShop/account/LoginActivity;Ljava/lang/String;)V

    .line 245
    .local v0, "content":Landroid/view/View;
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/account/LoginActivity;->pushView(Landroid/view/View;)V

    .line 249
    .end local v0    # "content":Landroid/view/View;
    :goto_0
    return-void

    .line 247
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/account/LoginActivity;->pushSignInView()V

    goto :goto_0
.end method

.method protected onStop()V
    .locals 1

    .prologue
    .line 333
    iget-boolean v0, p0, Lcom/amazon/mShop/account/LoginActivity;->mUserForceSignIn:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/amazon/mShop/account/LoginActivity;->mForceFinishOnStop:Z

    if-nez v0, :cond_0

    const/4 v0, 0x2

    :goto_0
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/account/LoginActivity;->setStopBehavior(I)V

    .line 334
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onStop()V

    .line 335
    return-void

    .line 333
    :cond_0
    const/4 v0, 0x1

    goto :goto_0
.end method
