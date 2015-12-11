.class Lcom/amazon/mShop/cvsd/CVSDMapActivity$OptionListAdapter;
.super Landroid/widget/BaseAdapter;
.source "CVSDMapActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/cvsd/CVSDMapActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "OptionListAdapter"
.end annotation


# instance fields
.field private final mContext:Landroid/content/Context;

.field private final mItems:[Ljava/lang/CharSequence;

.field private final mLayoutInflater:Landroid/view/LayoutInflater;

.field final synthetic this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Landroid/content/Context;)V
    .locals 4
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 496
    iput-object p1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$OptionListAdapter;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 497
    iput-object p2, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$OptionListAdapter;->mContext:Landroid/content/Context;

    .line 498
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$OptionListAdapter;->mContext:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$OptionListAdapter;->mLayoutInflater:Landroid/view/LayoutInflater;

    .line 499
    const/4 v0, 0x4

    new-array v0, v0, [Ljava/lang/CharSequence;

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$OptionListAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->opl_cvsd_search_address:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x1

    iget-object v2, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$OptionListAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->opl_cvsd_search_zip:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x2

    iget-object v2, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$OptionListAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->opl_cvsd_search_landmark:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v0, v1

    const/4 v1, 0x3

    iget-object v2, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$OptionListAdapter;->mContext:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->opl_cvsd_search_location:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    aput-object v2, v0, v1

    iput-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$OptionListAdapter;->mItems:[Ljava/lang/CharSequence;

    .line 505
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 513
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$OptionListAdapter;->mItems:[Ljava/lang/CharSequence;

    array-length v0, v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 518
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$OptionListAdapter;->mItems:[Ljava/lang/CharSequence;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 523
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 528
    move-object v1, p2

    .line 529
    .local v1, "itemView":Landroid/view/View;
    if-nez p2, :cond_0

    .line 530
    iget-object v2, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$OptionListAdapter;->mLayoutInflater:Landroid/view/LayoutInflater;

    sget v3, Lcom/amazon/mShop/android/lib/R$layout;->cvsd_list_item:I

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 532
    :cond_0
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->cvsd_list_item_text:I

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 533
    .local v0, "itemText":Landroid/widget/TextView;
    const/4 v2, 0x0

    invoke-virtual {v0}, Landroid/widget/TextView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$dimen;->cvsd_list_item_text_size:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimension(I)F

    move-result v3

    invoke-virtual {v0, v2, v3}, Landroid/widget/TextView;->setTextSize(IF)V

    .line 534
    iget-object v2, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$OptionListAdapter;->mItems:[Ljava/lang/CharSequence;

    aget-object v2, v2, p1

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 535
    return-object v1
.end method
