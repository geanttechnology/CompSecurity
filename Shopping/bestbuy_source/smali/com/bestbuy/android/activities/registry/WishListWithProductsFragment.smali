.class public Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcg;


# instance fields
.field private A:I

.field private B:Landroid/view/View;

.field private C:Z

.field private D:Z

.field private E:Z

.field private F:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Entities;",
            ">;"
        }
    .end annotation
.end field

.field private G:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation
.end field

.field private H:Landroid/widget/LinearLayout;

.field private I:Landroid/widget/LinearLayout;

.field private J:Landroid/widget/AdapterView$OnItemSelectedListener;

.field private K:Landroid/widget/AbsListView$OnScrollListener;

.field private a:Landroid/view/View;

.field private b:Landroid/view/View;

.field private c:Landroid/widget/ListView;

.field private g:Ldg;

.field private h:Landroid/widget/RelativeLayout;

.field private i:Lcom/bestbuy/android/activities/stores/DialogSpinner;

.field private j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

.field private k:Landroid/widget/RelativeLayout;

.field private l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private n:Z

.field private o:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Entities;",
            ">;"
        }
    .end annotation
.end field

.field private p:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation
.end field

.field private q:Lcom/bestbuy/android/base/BBYBaseFragment;

.field private r:Z

.field private s:Landroid/view/View;

.field private t:Landroid/widget/LinearLayout;

.field private u:Landroid/widget/LinearLayout;

.field private v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private w:Lnb;

