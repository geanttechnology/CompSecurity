.class public Lcom/amazon/mShop/photo/PhotoCaptureActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "PhotoCaptureActivity.java"


# instance fields
.field private mIsFocusKeyAlreadyPressing:Z

.field private mView:Lcom/amazon/mShop/photo/PhotoCaptureView;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    .line 85
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureActivity;->mIsFocusKeyAlreadyPressing:Z

    return-void
.end method


# virtual methods
.method protected cleanupMyView()V
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureActivity;->mView:Lcom/amazon/mShop/photo/PhotoCaptureView;

    if-eqz v0, :cond_0

    .line 48
    iget-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureActivity;->mView:Lcom/amazon/mShop/photo/PhotoCaptureView;

    invoke-virtual {v0}, Lcom/amazon/mShop/photo/PhotoCaptureView;->release()V

    .line 49
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureActivity;->mView:Lcom/amazon/mShop/photo/PhotoCaptureView;

    .line 51
    :cond_0
    return-void
.end method

.method protected createPhotoCaptureView()Lcom/amazon/mShop/photo/PhotoCaptureView;
    .locals 1

    .prologue
    .line 118
    new-instance v0, Lcom/amazon/mShop/photo/PhotoCaptureView;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/photo/PhotoCaptureView;-><init>(Lcom/amazon/mShop/photo/PhotoCaptureActivity;)V

    return-object v0
.end method

.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 5
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/16 v4, 0x50

    const/4 v3, 0x0

    const/4 v0, 0x1

    .line 89
    const/16 v1, 0x1b

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v2

    if-ne v1, v2, :cond_1

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v1

    if-nez v1, :cond_1

    .line 90
    iget-object v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureActivity;->mView:Lcom/amazon/mShop/photo/PhotoCaptureView;

    if-eqz v1, :cond_0

    .line 91
    iget-object v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureActivity;->mView:Lcom/amazon/mShop/photo/PhotoCaptureView;

    invoke-virtual {v1}, Lcom/amazon/mShop/photo/PhotoCaptureView;->doTakePhoto()V

    .line 104
    :cond_0
    :goto_0
    return v0

    .line 94
    :cond_1
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v1

    if-ne v4, v1, :cond_2

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v1

    if-nez v1, :cond_2

    .line 95
    iget-object v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureActivity;->mView:Lcom/amazon/mShop/photo/PhotoCaptureView;

    if-eqz v1, :cond_0

    iget-boolean v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureActivity;->mIsFocusKeyAlreadyPressing:Z

    if-nez v1, :cond_0

    .line 96
    iget-object v1, p0, Lcom/amazon/mShop/photo/PhotoCaptureActivity;->mView:Lcom/amazon/mShop/photo/PhotoCaptureView;

    invoke-virtual {v1, v3}, Lcom/amazon/mShop/photo/PhotoCaptureView;->doAutoFocus(Z)V

    .line 97
    iput-boolean v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureActivity;->mIsFocusKeyAlreadyPressing:Z

    goto :goto_0

    .line 100
    :cond_2
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v1

    if-ne v4, v1, :cond_3

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v1

    if-ne v0, v1, :cond_3

    .line 101
    iput-boolean v3, p0, Lcom/amazon/mShop/photo/PhotoCaptureActivity;->mIsFocusKeyAlreadyPressing:Z

    goto :goto_0

    .line 104
    :cond_3
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public handleCancelPhoto()V
    .locals 1

    .prologue
    .line 122
    invoke-virtual {p0}, Lcom/amazon/mShop/photo/PhotoCaptureActivity;->cleanupMyView()V

    .line 123
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/photo/PhotoCaptureActivity;->setResult(I)V

    .line 124
    invoke-virtual {p0}, Lcom/amazon/mShop/photo/PhotoCaptureActivity;->finish()V

    .line 125
    return-void
.end method

.method public handlePhotoTaken([BI)V
    .locals 0
    .param p1, "jpegData"    # [B
    .param p2, "lastKnownOrientation"    # I

    .prologue
    .line 135
    invoke-virtual {p0}, Lcom/amazon/mShop/photo/PhotoCaptureActivity;->cleanupMyView()V

    .line 136
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/16 v1, 0x400

    .line 18
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 21
    invoke-virtual {p0}, Lcom/amazon/mShop/photo/PhotoCaptureActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, v1, v1}, Landroid/view/Window;->setFlags(II)V

    .line 22
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/photo/PhotoCaptureActivity;->requestWindowFeature(I)Z

    .line 23
    invoke-virtual {p0}, Lcom/amazon/mShop/photo/PhotoCaptureActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 24
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 57
    const/4 v0, 0x0

    return v0
.end method

.method public onKeyUp(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 76
    const/4 v0, 0x4

    if-ne p1, v0, :cond_0

    .line 77
    invoke-virtual {p0}, Lcom/amazon/mShop/photo/PhotoCaptureActivity;->handleCancelPhoto()V

    .line 78
    const/4 v0, 0x1

    .line 80
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/AmazonActivity;->onKeyUp(ILandroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method protected onResume()V
    .locals 1

    .prologue
    .line 29
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onResume()V

    .line 37
    invoke-virtual {p0}, Lcom/amazon/mShop/photo/PhotoCaptureActivity;->cleanupMyView()V

    .line 38
    invoke-virtual {p0}, Lcom/amazon/mShop/photo/PhotoCaptureActivity;->createPhotoCaptureView()Lcom/amazon/mShop/photo/PhotoCaptureView;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureActivity;->mView:Lcom/amazon/mShop/photo/PhotoCaptureView;

    .line 42
    iget-object v0, p0, Lcom/amazon/mShop/photo/PhotoCaptureActivity;->mView:Lcom/amazon/mShop/photo/PhotoCaptureView;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/photo/PhotoCaptureActivity;->setContentView(Landroid/view/View;)V

    .line 43
    return-void
.end method

.method public onSearchRequested()Z
    .locals 1

    .prologue
    .line 62
    const/4 v0, 0x0

    return v0
.end method
