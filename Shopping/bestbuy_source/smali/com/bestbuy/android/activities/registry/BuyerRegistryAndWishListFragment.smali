.class public Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private A:Landroid/widget/AdapterView$OnItemSelectedListener;

.field private B:Landroid/widget/AbsListView$OnScrollListener;

.field private a:Landroid/app/Activity;

.field private b:Lcom/bestbuy/android/base/BBYBaseFragment;

.field private c:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Entities;",
            ">;"
        }
    .end annotation
.end field

.field private g:Landroid/view/View;

.field private h:Landroid/widget/ImageView;

.field private i:Lcom/bestbuy/android/activities/stores/DialogSpinner;

.field private j:Landroid/widget/ListView;

.field private k:Landroid/view/View;

.field private l:Ldg;

.field private m:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

.field private n:Landroid/widget/LinearLayout;

.field private o:Landroid/widget/LinearLayout;

.field private p:Landroid/widget/LinearLayout;

.field private q:Landroid/widget/LinearLayout;

.field private r:Landroid/widget/RelativeLayout;

.field private s:Landroid/widget/RelativeLayout;

.field private t:Landroid/widget/ImageView;

.field private u:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation
.end field

.field private v:Z

.field private w:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private x:Z

.field private y:I

.field private z:Landroid/view/View;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 65
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 59
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->v:Z

    .line 61
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->x:Z

    .line 62
    iput v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->y:I

    .line 143
    new-instance v0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;-><init>(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->A:Landroid/widget/AdapterView$OnItemSelectedListener;

    .line 351
    new-instance v0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$2;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$2;-><init>(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->B:Landroid/widget/AbsListView$OnScrollListener;

    .line 66
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/util/ArrayList;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Z)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/bestbuy/android/base/BBYBaseFragment;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Entities;",
            ">;",
            "Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;",
            "Z)V"
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 68
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 59
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->v:Z

    .line 61
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->x:Z

    .line 62
    iput v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->y:I

    .line 143
    new-instance v0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$1;-><init>(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->A:Landroid/widget/AdapterView$OnItemSelectedListener;

    .line 351
    new-instance v0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$2;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment$2;-><init>(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->B:Landroid/widget/AbsListView$OnScrollListener;

    .line 69
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->a:Landroid/app/Activity;

    .line 70
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->b:Lcom/bestbuy/android/base/BBYBaseFragment;

    .line 71
    iput-object p3, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->c:Ljava/util/ArrayList;

    .line 72
    iput-object p4, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 73
    iput-boolean p5, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->v:Z

    .line 74
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Lcom/bestbuy/android/activities/stores/DialogSpinner;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->i:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;Ldg;)Ldg;
    .locals 0

    .prologue
    .line 40
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->l:Ldg;

    return-object p1
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;Z)Z
    .locals 0

    .prologue
    .line 40
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->x:Z

    return p1
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->w:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    return-object v0
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->a:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->u:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic e(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->c:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic f(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->n:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic g(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    return-object v0
.end method

.method static synthetic h(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Z
    .locals 1

    .prologue
    .line 40
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->v:Z

    return v0
.end method

.method static synthetic i(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Ldg;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->l:Ldg;

    return-object v0
.end method

.method static synthetic j(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Landroid/widget/ListView;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->j:Landroid/widget/ListView;

    return-object v0
.end method

.method static synthetic k(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)Z
    .locals 1

    .prologue
    .line 40
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->x:Z

    return v0
.end method

.method static synthetic l(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)I
    .locals 1

    .prologue
    .line 40
    iget v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->y:I

    return v0
.end method

.method static synthetic m(Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;)I
    .locals 2

    .prologue
    .line 40
    iget v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->y:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->y:I

    return v0
.end method


# virtual methods
.method public a(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 301
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "cartQuantity"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 302
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 303
    const/4 v2, 0x1

    if-ne v0, v2, :cond_0

    .line 304
    const-string v0, "bb.scOpen"

    const-string v2, "1"

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 306
    :cond_0
    const-string v0, "bb.scAdd"

    const-string v2, "1"

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 307
    const-string v0, "&&products"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, ";["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "];;;;eVar7=[LE]"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 308
    sget-object v0, Llu;->bp:Ljava/lang/String;

    const-string v2, "LE"

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 309
    sget-object v0, Llu;->J:Ljava/lang/String;

    invoke-static {v0, v1}, Llu;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 310
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->o:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->b(Landroid/view/View;)V

    .line 311
    return-void
.end method

.method public a(Ljava/util/ArrayList;Ljava/util/ArrayList;Z)V
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Entities;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    const v2, 0x7f0c0085

    const/4 v1, 0x0

    .line 235
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->x:Z

    .line 236
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->u:Ljava/util/ArrayList;

    if-eqz v0, :cond_2

    iget v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->y:I

    if-lez v0, :cond_2

    .line 237
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->u:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 241
    :goto_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->b()V

    .line 242
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->l:Ldg;

    if-nez v0, :cond_4

    .line 243
    if-eqz p1, :cond_3

    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_3

    .line 244
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->j:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->z:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;)V

    .line 245
    new-instance v0, Ldg;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->a:Landroid/app/Activity;

    const v3, 0x7f03011c

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->u:Ljava/util/ArrayList;

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->c:Ljava/util/ArrayList;

    const/4 v6, 0x2

    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->n:Landroid/widget/LinearLayout;

    iget-object v8, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    iget-boolean v9, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->v:Z

    move-object v2, p0

    invoke-direct/range {v0 .. v9}, Ldg;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;ILjava/util/ArrayList;Ljava/util/ArrayList;ILandroid/widget/LinearLayout;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Z)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->l:Ldg;

    .line 247
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->j:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->l:Ldg;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 261
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->u:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/16 v1, 0x19

    if-lt v0, v1, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->u:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ne v0, v1, :cond_1

    .line 262
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->j:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->z:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->removeFooterView(Landroid/view/View;)Z

    .line 264
    :cond_1
    return-void

    .line 239
    :cond_2
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->u:Ljava/util/ArrayList;

    goto :goto_0

    .line 249
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 250
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "No Items added "

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_1

    .line 253
    :cond_4
    if-eqz p1, :cond_5

    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_5

    .line 254
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->l:Ldg;

    invoke-virtual {v0}, Ldg;->notifyDataSetChanged()V

    goto :goto_1

    .line 256
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 257
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->p:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "No Items added "

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_1
.end method

.method public b()V
    .locals 4

    .prologue
    .line 267
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 268
    iget-boolean v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->v:Z

    if-eqz v1, :cond_0

    .line 269
    const-string v1, "All Items"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 270
    const-string v1, "Purchased Items"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 271
    const-string v1, "Not Purchased Items"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 272
    const-string v1, "Favorite Items"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 280
    :goto_0
    new-instance v1, Landroid/widget/ArrayAdapter;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->a:Landroid/app/Activity;

    const v3, 0x7f03002c

    invoke-direct {v1, v2, v3, v0}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 281
    const v0, 0x1090009

    invoke-virtual {v1, v0}, Landroid/widget/ArrayAdapter;->setDropDownViewResource(I)V

    .line 282
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->i:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 283
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->i:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    const/high16 v1, -0x80000000

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->setSelection(IZ)V

    .line 284
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->i:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->A:Landroid/widget/AdapterView$OnItemSelectedListener;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V

    .line 285
    return-void

    .line 274
    :cond_0
    const-string v1, "All Gifts"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 275
    const-string v1, "Purchased Gifts"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 276
    const-string v1, "Not Purchased Gifts"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 277
    const-string v1, "Favorite Gifts"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public b(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 318
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 319
    :cond_0
    const v0, 0x7f08009e

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->getString(I)Ljava/lang/String;

    move-result-object p1

    .line 320
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->q:Landroid/widget/LinearLayout;

    const v1, 0x7f0c0083

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 321
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->q:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->b(Landroid/view/View;)V

    .line 322
    return-void
.end method

.method public c()Landroid/view/View;
    .locals 1

    .prologue
    .line 325
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->k:Landroid/view/View;

    return-object v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 89
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 90
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 78
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 79
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->a:Landroid/app/Activity;

    .line 80
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 330
    invoke-virtual {p1}, Landroid/view/View;->getId()I

    move-result v0

    packed-switch v0, :pswitch_data_0

    .line 348
    :goto_0
    :pswitch_0
    return-void

    .line 333
    :pswitch_1
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->a:Landroid/app/Activity;

    const-class v2, Lcom/bestbuy/android/activities/mybby/MyBBYListIdActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 334
    const-string v1, "FragmentName"

    const-string v2, "ListIdModalFragment"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 335
    const-string v1, "uuid"

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 336
    const-string v1, "retailListAlias"

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getRetailListAlias()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 337
    const-string v1, "listName"

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getShortDescription()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 338
    const-string v1, "listType"

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 339
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->a:Landroid/app/Activity;

    invoke-virtual {v1, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 340
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->a:Landroid/app/Activity;

    const v1, 0x7f04000e

    const v2, 0x7f040005

    invoke-virtual {v0, v1, v2}, Landroid/app/Activity;->overridePendingTransition(II)V

    goto :goto_0

    .line 330
    nop

    :pswitch_data_0
    .packed-switch 0x7f0c0076
        :pswitch_0
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 84
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 85
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 6

    .prologue
    const/4 v4, 0x0

    const v3, 0x7f0c007b

    const/16 v2, 0x19

    const/4 v5, 0x0

    .line 106
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->g:Landroid/view/View;

    if-nez v0, :cond_1

    .line 107
    const v0, 0x7f03001b

    invoke-virtual {p1, v0, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->g:Landroid/view/View;

    .line 108
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->g:Landroid/view/View;

    const v1, 0x7f0c004a

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->n:Landroid/widget/LinearLayout;

    .line 109
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0076

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->s:Landroid/widget/RelativeLayout;

    .line 110
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0080

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->o:Landroid/widget/LinearLayout;

    .line 111
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0082

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->q:Landroid/widget/LinearLayout;

    .line 112
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->k:Landroid/view/View;

    .line 113
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0084

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->p:Landroid/widget/LinearLayout;

    .line 114
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->g:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->h:Landroid/widget/ImageView;

    .line 115
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->g:Landroid/view/View;

    const v1, 0x7f0c007d

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/stores/DialogSpinner;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->i:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    .line 116
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->g:Landroid/view/View;

    const v1, 0x7f0c007e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->j:Landroid/widget/ListView;

    .line 117
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->j:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->B:Landroid/widget/AbsListView$OnScrollListener;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 118
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->g:Landroid/view/View;

    const v1, 0x7f0c007f

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->w:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 119
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->w:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 120
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0077

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->r:Landroid/widget/RelativeLayout;

    .line 121
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->r:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 122
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->g:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->t:Landroid/widget/ImageView;

    .line 123
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->t:Landroid/widget/ImageView;

    invoke-virtual {v0, p0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 124
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->s:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 125
    const v0, 0x7f0300bc

    invoke-virtual {p1, v0, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->z:Landroid/view/View;

    .line 127
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->x:Z

    .line 128
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-le v0, v2, :cond_2

    .line 129
    iput v5, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->y:I

    .line 130
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    move v0, v5

    .line 131
    :goto_0
    if-ge v0, v2, :cond_0

    .line 132
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->c:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v4, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 131
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 134
    :cond_0
    new-instance v0, Ljn;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->a:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->k:Landroid/view/View;

    move-object v2, p0

    invoke-direct/range {v0 .. v5}, Ljn;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/util/ArrayList;Z)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v5, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljn;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 140
    :cond_1
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->g:Landroid/view/View;

    return-object v0

    .line 136
    :cond_2
    iput v5, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->y:I

    .line 137
    new-instance v0, Ljn;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->a:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->k:Landroid/view/View;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->c:Ljava/util/ArrayList;

    move-object v2, p0

    invoke-direct/range {v0 .. v5}, Ljn;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/util/ArrayList;Z)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v5, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljn;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_1
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 101
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 102
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 94
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 95
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->m:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getShortDescription()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 96
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;->a:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 97
    return-void
.end method
