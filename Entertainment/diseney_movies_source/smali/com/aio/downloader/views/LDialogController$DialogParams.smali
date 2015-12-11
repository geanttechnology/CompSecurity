.class public Lcom/aio/downloader/views/LDialogController$DialogParams;
.super Ljava/lang/Object;
.source "LDialogController.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/views/LDialogController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "DialogParams"
.end annotation


# instance fields
.field public centerMsg:Z

.field public clickPositiveBtnDismiss:Z

.field public mCancelable:Z

.field public mCloseListener:Landroid/content/DialogInterface$OnClickListener;

.field public final mContext:Landroid/content/Context;

.field public mIcon:Landroid/graphics/drawable/Drawable;

.field public mIconId:I

.field public final mInflater:Landroid/view/LayoutInflater;

.field public mMessage:Ljava/lang/CharSequence;

.field public mNegativeButtonListener:Landroid/content/DialogInterface$OnClickListener;

.field public mNegativeButtonText:Ljava/lang/CharSequence;

.field public mOnCancelListener:Landroid/content/DialogInterface$OnCancelListener;

.field public mOnClickListener:Landroid/content/DialogInterface$OnClickListener;

.field public mPositiveButtonListener:Landroid/content/DialogInterface$OnClickListener;

.field public mPositiveButtonText:Ljava/lang/CharSequence;

.field public mTitle:Ljava/lang/CharSequence;

.field public mView:Landroid/view/View;

.field public visibleCallback:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x1

    .line 338
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 320
    const/4 v0, 0x0

    iput v0, p0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mIconId:I

    .line 339
    iput-object p1, p0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mContext:Landroid/content/Context;

    .line 340
    iput-boolean v1, p0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mCancelable:Z

    .line 341
    iput-boolean v1, p0, Lcom/aio/downloader/views/LDialogController$DialogParams;->clickPositiveBtnDismiss:Z

    .line 343
    const-string v0, "layout_inflater"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    .line 342
    iput-object v0, p0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mInflater:Landroid/view/LayoutInflater;

    .line 344
    return-void
.end method


# virtual methods
.method public apply(Lcom/aio/downloader/views/LDialogController;)V
    .locals 4
    .param p1, "control"    # Lcom/aio/downloader/views/LDialogController;

    .prologue
    const/4 v3, 0x0

    .line 347
    iget-boolean v0, p0, Lcom/aio/downloader/views/LDialogController$DialogParams;->clickPositiveBtnDismiss:Z

    invoke-virtual {p1, v0}, Lcom/aio/downloader/views/LDialogController;->setClickPositiveBtnDismiss(Z)V

    .line 348
    iget-boolean v0, p0, Lcom/aio/downloader/views/LDialogController$DialogParams;->centerMsg:Z

    invoke-virtual {p1, v0}, Lcom/aio/downloader/views/LDialogController;->setCenterMsg(Z)V

    .line 349
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mTitle:Ljava/lang/CharSequence;

    if-eqz v0, :cond_0

    .line 350
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mTitle:Ljava/lang/CharSequence;

    invoke-virtual {p1, v0}, Lcom/aio/downloader/views/LDialogController;->setTitle(Ljava/lang/CharSequence;)V

    .line 352
    :cond_0
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mIcon:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_1

    .line 353
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mIcon:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p1, v0}, Lcom/aio/downloader/views/LDialogController;->setIcon(Landroid/graphics/drawable/Drawable;)V

    .line 355
    :cond_1
    iget-boolean v0, p0, Lcom/aio/downloader/views/LDialogController$DialogParams;->visibleCallback:Z

    invoke-virtual {p1, v0}, Lcom/aio/downloader/views/LDialogController;->setCloseButton(Z)V

    .line 357
    iget v0, p0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mIconId:I

    if-ltz v0, :cond_2

    .line 358
    iget v0, p0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mIconId:I

    invoke-virtual {p1, v0}, Lcom/aio/downloader/views/LDialogController;->setIcon(I)V

    .line 360
    :cond_2
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mMessage:Ljava/lang/CharSequence;

    if-eqz v0, :cond_3

    .line 361
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mMessage:Ljava/lang/CharSequence;

    invoke-virtual {p1, v0}, Lcom/aio/downloader/views/LDialogController;->setMessage(Ljava/lang/CharSequence;)V

    .line 364
    :cond_3
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mPositiveButtonText:Ljava/lang/CharSequence;

    if-eqz v0, :cond_4

    .line 365
    const/4 v0, -0x1

    .line 366
    iget-object v1, p0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mPositiveButtonText:Ljava/lang/CharSequence;

    iget-object v2, p0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mPositiveButtonListener:Landroid/content/DialogInterface$OnClickListener;

    .line 365
    invoke-virtual {p1, v0, v1, v2, v3}, Lcom/aio/downloader/views/LDialogController;->setButton(ILjava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;Landroid/os/Message;)V

    .line 368
    :cond_4
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mNegativeButtonText:Ljava/lang/CharSequence;

    if-eqz v0, :cond_5

    .line 369
    const/4 v0, -0x2

    .line 370
    iget-object v1, p0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mNegativeButtonText:Ljava/lang/CharSequence;

    iget-object v2, p0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mNegativeButtonListener:Landroid/content/DialogInterface$OnClickListener;

    .line 369
    invoke-virtual {p1, v0, v1, v2, v3}, Lcom/aio/downloader/views/LDialogController;->setButton(ILjava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;Landroid/os/Message;)V

    .line 372
    :cond_5
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mView:Landroid/view/View;

    if-eqz v0, :cond_6

    .line 373
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mView:Landroid/view/View;

    invoke-virtual {p1, v0}, Lcom/aio/downloader/views/LDialogController;->setView(Landroid/view/View;)V

    .line 375
    :cond_6
    return-void
.end method
