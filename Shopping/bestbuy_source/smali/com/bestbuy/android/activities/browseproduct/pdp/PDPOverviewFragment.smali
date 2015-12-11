.class public Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# static fields
.field private static final a:Ljava/lang/String;


# instance fields
.field private A:Z

.field private B:Z

.field private C:Z

.field private D:Z

.field private E:Z

.field private b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

.field private c:Landroid/view/View;

.field private g:Landroid/widget/LinearLayout;

.field private h:Landroid/widget/LinearLayout;

.field private i:Landroid/widget/LinearLayout;

.field private j:Landroid/widget/LinearLayout;

.field private k:Landroid/widget/LinearLayout;

.field private l:Landroid/widget/LinearLayout;

.field private m:Landroid/widget/LinearLayout;

.field private n:Landroid/widget/LinearLayout;

.field private o:Landroid/widget/LinearLayout;

.field private p:Landroid/widget/LinearLayout;

.field private q:Landroid/widget/LinearLayout;

.field private r:Landroid/widget/LinearLayout;

.field private s:Landroid/widget/LinearLayout;

.field private t:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private u:Landroid/widget/LinearLayout;

.field private v:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;

.field private w:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private x:Z

.field private y:Z

.field private z:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 37
    const-class v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->a:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 69
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 60
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->x:Z

    .line 61
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->y:Z

    .line 62
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->z:Z

    .line 63
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->A:Z

    .line 64
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->B:Z

    .line 65
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->C:Z

    .line 66
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->D:Z

    .line 67
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->E:Z

    .line 71
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)V
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 73
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 60
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->x:Z

    .line 61
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->y:Z

    .line 62
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->z:Z

    .line 63
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->A:Z

    .line 64
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->B:Z

    .line 65
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->C:Z

    .line 66
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->D:Z

    .line 67
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->E:Z

    .line 74
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 76
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 77
    const-string v1, "product"

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 78
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->setArguments(Landroid/os/Bundle;)V

    .line 79
    return-void
.end method

