.class public Lcom/emilsjolander/components/StickyListHeaders/WrapperView;
.super Ljava/lang/Object;
.source "WrapperView.java"


# instance fields
.field private layoutId:I

.field private v:Landroid/widget/LinearLayout;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "c"    # Landroid/content/Context;

    .prologue
    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    sget v0, Lcom/emilsjolander/components/StickyListHeaders/R$layout;->wrapper:I

    iput v0, p0, Lcom/emilsjolander/components/StickyListHeaders/WrapperView;->layoutId:I

    .line 31
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iget v1, p0, Lcom/emilsjolander/components/StickyListHeaders/WrapperView;->layoutId:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/emilsjolander/components/StickyListHeaders/WrapperView;->v:Landroid/widget/LinearLayout;

    .line 32
    return-void
.end method

.method public constructor <init>(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    sget v0, Lcom/emilsjolander/components/StickyListHeaders/R$layout;->wrapper:I

    iput v0, p0, Lcom/emilsjolander/components/StickyListHeaders/WrapperView;->layoutId:I

    .line 35
    check-cast p1, Landroid/widget/LinearLayout;

    .end local p1    # "v":Landroid/view/View;
    iput-object p1, p0, Lcom/emilsjolander/components/StickyListHeaders/WrapperView;->v:Landroid/widget/LinearLayout;

    .line 36
    return-void
.end method


# virtual methods
.method public varargs wrapViews([Landroid/view/View;)Landroid/view/View;
    .locals 4
    .param p1, "views"    # [Landroid/view/View;

    .prologue
    .line 39
    iget-object v1, p0, Lcom/emilsjolander/components/StickyListHeaders/WrapperView;->v:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 40
    array-length v2, p1

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v2, :cond_0

    aget-object v0, p1, v1

    .line 41
    .local v0, "child":Landroid/view/View;
    iget-object v3, p0, Lcom/emilsjolander/components/StickyListHeaders/WrapperView;->v:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 40
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 43
    .end local v0    # "child":Landroid/view/View;
    :cond_0
    iget-object v1, p0, Lcom/emilsjolander/components/StickyListHeaders/WrapperView;->v:Landroid/widget/LinearLayout;

    return-object v1
.end method
