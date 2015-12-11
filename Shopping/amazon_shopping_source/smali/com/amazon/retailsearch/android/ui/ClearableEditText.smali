.class public Lcom/amazon/retailsearch/android/ui/ClearableEditText;
.super Landroid/widget/EditText;
.source "ClearableEditText.java"

# interfaces
.implements Landroid/text/TextWatcher;


# static fields
.field private static final DEFAULT_CLEAR_BUTTON_DRAWABLE:I


# instance fields
.field private mClearTextBitmap:Landroid/graphics/Bitmap;

.field private mClearTextButtonPaddingLeft:I

.field private mClearTextButtonPaddingRight:I

.field private mIsClearTextButtonEnabled:Z

.field private mIsClearTextButtonVisible:Z

.field private mIsHandlingAction:Z

.field private mPaint:Landroid/graphics/Paint;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 33
    sget v0, Lcom/amazon/retailsearch/R$drawable;->rs_clear_search_api_holo_light:I

    sput v0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->DEFAULT_CLEAR_BUTTON_DRAWABLE:I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 71
    invoke-direct {p0, p1}, Landroid/widget/EditText;-><init>(Landroid/content/Context;)V

    .line 72
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 75
    invoke-direct {p0, p1, p2}, Landroid/widget/EditText;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 76
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 79
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/EditText;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 80
    return-void
.end method

.method private loadClearButtonBitmap()V
    .locals 2

    .prologue
    .line 142
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mClearTextBitmap:Landroid/graphics/Bitmap;

    if-nez v0, :cond_0

    .line 143
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->DEFAULT_CLEAR_BUTTON_DRAWABLE:I

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mClearTextBitmap:Landroid/graphics/Bitmap;

    .line 145
    :cond_0
    return-void
.end method

.method private removeClearButtonBitmap()V
    .locals 1

    .prologue
    .line 151
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mClearTextBitmap:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_0

    .line 152
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mClearTextBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    .line 153
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mClearTextBitmap:Landroid/graphics/Bitmap;

    .line 155
    :cond_0
    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0
    .param p1, "s"    # Landroid/text/Editable;

    .prologue
    .line 228
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "count"    # I
    .param p4, "after"    # I

    .prologue
    .line 225
    return-void
.end method

.method public enableClearTextButton(Z)V
    .locals 4
    .param p1, "enable"    # Z

    .prologue
    .line 87
    if-eqz p1, :cond_1

    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mIsClearTextButtonEnabled:Z

    if-nez v0, :cond_1

    .line 89
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mPaint:Landroid/graphics/Paint;

    .line 92
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->loadClearButtonBitmap()V

    .line 95
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->getPaddingLeft()I

    move-result v0

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->getPaddingTop()I

    move-result v1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->getPaddingRight()I

    move-result v2

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mClearTextBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->getPaddingBottom()I

    move-result v3

    invoke-virtual {p0, v0, v1, v2, v3}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->setPadding(IIII)V

    .line 101
    invoke-virtual {p0, p0}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 115
    :cond_0
    :goto_0
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mIsClearTextButtonEnabled:Z

    .line 116
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->invalidate()V

    .line 117
    return-void

    .line 102
    :cond_1
    if-nez p1, :cond_0

    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mIsClearTextButtonEnabled:Z

    if-eqz v0, :cond_0

    .line 103
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mClearTextBitmap:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_2

    .line 105
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->getPaddingLeft()I

    move-result v0

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->getPaddingTop()I

    move-result v1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->getPaddingRight()I

    move-result v2

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mClearTextBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    sub-int/2addr v2, v3

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->getPaddingBottom()I

    move-result v3

    invoke-virtual {p0, v0, v1, v2, v3}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->setPadding(IIII)V

    .line 108
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->removeClearButtonBitmap()V

    .line 111
    :cond_2
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mPaint:Landroid/graphics/Paint;

    .line 112
    invoke-virtual {p0, p0}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->removeTextChangedListener(Landroid/text/TextWatcher;)V

    goto :goto_0
.end method

