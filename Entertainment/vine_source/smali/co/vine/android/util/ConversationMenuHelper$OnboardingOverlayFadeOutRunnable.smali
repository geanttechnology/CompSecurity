.class Lco/vine/android/util/ConversationMenuHelper$OnboardingOverlayFadeOutRunnable;
.super Ljava/lang/Object;
.source "ConversationMenuHelper.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/util/ConversationMenuHelper;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "OnboardingOverlayFadeOutRunnable"
.end annotation


# instance fields
.field private mView:Landroid/view/View;

.field final synthetic this$0:Lco/vine/android/util/ConversationMenuHelper;


# direct methods
.method private constructor <init>(Lco/vine/android/util/ConversationMenuHelper;)V
    .locals 0

    .prologue
    .line 331
    iput-object p1, p0, Lco/vine/android/util/ConversationMenuHelper$OnboardingOverlayFadeOutRunnable;->this$0:Lco/vine/android/util/ConversationMenuHelper;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lco/vine/android/util/ConversationMenuHelper;Lco/vine/android/util/ConversationMenuHelper$1;)V
    .locals 0
    .param p1, "x0"    # Lco/vine/android/util/ConversationMenuHelper;
    .param p2, "x1"    # Lco/vine/android/util/ConversationMenuHelper$1;

    .prologue
    .line 331
    invoke-direct {p0, p1}, Lco/vine/android/util/ConversationMenuHelper$OnboardingOverlayFadeOutRunnable;-><init>(Lco/vine/android/util/ConversationMenuHelper;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 340
    iget-object v1, p0, Lco/vine/android/util/ConversationMenuHelper$OnboardingOverlayFadeOutRunnable;->this$0:Lco/vine/android/util/ConversationMenuHelper;

    # getter for: Lco/vine/android/util/ConversationMenuHelper;->mActivity:Lco/vine/android/BaseControllerActionBarActivity;
    invoke-static {v1}, Lco/vine/android/util/ConversationMenuHelper;->access$300(Lco/vine/android/util/ConversationMenuHelper;)Lco/vine/android/BaseControllerActionBarActivity;

    move-result-object v1

    const v2, 0x7f04000f

    invoke-static {v1, v2}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    .line 341
    .local v0, "animation":Landroid/view/animation/Animation;
    iget-object v1, p0, Lco/vine/android/util/ConversationMenuHelper$OnboardingOverlayFadeOutRunnable;->this$0:Lco/vine/android/util/ConversationMenuHelper;

    # getter for: Lco/vine/android/util/ConversationMenuHelper;->mMessageSentFadeListener:Landroid/view/animation/Animation$AnimationListener;
    invoke-static {v1}, Lco/vine/android/util/ConversationMenuHelper;->access$400(Lco/vine/android/util/ConversationMenuHelper;)Landroid/view/animation/Animation$AnimationListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 342
    iget-object v1, p0, Lco/vine/android/util/ConversationMenuHelper$OnboardingOverlayFadeOutRunnable;->mView:Landroid/view/View;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lco/vine/android/util/ConversationMenuHelper$OnboardingOverlayFadeOutRunnable;->mView:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getVisibility()I

    move-result v1

    if-nez v1, :cond_0

    .line 343
    iget-object v1, p0, Lco/vine/android/util/ConversationMenuHelper$OnboardingOverlayFadeOutRunnable;->mView:Landroid/view/View;

    invoke-virtual {v1, v0}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 345
    :cond_0
    return-void
.end method

.method public setView(Landroid/view/View;)V
    .locals 0
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 335
    iput-object p1, p0, Lco/vine/android/util/ConversationMenuHelper$OnboardingOverlayFadeOutRunnable;->mView:Landroid/view/View;

    .line 336
    return-void
.end method
