.class public Lcom/aio/downloader/refresh/PullableListView_load;
.super Landroid/widget/ListView;
.source "PullableListView_load.java"

# interfaces
.implements Lcom/aio/downloader/refresh/Pullable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/refresh/PullableListView_load$OnLoadListener;
    }
.end annotation


# static fields
.field public static final INIT:I = 0x0

.field public static final LOADING:I = 0x1

.field public static final NO_MORE_DATA:I = 0x2


# instance fields
.field private autoLoad:Z

.field private canLoad:Z

.field private hasMoreData:Z

.field private mLoadAnim:Landroid/graphics/drawable/AnimationDrawable;

.field private mLoadingView:Landroid/widget/ImageView;

.field private mLoadmoreView:Landroid/view/View;

.field private mOnLoadListener:Lcom/aio/downloader/refresh/PullableListView_load$OnLoadListener;

.field private mStateTextView:Landroid/widget/TextView;

.field private mcContext:Landroid/content/Context;

.field private state:I

.field private tv_load_more:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x1

    .line 41
    invoke-direct {p0, p1}, Landroid/widget/ListView;-><init>(Landroid/content/Context;)V

    .line 32
    const/4 v0, 0x0

    iput v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->state:I

    .line 33
    iput-boolean v1, p0, Lcom/aio/downloader/refresh/PullableListView_load;->canLoad:Z

    .line 34
    iput-boolean v1, p0, Lcom/aio/downloader/refresh/PullableListView_load;->autoLoad:Z

    .line 35
    iput-boolean v1, p0, Lcom/aio/downloader/refresh/PullableListView_load;->hasMoreData:Z

    .line 42
    invoke-direct {p0, p1}, Lcom/aio/downloader/refresh/PullableListView_load;->init(Landroid/content/Context;)V

    .line 43
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v1, 0x1

    .line 46
    invoke-direct {p0, p1, p2}, Landroid/widget/ListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 32
    const/4 v0, 0x0

    iput v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->state:I

    .line 33
    iput-boolean v1, p0, Lcom/aio/downloader/refresh/PullableListView_load;->canLoad:Z

    .line 34
    iput-boolean v1, p0, Lcom/aio/downloader/refresh/PullableListView_load;->autoLoad:Z

    .line 35
    iput-boolean v1, p0, Lcom/aio/downloader/refresh/PullableListView_load;->hasMoreData:Z

    .line 47
    invoke-direct {p0, p1}, Lcom/aio/downloader/refresh/PullableListView_load;->init(Landroid/content/Context;)V

    .line 48
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    const/4 v1, 0x1

    .line 51
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ListView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 32
    const/4 v0, 0x0

    iput v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->state:I

    .line 33
    iput-boolean v1, p0, Lcom/aio/downloader/refresh/PullableListView_load;->canLoad:Z

    .line 34
    iput-boolean v1, p0, Lcom/aio/downloader/refresh/PullableListView_load;->autoLoad:Z

    .line 35
    iput-boolean v1, p0, Lcom/aio/downloader/refresh/PullableListView_load;->hasMoreData:Z

    .line 52
    invoke-direct {p0, p1}, Lcom/aio/downloader/refresh/PullableListView_load;->init(Landroid/content/Context;)V

    .line 53
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/refresh/PullableListView_load;)I
    .locals 1

    .prologue
    .line 32
    iget v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->state:I

    return v0
.end method

.method static synthetic access$1(Lcom/aio/downloader/refresh/PullableListView_load;)Z
    .locals 1

    .prologue
    .line 35
    iget-boolean v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->hasMoreData:Z

    return v0
.end method

.method static synthetic access$2(Lcom/aio/downloader/refresh/PullableListView_load;)V
    .locals 0

    .prologue
    .line 138
    invoke-direct {p0}, Lcom/aio/downloader/refresh/PullableListView_load;->load()V

    return-void
.end method

.method private changeState(I)V
    .locals 4
    .param p1, "state"    # I

    .prologue
    const/16 v3, 0x8

    const/4 v1, 0x4

    const/4 v2, 0x0

    .line 144
    iput p1, p0, Lcom/aio/downloader/refresh/PullableListView_load;->state:I

    .line 145
    packed-switch p1, :pswitch_data_0

    .line 168
    :goto_0
    return-void

    .line 147
    :pswitch_0
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->mLoadAnim:Landroid/graphics/drawable/AnimationDrawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/AnimationDrawable;->stop()V

    .line 148
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->mLoadingView:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 149
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->tv_load_more:Landroid/widget/TextView;

    const v1, 0x7f0b0060

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 150
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->tv_load_more:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 151
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->mStateTextView:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 155
    :pswitch_1
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->mLoadingView:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 156
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->mLoadAnim:Landroid/graphics/drawable/AnimationDrawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/AnimationDrawable;->start()V

    .line 157
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->tv_load_more:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 158
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->mStateTextView:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 159
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->mStateTextView:Landroid/widget/TextView;

    const v1, 0x7f0b0061

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    goto :goto_0

    .line 163
    :pswitch_2
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->mLoadAnim:Landroid/graphics/drawable/AnimationDrawable;

    invoke-virtual {v0}, Landroid/graphics/drawable/AnimationDrawable;->stop()V

    .line 164
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->mLoadingView:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 165
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->mStateTextView:Landroid/widget/TextView;

    const-string v1, "No More Data"

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 145
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method

