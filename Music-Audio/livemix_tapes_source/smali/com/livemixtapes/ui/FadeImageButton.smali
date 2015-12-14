.class public Lcom/livemixtapes/ui/FadeImageButton;
.super Landroid/widget/ImageButton;
.source "FadeImageButton.java"


# static fields
.field public static buttonClick:Landroid/view/animation/AlphaAnimation;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 16
    new-instance v0, Landroid/view/animation/AlphaAnimation;

    const/high16 v1, 0x3f800000    # 1.0f

    const v2, 0x3f4ccccd    # 0.8f

    invoke-direct {v0, v1, v2}, Landroid/view/animation/AlphaAnimation;-><init>(FF)V

    sput-object v0, Lcom/livemixtapes/ui/FadeImageButton;->buttonClick:Landroid/view/animation/AlphaAnimation;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 18
    invoke-direct {p0, p1}, Landroid/widget/ImageButton;-><init>(Landroid/content/Context;)V

    .line 20
    invoke-direct {p0}, Lcom/livemixtapes/ui/FadeImageButton;->addEffect()V

    .line 21
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 23
    invoke-direct {p0, p1, p2}, Landroid/widget/ImageButton;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 25
    invoke-direct {p0}, Lcom/livemixtapes/ui/FadeImageButton;->addEffect()V

    .line 26
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyleAttr"    # I

    .prologue
    .line 28
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ImageButton;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 30
    invoke-direct {p0}, Lcom/livemixtapes/ui/FadeImageButton;->addEffect()V

    .line 31
    return-void
.end method

.method private addEffect()V
    .locals 1

    .prologue
    .line 33
    new-instance v0, Lcom/livemixtapes/ui/FadeImageButton$1;

    invoke-direct {v0, p0}, Lcom/livemixtapes/ui/FadeImageButton$1;-><init>(Lcom/livemixtapes/ui/FadeImageButton;)V

    invoke-virtual {p0, v0}, Lcom/livemixtapes/ui/FadeImageButton;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 51
    return-void
.end method
