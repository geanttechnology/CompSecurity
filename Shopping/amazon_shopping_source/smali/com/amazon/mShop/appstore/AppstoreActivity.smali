.class public Lcom/amazon/mShop/appstore/AppstoreActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "AppstoreActivity.java"

# interfaces
.implements Lcom/amazon/mShop/search/ScopedSearch;
.implements Lcom/amazon/venezia/auth/AccountPreparer$AccountPreparationCallbacks;


# static fields
.field private static final LOG:Lcom/amazon/logging/Logger;


# instance fields
.field private controller:Lcom/amazon/venezia/mShop/AppstoreController;

.field private fragment:Landroid/support/v4/app/Fragment;

.field private installReceiver:Lcom/amazon/mas/client/install/foreground/InstallKickoffReceiver;

.field protected upKeyFromAppstore:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 37
    const-class v0, Lcom/amazon/mShop/appstore/AppstoreActivity;

    invoke-static {v0}, Lcom/amazon/logging/Logger;->getLogger(Ljava/lang/Class;)Lcom/amazon/logging/Logger;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/appstore/AppstoreActivity;->LOG:Lcom/amazon/logging/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 34
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    .line 51
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/appstore/AppstoreActivity;->upKeyFromAppstore:Z

    return-void
.end method

.method private addFragmentIfNecessary()V
    .locals 3

    .prologue
    .line 174
    iget-object v0, p0, Lcom/amazon/mShop/appstore/AppstoreActivity;->fragment:Landroid/support/v4/app/Fragment;

    if-nez v0, :cond_0

    .line 175
    iget-object v0, p0, Lcom/amazon/mShop/appstore/AppstoreActivity;->controller:Lcom/amazon/venezia/mShop/AppstoreController;

    invoke-virtual {v0}, Lcom/amazon/venezia/mShop/AppstoreController;->getFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/appstore/AppstoreActivity;->fragment:Landroid/support/v4/app/Fragment;

    .line 176
    invoke-virtual {p0}, Lcom/amazon/mShop/appstore/AppstoreActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->appstore_root:I

    iget-object v2, p0, Lcom/amazon/mShop/appstore/AppstoreActivity;->fragment:Landroid/support/v4/app/Fragment;

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/app/FragmentTransaction;->replace(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 180
    :cond_0
    return-void
.end method


# virtual methods
.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 3
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v2, 0x0

    const/4 v0, 0x1

    .line 184
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 185
    iput-boolean v0, p0, Lcom/amazon/mShop/appstore/AppstoreActivity;->upKeyFromAppstore:Z

    .line 187
    :cond_0
    iget-boolean v1, p0, Lcom/amazon/mShop/appstore/AppstoreActivity;->upKeyFromAppstore:Z

    if-eqz v1, :cond_1

    sget-boolean v1, Lcom/amazon/mShop/search/SearchActivity;->downKeyFromSearch:Z

    if-eqz v1, :cond_1

    .line 188
    iput-boolean v2, p0, Lcom/amazon/mShop/appstore/AppstoreActivity;->upKeyFromAppstore:Z

    .line 189
    sput-boolean v2, Lcom/amazon/mShop/search/SearchActivity;->downKeyFromSearch:Z

    .line 192
    :goto_0
    return v0

    :cond_1
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public getAppstoreName()Ljava/lang/String;
    .locals 3

    .prologue
    .line 196
    invoke-virtual {p0}, Lcom/amazon/mShop/appstore/AppstoreActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->amazon_appstore_search_field:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 197
    .local v0, "appstoreName":Ljava/lang/String;
    return-object v0
.end method

.method public getCategoryMetadata()Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;
    .locals 4

    .prologue
    .line 207
    new-instance v0, Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;

    invoke-virtual {p0}, Lcom/amazon/mShop/appstore/AppstoreActivity;->getAppstoreName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/mShop/appstore/AppstoreActivity;->getSearchUrl()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "mobile-apps"

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public getCurrentDepartmentDepth()I
    .locals 1

    .prologue
    .line 212
    const/4 v0, 0x1

    return v0
.end method

.method public getSearchUrl()Ljava/lang/String;
    .locals 3

    .prologue
    .line 201
    invoke-virtual {p0}, Lcom/amazon/mShop/appstore/AppstoreActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->amazon_appstore_browse_node:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 202
    .local v0, "nodeId":Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "/s?node="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "&ref="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "mshop_appstore_sr"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public onAccountPreparationComplete()V
    .locals 2

    .prologue
    .line 154
    sget-object v0, Lcom/amazon/mShop/appstore/AppstoreActivity;->LOG:Lcom/amazon/logging/Logger;

    const-string/jumbo v1, "Account preparation complete"

    invoke-virtual {v0, v1}, Lcom/amazon/logging/Logger;->i(Ljava/lang/String;)V

    .line 155
    invoke-direct {p0}, Lcom/amazon/mShop/appstore/AppstoreActivity;->addFragmentIfNecessary()V

    .line 156
    return-void
.end method

.method public onAccountPreparationError(Lcom/amazon/mas/client/authentication/AuthenticationException;)V
    .locals 4
    .param p1, "authException"    # Lcom/amazon/mas/client/authentication/AuthenticationException;

    .prologue
    .line 160
    sget-object v2, Lcom/amazon/mShop/appstore/AppstoreActivity;->LOG:Lcom/amazon/logging/Logger;

    const-string/jumbo v3, "Account preparation error"

    invoke-virtual {v2, v3}, Lcom/amazon/logging/Logger;->i(Ljava/lang/String;)V

    .line 161
    invoke-virtual {p0}, Lcom/amazon/mShop/appstore/AppstoreActivity;->isFinishing()Z

    move-result v2

    if-nez v2, :cond_0

    .line 162
    invoke-virtual {p0}, Lcom/amazon/mShop/appstore/AppstoreActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 163
    .local v1, "fm":Landroid/support/v4/app/FragmentManager;
    const-string/jumbo v2, "AccountPerparationFailureDialogFragment"

    invoke-virtual {v1, v2}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v2

    if-nez v2, :cond_0

    .line 164
    iget-object v2, p0, Lcom/amazon/mShop/appstore/AppstoreActivity;->controller:Lcom/amazon/venezia/mShop/AppstoreController;

    invoke-virtual {v2, p1}, Lcom/amazon/venezia/mShop/AppstoreController;->getAccountPreparationFailureDialogFragment(Lcom/amazon/mas/client/authentication/AuthenticationException;)Landroid/support/v4/app/DialogFragment;

    move-result-object v0

    .line 165
    .local v0, "df":Landroid/support/v4/app/DialogFragment;
    const-string/jumbo v2, "AccountPerparationFailureDialogFragment"

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/app/DialogFragment;->show(Landroid/support/v4/app/FragmentManager;Ljava/lang/String;)V

    .line 168
    .end local v0    # "df":Landroid/support/v4/app/DialogFragment;
    .end local v1    # "fm":Landroid/support/v4/app/FragmentManager;
    :cond_0
    return-void
.end method

.method public onBackPressed()V
    .locals 1

    .prologue
    .line 123
    iget-object v0, p0, Lcom/amazon/mShop/appstore/AppstoreActivity;->controller:Lcom/amazon/venezia/mShop/AppstoreController;

    invoke-virtual {v0}, Lcom/amazon/venezia/mShop/AppstoreController;->handleBackPressed()Z

    move-result v0

    if-nez v0, :cond_0

    .line 124
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onBackPressed()V

    .line 126
    :cond_0
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v5, 0x0

    .line 55
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 56
    const-string/jumbo v2, "mShopLocalePrefs"

    invoke-virtual {p0, v2, v5}, Lcom/amazon/mShop/appstore/AppstoreActivity;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v1

    .line 57
    .local v1, "sp":Landroid/content/SharedPreferences;
    invoke-interface {v1}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    const-string/jumbo v3, "mShopLocaleValue"

    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocale()Ljava/util/Locale;

    move-result-object v4

    invoke-virtual {v4}, Ljava/util/Locale;->getCountry()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v2

    invoke-interface {v2}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 58
    new-instance v2, Lcom/amazon/mShop/appstore/SnuffyNoConnectionViewAdapterFactory;

    invoke-direct {v2}, Lcom/amazon/mShop/appstore/SnuffyNoConnectionViewAdapterFactory;-><init>()V

    invoke-static {v2}, Lcom/amazon/venezia/web/WebViewFragment;->setNoConnectionViewAdapterFactory(Lcom/amazon/venezia/web/NoConnectionViewAdapterFactory;)V

    .line 59
    invoke-static {}, Lcom/amazon/venezia/mShop/AppstoreController;->getFactory()Lcom/amazon/venezia/mShop/AppstoreController$Factory;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/mShop/appstore/AppstoreActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    invoke-interface {v2, v3, p0, p0}, Lcom/amazon/venezia/mShop/AppstoreController$Factory;->createController(Landroid/content/Intent;Landroid/content/Context;Lcom/amazon/venezia/auth/AccountPreparer$AccountPreparationCallbacks;)Lcom/amazon/venezia/mShop/AppstoreController;

    move-result-object v2

    iput-object v2, p0, Lcom/amazon/mShop/appstore/AppstoreActivity;->controller:Lcom/amazon/venezia/mShop/AppstoreController;

    .line 60
    iget-object v2, p0, Lcom/amazon/mShop/appstore/AppstoreActivity;->controller:Lcom/amazon/venezia/mShop/AppstoreController;

    invoke-virtual {v2}, Lcom/amazon/venezia/mShop/AppstoreController;->prepareAccountIfNeeded()Z

    .line 61
    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->appstore_activity:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/appstore/AppstoreActivity;->pushView(I)V

    .line 62
    new-instance v2, Lcom/amazon/mas/client/install/foreground/InstallKickoffReceiver;

    invoke-direct {v2}, Lcom/amazon/mas/client/install/foreground/InstallKickoffReceiver;-><init>()V

    iput-object v2, p0, Lcom/amazon/mShop/appstore/AppstoreActivity;->installReceiver:Lcom/amazon/mas/client/install/foreground/InstallKickoffReceiver;

    .line 64
    new-instance v2, Lcom/amazon/mas/bamberg/settings/notifications/NotificationSettings;

    invoke-direct {v2}, Lcom/amazon/mas/bamberg/settings/notifications/NotificationSettings;-><init>()V

    invoke-virtual {v2, v5}, Lcom/amazon/mas/bamberg/settings/notifications/NotificationSettings;->initNotificationSettings(Z)V

    .line 66
    invoke-virtual {p0}, Lcom/amazon/mShop/appstore/AppstoreActivity;->getIntent()Landroid/content/Intent;

    move-result-object v2

    const-string/jumbo v3, "com.amazon.venezia.mShop.ASIN"

    invoke-virtual {v2, v3}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 67
    .local v0, "asin":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 68
    invoke-static {p0, v0}, Lcom/amazon/mShop/util/ActivityUtils;->logViewHistory(Landroid/content/Context;Ljava/lang/String;)V

    .line 70
    :cond_0
    return-void
.end method

.method public onInsufficientInfoReceived(Landroid/content/Intent;)V
    .locals 2
    .param p1, "insufficientInfoIntent"    # Landroid/content/Intent;

    .prologue
    .line 137
    sget-object v0, Lcom/amazon/mShop/appstore/AppstoreActivity;->LOG:Lcom/amazon/logging/Logger;

    const-string/jumbo v1, "Insufficient account information"

    invoke-virtual {v0, v1}, Lcom/amazon/logging/Logger;->i(Ljava/lang/String;)V

    .line 138
    new-instance v0, Lcom/amazon/mShop/appstore/AppstoreActivity$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/appstore/AppstoreActivity$1;-><init>(Lcom/amazon/mShop/appstore/AppstoreActivity;)V

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/amazon/mShop/appstore/AppstoreActivity;->authenticateUser(Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;)V

    .line 150
    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 3
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 99
    iget-object v2, p0, Lcom/amazon/mShop/appstore/AppstoreActivity;->controller:Lcom/amazon/venezia/mShop/AppstoreController;

    invoke-virtual {v2, p1}, Lcom/amazon/venezia/mShop/AppstoreController;->canHandleIntent(Landroid/content/Intent;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 100
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0, p1}, Landroid/content/Intent;-><init>(Landroid/content/Intent;)V

    .line 101
    .local v0, "copyIntent":Landroid/content/Intent;
    invoke-virtual {v0}, Landroid/content/Intent;->getFlags()I

    move-result v1

    .line 103
    .local v1, "flags":I
    const v2, -0x20000001

    and-int/2addr v1, v2

    .line 107
    const v2, -0x4000001

    and-int/2addr v1, v2

    .line 109
    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 110
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/appstore/AppstoreActivity;->startActivity(Landroid/content/Intent;)V

    .line 118
    .end local v0    # "copyIntent":Landroid/content/Intent;
    .end local v1    # "flags":I
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/mShop/appstore/AppstoreActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/gno/GNODrawer;->close()V

    .line 119
    return-void

    .line 112
    :cond_0
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/appstore/AppstoreActivity;->setIntent(Landroid/content/Intent;)V

    .line 113
    iget-object v2, p0, Lcom/amazon/mShop/appstore/AppstoreActivity;->controller:Lcom/amazon/venezia/mShop/AppstoreController;

    invoke-virtual {v2, p1}, Lcom/amazon/venezia/mShop/AppstoreController;->handleNewIntent(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method protected onPause()V
    .locals 1

    .prologue
    .line 92
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onPause()V

    .line 93
    iget-object v0, p0, Lcom/amazon/mShop/appstore/AppstoreActivity;->controller:Lcom/amazon/venezia/mShop/AppstoreController;

    invoke-virtual {v0}, Lcom/amazon/venezia/mShop/AppstoreController;->cancelAccountPreparationIfNeeded()V

    .line 94
    iget-object v0, p0, Lcom/amazon/mShop/appstore/AppstoreActivity;->installReceiver:Lcom/amazon/mas/client/install/foreground/InstallKickoffReceiver;

    invoke-virtual {v0, p0}, Lcom/amazon/mas/client/install/foreground/InstallKickoffReceiver;->unregister(Landroid/content/Context;)V

    .line 95
    return-void
.end method

.method protected onResume()V
    .locals 2

    .prologue
    .line 74
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onResume()V

    .line 75
    iget-object v0, p0, Lcom/amazon/mShop/appstore/AppstoreActivity;->installReceiver:Lcom/amazon/mas/client/install/foreground/InstallKickoffReceiver;

    invoke-virtual {v0, p0}, Lcom/amazon/mas/client/install/foreground/InstallKickoffReceiver;->register(Landroid/content/Context;)V

    .line 76
    iget-object v0, p0, Lcom/amazon/mShop/appstore/AppstoreActivity;->installReceiver:Lcom/amazon/mas/client/install/foreground/InstallKickoffReceiver;

    invoke-virtual {v0, p0}, Lcom/amazon/mas/client/install/foreground/InstallKickoffReceiver;->nextInstall(Landroid/content/Context;)V

    .line 80
    invoke-virtual {p0}, Lcom/amazon/mShop/appstore/AppstoreActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v0

    const-string/jumbo v1, "mshop:appstore"

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/gno/GNODrawer;->focusOn(Ljava/lang/String;)Z

    .line 82
    iget-object v0, p0, Lcom/amazon/mShop/appstore/AppstoreActivity;->controller:Lcom/amazon/venezia/mShop/AppstoreController;

    invoke-virtual {v0}, Lcom/amazon/venezia/mShop/AppstoreController;->prepareAccountIfNeeded()Z

    move-result v0

    if-nez v0, :cond_0

    .line 83
    invoke-direct {p0}, Lcom/amazon/mShop/appstore/AppstoreActivity;->addFragmentIfNecessary()V

    .line 88
    :cond_0
    return-void
.end method

.method public pushTemporaryBlankView()V
    .locals 0

    .prologue
    .line 131
    return-void
.end method
