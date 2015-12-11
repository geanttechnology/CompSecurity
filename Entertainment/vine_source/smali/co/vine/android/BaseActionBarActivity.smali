.class public abstract Lco/vine/android/BaseActionBarActivity;
.super Landroid/support/v7/app/ActionBarActivity;
.source "BaseActionBarActivity.java"

# interfaces
.implements Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler$MenuStateListener;


# static fields
.field public static final COLOR_TRANSITION_DURATION:I = 0x64

.field public static final FINISH_BROADCAST_ACTION:Ljava/lang/String; = "co.vine.android.FINISH"

.field private static FINISH_INTENT_FILTER:Landroid/content/IntentFilter; = null

.field private static final TAG:Ljava/lang/String; = "BaseActionBarActivity"

.field private static mDebugMenuSecrets:[I


# instance fields
.field private mDebugMenu:I

.field private mFakeActionBar:Lco/vine/android/widget/FakeActionBar;

.field private final mFinishReceiver:Landroid/content/BroadcastReceiver;

.field protected mMenu:Landroid/view/Menu;

.field protected mProgressDialog:Landroid/app/ProgressDialog;

.field private mSlidingMenuHelper:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;

.field private mVineGreen:I


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 54
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    sput-object v0, Lco/vine/android/BaseActionBarActivity;->FINISH_INTENT_FILTER:Landroid/content/IntentFilter;

    .line 85
    sget-object v0, Lco/vine/android/BaseActionBarActivity;->FINISH_INTENT_FILTER:Landroid/content/IntentFilter;

    const-string v1, "co.vine.android.FINISH"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 203
    const/4 v0, 0x4

    new-array v0, v0, [I

    fill-array-data v0, :array_0

    sput-object v0, Lco/vine/android/BaseActionBarActivity;->mDebugMenuSecrets:[I

    return-void

    nop

    :array_0
    .array-data 4
        0x18
        0x19
        0x18
        0x19
    .end array-data
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 49
    invoke-direct {p0}, Landroid/support/v7/app/ActionBarActivity;-><init>()V

    .line 88
    new-instance v0, Lco/vine/android/BaseActionBarActivity$1;

    invoke-direct {v0, p0}, Lco/vine/android/BaseActionBarActivity$1;-><init>(Lco/vine/android/BaseActionBarActivity;)V

    iput-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mFinishReceiver:Landroid/content/BroadcastReceiver;

    .line 202
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/BaseActionBarActivity;->mDebugMenu:I

    return-void
.end method

.method private setupActionBarJBOnly(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V
    .locals 2
    .param p1, "setHomeButtonEnabled"    # Ljava/lang/Boolean;
    .param p2, "setDisplayShowTitleEnabled"    # Ljava/lang/Boolean;
    .param p3, "setDisplayHomeAsUpEnabled"    # Ljava/lang/Boolean;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xe
    .end annotation

    .prologue
    .line 363
    invoke-virtual {p0}, Lco/vine/android/BaseActionBarActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 364
    .local v0, "actionBar":Landroid/app/ActionBar;
    if-eqz v0, :cond_2

    .line 365
    if-eqz p1, :cond_0

    .line 366
    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setHomeButtonEnabled(Z)V

    .line 368
    :cond_0
    if-eqz p2, :cond_1

    .line 369
    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setDisplayShowTitleEnabled(Z)V

    .line 371
    :cond_1
    if-eqz p3, :cond_2

    .line 372
    invoke-virtual {p3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 375
    :cond_2
    return-void
.end method


# virtual methods
.method protected applyDefaultTitleViewStylingToFakeActionBar()V
    .locals 5

    .prologue
    .line 144
    invoke-virtual {p0}, Lco/vine/android/BaseActionBarActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 145
    .local v1, "res":Landroid/content/res/Resources;
    invoke-virtual {p0}, Lco/vine/android/BaseActionBarActivity;->getFakeActionBar()Lco/vine/android/widget/FakeActionBar;

    move-result-object v0

    .line 146
    .local v0, "fakeActionBar":Lco/vine/android/widget/FakeActionBar;
    invoke-virtual {v0}, Lco/vine/android/widget/FakeActionBar;->getTitleView()Landroid/widget/TextView;

    move-result-object v2

    const v3, 0x7f090061

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setTextColor(I)V

    .line 147
    invoke-virtual {v0}, Lco/vine/android/widget/FakeActionBar;->getTitleView()Landroid/widget/TextView;

    move-result-object v2

    invoke-static {p0}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v3

    iget-object v3, v3, Lco/vine/android/widget/Typefaces;->mediumContent:Landroid/graphics/Typeface;

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 148
    invoke-virtual {v0}, Lco/vine/android/widget/FakeActionBar;->getTitleView()Landroid/widget/TextView;

    move-result-object v2

    const/4 v3, 0x0

    const v4, 0x7f0b0046

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v4

    int-to-float v4, v4

    invoke-virtual {v2, v3, v4}, Landroid/widget/TextView;->setTextSize(IF)V

    .line 150
    return-void
.end method

.method protected createSlidingMenuHelper()Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;
    .locals 1

    .prologue
    .line 284
    new-instance v0, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;

    invoke-direct {v0, p0}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;-><init>(Landroid/app/Activity;)V

    return-object v0
.end method

.method protected dismissDialog()V
    .locals 1

    .prologue
    .line 512
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_0

    .line 513
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 514
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mProgressDialog:Landroid/app/ProgressDialog;

    .line 516
    :cond_0
    return-void
.end method

.method public findViewById(I)Landroid/view/View;
    .locals 2
    .param p1, "id"    # I

    .prologue
    .line 154
    invoke-super {p0, p1}, Landroid/support/v7/app/ActionBarActivity;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 155
    .local v0, "v":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 160
    .end local v0    # "v":Landroid/view/View;
    :goto_0
    return-object v0

    .line 157
    .restart local v0    # "v":Landroid/view/View;
    :cond_0
    iget-object v1, p0, Lco/vine/android/BaseActionBarActivity;->mSlidingMenuHelper:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;

    if-eqz v1, :cond_1

    .line 158
    iget-object v1, p0, Lco/vine/android/BaseActionBarActivity;->mSlidingMenuHelper:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;

    invoke-virtual {v1, p1}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->findViewById(I)Landroid/view/View;

    move-result-object v0

    goto :goto_0

    .line 160
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getFakeActionBar()Lco/vine/android/widget/FakeActionBar;
    .locals 1

    .prologue
    .line 470
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mFakeActionBar:Lco/vine/android/widget/FakeActionBar;

    return-object v0
.end method

.method public getSlidingMenu()Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;
    .locals 1

    .prologue
    .line 195
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mSlidingMenuHelper:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mSlidingMenuHelper:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;

    invoke-virtual {v0}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->getSlidingMenu()Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getSlidingMenuHelper()Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;
    .locals 1

    .prologue
    .line 199
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mSlidingMenuHelper:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;

    return-object v0
.end method

.method public isFakeActionBarEnabled()Z
    .locals 1

    .prologue
    .line 110
    const/4 v0, 0x0

    return v0
.end method

.method protected isSlidingMenuEnabled()Z
    .locals 1

    .prologue
    .line 519
    const/4 v0, 0x0

    return v0
.end method

.method public onBackPressed()V
    .locals 1

    .prologue
    .line 380
    :try_start_0
    invoke-super {p0}, Landroid/support/v7/app/ActionBarActivity;->onBackPressed()V
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    .line 384
    :goto_0
    return-void

    .line 381
    :catch_0
    move-exception v0

    .line 382
    .local v0, "e":Ljava/lang/IllegalStateException;
    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 115
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "If extending BaseActivity, please use multiple parameter version of this method."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public onCreate(Landroid/os/Bundle;IZZ)V
    .locals 7
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;
    .param p2, "layout"    # I
    .param p3, "loginRequired"    # Z
    .param p4, "readOnly"    # Z

    .prologue
    const/4 v1, 0x1

    .line 247
    :try_start_0
    invoke-super {p0, p1}, Landroid/support/v7/app/ActionBarActivity;->onCreate(Landroid/os/Bundle;)V
    :try_end_0
    .catch Landroid/util/AndroidRuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    .line 252
    :goto_0
    invoke-virtual {p0}, Lco/vine/android/BaseActionBarActivity;->isFakeActionBarEnabled()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 253
    new-instance v3, Lco/vine/android/widget/FakeActionBar;

    invoke-direct {v3, p0}, Lco/vine/android/widget/FakeActionBar;-><init>(Landroid/support/v7/app/ActionBarActivity;)V

    iput-object v3, p0, Lco/vine/android/BaseActionBarActivity;->mFakeActionBar:Lco/vine/android/widget/FakeActionBar;

    .line 254
    iget-object v3, p0, Lco/vine/android/BaseActionBarActivity;->mFakeActionBar:Lco/vine/android/widget/FakeActionBar;

    invoke-virtual {v3}, Lco/vine/android/widget/FakeActionBar;->onCreate()V

    .line 255
    invoke-virtual {p0, v1}, Lco/vine/android/BaseActionBarActivity;->requestWindowFeature(I)Z

    .line 258
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/BaseActionBarActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f090096

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getColor(I)I

    move-result v3

    iput v3, p0, Lco/vine/android/BaseActionBarActivity;->mVineGreen:I

    .line 260
    invoke-virtual {p0}, Lco/vine/android/BaseActionBarActivity;->isSlidingMenuEnabled()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 261
    const-string v3, "Sliding menu is enabled."

    invoke-static {v3}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;)V

    .line 262
    invoke-virtual {p0}, Lco/vine/android/BaseActionBarActivity;->createSlidingMenuHelper()Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;

    move-result-object v3

    iput-object v3, p0, Lco/vine/android/BaseActionBarActivity;->mSlidingMenuHelper:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;

    .line 263
    iget-object v3, p0, Lco/vine/android/BaseActionBarActivity;->mSlidingMenuHelper:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;

    invoke-virtual {v3, p1}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->onCreate(Landroid/os/Bundle;)V

    .line 264
    iget-object v3, p0, Lco/vine/android/BaseActionBarActivity;->mSlidingMenuHelper:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;

    invoke-virtual {v3, p0}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->setMenuStateListener(Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper$MenuStateHandler$MenuStateListener;)V

    .line 266
    :cond_1
    invoke-virtual {p0}, Lco/vine/android/BaseActionBarActivity;->preSetContentView()V

    .line 267
    invoke-virtual {p0, p2}, Lco/vine/android/BaseActionBarActivity;->setContentView(I)V

    .line 268
    invoke-virtual {p0}, Lco/vine/android/BaseActionBarActivity;->getParent()Landroid/app/Activity;

    move-result-object v2

    .line 270
    .local v2, "parent":Landroid/app/Activity;
    if-eqz p3, :cond_4

    invoke-static {p0, p4}, Lco/vine/android/client/VineAccountHelper;->isLoggedIn(Landroid/content/Context;Z)Z

    move-result v3

    if-nez v3, :cond_4

    .line 273
    .local v1, "needsToLogin":Z
    :goto_1
    if-eqz v1, :cond_2

    if-nez v2, :cond_2

    .line 274
    invoke-static {p0}, Lco/vine/android/StartActivity;->toStart(Landroid/content/Context;)V

    .line 277
    :cond_2
    invoke-static {p0}, Lco/vine/android/util/SystemUtil;->isViewServerEnabled(Landroid/content/Context;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 278
    invoke-static {p0}, Lcom/android/debug/hv/ViewServer;->get(Landroid/content/Context;)Lcom/android/debug/hv/ViewServer;

    move-result-object v3

    invoke-virtual {v3, p0}, Lcom/android/debug/hv/ViewServer;->addWindow(Landroid/app/Activity;)V

    .line 280
    :cond_3
    iget-object v3, p0, Lco/vine/android/BaseActionBarActivity;->mFinishReceiver:Landroid/content/BroadcastReceiver;

    sget-object v4, Lco/vine/android/BaseActionBarActivity;->FINISH_INTENT_FILTER:Landroid/content/IntentFilter;

    const-string v5, "co.vine.android.BROADCAST"

    const/4 v6, 0x0

    invoke-virtual {p0, v3, v4, v5, v6}, Lco/vine/android/BaseActionBarActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;

    .line 281
    return-void

    .line 248
    .end local v1    # "needsToLogin":Z
    .end local v2    # "parent":Landroid/app/Activity;
    :catch_0
    move-exception v0

    .line 249
    .local v0, "e":Landroid/util/AndroidRuntimeException;
    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    goto :goto_0

    .line 270
    .end local v0    # "e":Landroid/util/AndroidRuntimeException;
    .restart local v2    # "parent":Landroid/app/Activity;
    :cond_4
    const/4 v1, 0x0

    goto :goto_1
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 3
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    const/4 v2, 0x1

    .line 297
    const v0, 0x7f0a0240

    invoke-interface {p1, v0}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/BaseActionBarActivity;->updateMuteActionState(Landroid/view/MenuItem;)V

    .line 298
    iput-object p1, p0, Lco/vine/android/BaseActionBarActivity;->mMenu:Landroid/view/Menu;

    .line 299
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mFakeActionBar:Lco/vine/android/widget/FakeActionBar;

    if-eqz v0, :cond_0

    .line 300
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mFakeActionBar:Lco/vine/android/widget/FakeActionBar;

    iget-object v1, p0, Lco/vine/android/BaseActionBarActivity;->mMenu:Landroid/view/Menu;

    invoke-virtual {v0, v1, v2}, Lco/vine/android/widget/FakeActionBar;->onCreateOptionsMenu(Landroid/view/Menu;Z)V

    .line 302
    :cond_0
    return v2
.end method

.method public onCreatePanelMenu(ILandroid/view/Menu;)Z
    .locals 2
    .param p1, "featureId"    # I
    .param p2, "menu"    # Landroid/view/Menu;

    .prologue
    .line 72
    :try_start_0
    invoke-super {p0, p1, p2}, Landroid/support/v7/app/ActionBarActivity;->onCreatePanelMenu(ILandroid/view/Menu;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v1

    .line 76
    :goto_0
    return v1

    .line 73
    :catch_0
    move-exception v0

    .line 74
    .local v0, "e":Ljava/lang/Exception;
    invoke-static {v0}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    .line 76
    const/4 v1, 0x0

    goto :goto_0
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 345
    invoke-super {p0}, Landroid/support/v7/app/ActionBarActivity;->onDestroy()V

    .line 346
    invoke-static {p0}, Lco/vine/android/util/SystemUtil;->isViewServerEnabled(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 347
    invoke-static {p0}, Lcom/android/debug/hv/ViewServer;->get(Landroid/content/Context;)Lcom/android/debug/hv/ViewServer;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/android/debug/hv/ViewServer;->removeWindow(Landroid/app/Activity;)V

    .line 349
    :cond_0
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mFinishReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v0}, Lco/vine/android/BaseActionBarActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 350
    return-void
.end method

.method public onKeyUp(ILandroid/view/KeyEvent;)Z
    .locals 3
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    .line 212
    iget-object v1, p0, Lco/vine/android/BaseActionBarActivity;->mSlidingMenuHelper:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;

    if-eqz v1, :cond_0

    .line 213
    iget-object v1, p0, Lco/vine/android/BaseActionBarActivity;->mSlidingMenuHelper:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;

    invoke-virtual {v1, p1, p2}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->onKeyUp(ILandroid/view/KeyEvent;)Z

    move-result v0

    .line 214
    .local v0, "b":Z
    if-eqz v0, :cond_0

    const/4 v1, 0x1

    .line 224
    .end local v0    # "b":Z
    :goto_0
    return v1

    .line 216
    :cond_0
    sget-boolean v1, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v1, :cond_1

    .line 217
    iget v1, p0, Lco/vine/android/BaseActionBarActivity;->mDebugMenu:I

    sget-object v2, Lco/vine/android/BaseActionBarActivity;->mDebugMenuSecrets:[I

    array-length v2, v2

    if-ge v1, v2, :cond_1

    sget-object v1, Lco/vine/android/BaseActionBarActivity;->mDebugMenuSecrets:[I

    iget v2, p0, Lco/vine/android/BaseActionBarActivity;->mDebugMenu:I

    aget v1, v1, v2

    if-ne p1, v1, :cond_1

    .line 218
    iget v1, p0, Lco/vine/android/BaseActionBarActivity;->mDebugMenu:I

    add-int/lit8 v1, v1, 0x1

    iput v1, p0, Lco/vine/android/BaseActionBarActivity;->mDebugMenu:I

    .line 219
    iget v1, p0, Lco/vine/android/BaseActionBarActivity;->mDebugMenu:I

    sget-object v2, Lco/vine/android/BaseActionBarActivity;->mDebugMenuSecrets:[I

    array-length v2, v2

    if-ne v1, v2, :cond_1

    .line 220
    new-instance v1, Landroid/content/Intent;

    const-string v2, "co.vine.android.debug_receiver"

    invoke-direct {v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    invoke-virtual {p0, v1}, Lco/vine/android/BaseActionBarActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 224
    :cond_1
    invoke-super {p0, p1, p2}, Landroid/support/v7/app/ActionBarActivity;->onKeyUp(ILandroid/view/KeyEvent;)Z

    move-result v1

    goto :goto_0
.end method

.method public onMenuClick(Landroid/view/View;)V
    .locals 0
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 550
    return-void
.end method

.method public onMenuClose()V
    .locals 0

    .prologue
    .line 535
    return-void
.end method

.method public onMenuClosed()V
    .locals 0

    .prologue
    .line 530
    return-void
.end method

.method public onMenuDrag(Landroid/view/View;Landroid/view/DragEvent;)Z
    .locals 1
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/DragEvent;

    .prologue
    .line 524
    const/4 v0, 0x0

    return v0
.end method

.method public onMenuOpen()V
    .locals 0

    .prologue
    .line 545
    return-void
.end method

.method public onMenuOpened()V
    .locals 0

    .prologue
    .line 540
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    const/4 v1, 0x1

    .line 441
    invoke-interface {p1}, Landroid/view/MenuItem;->getItemId()I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    .line 464
    invoke-super {p0, p1}, Landroid/support/v7/app/ActionBarActivity;->onOptionsItemSelected(Landroid/view/MenuItem;)Z

    move-result v1

    :goto_0
    return v1

    .line 443
    :sswitch_0
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mSlidingMenuHelper:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;

    if-eqz v0, :cond_0

    .line 444
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mSlidingMenuHelper:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;

    invoke-virtual {v0}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->toggle()V

    goto :goto_0

    .line 447
    :cond_0
    :try_start_0
    invoke-super {p0}, Landroid/support/v7/app/ActionBarActivity;->onBackPressed()V
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 448
    :catch_0
    move-exception v0

    goto :goto_0

    .line 455
    :sswitch_1
    invoke-static {}, Lco/vine/android/AppImpl;->getInstance()Lco/vine/android/AppImpl;

    move-result-object v0

    invoke-virtual {v0, p0}, Lco/vine/android/AppImpl;->startCapture(Landroid/app/Activity;)V

    goto :goto_0

    .line 459
    :sswitch_2
    invoke-static {p0}, Lco/vine/android/util/MuteUtil;->isMuted(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_1

    move v0, v1

    :goto_1
    invoke-static {p0, v0}, Lco/vine/android/util/MuteUtil;->setMuted(Landroid/content/Context;Z)V

    .line 460
    invoke-virtual {p0, p1}, Lco/vine/android/BaseActionBarActivity;->updateMuteActionState(Landroid/view/MenuItem;)V

    goto :goto_0

    .line 459
    :cond_1
    const/4 v0, 0x0

    goto :goto_1

    .line 441
    nop

    :sswitch_data_0
    .sparse-switch
        0x102002c -> :sswitch_0
        0x7f0a023c -> :sswitch_1
        0x7f0a0240 -> :sswitch_2
    .end sparse-switch
.end method

.method protected onPause()V
    .locals 0

    .prologue
    .line 330
    invoke-super {p0}, Landroid/support/v7/app/ActionBarActivity;->onPause()V

    .line 331
    invoke-virtual {p0}, Lco/vine/android/BaseActionBarActivity;->dismissDialog()V

    .line 332
    return-void
.end method

.method public onPostCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 133
    invoke-super {p0, p1}, Landroid/support/v7/app/ActionBarActivity;->onPostCreate(Landroid/os/Bundle;)V

    .line 134
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mFakeActionBar:Lco/vine/android/widget/FakeActionBar;

    if-eqz v0, :cond_0

    .line 135
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mFakeActionBar:Lco/vine/android/widget/FakeActionBar;

    invoke-virtual {v0, p1}, Lco/vine/android/widget/FakeActionBar;->onPostCreate(Landroid/os/Bundle;)V

    .line 136
    invoke-virtual {p0}, Lco/vine/android/BaseActionBarActivity;->applyDefaultTitleViewStylingToFakeActionBar()V

    .line 138
    :cond_0
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mSlidingMenuHelper:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;

    if-eqz v0, :cond_1

    .line 139
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mSlidingMenuHelper:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;

    invoke-virtual {v0, p1}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->onPostCreate(Landroid/os/Bundle;)V

    .line 141
    :cond_1
    return-void
.end method

.method public onPrepareOptionsMenu(Landroid/view/Menu;)Z
    .locals 2
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 336
    invoke-super {p0, p1}, Landroid/support/v7/app/ActionBarActivity;->onPrepareOptionsMenu(Landroid/view/Menu;)Z

    move-result v0

    .line 337
    .local v0, "r":Z
    iget-object v1, p0, Lco/vine/android/BaseActionBarActivity;->mFakeActionBar:Lco/vine/android/widget/FakeActionBar;

    if-eqz v1, :cond_0

    .line 338
    iget-object v1, p0, Lco/vine/android/BaseActionBarActivity;->mFakeActionBar:Lco/vine/android/widget/FakeActionBar;

    invoke-virtual {v1, p1, v0}, Lco/vine/android/widget/FakeActionBar;->onPrepareOptionsMenu(Landroid/view/Menu;Z)V

    .line 340
    :cond_0
    return v0
.end method

.method protected onResume()V
    .locals 4

    .prologue
    .line 307
    invoke-super {p0}, Landroid/support/v7/app/ActionBarActivity;->onResume()V

    .line 308
    invoke-virtual {p0}, Lco/vine/android/BaseActionBarActivity;->getSlidingMenu()Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    move-result-object v0

    if-eqz v0, :cond_3

    invoke-virtual {p0}, Lco/vine/android/BaseActionBarActivity;->getSlidingMenu()Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;

    move-result-object v0

    invoke-virtual {v0}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingMenu;->isMenuShowing()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 309
    new-instance v0, Landroid/content/Intent;

    sget-object v1, Lco/vine/android/util/MuteUtil;->ACTION_CHANGED_TO_MUTE:Ljava/lang/String;

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-string v1, "co.vine.android.BROADCAST"

    invoke-virtual {p0, v0, v1}, Lco/vine/android/BaseActionBarActivity;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    .line 315
    :cond_0
    :goto_0
    const-string v0, "Activity"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " - "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lco/vine/android/util/CrashUtil;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 317
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isLogsOn()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 318
    invoke-static {p0}, Lco/vine/android/util/SystemUtil;->isViewServerEnabled(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 319
    invoke-static {p0}, Lcom/android/debug/hv/ViewServer;->get(Landroid/content/Context;)Lcom/android/debug/hv/ViewServer;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/android/debug/hv/ViewServer;->setFocusedWindow(Landroid/app/Activity;)V

    .line 322
    :cond_1
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mMenu:Landroid/view/Menu;

    if-eqz v0, :cond_2

    .line 323
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mMenu:Landroid/view/Menu;

    const v1, 0x7f0a0240

    invoke-interface {v0, v1}, Landroid/view/Menu;->findItem(I)Landroid/view/MenuItem;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/BaseActionBarActivity;->updateMuteActionState(Landroid/view/MenuItem;)V

    .line 325
    :cond_2
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mFinishReceiver:Landroid/content/BroadcastReceiver;

    sget-object v1, Lco/vine/android/BaseActionBarActivity;->FINISH_INTENT_FILTER:Landroid/content/IntentFilter;

    const-string v2, "co.vine.android.BROADCAST"

    const/4 v3, 0x0

    invoke-virtual {p0, v0, v1, v2, v3}, Lco/vine/android/BaseActionBarActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;Ljava/lang/String;Landroid/os/Handler;)Landroid/content/Intent;

    .line 326
    return-void

    .line 311
    :cond_3
    invoke-static {p0}, Lco/vine/android/util/MuteUtil;->isMuted(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 312
    new-instance v0, Landroid/content/Intent;

    sget-object v1, Lco/vine/android/util/MuteUtil;->ACTION_CHANGED_TO_UNMUTE:Ljava/lang/String;

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    const-string v1, "co.vine.android.BROADCAST"

    invoke-virtual {p0, v0, v1}, Lco/vine/android/BaseActionBarActivity;->sendBroadcast(Landroid/content/Intent;Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 289
    invoke-super {p0, p1}, Landroid/support/v7/app/ActionBarActivity;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 290
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mSlidingMenuHelper:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;

    if-eqz v0, :cond_0

    .line 291
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mSlidingMenuHelper:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;

    invoke-virtual {v0, p1}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 293
    :cond_0
    return-void
.end method

.method protected onStart()V
    .locals 0

    .prologue
    .line 99
    invoke-super {p0}, Landroid/support/v7/app/ActionBarActivity;->onStart()V

    .line 100
    invoke-static {p0}, Lco/vine/android/util/FlurryUtils;->start(Landroid/content/Context;)V

    .line 101
    return-void
.end method

.method protected onStop()V
    .locals 0

    .prologue
    .line 105
    invoke-super {p0}, Landroid/support/v7/app/ActionBarActivity;->onStop()V

    .line 106
    invoke-static {p0}, Lco/vine/android/util/FlurryUtils;->stop(Landroid/content/Context;)V

    .line 107
    return-void
.end method

.method public preSetContentView()V
    .locals 0

    .prologue
    .line 129
    return-void
.end method

.method protected restoreActivityState()V
    .locals 3

    .prologue
    .line 123
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isLogsOn()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 124
    const-string v0, "BaseActionBarActivity"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Restoring activity "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 126
    :cond_0
    return-void
.end method

.method public setActionBarColor()V
    .locals 1

    .prologue
    .line 508
    iget v0, p0, Lco/vine/android/BaseActionBarActivity;->mVineGreen:I

    invoke-virtual {p0, v0}, Lco/vine/android/BaseActionBarActivity;->setActionBarColor(I)V

    .line 509
    return-void
.end method

.method public setActionBarColor(I)V
    .locals 4
    .param p1, "profileBackground"    # I

    .prologue
    const/high16 v3, -0x1000000

    .line 483
    if-eqz p1, :cond_4

    .line 484
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mFakeActionBar:Lco/vine/android/widget/FakeActionBar;

    if-eqz v0, :cond_2

    .line 485
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mFakeActionBar:Lco/vine/android/widget/FakeActionBar;

    or-int v1, p1, v3

    invoke-virtual {v0, v1}, Lco/vine/android/widget/FakeActionBar;->setActionBarColor(I)V

    .line 486
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mFakeActionBar:Lco/vine/android/widget/FakeActionBar;

    invoke-virtual {v0}, Lco/vine/android/widget/FakeActionBar;->getActionBar()Landroid/widget/RelativeLayout;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->invalidate()V

    .line 491
    :goto_0
    instance-of v0, p0, Lco/vine/android/HomeTabActivity;

    if-eqz v0, :cond_1

    .line 492
    sget v0, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    if-eq p1, v0, :cond_0

    if-lez p1, :cond_0

    sget v0, Lco/vine/android/Settings;->DEFAULT_PROFILE_COLOR:I

    or-int/2addr v0, v3

    if-ne p1, v0, :cond_3

    :cond_0
    move-object v0, p0

    .line 494
    check-cast v0, Lco/vine/android/HomeTabActivity;

    invoke-virtual {p0}, Lco/vine/android/BaseActionBarActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f090096

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lco/vine/android/HomeTabActivity;->setProfileColor(I)V

    .line 504
    :cond_1
    :goto_1
    invoke-virtual {p0}, Lco/vine/android/BaseActionBarActivity;->invalidateOptionsMenu()V

    .line 505
    return-void

    .line 488
    :cond_2
    invoke-virtual {p0}, Lco/vine/android/BaseActionBarActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    or-int v2, p1, v3

    invoke-direct {v1, v2}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v0, v1}, Landroid/support/v7/app/ActionBar;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    :cond_3
    move-object v0, p0

    .line 496
    check-cast v0, Lco/vine/android/HomeTabActivity;

    or-int v1, p1, v3

    invoke-virtual {v0, v1}, Lco/vine/android/HomeTabActivity;->setProfileColor(I)V

    goto :goto_1

    .line 500
    :cond_4
    iget v0, p0, Lco/vine/android/BaseActionBarActivity;->mVineGreen:I

    if-eqz v0, :cond_1

    .line 501
    iget v0, p0, Lco/vine/android/BaseActionBarActivity;->mVineGreen:I

    invoke-virtual {p0, v0}, Lco/vine/android/BaseActionBarActivity;->setActionBarColor(I)V

    goto :goto_1
.end method

.method public setActionBarTransition(Landroid/graphics/drawable/TransitionDrawable;)V
    .locals 1
    .param p1, "td"    # Landroid/graphics/drawable/TransitionDrawable;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    .line 474
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mFakeActionBar:Lco/vine/android/widget/FakeActionBar;

    if-eqz v0, :cond_0

    .line 475
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mFakeActionBar:Lco/vine/android/widget/FakeActionBar;

    invoke-virtual {v0, p1}, Lco/vine/android/widget/FakeActionBar;->setActionBarTransition(Landroid/graphics/drawable/TransitionDrawable;)V

    .line 479
    :goto_0
    const/16 v0, 0x64

    invoke-virtual {p1, v0}, Landroid/graphics/drawable/TransitionDrawable;->startTransition(I)V

    .line 480
    return-void

    .line 477
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/BaseActionBarActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/support/v7/app/ActionBar;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0
.end method

.method public setBehindContentView(I)Landroid/view/View;
    .locals 3
    .param p1, "id"    # I

    .prologue
    .line 239
    invoke-virtual {p0}, Lco/vine/android/BaseActionBarActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, p1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 240
    .local v0, "backView":Landroid/view/View;
    invoke-virtual {p0, v0}, Lco/vine/android/BaseActionBarActivity;->setBehindContentView(Landroid/view/View;)Landroid/view/View;

    .line 241
    return-object v0
.end method

.method public setBehindContentView(Landroid/view/View;)Landroid/view/View;
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v1, -0x1

    .line 229
    new-instance v0, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v0, v1, v1}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {p0, p1, v0}, Lco/vine/android/BaseActionBarActivity;->setBehindContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)Landroid/view/View;

    .line 230
    return-object p1
.end method

.method public setBehindContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)Landroid/view/View;
    .locals 1
    .param p1, "v"    # Landroid/view/View;
    .param p2, "params"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 234
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mSlidingMenuHelper:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;

    invoke-virtual {v0, p1, p2}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->setBehindContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 235
    return-object p1
.end method

.method public setContentView(I)V
    .locals 2
    .param p1, "layoutResID"    # I

    .prologue
    .line 166
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mSlidingMenuHelper:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;

    if-nez v0, :cond_0

    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mFakeActionBar:Lco/vine/android/widget/FakeActionBar;

    if-eqz v0, :cond_1

    .line 167
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/BaseActionBarActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    invoke-virtual {p0, v0}, Lco/vine/android/BaseActionBarActivity;->setContentView(Landroid/view/View;)V

    .line 171
    :goto_0
    return-void

    .line 169
    :cond_1
    invoke-super {p0, p1}, Landroid/support/v7/app/ActionBarActivity;->setContentView(I)V

    goto :goto_0
.end method

.method public setContentView(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v1, -0x1

    .line 175
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mSlidingMenuHelper:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;

    if-nez v0, :cond_0

    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mFakeActionBar:Lco/vine/android/widget/FakeActionBar;

    if-eqz v0, :cond_1

    .line 176
    :cond_0
    new-instance v0, Landroid/view/ViewGroup$LayoutParams;

    invoke-direct {v0, v1, v1}, Landroid/view/ViewGroup$LayoutParams;-><init>(II)V

    invoke-virtual {p0, p1, v0}, Lco/vine/android/BaseActionBarActivity;->setContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 180
    :goto_0
    return-void

    .line 178
    :cond_1
    invoke-super {p0, p1}, Landroid/support/v7/app/ActionBarActivity;->setContentView(Landroid/view/View;)V

    goto :goto_0
.end method

.method public setContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;
    .param p2, "params"    # Landroid/view/ViewGroup$LayoutParams;

    .prologue
    .line 184
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mFakeActionBar:Lco/vine/android/widget/FakeActionBar;

    if-eqz v0, :cond_0

    .line 185
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mFakeActionBar:Lco/vine/android/widget/FakeActionBar;

    invoke-virtual {v0, p1, p2}, Lco/vine/android/widget/FakeActionBar;->setContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 186
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mFakeActionBar:Lco/vine/android/widget/FakeActionBar;

    invoke-virtual {v0}, Lco/vine/android/widget/FakeActionBar;->getRoot()Landroid/widget/RelativeLayout;

    move-result-object p1

    .line 188
    :cond_0
    invoke-super {p0, p1, p2}, Landroid/support/v7/app/ActionBarActivity;->setContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 189
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mSlidingMenuHelper:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;

    if-eqz v0, :cond_1

    .line 190
    iget-object v0, p0, Lco/vine/android/BaseActionBarActivity;->mSlidingMenuHelper:Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;

    invoke-virtual {v0, p1, p2}, Lcom/jeremyfeinstein/slidingmenu/lib/SlidingActivityHelper;->registerAboveContentView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 192
    :cond_1
    return-void
.end method

.method protected setupActionBar(Ljava/lang/Boolean;Ljava/lang/Boolean;ILjava/lang/Boolean;)V
    .locals 1
    .param p1, "setHomeButtonEnabled"    # Ljava/lang/Boolean;
    .param p2, "setDisplayShowTitleEnabled"    # Ljava/lang/Boolean;
    .param p3, "titleRes"    # I
    .param p4, "setDisplayHomeAsUpEnabled"    # Ljava/lang/Boolean;

    .prologue
    .line 396
    if-lez p3, :cond_0

    invoke-virtual {p0, p3}, Lco/vine/android/BaseActionBarActivity;->getString(I)Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-virtual {p0, p1, p2, v0, p4}, Lco/vine/android/BaseActionBarActivity;->setupActionBar(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 397
    return-void

    .line 396
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected setupActionBar(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)V
    .locals 3
    .param p1, "setHomeButtonEnabled"    # Ljava/lang/Boolean;
    .param p2, "setDisplayShowTitleEnabled"    # Ljava/lang/Boolean;
    .param p3, "title"    # Ljava/lang/String;
    .param p4, "setDisplayHomeAsUpEnabled"    # Ljava/lang/Boolean;

    .prologue
    .line 402
    iget-object v1, p0, Lco/vine/android/BaseActionBarActivity;->mFakeActionBar:Lco/vine/android/widget/FakeActionBar;

    if-eqz v1, :cond_4

    .line 403
    if-eqz p1, :cond_0

    .line 404
    iget-object v1, p0, Lco/vine/android/BaseActionBarActivity;->mFakeActionBar:Lco/vine/android/widget/FakeActionBar;

    invoke-virtual {v1, p1}, Lco/vine/android/widget/FakeActionBar;->setHomeButtonEnabled(Ljava/lang/Boolean;)V

    .line 406
    :cond_0
    if-eqz p2, :cond_1

    .line 407
    iget-object v1, p0, Lco/vine/android/BaseActionBarActivity;->mFakeActionBar:Lco/vine/android/widget/FakeActionBar;

    invoke-virtual {v1, p2}, Lco/vine/android/widget/FakeActionBar;->setDisplayShowTitleEnabled(Ljava/lang/Boolean;)V

    .line 409
    :cond_1
    if-eqz p4, :cond_2

    .line 410
    iget-object v1, p0, Lco/vine/android/BaseActionBarActivity;->mFakeActionBar:Lco/vine/android/widget/FakeActionBar;

    invoke-virtual {v1, p4}, Lco/vine/android/widget/FakeActionBar;->setDisplayHomeAsUpEnabled(Ljava/lang/Boolean;)V

    .line 412
    :cond_2
    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 413
    iget-object v1, p0, Lco/vine/android/BaseActionBarActivity;->mFakeActionBar:Lco/vine/android/widget/FakeActionBar;

    invoke-virtual {v1, p3}, Lco/vine/android/widget/FakeActionBar;->setTitle(Ljava/lang/String;)V

    .line 437
    :cond_3
    :goto_0
    return-void

    .line 416
    :cond_4
    invoke-virtual {p0}, Lco/vine/android/BaseActionBarActivity;->getSupportActionBar()Landroid/support/v7/app/ActionBar;

    move-result-object v0

    .line 417
    .local v0, "ab":Landroid/support/v7/app/ActionBar;
    if-eqz v0, :cond_8

    .line 418
    if-eqz p1, :cond_5

    .line 419
    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/support/v7/app/ActionBar;->setHomeButtonEnabled(Z)V

    .line 421
    :cond_5
    if-eqz p2, :cond_6

    .line 422
    invoke-virtual {p2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/support/v7/app/ActionBar;->setDisplayShowTitleEnabled(Z)V

    .line 424
    :cond_6
    if-eqz p4, :cond_7

    .line 425
    invoke-virtual {p4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    invoke-virtual {v0, v1}, Landroid/support/v7/app/ActionBar;->setDisplayHomeAsUpEnabled(Z)V

    .line 427
    :cond_7
    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_8

    .line 428
    invoke-virtual {v0, p3}, Landroid/support/v7/app/ActionBar;->setTitle(Ljava/lang/CharSequence;)V

    .line 432
    :cond_8
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xe

    if-lt v1, v2, :cond_3

    .line 433
    invoke-direct {p0, p1, p2, p4}, Lco/vine/android/BaseActionBarActivity;->setupActionBarJBOnly(Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;)V

    goto :goto_0
.end method

.method public updateMuteActionState(Landroid/view/MenuItem;)V
    .locals 3
    .param p1, "menu"    # Landroid/view/MenuItem;

    .prologue
    .line 353
    if-eqz p1, :cond_0

    .line 354
    invoke-static {p0}, Lco/vine/android/util/MuteUtil;->isMuted(Landroid/content/Context;)Z

    move-result v0

    .line 355
    .local v0, "isMuted":Z
    const-string v1, "Is muted? {}"

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 356
    if-eqz v0, :cond_1

    const v1, 0x7f0e0254

    :goto_0
    invoke-interface {p1, v1}, Landroid/view/MenuItem;->setTitle(I)Landroid/view/MenuItem;

    .line 358
    .end local v0    # "isMuted":Z
    :cond_0
    return-void

    .line 356
    .restart local v0    # "isMuted":Z
    :cond_1
    const v1, 0x7f0e0148

    goto :goto_0
.end method
