.class public Lcom/livemixtapes/ui/widgets/DjBadgesView;
.super Landroid/widget/HorizontalScrollView;
.source "DjBadgesView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/livemixtapes/ui/widgets/DjBadgesView$DjClickListener;
    }
.end annotation


# instance fields
.field private clickDjListener:Landroid/view/View$OnClickListener;

.field private djClickListener:Lcom/livemixtapes/ui/widgets/DjBadgesView$DjClickListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 23
    invoke-direct {p0, p1}, Landroid/widget/HorizontalScrollView;-><init>(Landroid/content/Context;)V

    .line 88
    new-instance v0, Lcom/livemixtapes/ui/widgets/DjBadgesView$1;

    invoke-direct {v0, p0}, Lcom/livemixtapes/ui/widgets/DjBadgesView$1;-><init>(Lcom/livemixtapes/ui/widgets/DjBadgesView;)V

    iput-object v0, p0, Lcom/livemixtapes/ui/widgets/DjBadgesView;->clickDjListener:Landroid/view/View$OnClickListener;

    .line 25
    invoke-direct {p0, p1}, Lcom/livemixtapes/ui/widgets/DjBadgesView;->init(Landroid/content/Context;)V

    .line 26
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 29
    invoke-direct {p0, p1, p2}, Landroid/widget/HorizontalScrollView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 88
    new-instance v0, Lcom/livemixtapes/ui/widgets/DjBadgesView$1;

    invoke-direct {v0, p0}, Lcom/livemixtapes/ui/widgets/DjBadgesView$1;-><init>(Lcom/livemixtapes/ui/widgets/DjBadgesView;)V

    iput-object v0, p0, Lcom/livemixtapes/ui/widgets/DjBadgesView;->clickDjListener:Landroid/view/View$OnClickListener;

    .line 31
    invoke-direct {p0, p1}, Lcom/livemixtapes/ui/widgets/DjBadgesView;->init(Landroid/content/Context;)V

    .line 32
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyleAttr"    # I

    .prologue
    .line 35
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/HorizontalScrollView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 88
    new-instance v0, Lcom/livemixtapes/ui/widgets/DjBadgesView$1;

    invoke-direct {v0, p0}, Lcom/livemixtapes/ui/widgets/DjBadgesView$1;-><init>(Lcom/livemixtapes/ui/widgets/DjBadgesView;)V

    iput-object v0, p0, Lcom/livemixtapes/ui/widgets/DjBadgesView;->clickDjListener:Landroid/view/View$OnClickListener;

    .line 37
    invoke-direct {p0, p1}, Lcom/livemixtapes/ui/widgets/DjBadgesView;->init(Landroid/content/Context;)V

    .line 38
    return-void
.end method

.method static synthetic access$0(Lcom/livemixtapes/ui/widgets/DjBadgesView;)Lcom/livemixtapes/ui/widgets/DjBadgesView$DjClickListener;
    .locals 1

    .prologue
    .line 16
    iget-object v0, p0, Lcom/livemixtapes/ui/widgets/DjBadgesView;->djClickListener:Lcom/livemixtapes/ui/widgets/DjBadgesView$DjClickListener;

    return-object v0
.end method

