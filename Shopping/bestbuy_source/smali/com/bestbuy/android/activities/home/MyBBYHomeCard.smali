.class public Lcom/bestbuy/android/activities/home/MyBBYHomeCard;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# static fields
.field private static final a:Ljava/lang/String;


# instance fields
.field private b:Lmr;

.field private c:Landroid/widget/RelativeLayout;

.field private g:Landroid/widget/RelativeLayout;

.field private h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private j:Lnb;

.field private k:Landroid/widget/ImageView;

.field private l:Landroid/view/View;

.field private m:Landroid/widget/RelativeLayout;

.field private n:Landroid/view/View;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 44
    const-class v0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 56
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 45
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->b:Lmr;

    .line 57
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/home/MyBBYHomeCard;)Lcom/bestbuy/android/bbyobjects/BBYTextView;
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    return-object v0
.end method

.method private a(Ljava/lang/String;)Ljava/lang/String;
    .locals 4

    .prologue
    .line 124
    :try_start_0
    invoke-static {}, Ljava/text/NumberFormat;->getInstance()Ljava/text/NumberFormat;

    move-result-object v0

    .line 125
    invoke-static {p1}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Ljava/text/NumberFormat;->format(J)Ljava/lang/String;

    move-result-object v0

    .line 126
    sget-object v1, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->a:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "addDelimiters() formatedString="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lkf;->b(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-object p1, v0

    .line 130
    :goto_0
    return-object p1

    .line 128
    :catch_0
    move-exception v0

    .line 129
    sget-object v1, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->a:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "addDelimiters() e="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lkf;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;)V
    .locals 10

    .prologue
    const/16 v4, 0x8

    const/4 v9, 0x2

    const/4 v8, 0x1

    const/4 v7, -0x2

    const/4 v2, 0x0

    .line 157
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->j:Lnb;

    if-eqz v0, :cond_0

    .line 158
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->j:Lnb;

    invoke-virtual {v0, v2}, Lnb;->o(Z)V

    .line 161
    :cond_0
    if-nez p1, :cond_c

    .line 162
    invoke-static {}, Lfr;->h()Ljava/lang/String;

    move-result-object v0

    .line 166
    :goto_0
    invoke-static {}, Lfr;->e()Ljava/lang/String;

    move-result-object v1

    .line 167
    if-eqz v1, :cond_11

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_11

    .line 168
    iget-object v3, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->g:Landroid/widget/RelativeLayout;

    invoke-virtual {v3, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 169
    iget-object v3, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->c:Landroid/widget/RelativeLayout;

    invoke-virtual {v3, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 170
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_1

    .line 171
    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    .line 172
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v2}, Ljava/lang/String;->charAt(I)C

    move-result v4

    invoke-static {v4}, Ljava/lang/Character;->toString(C)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1, v8}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 174
    :cond_1
    iget-object v3, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v3, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 175
    if-eqz v1, :cond_d

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v3

    const/16 v4, 0x19

    if-le v3, v4, :cond_d

    .line 176
    iget-object v3, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setSingleLine()V

    .line 177
    iget-object v3, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    sget-object v4, Landroid/text/TextUtils$TruncateAt;->END:Landroid/text/TextUtils$TruncateAt;

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V

    .line 178
    iget-object v3, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v3

    .line 179
    new-instance v4, Lcom/bestbuy/android/activities/home/MyBBYHomeCard$1;

    invoke-direct {v4, p0}, Lcom/bestbuy/android/activities/home/MyBBYHomeCard$1;-><init>(Lcom/bestbuy/android/activities/home/MyBBYHomeCard;)V

    invoke-virtual {v3, v4}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 196
    :goto_1
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_3

    .line 197
    :cond_2
    const-string v0, "0"

    .line 199
    :cond_3
    iget-object v3, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->d:Landroid/app/Activity;

    invoke-static {v3}, Lnf;->b(Landroid/content/Context;)I

    move-result v3

    .line 201
    invoke-static {}, Lfr;->l()Z

    move-result v4

    if-nez v4, :cond_8

    .line 202
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->a(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, " Points"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    .line 204
    if-eqz v1, :cond_12

    if-eqz v4, :cond_12

    .line 205
    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v0

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v5

    add-int/2addr v0, v5

    add-int/lit8 v0, v0, 0x1

    .line 207
    :goto_2
    new-instance v5, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v6, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->d:Landroid/app/Activity;

    invoke-direct {v5, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;-><init>(Landroid/content/Context;)V

    iput-object v5, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 209
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v5

    const/16 v6, 0xa

    if-le v5, v6, :cond_4

    .line 210
    iget-object v5, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/high16 v6, 0x41700000    # 15.0f

    invoke-virtual {v5, v9, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextSize(IF)V

    .line 212
    :cond_4
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v5

    const/16 v6, 0xc

    if-le v5, v6, :cond_5

    .line 213
    iget-object v5, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/high16 v6, 0x41600000    # 14.0f

    invoke-virtual {v5, v9, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextSize(IF)V

    .line 215
    :cond_5
    iget-object v5, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v5, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 216
    iget-object v4, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/4 v5, -0x1

    invoke-virtual {v4, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    .line 217
    new-instance v4, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v4, v7, v7}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 218
    const/16 v5, 0x2ec

    if-ge v3, v5, :cond_6

    const/16 v5, 0x17

    if-gt v0, v5, :cond_7

    :cond_6
    if-eqz v1, :cond_e

    const/16 v0, 0x2ec

    if-lt v3, v0, :cond_e

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v0

    const/16 v1, 0x14

    if-le v0, v1, :cond_e

    .line 219
    :cond_7
    const/4 v0, 0x3

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getId()I

    move-result v1

    invoke-virtual {v4, v0, v1}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    .line 223
    :goto_3
    const/high16 v0, 0x41200000    # 10.0f

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->d:Landroid/app/Activity;

    invoke-static {v0, v1}, Lnf;->b(FLandroid/content/Context;)I

    move-result v0

    invoke-virtual {v4, v0, v2, v2, v2}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 224
    const/16 v0, 0xf

    invoke-virtual {v4, v0}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 225
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->g:Landroid/widget/RelativeLayout;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v1, v4}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 227
    :cond_8
    invoke-static {}, Lfr;->j()Ljava/lang/String;

    move-result-object v0

    .line 228
    if-eqz v0, :cond_f

    const-string v1, "10150"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_f

    .line 229
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->k:Landroid/widget/ImageView;

    const v1, 0x7f02012d

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 235
    :cond_9
    :goto_4
    invoke-static {}, Lfr;->g()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Ljava/lang/String;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    .line 236
    if-eqz v0, :cond_a

    invoke-static {}, Lfr;->k()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_a

    invoke-static {}, Lfr;->k()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_a

    .line 237
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->m:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 238
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->m:Landroid/widget/RelativeLayout;

    const v1, 0x7f0c012a

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 239
    invoke-static {}, Lfr;->k()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 246
    :cond_a
    :goto_5
    if-eqz p1, :cond_b

    .line 248
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->d:Landroid/app/Activity;

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    if-eqz v0, :cond_b

    .line 249
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->buildSideMenu()V

    .line 252
    :cond_b
    return-void

    .line 164
    :cond_c
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;->getEntities()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entity;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entity;->getPointsBalance()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_0

    .line 192
    :cond_d
    iget-object v3, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v3, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 193
    iget-object v3, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setSingleLine()V

    .line 194
    iget-object v3, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    sget-object v4, Landroid/text/TextUtils$TruncateAt;->END:Landroid/text/TextUtils$TruncateAt;

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V

    goto/16 :goto_1

    .line 221
    :cond_e
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getId()I

    move-result v0

    invoke-virtual {v4, v8, v0}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    goto/16 :goto_3

    .line 230
    :cond_f
    if-eqz v0, :cond_10

    const-string v1, "10067"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_10

    .line 231
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->k:Landroid/widget/ImageView;

    const v1, 0x7f02012c

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_4

    .line 232
    :cond_10
    if-eqz v0, :cond_9

    const-string v1, "10130"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 233
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->k:Landroid/widget/ImageView;

    const v1, 0x7f02012a

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_4

    .line 242
    :cond_11
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->g:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 243
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->c:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_5

    :cond_12
    move v0, v2

    goto/16 :goto_2
.end method

.method public b()V
    .locals 6

    .prologue
    .line 118
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->j:Lnb;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lnb;->m(Z)V

    .line 119
    new-instance v0, Lio;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->d:Landroid/app/Activity;

    const/4 v3, 0x0

    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v4

    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v5

    move-object v2, p0

    invoke-direct/range {v0 .. v5}, Lio;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Landroid/os/AsyncTask;->SERIAL_EXECUTOR:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lio;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 120
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 82
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 83
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->d:Landroid/app/Activity;

    .line 84
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 136
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->n:Landroid/view/View;

    if-ne p1, v0, :cond_4

    .line 137
    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 138
    :cond_0
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->d:Landroid/app/Activity;

    const-class v2, Lcom/bestbuy/android/activities/mybby/MyBBYHomeActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 139
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->d:Landroid/app/Activity;

    const/16 v2, 0x1ed2

    invoke-virtual {v1, v0, v2}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 140
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->d:Landroid/app/Activity;

    const v1, 0x7f04000e

    const v2, 0x7f040005

    invoke-virtual {v0, v1, v2}, Landroid/app/Activity;->overridePendingTransition(II)V

    .line 154
    :cond_1
    :goto_0
    return-void

    .line 142
    :cond_2
    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_3

    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 143
    :cond_3
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->openLeftNavigation()V

    goto :goto_0

    .line 146
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->m:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_1

    .line 147
    new-instance v1, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;

    invoke-direct {v1}, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;-><init>()V

    .line 148
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 149
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 150
    const v2, 0x7f0c0033

    const-string v3, "EmptyWeddingRegistryContainer"

    invoke-virtual {v0, v2, v1, v3}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 151
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/support/v4/app/FragmentTransaction;

    .line 152
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 60
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 61
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 65
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->j:Lnb;

    .line 66
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->j:Lnb;

    invoke-virtual {v0}, Lnb;->w()Lmr;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->b:Lmr;

    .line 67
    const v0, 0x7f030051

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->n:Landroid/view/View;

    .line 68
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->n:Landroid/view/View;

    const v1, 0x7f0c0126

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->l:Landroid/view/View;

    .line 69
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->n:Landroid/view/View;

    const v1, 0x7f0c0123

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->c:Landroid/widget/RelativeLayout;

    .line 70
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->n:Landroid/view/View;

    const v1, 0x7f0c0124

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->g:Landroid/widget/RelativeLayout;

    .line 71
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->n:Landroid/view/View;

    const v1, 0x7f0c0125

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 73
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->n:Landroid/view/View;

    const v1, 0x7f0c0122

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->k:Landroid/widget/ImageView;

    .line 74
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->n:Landroid/view/View;

    const v1, 0x7f0c0127

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->m:Landroid/widget/RelativeLayout;

    .line 75
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->n:Landroid/view/View;

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 76
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->m:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 77
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->n:Landroid/view/View;

    return-object v0
.end method

.method public onDetach()V
    .locals 2

    .prologue
    .line 88
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDetach()V

    .line 89
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->j:Lnb;

    if-eqz v0, :cond_0

    .line 90
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->j:Lnb;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lnb;->o(Z)V

    .line 92
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 4

    .prologue
    const/16 v3, 0x8

    const/4 v2, 0x0

    .line 95
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 96
    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    .line 97
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->j:Lnb;

    invoke-virtual {v0}, Lnb;->w()Lmr;

    move-result-object v0

    .line 98
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->j:Lnb;

    invoke-virtual {v1}, Lnb;->ac()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 99
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->a(Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;)V

    .line 100
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->b()V

    .line 114
    :goto_0
    return-void

    .line 102
    :cond_0
    if-eqz v0, :cond_1

    .line 103
    invoke-virtual {v0}, Lmr;->a()Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;

    move-result-object v0

    .line 104
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->a(Lcom/bestbuy/android/api/lib/models/registry/LoggedInUserProfile;)V

    goto :goto_0

    .line 106
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->g:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 107
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->c:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_0

    .line 111
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->g:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 112
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/MyBBYHomeCard;->c:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_0
.end method
