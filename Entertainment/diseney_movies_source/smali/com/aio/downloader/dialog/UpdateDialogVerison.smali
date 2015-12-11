.class public Lcom/aio/downloader/dialog/UpdateDialogVerison;
.super Landroid/app/Dialog;
.source "UpdateDialogVerison.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/dialog/UpdateDialogVerison$AnimateFirstDisplayListener;,
        Lcom/aio/downloader/dialog/UpdateDialogVerison$OnCustomDialogListener;
    }
.end annotation


# instance fields
.field private animateFirstListener:Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;

.field private btnCancel:Landroid/widget/Button;

.field private btnEnter:Landroid/widget/Button;

.field private ctx:Landroid/content/Context;

.field private imageLoader:Lcom/nostra13/universalimageloader/core/ImageLoader;

.field private imgIcon:Landroid/widget/ImageView;

.field private itemsOnClick:Landroid/view/View$OnClickListener;

.field private options:Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

.field private timeupdate:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;ILandroid/view/View$OnClickListener;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "customdialog"    # I
    .param p3, "itemsOnClick"    # Landroid/view/View$OnClickListener;

    .prologue
    .line 42
    invoke-direct {p0, p1, p2}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 32
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/dialog/UpdateDialogVerison;->imageLoader:Lcom/nostra13/universalimageloader/core/ImageLoader;

    .line 33
    new-instance v0, Lcom/aio/downloader/dialog/UpdateDialogVerison$AnimateFirstDisplayListener;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/aio/downloader/dialog/UpdateDialogVerison$AnimateFirstDisplayListener;-><init>(Lcom/aio/downloader/dialog/UpdateDialogVerison$AnimateFirstDisplayListener;)V

    iput-object v0, p0, Lcom/aio/downloader/dialog/UpdateDialogVerison;->animateFirstListener:Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;

    .line 43
    iput-object p1, p0, Lcom/aio/downloader/dialog/UpdateDialogVerison;->ctx:Landroid/content/Context;

    .line 44
    iput-object p3, p0, Lcom/aio/downloader/dialog/UpdateDialogVerison;->itemsOnClick:Landroid/view/View$OnClickListener;

    .line 45
    new-instance v0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    invoke-direct {v0}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;-><init>()V

    invoke-virtual {v0}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->cacheOnDisc()Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v0

    .line 46
    const v1, 0x7f0200eb

    invoke-virtual {v0, v1}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->showImageForEmptyUri(I)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v0

    .line 47
    new-instance v1, Lcom/nostra13/universalimageloader/core/display/RoundedBitmapDisplayer;

    const/16 v2, 0x8

    invoke-direct {v1, v2}, Lcom/nostra13/universalimageloader/core/display/RoundedBitmapDisplayer;-><init>(I)V

    invoke-virtual {v0, v1}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->displayer(Lcom/nostra13/universalimageloader/core/display/BitmapDisplayer;)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->build()Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

    move-result-object v0

    .line 45
    iput-object v0, p0, Lcom/aio/downloader/dialog/UpdateDialogVerison;->options:Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

    .line 48
    return-void
.end method


# virtual methods
.method protected onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 52
    invoke-super {p0, p1}, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V

    .line 53
    const v0, 0x7f03002e

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/UpdateDialogVerison;->setContentView(I)V

    .line 54
    const v0, 0x7f070157

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/UpdateDialogVerison;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/dialog/UpdateDialogVerison;->btnCancel:Landroid/widget/Button;

    .line 55
    const v0, 0x7f070158

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/UpdateDialogVerison;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/aio/downloader/dialog/UpdateDialogVerison;->btnEnter:Landroid/widget/Button;

    .line 56
    const v0, 0x7f070156

    invoke-virtual {p0, v0}, Lcom/aio/downloader/dialog/UpdateDialogVerison;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/dialog/UpdateDialogVerison;->timeupdate:Landroid/widget/TextView;

    .line 61
    iget-object v0, p0, Lcom/aio/downloader/dialog/UpdateDialogVerison;->btnCancel:Landroid/widget/Button;

    iget-object v1, p0, Lcom/aio/downloader/dialog/UpdateDialogVerison;->itemsOnClick:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 62
    iget-object v0, p0, Lcom/aio/downloader/dialog/UpdateDialogVerison;->btnEnter:Landroid/widget/Button;

    iget-object v1, p0, Lcom/aio/downloader/dialog/UpdateDialogVerison;->itemsOnClick:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 63
    return-void
.end method

.method public setImgIcon(Ljava/lang/String;)V
    .locals 4
    .param p1, "str"    # Ljava/lang/String;

    .prologue
    .line 74
    iget-object v0, p0, Lcom/aio/downloader/dialog/UpdateDialogVerison;->imageLoader:Lcom/nostra13/universalimageloader/core/ImageLoader;

    iget-object v1, p0, Lcom/aio/downloader/dialog/UpdateDialogVerison;->ctx:Landroid/content/Context;

    invoke-static {v1}, Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;->createDefault(Landroid/content/Context;)Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/nostra13/universalimageloader/core/ImageLoader;->init(Lcom/nostra13/universalimageloader/core/ImageLoaderConfiguration;)V

    .line 75
    iget-object v0, p0, Lcom/aio/downloader/dialog/UpdateDialogVerison;->imageLoader:Lcom/nostra13/universalimageloader/core/ImageLoader;

    iget-object v1, p0, Lcom/aio/downloader/dialog/UpdateDialogVerison;->imgIcon:Landroid/widget/ImageView;

    iget-object v2, p0, Lcom/aio/downloader/dialog/UpdateDialogVerison;->options:Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

    iget-object v3, p0, Lcom/aio/downloader/dialog/UpdateDialogVerison;->animateFirstListener:Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;

    invoke-virtual {v0, p1, v1, v2, v3}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;Lcom/nostra13/universalimageloader/core/DisplayImageOptions;Lcom/nostra13/universalimageloader/core/assist/ImageLoadingListener;)V

    .line 76
    return-void
.end method

.method public setTvTitle(Ljava/lang/String;)V
    .locals 1
    .param p1, "str"    # Ljava/lang/String;

    .prologue
    .line 66
    iget-object v0, p0, Lcom/aio/downloader/dialog/UpdateDialogVerison;->timeupdate:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 67
    return-void
.end method
