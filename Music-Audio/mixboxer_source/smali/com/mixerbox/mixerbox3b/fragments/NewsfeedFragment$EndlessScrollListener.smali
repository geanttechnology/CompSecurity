.class public Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# instance fields
.field private currentPage:I

.field private loading:Z

.field private previousTotal:I

.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

.field private visibleThreshold:I


# direct methods
.method public constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;)V
    .locals 1

    .prologue
    .line 185
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 180
    const/16 v0, 0x1f4

    iput v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->visibleThreshold:I

    .line 181
    const/4 v0, -0x1

    iput v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->currentPage:I

    .line 182
    const/4 v0, 0x0

    iput v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->previousTotal:I

    .line 183
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->loading:Z

    .line 186
    return-void
.end method

.method static synthetic access$002(Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;I)I
    .locals 0

    .prologue
    .line 178
    iput p1, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->currentPage:I

    return p1
.end method

.method static synthetic access$102(Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;I)I
    .locals 0

    .prologue
    .line 178
    iput p1, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->previousTotal:I

    return p1
.end method

.method static synthetic access$202(Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;Z)Z
    .locals 0

    .prologue
    .line 178
    iput-boolean p1, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->loading:Z

    return p1
.end method


# virtual methods
.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 190
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->canScroll:Z

    if-nez v0, :cond_1

    .line 206
    :cond_0
    :goto_0
    return-void

    .line 191
    :cond_1
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->loading:Z

    if-eqz v0, :cond_2

    .line 192
    iget v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->previousTotal:I

    if-le p4, v0, :cond_2

    .line 193
    iput-boolean v3, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->loading:Z

    .line 194
    iput p4, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->previousTotal:I

    .line 195
    iget v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->currentPage:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->currentPage:I

    .line 196
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "current page = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->currentPage:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 199
    :cond_2
    add-int v0, p2, p3

    .line 200
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    iget-boolean v1, v1, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->endList:Z

    if-nez v1, :cond_0

    iget-boolean v1, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->loading:Z

    if-nez v1, :cond_0

    if-ne v0, p4, :cond_0

    sub-int v0, p4, p3

    iget v1, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->visibleThreshold:I

    add-int/2addr v1, p2

    if-gt v0, v1, :cond_0

    .line 202
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;->llLoading:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 203
    new-instance v0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->this$0:Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;

    const/4 v2, 0x0

    invoke-direct {v0, v1, v2}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;-><init>(Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment;Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$1;)V

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/Integer;

    iget v2, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->currentPage:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v1, v3

    invoke-static {p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v1, v4

    const/4 v2, 0x2

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$LoadVectorTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 204
    iput-boolean v4, p0, Lcom/mixerbox/mixerbox3b/fragments/NewsfeedFragment$EndlessScrollListener;->loading:Z

    goto :goto_0
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 0

    .prologue
    .line 210
    return-void
.end method
