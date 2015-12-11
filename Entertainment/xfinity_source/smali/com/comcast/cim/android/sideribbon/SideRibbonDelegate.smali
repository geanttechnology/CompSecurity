.class public Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;
.super Ljava/lang/Object;
.source "SideRibbonDelegate.java"

# interfaces
.implements Lcom/comcast/cim/android/sideribbon/SlideClosedRequestListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$RibbonStateChangeListener;,
        Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;,
        Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$SlideInGestureListener;,
        Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$closeAnimationListener;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

.field private final animationInterpolator:Landroid/view/animation/Interpolator;

.field private final closeAnimation:Landroid/view/animation/Animation;

.field private final closeShadowAnimation:Landroid/view/animation/Animation;

.field private final contentContainerGestureDetector:Landroid/view/GestureDetector;

.field private final contentContainerGestureDetectorAtRest:Landroid/view/GestureDetector;

.field private final contentContainerParent:Landroid/view/ViewGroup;

.field protected focusToggleState:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Landroid/view/View;",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private final openAnimation:Landroid/view/animation/Animation;

.field private final openShadowAnimation:Landroid/view/animation/Animation;

.field private passiveGestureListener:Lcom/comcast/cim/android/accessibility/PassiveGestureListener;

.field private final passiveStateChangeListeners:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/comcast/cim/android/accessibility/PassiveStateChangeListener;",
            ">;"
        }
    .end annotation
.end field

.field private final ribbonContainer:Landroid/view/ViewGroup;

.field private final ribbonStateChangeListeners:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$RibbonStateChangeListener;",
            ">;"
        }
    .end annotation
.end field

.field private final ribbonWidth:I

.field private final rootContainer:Landroid/view/ViewGroup;

.field private final shadowView:Landroid/view/View;

.field private final slideDuration:J

.field private state:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

.field private statusBarHeight:I

