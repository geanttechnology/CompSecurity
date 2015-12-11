.class public Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;
.super Ljava/lang/Object;
.source "CustomTypefaceTextViewDelegate.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/customtypefacelib/TextStylable;


# instance fields
.field private typefaceFamilyName:Ljava/lang/String;

.field private typefaceManager:Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;

.field private typefaceStyle:I

.field private view:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/widget/TextView;)V
    .locals 0
    .param p1, "view"    # Landroid/widget/TextView;

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 18
    iput-object p1, p0, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;->view:Landroid/widget/TextView;

    .line 19
    return-void
.end method


# virtual methods
.method public setCustomTypeface()V
    .locals 4

    .prologue
    .line 52
    iget-object v1, p0, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;->typefaceFamilyName:Ljava/lang/String;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;->typefaceFamilyName:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    .line 54
    iget-object v1, p0, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;->typefaceManager:Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;

    iget-object v2, p0, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;->typefaceFamilyName:Ljava/lang/String;

    iget v3, p0, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;->typefaceStyle:I

    invoke-virtual {v1, v2, v3}, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;->getTypeface(Ljava/lang/String;I)Landroid/graphics/Typeface;

    move-result-object v0

    .line 55
    .local v0, "typeface":Landroid/graphics/Typeface;
    if-nez v0, :cond_0

    .line 56
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "A font for the \""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;->typefaceFamilyName:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\" has not been defined."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 59
    :cond_0
    iget-object v1, p0, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;->view:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;->view:Landroid/widget/TextView;

    invoke-virtual {v2}, Landroid/widget/TextView;->getPaintFlags()I

    move-result v2

    or-int/lit16 v2, v2, 0x80

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setPaintFlags(I)V

    .line 60
    iget-object v1, p0, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;->view:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 62
    .end local v0    # "typeface":Landroid/graphics/Typeface;
    :cond_1
    return-void
.end method

.method public setTypefaceFamilyName(Ljava/lang/String;)V
    .locals 1
    .param p1, "typefaceFamilyName"    # Ljava/lang/String;

    .prologue
    .line 66
    iget-object v0, p0, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;->typefaceFamilyName:Ljava/lang/String;

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 67
    iput-object p1, p0, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;->typefaceFamilyName:Ljava/lang/String;

    .line 68
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;->setCustomTypeface()V

    .line 70
    :cond_0
    return-void
.end method

.method public setTypefaceStyle(I)V
    .locals 1
    .param p1, "style"    # I

    .prologue
    .line 74
    iget v0, p0, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;->typefaceStyle:I

    if-eq v0, p1, :cond_0

    .line 75
    iput p1, p0, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;->typefaceStyle:I

    .line 76
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;->setCustomTypeface()V

    .line 78
    :cond_0
    return-void
.end method

.method public setup(Landroid/content/Context;Landroid/util/AttributeSet;ILcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I
    .param p4, "typefaceManager"    # Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 22
    iput-object p4, p0, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;->typefaceManager:Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceManager;

    .line 24
    if-nez p4, :cond_0

    .line 25
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "A non-null TypefaceManager must be provided"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 28
    :cond_0
    sget-object v3, Lcom/comcast/cim/cmasl/customtypefacelib/R$styleable;->com_comcast_cim_android_typeface_CustomTypefaceTextView:[I

    invoke-virtual {p1, p2, v3, p3, v4}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 30
    .local v0, "a":Landroid/content/res/TypedArray;
    invoke-virtual {v0, v4}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 31
    invoke-virtual {v0, v4}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;->typefaceFamilyName:Ljava/lang/String;

    .line 35
    :cond_1
    iget-object v3, p0, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;->view:Landroid/widget/TextView;

    invoke-virtual {v3}, Landroid/widget/TextView;->getTypeface()Landroid/graphics/Typeface;

    move-result-object v2

    .line 36
    .local v2, "typeface":Landroid/graphics/Typeface;
    if-eqz v2, :cond_2

    .line 37
    invoke-virtual {v2}, Landroid/graphics/Typeface;->getStyle()I

    move-result v1

    .line 38
    .local v1, "style":I
    invoke-static {v1}, Lcom/comcast/cim/cmasl/customtypefacelib/TypefaceFamily;->getCustomStyleIdForAndroidStyle(I)I

    move-result v3

    iput v3, p0, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;->typefaceStyle:I

    .line 42
    .end local v1    # "style":I
    :cond_2
    invoke-virtual {v0, v5}, Landroid/content/res/TypedArray;->hasValue(I)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 43
    invoke-virtual {v0, v5, v4}, Landroid/content/res/TypedArray;->getInt(II)I

    move-result v3

    iput v3, p0, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;->typefaceStyle:I

    .line 46
    :cond_3
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 48
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/customtypefacelib/CustomTypefaceTextViewDelegate;->setCustomTypeface()V

    .line 49
    return-void
.end method
