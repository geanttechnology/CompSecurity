.class public Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private A:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private B:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private C:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private D:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private E:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private F:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private G:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private H:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private I:Landroid/widget/LinearLayout;

.field private J:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private K:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;",
            ">;"
        }
    .end annotation
.end field

.field private L:Landroid/view/View;

.field private M:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private N:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;

.field private O:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private P:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private Q:Ljava/lang/String;

.field private R:Ljava/lang/String;

.field private S:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

.field private a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

.field private b:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

.field private c:Landroid/view/View;

.field private g:Landroid/view/View;

.field private h:Landroid/view/View;

.field private i:Ljava/lang/String;

.field private j:Ljava/lang/String;

.field private k:Ljava/lang/Double;

.field private l:Ljava/lang/Double;

.field private m:Landroid/widget/LinearLayout;

.field private n:Landroid/widget/LinearLayout;

.field private o:Landroid/widget/LinearLayout;

.field private p:Landroid/widget/LinearLayout;

.field private q:Landroid/widget/LinearLayout;

.field private r:Landroid/widget/LinearLayout;

.field private s:Landroid/widget/LinearLayout;

.field private t:Landroid/widget/LinearLayout;

.field private u:Landroid/widget/LinearLayout;

.field private v:Landroid/widget/RelativeLayout;

.field private w:Landroid/widget/RelativeLayout;

.field private x:Landroid/widget/ImageView;

.field private y:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private z:Lcom/bestbuy/android/bbyobjects/BBYTextView;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 79
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 56
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->j:Ljava/lang/String;

    .line 57
    const-wide/16 v0, 0x0

    invoke-static {v0, v1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->k:Ljava/lang/Double;

    .line 70
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->J:Ljava/util/ArrayList;

    .line 73
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->M:Ljava/util/Set;

    .line 81
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;)V
    .locals 2

    .prologue
    .line 83
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 56
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->j:Ljava/lang/String;

    .line 57
    const-wide/16 v0, 0x0

    invoke-static {v0, v1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->k:Ljava/lang/Double;

    .line 70
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->J:Ljava/util/ArrayList;

    .line 73
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->M:Ljava/util/Set;

    .line 84
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 85
    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->b:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    .line 86
    iput-object p3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->S:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    .line 88
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 89
    const-string v1, "product"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 90
    const-string v1, "dnmProduct"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 91
    const-string v1, "pdpOverviewResponse"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 92
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->setArguments(Landroid/os/Bundle;)V

    .line 93
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 47
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->Q:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 47
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->Q:Ljava/lang/String;

    return-object p1
.end method

.method private a(Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;Ljava/lang/String;)V
    .locals 5

    .prologue
    const v4, 0x7f080068

    const/4 v1, 0x0

    .line 321
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->g:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 322
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->o:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 323
    const-string v2, ""

    .line 324
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getOpenBoxCondition()Ljava/lang/String;

    move-result-object v0

    .line 325
    if-eqz v0, :cond_1

    invoke-virtual {p0, v4}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 326
    const-string v3, "Certified"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 327
    const-string v0, "Geek Squad Certified"

    .line 329
    :cond_0
    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 330
    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->A:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v3, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 332
    :cond_1
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getOpenBoxDamageType()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v4}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 333
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->q:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 334
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getOpenBoxDamageType()Ljava/lang/String;

    move-result-object v0

    .line 335
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getOpenBoxDamageLocation()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v4}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 336
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, ", "

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "<i> Location: </i>"

    invoke-static {v3}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getOpenBoxDamageLocation()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 338
    :cond_2
    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->B:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v3, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 340
    :cond_3
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getOpenBoxMissingAccessories()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->H:Ljava/util/ArrayList;

    .line 341
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->H:Ljava/util/ArrayList;

    if-eqz v0, :cond_6

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->H:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-eqz v0, :cond_6

    .line 342
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->r:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    move-object v0, v2

    .line 343
    :goto_0
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->H:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v1, v2, :cond_5

    .line 344
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->H:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    const/4 v3, 0x1

    if-ne v2, v3, :cond_4

    .line 345
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->H:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 343
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 347
    :cond_4
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->H:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ", "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_1

    .line 349
    :cond_5
    const-string v1, ", $"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 350
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->C:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 352
    :cond_6
    return-void
