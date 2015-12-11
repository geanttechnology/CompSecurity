.class public Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;
.super Ljava/lang/Object;
.source "TalkDelegateFactory.java"


# instance fields
.field protected final accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/android/accessibility/AccessibilityUtil;)V
    .locals 0
    .param p1, "accessibilityUtil"    # Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 12
    iput-object p1, p0, Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    .line 13
    return-void
.end method


# virtual methods
.method public getDefaultTalkDelegate(Landroid/app/Activity;)Lcom/comcast/cim/android/accessibility/TalkDelegate;
    .locals 1
    .param p1, "context"    # Landroid/app/Activity;

    .prologue
    .line 36
    new-instance v0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;

    invoke-direct {v0, p1}, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;-><init>(Landroid/app/Activity;)V

    return-object v0
.end method

.method public getTalkDelegate(Landroid/app/Activity;Landroid/view/View;)Lcom/comcast/cim/android/accessibility/TalkDelegate;
    .locals 2
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "view"    # Landroid/view/View;

    .prologue
    .line 17
    iget-object v0, p0, Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 19
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-lt v0, v1, :cond_0

    .line 20
    new-instance v0, Lcom/comcast/cim/android/accessibility/AccessibleTalkDelegate;

    iget-object v1, p0, Lcom/comcast/cim/android/accessibility/TalkDelegateFactory;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-direct {v0, p1, p2, v1}, Lcom/comcast/cim/android/accessibility/AccessibleTalkDelegate;-><init>(Landroid/app/Activity;Landroid/view/View;Lcom/comcast/cim/android/accessibility/AccessibilityUtil;)V

    .line 26
    :goto_0
    return-object v0

    .line 22
    :cond_0
    new-instance v0, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;

    invoke-direct {v0, p1}, Lcom/comcast/cim/android/accessibility/DefaultTalkDelegate;-><init>(Landroid/app/Activity;)V

    goto :goto_0

    .line 26
    :cond_1
    new-instance v0, Lcom/comcast/cim/android/accessibility/DummyTalkDelegate;

    invoke-direct {v0, p1}, Lcom/comcast/cim/android/accessibility/DummyTalkDelegate;-><init>(Landroid/app/Activity;)V

    goto :goto_0
.end method
