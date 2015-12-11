.class public Lcom/poshmark/ui/fragments/FeedMotherFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "FeedMotherFragment.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;
.implements Lcom/poshmark/notifications/SynchronousBroadcastListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/fragments/FeedMotherFragment$ScreenSlidePagerAdapter;
    }
.end annotation


# instance fields
.field private bMyLikesTrackingCallFired:Z

.field private currentTabIndex:I

.field feedFragment:Lcom/poshmark/ui/fragments/PMFragment;

.field feedTextView:Lcom/poshmark/ui/customviews/PMTextView;

.field private mPager:Landroid/support/v4/view/ViewPager;

.field private mPagerAdapter:Lcom/poshmark/ui/fragments/FeedMotherFragment$ScreenSlidePagerAdapter;

.field private mTabHost:Landroid/widget/TabHost;

.field myLikesFragment:Lcom/poshmark/ui/fragments/PMFragment;

.field myLikesTextView:Lcom/poshmark/ui/customviews/PMTextView;

.field peopleFragment:Lcom/poshmark/ui/fragments/PMFragment;

.field peopleTextView:Lcom/poshmark/ui/customviews/PMTextView;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 30
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 46
    const/4 v0, 0x1

    iput v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->currentTabIndex:I

    .line 48
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->bMyLikesTrackingCallFired:Z

    .line 260
    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/FeedMotherFragment;)Landroid/widget/TabHost;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/FeedMotherFragment;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->mTabHost:Landroid/widget/TabHost;

    return-object v0
.end method

.method static synthetic access$100(Lcom/poshmark/ui/fragments/FeedMotherFragment;)I
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/FeedMotherFragment;

    .prologue
    .line 30
    iget v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->currentTabIndex:I

    return v0
.end method

.method static synthetic access$102(Lcom/poshmark/ui/fragments/FeedMotherFragment;I)I
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/FeedMotherFragment;
    .param p1, "x1"    # I

    .prologue
    .line 30
    iput p1, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->currentTabIndex:I

    return p1
.end method

