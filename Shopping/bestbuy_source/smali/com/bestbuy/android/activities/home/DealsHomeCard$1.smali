.class Lcom/bestbuy/android/activities/home/DealsHomeCard$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/home/DealsHomeCard;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lmw;

.field final synthetic b:Lcom/bestbuy/android/activities/home/DealsHomeCard;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/home/DealsHomeCard;Lmw;)V
    .locals 0

    .prologue
    .line 112
    iput-object p1, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->b:Lcom/bestbuy/android/activities/home/DealsHomeCard;

    iput-object p2, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->a:Lmw;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 9

    .prologue
    const v6, 0x7f08008d

    const v5, 0x7f080087

    const v7, 0x7f08012c

    const/4 v1, 0x0

    const/4 v8, 0x1

    .line 116
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 117
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->a:Lmw;

    invoke-virtual {v2}, Lmw;->i()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Hottest Deals"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 118
    const-string v2, "bb.prevPageLink"

    const-string v3, "Best Buy: Deals_Panel 1"

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 128
    :cond_0
    :goto_0
    sget-object v2, Llu;->bh:Ljava/lang/String;

    invoke-static {v2, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 129
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->b:Lcom/bestbuy/android/activities/home/DealsHomeCard;

    iget-object v0, v0, Lcom/bestbuy/android/activities/home/DealsHomeCard;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v4

    .line 130
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->b:Lcom/bestbuy/android/activities/home/DealsHomeCard;

    iget-object v0, v0, Lcom/bestbuy/android/activities/home/DealsHomeCard;->f:Lnb;

    invoke-virtual {v0, v4}, Lnb;->i(Ljava/lang/String;)V

    .line 135
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->a:Lmw;

    invoke-virtual {v0}, Lmw;->i()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->b:Lcom/bestbuy/android/activities/home/DealsHomeCard;

    invoke-virtual {v2, v6}, Lcom/bestbuy/android/activities/home/DealsHomeCard;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 136
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->c()Landroid/content/SharedPreferences;

    move-result-object v0

    .line 137
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->b:Lcom/bestbuy/android/activities/home/DealsHomeCard;

    iget-object v2, v2, Lcom/bestbuy/android/activities/home/DealsHomeCard;->d:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    const v3, 0x7f08008a

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 138
    invoke-interface {v0, v2, v1}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    .line 139
    if-nez v2, :cond_1

    .line 140
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->b:Lcom/bestbuy/android/activities/home/DealsHomeCard;

    iget-object v2, v2, Lcom/bestbuy/android/activities/home/DealsHomeCard;->d:Landroid/app/Activity;

    const v3, 0x7f08004d

    invoke-virtual {v2, v3}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v2, v1}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    .line 141
    if-nez v2, :cond_1

    .line 142
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->b:Lcom/bestbuy/android/activities/home/DealsHomeCard;

    iget-object v2, v2, Lcom/bestbuy/android/activities/home/DealsHomeCard;->d:Landroid/app/Activity;

    invoke-virtual {v2, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v2, v8}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v2

    .line 143
    const/16 v3, 0xa

    if-lt v2, v3, :cond_7

    .line 144
    new-instance v0, Lkt;

    iget-object v2, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->b:Lcom/bestbuy/android/activities/home/DealsHomeCard;

    iget-object v2, v2, Lcom/bestbuy/android/activities/home/DealsHomeCard;->d:Landroid/app/Activity;

    sget-object v3, Lku;->b:Lku;

    invoke-direct {v0, v2, v3}, Lkt;-><init>(Landroid/content/Context;Lku;)V

    .line 145
    invoke-virtual {v0}, Lkt;->a()V

    .line 155
    :cond_1
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->a:Lmw;

    invoke-virtual {v0}, Lmw;->e()Ljava/lang/String;

    move-result-object v0

    const-string v2, "bbyWebViewController"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 156
    const-string v0, "MdotWebFragment"

    invoke-static {v0}, Lkb;->a(Ljava/lang/String;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v1

    .line 157
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 158
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->a:Lmw;

    invoke-virtual {v2}, Lmw;->i()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->b:Lcom/bestbuy/android/activities/home/DealsHomeCard;

    invoke-virtual {v3, v6}, Lcom/bestbuy/android/activities/home/DealsHomeCard;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 159
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->b:Lcom/bestbuy/android/activities/home/DealsHomeCard;

    invoke-static {v2}, Lcom/bestbuy/android/activities/home/DealsHomeCard;->a(Lcom/bestbuy/android/activities/home/DealsHomeCard;)Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->b:Lcom/bestbuy/android/activities/home/DealsHomeCard;

    invoke-static {v2}, Lcom/bestbuy/android/activities/home/DealsHomeCard;->a(Lcom/bestbuy/android/activities/home/DealsHomeCard;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_2

    .line 160
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->a:Lmw;

    invoke-virtual {v3}, Lmw;->f()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "/stores?storeID="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->b:Lcom/bestbuy/android/activities/home/DealsHomeCard;

    invoke-static {v3}, Lcom/bestbuy/android/activities/home/DealsHomeCard;->a(Lcom/bestbuy/android/activities/home/DealsHomeCard;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 161
    iget-object v3, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->a:Lmw;

    invoke-virtual {v3, v2}, Lmw;->f(Ljava/lang/String;)V

    .line 164
    :cond_2
    const-string v2, "mDotURL"

    iget-object v3, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->a:Lmw;

    invoke-virtual {v3}, Lmw;->f()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 165
    invoke-virtual {v1, v0}, Landroid/support/v4/app/Fragment;->setArguments(Landroid/os/Bundle;)V

    .line 166
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->b:Lcom/bestbuy/android/activities/home/DealsHomeCard;

    invoke-static {v0}, Lcom/bestbuy/android/activities/home/DealsHomeCard;->b(Lcom/bestbuy/android/activities/home/DealsHomeCard;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/Fragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v0, v1, v8}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 199
    :goto_2
    return-void

    .line 119
    :cond_3
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->a:Lmw;

    invoke-virtual {v2}, Lmw;->i()Ljava/lang/String;

    move-result-object v2

    const-string v3, "GiftIdeas"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 120
    const-string v2, "bb.prevPageLink"

    const-string v3, "Best Buy: Deals_Panel 2"

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_0

    .line 121
    :cond_4
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->a:Lmw;

    invoke-virtual {v2}, Lmw;->i()Ljava/lang/String;

    move-result-object v2

    const-string v3, "BestBuyOutlets"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 122
    const-string v2, "bb.prevPageLink"

    const-string v3, "Best Buy: Deals_Panel 3"

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_0

    .line 123
    :cond_5
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->a:Lmw;

    invoke-virtual {v2}, Lmw;->i()Ljava/lang/String;

    move-result-object v2

    const-string v3, "WeeklyAd"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_6

    .line 124
    const-string v2, "bb.prevPageLink"

    const-string v3, "Best Buy: Deals_Panel 4"

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_0

    .line 125
    :cond_6
    iget-object v2, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->a:Lmw;

    invoke-virtual {v2}, Lmw;->i()Ljava/lang/String;

    move-result-object v2

    const-string v3, "StudentDeals"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 126
    const-string v2, "bb.prevPageLink"

    const-string v3, "Best Buy: Deals_Panel 5"

    invoke-virtual {v0, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_0

    .line 147
    :cond_7
    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 148
    iget-object v3, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->b:Lcom/bestbuy/android/activities/home/DealsHomeCard;

    iget-object v3, v3, Lcom/bestbuy/android/activities/home/DealsHomeCard;->d:Landroid/app/Activity;

    invoke-virtual {v3, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v3

    add-int/lit8 v2, v2, 0x1

    invoke-interface {v0, v3, v2}, Landroid/content/SharedPreferences$Editor;->putInt(Ljava/lang/String;I)Landroid/content/SharedPreferences$Editor;

    .line 149
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    goto/16 :goto_1

    .line 169
    :cond_8
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->a:Lmw;

    invoke-virtual {v0}, Lmw;->e()Ljava/lang/String;

    .line 170
    const-string v2, "Best-Selling"

    .line 171
    new-instance v3, Ljava/util/HashMap;

    invoke-direct {v3}, Ljava/util/HashMap;-><init>()V

    .line 172
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->a:Lmw;

    invoke-virtual {v0}, Lmw;->i()Ljava/lang/String;

    move-result-object v0

    iget-object v5, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->b:Lcom/bestbuy/android/activities/home/DealsHomeCard;

    const v6, 0x7f08012a

    invoke-virtual {v5, v6}, Lcom/bestbuy/android/activities/home/DealsHomeCard;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 173
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->b:Lcom/bestbuy/android/activities/home/DealsHomeCard;

    invoke-virtual {v0, v7}, Lcom/bestbuy/android/activities/home/DealsHomeCard;->getString(I)Ljava/lang/String;

    move-result-object v0

    const-string v2, "New"

    invoke-interface {v3, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 174
    const-string v0, "currentoffers_facet"

    const-string v2, "Outlet+Items"

    invoke-interface {v3, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 175
    const-string v2, "Best-Match"

    .line 184
    :goto_3
    new-instance v7, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    invoke-direct {v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;-><init>()V

    .line 185
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v5, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->a:Lmw;

    invoke-virtual {v5}, Lmw;->i()Ljava/lang/String;

    move-result-object v5

    const/16 v6, 0x14

    invoke-direct/range {v0 .. v6}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;-><init>(ZLjava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;I)V

    .line 186
    iget-object v1, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->b:Lcom/bestbuy/android/activities/home/DealsHomeCard;

    invoke-static {v1}, Lcom/bestbuy/android/activities/home/DealsHomeCard;->b(Lcom/bestbuy/android/activities/home/DealsHomeCard;)Landroid/support/v4/app/Fragment;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/Fragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v1, v7, v8}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 187
    invoke-virtual {v7, v0, v8}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto/16 :goto_2

    .line 176
    :cond_9
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->a:Lmw;

    invoke-virtual {v0}, Lmw;->i()Ljava/lang/String;

    move-result-object v0

    iget-object v5, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->b:Lcom/bestbuy/android/activities/home/DealsHomeCard;

    const v6, 0x7f08006c

    invoke-virtual {v5, v6}, Lcom/bestbuy/android/activities/home/DealsHomeCard;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 177
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->b:Lcom/bestbuy/android/activities/home/DealsHomeCard;

    invoke-virtual {v0, v7}, Lcom/bestbuy/android/activities/home/DealsHomeCard;->getString(I)Ljava/lang/String;

    move-result-object v0

    const-string v2, "Open-Box"

    invoke-interface {v3, v0, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 178
    const-string v2, "Best-Match"

    goto :goto_3

    .line 180
    :cond_a
    iget-object v0, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->b:Lcom/bestbuy/android/activities/home/DealsHomeCard;

    invoke-virtual {v0, v7}, Lcom/bestbuy/android/activities/home/DealsHomeCard;->getString(I)Ljava/lang/String;

    move-result-object v0

    iget-object v5, p0, Lcom/bestbuy/android/activities/home/DealsHomeCard$1;->a:Lmw;

    invoke-virtual {v5}, Lmw;->i()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v0, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 181
    const-string v0, "currentoffers_facet"

    const-string v5, "Outlet+Items"

    invoke-interface {v3, v0, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_3
.end method
