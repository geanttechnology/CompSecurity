.class public final Lcom/wishabi/flipp/widget/u;
.super Landroid/widget/FrameLayout;
.source "SourceFile"


# instance fields
.field private final a:Landroid/widget/TextView;

.field private final b:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 19
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/u;-><init>(Landroid/content/Context;B)V

    .line 20
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;B)V
    .locals 1

    .prologue
    .line 23
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/u;-><init>(Landroid/content/Context;C)V

    .line 24
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;C)V
    .locals 2

    .prologue
    .line 27
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p0, p1, v0, v1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 29
    const v0, 0x7f030019

    invoke-static {p1, v0, p0}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 31
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f090066

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/u;->setBackgroundColor(I)V

    .line 33
    const v0, 0x7f0b005c

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/u;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/u;->a:Landroid/widget/TextView;

    .line 34
    const v0, 0x7f0b005d

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/u;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/u;->b:Landroid/widget/TextView;

    .line 35
    iget-object v0, p0, Lcom/wishabi/flipp/widget/u;->b:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->setSingleLine()V

    .line 36
    return-void
.end method


# virtual methods
.method public final setCount(I)V
    .locals 2

    .prologue
    .line 39
    iget-object v0, p0, Lcom/wishabi/flipp/widget/u;->a:Landroid/widget/TextView;

    invoke-static {p1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 40
    iget-object v1, p0, Lcom/wishabi/flipp/widget/u;->b:Landroid/widget/TextView;

    const/4 v0, 0x1

    if-le p1, v0, :cond_0

    const v0, 0x7f0e006a

    :goto_0
    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(I)V

    .line 42
    return-void

    .line 40
    :cond_0
    const v0, 0x7f0e0069

    goto :goto_0
.end method
