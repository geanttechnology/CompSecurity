.class Lcom/livemixtapes/Login$12;
.super Ljava/lang/Object;
.source "Login.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Login;->shake(Landroid/view/View;Ljava/lang/Runnable;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/Login;

.field private final synthetic val$callback:Ljava/lang/Runnable;


# direct methods
.method constructor <init>(Lcom/livemixtapes/Login;Ljava/lang/Runnable;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Login$12;->this$0:Lcom/livemixtapes/Login;

    iput-object p2, p0, Lcom/livemixtapes/Login$12;->val$callback:Ljava/lang/Runnable;

    .line 256
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 3
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 263
    iget-object v1, p0, Lcom/livemixtapes/Login$12;->this$0:Lcom/livemixtapes/Login;

    invoke-virtual {v1}, Lcom/livemixtapes/Login;->getCurrentFocus()Landroid/view/View;

    move-result-object v0

    .line 265
    .local v0, "v":Landroid/view/View;
    iget-object v1, p0, Lcom/livemixtapes/Login$12;->this$0:Lcom/livemixtapes/Login;

    # getter for: Lcom/livemixtapes/Login;->username:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/livemixtapes/Login;->access$3(Lcom/livemixtapes/Login;)Landroid/widget/EditText;

    move-result-object v1

    if-ne v0, v1, :cond_2

    .line 266
    iget-object v1, p0, Lcom/livemixtapes/Login$12;->this$0:Lcom/livemixtapes/Login;

    iget-object v2, p0, Lcom/livemixtapes/Login$12;->this$0:Lcom/livemixtapes/Login;

    # getter for: Lcom/livemixtapes/Login;->username:Landroid/widget/EditText;
    invoke-static {v2}, Lcom/livemixtapes/Login;->access$3(Lcom/livemixtapes/Login;)Landroid/widget/EditText;

    move-result-object v2

    # invokes: Lcom/livemixtapes/Login;->showKeyboard(Landroid/view/View;)V
    invoke-static {v1, v2}, Lcom/livemixtapes/Login;->access$13(Lcom/livemixtapes/Login;Landroid/view/View;)V

    .line 271
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/livemixtapes/Login$12;->val$callback:Ljava/lang/Runnable;

    if-eqz v1, :cond_1

    .line 272
    iget-object v1, p0, Lcom/livemixtapes/Login$12;->val$callback:Ljava/lang/Runnable;

    invoke-interface {v1}, Ljava/lang/Runnable;->run()V

    .line 274
    :cond_1
    return-void

    .line 267
    :cond_2
    iget-object v1, p0, Lcom/livemixtapes/Login$12;->this$0:Lcom/livemixtapes/Login;

    # getter for: Lcom/livemixtapes/Login;->password:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/livemixtapes/Login;->access$5(Lcom/livemixtapes/Login;)Landroid/widget/EditText;

    move-result-object v1

    if-ne v0, v1, :cond_0

    .line 268
    iget-object v1, p0, Lcom/livemixtapes/Login$12;->this$0:Lcom/livemixtapes/Login;

    iget-object v2, p0, Lcom/livemixtapes/Login$12;->this$0:Lcom/livemixtapes/Login;

    # getter for: Lcom/livemixtapes/Login;->password:Landroid/widget/EditText;
    invoke-static {v2}, Lcom/livemixtapes/Login;->access$5(Lcom/livemixtapes/Login;)Landroid/widget/EditText;

    move-result-object v2

    # invokes: Lcom/livemixtapes/Login;->showKeyboard(Landroid/view/View;)V
    invoke-static {v1, v2}, Lcom/livemixtapes/Login;->access$13(Lcom/livemixtapes/Login;Landroid/view/View;)V

    goto :goto_0
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 278
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 259
    return-void
.end method
