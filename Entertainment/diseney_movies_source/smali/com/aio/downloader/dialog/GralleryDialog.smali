.class public Lcom/aio/downloader/dialog/GralleryDialog;
.super Landroid/app/Dialog;
.source "GralleryDialog.java"


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
    iput-object p1, p0, Lcom/aio/downloader/dialog/GralleryDialog;->ctx:Landroid/content/Context;

    .line 25
    iput-object p3, p0, Lcom/aio/downloader/dialog/GralleryDialog;->itemsOnClick:Landroid/view/View$OnClickListener;

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
    const v0, 0x7f030051

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/GralleryDialog;->setContentView(I)V

    .line 33
    iget-object v0, p0, Lcom/aio/downloader/dialog/GralleryDialog;->ctx:Landroid/content/Context;

    const-string v1, "gallery"

    invoke-static {v0, v1}, Lcom/umeng/analytics/MobclickAgent;->onEvent(Landroid/content/Context;Ljava/lang/String;)V

    .line 34
    new-instance v0, Lcom/aio/downloader/dialog/GralleryDialog$1;

    invoke-direct {v0, p0}, Lcom/aio/downloader/dialog/GralleryDialog$1;-><init>(Lcom/aio/downloader/dialog/GralleryDialog;)V

    .line 43
    invoke-virtual {v0}, Lcom/aio/downloader/dialog/GralleryDialog$1;->start()V

    .line 44
    const v0, 0x7f070216

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/GralleryDialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/dialog/GralleryDialog;->gallery_cancel:Landroid/widget/Button;

    .line 45
    const v0, 0x7f070217

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/GralleryDialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/dialog/GralleryDialog;->rl_gallery_ok:Landroid/widget/RelativeLayout;

    .line 46
    iget-object v0, p0, Lcom/aio/downloader/dialog/GralleryDialog;->gallery_cancel:Landroid/widget/Button;

    iget-object v1, p0, Lcom/aio/downloader/dialog/GralleryDialog;->itemsOnClick:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 47
    iget-object v0, p0, Lcom/aio/downloader/dialog/GralleryDialog;->rl_gallery_ok:Landroid/widget/RelativeLayout;

    iget-object v1, p0, Lcom/aio/downloader/dialog/GralleryDialog;->itemsOnClick:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 49
    return-void
.end method
