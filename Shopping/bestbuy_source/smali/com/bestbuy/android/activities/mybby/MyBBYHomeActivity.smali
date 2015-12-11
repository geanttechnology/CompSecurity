.class public Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;
.super Lcom/bestbuy/android/base/BBYBaseFragmentActivity;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/String;

.field private b:Lnb;

.field private c:Z

.field private d:Landroid/content/BroadcastReceiver;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 26
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;-><init>()V

    .line 31
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->c:Z

    .line 32
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->d:Landroid/content/BroadcastReceiver;

    return-void
.end method


# virtual methods
.method public onBackPressed()V
    .locals 5

    .prologue
    const v4, 0x7f040008

    const v3, 0x7f040005

    .line 94
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 95
    const v0, 0x7f0c0182

    invoke-virtual {v1, v0}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 96
    instance-of v2, v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    if-eqz v2, :cond_1

    .line 97
    check-cast v0, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    .line 98
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->b()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 99
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;->c()V

    .line 112
    :goto_0
    return-void

    .line 101
    :cond_0
    invoke-virtual {p0, v3, v4}, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->overridePendingTransition(II)V

    .line 102
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->finish()V

    goto :goto_0

    .line 105
    :cond_1
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v0

    const/4 v2, 0x1

    if-le v0, v2, :cond_2

    .line 106
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    goto :goto_0

    .line 108
    :cond_2
    invoke-virtual {p0, v3, v4}, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->overridePendingTransition(II)V

    .line 109
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->finish()V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 5

    .prologue
    .line 36
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 37
    const v0, 0x7f030101

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->setContentView(I)V

    .line 38
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->b:Lnb;

    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->b:Lnb;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lnb;->i(Z)V

    .line 40
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    const v2, -0xffc7a1

    invoke-direct {v1, v2}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 41
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setTitle(Ljava/lang/CharSequence;)V

    .line 43
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setDisplayShowHomeEnabled(Z)V

    .line 45
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 46
    if-eqz v0, :cond_0

    const-string v1, "FragmentName"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 47
    const-string v1, "FragmentName"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->a:Ljava/lang/String;

    .line 49
    :cond_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 50
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 51
    iget-object v1, p0, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->a:Ljava/lang/String;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->a:Ljava/lang/String;

    const-string v2, "MyBBYLoginFragment"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 52
    :cond_1
    new-instance v1, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;

    invoke-direct {v1}, Lcom/bestbuy/android/activities/mybby/CIALoginFragment;-><init>()V

    .line 53
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/ActionBar;->hide()V

    .line 54
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 55
    sget-object v3, Llu;->bo:Ljava/lang/String;

    const-string v4, "profile,login"

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 56
    sget-object v3, Llu;->bp:Ljava/lang/String;

    const-string v4, "GSI"

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 57
    sget-object v3, Llu;->v:Ljava/lang/String;

    invoke-static {v3, v2}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 58
    const v2, 0x7f0c0182

    const-string v3, "MyBBYLoginFragment"

    invoke-virtual {v0, v2, v1, v3}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 59
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 60
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 63
    :cond_2
    new-instance v0, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity$1;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity$1;-><init>(Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->d:Landroid/content/BroadcastReceiver;

    .line 69
    invoke-static {p0}, Landroid/support/v4/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->d:Landroid/content/BroadcastReceiver;

    new-instance v2, Landroid/content/IntentFilter;

    const-string v3, "loginOkay"

    invoke-direct {v2, v3}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v1, v2}, Landroid/support/v4/content/LocalBroadcastManager;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V

    .line 70
    return-void
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 154
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onDestroy()V

    .line 155
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->b:Lnb;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lnb;->i(Z)V

    .line 156
    invoke-static {p0}, Landroid/support/v4/content/LocalBroadcastManager;->getInstance(Landroid/content/Context;)Landroid/support/v4/content/LocalBroadcastManager;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->d:Landroid/content/BroadcastReceiver;

    invoke-virtual {v0, v1}, Landroid/support/v4/content/LocalBroadcastManager;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 157
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->isFinishing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 160
    :cond_0
    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 6

    .prologue
    const/4 v5, 0x1

    const v4, 0x7f080055

    .line 116
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onNewIntent(Landroid/content/Intent;)V

    .line 118
    const/4 v0, 0x0

    .line 119
    const-string v1, "com.bestbuy.android.NOTIFICATION"

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 120
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 121
    if-eqz v1, :cond_0

    const-string v2, "IS_CALLED_FROM_NOTIFICATION"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 122
    const-string v2, "IS_CALLED_FROM_NOTIFICATION"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    .line 123
    const-string v2, "TAB_NAME"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    .line 125
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 126
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 141
    :cond_0
    new-instance v1, Landroid/content/Intent;

    const-class v2, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-direct {v1, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 142
    const-string v2, "com.bestbuy.android.NOTIFICATION"

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 143
    const-string v2, "IS_CALLED_FROM_NOTIFICATION"

    invoke-virtual {v1, v2, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 144
    const-string v2, "TAB_NAME"

    const-string v3, "ProductTab"

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 145
    const/high16 v2, 0x10000000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 146
    const/high16 v2, 0x20000

    invoke-virtual {v1, v2}, Landroid/content/Intent;->addFlags(I)Landroid/content/Intent;

    .line 147
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 148
    const-string v0, "isDod"

    invoke-virtual {v1, v0, v5}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 149
    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->startActivity(Landroid/content/Intent;)V

    .line 150
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->finish()V

    .line 151
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 3

    .prologue
    const/4 v1, 0x1

    .line 175
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 193
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    :goto_0
    return v0

    .line 177
    :pswitch_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->getBackStackEntryCount()I

    move-result v0

    if-gt v0, v1, :cond_0

    .line 178
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v0

    goto :goto_0

    .line 180
    :cond_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const v2, 0x7f0c0182

    invoke-virtual {v0, v2}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 181
    instance-of v2, v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    if-eqz v2, :cond_2

    .line 182
    check-cast v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    .line 183
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->d()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 184
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->e()V

    :goto_1
    move v0, v1

    .line 190
    goto :goto_0

    .line 186
    :cond_1
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    goto :goto_1

    .line 188
    :cond_2
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->popBackStack()V

    goto :goto_1

    .line 175
    :pswitch_data_0
    .packed-switch 0x102002c
        :pswitch_0
    .end packed-switch
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 80
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onPause()V

    .line 81
    invoke-static {}, Llu;->a()V

    .line 82
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 74
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->onResume()V

    .line 75
    invoke-static {p0}, Llu;->a(Landroid/app/Activity;)V

    .line 76
    return-void
.end method

.method public onWindowFocusChanged(Z)V
    .locals 2

    .prologue
    .line 86
    if-eqz p1, :cond_0

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->c:Z

    if-nez v0, :cond_0

    .line 87
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->getApplication()Landroid/app/Application;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BBYApplication;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYApplication;->setLoginOkay(Z)V

    .line 89
    :cond_0
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;->c:Z

    .line 90
    return-void
.end method