.method protected onAttachedToWindow()V
    .locals 1

    .prologue
    .line 204
    invoke-super {p0}, Landroid/widget/EditText;->onAttachedToWindow()V

    .line 205
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mIsClearTextButtonEnabled:Z

    if-eqz v0, :cond_0

    .line 206
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->loadClearButtonBitmap()V

    .line 208
    :cond_0
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 0

    .prologue
    .line 212
    invoke-super {p0}, Landroid/widget/EditText;->onDetachedFromWindow()V

    .line 213
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->removeClearButtonBitmap()V

    .line 214
    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 5
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 191
    invoke-super {p0, p1}, Landroid/widget/EditText;->onDraw(Landroid/graphics/Canvas;)V

    .line 193
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mIsClearTextButtonEnabled:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mIsClearTextButtonVisible:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mClearTextBitmap:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_0

    .line 194
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mClearTextBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->getScrollX()I

    move-result v1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->getWidth()I

    move-result v2

    add-int/2addr v1, v2

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mClearTextBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v2

    sub-int/2addr v1, v2

    iget v2, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mClearTextButtonPaddingRight:I

    sub-int/2addr v1, v2

    int-to-float v1, v1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->getScrollY()I

    move-result v2

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->getHeight()I

    move-result v3

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mClearTextBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v4}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v4

    sub-int/2addr v3, v4

    div-int/lit8 v3, v3, 0x2

    add-int/2addr v2, v3

    int-to-float v2, v2

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 200
    :cond_0
    return-void
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 1
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    .line 221
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mIsClearTextButtonVisible:Z

    .line 222
    return-void

    .line 221
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onTouchEvent(Landroid/view/MotionEvent;)Z
    .locals 5
    .param p1, "event"    # Landroid/view/MotionEvent;

    .prologue
    const/4 v0, 0x1

    const/4 v4, 0x0

    .line 160
    iget-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mIsClearTextButtonEnabled:Z

    if-eqz v1, :cond_1

    iget-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mIsClearTextButtonVisible:Z

    if-eqz v1, :cond_1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->getRight()I

    move-result v2

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->getPaddingRight()I

    move-result v3

    sub-int/2addr v2, v3

    int-to-float v2, v2

    cmpl-float v1, v1, v2

    if-lez v1, :cond_1

    .line 165
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 186
    :goto_0
    :pswitch_0
    return v0

    .line 167
    :pswitch_1
    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mIsHandlingAction:Z

    goto :goto_0

    .line 171
    :pswitch_2
    iget-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mIsHandlingAction:Z

    if-eqz v1, :cond_0

    .line 172
    const-string/jumbo v1, ""

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->setText(Ljava/lang/CharSequence;)V

    .line 174
    :cond_0
    iput-boolean v4, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mIsHandlingAction:Z

    goto :goto_0

    .line 177
    :pswitch_3
    iput-boolean v4, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mIsHandlingAction:Z

    goto :goto_0

    .line 186
    :cond_1
    invoke-super {p0, p1}, Landroid/widget/EditText;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0

    .line 165
    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_3
    .end packed-switch
.end method

.method public setClearTextButtonPadding(II)V
    .locals 4
    .param p1, "left"    # I
    .param p2, "right"    # I

    .prologue
    .line 126
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->getPaddingLeft()I

    move-result v0

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->getPaddingTop()I

    move-result v1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->getPaddingRight()I

    move-result v2

    iget v3, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mClearTextButtonPaddingLeft:I

    sub-int/2addr v2, v3

    iget v3, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mClearTextButtonPaddingRight:I

    sub-int/2addr v2, v3

    add-int/2addr v2, p1

    add-int/2addr v2, p2

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->getPaddingBottom()I

    move-result v3

    invoke-virtual {p0, v0, v1, v2, v3}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->setPadding(IIII)V

    .line 132
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mClearTextButtonPaddingLeft:I

    .line 133
    iput p2, p0, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->mClearTextButtonPaddingRight:I

    .line 135
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableEditText;->invalidate()V

    .line 136
    return-void
.end method
