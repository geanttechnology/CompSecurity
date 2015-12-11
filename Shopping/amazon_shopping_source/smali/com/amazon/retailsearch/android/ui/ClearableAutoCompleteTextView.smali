.class public Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;
.super Landroid/widget/AutoCompleteTextView;
.source "ClearableAutoCompleteTextView.java"

# interfaces
.implements Landroid/text/TextWatcher;


# static fields
.field private static final DEFAULT_CLEAR_BUTTON_DRAWABLE:I


# instance fields
.field private clearButtonEventListener:Lcom/amazon/retailsearch/android/ui/ClearButtonEventListener;

.field private keyPreImeListener:Lcom/amazon/retailsearch/android/api/display/input/listeners/KeyPreImeListener;

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
    .line 37
    sget v0, Lcom/amazon/retailsearch/R$drawable;->rs_action_bar_clear_button:I

    sput v0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->DEFAULT_CLEAR_BUTTON_DRAWABLE:I

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 85
    invoke-direct {p0, p1}, Landroid/widget/AutoCompleteTextView;-><init>(Landroid/content/Context;)V

    .line 86
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 89
    invoke-direct {p0, p1, p2}, Landroid/widget/AutoCompleteTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 90
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 93
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/AutoCompleteTextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 94
    return-void
.end method

.method private loadClearButtonBitmap()V
    .locals 2

    .prologue
    .line 156
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mClearTextBitmap:Landroid/graphics/Bitmap;

    if-nez v0, :cond_0

    .line 157
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->DEFAULT_CLEAR_BUTTON_DRAWABLE:I

    invoke-static {v0, v1}, Landroid/graphics/BitmapFactory;->decodeResource(Landroid/content/res/Resources;I)Landroid/graphics/Bitmap;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mClearTextBitmap:Landroid/graphics/Bitmap;

    .line 159
    :cond_0
    return-void
.end method

.method private removeClearButtonBitmap()V
    .locals 1

    .prologue
    .line 165
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mClearTextBitmap:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_0

    .line 166
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mClearTextBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v0}, Landroid/graphics/Bitmap;->recycle()V

    .line 167
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mClearTextBitmap:Landroid/graphics/Bitmap;

    .line 169
    :cond_0
    return-void
.end method


# virtual methods
.method public afterTextChanged(Landroid/text/Editable;)V
    .locals 0
    .param p1, "s"    # Landroid/text/Editable;

    .prologue
    .line 246
    return-void
.end method

.method public beforeTextChanged(Ljava/lang/CharSequence;III)V
    .locals 0
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "count"    # I
    .param p4, "after"    # I

    .prologue
    .line 243
    return-void
.end method