.method private init(Landroid/content/Context;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v3, -0x2

    const/4 v2, 0x0

    .line 45
    new-instance v1, Landroid/view/ViewGroup$MarginLayoutParams;

    invoke-direct {v1, v3, v3}, Landroid/view/ViewGroup$MarginLayoutParams;-><init>(II)V

    .line 46
    .local v1, "lp":Landroid/view/ViewGroup$MarginLayoutParams;
    new-instance v0, Landroid/widget/LinearLayout;

    invoke-direct {v0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 47
    .local v0, "ll":Landroid/widget/LinearLayout;
    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 48
    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 49
    invoke-virtual {p0, v0}, Lcom/livemixtapes/ui/widgets/DjBadgesView;->addView(Landroid/view/View;)V

    .line 51
    invoke-virtual {p0, v2}, Lcom/livemixtapes/ui/widgets/DjBadgesView;->setVerticalScrollBarEnabled(Z)V

    .line 52
    invoke-virtual {p0, v2}, Lcom/livemixtapes/ui/widgets/DjBadgesView;->setHorizontalScrollBarEnabled(Z)V

    .line 53
    return-void
.end method


# virtual methods
.method public loadDjs([Ljava/lang/String;Z)V
    .locals 11
    .param p1, "djs"    # [Ljava/lang/String;
    .param p2, "onlyFirst"    # Z

    .prologue
    const/4 v10, -0x2

    const/high16 v8, 0x40800000    # 4.0f

    const/4 v9, 0x0

    .line 56
    invoke-virtual {p0}, Lcom/livemixtapes/ui/widgets/DjBadgesView;->getContext()Landroid/content/Context;

    move-result-object v7

    invoke-static {v7, v8}, Lcom/livemixtapes/utils/Utility;->dpToPixel(Landroid/content/Context;F)F

    move-result v7

    float-to-int v3, v7

    .line 57
    .local v3, "padding":I
    invoke-virtual {p0}, Lcom/livemixtapes/ui/widgets/DjBadgesView;->getContext()Landroid/content/Context;

    move-result-object v7

    invoke-static {v7, v8}, Lcom/livemixtapes/utils/Utility;->dpToPixel(Landroid/content/Context;F)F

    move-result v7

    float-to-int v2, v7

    .line 58
    .local v2, "margin":I
    invoke-virtual {p0}, Lcom/livemixtapes/ui/widgets/DjBadgesView;->getContext()Landroid/content/Context;

    move-result-object v7

    invoke-virtual {v7}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    const v8, 0x7f0b001b

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    .line 59
    .local v5, "textColor":I
    invoke-virtual {p0, v9}, Lcom/livemixtapes/ui/widgets/DjBadgesView;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    .line 61
    .local v1, "ll":Landroid/widget/LinearLayout;
    invoke-virtual {v1}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 63
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v7, p1

    if-lt v0, v7, :cond_1

    .line 86
    :cond_0
    return-void

    .line 65
    :cond_1
    new-instance v4, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v4, v10, v10}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 66
    .local v4, "params":Landroid/widget/LinearLayout$LayoutParams;
    invoke-virtual {v4, v9, v9, v2, v9}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 68
    new-instance v6, Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/livemixtapes/ui/widgets/DjBadgesView;->getContext()Landroid/content/Context;

    move-result-object v7

    invoke-direct {v6, v7}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 69
    .local v6, "tv":Landroid/widget/TextView;
    aget-object v7, p1, v0

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 70
    const v7, 0x7f020094

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setBackgroundResource(I)V

    .line 71
    invoke-virtual {v6, v5}, Landroid/widget/TextView;->setTextColor(I)V

    .line 72
    const/high16 v7, 0x41400000    # 12.0f

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setTextSize(F)V

    .line 73
    invoke-virtual {v6, v4}, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 74
    invoke-virtual {v6, v3, v9, v3, v9}, Landroid/widget/TextView;->setPadding(IIII)V

    .line 76
    iget-object v7, p0, Lcom/livemixtapes/ui/widgets/DjBadgesView;->djClickListener:Lcom/livemixtapes/ui/widgets/DjBadgesView$DjClickListener;

    if-eqz v7, :cond_2

    .line 77
    iget-object v7, p0, Lcom/livemixtapes/ui/widgets/DjBadgesView;->clickDjListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 80
    :cond_2
    invoke-virtual {v1, v6}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 82
    if-nez p2, :cond_0

    .line 63
    add-int/lit8 v0, v0, 0x1

    goto :goto_0
.end method

.method public setOnDjClickListener(Lcom/livemixtapes/ui/widgets/DjBadgesView$DjClickListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/livemixtapes/ui/widgets/DjBadgesView$DjClickListener;

    .prologue
    .line 41
    iput-object p1, p0, Lcom/livemixtapes/ui/widgets/DjBadgesView;->djClickListener:Lcom/livemixtapes/ui/widgets/DjBadgesView$DjClickListener;

    .line 42
    return-void
.end method
