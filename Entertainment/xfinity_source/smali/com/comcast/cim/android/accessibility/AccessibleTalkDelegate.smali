.class public Lcom/comcast/cim/android/accessibility/AccessibleTalkDelegate;
.super Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;
.source "AccessibleTalkDelegate.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/android/accessibility/AccessibleTalkDelegate$SpeakDelayRunnable;
    }
.end annotation


# instance fields
.field protected final accessibilityView:Landroid/view/View;

.field final handler:Landroid/os/Handler;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Landroid/view/View;Lcom/comcast/cim/android/accessibility/AccessibilityUtil;)V
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "view"    # Landroid/view/View;
    .param p3, "accessibilityUtil"    # Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    .prologue
    const/4 v1, 0x1

    .line 15
    invoke-direct {p0, p1, v1}, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;-><init>(Landroid/app/Activity;Z)V

    .line 11
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/android/accessibility/AccessibleTalkDelegate;->handler:Landroid/os/Handler;

    .line 17
    if-nez p2, :cond_0

    .line 18
    invoke-virtual {p1}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getRootView()Landroid/view/View;

    move-result-object p2

    .line 19
    invoke-virtual {p3, p2, v1}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->setImportantForAccessibility(Landroid/view/View;I)V

    .line 22
    :cond_0
    iput-object p2, p0, Lcom/comcast/cim/android/accessibility/AccessibleTalkDelegate;->accessibilityView:Landroid/view/View;

    .line 23
    return-void
.end method


# virtual methods
.method public onDestroy()V
    .locals 2

    .prologue
    .line 42
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/AccessibleTalkDelegate;->handler:Landroid/os/Handler;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacksAndMessages(Ljava/lang/Object;)V

    .line 43
    return-void
.end method

.method public speak(Ljava/lang/String;I)V
    .locals 4
    .param p1, "sayWhat"    # Ljava/lang/String;
    .param p2, "queueMode"    # I

    .prologue
    .line 37
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/AccessibleTalkDelegate;->handler:Landroid/os/Handler;

    new-instance v1, Lcom/comcast/cim/android/accessibility/AccessibleTalkDelegate$SpeakDelayRunnable;

    invoke-direct {v1, p0, p1}, Lcom/comcast/cim/android/accessibility/AccessibleTalkDelegate$SpeakDelayRunnable;-><init>(Lcom/comcast/cim/android/accessibility/AccessibleTalkDelegate;Ljava/lang/String;)V

    const-wide/16 v2, 0xc8

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 38
    return-void
.end method

.method public speakNow(Ljava/lang/String;)V
    .locals 1
    .param p1, "sayWhat"    # Ljava/lang/String;

    .prologue
    .line 46
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/AccessibleTalkDelegate;->accessibilityView:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 47
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/AccessibleTalkDelegate;->accessibilityView:Landroid/view/View;

    invoke-virtual {v0, p1}, Landroid/view/View;->announceForAccessibility(Ljava/lang/CharSequence;)V

    .line 49
    :cond_0
    return-void
.end method

.method public stopSpeaking()V
    .locals 2

    .prologue
    .line 27
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/AccessibleTalkDelegate;->accessibilityView:Landroid/view/View;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/view/View;->announceForAccessibility(Ljava/lang/CharSequence;)V

    .line 28
    return-void
.end method
