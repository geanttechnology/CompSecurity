.class public abstract Lcom/poshmark/ui/customviews/DrawableOnTouchListener;
.super Ljava/lang/Object;
.source "DrawableOnTouchListener.java"

# interfaces
.implements Landroid/view/View$OnTouchListener;


# instance fields
.field drawable:Landroid/graphics/drawable/Drawable;

.field private fuzz:I


# direct methods
.method public constructor <init>(Landroid/widget/EditText;)V
    .locals 3
    .param p1, "view"    # Landroid/widget/EditText;

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    const/16 v1, 0xa

    iput v1, p0, Lcom/poshmark/ui/customviews/DrawableOnTouchListener;->fuzz:I

    .line 19
    invoke-virtual {p1}, Landroid/widget/EditText;->getCompoundDrawables()[Landroid/graphics/drawable/Drawable;

    move-result-object v0

    .line 20
    .local v0, "drawables":[Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    array-length v1, v0

    const/4 v2, 0x4

    if-ne v1, v2, :cond_0

    .line 21
    const/4 v1, 0x2

    aget-object v1, v0, v1

    iput-object v1, p0, Lcom/poshmark/ui/customviews/DrawableOnTouchListener;->drawable:Landroid/graphics/drawable/Drawable;

    .line 22
    :cond_0
    return-void
.end method


# virtual methods
.method public abstract onDrawableTouch(Landroid/view/MotionEvent;)Z
.end method

.method public onTouch(Landroid/view/View;Landroid/view/MotionEvent;)Z
    .locals 5
    .param p1, "v"    # Landroid/view/View;
    .param p2, "event"    # Landroid/view/MotionEvent;

    .prologue
    .line 31
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getAction()I

    move-result v3

    if-nez v3, :cond_0

    iget-object v3, p0, Lcom/poshmark/ui/customviews/DrawableOnTouchListener;->drawable:Landroid/graphics/drawable/Drawable;

    if-eqz v3, :cond_0

    .line 32
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getX()F

    move-result v3

    float-to-int v1, v3

    .line 33
    .local v1, "x":I
    invoke-virtual {p2}, Landroid/view/MotionEvent;->getY()F

    move-result v3

    float-to-int v2, v3

    .line 34
    .local v2, "y":I
    iget-object v3, p0, Lcom/poshmark/ui/customviews/DrawableOnTouchListener;->drawable:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v3}, Landroid/graphics/drawable/Drawable;->getBounds()Landroid/graphics/Rect;

    move-result-object v0

    .line 35
    .local v0, "bounds":Landroid/graphics/Rect;
    invoke-virtual {p1}, Landroid/view/View;->getRight()I

    move-result v3

    invoke-virtual {v0}, Landroid/graphics/Rect;->width()I

    move-result v4

    sub-int/2addr v3, v4

    iget v4, p0, Lcom/poshmark/ui/customviews/DrawableOnTouchListener;->fuzz:I

    sub-int/2addr v3, v4

    if-lt v1, v3, :cond_0

    invoke-virtual {p1}, Landroid/view/View;->getRight()I

    move-result v3

    invoke-virtual {p1}, Landroid/view/View;->getPaddingRight()I

    move-result v4

    sub-int/2addr v3, v4

    iget v4, p0, Lcom/poshmark/ui/customviews/DrawableOnTouchListener;->fuzz:I

    add-int/2addr v3, v4

    if-gt v1, v3, :cond_0

    invoke-virtual {p1}, Landroid/view/View;->getPaddingTop()I

    move-result v3

    iget v4, p0, Lcom/poshmark/ui/customviews/DrawableOnTouchListener;->fuzz:I

    sub-int/2addr v3, v4

    if-lt v2, v3, :cond_0

    invoke-virtual {p1}, Landroid/view/View;->getHeight()I

    move-result v3

    invoke-virtual {p1}, Landroid/view/View;->getPaddingBottom()I

    move-result v4

    sub-int/2addr v3, v4

    iget v4, p0, Lcom/poshmark/ui/customviews/DrawableOnTouchListener;->fuzz:I

    add-int/2addr v3, v4

    if-gt v2, v3, :cond_0

    .line 37
    invoke-virtual {p0, p2}, Lcom/poshmark/ui/customviews/DrawableOnTouchListener;->onDrawableTouch(Landroid/view/MotionEvent;)Z

    move-result v3

    .line 40
    .end local v0    # "bounds":Landroid/graphics/Rect;
    .end local v1    # "x":I
    .end local v2    # "y":I
    :goto_0
    return v3

    :cond_0
    const/4 v3, 0x0

    goto :goto_0
.end method