.end method

.method private a(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Ljava/lang/String;)V
    .locals 5

    .prologue
    const v4, 0x7f080077

    const v2, 0x7f0c02cc

    const/4 v3, 0x0

    .line 239
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->b:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->b:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getDnmType()Ljava/lang/String;

    move-result-object v0

    const-string v1, "Open Box"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    const-string v0, "openbox"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 240
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->m:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 241
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->h:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 242
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->n:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 243
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->P:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "This is an "

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 244
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->x:Landroid/widget/ImageView;

    const v1, 0x7f020134

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 245
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, " Open-Box"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 246
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->b:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    if-eqz v0, :cond_2

    .line 247
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->b:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-direct {p0, v0, p2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->a(Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;Ljava/lang/String;)V

    .line 318
    :cond_2
    :goto_0
    return-void

    .line 250
    :cond_3
    if-eqz p1, :cond_7

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v0

    if-eqz v0, :cond_7

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;->isMarketplace()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 251
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->m:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 252
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->h:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 253
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->n:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 254
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->x:Landroid/widget/ImageView;

    const v1, 0x7f020111

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 255
    const-string v0, "pre-owned"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 256
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, " Marketplace Pre-Owned"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 262
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->O:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setPaintFlags(I)V

    .line 263
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->O:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment$1;

    invoke-direct {v1, p0, p2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment$1;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 275
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    .line 276
    if-eqz v0, :cond_2

    .line 277
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getSellerInfo()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;

    move-result-object v0

    .line 278
    if-eqz v0, :cond_2

    .line 279
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->s:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 280
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->getSeller()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_4

    .line 281
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->t:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 282
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->D:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->getSeller()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 283
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->D:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment$2;

    invoke-direct {v2, p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment$2;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;)V

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 291
    :cond_4
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->getAverageScore()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_2

    .line 292
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->u:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 293
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->E:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->getAverageScore()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, " out of 5"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 257
    :cond_5
    const-string v0, "refurbished"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 258
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, " Marketplace Refurbished"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 259
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->O:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "About Marketplace Refurbished"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 261
    :cond_6
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, " Marketplace"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 297
    :cond_7
    invoke-virtual {p0, v4}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_8

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCondition()Ljava/lang/String;

    move-result-object v0

    const-string v1, "refurbished"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 298
    :cond_8
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->m:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 299
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->h:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 300
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->n:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 301
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->x:Landroid/widget/ImageView;

    const v1, 0x7f02016a

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 302
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {p0, v4}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 303
    :cond_9
    const-string v0, "pre-owned"

    invoke-virtual {p2, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 304
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->m:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 305
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->h:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 306
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->n:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 307
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->x:Landroid/widget/ImageView;

    const v1, 0x7f020159

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 308
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, " Pre-Owned"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 309
    :cond_a
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getProductType()Ljava/lang/String;

    move-result-object v0

    const-string v1, "bundle"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 310
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->m:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 311
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->h:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 312
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->n:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 313
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->x:Landroid/widget/ImageView;

    const v1, 0x7f02005c

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 314
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, " Bundled"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 315
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->y:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getBundleItems()Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " Items "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 316
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->z:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "In This Bundle"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method private a(Ljava/util/ArrayList;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 180
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->I:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 181
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->I:Landroid/widget/LinearLayout;

    const v1, 0x7f0c0210

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 182
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getBundleItems()Ljava/util/ArrayList;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " Items"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 183
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->I:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 184
    return-void
.end method

.method private b(Ljava/lang/String;)Ljava/lang/String;
    .locals 3

    .prologue
    .line 355
    .line 357
    :try_start_0
    invoke-static {p1}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    .line 358
    new-instance v1, Ljava/text/DecimalFormat;

    const-string v2, "###,###,###.##"

    invoke-direct {v1, v2}, Ljava/text/DecimalFormat;-><init>(Ljava/lang/String;)V

    .line 359
    const/4 v2, 0x2

    invoke-virtual {v1, v2}, Ljava/text/NumberFormat;->setMinimumFractionDigits(I)V

    .line 360
    const/4 v2, 0x2

    invoke-virtual {v1, v2}, Ljava/text/NumberFormat;->setMaximumFractionDigits(I)V

    .line 361
    invoke-virtual {v1, v0}, Ljava/text/NumberFormat;->format(Ljava/lang/Object;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p1

    .line 365
    :goto_0
    return-object p1

    .line 362
    :catch_0
    move-exception v0

    goto :goto_0
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;)V
    .locals 8

    .prologue
    const/4 v4, 0x1

    const/4 v2, 0x0

    .line 187
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->b:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->b:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getDnmType()Ljava/lang/String;

    move-result-object v0

    const-string v1, "Open Box"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 236
    :cond_0
    :goto_0
    return-void

    .line 188
    :cond_1
    if-eqz p1, :cond_0

    .line 189
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->N:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;

    .line 190
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;->getBuyingOptions()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->K:Ljava/util/ArrayList;

    .line 191
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->K:Ljava/util/ArrayList;

    if-eqz v0, :cond_a

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->K:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_a

    .line 192
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->m:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 193
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->h:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 194
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->v:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 195
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->K:Ljava/util/ArrayList;

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->K:Ljava/util/ArrayList;

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->getCurrentPrice()D

    move-result-wide v0

    const-wide/16 v6, 0x0

    cmpl-double v0, v0, v6

    if-eqz v0, :cond_2

    .line 196
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->K:Ljava/util/ArrayList;

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->getCurrentPrice()D

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->l:Ljava/lang/Double;

    :cond_2
    move v1, v2

    .line 198
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->K:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_8

    .line 199
    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->M:Ljava/util/Set;

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->K:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getCondition()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v3, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 200
    invoke-static {}, Lfr;->j()Ljava/lang/String;

    move-result-object v0

    .line 202
    if-eqz v0, :cond_6

    const-string v3, "10150"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_6

    move v3, v4

    .line 208
    :goto_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->K:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->K:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->getPricingType()Ljava/lang/String;

    move-result-object v0

    const-string v5, "ICR-strikeThrough"

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_4

    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->K:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->getPricingType()Ljava/lang/String;

    move-result-object v0

    const-string v5, "MAP"

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->K:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->getPricingType()Ljava/lang/String;

    move-result-object v0

    const-string v5, "ICR-noPrice"

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    :cond_4
    if-nez v3, :cond_7

    .line 198
    :cond_5
    :goto_3
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto/16 :goto_1

    .line 204
    :cond_6
    if-eqz v0, :cond_c

    const-string v3, "10067"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c

    move v3, v4

    .line 205
    goto :goto_2

    .line 213
    :cond_7
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->K:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsList;->getPrice()Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/Price;->getCurrentPrice()D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->k:Ljava/lang/Double;

    .line 214
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->l:Ljava/lang/Double;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->k:Ljava/lang/Double;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->k:Ljava/lang/Double;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->l:Ljava/lang/Double;

    invoke-virtual {v0, v3}, Ljava/lang/Double;->compareTo(Ljava/lang/Double;)I

    move-result v0

    if-gez v0, :cond_5

    .line 215
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->k:Ljava/lang/Double;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->l:Ljava/lang/Double;

    goto :goto_3

    .line 219
    :cond_8
    const-string v0, "More buying options"

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->j:Ljava/lang/String;

    .line 220
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->y:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->j:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, " "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 221
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->l:Ljava/lang/Double;

    if-eqz v0, :cond_9

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->l:Ljava/lang/Double;

    invoke-virtual {v0}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Double;->isNaN(D)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 222
    :cond_9
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->z:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, " "

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 227
    :cond_a
    :goto_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getProductOptions()Lcom/bestbuy/android/api/lib/models/pdp/ProductOption;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getProductOptions()Lcom/bestbuy/android/api/lib/models/pdp/ProductOption;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/ProductOption;->getContractOptions()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getProductOptions()Lcom/bestbuy/android/api/lib/models/pdp/ProductOption;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/ProductOption;->getContractOptions()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 229
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->m:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 230
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->h:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 231
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->w:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 232
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->F:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getProductOptions()Lcom/bestbuy/android/api/lib/models/pdp/ProductOption;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/ProductOption;->getContractOptions()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/ContractOption;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/ContractOption;->getType()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 233
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->G:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08029b

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 224
    :cond_b
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->z:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "From $"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->l:Ljava/lang/Double;

    invoke-virtual {v3}, Ljava/lang/Double;->doubleValue()D

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Double;->toString(D)Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->b(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_4

    :cond_c
    move v3, v2

    goto/16 :goto_2
.end method

.method public a(Ljava/lang/String;)V
    .locals 7

    .prologue
    const v6, 0x7f0c0033

    const/4 v5, 0x1

    .line 401
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->d:Landroid/app/Activity;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarShareVisibility(Landroid/app/Activity;Z)V

    .line 402
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->d:Landroid/app/Activity;

    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 403
    invoke-virtual {v0, v6}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 404
    new-instance v1, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-direct {v1, v5, v5}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;-><init>(ZZ)V

    .line 405
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 406
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f080055

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 407
    invoke-virtual {v1, v2}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->setArguments(Landroid/os/Bundle;)V

    .line 408
    instance-of v2, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v2, :cond_0

    .line 409
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 410
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 411
    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v0, v1, v5}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 417
    :goto_0
    return-void

    .line 413
    :cond_0
    instance-of v2, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    if-eqz v2, :cond_1

    .line 414
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v0, v1, v5}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto :goto_0

    .line 416
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v2, "MdotWebFragment"

    invoke-virtual {v0, v6, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->addFragment(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 102
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 103
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 97
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 98
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->d:Landroid/app/Activity;

    .line 99
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 8

    .prologue
    const/4 v7, 0x1

    .line 379
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->I:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_1

    .line 380
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->d:Landroid/app/Activity;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarShareVisibility(Landroid/app/Activity;Z)V

    .line 381
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBundledProductFragment;

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->J:Ljava/util/ArrayList;

    invoke-direct {v1, v0, v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBundledProductFragment;-><init>(Landroid/app/Activity;Ljava/util/ArrayList;)V

    .line 382
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    .line 383
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-virtual {v0, v1, v7}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 398
    :cond_0
    :goto_0
    return-void

    .line 384
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->v:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_2

    .line 385
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    .line 386
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPProductAvailabilityContainer;

    const-string v2, " Product Availability "

    invoke-direct {v1, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPProductAvailabilityContainer;-><init>(Ljava/lang/String;)V

    .line 387
    new-instance v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->N:Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->S:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    invoke-direct {v2, v3, v4, v5, v6}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceProductAvailabilityFragment;-><init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Landroid/support/v4/app/Fragment;Lcom/bestbuy/android/api/lib/models/pdpbuyingoptions/BuyingOptionsResponse;Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;)V

    .line 388
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-virtual {v0, v1, v7}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 389
    invoke-virtual {v1, v2, v7}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto :goto_0

    .line 390
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->w:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_0

    .line 391
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v1

    .line 392
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getProductOptions()Lcom/bestbuy/android/api/lib/models/pdp/ProductOption;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getProductOptions()Lcom/bestbuy/android/api/lib/models/pdp/ProductOption;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/ProductOption;->getContractOptions()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 393
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    .line 394
    new-instance v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getProductOptions()Lcom/bestbuy/android/api/lib/models/pdp/ProductOption;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/ProductOption;->getContractOptions()Ljava/util/ArrayList;

    move-result-object v1

    invoke-direct {v2, v1, v7}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;-><init>(Ljava/util/ArrayList;Z)V

    .line 395
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-virtual {v0, v2, v7}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 106
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 107
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5

    .prologue
    const/16 v3, 0x8

    const/4 v2, 0x0

    .line 112
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-nez v0, :cond_0

    .line 113
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    .line 114
    const-string v0, "product"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 115
    const-string v0, "dnmProduct"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->b:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    .line 116
    const-string v0, "pdpOverviewResponse"

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->S:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    .line 119
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    if-nez v0, :cond_4

    .line 120
    const v0, 0x7f0300b3

    invoke-virtual {p1, v0, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    .line 121
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->L:Landroid/view/View;

    .line 122
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02c8

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->m:Landroid/widget/LinearLayout;

    .line 123
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02e8

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->I:Landroid/widget/LinearLayout;

    .line 124
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02ca

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->P:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 125
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02cb

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->x:Landroid/widget/ImageView;

    .line 126
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02c9

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->n:Landroid/widget/LinearLayout;

    .line 127
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02e4

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->v:Landroid/widget/RelativeLayout;

    .line 128
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->v:Landroid/widget/RelativeLayout;

    const v1, 0x7f0c02e5

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->y:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 129
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->v:Landroid/widget/RelativeLayout;

    const v1, 0x7f0c02e7

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->z:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 130
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02d6

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->o:Landroid/widget/LinearLayout;

    .line 131
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02d7

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->p:Landroid/widget/LinearLayout;

    .line 132
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02d9

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->A:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 133
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02da

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->q:Landroid/widget/LinearLayout;

    .line 134
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02dc

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->B:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 135
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02dd

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->r:Landroid/widget/LinearLayout;

    .line 136
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02df

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->C:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 137
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02ce

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->s:Landroid/widget/LinearLayout;

    .line 138
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02cf

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->O:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 139
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02d0

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->t:Landroid/widget/LinearLayout;

    .line 140
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02d3

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->u:Landroid/widget/LinearLayout;

    .line 141
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02d2

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->D:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 142
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02d5

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->E:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 143
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02ab

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->g:Landroid/view/View;

    .line 144
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02e9

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->h:Landroid/view/View;

    .line 145
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02e0

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->w:Landroid/widget/RelativeLayout;

    .line 146
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02e1

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->F:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 147
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    const v1, 0x7f0c02e3

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->G:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 148
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->m:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 149
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->v:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 150
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->n:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 151
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->w:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 152
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->v:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 153
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->w:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 154
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-eqz v0, :cond_3

    .line 155
    new-instance v0, Lim;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->L:Landroid/view/View;

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v0, v1, p0, v3, v4}, Lim;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v3, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v3}, Lim;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 157
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCondition()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->i:Ljava/lang/String;

    .line 158
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->i:Ljava/lang/String;

    if-eqz v0, :cond_1

    .line 159
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->i:Ljava/lang/String;

    invoke-direct {p0, v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->a(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Ljava/lang/String;)V

    .line 161
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getBundleItems()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_3

    move v1, v2

    .line 162
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getBundleItems()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_2

    .line 163
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->a:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getBundleItems()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/BundleItems;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/BundleItems;->getSkuId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->R:Ljava/lang/String;

    .line 164
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->J:Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->R:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 162
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 166
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->J:Ljava/util/ArrayList;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->J:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_3

    .line 167
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->J:Ljava/util/ArrayList;

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    const-string v3, ""

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const/4 v3, 0x0

    aput-object v3, v1, v2

    invoke-static {v1}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->removeAll(Ljava/util/Collection;)Z

    .line 168
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->J:Ljava/util/ArrayList;

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->a(Ljava/util/ArrayList;)V

    .line 176
    :cond_3
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    return-object v0

    .line 174
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPSourceDetailFragment;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_1
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 374
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 375
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 369
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 370
    return-void
.end method
