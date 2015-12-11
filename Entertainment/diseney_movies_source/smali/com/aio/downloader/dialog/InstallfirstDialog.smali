.class public Lcom/aio/downloader/dialog/InstallfirstDialog;
.super Landroid/app/Dialog;
.source "InstallfirstDialog.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/dialog/InstallfirstDialog$OnCustomDialogListener;
    }
.end annotation


# instance fields
.field private bt_firstcleaner_cancel:Landroid/widget/Button;

.field private bt_firstcleaner_ok:Landroid/widget/Button;

.field private ctx:Landroid/content/Context;

.field private descriptiontv:Landroid/widget/TextView;

.field private installf_tv:Landroid/widget/TextView;

.field private itemsOnClick:Landroid/view/View$OnClickListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;ILandroid/view/View$OnClickListener;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "customdialog"    # I
    .param p3, "itemsOnClick"    # Landroid/view/View$OnClickListener;

    .prologue
    .line 28
    invoke-direct {p0, p1, p2}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 29
    iput-object p1, p0, Lcom/aio/downloader/dialog/InstallfirstDialog;->ctx:Landroid/content/Context;

    .line 30
    iput-object p3, p0, Lcom/aio/downloader/dialog/InstallfirstDialog;->itemsOnClick:Landroid/view/View$OnClickListener;

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
    const v0, 0x7f030028

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/InstallfirstDialog;->setContentView(I)V

    .line 38
    const v0, 0x7f07014b

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/InstallfirstDialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/dialog/InstallfirstDialog;->descriptiontv:Landroid/widget/TextView;

    .line 39
    const v0, 0x7f07014c

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/InstallfirstDialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/dialog/InstallfirstDialog;->bt_firstcleaner_cancel:Landroid/widget/Button;

    .line 40
    const v0, 0x7f07014d

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/InstallfirstDialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/dialog/InstallfirstDialog;->bt_firstcleaner_ok:Landroid/widget/Button;

    .line 41
    iget-object v0, p0, Lcom/aio/downloader/dialog/InstallfirstDialog;->descriptiontv:Landroid/widget/TextView;

    const-string v1, "<font color=\'#3C55C3\'>All-In-One Downloader</font> installed, you can delete its unneeded apk file to save<font color=\'#3C55C3\'> 6.6MB</font>."

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 42
    iget-object v0, p0, Lcom/aio/downloader/dialog/InstallfirstDialog;->bt_firstcleaner_cancel:Landroid/widget/Button;

    iget-object v1, p0, Lcom/aio/downloader/dialog/InstallfirstDialog;->itemsOnClick:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 43
    iget-object v0, p0, Lcom/aio/downloader/dialog/InstallfirstDialog;->bt_firstcleaner_ok:Landroid/widget/Button;

    iget-object v1, p0, Lcom/aio/downloader/dialog/InstallfirstDialog;->itemsOnClick:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 44
    return-void
.end method
