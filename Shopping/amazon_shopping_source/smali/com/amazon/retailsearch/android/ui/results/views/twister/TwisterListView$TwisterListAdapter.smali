.class Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter;
.super Landroid/widget/BaseAdapter;
.source "TwisterListView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "TwisterListAdapter"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;


# direct methods
.method private constructor <init>(Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;)V
    .locals 0

    .prologue
    .line 90
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$1;

    .prologue
    .line 90
    invoke-direct {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter;-><init>(Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;)V

    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 94
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;->editions:[Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;

    if-nez v0, :cond_0

    .line 96
    const/4 v0, 0x0

    .line 98
    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;

    iget-object v0, v0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;->editions:[Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;

    array-length v0, v0

    goto :goto_0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 104
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 110
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 9
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 116
    move-object v5, p2

    .line 117
    .local v5, "vi":Landroid/view/View;
    if-nez p2, :cond_0

    .line 119
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;

    invoke-virtual {v6}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;->getContext()Landroid/content/Context;

    move-result-object v6

    sget v7, Lcom/amazon/retailsearch/R$layout;->rs_twister_list_item:I

    const/4 v8, 0x0

    invoke-static {v6, v7, v8}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v5

    .line 123
    :cond_0
    if-ltz p1, :cond_1

    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;

    iget-object v6, v6, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;->editions:[Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;

    array-length v6, v6

    if-lt p1, v6, :cond_2

    :cond_1
    move-object v5, p2

    .line 168
    .end local v5    # "vi":Landroid/view/View;
    :goto_0
    return-object v5

    .line 128
    .restart local v5    # "vi":Landroid/view/View;
    :cond_2
    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;

    iget-object v6, v6, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;->editions:[Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;

    aget-object v0, v6, p1

    .line 132
    .local v0, "edition":Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;
    sget v6, Lcom/amazon/retailsearch/R$id;->rs_twister_item_edition_info:I

    invoke-virtual {v5, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 135
    .local v2, "itemInfo":Landroid/widget/TextView;
    new-instance v4, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    iget-object v6, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter;->this$0:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;

    invoke-virtual {v6}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView;->getContext()Landroid/content/Context;

    move-result-object v6

    invoke-direct {v4, v6}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;-><init>(Landroid/content/Context;)V

    .line 136
    .local v4, "sss":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    iget-object v1, v0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;->text:Ljava/lang/String;

    .line 137
    .local v1, "editionText":Ljava/lang/String;
    invoke-virtual {v4, v1}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/CharSequence;)Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    .line 139
    iget-object v6, v0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;->price:Ljava/lang/String;

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_3

    .line 141
    const-string/jumbo v6, " - "

    invoke-virtual {v4, v6}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/CharSequence;)Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    .line 142
    iget-object v6, v0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;->price:Ljava/lang/String;

    sget v7, Lcom/amazon/retailsearch/R$style;->Rs_Twister_ItemInfo_PriceSpan:I

    invoke-virtual {v4, v6, v7}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/String;I)V

    .line 145
    :cond_3
    iget-object v6, v0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;->srdsBadgeId:Ljava/lang/String;

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_4

    .line 147
    const-string/jumbo v6, " "

    invoke-virtual {v4, v6}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/CharSequence;)Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    .line 148
    iget-object v6, v0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;->srdsBadgeId:Ljava/lang/String;

    sget v7, Lcom/amazon/retailsearch/R$style;->Rs_Twister_ItemInfo_BadgeSpan:I

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    invoke-virtual {v4, v6, v7}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->appendBadge(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 151
    :cond_4
    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 153
    iget-object v3, v0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel$Edition;->resultItem:Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;

    .line 155
    .local v3, "resultItem":Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;
    new-instance v6, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter$1;

    invoke-direct {v6, p0, v3}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter$1;-><init>(Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterListView$TwisterListAdapter;Lcom/amazon/retailsearch/android/api/display/results/item/RetailSearchResultItem;)V

    invoke-virtual {v5, v6}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0
.end method
