.class public Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;
.super Landroid/widget/RelativeLayout;
.source "CheckableRelativeLayout.java"

# interfaces
.implements Landroid/widget/Checkable;


# static fields
.field private static final CHECKED_STATE_SET:[I


# instance fields
.field private checked:Z


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 10
    const/4 v0, 0x1

    new-array v0, v0, [I

    const/4 v1, 0x0

    const v2, 0x10100a0

    aput v2, v0, v1

    sput-object v0, Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;->CHECKED_STATE_SET:[I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 17
    invoke-direct {p0, p1}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;)V

    .line 18
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 21
    invoke-direct {p0, p1, p2}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 22
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 25
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/RelativeLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 26
    return-void
.end method


# virtual methods
.method public isChecked()Z
    .locals 1

    .prologue
    .line 47
    iget-boolean v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;->checked:Z

    return v0
.end method

.method protected onCreateDrawableState(I)[I
    .locals 2
    .param p1, "extraSpace"    # I

    .prologue
    .line 30
    add-int/lit8 v1, p1, 0x1

    invoke-super {p0, v1}, Landroid/widget/RelativeLayout;->onCreateDrawableState(I)[I

    move-result-object v0

    .line 31
    .local v0, "drawableState":[I
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;->isChecked()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 32
    sget-object v1, Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;->CHECKED_STATE_SET:[I

    invoke-static {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;->mergeDrawableStates([I[I)[I

    .line 34
    :cond_0
    return-object v0
.end method

.method public setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V
    .locals 0
    .param p1, "d"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 57
    invoke-super {p0, p1}, Landroid/widget/RelativeLayout;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 58
    return-void
.end method

.method public setChecked(Z)V
    .locals 1
    .param p1, "checked"    # Z

    .prologue
    .line 39
    iget-boolean v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;->checked:Z

    if-eq v0, p1, :cond_0

    .line 40
    iput-boolean p1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;->checked:Z

    .line 41
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;->refreshDrawableState()V

    .line 43
    :cond_0
    return-void
.end method

.method public toggle()V
    .locals 1

    .prologue
    .line 52
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;->isChecked()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p0, v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;->setChecked(Z)V

    .line 53
    return-void

    .line 52
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
