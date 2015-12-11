.class Lcom/amazon/retailsearch/popup/PopupDialogFragment$2;
.super Ljava/lang/Object;
.source "PopupDialogFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/popup/PopupDialogFragment;->onConfigurationChanged(Landroid/content/res/Configuration;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragment;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/popup/PopupDialogFragment;)V
    .locals 0

    .prologue
    .line 229
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragment$2;, "Lcom/amazon/retailsearch/popup/PopupDialogFragment.2;"
    iput-object p1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment$2;->this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 232
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragment$2;, "Lcom/amazon/retailsearch/popup/PopupDialogFragment.2;"
    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment$2;->this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragment;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 233
    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment$2;->this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragment;

    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragment$2;->this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragment;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->getDialog()Landroid/app/Dialog;

    move-result-object v1

    # invokes: Lcom/amazon/retailsearch/popup/PopupDialogFragment;->setDialogBounds(Landroid/app/Dialog;)V
    invoke-static {v0, v1}, Lcom/amazon/retailsearch/popup/PopupDialogFragment;->access$100(Lcom/amazon/retailsearch/popup/PopupDialogFragment;Landroid/app/Dialog;)V

    .line 235
    :cond_0
    return-void
.end method
