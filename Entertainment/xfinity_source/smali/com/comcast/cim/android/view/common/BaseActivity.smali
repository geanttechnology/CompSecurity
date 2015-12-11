.class public abstract Lcom/comcast/cim/android/view/common/BaseActivity;
.super Landroid/app/Activity;
.source "BaseActivity.java"

# interfaces
.implements Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
.implements Lcom/comcast/cim/android/accessibility/PassiveStateChangeListener;
.implements Lcom/comcast/cim/android/view/common/OrientationStrategyProvider;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/android/view/common/BaseActivity$ActivitySpeechListener;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private actionBar:Landroid/app/ActionBar;

.field protected actionBarTitle:Landroid/widget/TextView;

.field private final androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

.field private baseActivityDelegate:Lcom/comcast/cim/android/view/common/BaseActivityDelegate;

.field private defaultOrientationStrategy:Lcom/comcast/cim/android/view/common/OrientationStrategy;

.field public ignoreAnnounceTitle:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 26
    const-class v0, Lcom/comcast/cim/android/view/common/BaseActivity;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/android/view/common/BaseActivity;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 25
    invoke-direct {p0}, Landroid/app/Activity;-><init>()V

    .line 28
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0, p0, p0}, Lcom/comcast/cim/container/CALContainer;->getBaseActivityDelegate(Landroid/app/Activity;Lcom/comcast/cim/android/view/common/OrientationStrategyProvider;)Lcom/comcast/cim/android/view/common/BaseActivityDelegate;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->baseActivityDelegate:Lcom/comcast/cim/android/view/common/BaseActivityDelegate;

    .line 29
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getDefaultOrientationStrategy()Lcom/comcast/cim/android/view/common/OrientationStrategy;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->defaultOrientationStrategy:Lcom/comcast/cim/android/view/common/OrientationStrategy;

    .line 30
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getAndroidDevice()Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    .line 35
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->ignoreAnnounceTitle:Z

    .line 187
    return-void
.end method


# virtual methods
.method protected addDefaultActivitySpeechListener()V
    .locals 2

    .prologue
    .line 164
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->baseActivityDelegate:Lcom/comcast/cim/android/view/common/BaseActivityDelegate;

    new-instance v1, Lcom/comcast/cim/android/view/common/BaseActivity$ActivitySpeechListener;

    invoke-direct {v1, p0}, Lcom/comcast/cim/android/view/common/BaseActivity$ActivitySpeechListener;-><init>(Lcom/comcast/cim/android/view/common/BaseActivity;)V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->addSpeechListener(Lcom/comcast/cim/android/accessibility/SpeechListener;)V

    .line 165
    return-void
.end method

.method public addSpeechListener(Lcom/comcast/cim/android/accessibility/SpeechListener;)V
    .locals 1
    .param p1, "speechListener"    # Lcom/comcast/cim/android/accessibility/SpeechListener;

    .prologue
    .line 169
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->baseActivityDelegate:Lcom/comcast/cim/android/view/common/BaseActivityDelegate;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->addSpeechListener(Lcom/comcast/cim/android/accessibility/SpeechListener;)V

    .line 170
    return-void
.end method

.method protected checkTalkBackModeOnResume()V
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->baseActivityDelegate:Lcom/comcast/cim/android/view/common/BaseActivityDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->checkTalkBackModeOnResume()V

    .line 109
    return-void
.end method

.method public checkTalkBackModeOnResume(Landroid/content/Intent;)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 104
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->baseActivityDelegate:Lcom/comcast/cim/android/view/common/BaseActivityDelegate;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->checkTalkBackModeOnResume(Landroid/content/Intent;)V

    .line 105
    return-void
.end method

.method public getOrientationStrategy()Lcom/comcast/cim/android/view/common/OrientationStrategy;
    .locals 1

    .prologue
    .line 100
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->defaultOrientationStrategy:Lcom/comcast/cim/android/view/common/OrientationStrategy;

    return-object v0