.field private final touchyContentContainer:Landroid/view/ViewGroup;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 55
    const-class v0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/view/ViewGroup;Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;Lcom/comcast/cim/android/accessibility/AccessibilityUtil;)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "contentContainerParent"    # Landroid/view/ViewGroup;
    .param p3, "configuration"    # Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;
    .param p4, "accessibilityUtil"    # Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    .prologue
    const/4 v7, 0x0

    const/4 v6, -0x1

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 65
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 31
    iput v6, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->statusBarHeight:I

    .line 33
    sget-object v1, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;->CLOSED:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    iput-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->state:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    .line 52
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    invoke-static {v1}, Ljava/util/Collections;->synchronizedSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v1

    iput-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonStateChangeListeners:Ljava/util/Set;

    .line 53
    new-instance v1, Ljava/util/HashSet;

    invoke-direct {v1}, Ljava/util/HashSet;-><init>()V

    invoke-static {v1}, Ljava/util/Collections;->synchronizedSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v1

    iput-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->passiveStateChangeListeners:Ljava/util/Set;

    .line 59
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    iput-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->focusToggleState:Ljava/util/HashMap;

    .line 67
    iput-object p2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->contentContainerParent:Landroid/view/ViewGroup;

    .line 68
    iput-object p4, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    .line 71
    invoke-virtual {p3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->getRibbonWidth()I

    move-result v1

    iput v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonWidth:I

    .line 72
    invoke-virtual {p3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->getSlideDuration()J

    move-result-wide v2

    iput-wide v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->slideDuration:J

    .line 73
    invoke-virtual {p3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->getAnimationInterpolator()Landroid/view/animation/Interpolator;

    move-result-object v1

    iput-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->animationInterpolator:Landroid/view/animation/Interpolator;

    .line 76
    new-instance v1, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$1;

    invoke-direct {v1, p0, p1, p4, p1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$1;-><init>(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;Landroid/content/Context;Lcom/comcast/cim/android/accessibility/AccessibilityUtil;Landroid/content/Context;)V

    iput-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->touchyContentContainer:Landroid/view/ViewGroup;

    .line 115
    new-instance v1, Landroid/view/GestureDetector;

    new-instance v2, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$SlideInGestureListener;

    invoke-direct {v2, p0, p0}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$SlideInGestureListener;-><init>(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)V

    invoke-direct {v1, p1, v2}, Landroid/view/GestureDetector;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V

    iput-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->contentContainerGestureDetector:Landroid/view/GestureDetector;

    .line 116
    new-instance v1, Lcom/comcast/cim/android/accessibility/PassiveGestureListener;

    iget-object v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->passiveStateChangeListeners:Ljava/util/Set;

    invoke-direct {v1, v2}, Lcom/comcast/cim/android/accessibility/PassiveGestureListener;-><init>(Ljava/util/Set;)V

    iput-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->passiveGestureListener:Lcom/comcast/cim/android/accessibility/PassiveGestureListener;

    .line 117
    new-instance v1, Landroid/view/GestureDetector;

    iget-object v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->passiveGestureListener:Lcom/comcast/cim/android/accessibility/PassiveGestureListener;

    invoke-direct {v1, p1, v2}, Landroid/view/GestureDetector;-><init>(Landroid/content/Context;Landroid/view/GestureDetector$OnGestureListener;)V

    iput-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->contentContainerGestureDetectorAtRest:Landroid/view/GestureDetector;

    .line 119
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->touchyContentContainer:Landroid/view/ViewGroup;

    invoke-virtual {p2}, Landroid/view/ViewGroup;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 121
    new-instance v1, Landroid/view/View;

    invoke-direct {v1, p1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->shadowView:Landroid/view/View;

    .line 124
    new-instance v1, Landroid/widget/RelativeLayout;

    invoke-virtual {p2}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->rootContainer:Landroid/view/ViewGroup;

    .line 128
    new-instance v1, Landroid/widget/FrameLayout;

    invoke-direct {v1, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonContainer:Landroid/view/ViewGroup;

    .line 129
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonContainer:Landroid/view/ViewGroup;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 131
    invoke-virtual {p4}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 132
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonContainer:Landroid/view/ViewGroup;

    invoke-virtual {v1, v5}, Landroid/view/ViewGroup;->setFocusable(Z)V

    .line 133
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonContainer:Landroid/view/ViewGroup;

    invoke-virtual {v1, v5}, Landroid/view/ViewGroup;->setFocusableInTouchMode(Z)V

    .line 134
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonContainer:Landroid/view/ViewGroup;

    sget v2, Lcom/comcast/cim/android/R$string;->content_description_menu:I

    invoke-virtual {p1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 136
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonContainer:Landroid/view/ViewGroup;

    invoke-virtual {p4, v1, v5}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->setImportantForAccessibility(Landroid/view/View;I)V

    .line 141
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->rootContainer:Landroid/view/ViewGroup;

    iget-object v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonContainer:Landroid/view/ViewGroup;

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 143
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->rootContainer:Landroid/view/ViewGroup;

    iget-object v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->shadowView:Landroid/view/View;

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 144
    invoke-virtual {p3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->getShadowWidth()I

    move-result v0

    .line 145
    .local v0, "shadowWidth":I
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->shadowView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    iput v0, v1, Landroid/view/ViewGroup$LayoutParams;->width:I

    .line 146
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->shadowView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    iput v6, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 147
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->shadowView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup$MarginLayoutParams;

    neg-int v2, v0

    neg-int v3, v0

    invoke-virtual {v1, v2, v7, v3, v7}, Landroid/view/ViewGroup$MarginLayoutParams;->setMargins(IIII)V

    .line 149
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->shadowView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->requestLayout()V

    .line 152
    invoke-virtual {p3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->getShadowResource()Ljava/lang/Integer;

    move-result-object v1

    if-eqz v1, :cond_4

    .line 153
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->shadowView:Landroid/view/View;

    invoke-virtual {p3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->getShadowResource()Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/view/View;->setBackgroundResource(I)V

    .line 160
    :cond_1
    :goto_0
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->rootContainer:Landroid/view/ViewGroup;

    iget-object v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->touchyContentContainer:Landroid/view/ViewGroup;

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 163
    invoke-virtual {p3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->getBackgroundResource()Ljava/lang/Integer;

    move-result-object v1

    if-eqz v1, :cond_6

    .line 164
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonContainer:Landroid/view/ViewGroup;

    invoke-virtual {p3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->getBackgroundResource()Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->setBackgroundResource(I)V

    .line 171
    :cond_2
    :goto_1
    iget v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonWidth:I

    int-to-float v1, v1

    invoke-direct {p0, v4, v1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->getSlideAnimation(FF)Landroid/view/animation/Animation;

    move-result-object v1

    iput-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->openShadowAnimation:Landroid/view/animation/Animation;

    .line 172
    iget v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonWidth:I

    int-to-float v1, v1

    invoke-direct {p0, v4, v1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->getSlideAnimation(FF)Landroid/view/animation/Animation;

    move-result-object v1

    iput-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->openAnimation:Landroid/view/animation/Animation;

    .line 173
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->openAnimation:Landroid/view/animation/Animation;

    new-instance v2, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;

    invoke-direct {v2, p0, p4, v0}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$2;-><init>(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;Lcom/comcast/cim/android/accessibility/AccessibilityUtil;I)V

    invoke-virtual {v1, v2}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 209
    iget v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonWidth:I

    neg-int v1, v1

    int-to-float v1, v1

    invoke-direct {p0, v4, v1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->getSlideAnimation(FF)Landroid/view/animation/Animation;

    move-result-object v1

    iput-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->closeShadowAnimation:Landroid/view/animation/Animation;

    .line 210
    iget v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonWidth:I

    neg-int v1, v1

    int-to-float v1, v1

    invoke-direct {p0, v4, v1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->getSlideAnimation(FF)Landroid/view/animation/Animation;

    move-result-object v1

    iput-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->closeAnimation:Landroid/view/animation/Animation;

    .line 213
    invoke-virtual {p2}, Landroid/view/ViewGroup;->getRootView()Landroid/view/View;

    move-result-object v1

    if-ne p2, v1, :cond_3

    .line 214
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonContainer:Landroid/view/ViewGroup;

    invoke-direct {p0, v1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->adjustMenuTopForNotificationBar(Landroid/view/View;)V

    .line 216
    :cond_3
    return-void

    .line 154
    :cond_4
    invoke-virtual {p3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->getShadowDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    if-eqz v1, :cond_5

    .line 155
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->shadowView:Landroid/view/View;

    invoke-virtual {p3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->getShadowDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/view/View;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_0

    .line 156
    :cond_5
    invoke-virtual {p3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->getBackgroundColor()Ljava/lang/Integer;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 157
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->shadowView:Landroid/view/View;

    invoke-virtual {p3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->getShadowColor()I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/view/View;->setBackgroundColor(I)V

    goto :goto_0

    .line 165
    :cond_6
    invoke-virtual {p3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->getBackgroundDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v1

    if-eqz v1, :cond_7

    .line 166
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonContainer:Landroid/view/ViewGroup;

    invoke-virtual {p3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->getBackgroundDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    goto :goto_1

    .line 167
    :cond_7
    invoke-virtual {p3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->getBackgroundColor()Ljava/lang/Integer;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 168
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonContainer:Landroid/view/ViewGroup;

    invoke-virtual {p3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegateBuilder$Configuration;->getBackgroundColor()Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->setBackgroundColor(I)V

    goto :goto_1
.end method

.method static synthetic access$000(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->state:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    return-object v0
.end method

.method static synthetic access$100(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/GestureDetector;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->contentContainerGestureDetector:Landroid/view/GestureDetector;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)I
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->getStatusBarHeight()I

    move-result v0

    return v0
.end method

.method static synthetic access$1100(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;Landroid/view/View;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;
    .param p1, "x1"    # Landroid/view/View;

    .prologue
    .line 28
    invoke-direct {p0, p1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->adjustMenuTopForNotificationBar(Landroid/view/View;)V

    return-void
.end method

.method static synthetic access$1200(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/ViewGroup;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->contentContainerParent:Landroid/view/ViewGroup;

    return-object v0
.end method

.method static synthetic access$1300(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    return-object v0
.end method

.method static synthetic access$200(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Lcom/comcast/cim/android/accessibility/PassiveGestureListener;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->passiveGestureListener:Lcom/comcast/cim/android/accessibility/PassiveGestureListener;

    return-object v0
.end method

.method static synthetic access$300(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/GestureDetector;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->contentContainerGestureDetectorAtRest:Landroid/view/GestureDetector;

    return-object v0
.end method

.method static synthetic access$400(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/ViewGroup;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonContainer:Landroid/view/ViewGroup;

    return-object v0
.end method

.method static synthetic access$500(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;)V
    .locals 0
    .param p0, "x0"    # Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;
    .param p1, "x1"    # Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    .prologue
    .line 28
    invoke-direct {p0, p1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->updateState(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;)V

    return-void
.end method

.method static synthetic access$600(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/ViewGroup;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->touchyContentContainer:Landroid/view/ViewGroup;

    return-object v0
.end method

.method static synthetic access$700(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)I
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    .prologue
    .line 28
    iget v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonWidth:I

    return v0
.end method

.method static synthetic access$800(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;

    .prologue
    .line 28
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->shadowView:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$902(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;I)I
    .locals 0
    .param p0, "x0"    # Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;
    .param p1, "x1"    # I

    .prologue
    .line 28
    iput p1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->statusBarHeight:I

    return p1
.end method

.method private adjustMenuTopForNotificationBar(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v2, -0x1

    .line 302
    iget v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->statusBarHeight:I

    if-ne v1, v2, :cond_0

    .line 303
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->contentContainerParent:Landroid/view/ViewGroup;

    invoke-virtual {v1}, Landroid/view/ViewGroup;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v1

    new-instance v2, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$3;

    invoke-direct {v2, p0, p1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$3;-><init>(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;Landroid/view/View;)V

    invoke-virtual {v1, v2}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 325
    :goto_0
    return-void

    .line 315
    :cond_0
    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v0, v2, v2}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 320
    .local v0, "params":Landroid/widget/RelativeLayout$LayoutParams;
    iget v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->statusBarHeight:I

    iput v1, v0, Landroid/widget/RelativeLayout$LayoutParams;->topMargin:I

    .line 322
    invoke-virtual {p1, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 323
    invoke-virtual {p1}, Landroid/view/View;->requestLayout()V

    goto :goto_0
.end method

.method private getResizeAnimation(Landroid/view/View;FF)Landroid/view/animation/Animation;
    .locals 6
    .param p1, "view"    # Landroid/view/View;
    .param p2, "from"    # F
    .param p3, "to"    # F

    .prologue
    const/high16 v3, -0x40800000    # -1.0f

    .line 406
    new-instance v0, Lcom/comcast/cim/cmasl/android/util/view/animation/ResizeAnimation;

    move-object v1, p1

    move v2, p2

    move v4, p3

    move v5, v3

    invoke-direct/range {v0 .. v5}, Lcom/comcast/cim/cmasl/android/util/view/animation/ResizeAnimation;-><init>(Landroid/view/View;FFFF)V

    .line 407
    .local v0, "animation":Landroid/view/animation/Animation;
    iget-wide v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->slideDuration:J

    invoke-virtual {v0, v2, v3}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 408
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setFillEnabled(Z)V

    .line 409
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->animationInterpolator:Landroid/view/animation/Interpolator;

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 411
    return-object v0
.end method

.method private getSlideAnimation(FF)Landroid/view/animation/Animation;
    .locals 4
    .param p1, "from"    # F
    .param p2, "to"    # F

    .prologue
    const/4 v1, 0x0

    .line 397
    new-instance v0, Landroid/view/animation/TranslateAnimation;

    invoke-direct {v0, p1, p2, v1, v1}, Landroid/view/animation/TranslateAnimation;-><init>(FFFF)V

    .line 398
    .local v0, "animation":Landroid/view/animation/Animation;
    iget-wide v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->slideDuration:J

    invoke-virtual {v0, v2, v3}, Landroid/view/animation/Animation;->setDuration(J)V

    .line 399
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setFillEnabled(Z)V

    .line 400
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->animationInterpolator:Landroid/view/animation/Interpolator;

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setInterpolator(Landroid/view/animation/Interpolator;)V

    .line 402
    return-object v0
.end method

.method private getStatusBarHeight()I
    .locals 2

    .prologue
    .line 328
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    .line 329
    .local v0, "rectContentArea":Landroid/graphics/Rect;
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->contentContainerParent:Landroid/view/ViewGroup;

    invoke-virtual {v1, v0}, Landroid/view/ViewGroup;->getWindowVisibleDisplayFrame(Landroid/graphics/Rect;)V

    .line 330
    iget v1, v0, Landroid/graphics/Rect;->top:I

    return v1
.end method

.method private updateState(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;)V
    .locals 4
    .param p1, "newState"    # Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    .prologue
    .line 385
    iget-object v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonStateChangeListeners:Ljava/util/Set;

    monitor-enter v2

    .line 386
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->state:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    invoke-virtual {v1, p1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 387
    iput-object p1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->state:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    .line 389
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonStateChangeListeners:Ljava/util/Set;

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$RibbonStateChangeListener;

    .line 390
    .local v0, "listener":Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$RibbonStateChangeListener;
    iget-object v3, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->state:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    invoke-interface {v0, v3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$RibbonStateChangeListener;->onSideRibbonStateChanged(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;)V

    goto :goto_0

    .line 393
    .end local v0    # "listener":Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$RibbonStateChangeListener;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1

    :cond_0
    :try_start_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 394
    return-void
.end method


# virtual methods
.method public addPassiveStateChangeListener(Lcom/comcast/cim/android/accessibility/PassiveStateChangeListener;)V
    .locals 1
    .param p1, "passiveStateChangeListener"    # Lcom/comcast/cim/android/accessibility/PassiveStateChangeListener;

    .prologue
    .line 338
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->passiveStateChangeListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 339
    return-void
.end method

.method public addRibbonStateChangeListener(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$RibbonStateChangeListener;)V
    .locals 1
    .param p1, "ribbonStateChangeListener"    # Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$RibbonStateChangeListener;

    .prologue
    .line 334
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonStateChangeListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 335
    return-void
.end method

.method public getRibbonContainer()Landroid/view/ViewGroup;
    .locals 1

    .prologue
    .line 255
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonContainer:Landroid/view/ViewGroup;

    return-object v0
.end method

.method public getRibbonContentView()Landroid/view/View;
    .locals 2

    .prologue
    .line 259
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonContainer:Landroid/view/ViewGroup;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public handleBackPressed()Z
    .locals 2

    .prologue
    .line 236
    sget-object v0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;->CLOSED:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->state:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 237
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->slideClosed(Lcom/comcast/cim/android/sideribbon/SlideClosedListener;)V

    .line 238
    const/4 v0, 0x1

    .line 241
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public init()V
    .locals 3

    .prologue
    .line 219
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->contentContainerParent:Landroid/view/ViewGroup;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 222
    .local v0, "contentContainer":Landroid/view/View;
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->contentContainerParent:Landroid/view/ViewGroup;

    invoke-virtual {v1}, Landroid/view/ViewGroup;->removeAllViews()V

    .line 223
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->contentContainerParent:Landroid/view/ViewGroup;

    iget-object v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->rootContainer:Landroid/view/ViewGroup;

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 226
    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->touchyContentContainer:Landroid/view/ViewGroup;

    invoke-virtual {v1, v0}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 228
    return-void
.end method

.method public removeRibbonContentView()V
    .locals 1

    .prologue
    .line 263
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonContainer:Landroid/view/ViewGroup;

    invoke-virtual {v0}, Landroid/view/ViewGroup;->removeAllViews()V

    .line 264
    return-void
.end method

.method public setRibbonContentView(Landroid/view/View;)V
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 250
    invoke-virtual {p0}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->removeRibbonContentView()V

    .line 251
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonContainer:Landroid/view/ViewGroup;

    invoke-virtual {v0, p1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 252
    return-void
.end method

.method public slideClosed(Lcom/comcast/cim/android/sideribbon/SlideClosedListener;)V
    .locals 4
    .param p1, "slideClosedListener"    # Lcom/comcast/cim/android/sideribbon/SlideClosedListener;

    .prologue
    .line 287
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->state:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    sget-object v1, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;->OPEN:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    if-ne v0, v1, :cond_0

    .line 288
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->shadowView:Landroid/view/View;

    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->closeShadowAnimation:Landroid/view/animation/Animation;

    invoke-virtual {v0, v1}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 289
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->closeAnimation:Landroid/view/animation/Animation;

    new-instance v1, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$closeAnimationListener;

    invoke-direct {v1, p0, p1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$closeAnimationListener;-><init>(Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;Lcom/comcast/cim/android/sideribbon/SlideClosedListener;)V

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 290
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->touchyContentContainer:Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->closeAnimation:Landroid/view/animation/Animation;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->startAnimation(Landroid/view/animation/Animation;)V

    .line 291
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonContainer:Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonContainer:Landroid/view/ViewGroup;

    iget v2, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonWidth:I

    int-to-float v2, v2

    const/4 v3, 0x0

    invoke-direct {p0, v1, v2, v3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->getResizeAnimation(Landroid/view/View;FF)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->startAnimation(Landroid/view/animation/Animation;)V

    .line 293
    :cond_0
    return-void
.end method

.method public slideOpen()V
    .locals 4

    .prologue
    .line 278
    sget-object v0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;->CLOSED:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->state:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 279
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->shadowView:Landroid/view/View;

    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->openShadowAnimation:Landroid/view/animation/Animation;

    invoke-virtual {v0, v1}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 280
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonContainer:Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonContainer:Landroid/view/ViewGroup;

    const/4 v2, 0x0

    iget v3, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->ribbonWidth:I

    int-to-float v3, v3

    invoke-direct {p0, v1, v2, v3}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->getResizeAnimation(Landroid/view/View;FF)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->startAnimation(Landroid/view/animation/Animation;)V

    .line 282
    iget-object v0, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->touchyContentContainer:Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->openAnimation:Landroid/view/animation/Animation;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->startAnimation(Landroid/view/animation/Animation;)V

    .line 284
    :cond_0
    return-void
.end method

.method public toggleSlideIn()V
    .locals 2

    .prologue
    .line 267
    sget-object v0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$4;->$SwitchMap$com$comcast$cim$android$sideribbon$SideRibbonDelegate$State:[I

    iget-object v1, p0, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->state:Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;

    invoke-virtual {v1}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate$State;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 275
    :goto_0
    return-void

    .line 269
    :pswitch_0
    invoke-virtual {p0}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->slideOpen()V

    goto :goto_0

    .line 272
    :pswitch_1
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/comcast/cim/android/sideribbon/SideRibbonDelegate;->slideClosed(Lcom/comcast/cim/android/sideribbon/SlideClosedListener;)V

    goto :goto_0

    .line 267
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
