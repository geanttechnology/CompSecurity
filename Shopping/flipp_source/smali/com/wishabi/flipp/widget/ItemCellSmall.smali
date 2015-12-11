.class public Lcom/wishabi/flipp/widget/ItemCellSmall;
.super Landroid/widget/FrameLayout;
.source "SourceFile"


# instance fields
.field private final a:Lcom/wishabi/flipp/widget/WebImageView;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 19
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/ItemCellSmall;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 20
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 23
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/wishabi/flipp/widget/ItemCellSmall;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 24
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1

    .prologue
    .line 27
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 28
    const v0, 0x7f030033

    invoke-static {p1, v0, p0}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 29
    const v0, 0x7f0b00da

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/ItemCellSmall;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/WebImageView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/ItemCellSmall;->a:Lcom/wishabi/flipp/widget/WebImageView;

    .line 30
    return-void
.end method


# virtual methods
.method public setImageScaleType(Landroid/widget/ImageView$ScaleType;)V
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ItemCellSmall;->a:Lcom/wishabi/flipp/widget/WebImageView;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/WebImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 41
    return-void
.end method

.method public setImageUrl(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 33
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 34
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ItemCellSmall;->a:Lcom/wishabi/flipp/widget/WebImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/WebImageView;->setImageUrl(Ljava/lang/String;)V

    .line 37
    :goto_0
    return-void

    .line 36
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ItemCellSmall;->a:Lcom/wishabi/flipp/widget/WebImageView;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/WebImageView;->setImageUrl(Ljava/lang/String;)V

    goto :goto_0
.end method
