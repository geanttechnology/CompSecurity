.class public Llb;
.super Landroid/app/Dialog;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private a:Landroid/content/Context;

.field private b:I

.field private c:I

.field private d:I

.field private e:I

.field private f:I

.field private g:Z

.field private h:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

.field private i:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

.field private j:Lcom/bestbuy/android/api/lib/models/product/Product;


# direct methods
.method public constructor <init>(Landroid/content/Context;II)V
    .locals 1

    .prologue
    .line 80
    const v0, 0x7f0e002b

    invoke-direct {p0, p1, v0}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 81
    iput-object p1, p0, Llb;->a:Landroid/content/Context;

    .line 82
    iput p2, p0, Llb;->b:I

    .line 83
    iput p3, p0, Llb;->d:I

    .line 84
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;IIII)V
    .locals 1

    .prologue
    .line 37
    const v0, 0x7f0e002b

    invoke-direct {p0, p1, v0}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 38
    iput-object p1, p0, Llb;->a:Landroid/content/Context;

    .line 39
    iput p2, p0, Llb;->b:I

    .line 40
    iput p4, p0, Llb;->c:I

    .line 41
    iput p3, p0, Llb;->d:I

    .line 42
    iput p5, p0, Llb;->e:I

    .line 43
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;IIIII)V
    .locals 1

    .prologue
    .line 70
    const v0, 0x7f0e002b

    invoke-direct {p0, p1, v0}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 71
    iput-object p1, p0, Llb;->a:Landroid/content/Context;

    .line 72
    iput p2, p0, Llb;->b:I

    .line 73
    iput p4, p0, Llb;->c:I

    .line 74
    iput p3, p0, Llb;->d:I

    .line 75
    iput p5, p0, Llb;->e:I

    .line 76
    iput p6, p0, Llb;->f:I

    .line 77
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;IIIIZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V
    .locals 1

    .prologue
    .line 46
    const v0, 0x7f0e002b

    invoke-direct {p0, p1, v0}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 47
    iput-object p1, p0, Llb;->a:Landroid/content/Context;

    .line 48
    iput p2, p0, Llb;->b:I

    .line 49
    iput p4, p0, Llb;->c:I

    .line 50
    iput p3, p0, Llb;->d:I

    .line 51
    iput p5, p0, Llb;->e:I

    .line 52
    iput-boolean p6, p0, Llb;->g:Z

    .line 53
    iput-object p7, p0, Llb;->h:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    .line 54
    iput-object p8, p0, Llb;->i:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 55
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4

    .prologue
    .line 172
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    const v1, 0x7f0c0329

    if-ne v0, v1, :cond_1

    .line 173
    invoke-virtual {p0}, Llb;->cancel()V

    .line 180
    :cond_0
    :goto_0
    return-void

    .line 175
    :cond_1
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    const v1, 0x7f0c0325

    if-ne v0, v1, :cond_0

    .line 176
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.VIEW"

    iget-object v2, p0, Llb;->a:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f0801ac

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 177
    iget-object v1, p0, Llb;->a:Landroid/content/Context;

    invoke-virtual {v1, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 178
    invoke-virtual {p0}, Llb;->cancel()V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 10

    .prologue
    const v5, 0x7f0c0325

    const/4 v9, 0x0

    const/16 v4, 0x8

    const v8, 0x7f080068

    const/4 v2, 0x1

    .line 87
    invoke-super {p0, p1}, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V

    .line 88
    const v0, 0x7f0300ca

    invoke-virtual {p0, v0}, Llb;->setContentView(I)V

    .line 89
    const v0, 0x7f0c0323

    invoke-virtual {p0, v0}, Llb;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Llb;->a:Landroid/content/Context;

    check-cast v1, Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iget v3, p0, Llb;->b:I

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 90
    const v0, 0x7f0c0324

    invoke-virtual {p0, v0}, Llb;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Llb;->a:Landroid/content/Context;

    check-cast v1, Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iget v3, p0, Llb;->d:I

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 91
    iget v0, p0, Llb;->e:I

    if-gtz v0, :cond_a

    .line 92
    const v0, 0x7f0c0326

    invoke-virtual {p0, v0}, Llb;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 97
    :goto_0
    iget v0, p0, Llb;->f:I

    if-gtz v0, :cond_b

    .line 98
    invoke-virtual {p0, v5}, Llb;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 101
    :goto_1
    const v0, 0x7f0c0329

    invoke-virtual {p0, v0}, Llb;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 102
    invoke-virtual {p0, v5}, Llb;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 103
    iget-boolean v0, p0, Llb;->g:Z

    if-eqz v0, :cond_9

    .line 104
    const v0, 0x7f0c0301

    invoke-virtual {p0, v0}, Llb;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 105
    iget-object v1, p0, Llb;->h:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    if-eqz v1, :cond_9

    .line 106
    iget-object v1, p0, Llb;->h:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->isMapFlag()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 107
    const v1, 0x7f0c0327

    invoke-virtual {p0, v1}, Llb;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 108
    const v1, 0x7f0c0328

    invoke-virtual {p0, v1}, Llb;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 110
    :cond_0
    invoke-virtual {v0, v9}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 111
    const v1, 0x7f0c012e

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 112
    const v3, 0x7f0c012f

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 113
    const v4, 0x7f0c00cd

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    move-object v7, v0

    check-cast v7, Landroid/widget/LinearLayout;

    .line 114
    invoke-virtual {v7}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 116
    const-string v0, ""

    .line 117
    iget-object v4, p0, Llb;->i:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    if-eqz v4, :cond_e

    .line 118
    iget-object v4, p0, Llb;->i:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v5

    .line 119
    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getNames()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;

    move-result-object v4

    if-eqz v4, :cond_1

    .line 120
    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getNames()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;->getShortName()Ljava/lang/String;

    move-result-object v0

    .line 121
    :cond_1
    const-string v4, ""

    .line 122
    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v6

    if-eqz v6, :cond_c

    .line 123
    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v6

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v6

    if-eqz v6, :cond_2

    .line 124
    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v4

    .line 125
    :cond_2
    invoke-virtual {v4}, Ljava/lang/String;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_3

    iget-object v6, p0, Llb;->a:Landroid/content/Context;

    invoke-virtual {v6, v8}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 126
    :cond_3
    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v6

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getListImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v6

    if-eqz v6, :cond_4

    .line 127
    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getListImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v4

    .line 129
    :cond_4
    invoke-virtual {v4}, Ljava/lang/String;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_5

    iget-object v6, p0, Llb;->a:Landroid/content/Context;

    invoke-virtual {v6, v8}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_6

    .line 130
    :cond_5
    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v6

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getThumbnailImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v6

    if-eqz v6, :cond_6

    .line 131
    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getMedia()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Media;->getThumbnailImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v4

    .line 133
    :cond_6
    invoke-static {v4, v1, v9}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;Z)V

    :cond_7
    :goto_2
    move-object v1, v0

    .line 155
    :goto_3
    :try_start_0
    iget-object v0, p0, Llb;->a:Landroid/content/Context;

    const/16 v4, 0x3e8

    const v5, 0x7f080024

    invoke-static {v0, v3, v1, v4, v5}, Llt;->a(Landroid/content/Context;Lcom/bestbuy/android/bbyobjects/BBYTextView;Ljava/lang/String;II)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 160
    :goto_4
    const/4 v0, 0x0

    .line 161
    iget-object v1, p0, Llb;->i:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    if-eqz v1, :cond_18

    .line 162
    iget-object v0, p0, Llb;->a:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    iget-object v1, p0, Llb;->i:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    iget-object v4, p0, Llb;->h:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    const-string v6, ""

    move v3, v2

    move v5, v2

    invoke-static/range {v0 .. v6}, Llp;->a(Landroid/app/Activity;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;IZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZLjava/lang/String;)Landroid/view/View;

    move-result-object v0

    .line 165
    :cond_8
    :goto_5
    invoke-virtual {v7, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 168
    :cond_9
    return-void

    .line 94
    :cond_a
    const v0, 0x7f0c0327

    invoke-virtual {p0, v0}, Llb;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Llb;->a:Landroid/content/Context;

    check-cast v1, Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iget v3, p0, Llb;->c:I

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 95
    const v0, 0x7f0c0328

    invoke-virtual {p0, v0}, Llb;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Llb;->a:Landroid/content/Context;

    check-cast v1, Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iget v3, p0, Llb;->e:I

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 100
    :cond_b
    invoke-virtual {p0, v5}, Llb;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Llb;->a:Landroid/content/Context;

    check-cast v1, Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iget v3, p0, Llb;->f:I

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 134
    :cond_c
    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getPdpMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v6

    if-eqz v6, :cond_7

    .line 135
    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getPdpMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v6

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v6

    if-eqz v6, :cond_d

    .line 136
    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;->getPdpMedia()Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdp/PDPMedia;->getPrimaryImage()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;

    move-result-object v4

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/MediaImage;->getUrl()Ljava/lang/String;

    move-result-object v4

    .line 137
    :cond_d
    invoke-static {v4, v1, v9}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;Z)V

    goto/16 :goto_2

    .line 139
    :cond_e
    iget-object v4, p0, Llb;->j:Lcom/bestbuy/android/api/lib/models/product/Product;

    if-eqz v4, :cond_19

    .line 140
    iget-object v0, p0, Llb;->j:Lcom/bestbuy/android/api/lib/models/product/Product;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/product/Product;->getName()Ljava/lang/String;

    move-result-object v4

    .line 141
    iget-object v0, p0, Llb;->j:Lcom/bestbuy/android/api/lib/models/product/Product;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/product/Product;->getImages()Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->getImage()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_17

    .line 142
    iget-object v0, p0, Llb;->j:Lcom/bestbuy/android/api/lib/models/product/Product;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/product/Product;->getImages()Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->getPrimaryImage()Ljava/lang/String;

    move-result-object v0

    .line 143
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_f

    iget-object v5, p0, Llb;->a:Landroid/content/Context;

    invoke-virtual {v5, v8}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_10

    .line 144
    :cond_f
    iget-object v0, p0, Llb;->j:Lcom/bestbuy/android/api/lib/models/product/Product;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/product/Product;->getImages()Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->getThumbnailImage()Ljava/lang/String;

    move-result-object v0

    .line 145
    :cond_10
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_11

    iget-object v5, p0, Llb;->a:Landroid/content/Context;

    invoke-virtual {v5, v8}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_12

    .line 146
    :cond_11
    iget-object v0, p0, Llb;->j:Lcom/bestbuy/android/api/lib/models/product/Product;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/product/Product;->getImages()Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->getImage()Ljava/lang/String;

    move-result-object v0

    .line 147
    :cond_12
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_13

    iget-object v5, p0, Llb;->a:Landroid/content/Context;

    invoke-virtual {v5, v8}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_14

    .line 148
    :cond_13
    iget-object v0, p0, Llb;->j:Lcom/bestbuy/android/api/lib/models/product/Product;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/product/Product;->getImages()Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->getLargeFrontImage()Ljava/lang/String;

    move-result-object v0

    .line 149
    :cond_14
    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_15

    iget-object v5, p0, Llb;->a:Landroid/content/Context;

    invoke-virtual {v5, v8}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_16

    .line 150
    :cond_15
    iget-object v0, p0, Llb;->j:Lcom/bestbuy/android/api/lib/models/product/Product;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/product/Product;->getImages()Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/product/Product$ProductImages;->getLargeImage()Ljava/lang/String;

    move-result-object v0

    .line 151
    :cond_16
    invoke-static {v0, v1, v2}, Lng;->a(Ljava/lang/String;Landroid/widget/ImageView;Z)V

    :cond_17
    move-object v1, v4

    goto/16 :goto_3

    .line 156
    :catch_0
    move-exception v0

    .line 157
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 158
    invoke-virtual {v3, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_4

    .line 163
    :cond_18
    iget-object v1, p0, Llb;->j:Lcom/bestbuy/android/api/lib/models/product/Product;

    if-eqz v1, :cond_8

    .line 164
    iget-object v0, p0, Llb;->a:Landroid/content/Context;

    check-cast v0, Landroid/app/Activity;

    iget-object v1, p0, Llb;->i:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    iget-object v4, p0, Llb;->h:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    const-string v6, ""

    move v3, v2

    move v5, v2

    invoke-static/range {v0 .. v6}, Llp;->a(Landroid/app/Activity;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;IZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZLjava/lang/String;)Landroid/view/View;

    move-result-object v0

    goto/16 :goto_5

    :cond_19
    move-object v1, v0

    goto/16 :goto_3
.end method
