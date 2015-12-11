.class public Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AbsListView$OnScrollListener;


# instance fields
.field private currentPage:I

.field private loading:Z

.field private previousTotal:I

.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

.field private vectorType:I

.field private visibleThreshold:I


# direct methods
.method public constructor <init>(Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;I)V
    .locals 1

    .prologue
    .line 260
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 254
    const/16 v0, 0x1f4

    iput v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->visibleThreshold:I

    .line 255
    const/4 v0, -0x1

    iput v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->currentPage:I

    .line 256
    const/4 v0, 0x0

    iput v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->previousTotal:I

    .line 257
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->loading:Z

    .line 261
    iput p2, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->vectorType:I

    .line 262
    return-void
.end method

.method static synthetic access$002(Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;I)I
    .locals 0

    .prologue
    .line 252
    iput p1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->currentPage:I

    return p1
.end method

.method static synthetic access$102(Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;I)I
    .locals 0

    .prologue
    .line 252
    iput p1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->previousTotal:I

    return p1
.end method

.method static synthetic access$202(Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;Z)Z
    .locals 0

    .prologue
    .line 252
    iput-boolean p1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->loading:Z

    return p1
.end method


# virtual methods
.method public onScroll(Landroid/widget/AbsListView;III)V
    .locals 7

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x2

    const/4 v2, 0x3

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 266
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->canScroll:Z

    if-nez v0, :cond_1

    .line 285
    :cond_0
    :goto_0
    return-void

    .line 267
    :cond_1
    iget-boolean v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->loading:Z

    if-eqz v0, :cond_2

    .line 268
    iget v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->previousTotal:I

    if-le p4, v0, :cond_2

    .line 269
    iput-boolean v3, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->loading:Z

    .line 270
    iput p4, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->previousTotal:I

    .line 271
    iget v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->currentPage:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->currentPage:I

    .line 272
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "current page = "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->currentPage:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->logMsg(Ljava/lang/String;)V

    .line 275
    :cond_2
    add-int v0, p2, p3

    .line 276
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-boolean v1, v1, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->endList:Z

    if-nez v1, :cond_0

    iget-boolean v1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->loading:Z

    if-nez v1, :cond_0

    if-ne v0, p4, :cond_0

    if-eqz p3, :cond_0

    sub-int v0, p4, p3

    iget v1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->visibleThreshold:I

    add-int/2addr v1, p2

    if-gt v0, v1, :cond_0

    .line 278
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;->llLoading:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 279
    iget v0, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->vectorType:I

    if-ne v0, v2, :cond_3

    .line 280
    new-instance v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-direct {v0, v1, v6}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask;-><init>(Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$1;)V

    new-array v1, v2, [Ljava/lang/Integer;

    iget v2, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->currentPage:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v1, v3

    invoke-static {p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v1, v4

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v1, v5

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadSearchVectorTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 283
    :goto_1
    iput-boolean v4, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->loading:Z

    goto :goto_0

    .line 282
    :cond_3
    new-instance v0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->this$0:Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;

    invoke-direct {v0, v1, v6}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;-><init>(Lcom/mixerbox/mixerbox3b/fragments/VectorFragment;Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$1;)V

    new-array v1, v2, [Ljava/lang/Integer;

    iget v2, p0, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$EndlessScrollListener;->currentPage:I

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v1, v3

    invoke-static {p4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v1, v4

    invoke-static {p3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    aput-object v2, v1, v5

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/fragments/VectorFragment$LoadVectorTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_1
.end method

.method public onScrollStateChanged(Landroid/widget/AbsListView;I)V
    .locals 0

    .prologue
    .line 289
    return-void
.end method