.method private checkLoad()V
    .locals 2

    .prologue
    .line 133
    invoke-direct {p0}, Lcom/aio/downloader/refresh/PullableListView_load;->reachBottom()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->mOnLoadListener:Lcom/aio/downloader/refresh/PullableListView_load$OnLoadListener;

    if-eqz v0, :cond_0

    iget v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->state:I

    const/4 v1, 0x1

    if-eq v0, v1, :cond_0

    .line 134
    iget-boolean v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->canLoad:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->autoLoad:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->hasMoreData:Z

    if-eqz v0, :cond_0

    .line 135
    invoke-direct {p0}, Lcom/aio/downloader/refresh/PullableListView_load;->load()V

    .line 136
    :cond_0
    return-void
.end method

.method private init(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v2, 0x0

    .line 56
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 57
    const v1, 0x7f03006c

    .line 56
    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->mLoadmoreView:Landroid/view/View;

    .line 58
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->mLoadmoreView:Landroid/view/View;

    .line 59
    const v1, 0x7f07028e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 58
    iput-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->mLoadingView:Landroid/widget/ImageView;

    .line 60
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->mLoadingView:Landroid/widget/ImageView;

    const v1, 0x7f040015

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 61
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->mLoadingView:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getBackground()Landroid/graphics/drawable/Drawable;

    move-result-object v0

    check-cast v0, Landroid/graphics/drawable/AnimationDrawable;

    iput-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->mLoadAnim:Landroid/graphics/drawable/AnimationDrawable;

    .line 62
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->mLoadmoreView:Landroid/view/View;

    .line 63
    const v1, 0x7f070290

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 62
    iput-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->mStateTextView:Landroid/widget/TextView;

    .line 64
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->mLoadmoreView:Landroid/view/View;

    const v1, 0x7f070291

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->tv_load_more:Landroid/widget/TextView;

    .line 65
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->tv_load_more:Landroid/widget/TextView;

    new-instance v1, Lcom/aio/downloader/refresh/PullableListView_load$1;

    invoke-direct {v1, p0}, Lcom/aio/downloader/refresh/PullableListView_load$1;-><init>(Lcom/aio/downloader/refresh/PullableListView_load;)V

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 77
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->mLoadmoreView:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v2, v1}, Lcom/aio/downloader/refresh/PullableListView_load;->addFooterView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 78
    return-void
.end method

.method private load()V
    .locals 1

    .prologue
    .line 139
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/aio/downloader/refresh/PullableListView_load;->changeState(I)V

    .line 140
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->mOnLoadListener:Lcom/aio/downloader/refresh/PullableListView_load$OnLoadListener;

    invoke-interface {v0, p0}, Lcom/aio/downloader/refresh/PullableListView_load$OnLoadListener;->onLoad(Lcom/aio/downloader/refresh/PullableListView_load;)V

    .line 141
    return-void
.end method

.method private reachBottom()Z
    .locals 3

    .prologue
    const/4 v0, 0x1

    .line 206
    invoke-virtual {p0}, Lcom/aio/downloader/refresh/PullableListView_load;->getCount()I

    move-result v1

    if-nez v1, :cond_1

    .line 217
    :cond_0
    :goto_0
    return v0

    .line 208
    :cond_1
    invoke-virtual {p0}, Lcom/aio/downloader/refresh/PullableListView_load;->getLastVisiblePosition()I

    move-result v1

    invoke-virtual {p0}, Lcom/aio/downloader/refresh/PullableListView_load;->getCount()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    if-ne v1, v2, :cond_2

    .line 210
    invoke-virtual {p0}, Lcom/aio/downloader/refresh/PullableListView_load;->getLastVisiblePosition()I

    move-result v1

    invoke-virtual {p0}, Lcom/aio/downloader/refresh/PullableListView_load;->getFirstVisiblePosition()I

    move-result v2

    sub-int/2addr v1, v2

    invoke-virtual {p0, v1}, Lcom/aio/downloader/refresh/PullableListView_load;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 212
    invoke-virtual {p0}, Lcom/aio/downloader/refresh/PullableListView_load;->getLastVisiblePosition()I

    move-result v1

    .line 213
    invoke-virtual {p0}, Lcom/aio/downloader/refresh/PullableListView_load;->getFirstVisiblePosition()I

    move-result v2

    .line 212
    sub-int/2addr v1, v2

    .line 211
    invoke-virtual {p0, v1}, Lcom/aio/downloader/refresh/PullableListView_load;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 213
    invoke-virtual {v1}, Landroid/view/View;->getTop()I

    move-result v1

    invoke-virtual {p0}, Lcom/aio/downloader/refresh/PullableListView_load;->getMeasuredHeight()I

    move-result v2

    if-ge v1, v2, :cond_2

    .line 214
    invoke-virtual {p0}, Lcom/aio/downloader/refresh/PullableListView_load;->canPullDown()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 217
    :cond_2
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public canPullDown()Z
    .locals 4

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 179
    invoke-virtual {p0}, Lcom/aio/downloader/refresh/PullableListView_load;->getCount()I

    move-result v3

    if-nez v3, :cond_1

    .line 195
    :cond_0
    :goto_0
    return v1

    .line 182
    :cond_1
    invoke-virtual {p0}, Lcom/aio/downloader/refresh/PullableListView_load;->getFirstVisiblePosition()I

    move-result v3

    if-nez v3, :cond_2

    .line 185
    const/4 v3, 0x0

    :try_start_0
    invoke-virtual {p0, v3}, Lcom/aio/downloader/refresh/PullableListView_load;->getChildAt(I)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/View;->getTop()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    if-gez v3, :cond_0

    move v1, v2

    .line 193
    goto :goto_0

    .line 188
    :catch_0
    move-exception v0

    .local v0, "e":Ljava/lang/Exception;
    move v1, v2

    .line 190
    goto :goto_0

    .end local v0    # "e":Ljava/lang/Exception;
    :cond_2
    move v1, v2

    .line 195
    goto :goto_0
