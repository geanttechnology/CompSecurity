.class public Lcom/amazon/mShop/search/image/SnapItPhotoCaptureView;
.super Lcom/amazon/mShop/photo/PhotoCaptureView;
.source "SnapItPhotoCaptureView.java"


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/search/image/SnapItPhotoCaptureActivity;)V
    .locals 0
    .param p1, "activity"    # Lcom/amazon/mShop/search/image/SnapItPhotoCaptureActivity;

    .prologue
    .line 12
    invoke-direct {p0, p1}, Lcom/amazon/mShop/photo/PhotoCaptureView;-><init>(Lcom/amazon/mShop/photo/PhotoCaptureActivity;)V

    .line 14
    return-void
.end method


# virtual methods
.method public bridge synthetic getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 9
    invoke-virtual {p0}, Lcom/amazon/mShop/search/image/SnapItPhotoCaptureView;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 2

    .prologue
    .line 23
    invoke-virtual {p0}, Lcom/amazon/mShop/search/image/SnapItPhotoCaptureView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->snapit_photo_capture_view_title:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected inflateMoreView(Landroid/widget/FrameLayout;)Landroid/view/View;
    .locals 2
    .param p1, "photoFrame"    # Landroid/widget/FrameLayout;

    .prologue
    .line 18
    invoke-virtual {p0}, Lcom/amazon/mShop/search/image/SnapItPhotoCaptureView;->getContext()Landroid/content/Context;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$layout;->snap_it_more_view:I

    invoke-static {v0, v1, p1}, Lcom/amazon/mShop/search/image/SnapItPhotoCaptureView;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method