.method public enableClearTextButton(Z)V
    .locals 4
    .param p1, "enable"    # Z

    .prologue
    .line 101
    if-eqz p1, :cond_1

    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mIsClearTextButtonEnabled:Z

    if-nez v0, :cond_1

    .line 103
    new-instance v0, Landroid/graphics/Paint;

    invoke-direct {v0}, Landroid/graphics/Paint;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mPaint:Landroid/graphics/Paint;

    .line 106
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->loadClearButtonBitmap()V

    .line 109
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getPaddingLeft()I

    move-result v0

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getPaddingTop()I

    move-result v1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getPaddingRight()I

    move-result v2

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mClearTextBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    add-int/2addr v2, v3

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getPaddingBottom()I

    move-result v3

    invoke-virtual {p0, v0, v1, v2, v3}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->setPadding(IIII)V

    .line 115
    invoke-virtual {p0, p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->addTextChangedListener(Landroid/text/TextWatcher;)V

    .line 129
    :cond_0
    :goto_0
    iput-boolean p1, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mIsClearTextButtonEnabled:Z

    .line 130
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->invalidate()V

    .line 131
    return-void

    .line 116
    :cond_1
    if-nez p1, :cond_0

    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mIsClearTextButtonEnabled:Z

    if-eqz v0, :cond_0

    .line 117
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mClearTextBitmap:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_2

    .line 119
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getPaddingLeft()I

    move-result v0

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getPaddingTop()I

    move-result v1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getPaddingRight()I

    move-result v2

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mClearTextBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v3}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v3

    sub-int/2addr v2, v3

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getPaddingBottom()I

    move-result v3

    invoke-virtual {p0, v0, v1, v2, v3}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->setPadding(IIII)V

    .line 122
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->removeClearButtonBitmap()V

    .line 125
    :cond_2
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mPaint:Landroid/graphics/Paint;

    .line 126
    invoke-virtual {p0, p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->removeTextChangedListener(Landroid/text/TextWatcher;)V

    goto :goto_0
.end method

.method public enoughToFilter()Z
    .locals 1

    .prologue
    .line 280
    const/4 v0, 0x1

    return v0
.end method

.method protected onAttachedToWindow()V
    .locals 1

    .prologue
    .line 222
    invoke-super {p0}, Landroid/widget/AutoCompleteTextView;->onAttachedToWindow()V

    .line 223
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mIsClearTextButtonEnabled:Z

    if-eqz v0, :cond_0

    .line 224
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->loadClearButtonBitmap()V

    .line 226
    :cond_0
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 0

    .prologue
    .line 230
    invoke-super {p0}, Landroid/widget/AutoCompleteTextView;->onDetachedFromWindow()V

    .line 231
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->removeClearButtonBitmap()V

    .line 232
    return-void
.end method

.method protected onDraw(Landroid/graphics/Canvas;)V
    .locals 5
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 209
    invoke-super {p0, p1}, Landroid/widget/AutoCompleteTextView;->onDraw(Landroid/graphics/Canvas;)V

    .line 211
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mIsClearTextButtonEnabled:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mIsClearTextButtonVisible:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mClearTextBitmap:Landroid/graphics/Bitmap;

    if-eqz v0, :cond_0

    .line 212
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mClearTextBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getScrollX()I

    move-result v1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getWidth()I

    move-result v2

    add-int/2addr v1, v2

    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mClearTextBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v2}, Landroid/graphics/Bitmap;->getWidth()I

    move-result v2

    sub-int/2addr v1, v2

    iget v2, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mClearTextButtonPaddingRight:I

    sub-int/2addr v1, v2

    int-to-float v1, v1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getScrollY()I

    move-result v2

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getHeight()I

    move-result v3

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mClearTextBitmap:Landroid/graphics/Bitmap;

    invoke-virtual {v4}, Landroid/graphics/Bitmap;->getHeight()I

    move-result v4

    sub-int/2addr v3, v4

    div-int/lit8 v3, v3, 0x2

    add-int/2addr v2, v3

    int-to-float v2, v2

    iget-object v3, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mPaint:Landroid/graphics/Paint;

    invoke-virtual {p1, v0, v1, v2, v3}, Landroid/graphics/Canvas;->drawBitmap(Landroid/graphics/Bitmap;FFLandroid/graphics/Paint;)V

    .line 218
    :cond_0
    return-void
.end method

.method protected onFocusChanged(ZILandroid/graphics/Rect;)V
    .locals 2
    .param p1, "focused"    # Z
    .param p2, "direction"    # I
    .param p3, "previouslyFocusedRect"    # Landroid/graphics/Rect;

    .prologue
    .line 286
    invoke-super {p0, p1, p2, p3}, Landroid/widget/AutoCompleteTextView;->onFocusChanged(ZILandroid/graphics/Rect;)V

    .line 287
    if-eqz p1, :cond_0

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 289
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getText()Landroid/text/Editable;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->performFiltering(Ljava/lang/CharSequence;I)V

    .line 290
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->showDropDown()V

    .line 292
    :cond_0
    if-nez p1, :cond_1

    .line 294
    invoke-static {p0}, Lcom/amazon/retailsearch/android/ui/UIUtils;->closeSoftKeyboard(Landroid/view/View;)V

    .line 296
    :cond_1
    return-void
.end method

