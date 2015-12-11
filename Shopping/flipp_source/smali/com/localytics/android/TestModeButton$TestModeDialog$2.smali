.class Lcom/localytics/android/TestModeButton$TestModeDialog$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# instance fields
.field final synthetic this$1:Lcom/localytics/android/TestModeButton$TestModeDialog;


# direct methods
.method constructor <init>(Lcom/localytics/android/TestModeButton$TestModeDialog;)V
    .locals 0

    .prologue
    .line 279
    iput-object p1, p0, Lcom/localytics/android/TestModeButton$TestModeDialog$2;->this$1:Lcom/localytics/android/TestModeButton$TestModeDialog;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 1

    .prologue
    .line 286
    iget-object v0, p0, Lcom/localytics/android/TestModeButton$TestModeDialog$2;->this$1:Lcom/localytics/android/TestModeButton$TestModeDialog;

    iget-object v0, v0, Lcom/localytics/android/TestModeButton$TestModeDialog;->this$0:Lcom/localytics/android/TestModeButton;

    invoke-virtual {v0}, Lcom/localytics/android/TestModeButton;->dismiss()V

    .line 287
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0

    .prologue
    .line 291
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0

    .prologue
    .line 282
    return-void
.end method
