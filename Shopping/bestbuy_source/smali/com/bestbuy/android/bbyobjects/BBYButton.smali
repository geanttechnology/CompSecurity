.class public Lcom/bestbuy/android/bbyobjects/BBYButton;
.super Landroid/widget/Button;
.source "SourceFile"


# instance fields
.field private a:Landroid/graphics/Typeface;

.field private b:Landroid/content/Context;

.field private c:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2

    .prologue
    .line 18
    invoke-direct {p0, p1, p2}, Landroid/widget/Button;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 15
    const/4 v0, -0x1

    iput v0, p0, Lcom/bestbuy/android/bbyobjects/BBYButton;->c:I

    .line 19
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/BBYButton;->b:Landroid/content/Context;

    .line 21
    :try_start_0
    sget-object v0, Lcom/bestbuy/android/R$styleable;->BBYTextView:[I

    invoke-virtual {p1, p2, v0}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 22
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 23
    invoke-direct {p0, v0}, Lcom/bestbuy/android/bbyobjects/BBYButton;->a(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/bestbuy/android/bbyobjects/BBYButton;->c:I

    .line 24
    iget v0, p0, Lcom/bestbuy/android/bbyobjects/BBYButton;->c:I

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-static {p1, v0, v1}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYButton;->a:Landroid/graphics/Typeface;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 28
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYButton;->a:Landroid/graphics/Typeface;

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setTypeface(Landroid/graphics/Typeface;)V

    .line 29
    return-void

    .line 25
    :catch_0
    move-exception v0

    .line 26
    const v0, 0x7f080021

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-static {p1, v0, v1}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYButton;->a:Landroid/graphics/Typeface;

    goto :goto_0
.end method

.method private a(Ljava/lang/String;)I
    .locals 5

    .prologue
    const v1, 0x7f080024

    const v2, 0x7f080022

    const v0, 0x7f080021

    .line 32
    const/4 v3, 0x0

    .line 33
    iget-object v4, p0, Lcom/bestbuy/android/bbyobjects/BBYButton;->b:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 47
    :cond_0
    :goto_0
    return v0

    .line 35
    :cond_1
    iget-object v4, p0, Lcom/bestbuy/android/bbyobjects/BBYButton;->b:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_2

    move v0, v1

    .line 36
    goto :goto_0

    .line 37
    :cond_2
    iget-object v4, p0, Lcom/bestbuy/android/bbyobjects/BBYButton;->b:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_3

    move v0, v2

    .line 38
    goto :goto_0

    .line 39
    :cond_3
    const-string v4, "Roboto-Black"

    invoke-virtual {p1, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 41
    const-string v0, "Roboto-Regular"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_4

    move v0, v1

    .line 42
    goto :goto_0

    .line 43
    :cond_4
    const-string v0, "Roboto-LightItalic"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 44
    const v0, 0x7f080023

    goto :goto_0

    .line 45
    :cond_5
    const-string v0, "Roboto-Light"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_6

    move v0, v2

    .line 46
    goto :goto_0

    :cond_6
    move v0, v3

    goto :goto_0
.end method
