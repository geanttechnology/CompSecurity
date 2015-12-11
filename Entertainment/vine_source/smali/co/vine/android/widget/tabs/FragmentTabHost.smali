.class public Lco/vine/android/widget/tabs/FragmentTabHost;
.super Landroid/widget/TabHost;
.source "FragmentTabHost.java"

# interfaces
.implements Landroid/widget/TabHost$OnTabChangeListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/widget/tabs/FragmentTabHost$1;,
        Lco/vine/android/widget/tabs/FragmentTabHost$SavedState;,
        Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;
    }
.end annotation


# instance fields
.field private mAttached:Z

.field private mContainerId:I

.field private mContext:Landroid/content/Context;

.field private mFragmentManager:Landroid/support/v4/app/FragmentManager;

.field private mLastTab:Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;

.field private mOnTabChangeListener:Landroid/widget/TabHost$OnTabChangeListener;

.field private mRealTabContent:Landroid/widget/FrameLayout;

.field private final mTabs:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x0

    .line 119
    invoke-direct {p0, p1, v1}, Landroid/widget/TabHost;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 61
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mTabs:Ljava/util/ArrayList;

    .line 120
    invoke-direct {p0, p1, v1}, Lco/vine/android/widget/tabs/FragmentTabHost;->initFragmentTabHost(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 121
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 124
    invoke-direct {p0, p1, p2}, Landroid/widget/TabHost;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 61
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mTabs:Ljava/util/ArrayList;

    .line 125
    invoke-direct {p0, p1, p2}, Lco/vine/android/widget/tabs/FragmentTabHost;->initFragmentTabHost(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 126
    return-void
.end method

.method private doTabChanged(Ljava/lang/String;Landroid/support/v4/app/FragmentTransaction;)Landroid/support/v4/app/FragmentTransaction;
    .locals 7
    .param p1, "tabId"    # Ljava/lang/String;
    .param p2, "ft"    # Landroid/support/v4/app/FragmentTransaction;

    .prologue
    .line 313
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 314
    const-string p1, "users"

    .line 316
    :cond_0
    const/4 v2, 0x0

    .line 317
    .local v2, "newTab":Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;
    iget-object v4, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mTabs:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;

    .line 318
    .local v3, "tab":Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;
    iget-object v4, v3, Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->mTag:Ljava/lang/String;

    invoke-virtual {v4, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 319
    move-object v2, v3

    goto :goto_0

    .line 322
    .end local v3    # "tab":Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;
    :cond_2
    if-nez v2, :cond_3

    .line 323
    new-instance v4, Ljava/lang/IllegalStateException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "No tab known for tag "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    invoke-static {v4}, Lco/vine/android/util/CrashUtil;->logException(Ljava/lang/Throwable;)V

    move-object v0, p2

    .line 345
    .end local p2    # "ft":Landroid/support/v4/app/FragmentTransaction;
    .local v0, "ft":Landroid/support/v4/app/FragmentTransaction;
    :goto_1
    return-object v0

    .line 326
    .end local v0    # "ft":Landroid/support/v4/app/FragmentTransaction;
    .restart local p2    # "ft":Landroid/support/v4/app/FragmentTransaction;
    :cond_3
    iget-object v4, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mLastTab:Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;

    if-eq v4, v2, :cond_6

    .line 327
    if-nez p2, :cond_4

    .line 328
    iget-object v4, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mFragmentManager:Landroid/support/v4/app/FragmentManager;

    invoke-virtual {v4}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object p2

    .line 330
    :cond_4
    iget-object v4, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mLastTab:Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;

    if-eqz v4, :cond_5

    .line 331
    iget-object v4, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mLastTab:Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;

    # getter for: Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->fragment:Landroid/support/v4/app/Fragment;
    invoke-static {v4}, Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->access$100(Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;)Landroid/support/v4/app/Fragment;

    move-result-object v4

    if-eqz v4, :cond_5

    .line 332
    iget-object v4, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mLastTab:Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;

    # getter for: Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->fragment:Landroid/support/v4/app/Fragment;
    invoke-static {v4}, Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->access$100(Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;)Landroid/support/v4/app/Fragment;

    move-result-object v4

    invoke-virtual {p2, v4}, Landroid/support/v4/app/FragmentTransaction;->detach(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 335
    :cond_5
    # getter for: Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->fragment:Landroid/support/v4/app/Fragment;
    invoke-static {v2}, Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->access$100(Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;)Landroid/support/v4/app/Fragment;

    move-result-object v4

    if-nez v4, :cond_7

    .line 336
    iget-object v4, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mContext:Landroid/content/Context;

    iget-object v5, v2, Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->clss:Ljava/lang/Class;

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    iget-object v6, v2, Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->bundle:Landroid/os/Bundle;

    invoke-static {v4, v5, v6}, Landroid/support/v4/app/Fragment;->instantiate(Landroid/content/Context;Ljava/lang/String;Landroid/os/Bundle;)Landroid/support/v4/app/Fragment;

    move-result-object v4

    # setter for: Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->fragment:Landroid/support/v4/app/Fragment;
    invoke-static {v2, v4}, Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->access$102(Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/Fragment;

    .line 338
    iget v4, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mContainerId:I

    # getter for: Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->fragment:Landroid/support/v4/app/Fragment;
    invoke-static {v2}, Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->access$100(Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;)Landroid/support/v4/app/Fragment;

    move-result-object v5

    iget-object v6, v2, Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->mTag:Ljava/lang/String;

    invoke-virtual {p2, v4, v5, v6}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 343
    :goto_2
    iput-object v2, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mLastTab:Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;

    :cond_6
    move-object v0, p2

    .line 345
    .end local p2    # "ft":Landroid/support/v4/app/FragmentTransaction;
    .restart local v0    # "ft":Landroid/support/v4/app/FragmentTransaction;
    goto :goto_1

    .line 340
    .end local v0    # "ft":Landroid/support/v4/app/FragmentTransaction;
    .restart local p2    # "ft":Landroid/support/v4/app/FragmentTransaction;
    :cond_7
    # getter for: Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->fragment:Landroid/support/v4/app/Fragment;
    invoke-static {v2}, Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->access$100(Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;)Landroid/support/v4/app/Fragment;

    move-result-object v4

    invoke-virtual {p2, v4}, Landroid/support/v4/app/FragmentTransaction;->attach(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    goto :goto_2
.end method

.method private ensureContent()V
    .locals 3

    .prologue
    .line 200
    iget-object v0, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mRealTabContent:Landroid/widget/FrameLayout;

    if-nez v0, :cond_0

    .line 201
    iget v0, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mContainerId:I

    invoke-virtual {p0, v0}, Lco/vine/android/widget/tabs/FragmentTabHost;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    iput-object v0, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mRealTabContent:Landroid/widget/FrameLayout;

    .line 202
    iget-object v0, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mRealTabContent:Landroid/widget/FrameLayout;

    if-nez v0, :cond_0

    .line 203
    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "No tab content FrameLayout found for id "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mContainerId:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 207
    :cond_0
    return-void
.end method

.method private initFragmentTabHost(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 11
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const v10, 0x1020013

    const/4 v9, 0x1

    const/4 v8, 0x0

    const/4 v7, -0x1

    const/4 v6, 0x0

    .line 129
    new-array v4, v9, [I

    const v5, 0x10100f3

    aput v5, v4, v6

    invoke-virtual {p1, p2, v4, v6, v6}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 131
    .local v0, "a":Landroid/content/res/TypedArray;
    if-eqz v0, :cond_0

    .line 132
    invoke-virtual {v0, v6, v6}, Landroid/content/res/TypedArray;->getResourceId(II)I

    move-result v4

    iput v4, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mContainerId:I

    .line 133
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 136
    :cond_0
    invoke-super {p0, p0}, Landroid/widget/TabHost;->setOnTabChangedListener(Landroid/widget/TabHost$OnTabChangeListener;)V

    .line 140
    invoke-virtual {p0, v10}, Lco/vine/android/widget/tabs/FragmentTabHost;->findViewById(I)Landroid/view/View;

    move-result-object v4

    if-nez v4, :cond_1

    .line 141
    new-instance v2, Landroid/widget/LinearLayout;

    invoke-direct {v2, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 142
    .local v2, "ll":Landroid/widget/LinearLayout;
    invoke-virtual {v2, v9}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 143
    new-instance v4, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v4, v7, v7}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    invoke-virtual {p0, v2, v4}, Lco/vine/android/widget/tabs/FragmentTabHost;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 147
    new-instance v3, Landroid/widget/TabWidget;

    invoke-direct {v3, p1}, Landroid/widget/TabWidget;-><init>(Landroid/content/Context;)V

    .line 148
    .local v3, "tw":Landroid/widget/TabWidget;
    invoke-virtual {v3, v10}, Landroid/widget/TabWidget;->setId(I)V

    .line 149
    invoke-virtual {v3, v6}, Landroid/widget/TabWidget;->setOrientation(I)V

    .line 150
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v5, -0x2

    invoke-direct {v4, v7, v5, v8}, Landroid/widget/LinearLayout$LayoutParams;-><init>(IIF)V

    invoke-virtual {v2, v3, v4}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 154
    new-instance v1, Landroid/widget/FrameLayout;

    invoke-direct {v1, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 155
    .local v1, "fl":Landroid/widget/FrameLayout;
    const v4, 0x1020011

    invoke-virtual {v1, v4}, Landroid/widget/FrameLayout;->setId(I)V

    .line 156
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v4, v6, v6, v8}, Landroid/widget/LinearLayout$LayoutParams;-><init>(IIF)V

    invoke-virtual {v2, v1, v4}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 158
    new-instance v1, Landroid/widget/FrameLayout;

    .end local v1    # "fl":Landroid/widget/FrameLayout;
    invoke-direct {v1, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .restart local v1    # "fl":Landroid/widget/FrameLayout;
    iput-object v1, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mRealTabContent:Landroid/widget/FrameLayout;

    .line 159
    iget-object v4, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mRealTabContent:Landroid/widget/FrameLayout;

    iget v5, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mContainerId:I

    invoke-virtual {v4, v5}, Landroid/widget/FrameLayout;->setId(I)V

    .line 160
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;

    const/high16 v5, 0x3f800000    # 1.0f

    invoke-direct {v4, v7, v6, v5}, Landroid/widget/LinearLayout$LayoutParams;-><init>(IIF)V

    invoke-virtual {v2, v1, v4}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 163
    .end local v1    # "fl":Landroid/widget/FrameLayout;
    .end local v2    # "ll":Landroid/widget/LinearLayout;
    .end local v3    # "tw":Landroid/widget/TabWidget;
    :cond_1
    return-void
.end method


# virtual methods
.method public addTab(Landroid/widget/TabHost$TabSpec;Ljava/lang/Class;Landroid/os/Bundle;)V
    .locals 5
    .param p1, "tabSpec"    # Landroid/widget/TabHost$TabSpec;
    .param p3, "args"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/TabHost$TabSpec;",
            "Ljava/lang/Class",
            "<*>;",
            "Landroid/os/Bundle;",
            ")V"
        }
    .end annotation

    .prologue
    .line 215
    .local p2, "clss":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    new-instance v3, Lco/vine/android/widget/tabs/DummyTabFactory;

    iget-object v4, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mContext:Landroid/content/Context;

    invoke-direct {v3, v4}, Lco/vine/android/widget/tabs/DummyTabFactory;-><init>(Landroid/content/Context;)V

    invoke-virtual {p1, v3}, Landroid/widget/TabHost$TabSpec;->setContent(Landroid/widget/TabHost$TabContentFactory;)Landroid/widget/TabHost$TabSpec;

    .line 216
    invoke-virtual {p1}, Landroid/widget/TabHost$TabSpec;->getTag()Ljava/lang/String;

    move-result-object v2

    .line 218
    .local v2, "tag":Ljava/lang/String;
    new-instance v1, Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;

    invoke-direct {v1, v2, p2, p3}, Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;-><init>(Ljava/lang/String;Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 220
    .local v1, "info":Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;
    iget-boolean v3, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mAttached:Z

    if-eqz v3, :cond_0

    .line 224
    iget-object v3, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mFragmentManager:Landroid/support/v4/app/FragmentManager;

    invoke-virtual {v3, v2}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v3

    # setter for: Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->fragment:Landroid/support/v4/app/Fragment;
    invoke-static {v1, v3}, Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->access$102(Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/Fragment;

    .line 225
    # getter for: Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->fragment:Landroid/support/v4/app/Fragment;
    invoke-static {v1}, Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->access$100(Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;)Landroid/support/v4/app/Fragment;

    move-result-object v3

    if-eqz v3, :cond_0

    # getter for: Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->fragment:Landroid/support/v4/app/Fragment;
    invoke-static {v1}, Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->access$100(Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;)Landroid/support/v4/app/Fragment;

    move-result-object v3

    invoke-virtual {v3}, Landroid/support/v4/app/Fragment;->isDetached()Z

    move-result v3

    if-nez v3, :cond_0

    .line 226
    iget-object v3, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mFragmentManager:Landroid/support/v4/app/FragmentManager;

    invoke-virtual {v3}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 227
    .local v0, "ft":Landroid/support/v4/app/FragmentTransaction;
    # getter for: Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->fragment:Landroid/support/v4/app/Fragment;
    invoke-static {v1}, Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->access$100(Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;)Landroid/support/v4/app/Fragment;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/support/v4/app/FragmentTransaction;->detach(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 228
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    .line 232
    .end local v0    # "ft":Landroid/support/v4/app/FragmentTransaction;
    :cond_0
    iget-object v3, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mTabs:Ljava/util/ArrayList;

    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 233
    invoke-virtual {p0, p1}, Lco/vine/android/widget/tabs/FragmentTabHost;->addTab(Landroid/widget/TabHost$TabSpec;)V

    .line 234
    return-void
.end method

.method protected onAttachedToWindow()V
    .locals 6

    .prologue
    .line 238
    invoke-super {p0}, Landroid/widget/TabHost;->onAttachedToWindow()V

    .line 240
    invoke-virtual {p0}, Lco/vine/android/widget/tabs/FragmentTabHost;->getCurrentTabTag()Ljava/lang/String;

    move-result-object v0

    .line 244
    .local v0, "currentTab":Ljava/lang/String;
    const/4 v1, 0x0

    .line 245
    .local v1, "ft":Landroid/support/v4/app/FragmentTransaction;
    iget-object v4, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mTabs:Ljava/util/ArrayList;

    invoke-virtual {v4}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;

    .line 246
    .local v3, "tab":Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;
    iget-object v4, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mFragmentManager:Landroid/support/v4/app/FragmentManager;

    iget-object v5, v3, Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->mTag:Ljava/lang/String;

    invoke-virtual {v4, v5}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v4

    # setter for: Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->fragment:Landroid/support/v4/app/Fragment;
    invoke-static {v3, v4}, Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->access$102(Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/Fragment;

    .line 247
    # getter for: Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->fragment:Landroid/support/v4/app/Fragment;
    invoke-static {v3}, Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->access$100(Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;)Landroid/support/v4/app/Fragment;

    move-result-object v4

    if-eqz v4, :cond_0

    # getter for: Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->fragment:Landroid/support/v4/app/Fragment;
    invoke-static {v3}, Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->access$100(Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;)Landroid/support/v4/app/Fragment;

    move-result-object v4

    invoke-virtual {v4}, Landroid/support/v4/app/Fragment;->isDetached()Z

    move-result v4

    if-nez v4, :cond_0

    .line 248
    iget-object v4, v3, Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->mTag:Ljava/lang/String;

    invoke-virtual {v4, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 252
    iput-object v3, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mLastTab:Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;

    goto :goto_0

    .line 256
    :cond_1
    if-nez v1, :cond_2

    .line 257
    iget-object v4, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mFragmentManager:Landroid/support/v4/app/FragmentManager;

    invoke-virtual {v4}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    .line 259
    :cond_2
    # getter for: Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->fragment:Landroid/support/v4/app/Fragment;
    invoke-static {v3}, Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;->access$100(Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;)Landroid/support/v4/app/Fragment;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/support/v4/app/FragmentTransaction;->detach(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    goto :goto_0

    .line 266
    .end local v3    # "tab":Lco/vine/android/widget/tabs/FragmentTabHost$TabInfo;
    :cond_3
    const/4 v4, 0x1

    iput-boolean v4, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mAttached:Z

    .line 267
    invoke-direct {p0, v0, v1}, Lco/vine/android/widget/tabs/FragmentTabHost;->doTabChanged(Ljava/lang/String;Landroid/support/v4/app/FragmentTransaction;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    .line 268
    if-eqz v1, :cond_4

    .line 269
    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commitAllowingStateLoss()I

    .line 270
    iget-object v4, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mFragmentManager:Landroid/support/v4/app/FragmentManager;

    invoke-virtual {v4}, Landroid/support/v4/app/FragmentManager;->executePendingTransactions()Z

    .line 272
    :cond_4
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 276
    invoke-super {p0}, Landroid/widget/TabHost;->onDetachedFromWindow()V

    .line 277
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mAttached:Z

    .line 278
    return-void
.end method

.method protected onRestoreInstanceState(Landroid/os/Parcelable;)V
    .locals 2
    .param p1, "state"    # Landroid/os/Parcelable;

    .prologue
    .line 290
    move-object v0, p1

    check-cast v0, Lco/vine/android/widget/tabs/FragmentTabHost$SavedState;

    .line 291
    .local v0, "ss":Lco/vine/android/widget/tabs/FragmentTabHost$SavedState;
    invoke-virtual {v0}, Lco/vine/android/widget/tabs/FragmentTabHost$SavedState;->getSuperState()Landroid/os/Parcelable;

    move-result-object v1

    invoke-super {p0, v1}, Landroid/widget/TabHost;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    .line 292
    iget-object v1, v0, Lco/vine/android/widget/tabs/FragmentTabHost$SavedState;->curTab:Ljava/lang/String;

    invoke-virtual {p0, v1}, Lco/vine/android/widget/tabs/FragmentTabHost;->setCurrentTabByTag(Ljava/lang/String;)V

    .line 293
    return-void
.end method

.method protected onSaveInstanceState()Landroid/os/Parcelable;
    .locals 3

    .prologue
    .line 282
    invoke-super {p0}, Landroid/widget/TabHost;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v1

    .line 283
    .local v1, "superState":Landroid/os/Parcelable;
    new-instance v0, Lco/vine/android/widget/tabs/FragmentTabHost$SavedState;

    invoke-direct {v0, v1}, Lco/vine/android/widget/tabs/FragmentTabHost$SavedState;-><init>(Landroid/os/Parcelable;)V

    .line 284
    .local v0, "ss":Lco/vine/android/widget/tabs/FragmentTabHost$SavedState;
    invoke-virtual {p0}, Lco/vine/android/widget/tabs/FragmentTabHost;->getCurrentTabTag()Ljava/lang/String;

    move-result-object v2

    iput-object v2, v0, Lco/vine/android/widget/tabs/FragmentTabHost$SavedState;->curTab:Ljava/lang/String;

    .line 285
    return-object v0
.end method

.method public onTabChanged(Ljava/lang/String;)V
    .locals 2
    .param p1, "tabId"    # Ljava/lang/String;

    .prologue
    .line 297
    iget-boolean v1, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mAttached:Z

    if-eqz v1, :cond_0

    .line 298
    const/4 v1, 0x0

    invoke-direct {p0, p1, v1}, Lco/vine/android/widget/tabs/FragmentTabHost;->doTabChanged(Ljava/lang/String;Landroid/support/v4/app/FragmentTransaction;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 299
    .local v0, "ft":Landroid/support/v4/app/FragmentTransaction;
    if-eqz v0, :cond_0

    .line 300
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commitAllowingStateLoss()I

    .line 303
    .end local v0    # "ft":Landroid/support/v4/app/FragmentTransaction;
    :cond_0
    iget-object v1, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mOnTabChangeListener:Landroid/widget/TabHost$OnTabChangeListener;

    if-eqz v1, :cond_1

    .line 304
    iget-object v1, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mOnTabChangeListener:Landroid/widget/TabHost$OnTabChangeListener;

    invoke-interface {v1, p1}, Landroid/widget/TabHost$OnTabChangeListener;->onTabChanged(Ljava/lang/String;)V

    .line 306
    :cond_1
    return-void
.end method

.method public setOnTabChangedListener(Landroid/widget/TabHost$OnTabChangeListener;)V
    .locals 0
    .param p1, "l"    # Landroid/widget/TabHost$OnTabChangeListener;

    .prologue
    .line 211
    iput-object p1, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mOnTabChangeListener:Landroid/widget/TabHost$OnTabChangeListener;

    .line 212
    return-void
.end method

.method public setup()V
    .locals 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 173
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Must call setup() that takes a Context and FragmentManager"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public setup(Landroid/content/Context;Landroid/support/v4/app/FragmentManager;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "manager"    # Landroid/support/v4/app/FragmentManager;

    .prologue
    .line 178
    invoke-super {p0}, Landroid/widget/TabHost;->setup()V

    .line 179
    iput-object p1, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mContext:Landroid/content/Context;

    .line 180
    iput-object p2, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mFragmentManager:Landroid/support/v4/app/FragmentManager;

    .line 181
    invoke-direct {p0}, Lco/vine/android/widget/tabs/FragmentTabHost;->ensureContent()V

    .line 182
    return-void
.end method

.method public setup(Landroid/content/Context;Landroid/support/v4/app/FragmentManager;I)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "manager"    # Landroid/support/v4/app/FragmentManager;
    .param p3, "containerId"    # I

    .prologue
    .line 185
    invoke-super {p0}, Landroid/widget/TabHost;->setup()V

    .line 186
    iput-object p1, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mContext:Landroid/content/Context;

    .line 187
    iput-object p2, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mFragmentManager:Landroid/support/v4/app/FragmentManager;

    .line 188
    iput p3, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mContainerId:I

    .line 189
    invoke-direct {p0}, Lco/vine/android/widget/tabs/FragmentTabHost;->ensureContent()V

    .line 190
    iget-object v0, p0, Lco/vine/android/widget/tabs/FragmentTabHost;->mRealTabContent:Landroid/widget/FrameLayout;

    invoke-virtual {v0, p3}, Landroid/widget/FrameLayout;->setId(I)V

    .line 194
    invoke-virtual {p0}, Lco/vine/android/widget/tabs/FragmentTabHost;->getId()I

    move-result v0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    .line 195
    const v0, 0x1020012

    invoke-virtual {p0, v0}, Lco/vine/android/widget/tabs/FragmentTabHost;->setId(I)V

    .line 197
    :cond_0
    return-void
.end method