.end method

.method public getSpeechDelegate()Lcom/comcast/cim/android/accessibility/SpeechDelegate;
    .locals 1

    .prologue
    .line 184
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->baseActivityDelegate:Lcom/comcast/cim/android/view/common/BaseActivityDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->getSpeechDelegate()Lcom/comcast/cim/android/accessibility/SpeechDelegate;

    move-result-object v0

    return-object v0
.end method

.method protected getSpeechRecognizerClass()Ljava/lang/Class;
    .locals 1

    .prologue
    .line 142
    const-class v0, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;

    return-object v0
.end method

.method public getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;
    .locals 1

    .prologue
    .line 179
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->baseActivityDelegate:Lcom/comcast/cim/android/view/common/BaseActivityDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    return-object v0
.end method

.method public isAccessibilityEnabled()Z
    .locals 1

    .prologue
    .line 160
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->baseActivityDelegate:Lcom/comcast/cim/android/view/common/BaseActivityDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->isAccessibilityEnabled()Z

    move-result v0

    return v0
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 70
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->baseActivityDelegate:Lcom/comcast/cim/android/view/common/BaseActivityDelegate;

    invoke-virtual {v0, p1, p2, p3}, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->onActivityResult(IILandroid/content/Intent;)V

    .line 71
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 39
    invoke-super {p0, p1}, Landroid/app/Activity;->onCreate(Landroid/os/Bundle;)V

    .line 41
    iget-object v1, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->isKindle()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 42
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/BaseActivity;->getWindow()Landroid/view/Window;

    move-result-object v1

    const/16 v2, 0x400

    invoke-virtual {v1, v2}, Landroid/view/Window;->addFlags(I)V

    .line 45
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->baseActivityDelegate:Lcom/comcast/cim/android/view/common/BaseActivityDelegate;

    invoke-virtual {v1}, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->onCreate()V

    .line 49
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/BaseActivity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v1

    iput-object v1, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->actionBar:Landroid/app/ActionBar;

    .line 50
    iget-object v1, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->actionBar:Landroid/app/ActionBar;

    if-eqz v1, :cond_1

    .line 54
    iget-object v1, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->actionBar:Landroid/app/ActionBar;

    invoke-virtual {v1}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v0

    .line 55
    .local v0, "customView":Landroid/view/View;
    if-eqz v0, :cond_1

    .line 56
    sget v1, Lcom/comcast/cim/android/R$id;->title:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->actionBarTitle:Landroid/widget/TextView;

    .line 59
    iget-object v1, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->actionBarTitle:Landroid/widget/TextView;

    if-eqz v1, :cond_1

    .line 60
    iget-object v1, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->actionBarTitle:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/BaseActivity;->getTitle()Ljava/lang/CharSequence;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 65
    .end local v0    # "customView":Landroid/view/View;
    :cond_1
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/BaseActivity;->addDefaultActivitySpeechListener()V

    .line 66
    return-void
.end method

.method public onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 87
    iget-object v1, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->baseActivityDelegate:Lcom/comcast/cim/android/view/common/BaseActivityDelegate;

    invoke-virtual {v1, p1, p2, p3}, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->createView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v0

    .line 88
    .local v0, "view":Landroid/view/View;
    if-eqz v0, :cond_0

    .line 92
    .end local v0    # "view":Landroid/view/View;
    :goto_0
    return-object v0

    .restart local v0    # "view":Landroid/view/View;
    :cond_0
    invoke-super {p0, p1, p2, p3}, Landroid/app/Activity;->onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v0

    goto :goto_0
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 81
    invoke-super {p0}, Landroid/app/Activity;->onDestroy()V

    .line 82
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->baseActivityDelegate:Lcom/comcast/cim/android/view/common/BaseActivityDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->onDestroy()V

    .line 83
    return-void
.end method

