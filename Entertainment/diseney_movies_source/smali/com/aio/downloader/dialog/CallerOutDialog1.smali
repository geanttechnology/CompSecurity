.class public Lcom/aio/downloader/dialog/CallerOutDialog1;
.super Landroid/app/Dialog;
.source "CallerOutDialog1.java"


# instance fields
.field private ctx:Landroid/content/Context;

.field private gallery_cancel:Landroid/widget/ImageView;

.field private itemsOnClick:Landroid/view/View$OnClickListener;

.field private number:Ljava/lang/String;

.field private rl_gallery_ok:Landroid/widget/Button;

.field private tv_number_caller:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;ILandroid/view/View$OnClickListener;Ljava/lang/String;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "customdialog"    # I
    .param p3, "itemsOnClick"    # Landroid/view/View$OnClickListener;
    .param p4, "number"    # Ljava/lang/String;

    .prologue
    .line 26
    invoke-direct {p0, p1, p2}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 28
    iput-object p1, p0, Lcom/aio/downloader/dialog/CallerOutDialog1;->ctx:Landroid/content/Context;

    .line 29
    iput-object p3, p0, Lcom/aio/downloader/dialog/CallerOutDialog1;->itemsOnClick:Landroid/view/View$OnClickListener;

    .line 30
    iput-object p4, p0, Lcom/aio/downloader/dialog/CallerOutDialog1;->number:Ljava/lang/String;

    .line 31
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 36
    invoke-super {p0, p1}, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V

    .line 37
    const v0, 0x7f03009d

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/CallerOutDialog1;->setContentView(I)V

    .line 38
    const v0, 0x7f070368

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/CallerOutDialog1;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/aio/downloader/dialog/CallerOutDialog1;->gallery_cancel:Landroid/widget/ImageView;

    .line 39
    const v0, 0x7f07036b

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/CallerOutDialog1;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/dialog/CallerOutDialog1;->rl_gallery_ok:Landroid/widget/Button;

    .line 40
    const v0, 0x7f07036a

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/CallerOutDialog1;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/dialog/CallerOutDialog1;->tv_number_caller:Landroid/widget/TextView;

    .line 41
    iget-object v0, p0, Lcom/aio/downloader/dialog/CallerOutDialog1;->tv_number_caller:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/aio/downloader/dialog/CallerOutDialog1;->number:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 42
    iget-object v0, p0, Lcom/aio/downloader/dialog/CallerOutDialog1;->gallery_cancel:Landroid/widget/ImageView;

    iget-object v1, p0, Lcom/aio/downloader/dialog/CallerOutDialog1;->itemsOnClick:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 43
    iget-object v0, p0, Lcom/aio/downloader/dialog/CallerOutDialog1;->rl_gallery_ok:Landroid/widget/Button;

    iget-object v1, p0, Lcom/aio/downloader/dialog/CallerOutDialog1;->itemsOnClick:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 45
    return-void
.end method
