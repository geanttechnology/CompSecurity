.class public Lcom/wishabi/flipp/widget/ZeroCaseView;
.super Landroid/widget/FrameLayout;
.source "SourceFile"


# static fields
.field private static final e:Ljava/lang/String;


# instance fields
.field protected final a:Landroid/widget/ImageView;

.field protected final b:Landroid/widget/TextView;

.field protected final c:Landroid/widget/TextView;

.field protected final d:Lcom/wishabi/flipp/widget/ActionButton;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    const-class v0, Lcom/wishabi/flipp/widget/ZeroCaseView;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/widget/ZeroCaseView;->e:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 26
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/wishabi/flipp/widget/ZeroCaseView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 27
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 30
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/wishabi/flipp/widget/ZeroCaseView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 31
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 3

    .prologue
    const/16 v2, 0x8

    .line 34
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 36
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ZeroCaseView;->getContext()Landroid/content/Context;

    move-result-object v0

    const v1, 0x7f030058

    invoke-static {v0, v1, p0}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 38
    const v0, 0x7f0b014d

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/ZeroCaseView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/ZeroCaseView;->a:Landroid/widget/ImageView;

    .line 39
    const v0, 0x7f0b014e

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/ZeroCaseView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/ZeroCaseView;->b:Landroid/widget/TextView;

    .line 40
    const v0, 0x7f0b014f

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/ZeroCaseView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/ZeroCaseView;->c:Landroid/widget/TextView;

    .line 41
    const v0, 0x7f0b0150

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/ZeroCaseView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/wishabi/flipp/widget/ActionButton;

    iput-object v0, p0, Lcom/wishabi/flipp/widget/ZeroCaseView;->d:Lcom/wishabi/flipp/widget/ActionButton;

    .line 42
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ZeroCaseView;->d:Lcom/wishabi/flipp/widget/ActionButton;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ActionButton;->setAllCaps(Z)V

    .line 45
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ZeroCaseView;->a:Landroid/widget/ImageView;

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 46
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ZeroCaseView;->b:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 47
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ZeroCaseView;->c:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 48
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ZeroCaseView;->d:Lcom/wishabi/flipp/widget/ActionButton;

    invoke-virtual {v0, v2}, Lcom/wishabi/flipp/widget/ActionButton;->setVisibility(I)V

    .line 49
    return-void
.end method


# virtual methods
.method public final a()V
    .locals 2

    .prologue
    .line 111
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ZeroCaseView;->d:Lcom/wishabi/flipp/widget/ActionButton;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ActionButton;->setVisibility(I)V

    .line 112
    return-void
.end method

.method public final a(Ljava/lang/String;Landroid/view/View$OnClickListener;)V
    .locals 2

    .prologue
    .line 92
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ZeroCaseView;->d:Lcom/wishabi/flipp/widget/ActionButton;

    invoke-virtual {v0, p1}, Lcom/wishabi/flipp/widget/ActionButton;->setLabel(Ljava/lang/CharSequence;)V

    .line 93
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ZeroCaseView;->d:Lcom/wishabi/flipp/widget/ActionButton;

    invoke-virtual {v0, p2}, Lcom/wishabi/flipp/widget/ActionButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 95
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 96
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ZeroCaseView;->d:Lcom/wishabi/flipp/widget/ActionButton;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ActionButton;->setVisibility(I)V

    .line 99
    :goto_0
    return-void

    .line 98
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ZeroCaseView;->d:Lcom/wishabi/flipp/widget/ActionButton;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/wishabi/flipp/widget/ActionButton;->setVisibility(I)V

    goto :goto_0
.end method

.method public final b()Z
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ZeroCaseView;->d:Lcom/wishabi/flipp/widget/ActionButton;

    invoke-virtual {v0}, Lcom/wishabi/flipp/widget/ActionButton;->isShown()Z

    move-result v0

    return v0
.end method

.method public setIcon(I)V
    .locals 2

    .prologue
    .line 52
    if-nez p1, :cond_0

    .line 53
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ZeroCaseView;->a:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 54
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ZeroCaseView;->a:Landroid/widget/ImageView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 59
    :goto_0
    return-void

    .line 56
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ZeroCaseView;->a:Landroid/widget/ImageView;

    invoke-virtual {v0, p1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 57
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ZeroCaseView;->a:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0
.end method

.method public setSubTitle(I)V
    .locals 1

    .prologue
    .line 75
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ZeroCaseView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setSubTitle(Ljava/lang/String;)V

    .line 76
    return-void
.end method

.method public setSubTitle(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 79
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ZeroCaseView;->c:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 81
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 82
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ZeroCaseView;->c:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 85
    :goto_0
    return-void

    .line 84
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ZeroCaseView;->c:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method public setTitle(I)V
    .locals 1

    .prologue
    .line 62
    invoke-virtual {p0}, Lcom/wishabi/flipp/widget/ZeroCaseView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/wishabi/flipp/widget/ZeroCaseView;->setTitle(Ljava/lang/String;)V

    .line 63
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 66
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ZeroCaseView;->b:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 68
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 69
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ZeroCaseView;->b:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 72
    :goto_0
    return-void

    .line 71
    :cond_0
    iget-object v0, p0, Lcom/wishabi/flipp/widget/ZeroCaseView;->b:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method
