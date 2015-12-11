.class public Lcom/aio/downloader/views/LAlertDialog$Builder;
.super Ljava/lang/Object;
.source "LAlertDialog.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/views/LAlertDialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation


# instance fields
.field private final P:Lcom/aio/downloader/views/LDialogController$DialogParams;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 59
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 60
    new-instance v0, Lcom/aio/downloader/views/LDialogController$DialogParams;

    invoke-direct {v0, p1}, Lcom/aio/downloader/views/LDialogController$DialogParams;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    .line 61
    return-void
.end method


# virtual methods
.method public create()Lcom/aio/downloader/views/LAlertDialog;
    .locals 3

    .prologue
    .line 257
    new-instance v0, Lcom/aio/downloader/views/LAlertDialog;

    iget-object v1, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iget-object v1, v1, Lcom/aio/downloader/views/LDialogController$DialogParams;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/aio/downloader/views/LAlertDialog;-><init>(Landroid/content/Context;)V

    .line 258
    .local v0, "dialog":Lcom/aio/downloader/views/LAlertDialog;
    iget-object v1, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    # getter for: Lcom/aio/downloader/views/LAlertDialog;->control:Lcom/aio/downloader/views/LDialogController;
    invoke-static {v0}, Lcom/aio/downloader/views/LAlertDialog;->access$0(Lcom/aio/downloader/views/LAlertDialog;)Lcom/aio/downloader/views/LDialogController;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/aio/downloader/views/LDialogController$DialogParams;->apply(Lcom/aio/downloader/views/LDialogController;)V

    .line 259
    iget-object v1, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iget-boolean v1, v1, Lcom/aio/downloader/views/LDialogController$DialogParams;->mCancelable:Z

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/LAlertDialog;->setCancelable(Z)V

    .line 260
    iget-object v1, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iget-boolean v1, v1, Lcom/aio/downloader/views/LDialogController$DialogParams;->mCancelable:Z

    if-eqz v1, :cond_0

    .line 261
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/LAlertDialog;->setCanceledOnTouchOutside(Z)V

    .line 263
    :cond_0
    iget-object v1, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iget-object v1, v1, Lcom/aio/downloader/views/LDialogController$DialogParams;->mOnCancelListener:Landroid/content/DialogInterface$OnCancelListener;

    invoke-virtual {v0, v1}, Lcom/aio/downloader/views/LAlertDialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 264
    return-object v0
.end method

.method public setCancelable(Z)Lcom/aio/downloader/views/LAlertDialog$Builder;
    .locals 1
    .param p1, "cancelable"    # Z

    .prologue
    .line 231
    iget-object v0, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iput-boolean p1, v0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mCancelable:Z

    .line 232
    return-object p0
.end method

.method public setCenterMsg(Z)Lcom/aio/downloader/views/LAlertDialog$Builder;
    .locals 1
    .param p1, "value"    # Z

    .prologue
    .line 141
    iget-object v0, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iput-boolean p1, v0, Lcom/aio/downloader/views/LDialogController$DialogParams;->centerMsg:Z

    .line 142
    return-object p0
.end method

.method public setClickPositiveBtnDismiss(Z)Lcom/aio/downloader/views/LAlertDialog$Builder;
    .locals 1
    .param p1, "value"    # Z

    .prologue
    .line 194
    iget-object v0, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iput-boolean p1, v0, Lcom/aio/downloader/views/LDialogController$DialogParams;->clickPositiveBtnDismiss:Z

    .line 195
    return-object p0
.end method

.method public setIcon(I)Lcom/aio/downloader/views/LAlertDialog$Builder;
    .locals 1
    .param p1, "iconId"    # I

    .prologue
    .line 119
    iget-object v0, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iput p1, v0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mIconId:I

    .line 120
    return-object p0
.end method

.method public setIcon(Landroid/graphics/drawable/Drawable;)Lcom/aio/downloader/views/LAlertDialog$Builder;
    .locals 1
    .param p1, "icon"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 130
    iget-object v0, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iput-object p1, v0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mIcon:Landroid/graphics/drawable/Drawable;

    .line 131
    return-object p0
.end method

.method public setMessage(I)Lcom/aio/downloader/views/LAlertDialog$Builder;
    .locals 2
    .param p1, "messageId"    # I

    .prologue
    .line 92
    iget-object v0, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iget-object v1, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iget-object v1, v1, Lcom/aio/downloader/views/LDialogController$DialogParams;->mContext:Landroid/content/Context;

    invoke-virtual {v1, p1}, Landroid/content/Context;->getText(I)Ljava/lang/CharSequence;

    move-result-object v1

    iput-object v1, v0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mMessage:Ljava/lang/CharSequence;

    .line 93
    return-object p0
.end method

.method public setMessage(Ljava/lang/CharSequence;)Lcom/aio/downloader/views/LAlertDialog$Builder;
    .locals 1
    .param p1, "message"    # Ljava/lang/CharSequence;

    .prologue
    .line 103
    iget-object v0, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iput-object p1, v0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mMessage:Ljava/lang/CharSequence;

    .line 104
    return-object p0
.end method

