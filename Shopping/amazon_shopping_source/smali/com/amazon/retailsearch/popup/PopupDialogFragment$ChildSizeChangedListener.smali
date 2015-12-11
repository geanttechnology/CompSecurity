.class Lcom/amazon/retailsearch/popup/PopupDialogFragment$ChildSizeChangedListener;
.super Ljava/lang/Object;
.source "PopupDialogFragment.java"

# interfaces
.implements Lcom/amazon/retailsearch/popup/DialogSizeChangedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/popup/PopupDialogFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ChildSizeChangedListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragment;


# direct methods
.method private constructor <init>(Lcom/amazon/retailsearch/popup/PopupDialogFragment;)V
    .locals 0

    .prologue
    .line 302
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragment$ChildSizeChangedListener;, "Lcom/amazon/retailsearch/popup/PopupDialogFragment<TPopupView;>.ChildSizeChangedListener;"
    iput-object p1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment$ChildSizeChangedListener;->this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/retailsearch/popup/PopupDialogFragment;Lcom/amazon/retailsearch/popup/PopupDialogFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/popup/PopupDialogFragment;
    .param p2, "x1"    # Lcom/amazon/retailsearch/popup/PopupDialogFragment$1;

    .prologue
    .line 302
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragment$ChildSizeChangedListener;, "Lcom/amazon/retailsearch/popup/PopupDialogFragment<TPopupView;>.ChildSizeChangedListener;"
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/popup/PopupDialogFragment$ChildSizeChangedListener;-><init>(Lcom/amazon/retailsearch/popup/PopupDialogFragment;)V

    return-void
.end method


# virtual methods
.method public onHeightChanged(I)V
    .locals 2
    .param p1, "height"    # I

    .prologue
    .line 307
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragment$ChildSizeChangedListener;, "Lcom/amazon/retailsearch/popup/PopupDialogFragment<TPopupView;>.ChildSizeChangedListener;"
    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment$ChildSizeChangedListener;->this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragment;

    # getter for: Lcom/amazon/retailsearch/popup/PopupDialogFragment;->dialog:Landroid/app/Dialog;
    invoke-static {v1}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->access$200(Lcom/amazon/retailsearch/popup/PopupDialogFragment;)Landroid/app/Dialog;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v0

    .line 308
    .local v0, "params":Landroid/view/WindowManager$LayoutParams;
    if-lez p1, :cond_1

    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment$ChildSizeChangedListener;->this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragment;

    # getter for: Lcom/amazon/retailsearch/popup/PopupDialogFragment;->maxHeight:I
    invoke-static {v1}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->access$300(Lcom/amazon/retailsearch/popup/PopupDialogFragment;)I

    move-result v1

    if-ge p1, v1, :cond_1

    move v1, p1

    :goto_0
    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->height:I

    .line 309
    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment$ChildSizeChangedListener;->this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragment;

    # setter for: Lcom/amazon/retailsearch/popup/PopupDialogFragment;->height:I
    invoke-static {v1, p1}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->access$402(Lcom/amazon/retailsearch/popup/PopupDialogFragment;I)I

    .line 310
    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment$ChildSizeChangedListener;->this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragment;

    # getter for: Lcom/amazon/retailsearch/popup/PopupDialogFragment;->dialog:Landroid/app/Dialog;
    invoke-static {v1}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->access$200(Lcom/amazon/retailsearch/popup/PopupDialogFragment;)Landroid/app/Dialog;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/view/Window;->setAttributes(Landroid/view/WindowManager$LayoutParams;)V

    .line 311
    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment$ChildSizeChangedListener;->this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragment;

    # getter for: Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mSizeChangedListener:Lcom/amazon/retailsearch/popup/PopupDialogFragment$OnSizeChangedListener;
    invoke-static {v1}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->access$500(Lcom/amazon/retailsearch/popup/PopupDialogFragment;)Lcom/amazon/retailsearch/popup/PopupDialogFragment$OnSizeChangedListener;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 312
    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment$ChildSizeChangedListener;->this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragment;

    # getter for: Lcom/amazon/retailsearch/popup/PopupDialogFragment;->mSizeChangedListener:Lcom/amazon/retailsearch/popup/PopupDialogFragment$OnSizeChangedListener;
    invoke-static {v1}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->access$500(Lcom/amazon/retailsearch/popup/PopupDialogFragment;)Lcom/amazon/retailsearch/popup/PopupDialogFragment$OnSizeChangedListener;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/retailsearch/popup/PopupDialogFragment$OnSizeChangedListener;->onSizeChanged()V

    .line 314
    :cond_0
    return-void

    .line 308
    :cond_1
    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment$ChildSizeChangedListener;->this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragment;

    # getter for: Lcom/amazon/retailsearch/popup/PopupDialogFragment;->maxHeight:I
    invoke-static {v1}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->access$300(Lcom/amazon/retailsearch/popup/PopupDialogFragment;)I

    move-result v1

    goto :goto_0
.end method
