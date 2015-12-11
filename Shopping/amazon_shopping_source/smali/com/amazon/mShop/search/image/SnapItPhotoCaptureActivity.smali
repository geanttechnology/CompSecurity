.class public Lcom/amazon/mShop/search/image/SnapItPhotoCaptureActivity;
.super Lcom/amazon/mShop/photo/PhotoCaptureActivity;
.source "SnapItPhotoCaptureActivity.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 7
    invoke-direct {p0}, Lcom/amazon/mShop/photo/PhotoCaptureActivity;-><init>()V

    return-void
.end method


# virtual methods
.method protected createPhotoCaptureView()Lcom/amazon/mShop/photo/PhotoCaptureView;
    .locals 1

    .prologue
    .line 20
    new-instance v0, Lcom/amazon/mShop/search/image/SnapItPhotoCaptureView;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/search/image/SnapItPhotoCaptureView;-><init>(Lcom/amazon/mShop/search/image/SnapItPhotoCaptureActivity;)V

    return-object v0
.end method

.method public handlePhotoTaken([BI)V
    .locals 1
    .param p1, "jpegData"    # [B
    .param p2, "lastKnownOrientation"    # I

    .prologue
    .line 11
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/photo/PhotoCaptureActivity;->handlePhotoTaken([BI)V

    .line 13
    invoke-static {p1, p2}, Lcom/amazon/mShop/search/image/SnapItActivity;->setLastPhotoCaptured([BI)V

    .line 14
    const/16 v0, 0x3e9

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/image/SnapItPhotoCaptureActivity;->setResult(I)V

    .line 15
    invoke-virtual {p0}, Lcom/amazon/mShop/search/image/SnapItPhotoCaptureActivity;->finish()V

    .line 16
    return-void
.end method
