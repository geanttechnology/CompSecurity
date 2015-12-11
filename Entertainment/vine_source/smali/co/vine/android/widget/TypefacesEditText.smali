.class public Lco/vine/android/widget/TypefacesEditText;
.super Lco/vine/android/views/SdkEditText;
.source "TypefacesEditText.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/widget/TypefacesEditText$TypeFacesInputConnection;,
        Lco/vine/android/widget/TypefacesEditText$KeyboardListener;
    }
.end annotation


# instance fields
.field private mKeyboardListener:Lco/vine/android/widget/TypefacesEditText$KeyboardListener;

.field private mWeight:I


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 30
    invoke-direct {p0, p1}, Lco/vine/android/views/SdkEditText;-><init>(Landroid/content/Context;)V

    .line 27
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/widget/TypefacesEditText;->mKeyboardListener:Lco/vine/android/widget/TypefacesEditText$KeyboardListener;

    .line 31
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 34
    invoke-direct {p0, p1, p2}, Lco/vine/android/views/SdkEditText;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 27
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/widget/TypefacesEditText;->mKeyboardListener:Lco/vine/android/widget/TypefacesEditText$KeyboardListener;

    .line 35
    invoke-virtual {p0, p1, p2}, Lco/vine/android/widget/TypefacesEditText;->init(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 36
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 39
    invoke-direct {p0, p1, p2, p3}, Lco/vine/android/views/SdkEditText;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 27
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/widget/TypefacesEditText;->mKeyboardListener:Lco/vine/android/widget/TypefacesEditText$KeyboardListener;

    .line 40
    invoke-virtual {p0, p1, p2}, Lco/vine/android/widget/TypefacesEditText;->init(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 41
    return-void
.end method

.method static synthetic access$000(Lco/vine/android/widget/TypefacesEditText;)Lco/vine/android/widget/TypefacesEditText$KeyboardListener;
    .locals 1
    .param p0, "x0"    # Lco/vine/android/widget/TypefacesEditText;

    .prologue
    .line 25
    iget-object v0, p0, Lco/vine/android/widget/TypefacesEditText;->mKeyboardListener:Lco/vine/android/widget/TypefacesEditText$KeyboardListener;

    return-object v0
.end method


# virtual methods
.method public init(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v4, 0x0

    .line 44
    sget-object v2, Lco/vine/android/R$styleable;->VineTextView:[I

    const v3, 0x7f010047

    invoke-virtual {p1, p2, v2, v3, v4}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 46
    .local v0, "a":Landroid/content/res/TypedArray;
    const/4 v2, 0x1

    invoke-virtual {v0, v2, v4}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v1

    .line 47
    .local v1, "style":I
    const/4 v2, 0x2

    invoke-virtual {v0, v4, v2}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v2

    iput v2, p0, Lco/vine/android/widget/TypefacesEditText;->mWeight:I

    .line 48
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 49
    invoke-static {p1}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v2

    iget v3, p0, Lco/vine/android/widget/TypefacesEditText;->mWeight:I

    invoke-virtual {v2, v1, v3}, Lco/vine/android/widget/Typefaces;->getContentTypeface(II)Landroid/graphics/Typeface;

    move-result-object v2

    invoke-virtual {p0, v2, v1}, Lco/vine/android/widget/TypefacesEditText;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 50
    return-void
.end method

.method public onCreateInputConnection(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;
    .locals 3
    .param p1, "outAttrs"    # Landroid/view/inputmethod/EditorInfo;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    .line 78
    new-instance v0, Lco/vine/android/widget/TypefacesEditText$TypeFacesInputConnection;

    invoke-super {p0, p1}, Lco/vine/android/views/SdkEditText;->onCreateInputConnection(Landroid/view/inputmethod/EditorInfo;)Landroid/view/inputmethod/InputConnection;

    move-result-object v1

    const/4 v2, 0x1

    invoke-direct {v0, p0, v1, v2}, Lco/vine/android/widget/TypefacesEditText$TypeFacesInputConnection;-><init>(Lco/vine/android/widget/TypefacesEditText;Landroid/view/inputmethod/InputConnection;Z)V

    return-object v0
.end method

.method public onKeyPreIme(ILandroid/view/KeyEvent;)Z
    .locals 1
    .param p1, "keyCode"    # I
    .param p2, "keyEvent"    # Landroid/view/KeyEvent;
        .annotation build Lorg/jetbrains/annotations/NotNull;
        .end annotation
    .end param

    .prologue
    .line 63
    const/4 v0, 0x4

    if-ne p1, v0, :cond_0

    .line 64
    iget-object v0, p0, Lco/vine/android/widget/TypefacesEditText;->mKeyboardListener:Lco/vine/android/widget/TypefacesEditText$KeyboardListener;

    if-eqz v0, :cond_0

    .line 65
    iget-object v0, p0, Lco/vine/android/widget/TypefacesEditText;->mKeyboardListener:Lco/vine/android/widget/TypefacesEditText$KeyboardListener;

    invoke-interface {v0}, Lco/vine/android/widget/TypefacesEditText$KeyboardListener;->onKeyboardDismissed()V

    .line 68
    :cond_0
    invoke-super {p0, p1, p2}, Lco/vine/android/views/SdkEditText;->onKeyPreIme(ILandroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method public setKeyboardListener(Lco/vine/android/widget/TypefacesEditText$KeyboardListener;)V
    .locals 0
    .param p1, "listener"    # Lco/vine/android/widget/TypefacesEditText$KeyboardListener;

    .prologue
    .line 58
    iput-object p1, p0, Lco/vine/android/widget/TypefacesEditText;->mKeyboardListener:Lco/vine/android/widget/TypefacesEditText$KeyboardListener;

    .line 59
    return-void
.end method

.method public setTypeface(Landroid/graphics/Typeface;I)V
    .locals 2
    .param p1, "tf"    # Landroid/graphics/Typeface;
    .param p2, "style"    # I

    .prologue
    .line 54
    invoke-virtual {p0}, Lco/vine/android/widget/TypefacesEditText;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lco/vine/android/widget/Typefaces;->get(Landroid/content/Context;)Lco/vine/android/widget/Typefaces;

    move-result-object v0

    iget v1, p0, Lco/vine/android/widget/TypefacesEditText;->mWeight:I

    invoke-virtual {v0, p2, v1}, Lco/vine/android/widget/Typefaces;->getContentTypeface(II)Landroid/graphics/Typeface;

    move-result-object v0

    invoke-super {p0, v0}, Lco/vine/android/views/SdkEditText;->setTypeface(Landroid/graphics/Typeface;)V

    .line 55
    return-void
.end method
