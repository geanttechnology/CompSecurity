.class public Lcom/amazon/mShop/account/LogoutActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "LogoutActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcom/amazon/mShop/control/account/SignOutSubscriber;


# instance fields
.field private logoutButton:Landroid/widget/Button;

.field private mRefMarker:Ljava/lang/String;

.field private signOutController:Lcom/amazon/mShop/control/account/SignOutController;

.field private signedInAsText:Landroid/widget/TextView;

.field private taskCallback:Lcom/amazon/mShop/control/TaskCallback;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    return-void
.end method

.method private setSignedInAsText(Landroid/view/View;)V
    .locals 6
    .param p1, "content"    # Landroid/view/View;

    .prologue
    .line 179
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->you_are_signed_in_as_label:I

    invoke-virtual {p1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    iput-object v4, p0, Lcom/amazon/mShop/account/LogoutActivity;->signedInAsText:Landroid/widget/TextView;

    .line 181
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v3

    .line 182
    .local v3, "user":Lcom/amazon/mShop/model/auth/User;
    if-eqz v3, :cond_0

    .line 184
    invoke-virtual {v3}, Lcom/amazon/mShop/model/auth/User;->getFullName()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->htmlEncode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 187
    .local v0, "escapedFullname":Ljava/lang/String;
    invoke-virtual {p1}, Landroid/view/View;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->sign_out_you_are_signed_in_as:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 188
    .local v1, "signedInAsFormat":Ljava/lang/String;
    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    invoke-static {v1, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 190
    .local v2, "signedInAsFormattedText":Ljava/lang/String;
    iget-object v4, p0, Lcom/amazon/mShop/account/LogoutActivity;->signedInAsText:Landroid/widget/TextView;

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 197
    .end local v0    # "escapedFullname":Ljava/lang/String;
    .end local v1    # "signedInAsFormat":Ljava/lang/String;
    .end local v2    # "signedInAsFormattedText":Ljava/lang/String;
    :goto_0
    iget-object v4, p0, Lcom/amazon/mShop/account/LogoutActivity;->signedInAsText:Landroid/widget/TextView;

    invoke-virtual {v4}, Landroid/widget/TextView;->requestFocus()Z

    .line 199
    return-void

    .line 192
    :cond_0
    iget-object v4, p0, Lcom/amazon/mShop/account/LogoutActivity;->signedInAsText:Landroid/widget/TextView;

    const-string/jumbo v5, ""

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 114
    const-string/jumbo v2, ""

    invoke-static {v2}, Lcom/amazon/mShop/search/SearchActivity;->setPreviousSearchTerm(Ljava/lang/String;)V

    .line 116
    iget-object v2, p0, Lcom/amazon/mShop/account/LogoutActivity;->signOutController:Lcom/amazon/mShop/control/account/SignOutController;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/account/SignOutController;->hasServiceCallRunning()Z

    move-result v2

    if-nez v2, :cond_1

    .line 117
    const/4 v1, 0x0

    .line 118
    .local v1, "notificationTarget":Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    invoke-static {}, Lcom/amazon/mShop/util/MShopPushNotificationUtils;->isPushNotificationAvailable()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 119
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v0

    .line 120
    .local v0, "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getNewNotificationTarget(Ljava/lang/String;)Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;

    move-result-object v1

    .line 123
    .end local v0    # "notificationManager":Lcom/amazon/mShop/pushnotification/PushNotificationManager;
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/account/LogoutActivity;->signOutController:Lcom/amazon/mShop/control/account/SignOutController;

    iget-object v3, p0, Lcom/amazon/mShop/account/LogoutActivity;->taskCallback:Lcom/amazon/mShop/control/TaskCallback;

    invoke-virtual {v2, v3, v1}, Lcom/amazon/mShop/control/account/SignOutController;->signOut(Lcom/amazon/mShop/control/TaskCallback;Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;)V

    .line 130
    .end local v1    # "notificationTarget":Lcom/amazon/rio/j2me/client/services/mShop/NotificationTarget;
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/account/LogoutActivity;->mRefMarker:Ljava/lang/String;

    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    .line 131
    iget-object v2, p0, Lcom/amazon/mShop/account/LogoutActivity;->mRefMarker:Ljava/lang/String;

    invoke-static {v2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 136
    :cond_2
    const-string/jumbo v2, "sign_out"

    invoke-static {v2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 137
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 53
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 55
    new-instance v0, Lcom/amazon/mShop/control/account/SignOutController;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/control/account/SignOutController;-><init>(Lcom/amazon/mShop/control/account/SignOutSubscriber;)V

    iput-object v0, p0, Lcom/amazon/mShop/account/LogoutActivity;->signOutController:Lcom/amazon/mShop/control/account/SignOutController;

    .line 56
    new-instance v0, Lcom/amazon/mShop/TaskCallbackFactory;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/TaskCallbackFactory;-><init>(Landroid/content/Context;)V

    iget-object v1, p0, Lcom/amazon/mShop/account/LogoutActivity;->signOutController:Lcom/amazon/mShop/control/account/SignOutController;

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->sign_out_in_progress:I

    invoke-virtual {v0, v1, p0, v2}, Lcom/amazon/mShop/TaskCallbackFactory;->getFinishTaskCallback(Lcom/amazon/mShop/control/Cancellable;Lcom/amazon/mShop/AmazonActivity;I)Lcom/amazon/mShop/control/TaskCallback;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/account/LogoutActivity;->taskCallback:Lcom/amazon/mShop/control/TaskCallback;

    .line 67
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->sign_out_title:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/account/LogoutActivity;->setTitle(I)V

    .line 68
    invoke-virtual {p0}, Lcom/amazon/mShop/account/LogoutActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string/jumbo v1, "REFMARKER"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/account/LogoutActivity;->mRefMarker:Ljava/lang/String;

    .line 69
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 175
    const/4 v0, 0x0

    return v0
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 3
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 164
    const-string/jumbo v0, "Amazon.LogoutActivity"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "error: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 166
    const/4 v0, 0x0

    invoke-virtual {p0}, Lcom/amazon/mShop/account/LogoutActivity;->getCurrentView()Landroid/view/View;

    move-result-object v1

    invoke-static {p0, v0, v1, p1}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportMShopServerError(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;Ljava/lang/Exception;)V

    .line 167
    return-void
.end method

.method protected onResume()V
    .locals 1

    .prologue
    .line 95
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onResume()V

    .line 98
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->sign_out_title:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/account/LogoutActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/account/LogoutActivity;->setTitle(Ljava/lang/CharSequence;)V

    .line 99
    return-void
.end method

.method public onSignOutComplete(Ljava/lang/String;)V
    .locals 1
    .param p1, "failureMessage"    # Ljava/lang/String;

    .prologue
    .line 145
    if-nez p1, :cond_1

    .line 147
    const/4 v0, -0x1

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/account/LogoutActivity;->setResult(I)V

    .line 148
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isSignInPrompt()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 150
    invoke-static {}, Lcom/amazon/mShop/util/AppUtils;->restartApp()V

    .line 160
    :goto_0
    return-void

    .line 154
    :cond_0
    invoke-static {p0}, Lcom/amazon/mShop/util/ActivityUtils;->startHomeActivity(Landroid/content/Context;)Z

    goto :goto_0

    .line 158
    :cond_1
    invoke-static {p0, p1}, Lcom/amazon/mShop/util/UIUtils;->alert(Landroid/content/Context;Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected onStart()V
    .locals 3

    .prologue
    .line 73
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onStart()V

    .line 84
    sget v1, Lcom/amazon/mShop/android/lib/R$layout;->logout:I

    const/4 v2, 0x0

    invoke-static {p0, v1, v2}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 85
    .local v0, "content":Landroid/view/View;
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/account/LogoutActivity;->pushView(Landroid/view/View;)V

    .line 87
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->logout_button:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/amazon/mShop/account/LogoutActivity;->logoutButton:Landroid/widget/Button;

    .line 88
    iget-object v1, p0, Lcom/amazon/mShop/account/LogoutActivity;->logoutButton:Landroid/widget/Button;

    invoke-virtual {v1, p0}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 90
    invoke-direct {p0, v0}, Lcom/amazon/mShop/account/LogoutActivity;->setSignedInAsText(Landroid/view/View;)V

    .line 91
    return-void
.end method

.method protected onStop()V
    .locals 0

    .prologue
    .line 103
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onStop()V

    .line 104
    return-void
.end method
