.class Lcom/livemixtapes/ui/widgets/SearchView$11;
.super Ljava/lang/Object;
.source "SearchView.java"

# interfaces
.implements Landroid/view/animation/Animation$AnimationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/ui/widgets/SearchView;->startAnimation(Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/ui/widgets/SearchView;

.field private final synthetic val$expand:Z


# direct methods
.method constructor <init>(Lcom/livemixtapes/ui/widgets/SearchView;Z)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/ui/widgets/SearchView$11;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    iput-boolean p2, p0, Lcom/livemixtapes/ui/widgets/SearchView$11;->val$expand:Z

    .line 302
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAnimationEnd(Landroid/view/animation/Animation;)V
    .locals 4
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 325
    iget-object v2, p0, Lcom/livemixtapes/ui/widgets/SearchView$11;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->layoutPanel:Landroid/widget/RelativeLayout;
    invoke-static {v2}, Lcom/livemixtapes/ui/widgets/SearchView;->access$0(Lcom/livemixtapes/ui/widgets/SearchView;)Landroid/widget/RelativeLayout;

    move-result-object v2

    invoke-virtual {v2}, Landroid/widget/RelativeLayout;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout$LayoutParams;

    .line 326
    .local v1, "params":Landroid/widget/RelativeLayout$LayoutParams;
    const/4 v0, 0x0

    .line 327
    .local v0, "marginOffset":F
    float-to-int v2, v0

    neg-int v2, v2

    iput v2, v1, Landroid/widget/RelativeLayout$LayoutParams;->rightMargin:I

    .line 328
    iget-object v2, p0, Lcom/livemixtapes/ui/widgets/SearchView$11;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->layoutPanel:Landroid/widget/RelativeLayout;
    invoke-static {v2}, Lcom/livemixtapes/ui/widgets/SearchView;->access$0(Lcom/livemixtapes/ui/widgets/SearchView;)Landroid/widget/RelativeLayout;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/widget/RelativeLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 330
    iget-object v2, p0, Lcom/livemixtapes/ui/widgets/SearchView$11;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->expandListener:Lcom/livemixtapes/ui/widgets/SearchView$ExpandListener;
    invoke-static {v2}, Lcom/livemixtapes/ui/widgets/SearchView;->access$10(Lcom/livemixtapes/ui/widgets/SearchView;)Lcom/livemixtapes/ui/widgets/SearchView$ExpandListener;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 331
    iget-object v2, p0, Lcom/livemixtapes/ui/widgets/SearchView$11;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->expandListener:Lcom/livemixtapes/ui/widgets/SearchView$ExpandListener;
    invoke-static {v2}, Lcom/livemixtapes/ui/widgets/SearchView;->access$10(Lcom/livemixtapes/ui/widgets/SearchView;)Lcom/livemixtapes/ui/widgets/SearchView$ExpandListener;

    move-result-object v2

    iget-boolean v3, p0, Lcom/livemixtapes/ui/widgets/SearchView$11;->val$expand:Z

    invoke-interface {v2, v3}, Lcom/livemixtapes/ui/widgets/SearchView$ExpandListener;->onAfterExpand(Z)V

    .line 333
    :cond_0
    return-void
.end method

.method public onAnimationRepeat(Landroid/view/animation/Animation;)V
    .locals 0
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    .line 339
    return-void
.end method

.method public onAnimationStart(Landroid/view/animation/Animation;)V
    .locals 4
    .param p1, "animation"    # Landroid/view/animation/Animation;

    .prologue
    const/16 v2, 0x8

    const/4 v3, 0x0

    .line 307
    iget-object v1, p0, Lcom/livemixtapes/ui/widgets/SearchView$11;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->buttonCancel:Landroid/widget/Button;
    invoke-static {v1}, Lcom/livemixtapes/ui/widgets/SearchView;->access$9(Lcom/livemixtapes/ui/widgets/SearchView;)Landroid/widget/Button;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 309
    iget-object v1, p0, Lcom/livemixtapes/ui/widgets/SearchView$11;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # invokes: Lcom/livemixtapes/ui/widgets/SearchView;->updateHintLabel()V
    invoke-static {v1}, Lcom/livemixtapes/ui/widgets/SearchView;->access$12(Lcom/livemixtapes/ui/widgets/SearchView;)V

    .line 311
    iget-object v1, p0, Lcom/livemixtapes/ui/widgets/SearchView$11;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->textViewHint:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/livemixtapes/ui/widgets/SearchView;->access$11(Lcom/livemixtapes/ui/widgets/SearchView;)Landroid/widget/TextView;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 312
    iget-object v1, p0, Lcom/livemixtapes/ui/widgets/SearchView$11;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->editTextQuery:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/livemixtapes/ui/widgets/SearchView;->access$5(Lcom/livemixtapes/ui/widgets/SearchView;)Landroid/widget/EditText;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/widget/EditText;->setVisibility(I)V

    .line 314
    iget-object v1, p0, Lcom/livemixtapes/ui/widgets/SearchView$11;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->context:Landroid/content/Context;
    invoke-static {v1}, Lcom/livemixtapes/ui/widgets/SearchView;->access$8(Lcom/livemixtapes/ui/widgets/SearchView;)Landroid/content/Context;

    move-result-object v1

    const-string v2, "input_method"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 315
    .local v0, "imm":Landroid/view/inputmethod/InputMethodManager;
    iget-object v1, p0, Lcom/livemixtapes/ui/widgets/SearchView$11;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->editTextQuery:Landroid/widget/EditText;
    invoke-static {v1}, Lcom/livemixtapes/ui/widgets/SearchView;->access$5(Lcom/livemixtapes/ui/widgets/SearchView;)Landroid/widget/EditText;

    move-result-object v1

    invoke-virtual {v1}, Landroid/widget/EditText;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    invoke-virtual {v0, v1, v3}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 317
    iget-object v1, p0, Lcom/livemixtapes/ui/widgets/SearchView$11;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->expandListener:Lcom/livemixtapes/ui/widgets/SearchView$ExpandListener;
    invoke-static {v1}, Lcom/livemixtapes/ui/widgets/SearchView;->access$10(Lcom/livemixtapes/ui/widgets/SearchView;)Lcom/livemixtapes/ui/widgets/SearchView$ExpandListener;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 318
    iget-object v1, p0, Lcom/livemixtapes/ui/widgets/SearchView$11;->this$0:Lcom/livemixtapes/ui/widgets/SearchView;

    # getter for: Lcom/livemixtapes/ui/widgets/SearchView;->expandListener:Lcom/livemixtapes/ui/widgets/SearchView$ExpandListener;
    invoke-static {v1}, Lcom/livemixtapes/ui/widgets/SearchView;->access$10(Lcom/livemixtapes/ui/widgets/SearchView;)Lcom/livemixtapes/ui/widgets/SearchView$ExpandListener;

    move-result-object v1

    iget-boolean v2, p0, Lcom/livemixtapes/ui/widgets/SearchView$11;->val$expand:Z

    invoke-interface {v1, v2}, Lcom/livemixtapes/ui/widgets/SearchView$ExpandListener;->onBeforeExpand(Z)V

    .line 320
    :cond_0
    return-void
.end method
