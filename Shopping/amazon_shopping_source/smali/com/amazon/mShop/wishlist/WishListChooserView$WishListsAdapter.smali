.class Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;
.super Landroid/widget/BaseAdapter;
.source "WishListChooserView.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/wishlist/WishListChooserView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "WishListsAdapter"
.end annotation


# instance fields
.field private mWishLists:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/ListList;",
            ">;"
        }
    .end annotation
.end field

.field final synthetic this$0:Lcom/amazon/mShop/wishlist/WishListChooserView;


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/wishlist/WishListChooserView;)V
    .locals 0

    .prologue
    .line 56
    iput-object p1, p0, Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;->this$0:Lcom/amazon/mShop/wishlist/WishListChooserView;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/wishlist/WishListChooserView;Lcom/amazon/mShop/wishlist/WishListChooserView$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/wishlist/WishListChooserView;
    .param p2, "x1"    # Lcom/amazon/mShop/wishlist/WishListChooserView$1;

    .prologue
    .line 56
    invoke-direct {p0, p1}, Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;-><init>(Lcom/amazon/mShop/wishlist/WishListChooserView;)V

    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 67
    iget-object v0, p0, Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;->mWishLists:Ljava/util/List;

    if-nez v0, :cond_0

    .line 68
    const/4 v0, 0x0

    .line 69
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;->mWishLists:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    goto :goto_0
.end method

.method public getItem(I)Lcom/amazon/rio/j2me/client/services/mShop/ListList;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 74
    iget-object v0, p0, Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;->mWishLists:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/rio/j2me/client/services/mShop/ListList;

    return-object v0
.end method