.method public setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/aio/downloader/views/LAlertDialog$Builder;
    .locals 2
    .param p1, "textId"    # I
    .param p2, "listener"    # Landroid/content/DialogInterface$OnClickListener;

    .prologue
    .line 209
    iget-object v0, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iget-object v1, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iget-object v1, v1, Lcom/aio/downloader/views/LDialogController$DialogParams;->mContext:Landroid/content/Context;

    invoke-virtual {v1, p1}, Landroid/content/Context;->getText(I)Ljava/lang/CharSequence;

    move-result-object v1

    iput-object v1, v0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mNegativeButtonText:Ljava/lang/CharSequence;

    .line 210
    iget-object v0, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iput-object p2, v0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mNegativeButtonListener:Landroid/content/DialogInterface$OnClickListener;

    .line 211
    return-object p0
.end method

.method public setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Lcom/aio/downloader/views/LAlertDialog$Builder;
    .locals 1
    .param p1, "text"    # Ljava/lang/CharSequence;
    .param p2, "listener"    # Landroid/content/DialogInterface$OnClickListener;

    .prologue
    .line 225
    iget-object v0, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iput-object p1, v0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mNegativeButtonText:Ljava/lang/CharSequence;

    .line 226
    iget-object v0, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iput-object p2, v0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mNegativeButtonListener:Landroid/content/DialogInterface$OnClickListener;

    .line 227
    return-object p0
.end method

.method public setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)Lcom/aio/downloader/views/LAlertDialog$Builder;
    .locals 1
    .param p1, "onCancelListener"    # Landroid/content/DialogInterface$OnCancelListener;

    .prologue
    .line 236
    iget-object v0, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iput-object p1, v0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mOnCancelListener:Landroid/content/DialogInterface$OnCancelListener;

    .line 237
    return-object p0
.end method

.method public setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/aio/downloader/views/LAlertDialog$Builder;
    .locals 2
    .param p1, "textId"    # I
    .param p2, "listener"    # Landroid/content/DialogInterface$OnClickListener;

    .prologue
    .line 167
    iget-object v0, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iget-object v1, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iget-object v1, v1, Lcom/aio/downloader/views/LDialogController$DialogParams;->mContext:Landroid/content/Context;

    invoke-virtual {v1, p1}, Landroid/content/Context;->getText(I)Ljava/lang/CharSequence;

    move-result-object v1

    iput-object v1, v0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mPositiveButtonText:Ljava/lang/CharSequence;

    .line 168
    iget-object v0, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iput-object p2, v0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mPositiveButtonListener:Landroid/content/DialogInterface$OnClickListener;

    .line 169
    return-object p0
.end method

.method public setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Lcom/aio/downloader/views/LAlertDialog$Builder;
    .locals 1
    .param p1, "text"    # Ljava/lang/CharSequence;
    .param p2, "listener"    # Landroid/content/DialogInterface$OnClickListener;

    .prologue
    .line 183
    iget-object v0, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iput-object p1, v0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mPositiveButtonText:Ljava/lang/CharSequence;

    .line 184
    iget-object v0, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iput-object p2, v0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mPositiveButtonListener:Landroid/content/DialogInterface$OnClickListener;

    .line 185
    return-object p0
.end method

.method public setTitle(I)Lcom/aio/downloader/views/LAlertDialog$Builder;
    .locals 2
    .param p1, "titleId"    # I

    .prologue
    .line 70
    iget-object v0, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iget-object v1, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iget-object v1, v1, Lcom/aio/downloader/views/LDialogController$DialogParams;->mContext:Landroid/content/Context;

    invoke-virtual {v1, p1}, Landroid/content/Context;->getText(I)Ljava/lang/CharSequence;

    move-result-object v1

    iput-object v1, v0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mTitle:Ljava/lang/CharSequence;

    .line 71
    return-object p0
.end method

.method public setTitle(Ljava/lang/CharSequence;)Lcom/aio/downloader/views/LAlertDialog$Builder;
    .locals 1
    .param p1, "title"    # Ljava/lang/CharSequence;

    .prologue
    .line 81
    iget-object v0, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iput-object p1, v0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mTitle:Ljava/lang/CharSequence;

    .line 82
    return-object p0
.end method

.method public setView(Landroid/view/View;)Lcom/aio/downloader/views/LAlertDialog$Builder;
    .locals 1
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 247
    iget-object v0, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iput-object p1, v0, Lcom/aio/downloader/views/LDialogController$DialogParams;->mView:Landroid/view/View;

    .line 248
    return-object p0
.end method

.method public show()Lcom/aio/downloader/views/LAlertDialog;
    .locals 1

    .prologue
    .line 273
    invoke-virtual {p0}, Lcom/aio/downloader/views/LAlertDialog$Builder;->create()Lcom/aio/downloader/views/LAlertDialog;

    move-result-object v0

    .line 274
    .local v0, "dialog":Lcom/aio/downloader/views/LAlertDialog;
    invoke-virtual {v0}, Lcom/aio/downloader/views/LAlertDialog;->show()V

    .line 275
    return-object v0
.end method

.method public showCloseButton(Z)Lcom/aio/downloader/views/LAlertDialog$Builder;
    .locals 1
    .param p1, "show"    # Z

    .prologue
    .line 108
    iget-object v0, p0, Lcom/aio/downloader/views/LAlertDialog$Builder;->P:Lcom/aio/downloader/views/LDialogController$DialogParams;

    iput-boolean p1, v0, Lcom/aio/downloader/views/LDialogController$DialogParams;->visibleCallback:Z

    .line 109
    return-object p0
.end method
