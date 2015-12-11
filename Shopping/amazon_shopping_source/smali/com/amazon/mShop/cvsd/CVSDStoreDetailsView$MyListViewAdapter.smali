.class Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView$MyListViewAdapter;
.super Ljava/lang/Object;
.source "CVSDStoreDetailsView.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;
.implements Landroid/widget/ListAdapter;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "MyListViewAdapter"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;)V
    .locals 0

    .prologue
    .line 44
    iput-object p1, p0, Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView$MyListViewAdapter;->this$0:Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;
    .param p2, "x1"    # Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView$1;

    .prologue
    .line 44
    invoke-direct {p0, p1}, Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView$MyListViewAdapter;-><init>(Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;)V

    return-void
.end method


# virtual methods
.method public areAllItemsEnabled()Z
    .locals 1

    .prologue
    .line 48
    const/4 v0, 0x1

    return v0
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 58
    sget-object v0, Lcom/amazon/mShop/control/cvsd/CVSDReceivedResult;->receivedAddresss:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 64
    const/4 v0, 0x0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 69
    int-to-long v0, p1

    return-wide v0
.end method

.method public getItemViewType(I)I
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 74
    const/4 v0, 0x0

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 80
    move-object v2, p2

    check-cast v2, Landroid/widget/CheckedTextView;

    .line 82
    .local v2, "storeDetailsView":Landroid/widget/CheckedTextView;
    if-nez v2, :cond_0

    .line 83
    iget-object v3, p0, Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView$MyListViewAdapter;->this$0:Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;

    # getter for: Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;->layoutInflater:Landroid/view/LayoutInflater;
    invoke-static {v3}, Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;->access$100(Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;)Landroid/view/LayoutInflater;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$layout;->picker_item:I

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .end local v2    # "storeDetailsView":Landroid/widget/CheckedTextView;
    check-cast v2, Landroid/widget/CheckedTextView;

    .line 86
    .restart local v2    # "storeDetailsView":Landroid/widget/CheckedTextView;
    :cond_0
    sget-object v3, Lcom/amazon/mShop/control/cvsd/CVSDReceivedResult;->receivedAddresss:Ljava/util/List;

    const/4 v4, 0x0

    invoke-interface {v3, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/rio/j2me/client/services/mShop/Address;

    .line 88
    .local v1, "selectedAddress":Lcom/amazon/rio/j2me/client/services/mShop/Address;
    const/4 v3, 0x2

    invoke-static {v1, v3}, Lcom/amazon/mShop/ui/resources/AddressFormat;->formatAddress(Lcom/amazon/rio/j2me/client/services/mShop/Address;I)Ljava/lang/String;

    move-result-object v0

    .line 90
    .local v0, "s":Ljava/lang/String;
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getInformation()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 91
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, "\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/Address;->getInformation()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 94
    :cond_1
    invoke-virtual {v2, v0}, Landroid/widget/CheckedTextView;->setText(Ljava/lang/CharSequence;)V

    .line 96
    return-object v2
.end method

.method public getViewTypeCount()I
    .locals 1

    .prologue
    .line 101
    const/4 v0, 0x1

    return v0
.end method

.method public hasStableIds()Z
    .locals 1

    .prologue
    .line 106
    const/4 v0, 0x0

    return v0
.end method

.method public isEmpty()Z
    .locals 1

    .prologue
    .line 111
    invoke-virtual {p0}, Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView$MyListViewAdapter;->getCount()I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isEnabled(I)Z
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 53
    const/4 v0, 0x1

    return v0
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 4
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
    .line 127
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    invoke-virtual {p1}, Landroid/widget/AdapterView;->getChildCount()I

    move-result v2

    if-ge v1, v2, :cond_2

    .line 128
    invoke-virtual {p1, v1}, Landroid/widget/AdapterView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 129
    .local v0, "childView":Landroid/view/View;
    instance-of v2, v0, Landroid/widget/Checkable;

    if-eqz v2, :cond_0

    move-object v2, v0

    .line 130
    check-cast v2, Landroid/widget/Checkable;

    if-ne v0, p2, :cond_1

    const/4 v3, 0x1

    :goto_1
    invoke-interface {v2, v3}, Landroid/widget/Checkable;->setChecked(Z)V

    .line 127
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 130
    :cond_1
    const/4 v3, 0x0

    goto :goto_1

    .line 134
    .end local v0    # "childView":Landroid/view/View;
    :cond_2
    iget-object v2, p0, Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView$MyListViewAdapter;->this$0:Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;

    # getter for: Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v2}, Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;->access$200(Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v2

    const/4 v3, -0x1

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/AmazonActivity;->setResult(I)V

    .line 135
    iget-object v2, p0, Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView$MyListViewAdapter;->this$0:Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;

    # getter for: Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;->amazonActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v2}, Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;->access$200(Lcom/amazon/mShop/cvsd/CVSDStoreDetailsView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonActivity;->finish()V

    .line 136
    return-void
.end method

.method public registerDataSetObserver(Landroid/database/DataSetObserver;)V
    .locals 0
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 117
    return-void
.end method

.method public unregisterDataSetObserver(Landroid/database/DataSetObserver;)V
    .locals 0
    .param p1, "observer"    # Landroid/database/DataSetObserver;

    .prologue
    .line 122
    return-void
.end method
