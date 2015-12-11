.class public Lcom/amazon/mShop/search/image/SnapItPhotoPreviewActivity;
.super Lcom/amazon/mShop/AmazonActivity;
.source "SnapItPhotoPreviewActivity.java"


# instance fields
.field private view:Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Lcom/amazon/mShop/AmazonActivity;-><init>()V

    return-void
.end method


# virtual methods
.method public getLastCapturedPhoto()[B
    .locals 1

    .prologue
    .line 33
    invoke-static {}, Lcom/amazon/mShop/search/image/SnapItActivity;->getLastPhotoCapturedOriginal()[B

    move-result-object v0

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/16 v1, 0x400

    .line 17
    invoke-super {p0, p1}, Lcom/amazon/mShop/AmazonActivity;->onCreate(Landroid/os/Bundle;)V

    .line 20
    invoke-virtual {p0}, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewActivity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, v1, v1}, Landroid/view/Window;->setFlags(II)V

    .line 21
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewActivity;->requestWindowFeature(I)Z

    .line 22
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;)Z
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;

    .prologue
    .line 51
    const/4 v0, 0x0

    return v0
.end method

.method public onSearchRequested()Z
    .locals 1

    .prologue
    .line 56
    const/4 v0, 0x0

    return v0
.end method

.method protected onStart()V
    .locals 2

    .prologue
    .line 26
    invoke-super {p0}, Lcom/amazon/mShop/AmazonActivity;->onStart()V

    .line 27
    new-instance v0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;-><init>(Lcom/amazon/mShop/search/image/SnapItPhotoPreviewActivity;)V

    iput-object v0, p0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewActivity;->view:Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;

    .line 28
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewActivity;->view:Lcom/amazon/mShop/search/image/SnapItPhotoPreviewView;

    const/4 v1, 0x0

    invoke-super {p0, v0, v1}, Lcom/amazon/mShop/AmazonActivity;->setRootView(Landroid/view/View;Z)V

    .line 29
    return-void
.end method

.method public retakePhoto()V
    .locals 1

    .prologue
    .line 44
    const/16 v0, 0x3ea

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewActivity;->setResult(I)V

    .line 45
    invoke-virtual {p0}, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewActivity;->finish()V

    .line 46
    return-void
.end method

.method public usePhoto()V
    .locals 1

    .prologue
    .line 38
    const/16 v0, 0x3eb

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewActivity;->setResult(I)V

    .line 39
    invoke-virtual {p0}, Lcom/amazon/mShop/search/image/SnapItPhotoPreviewActivity;->finish()V

    .line 40
    return-void
.end method