.end method

.method public canPullUp()Z
    .locals 1

    .prologue
    .line 240
    const/4 v0, 0x0

    return v0
.end method

.method public enableAutoLoad(Z)V
    .locals 0
    .param p1, "enable"    # Z

    .prologue
    .line 87
    iput-boolean p1, p0, Lcom/aio/downloader/refresh/PullableListView_load;->autoLoad:Z

    .line 88
    return-void
.end method

.method public finishLoading()V
    .locals 1

    .prologue
    .line 174
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/aio/downloader/refresh/PullableListView_load;->changeState(I)V

    .line 175
    return-void
.end method

.method public isHasMoreData()Z
    .locals 1

    .prologue
    .line 221
    iget-boolean v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->hasMoreData:Z

    return v0
.end method

.method protected onScrollChanged(IIII)V
    .locals 0
    .param p1, "l"    # I
    .param p2, "t"    # I
    .param p3, "oldl"    # I
    .param p4, "oldt"    # I

    .prologue
    .line 124
    invoke-super {p0, p1, p2, p3, p4}, Landroid/widget/ListView;->onScrollChanged(IIII)V

    .line 126
    invoke-direct {p0}, Lcom/aio/downloader/refresh/PullableListView_load;->checkLoad()V

    .line 127
    return-void
.end method

.method public setHasMoreData(Z)V
    .locals 1
    .param p1, "hasMoreData"    # Z

    .prologue
    .line 225
    iput-boolean p1, p0, Lcom/aio/downloader/refresh/PullableListView_load;->hasMoreData:Z

    .line 226
    if-nez p1, :cond_0

    .line 227
    const/4 v0, 0x2

    invoke-direct {p0, v0}, Lcom/aio/downloader/refresh/PullableListView_load;->changeState(I)V

    .line 231
    :goto_0
    return-void

    .line 229
    :cond_0
    const/4 v0, 0x0

    invoke-direct {p0, v0}, Lcom/aio/downloader/refresh/PullableListView_load;->changeState(I)V

    goto :goto_0
.end method

.method public setLoadmoreVisible(Z)V
    .locals 3
    .param p1, "v"    # Z

    .prologue
    .line 97
    if-eqz p1, :cond_1

    .line 98
    invoke-virtual {p0}, Lcom/aio/downloader/refresh/PullableListView_load;->getFooterViewsCount()I

    move-result v0

    if-nez v0, :cond_0

    .line 99
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->mLoadmoreView:Landroid/view/View;

    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-virtual {p0, v0, v1, v2}, Lcom/aio/downloader/refresh/PullableListView_load;->addFooterView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 104
    :cond_0
    :goto_0
    return-void

    .line 102
    :cond_1
    iget-object v0, p0, Lcom/aio/downloader/refresh/PullableListView_load;->mLoadmoreView:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/aio/downloader/refresh/PullableListView_load;->removeFooterView(Landroid/view/View;)Z

    goto :goto_0
.end method

.method public setOnLoadListener(Lcom/aio/downloader/refresh/PullableListView_load$OnLoadListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/aio/downloader/refresh/PullableListView_load$OnLoadListener;

    .prologue
    .line 199
    iput-object p1, p0, Lcom/aio/downloader/refresh/PullableListView_load;->mOnLoadListener:Lcom/aio/downloader/refresh/PullableListView_load$OnLoadListener;

    .line 200
    return-void
.end method
