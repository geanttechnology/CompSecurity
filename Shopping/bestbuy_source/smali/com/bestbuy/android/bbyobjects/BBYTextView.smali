.class public Lcom/bestbuy/android/bbyobjects/BBYTextView;
.super Landroid/widget/TextView;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/String;

.field private b:Landroid/content/Context;

.field private c:Ljava/lang/String;

.field private d:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1

    .prologue
    .line 39
    invoke-direct {p0, p1}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 25
    const-string v0, "<html><head><meta http-equiv=\"content-type\" content=\"text/html;\" charset=\"UTF-8\"><style>@font-face {font-family: \"Roboto-Bold\";src: url(\'file:///android_asset/fonts/Roboto-Bold.ttf\');}@font-face {font-family: \"Roboto-Black\";src: url(\'file:///android_asset/fonts/Roboto-Black.ttf\');}@font-face {font-family: \"Roboto-Regular\";src: url(\'file:///android_asset/fonts/Roboto-Regular.ttf\');}@font-face {font-family: \"Roboto-Light\";src: url(\'file:///android_asset/fonts/Roboto-Light.ttf\');}@font-face {font-family: \"Roboto-Light-Italic\";src: url(\'file:///android_asset/fonts/Roboto-LightItalic.ttf\');}body { font-family:\"Roboto-Regular\"} h3 { font-family:\"Roboto-Bold\"} i { font-family:\"Roboto-Light-Italic\"} u { font-family:\"Roboto-Regular\"}</style></head><body>%s</body></html>"

    iput-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->a:Ljava/lang/String;

    .line 40
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->b:Landroid/content/Context;

    .line 41
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1

    .prologue
    .line 44
    invoke-direct {p0, p1, p2}, Landroid/widget/TextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 25
    const-string v0, "<html><head><meta http-equiv=\"content-type\" content=\"text/html;\" charset=\"UTF-8\"><style>@font-face {font-family: \"Roboto-Bold\";src: url(\'file:///android_asset/fonts/Roboto-Bold.ttf\');}@font-face {font-family: \"Roboto-Black\";src: url(\'file:///android_asset/fonts/Roboto-Black.ttf\');}@font-face {font-family: \"Roboto-Regular\";src: url(\'file:///android_asset/fonts/Roboto-Regular.ttf\');}@font-face {font-family: \"Roboto-Light\";src: url(\'file:///android_asset/fonts/Roboto-Light.ttf\');}@font-face {font-family: \"Roboto-Light-Italic\";src: url(\'file:///android_asset/fonts/Roboto-LightItalic.ttf\');}body { font-family:\"Roboto-Regular\"} h3 { font-family:\"Roboto-Bold\"} i { font-family:\"Roboto-Light-Italic\"} u { font-family:\"Roboto-Regular\"}</style></head><body>%s</body></html>"

    iput-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->a:Ljava/lang/String;

    .line 45
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->b:Landroid/content/Context;

    .line 46
    invoke-direct {p0, p1, p2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->a(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 47
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 1

    .prologue
    .line 50
    invoke-direct {p0, p1, p2, p3}, Landroid/widget/TextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 25
    const-string v0, "<html><head><meta http-equiv=\"content-type\" content=\"text/html;\" charset=\"UTF-8\"><style>@font-face {font-family: \"Roboto-Bold\";src: url(\'file:///android_asset/fonts/Roboto-Bold.ttf\');}@font-face {font-family: \"Roboto-Black\";src: url(\'file:///android_asset/fonts/Roboto-Black.ttf\');}@font-face {font-family: \"Roboto-Regular\";src: url(\'file:///android_asset/fonts/Roboto-Regular.ttf\');}@font-face {font-family: \"Roboto-Light\";src: url(\'file:///android_asset/fonts/Roboto-Light.ttf\');}@font-face {font-family: \"Roboto-Light-Italic\";src: url(\'file:///android_asset/fonts/Roboto-LightItalic.ttf\');}body { font-family:\"Roboto-Regular\"} h3 { font-family:\"Roboto-Bold\"} i { font-family:\"Roboto-Light-Italic\"} u { font-family:\"Roboto-Regular\"}</style></head><body>%s</body></html>"

    iput-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->a:Ljava/lang/String;

    .line 51
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->b:Landroid/content/Context;

    .line 52
    invoke-direct {p0, p1, p2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->a(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 53
    return-void
.end method

.method private a(Ljava/lang/String;)I
    .locals 5

    .prologue
    const v1, 0x7f080024

    const v2, 0x7f080022

    const v0, 0x7f080021

    .line 165
    const/4 v3, 0x0

    .line 166
    iget-object v4, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->b:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4, v0}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 180
    :cond_0
    :goto_0
    return v0

    .line 168
    :cond_1
    iget-object v4, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->b:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_2

    move v0, v1

    .line 169
    goto :goto_0

    .line 170
    :cond_2
    iget-object v4, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->b:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p1, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_3

    move v0, v2

    .line 171
    goto :goto_0

    .line 172
    :cond_3
    const-string v4, "Roboto-Black"

    invoke-virtual {p1, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 174
    const-string v0, "Roboto-Regular"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_4

    move v0, v1

    .line 175
    goto :goto_0

    .line 176
    :cond_4
    const-string v0, "Roboto-LightItalic"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 177
    const v0, 0x7f080023

    goto :goto_0

    .line 178
    :cond_5
    const-string v0, "Roboto-Light"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_6

    move v0, v2

    .line 179
    goto :goto_0

    :cond_6
    move v0, v3

    goto :goto_0
.end method

.method private a(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 4

    .prologue
    .line 126
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->b:Landroid/content/Context;

    sget-object v1, Lcom/bestbuy/android/R$styleable;->BBYTextView:[I

    invoke-virtual {v0, p2, v1}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 127
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->c:Ljava/lang/String;

    .line 128
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/content/res/TypedArray;->getString(I)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->d:Ljava/lang/String;

    .line 129
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->b:Landroid/content/Context;

    iget-object v2, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->c:Ljava/lang/String;

    iget-object v3, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->d:Ljava/lang/String;

    invoke-virtual {p0, v1, v2, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z

    .line 130
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 131
    return-void
.end method

.method private a(Landroid/content/Context;Lcom/bestbuy/android/bbyobjects/BBYTextView;Ljava/lang/String;)V
    .locals 8

    .prologue
    const/4 v1, -0x1

    .line 65
    const-string v0, ""

    invoke-virtual {p3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 69
    :try_start_0
    const-string v0, "<span class=\'bold\'>"

    invoke-virtual {p3, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 70
    const-string v0, "<span class=\'bold\'>"

    invoke-virtual {p3, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    .line 71
    const-string v0, "<span class=\'bold\'>"

    const-string v3, ""

    invoke-virtual {p3, v0, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v3

    .line 72
    const-string v0, "</span>"

    invoke-virtual {v3, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    .line 73
    const-string v4, "</span>"

    const-string v5, ""

    invoke-virtual {v3, v4, v5}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v3

    .line 78
    :goto_0
    new-instance v4, Landroid/text/SpannableString;

    invoke-direct {v4, v3}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 79
    if-ne v2, v1, :cond_2

    .line 80
    new-instance v0, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;

    const/4 v1, 0x0

    const v2, 0x7f080021

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-static {p1, v2, v5}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v2

    invoke-direct {v0, p1, v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;-><init>(Landroid/content/Context;ILandroid/graphics/Typeface;)V

    const/4 v1, 0x0

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v2

    const/16 v3, 0x21

    invoke-virtual {v4, v0, v1, v2, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 110
    :goto_1
    sget-object v0, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-virtual {p2, v4, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 115
    :cond_0
    :goto_2
    return-void

    .line 75
    :cond_1
    const-string v0, "\\n"

    const-string v2, " "

    invoke-virtual {p3, v0, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    const-string v2, "\n"

    const-string v3, " "

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    const-string v2, "\t"

    const-string v3, " "

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    .line 76
    const-string v0, " "

    invoke-virtual {v2, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    move-object v3, v2

    move v2, v0

    move v0, v1

    goto :goto_0

    .line 86
    :cond_2
    if-nez v2, :cond_3

    .line 87
    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 88
    new-instance v3, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;

    const/4 v5, 0x0

    const v6, 0x7f080021

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    invoke-static {p1, v6, v7}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v6

    invoke-direct {v3, p1, v5, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;-><init>(Landroid/content/Context;ILandroid/graphics/Typeface;)V

    const/16 v5, 0x21

    invoke-virtual {v4, v3, v2, v0, v5}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 92
    new-instance v2, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;

    const/4 v3, 0x0

    const v5, 0x7f080024

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-static {p1, v5, v6}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v5

    invoke-direct {v2, p1, v3, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;-><init>(Landroid/content/Context;ILandroid/graphics/Typeface;)V

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    const/16 v3, 0x21

    invoke-virtual {v4, v2, v0, v1, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 111
    :catch_0
    move-exception v0

    .line 112
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_2

    .line 98
    :cond_3
    :try_start_1
    new-instance v0, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;

    const/4 v1, 0x0

    const v5, 0x7f080024

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-static {p1, v5, v6}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v5

    invoke-direct {v0, p1, v1, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;-><init>(Landroid/content/Context;ILandroid/graphics/Typeface;)V

    const/4 v1, 0x0

    const/16 v5, 0x21

    invoke-virtual {v4, v0, v1, v2, v5}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 103
    new-instance v0, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;

    const/4 v1, 0x0

    const v5, 0x7f080021

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-static {p1, v5, v6}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v5

    invoke-direct {v0, p1, v1, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;-><init>(Landroid/content/Context;ILandroid/graphics/Typeface;)V

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v1

    const/16 v3, 0x21

    invoke-virtual {v4, v0, v2, v1, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_1
.end method

.method private b(Landroid/content/Context;Lcom/bestbuy/android/bbyobjects/BBYTextView;Ljava/lang/String;)V
    .locals 12

    .prologue
    const/16 v11, 0x21

    const/4 v1, 0x0

    .line 184
    const-string v0, ":"

    invoke-virtual {p3, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 185
    const/4 v0, 0x0

    move-object v2, v0

    move v0, v1

    .line 187
    :goto_0
    array-length v4, v3

    if-ge v0, v4, :cond_3

    .line 188
    aget-object v4, v3, v0

    .line 189
    const-string v5, "<span class=\'bold\'>"

    invoke-virtual {v4, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 190
    const-string v2, "<span class=\'bold\'>"

    invoke-virtual {v4, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v5

    .line 191
    const-string v2, "<span class=\'bold\'>"

    const-string v6, ""

    invoke-virtual {v4, v2, v6}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    const-string v4, "</span>"

    const-string v6, ""

    invoke-virtual {v2, v4, v6}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v4

    .line 193
    new-instance v2, Landroid/text/SpannableString;

    invoke-direct {v2, v4}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 194
    const/4 v6, -0x1

    if-eq v5, v6, :cond_0

    .line 195
    new-instance v5, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;

    const v6, 0x7f080021

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    invoke-static {p1, v6, v7}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v6

    invoke-direct {v5, p1, v1, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;-><init>(Landroid/content/Context;ILandroid/graphics/Typeface;)V

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v6

    invoke-virtual {v2, v5, v1, v6, v11}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 201
    new-instance v5, Landroid/text/style/ForegroundColorSpan;

    const v6, -0xbbbbbc

    invoke-direct {v5, v6}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    invoke-virtual {v2, v5, v1, v4, v11}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 223
    :cond_0
    :goto_1
    if-nez v0, :cond_2

    .line 224
    invoke-virtual {p2, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 187
    :goto_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 204
    :cond_1
    const-string v5, "</font>"

    invoke-virtual {v4, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 205
    const-string v2, "</font>"

    const-string v5, ""

    invoke-virtual {v4, v2, v5}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    const-string v4, "<font color="

    const-string v5, ""

    invoke-virtual {v2, v4, v5}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    .line 206
    const-string v4, "#"

    invoke-virtual {v2, v4}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v4

    add-int/lit8 v4, v4, 0x1

    const-string v5, "\">"

    invoke-virtual {v2, v5}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v5

    invoke-virtual {v2, v4, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v4

    .line 208
    const-string v5, ">"

    invoke-virtual {v2, v5}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v5

    add-int/lit8 v5, v5, 0x1

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v6

    invoke-virtual {v2, v5, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v5

    .line 209
    new-instance v2, Landroid/text/SpannableString;

    invoke-static {v5}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v6

    invoke-direct {v2, v6}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 210
    const/16 v6, 0x10

    invoke-static {v4, v6}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;I)I

    move-result v4

    .line 211
    shr-int/lit8 v6, v4, 0x10

    and-int/lit16 v6, v6, 0xff

    .line 212
    shr-int/lit8 v7, v4, 0x8

    and-int/lit16 v7, v7, 0xff

    .line 213
    shr-int/lit8 v4, v4, 0x0

    and-int/lit16 v4, v4, 0xff

    .line 215
    new-instance v8, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;

    const v9, 0x7f080024

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    invoke-static {p1, v9, v10}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v9

    invoke-direct {v8, p1, v1, v9}, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;-><init>(Landroid/content/Context;ILandroid/graphics/Typeface;)V

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v9

    invoke-virtual {v2, v8, v1, v9, v11}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 220
    new-instance v8, Landroid/text/style/ForegroundColorSpan;

    invoke-static {v6, v7, v4}, Landroid/graphics/Color;->rgb(III)I

    move-result v4

    invoke-direct {v8, v4}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v4

    invoke-virtual {v2, v8, v1, v4, v11}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    goto/16 :goto_1

    .line 226
    :cond_2
    invoke-virtual {p2, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->append(Ljava/lang/CharSequence;)V

    goto/16 :goto_2

    .line 228
    :cond_3
    return-void
.end method

.method private c(Landroid/content/Context;Lcom/bestbuy/android/bbyobjects/BBYTextView;Ljava/lang/String;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 232
    const-string v0, ""

    invoke-virtual {p3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 233
    new-instance v0, Landroid/text/SpannableString;

    invoke-direct {v0, p3}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 234
    new-instance v1, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;

    const v2, 0x7f080024

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-static {p1, v2, v3}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v2

    invoke-direct {v1, p1, v4, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;-><init>(Landroid/content/Context;ILandroid/graphics/Typeface;)V

    invoke-virtual {v0}, Landroid/text/SpannableString;->length()I

    move-result v2

    const/16 v3, 0x21

    invoke-virtual {v0, v1, v4, v2, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 239
    new-instance v1, Landroid/text/style/StyleSpan;

    const/4 v2, 0x2

    invoke-direct {v1, v2}, Landroid/text/style/StyleSpan;-><init>(I)V

    invoke-virtual {v0}, Landroid/text/SpannableString;->length()I

    move-result v2

    invoke-virtual {v0, v1, v4, v2, v4}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 240
    sget-object v1, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-virtual {p2, v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 242
    :cond_0
    return-void
.end method

.method private d(Landroid/content/Context;Lcom/bestbuy/android/bbyobjects/BBYTextView;Ljava/lang/String;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 245
    const-string v0, ""

    invoke-virtual {p3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 246
    new-instance v0, Landroid/text/SpannableString;

    invoke-direct {v0, p3}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 247
    new-instance v1, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;

    const v2, 0x7f080024

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-static {p1, v2, v3}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v2

    invoke-direct {v1, p1, v4, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;-><init>(Landroid/content/Context;ILandroid/graphics/Typeface;)V

    invoke-virtual {v0}, Landroid/text/SpannableString;->length()I

    move-result v2

    const/16 v3, 0x21

    invoke-virtual {v0, v1, v4, v2, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 252
    new-instance v1, Landroid/text/style/UnderlineSpan;

    invoke-direct {v1}, Landroid/text/style/UnderlineSpan;-><init>()V

    invoke-virtual {v0}, Landroid/text/SpannableString;->length()I

    move-result v2

    invoke-virtual {v0, v1, v4, v2, v4}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 253
    sget-object v1, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-virtual {p2, v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 255
    :cond_0
    return-void
.end method

.method private e(Landroid/content/Context;Lcom/bestbuy/android/bbyobjects/BBYTextView;Ljava/lang/String;)V
    .locals 8

    .prologue
    const/16 v7, 0x21

    const/4 v6, 0x0

    .line 258
    const-string v0, ""

    invoke-virtual {p3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 259
    const-string v0, "\\n"

    const-string v1, "\n"

    invoke-virtual {p3, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 260
    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    .line 261
    new-instance v2, Landroid/text/SpannableString;

    invoke-direct {v2, v0}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 262
    new-instance v3, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;

    const v4, 0x7f080024

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-static {p1, v4, v5}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v4

    invoke-direct {v3, p1, v6, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;-><init>(Landroid/content/Context;ILandroid/graphics/Typeface;)V

    invoke-virtual {v2, v3, v6, v1, v7}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 267
    new-instance v3, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;

    const v4, 0x7f080021

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-static {p1, v4, v5}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v4

    invoke-direct {v3, p1, v6, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;-><init>(Landroid/content/Context;ILandroid/graphics/Typeface;)V

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    invoke-virtual {v2, v3, v1, v0, v7}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 272
    sget-object v0, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-virtual {p2, v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 274
    :cond_0
    return-void
.end method

.method private f(Landroid/content/Context;Lcom/bestbuy/android/bbyobjects/BBYTextView;Ljava/lang/String;)V
    .locals 8

    .prologue
    const v7, 0x7f080024

    const/16 v6, 0x21

    const/4 v5, 0x0

    .line 278
    const-string v0, ""

    invoke-virtual {p3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 279
    const-string v0, "\\n"

    const-string v1, "\n"

    invoke-virtual {p3, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 280
    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    .line 281
    new-instance v2, Landroid/text/SpannableString;

    invoke-direct {v2, v0}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 282
    new-instance v3, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-static {p1, v7, v4}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v4

    invoke-direct {v3, p1, v5, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;-><init>(Landroid/content/Context;ILandroid/graphics/Typeface;)V

    invoke-virtual {v2, v3, v5, v1, v6}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 287
    new-instance v3, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;

    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-static {p1, v7, v4}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v4

    invoke-direct {v3, p1, v5, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;-><init>(Landroid/content/Context;ILandroid/graphics/Typeface;)V

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    invoke-virtual {v2, v3, v1, v0, v6}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 292
    sget-object v0, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-virtual {p2, v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 294
    :cond_0
    return-void
.end method


# virtual methods
.method public a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 3

    .prologue
    .line 134
    .line 135
    const/4 v0, 0x0

    .line 136
    if-eqz p3, :cond_6

    .line 137
    const-string v1, "NEW_LINE_STYLE"

    invoke-virtual {p3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 138
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->b:Landroid/content/Context;

    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    invoke-interface {v2}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v1, p0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->e(Landroid/content/Context;Lcom/bestbuy/android/bbyobjects/BBYTextView;Ljava/lang/String;)V

    .line 160
    :cond_0
    :goto_0
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 161
    const/4 v0, 0x1

    return v0

    .line 139
    :cond_1
    const-string v1, "REGULAR_BOLD_STYLE"

    invoke-virtual {p3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 140
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->b:Landroid/content/Context;

    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    invoke-interface {v2}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v1, p0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->a(Landroid/content/Context;Lcom/bestbuy/android/bbyobjects/BBYTextView;Ljava/lang/String;)V

    goto :goto_0

    .line 141
    :cond_2
    const-string v1, "MULTI_SPAN_STYLE"

    invoke-virtual {p3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 142
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->b:Landroid/content/Context;

    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    invoke-interface {v2}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v1, p0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->b(Landroid/content/Context;Lcom/bestbuy/android/bbyobjects/BBYTextView;Ljava/lang/String;)V

    goto :goto_0

    .line 143
    :cond_3
    const-string v1, "NEW_LINE_STYLE_WITH_REG"

    invoke-virtual {p3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 144
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->b:Landroid/content/Context;

    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    invoke-interface {v2}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v1, p0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->f(Landroid/content/Context;Lcom/bestbuy/android/bbyobjects/BBYTextView;Ljava/lang/String;)V

    goto :goto_0

    .line 145
    :cond_4
    const-string v1, "REGULAR_ITALIC_STYLE"

    invoke-virtual {p3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 146
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->b:Landroid/content/Context;

    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    invoke-interface {v2}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v1, p0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->c(Landroid/content/Context;Lcom/bestbuy/android/bbyobjects/BBYTextView;Ljava/lang/String;)V

    goto :goto_0

    .line 147
    :cond_5
    const-string v1, "REGULAR_UNDERLINE_STYLE"

    invoke-virtual {p3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 148
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->b:Landroid/content/Context;

    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v2

    invoke-interface {v2}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v1, p0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->d(Landroid/content/Context;Lcom/bestbuy/android/bbyobjects/BBYTextView;Ljava/lang/String;)V

    goto :goto_0

    .line 150
    :cond_6
    if-eqz p2, :cond_0

    .line 151
    invoke-direct {p0, p2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->a(Ljava/lang/String;)I

    move-result v0

    .line 152
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->b:Landroid/content/Context;

    iget-object v2, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->b:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-static {v1, v0, v2}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v0

    .line 153
    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-interface {v1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v1

    .line 154
    if-eqz v1, :cond_0

    .line 155
    const-string v2, "<body>"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 156
    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    sget-object v2, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-virtual {p0, v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    goto/16 :goto_0
.end method

.method protected onMeasure(II)V
    .locals 2

    .prologue
    .line 119
    invoke-super {p0, p1, p2}, Landroid/widget/TextView;->onMeasure(II)V

    .line 120
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->d:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->d:Ljava/lang/String;

    const-string v1, "NEW_LINE_STYLE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-interface {v0}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 122
    :cond_1
    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getMeasuredWidth()I

    move-result v0

    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getMeasuredHeight()I

    move-result v1

    add-int/lit8 v1, v1, 0x1e

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setMeasuredDimension(II)V

    .line 123
    :cond_2
    return-void
.end method

.method public setText(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 56
    invoke-super {p0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 57
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->d:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 58
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->d:Ljava/lang/String;

    const-string v1, "REGULAR_BOLD_STYLE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 59
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->b:Landroid/content/Context;

    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-interface {v1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v0, p0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->a(Landroid/content/Context;Lcom/bestbuy/android/bbyobjects/BBYTextView;Ljava/lang/String;)V

    .line 62
    :cond_0
    return-void
.end method

.method public setTextWithBoldness(Ljava/lang/String;)V
    .locals 14

    .prologue
    const/16 v13, 0x21

    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 297
    if-eqz p1, :cond_2

    .line 298
    const-string v0, "<span class=\'bold\'>"

    invoke-virtual {p1, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    .line 300
    const-string v0, "<span class=\'bold\'>"

    invoke-virtual {p1, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    move v0, v1

    .line 303
    :goto_0
    array-length v5, v4

    move v3, v1

    :goto_1
    if-ge v3, v5, :cond_2

    aget-object v6, v4, v3

    .line 304
    if-eqz v0, :cond_1

    .line 306
    new-instance v0, Landroid/text/SpannableString;

    invoke-static {v6}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v6

    invoke-direct {v0, v6}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->append(Ljava/lang/CharSequence;)V

    move v0, v1

    .line 303
    :cond_0
    :goto_2
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 308
    :cond_1
    const-string v7, "</span>"

    invoke-virtual {v6, v7}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v6

    .line 309
    array-length v7, v6

    if-lez v7, :cond_0

    .line 310
    new-instance v7, Landroid/text/SpannableString;

    aget-object v8, v6, v1

    invoke-static {v8}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v8

    invoke-direct {v7, v8}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 311
    new-instance v8, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;

    iget-object v9, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->b:Landroid/content/Context;

    iget-object v10, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->b:Landroid/content/Context;

    const v11, 0x7f080021

    iget-object v12, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->b:Landroid/content/Context;

    invoke-virtual {v12}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v12

    invoke-static {v10, v11, v12}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v10

    invoke-direct {v8, v9, v1, v10}, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;-><init>(Landroid/content/Context;ILandroid/graphics/Typeface;)V

    invoke-virtual {v7}, Landroid/text/SpannableString;->length()I

    move-result v9

    invoke-virtual {v7, v8, v1, v9, v13}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 313
    invoke-virtual {p0, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->append(Ljava/lang/CharSequence;)V

    .line 314
    array-length v7, v6

    if-le v7, v2, :cond_0

    .line 315
    new-instance v7, Landroid/text/SpannableString;

    aget-object v6, v6, v2

    invoke-static {v6}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v6

    invoke-direct {v7, v6}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 316
    new-instance v6, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;

    iget-object v8, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->b:Landroid/content/Context;

    iget-object v9, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->b:Landroid/content/Context;

    const v10, 0x7f080024

    iget-object v11, p0, Lcom/bestbuy/android/bbyobjects/BBYTextView;->b:Landroid/content/Context;

    invoke-virtual {v11}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    invoke-static {v9, v10, v11}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v9

    invoke-direct {v6, v8, v1, v9}, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;-><init>(Landroid/content/Context;ILandroid/graphics/Typeface;)V

    invoke-virtual {v7}, Landroid/text/SpannableString;->length()I

    move-result v8

    invoke-virtual {v7, v6, v1, v8, v13}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 323
    invoke-virtual {p0, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->append(Ljava/lang/CharSequence;)V

    goto :goto_2

    .line 329
    :cond_2
    return-void

    :cond_3
    move v0, v2

    goto :goto_0
.end method
