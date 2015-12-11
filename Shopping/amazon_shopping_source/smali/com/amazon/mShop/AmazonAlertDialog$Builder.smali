.class public Lcom/amazon/mShop/AmazonAlertDialog$Builder;
.super Ljava/lang/Object;
.source "AmazonAlertDialog.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/AmazonAlertDialog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;
    }
.end annotation


# instance fields
.field private mContentView:Landroid/view/View;

.field private mIcon:Landroid/graphics/drawable/Drawable;

.field private myCancelable:Ljava/lang/Boolean;

.field private final myContext:Landroid/content/Context;

.field private myMessage:Ljava/lang/CharSequence;

.field private myNegativeButton:Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;

.field private myNeutralButton:Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;

.field private myOnCancelListener:Landroid/content/DialogInterface$OnCancelListener;

.field private myPositiveButton:Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;

.field private myTitle:Ljava/lang/CharSequence;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 155
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 156
    iput-object p1, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myContext:Landroid/content/Context;

    .line 157
    return-void
.end method


# virtual methods
.method public create()Lcom/amazon/mShop/AmazonAlertDialog;
    .locals 2

    .prologue
    .line 218
    new-instance v0, Lcom/amazon/mShop/AmazonAlertDialog;

    iget-object v1, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/mShop/AmazonAlertDialog;-><init>(Landroid/content/Context;)V

    .line 219
    .local v0, "dialog":Lcom/amazon/mShop/AmazonAlertDialog;
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->init(Lcom/amazon/mShop/AmazonAlertDialog;)Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v1

    return-object v1
.end method

.method public init(Lcom/amazon/mShop/AmazonAlertDialog;)Lcom/amazon/mShop/AmazonAlertDialog;
    .locals 3
    .param p1, "dialog"    # Lcom/amazon/mShop/AmazonAlertDialog;

    .prologue
    .line 228
    iget-object v0, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->mContentView:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 229
    iget-object v0, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->mContentView:Landroid/view/View;

    invoke-virtual {p1, v0}, Lcom/amazon/mShop/AmazonAlertDialog;->setView(Landroid/view/View;)V

    .line 232
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myTitle:Ljava/lang/CharSequence;

    if-eqz v0, :cond_1

    .line 233
    iget-object v0, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myTitle:Ljava/lang/CharSequence;

    invoke-virtual {p1, v0}, Lcom/amazon/mShop/AmazonAlertDialog;->setTitle(Ljava/lang/CharSequence;)V

    .line 236
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myMessage:Ljava/lang/CharSequence;

    if-eqz v0, :cond_2

    .line 237
    iget-object v0, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myMessage:Ljava/lang/CharSequence;

    invoke-virtual {p1, v0}, Lcom/amazon/mShop/AmazonAlertDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 240
    :cond_2
    iget-object v0, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myPositiveButton:Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;

    if-eqz v0, :cond_3

    .line 241
    const/4 v0, -0x1

    iget-object v1, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myPositiveButton:Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;

    iget v2, v2, Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;->textResId:I

    invoke-virtual {v1, v2}, Landroid/content/Context;->getText(I)Ljava/lang/CharSequence;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myPositiveButton:Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;

    iget-object v2, v2, Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;->listener:Landroid/content/DialogInterface$OnClickListener;

    invoke-virtual {p1, v0, v1, v2}, Lcom/amazon/mShop/AmazonAlertDialog;->setButton(ILjava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)V

    .line 244
    :cond_3
    iget-object v0, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myNeutralButton:Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;

    if-eqz v0, :cond_4

    .line 245
    const/4 v0, -0x3

    iget-object v1, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myNeutralButton:Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;

    iget v2, v2, Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;->textResId:I

    invoke-virtual {v1, v2}, Landroid/content/Context;->getText(I)Ljava/lang/CharSequence;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myNeutralButton:Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;

    iget-object v2, v2, Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;->listener:Landroid/content/DialogInterface$OnClickListener;

    invoke-virtual {p1, v0, v1, v2}, Lcom/amazon/mShop/AmazonAlertDialog;->setButton(ILjava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)V

    .line 248
    :cond_4
    iget-object v0, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myNegativeButton:Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;

    if-eqz v0, :cond_5

    .line 249
    const/4 v0, -0x2

    iget-object v1, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myContext:Landroid/content/Context;

    iget-object v2, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myNegativeButton:Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;

    iget v2, v2, Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;->textResId:I

    invoke-virtual {v1, v2}, Landroid/content/Context;->getText(I)Ljava/lang/CharSequence;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myNegativeButton:Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;

    iget-object v2, v2, Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;->listener:Landroid/content/DialogInterface$OnClickListener;

    invoke-virtual {p1, v0, v1, v2}, Lcom/amazon/mShop/AmazonAlertDialog;->setButton(ILjava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)V

    .line 252
    :cond_5
    iget-object v0, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myCancelable:Ljava/lang/Boolean;

    if-eqz v0, :cond_6

    .line 253
    iget-object v0, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myCancelable:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    invoke-virtual {p1, v0}, Lcom/amazon/mShop/AmazonAlertDialog;->setCancelable(Z)V

    .line 256
    :cond_6
    iget-object v0, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myOnCancelListener:Landroid/content/DialogInterface$OnCancelListener;

    if-eqz v0, :cond_7

    .line 257
    iget-object v0, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myOnCancelListener:Landroid/content/DialogInterface$OnCancelListener;

    invoke-virtual {p1, v0}, Lcom/amazon/mShop/AmazonAlertDialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 260
    :cond_7
    iget-object v0, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->mIcon:Landroid/graphics/drawable/Drawable;

    if-eqz v0, :cond_8

    .line 261
    iget-object v0, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->mIcon:Landroid/graphics/drawable/Drawable;

    invoke-virtual {p1, v0}, Lcom/amazon/mShop/AmazonAlertDialog;->setIcon(Landroid/graphics/drawable/Drawable;)V

    .line 264
    :cond_8
    return-object p1
