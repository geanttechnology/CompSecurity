.class public Lcom/amazon/mShop/search/image/SnapItSearchResultsView;
.super Landroid/widget/ListView;
.source "SnapItSearchResultsView.java"

# interfaces
.implements Lcom/amazon/mShop/TitleProvider;
.implements Lcom/amazon/mShop/control/search/image/ImageSearchSubscriber;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/search/image/SnapItSearchResultsView$SnapItSearchResultAdapter;
    }
.end annotation


# instance fields
.field private final mAdapter:Lcom/amazon/mShop/search/image/SnapItSearchResultsView$SnapItSearchResultAdapter;

.field private final mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

.field private final mFooter:Landroid/view/View;

.field private final mImageSearchController:Lcom/amazon/mShop/control/search/image/ImageSearchController;

.field private mResizedImage:[B

.field private final mStatus:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;)V
    .locals 3
    .param p1, "activity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 58
    invoke-direct {p0, p1}, Landroid/widget/ListView;-><init>(Landroid/content/Context;)V

    .line 59
    iput-object p1, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 60
    sget v0, Lcom/amazon/mShop/android/lib/R$layout;->search_results_footer:I

    const/4 v1, 0x0

    invoke-static {p1, v0, v1}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mFooter:Landroid/view/View;

    .line 61
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mFooter:Landroid/view/View;

    sget v1, Lcom/amazon/mShop/android/lib/R$id;->search_results_status:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mStatus:Landroid/widget/TextView;

    .line 62
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mStatus:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->snapit_searching_for:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 63
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mFooter:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->addFooterView(Landroid/view/View;)V

    .line 65
    new-instance v0, Lcom/amazon/mShop/control/search/image/ImageSearchController;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/control/search/image/ImageSearchController;-><init>(Lcom/amazon/mShop/control/search/image/ImageSearchSubscriber;)V

    iput-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mImageSearchController:Lcom/amazon/mShop/control/search/image/ImageSearchController;

    .line 66
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->setItemsCanFocus(Z)V

    .line 69
    invoke-direct {p0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->compressImangeForImageSearch()[B

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mResizedImage:[B

    .line 70
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->setFooterDividersEnabled(Z)V

    .line 72
    new-instance v0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView$SnapItSearchResultAdapter;

    sget v1, Lcom/amazon/mShop/android/lib/R$layout;->item_row:I

    invoke-direct {v0, p0, p1, v1}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView$SnapItSearchResultAdapter;-><init>(Lcom/amazon/mShop/search/image/SnapItSearchResultsView;Lcom/amazon/mShop/AmazonActivity;I)V

    iput-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mAdapter:Lcom/amazon/mShop/search/image/SnapItSearchResultsView$SnapItSearchResultAdapter;

    .line 73
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mAdapter:Lcom/amazon/mShop/search/image/SnapItSearchResultsView$SnapItSearchResultAdapter;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView$SnapItSearchResultAdapter;->setListView(Landroid/widget/ListView;)V

    .line 74
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/search/image/SnapItSearchResultsView;)[B
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/image/SnapItSearchResultsView;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mResizedImage:[B

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/search/image/SnapItSearchResultsView;)Lcom/amazon/mShop/control/search/image/ImageSearchController;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/image/SnapItSearchResultsView;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mImageSearchController:Lcom/amazon/mShop/control/search/image/ImageSearchController;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/search/image/SnapItSearchResultsView;)Lcom/amazon/mShop/AmazonActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/image/SnapItSearchResultsView;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    return-object v0
.end method

.method private compressImangeForImageSearch()[B
    .locals 12

    .prologue
    const/4 v1, 0x0

    .line 210
    const/4 v11, 0x0

    .line 216
    .local v11, "result":[B
    invoke-static {}, Lcom/amazon/mShop/search/image/SnapItActivity;->getLastPhotoCapturedOriginal()[B

    move-result-object v2

    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty([B)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 217
    iget-object v1, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-static {v1}, Lcom/amazon/mShop/util/ActivityUtils;->startHomeActivity(Landroid/content/Context;)Z

    .line 218
    invoke-virtual {p0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->getContext()Landroid/content/Context;

    move-result-object v1

    check-cast v1, Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->finish()V

    .line 247
    :goto_0
    return-object v11

    .line 220
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/search/image/SnapItActivity;->getLastPhotoCapturedOriginal()[B

    move-result-object v2

    invoke-static {}, Lcom/amazon/mShop/search/image/SnapItActivity;->getLastPhotoCapturedOriginal()[B

    move-result-object v3

    array-length v3, v3

    invoke-static {v2, v1, v3}, Landroid/graphics/BitmapFactory;->decodeByteArray([BII)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 223
    .local v0, "aBitMap":Landroid/graphics/Bitmap;
    new-instance v5, Landroid/graphics/Matrix;

    invoke-direct {v5}, Landroid/graphics/Matrix;-><init>()V

    .line 230
    .local v5, "rotateMatrix":Landroid/graphics/Matrix;
    invoke-static {}, Lcom/amazon/mShop/search/image/SnapItActivity;->getLastKnownOrientation()I

    move-result v2

    add-int/lit8 v2, v2, 0x5a

    int-to-float v2, v2

    invoke-virtual {v5, v2}, Landroid/graphics/Matrix;->postRotate(F)Z

    .line 234
    const/16 v9, 0x168

    .line 235
    .local v9, "newWidth":I
    const/16 v8, 0x1e0

    .line 236
    .local v8, "newHeight":I
    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v4

    const/4 v6, 0x1

    move v2, v1

    invoke-static/range {v0 .. v6}, Landroid/graphics/Bitmap;->createBitmap(Landroid/graphics/Bitmap;IIIILandroid/graphics/Matrix;Z)Landroid/graphics/Bitmap;

    move-result-object v10

    .line 239
    .local v10, "resizedBitmap":Landroid/graphics/Bitmap;
    invoke-static {v10, v9, v8, v1}, Landroid/graphics/Bitmap;->createScaledBitmap(Landroid/graphics/Bitmap;IIZ)Landroid/graphics/Bitmap;

    move-result-object v10

    .line 241
    new-instance v7, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v7}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 242
    .local v7, "bos":Ljava/io/ByteArrayOutputStream;
    sget-object v1, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v2, 0x64

    invoke-virtual {v10, v1, v2, v7}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 244
    invoke-virtual {v7}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v11

    goto :goto_0
.end method


# virtual methods
.method protected getMismatchFooter()Landroid/view/View;
    .locals 5

    .prologue
    .line 312
    invoke-virtual {p0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->getContext()Landroid/content/Context;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$layout;->snapit_search_results_view_report_bad_match_row:I

    const/4 v4, 0x0

    invoke-static {v2, v3, v4}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 314
    .local v0, "mismatchFooter":Landroid/view/View;
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->snapit_search_results_view_not_match_hint:I

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 316
    .local v1, "mismatchHint":Landroid/widget/TextView;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->snapit_search_report_mismatch_prompt:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->snapit_search_report_mismatch_button:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 321
    new-instance v2, Lcom/amazon/mShop/search/image/SnapItSearchResultsView$2;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView$2;-><init>(Lcom/amazon/mShop/search/image/SnapItSearchResultsView;)V

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 328
    return-object v0
.end method

.method protected getNoMatchFooter()Landroid/view/View;
    .locals 3

    .prologue
    .line 332
    new-instance v1, Lcom/amazon/mShop/search/NoMatchSearchResultsView;

    invoke-virtual {p0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    const-string/jumbo v2, "snapItSearchResultsType"

    invoke-direct {v1, v0, v2}, Lcom/amazon/mShop/search/NoMatchSearchResultsView;-><init>(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;)V

    return-object v1
.end method

.method public getTitle()Ljava/lang/CharSequence;
    .locals 2

    .prologue
    .line 363
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->isErrorBoxShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 364
    invoke-virtual {p0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->search_results_title:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 376
    :goto_0
    return-object v0

    .line 367
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mImageSearchController:Lcom/amazon/mShop/control/search/image/ImageSearchController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/search/image/ImageSearchController;->isCompleted()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 368
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mImageSearchController:Lcom/amazon/mShop/control/search/image/ImageSearchController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/search/image/ImageSearchController;->count()I

    move-result v0

    if-nez v0, :cond_1

    .line 369
    invoke-virtual {p0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->snapit_search_result_title_no_result:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 370
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mImageSearchController:Lcom/amazon/mShop/control/search/image/ImageSearchController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/search/image/ImageSearchController;->count()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_2

    .line 371
    invoke-virtual {p0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->snapit_search_result_title_result:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 373
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->snapit_search_result_title_result_plural:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 376
    :cond_3
    invoke-virtual {p0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->snapit_search_result_title_searching_for:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method protected onAttachedToWindow()V
    .locals 2

    .prologue
    .line 78
    invoke-super {p0}, Landroid/widget/ListView;->onAttachedToWindow()V

    .line 79
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mImageSearchController:Lcom/amazon/mShop/control/search/image/ImageSearchController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/search/image/ImageSearchController;->hasServiceCallRunning()Z

    move-result v0

    if-nez v0, :cond_0

    .line 80
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mImageSearchController:Lcom/amazon/mShop/control/search/image/ImageSearchController;

    iget-object v1, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mResizedImage:[B

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/search/image/ImageSearchController;->doImageSearch([B)V

    .line 82
    :cond_0
    return-void
.end method

.method public onCompleted()V
    .locals 2

    .prologue
    .line 342
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mAdapter:Lcom/amazon/mShop/search/image/SnapItSearchResultsView$SnapItSearchResultAdapter;

    invoke-virtual {v0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView$SnapItSearchResultAdapter;->notifyDataSetChanged()V

    .line 344
    const/4 v0, 0x1

    iget-object v1, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mImageSearchController:Lcom/amazon/mShop/control/search/image/ImageSearchController;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/search/image/ImageSearchController;->count()I

    move-result v1

    if-gt v0, v1, :cond_0

    .line 346
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mFooter:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->removeFooterView(Landroid/view/View;)Z

    .line 347
    invoke-virtual {p0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->getMismatchFooter()Landroid/view/View;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->addFooterView(Landroid/view/View;)V

    .line 357
    :goto_0
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/AmazonActivity;->updateTitle(Landroid/view/View;)V

    .line 358
    return-void

    .line 353
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mFooter:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->removeFooterView(Landroid/view/View;)Z

    .line 354
    invoke-virtual {p0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->getNoMatchFooter()Landroid/view/View;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->addFooterView(Landroid/view/View;)V

    goto :goto_0
.end method

.method protected onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 86
    invoke-super {p0}, Landroid/widget/ListView;->onDetachedFromWindow()V

    .line 87
    invoke-static {}, Lcom/amazon/mShop/search/image/SnapItActivity;->clearLastPhotoCaptured()V

    .line 88
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mImageSearchController:Lcom/amazon/mShop/control/search/image/ImageSearchController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/search/image/ImageSearchController;->hasServiceCallRunning()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 89
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mImageSearchController:Lcom/amazon/mShop/control/search/image/ImageSearchController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/search/image/ImageSearchController;->cancel()V

    .line 90
    :cond_0
    return-void
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 103
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mImageSearchController:Lcom/amazon/mShop/control/search/image/ImageSearchController;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/search/image/ImageSearchController;->setCompleted(Z)V

    .line 104
    invoke-virtual {p0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    new-instance v1, Lcom/amazon/mShop/search/image/SnapItSearchResultsView$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView$1;-><init>(Lcom/amazon/mShop/search/image/SnapItSearchResultsView;)V

    invoke-static {v0, v1, p0, p1}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportMShopServerError(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;Ljava/lang/Exception;)V

    .line 110
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/AmazonActivity;->updateTitle(Landroid/view/View;)V

    .line 111
    return-void
.end method

.method protected reportMismatch()V
    .locals 13

    .prologue
    const/4 v12, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v11, 0x0

    .line 251
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    .line 252
    .local v7, "bodyBuilder":Ljava/lang/StringBuilder;
    invoke-virtual {p0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    .line 254
    .local v10, "res":Landroid/content/res/Resources;
    iget-object v1, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mImageSearchController:Lcom/amazon/mShop/control/search/image/ImageSearchController;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/search/image/ImageSearchController;->count()I

    move-result v1

    if-lez v1, :cond_0

    .line 255
    iget-object v1, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mImageSearchController:Lcom/amazon/mShop/control/search/image/ImageSearchController;

    invoke-virtual {v1, v11}, Lcom/amazon/mShop/control/search/image/ImageSearchController;->getSearchResult(I)Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v6

    .line 257
    .local v6, "basicProduct":Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getByLine()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getShortDescription()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 259
    sget v1, Lcom/amazon/mShop/android/lib/R$string;->snapit_search_report_mismatch_item_description_with_byline_and_shortdesc:I

    const/4 v2, 0x4

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getTitle()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v11

    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getByLine()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getShortDescription()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v12

    invoke-virtual {v10, v1, v2}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 294
    .end local v6    # "basicProduct":Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    :cond_0
    :goto_0
    const-string/jumbo v9, "snapit"

    .line 295
    .local v9, "fileName":Ljava/lang/String;
    const-string/jumbo v8, "jpg"

    .line 296
    .local v8, "fileExtension":Ljava/lang/String;
    new-instance v0, Lcom/amazon/mShop/util/EmailComposer;

    invoke-virtual {p0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->getContext()Landroid/content/Context;

    move-result-object v1

    new-array v2, v4, [Ljava/lang/String;

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->snapit_search_report_mismatch_mail_recipient:I

    invoke-virtual {v10, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v11

    invoke-static {v2}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v2

    const/4 v3, 0x0

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->snapit_search_report_mismatch_mail_subject:I

    invoke-virtual {v10, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->snapit_search_report_mismatch_mail_body:I

    invoke-virtual {v10, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v7, v11, v5}, Ljava/lang/StringBuilder;->insert(ILjava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/util/EmailComposer;-><init>(Landroid/content/Context;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V

    .line 307
    .local v0, "emailComposer":Lcom/amazon/mShop/util/EmailComposer;
    iget-object v1, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mResizedImage:[B

    invoke-virtual {v0, v1, v9, v8}, Lcom/amazon/mShop/util/EmailComposer;->attachFile([BLjava/lang/String;Ljava/lang/String;)V

    .line 308
    invoke-virtual {v0}, Lcom/amazon/mShop/util/EmailComposer;->composeEmail()V

    .line 309
    return-void

    .line 267
    .end local v0    # "emailComposer":Lcom/amazon/mShop/util/EmailComposer;
    .end local v8    # "fileExtension":Ljava/lang/String;
    .end local v9    # "fileName":Ljava/lang/String;
    .restart local v6    # "basicProduct":Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    :cond_1
    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getByLine()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 268
    sget v1, Lcom/amazon/mShop/android/lib/R$string;->snapit_search_report_mismatch_item_description_with_byline:I

    new-array v2, v12, [Ljava/lang/Object;

    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getTitle()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v11

    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getByLine()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-virtual {v10, v1, v2}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_0

    .line 275
    :cond_2
    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getShortDescription()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_3

    .line 276
    sget v1, Lcom/amazon/mShop/android/lib/R$string;->snapit_search_report_mismatch_item_description_with_shortdesc:I

    new-array v2, v12, [Ljava/lang/Object;

    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getTitle()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v11

    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getShortDescription()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-virtual {v10, v1, v2}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_0

    .line 284
    :cond_3
    sget v1, Lcom/amazon/mShop/android/lib/R$string;->snapit_search_report_mismatch_item_description:I

    new-array v2, v5, [Ljava/lang/Object;

    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getTitle()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v11

    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-virtual {v10, v1, v2}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto/16 :goto_0
.end method
