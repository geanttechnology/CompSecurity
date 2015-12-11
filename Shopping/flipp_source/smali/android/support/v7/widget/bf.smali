.class public final Landroid/support/v7/widget/bf;
.super Ljava/lang/Object;
.source "SourceFile"


# instance fields
.field a:I

.field b:Landroid/support/v4/c/a;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/c/a",
            "<",
            "Landroid/support/v7/widget/bi;",
            "Landroid/support/v7/widget/at;",
            ">;"
        }
    .end annotation
.end field

.field c:Landroid/support/v4/c/a;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/c/a",
            "<",
            "Landroid/support/v7/widget/bi;",
            "Landroid/support/v7/widget/at;",
            ">;"
        }
    .end annotation
.end field

.field d:Landroid/support/v4/c/a;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/c/a",
            "<",
            "Ljava/lang/Long;",
            "Landroid/support/v7/widget/bi;",
            ">;"
        }
    .end annotation
.end field

.field e:I

.field f:I

.field g:I

.field h:Z

.field i:Z

.field j:Z

.field k:Z

.field private l:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 7586
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 7588
    const/4 v0, -0x1

    iput v0, p0, Landroid/support/v7/widget/bf;->a:I

    .line 7589
    new-instance v0, Landroid/support/v4/c/a;

    invoke-direct {v0}, Landroid/support/v4/c/a;-><init>()V

    iput-object v0, p0, Landroid/support/v7/widget/bf;->b:Landroid/support/v4/c/a;

    .line 7591
    new-instance v0, Landroid/support/v4/c/a;

    invoke-direct {v0}, Landroid/support/v4/c/a;-><init>()V

    iput-object v0, p0, Landroid/support/v7/widget/bf;->c:Landroid/support/v4/c/a;

    .line 7594
    new-instance v0, Landroid/support/v4/c/a;

    invoke-direct {v0}, Landroid/support/v4/c/a;-><init>()V

    iput-object v0, p0, Landroid/support/v7/widget/bf;->d:Landroid/support/v4/c/a;

    .line 7601
    iput v1, p0, Landroid/support/v7/widget/bf;->e:I

    .line 7606
    iput v1, p0, Landroid/support/v7/widget/bf;->f:I

    .line 7612
    iput v1, p0, Landroid/support/v7/widget/bf;->g:I

    .line 7614
    iput-boolean v1, p0, Landroid/support/v7/widget/bf;->h:Z

    .line 7616
    iput-boolean v1, p0, Landroid/support/v7/widget/bf;->i:Z

    .line 7618
    iput-boolean v1, p0, Landroid/support/v7/widget/bf;->j:Z

    .line 7620
    iput-boolean v1, p0, Landroid/support/v7/widget/bf;->k:Z

    return-void
.end method


# virtual methods
.method public final a()I
    .locals 2

    .prologue
    .line 7753
    iget-boolean v0, p0, Landroid/support/v7/widget/bf;->i:Z

    if-eqz v0, :cond_0

    iget v0, p0, Landroid/support/v7/widget/bf;->f:I

    iget v1, p0, Landroid/support/v7/widget/bf;->g:I

    sub-int/2addr v0, v1

    :goto_0
    return v0

    :cond_0
    iget v0, p0, Landroid/support/v7/widget/bf;->e:I

    goto :goto_0
.end method

.method public final a(Landroid/support/v7/widget/bi;)V
    .locals 3

    .prologue
    .line 7759
    iget-object v0, p0, Landroid/support/v7/widget/bf;->b:Landroid/support/v4/c/a;

    invoke-virtual {v0, p1}, Landroid/support/v4/c/a;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 7760
    iget-object v0, p0, Landroid/support/v7/widget/bf;->c:Landroid/support/v4/c/a;

    invoke-virtual {v0, p1}, Landroid/support/v4/c/a;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 7761
    iget-object v0, p0, Landroid/support/v7/widget/bf;->d:Landroid/support/v4/c/a;

    if-eqz v0, :cond_0

    .line 7762
    iget-object v1, p0, Landroid/support/v7/widget/bf;->d:Landroid/support/v4/c/a;

    invoke-virtual {v1}, Landroid/support/v4/c/a;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    :goto_0
    if-ltz v0, :cond_0

    invoke-virtual {v1, v0}, Landroid/support/v4/c/a;->c(I)Ljava/lang/Object;

    move-result-object v2

    if-ne p1, v2, :cond_1

    invoke-virtual {v1, v0}, Landroid/support/v4/c/a;->d(I)Ljava/lang/Object;

    .line 7765
    :cond_0
    return-void

    .line 7762
    :cond_1
    add-int/lit8 v0, v0, -0x1

    goto :goto_0
.end method

.method public final toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 7782
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "State{mTargetPosition="

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v1, p0, Landroid/support/v7/widget/bf;->a:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mPreLayoutHolderMap="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroid/support/v7/widget/bf;->b:Landroid/support/v4/c/a;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mPostLayoutHolderMap="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroid/support/v7/widget/bf;->c:Landroid/support/v4/c/a;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mData="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Landroid/support/v7/widget/bf;->l:Landroid/util/SparseArray;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mItemCount="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroid/support/v7/widget/bf;->e:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mPreviousLayoutItemCount="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroid/support/v7/widget/bf;->f:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mDeletedInvisibleItemCountSincePreviousLayout="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Landroid/support/v7/widget/bf;->g:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mStructureChanged="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Landroid/support/v7/widget/bf;->h:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mInPreLayout="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Landroid/support/v7/widget/bf;->i:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mRunSimpleAnimations="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Landroid/support/v7/widget/bf;->j:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", mRunPredictiveAnimations="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Landroid/support/v7/widget/bf;->k:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const/16 v1, 0x7d

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
