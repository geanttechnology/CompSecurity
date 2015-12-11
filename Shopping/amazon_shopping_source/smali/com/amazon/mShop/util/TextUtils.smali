.class public Lcom/amazon/mShop/util/TextUtils;
.super Ljava/lang/Object;
.source "TextUtils.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static fromHtmlToSpannedUsingEmbeddedBrowser(Ljava/lang/String;Z)Landroid/text/Spannable;
    .locals 10
    .param p0, "html"    # Ljava/lang/String;
    .param p1, "isMASHRequired"    # Z

    .prologue
    .line 83
    invoke-static {p0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v5

    .line 84
    .local v5, "spannedHTML":Landroid/text/Spanned;
    new-instance v4, Landroid/text/SpannableStringBuilder;

    invoke-direct {v4, v5}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 85
    .local v4, "spannableBuilder":Landroid/text/SpannableStringBuilder;
    const/4 v7, 0x0

    invoke-interface {v5}, Landroid/text/Spanned;->length()I

    move-result v8

    const-class v9, Landroid/text/style/URLSpan;

    invoke-virtual {v4, v7, v8, v9}, Landroid/text/SpannableStringBuilder;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v6

    check-cast v6, [Landroid/text/style/URLSpan;

    .line 86
    .local v6, "urls":[Landroid/text/style/URLSpan;
    move-object v0, v6

    .local v0, "arr$":[Landroid/text/style/URLSpan;
    array-length v2, v0

    .local v2, "len$":I
    const/4 v1, 0x0

    .local v1, "i$":I
    :goto_0
    if-ge v1, v2, :cond_0

    aget-object v3, v0, v1

    .line 87
    .local v3, "span":Landroid/text/style/URLSpan;
    invoke-static {v4, v3, p1}, Lcom/amazon/mShop/util/TextUtils;->makeLinkClickable(Landroid/text/SpannableStringBuilder;Landroid/text/style/URLSpan;Z)V

    .line 86
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 89
    .end local v3    # "span":Landroid/text/style/URLSpan;
    :cond_0
    return-object v4
.end method

.method public static isTextExceedMaxWidth(Ljava/lang/String;Landroid/graphics/Paint;I)Z
    .locals 3
    .param p0, "text"    # Ljava/lang/String;
    .param p1, "paint"    # Landroid/graphics/Paint;
    .param p2, "maxWidth"    # I

    .prologue
    const/4 v0, 0x0

    .line 36
    invoke-static {p0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    if-eqz p1, :cond_0

    if-gez p2, :cond_1

    .line 40
    :cond_0
    :goto_0
    return v0

    :cond_1
    invoke-virtual {p1, p0}, Landroid/graphics/Paint;->measureText(Ljava/lang/String;)F

    move-result v1

    int-to-float v2, p2

    cmpl-float v1, v1, v2

    if-lez v1, :cond_0

    const/4 v0, 0x1

    goto :goto_0
.end method

.method private static makeLinkClickable(Landroid/text/SpannableStringBuilder;Landroid/text/style/URLSpan;Z)V
    .locals 7
    .param p0, "spannableBuilder"    # Landroid/text/SpannableStringBuilder;
    .param p1, "span"    # Landroid/text/style/URLSpan;
    .param p2, "isMASHRequired"    # Z

    .prologue
    .line 46
    invoke-virtual {p0, p1}, Landroid/text/SpannableStringBuilder;->getSpanStart(Ljava/lang/Object;)I

    move-result v3

    .line 47
    .local v3, "start":I
    invoke-virtual {p0, p1}, Landroid/text/SpannableStringBuilder;->getSpanEnd(Ljava/lang/Object;)I

    move-result v1

    .line 48
    .local v1, "end":I
    invoke-virtual {p0, p1}, Landroid/text/SpannableStringBuilder;->getSpanFlags(Ljava/lang/Object;)I

    move-result v2

    .line 50
    .local v2, "flags":I
    invoke-virtual {p0, v3, v1}, Landroid/text/SpannableStringBuilder;->subSequence(II)Ljava/lang/CharSequence;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 51
    .local v4, "title":Ljava/lang/String;
    invoke-virtual {p1}, Landroid/text/style/URLSpan;->getURL()Ljava/lang/String;

    move-result-object v5

    .line 53
    .local v5, "url":Ljava/lang/String;
    if-eqz p2, :cond_0

    .line 54
    new-instance v0, Lcom/amazon/mShop/util/TextUtils$1;

    invoke-direct {v0, v5}, Lcom/amazon/mShop/util/TextUtils$1;-><init>(Ljava/lang/String;)V

    .line 72
    .local v0, "clickable":Landroid/text/style/ClickableSpan;
    :goto_0
    invoke-virtual {p0, v0, v3, v1, v2}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 73
    invoke-virtual {p0, p1}, Landroid/text/SpannableStringBuilder;->removeSpan(Ljava/lang/Object;)V

    .line 74
    return-void

    .line 62
    .end local v0    # "clickable":Landroid/text/style/ClickableSpan;
    :cond_0
    new-instance v0, Lcom/amazon/mShop/util/TextUtils$2;

    invoke-direct {v0, v5, v4}, Lcom/amazon/mShop/util/TextUtils$2;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .restart local v0    # "clickable":Landroid/text/style/ClickableSpan;
    goto :goto_0
.end method