.field private x:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private y:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private z:Landroid/widget/ImageView;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 84
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 62
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->n:Z

    .line 66
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    .line 74
    iput v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->A:I

    .line 76
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->C:Z

    .line 78
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->E:Z

    .line 79
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    .line 80
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->G:Ljava/util/ArrayList;

    .line 330
    new-instance v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$1;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$1;-><init>(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->J:Landroid/widget/AdapterView$OnItemSelectedListener;

    .line 766
    new-instance v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$2;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$2;-><init>(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->K:Landroid/widget/AbsListView$OnScrollListener;

    .line 86
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Ljava/util/ArrayList;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bestbuy/android/base/BBYBaseFragment;",
            "Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Entities;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 113
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 62
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->n:Z

    .line 66
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    .line 74
    iput v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->A:I

    .line 76
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->C:Z

    .line 78
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->E:Z

    .line 79
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    .line 80
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->G:Ljava/util/ArrayList;

    .line 330
    new-instance v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$1;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$1;-><init>(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->J:Landroid/widget/AdapterView$OnItemSelectedListener;

    .line 766
    new-instance v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$2;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$2;-><init>(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->K:Landroid/widget/AbsListView$OnScrollListener;

    .line 114
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 115
    iput-object p3, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    .line 116
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->q:Lcom/bestbuy/android/base/BBYBaseFragment;

    .line 117
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Ljava/util/ArrayList;Z)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/bestbuy/android/base/BBYBaseFragment;",
            "Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Entities;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 120
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 62
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->n:Z

    .line 66
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    .line 74
    iput v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->A:I

    .line 76
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->C:Z

    .line 78
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->E:Z

    .line 79
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    .line 80
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->G:Ljava/util/ArrayList;

    .line 330
    new-instance v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$1;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$1;-><init>(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->J:Landroid/widget/AdapterView$OnItemSelectedListener;

    .line 766
    new-instance v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$2;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$2;-><init>(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->K:Landroid/widget/AbsListView$OnScrollListener;

    .line 121
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 122
    iput-object p3, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    .line 123
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->q:Lcom/bestbuy/android/base/BBYBaseFragment;

    .line 124
    iput-boolean p4, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    .line 125
    return-void
.end method

.method public constructor <init>(ZLcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 88
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 62
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->n:Z

    .line 66
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    .line 74
    iput v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->A:I

    .line 76
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->C:Z

    .line 78
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->E:Z

    .line 79
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    .line 80
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->G:Ljava/util/ArrayList;

    .line 330
    new-instance v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$1;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$1;-><init>(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->J:Landroid/widget/AdapterView$OnItemSelectedListener;

    .line 766
    new-instance v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$2;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$2;-><init>(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->K:Landroid/widget/AbsListView$OnScrollListener;

    .line 89
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->q:Lcom/bestbuy/android/base/BBYBaseFragment;

    .line 90
    iput-object p3, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 91
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->D:Z

    .line 92
    return-void
.end method

.method public constructor <init>(ZLcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Z)V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 106
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 62
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->n:Z

    .line 66
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    .line 74
    iput v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->A:I

    .line 76
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->C:Z

    .line 78
    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->E:Z

    .line 79
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    .line 80
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->G:Ljava/util/ArrayList;

    .line 330
    new-instance v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$1;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$1;-><init>(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->J:Landroid/widget/AdapterView$OnItemSelectedListener;

    .line 766
    new-instance v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$2;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment$2;-><init>(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->K:Landroid/widget/AbsListView$OnScrollListener;

    .line 107
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->q:Lcom/bestbuy/android/base/BBYBaseFragment;

    .line 108
    iput-object p3, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 109
    iput-boolean p4, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    .line 110
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->D:Z

    .line 111
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)Lcom/bestbuy/android/activities/stores/DialogSpinner;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->i:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 51
    invoke-direct {p0, p1, p2}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a(Ljava/lang/String;Z)V

    return-void
.end method

.method private a(Ljava/lang/String;Z)V
    .locals 9

    .prologue
    const/16 v5, 0x8

    const/4 v6, 0x4

    const/4 v8, 0x1

    const v3, 0x7f03011c

    const/4 v2, 0x0

    .line 644
    const-string v0, "All Items"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "All Gifts"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 645
    :cond_0
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->E:Z

    .line 646
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 647
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->G:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 648
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 650
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->G:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->p:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 652
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 653
    if-eqz p2, :cond_2

    .line 654
    new-instance v0, Ldg;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->G:Ljava/util/ArrayList;

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    iget-boolean v7, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    move-object v2, p0

    invoke-direct/range {v0 .. v7}, Ldg;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;ILjava/util/ArrayList;Ljava/util/ArrayList;IZ)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->g:Ldg;

    .line 743
    :cond_1
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->c:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->g:Ldg;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 744
    return-void

    .line 657
    :cond_2
    new-instance v0, Ldg;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->G:Ljava/util/ArrayList;

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    iget-boolean v7, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    move-object v2, p0

    move v6, v8

    invoke-direct/range {v0 .. v7}, Ldg;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;ILjava/util/ArrayList;Ljava/util/ArrayList;IZ)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->g:Ldg;

    goto :goto_0

    .line 660
    :cond_3
    const-string v0, "Favorite Items"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_4

    const-string v0, "Favorite Gifts"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 661
    :cond_4
    iput-boolean v8, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->E:Z

    .line 662
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 663
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->G:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    move v1, v2

    .line 664
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->p:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_6

    .line 665
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->isFavorite()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 666
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v4, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 667
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->G:Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->p:Ljava/util/ArrayList;

    invoke-virtual {v4, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 664
    :cond_5
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_1

    .line 671
    :cond_6
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-gtz v0, :cond_8

    .line 672
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 673
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->bringToFront()V

    .line 674
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    if-eqz v0, :cond_7

    .line 675
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "No Favorite Gifts"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 681
    :goto_2
    if-eqz p2, :cond_9

    .line 682
    new-instance v0, Ldg;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->G:Ljava/util/ArrayList;

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    iget-boolean v7, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    move-object v2, p0

    invoke-direct/range {v0 .. v7}, Ldg;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;ILjava/util/ArrayList;Ljava/util/ArrayList;IZ)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->g:Ldg;

    goto/16 :goto_0

    .line 677
    :cond_7
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "No Favorite Items"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_2

    .line 679
    :cond_8
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto :goto_2

    .line 685
    :cond_9
    new-instance v0, Ldg;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->G:Ljava/util/ArrayList;

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    iget-boolean v7, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    move-object v2, p0

    move v6, v8

    invoke-direct/range {v0 .. v7}, Ldg;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;ILjava/util/ArrayList;Ljava/util/ArrayList;IZ)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->g:Ldg;

    goto/16 :goto_0

    .line 688
    :cond_a
    const-string v0, "Purchased Gifts"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_b

    const-string v0, "Purchased Items"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_11

    .line 689
    :cond_b
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->E:Z

    .line 690
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 691
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->G:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    move v1, v2

    .line 692
    :goto_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->p:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_d

    .line 693
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getPurchaseQuantity()I

    move-result v0

    if-lez v0, :cond_c

    .line 694
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v4, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 695
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->G:Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->p:Ljava/util/ArrayList;

    invoke-virtual {v4, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 692
    :cond_c
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_3

    .line 698
    :cond_d
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-gtz v0, :cond_f

    .line 699
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 700
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->bringToFront()V

    .line 701
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    if-eqz v0, :cond_e

    .line 702
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "No Purchased Gifts"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 708
    :goto_4
    if-eqz p2, :cond_10

    .line 709
    new-instance v0, Ldg;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->G:Ljava/util/ArrayList;

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    iget-boolean v7, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    move-object v2, p0

    invoke-direct/range {v0 .. v7}, Ldg;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;ILjava/util/ArrayList;Ljava/util/ArrayList;IZ)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->g:Ldg;

    goto/16 :goto_0

    .line 704
    :cond_e
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "No Purchased Items"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_4

    .line 706
    :cond_f
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto :goto_4

    .line 712
    :cond_10
    new-instance v0, Ldg;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->G:Ljava/util/ArrayList;

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    iget-boolean v7, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    move-object v2, p0

    move v6, v8

    invoke-direct/range {v0 .. v7}, Ldg;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;ILjava/util/ArrayList;Ljava/util/ArrayList;IZ)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->g:Ldg;

    goto/16 :goto_0

    .line 715
    :cond_11
    const-string v0, "Not Purchased Gifts"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_12

    const-string v0, "Not Purchased Items"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 716
    :cond_12
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->E:Z

    .line 717
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 718
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->G:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    move v1, v2

    .line 719
    :goto_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->p:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_14

    .line 720
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getPurchaseQuantity()I

    move-result v0

    if-nez v0, :cond_13

    .line 721
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v4, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 722
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->G:Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->p:Ljava/util/ArrayList;

    invoke-virtual {v4, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 719
    :cond_13
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_5

    .line 725
    :cond_14
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-gtz v0, :cond_16

    .line 726
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 727
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->bringToFront()V

    .line 728
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    if-eqz v0, :cond_15

    .line 729
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "No Not Purchased Gifts"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 735
    :goto_6
    if-eqz p2, :cond_17

    .line 736
    new-instance v0, Ldg;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->G:Ljava/util/ArrayList;

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    iget-boolean v7, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    move-object v2, p0

    invoke-direct/range {v0 .. v7}, Ldg;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;ILjava/util/ArrayList;Ljava/util/ArrayList;IZ)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->g:Ldg;

    goto/16 :goto_0

    .line 731
    :cond_15
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "No Not Purchased Items"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_6

    .line 733
    :cond_16
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v5}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto :goto_6

    .line 739
    :cond_17
    new-instance v0, Ldg;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->G:Ljava/util/ArrayList;

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    iget-boolean v7, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    move-object v2, p0

    move v6, v8

    invoke-direct/range {v0 .. v7}, Ldg;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;ILjava/util/ArrayList;Ljava/util/ArrayList;IZ)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->g:Ldg;

    goto/16 :goto_0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;Z)Z
    .locals 0

    .prologue
    .line 51
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->C:Z

    return p1
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)Z
    .locals 1

    .prologue
    .line 51
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->C:Z

    return v0
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)I
    .locals 1

    .prologue
    .line 51
    iget v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->A:I

    return v0
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 51
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic e(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)I
    .locals 2

    .prologue
    .line 51
    iget v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->A:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->A:I

    return v0
