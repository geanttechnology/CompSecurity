.class public Llt;
.super Ljava/lang/Object;
.source "SourceFile"


# static fields
.field private static a:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 39
    const/4 v0, -0x1

    sput v0, Llt;->a:I

    return-void
.end method

.method public static a(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;)V
    .locals 5

    .prologue
    .line 196
    const v0, 0x7f080022

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-static {p0, v0, v1}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v0

    .line 197
    new-instance v1, Landroid/text/SpannableStringBuilder;

    invoke-direct {v1, p2}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 198
    new-instance v2, Lcom/bestbuy/android/bbyobjects/BBYTypefaceSpan;

    const-string v3, ""

    invoke-direct {v2, v3, v0}, Lcom/bestbuy/android/bbyobjects/BBYTypefaceSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    const/4 v0, 0x0

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v3

    const/16 v4, 0x22

    invoke-virtual {v1, v2, v0, v3, v4}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 199
    invoke-virtual {p1, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 200
    return-void
.end method

.method public static a(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;I)V
    .locals 1

    .prologue
    .line 47
    const/4 v0, -0x1

    invoke-static {p0, p1, p2, p3, v0}, Llt;->a(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;II)V

    .line 48
    return-void
.end method

.method public static a(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;II)V
    .locals 4

    .prologue
    const/16 v1, 0x12c

    .line 50
    const/4 v0, 0x0

    .line 51
    sput p4, Llt;->a:I

    .line 52
    const-string v2, "\\u00BB"

    invoke-virtual {p2, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 53
    invoke-static {p2}, Lns;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    .line 54
    :cond_0
    const-string v2, "<span class=\'bold\'>"

    invoke-virtual {p2, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_3

    const-string v2, "AND"

    invoke-virtual {p2, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_3

    const-string v2, "\n"

    invoke-virtual {p2, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_1

    const-string v2, "\\n"

    invoke-virtual {p2, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 55
    :cond_1
    const/16 p3, 0x258

    .line 73
    :cond_2
    :goto_0
    sparse-switch p3, :sswitch_data_0

    .line 110
    :goto_1
    return-void

    .line 56
    :cond_3
    const-string v2, "<span class=\'bold\'>"

    invoke-virtual {p2, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 57
    const/16 v2, 0x1f4

    if-ne p3, v2, :cond_4

    .line 58
    const-string v1, "<span class=\'bold\'>"

    const-string v2, ""

    invoke-virtual {p2, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "</span>"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p2

    goto :goto_0

    .line 59
    :cond_4
    if-ne p3, v1, :cond_5

    .line 60
    const-string v0, "<span class=\'bold\'>"

    const-string v1, ""

    invoke-virtual {p2, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "</span>"

    const-string v2, "|"

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p2

    .line 61
    const-string v0, "|"

    invoke-virtual {p2, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    goto :goto_0

    .line 63
    :cond_5
    const-string v0, "<span class=\'bold\'>"

    invoke-virtual {p2, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    move p3, v1

    .line 64
    goto :goto_0

    .line 67
    :cond_6
    const-string v1, "italic"

    invoke-virtual {p2, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 68
    const-string v1, "<span class=\'italic\'>"

    const-string v2, ""

    invoke-virtual {p2, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v1

    const-string v2, "</span>"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object p2

    goto :goto_0

    .line 75
    :sswitch_0
    invoke-static {p0, p1, p2, v0}, Llt;->d(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;I)V

    goto :goto_1

    .line 78
    :sswitch_1
    invoke-static {p0, p1, p2, v0}, Llt;->e(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;I)V

    goto :goto_1

    .line 81
    :sswitch_2
    invoke-static {p0, p1, p2, v0}, Llt;->b(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;I)V

    goto :goto_1

    .line 84
    :sswitch_3
    invoke-static {p0, p1, p2}, Llt;->d(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;)V

    goto :goto_1

    .line 87
    :sswitch_4
    invoke-static {p0, p1, p2, v0}, Llt;->c(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;I)V

    goto :goto_1

    .line 90
    :sswitch_5
    invoke-static {p0, p1, p2}, Llt;->c(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;)V

    goto :goto_1

    .line 93
    :sswitch_6
    invoke-static {p0, p1, p2, v0}, Llt;->f(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;I)V

    goto :goto_1

    .line 96
    :sswitch_7
    invoke-static {p0, p1, p2}, Llt;->a(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;)V

    goto :goto_1

    .line 99
    :sswitch_8
    invoke-static {p0, p1, p2}, Llt;->b(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;)V

    goto :goto_1

    .line 102
    :sswitch_9
    invoke-static {p0, p1, p2}, Llt;->e(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;)V

    goto :goto_1

    .line 105
    :sswitch_a
    invoke-static {p0, p1, p2}, Llt;->f(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;)V

    goto/16 :goto_1

    .line 73
    nop

    :sswitch_data_0
    .sparse-switch
        0x64 -> :sswitch_1
        0xc8 -> :sswitch_0
        0x12c -> :sswitch_2
        0x190 -> :sswitch_3
        0x1f4 -> :sswitch_4
        0x258 -> :sswitch_5
        0x2bc -> :sswitch_6
        0x320 -> :sswitch_7
        0x384 -> :sswitch_8
        0x3e8 -> :sswitch_a
        0x44c -> :sswitch_9
    .end sparse-switch
.end method

.method private static a(Landroid/content/Context;Lcom/bestbuy/android/bbyobjects/BBYTextView;Ljava/lang/String;I)V
    .locals 15

    .prologue
    .line 239
    const/16 v1, 0xa

    new-array v6, v1, [I

    .line 240
    const/16 v1, 0xa

    new-array v7, v1, [I

    .line 241
    const/16 v1, 0xa

    new-array v8, v1, [I

    .line 242
    const/16 v1, 0xa

    new-array v9, v1, [I

    .line 243
    const/16 v1, 0xa

    new-array v10, v1, [I

    .line 244
    const/16 v1, 0xa

    new-array v11, v1, [I

    .line 245
    const/4 v5, 0x0

    .line 246
    const/4 v4, 0x0

    .line 247
    const/4 v1, 0x0

    .line 248
    const/4 v2, 0x0

    .line 249
    const/4 v3, 0x0

    .line 250
    const-string v12, "<span class=\'bold\'>"

    move-object/from16 v0, p2

    invoke-virtual {v0, v12}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v12

    if-eqz v12, :cond_1

    .line 251
    :cond_0
    :goto_0
    const/4 v12, -0x1

    if-eq v5, v12, :cond_1

    .line 252
    const-string v12, "<span class=\'bold\'>"

    move-object/from16 v0, p2

    invoke-virtual {v0, v12, v5}, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I

    move-result v5

    .line 253
    const/4 v12, -0x1

    if-eq v5, v12, :cond_0

    .line 254
    const-string v1, "<span class=\'bold\'>"

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    add-int/2addr v5, v1

    .line 255
    const-string v1, "<span class=\'bold\'>"

    move-object/from16 v0, p2

    invoke-virtual {v0, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    aput v1, v6, v4

    .line 256
    const-string v1, "<span class=\'bold\'>"

    const-string v12, ""

    move-object/from16 v0, p2

    invoke-virtual {v0, v1, v12}, Ljava/lang/String;->replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 257
    const-string v12, "</span>"

    invoke-virtual {v1, v12}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v12

    aput v12, v7, v4

    .line 258
    const-string v12, "</span>"

    const-string v13, ""

    invoke-virtual {v1, v12, v13}, Ljava/lang/String;->replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    .line 259
    const/4 v1, 0x1

    .line 260
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 264
    :cond_1
    const-string v4, "<i>"

    move-object/from16 v0, p2

    invoke-virtual {v0, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 265
    const/4 v4, 0x0

    .line 266
    const/4 v5, 0x0

    .line 267
    :cond_2
    :goto_1
    const/4 v12, -0x1

    if-eq v5, v12, :cond_3

    .line 268
    const-string v12, "<i>"

    move-object/from16 v0, p2

    invoke-virtual {v0, v12, v5}, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I

    move-result v5

    .line 269
    const/4 v12, -0x1

    if-eq v5, v12, :cond_2

    .line 270
    const-string v2, "<i>"

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    add-int/2addr v5, v2

    .line 271
    const-string v2, "<i>"

    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    aput v2, v8, v4

    .line 272
    const-string v2, "<i>"

    const-string v12, ""

    move-object/from16 v0, p2

    invoke-virtual {v0, v2, v12}, Ljava/lang/String;->replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 273
    const-string v12, "</i>"

    invoke-virtual {v2, v12}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v12

    aput v12, v9, v4

    .line 274
    const-string v12, "</i>"

    const-string v13, ""

    invoke-virtual {v2, v12, v13}, Ljava/lang/String;->replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    .line 275
    const/4 v2, 0x1

    .line 276
    add-int/lit8 v4, v4, 0x1

    goto :goto_1

    .line 280
    :cond_3
    const-string v4, "<u>"

    move-object/from16 v0, p2

    invoke-virtual {v0, v4}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_5

    .line 281
    const/4 v4, 0x0

    .line 282
    const/4 v5, 0x0

    .line 283
    :cond_4
    :goto_2
    const/4 v12, -0x1

    if-eq v5, v12, :cond_5

    .line 284
    const-string v12, "<u>"

    move-object/from16 v0, p2

    invoke-virtual {v0, v12, v5}, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I

    move-result v5

    .line 285
    const/4 v12, -0x1

    if-eq v5, v12, :cond_4

    .line 286
    const-string v3, "<u>"

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v5, v3

    .line 287
    const-string v3, "<u>"

    move-object/from16 v0, p2

    invoke-virtual {v0, v3}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v3

    aput v3, v10, v4

    .line 288
    const-string v3, "<u>"

    const-string v12, ""

    move-object/from16 v0, p2

    invoke-virtual {v0, v3, v12}, Ljava/lang/String;->replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 289
    const-string v12, "</u>"

    invoke-virtual {v3, v12}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v12

    aput v12, v11, v4

    .line 290
    const-string v12, "</u>"

    const-string v13, ""

    invoke-virtual {v3, v12, v13}, Ljava/lang/String;->replaceFirst(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object p2

    .line 291
    const/4 v3, 0x1

    .line 292
    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    .line 296
    :cond_5
    new-instance v4, Landroid/text/SpannableString;

    move-object/from16 v0, p2

    invoke-direct {v4, v0}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 297
    new-instance v5, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;

    const/4 v12, 0x0

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v13

    move/from16 v0, p3

    invoke-static {p0, v0, v13}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v13

    invoke-direct {v5, p0, v12, v13}, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;-><init>(Landroid/content/Context;ILandroid/graphics/Typeface;)V

    const/4 v12, 0x0

    invoke-virtual/range {p2 .. p2}, Ljava/lang/String;->length()I

    move-result v13

    const/16 v14, 0x21

    invoke-virtual {v4, v5, v12, v13, v14}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 300
    if-eqz v1, :cond_6

    .line 301
    const/4 v1, 0x0

    :goto_3
    array-length v5, v6

    if-ge v1, v5, :cond_6

    .line 302
    new-instance v5, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;

    const/4 v12, 0x0

    const v13, 0x7f080021

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v14

    invoke-static {p0, v13, v14}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v13

    invoke-direct {v5, p0, v12, v13}, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;-><init>(Landroid/content/Context;ILandroid/graphics/Typeface;)V

    aget v12, v6, v1

    aget v13, v7, v1

    const/16 v14, 0x21

    invoke-virtual {v4, v5, v12, v13, v14}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 301
    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    .line 309
    :cond_6
    if-eqz v2, :cond_7

    .line 310
    const/4 v1, 0x0

    :goto_4
    array-length v2, v8

    if-ge v1, v2, :cond_7

    .line 311
    new-instance v2, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;

    const/4 v5, 0x0

    const v6, 0x7f080023

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    invoke-static {p0, v6, v7}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v6

    invoke-direct {v2, p0, v5, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;-><init>(Landroid/content/Context;ILandroid/graphics/Typeface;)V

    aget v5, v8, v1

    aget v6, v9, v1

    const/16 v7, 0x21

    invoke-virtual {v4, v2, v5, v6, v7}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 310
    add-int/lit8 v1, v1, 0x1

    goto :goto_4

    .line 318
    :cond_7
    if-eqz v3, :cond_8

    .line 319
    const/4 v1, 0x0

    :goto_5
    array-length v2, v10

    if-ge v1, v2, :cond_8

    .line 320
    new-instance v2, Landroid/text/style/UnderlineSpan;

    invoke-direct {v2}, Landroid/text/style/UnderlineSpan;-><init>()V

    aget v3, v10, v1

    aget v5, v11, v1

    const/16 v6, 0x21

    invoke-virtual {v4, v2, v3, v5, v6}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 319
    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    .line 323
    :cond_8
    sget-object v1, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    move-object/from16 v0, p1

    invoke-virtual {v0, v4, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 324
    return-void
.end method

.method public static a(Landroid/content/Context;Lcom/bestbuy/android/bbyobjects/BBYTextView;Ljava/lang/String;II)V
    .locals 1

    .prologue
    .line 42
    const/16 v0, 0x3e8

    if-ne p3, v0, :cond_0

    .line 43
    invoke-static {p0, p1, p2, p4}, Llt;->a(Landroid/content/Context;Lcom/bestbuy/android/bbyobjects/BBYTextView;Ljava/lang/String;I)V

    .line 45
    :cond_0
    return-void
.end method

.method public static b(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 203
    const v0, 0x7f080023

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-static {p0, v0, v1}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v0

    .line 204
    new-instance v1, Landroid/text/SpannableStringBuilder;

    invoke-direct {v1, p2}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 205
    new-instance v2, Lcom/bestbuy/android/bbyobjects/BBYTypefaceSpan;

    const-string v3, ""

    invoke-direct {v2, v3, v0}, Lcom/bestbuy/android/bbyobjects/BBYTypefaceSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v3, 0x22

    invoke-virtual {v1, v2, v4, v0, v3}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 206
    sget v0, Llt;->a:I

    const/4 v2, -0x1

    if-eq v0, v2, :cond_0

    .line 207
    new-instance v0, Landroid/text/style/ForegroundColorSpan;

    sget v2, Llt;->a:I

    invoke-direct {v0, v2}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v2

    const/16 v3, 0x21

    invoke-virtual {v1, v0, v4, v2, v3}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 208
    :cond_0
    invoke-virtual {p1, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 209
    return-void
.end method

.method public static b(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;I)V
    .locals 8

    .prologue
    const/16 v7, 0x22

    const/4 v6, 0x0

    .line 137
    const v0, 0x7f080021

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-static {p0, v0, v1}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v0

    .line 138
    const v1, 0x7f080024

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-static {p0, v1, v2}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v1

    .line 139
    const-string v2, "|"

    const-string v3, ""

    invoke-virtual {p2, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    .line 140
    new-instance v3, Landroid/text/SpannableStringBuilder;

    invoke-direct {v3, v2}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 141
    new-instance v4, Lcom/bestbuy/android/bbyobjects/BBYTypefaceSpan;

    const-string v5, ""

    invoke-direct {v4, v5, v0}, Lcom/bestbuy/android/bbyobjects/BBYTypefaceSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    invoke-virtual {v3, v4, v6, p3, v7}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 142
    sget v0, Llt;->a:I

    const/4 v4, -0x1

    if-eq v0, v4, :cond_0

    .line 143
    new-instance v0, Landroid/text/style/ForegroundColorSpan;

    sget v4, Llt;->a:I

    invoke-direct {v0, v4}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    const/16 v4, 0x21

    invoke-virtual {v3, v0, v6, p3, v4}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 144
    :cond_0
    new-instance v0, Lcom/bestbuy/android/bbyobjects/BBYTypefaceSpan;

    const-string v4, ""

    invoke-direct {v0, v4, v1}, Lcom/bestbuy/android/bbyobjects/BBYTypefaceSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v1

    invoke-virtual {v3, v0, p3, v1, v7}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 146
    invoke-virtual {p1, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 147
    return-void
.end method

.method private static c(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;)V
    .locals 11

    .prologue
    const v10, 0x7f080024

    const v9, 0x7f080021

    const/16 v8, 0x22

    const/4 v7, 0x0

    .line 113
    const-string v0, "\\n"

    const-string v1, "\n"

    invoke-virtual {p2, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 114
    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    .line 115
    invoke-virtual {v0, v7, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    .line 116
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v3

    invoke-virtual {v0, v1, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 117
    const-string v1, "<span class=\'bold\'>"

    invoke-virtual {v2, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    .line 118
    const-string v3, "<span class=\'bold\'>"

    const-string v4, ""

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    const-string v3, "</span>"

    const-string v4, ""

    invoke-virtual {v2, v3, v4}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    .line 119
    new-instance v3, Landroid/text/SpannableStringBuilder;

    invoke-direct {v3, v2}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 120
    new-instance v4, Lcom/bestbuy/android/bbyobjects/BBYTypefaceSpan;

    const-string v5, ""

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-static {p0, v10, v6}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lcom/bestbuy/android/bbyobjects/BBYTypefaceSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    invoke-virtual {v3, v4, v7, v1, v8}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 122
    new-instance v4, Lcom/bestbuy/android/bbyobjects/BBYTypefaceSpan;

    const-string v5, ""

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-static {p0, v9, v6}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lcom/bestbuy/android/bbyobjects/BBYTypefaceSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    const/16 v5, 0x21

    invoke-virtual {v3, v4, v1, v2, v5}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 124
    sget-object v1, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-virtual {p1, v3, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 126
    const-string v1, "<span class=\'bold\'>"

    invoke-virtual {v0, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    .line 127
    const-string v2, "<span class=\'bold\'>"

    const-string v3, ""

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    const-string v2, "</span>"

    const-string v3, ""

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 128
    new-instance v2, Landroid/text/SpannableStringBuilder;

    invoke-direct {v2, v0}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 129
    new-instance v3, Lcom/bestbuy/android/bbyobjects/BBYTypefaceSpan;

    const-string v4, ""

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-static {p0, v10, v5}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Lcom/bestbuy/android/bbyobjects/BBYTypefaceSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    invoke-virtual {v2, v3, v7, v1, v8}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 131
    new-instance v3, Lcom/bestbuy/android/bbyobjects/BBYTypefaceSpan;

    const-string v4, ""

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-static {p0, v9, v5}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Lcom/bestbuy/android/bbyobjects/BBYTypefaceSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    invoke-virtual {v2, v3, v1, v0, v8}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 133
    invoke-virtual {p1, v2}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 134
    return-void
.end method

.method public static c(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;I)V
    .locals 6

    .prologue
    const/16 v5, 0x22

    .line 187
    const v0, 0x7f080021

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-static {p0, v0, v1}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v0

    .line 188
    const v1, 0x7f080024

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-static {p0, v1, v2}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v1

    .line 189
    new-instance v2, Landroid/text/SpannableStringBuilder;

    invoke-direct {v2, p2}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 190
    new-instance v3, Lcom/bestbuy/android/bbyobjects/BBYTypefaceSpan;

    const-string v4, ""

    invoke-direct {v3, v4, v0}, Lcom/bestbuy/android/bbyobjects/BBYTypefaceSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    const/4 v0, 0x0

    invoke-virtual {v2, v3, v0, p3, v5}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 191
    new-instance v0, Lcom/bestbuy/android/bbyobjects/BBYTypefaceSpan;

    const-string v3, ""

    invoke-direct {v0, v3, v1}, Lcom/bestbuy/android/bbyobjects/BBYTypefaceSpan;-><init>(Ljava/lang/String;Landroid/graphics/Typeface;)V

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v1

    invoke-virtual {v2, v0, p3, v1, v5}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 192
    invoke-virtual {p1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 193
    return-void
.end method

.method private static d(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;)V
    .locals 8

    .prologue
    const/16 v7, 0x21

    const/4 v6, 0x0

    .line 176
    const-string v0, "\\n"

    const-string v1, "\n"

    invoke-virtual {p2, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 177
    const-string v1, "\n"

    invoke-virtual {v0, v1}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    .line 178
    new-instance v2, Landroid/text/SpannableString;

    invoke-direct {v2, v0}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 179
    new-instance v3, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;

    const v4, 0x7f080024

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-static {p0, v4, v5}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v4

    invoke-direct {v3, p0, v6, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;-><init>(Landroid/content/Context;ILandroid/graphics/Typeface;)V

    invoke-virtual {v2, v3, v6, v1, v7}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 181
    new-instance v3, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;

    const v4, 0x7f080021

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-static {p0, v4, v5}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v4

    invoke-direct {v3, p0, v6, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;-><init>(Landroid/content/Context;ILandroid/graphics/Typeface;)V

    add-int/lit8 v1, v1, 0x1

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    invoke-virtual {v2, v3, v1, v0, v7}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 183
    sget-object v0, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-virtual {p1, v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 184
    return-void
.end method

.method private static d(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;I)V
    .locals 6

    .prologue
    const/16 v5, 0x21

    const/4 v4, 0x0

    .line 150
    const v0, 0x7f080021

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-static {p0, v0, v1}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v0

    .line 151
    new-instance v1, Landroid/text/SpannableString;

    invoke-direct {v1, p2}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 152
    new-instance v2, Landroid/text/style/StyleSpan;

    const/4 v3, 0x1

    invoke-direct {v2, v3}, Landroid/text/style/StyleSpan;-><init>(I)V

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v3

    invoke-virtual {v1, v2, v4, v3, v5}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 153
    sget v2, Llt;->a:I

    const/4 v3, -0x1

    if-eq v2, v3, :cond_0

    .line 154
    new-instance v2, Landroid/text/style/ForegroundColorSpan;

    sget v3, Llt;->a:I

    invoke-direct {v2, v3}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-virtual {v1, v2, v4, p3, v5}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 155
    :cond_0
    sget-object v2, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-virtual {p1, v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 156
    invoke-virtual {p1, v0}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 157
    return-void
.end method

.method private static e(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 212
    if-eqz p2, :cond_0

    .line 213
    new-instance v0, Landroid/text/SpannableString;

    invoke-direct {v0, p2}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 214
    new-instance v1, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;

    const v2, 0x7f080023

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-static {p0, v2, v3}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v2

    invoke-direct {v1, p0, v4, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;-><init>(Landroid/content/Context;ILandroid/graphics/Typeface;)V

    invoke-virtual {v0}, Landroid/text/SpannableString;->length()I

    move-result v2

    const/16 v3, 0x21

    invoke-virtual {v0, v1, v4, v2, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 219
    new-instance v1, Landroid/text/style/UnderlineSpan;

    invoke-direct {v1}, Landroid/text/style/UnderlineSpan;-><init>()V

    invoke-virtual {v0}, Landroid/text/SpannableString;->length()I

    move-result v2

    invoke-virtual {v0, v1, v4, v2, v4}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 220
    sget-object v1, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-virtual {p1, v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 222
    :cond_0
    return-void
.end method

.method private static e(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;I)V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 160
    const v0, 0x7f080024

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-static {p0, v0, v1}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v0

    .line 161
    new-instance v1, Landroid/text/SpannableString;

    invoke-direct {v1, p2}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 162
    new-instance v2, Landroid/text/style/StyleSpan;

    invoke-direct {v2, v5}, Landroid/text/style/StyleSpan;-><init>(I)V

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v3

    const/16 v4, 0x21

    invoke-virtual {v1, v2, v5, v3, v4}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 163
    sget-object v2, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-virtual {p1, v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 164
    invoke-virtual {p1, v0}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 165
    return-void
.end method

.method private static f(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 225
    if-eqz p2, :cond_0

    .line 226
    new-instance v0, Landroid/text/SpannableString;

    invoke-direct {v0, p2}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 227
    new-instance v1, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;

    const v2, 0x7f080022

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-static {p0, v2, v3}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v2

    invoke-direct {v1, p0, v4, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextAppearnceSpan;-><init>(Landroid/content/Context;ILandroid/graphics/Typeface;)V

    invoke-virtual {v0}, Landroid/text/SpannableString;->length()I

    move-result v2

    const/16 v3, 0x21

    invoke-virtual {v0, v1, v4, v2, v3}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 232
    new-instance v1, Landroid/text/style/UnderlineSpan;

    invoke-direct {v1}, Landroid/text/style/UnderlineSpan;-><init>()V

    invoke-virtual {v0}, Landroid/text/SpannableString;->length()I

    move-result v2

    invoke-virtual {v0, v1, v4, v2, v4}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 233
    sget-object v1, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-virtual {p1, v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 235
    :cond_0
    return-void
.end method

.method private static f(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;I)V
    .locals 6

    .prologue
    .line 168
    const v0, 0x7f080024

    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-static {p0, v0, v1}, Llo;->a(Landroid/content/Context;ILandroid/content/res/Resources;)Landroid/graphics/Typeface;

    move-result-object v0

    .line 169
    new-instance v1, Landroid/text/SpannableString;

    invoke-direct {v1, p2}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 170
    new-instance v2, Landroid/text/style/UnderlineSpan;

    invoke-direct {v2}, Landroid/text/style/UnderlineSpan;-><init>()V

    const/4 v3, 0x0

    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v4

    const/16 v5, 0x21

    invoke-virtual {v1, v2, v3, v4, v5}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 171
    sget-object v2, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-virtual {p1, v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 172
    invoke-virtual {p1, v0}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;)V

    .line 173
    return-void
.end method
