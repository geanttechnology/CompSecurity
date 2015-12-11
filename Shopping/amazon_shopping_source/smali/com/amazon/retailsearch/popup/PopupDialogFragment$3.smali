.class Lcom/amazon/retailsearch/popup/PopupDialogFragment$3;
.super Ljava/lang/Object;
.source "PopupDialogFragment.java"

# interfaces
.implements Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/popup/PopupDialogFragment;->runAfterNextLayoutPass(Landroid/view/View;Ljava/lang/Runnable;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragment;

.field final synthetic val$runnable:Ljava/lang/Runnable;

.field final synthetic val$view:Landroid/view/View;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/popup/PopupDialogFragment;Landroid/view/View;Ljava/lang/Runnable;)V
    .locals 0

    .prologue
    .line 284
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragment$3;, "Lcom/amazon/retailsearch/popup/PopupDialogFragment.3;"
    iput-object p1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment$3;->this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragment;

    iput-object p2, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment$3;->val$view:Landroid/view/View;

    iput-object p3, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment$3;->val$runnable:Ljava/lang/Runnable;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onGlobalLayout()V
    .locals 2

    .prologue
    .line 287
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragment$3;, "Lcom/amazon/retailsearch/popup/PopupDialogFragment.3;"
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-ge v0, v1, :cond_0

    .line 288
    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment$3;->val$view:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->removeGlobalOnLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 292
    :goto_0
    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment$3;->val$runnable:Ljava/lang/Runnable;

    invoke-interface {v0}, Ljava/lang/Runnable;->run()V

    .line 293
    return-void

    .line 290
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment$3;->val$view:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/ViewTreeObserver;->removeOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    goto :goto_0
.end method
