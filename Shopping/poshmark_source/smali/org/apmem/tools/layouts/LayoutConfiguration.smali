.class Lorg/apmem/tools/layouts/LayoutConfiguration;
.super Ljava/lang/Object;
.source "LayoutConfiguration.java"


# instance fields
.field private debugDraw:Z

.field private gravity:I

.field private layoutDirection:I

.field private orientation:I

.field private weightDefault:F


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attributeSet"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 9
    iput v2, p0, Lorg/apmem/tools/layouts/LayoutConfiguration;->orientation:I

    .line 10
    iput-boolean v2, p0, Lorg/apmem/tools/layouts/LayoutConfiguration;->debugDraw:Z

    .line 11
    iput v1, p0, Lorg/apmem/tools/layouts/LayoutConfiguration;->weightDefault:F

    .line 12
    const/16 v1, 0x33

    iput v1, p0, Lorg/apmem/tools/layouts/LayoutConfiguration;->gravity:I

    .line 13
    iput v2, p0, Lorg/apmem/tools/layouts/LayoutConfiguration;->layoutDirection:I

    .line 16
    sget-object v1, Lorg/apmem/tools/layouts/R$styleable;->FlowLayout:[I

    invoke-virtual {p1, p2, v1}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 18
    .local v0, "a":Landroid/content/res/TypedArray;
    :try_start_0
    sget v1, Lorg/apmem/tools/layouts/R$styleable;->FlowLayout_android_orientation:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getInteger(II)I

    move-result v1

    invoke-virtual {p0, v1}, Lorg/apmem/tools/layouts/LayoutConfiguration;->setOrientation(I)V

    .line 19
    sget v1, Lorg/apmem/tools/layouts/R$styleable;->FlowLayout_debugDraw:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    invoke-virtual {p0, v1}, Lorg/apmem/tools/layouts/LayoutConfiguration;->setDebugDraw(Z)V

    .line 20
    sget v1, Lorg/apmem/tools/layouts/R$styleable;->FlowLayout_weightDefault:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getFloat(IF)F

    move-result v1

    invoke-virtual {p0, v1}, Lorg/apmem/tools/layouts/LayoutConfiguration;->setWeightDefault(F)V

    .line 21
    sget v1, Lorg/apmem/tools/layouts/R$styleable;->FlowLayout_android_gravity:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getInteger(II)I

    move-result v1

    invoke-virtual {p0, v1}, Lorg/apmem/tools/layouts/LayoutConfiguration;->setGravity(I)V

    .line 22
    sget v1, Lorg/apmem/tools/layouts/R$styleable;->FlowLayout_layoutDirection:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getInteger(II)I

    move-result v1

    invoke-virtual {p0, v1}, Lorg/apmem/tools/layouts/LayoutConfiguration;->setLayoutDirection(I)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 24
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 26
    return-void

    .line 24
    :catchall_0
    move-exception v1

    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    throw v1
.end method


# virtual methods
.method public getGravity()I
    .locals 1

    .prologue
    .line 57
    iget v0, p0, Lorg/apmem/tools/layouts/LayoutConfiguration;->gravity:I

    return v0
.end method

.method public getLayoutDirection()I
    .locals 1

    .prologue
    .line 73
    iget v0, p0, Lorg/apmem/tools/layouts/LayoutConfiguration;->layoutDirection:I

    return v0
.end method

.method public getOrientation()I
    .locals 1

    .prologue
    .line 29
    iget v0, p0, Lorg/apmem/tools/layouts/LayoutConfiguration;->orientation:I

    return v0
.end method

.method public getWeightDefault()F
    .locals 1

    .prologue
    .line 49
    iget v0, p0, Lorg/apmem/tools/layouts/LayoutConfiguration;->weightDefault:F

    return v0
.end method

.method public isDebugDraw()Z
    .locals 1

    .prologue
    .line 41
    iget-boolean v0, p0, Lorg/apmem/tools/layouts/LayoutConfiguration;->debugDraw:Z

    return v0
.end method

.method public setDebugDraw(Z)V
    .locals 0
    .param p1, "debugDraw"    # Z

    .prologue
    .line 45
    iput-boolean p1, p0, Lorg/apmem/tools/layouts/LayoutConfiguration;->debugDraw:Z

    .line 46
    return-void
.end method

.method public setGravity(I)V
    .locals 1
    .param p1, "gravity"    # I

    .prologue
    .line 61
    and-int/lit8 v0, p1, 0x7

    if-nez v0, :cond_0

    .line 62
    or-int/lit8 p1, p1, 0x3

    .line 65
    :cond_0
    and-int/lit8 v0, p1, 0x70

    if-nez v0, :cond_1

    .line 66
    or-int/lit8 p1, p1, 0x30

    .line 69
    :cond_1
    iput p1, p0, Lorg/apmem/tools/layouts/LayoutConfiguration;->gravity:I

    .line 70
    return-void
.end method

.method public setLayoutDirection(I)V
    .locals 1
    .param p1, "layoutDirection"    # I

    .prologue
    .line 77
    const/4 v0, 0x1

    if-ne p1, v0, :cond_0

    .line 78
    iput p1, p0, Lorg/apmem/tools/layouts/LayoutConfiguration;->layoutDirection:I

    .line 82
    :goto_0
    return-void

    .line 80
    :cond_0
    const/4 v0, 0x0

    iput v0, p0, Lorg/apmem/tools/layouts/LayoutConfiguration;->layoutDirection:I

    goto :goto_0
.end method

.method public setOrientation(I)V
    .locals 1
    .param p1, "orientation"    # I

    .prologue
    .line 33
    const/4 v0, 0x1

    if-ne p1, v0, :cond_0

    .line 34
    iput p1, p0, Lorg/apmem/tools/layouts/LayoutConfiguration;->orientation:I

    .line 38
    :goto_0
    return-void

    .line 36
    :cond_0
    const/4 v0, 0x0

    iput v0, p0, Lorg/apmem/tools/layouts/LayoutConfiguration;->orientation:I

    goto :goto_0
.end method

.method public setWeightDefault(F)V
    .locals 1
    .param p1, "weightDefault"    # F

    .prologue
    .line 53
    const/4 v0, 0x0

    invoke-static {v0, p1}, Ljava/lang/Math;->max(FF)F

    move-result v0

    iput v0, p0, Lorg/apmem/tools/layouts/LayoutConfiguration;->weightDefault:F

    .line 54
    return-void
.end method