.method static synthetic access$200(Lcom/poshmark/ui/fragments/FeedMotherFragment;Lcom/poshmark/ui/customviews/PMTextView;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/FeedMotherFragment;
    .param p1, "x1"    # Lcom/poshmark/ui/customviews/PMTextView;
    .param p2, "x2"    # Z

    .prologue
    .line 30
    invoke-direct {p0, p1, p2}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->setTabTextViewSelected(Lcom/poshmark/ui/customviews/PMTextView;Z)V

    return-void
.end method

.method static synthetic access$300(Lcom/poshmark/ui/fragments/FeedMotherFragment;)Landroid/support/v4/view/ViewPager;
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/FeedMotherFragment;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->mPager:Landroid/support/v4/view/ViewPager;

    return-object v0
.end method

.method static synthetic access$400(Lcom/poshmark/ui/fragments/FeedMotherFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/FeedMotherFragment;

    .prologue
    .line 30
    iget-boolean v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->bMyLikesTrackingCallFired:Z

    return v0
.end method

.method static synthetic access$402(Lcom/poshmark/ui/fragments/FeedMotherFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/FeedMotherFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 30
    iput-boolean p1, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->bMyLikesTrackingCallFired:Z

    return p1
.end method

.method private getTabTextViewWithTitle(Ljava/lang/String;Z)Lcom/poshmark/ui/customviews/PMTextView;
    .locals 3
    .param p1, "tabTitle"    # Ljava/lang/String;
    .param p2, "selected"    # Z

    .prologue
    .line 162
    new-instance v0, Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lcom/poshmark/ui/customviews/PMTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 163
    .local v0, "labelTextView":Lcom/poshmark/ui/customviews/PMTextView;
    const/4 v1, 0x2

    const/high16 v2, 0x41600000    # 14.0f

    invoke-virtual {v0, v1, v2}, Lcom/poshmark/ui/customviews/PMTextView;->setTextSize(IF)V

    .line 164
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/high16 v2, 0x42200000    # 40.0f

    invoke-static {v1, v2}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v1

    float-to-int v1, v1

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setHeight(I)V

    .line 165
    const v1, 0x7f020001

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setBackgroundResource(I)V

    .line 166
    invoke-virtual {v0, p1}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 167
    const/16 v1, 0x11

    invoke-virtual {v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setGravity(I)V

    .line 168
    invoke-direct {p0, v0, p2}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->setTabTextViewSelected(Lcom/poshmark/ui/customviews/PMTextView;Z)V

    .line 169
    return-object v0
.end method

.method private initialiseTabHost()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    const v3, 0x7f0c0049

    .line 173
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->mTabHost:Landroid/widget/TabHost;

    invoke-virtual {v2}, Landroid/widget/TabHost;->setup()V

    .line 175
    const v2, 0x7f0601b3

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 176
    .local v1, "title":Ljava/lang/String;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->mTabHost:Landroid/widget/TabHost;

    invoke-virtual {v2, v1}, Landroid/widget/TabHost;->newTabSpec(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;

    move-result-object v2

    invoke-virtual {v2, v3}, Landroid/widget/TabHost$TabSpec;->setContent(I)Landroid/widget/TabHost$TabSpec;

    move-result-object v0

    .line 177
    .local v0, "spec":Landroid/widget/TabHost$TabSpec;
    invoke-direct {p0, v1, v4}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->getTabTextViewWithTitle(Ljava/lang/String;Z)Lcom/poshmark/ui/customviews/PMTextView;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->myLikesTextView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 178
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->myLikesTextView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v0, v2}, Landroid/widget/TabHost$TabSpec;->setIndicator(Landroid/view/View;)Landroid/widget/TabHost$TabSpec;

    .line 179
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->mTabHost:Landroid/widget/TabHost;

    invoke-virtual {v2, v0}, Landroid/widget/TabHost;->addTab(Landroid/widget/TabHost$TabSpec;)V

    .line 181
    const v2, 0x7f06010f

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 182
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->mTabHost:Landroid/widget/TabHost;

    invoke-virtual {v2, v1}, Landroid/widget/TabHost;->newTabSpec(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;

    move-result-object v2

    invoke-virtual {v2, v3}, Landroid/widget/TabHost$TabSpec;->setContent(I)Landroid/widget/TabHost$TabSpec;

    move-result-object v0

    .line 183
    const/4 v2, 0x1

    invoke-direct {p0, v1, v2}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->getTabTextViewWithTitle(Ljava/lang/String;Z)Lcom/poshmark/ui/customviews/PMTextView;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->feedTextView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 184
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->feedTextView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v0, v2}, Landroid/widget/TabHost$TabSpec;->setIndicator(Landroid/view/View;)Landroid/widget/TabHost$TabSpec;

    .line 185
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->mTabHost:Landroid/widget/TabHost;

    invoke-virtual {v2, v0}, Landroid/widget/TabHost;->addTab(Landroid/widget/TabHost$TabSpec;)V

    .line 187
    const v2, 0x7f0601fd

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 188
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->mTabHost:Landroid/widget/TabHost;

    invoke-virtual {v2, v1}, Landroid/widget/TabHost;->newTabSpec(Ljava/lang/String;)Landroid/widget/TabHost$TabSpec;

    move-result-object v2

    invoke-virtual {v2, v3}, Landroid/widget/TabHost$TabSpec;->setContent(I)Landroid/widget/TabHost$TabSpec;

    move-result-object v0

    .line 189
    invoke-direct {p0, v1, v4}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->getTabTextViewWithTitle(Ljava/lang/String;Z)Lcom/poshmark/ui/customviews/PMTextView;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->peopleTextView:Lcom/poshmark/ui/customviews/PMTextView;

    .line 190
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->peopleTextView:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v0, v2}, Landroid/widget/TabHost$TabSpec;->setIndicator(Landroid/view/View;)Landroid/widget/TabHost$TabSpec;

    .line 191
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->mTabHost:Landroid/widget/TabHost;

    invoke-virtual {v2, v0}, Landroid/widget/TabHost;->addTab(Landroid/widget/TabHost$TabSpec;)V

    .line 193
    iget-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->mTabHost:Landroid/widget/TabHost;

    new-instance v3, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;

    invoke-direct {v3, p0}, Lcom/poshmark/ui/fragments/FeedMotherFragment$2;-><init>(Lcom/poshmark/ui/fragments/FeedMotherFragment;)V

    invoke-virtual {v2, v3}, Landroid/widget/TabHost;->setOnTabChangedListener(Landroid/widget/TabHost$OnTabChangeListener;)V

    .line 233
    return-void
.end method

.method private setTabTextViewSelected(Lcom/poshmark/ui/customviews/PMTextView;Z)V
    .locals 2
    .param p1, "textView"    # Lcom/poshmark/ui/customviews/PMTextView;
    .param p2, "selected"    # Z

    .prologue
    .line 151
    if-eqz p2, :cond_0

    .line 152
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f09003c

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {p1, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 153
    sget-object v0, Landroid/graphics/Typeface;->SANS_SERIF:Landroid/graphics/Typeface;

    const/4 v1, 0x1

    invoke-virtual {p1, v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 159
    :goto_0
    return-void

    .line 156
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f090038

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {p1, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setTextColor(I)V

    .line 157
    sget-object v0, Landroid/graphics/Typeface;->SANS_SERIF:Landroid/graphics/Typeface;

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Lcom/poshmark/ui/customviews/PMTextView;->setTypeface(Landroid/graphics/Typeface;I)V

    goto :goto_0
.end method

.method private setupViewPager()V
    .locals 2

    .prologue
    .line 134
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->mPager:Landroid/support/v4/view/ViewPager;

    iget-object v1, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->mPagerAdapter:Lcom/poshmark/ui/fragments/FeedMotherFragment$ScreenSlidePagerAdapter;

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 136
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->mPager:Landroid/support/v4/view/ViewPager;

    new-instance v1, Lcom/poshmark/ui/fragments/FeedMotherFragment$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/FeedMotherFragment$1;-><init>(Lcom/poshmark/ui/fragments/FeedMotherFragment;)V

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setOnPageChangeListener(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)V

    .line 148
    return-void
.end method


# virtual methods
.method public handleBack()Z
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->myLikesFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->handleBack()Z

    .line 128
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->feedFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->handleBack()Z

    .line 129
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->peopleFragment:Lcom/poshmark/ui/fragments/PMFragment;

    invoke-virtual {v0}, Lcom/poshmark/ui/fragments/PMFragment;->handleBack()Z

    .line 130
    const/4 v0, 0x0

    return v0
.end method

.method public handleNotification(Landroid/content/Intent;)V
    .locals 3
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    const/4 v2, 0x1

    .line 237
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LISTING_CREATED"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 238
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->mTabHost:Landroid/widget/TabHost;

    if-eqz v0, :cond_1

    .line 239
    iput v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->currentTabIndex:I

    .line 240
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->mTabHost:Landroid/widget/TabHost;

    iget v1, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->currentTabIndex:I

    invoke-virtual {v0, v1}, Landroid/widget/TabHost;->setCurrentTab(I)V

    .line 246
    :cond_0
    :goto_0
    return-void

    .line 243
    :cond_1
    iput v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->currentTabIndex:I

    goto :goto_0
.end method

.method public handleSynchronousBroadcastMsg(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "intent"    # Ljava/lang/String;
    .param p2, "data"    # Ljava/lang/Object;

    .prologue
    .line 250
    const-string v0, "com.poshmark.intents.LOGOUT_COMPLETE"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 251
    const/4 v0, 0x1

    iput v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->currentTabIndex:I

    .line 253
    :cond_0
    return-void
.end method

.method public logScreenTracking()V
    .locals 0

    .prologue
    .line 100
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 83
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 84
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->initialiseTabHost()V

    .line 85
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->setupViewPager()V

    .line 87
    iget v1, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->currentTabIndex:I

    if-nez v1, :cond_0

    .line 88
    iget v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->currentTabIndex:I

    .line 89
    .local v0, "temp":I
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->mTabHost:Landroid/widget/TabHost;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/widget/TabHost;->setCurrentTab(I)V

    .line 90
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->mTabHost:Landroid/widget/TabHost;

    invoke-virtual {v1, v0}, Landroid/widget/TabHost;->setCurrentTab(I)V

    .line 95
    .end local v0    # "temp":I
    :goto_0
    return-void

    .line 92
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->mTabHost:Landroid/widget/TabHost;

    iget v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->currentTabIndex:I

    invoke-virtual {v1, v2}, Landroid/widget/TabHost;->setCurrentTab(I)V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 52
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 53
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 70
    const v2, 0x7f030051

    const/4 v3, 0x0

    invoke-virtual {p1, v2, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 72
    .local v1, "v":Landroid/view/View;
    invoke-virtual {v1}, Landroid/view/View;->getRootView()Landroid/view/View;

    move-result-object v0

    .line 74
    .local v0, "root":Landroid/view/View;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f090015

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v2

    invoke-virtual {v0, v2}, Landroid/view/View;->setBackgroundColor(I)V

    .line 75
    const v2, 0x7f0c0049

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/support/v4/view/ViewPager;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->mPager:Landroid/support/v4/view/ViewPager;

    .line 76
    const v2, 0x7f0c0139

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TabHost;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->mTabHost:Landroid/widget/TabHost;

    .line 77
    new-instance v2, Lcom/poshmark/ui/fragments/FeedMotherFragment$ScreenSlidePagerAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/FeedMotherFragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v3

    invoke-direct {v2, p0, v3}, Lcom/poshmark/ui/fragments/FeedMotherFragment$ScreenSlidePagerAdapter;-><init>(Lcom/poshmark/ui/fragments/FeedMotherFragment;Landroid/support/v4/app/FragmentManager;)V

    iput-object v2, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->mPagerAdapter:Lcom/poshmark/ui/fragments/FeedMotherFragment$ScreenSlidePagerAdapter;

    .line 78
    return-object v1
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 57
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onDestroy()V

    .line 59
    return-void
.end method

.method public onDestroyView()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 116
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onDestroyView()V

    .line 117
    iput-object v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->mPager:Landroid/support/v4/view/ViewPager;

    .line 118
    iput-object v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->mTabHost:Landroid/widget/TabHost;

    .line 119
    return-void
.end method

.method public onPMResume()V
    .locals 2

    .prologue
    .line 104
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 106
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LISTING_CREATED"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 107
    invoke-static {}, Lcom/poshmark/notifications/SynchronousBroadcastManager;->getSyncronousBroadcastManager()Lcom/poshmark/notifications/SynchronousBroadcastManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGOUT_COMPLETE"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/SynchronousBroadcastManager;->registerSynchronousBroadcastListener(Ljava/lang/String;Lcom/poshmark/notifications/SynchronousBroadcastListener;)V

    .line 109
    iget v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->currentTabIndex:I

    iget-object v1, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->mTabHost:Landroid/widget/TabHost;

    invoke-virtual {v1}, Landroid/widget/TabHost;->getCurrentTab()I

    move-result v1

    if-eq v0, v1, :cond_0

    .line 110
    iget-object v0, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->mTabHost:Landroid/widget/TabHost;

    iget v1, p0, Lcom/poshmark/ui/fragments/FeedMotherFragment;->currentTabIndex:I

    invoke-virtual {v0, v1}, Landroid/widget/TabHost;->setCurrentTab(I)V

    .line 112
    :cond_0
    return-void
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 63
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPause()V

    .line 64
    invoke-static {}, Lcom/poshmark/notifications/SynchronousBroadcastManager;->getSyncronousBroadcastManager()Lcom/poshmark/notifications/SynchronousBroadcastManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.LOGOUT_COMPLETE"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/SynchronousBroadcastManager;->unregisterSynchronousBroadcastListener(Ljava/lang/String;Lcom/poshmark/notifications/SynchronousBroadcastListener;)V

    .line 65
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/notifications/PMNotificationManager;->unregisterAllEvents(Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 66
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 0

    .prologue
    .line 123
    return-void
.end method
