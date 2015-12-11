.class public Lcom/comcast/cim/android/view/common/BaseActivityDelegate;
.super Ljava/lang/Object;
.source "BaseActivityDelegate.java"


# instance fields
.field private final accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

.field private final activity:Landroid/app/Activity;

.field private final androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

.field private final customLayoutInflaterFactory:Landroid/view/LayoutInflater$Factory;

.field private final inputMethodManager:Landroid/view/inputmethod/InputMethodManager;

.field private final orientationStrategyProvider:Lcom/comcast/cim/android/view/common/OrientationStrategyProvider;

.field private speechDelegate:Lcom/comcast/cim/android/accessibility/SpeechDelegate;

.field private talkDelegate:Lcom/comcast/cim/android/accessibility/TalkDelegate;

.field private final talkDelegateFactory:Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;

.field private wasInAccessibilityMode:Z


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/comcast/cim/android/view/common/OrientationStrategyProvider;Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;Lcom/comcast/cim/android/accessibility/AccessibilityUtil;Landroid/view/inputmethod/InputMethodManager;Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "orientationStrategyProvider"    # Lcom/comcast/cim/android/view/common/OrientationStrategyProvider;
    .param p3, "androidDevice"    # Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;
    .param p4, "accessibilityUtil"    # Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
    .param p5, "inputMethodManager"    # Landroid/view/inputmethod/InputMethodManager;
    .param p6, "talkDelegateFactory"    # Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;

    .prologue
    .line 39
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getLayoutInflatorFactory()Landroid/view/LayoutInflater$Factory;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->customLayoutInflaterFactory:Landroid/view/LayoutInflater$Factory;

    .line 40
    iput-object p1, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->activity:Landroid/app/Activity;

    .line 41
    iput-object p2, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->orientationStrategyProvider:Lcom/comcast/cim/android/view/common/OrientationStrategyProvider;

    .line 42
    iput-object p3, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    .line 43
    iput-object p4, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    .line 44
    iput-object p5, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->inputMethodManager:Landroid/view/inputmethod/InputMethodManager;

    .line 45
    iput-object p6, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->talkDelegateFactory:Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;

    .line 48
    return-void
.end method


# virtual methods
.method public addSpeechListener(Lcom/comcast/cim/android/accessibility/SpeechListener;)V
    .locals 1
    .param p1, "speechListener"    # Lcom/comcast/cim/android/accessibility/SpeechListener;

    .prologue
    .line 153
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->speechDelegate:Lcom/comcast/cim/android/accessibility/SpeechDelegate;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->addSpeechListener(Lcom/comcast/cim/android/accessibility/SpeechListener;)V

    .line 154
    return-void
.end method

.method public checkTalkBackModeOnResume()V
    .locals 1

    .prologue
    .line 91
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->checkTalkBackModeOnResume(Landroid/content/Intent;)V

    .line 92
    return-void
.end method

.method public checkTalkBackModeOnResume(Landroid/content/Intent;)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 95
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v0

    iget-boolean v1, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->wasInAccessibilityMode:Z

    if-eq v0, v1, :cond_1

    .line 96
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v0

    iput-boolean v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->wasInAccessibilityMode:Z

    .line 98
    if-nez p1, :cond_0

    .line 99
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->activity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object p1

    .line 100
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->activity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 103
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->activity:Landroid/app/Activity;

    invoke-virtual {v0, p1}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 105
    :cond_1
    return-void
.end method

