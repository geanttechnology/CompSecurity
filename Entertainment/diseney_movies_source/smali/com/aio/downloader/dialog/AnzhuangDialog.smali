.class public Lcom/aio/downloader/dialog/AnzhuangDialog;
.super Landroid/app/Dialog;
.source "AnzhuangDialog.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/dialog/AnzhuangDialog$OnCustomDialogListener;
    }
.end annotation


# instance fields
.field private appid:Ljava/lang/String;

.field private appname:Ljava/lang/String;

.field private appsize:Ljava/lang/String;

.field private cleanercancel:Landroid/widget/Button;

.field private cleanerupdate:Landroid/widget/RelativeLayout;

.field private ctx:Landroid/content/Context;

.field private descriptiontv:Landroid/widget/TextView;

.field private itemsOnClick:Landroid/view/View$OnClickListener;

.field private iv_icon_ins:Lcom/aio/downloader/views/RoundImageView;

.field pI:Landroid/content/pm/PackageInfo;

.field private tv_install_appname:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;ILandroid/view/View$OnClickListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "customdialog"    # I
    .param p3, "itemsOnClick"    # Landroid/view/View$OnClickListener;
    .param p4, "appname"    # Ljava/lang/String;
    .param p5, "appid"    # Ljava/lang/String;
    .param p6, "appsize"    # Ljava/lang/String;

    .prologue
    .line 35
    invoke-direct {p0, p1, p2}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 24
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/dialog/AnzhuangDialog;->pI:Landroid/content/pm/PackageInfo;

    .line 36
    iput-object p1, p0, Lcom/aio/downloader/dialog/AnzhuangDialog;->ctx:Landroid/content/Context;

    .line 37
    iput-object p3, p0, Lcom/aio/downloader/dialog/AnzhuangDialog;->itemsOnClick:Landroid/view/View$OnClickListener;

    .line 38
    iput-object p4, p0, Lcom/aio/downloader/dialog/AnzhuangDialog;->appname:Ljava/lang/String;

    .line 39
    iput-object p5, p0, Lcom/aio/downloader/dialog/AnzhuangDialog;->appid:Ljava/lang/String;

    .line 40
    iput-object p6, p0, Lcom/aio/downloader/dialog/AnzhuangDialog;->appsize:Ljava/lang/String;

    .line 41
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 5
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 46
    invoke-super {p0, p1}, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V

    .line 47
    const v2, 0x7f030010

    invoke-virtual {p0, v2}, Lcom/aio/downloader/dialog/AnzhuangDialog;->setContentView(I)V

    .line 48
    const v2, 0x7f070095

    invoke-virtual {p0, v2}, Lcom/aio/downloader/dialog/AnzhuangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/aio/downloader/views/RoundImageView;

    iput-object v2, p0, Lcom/aio/downloader/dialog/AnzhuangDialog;->iv_icon_ins:Lcom/aio/downloader/views/RoundImageView;

    .line 54
    :try_start_0
    iget-object v2, p0, Lcom/aio/downloader/dialog/AnzhuangDialog;->ctx:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/dialog/AnzhuangDialog;->appid:Ljava/lang/String;

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v2

    iput-object v2, p0, Lcom/aio/downloader/dialog/AnzhuangDialog;->pI:Landroid/content/pm/PackageInfo;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    .line 59
    :goto_0
    :try_start_1
    iget-object v2, p0, Lcom/aio/downloader/dialog/AnzhuangDialog;->pI:Landroid/content/pm/PackageInfo;

    iget-object v2, v2, Landroid/content/pm/PackageInfo;->applicationInfo:Landroid/content/pm/ApplicationInfo;

    iget-object v3, p0, Lcom/aio/downloader/dialog/AnzhuangDialog;->ctx:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/content/pm/ApplicationInfo;->loadIcon(Landroid/content/pm/PackageManager;)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 61
    .local v1, "icon":Landroid/graphics/drawable/Drawable;
    iget-object v2, p0, Lcom/aio/downloader/dialog/AnzhuangDialog;->iv_icon_ins:Lcom/aio/downloader/views/RoundImageView;

    invoke-virtual {v2, v1}, Lcom/aio/downloader/views/RoundImageView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .line 64
    .end local v1    # "icon":Landroid/graphics/drawable/Drawable;
    :goto_1
    const v2, 0x7f070093

    invoke-virtual {p0, v2}, Lcom/aio/downloader/dialog/AnzhuangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/aio/downloader/dialog/AnzhuangDialog;->descriptiontv:Landroid/widget/TextView;

    .line 65
    const v2, 0x7f070094

    invoke-virtual {p0, v2}, Lcom/aio/downloader/dialog/AnzhuangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, p0, Lcom/aio/downloader/dialog/AnzhuangDialog;->tv_install_appname:Landroid/widget/TextView;

    .line 66
    iget-object v2, p0, Lcom/aio/downloader/dialog/AnzhuangDialog;->tv_install_appname:Landroid/widget/TextView;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "<font color=\'#3463B4\'>"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/aio/downloader/dialog/AnzhuangDialog;->appname:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "</font> just installed!"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 68
    iget-object v2, p0, Lcom/aio/downloader/dialog/AnzhuangDialog;->descriptiontv:Landroid/widget/TextView;

    .line 70
    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "You can delete its unneeded apk file to save <font color=\'#3261b4\'><b>"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/aio/downloader/dialog/AnzhuangDialog;->appsize:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ".</b></font>"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v3

    .line 69
    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 73
    const v2, 0x7f070090

    invoke-virtual {p0, v2}, Lcom/aio/downloader/dialog/AnzhuangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    iput-object v2, p0, Lcom/aio/downloader/dialog/AnzhuangDialog;->cleanercancel:Landroid/widget/Button;

    .line 74
    const v2, 0x7f070096

    invoke-virtual {p0, v2}, Lcom/aio/downloader/dialog/AnzhuangDialog;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/RelativeLayout;

    iput-object v2, p0, Lcom/aio/downloader/dialog/AnzhuangDialog;->cleanerupdate:Landroid/widget/RelativeLayout;

    .line 75
    iget-object v2, p0, Lcom/aio/downloader/dialog/AnzhuangDialog;->cleanercancel:Landroid/widget/Button;

    iget-object v3, p0, Lcom/aio/downloader/dialog/AnzhuangDialog;->itemsOnClick:Landroid/view/View$OnClickListener;

    invoke-virtual {v2, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 76
    iget-object v2, p0, Lcom/aio/downloader/dialog/AnzhuangDialog;->cleanerupdate:Landroid/widget/RelativeLayout;

    iget-object v3, p0, Lcom/aio/downloader/dialog/AnzhuangDialog;->itemsOnClick:Landroid/view/View$OnClickListener;

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 77
    return-void

    .line 55
    :catch_0
    move-exception v0

    .line 56
    .local v0, "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :try_start_2
    invoke-virtual {v0}, Landroid/content/pm/PackageManager$NameNotFoundException;->printStackTrace()V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    goto/16 :goto_0

    .line 62
    .end local v0    # "e":Landroid/content/pm/PackageManager$NameNotFoundException;
    :catch_1
    move-exception v2

    goto/16 :goto_1
.end method
