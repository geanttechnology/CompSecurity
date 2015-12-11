.class public Lcom/poshmark/ui/customviews/PMButton;
.super Landroid/widget/Button;
.source "PMButton.java"


# instance fields
.field private fontName:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 17
    invoke-direct {p0, p1, p2}, Landroid/widget/Button;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 18
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMButton;->getContext()Landroid/content/Context;

    move-result-object v1

    sget-object v2, Lcom/poshmark/app/R$styleable;->PMCommon:[I

    invoke-virtual {v1, p2, v2}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 20
    .local v0, "array":Landroid/content/res/TypedArray;
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/ui/customviews/PMButton;->fontName:Ljava/lang/String;

    .line 21
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMButton;->fontName:Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 22
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMButton;->fontName:Ljava/lang/String;

    invoke-static {p1, v1, p0}, Lcom/poshmark/utils/ViewUtils;->setTypefaceForView(Landroid/content/Context;Ljava/lang/String;Landroid/widget/TextView;)V

    .line 24
    :cond_0
    return-void
.end method