.method public onKeyPreIme(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 254
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->keyPreImeListener:Lcom/amazon/retailsearch/android/api/display/input/listeners/KeyPreImeListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->keyPreImeListener:Lcom/amazon/retailsearch/android/api/display/input/listeners/KeyPreImeListener;

    invoke-interface {v0, p1, p2}, Lcom/amazon/retailsearch/android/api/display/input/listeners/KeyPreImeListener;->onKeyPreIme(ILandroid/view/KeyEvent;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 256
    const/4 v0, 0x1

    .line 258
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1, p2}, Landroid/widget/AutoCompleteTextView;->onKeyPreIme(ILandroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public onTextChanged(Ljava/lang/CharSequence;III)V
    .locals 1
    .param p1, "s"    # Ljava/lang/CharSequence;
    .param p2, "start"    # I
    .param p3, "before"    # I
    .param p4, "count"    # I

    .prologue
    .line 239
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mIsClearTextButtonVisible:Z

    .line 240
    return-void

    .line 239
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

    .line 174
    iget-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mIsClearTextButtonEnabled:Z

    if-eqz v1, :cond_1

    iget-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mIsClearTextButtonVisible:Z

    if-eqz v1, :cond_1

    invoke-virtual {p1}, Landroid/view/MotionEvent;->getX()F

    move-result v1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getRight()I

    move-result v2

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getPaddingRight()I

    move-result v3

    sub-int/2addr v2, v3

    int-to-float v2, v2

    cmpl-float v1, v1, v2

    if-lez v1, :cond_1

    .line 179
    invoke-virtual {p1}, Landroid/view/MotionEvent;->getAction()I

    move-result v1

    packed-switch v1, :pswitch_data_0

    .line 204
    :goto_0
    :pswitch_0
    return v0

    .line 181
    :pswitch_1
    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mIsHandlingAction:Z

    goto :goto_0

    .line 185
    :pswitch_2
    iget-boolean v1, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mIsHandlingAction:Z

    if-eqz v1, :cond_0

    .line 186
    const-string/jumbo v1, ""

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->setText(Ljava/lang/CharSequence;)V

    .line 187
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->clearButtonEventListener:Lcom/amazon/retailsearch/android/ui/ClearButtonEventListener;

    if-eqz v1, :cond_0

    .line 189
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->clearButtonEventListener:Lcom/amazon/retailsearch/android/ui/ClearButtonEventListener;

    invoke-interface {v1}, Lcom/amazon/retailsearch/android/ui/ClearButtonEventListener;->onTextCleared()V

    .line 192
    :cond_0
    iput-boolean v4, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mIsHandlingAction:Z

    goto :goto_0

    .line 195
    :pswitch_3
    iput-boolean v4, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mIsHandlingAction:Z

    goto :goto_0

    .line 204
    :cond_1
    invoke-super {p0, p1}, Landroid/widget/AutoCompleteTextView;->onTouchEvent(Landroid/view/MotionEvent;)Z

    move-result v0

    goto :goto_0

    .line 179
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_1
        :pswitch_2
        :pswitch_0
        :pswitch_3
    .end packed-switch
.end method

.method public removeKeyPreImeListener()V
    .locals 1

    .prologue
    .line 303
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->keyPreImeListener:Lcom/amazon/retailsearch/android/api/display/input/listeners/KeyPreImeListener;

    .line 304
    return-void
.end method

.method public setClearButtonEventListener(Lcom/amazon/retailsearch/android/ui/ClearButtonEventListener;)V
    .locals 0
    .param p1, "clearButtonEventListener"    # Lcom/amazon/retailsearch/android/ui/ClearButtonEventListener;

    .prologue
    .line 274
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->clearButtonEventListener:Lcom/amazon/retailsearch/android/ui/ClearButtonEventListener;

    .line 275
    return-void
.end method

.method public setClearTextButtonPadding(II)V
    .locals 4
    .param p1, "left"    # I
    .param p2, "right"    # I

    .prologue
    .line 140
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getPaddingLeft()I

    move-result v0

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getPaddingTop()I

    move-result v1

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getPaddingRight()I

    move-result v2

    iget v3, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mClearTextButtonPaddingLeft:I

    sub-int/2addr v2, v3

    iget v3, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mClearTextButtonPaddingRight:I

    sub-int/2addr v2, v3

    add-int/2addr v2, p1

    add-int/2addr v2, p2

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->getPaddingBottom()I

    move-result v3

    invoke-virtual {p0, v0, v1, v2, v3}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->setPadding(IIII)V

    .line 146
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mClearTextButtonPaddingLeft:I

    .line 147
    iput p2, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->mClearTextButtonPaddingRight:I

    .line 149
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->invalidate()V

    .line 150
    return-void
.end method

.method public setKeyPreImeListener(Lcom/amazon/retailsearch/android/api/display/input/listeners/KeyPreImeListener;)V
    .locals 0
    .param p1, "keyPreImeListener"    # Lcom/amazon/retailsearch/android/api/display/input/listeners/KeyPreImeListener;

    .prologue
    .line 266
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/ClearableAutoCompleteTextView;->keyPreImeListener:Lcom/amazon/retailsearch/android/api/display/input/listeners/KeyPreImeListener;

    .line 267
    return-void
.end method
