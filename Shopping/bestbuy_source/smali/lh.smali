.class public Llh;
.super Landroid/app/Dialog;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Llg;


# instance fields
.field private a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

.field private b:Landroid/widget/ImageView;

.field private c:Landroid/content/Context;

.field private d:Landroid/widget/RelativeLayout;

.field private e:Landroid/widget/RelativeLayout;

.field private f:Lnb;

.field private g:Ljava/lang/String;

.field private h:Lcom/bestbuy/android/api/lib/models/remix/Store;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/bestbuy/android/api/lib/models/store/BBYStore;Lcom/bestbuy/android/api/lib/models/remix/Store;)V
    .locals 1

    .prologue
    .line 56
    const v0, 0x7f0e0028

    invoke-direct {p0, p1, v0}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 57
    iput-object p1, p0, Llh;->c:Landroid/content/Context;

    .line 58
    iput-object p2, p0, Llh;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 59
    iput-object p3, p0, Llh;->h:Lcom/bestbuy/android/api/lib/models/remix/Store;

    .line 60
    return-void
.end method

.method static synthetic a(Llh;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Llh;->c:Landroid/content/Context;

    return-object v0
.end method

.method private a(Ljava/util/ArrayList;)Ljava/lang/String;
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/DetailedHours;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 109
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    .line 110
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    .line 111
    const-string v0, ""

    .line 112
    const/4 v0, 0x0

    .line 113
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v7

    move v2, v0

    :goto_0
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/DetailedHours;

    .line 114
    new-instance v8, Ljava/text/SimpleDateFormat;

    const-string v1, "MMM.dd"

    invoke-direct {v8, v1}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 115
    invoke-static {}, Ljava/util/Calendar;->getInstance()Ljava/util/Calendar;

    move-result-object v1

    .line 116
    invoke-virtual {v1}, Ljava/util/Calendar;->getTime()Ljava/util/Date;

    move-result-object v1

    invoke-virtual {v8, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v9

    .line 117
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/DetailedHours;->getOpen()Ljava/lang/String;

    move-result-object v3

    .line 118
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/DetailedHours;->getClose()Ljava/lang/String;

    move-result-object v1

    .line 119
    iget-object v4, p0, Llh;->c:Landroid/content/Context;

    invoke-static {v4}, Landroid/text/format/DateFormat;->is24HourFormat(Landroid/content/Context;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 120
    new-instance v10, Ljava/text/SimpleDateFormat;

    const-string v4, "HH:mm"

    invoke-direct {v10, v4}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 121
    new-instance v11, Ljava/text/SimpleDateFormat;

    const-string v4, "h:mm aa"

    invoke-direct {v11, v4}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 123
    :try_start_0
    invoke-virtual {v10, v1}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v4

    .line 124
    invoke-virtual {v11, v4}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/text/ParseException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    .line 125
    :try_start_1
    invoke-virtual {v10, v3}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v1

    .line 126
    invoke-virtual {v11, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v3

    .line 127
    invoke-virtual {v3}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v3

    .line 128
    invoke-virtual {v4}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;
    :try_end_1
    .catch Ljava/text/ParseException; {:try_start_1 .. :try_end_1} :catch_2

    move-result-object v1

    .line 135
    :cond_0
    :goto_1
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " - "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "\n"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 136
    new-instance v4, Ljava/text/SimpleDateFormat;

    const-string v3, "yyyy-MM-dd"

    invoke-direct {v4, v3}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 137
    const/4 v3, 0x0

    .line 139
    :try_start_2
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/DetailedHours;->getDate()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v4, v10}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;
    :try_end_2
    .catch Ljava/text/ParseException; {:try_start_2 .. :try_end_2} :catch_1

    move-result-object v3

    .line 143
    :goto_2
    invoke-virtual {v8, v3}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v4

    .line 145
    invoke-virtual {v9, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 146
    const/4 v3, 0x1

    .line 147
    :goto_3
    if-eqz v3, :cond_1

    .line 148
    invoke-virtual {v9, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 149
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Today, "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "\n"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 150
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "<span class=\'bold\'>"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "</span>"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 151
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "<span class=\'bold\'>"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "</span>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    move-object v1, v2

    .line 154
    :goto_4
    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 155
    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_1
    move v2, v3

    .line 157
    goto/16 :goto_0

    .line 129
    :catch_0
    move-exception v4

    move-object v12, v4

    move-object v4, v1

    move-object v1, v12

    .line 130
    :goto_5
    invoke-virtual {v1}, Ljava/text/ParseException;->printStackTrace()V

    .line 131
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "am"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 132
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "pm"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_1

    .line 140
    :catch_1
    move-exception v4

    .line 141
    invoke-virtual {v4}, Ljava/text/ParseException;->printStackTrace()V

    goto/16 :goto_2

    .line 153
    :cond_2
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/DetailedHours;->getDay()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ", "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "\n"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    move-object v12, v1

    move-object v1, v0

    move-object v0, v12

    goto :goto_4

    .line 158
    :cond_3
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 159
    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "&"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 160
    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    return-object v0

    .line 129
    :catch_2
    move-exception v1

    goto/16 :goto_5

    :cond_4
    move v3, v2

    goto/16 :goto_3
.end method

.method private a()V
    .locals 0

    .prologue
    .line 105
    invoke-super {p0}, Landroid/app/Dialog;->cancel()V

    .line 106
    return-void
.end method

.method private a(Landroid/net/Uri;)V
    .locals 3

    .prologue
    .line 244
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Llh;->c:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 245
    const-string v1, "<font face = \'Sans-Serif\'>Get directions?</font>"

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 246
    const-string v1, "<font face = \'Sans-Serif\'><b>Confirm</b></font>"

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    new-instance v2, Llh$1;

    invoke-direct {v2, p0, p1}, Llh$1;-><init>(Llh;Landroid/net/Uri;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 258
    const-string v1, "<font face = \'Sans-Serif\'>Cancel</font>"

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    new-instance v2, Llh$2;

    invoke-direct {v2, p0}, Llh$2;-><init>(Llh;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 265
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 266
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 267
    const v1, 0x102000b

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 268
    const/16 v1, 0x11

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setGravity(I)V

    .line 271
    return-void
.end method

.method static synthetic b(Llh;)Lcom/bestbuy/android/api/lib/models/store/BBYStore;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Llh;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    return-object v0
.end method

.method private b()V
    .locals 3

    .prologue
    .line 274
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Llh;->c:Landroid/content/Context;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 275
    const-string v1, "<font face = \'Sans-Serif\'>Do you want to call the Best Buy BBYStore?</font>"

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 276
    const-string v1, "<font face = \'Sans-Serif\'>Yes</font>"

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    new-instance v2, Llh$3;

    invoke-direct {v2, p0}, Llh$3;-><init>(Llh;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 285
    const-string v1, "<font face = \'Sans-Serif\'>No</font>"

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    new-instance v2, Llh$4;

    invoke-direct {v2, p0}, Llh$4;-><init>(Llh;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 292
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 293
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 294
    const v1, 0x102000b

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 295
    const/16 v1, 0x11

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setGravity(I)V

    .line 296
    return-void
.end method


# virtual methods
.method public a(Z)V
    .locals 0

    .prologue
    .line 301
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 165
    iget-object v0, p0, Llh;->b:Landroid/widget/ImageView;

    if-ne p1, v0, :cond_1

    .line 166
    invoke-direct {p0}, Llh;->a()V

    .line 176
    :cond_0
    :goto_0
    return-void

    .line 167
    :cond_1
    iget-object v0, p0, Llh;->d:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_2

    .line 168
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Llh;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getAddress()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Llh;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getCity()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Llh;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getState()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, " "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Llh;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getZipCode()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 169
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Llh;->c:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0801d0

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Llh;->f:Lnb;

    invoke-virtual {v2}, Lnb;->y()D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Llh;->f:Lnb;

    invoke-virtual {v2}, Lnb;->z()D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "&daddr="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "&hl=en"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    .line 172
    invoke-direct {p0, v0}, Llh;->a(Landroid/net/Uri;)V

    goto/16 :goto_0

    .line 173
    :cond_2
    iget-object v0, p0, Llh;->e:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_0

    .line 174
    invoke-direct {p0}, Llh;->b()V

    goto/16 :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 10

    .prologue
    const/4 v9, 0x6

    const/4 v8, 0x3

    const/4 v7, 0x0

    .line 63
    invoke-super {p0, p1}, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V

    .line 64
    const v0, 0x7f0300f9

    invoke-virtual {p0, v0}, Llh;->setContentView(I)V

    .line 65
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Llh;->f:Lnb;

    .line 66
    const v0, 0x7f0c03c1

    invoke-virtual {p0, v0}, Llh;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Llh;->b:Landroid/widget/ImageView;

    .line 67
    const v0, 0x7f0c03c2

    invoke-virtual {p0, v0}, Llh;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Llh;->d:Landroid/widget/RelativeLayout;

    .line 68
    const v0, 0x7f0c03c3

    invoke-virtual {p0, v0}, Llh;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Llh;->e:Landroid/widget/RelativeLayout;

    .line 69
    const v0, 0x7f0c0025

    invoke-virtual {p0, v0}, Llh;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 70
    const v1, 0x7f0c03c4

    invoke-virtual {p0, v1}, Llh;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 71
    const v2, 0x7f0c03c6

    invoke-virtual {p0, v2}, Llh;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 72
    const v3, 0x7f0c03c5

    invoke-virtual {p0, v3}, Llh;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 73
    const v4, 0x7f0c03c7

    invoke-virtual {p0, v4}, Llh;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 74
    iget-object v5, p0, Llh;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    if-eqz v5, :cond_1

    .line 75
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v6, p0, Llh;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v6

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getAddress()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "\n"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Llh;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v6

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getCity()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ", "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Llh;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v6

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getState()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Llh;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v6

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getZipCode()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    iput-object v5, p0, Llh;->g:Ljava/lang/String;

    .line 76
    iget-object v5, p0, Llh;->g:Ljava/lang/String;

    invoke-virtual {v0, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 77
    iget-object v0, p0, Llh;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getPhone()Ljava/lang/String;

    move-result-object v0

    .line 78
    const-string v5, "\\D"

    const-string v6, ""

    invoke-virtual {v0, v5, v6}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 79
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "("

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0, v7, v8}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ") "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0, v8, v9}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "-"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const/16 v6, 0xa

    invoke-virtual {v0, v9, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 81
    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 82
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 83
    iget-object v1, p0, Llh;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getDetailedHours()[Lcom/bestbuy/android/api/lib/models/store/DetailedHours;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 84
    iget-object v1, p0, Llh;->a:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getDetailedHours()[Lcom/bestbuy/android/api/lib/models/store/DetailedHours;

    move-result-object v1

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 85
    invoke-direct {p0, v0}, Llh;->a(Ljava/util/ArrayList;)Ljava/lang/String;

    move-result-object v0

    .line 86
    const-string v1, "&"

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 88
    :try_start_0
    iget-object v1, p0, Llh;->c:Landroid/content/Context;

    const/4 v5, 0x0

    aget-object v5, v0, v5

    const/16 v6, 0x12c

    invoke-static {v1, v3, v5, v6}, Llt;->a(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;I)V

    .line 89
    iget-object v1, p0, Llh;->c:Landroid/content/Context;

    const/4 v3, 0x1

    aget-object v0, v0, v3

    const/16 v3, 0x12c

    invoke-static {v1, v2, v0, v3}, Llt;->a(Landroid/content/Context;Landroid/widget/TextView;Ljava/lang/String;I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 94
    :cond_0
    :goto_0
    iget-object v0, p0, Llh;->h:Lcom/bestbuy/android/api/lib/models/remix/Store;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/remix/Store;->getServices()Ljava/lang/String;

    move-result-object v0

    .line 95
    const-string v1, ","

    invoke-virtual {v0, v1}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 96
    const-string v1, ""

    invoke-static {v1, v0}, Lli;->a(Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 97
    invoke-static {v0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v0

    invoke-virtual {v4, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/CharSequence;)V

    .line 99
    :cond_1
    iget-object v0, p0, Llh;->b:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 100
    iget-object v0, p0, Llh;->d:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 101
    iget-object v0, p0, Llh;->e:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 102
    return-void

    .line 90
    :catch_0
    move-exception v0

    .line 91
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method