.end method

.method static synthetic f(Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;)Z
    .locals 1

    .prologue
    .line 51
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->n:Z

    return v0
.end method

.method private h()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 405
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 406
    iget-boolean v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    if-eqz v1, :cond_0

    .line 407
    const-string v1, "All Gifts"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 408
    const-string v1, "Purchased Gifts"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 409
    const-string v1, "Not Purchased Gifts"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 410
    const-string v1, "Favorite Gifts"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 417
    :goto_0
    new-instance v1, Landroid/widget/ArrayAdapter;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    const v3, 0x7f03002c

    invoke-direct {v1, v2, v3, v0}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 418
    const v0, 0x1090009

    invoke-virtual {v1, v0}, Landroid/widget/ArrayAdapter;->setDropDownViewResource(I)V

    .line 419
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->i:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 420
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->i:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    invoke-virtual {v0, v4, v4}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->setSelection(IZ)V

    .line 421
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->i:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->J:Landroid/widget/AdapterView$OnItemSelectedListener;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V

    .line 422
    return-void

    .line 412
    :cond_0
    const-string v1, "All Items"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 413
    const-string v1, "Purchased Items"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 414
    const-string v1, "Not Purchased Items"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 415
    const-string v1, "Favorite Items"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V
    .locals 7

    .prologue
    const/16 v2, 0x19

    const/4 v6, 0x0

    .line 556
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 557
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->w:Lnb;

    invoke-virtual {v0}, Lnb;->E()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 558
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->w:Lnb;

    invoke-virtual {v0, v6}, Lnb;->c(Z)V

    .line 559
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->b:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 560
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->b:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 575
    :cond_0
    :goto_0
    return-void

    .line 564
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-le v0, v2, :cond_3

    .line 565
    iput v6, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->A:I

    .line 566
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    move v0, v6

    .line 567
    :goto_1
    if-ge v0, v2, :cond_2

    .line 568
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {v4, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 567
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .line 570
    :cond_2
    new-instance v0, Ljn;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->b:Landroid/view/View;

    iget-boolean v5, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->n:Z

    move-object v2, p0

    invoke-direct/range {v0 .. v5}, Ljn;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/util/ArrayList;Z)V

    sget-object v1, Landroid/os/AsyncTask;->THREAD_POOL_EXECUTOR:Ljava/util/concurrent/Executor;

    new-array v2, v6, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljn;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 572
    :cond_3
    new-instance v0, Ljn;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->b:Landroid/view/View;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    iget-boolean v5, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->n:Z

    move-object v2, p0

    invoke-direct/range {v0 .. v5}, Ljn;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/util/ArrayList;Z)V

    sget-object v1, Landroid/os/AsyncTask;->THREAD_POOL_EXECUTOR:Ljava/util/concurrent/Executor;

    new-array v2, v6, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljn;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public a(Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;)V
    .locals 2

    .prologue
    .line 584
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getRegistryName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 585
    return-void
