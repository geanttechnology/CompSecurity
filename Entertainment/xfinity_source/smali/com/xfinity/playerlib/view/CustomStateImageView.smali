.class public Lcom/xfinity/playerlib/view/CustomStateImageView;
.super Landroid/widget/ImageView;
.source "CustomStateImageView.java"


# static fields
.field private static final APPEAR_ENABLED_STATE_SET:[I


# instance fields
.field private appearEnabled:Z


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 10
    const/4 v0, 0x1

    new-array v0, v0, [I

    const/4 v1, 0x0

    sget v2, Lcom/xfinity/playerlib/R$attr;->state_appear_enabled:I

    aput v2, v0, v1

    sput-object v0, Lcom/xfinity/playerlib/view/CustomStateImageView;->APPEAR_ENABLED_STATE_SET:[I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 17
    invoke-direct {p0, p1}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 14
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/CustomStateImageView;->appearEnabled:Z

    .line 18
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 14
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/CustomStateImageView;->appearEnabled:Z

    .line 26
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 21
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 14
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/CustomStateImageView;->appearEnabled:Z

    .line 22
    return-void
.end method


# virtual methods
.method public appearEnabled()Z
    .locals 1

    .prologue
    .line 35
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/CustomStateImageView;->appearEnabled:Z

    return v0
.end method

.method public onCreateDrawableState(I)[I
    .locals 2
    .param p1, "extraSpace"    # I

    .prologue
    .line 40
    add-int/lit8 v1, p1, 0x1

    invoke-super {p0, v1}, Landroid/widget/ImageView;->onCreateDrawableState(I)[I

    move-result-object v0

    .line 42
    .local v0, "drawableState":[I
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/CustomStateImageView;->appearEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 43
    sget-object v1, Lcom/xfinity/playerlib/view/CustomStateImageView;->APPEAR_ENABLED_STATE_SET:[I

    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/CustomStateImageView;->mergeDrawableStates([I[I)[I

    .line 46
    :cond_0
    return-object v0
.end method

.method public setAppearEnabled(Z)V
    .locals 0
    .param p1, "appearEnabled"    # Z

    .prologue
    .line 29
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/CustomStateImageView;->appearEnabled:Z

    .line 30
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/CustomStateImageView;->refreshDrawableState()V

    .line 31
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/CustomStateImageView;->invalidate()V

    .line 32
    return-void
.end method
