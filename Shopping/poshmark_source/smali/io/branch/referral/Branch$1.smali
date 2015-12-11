.class Lio/branch/referral/Branch$1;
.super Ljava/lang/Object;
.source "Branch.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lio/branch/referral/Branch;->retrieveOnTouchListener()Landroid/view/View$OnTouchListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lio/branch/referral/Branch$1$KeepDebugConnectionTask;
    }
.end annotation


# instance fields
.field _longPressed:Ljava/lang/Runnable;

.field final synthetic this$0:Lio/branch/referral/Branch;


# direct methods
.method constructor <init>(Lio/branch/referral/Branch;)V
    .locals 1

    .prologue
    .line 1140
    iput-object p1, p0, Lio/branch/referral/Branch$1;->this$0:Lio/branch/referral/Branch;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1149
    new-instance v0, Lio/branch/referral/Branch$1$1;

    invoke-direct {v0, p0}, Lio/branch/referral/Branch$1$1;-><init>(Lio/branch/referral/Branch$1;)V

    iput-object v0, p0, Lio/branch/referral/Branch$1;->_longPressed:Ljava/lang/Runnable;

    return-void
.end method


# virtual methods
.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 6
    .param p1, "v"    # Landroid/view/View;
    .param p2, "ev"    # Landroid/view/MotionEvent;

    .prologue
    const-wide/16 v4, 0xbb8

    .line 1172
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getPointerCount()I

    move-result v1

    .line 1173
    .local v1, "pointerCount":I
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v0

    .line 1174
    .local v0, "actionPerformed":I
    and-int/lit16 v2, v0, 0xff

    packed-switch v2, :pswitch_data_0

    .line 1195
    :cond_0
    :goto_0
    :pswitch_0
    const/4 v2, 0x1

    return v2

    .line 1176
    :pswitch_1
    iget-object v2, p0, Lio/branch/referral/Branch$1;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->systemObserver_:Lio/branch/referral/SystemObserver;
    invoke-static {v2}, Lio/branch/referral/Branch;->access$300(Lio/branch/referral/Branch;)Lio/branch/referral/SystemObserver;

    move-result-object v2

    invoke-virtual {v2}, Lio/branch/referral/SystemObserver;->isSimulator()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1177
    iget-object v2, p0, Lio/branch/referral/Branch$1;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->debugHandler_:Landroid/os/Handler;
    invoke-static {v2}, Lio/branch/referral/Branch;->access$200(Lio/branch/referral/Branch;)Landroid/os/Handler;

    move-result-object v2

    iget-object v3, p0, Lio/branch/referral/Branch$1;->_longPressed:Ljava/lang/Runnable;

    invoke-virtual {v2, v3, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0

    .line 1183
    :pswitch_2
    iget-object v2, p0, Lio/branch/referral/Branch$1;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->debugHandler_:Landroid/os/Handler;
    invoke-static {v2}, Lio/branch/referral/Branch;->access$200(Lio/branch/referral/Branch;)Landroid/os/Handler;

    move-result-object v2

    iget-object v3, p0, Lio/branch/referral/Branch$1;->_longPressed:Ljava/lang/Runnable;

    invoke-virtual {v2, v3}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 1186
    :pswitch_3
    invoke-virtual {p1}, Landroid/view/View;->performClick()Z

    .line 1187
    iget-object v2, p0, Lio/branch/referral/Branch$1;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->debugHandler_:Landroid/os/Handler;
    invoke-static {v2}, Lio/branch/referral/Branch;->access$200(Lio/branch/referral/Branch;)Landroid/os/Handler;

    move-result-object v2

    iget-object v3, p0, Lio/branch/referral/Branch$1;->_longPressed:Ljava/lang/Runnable;

    invoke-virtual {v2, v3}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 1190
    :pswitch_4
    const/4 v2, 0x4

    if-ne v1, v2, :cond_0

    .line 1191
    iget-object v2, p0, Lio/branch/referral/Branch$1;->this$0:Lio/branch/referral/Branch;

    # getter for: Lio/branch/referral/Branch;->debugHandler_:Landroid/os/Handler;
    invoke-static {v2}, Lio/branch/referral/Branch;->access$200(Lio/branch/referral/Branch;)Landroid/os/Handler;

    move-result-object v2

    iget-object v3, p0, Lio/branch/referral/Branch$1;->_longPressed:Ljava/lang/Runnable;

    invoke-virtual {v2, v3, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0

    .line 1174
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
