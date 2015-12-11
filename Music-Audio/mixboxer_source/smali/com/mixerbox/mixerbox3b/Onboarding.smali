.class public Lcom/mixerbox/mixerbox3b/Onboarding;
.super Landroid/support/v4/app/FragmentActivity;
.source "SourceFile"


# annotations
.annotation build Lcom/newrelic/agent/android/instrumentation/Instrumented;
.end annotation


# instance fields
.field bundle:Landroid/os/Bundle;

.field fm:Landroid/support/v4/app/FragmentManager;

.field public hasInit:Z

.field public ivS1:Landroid/widget/ImageView;

.field public ivS2:Landroid/widget/ImageView;

.field public ivS3:Landroid/widget/ImageView;

.field private mAdapter:Lcom/mixerbox/mixerbox3b/Onboarding$MyFragmentPageAdapter;

.field mHandler:Lcom/mixerbox/mixerbox3b/Onboarding$MyHandler;

.field private mViewPager:Landroid/support/v4/view/ViewPager;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Landroid/support/v4/app/FragmentActivity;-><init>()V

    .line 298
    return-void
.end method


# virtual methods
.method public goToMainPage()V
    .locals 3

    .prologue
    const/4 v1, 0x1

    .line 237
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding;->mHandler:Lcom/mixerbox/mixerbox3b/Onboarding$MyHandler;

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/Onboarding$MyHandler;->removeMessages(I)V

    .line 238
    sput-boolean v1, Lcom/mixerbox/mixerbox3b/utils/MixerBoxConstants;->shouldOnCreate:Z

    .line 239
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding;->bundle:Landroid/os/Bundle;

    const-string v1, "isLogIn"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 240
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 241
    const-class v1, Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0, p0, v1}, Landroid/content/Intent;->setClass(Landroid/content/Context;Ljava/lang/Class;)Landroid/content/Intent;

    .line 242
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/Onboarding;->bundle:Landroid/os/Bundle;

    invoke-virtual {v0, v1}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 243
    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/Onboarding;->startActivity(Landroid/content/Intent;)V

    .line 244
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/Onboarding;->finish()V

    .line 245
    return-void
.end method

