.class public Lco/vine/android/views/SquareRelativeLayout;
.super Landroid/widget/RelativeLayout;
.source "SquareRelativeLayout.java"

# interfaces
.implements Ljava/lang/Runnable;
.implements Lco/vine/android/views/SquareMatch$SquareMatchView;


# instance fields
.field private mSpec:Lco/vine/android/views/SquareMatch$SquareMatchRules;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 15
    invoke-direct {p0, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 26
    sget-object v0, Lco/vine/android/views/SquareMatch$SquareMatchRules;->MATCH_LESS:Lco/vine/android/views/SquareMatch$SquareMatchRules;

    iput-object v0, p0, Lco/vine/android/views/SquareRelativeLayout;->mSpec:Lco/vine/android/views/SquareMatch$SquareMatchRules;

    .line 16
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 19
    invoke-direct {p0, p1, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 26
    sget-object v0, Lco/vine/android/views/SquareMatch$SquareMatchRules;->MATCH_LESS:Lco/vine/android/views/SquareMatch$SquareMatchRules;

    iput-object v0, p0, Lco/vine/android/views/SquareRelativeLayout;->mSpec:Lco/vine/android/views/SquareMatch$SquareMatchRules;

    .line 20
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 23
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 26
    sget-object v0, Lco/vine/android/views/SquareMatch$SquareMatchRules;->MATCH_LESS:Lco/vine/android/views/SquareMatch$SquareMatchRules;

    iput-object v0, p0, Lco/vine/android/views/SquareRelativeLayout;->mSpec:Lco/vine/android/views/SquareMatch$SquareMatchRules;

    .line 24
    return-void
.end method


# virtual methods
.method public getMatchLayoutRunnable()Ljava/lang/Runnable;
    .locals 0

    .prologue
    .line 41
    return-object p0
.end method

.method public getMatchSpec()Lco/vine/android/views/SquareMatch$SquareMatchRules;
    .locals 1
    .annotation build Lorg/jetbrains/annotations/NotNull;
    .end annotation

    .prologue
    .line 31
    iget-object v0, p0, Lco/vine/android/views/SquareRelativeLayout;->mSpec:Lco/vine/android/views/SquareMatch$SquareMatchRules;

    return-object v0
.end method

.method public onMeasure(II)V
    .locals 0
    .param p1, "widthMeasureSpec"    # I
    .param p2, "heightMeasureSpec"    # I

    .prologue
    .line 54
    invoke-super {p0, p1, p2}, Landroid/widget/RelativeLayout;->onMeasure(II)V

    .line 55
    invoke-static {p0}, Lco/vine/android/views/SquareMatch;->setupSquareMatchView(Lco/vine/android/views/SquareMatch$SquareMatchView;)V

    .line 56
    return-void
.end method

.method public run()V
    .locals 0

    .prologue
    .line 36
    invoke-static {p0}, Lco/vine/android/views/SquareMatch;->setMatchingLayoutAction(Lco/vine/android/views/SquareMatch$SquareMatchView;)V

    .line 37
    return-void
.end method

.method public setMatchRule(Lco/vine/android/views/SquareMatch$SquareMatchRules;)V
    .locals 0
    .param p1, "spec"    # Lco/vine/android/views/SquareMatch$SquareMatchRules;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    .line 49
    iput-object p1, p0, Lco/vine/android/views/SquareRelativeLayout;->mSpec:Lco/vine/android/views/SquareMatch$SquareMatchRules;

    .line 50
    return-void
.end method

.method public setMeasuredDimension(I)V
    .locals 0
    .param p1, "size"    # I

    .prologue
    .line 45
    invoke-virtual {p0, p1, p1}, Lco/vine/android/views/SquareRelativeLayout;->setMeasuredDimension(II)V

    .line 46
    return-void
.end method