.method public bridge synthetic getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "x0"    # I

    .prologue
    .line 56
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;->getItem(I)Lcom/amazon/rio/j2me/client/services/mShop/ListList;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 79
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 9
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/16 v8, 0x8

    .line 85
    if-nez p2, :cond_0

    .line 86
    iget-object v5, p0, Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;->this$0:Lcom/amazon/mShop/wishlist/WishListChooserView;

    # getter for: Lcom/amazon/mShop/wishlist/WishListChooserView;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v5}, Lcom/amazon/mShop/wishlist/WishListChooserView;->access$100(Lcom/amazon/mShop/wishlist/WishListChooserView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v5

    sget v6, Lcom/amazon/mShop/android/lib/R$layout;->wishlist_chooser_item:I

    const/4 v7, 0x0

    invoke-static {v5, v6, v7}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 91
    .local v1, "itemView":Landroid/view/View;
    :goto_0
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;->getItem(I)Lcom/amazon/rio/j2me/client/services/mShop/ListList;

    move-result-object v2

    .line 92
    .local v2, "ll":Lcom/amazon/rio/j2me/client/services/mShop/ListList;
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->item_title:I

    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 93
    .local v4, "title":Landroid/widget/TextView;
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/ListList;->getListTitle()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 94
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->check_mark:I

    invoke-virtual {v1, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 96
    .local v0, "checkmark":Landroid/widget/ImageView;
    iget-object v5, p0, Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;->this$0:Lcom/amazon/mShop/wishlist/WishListChooserView;

    # getter for: Lcom/amazon/mShop/wishlist/WishListChooserView;->mOperationType:I
    invoke-static {v5}, Lcom/amazon/mShop/wishlist/WishListChooserView;->access$200(Lcom/amazon/mShop/wishlist/WishListChooserView;)I

    move-result v5

    packed-switch v5, :pswitch_data_0

    .line 108
    invoke-virtual {v0, v8}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 109
    iget-object v5, p0, Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;->this$0:Lcom/amazon/mShop/wishlist/WishListChooserView;

    invoke-virtual {v5}, Lcom/amazon/mShop/wishlist/WishListChooserView;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/amazon/mShop/android/lib/R$color;->dark_text:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setTextColor(I)V

    .line 112
    :goto_1
    return-object v1

    .line 88
    .end local v0    # "checkmark":Landroid/widget/ImageView;
    .end local v1    # "itemView":Landroid/view/View;
    .end local v2    # "ll":Lcom/amazon/rio/j2me/client/services/mShop/ListList;
    .end local v4    # "title":Landroid/widget/TextView;
    :cond_0
    move-object v1, p2

    .restart local v1    # "itemView":Landroid/view/View;
    goto :goto_0

    .line 98
    .restart local v0    # "checkmark":Landroid/widget/ImageView;
    .restart local v2    # "ll":Lcom/amazon/rio/j2me/client/services/mShop/ListList;
    .restart local v4    # "title":Landroid/widget/TextView;
    :pswitch_0
    invoke-static {}, Lcom/amazon/mShop/control/wishlist/WishListManageController;->getInstance()Lcom/amazon/mShop/control/wishlist/WishListManageController;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/mShop/control/wishlist/WishListManageController;->getCurrentList()Lcom/amazon/rio/j2me/client/services/mShop/ListList;

    move-result-object v3

    .line 99
    .local v3, "mCurrentList":Lcom/amazon/rio/j2me/client/services/mShop/ListList;
    if-eqz v3, :cond_1

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/ListList;->getListId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/ListList;->getListId()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 100
    const/4 v5, 0x0

    invoke-virtual {v0, v5}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 101
    iget-object v5, p0, Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;->this$0:Lcom/amazon/mShop/wishlist/WishListChooserView;

    invoke-virtual {v5}, Lcom/amazon/mShop/wishlist/WishListChooserView;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/amazon/mShop/android/lib/R$color;->background_gray:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_1

    .line 103
    :cond_1
    invoke-virtual {v0, v8}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 104
    iget-object v5, p0, Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;->this$0:Lcom/amazon/mShop/wishlist/WishListChooserView;

    invoke-virtual {v5}, Lcom/amazon/mShop/wishlist/WishListChooserView;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/amazon/mShop/android/lib/R$color;->dark_text:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_1

    .line 96
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 6
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 119
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v4, p0, Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;->this$0:Lcom/amazon/mShop/wishlist/WishListChooserView;

    # getter for: Lcom/amazon/mShop/wishlist/WishListChooserView;->mOperationType:I
    invoke-static {v4}, Lcom/amazon/mShop/wishlist/WishListChooserView;->access$200(Lcom/amazon/mShop/wishlist/WishListChooserView;)I

    move-result v4

    packed-switch v4, :pswitch_data_0

    .line 134
    :goto_0
    invoke-virtual {p0, p3}, Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;->getItem(I)Lcom/amazon/rio/j2me/client/services/mShop/ListList;

    move-result-object v3

    .line 135
    .local v3, "selectedList":Lcom/amazon/rio/j2me/client/services/mShop/ListList;
    iget-object v4, p0, Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;->this$0:Lcom/amazon/mShop/wishlist/WishListChooserView;

    # getter for: Lcom/amazon/mShop/wishlist/WishListChooserView;->mChooserSubscriber:Lcom/amazon/mShop/wishlist/WishListChooserSubscriber;
    invoke-static {v4}, Lcom/amazon/mShop/wishlist/WishListChooserView;->access$300(Lcom/amazon/mShop/wishlist/WishListChooserView;)Lcom/amazon/mShop/wishlist/WishListChooserSubscriber;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;->this$0:Lcom/amazon/mShop/wishlist/WishListChooserView;

    # getter for: Lcom/amazon/mShop/wishlist/WishListChooserView;->mOperationType:I
    invoke-static {v5}, Lcom/amazon/mShop/wishlist/WishListChooserView;->access$200(Lcom/amazon/mShop/wishlist/WishListChooserView;)I

    move-result v5

    invoke-interface {v4, v3, v5}, Lcom/amazon/mShop/wishlist/WishListChooserSubscriber;->onListSelected(Lcom/amazon/rio/j2me/client/services/mShop/ListList;I)V

    .line 136
    return-void

    .line 121
    .end local v3    # "selectedList":Lcom/amazon/rio/j2me/client/services/mShop/ListList;
    :pswitch_0
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    iget-object v4, p0, Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;->this$0:Lcom/amazon/mShop/wishlist/WishListChooserView;

    invoke-virtual {v4}, Lcom/amazon/mShop/wishlist/WishListChooserView;->getChildCount()I

    move-result v4

    if-ge v1, v4, :cond_1

    .line 122
    iget-object v4, p0, Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;->this$0:Lcom/amazon/mShop/wishlist/WishListChooserView;

    invoke-virtual {v4, v1}, Lcom/amazon/mShop/wishlist/WishListChooserView;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    .line 123
    .local v2, "itemView":Landroid/view/View;
    if-eqz v2, :cond_0

    .line 124
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->check_mark:I

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 125
    .local v0, "checkmark":Landroid/widget/ImageView;
    const/16 v4, 0x8

    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 121
    .end local v0    # "checkmark":Landroid/widget/ImageView;
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 129
    .end local v2    # "itemView":Landroid/view/View;
    :cond_1
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->check_mark:I

    invoke-virtual {p2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    .line 130
    .restart local v0    # "checkmark":Landroid/widget/ImageView;
    const/4 v4, 0x0

    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0

    .line 119
    nop

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
    .end packed-switch
.end method

.method public setWishLists(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/ListList;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 62
    .local p1, "wishLists":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ListList;>;"
    iput-object p1, p0, Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;->mWishLists:Ljava/util/List;

    .line 63
    return-void
.end method
