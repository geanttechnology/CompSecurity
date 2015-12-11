.class Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$2;
.super Ljava/lang/Object;
.source "PopupDialogFragmentV4.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->onConfigurationChanged(Landroid/content/res/Configuration;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;


# direct methods
.method constructor <init>(Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;)V
    .locals 0

    .prologue
    .line 226
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$2;, "Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4.2;"
    iput-object p1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$2;->this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 229
    .local p0, "this":Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$2;, "Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4.2;"
    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$2;->this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->getDialog()Landroid/app/Dialog;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 230
    iget-object v0, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$2;->this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;

    iget-object v1, p0, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4$2;->this$0:Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->getDialog()Landroid/app/Dialog;

    move-result-object v1

    # invokes: Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->setDialogBounds(Landroid/app/Dialog;)V
    invoke-static {v0, v1}, Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;->access$100(Lcom/amazon/retailsearch/popup/PopupDialogFragmentV4;Landroid/app/Dialog;)V

    .line 232
    :cond_0
    return-void
.end method