.method private a(I)V
    .locals 4

    .prologue
    .line 410
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 411
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->w:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v2

    .line 412
    invoke-virtual {v0, p1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 414
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    if-ge v1, v2, :cond_0

    .line 415
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->w:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 416
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->w:Ljava/util/ArrayList;

    invoke-direct {v0, v1, v2, v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;-><init>(ILcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Ljava/util/ArrayList;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->v:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;

    .line 420
    :cond_0
    return-void

    .line 414
    :cond_1
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0
.end method

.method private g()V
    .locals 10

    .prologue
    const/4 v6, 0x0

    .line 134
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getFeatures()Ljava/util/List;

    move-result-object v7

    .line 136
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->j:Landroid/widget/LinearLayout;

    const v1, 0x7f0c0268

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 137
    const v1, 0x7f0c0269

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 138
    const v2, 0x7f0c026a

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 139
    const v3, 0x7f0c026b

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 140
    const v4, 0x7f0c026c

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move v5, v6

    .line 141
    :goto_0
    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v4

    if-ge v5, v4, :cond_1

    .line 142
    invoke-interface {v7, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/bestbuy/android/api/lib/models/pdp/Feature;

    .line 143
    if-eqz v4, :cond_2

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdp/Feature;->getTitle()Ljava/lang/String;

    move-result-object v8

    if-eqz v8, :cond_2

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdp/Feature;->getTitle()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/String;->length()I

    move-result v8

    if-lez v8, :cond_2

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdp/Feature;->getTitle()Ljava/lang/String;

    move-result-object v4

    .line 144
    :goto_1
    invoke-static {v4}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 145
    if-nez v5, :cond_3

    .line 146
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "\u2022 "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 157
    :cond_0
    :goto_2
    add-int/lit8 v4, v5, 0x1

    .line 158
    const/4 v5, 0x4

    if-ne v4, v5, :cond_6

    .line 162
    :cond_1
    return-void

    .line 143
    :cond_2
    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/pdp/Feature;->getDescription()Ljava/lang/String;

    move-result-object v4

    goto :goto_1

    .line 147
    :cond_3
    const/4 v8, 0x1

    if-ne v5, v8, :cond_4

    .line 148
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "\u2022 "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 149
    invoke-virtual {v2, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto :goto_2

    .line 150
    :cond_4
    const/4 v8, 0x2

    if-ne v5, v8, :cond_5

    .line 151
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "\u2022 "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 152
    invoke-virtual {v3, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto :goto_2

    .line 153
    :cond_5
    const/4 v8, 0x3

    if-ne v5, v8, :cond_0

    .line 154
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "\u2022 "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 155
    invoke-virtual {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto :goto_2

    :cond_6
    move v5, v4

    .line 161
    goto/16 :goto_0
.end method

.method private h()V
    .locals 3

    .prologue
    const v2, 0x7f08032e

    .line 193
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSpecialFeatures()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSpecialFeatures()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 194
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->E:Z

    .line 195
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->u:Landroid/widget/LinearLayout;

    const v1, 0x7f0c025b

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 196
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 197
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->w:Ljava/util/ArrayList;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 198
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->u:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 200
    :cond_0
    return-void
.end method

.method private i()V
    .locals 3

    .prologue
    const v2, 0x7f0801b0

    .line 204
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getBonusContent()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getBonusContent()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 205
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->g:Landroid/widget/LinearLayout;

    const v1, 0x7f0c025d

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 206
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 207
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->w:Ljava/util/ArrayList;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 208
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->g:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 209
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->x:Z

    .line 211
    :cond_0
    return-void
.end method

.method private j()V
    .locals 10

    .prologue
    const v9, 0x7f0802bf

    const v8, 0x7f0802b8

    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 215
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-eqz v0, :cond_3

    .line 217
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getDescriptions()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;

    move-result-object v3

    .line 219
    if-eqz v3, :cond_3

    .line 221
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;->getLongDesc()Ljava/lang/String;

    move-result-object v1

    .line 222
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;->getShortDesc()Ljava/lang/String;

    move-result-object v2

    .line 224
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    .line 226
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v0

    if-gtz v0, :cond_1

    :cond_0
    if-eqz v2, :cond_2

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_2

    .line 228
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->h:Landroid/widget/LinearLayout;

    const v5, 0x7f0c025f

    invoke-virtual {v0, v5}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 229
    invoke-virtual {v4, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 231
    if-eqz v1, :cond_4

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_4

    move-object v0, v1

    .line 232
    :goto_0
    invoke-static {v0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 233
    const-string v1, "[\\r\\n]+\\s"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 234
    const-string v1, "[^a-z\\sA-Z0-9!@#$%^&*()-_=:.;{[}]|\'?/<,>/\"\\+]"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 236
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->h:Landroid/widget/LinearLayout;

    const v2, 0x7f0c0260

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 237
    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 239
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->w:Ljava/util/ArrayList;

    invoke-virtual {v4, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 240
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->h:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 241
    iput-boolean v7, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->z:Z

    .line 245
    :cond_2
    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Descriptions;->getSynopsis()Ljava/lang/String;

    move-result-object v1

    .line 247
    if-eqz v1, :cond_3

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_3

    .line 248
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->i:Landroid/widget/LinearLayout;

    const v2, 0x7f0c0262

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 249
    invoke-virtual {v4, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 251
    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    .line 252
    const-string v1, "[\\r\\n]+\\s"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 253
    const-string v1, "[^a-z\\sA-Z0-9!@#$%^&*()-_=:.;{[}]|\'?/<,>/\"\\+]"

    const-string v2, ""

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 255
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->i:Landroid/widget/LinearLayout;

    const v2, 0x7f0c0264

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 256
    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 258
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->w:Ljava/util/ArrayList;

    invoke-virtual {v4, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 259
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->i:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 260
    iput-boolean v7, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->y:Z

    .line 264
    :cond_3
    return-void

    :cond_4
    move-object v0, v2

    .line 231
    goto/16 :goto_0
.end method

.method private k()V
    .locals 4

    .prologue
    const v3, 0x7f0802b9

    .line 267
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getFeatures()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 268
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 270
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->j:Landroid/widget/LinearLayout;

    const v2, 0x7f0c0266

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 271
    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 273
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->w:Ljava/util/ArrayList;

    invoke-virtual {v1, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 274
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->g()V

    .line 275
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->j:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 276
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->B:Z

    .line 278
    :cond_0
    return-void
.end method

.method private m()V
    .locals 5

    .prologue
    const v4, 0x7f0802ba

    .line 281
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getIncludedItems()Ljava/util/List;

    move-result-object v0

    .line 282
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 283
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 285
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->k:Landroid/widget/LinearLayout;

    const v2, 0x7f0c026e

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 286
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->w:Ljava/util/ArrayList;

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 288
    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 289
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->k:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 290
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->A:Z

    .line 292
    :cond_0
    return-void
.end method

.method private n()V
    .locals 5

    .prologue
    const v4, 0x7f0802be

    const/4 v3, 0x0

    .line 295
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSpecifications()Ljava/util/List;

    move-result-object v0

    .line 296
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_0

    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/Specification;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/Specification;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_0

    .line 297
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 299
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->l:Landroid/widget/LinearLayout;

    const v2, 0x7f0c0270

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 300
    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 302
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->w:Ljava/util/ArrayList;

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 303
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->l:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 304
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->C:Z

    .line 306
    :cond_0
    return-void
.end method

.method private o()V
    .locals 11

    .prologue
    const v10, 0x7f08032a

    const v9, 0x7f080327

    const v8, 0x7f0801b3

    const/4 v7, 0x0

    .line 310
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->D:Z

    .line 312
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    .line 314
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSubSections()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_c

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/SubSection;

    .line 315
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/SubSection;->getId()Ljava/lang/String;

    move-result-object v3

    .line 317
    const-string v0, "movieDetails"

    invoke-virtual {v3, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    const-string v0, "movie"

    invoke-virtual {v3, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    const-string v0, "Movie"

    invoke-virtual {v3, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    const-string v0, "MOVIE"

    invoke-virtual {v3, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 318
    :cond_1
    new-instance v0, Lie;

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->d:Landroid/app/Activity;

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v0, v4, p0, v5, v6}, Lie;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Ljava/lang/String;)V

    sget-object v4, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v5, v7, [Ljava/lang/Void;

    invoke-virtual {v0, v4, v5}, Lie;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 319
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->n:Landroid/widget/LinearLayout;

    const v4, 0x7f0c0276

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 320
    const v4, 0x7f08023b

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 323
    :cond_2
    const-string v0, "episodes"

    invoke-virtual {v3, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3

    const-string v0, "episode"

    invoke-virtual {v3, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 324
    :cond_3
    new-instance v0, Lic;

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->d:Landroid/app/Activity;

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v0, v4, p0, v5, v6}, Lic;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Ljava/lang/String;)V

    sget-object v4, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v5, v7, [Ljava/lang/Void;

    invoke-virtual {v0, v4, v5}, Lic;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 325
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->o:Landroid/widget/LinearLayout;

    const v4, 0x7f0c0278

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 326
    const v4, 0x7f08018f

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 329
    :cond_4
    const-string v0, "castAndCrew"

    invoke-virtual {v3, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_5

    const-string v0, "cast"

    invoke-virtual {v3, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_5

    const-string v0, "Cast"

    invoke-virtual {v3, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_5

    const-string v0, "CAST"

    invoke-virtual {v3, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 330
    :cond_5
    new-instance v0, Lib;

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->d:Landroid/app/Activity;

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v0, v4, p0, v5, v6}, Lib;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Ljava/lang/String;)V

    sget-object v4, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v5, v7, [Ljava/lang/Void;

    invoke-virtual {v0, v4, v5}, Lib;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 331
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->p:Landroid/widget/LinearLayout;

    const v4, 0x7f0c0274

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 332
    const v4, 0x7f0800ee

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 335
    :cond_6
    const-string v0, "musicDetails"

    invoke-virtual {v3, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_7

    const-string v0, "music"

    invoke-virtual {v3, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_7

    const-string v0, "Music"

    invoke-virtual {v3, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_7

    const-string v0, "MUSIC"

    invoke-virtual {v3, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 336
    :cond_7
    new-instance v0, Lif;

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->d:Landroid/app/Activity;

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v0, v4, p0, v5, v6}, Lif;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Ljava/lang/String;)V

    sget-object v4, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v5, v7, [Ljava/lang/Void;

    invoke-virtual {v0, v4, v5}, Lif;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 337
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->q:Landroid/widget/LinearLayout;

    const v4, 0x7f0c027a

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 338
    const v4, 0x7f080241

    invoke-virtual {v1, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 340
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getTrackInfo()Ljava/util/List;

    move-result-object v0

    .line 341
    if-eqz v0, :cond_8

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_8

    .line 342
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->r:Landroid/widget/LinearLayout;

    const v4, 0x7f0c027e

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 343
    invoke-virtual {v1, v10}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 344
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->r:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 345
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->w:Ljava/util/ArrayList;

    invoke-virtual {v1, v10}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 349
    :cond_8
    const-string v0, "softwareDetails"

    invoke-virtual {v3, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_9

    const-string v0, "software"

    invoke-virtual {v3, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_9

    const-string v0, "Software"

    invoke-virtual {v3, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_9

    const-string v0, "SOFTWARE"

    invoke-virtual {v3, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 350
    :cond_9
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->t:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 351
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->s:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 352
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->w:Ljava/util/ArrayList;

    invoke-virtual {v1, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 355
    :cond_a
    const-string v0, "gameDetails"

    invoke-virtual {v3, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_b

    const-string v0, "game"

    invoke-virtual {v3, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_b

    const-string v0, "Game"

    invoke-virtual {v3, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_b

    const-string v0, "GAME"

    invoke-virtual {v3, v0}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 356
    :cond_b
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->t:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 357
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->s:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 358
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->w:Ljava/util/ArrayList;

    invoke-virtual {v1, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    .line 361
    :cond_c
    return-void
.end method


# virtual methods
.method public b()V
    .locals 1

    .prologue
    .line 185
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 186
    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 187
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    .line 188
    invoke-virtual {v0, p0}, Landroid/support/v4/app/FragmentTransaction;->remove(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    .line 189
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commitAllowingStateLoss()I

    .line 190
    return-void
.end method

.method public c()V
    .locals 3

    .prologue
    .line 364
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->p:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 365
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->w:Ljava/util/ArrayList;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0800ee

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 367
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->v:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;

    if-eqz v0, :cond_0

    .line 368
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->v:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->b()Lek;

    move-result-object v0

    invoke-virtual {v0}, Lek;->notifyDataSetChanged()V

    .line 370
    :cond_0
    return-void
.end method

.method public d()V
    .locals 3

    .prologue
    .line 373
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->n:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 374
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->w:Ljava/util/ArrayList;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08023b

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 376
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->v:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;

    if-eqz v0, :cond_0

    .line 377
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->v:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->b()Lek;

    move-result-object v0

    invoke-virtual {v0}, Lek;->notifyDataSetChanged()V

    .line 379
    :cond_0
    return-void
.end method

.method public e()V
    .locals 3

    .prologue
    .line 382
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->o:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 383
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->w:Ljava/util/ArrayList;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08018f

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 385
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->v:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;

    if-eqz v0, :cond_0

    .line 386
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->v:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->b()Lek;

    move-result-object v0

    invoke-virtual {v0}, Lek;->notifyDataSetChanged()V

    .line 388
    :cond_0
    return-void
.end method

.method public f()V
    .locals 3

    .prologue
    .line 401
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->q:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 402
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->w:Ljava/util/ArrayList;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080241

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 404
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->v:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;

    if-eqz v0, :cond_0

    .line 405
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->v:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->b()Lek;

    move-result-object v0

    invoke-virtual {v0}, Lek;->notifyDataSetChanged()V

    .line 407
    :cond_0
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 165
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 166
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->w:Ljava/util/ArrayList;

    .line 167
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-eqz v0, :cond_0

    .line 168
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->h()V

    .line 169
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->j()V

    .line 170
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->i()V

    .line 171
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->k()V

    .line 172
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->m()V

    .line 173
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->n()V

    .line 174
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->o()V

    .line 176
    :cond_0
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->y:Z

    if-nez v0, :cond_1

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->z:Z

    if-nez v0, :cond_1

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->A:Z

    if-nez v0, :cond_1

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->B:Z

    if-nez v0, :cond_1

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->B:Z

    if-nez v0, :cond_1

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->C:Z

    if-nez v0, :cond_1

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->D:Z

    if-nez v0, :cond_1

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->x:Z

    if-nez v0, :cond_1

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->E:Z

    if-nez v0, :cond_1

    .line 180
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->b()V

    .line 182
    :cond_1
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 83
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 84
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->d:Landroid/app/Activity;

    .line 85
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    const v2, 0x7f080327

    .line 424
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    .line 426
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->h:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getId()I

    move-result v1

    if-ne v0, v1, :cond_2

    .line 427
    const v0, 0x7f0802b8

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->a(I)V

    .line 462
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->v:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;

    if-eqz v0, :cond_1

    .line 463
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 464
    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    if-eqz v0, :cond_1

    .line 465
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    .line 466
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 467
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    if-eqz v1, :cond_1

    .line 468
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->v:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 472
    :cond_1
    return-void

    .line 428
    :cond_2
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->i:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getId()I

    move-result v1

    if-ne v0, v1, :cond_3

    .line 429
    const v0, 0x7f0802bf

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->a(I)V

    goto :goto_0

    .line 430
    :cond_3
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->u:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getId()I

    move-result v1

    if-ne v0, v1, :cond_4

    .line 431
    const v0, 0x7f08032e

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->a(I)V

    goto :goto_0

    .line 432
    :cond_4
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->j:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getId()I

    move-result v1

    if-ne v0, v1, :cond_5

    .line 433
    const v0, 0x7f0802b9

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->a(I)V

    goto :goto_0

    .line 434
    :cond_5
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->k:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getId()I

    move-result v1

    if-ne v0, v1, :cond_6

    .line 435
    const v0, 0x7f0802ba

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->a(I)V

    goto :goto_0

    .line 436
    :cond_6
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->l:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getId()I

    move-result v1

    if-ne v0, v1, :cond_7

    .line 437
    const v0, 0x7f0802be

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->a(I)V

    goto :goto_0

    .line 438
    :cond_7
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->m:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getId()I

    move-result v1

    if-ne v0, v1, :cond_8

    .line 439
    const v0, 0x7f0802bd

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->a(I)V

    goto :goto_0

    .line 440
    :cond_8
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->n:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getId()I

    move-result v1

    if-ne v0, v1, :cond_9

    .line 441
    const v0, 0x7f08023b

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->a(I)V

    goto/16 :goto_0

    .line 442
    :cond_9
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->o:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getId()I

    move-result v1

    if-ne v0, v1, :cond_a

    .line 443
    const v0, 0x7f08018f

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->a(I)V

    goto/16 :goto_0

    .line 444
    :cond_a
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getId()I

    move-result v1

    if-ne v0, v1, :cond_b

    .line 445
    const v0, 0x7f0800ee

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->a(I)V

    goto/16 :goto_0

    .line 446
    :cond_b
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->q:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getId()I

    move-result v1

    if-ne v0, v1, :cond_c

    .line 447
    const v0, 0x7f080241

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->a(I)V

    goto/16 :goto_0

    .line 448
    :cond_c
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->r:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getId()I

    move-result v1

    if-ne v0, v1, :cond_d

    .line 449
    const v0, 0x7f08032a

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->a(I)V

    goto/16 :goto_0

    .line 450
    :cond_d
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->s:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getId()I

    move-result v1

    if-ne v0, v1, :cond_f

    .line 451
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    .line 452
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->t:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->getText()Ljava/lang/CharSequence;

    move-result-object v1

    invoke-interface {v1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v1

    .line 453
    invoke-virtual {v0, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_e

    .line 454
    invoke-direct {p0, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->a(I)V

    goto/16 :goto_0

    .line 456
    :cond_e
    const v0, 0x7f0801b3

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->a(I)V

    goto/16 :goto_0

    .line 458
    :cond_f
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->g:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getId()I

    move-result v1

    if-ne v0, v1, :cond_0

    .line 459
    const v0, 0x7f0801b0

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->a(I)V

    goto/16 :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 90
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-nez v0, :cond_0

    .line 91
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 92
    const-string v1, "product"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 95
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->c:Landroid/view/View;

    if-nez v0, :cond_1

    .line 96
    const v0, 0x7f0300a7

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->c:Landroid/view/View;

    .line 97
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->c:Landroid/view/View;

    const v1, 0x7f0c025c

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->g:Landroid/widget/LinearLayout;

    .line 98
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->c:Landroid/view/View;

    const v1, 0x7f0c025e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->h:Landroid/widget/LinearLayout;

    .line 99
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->c:Landroid/view/View;

    const v1, 0x7f0c0265

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->j:Landroid/widget/LinearLayout;

    .line 100
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->c:Landroid/view/View;

    const v1, 0x7f0c026d

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->k:Landroid/widget/LinearLayout;

    .line 101
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->c:Landroid/view/View;

    const v1, 0x7f0c026f

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->l:Landroid/widget/LinearLayout;

    .line 102
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->c:Landroid/view/View;

    const v1, 0x7f0c0271

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->m:Landroid/widget/LinearLayout;

    .line 103
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->c:Landroid/view/View;

    const v1, 0x7f0c0275

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->n:Landroid/widget/LinearLayout;

    .line 104
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->c:Landroid/view/View;

    const v1, 0x7f0c0277

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->o:Landroid/widget/LinearLayout;

    .line 105
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->c:Landroid/view/View;

    const v1, 0x7f0c0273

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->p:Landroid/widget/LinearLayout;

    .line 106
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->c:Landroid/view/View;

    const v1, 0x7f0c0279

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->q:Landroid/widget/LinearLayout;

    .line 107
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->c:Landroid/view/View;

    const v1, 0x7f0c027d

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->r:Landroid/widget/LinearLayout;

    .line 108
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->c:Landroid/view/View;

    const v1, 0x7f0c027b

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->s:Landroid/widget/LinearLayout;

    .line 109
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->s:Landroid/widget/LinearLayout;

    const v1, 0x7f0c027c

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->t:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 110
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->c:Landroid/view/View;

    const v1, 0x7f0c025a

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->u:Landroid/widget/LinearLayout;

    .line 111
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->c:Landroid/view/View;

    const v1, 0x7f0c0261

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->i:Landroid/widget/LinearLayout;

    .line 112
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->g:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 113
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->h:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 114
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->j:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 115
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->k:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 116
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->l:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 117
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->m:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 118
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->n:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 119
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->o:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 120
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 121
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->q:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 122
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->r:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 123
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->s:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 124
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->u:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 125
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->i:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 130
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->c:Landroid/view/View;

    return-object v0

    .line 127
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->c:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewFragment;->c:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_0
.end method