.method public createView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 79
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->customLayoutInflaterFactory:Landroid/view/LayoutInflater$Factory;

    invoke-interface {v0, p1, p2, p3}, Landroid/view/LayoutInflater$Factory;->onCreateView(Ljava/lang/String;Landroid/content/Context;Landroid/util/AttributeSet;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public getSpeechDelegate()Lcom/comcast/cim/android/accessibility/SpeechDelegate;
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->speechDelegate:Lcom/comcast/cim/android/accessibility/SpeechDelegate;

    return-object v0
.end method

.method public getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;
    .locals 3

    .prologue
    .line 162
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->talkDelegate:Lcom/comcast/cim/android/accessibility/TalkDelegate;

    if-nez v0, :cond_0

    .line 163
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->talkDelegateFactory:Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;

    iget-object v1, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->activity:Landroid/app/Activity;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;->getTalkDelegate(Landroid/app/Activity;Landroid/view/View;)Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->talkDelegate:Lcom/comcast/cim/android/accessibility/TalkDelegate;

    .line 166
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->talkDelegate:Lcom/comcast/cim/android/accessibility/TalkDelegate;

    return-object v0
.end method

.method public isAccessibilityEnabled()Z
    .locals 1

    .prologue
    .line 108
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v0

    return v0
.end method

.method protected onActivityResult(IILandroid/content/Intent;)V
    .locals 1
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 113
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->speechDelegate:Lcom/comcast/cim/android/accessibility/SpeechDelegate;

    invoke-virtual {v0, p1, p2, p3}, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->onActivityResult(IILandroid/content/Intent;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 116
    :cond_0
    return-void
.end method

.method public onCreate()V
    .locals 2

    .prologue
    .line 51
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->activity:Landroid/app/Activity;

    iget-object v1, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->orientationStrategyProvider:Lcom/comcast/cim/android/view/common/OrientationStrategyProvider;

    invoke-interface {v1}, Lcom/comcast/cim/android/view/common/OrientationStrategyProvider;->getOrientationStrategy()Lcom/comcast/cim/android/view/common/OrientationStrategy;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/android/view/common/OrientationStrategy;->getAppropriateOrientation()I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/app/Activity;->setRequestedOrientation(I)V

    .line 53
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->isDebuggable()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 54
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->activity:Landroid/app/Activity;

    invoke-static {v0}, Lcom/android/debug/hv/ViewServer;->get(Landroid/content/Context;)Lcom/android/debug/hv/ViewServer;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->activity:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/android/debug/hv/ViewServer;->addWindow(Landroid/app/Activity;)V

    .line 57
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v0

    iput-boolean v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->wasInAccessibilityMode:Z

    .line 59
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    .line 60
    new-instance v0, Lcom/comcast/cim/android/accessibility/SpeechDelegate;

    iget-object v1, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->activity:Landroid/app/Activity;

    invoke-direct {v0, v1}, Lcom/comcast/cim/android/accessibility/SpeechDelegate;-><init>(Landroid/app/Activity;)V

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->speechDelegate:Lcom/comcast/cim/android/accessibility/SpeechDelegate;

    .line 61
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->talkDelegate:Lcom/comcast/cim/android/accessibility/TalkDelegate;

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->ignoreAnnounceTitleOnce()V

    .line 62
    return-void
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 72
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->isDebuggable()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 73
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->activity:Landroid/app/Activity;

    invoke-static {v0}, Lcom/android/debug/hv/ViewServer;->get(Landroid/content/Context;)Lcom/android/debug/hv/ViewServer;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->activity:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/android/debug/hv/ViewServer;->removeWindow(Landroid/app/Activity;)V

    .line 75
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->talkDelegate:Lcom/comcast/cim/android/accessibility/TalkDelegate;

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->onDestroy()V

    .line 76
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 65
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->isDebuggable()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 66
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->activity:Landroid/app/Activity;

    invoke-static {v0}, Lcom/android/debug/hv/ViewServer;->get(Landroid/content/Context;)Lcom/android/debug/hv/ViewServer;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->activity:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/android/debug/hv/ViewServer;->setFocusedWindow(Landroid/app/Activity;)V

    .line 68
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->talkDelegate:Lcom/comcast/cim/android/accessibility/TalkDelegate;

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->announceTitle()V

    .line 69
    return-void
.end method

.method public onSpeechSwipe(Ljava/lang/Class;)V
    .locals 1
    .param p1, "clazz"    # Ljava/lang/Class;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->talkDelegate:Lcom/comcast/cim/android/accessibility/TalkDelegate;

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->stopSpeaking()V

    .line 124
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->speechDelegate:Lcom/comcast/cim/android/accessibility/SpeechDelegate;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->getSpeechInput(Ljava/lang/Class;)V

    .line 125
    return-void
.end method

.method public removeSpeechListener(Lcom/comcast/cim/android/accessibility/SpeechListener;)V
    .locals 1
    .param p1, "speechListener"    # Lcom/comcast/cim/android/accessibility/SpeechListener;

    .prologue
    .line 157
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->speechDelegate:Lcom/comcast/cim/android/accessibility/SpeechDelegate;

    invoke-virtual {v0, p1}, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->removeSpeechListener(Lcom/comcast/cim/android/accessibility/SpeechListener;)V

    .line 158
    return-void
.end method

.method public setupPassiveGestureDetector(Landroid/view/View;ILcom/comcast/cim/android/accessibility/PassiveStateChangeListener;)V
    .locals 4
    .param p1, "parentView"    # Landroid/view/View;
    .param p2, "resId"    # I
    .param p3, "passiveGestureListener"    # Lcom/comcast/cim/android/accessibility/PassiveStateChangeListener;

    .prologue
    .line 144
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->isAccessibilityEnabled()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 146
    invoke-virtual {p1, p2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/android/accessibility/GestureListenerLayout;

    .line 147
    .local v0, "gestureListenerLayout":Lcom/comcast/cim/android/accessibility/GestureListenerLayout;
    new-instance v1, Landroid/view/GestureDetector;

    iget-object v2, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->activity:Landroid/app/Activity;

    new-instance v3, Lcom/comcast/cim/android/accessibility/PassiveGestureListener;

    invoke-direct {v3, p3}, Lcom/comcast/cim/android/accessibility/PassiveGestureListener;-><init>(Lcom/comcast/cim/android/accessibility/PassiveStateChangeListener;)V

    invoke-direct {v1, v2, v3}, Landroid/view/GestureDetector;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V

    .line 148
    .local v1, "passiveGestureDetector":Landroid/view/GestureDetector;
    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/accessibility/GestureListenerLayout;->setGestureListener(Landroid/view/GestureDetector;)V

    .line 150
    .end local v0    # "gestureListenerLayout":Lcom/comcast/cim/android/accessibility/GestureListenerLayout;
    .end local v1    # "passiveGestureDetector":Landroid/view/GestureDetector;
    :cond_0
    return-void
.end method

.method protected setupTalkDelegateDefault()V
    .locals 2

    .prologue
    .line 130
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->isAccessibilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 131
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->talkDelegateFactory:Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;

    iget-object v1, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->activity:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;->getDefaultTalkDelegate(Landroid/app/Activity;)Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->talkDelegate:Lcom/comcast/cim/android/accessibility/TalkDelegate;

    .line 133
    :cond_0
    return-void
.end method

.method protected setupTalkDelegateForAccessibilityViaLayout()V
    .locals 3

    .prologue
    .line 137
    invoke-virtual {p0}, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->isAccessibilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 138
    iget-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->talkDelegateFactory:Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;

    iget-object v1, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->activity:Landroid/app/Activity;

    iget-object v2, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->activity:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;->getTalkDelegate(Landroid/app/Activity;Landroid/view/View;)Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/android/view/common/BaseActivityDelegate;->talkDelegate:Lcom/comcast/cim/android/accessibility/TalkDelegate;

    .line 140
    :cond_0
    return-void
.end method
