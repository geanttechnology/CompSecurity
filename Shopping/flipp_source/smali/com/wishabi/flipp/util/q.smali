.class public final Lcom/wishabi/flipp/util/q;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static final a:Lb/a/a/d/d;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 33
    invoke-static {}, Lb/a/a/d/aa;->a()Lb/a/a/d/d;

    move-result-object v0

    sput-object v0, Lcom/wishabi/flipp/util/q;->a:Lb/a/a/d/d;

    return-void
.end method

.method public static a(Ljava/lang/String;Z)Landroid/text/Spanned;
    .locals 7

    .prologue
    .line 239
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v0

    .line 240
    const-string v1, "en_US"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    const-string v1, "es_US"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    const-string v1, "en_CA"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    const-string v1, "fr_CA"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 242
    new-instance v0, Landroid/text/SpannedString;

    invoke-direct {v0, p0}, Landroid/text/SpannedString;-><init>(Ljava/lang/CharSequence;)V

    .line 306
    :cond_0
    :goto_0
    return-object v0

    .line 244
    :cond_1
    const-string v1, "fr_CA"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    .line 247
    :try_start_0
    new-instance v0, Ljava/text/DecimalFormatSymbols;

    invoke-direct {v0}, Ljava/text/DecimalFormatSymbols;-><init>()V

    .line 248
    const/16 v2, 0x2e

    invoke-virtual {v0, v2}, Ljava/text/DecimalFormatSymbols;->setDecimalSeparator(C)V

    .line 249
    const/16 v2, 0x2e

    invoke-virtual {v0, v2}, Ljava/text/DecimalFormatSymbols;->setMonetaryDecimalSeparator(C)V

    .line 251
    new-instance v2, Ljava/text/DecimalFormat;

    invoke-direct {v2}, Ljava/text/DecimalFormat;-><init>()V

    .line 252
    invoke-virtual {v2, v0}, Ljava/text/DecimalFormat;->setDecimalFormatSymbols(Ljava/text/DecimalFormatSymbols;)V

    .line 253
    const/4 v0, 0x1

    invoke-virtual {v2, v0}, Ljava/text/DecimalFormat;->setParseBigDecimal(Z)V

    .line 255
    invoke-virtual {v2, p0}, Ljava/text/DecimalFormat;->parse(Ljava/lang/String;)Ljava/lang/Number;

    move-result-object v0

    check-cast v0, Ljava/math/BigDecimal;

    .line 256
    new-instance v2, Ljava/math/BigDecimal;

    const/16 v3, 0x64

    invoke-direct {v2, v3}, Ljava/math/BigDecimal;-><init>(I)V

    .line 257
    invoke-virtual {v0, v2}, Ljava/math/BigDecimal;->multiply(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;

    move-result-object v0

    .line 258
    invoke-virtual {v0, v2}, Ljava/math/BigDecimal;->remainder(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;

    move-result-object v3

    .line 259
    invoke-virtual {v0, v2}, Ljava/math/BigDecimal;->divideToIntegralValue(Ljava/math/BigDecimal;)Ljava/math/BigDecimal;

    move-result-object v2

    .line 261
    new-instance v4, Ljava/text/DecimalFormat;

    invoke-direct {v4}, Ljava/text/DecimalFormat;-><init>()V

    .line 262
    const/4 v0, 0x2

    invoke-virtual {v4, v0}, Ljava/text/DecimalFormat;->setMinimumIntegerDigits(I)V

    .line 264
    new-instance v5, Ljava/text/DecimalFormat;

    invoke-direct {v5}, Ljava/text/DecimalFormat;-><init>()V

    .line 265
    const/4 v0, 0x3

    invoke-virtual {v5, v0}, Ljava/text/DecimalFormat;->setGroupingSize(I)V

    .line 266
    const/4 v0, 0x1

    invoke-virtual {v5, v0}, Ljava/text/DecimalFormat;->setGroupingUsed(Z)V

    .line 269
    if-eqz v1, :cond_2

    .line 270
    new-instance v0, Landroid/text/SpannableStringBuilder;

    invoke-direct {v0}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 274
    :goto_1
    invoke-virtual {v2}, Ljava/math/BigDecimal;->toBigIntegerExact()Ljava/math/BigInteger;

    move-result-object v2

    invoke-virtual {v5, v2}, Ljava/text/DecimalFormat;->format(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 276
    if-eqz p1, :cond_3

    .line 277
    invoke-virtual {v0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v2

    .line 278
    invoke-virtual {v3}, Ljava/math/BigDecimal;->toBigIntegerExact()Ljava/math/BigInteger;

    move-result-object v3

    invoke-virtual {v4, v3}, Ljava/text/DecimalFormat;->format(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 279
    invoke-virtual {v0}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v3

    .line 280
    new-instance v4, Lcom/wishabi/flipp/util/StringHelper$1;

    invoke-direct {v4}, Lcom/wishabi/flipp/util/StringHelper$1;-><init>()V

    const/16 v5, 0x21

    invoke-virtual {v0, v4, v2, v3, v5}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 298
    :goto_2
    if-eqz v1, :cond_0

    .line 299
    const-string v2, "$"

    invoke-virtual {v0, v2}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    :try_end_0
    .catch Ljava/text/ParseException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/ArithmeticException; {:try_start_0 .. :try_end_0} :catch_1

    goto/16 :goto_0

    .line 303
    :catch_0
    move-exception v0

    :goto_3
    if-eqz v1, :cond_4

    .line 304
    new-instance v0, Landroid/text/SpannedString;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "$"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/text/SpannedString;-><init>(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 272
    :cond_2
    :try_start_1
    new-instance v0, Landroid/text/SpannableStringBuilder;

    const-string v6, "$"

    invoke-direct {v0, v6}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    goto :goto_1

    .line 303
    :catch_1
    move-exception v0

    goto :goto_3

    .line 294
    :cond_3
    const-string v2, "."

    invoke-virtual {v0, v2}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 295
    invoke-virtual {v3}, Ljava/math/BigDecimal;->toBigIntegerExact()Ljava/math/BigInteger;

    move-result-object v2

    invoke-virtual {v4, v2}, Ljava/text/DecimalFormat;->format(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;
    :try_end_1
    .catch Ljava/text/ParseException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/ArithmeticException; {:try_start_1 .. :try_end_1} :catch_1

    goto :goto_2

    .line 306
    :cond_4
    new-instance v0, Landroid/text/SpannedString;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "$"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/text/SpannedString;-><init>(Ljava/lang/CharSequence;)V

    goto/16 :goto_0
.end method

.method public static a()Ljava/lang/String;
    .locals 4

    .prologue
    const/4 v0, 0x0

    const v3, 0x7f0e00bc

    .line 198
    invoke-static {}, Lcom/wishabi/flipp/app/FlippApplication;->b()Landroid/content/Context;

    move-result-object v1

    .line 199
    if-nez v1, :cond_0

    .line 210
    :goto_0
    return-object v0

    .line 202
    :cond_0
    invoke-static {v0}, Lcom/wishabi/flipp/util/k;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 204
    invoke-static {v0}, Lcom/wishabi/flipp/util/k;->b(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 205
    invoke-virtual {v1, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 207
    :cond_1
    invoke-static {v0}, Lcom/wishabi/flipp/util/k;->c(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 208
    const v0, 0x7f0e015c

    invoke-virtual {v1, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 210
    :cond_2
    invoke-virtual {v1, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static a(D)Ljava/lang/String;
    .locals 2

    .prologue
    .line 234
    invoke-static {p0, p1}, Ljava/lang/Double;->toString(D)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/wishabi/flipp/util/q;->a(Ljava/lang/String;Z)Landroid/text/Spanned;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static a(F)Ljava/lang/String;
    .locals 2

    .prologue
    .line 230
    invoke-static {p0}, Ljava/lang/Float;->toString(F)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-static {v0, v1}, Lcom/wishabi/flipp/util/q;->a(Ljava/lang/String;Z)Landroid/text/Spanned;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static a(Ljava/lang/String;)Ljava/lang/String;
    .locals 7

    .prologue
    const/4 v6, 0x1

    const/4 v1, 0x0

    .line 37
    const-string v0, " "

    invoke-virtual {p0, v0}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 38
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    move v0, v1

    .line 39
    :goto_0
    array-length v4, v2

    if-ge v0, v4, :cond_2

    .line 40
    aget-object v4, v2, v0

    .line 41
    invoke-virtual {v4}, Ljava/lang/String;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_1

    .line 42
    invoke-virtual {v4, v1}, Ljava/lang/String;->charAt(I)C

    move-result v5

    invoke-static {v5}, Ljava/lang/Character;->toUpperCase(C)C

    move-result v5

    invoke-virtual {v3, v5}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 44
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    if-le v4, v6, :cond_0

    .line 45
    aget-object v4, v2, v0

    invoke-virtual {v4, v6}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 47
    :cond_0
    array-length v4, v2

    add-int/lit8 v4, v4, -0x1

    if-ge v0, v4, :cond_1

    .line 48
    const/16 v4, 0x20

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(C)Ljava/lang/StringBuilder;

    .line 39
    :cond_1
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 50
    :cond_2
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static a(Ljava/lang/String;ILjava/lang/String;)Ljava/lang/String;
    .locals 4

    .prologue
    .line 54
    const-string v1, ""

    .line 55
    const/4 v0, 0x1

    move v3, v0

    move-object v0, v1

    move v1, v3

    :goto_0
    if-gt v1, p1, :cond_1

    .line 56
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 57
    if-ge v1, p1, :cond_0

    .line 58
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 55
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 60
    :cond_1
    return-object v0
.end method

.method public static a(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 7

    .prologue
    .line 340
    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 341
    :cond_0
    const/4 v0, 0x0

    .line 358
    :goto_0
    return-object v0

    .line 343
    :cond_1
    invoke-static {}, Lb/a/a/d/aa;->a()Lb/a/a/d/d;

    move-result-object v0

    .line 344
    invoke-virtual {v0, p0}, Lb/a/a/d/d;->a(Ljava/lang/String;)Lb/a/a/b;

    move-result-object v1

    .line 345
    invoke-virtual {v0, p1}, Lb/a/a/d/d;->a(Ljava/lang/String;)Lb/a/a/b;

    move-result-object v2

    .line 347
    invoke-static {v2, v1}, Lb/a/a/ad;->a(Lb/a/a/z;Lb/a/a/z;)Lb/a/a/ad;

    move-result-object v0

    iget v0, v0, Lb/a/a/a/f;->p:I

    .line 350
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v3

    sget-object v4, Ljava/util/Locale;->CANADA_FRENCH:Ljava/util/Locale;

    invoke-virtual {v3, v4}, Ljava/util/Locale;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 351
    if-eqz v0, :cond_2

    const-string v0, "yyyy-MM-dd"

    .line 355
    :goto_1
    invoke-static {v0}, Lb/a/a/d/a;->a(Ljava/lang/String;)Lb/a/a/d/d;

    move-result-object v0

    sget-object v3, Lcom/wishabi/flipp/util/g;->a:Lb/a/a/i;

    invoke-virtual {v0, v3}, Lb/a/a/d/d;->a(Lb/a/a/i;)Lb/a/a/d/d;

    move-result-object v0

    .line 358
    invoke-static {}, Lcom/wishabi/flipp/app/FlippApplication;->b()Landroid/content/Context;

    move-result-object v3

    const v4, 0x7f0e0088

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-virtual {v0, v1}, Lb/a/a/d/d;->a(Lb/a/a/z;)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v5, v6

    const/4 v1, 0x1

    invoke-virtual {v0, v2}, Lb/a/a/d/d;->a(Lb/a/a/z;)Ljava/lang/String;

    move-result-object v0

    aput-object v0, v5, v1

    invoke-virtual {v3, v4, v5}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 351
    :cond_2
    const-string v0, "dd MMM"

    goto :goto_1

    .line 353
    :cond_3
    if-eqz v0, :cond_4

    const-string v0, "yyyy-MM-dd"

    goto :goto_1

    :cond_4
    const-string v0, "MMM dd"

    goto :goto_1
.end method

.method public static a(Ljava/util/List;Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/List",
            "<TT;>;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 142
    invoke-interface {p0}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 143
    const/4 v0, 0x0

    .line 157
    :goto_0
    return-object v0

    .line 145
    :cond_0
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v2

    .line 147
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 148
    invoke-interface {p0, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 150
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_1

    move v0, v1

    .line 151
    :cond_1
    :goto_1
    if-ge v1, v2, :cond_3

    .line 152
    if-eqz v0, :cond_2

    .line 153
    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 154
    :cond_2
    invoke-interface {p0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    .line 151
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 157
    :cond_3
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static a([ILjava/lang/String;)Ljava/lang/String;
    .locals 5

    .prologue
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 124
    array-length v2, p0

    .line 125
    if-nez v2, :cond_0

    .line 126
    const/4 v0, 0x0

    .line 138
    :goto_0
    return-object v0

    .line 128
    :cond_0
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 129
    aget v4, p0, v0

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 131
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_1

    move v0, v1

    .line 132
    :cond_1
    :goto_1
    if-ge v1, v2, :cond_3

    .line 133
    if-eqz v0, :cond_2

    .line 134
    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 135
    :cond_2
    aget v4, p0, v1

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    .line 132
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 138
    :cond_3
    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static a([Ljava/lang/String;)Z
    .locals 4

    .prologue
    const/4 v0, 0x0

    .line 161
    array-length v1, p0

    if-nez v1, :cond_1

    .line 167
    :cond_0
    :goto_0
    return v0

    .line 164
    :cond_1
    array-length v2, p0

    move v1, v0

    :goto_1
    if-ge v1, v2, :cond_2

    aget-object v3, p0, v1

    .line 165
    invoke-static {v3}, Lcom/wishabi/flipp/util/q;->b(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 164
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 167
    :cond_2
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public static a(Ljava/util/List;)[Ljava/lang/String;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/util/List",
            "<TT;>;)[",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 97
    invoke-interface {p0}, Ljava/util/List;->size()I

    move-result v0

    new-array v2, v0, [Ljava/lang/String;

    .line 98
    const/4 v0, 0x0

    .line 99
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    .line 100
    add-int/lit8 v1, v0, 0x1

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v0

    move v0, v1

    goto :goto_0

    .line 101
    :cond_0
    return-object v2
.end method

.method public static a([I)[Ljava/lang/String;
    .locals 3

    .prologue
    .line 76
    if-nez p0, :cond_0

    .line 77
    const/4 v0, 0x0

    .line 82
    :goto_0
    return-object v0

    .line 79
    :cond_0
    array-length v0, p0

    new-array v1, v0, [Ljava/lang/String;

    .line 80
    const/4 v0, 0x0

    :goto_1
    array-length v2, p0

    if-ge v0, v2, :cond_1

    .line 81
    aget v2, p0, v0

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v0

    .line 80
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_1
    move-object v0, v1

    .line 82
    goto :goto_0
.end method

.method public static a([J)[Ljava/lang/String;
    .locals 4

    .prologue
    .line 87
    if-nez p0, :cond_0

    .line 88
    const/4 v0, 0x0

    .line 93
    :goto_0
    return-object v0

    .line 90
    :cond_0
    array-length v0, p0

    new-array v1, v0, [Ljava/lang/String;

    .line 91
    const/4 v0, 0x0

    :goto_1
    array-length v2, p0

    if-ge v0, v2, :cond_1

    .line 92
    aget-wide v2, p0, v0

    invoke-static {v2, v3}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v1, v0

    .line 91
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_1
    move-object v0, v1

    .line 93
    goto :goto_0
.end method

.method public static b()Ljava/lang/String;
    .locals 4

    .prologue
    const/4 v0, 0x0

    const v3, 0x7f0e00be

    .line 214
    invoke-static {}, Lcom/wishabi/flipp/app/FlippApplication;->b()Landroid/content/Context;

    move-result-object v1

    .line 215
    if-nez v1, :cond_0

    .line 226
    :goto_0
    return-object v0

    .line 218
    :cond_0
    invoke-static {v0}, Lcom/wishabi/flipp/util/k;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 220
    invoke-static {v0}, Lcom/wishabi/flipp/util/k;->b(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 221
    invoke-virtual {v1, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 223
    :cond_1
    invoke-static {v0}, Lcom/wishabi/flipp/util/k;->c(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 224
    const v0, 0x7f0e015d

    invoke-virtual {v1, v0}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 226
    :cond_2
    invoke-virtual {v1, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static b(Ljava/lang/String;)Z
    .locals 1

    .prologue
    .line 172
    :try_start_0
    invoke-static {p0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 176
    const/4 v0, 0x1

    :goto_0
    return v0

    .line 174
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static c(Ljava/lang/String;)Z
    .locals 1

    .prologue
    .line 181
    :try_start_0
    invoke-static {p0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 185
    const/4 v0, 0x1

    :goto_0
    return v0

    .line 183
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static d(Ljava/lang/String;)Z
    .locals 1

    .prologue
    .line 190
    :try_start_0
    invoke-static {p0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    .line 194
    const/4 v0, 0x1

    :goto_0
    return v0

    .line 192
    :catch_0
    move-exception v0

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static e(Ljava/lang/String;)Ljava/lang/String;
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 311
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    sget-object v2, Ljava/util/Locale;->CANADA_FRENCH:Ljava/util/Locale;

    invoke-virtual {v0, v2}, Ljava/util/Locale;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "dd MMM, yyyy"

    .line 313
    :goto_0
    sget-object v2, Lcom/wishabi/flipp/util/g;->a:Lb/a/a/i;

    invoke-static {p0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_1

    move-object v0, v1

    :goto_1
    return-object v0

    .line 311
    :cond_0
    const-string v0, "MMM dd, yyyy"

    goto :goto_0

    .line 313
    :cond_1
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_2

    move-object v0, v1

    goto :goto_1

    :cond_2
    if-nez v2, :cond_3

    move-object v0, v1

    goto :goto_1

    :cond_3
    sget-object v1, Lcom/wishabi/flipp/util/q;->a:Lb/a/a/d/d;

    invoke-virtual {v1, p0}, Lb/a/a/d/d;->a(Ljava/lang/String;)Lb/a/a/b;

    move-result-object v1

    invoke-static {v0}, Lb/a/a/d/a;->a(Ljava/lang/String;)Lb/a/a/d/d;

    move-result-object v0

    invoke-virtual {v0, v2}, Lb/a/a/d/d;->a(Lb/a/a/i;)Lb/a/a/d/d;

    move-result-object v0

    invoke-virtual {v0, v1}, Lb/a/a/d/d;->a(Lb/a/a/z;)Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method
