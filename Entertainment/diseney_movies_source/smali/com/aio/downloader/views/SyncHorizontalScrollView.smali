.class public Lcom/aio/downloader/views/SyncHorizontalScrollView;
.super Landroid/widget/HorizontalScrollView;
.source "SyncHorizontalScrollView.java"


# instance fields
.field private leftImage:Landroid/widget/ImageView;

.field private mContext:Landroid/app/Activity;

.field private rightImage:Landroid/widget/ImageView;

.field private view:Landroid/view/View;

.field private windowWitdh:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 30
    invoke-direct {p0, p1}, Landroid/widget/HorizontalScrollView;-><init>(Landroid/content/Context;)V

    .line 16
    const/4 v0, 0x0

    iput v0, p0, Lcom/aio/downloader/views/SyncHorizontalScrollView;->windowWitdh:I

    .line 31
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 34
    invoke-direct {p0, p1, p2}, Landroid/widget/HorizontalScrollView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 16
    const/4 v0, 0x0

    iput v0, p0, Lcom/aio/downloader/views/SyncHorizontalScrollView;->windowWitdh:I

    .line 35
    return-void
.end method


# virtual methods
.method public setSomeParam(Landroid/view/View;Landroid/widget/ImageView;Landroid/widget/ImageView;Landroid/app/Activity;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;
    .param p2, "leftImage"    # Landroid/widget/ImageView;
    .param p3, "rightImage"    # Landroid/widget/ImageView;
    .param p4, "context"    # Landroid/app/Activity;

    .prologue
    .line 20
    iput-object p4, p0, Lcom/aio/downloader/views/SyncHorizontalScrollView;->mContext:Landroid/app/Activity;

    .line 21
    iput-object p1, p0, Lcom/aio/downloader/views/SyncHorizontalScrollView;->view:Landroid/view/View;

    .line 22
    iput-object p2, p0, Lcom/aio/downloader/views/SyncHorizontalScrollView;->leftImage:Landroid/widget/ImageView;

    .line 23
    iput-object p3, p0, Lcom/aio/downloader/views/SyncHorizontalScrollView;->rightImage:Landroid/widget/ImageView;

    .line 24
    new-instance v0, Landroid/util/DisplayMetrics;

    invoke-direct {v0}, Landroid/util/DisplayMetrics;-><init>()V

    .line 25
    .local v0, "dm":Landroid/util/DisplayMetrics;
    iget-object v1, p0, Lcom/aio/downloader/views/SyncHorizontalScrollView;->mContext:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v1

    invoke-interface {v1}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 26
    iget v1, v0, Landroid/util/DisplayMetrics;->widthPixels:I

    iput v1, p0, Lcom/aio/downloader/views/SyncHorizontalScrollView;->windowWitdh:I

    .line 27
    return-void
.end method

.method public showAndHideArrow()V
    .locals 5

    .prologue
    const/16 v4, 0x8

    const/4 v3, 0x0

    .line 39
    iget-object v0, p0, Lcom/aio/downloader/views/SyncHorizontalScrollView;->mContext:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->isFinishing()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/views/SyncHorizontalScrollView;->view:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 40
    invoke-virtual {p0, v3, v3}, Lcom/aio/downloader/views/SyncHorizontalScrollView;->measure(II)V

    .line 41
    iget v0, p0, Lcom/aio/downloader/views/SyncHorizontalScrollView;->windowWitdh:I

    invoke-virtual {p0}, Lcom/aio/downloader/views/SyncHorizontalScrollView;->getMeasuredWidth()I

    move-result v1

    if-lt v0, v1, :cond_1

    .line 42
    iget-object v0, p0, Lcom/aio/downloader/views/SyncHorizontalScrollView;->leftImage:Landroid/widget/ImageView;

    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 43
    iget-object v0, p0, Lcom/aio/downloader/views/SyncHorizontalScrollView;->rightImage:Landroid/widget/ImageView;

    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 57
    :cond_0
    :goto_0
    return-void

    .line 45
    :cond_1
    invoke-virtual {p0}, Lcom/aio/downloader/views/SyncHorizontalScrollView;->getLeft()I

    move-result v0

    if-nez v0, :cond_2

    .line 46
    iget-object v0, p0, Lcom/aio/downloader/views/SyncHorizontalScrollView;->leftImage:Landroid/widget/ImageView;

    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 47
    iget-object v0, p0, Lcom/aio/downloader/views/SyncHorizontalScrollView;->rightImage:Landroid/widget/ImageView;

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0

    .line 48
    :cond_2
    invoke-virtual {p0}, Lcom/aio/downloader/views/SyncHorizontalScrollView;->getRight()I

    move-result v0

    invoke-virtual {p0}, Lcom/aio/downloader/views/SyncHorizontalScrollView;->getMeasuredWidth()I

    move-result v1

    iget v2, p0, Lcom/aio/downloader/views/SyncHorizontalScrollView;->windowWitdh:I

    sub-int/2addr v1, v2

    if-ne v0, v1, :cond_3

    .line 49
    iget-object v0, p0, Lcom/aio/downloader/views/SyncHorizontalScrollView;->leftImage:Landroid/widget/ImageView;

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 50
    iget-object v0, p0, Lcom/aio/downloader/views/SyncHorizontalScrollView;->rightImage:Landroid/widget/ImageView;

    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0

    .line 52
    :cond_3
    iget-object v0, p0, Lcom/aio/downloader/views/SyncHorizontalScrollView;->leftImage:Landroid/widget/ImageView;

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 53
    iget-object v0, p0, Lcom/aio/downloader/views/SyncHorizontalScrollView;->rightImage:Landroid/widget/ImageView;

    invoke-virtual {v0, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0
.end method
