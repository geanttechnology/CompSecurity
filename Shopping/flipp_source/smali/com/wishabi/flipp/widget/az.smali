.class public final Lcom/wishabi/flipp/widget/az;
.super Landroid/widget/FrameLayout;
.source "SourceFile"


# instance fields
.field private final a:Landroid/widget/TextView;

.field private final b:Landroid/widget/TextView;

.field private final c:Lcom/wishabi/flipp/widget/WebImageView;

.field private final d:Landroid/widget/TextView;

.field private e:Z

.field private f:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 22
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/az;-><init>(Landroid/content/Context;B)V

    .line 23
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;B)V
    .locals 1

    .prologue
    .line 26
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/az;-><init>(Landroid/content/Context;C)V

    .line 27
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;C)V
    .locals 2

    .prologue
    .line 30
    const/4 v0, 0x0

    const/4 v1, 0x0

    invoke-direct {p0, p1, v0, v1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 33
    const v0, 0x7f030028

    invoke-static {p1, v0, p0}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 35
    const v0, 0x7f0b0040

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/az;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/az;->a:Landroid/widget/TextView;

    .line 36
    const v0, 0x7f0b00af

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/az;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/az;->b:Landroid/widget/TextView;

    .line 37
    const v0, 0x7f0b0094

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/az;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/az;->d:Landroid/widget/TextView;

    .line 38
    const v0, 0x7f0b00ae

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/az;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/WebImageView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/az;->c:Lcom/wishabi/flipp/widget/WebImageView;

    .line 40
    iget-object v0, p0, Lcom/wishabi/flipp/widget/az;->b:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->setSingleLine()V

    .line 41
    iget-object v0, p0, Lcom/wishabi/flipp/widget/az;->c:Lcom/wishabi/flipp/widget/WebImageView;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/WebImageView;->setTopLeftCrop(Z)V

    .line 42
    iget-object v0, p0, Lcom/wishabi/flipp/widget/az;->d:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 43
    return-void
.end method

.method private a()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 56
    iget-boolean v0, p0, Lcom/wishabi/flipp/widget/az;->f:Z

    if-eqz v0, :cond_0

    .line 57
    iget-object v0, p0, Lcom/wishabi/flipp/widget/az;->d:Landroid/widget/TextView;

    const v1, 0x7f0e0016

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 58
    iget-object v0, p0, Lcom/wishabi/flipp/widget/az;->d:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/az;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f090006

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 60
    iget-object v0, p0, Lcom/wishabi/flipp/widget/az;->d:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 69
    :goto_0
    return-void

    .line 61
    :cond_0
    iget-boolean v0, p0, Lcom/wishabi/flipp/widget/az;->e:Z

    if-eqz v0, :cond_1

    .line 62
    iget-object v0, p0, Lcom/wishabi/flipp/widget/az;->d:Landroid/widget/TextView;

    const v1, 0x7f0e0015

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 63
    iget-object v0, p0, Lcom/wishabi/flipp/widget/az;->d:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/az;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f090005

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setBackgroundColor(I)V

    .line 65
    iget-object v0, p0, Lcom/wishabi/flipp/widget/az;->d:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 67
    :cond_1
    iget-object v0, p0, Lcom/wishabi/flipp/widget/az;->d:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method


# virtual methods
.method public final setFlyerDate(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 81
    iget-object v0, p0, Lcom/wishabi/flipp/widget/az;->b:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 82
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/wishabi/flipp/widget/az;->a:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ". "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/az;->b:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/az;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 83
    return-void
.end method

.method public final setFlyerName(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 76
    iget-object v0, p0, Lcom/wishabi/flipp/widget/az;->a:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 77
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/wishabi/flipp/widget/az;->a:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ". "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/wishabi/flipp/widget/az;->b:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/az;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 78
    return-void
.end method

.method public final setThumbnailUrl(Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/wishabi/flipp/widget/az;->c:Lcom/wishabi/flipp/widget/WebImageView;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/WebImageView;->setImageUrl(Ljava/lang/String;)V

    .line 73
    return-void
.end method

.method public final setUnread(Z)V
    .locals 0

    .prologue
    .line 51
    iput-boolean p1, p0, Lcom/wishabi/flipp/widget/az;->e:Z

    .line 52
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/az;->a()V

    .line 53
    return-void
.end method

.method public final setUpcoming(Z)V
    .locals 0

    .prologue
    .line 46
    iput-boolean p1, p0, Lcom/wishabi/flipp/widget/az;->f:Z

    .line 47
    invoke-direct {p0}, Lcom/wishabi/flipp/widget/az;->a()V

    .line 48
    return-void
.end method
