.class public Lcom/aio/downloader/dialog/ChangeDialog;
.super Landroid/app/Dialog;
.source "ChangeDialog.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/dialog/ChangeDialog$OnCustomDialogListener;
    }
.end annotation


# instance fields
.field private changecancel:Landroid/widget/Button;

.field private ctx:Landroid/content/Context;

.field private descriptiontv_change:Landroid/widget/TextView;

.field private fenzhong:Ljava/lang/String;

.field private itemsOnClick:Landroid/view/View$OnClickListener;

.field private level:I

.field private rl_change_ok:Landroid/widget/RelativeLayout;

.field private tv_change_appname:Landroid/widget/TextView;

.field private xiaoshi:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;ILandroid/view/View$OnClickListener;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "customdialog"    # I
    .param p3, "itemsOnClick"    # Landroid/view/View$OnClickListener;
    .param p4, "xiaoshi"    # Ljava/lang/String;
    .param p5, "fenzhong"    # Ljava/lang/String;
    .param p6, "level"    # I

    .prologue
    .line 30
    invoke-direct {p0, p1, p2}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 31
    iput-object p1, p0, Lcom/aio/downloader/dialog/ChangeDialog;->ctx:Landroid/content/Context;

    .line 32
    iput-object p3, p0, Lcom/aio/downloader/dialog/ChangeDialog;->itemsOnClick:Landroid/view/View$OnClickListener;

    .line 33
    iput-object p4, p0, Lcom/aio/downloader/dialog/ChangeDialog;->xiaoshi:Ljava/lang/String;

    .line 34
    iput-object p5, p0, Lcom/aio/downloader/dialog/ChangeDialog;->fenzhong:Ljava/lang/String;

    .line 35
    iput p6, p0, Lcom/aio/downloader/dialog/ChangeDialog;->level:I

    .line 36
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 40
    invoke-super {p0, p1}, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V

    .line 41
    const v0, 0x7f030023

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/ChangeDialog;->setContentView(I)V

    .line 45
    const v0, 0x7f070138

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/ChangeDialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/dialog/ChangeDialog;->changecancel:Landroid/widget/Button;

    .line 46
    const v0, 0x7f070139

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/ChangeDialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/aio/downloader/dialog/ChangeDialog;->rl_change_ok:Landroid/widget/RelativeLayout;

    .line 47
    const v0, 0x7f070136

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/ChangeDialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/dialog/ChangeDialog;->tv_change_appname:Landroid/widget/TextView;

    .line 48
    const v0, 0x7f070137

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/ChangeDialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/dialog/ChangeDialog;->descriptiontv_change:Landroid/widget/TextView;

    .line 50
    iget-object v0, p0, Lcom/aio/downloader/dialog/ChangeDialog;->descriptiontv_change:Landroid/widget/TextView;

    const-string v1, "Extend your battery life up to <font color=\'#3463B4\'><b>50%</b></font> using Battery Saver!"

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 51
    iget v0, p0, Lcom/aio/downloader/dialog/ChangeDialog;->level:I

    const/16 v1, 0x64

    if-ne v0, v1, :cond_0

    .line 52
    iget-object v0, p0, Lcom/aio/downloader/dialog/ChangeDialog;->tv_change_appname:Landroid/widget/TextView;

    const-string v1, "Full Charge"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 56
    :goto_0
    iget-object v0, p0, Lcom/aio/downloader/dialog/ChangeDialog;->changecancel:Landroid/widget/Button;

    iget-object v1, p0, Lcom/aio/downloader/dialog/ChangeDialog;->itemsOnClick:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 57
    iget-object v0, p0, Lcom/aio/downloader/dialog/ChangeDialog;->rl_change_ok:Landroid/widget/RelativeLayout;

    iget-object v1, p0, Lcom/aio/downloader/dialog/ChangeDialog;->itemsOnClick:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 58
    return-void

    .line 54
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/dialog/ChangeDialog;->tv_change_appname:Landroid/widget/TextView;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "Full Charge Left <font color=\'#3463B4\'><b>"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/aio/downloader/dialog/ChangeDialog;->xiaoshi:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "</b></font> H <font color=\'#3463B4\'><b>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/aio/downloader/dialog/ChangeDialog;->fenzhong:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "</b></font> Min"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0
.end method
