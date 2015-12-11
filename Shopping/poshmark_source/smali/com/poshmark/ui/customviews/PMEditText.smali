.class public Lcom/poshmark/ui/customviews/PMEditText;
.super Landroid/widget/EditText;
.source "PMEditText.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/customviews/PMEditText$OnTapListener;
    }
.end annotation


# instance fields
.field defaultMessage:Ljava/lang/String;

.field isKeyboardInput:Z

.field isRequired:Z

.field listener:Lcom/poshmark/ui/customviews/PMEditText$OnTapListener;

.field message:Ljava/lang/String;

.field mode:Lcom/poshmark/utils/TextValidator$MODE;

.field validator:Lcom/poshmark/utils/TextValidator;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 29
    invoke-direct {p0, p1, p2}, Landroid/widget/EditText;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 19
    iput-boolean v4, p0, Lcom/poshmark/ui/customviews/PMEditText;->isRequired:Z

    .line 20
    iput-boolean v5, p0, Lcom/poshmark/ui/customviews/PMEditText;->isKeyboardInput:Z

    .line 21
    new-instance v2, Lcom/poshmark/utils/TextValidator;

    invoke-direct {v2}, Lcom/poshmark/utils/TextValidator;-><init>()V

    iput-object v2, p0, Lcom/poshmark/ui/customviews/PMEditText;->validator:Lcom/poshmark/utils/TextValidator;

    .line 22
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMEditText;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f06022a

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/customviews/PMEditText;->defaultMessage:Ljava/lang/String;

    .line 31
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMEditText;->getContext()Landroid/content/Context;

    move-result-object v2

    sget-object v3, Lcom/poshmark/app/R$styleable;->PMEditText:[I

    invoke-virtual {v2, p2, v3}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 33
    .local v0, "array":Landroid/content/res/TypedArray;
    invoke-virtual {v0, v4, v4}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    iput-boolean v2, p0, Lcom/poshmark/ui/customviews/PMEditText;->isRequired:Z

    .line 34
    invoke-virtual {v0, v5, v5}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v2

    iput-boolean v2, p0, Lcom/poshmark/ui/customviews/PMEditText;->isKeyboardInput:Z

    .line 36
    iget-boolean v2, p0, Lcom/poshmark/ui/customviews/PMEditText;->isKeyboardInput:Z

    if-eqz v2, :cond_0

    .line 37
    const/4 v2, 0x2

    invoke-virtual {v0, v2, v5}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v2

    invoke-static {v2}, Lcom/poshmark/utils/TextValidator$MODE;->getMode(I)Lcom/poshmark/utils/TextValidator$MODE;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/customviews/PMEditText;->mode:Lcom/poshmark/utils/TextValidator$MODE;

    .line 38
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMEditText;->validator:Lcom/poshmark/utils/TextValidator;

    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMEditText;->mode:Lcom/poshmark/utils/TextValidator$MODE;

    invoke-virtual {v2, v3}, Lcom/poshmark/utils/TextValidator;->setValidatorMode(Lcom/poshmark/utils/TextValidator$MODE;)V

    .line 41
    :cond_0
    const/4 v2, 0x3

    invoke-virtual {v0, v2}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/customviews/PMEditText;->message:Ljava/lang/String;

    .line 42
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMEditText;->message:Ljava/lang/String;

    if-nez v2, :cond_1

    .line 43
    iget-object v2, p0, Lcom/poshmark/ui/customviews/PMEditText;->defaultMessage:Ljava/lang/String;

    iput-object v2, p0, Lcom/poshmark/ui/customviews/PMEditText;->message:Ljava/lang/String;

    .line 46
    :cond_1
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMEditText;->getContext()Landroid/content/Context;

    move-result-object v2

    sget-object v3, Lcom/poshmark/app/R$styleable;->PMCommon:[I

    invoke-virtual {v2, p2, v3}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 47
    invoke-virtual {v0, v4}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 48
    .local v1, "fontName":Ljava/lang/String;
    if-eqz v1, :cond_2

    .line 49
    invoke-static {p1, v1, p0}, Lcom/poshmark/utils/ViewUtils;->setTypefaceForView(Landroid/content/Context;Ljava/lang/String;Landroid/widget/TextView;)V

    .line 51
    :cond_2
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 52
    return-void
.end method

.method private tapInView(FF)Z
    .locals 6
    .param p1, "x"    # F
    .param p2, "y"    # F

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 77
    const/4 v5, 0x2

    new-array v0, v5, [I

    .line 78
    .local v0, "location":[I
    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMEditText;->getLocationOnScreen([I)V

    .line 79
    aget v1, v0, v4

    .line 80
    .local v1, "viewX":I
    aget v2, v0, v3

    .line 83
    .local v2, "viewY":I
    int-to-float v5, v1

    cmpl-float v5, p1, v5

    if-lez v5, :cond_0

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMEditText;->getWidth()I

    move-result v5

    add-int/2addr v5, v1

    int-to-float v5, v5

    cmpg-float v5, p1, v5

    if-gez v5, :cond_0

    int-to-float v5, v2

    cmpl-float v5, p2, v5

    if-lez v5, :cond_0

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMEditText;->getHeight()I

    move-result v5

    add-int/2addr v5, v2

    int-to-float v5, v5

    cmpg-float v5, p2, v5

    if-gez v5, :cond_0

    .line 87
    :goto_0
    return v3

    :cond_0
    move v3, v4

    goto :goto_0
.end method


# virtual methods
.method public getValidatorString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 116
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/customviews/PMEditText;->getValidatorString(Z)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getValidatorString(Z)Ljava/lang/String;
    .locals 4
    .param p1, "force"    # Z

    .prologue
    .line 104
    if-eqz p1, :cond_1

    .line 105
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditText;->message:Ljava/lang/String;

    .line 112
    :cond_0
    :goto_0
    return-object v0

    .line 107
    :cond_1
    iget-object v1, p0, Lcom/poshmark/ui/customviews/PMEditText;->validator:Lcom/poshmark/utils/TextValidator;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMEditText;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/poshmark/utils/TextValidator;->getErrorMessage(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 108
    .local v0, "msg":Ljava/lang/String;
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 112
    :cond_2
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditText;->message:Ljava/lang/String;

    goto :goto_0
.end method

.method public isValid()Z
    .locals 2

    .prologue
    .line 100
    iget-object v0, p0, Lcom/poshmark/ui/customviews/PMEditText;->validator:Lcom/poshmark/utils/TextValidator;

    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/PMEditText;->getText()Landroid/text/Editable;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/poshmark/utils/TextValidator;->isValid(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public onCheckIsTextEditor()Z
    .locals 1

    .prologue
    .line 56
    iget-boolean v0, p0, Lcom/poshmark/ui/customviews/PMEditText;->isKeyboardInput:Z

    return v0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 4
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v2, 0x1

    .line 61
    iget-boolean v3, p0, Lcom/poshmark/ui/customviews/PMEditText;->isKeyboardInput:Z

    if-eqz v3, :cond_1

    .line 62
    invoke-super {p0, p1}, Landroid/widget/EditText;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v2

    .line 73
    :cond_0
    :goto_0
    return v2

    .line 64
    :cond_1
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v3

    if-ne v3, v2, :cond_0

    .line 65
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawX()F

    move-result v0

    .line 66
    .local v0, "xPos":F
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getRawY()F

    move-result v1

    .line 67
    .local v1, "yPos":F
    invoke-direct {p0, v0, v1}, Lcom/poshmark/ui/customviews/PMEditText;->tapInView(FF)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 68
    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMEditText;->listener:Lcom/poshmark/ui/customviews/PMEditText$OnTapListener;

    if-eqz v3, :cond_0

    .line 69
    iget-object v3, p0, Lcom/poshmark/ui/customviews/PMEditText;->listener:Lcom/poshmark/ui/customviews/PMEditText$OnTapListener;

    invoke-interface {v3, p0}, Lcom/poshmark/ui/customviews/PMEditText$OnTapListener;->onTap(Landroid/view/View;)V

    goto :goto_0
.end method

.method public setOnTapListener(Lcom/poshmark/ui/customviews/PMEditText$OnTapListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/poshmark/ui/customviews/PMEditText$OnTapListener;

    .prologue
    .line 92
    iput-object p1, p0, Lcom/poshmark/ui/customviews/PMEditText;->listener:Lcom/poshmark/ui/customviews/PMEditText$OnTapListener;

    .line 93
    return-void
.end method
