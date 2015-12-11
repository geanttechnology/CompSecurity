.class public Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Landroid/app/Activity;

.field private b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

.field private c:Landroid/view/View;

.field private g:Landroid/widget/FrameLayout;

.field private h:Landroid/widget/ImageView;

.field private i:Landroid/view/LayoutInflater;

.field private j:Landroid/widget/RelativeLayout;

.field private k:Landroid/widget/LinearLayout;

.field private l:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 47
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 45
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->l:Z

    .line 49
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V
    .locals 1

    .prologue
    .line 51
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 45
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->l:Z

    .line 52
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 53
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 35
    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->c(Ljava/util/List;)V

    return-void
.end method

.method private a(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 248
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->g:Landroid/widget/FrameLayout;

    const v1, 0x7f0c0224

    invoke-virtual {v0, v1}, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 249
    const v1, 0x7f080085

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 250
    const v1, 0x7f02019c

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundResource(I)V

    .line 261
    :goto_0
    return-void

    .line 251
    :cond_0
    const v1, 0x7f080074

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 252
    const v1, 0x7f020150

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundResource(I)V

    goto :goto_0

    .line 253
    :cond_1
    const v1, 0x7f0800f9

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 254
    const v1, 0x7f020071

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundResource(I)V

    goto :goto_0

    .line 255
    :cond_2
    const v1, 0x7f08038f

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 256
    const v1, 0x7f0201c0

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundResource(I)V

    goto :goto_0

    .line 257
    :cond_3
    const v1, 0x7f0800e5

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 258
    const v1, 0x7f020065

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundResource(I)V

    goto :goto_0

    .line 260
    :cond_4
    const v1, 0x7f0201b5

    invoke-virtual {v0, v1}, Landroid/view/View;->setBackgroundResource(I)V

    goto :goto_0
.end method

.method private a(Ljava/util/List;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/Option;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v2, 0x0

    const/16 v4, -0x3039

    .line 113
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->c:Landroid/view/View;

    const v1, 0x7f0c023e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 114
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->k:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 115
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/Option;

    .line 116
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->c:Landroid/view/View;

    const v2, 0x7f0c023d

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 117
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->c:Landroid/view/View;

    const v3, 0x7f0c023f

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    .line 118
    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->i:Landroid/view/LayoutInflater;

    const v6, 0x7f03008d

    const/4 v7, 0x0

    invoke-virtual {v3, v6, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/FrameLayout;

    iput-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->g:Landroid/widget/FrameLayout;

    .line 119
    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->g:Landroid/widget/FrameLayout;

    const v6, 0x7f0c0225

    invoke-virtual {v3, v6}, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    iput-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->h:Landroid/widget/ImageView;

    .line 120
    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->g:Landroid/widget/FrameLayout;

    const v6, 0x7f0c0224

    invoke-virtual {v3, v6}, Landroid/widget/FrameLayout;->findViewById(I)Landroid/view/View;

    move-result-object v6

    .line 122
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Option;->getDisplayName()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Option;->getDisplayName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_0

    .line 124
    :try_start_0
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v3

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Option;->getDisplayName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v7}, Lnb;->g(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 125
    invoke-static {v3}, Landroid/graphics/Color;->parseColor(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    .line 130
    :goto_1
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Option;->getDisplayName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v7

    .line 131
    if-eq v3, v4, :cond_3

    .line 134
    const-string v8, "Gold"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 135
    const v3, 0x7f0200de

    invoke-virtual {v6, v3}, Landroid/view/View;->setBackgroundResource(I)V

    .line 149
    :goto_2
    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->g:Landroid/widget/FrameLayout;

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 150
    new-instance v3, Landroid/view/View;

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->a:Landroid/app/Activity;

    invoke-direct {v3, v6}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 151
    new-instance v6, Landroid/widget/RelativeLayout$LayoutParams;

    const/16 v7, 0xc

    const/4 v8, 0x1

    invoke-direct {v6, v7, v8}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v3, v6}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 152
    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 153
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Option;->getState()Ljava/lang/String;

    move-result-object v2

    const-string v3, "selected"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 154
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->h:Landroid/widget/ImageView;

    const v3, 0x7f020083

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setBackgroundResource(I)V

    .line 155
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Option;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 126
    :catch_0
    move-exception v3

    .line 127
    invoke-virtual {v3}, Ljava/lang/Exception;->printStackTrace()V

    :cond_0
    move v3, v4

    goto :goto_1

    .line 136
    :cond_1
    const-string v8, "Silver"

    invoke-virtual {v7, v8}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 137
    const v3, 0x7f02018e

    invoke-virtual {v6, v3}, Landroid/view/View;->setBackgroundResource(I)V

    goto :goto_2

    .line 140
    :cond_2
    invoke-virtual {v6, v3}, Landroid/view/View;->setBackgroundColor(I)V

    goto :goto_2

    .line 145
    :cond_3
    invoke-direct {p0, v7}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->a(Ljava/lang/String;)V

    goto :goto_2

    .line 157
    :cond_4
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->g:Landroid/widget/FrameLayout;

    new-instance v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment$1;

    invoke-direct {v2, p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment$1;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;Lcom/bestbuy/android/api/lib/models/pdp/Option;)V

    invoke-virtual {v1, v2}, Landroid/widget/FrameLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_0

    .line 171
    :cond_5
    return-void
.end method

.method private b(Ljava/util/List;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/AlternateProduct;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 174
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->j:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v5}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 175
    new-instance v1, Ljava/lang/StringBuffer;

    invoke-direct {v1}, Ljava/lang/StringBuffer;-><init>()V

    .line 176
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/AlternateProduct;

    .line 177
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->length()I

    move-result v3

    if-lez v3, :cond_0

    .line 178
    const-string v3, ", "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 179
    :cond_0
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/AlternateProduct;->getFormat()Ljava/lang/String;

    move-result-object v3

    const v4, 0x7f080088

    invoke-virtual {p0, v4}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 180
    const v0, 0x7f080075

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 182
    :cond_1
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/AlternateProduct;->getFormat()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0

    .line 184
    :cond_2
    invoke-virtual {v1}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v0

    .line 185
    if-eqz v0, :cond_3

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_5

    .line 186
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCondition()Ljava/lang/String;

    move-result-object v0

    .line 192
    :cond_4
    :goto_1
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v5, v6}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0, v6}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 193
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->c:Landroid/view/View;

    const v2, 0x7f0c0242

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 195
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->j:Landroid/widget/RelativeLayout;

    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment$2;

    invoke-direct {v1, p0, p1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment$2;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;Ljava/util/List;)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 202
    return-void

    .line 187
    :cond_5
    const v1, 0x7f080030

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 188
    const v0, 0x7f08002f

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 189
    :cond_6
    const v1, 0x7f080040

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 190
    const v0, 0x7f08003f

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method

.method private c(Ljava/util/List;)V
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/AlternateProduct;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    .line 219
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 220
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/AlternateProduct;

    .line 221
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/AlternateProduct;->getSkuId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 223
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->a:Landroid/app/Activity;

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarShareVisibility(Landroid/app/Activity;Z)V

    .line 224
    new-instance v7, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    invoke-direct {v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;-><init>()V

    .line 225
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    const-string v2, "PLP"

    const-string v3, ""

    const-string v5, ""

    const/16 v6, 0x14

    invoke-direct/range {v0 .. v6}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;-><init>(ZLjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V

    .line 226
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    .line 227
    invoke-virtual {v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-virtual {v2, v7, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 228
    invoke-virtual {v7, v0, v1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 230
    return-void
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 62
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 63
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 57
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 58
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->a:Landroid/app/Activity;

    .line 59
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 66
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 67
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v1, 0x0

    .line 71
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->i:Landroid/view/LayoutInflater;

    .line 72
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->c:Landroid/view/View;

    if-nez v0, :cond_4

    .line 73
    const v0, 0x7f030092

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->c:Landroid/view/View;

    .line 74
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->c:Landroid/view/View;

    const v2, 0x7f0c023c

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->k:Landroid/widget/LinearLayout;

    .line 75
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->c:Landroid/view/View;

    const v2, 0x7f0c0240

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->j:Landroid/widget/RelativeLayout;

    .line 76
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-eqz v0, :cond_2

    .line 77
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProductFamily()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProductFamily()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_1

    .line 78
    const/4 v0, 0x0

    move v2, v1

    move-object v1, v0

    .line 79
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProductFamily()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v2, v0, :cond_0

    .line 80
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProductFamily()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/ProductFamily;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/ProductFamily;->getAttributeType()Ljava/lang/String;

    move-result-object v0

    const-string v3, "color"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 81
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProductFamily()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/ProductFamily;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/ProductFamily;->getOptions()Ljava/util/List;

    move-result-object v0

    .line 79
    :goto_1
    add-int/lit8 v1, v2, 0x1

    move v2, v1

    move-object v1, v0

    goto :goto_0

    .line 84
    :cond_0
    if-eqz v1, :cond_1

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 85
    invoke-direct {p0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->a(Ljava/util/List;)V

    .line 86
    iput-boolean v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->l:Z

    .line 89
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getProductOptions()Lcom/bestbuy/android/api/lib/models/pdp/ProductOption;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 90
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getProductOptions()Lcom/bestbuy/android/api/lib/models/pdp/ProductOption;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/ProductOption;->getAlternateProducts()Ljava/util/ArrayList;

    move-result-object v0

    .line 91
    if-eqz v0, :cond_2

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_2

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_2

    .line 92
    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->b(Ljava/util/List;)V

    .line 93
    iput-boolean v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->l:Z

    .line 103
    :cond_2
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->l:Z

    if-nez v0, :cond_3

    .line 104
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->c:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 109
    :cond_3
    :goto_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->c:Landroid/view/View;

    return-object v0

    .line 107
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->c:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionFragment;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_2

    :cond_5
    move-object v0, v1

    goto :goto_1
.end method
