.class Lcom/livemixtapes/SignUp$14;
.super Ljava/lang/Object;
.source "SignUp.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/SignUp;->shake(Landroid/view/View;Ljava/lang/Runnable;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/SignUp;

.field private final synthetic val$callback:Ljava/lang/Runnable;


# direct methods
.method constructor <init>(Lcom/livemixtapes/SignUp;Ljava/lang/Runnable;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    iput-object p2, p0, Lcom/livemixtapes/SignUp$14;->val$callback:Ljava/lang/Runnable;

    .line 494
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 3
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 501
    iget-object v1, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    invoke-virtual {v1}, Lcom/livemixtapes/SignUp;->getCurrentFocus()Landroid/view/View;

    move-result-object v0

    .line 503
    .local v0, "v":Landroid/view/View;
    iget-object v1, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->username:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/livemixtapes/SignUp;->access$8(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v1

    if-ne v0, v1, :cond_2

    .line 504
    iget-object v1, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    iget-object v2, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->username:Landroid/widget/EditText;
    invoke-static {v2}, Lcom/livemixtapes/SignUp;->access$8(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v2

    # invokes: Lcom/livemixtapes/SignUp;->showKeyboard(Landroid/view/View;)V
    invoke-static {v1, v2}, Lcom/livemixtapes/SignUp;->access$38(Lcom/livemixtapes/SignUp;Landroid/view/View;)V

    .line 532
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/livemixtapes/SignUp$14;->val$callback:Ljava/lang/Runnable;

    if-eqz v1, :cond_1

    .line 533
    iget-object v1, p0, Lcom/livemixtapes/SignUp$14;->val$callback:Ljava/lang/Runnable;

    invoke-interface {v1}, Ljava/lang/Runnable;->run()V

    .line 535
    :cond_1
    return-void

    .line 505
    :cond_2
    iget-object v1, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->password:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/livemixtapes/SignUp;->access$10(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v1

    if-ne v0, v1, :cond_3

    .line 506
    iget-object v1, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    iget-object v2, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->password:Landroid/widget/EditText;
    invoke-static {v2}, Lcom/livemixtapes/SignUp;->access$10(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v2

    # invokes: Lcom/livemixtapes/SignUp;->showKeyboard(Landroid/view/View;)V
    invoke-static {v1, v2}, Lcom/livemixtapes/SignUp;->access$38(Lcom/livemixtapes/SignUp;Landroid/view/View;)V

    goto :goto_0

    .line 508
    :cond_3
    iget-object v1, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_email:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/livemixtapes/SignUp;->access$14(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v1

    if-ne v0, v1, :cond_4

    .line 509
    iget-object v1, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    iget-object v2, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_email:Landroid/widget/EditText;
    invoke-static {v2}, Lcom/livemixtapes/SignUp;->access$14(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v2

    # invokes: Lcom/livemixtapes/SignUp;->showKeyboard(Landroid/view/View;)V
    invoke-static {v1, v2}, Lcom/livemixtapes/SignUp;->access$38(Lcom/livemixtapes/SignUp;Landroid/view/View;)V

    goto :goto_0

    .line 511
    :cond_4
    iget-object v1, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_confirmemail:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/livemixtapes/SignUp;->access$16(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v1

    if-ne v0, v1, :cond_5

    .line 512
    iget-object v1, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    iget-object v2, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_confirmemail:Landroid/widget/EditText;
    invoke-static {v2}, Lcom/livemixtapes/SignUp;->access$16(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v2

    # invokes: Lcom/livemixtapes/SignUp;->showKeyboard(Landroid/view/View;)V
    invoke-static {v1, v2}, Lcom/livemixtapes/SignUp;->access$38(Lcom/livemixtapes/SignUp;Landroid/view/View;)V

    goto :goto_0

    .line 514
    :cond_5
    iget-object v1, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_password:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/livemixtapes/SignUp;->access$19(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v1

    if-ne v0, v1, :cond_6

    .line 515
    iget-object v1, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    iget-object v2, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_password:Landroid/widget/EditText;
    invoke-static {v2}, Lcom/livemixtapes/SignUp;->access$19(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v2

    # invokes: Lcom/livemixtapes/SignUp;->showKeyboard(Landroid/view/View;)V
    invoke-static {v1, v2}, Lcom/livemixtapes/SignUp;->access$38(Lcom/livemixtapes/SignUp;Landroid/view/View;)V

    goto :goto_0

    .line 517
    :cond_6
    iget-object v1, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_confirmpassword:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/livemixtapes/SignUp;->access$21(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v1

    if-ne v0, v1, :cond_7

    .line 518
    iget-object v1, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    iget-object v2, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_confirmpassword:Landroid/widget/EditText;
    invoke-static {v2}, Lcom/livemixtapes/SignUp;->access$21(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v2

    # invokes: Lcom/livemixtapes/SignUp;->showKeyboard(Landroid/view/View;)V
    invoke-static {v1, v2}, Lcom/livemixtapes/SignUp;->access$38(Lcom/livemixtapes/SignUp;Landroid/view/View;)V

    goto :goto_0

    .line 520
    :cond_7
    iget-object v1, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_firstname:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/livemixtapes/SignUp;->access$23(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v1

    if-ne v0, v1, :cond_8

    .line 521
    iget-object v1, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    iget-object v2, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_firstname:Landroid/widget/EditText;
    invoke-static {v2}, Lcom/livemixtapes/SignUp;->access$23(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v2

    # invokes: Lcom/livemixtapes/SignUp;->showKeyboard(Landroid/view/View;)V
    invoke-static {v1, v2}, Lcom/livemixtapes/SignUp;->access$38(Lcom/livemixtapes/SignUp;Landroid/view/View;)V

    goto/16 :goto_0

    .line 523
    :cond_8
    iget-object v1, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_lastname:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/livemixtapes/SignUp;->access$25(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v1

    if-ne v0, v1, :cond_9

    .line 524
    iget-object v1, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    iget-object v2, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_lastname:Landroid/widget/EditText;
    invoke-static {v2}, Lcom/livemixtapes/SignUp;->access$25(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v2

    # invokes: Lcom/livemixtapes/SignUp;->showKeyboard(Landroid/view/View;)V
    invoke-static {v1, v2}, Lcom/livemixtapes/SignUp;->access$38(Lcom/livemixtapes/SignUp;Landroid/view/View;)V

    goto/16 :goto_0

    .line 526
    :cond_9
    iget-object v1, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_postalcode:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/livemixtapes/SignUp;->access$27(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v1

    if-ne v0, v1, :cond_0

    .line 527
    iget-object v1, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    iget-object v2, p0, Lcom/livemixtapes/SignUp$14;->this$0:Lcom/livemixtapes/SignUp;

    # getter for: Lcom/livemixtapes/SignUp;->signup_postalcode:Landroid/widget/EditText;
    invoke-static {v2}, Lcom/livemixtapes/SignUp;->access$27(Lcom/livemixtapes/SignUp;)Landroid/widget/EditText;

    move-result-object v2

    # invokes: Lcom/livemixtapes/SignUp;->showKeyboard(Landroid/view/View;)V
    invoke-static {v1, v2}, Lcom/livemixtapes/SignUp;->access$38(Lcom/livemixtapes/SignUp;Landroid/view/View;)V

    goto/16 :goto_0
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 539
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 497
    return-void
.end method