.end method

.method public a(Ljava/lang/String;)V
    .locals 9

    .prologue
    const/4 v1, 0x1

    .line 281
    new-instance v8, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    const/4 v0, 0x0

    invoke-direct {v8, v0, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;-><init>(ZZ)V

    .line 282
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    const-string v2, "Similar"

    const-string v3, "Related Products"

    const-string v4, "all"

    const-string v6, ""

    const/16 v7, 0x32

    move-object v5, p1

    invoke-direct/range {v0 .. v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;-><init>(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 283
    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b(Z)V

    .line 284
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    check-cast v2, Lcom/bestbuy/android/activities/home/HomeActivity;

    const v3, 0x7f0c0033

    const-string v4, "PLPFragmentContainer"

    invoke-virtual {v2, v3, v8, v4}, Lcom/bestbuy/android/activities/home/HomeActivity;->addFragment(ILandroid/support/v4/app/Fragment;Ljava/lang/String;)V

    .line 285
    invoke-virtual {v8, v0, v1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 286
    return-void
.end method

.method public a(Ljava/util/ArrayList;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Entities;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v6, 0x0

    .line 293
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    .line 294
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 296
    new-instance v0, Ljk;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->b:Landroid/view/View;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v4

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v5

    move-object v2, p0

    invoke-direct/range {v0 .. v5}, Ljk;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v6, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljk;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 309
    :goto_0
    return-void

    .line 298
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->w:Lnb;

    invoke-virtual {v0}, Lnb;->B()Ljava/util/ArrayList;

    move-result-object v0

    .line 299
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v1

    .line 300
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 301
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0, v6}, Lnb;->j(Z)V

    .line 302
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    .line 303
    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;

    if-eqz v0, :cond_1

    .line 304
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d()V

    goto :goto_0

    .line 306
    :cond_1
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->c()V

    goto :goto_0
.end method

.method public a(Ljava/util/ArrayList;Ljava/util/ArrayList;Z)V
    .locals 9
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
    const v3, 0x7f03011c

    const/4 v8, 0x4

    const/4 v6, 0x1

    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 353
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->C:Z

    .line 354
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    .line 355
    if-eqz p1, :cond_6

    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_6

    .line 356
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->y:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 357
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->h:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 358
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->u:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 359
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->p:Ljava/util/ArrayList;

    if-eqz v0, :cond_2

    iget v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->A:I

    if-lez v0, :cond_2

    .line 360
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->p:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 364
    :goto_0
    invoke-direct {p0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->h()V

    .line 365
    if-nez p3, :cond_4

    .line 367
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->g:Ldg;

    if-nez v0, :cond_3

    .line 368
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->c:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->B:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;)V

    .line 369
    new-instance v0, Ldg;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->p:Ljava/util/ArrayList;

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    iget-boolean v7, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    move-object v2, p0

    invoke-direct/range {v0 .. v7}, Ldg;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;ILjava/util/ArrayList;Ljava/util/ArrayList;IZ)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->g:Ldg;

    .line 371
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->c:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->g:Ldg;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 388
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->p:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/16 v1, 0x19

    if-lt v0, v1, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->p:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ne v0, v1, :cond_1

    .line 389
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->c:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->B:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->removeFooterView(Landroid/view/View;)Z

    .line 397
    :cond_1
    :goto_2
    return-void

    .line 362
    :cond_2
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->p:Ljava/util/ArrayList;

    goto :goto_0

    .line 373
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->g:Ldg;

    invoke-virtual {v0, v6}, Ldg;->a(I)V

    .line 374
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->g:Ldg;

    invoke-virtual {v0}, Ldg;->notifyDataSetChanged()V

    goto :goto_1

    .line 377
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->g:Ldg;

    if-nez v0, :cond_5

    .line 378
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->c:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->B:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;)V

    .line 379
    new-instance v0, Ldg;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->p:Ljava/util/ArrayList;

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    iget-boolean v7, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    move-object v2, p0

    move v6, v8

    invoke-direct/range {v0 .. v7}, Ldg;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;ILjava/util/ArrayList;Ljava/util/ArrayList;IZ)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->g:Ldg;

    .line 381
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->c:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->g:Ldg;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    goto :goto_1

    .line 383
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->g:Ldg;

    invoke-virtual {v0, v8}, Ldg;->a(I)V

    .line 384
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->g:Ldg;

    invoke-virtual {v0}, Ldg;->notifyDataSetChanged()V

    goto :goto_1

    .line 391
    :cond_6
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-nez v0, :cond_1

    .line 392
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->h:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 393
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->u:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 394
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->y:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto :goto_2
.end method

.method public a(Z)V
    .locals 2

    .prologue
    .line 543
    if-eqz p1, :cond_0

    .line 544
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->t:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 545
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->t:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->b(Landroid/view/View;)V

    .line 549
    :goto_0
    return-void

    .line 547
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->t:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0
.end method

.method public a(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 594
    if-eqz p1, :cond_0

    .line 595
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->g:Ldg;

    invoke-virtual {v0, p4}, Ldg;->a(Ljava/lang/String;)I

    move-result v2

    .line 596
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entities;

    .line 597
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->G:Ljava/util/ArrayList;

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 598
    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 599
    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->G:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->remove(I)Ljava/lang/Object;

    .line 600
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 601
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->p:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 602
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_1

    .line 603
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->g:Ldg;

    invoke-virtual {v0}, Ldg;->notifyDataSetChanged()V

    .line 640
    :cond_0
    :goto_0
    return-void

    .line 605
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-nez v0, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->i:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->getSelectedItem()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "All Items"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->i:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->getSelectedItem()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "All Gifts"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 606
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->w:Lnb;

    invoke-virtual {v0}, Lnb;->B()Ljava/util/ArrayList;

    move-result-object v0

    .line 607
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v1

    .line 608
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 609
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0, v4}, Lnb;->j(Z)V

    .line 610
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    .line 611
    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;

    if-eqz v0, :cond_3

    .line 612
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d()V

    goto :goto_0

    .line 614
    :cond_3
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->c()V

    goto :goto_0

    .line 616
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-nez v0, :cond_7

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->i:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->getSelectedItem()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "Favorite Items"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_5

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->i:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->getSelectedItem()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "Favorite Gifts"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 617
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 618
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->bringToFront()V

    .line 619
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    if-eqz v0, :cond_6

    .line 620
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "No Favorite Gifts"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 622
    :cond_6
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "No Favorite Items"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 623
    :cond_7
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-nez v0, :cond_a

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->i:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->getSelectedItem()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "Purchased Items"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_8

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->i:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->getSelectedItem()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "Purchased Gifts"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 624
    :cond_8
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 625
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->bringToFront()V

    .line 626
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    if-eqz v0, :cond_9

    .line 627
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "No Purchased Gifts"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 629
    :cond_9
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "No Purchased Items"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 630
    :cond_a
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->i:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->getSelectedItem()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "Not Purchased Gifts"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_b

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->i:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->getSelectedItem()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    const-string v1, "Not Purchased Items"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 631
    :cond_b
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 632
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->bringToFront()V

    .line 633
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    if-eqz v0, :cond_c

    .line 634
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "No Not Purchased Gifts"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 636
    :cond_c
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "No Not Purchased Items"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method public a(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILmp;)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 442
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->g:Ldg;

    invoke-virtual {v0, p4}, Ldg;->a(Ljava/lang/String;)I

    move-result v0

    .line 444
    if-eqz p1, :cond_1

    .line 445
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v0, p5}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->setRequiredQuantity(I)V

    .line 446
    if-le p5, v2, :cond_2

    .line 447
    iget-object v0, p6, Lmp;->d:Landroid/widget/ImageView;

    const v1, 0x7f020115

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 451
    :cond_0
    :goto_0
    iget-object v0, p6, Lmp;->e:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-static {p5}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 453
    :cond_1
    return-void

    .line 448
    :cond_2
    if-ne p5, v2, :cond_0

    .line 449
    iget-object v0, p6, Lmp;->d:Landroid/widget/ImageView;

    const v1, 0x7f020116

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0
.end method

