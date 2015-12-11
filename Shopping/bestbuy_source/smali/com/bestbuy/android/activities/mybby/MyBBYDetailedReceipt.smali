.class public Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/String;

.field private b:Lcom/bestbuy/android/api/lib/models/mybby/Transaction;

.field private c:Landroid/view/LayoutInflater;

.field private g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private j:Landroid/widget/LinearLayout;

.field private k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private m:Landroid/widget/LinearLayout;

.field private n:Ljava/lang/String;

.field private o:Landroid/view/View;

.field private p:Landroid/view/View;

.field private q:Ljava/lang/String;

.field private r:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private s:Lcom/bestbuy/android/bbyobjects/BBYTextView;


# direct methods
.method private a(D)Ljava/lang/String;
    .locals 3

    .prologue
    .line 265
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->q:Ljava/lang/String;

    return-object v0
.end method

.method private a(Ljava/lang/String;)Ljava/lang/String;
    .locals 4

    .prologue
    .line 255
    .line 257
    :try_start_0
    const-string v0, "%.2f"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    invoke-static {p1}, Ljava/lang/Float;->valueOf(Ljava/lang/String;)Ljava/lang/Float;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v3

    aput-object v3, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p1

    .line 261
    :goto_0
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "$"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 258
    :catch_0
    move-exception v0

    .line 259
    iget-object v1, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->a:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Error attempting to parse price.  Continuing with poorly formatted price: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lkf;->c(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private a(Landroid/content/Context;Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 206
    new-instance v0, Landroid/app/AlertDialog$Builder;

    invoke-direct {v0, p1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 207
    const-string v1, "<font face = \'Sans-Serif\'>Do you want to call the Store?</font>"

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 208
    const-string v1, "<font face = \'Sans-Serif\'>Yes</font>"

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    new-instance v2, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt$4;

    invoke-direct {v2, p0, p2, p1}, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt$4;-><init>(Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;Ljava/lang/String;Landroid/content/Context;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 217
    const-string v1, "<font face = \'Sans-Serif\'>No</font>"

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    new-instance v2, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt$5;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt$5;-><init>(Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 224
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    .line 225
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    .line 226
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;Landroid/content/Context;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0, p1, p2}, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->a(Landroid/content/Context;Ljava/lang/String;)V

    return-void
.end method

.method private b()D
    .locals 4

    .prologue
    .line 229
    const-wide/16 v0, 0x0

    .line 231
    :try_start_0
    iget-object v2, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->b:Lcom/bestbuy/android/api/lib/models/mybby/Transaction;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->getTotalRevenue()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Double;->valueOf(Ljava/lang/String;)Ljava/lang/Double;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Double;->doubleValue()D
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v0

    .line 235
    :goto_0
    return-wide v0

    .line 232
    :catch_0
    move-exception v2

    .line 233
    iget-object v3, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->a:Ljava/lang/String;

    invoke-static {v3, v2}, Lkf;->a(Ljava/lang/String;Ljava/lang/Exception;)V

    goto :goto_0
.end method

.method private c()D
    .locals 2

    .prologue
    .line 240
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->b:Lcom/bestbuy/android/api/lib/models/mybby/Transaction;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->getTotalTax()Ljava/lang/String;

    move-result-object v0

    const v1, 0x7f080068

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 241
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->b:Lcom/bestbuy/android/api/lib/models/mybby/Transaction;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->getTotalTax()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    .line 246
    :goto_0
    return-wide v0

    .line 243
    :cond_0
    const-string v0, "0.0"

    invoke-static {v0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    goto :goto_0
.end method

.method private d()Ljava/lang/String;
    .locals 6

    .prologue
    .line 250
    new-instance v0, Ljava/text/DecimalFormat;

    const-string v1, "0.00"

    invoke-direct {v0, v1}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;)V

    .line 251
    invoke-direct {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->b()D

    move-result-wide v2

    invoke-direct {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->c()D

    move-result-wide v4

    add-double/2addr v2, v4

    invoke-virtual {v0, v2, v3}, Ljava/text/NumberFormat;->format(D)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/remix/Store;)V
    .locals 14

    .prologue
    const v13, 0x7f0c01a8

    const/16 v12, 0x8

    const/4 v7, 0x0

    .line 109
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->o:Landroid/view/View;

    const v1, 0x7f0c01ab

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 110
    iget-object v1, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->b:Lcom/bestbuy/android/api/lib/models/mybby/Transaction;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->getSaleLineItems()Ljava/util/ArrayList;

    move-result-object v8

    .line 112
    invoke-virtual {v8}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v9

    move v6, v7

    :goto_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_3

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;

    .line 113
    iget-object v2, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->c:Landroid/view/LayoutInflater;

    const v3, 0x7f03007b

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v10

    .line 115
    iget-object v2, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->r:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v2, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 116
    iget-object v2, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v2, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 118
    const v2, 0x7f0c01cf

    invoke-virtual {v10, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 119
    invoke-virtual {v2, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 120
    const v3, 0x7f0c01d0

    invoke-virtual {v10, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 121
    invoke-virtual {v3, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 122
    const v4, 0x7f0c01d1

    invoke-virtual {v10, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 123
    invoke-virtual {v4, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 124
    const v5, 0x7f0c01d2

    invoke-virtual {v10, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/ImageView;

    .line 125
    invoke-virtual {v5, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 126
    invoke-virtual {v0, v10}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 128
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->getDescription()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v2, v11}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 129
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->getProductSku()Ljava/lang/String;

    move-result-object v11

    iput-object v11, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->q:Ljava/lang/String;

    .line 130
    new-instance v11, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt$1;

    invoke-direct {v11, p0}, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt$1;-><init>(Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;)V

    invoke-virtual {v2, v11}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 140
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->getAmount()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 141
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Qty: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->getQuantity()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v4, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 142
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 143
    const-string v3, "ProductTitle"

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->getDescription()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 144
    sget-object v3, Llu;->ab:Ljava/lang/String;

    invoke-static {v3, v2}, Llu;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 146
    if-nez v6, :cond_0

    .line 147
    const v2, 0x7f020088

    invoke-virtual {v10, v2}, Landroid/view/View;->setBackgroundResource(I)V

    .line 148
    invoke-virtual {v10, v13}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2, v7}, Landroid/view/View;->setVisibility(I)V

    .line 156
    :goto_1
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->getAmount()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->getAmount()Ljava/lang/String;

    move-result-object v2

    const-string v3, "0.00"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_2

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/mybby/Transaction$TransactionLineItem;->getProductSku()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 159
    invoke-virtual {v5, v12}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 165
    :goto_2
    add-int/lit8 v1, v6, 0x1

    move v6, v1

    .line 166
    goto/16 :goto_0

    .line 149
    :cond_0
    invoke-virtual {v8}, Ljava/util/ArrayList;->size()I

    move-result v2

    add-int/lit8 v2, v2, -0x1

    if-ne v6, v2, :cond_1

    .line 150
    const v2, 0x7f020086

    invoke-virtual {v10, v2}, Landroid/view/View;->setBackgroundResource(I)V

    .line 151
    invoke-virtual {v10, v13}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2, v12}, Landroid/view/View;->setVisibility(I)V

    goto :goto_1

    .line 153
    :cond_1
    const v2, 0x7f020087

    invoke-virtual {v10, v2}, Landroid/view/View;->setBackgroundResource(I)V

    .line 154
    invoke-virtual {v10, v13}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2, v7}, Landroid/view/View;->setVisibility(I)V

    goto :goto_1

    .line 162
    :cond_2
    invoke-virtual {v5, v12}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_2

    .line 168
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-direct {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->b()D

    move-result-wide v2

    invoke-direct {p0, v2, v3}, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->a(D)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 169
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-direct {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->c()D

    move-result-wide v2

    invoke-direct {p0, v2, v3}, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->a(D)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 170
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-direct {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->d()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 172
    if-eqz p1, :cond_4

    .line 173
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->o:Landroid/view/View;

    const v1, 0x7f0c01b2

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    invoke-virtual {v0, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 174
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "phone"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/telephony/TelephonyManager;

    invoke-virtual {v0}, Landroid/telephony/TelephonyManager;->getPhoneType()I

    move-result v0

    if-nez v0, :cond_5

    .line 176
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->j:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v12}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 190
    :goto_3
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/remix/Store;->getName()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_7

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/remix/Store;->getStoreId()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_7

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/remix/Store;->getRegion()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_7

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/remix/Store;->getPostalCode()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_7

    .line 191
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "View "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/remix/Store;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->toUpperCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 192
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->m:Landroid/widget/LinearLayout;

    new-instance v1, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt$3;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt$3;-><init>(Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;)V

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 203
    :cond_4
    :goto_4
    return-void

    .line 178
    :cond_5
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/remix/Store;->getPhone()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_6

    .line 179
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Call "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/remix/Store;->getPhone()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 180
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/remix/Store;->getPhone()Ljava/lang/String;

    move-result-object v0

    .line 181
    iget-object v1, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->j:Landroid/widget/LinearLayout;

    new-instance v2, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt$2;

    invoke-direct {v2, p0, v0}, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt$2;-><init>(Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_3

    .line 187
    :cond_6
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->j:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v12}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_3

    .line 200
    :cond_7
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->m:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v12}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_4
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 61
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 62
    iput-object p1, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->d:Landroid/app/Activity;

    .line 63
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 67
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 69
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 6

    .prologue
    const/16 v5, 0x8

    .line 75
    const v0, 0x7f030075

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->o:Landroid/view/View;

    .line 76
    iput-object p1, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->c:Landroid/view/LayoutInflater;

    .line 77
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->o:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->p:Landroid/view/View;

    .line 78
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->o:Landroid/view/View;

    const v1, 0x7f0c01aa

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->r:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 79
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->o:Landroid/view/View;

    const v1, 0x7f0c01ac

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 81
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->o:Landroid/view/View;

    const v1, 0x7f0c01ae

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 82
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->o:Landroid/view/View;

    const v1, 0x7f0c01b0

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 83
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->o:Landroid/view/View;

    const v1, 0x7f0c01b1

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 84
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->o:Landroid/view/View;

    const v1, 0x7f0c01b3

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->m:Landroid/widget/LinearLayout;

    .line 85
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->o:Landroid/view/View;

    const v1, 0x7f0c01b5

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->j:Landroid/widget/LinearLayout;

    .line 86
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->o:Landroid/view/View;

    const v1, 0x7f0c01b4

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 87
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->o:Landroid/view/View;

    const v1, 0x7f0c01b6

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 88
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->o:Landroid/view/View;

    const v1, 0x7f0c01a7

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 89
    iget-object v1, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->o:Landroid/view/View;

    const v2, 0x7f0c01a9

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 92
    new-instance v2, Ljava/text/SimpleDateFormat;

    const-string v3, "MMM d, yyyy"

    sget-object v4, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-direct {v2, v3, v4}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;Ljava/util/Locale;)V

    .line 93
    iget-object v3, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->b:Lcom/bestbuy/android/api/lib/models/mybby/Transaction;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->getDate()Ljava/util/Date;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 96
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->b:Lcom/bestbuy/android/api/lib/models/mybby/Transaction;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->getPoints()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 97
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->b:Lcom/bestbuy/android/api/lib/models/mybby/Transaction;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/mybby/Transaction;->getStoreID()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->n:Ljava/lang/String;

    .line 98
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->n:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->n:Ljava/lang/String;

    const-string v1, "960"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 99
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->m:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 101
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->j:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 103
    :cond_0
    new-instance v0, Ljx;

    iget-object v1, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->p:Landroid/view/View;

    iget-object v3, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->n:Ljava/lang/String;

    invoke-direct {v0, v1, p0, v2, v3}, Ljx;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljx;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 104
    iget-object v0, p0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->o:Landroid/view/View;

    return-object v0
.end method
