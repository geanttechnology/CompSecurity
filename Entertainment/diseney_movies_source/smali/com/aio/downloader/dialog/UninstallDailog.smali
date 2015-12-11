.class public Lcom/aio/downloader/dialog/UninstallDailog;
.super Landroid/app/Dialog;
.source "UninstallDailog.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/dialog/UninstallDailog$OnCustomDialogListener;
    }
.end annotation


# instance fields
.field private appname:Ljava/lang/String;

.field private appsize:Ljava/lang/String;

.field private cleanercancel:Landroid/widget/Button;

.field private cleanerupdate:Landroid/widget/Button;

.field private ctx:Landroid/content/Context;

.field private descriptiontv:Landroid/widget/TextView;

.field private itemsOnClick:Landroid/view/View$OnClickListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;ILandroid/view/View$OnClickListener;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "customdialog"    # I
    .param p3, "itemsOnClick"    # Landroid/view/View$OnClickListener;
    .param p4, "appname"    # Ljava/lang/String;
    .param p5, "appsize"    # Ljava/lang/String;

    .prologue
    .line 24
    invoke-direct {p0, p1, p2}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 25
    iput-object p1, p0, Lcom/aio/downloader/dialog/UninstallDailog;->ctx:Landroid/content/Context;

    .line 26
    iput-object p3, p0, Lcom/aio/downloader/dialog/UninstallDailog;->itemsOnClick:Landroid/view/View$OnClickListener;

    .line 27
    iput-object p4, p0, Lcom/aio/downloader/dialog/UninstallDailog;->appname:Ljava/lang/String;

    .line 28
    iput-object p5, p0, Lcom/aio/downloader/dialog/UninstallDailog;->appsize:Ljava/lang/String;

    .line 29
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 34
    invoke-super {p0, p1}, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V

    .line 35
    const v0, 0x7f0300b5

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/UninstallDailog;->setContentView(I)V

    .line 36
    const v0, 0x7f070093

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/UninstallDailog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/dialog/UninstallDailog;->descriptiontv:Landroid/widget/TextView;

    .line 37
    const v0, 0x7f070090

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/UninstallDailog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/dialog/UninstallDailog;->cleanercancel:Landroid/widget/Button;

    .line 38
    const v0, 0x7f070092

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/UninstallDailog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/dialog/UninstallDailog;->cleanerupdate:Landroid/widget/Button;

    .line 39
    iget-object v0, p0, Lcom/aio/downloader/dialog/UninstallDailog;->cleanercancel:Landroid/widget/Button;

    iget-object v1, p0, Lcom/aio/downloader/dialog/UninstallDailog;->itemsOnClick:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 40
    iget-object v0, p0, Lcom/aio/downloader/dialog/UninstallDailog;->cleanerupdate:Landroid/widget/Button;

    iget-object v1, p0, Lcom/aio/downloader/dialog/UninstallDailog;->itemsOnClick:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 41
    iget-object v0, p0, Lcom/aio/downloader/dialog/UninstallDailog;->descriptiontv:Landroid/widget/TextView;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "<font color=\'#3261b4\'> <b>"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 42
    iget-object v2, p0, Lcom/aio/downloader/dialog/UninstallDailog;->appname:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "</b></font>  left <font color=\'#3261b4\'><b>"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 43
    iget-object v2, p0, Lcom/aio/downloader/dialog/UninstallDailog;->appsize:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " </b></font> residual files. \n Use "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 44
    const-string v2, "<font color=\'#3261b4\'> <b>AIO Cleaner"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    .line 45
    const-string v2, "</b></font> to get rid of them!"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 41
    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 46
    return-void
.end method