.method public a(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lmp;)V
    .locals 8

    .prologue
    const v4, 0x7f0200c9

    const/4 v6, 0x1

    const/4 v2, 0x0

    .line 457
    .line 458
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    move v1, v2

    move v3, v2

    .line 459
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_2

    .line 460
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->getUuid()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    move v3, v1

    .line 459
    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    :cond_1
    move v3, v2

    .line 467
    :cond_2
    if-eqz p1, :cond_a

    .line 468
    iget-object v0, p5, Lmp;->a:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getTag()Ljava/lang/Object;

    move-result-object v0

    const-string v1, "Favorite this"

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 469
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    if-eqz v0, :cond_6

    .line 470
    iget-object v0, p5, Lmp;->a:Landroid/widget/ImageView;

    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 471
    iget-object v0, p5, Lmp;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "Our Favorite"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 476
    :cond_3
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->setFavorite(Z)V

    .line 483
    :cond_4
    :goto_2
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->E:Z

    if-eqz v0, :cond_a

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    if-eqz v0, :cond_a

    .line 484
    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    .line 485
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 486
    invoke-virtual {v5}, Ljava/util/ArrayList;->clear()V

    .line 487
    invoke-virtual {v4}, Ljava/util/ArrayList;->clear()V

    move v1, v2

    .line 488
    :goto_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->p:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_9

    .line 489
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->isFavorite()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 490
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v5, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 491
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->p:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 488
    :cond_5
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_3

    .line 472
    :cond_6
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    if-nez v0, :cond_3

    .line 473
    iget-object v0, p5, Lmp;->a:Landroid/widget/ImageView;

    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 474
    iget-object v0, p5, Lmp;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "My Favorite"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_1

    .line 477
    :cond_7
    iget-object v0, p5, Lmp;->a:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getTag()Ljava/lang/Object;

    move-result-object v0

    const-string v1, "My Favorite"

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_8

    iget-object v0, p5, Lmp;->a:Landroid/widget/ImageView;

    invoke-virtual {v0}, Landroid/widget/ImageView;->getTag()Ljava/lang/Object;

    move-result-object v0

    const-string v1, "Our Favorite"

    invoke-virtual {v0, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 478
    :cond_8
    iget-object v0, p5, Lmp;->a:Landroid/widget/ImageView;

    const v1, 0x7f0200cc

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 479
    iget-object v0, p5, Lmp;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "Favorite this"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 480
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/Entities;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/api/lib/models/registry/Entities;->setFavorite(Z)V

    goto/16 :goto_2

    .line 494
    :cond_9
    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-gtz v0, :cond_c

    .line 495
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->E:Z

    .line 496
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 497
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->bringToFront()V

    .line 498
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    if-eqz v0, :cond_b

    .line 499
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "No Favorite Gifts"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 505
    :goto_4
    new-instance v0, Ldg;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    const v3, 0x7f03011c

    iget-boolean v7, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    move-object v2, p0

    invoke-direct/range {v0 .. v7}, Ldg;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;ILjava/util/ArrayList;Ljava/util/ArrayList;IZ)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->g:Ldg;

    .line 507
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->c:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->g:Ldg;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 510
    :cond_a
    return-void

    .line 501
    :cond_b
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "No Favorite Items"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_4

    .line 503
    :cond_c
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto :goto_4
.end method

