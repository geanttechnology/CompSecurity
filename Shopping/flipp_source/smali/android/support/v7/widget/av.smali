.class public Landroid/support/v7/widget/av;
.super Landroid/view/ViewGroup$MarginLayoutParams;
.source "SourceFile"


# instance fields
.field c:Landroid/support/v7/widget/bi;

.field final d:Landroid/graphics/Rect;

.field e:Z

.field f:Z


# direct methods
.method public constructor <init>(II)V
    .locals 1

    .prologue
    .line 7022
    invoke-direct {p0, p1, p2}, Landroid/view/ViewGroup$MarginLayoutParams;-><init>(II)V

    .line 7010
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/support/v7/widget/av;->d:Landroid/graphics/Rect;

    .line 7011
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/widget/av;->e:Z

    .line 7015
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v7/widget/av;->f:Z

    .line 7023
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 7018
    invoke-direct {p0, p1, p2}, Landroid/view/ViewGroup$MarginLayoutParams;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 7010
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/support/v7/widget/av;->d:Landroid/graphics/Rect;

    .line 7011
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/widget/av;->e:Z

    .line 7015
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v7/widget/av;->f:Z

    .line 7019
    return-void
.end method

.method public constructor <init>(Landroid/support/v7/widget/av;)V
    .locals 1

    .prologue
    .line 7034
    invoke-direct {p0, p1}, Landroid/view/ViewGroup$MarginLayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    .line 7010
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/support/v7/widget/av;->d:Landroid/graphics/Rect;

    .line 7011
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/widget/av;->e:Z

    .line 7015
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v7/widget/av;->f:Z

    .line 7035
    return-void
.end method

.method public constructor <init>(Landroid/view/ViewGroup$LayoutParams;)V
    .locals 1

    .prologue
    .line 7030
    invoke-direct {p0, p1}, Landroid/view/ViewGroup$MarginLayoutParams;-><init>(Landroid/view/ViewGroup$LayoutParams;)V

    .line 7010
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/support/v7/widget/av;->d:Landroid/graphics/Rect;

    .line 7011
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/widget/av;->e:Z

    .line 7015
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v7/widget/av;->f:Z

    .line 7031
    return-void
.end method

.method public constructor <init>(Landroid/view/ViewGroup$MarginLayoutParams;)V
    .locals 1

    .prologue
    .line 7026
    invoke-direct {p0, p1}, Landroid/view/ViewGroup$MarginLayoutParams;-><init>(Landroid/view/ViewGroup$MarginLayoutParams;)V

    .line 7010
    new-instance v0, Landroid/graphics/Rect;

    invoke-direct {v0}, Landroid/graphics/Rect;-><init>()V

    iput-object v0, p0, Landroid/support/v7/widget/av;->d:Landroid/graphics/Rect;

    .line 7011
    const/4 v0, 0x1

    iput-boolean v0, p0, Landroid/support/v7/widget/av;->e:Z

    .line 7015
    const/4 v0, 0x0

    iput-boolean v0, p0, Landroid/support/v7/widget/av;->f:Z

    .line 7027
    return-void
.end method