.method public initAnim()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 227
    iput-boolean v3, p0, Lcom/mixerbox/mixerbox3b/Onboarding;->hasInit:Z

    .line 229
    const v0, 0x7f070076

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/Onboarding;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding;->ivS1:Landroid/widget/ImageView;

    .line 230
    const v0, 0x7f070078

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/Onboarding;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding;->ivS2:Landroid/widget/ImageView;

    .line 231
    const v0, 0x7f07007a

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/Onboarding;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding;->ivS3:Landroid/widget/ImageView;

    .line 233
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding;->mHandler:Lcom/mixerbox/mixerbox3b/Onboarding$MyHandler;

    const-wide/16 v1, 0x12c

    invoke-virtual {v0, v3, v1, v2}, Lcom/mixerbox/mixerbox3b/Onboarding$MyHandler;->sendEmptyMessageDelayed(IJ)Z

    .line 234
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 44
    invoke-super {p0, p1}, Landroid/support/v4/app/FragmentActivity;->onCreate(Landroid/os/Bundle;)V

    .line 45
    const v0, 0x7f030044

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/Onboarding;->setContentView(I)V

    .line 47
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding;->hasInit:Z

    .line 49
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/Onboarding;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 50
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/Onboarding;->getIntent()Landroid/content/Intent;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding;->bundle:Landroid/os/Bundle;

    .line 54
    :goto_0
    const v0, 0x7f0700f1

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/Onboarding;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v4/view/ViewPager;

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding;->mViewPager:Landroid/support/v4/view/ViewPager;

    .line 55
    const v0, 0x7f0700f2

    invoke-virtual {p0, v0}, Lcom/mixerbox/mixerbox3b/Onboarding;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 56
    const v1, 0x7f0700f0

    invoke-virtual {p0, v1}, Lcom/mixerbox/mixerbox3b/Onboarding;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 58
    new-instance v2, Lcom/mixerbox/mixerbox3b/Onboarding$MyHandler;

    invoke-direct {v2, p0}, Lcom/mixerbox/mixerbox3b/Onboarding$MyHandler;-><init>(Lcom/mixerbox/mixerbox3b/Onboarding;)V

    iput-object v2, p0, Lcom/mixerbox/mixerbox3b/Onboarding;->mHandler:Lcom/mixerbox/mixerbox3b/Onboarding$MyHandler;

    .line 60
    invoke-virtual {p0}, Lcom/mixerbox/mixerbox3b/Onboarding;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v2

    iput-object v2, p0, Lcom/mixerbox/mixerbox3b/Onboarding;->fm:Landroid/support/v4/app/FragmentManager;

    .line 61
    new-instance v2, Lcom/mixerbox/mixerbox3b/Onboarding$MyFragmentPageAdapter;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/Onboarding;->fm:Landroid/support/v4/app/FragmentManager;

    invoke-direct {v2, p0, v3}, Lcom/mixerbox/mixerbox3b/Onboarding$MyFragmentPageAdapter;-><init>(Lcom/mixerbox/mixerbox3b/Onboarding;Landroid/support/v4/app/FragmentManager;)V

    iput-object v2, p0, Lcom/mixerbox/mixerbox3b/Onboarding;->mAdapter:Lcom/mixerbox/mixerbox3b/Onboarding$MyFragmentPageAdapter;

    .line 62
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/Onboarding;->mViewPager:Landroid/support/v4/view/ViewPager;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/Onboarding;->mAdapter:Lcom/mixerbox/mixerbox3b/Onboarding$MyFragmentPageAdapter;

    invoke-virtual {v2, v3}, Landroid/support/v4/view/ViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 64
    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/Onboarding;->mViewPager:Landroid/support/v4/view/ViewPager;

    new-instance v3, Lcom/mixerbox/mixerbox3b/Onboarding$1;

    invoke-direct {v3, p0, v0, v1}, Lcom/mixerbox/mixerbox3b/Onboarding$1;-><init>(Lcom/mixerbox/mixerbox3b/Onboarding;Landroid/widget/TextView;Landroid/widget/ImageView;)V

    invoke-virtual {v2, v3}, Landroid/support/v4/view/ViewPager;->setOnPageChangeListener(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)V

    .line 216
    new-instance v1, Lcom/mixerbox/mixerbox3b/Onboarding$2;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/Onboarding$2;-><init>(Lcom/mixerbox/mixerbox3b/Onboarding;)V

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 224
    return-void

    .line 52
    :cond_0
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding;->bundle:Landroid/os/Bundle;

    goto :goto_0
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 286
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding;->mHandler:Lcom/mixerbox/mixerbox3b/Onboarding$MyHandler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/Onboarding$MyHandler;->removeMessages(I)V

    .line 287
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onPause()V

    .line 288
    return-void
.end method

.method public onResume()V
    .locals 4

    .prologue
    .line 292
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onResume()V

    .line 293
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding;->hasInit:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding;->mViewPager:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v0

    if-nez v0, :cond_0

    .line 294
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/Onboarding;->mHandler:Lcom/mixerbox/mixerbox3b/Onboarding$MyHandler;

    const/4 v1, 0x1

    const-wide/16 v2, 0x12c

    invoke-virtual {v0, v1, v2, v3}, Lcom/mixerbox/mixerbox3b/Onboarding$MyHandler;->sendEmptyMessageDelayed(IJ)Z

    .line 295
    :cond_0
    return-void
.end method

.method protected onStart()V
    .locals 1

    .prologue
    invoke-static {}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->getInstance()Lcom/newrelic/agent/android/background/ApplicationStateMonitor;

    move-result-object v0

    invoke-virtual {v0}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->activityStarted()V

    .line 323
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onStart()V

    .line 324
    const-string v0, "Z8QPYZT3PBG8R6ZNSDXQ"

    invoke-static {p0, v0}, Lcom/flurry/android/FlurryAgent;->onStartSession(Landroid/content/Context;Ljava/lang/String;)V

    .line 325
    return-void
.end method

.method protected onStop()V
    .locals 1

    .prologue
    invoke-static {}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->getInstance()Lcom/newrelic/agent/android/background/ApplicationStateMonitor;

    move-result-object v0

    invoke-virtual {v0}, Lcom/newrelic/agent/android/background/ApplicationStateMonitor;->activityStopped()V

    .line 329
    invoke-static {p0}, Lcom/flurry/android/FlurryAgent;->onEndSession(Landroid/content/Context;)V

    .line 330
    invoke-super {p0}, Landroid/support/v4/app/FragmentActivity;->onStop()V

    .line 331
    return-void
.end method
