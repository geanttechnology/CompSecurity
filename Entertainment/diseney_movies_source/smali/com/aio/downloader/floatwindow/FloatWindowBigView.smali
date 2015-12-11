.class public Lcom/aio/downloader/floatwindow/FloatWindowBigView;
.super Landroid/widget/LinearLayout;
.source "FloatWindowBigView.java"


# static fields
.field public static viewHeight:I

.field public static viewWidth:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 25
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 27
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v3

    const v4, 0x7f030045

    invoke-virtual {v3, v4, p0}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 28
    const v3, 0x7f0701e9

    invoke-virtual {p0, v3}, Lcom/aio/downloader/floatwindow/FloatWindowBigView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    .line 29
    .local v2, "view":Landroid/view/View;
    invoke-virtual {v2}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    iget v3, v3, Landroid/view/ViewGroup$LayoutParams;->width:I

    sput v3, Lcom/aio/downloader/floatwindow/FloatWindowBigView;->viewWidth:I

    .line 30
    invoke-virtual {v2}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    iget v3, v3, Landroid/view/ViewGroup$LayoutParams;->height:I

    sput v3, Lcom/aio/downloader/floatwindow/FloatWindowBigView;->viewHeight:I

    .line 31
    const v3, 0x7f0701ea

    invoke-virtual {p0, v3}, Lcom/aio/downloader/floatwindow/FloatWindowBigView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 32
    .local v1, "close":Landroid/widget/Button;
    const v3, 0x7f070077

    invoke-virtual {p0, v3}, Lcom/aio/downloader/floatwindow/FloatWindowBigView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    .line 33
    .local v0, "back":Landroid/widget/Button;
    new-instance v3, Lcom/aio/downloader/floatwindow/FloatWindowBigView$1;

    invoke-direct {v3, p0, p1}, Lcom/aio/downloader/floatwindow/FloatWindowBigView$1;-><init>(Lcom/aio/downloader/floatwindow/FloatWindowBigView;Landroid/content/Context;)V

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 45
    new-instance v3, Lcom/aio/downloader/floatwindow/FloatWindowBigView$2;

    invoke-direct {v3, p0, p1}, Lcom/aio/downloader/floatwindow/FloatWindowBigView$2;-><init>(Lcom/aio/downloader/floatwindow/FloatWindowBigView;Landroid/content/Context;)V

    invoke-virtual {v0, v3}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 54
    return-void
.end method