.method protected onResume()V
    .locals 1

    .prologue
    .line 75
    invoke-super {p0}, Landroid/app/Activity;->onResume()V

    .line 76
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->baseActivityDelegate:Lcom/comcast/cim/android/view/common/BaseActivityDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->onResume()V

    .line 77
    return-void
.end method

.method public onSpeechSwipe()V
    .locals 2

    .prologue
    .line 137
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->ignoreAnnounceTitle:Z

    .line 138
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->baseActivityDelegate:Lcom/comcast/cim/android/view/common/BaseActivityDelegate;

    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/BaseActivity;->getSpeechRecognizerClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->onSpeechSwipe(Ljava/lang/Class;)V

    .line 139
    return-void
.end method

.method public removeSpeechListener(Lcom/comcast/cim/android/accessibility/SpeechListener;)V
    .locals 1
    .param p1, "speechListener"    # Lcom/comcast/cim/android/accessibility/SpeechListener;

    .prologue
    .line 174
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->baseActivityDelegate:Lcom/comcast/cim/android/view/common/BaseActivityDelegate;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->removeSpeechListener(Lcom/comcast/cim/android/accessibility/SpeechListener;)V

    .line 175
    return-void
.end method

.method protected resetActionBarIcon()V
    .locals 2

    .prologue
    .line 116
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->actionBar:Landroid/app/ActionBar;

    sget v1, Lcom/comcast/cim/android/R$drawable;->ico_browse:I

    invoke-virtual {v0, v1}, Landroid/app/ActionBar;->setIcon(I)V

    .line 117
    return-void
.end method

.method protected setActionBarIcon(I)V
    .locals 1
    .param p1, "resourceID"    # I

    .prologue
    .line 112
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->actionBar:Landroid/app/ActionBar;

    invoke-virtual {v0, p1}, Landroid/app/ActionBar;->setIcon(I)V

    .line 113
    return-void
.end method

.method public setTitle(I)V
    .locals 1
    .param p1, "titleId"    # I

    .prologue
    .line 129
    invoke-super {p0, p1}, Landroid/app/Activity;->setTitle(I)V

    .line 130
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->actionBarTitle:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 131
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->actionBarTitle:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(I)V

    .line 133
    :cond_0
    return-void
.end method

.method public setTitle(Ljava/lang/CharSequence;)V
    .locals 1
    .param p1, "title"    # Ljava/lang/CharSequence;

    .prologue
    .line 121
    invoke-super {p0, p1}, Landroid/app/Activity;->setTitle(Ljava/lang/CharSequence;)V

    .line 122
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->actionBarTitle:Landroid/widget/TextView;

    if-eqz v0, :cond_0

    .line 123
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->actionBarTitle:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 125
    :cond_0
    return-void
.end method

.method public setupPassiveGestureDetector(Landroid/view/View;I)V
    .locals 1
    .param p1, "parentView"    # Landroid/view/View;
    .param p2, "resId"    # I

    .prologue
    .line 155
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->baseActivityDelegate:Lcom/comcast/cim/android/view/common/BaseActivityDelegate;

    invoke-virtual {v0, p1, p2, p0}, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->setupPassiveGestureDetector(Landroid/view/View;ILcom/comcast/cim/android/accessibility/PassiveStateChangeListener;)V

    .line 156
    return-void
.end method

.method protected setupTalkDelegateDefault()V
    .locals 1

    .prologue
    .line 150
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->baseActivityDelegate:Lcom/comcast/cim/android/view/common/BaseActivityDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->setupTalkDelegateDefault()V

    .line 151
    return-void
.end method

.method protected setupTalkDelegateForAccessibilityViaLayout()V
    .locals 1

    .prologue
    .line 146
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivity;->baseActivityDelegate:Lcom/comcast/cim/android/view/common/BaseActivityDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->setupTalkDelegateForAccessibilityViaLayout()V

    .line 147
    return-void
.end method
