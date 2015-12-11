.class Lcom/aio/downloader/views/LTabIndicator$TabView;
.super Lcom/aio/downloader/views/LFrameLayout;
.source "LTabIndicator.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/views/LTabIndicator;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "TabView"
.end annotation


# instance fields
.field private mTabText:Landroid/widget/TextView;

.field final synthetic this$0:Lcom/aio/downloader/views/LTabIndicator;


# direct methods
.method public constructor <init>(Lcom/aio/downloader/views/LTabIndicator;Landroid/content/Context;)V
    .locals 1
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 201
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/aio/downloader/views/LTabIndicator$TabView;-><init>(Lcom/aio/downloader/views/LTabIndicator;Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 202
    return-void
.end method

.method public constructor <init>(Lcom/aio/downloader/views/LTabIndicator;Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 204
    iput-object p1, p0, Lcom/aio/downloader/views/LTabIndicator$TabView;->this$0:Lcom/aio/downloader/views/LTabIndicator;

    .line 205
    invoke-direct {p0, p2, p3}, Lcom/aio/downloader/views/LFrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 206
    invoke-direct {p0}, Lcom/aio/downloader/views/LTabIndicator$TabView;->init()V

    .line 207
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/aio/downloader/views/LTabIndicator$TabView;->setDelayClick(Z)V

    .line 208
    # getter for: Lcom/aio/downloader/views/LTabIndicator;->mAnimColor:I
    invoke-static {p1}, Lcom/aio/downloader/views/LTabIndicator;->access$0(Lcom/aio/downloader/views/LTabIndicator;)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/aio/downloader/views/LTabIndicator$TabView;->setColor(I)V

    .line 209
    return-void
.end method

.method private init()V
    .locals 5

    .prologue
    const/4 v4, -0x1

    .line 212
    new-instance v1, Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/aio/downloader/views/LTabIndicator$TabView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/aio/downloader/views/LTabIndicator$TabView;->mTabText:Landroid/widget/TextView;

    .line 213
    iget-object v1, p0, Lcom/aio/downloader/views/LTabIndicator$TabView;->mTabText:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/aio/downloader/views/LTabIndicator$TabView;->getContext()Landroid/content/Context;

    move-result-object v2

    const v3, 0x1010041

    invoke-virtual {v1, v2, v3}, Landroid/widget/TextView;->setTextAppearance(Landroid/content/Context;I)V

    .line 214
    iget-object v1, p0, Lcom/aio/downloader/views/LTabIndicator$TabView;->mTabText:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/aio/downloader/views/LTabIndicator$TabView;->this$0:Lcom/aio/downloader/views/LTabIndicator;

    # getter for: Lcom/aio/downloader/views/LTabIndicator;->tabTextSize:I
    invoke-static {v2}, Lcom/aio/downloader/views/LTabIndicator;->access$1(Lcom/aio/downloader/views/LTabIndicator;)I

    move-result v2

    int-to-float v2, v2

    .line 215
    invoke-virtual {p0}, Lcom/aio/downloader/views/LTabIndicator$TabView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/res/Resources;->getConfiguration()Landroid/content/res/Configuration;

    move-result-object v3

    iget v3, v3, Landroid/content/res/Configuration;->fontScale:F

    div-float/2addr v2, v3

    .line 214
    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setTextSize(F)V

    .line 216
    iget-object v1, p0, Lcom/aio/downloader/views/LTabIndicator$TabView;->mTabText:Landroid/widget/TextView;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setSingleLine(Z)V

    .line 217
    iget-object v1, p0, Lcom/aio/downloader/views/LTabIndicator$TabView;->mTabText:Landroid/widget/TextView;

    const/16 v2, 0x11

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setGravity(I)V

    .line 218
    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;

    invoke-direct {v0, v4, v4}, Landroid/widget/FrameLayout$LayoutParams;-><init>(II)V

    .line 220
    .local v0, "params":Landroid/widget/FrameLayout$LayoutParams;
    iget-object v1, p0, Lcom/aio/downloader/views/LTabIndicator$TabView;->mTabText:Landroid/widget/TextView;

    invoke-virtual {p0, v1, v0}, Lcom/aio/downloader/views/LTabIndicator$TabView;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 222
    return-void
.end method


# virtual methods
.method public getTextView()Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 225
    iget-object v0, p0, Lcom/aio/downloader/views/LTabIndicator$TabView;->mTabText:Landroid/widget/TextView;

    return-object v0
.end method
