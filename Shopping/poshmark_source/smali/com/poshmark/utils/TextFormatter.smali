.class public Lcom/poshmark/utils/TextFormatter;
.super Ljava/lang/Object;
.source "TextFormatter.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    return-void
.end method


# virtual methods
.method public getClickableCommentString(Lcom/poshmark/ui/customviews/PMTextView;Lcom/poshmark/utils/TextClickListener;Ljava/lang/String;)Ljava/lang/CharSequence;
    .locals 16
    .param p1, "pmTextView"    # Lcom/poshmark/ui/customviews/PMTextView;
    .param p2, "nameClickListener"    # Lcom/poshmark/utils/TextClickListener;
    .param p3, "comment"    # Ljava/lang/String;

    .prologue
    .line 148
    new-instance v15, Landroid/text/SpannableStringBuilder;

    invoke-direct {v15}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 150
    .local v15, "strBuilder":Landroid/text/SpannableStringBuilder;
    new-instance v14, Landroid/text/SpannableString;

    move-object/from16 v0, p3

    invoke-direct {v14, v0}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 153
    .local v14, "span":Landroid/text/SpannableString;
    const-string v1, " "

    const/4 v3, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v1, v3}, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I

    move-result v9

    .line 154
    .local v9, "indexEnd":I
    const/4 v1, -0x1

    if-eq v9, v1, :cond_0

    .line 155
    const/4 v1, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v1, v9}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    .line 156
    .local v2, "commenterName":Ljava/lang/String;
    new-instance v1, Lcom/poshmark/utils/PMClickableSpan;

    invoke-virtual/range {p1 .. p1}, Lcom/poshmark/ui/customviews/PMTextView;->getFontColor()I

    move-result v4

    invoke-virtual/range {p1 .. p1}, Lcom/poshmark/ui/customviews/PMTextView;->getFontName()Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x0

    move-object/from16 v3, p2

    invoke-direct/range {v1 .. v6}, Lcom/poshmark/utils/PMClickableSpan;-><init>(Ljava/lang/String;Lcom/poshmark/utils/TextClickListener;ILjava/lang/String;Z)V

    const/4 v3, 0x0

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v4

    const/16 v5, 0x21

    invoke-virtual {v14, v1, v3, v4, v5}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 160
    .end local v2    # "commenterName":Ljava/lang/String;
    :cond_0
    const-string v13, "(?<![a-z])@\\w*\\b"

    .line 161
    .local v13, "regex":Ljava/lang/String;
    invoke-static {v13}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v12

    .line 162
    .local v12, "p":Ljava/util/regex/Pattern;
    move-object/from16 v0, p3

    invoke-virtual {v12, v0}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v10

    .line 164
    .local v10, "m":Ljava/util/regex/Matcher;
    :goto_0
    invoke-virtual {v10}, Ljava/util/regex/Matcher;->find()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 165
    invoke-virtual {v10}, Ljava/util/regex/Matcher;->group()Ljava/lang/String;

    move-result-object v11

    .line 166
    .local v11, "name":Ljava/lang/String;
    new-instance v3, Lcom/poshmark/utils/PMClickableSpan;

    const/4 v1, 0x1

    invoke-virtual {v11, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual/range {p1 .. p1}, Lcom/poshmark/ui/customviews/PMTextView;->getFontColor()I

    move-result v6

    invoke-virtual/range {p1 .. p1}, Lcom/poshmark/ui/customviews/PMTextView;->getFontName()Ljava/lang/String;

    move-result-object v7

    const/4 v8, 0x0

    move-object/from16 v5, p2

    invoke-direct/range {v3 .. v8}, Lcom/poshmark/utils/PMClickableSpan;-><init>(Ljava/lang/String;Lcom/poshmark/utils/TextClickListener;ILjava/lang/String;Z)V

    invoke-virtual {v10}, Ljava/util/regex/Matcher;->start()I

    move-result v1

    invoke-virtual {v10}, Ljava/util/regex/Matcher;->start()I

    move-result v4

    invoke-virtual {v11}, Ljava/lang/String;->length()I

    move-result v5

    add-int/2addr v4, v5

    const/16 v5, 0x21

    invoke-virtual {v14, v3, v1, v4, v5}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    goto :goto_0

    .line 169
    .end local v11    # "name":Ljava/lang/String;
    :cond_1
    invoke-virtual {v15, v14}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 170
    return-object v15
.end method

.method public getClickableLikesString(Lcom/poshmark/ui/customviews/PMTextView;Lcom/poshmark/utils/TextClickListener;Lcom/poshmark/utils/TextClickListener;Ljava/util/List;Ljava/lang/String;)Ljava/lang/CharSequence;
    .locals 23
    .param p1, "pmTextView"    # Lcom/poshmark/ui/customviews/PMTextView;
    .param p2, "linkClickListener"    # Lcom/poshmark/utils/TextClickListener;
    .param p3, "multipleLikesClickListener"    # Lcom/poshmark/utils/TextClickListener;
    .param p5, "listingId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/ui/customviews/PMTextView;",
            "Lcom/poshmark/utils/TextClickListener;",
            "Lcom/poshmark/utils/TextClickListener;",
            "Ljava/util/List",
            "<",
            "Lcom/poshmark/data_model/models/inner_models/Like;",
            ">;",
            "Ljava/lang/String;",
            ")",
            "Ljava/lang/CharSequence;"
        }
    .end annotation

    .prologue
    .line 237
    .local p4, "likes":Ljava/util/List;, "Ljava/util/List<Lcom/poshmark/data_model/models/inner_models/Like;>;"
    new-instance v10, Ljava/lang/String;

    invoke-direct {v10}, Ljava/lang/String;-><init>()V

    .line 238
    .local v10, "final_likes_string":Ljava/lang/String;
    new-instance v15, Ljava/util/ArrayList;

    invoke-direct {v15}, Ljava/util/ArrayList;-><init>()V

    .line 239
    .local v15, "links":Ljava/util/List;, "Ljava/util/List<Landroid/graphics/Point;>;"
    const/16 v20, 0x0

    .line 240
    .local v20, "specialLinkPos":Landroid/graphics/Point;
    const/16 v21, 0x0

    .line 242
    .local v21, "startPos":I
    invoke-interface/range {p4 .. p4}, Ljava/util/List;->size()I

    move-result v2

    const/4 v4, 0x2

    if-le v2, v4, :cond_1

    .line 243
    const/4 v2, 0x0

    move-object/from16 v0, p4

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Lcom/poshmark/data_model/models/inner_models/Like;

    .line 244
    .local v13, "like":Lcom/poshmark/data_model/models/inner_models/Like;
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v13}, Lcom/poshmark/data_model/models/inner_models/Like;->getDisplayHandle()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    .line 245
    new-instance v14, Landroid/graphics/Point;

    invoke-virtual {v13}, Lcom/poshmark/data_model/models/inner_models/Like;->getDisplayHandle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    move/from16 v0, v21

    invoke-direct {v14, v0, v2}, Landroid/graphics/Point;-><init>(II)V

    .line 246
    .local v14, "linkPos":Landroid/graphics/Point;
    invoke-interface {v15, v14}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 248
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, " and "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    .line 249
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-interface/range {p4 .. p4}, Ljava/util/List;->size()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    invoke-static {v4}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, " others"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    .line 250
    .local v16, "msg":Ljava/lang/String;
    new-instance v20, Landroid/graphics/Point;

    .end local v20    # "specialLinkPos":Landroid/graphics/Point;
    invoke-virtual {v10}, Ljava/lang/String;->length()I

    move-result v2

    invoke-virtual/range {v16 .. v16}, Ljava/lang/String;->length()I

    move-result v4

    move-object/from16 v0, v20

    invoke-direct {v0, v2, v4}, Landroid/graphics/Point;-><init>(II)V

    .line 251
    .restart local v20    # "specialLinkPos":Landroid/graphics/Point;
    move-object/from16 v0, v20

    invoke-interface {v15, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 253
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    move-object/from16 v0, v16

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, " like this"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    .line 270
    .end local v13    # "like":Lcom/poshmark/data_model/models/inner_models/Like;
    .end local v14    # "linkPos":Landroid/graphics/Point;
    .end local v16    # "msg":Ljava/lang/String;
    :cond_0
    new-instance v22, Landroid/text/SpannableStringBuilder;

    invoke-direct/range {v22 .. v22}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 271
    .local v22, "strBuilder":Landroid/text/SpannableStringBuilder;
    invoke-virtual {v10}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_5

    .line 272
    new-instance v19, Landroid/text/SpannableString;

    move-object/from16 v0, v19

    invoke-direct {v0, v10}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 275
    .local v19, "span":Landroid/text/SpannableString;
    invoke-interface {v15}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v12

    .line 276
    .local v12, "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Landroid/graphics/Point;>;"
    :goto_0
    invoke-interface {v12}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 277
    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v17

    check-cast v17, Landroid/graphics/Point;

    .line 278
    .local v17, "point":Landroid/graphics/Point;
    move-object/from16 v0, v17

    move-object/from16 v1, v20

    if-eq v0, v1, :cond_3

    .line 279
    move-object/from16 v0, v17

    iget v2, v0, Landroid/graphics/Point;->x:I

    move-object/from16 v0, v17

    iget v4, v0, Landroid/graphics/Point;->x:I

    move-object/from16 v0, v17

    iget v5, v0, Landroid/graphics/Point;->y:I

    add-int/2addr v4, v5

    invoke-virtual {v10, v2, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    .line 280
    .local v3, "linkStr":Ljava/lang/String;
    new-instance v2, Lcom/poshmark/utils/PMClickableSpan;

    invoke-virtual/range {p1 .. p1}, Lcom/poshmark/ui/customviews/PMTextView;->getFontColor()I

    move-result v5

    invoke-virtual/range {p1 .. p1}, Lcom/poshmark/ui/customviews/PMTextView;->getFontName()Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x0

    move-object/from16 v4, p2

    invoke-direct/range {v2 .. v7}, Lcom/poshmark/utils/PMClickableSpan;-><init>(Ljava/lang/String;Lcom/poshmark/utils/TextClickListener;ILjava/lang/String;Z)V

    move-object/from16 v0, v17

    iget v4, v0, Landroid/graphics/Point;->x:I

    move-object/from16 v0, v17

    iget v5, v0, Landroid/graphics/Point;->x:I

    move-object/from16 v0, v17

    iget v6, v0, Landroid/graphics/Point;->y:I

    add-int/2addr v5, v6

    const/16 v6, 0x21

    move-object/from16 v0, v19

    invoke-virtual {v0, v2, v4, v5, v6}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    goto :goto_0

    .line 257
    .end local v3    # "linkStr":Ljava/lang/String;
    .end local v12    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Landroid/graphics/Point;>;"
    .end local v17    # "point":Landroid/graphics/Point;
    .end local v19    # "span":Landroid/text/SpannableString;
    .end local v22    # "strBuilder":Landroid/text/SpannableStringBuilder;
    :cond_1
    invoke-interface/range {p4 .. p4}, Ljava/util/List;->size()I

    move-result v18

    .line 258
    .local v18, "size":I
    const/4 v11, 0x0

    .local v11, "i":I
    :goto_1
    move/from16 v0, v18

    if-ge v11, v0, :cond_0

    .line 259
    move-object/from16 v0, p4

    invoke-interface {v0, v11}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Lcom/poshmark/data_model/models/inner_models/Like;

    .line 260
    .restart local v13    # "like":Lcom/poshmark/data_model/models/inner_models/Like;
    new-instance v14, Landroid/graphics/Point;

    invoke-virtual {v10}, Ljava/lang/String;->length()I

    move-result v2

    invoke-virtual {v13}, Lcom/poshmark/data_model/models/inner_models/Like;->getDisplayHandle()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    invoke-direct {v14, v2, v4}, Landroid/graphics/Point;-><init>(II)V

    .line 261
    .restart local v14    # "linkPos":Landroid/graphics/Point;
    invoke-interface {v15, v14}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 262
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v13}, Lcom/poshmark/data_model/models/inner_models/Like;->getDisplayHandle()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    .line 263
    add-int/lit8 v2, v18, -0x1

    if-ge v11, v2, :cond_2

    .line 264
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, ", "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    .line 258
    :cond_2
    add-int/lit8 v11, v11, 0x1

    goto :goto_1

    .line 282
    .end local v11    # "i":I
    .end local v13    # "like":Lcom/poshmark/data_model/models/inner_models/Like;
    .end local v14    # "linkPos":Landroid/graphics/Point;
    .end local v18    # "size":I
    .restart local v12    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Landroid/graphics/Point;>;"
    .restart local v17    # "point":Landroid/graphics/Point;
    .restart local v19    # "span":Landroid/text/SpannableString;
    .restart local v22    # "strBuilder":Landroid/text/SpannableStringBuilder;
    :cond_3
    new-instance v4, Lcom/poshmark/utils/PMClickableSpan;

    invoke-virtual/range {p1 .. p1}, Lcom/poshmark/ui/customviews/PMTextView;->getFontColor()I

    move-result v7

    invoke-virtual/range {p1 .. p1}, Lcom/poshmark/ui/customviews/PMTextView;->getFontName()Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x0

    move-object/from16 v5, p5

    move-object/from16 v6, p3

    invoke-direct/range {v4 .. v9}, Lcom/poshmark/utils/PMClickableSpan;-><init>(Ljava/lang/String;Lcom/poshmark/utils/TextClickListener;ILjava/lang/String;Z)V

    move-object/from16 v0, v17

    iget v2, v0, Landroid/graphics/Point;->x:I

    move-object/from16 v0, v17

    iget v5, v0, Landroid/graphics/Point;->x:I

    move-object/from16 v0, v17

    iget v6, v0, Landroid/graphics/Point;->y:I

    add-int/2addr v5, v6

    const/16 v6, 0x21

    move-object/from16 v0, v19

    invoke-virtual {v0, v4, v2, v5, v6}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    goto/16 :goto_0

    .line 286
    .end local v17    # "point":Landroid/graphics/Point;
    :cond_4
    move-object/from16 v0, v22

    move-object/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 288
    .end local v12    # "itr":Ljava/util/Iterator;, "Ljava/util/Iterator<Landroid/graphics/Point;>;"
    .end local v19    # "span":Landroid/text/SpannableString;
    :cond_5
    return-object v22
.end method

.method public getClickableLinkString(Lcom/poshmark/ui/customviews/PMTextView;Lcom/poshmark/utils/TextClickListener;Ljava/lang/String;Ljava/util/ArrayList;)Ljava/lang/CharSequence;
    .locals 15
    .param p1, "pmTextView"    # Lcom/poshmark/ui/customviews/PMTextView;
    .param p2, "nameClickListener"    # Lcom/poshmark/utils/TextClickListener;
    .param p3, "label"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/poshmark/ui/customviews/PMTextView;",
            "Lcom/poshmark/utils/TextClickListener;",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)",
            "Ljava/lang/CharSequence;"
        }
    .end annotation

    .prologue
    .line 191
    .local p4, "urls":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/String;>;"
    new-instance v11, Ljava/lang/String;

    move-object/from16 v0, p3

    invoke-direct {v11, v0}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    .line 192
    .local v11, "label_minus_braces":Ljava/lang/String;
    const-string v1, "["

    const-string v3, ""

    invoke-virtual {v11, v1, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v11

    .line 193
    const-string v1, "]"

    const-string v3, ""

    invoke-virtual {v11, v1, v3}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v11

    .line 195
    new-instance v13, Landroid/text/SpannableStringBuilder;

    invoke-direct {v13}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 197
    .local v13, "strBuilder":Landroid/text/SpannableStringBuilder;
    new-instance v12, Landroid/text/SpannableString;

    invoke-direct {v12, v11}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 199
    .local v12, "span":Landroid/text/SpannableString;
    const/4 v8, 0x0

    .line 200
    .local v8, "count":I
    const/4 v7, 0x0

    .line 202
    .local v7, "bFoundMatch":Z
    const-string v1, "["

    const/4 v3, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v1, v3}, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I

    move-result v10

    .line 203
    .local v10, "indexStart":I
    :cond_0
    :goto_0
    const/4 v1, -0x1

    if-eq v10, v1, :cond_2

    .line 204
    const-string v1, "]"

    move-object/from16 v0, p3

    invoke-virtual {v0, v1, v10}, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I

    move-result v9

    .line 205
    .local v9, "indexEnd":I
    const/4 v1, -0x1

    if-eq v9, v1, :cond_0

    .line 208
    add-int/lit8 v9, v9, -0x1

    .line 209
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const/4 v3, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v3, v10}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, ""

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    add-int/lit8 v3, v10, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v0, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p3

    .line 210
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const/4 v3, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v3, v9}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, ""

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    add-int/lit8 v3, v9, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v0, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p3

    .line 211
    move-object/from16 v0, p3

    invoke-virtual {v0, v10, v9}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v14

    .line 212
    .local v14, "subString":Ljava/lang/String;
    move-object/from16 v0, p4

    invoke-virtual {v0, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 213
    .local v2, "url":Ljava/lang/String;
    if-eqz v2, :cond_1

    .line 214
    new-instance v1, Lcom/poshmark/utils/PMClickableSpan;

    invoke-virtual/range {p1 .. p1}, Lcom/poshmark/ui/customviews/PMTextView;->getFontColor()I

    move-result v4

    invoke-virtual/range {p1 .. p1}, Lcom/poshmark/ui/customviews/PMTextView;->getFontName()Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x0

    move-object/from16 v3, p2

    invoke-direct/range {v1 .. v6}, Lcom/poshmark/utils/PMClickableSpan;-><init>(Ljava/lang/String;Lcom/poshmark/utils/TextClickListener;ILjava/lang/String;Z)V

    invoke-virtual {v14}, Ljava/lang/String;->length()I

    move-result v3

    add-int/2addr v3, v10

    const/16 v4, 0x21

    invoke-virtual {v12, v1, v10, v3, v4}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 216
    :cond_1
    add-int/lit8 v8, v8, 0x1

    .line 217
    const-string v1, "["

    move-object/from16 v0, p3

    invoke-virtual {v0, v1, v9}, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I

    move-result v10

    .line 218
    const/4 v7, 0x1

    goto/16 :goto_0

    .line 222
    .end local v2    # "url":Ljava/lang/String;
    .end local v9    # "indexEnd":I
    .end local v14    # "subString":Ljava/lang/String;
    :cond_2
    if-nez v7, :cond_3

    .line 223
    invoke-virtual {v13, v11}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 228
    :goto_1
    return-object v13

    .line 225
    :cond_3
    invoke-virtual {v13, v12}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    goto :goto_1
.end method

.method public getClickableSimpleString(Lcom/poshmark/ui/customviews/PMTextView;Lcom/poshmark/utils/TextClickListener;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/CharSequence;
    .locals 8
    .param p1, "pmTextView"    # Lcom/poshmark/ui/customviews/PMTextView;
    .param p2, "nameClickListener"    # Lcom/poshmark/utils/TextClickListener;
    .param p3, "string"    # Ljava/lang/String;
    .param p4, "data"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 177
    new-instance v7, Landroid/text/SpannableStringBuilder;

    invoke-direct {v7}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 179
    .local v7, "strBuilder":Landroid/text/SpannableStringBuilder;
    new-instance v6, Landroid/text/SpannableString;

    invoke-direct {v6, p3}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 181
    .local v6, "span":Landroid/text/SpannableString;
    new-instance v0, Lcom/poshmark/utils/PMClickableSpan;

    invoke-virtual {p1}, Lcom/poshmark/ui/customviews/PMTextView;->getFontColor()I

    move-result v3

    invoke-virtual {p1}, Lcom/poshmark/ui/customviews/PMTextView;->getFontName()Ljava/lang/String;

    move-result-object v4

    move-object v1, p4

    move-object v2, p2

    invoke-direct/range {v0 .. v5}, Lcom/poshmark/utils/PMClickableSpan;-><init>(Ljava/lang/String;Lcom/poshmark/utils/TextClickListener;ILjava/lang/String;Z)V

    invoke-virtual {p3}, Ljava/lang/String;->length()I

    move-result v1

    const/16 v2, 0x21

    invoke-virtual {v6, v0, v5, v1, v2}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 183
    invoke-virtual {v7, v6}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 184
    return-object v7
.end method

.method public getClickableUserNameString(Lcom/poshmark/ui/customviews/PMTextView;Lcom/poshmark/utils/TextClickListener;Ljava/lang/String;)Ljava/lang/CharSequence;
    .locals 8
    .param p1, "pmTextView"    # Lcom/poshmark/ui/customviews/PMTextView;
    .param p2, "nameClickListener"    # Lcom/poshmark/utils/TextClickListener;
    .param p3, "name"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 118
    new-instance v7, Landroid/text/SpannableStringBuilder;

    invoke-direct {v7}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 119
    .local v7, "strBuilder":Landroid/text/SpannableStringBuilder;
    new-instance v6, Landroid/text/SpannableString;

    invoke-direct {v6, p3}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 121
    .local v6, "span":Landroid/text/SpannableString;
    new-instance v0, Lcom/poshmark/utils/PMClickableSpan;

    invoke-virtual {p1}, Lcom/poshmark/ui/customviews/PMTextView;->getFontColor()I

    move-result v3

    invoke-virtual {p1}, Lcom/poshmark/ui/customviews/PMTextView;->getFontName()Ljava/lang/String;

    move-result-object v4

    move-object v1, p3

    move-object v2, p2

    invoke-direct/range {v0 .. v5}, Lcom/poshmark/utils/PMClickableSpan;-><init>(Ljava/lang/String;Lcom/poshmark/utils/TextClickListener;ILjava/lang/String;Z)V

    invoke-virtual {p3}, Ljava/lang/String;->length()I

    move-result v1

    const/16 v2, 0x21

    invoke-virtual {v6, v0, v5, v1, v2}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 122
    invoke-virtual {v7, v6}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 123
    return-object v7
.end method

.method public getHtmlStringWithClickableLinks(Lcom/poshmark/ui/customviews/PMTextView;Lcom/poshmark/utils/TextClickListener;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/CharSequence;
    .locals 15
    .param p1, "pmTextView"    # Lcom/poshmark/ui/customviews/PMTextView;
    .param p2, "nameClickListener"    # Lcom/poshmark/utils/TextClickListener;
    .param p3, "htmlString"    # Ljava/lang/String;
    .param p4, "text"    # Ljava/lang/String;

    .prologue
    .line 127
    new-instance v13, Landroid/text/SpannableStringBuilder;

    invoke-direct {v13}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 128
    .local v13, "strBuilder":Landroid/text/SpannableStringBuilder;
    new-instance v11, Landroid/text/SpannableString;

    invoke-static/range {p4 .. p4}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-direct {v11, v1}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 129
    .local v11, "spannableString":Landroid/text/SpannableString;
    const/4 v1, 0x0

    invoke-virtual {v11}, Landroid/text/SpannableString;->length()I

    move-result v2

    const-class v3, Landroid/text/style/URLSpan;

    invoke-virtual {v11, v1, v2, v3}, Landroid/text/SpannableString;->getSpans(IILjava/lang/Class;)[Ljava/lang/Object;

    move-result-object v14

    check-cast v14, [Landroid/text/style/URLSpan;

    .line 131
    .local v14, "urlSPans":[Landroid/text/style/URLSpan;
    move-object v6, v14

    .local v6, "arr$":[Landroid/text/style/URLSpan;
    array-length v9, v6

    .local v9, "len$":I
    const/4 v8, 0x0

    .local v8, "i$":I
    :goto_0
    if-ge v8, v9, :cond_0

    aget-object v10, v6, v8

    .line 132
    .local v10, "span":Landroid/text/style/URLSpan;
    invoke-virtual {v11, v10}, Landroid/text/SpannableString;->getSpanStart(Ljava/lang/Object;)I

    move-result v12

    .line 133
    .local v12, "start":I
    invoke-virtual {v11, v10}, Landroid/text/SpannableString;->getSpanEnd(Ljava/lang/Object;)I

    move-result v7

    .line 134
    .local v7, "end":I
    invoke-virtual {v11, v10}, Landroid/text/SpannableString;->removeSpan(Ljava/lang/Object;)V

    .line 135
    new-instance v0, Lcom/poshmark/utils/view_holders/PMUrlSpan;

    invoke-virtual {v10}, Landroid/text/style/URLSpan;->getURL()Ljava/lang/String;

    move-result-object v1

    invoke-virtual/range {p1 .. p1}, Lcom/poshmark/ui/customviews/PMTextView;->getFontColor()I

    move-result v3

    invoke-virtual/range {p1 .. p1}, Lcom/poshmark/ui/customviews/PMTextView;->getFontName()Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    move-object/from16 v2, p2

    invoke-direct/range {v0 .. v5}, Lcom/poshmark/utils/view_holders/PMUrlSpan;-><init>(Ljava/lang/String;Lcom/poshmark/utils/TextClickListener;ILjava/lang/String;Z)V

    .line 136
    .end local v10    # "span":Landroid/text/style/URLSpan;
    .local v0, "span":Landroid/text/style/URLSpan;
    const/4 v1, 0x0

    invoke-virtual {v11, v0, v12, v7, v1}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 131
    add-int/lit8 v8, v8, 0x1

    goto :goto_0

    .line 139
    .end local v0    # "span":Landroid/text/style/URLSpan;
    .end local v7    # "end":I
    .end local v12    # "start":I
    :cond_0
    invoke-virtual {v13, v11}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 140
    return-object v13
.end method

.method public getPublishedAtMessageString(Lcom/poshmark/data_model/models/ListingSocial;)Ljava/lang/String;
    .locals 10
    .param p1, "feedItem"    # Lcom/poshmark/data_model/models/ListingSocial;

    .prologue
    const v9, 0x7f060181

    const/4 v8, 0x0

    const/4 v7, 0x1

    .line 66
    const/4 v2, 0x0

    .line 67
    .local v2, "prefix":Ljava/lang/String;
    const/4 v0, 0x0

    .line 70
    .local v0, "date":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    .line 72
    .local v3, "resources":Landroid/content/res/Resources;
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingSocial;->hasEventContext()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 75
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingSocial;->getEventContext()Lcom/poshmark/data_model/models/EventContext;

    move-result-object v1

    .line 76
    .local v1, "eventContext":Lcom/poshmark/data_model/models/EventContext;
    iget-object v0, v1, Lcom/poshmark/data_model/models/EventContext;->created_at:Ljava/lang/String;

    .line 77
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingSocial;->getUserId()Ljava/lang/String;

    move-result-object v5

    iget-object v6, v1, Lcom/poshmark/data_model/models/EventContext;->by_id:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 79
    invoke-static {v0, v2}, Lcom/poshmark/utils/DateUtils;->formatDateForDisplay(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 110
    .end local v1    # "eventContext":Lcom/poshmark/data_model/models/EventContext;
    :goto_0
    if-eqz v2, :cond_0

    .line 111
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 113
    .end local v0    # "date":Ljava/lang/String;
    :cond_0
    return-object v0

    .line 81
    .restart local v0    # "date":Ljava/lang/String;
    .restart local v1    # "eventContext":Lcom/poshmark/data_model/models/EventContext;
    :cond_1
    iget-object v4, v1, Lcom/poshmark/data_model/models/EventContext;->by_username:Ljava/lang/String;

    .line 82
    .local v4, "sharedByUserName":Ljava/lang/String;
    invoke-virtual {v3, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 83
    new-array v5, v7, [Ljava/lang/Object;

    aput-object v4, v5, v8

    invoke-static {v2, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 84
    invoke-static {v0, v2}, Lcom/poshmark/utils/DateUtils;->formatDateForDisplay(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 88
    .end local v1    # "eventContext":Lcom/poshmark/data_model/models/EventContext;
    .end local v4    # "sharedByUserName":Ljava/lang/String;
    :cond_2
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingSocial;->getSharedByUserName()Ljava/lang/String;

    move-result-object v4

    .line 90
    .restart local v4    # "sharedByUserName":Ljava/lang/String;
    if-eqz v4, :cond_3

    .line 92
    invoke-virtual {v3, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 96
    new-array v5, v7, [Ljava/lang/Object;

    aput-object v4, v5, v8

    invoke-static {v2, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    .line 97
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingSocial;->getSharedAtTime()Ljava/lang/String;

    move-result-object v0

    .line 98
    invoke-static {v0, v2}, Lcom/poshmark/utils/DateUtils;->formatDateForDisplay(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 99
    :cond_3
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingSocial;->getPublishCount()I

    move-result v5

    if-le v5, v7, :cond_4

    .line 100
    const v5, 0x7f0602b4

    invoke-virtual {v3, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 101
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingSocial;->statusChangedAt()Ljava/lang/String;

    move-result-object v0

    .line 102
    invoke-static {v0, v2}, Lcom/poshmark/utils/DateUtils;->formatDateForDisplay(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 104
    :cond_4
    new-instance v2, Ljava/lang/String;

    .end local v2    # "prefix":Ljava/lang/String;
    const-string v5, ""

    invoke-direct {v2, v5}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    .line 105
    .restart local v2    # "prefix":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingSocial;->getListingDate()Ljava/lang/String;

    move-result-object v0

    .line 106
    invoke-static {v0, v2}, Lcom/poshmark/utils/DateUtils;->formatDateForDisplay(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getPublishedAtTimeString(Lcom/poshmark/data_model/models/ListingSocial;)Ljava/lang/String;
    .locals 8
    .param p1, "feedItem"    # Lcom/poshmark/data_model/models/ListingSocial;

    .prologue
    const/4 v7, 0x0

    .line 34
    const/4 v2, 0x0

    .line 35
    .local v2, "prefix":Ljava/lang/String;
    const/4 v0, 0x0

    .line 38
    .local v0, "date":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplication;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    .line 40
    .local v3, "resources":Landroid/content/res/Resources;
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingSocial;->hasEventContext()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 43
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingSocial;->getEventContext()Lcom/poshmark/data_model/models/EventContext;

    move-result-object v1

    .line 44
    .local v1, "eventContext":Lcom/poshmark/data_model/models/EventContext;
    iget-object v0, v1, Lcom/poshmark/data_model/models/EventContext;->created_at:Ljava/lang/String;

    .line 61
    .end local v1    # "eventContext":Lcom/poshmark/data_model/models/EventContext;
    :goto_0
    return-object v0

    .line 47
    :cond_0
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingSocial;->getSharedByUserName()Ljava/lang/String;

    move-result-object v4

    .line 49
    .local v4, "sharedByUserName":Ljava/lang/String;
    if-eqz v4, :cond_1

    .line 50
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingSocial;->getSharedAtTime()Ljava/lang/String;

    move-result-object v0

    .line 51
    invoke-static {v0, v7}, Lcom/poshmark/utils/DateUtils;->formatDateForDisplay(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 52
    :cond_1
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingSocial;->getPublishCount()I

    move-result v5

    const/4 v6, 0x1

    if-le v5, v6, :cond_2

    .line 53
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingSocial;->statusChangedAt()Ljava/lang/String;

    move-result-object v0

    .line 54
    invoke-static {v0, v7}, Lcom/poshmark/utils/DateUtils;->formatDateForDisplay(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 56
    :cond_2
    invoke-virtual {p1}, Lcom/poshmark/data_model/models/ListingSocial;->getListingDate()Ljava/lang/String;

    move-result-object v0

    .line 57
    invoke-static {v0, v7}, Lcom/poshmark/utils/DateUtils;->formatDateForDisplay(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
