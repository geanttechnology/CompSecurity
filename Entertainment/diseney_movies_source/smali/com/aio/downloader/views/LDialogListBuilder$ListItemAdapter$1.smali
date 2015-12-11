.class Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$1;
.super Ljava/lang/Object;
.source "LDialogListBuilder.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;

.field private final synthetic val$position:I


# direct methods
.method constructor <init>(Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;I)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$1;->this$1:Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;

    iput p2, p0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$1;->val$position:I

    .line 124
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "arg0"    # Landroid/view/View;

    .prologue
    .line 128
    iget-object v1, p0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$1;->this$1:Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;

    # getter for: Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;->this$0:Lcom/aio/downloader/views/LDialogListBuilder;
    invoke-static {v1}, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;->access$0(Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;)Lcom/aio/downloader/views/LDialogListBuilder;

    move-result-object v1

    # getter for: Lcom/aio/downloader/views/LDialogListBuilder;->mListener:Landroid/content/DialogInterface$OnClickListener;
    invoke-static {v1}, Lcom/aio/downloader/views/LDialogListBuilder;->access$0(Lcom/aio/downloader/views/LDialogListBuilder;)Landroid/content/DialogInterface$OnClickListener;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 129
    iget-object v1, p0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$1;->this$1:Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;

    # getter for: Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;->this$0:Lcom/aio/downloader/views/LDialogListBuilder;
    invoke-static {v1}, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;->access$0(Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;)Lcom/aio/downloader/views/LDialogListBuilder;

    move-result-object v1

    # getter for: Lcom/aio/downloader/views/LDialogListBuilder;->mController:Lcom/aio/downloader/views/LDialogController;
    invoke-static {v1}, Lcom/aio/downloader/views/LDialogListBuilder;->access$1(Lcom/aio/downloader/views/LDialogListBuilder;)Lcom/aio/downloader/views/LDialogController;

    move-result-object v1

    if-nez v1, :cond_1

    const/4 v0, 0x0

    .line 131
    .local v0, "dialogInterface":Landroid/content/DialogInterface;
    :goto_0
    iget-object v1, p0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$1;->this$1:Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;

    # getter for: Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;->this$0:Lcom/aio/downloader/views/LDialogListBuilder;
    invoke-static {v1}, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;->access$0(Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;)Lcom/aio/downloader/views/LDialogListBuilder;

    move-result-object v1

    # getter for: Lcom/aio/downloader/views/LDialogListBuilder;->mListener:Landroid/content/DialogInterface$OnClickListener;
    invoke-static {v1}, Lcom/aio/downloader/views/LDialogListBuilder;->access$0(Lcom/aio/downloader/views/LDialogListBuilder;)Landroid/content/DialogInterface$OnClickListener;

    move-result-object v1

    iget v2, p0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$1;->val$position:I

    invoke-interface {v1, v0, v2}, Landroid/content/DialogInterface$OnClickListener;->onClick(Landroid/content/DialogInterface;I)V

    .line 132
    if-eqz v0, :cond_0

    .line 133
    invoke-interface {v0}, Landroid/content/DialogInterface;->dismiss()V

    .line 136
    .end local v0    # "dialogInterface":Landroid/content/DialogInterface;
    :cond_0
    return-void

    .line 130
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$1;->this$1:Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;

    # getter for: Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;->this$0:Lcom/aio/downloader/views/LDialogListBuilder;
    invoke-static {v1}, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;->access$0(Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;)Lcom/aio/downloader/views/LDialogListBuilder;

    move-result-object v1

    # getter for: Lcom/aio/downloader/views/LDialogListBuilder;->mController:Lcom/aio/downloader/views/LDialogController;
    invoke-static {v1}, Lcom/aio/downloader/views/LDialogListBuilder;->access$1(Lcom/aio/downloader/views/LDialogListBuilder;)Lcom/aio/downloader/views/LDialogController;

    move-result-object v1

    invoke-virtual {v1}, Lcom/aio/downloader/views/LDialogController;->getDialogInterface()Landroid/content/DialogInterface;

    move-result-object v0

    goto :goto_0
.end method
