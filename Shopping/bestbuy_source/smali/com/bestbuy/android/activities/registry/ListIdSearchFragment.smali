.class public Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Lcg;
.implements Lch;


# instance fields
.field private a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private g:Landroid/view/View;

.field private h:Landroid/widget/ListView;

.field private i:Ljava/lang/String;

.field private j:Lcz;

.field private k:Z

.field private l:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

.field private m:Landroid/view/View;

.field private n:Landroid/widget/LinearLayout;

.field private o:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 56
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 54
    new-instance v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->o:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;

    .line 58
    return-void
.end method

.method public constructor <init>(ZLjava/lang/String;)V
    .locals 1

    .prologue
    .line 60
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 54
    new-instance v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->o:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;

    .line 61
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->k:Z

    .line 62
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->i:Ljava/lang/String;

    .line 63
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;
    .locals 0

    .prologue
    .line 41
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    return-object p1
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;)Landroid/view/View;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->g:Landroid/view/View;

    return-object v0
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 156
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    .line 157
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->k:Z

    if-nez v0, :cond_1

    .line 158
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;->getRegistryWishlistArray()Ljava/util/ArrayList;

    move-result-object v1

    .line 159
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-le v0, v4, :cond_0

    const-string v0, " Registries found for "

    :goto_0
    invoke-virtual {v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    move-object v0, v1

    .line 168
    :goto_1
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v1

    .line 169
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 170
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "\""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->i:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "\""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 171
    new-instance v1, Lcz;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const v3, 0x7f0300e4

    iget-boolean v4, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->k:Z

    invoke-direct {v1, v2, v3, v0, v4}, Lcz;-><init>(Landroid/app/Activity;ILjava/util/ArrayList;Z)V

    iput-object v1, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->j:Lcz;

    .line 172
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->j:Lcz;

    invoke-virtual {v0}, Lcz;->notifyDataSetChanged()V

    .line 173
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->h:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->j:Lcz;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 175
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->h:Landroid/widget/ListView;

    new-instance v1, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment$2;

    invoke-direct {v1, p0, p1}, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment$2;-><init>(Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 185
    return-void

    .line 159
    :cond_0
    const-string v0, " Registry found for "

    goto :goto_0

    .line 161
    :cond_1
    const/4 v0, 0x0

    move v1, v0

    :goto_2
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;->getRegistryWishlistArray()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_3

    .line 162
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;->getRegistryWishlistArray()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v0

    const-string v3, "weddingregistrylists"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 163
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;->getRegistryWishlistArray()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 161
    :cond_2
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_2

    .line 166
    :cond_3
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-le v0, v4, :cond_4

    const-string v0, " WishLists found for "

    :goto_3
    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    move-object v0, v2

    goto/16 :goto_1

    :cond_4
    const-string v0, " WishList found for "

    goto :goto_3
.end method

.method public a(Ljava/util/ArrayList;)V
    .locals 6
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
    const v4, 0x7f080284

    const/4 v3, 0x0

    .line 188
    if-eqz p1, :cond_1

    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_1

    .line 189
    new-instance v0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->d:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->l:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    iget-boolean v5, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->k:Z

    move-object v2, p0

    move-object v3, p1

    invoke-direct/range {v0 .. v5}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/util/ArrayList;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Z)V

    .line 190
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 191
    instance-of v2, v1, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    if-eqz v2, :cond_0

    .line 192
    check-cast v1, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const/4 v2, 0x1

    invoke-virtual {v1, v0, v2}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 222
    :cond_0
    :goto_0
    return-void

    .line 195
    :cond_1
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->d:Landroid/app/Activity;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 196
    iget-boolean v1, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->k:Z

    if-eqz v1, :cond_2

    .line 197
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f08026e

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->d:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    new-instance v3, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment$3;

    invoke-direct {v3, p0}, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment$3;-><init>(Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 217
    :goto_1
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 218
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 219
    const v1, 0x102000b

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 220
    const/16 v1, 0x11

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setGravity(I)V

    goto :goto_0

    .line 207
    :cond_2
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f080270

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->d:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    new-instance v3, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment$4;

    invoke-direct {v3, p0}, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment$4;-><init>(Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    goto :goto_1
.end method

.method public g()V
    .locals 0

    .prologue
    .line 139
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 132
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 133
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 67
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    move-object v0, p1

    .line 68
    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->d:Landroid/app/Activity;

    .line 69
    const/4 v0, 0x1

    sput-boolean v0, Lcom/bestbuy/android/activities/home/HomeActivity;->inListIdSearchFragment:Z

    .line 70
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->k:Z

    if-eqz v0, :cond_0

    move-object v0, p1

    .line 71
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "Search List ID"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    :goto_0
    move-object v0, p1

    .line 74
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 75
    return-void

    :cond_0
    move-object v0, p1

    .line 73
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "Search Registry ID"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 80
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 81
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 10

    .prologue
    const/4 v9, 0x0

    .line 96
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Landroid/view/Window;->setSoftInputMode(I)V

    .line 97
    const v0, 0x7f0300e5

    invoke-virtual {p1, v0, p2, v9}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v8

    .line 98
    if-eqz v8, :cond_1

    .line 99
    const v0, 0x7f0c0386

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->n:Landroid/widget/LinearLayout;

    .line 100
    const v0, 0x7f0c0388

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->a:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 101
    const v0, 0x7f0c0389

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 102
    const v0, 0x7f0c038a

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 103
    const v0, 0x7f0c0064

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->g:Landroid/view/View;

    .line 104
    const v0, 0x7f0c004d

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->h:Landroid/widget/ListView;

    .line 105
    const v0, 0x7f0c0047

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->m:Landroid/view/View;

    .line 109
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->i:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->i:Ljava/lang/String;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->i:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 110
    :cond_0
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->k:Z

    if-nez v0, :cond_2

    .line 111
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "0 Registries found for \"\""

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 115
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->m:Landroid/view/View;

    invoke-virtual {v0, v9}, Landroid/view/View;->setVisibility(I)V

    .line 120
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->n:Landroid/widget/LinearLayout;

    new-instance v1, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment$1;-><init>(Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 127
    :cond_1
    return-object v8

    .line 113
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "0 Wish Lists found for \"\""

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_0

    .line 117
    :cond_3
    new-instance v0, Ljs;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->i:Ljava/lang/String;

    iget-boolean v4, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->k:Z

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->g:Landroid/view/View;

    const/16 v6, 0x3e7

    const-string v7, ""

    move-object v2, p0

    invoke-direct/range {v0 .. v7}, Ljs;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;ZLandroid/view/View;ILjava/lang/String;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v9, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljs;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_1
.end method

.method public onDetach()V
    .locals 1

    .prologue
    .line 143
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDetach()V

    .line 144
    const/4 v0, 0x0

    sput-boolean v0, Lcom/bestbuy/android/activities/home/HomeActivity;->inListIdSearchFragment:Z

    .line 145
    return-void
.end method

.method public onResume()V
    .locals 2

    .prologue
    .line 85
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 86
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->k:Z

    if-eqz v0, :cond_0

    .line 87
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "Search List ID"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 90
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 91
    return-void

    .line 89
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "Search Registry ID"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    goto :goto_0
.end method
