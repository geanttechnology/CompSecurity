.class public Lcom/amazon/mShop/wishlist/WishListChooserView;
.super Landroid/widget/ListView;
.source "WishListChooserView.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/wishlist/WishListChooserView$1;,
        Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;
    }
.end annotation


# instance fields
.field private mActivity:Lcom/amazon/mShop/AmazonActivity;

.field private mChooserSubscriber:Lcom/amazon/mShop/wishlist/WishListChooserSubscriber;

.field private mOperationType:I

.field protected mWishListsAdapter:Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;ILcom/amazon/mShop/wishlist/WishListChooserSubscriber;)V
    .locals 2
    .param p1, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "operationType"    # I
    .param p3, "subScriber"    # Lcom/amazon/mShop/wishlist/WishListChooserSubscriber;

    .prologue
    .line 43
    invoke-direct {p0, p1}, Landroid/widget/ListView;-><init>(Landroid/content/Context;)V

    .line 44
    iput-object p1, p0, Lcom/amazon/mShop/wishlist/WishListChooserView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 45
    iput-object p3, p0, Lcom/amazon/mShop/wishlist/WishListChooserView;->mChooserSubscriber:Lcom/amazon/mShop/wishlist/WishListChooserSubscriber;

    .line 46
    iput p2, p0, Lcom/amazon/mShop/wishlist/WishListChooserView;->mOperationType:I

    .line 48
    new-instance v0, Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;-><init>(Lcom/amazon/mShop/wishlist/WishListChooserView;Lcom/amazon/mShop/wishlist/WishListChooserView$1;)V

    iput-object v0, p0, Lcom/amazon/mShop/wishlist/WishListChooserView;->mWishListsAdapter:Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;

    .line 49
    sget v0, Lcom/amazon/mShop/android/lib/R$color;->white:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/wishlist/WishListChooserView;->setBackgroundResource(I)V

    .line 51
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/wishlist/WishListChooserView;->setItemsCanFocus(Z)V

    .line 52
    iget-object v0, p0, Lcom/amazon/mShop/wishlist/WishListChooserView;->mWishListsAdapter:Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/wishlist/WishListChooserView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 53
    iget-object v0, p0, Lcom/amazon/mShop/wishlist/WishListChooserView;->mWishListsAdapter:Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/wishlist/WishListChooserView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 54
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/mShop/wishlist/WishListChooserView;)Lcom/amazon/mShop/AmazonActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/wishlist/WishListChooserView;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/wishlist/WishListChooserView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/wishlist/WishListChooserView;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/wishlist/WishListChooserView;

    .prologue
    .line 18
    iget v0, p0, Lcom/amazon/mShop/wishlist/WishListChooserView;->mOperationType:I

    return v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/wishlist/WishListChooserView;)Lcom/amazon/mShop/wishlist/WishListChooserSubscriber;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/wishlist/WishListChooserView;

    .prologue
    .line 18
    iget-object v0, p0, Lcom/amazon/mShop/wishlist/WishListChooserView;->mChooserSubscriber:Lcom/amazon/mShop/wishlist/WishListChooserSubscriber;

    return-object v0
.end method


# virtual methods
.method public setWishLists(Ljava/util/List;)V
    .locals 1
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
    .line 140
    .local p1, "wishLists":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ListList;>;"
    iget-object v0, p0, Lcom/amazon/mShop/wishlist/WishListChooserView;->mWishListsAdapter:Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/wishlist/WishListChooserView$WishListsAdapter;->setWishLists(Ljava/util/List;)V

    .line 141
    return-void
.end method
