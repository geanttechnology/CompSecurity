.class public final Lcom/wishabi/flipp/widget/ch;
.super Landroid/widget/FrameLayout;
.source "SourceFile"


# instance fields
.field final a:Lcom/wishabi/flipp/widget/ItemCellSmall;

.field private final b:Landroid/widget/TextView;

.field private final c:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 21
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/ch;-><init>(Landroid/content/Context;B)V

    .line 22
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;B)V
    .locals 1

    .prologue
    .line 25
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/ch;-><init>(Landroid/content/Context;C)V

    .line 26
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;C)V
    .locals 2

    .prologue
    .line 29
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p0, p1, v0, v1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 31
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ch;->getContext()Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f03003c

    invoke-static {v0, v1, p0}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 33
    const v0, 0x7f0b00f5

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/ch;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ItemCellSmall;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/ch;->a:Lcom/wishabi/flipp/widget/ItemCellSmall;

    .line 34
    const v0, 0x7f0b00f6

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/ch;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/ch;->b:Landroid/widget/TextView;

    .line 35
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ch;->b:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->setSingleLine()V

    .line 36
    const v0, 0x7f0b00f7

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/ch;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/ch;->c:Landroid/widget/TextView;

    .line 38
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ch;->c:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->setSingleLine()V

    .line 39
    return-void
.end method


# virtual methods
.method public final setItemMatchupImage(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ch;->a:Lcom/wishabi/flipp/widget/ItemCellSmall;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/ItemCellSmall;->setImageUrl(Ljava/lang/String;)V

    .line 48
    return-void
.end method

.method public final setItemMatchupLabel(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 51
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 52
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ch;->b:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 53
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ch;->b:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 58
    :goto_0
    return-void

    .line 55
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ch;->b:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 56
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ch;->b:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method public final setItemMatchupMerchant(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 61
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 62
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ch;->c:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 63
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ch;->c:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 68
    :goto_0
    return-void

    .line 65
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ch;->c:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 66
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ch;->c:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method
