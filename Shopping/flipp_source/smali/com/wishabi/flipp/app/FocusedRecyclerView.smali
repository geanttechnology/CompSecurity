.class public Lcom/wishabi/flipp/app/FocusedRecyclerView;
.super Landroid/support/v7/widget/RecyclerView;
.source "SourceFile"


# instance fields
.field p:Z

.field private q:Lcom/wishabi/flipp/app/cf;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0, p1}, Landroid/support/v7/widget/RecyclerView;-><init>(Landroid/content/Context;)V

    .line 24
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Landroid/support/v7/widget/RecyclerView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 28
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0, p1, p2, p3}, Landroid/support/v7/widget/RecyclerView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 32
    return-void
.end method


# virtual methods
.method protected onLayout(ZIIII)V
    .locals 1

    .prologue
    .line 46
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/FocusedRecyclerView;->p:Z

    .line 47
    invoke-super/range {p0 .. p5}, Landroid/support/v7/widget/RecyclerView;->onLayout(ZIIII)V

    .line 48
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/wishabi/flipp/app/FocusedRecyclerView;->p:Z

    .line 49
    return-void
.end method

.method protected onSizeChanged(IIII)V
    .locals 1

    .prologue
    .line 53
    invoke-virtual {p0}, Lcom/wishabi/flipp/app/FocusedRecyclerView;->getFocusedChild()Landroid/view/View;

    move-result-object v0

    .line 55
    if-eqz v0, :cond_0

    if-eqz p3, :cond_0

    if-eqz p4, :cond_0

    .line 56
    invoke-static {v0}, Lcom/wishabi/flipp/app/FocusedRecyclerView;->c(Landroid/view/View;)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/app/FocusedRecyclerView;->a(I)V

    .line 58
    :cond_0
    return-void
.end method

.method public setResizeListener(Lcom/wishabi/flipp/app/cf;)V
    .locals 0

    .prologue
    .line 37
    iput-object p1, p0, Lcom/wishabi/flipp/app/FocusedRecyclerView;->q:Lcom/wishabi/flipp/app/cf;

    .line 38
    return-void
.end method
