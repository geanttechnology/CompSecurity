.class public Lcom/bestbuy/android/activities/registry/RegistrySearchResults;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Lcg;


# instance fields
.field private a:Lcz;

.field private b:Landroid/widget/ListView;

.field private c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private i:Ljava/lang/String;

.field private j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

.field private k:Z

.field private l:Landroid/view/View;

.field private m:Landroid/view/View;

.field private n:Landroid/widget/LinearLayout;

.field private o:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;

.field private p:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;",
            ">;"
        }
    .end annotation
.end field

.field private q:Ljava/lang/String;

.field private r:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 55
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 57
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 59
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 60
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->i:Ljava/lang/String;

    .line 61
    iput-boolean p2, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->k:Z

    .line 62
    iput-object p3, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->q:Ljava/lang/String;

    .line 63
    iput-object p4, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->r:Ljava/lang/String;

    .line 64
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/RegistrySearchResults;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;
    .locals 0

    .prologue
    .line 38
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    return-object p1
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/RegistrySearchResults;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->p:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/registry/RegistrySearchResults;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    return-object v0
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    const/4 v2, 0x0

    .line 171
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->o:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;

    .line 175
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->k:Z

    if-nez v0, :cond_1

    .line 176
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->p:Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;->getRegistryWishlistArray()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 177
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->p:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-le v0, v4, :cond_0

    const-string v0, " Registries found for "

    :goto_0
    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 186
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->p:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 187
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->m:Landroid/view/View;

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 188
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-static {v0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 190
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->q:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_5

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->r:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_5

    .line 191
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->q:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->r:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 196
    :goto_2
    new-instance v0, Lcz;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const v2, 0x7f0300e4

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->p:Ljava/util/ArrayList;

    iget-boolean v4, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->k:Z

    invoke-direct {v0, v1, v2, v3, v4}, Lcz;-><init>(Landroid/app/Activity;ILjava/util/ArrayList;Z)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->a:Lcz;

    .line 197
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->b:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->a:Lcz;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 218
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->b:Landroid/widget/ListView;

    new-instance v1, Lcom/bestbuy/android/activities/registry/RegistrySearchResults$4;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/registry/RegistrySearchResults$4;-><init>(Lcom/bestbuy/android/activities/registry/RegistrySearchResults;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 228
    return-void

    .line 177
    :cond_0
    const-string v0, " Registry found for "

    goto :goto_0

    :cond_1
    move v1, v2

    .line 179
    :goto_3
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;->getRegistryWishlistArray()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_3

    .line 180
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

    .line 181
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->p:Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;->getRegistryWishlistArray()Ljava/util/ArrayList;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 179
    :cond_2
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_3

    .line 184
    :cond_3
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->p:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-le v0, v4, :cond_4

    const-string v0, " Wish Lists found for "

    :goto_4
    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_1

    :cond_4
    const-string v0, " Wish List found for "

    goto :goto_4

    .line 193
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->i:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto/16 :goto_2
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

    .line 129
    if-eqz p1, :cond_1

    invoke-virtual {p1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_1

    .line 130
    new-instance v0, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->d:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    iget-boolean v5, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->k:Z

    move-object v2, p0

    move-object v3, p1

    invoke-direct/range {v0 .. v5}, Lcom/bestbuy/android/activities/registry/BuyerRegistryAndWishListFragment;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/util/ArrayList;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Z)V

    .line 131
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 132
    instance-of v2, v1, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    if-eqz v2, :cond_0

    .line 133
    check-cast v1, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const/4 v2, 0x1

    invoke-virtual {v1, v0, v2}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 163
    :cond_0
    :goto_0
    return-void

    .line 136
    :cond_1
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->d:Landroid/app/Activity;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 137
    iget-boolean v1, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->k:Z

    if-eqz v1, :cond_2

    .line 138
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->d:Landroid/app/Activity;

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

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->d:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    new-instance v3, Lcom/bestbuy/android/activities/registry/RegistrySearchResults$2;

    invoke-direct {v3, p0}, Lcom/bestbuy/android/activities/registry/RegistrySearchResults$2;-><init>(Lcom/bestbuy/android/activities/registry/RegistrySearchResults;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 158
    :goto_1
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 159
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 160
    const v1, 0x102000b

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 161
    const/16 v1, 0x11

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setGravity(I)V

    goto :goto_0

    .line 148
    :cond_2
    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->d:Landroid/app/Activity;

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

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->d:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    new-instance v3, Lcom/bestbuy/android/activities/registry/RegistrySearchResults$3;

    invoke-direct {v3, p0}, Lcom/bestbuy/android/activities/registry/RegistrySearchResults$3;-><init>(Lcom/bestbuy/android/activities/registry/RegistrySearchResults;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    goto :goto_1
.end method

.method public g()V
    .locals 0

    .prologue
    .line 167
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 88
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 89
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 68
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    move-object v0, p1

    .line 69
    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->d:Landroid/app/Activity;

    move-object v0, p1

    .line 70
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-boolean v1, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->k:Z

    if-eqz v1, :cond_0

    const-string v1, "Wish List Search Results"

    :goto_0
    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    move-object v0, p1

    .line 71
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 72
    return-void

    .line 70
    :cond_0
    const-string v1, "Registry Search Results"

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 76
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 77
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 10

    .prologue
    const/4 v9, 0x0

    .line 93
    const v0, 0x7f0300e5

    invoke-virtual {p1, v0, p2, v9}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v8

    .line 94
    if-eqz v8, :cond_0

    .line 95
    const v0, 0x7f0c0386

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->n:Landroid/widget/LinearLayout;

    .line 96
    const v0, 0x7f0c0388

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->c:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 97
    const v0, 0x7f0c0389

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 98
    const v0, 0x7f0c038a

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 99
    const v0, 0x7f0c0064

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->l:Landroid/view/View;

    .line 100
    const v0, 0x7f0c0047

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->m:Landroid/view/View;

    .line 101
    const v0, 0x7f0c004d

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->b:Landroid/widget/ListView;

    .line 104
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->n:Landroid/widget/LinearLayout;

    new-instance v1, Lcom/bestbuy/android/activities/registry/RegistrySearchResults$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/registry/RegistrySearchResults$1;-><init>(Lcom/bestbuy/android/activities/registry/RegistrySearchResults;)V

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 112
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->a:Lcz;

    .line 113
    new-instance v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->o:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;

    .line 114
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->p:Ljava/util/ArrayList;

    .line 115
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->i:Ljava/lang/String;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->i:Ljava/lang/String;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->i:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 116
    :cond_1
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->k:Z

    if-nez v0, :cond_2

    .line 117
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "0 Registries found for \"\""

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 121
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->m:Landroid/view/View;

    invoke-virtual {v0, v9}, Landroid/view/View;->setVisibility(I)V

    .line 125
    :goto_1
    return-object v8

    .line 119
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->g:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "0 Wish Lists found for \"\""

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_0

    .line 123
    :cond_3
    new-instance v0, Ljs;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->i:Ljava/lang/String;

    iget-boolean v4, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->k:Z

    iget-object v5, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->l:Landroid/view/View;

    const/16 v6, 0x3e7

    const-string v7, ""

    move-object v2, p0

    invoke-direct/range {v0 .. v7}, Ljs;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;ZLandroid/view/View;ILjava/lang/String;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v9, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljs;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_1
.end method

.method public onResume()V
    .locals 3

    .prologue
    .line 81
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 82
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-boolean v1, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->k:Z

    if-eqz v1, :cond_0

    const-string v1, "Wish List Search Results"

    :goto_0
    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 83
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, ""

    const/4 v2, 0x0

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 84
    return-void

    .line 82
    :cond_0
    const-string v1, "Registry Search Results"

    goto :goto_0
.end method
