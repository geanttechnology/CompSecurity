.class public Lio/branch/referral/Branch$BranchWindowCallback;
.super Ljava/lang/Object;
.source "Branch.java"

# interfaces
.implements Landroid/view/Window$Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lio/branch/referral/Branch;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "BranchWindowCallback"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/branch/referral/Branch$BranchWindowCallback$KeepDebugConnectionTask;
    }
.end annotation


# instance fields
.field private callback_:Landroid/view/Window$Callback;

.field private longPressed_:Ljava/lang/Runnable;

.field final synthetic this$0:Lio/branch/referral/Branch;


# direct methods
.method public constructor <init>(Lio/branch/referral/Branch;Landroid/view/Window$Callback;)V
    .locals 1
    .param p2, "callback"    # Landroid/view/Window$Callback;

    .prologue
    .line 3526
    iput-object p1, p0, Lio/branch/referral/Branch$BranchWindowCallback;->this$0:Lio/branch/referral/Branch;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3527
    iput-object p2, p0, Lio/branch/referral/Branch$BranchWindowCallback;->callback_:Landroid/view/Window$Callback;

    .line 3529
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->longPressed_:Ljava/lang/Runnable;

    if-nez v0, :cond_0

    .line 3530
    new-instance v0, Lio/branch/referral/Branch$BranchWindowCallback$1;

    invoke-direct {v0, p0, p1}, Lio/branch/referral/Branch$BranchWindowCallback$1;-><init>(Lio/branch/referral/Branch$BranchWindowCallback;Lio/branch/referral/Branch;)V

    iput-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->longPressed_:Ljava/lang/Runnable;

    .line 3552
    :cond_0
    return-void
.end method

.method static synthetic access$000(Lio/branch/referral/Branch$BranchWindowCallback;)Landroid/view/Window$Callback;
    .locals 1
    .param p0, "x0"    # Lio/branch/referral/Branch$BranchWindowCallback;

    .prologue
    .line 3522
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->callback_:Landroid/view/Window$Callback;

    return-object v0
.end method

.method static synthetic access$2700(Lio/branch/referral/Branch$BranchWindowCallback;)Ljava/lang/Runnable;
    .locals 1
    .param p0, "x0"    # Lio/branch/referral/Branch$BranchWindowCallback;

    .prologue
    .line 3522
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->longPressed_:Ljava/lang/Runnable;

    return-object v0
.end method


# virtual methods
.method public dispatchGenericMotionEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/MotionEvent;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xc
    .end annotation

    .prologue
    .line 3565
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->callback_:Landroid/view/Window$Callback;

    invoke-interface {v0, p1}, Landroid/view/Window$Callback;->dispatchGenericMotionEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method

