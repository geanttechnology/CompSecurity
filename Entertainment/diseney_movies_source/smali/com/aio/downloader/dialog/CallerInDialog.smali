.class public Lcom/aio/downloader/dialog/CallerInDialog;
.super Landroid/app/Dialog;
.source "CallerInDialog.java"


# instance fields
.field private ctx:Landroid/content/Context;

.field private gallery_cancel:Landroid/widget/Button;

.field private itemsOnClick:Landroid/view/View$OnClickListener;

.field private rl_gallery_ok:Landroid/widget/RelativeLayout;


# direct methods
.method public constructor <init>(Landroid/content/Context;ILandroid/view/View$OnClickListener;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "customdialog"    # I
    .param p3, "itemsOnClick"    # Landroid/view/View$OnClickListener;

    .prologue
    .line 22
    invoke-direct {p0, p1, p2}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 24
    iput-object p1, p0, Lcom/aio/downloader/dialog/CallerInDialog;->ctx:Landroid/content/Context;

    .line 25
    iput-object p3, p0, Lcom/aio/downloader/dialog/CallerInDialog;->itemsOnClick:Landroid/view/View$OnClickListener;

    .line 26
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 31
    invoke-super {p0, p1}, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V

    .line 32
    const v0, 0x7f030021

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/CallerInDialog;->setContentView(I)V

    .line 33
    const v0, 0x7f070133

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/CallerInDialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/dialog/CallerInDialog;->gallery_cancel:Landroid/widget/Button;

    .line 34
    const v0, 0x7f070134

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/CallerInDialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/dialog/CallerInDialog;->rl_gallery_ok:Landroid/widget/RelativeLayout;

    .line 35
    iget-object v0, p0, Lcom/aio/downloader/dialog/CallerInDialog;->gallery_cancel:Landroid/widget/Button;

    iget-object v1, p0, Lcom/aio/downloader/dialog/CallerInDialog;->itemsOnClick:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 36
    iget-object v0, p0, Lcom/aio/downloader/dialog/CallerInDialog;->rl_gallery_ok:Landroid/widget/RelativeLayout;

    iget-object v1, p0, Lcom/aio/downloader/dialog/CallerInDialog;->itemsOnClick:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 38
    return-void
.end method