.method public b()V
    .locals 6

    .prologue
    .line 143
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->w:Lnb;

    invoke-virtual {v0}, Lnb;->B()Ljava/util/ArrayList;

    move-result-object v1

    .line 144
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v2

    .line 145
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 146
    new-instance v3, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    const/4 v4, 0x0

    invoke-direct {v3, p0, v0, v4}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;-><init>(Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Ljava/util/ArrayList;)V

    .line 147
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 148
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const/4 v4, 0x1

    const-string v5, "WishListWithProductsFragment"

    invoke-virtual {v0, v3, v4, v5}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 149
    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 150
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->w:Lnb;

    invoke-virtual {v0, v1}, Lnb;->a(Ljava/util/ArrayList;)V

    .line 151
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->w:Lnb;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lnb;->b(Z)V

    .line 153
    :cond_0
    return-void
.end method

.method public b(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 747
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "cartQuantity"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 748
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 749
    const/4 v2, 0x1

    if-ne v0, v2, :cond_0

    .line 750
    const-string v0, "bb.scOpen"

    const-string v2, "1"

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 752
    :cond_0
    const-string v0, "bb.scAdd"

    const-string v2, "1"

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 753
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

    .line 754
    sget-object v0, Llu;->bp:Ljava/lang/String;

    const-string v2, "LE"

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 755
    sget-object v0, Llu;->J:Ljava/lang/String;

    invoke-static {v0, v1}, Llu;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 756
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->H:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->b(Landroid/view/View;)V

    .line 757
    return-void
.end method

.method public c()V
    .locals 4

    .prologue
    .line 312
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    .line 313
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Llu;->y:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    invoke-virtual {v0, v2, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 314
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    .line 315
    invoke-virtual {v0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->d()V

    .line 316
    new-instance v1, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-direct {v1, v0}, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;-><init>(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V

    .line 317
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 318
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const/4 v2, 0x1

    const-string v3, "MyEmptyWishListFragment"

    invoke-virtual {v0, v1, v2, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 319
    return-void
.end method

.method public c(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 760
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 761
    :cond_0
    const v0, 0x7f08009e

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->getString(I)Ljava/lang/String;

    move-result-object p1

    .line 762
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->I:Landroid/widget/LinearLayout;

    const v1, 0x7f0c0083

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 763
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->I:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->b(Landroid/view/View;)V

    .line 764
    return-void
.end method

.method public d()V
    .locals 4

    .prologue
    .line 322
    sget-object v0, Llu;->az:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 323
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    .line 324
    invoke-virtual {v0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->d()V

    .line 325
    new-instance v1, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-direct {v1, v0}, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;-><init>(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V

    .line 326
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 327
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const/4 v2, 0x1

    const-string v3, "MyEmptyWeddingRegistryList"

    invoke-virtual {v0, v1, v2, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 328
    return-void
.end method

.method public e()Landroid/view/View;
    .locals 1

    .prologue
    .line 400
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->b:Landroid/view/View;

    return-object v0
.end method

.method public f()V
    .locals 8

    .prologue
    const/4 v6, 0x0

    .line 426
    iput v6, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->A:I

    .line 427
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->p:Ljava/util/ArrayList;

    .line 428
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    .line 429
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->g:Ldg;

    .line 430
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->w:Lnb;

    invoke-virtual {v0}, Lnb;->B()Ljava/util/ArrayList;

    move-result-object v0

    .line 431
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v1

    .line 432
    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 433
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->w:Lnb;

    invoke-virtual {v1, v0}, Lnb;->a(Ljava/util/ArrayList;)V

    .line 435
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->C:Z

    .line 436
    new-instance v0, Ljd;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v3

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v4

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v5

    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->b:Landroid/view/View;

    move-object v2, p0

    invoke-direct/range {v0 .. v7}, Ljd;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/view/View;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v6, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljd;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 438
    return-void
.end method

.method public g()V
    .locals 0

    .prologue
    .line 591
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 270
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 271
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->w:Lnb;

    invoke-virtual {v0}, Lnb;->E()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 272
    new-instance v0, Ljk;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->b:Landroid/view/View;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v4

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v5

    move-object v2, p0

    invoke-direct/range {v0 .. v5}, Ljk;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v6, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljk;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 274
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    if-eqz v0, :cond_1

    .line 275
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    add-int/lit8 v1, v1, -0x1

    invoke-virtual {v0, v6, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    .line 278
    :cond_1
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 3

    .prologue
    .line 129
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 130
    const-string v0, "input_method"

    invoke-virtual {p1, v0}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 131
    invoke-virtual {p1}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {p1}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 132
    invoke-virtual {p1}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 134
    :cond_0
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 8

    .prologue
    const/4 v7, 0x1

    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 515
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    if-ne p1, v0, :cond_1

    .line 516
    iput-boolean v7, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->n:Z

    .line 517
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 518
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 519
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 520
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->i:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->getSelectedItem()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    iget-boolean v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->n:Z

    invoke-direct {p0, v0, v1}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a(Ljava/lang/String;Z)V

    .line 540
    :cond_0
    :goto_0
    return-void

    .line 524
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    if-ne p1, v0, :cond_2

    .line 525
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->n:Z

    .line 526
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 527
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 528
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->i:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->getSelectedItem()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    iget-boolean v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->n:Z

    invoke-direct {p0, v0, v1}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a(Ljava/lang/String;Z)V

    goto :goto_0

    .line 532
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->k:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_3

    .line 533
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    move-object v6, v0

    check-cast v6, Lcom/bestbuy/android/base/BaseFragmentContainer;

    .line 534
    new-instance v0, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getShortDescription()Ljava/lang/String;

    move-result-object v4

    iget-boolean v5, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    invoke-direct/range {v0 .. v5}, Lcom/bestbuy/android/activities/registry/AddItemsToPLPFragment;-><init>(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 536
    invoke-virtual {v6, v0, v7}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto :goto_0

    .line 537
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->u:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_0

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 138
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 139
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->w:Lnb;

    .line 140
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 10

    .prologue
    const/high16 v4, 0x40000

    const/16 v3, 0x8

    const/4 v2, 0x0

    const/4 v9, 0x0

    .line 202
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a:Landroid/view/View;

    if-nez v0, :cond_6

    .line 203
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/16 v1, 0x20

    invoke-virtual {v0, v1}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 204
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, v4, v4}, Landroid/view/Window;->setFlags(II)V

    .line 205
    const v0, 0x7f03011f

    invoke-virtual {p1, v0, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a:Landroid/view/View;

    .line 206
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a:Landroid/view/View;

    const v1, 0x7f0c043f

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->c:Landroid/widget/ListView;

    .line 207
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a:Landroid/view/View;

    const v1, 0x7f0c0080

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->H:Landroid/widget/LinearLayout;

    .line 208
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->c:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->K:Landroid/widget/AbsListView$OnScrollListener;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 209
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a:Landroid/view/View;

    const v1, 0x7f0c003a

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->h:Landroid/widget/RelativeLayout;

    .line 210
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a:Landroid/view/View;

    const v1, 0x7f0c043c

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->u:Landroid/widget/LinearLayout;

    .line 211
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->b:Landroid/view/View;

    .line 212
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a:Landroid/view/View;

    const v1, 0x7f0c007d

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/stores/DialogSpinner;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->i:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    .line 213
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a:Landroid/view/View;

    const v1, 0x7f0c0442

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->k:Landroid/widget/RelativeLayout;

    .line 214
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a:Landroid/view/View;

    const v1, 0x7f0c0082

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->I:Landroid/widget/LinearLayout;

    .line 215
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a:Landroid/view/View;

    const v1, 0x7f0c0134

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->x:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 216
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a:Landroid/view/View;

    const v1, 0x7f0c043d

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 217
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a:Landroid/view/View;

    const v1, 0x7f0c043e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 218
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a:Landroid/view/View;

    const v1, 0x7f0c0443

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->z:Landroid/widget/ImageView;

    .line 219
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a:Landroid/view/View;

    const v1, 0x7f0c0440

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->t:Landroid/widget/LinearLayout;

    .line 220
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a:Landroid/view/View;

    const v1, 0x7f0c007f

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 221
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a:Landroid/view/View;

    const v1, 0x7f0c043b

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->y:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 222
    const v0, 0x7f0300bc

    invoke-virtual {p1, v0, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->B:Landroid/view/View;

    .line 223
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->v:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 224
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 225
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 226
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->k:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 227
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->u:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 228
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    if-eqz v0, :cond_0

    .line 229
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->x:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "Add Gifts"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 230
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "Edit Gifts"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 231
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->z:Landroid/widget/ImageView;

    const v1, 0x7f02000b

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 233
    :cond_0
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->n:Z

    if-eqz v0, :cond_3

    .line 234
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v9}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 235
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 240
    :goto_0
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    if-eqz v0, :cond_4

    .line 241
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    iget-boolean v4, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->D:Z

    iget-boolean v5, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    move-object v1, p0

    invoke-static/range {v0 .. v5}, Lmm;->a(Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;ZZ)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->s:Landroid/view/View;

    .line 246
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->s:Landroid/view/View;

    if-eqz v0, :cond_1

    .line 247
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->h:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->removeAllViews()V

    .line 248
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->h:Landroid/widget/RelativeLayout;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->s:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;)V

    .line 252
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->w:Lnb;

    invoke-virtual {v0}, Lnb;->C()Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->w:Lnb;

    invoke-virtual {v0}, Lnb;->W()Z

    move-result v0

    if-nez v0, :cond_2

    .line 253
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->o:Ljava/util/ArrayList;

    if-eqz v0, :cond_5

    .line 255
    new-instance v0, Ljk;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->b:Landroid/view/View;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v4

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v5

    move-object v2, p0

    invoke-direct/range {v0 .. v5}, Ljk;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v9, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljk;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 265
    :cond_2
    :goto_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a:Landroid/view/View;

    return-object v0

    .line 237
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->l:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v9}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 238
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v3}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto :goto_0

    .line 243
    :cond_4
    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    iget-boolean v7, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->D:Z

    iget-boolean v8, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->r:Z

    move-object v4, p0

    move-object v6, v2

    invoke-static/range {v3 .. v8}, Lmm;->a(Landroid/content/Context;Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;ZZ)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->s:Landroid/view/View;

    goto :goto_1

    .line 258
    :cond_5
    new-instance v0, Ljd;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v3

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v4

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v5

    iget-object v7, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->b:Landroid/view/View;

    move-object v2, p0

    move v6, v9

    invoke-direct/range {v0 .. v7}, Ljd;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/view/View;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v9, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljd;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_2

    .line 263
    :cond_6
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_2
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 158
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 159
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lnb;->j(Z)V

    .line 160
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->b()V

    .line 161
    return-void
.end method

.method public onResume()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 165
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 166
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, ""

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 167
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->w:Lnb;

    invoke-virtual {v0}, Lnb;->E()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_3

    .line 168
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->q:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;

    if-eqz v0, :cond_1

    .line 169
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getShortDescription()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 170
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 171
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->w:Lnb;

    invoke-virtual {v1, v0}, Lnb;->i(Ljava/lang/String;)V

    .line 172
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->changeSearchBarVisibility(Z)V

    .line 174
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->q:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/MyWeddingRegistryFragment;

    if-eqz v0, :cond_5

    .line 175
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getShortDescription()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 176
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 177
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->w:Lnb;

    invoke-virtual {v1, v0}, Lnb;->i(Ljava/lang/String;)V

    .line 178
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->changeSearchBarVisibility(Z)V

    .line 182
    :cond_3
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 183
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->w:Lnb;

    invoke-virtual {v0}, Lnb;->W()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 184
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->f()V

    .line 185
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->w:Lnb;

    invoke-virtual {v0, v2}, Lnb;->b(Z)V

    .line 186
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->w:Lnb;

    invoke-virtual {v0, v2}, Lnb;->j(Z)V

    .line 196
    :cond_4
    :goto_1
    return-void

    .line 180
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    goto :goto_0

    .line 188
    :cond_6
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->w:Lnb;

    invoke-virtual {v0}, Lnb;->C()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 189
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    .line 190
    instance-of v0, v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    if-eqz v0, :cond_4

    .line 191
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->f()V

    .line 192
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->w:Lnb;

    invoke-virtual {v0, v2}, Lnb;->b(Z)V

    goto :goto_1
.end method
