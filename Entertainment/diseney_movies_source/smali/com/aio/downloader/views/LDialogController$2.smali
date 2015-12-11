.class Lcom/aio/downloader/views/LDialogController$2;
.super Ljava/lang/Object;
.source "LDialogController.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/views/LDialogController;->setupTitle()Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/aio/downloader/views/LDialogController;


# direct methods
.method constructor <init>(Lcom/aio/downloader/views/LDialogController;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/views/LDialogController$2;->this$0:Lcom/aio/downloader/views/LDialogController;

    .line 154
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 158
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController$2;->this$0:Lcom/aio/downloader/views/LDialogController;

    # getter for: Lcom/aio/downloader/views/LDialogController;->mDialogInterface:Landroid/content/DialogInterface;
    invoke-static {v0}, Lcom/aio/downloader/views/LDialogController;->access$5(Lcom/aio/downloader/views/LDialogController;)Landroid/content/DialogInterface;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/DialogInterface;->dismiss()V

    .line 159
    return-void
.end method