.end method

.method public setCancelable(Z)Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    .locals 1
    .param p1, "cancelable"    # Z

    .prologue
    .line 198
    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myCancelable:Ljava/lang/Boolean;

    .line 199
    return-object p0
.end method

.method public setMessage(I)Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    .locals 1
    .param p1, "messageResId"    # I

    .prologue
    .line 179
    iget-object v0, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myContext:Landroid/content/Context;

    invoke-virtual {v0, p1}, Landroid/content/Context;->getText(I)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v0

    return-object v0
.end method

.method public setMessage(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    .locals 0
    .param p1, "message"    # Ljava/lang/CharSequence;

    .prologue
    .line 174
    iput-object p1, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myMessage:Ljava/lang/CharSequence;

    .line 175
    return-object p0
.end method

.method public setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    .locals 2
    .param p1, "textResId"    # I
    .param p2, "listener"    # Landroid/content/DialogInterface$OnClickListener;

    .prologue
    .line 193
    new-instance v0, Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;

    const/4 v1, 0x0

    invoke-direct {v0, p0, p1, p2, v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;-><init>(Lcom/amazon/mShop/AmazonAlertDialog$Builder;ILandroid/content/DialogInterface$OnClickListener;Lcom/amazon/mShop/AmazonAlertDialog$1;)V

    iput-object v0, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myNegativeButton:Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;

    .line 194
    return-object p0
.end method

.method public setNeutralButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    .locals 2
    .param p1, "textResId"    # I
    .param p2, "listener"    # Landroid/content/DialogInterface$OnClickListener;

    .prologue
    .line 188
    new-instance v0, Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;

    const/4 v1, 0x0

    invoke-direct {v0, p0, p1, p2, v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;-><init>(Lcom/amazon/mShop/AmazonAlertDialog$Builder;ILandroid/content/DialogInterface$OnClickListener;Lcom/amazon/mShop/AmazonAlertDialog$1;)V

    iput-object v0, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myNeutralButton:Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;

    .line 189
    return-object p0
.end method

.method public setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    .locals 0
    .param p1, "listener"    # Landroid/content/DialogInterface$OnCancelListener;

    .prologue
    .line 203
    iput-object p1, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myOnCancelListener:Landroid/content/DialogInterface$OnCancelListener;

    .line 204
    return-object p0
.end method

.method public setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    .locals 2
    .param p1, "textResId"    # I
    .param p2, "listener"    # Landroid/content/DialogInterface$OnClickListener;

    .prologue
    .line 183
    new-instance v0, Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;

    const/4 v1, 0x0

    invoke-direct {v0, p0, p1, p2, v1}, Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;-><init>(Lcom/amazon/mShop/AmazonAlertDialog$Builder;ILandroid/content/DialogInterface$OnClickListener;Lcom/amazon/mShop/AmazonAlertDialog$1;)V

    iput-object v0, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myPositiveButton:Lcom/amazon/mShop/AmazonAlertDialog$Builder$ButtonData;

    .line 184
    return-object p0
.end method

.method public setTitle(I)Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    .locals 1
    .param p1, "titleResId"    # I

    .prologue
    .line 165
    iget-object v0, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myContext:Landroid/content/Context;

    invoke-virtual {v0, p1}, Landroid/content/Context;->getText(I)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    move-result-object v0

    return-object v0
.end method

.method public setTitle(Ljava/lang/CharSequence;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    .locals 0
    .param p1, "title"    # Ljava/lang/CharSequence;

    .prologue
    .line 160
    iput-object p1, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->myTitle:Ljava/lang/CharSequence;

    .line 161
    return-object p0
.end method

.method public setView(Landroid/view/View;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    .locals 0
    .param p1, "contentView"    # Landroid/view/View;

    .prologue
    .line 208
    iput-object p1, p0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->mContentView:Landroid/view/View;

    .line 209
    return-object p0
.end method
