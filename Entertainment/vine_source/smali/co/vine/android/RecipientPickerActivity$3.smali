.class Lco/vine/android/RecipientPickerActivity$3;
.super Ljava/lang/Object;
.source "RecipientPickerActivity.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/RecipientPickerActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/RecipientPickerActivity;


# direct methods
.method constructor <init>(Lco/vine/android/RecipientPickerActivity;)V
    .locals 0

    .prologue
    .line 235
    iput-object p1, p0, Lco/vine/android/RecipientPickerActivity$3;->this$0:Lco/vine/android/RecipientPickerActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 2
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 242
    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity$3;->this$0:Lco/vine/android/RecipientPickerActivity;

    # getter for: Lco/vine/android/RecipientPickerActivity;->mOnboardingOverlay:Landroid/widget/TextView;
    invoke-static {v0}, Lco/vine/android/RecipientPickerActivity;->access$100(Lco/vine/android/RecipientPickerActivity;)Landroid/widget/TextView;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 243
    iget-object v0, p0, Lco/vine/android/RecipientPickerActivity$3;->this$0:Lco/vine/android/RecipientPickerActivity;

    # getter for: Lco/vine/android/RecipientPickerActivity;->mOnboardingOverlay:Landroid/widget/TextView;
    invoke-static {v0}, Lco/vine/android/RecipientPickerActivity;->access$100(Lco/vine/android/RecipientPickerActivity;)Landroid/widget/TextView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setClickable(Z)V

    .line 244
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 248
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 238
    return-void
.end method
