.class Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$ChildSizeChangedListener;
.super Ljava/lang/Object;
.source "PopupDialogFragmentV4.java"

# interfaces
.implements Lcom/amazon/retailsearch/popup/DialogSizeChangedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ChildSizeChangedListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;


# direct methods
.method private constructor <init>(Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;)V
    .locals 0

    .prologue
    .line 299
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$ChildSizeChangedListener;, "Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4<TPopupView;>.ChildSizeChangedListener;"
    iput-object p1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$ChildSizeChangedListener;->this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;
    .param p2, "x1"    # Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$1;

    .prologue
    .line 299
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$ChildSizeChangedListener;, "Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4<TPopupView;>.ChildSizeChangedListener;"
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$ChildSizeChangedListener;-><init>(Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;)V

    return-void
.end method


# virtual methods
.method public onHeightChanged(I)V
    .locals 2
    .param p1, "height"    # I

    .prologue
    .line 304
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$ChildSizeChangedListener;, "Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4<TPopupView;>.ChildSizeChangedListener;"
    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$ChildSizeChangedListener;->this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;

    # getter for: Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->dialog:Landroid/app/Dialog;
    invoke-static {v1}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->access$200(Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;)Landroid/app/Dialog;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v0

    .line 305
    .local v0, "params":Landroid/view/WindowManager$LayoutParams;
    if-lez p1, :cond_1

    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$ChildSizeChangedListener;->this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;

    # getter for: Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->maxHeight:I
    invoke-static {v1}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->access$300(Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;)I

    move-result v1

    if-ge p1, v1, :cond_1

    move v1, p1

    :goto_0
    iput v1, v0, Landroid/view/WindowManager$LayoutParams;->height:I

    .line 306
    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$ChildSizeChangedListener;->this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;

    # setter for: Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->height:I
    invoke-static {v1, p1}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->access$402(Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;I)I

    .line 307
    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$ChildSizeChangedListener;->this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;

    # getter for: Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->dialog:Landroid/app/Dialog;
    invoke-static {v1}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->access$200(Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;)Landroid/app/Dialog;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Dialog;->getWindow()Landroid/view/Window;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/view/Window;->setAttributes(Landroid/view/WindowManager$LayoutParams;)V

    .line 308
    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$ChildSizeChangedListener;->this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;

    # getter for: Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mSizeChangedListener:Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$OnSizeChangedListener;
    invoke-static {v1}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->access$500(Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;)Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$OnSizeChangedListener;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 309
    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$ChildSizeChangedListener;->this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;

    # getter for: Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->mSizeChangedListener:Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$OnSizeChangedListener;
    invoke-static {v1}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->access$500(Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;)Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$OnSizeChangedListener;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$OnSizeChangedListener;->onSizeChanged()V

    .line 311
    :cond_0
    return-void

    .line 305
    :cond_1
    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$ChildSizeChangedListener;->this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;

    # getter for: Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->maxHeight:I
    invoke-static {v1}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->access$300(Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;)I

    move-result v1

    goto :goto_0
.end method