.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 3570
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->callback_:Landroid/view/Window$Callback;

    invoke-interface {v0, p1}, Landroid/view/Window$Callback;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method public dispatchKeyShortcutEvent(Landroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/KeyEvent;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .prologue
    .line 3576
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->callback_:Landroid/view/Window$Callback;

    invoke-interface {v0, p1}, Landroid/view/Window$Callback;->dispatchKeyShortcutEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method public dispatchPopulateAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/accessibility/AccessibilityEvent;

    .prologue
    .line 3581
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->callback_:Landroid/view/Window$Callback;

    invoke-interface {v0, p1}, Landroid/view/Window$Callback;->dispatchPopulateAccessibilityEvent(Landroid/view/accessibility/AccessibilityEvent;)Z

    move-result v0

    return v0
.end method

.method public dispatchTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 4
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const-wide/16 v2, 0xbb8

    .line 3586
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    and-int/lit16 v0, v0, 0xff

    packed-switch v0, :pswitch_data_0

    .line 3609
    :cond_0
    :goto_0
    :pswitch_0
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->callback_:Landroid/view/Window$Callback;

    invoke-interface {v0, p1}, Landroid/view/Window$Callback;->dispatchTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0

    .line 3588
    :pswitch_1
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->systemObserver_:Lio/branch/referral/SystemObserver;
    invoke-static {v0}, Lio/branch/referral/Branch;->access$300(Lio/branch/referral/Branch;)Lio/branch/referral/SystemObserver;

    move-result-object v0

    invoke-virtual {v0}, Lio/branch/referral/SystemObserver;->isSimulator()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 3589
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->debugHandler_:Landroid/os/Handler;
    invoke-static {v0}, Lio/branch/referral/Branch;->access$200(Lio/branch/referral/Branch;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lio/branch/referral/Branch$BranchWindowCallback;->longPressed_:Ljava/lang/Runnable;

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0

    .line 3595
    :pswitch_2
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->debugHandler_:Landroid/os/Handler;
    invoke-static {v0}, Lio/branch/referral/Branch;->access$200(Lio/branch/referral/Branch;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lio/branch/referral/Branch$BranchWindowCallback;->longPressed_:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 3598
    :pswitch_3
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->debugHandler_:Landroid/os/Handler;
    invoke-static {v0}, Lio/branch/referral/Branch;->access$200(Lio/branch/referral/Branch;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lio/branch/referral/Branch$BranchWindowCallback;->longPressed_:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 3601
    :pswitch_4
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v0

    const/4 v1, 0x4

    if-ne v0, v1, :cond_0

    .line 3602
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->debugHandler_:Landroid/os/Handler;
    invoke-static {v0}, Lio/branch/referral/Branch;->access$200(Lio/branch/referral/Branch;)Landroid/os/Handler;

    move-result-object v0

    iget-object v1, p0, Lio/branch/referral/Branch$BranchWindowCallback;->longPressed_:Ljava/lang/Runnable;

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0

    .line 3586
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_3
        :pswitch_0
        :pswitch_2
        :pswitch_0
        :pswitch_4
    .end packed-switch
.end method

.method public dispatchTrackballEvent(Landroid/view/MotionEvent;)Z
    .locals 1
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 3614
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->callback_:Landroid/view/Window$Callback;

    invoke-interface {v0, p1}, Landroid/view/Window$Callback;->dispatchTrackballEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    return v0
.end method

.method public onActionModeFinished(Landroid/view/ActionMode;)V
    .locals 1
    .param p1, "mode"    # Landroid/view/ActionMode;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    .line 3620
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->callback_:Landroid/view/Window$Callback;

    invoke-interface {v0, p1}, Landroid/view/Window$Callback;->onActionModeFinished(Landroid/view/ActionMode;)V

    .line 3621
    return-void
.end method

.method public onActionModeStarted(Landroid/view/ActionMode;)V
    .locals 1
    .param p1, "mode"    # Landroid/view/ActionMode;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    .line 3626
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->callback_:Landroid/view/Window$Callback;

    invoke-interface {v0, p1}, Landroid/view/Window$Callback;->onActionModeStarted(Landroid/view/ActionMode;)V

    .line 3627
    return-void
.end method

.method public onAttachedToWindow()V
    .locals 1

    .prologue
    .line 3631
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->callback_:Landroid/view/Window$Callback;

    invoke-interface {v0}, Landroid/view/Window$Callback;->onAttachedToWindow()V

    .line 3632
    return-void
.end method

.method public onContentChanged()V
    .locals 1

    .prologue
    .line 3636
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->callback_:Landroid/view/Window$Callback;

    invoke-interface {v0}, Landroid/view/Window$Callback;->onContentChanged()V

    .line 3637
    return-void
.end method

.method public onCreatePanelMenu(ILandroid/view/Menu;)Z
    .locals 1
    .param p1, "featureId"    # I
    .param p2, "menu"    # Landroid/view/Menu;

    .prologue
    .line 3641
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->callback_:Landroid/view/Window$Callback;

    invoke-interface {v0, p1, p2}, Landroid/view/Window$Callback;->onCreatePanelMenu(ILandroid/view/Menu;)Z

    move-result v0

    return v0
.end method

.method public onCreatePanelView(I)Landroid/view/View;
    .locals 1
    .param p1, "featureId"    # I

    .prologue
    .line 3646
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->callback_:Landroid/view/Window$Callback;

    invoke-interface {v0, p1}, Landroid/view/Window$Callback;->onCreatePanelView(I)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onDetachedFromWindow()V
    .locals 1
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "MissingSuperCall"
        }
    .end annotation

    .prologue
    .line 3652
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->callback_:Landroid/view/Window$Callback;

    invoke-interface {v0}, Landroid/view/Window$Callback;->onDetachedFromWindow()V

    .line 3653
    return-void
.end method

.method public onMenuItemSelected(ILandroid/view/MenuItem;)Z
    .locals 1
    .param p1, "featureId"    # I
    .param p2, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 3657
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->callback_:Landroid/view/Window$Callback;

    invoke-interface {v0, p1, p2}, Landroid/view/Window$Callback;->onMenuItemSelected(ILandroid/view/MenuItem;)Z

    move-result v0

    return v0
.end method

.method public onMenuOpened(ILandroid/view/Menu;)Z
    .locals 1
    .param p1, "featureId"    # I
    .param p2, "menu"    # Landroid/view/Menu;

    .prologue
    .line 3662
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->callback_:Landroid/view/Window$Callback;

    invoke-interface {v0, p1, p2}, Landroid/view/Window$Callback;->onMenuOpened(ILandroid/view/Menu;)Z

    move-result v0

    return v0
.end method

.method public onPanelClosed(ILandroid/view/Menu;)V
    .locals 1
    .param p1, "featureId"    # I
    .param p2, "menu"    # Landroid/view/Menu;

    .prologue
    .line 3667
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->callback_:Landroid/view/Window$Callback;

    invoke-interface {v0, p1, p2}, Landroid/view/Window$Callback;->onPanelClosed(ILandroid/view/Menu;)V

    .line 3668
    return-void
.end method

.method public onPreparePanel(ILandroid/view/View;Landroid/view/Menu;)Z
    .locals 1
    .param p1, "featureId"    # I
    .param p2, "view"    # Landroid/view/View;
    .param p3, "menu"    # Landroid/view/Menu;

    .prologue
    .line 3672
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->callback_:Landroid/view/Window$Callback;

    invoke-interface {v0, p1, p2, p3}, Landroid/view/Window$Callback;->onPreparePanel(ILandroid/view/View;Landroid/view/Menu;)Z

    move-result v0

    return v0
.end method

.method public onSearchRequested()Z
    .locals 1

    .prologue
    .line 3677
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->callback_:Landroid/view/Window$Callback;

    invoke-interface {v0}, Landroid/view/Window$Callback;->onSearchRequested()Z

    move-result v0

    return v0
.end method

.method public onWindowAttributesChanged(Landroid/view/WindowManager$LayoutParams;)V
    .locals 1
    .param p1, "attrs"    # Landroid/view/WindowManager$LayoutParams;

    .prologue
    .line 3682
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->callback_:Landroid/view/Window$Callback;

    invoke-interface {v0, p1}, Landroid/view/Window$Callback;->onWindowAttributesChanged(Landroid/view/WindowManager$LayoutParams;)V

    .line 3683
    return-void
.end method

.method public onWindowFocusChanged(Z)V
    .locals 1
    .param p1, "hasFocus"    # Z

    .prologue
    .line 3687
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->callback_:Landroid/view/Window$Callback;

    invoke-interface {v0, p1}, Landroid/view/Window$Callback;->onWindowFocusChanged(Z)V

    .line 3688
    return-void
.end method

.method public onWindowStartingActionMode(Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode;
    .locals 1
    .param p1, "callback"    # Landroid/view/ActionMode$Callback;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .prologue
    .line 3693
    iget-object v0, p0, Lio/branch/referral/Branch$BranchWindowCallback;->callback_:Landroid/view/Window$Callback;

    invoke-interface {v0, p1}, Landroid/view/Window$Callback;->onWindowStartingActionMode(Landroid/view/ActionMode$Callback;)Landroid/view/ActionMode;

    move-result-object v0

    return-object v0
.end method
