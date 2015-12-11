.class Lcom/amazon/mShop/localeswitch/LocaleSwitchView$SelectCountryAdapter;
.super Landroid/widget/BaseAdapter;
.source "LocaleSwitchView.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/localeswitch/LocaleSwitchView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SelectCountryAdapter"
.end annotation


# instance fields
.field private final mLayoutInflater:Landroid/view/LayoutInflater;

.field final synthetic this$0:Lcom/amazon/mShop/localeswitch/LocaleSwitchView;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/localeswitch/LocaleSwitchView;)V
    .locals 1

    .prologue
    .line 107
    iput-object p1, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$SelectCountryAdapter;->this$0:Lcom/amazon/mShop/localeswitch/LocaleSwitchView;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 108
    invoke-virtual {p1}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$SelectCountryAdapter;->mLayoutInflater:Landroid/view/LayoutInflater;

    .line 109
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 113
    invoke-static {}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->values()[Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    move-result-object v0

    array-length v0, v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 118
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 123
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 128
    move-object v0, p2

    check-cast v0, Landroid/widget/RelativeLayout;

    .line 129
    .local v0, "itemView":Landroid/widget/RelativeLayout;
    if-nez p2, :cond_0

    .line 130
    iget-object v3, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$SelectCountryAdapter;->mLayoutInflater:Landroid/view/LayoutInflater;

    sget v4, Lcom/amazon/mShop/android/lib/R$layout;->country_item:I

    const/4 v5, 0x0

    invoke-virtual {v3, v4, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .end local v0    # "itemView":Landroid/widget/RelativeLayout;
    check-cast v0, Landroid/widget/RelativeLayout;

    .line 141
    .restart local v0    # "itemView":Landroid/widget/RelativeLayout;
    :cond_0
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->locale_icon:I

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    invoke-static {}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->values()[Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    move-result-object v4

    aget-object v4, v4, p1

    invoke-virtual {v4}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->getIconDrawableId()I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 142
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->check_mark:I

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    sget v4, Lcom/amazon/mShop/android/lib/R$drawable;->btn_check_buttonless_on:I

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 143
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->check_mark:I

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    invoke-static {}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->values()[Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    move-result-object v4

    aget-object v4, v4, p1

    invoke-virtual {v4}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->getLocaleString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/mShop/util/LocaleUtils;->isCurrentLocale(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    const/4 v4, 0x0

    :goto_0
    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 145
    iget-object v3, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$SelectCountryAdapter;->this$0:Lcom/amazon/mShop/localeswitch/LocaleSwitchView;

    invoke-virtual {v3}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView;->getContext()Landroid/content/Context;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->config_marketplaceCountry:I

    invoke-static {}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->values()[Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    move-result-object v5

    aget-object v5, v5, p1

    invoke-virtual {v5}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->getLocaleString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v3, v4, v5}, Lcom/amazon/mShop/util/ConfigUtils;->getStringForSpecificLocale(Landroid/content/Context;ILjava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 146
    .local v1, "marketCountry":Ljava/lang/String;
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->marketplace_country:I

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    check-cast v3, Landroid/widget/TextView;

    invoke-virtual {v3, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 148
    new-instance v2, Ljava/lang/StringBuilder;

    iget-object v3, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$SelectCountryAdapter;->this$0:Lcom/amazon/mShop/localeswitch/LocaleSwitchView;

    invoke-virtual {v3}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView;->getContext()Landroid/content/Context;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->config_marketplaceName:I

    invoke-static {}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->values()[Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    move-result-object v5

    aget-object v5, v5, p1

    invoke-virtual {v5}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->getLocaleString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v3, v4, v5}, Lcom/amazon/mShop/util/ConfigUtils;->getStringForSpecificLocale(Landroid/content/Context;ILjava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 149
    .local v2, "marketPlaceName":Ljava/lang/StringBuilder;
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->marketplace_name:I

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    check-cast v3, Landroid/widget/TextView;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, " - "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 151
    return-object v0

    .line 143
    .end local v1    # "marketCountry":Ljava/lang/String;
    .end local v2    # "marketPlaceName":Ljava/lang/StringBuilder;
    :cond_1
    const/4 v4, 0x4

    goto :goto_0
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 4
    .param p2, "clickedView"    # Landroid/view/View;
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
    .line 160
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v2, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$SelectCountryAdapter;->this$0:Lcom/amazon/mShop/localeswitch/LocaleSwitchView;

    invoke-virtual {v2}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView;->getHeaderViewsCount()I

    move-result v2

    sub-int/2addr p3, v2

    .line 162
    if-ltz p3, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$SelectCountryAdapter;->getCount()I

    move-result v2

    if-lt p3, v2, :cond_1

    .line 176
    :cond_0
    :goto_0
    return-void

    .line 168
    :cond_1
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    invoke-virtual {p1}, Landroid/widget/AdapterView;->getChildCount()I

    move-result v2

    if-ge v1, v2, :cond_4

    .line 169
    invoke-virtual {p1, v1}, Landroid/widget/AdapterView;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 170
    .local v0, "childView":Landroid/view/View;
    instance-of v2, v0, Landroid/widget/RelativeLayout;

    if-eqz v2, :cond_2

    move-object v2, v0

    .line 171
    check-cast v2, Landroid/widget/RelativeLayout;

    sget v3, Lcom/amazon/mShop/android/lib/R$id;->check_mark:I

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    if-ne v0, p2, :cond_3

    const/4 v3, 0x0

    :goto_2
    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 168
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .line 171
    :cond_3
    const/4 v3, 0x4

    goto :goto_2

    .line 175
    .end local v0    # "childView":Landroid/view/View;
    :cond_4
    iget-object v2, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$SelectCountryAdapter;->this$0:Lcom/amazon/mShop/localeswitch/LocaleSwitchView;

    # getter for: Lcom/amazon/mShop/localeswitch/LocaleSwitchView;->mLocaleSwitcher:Lcom/amazon/mShop/localeswitch/LocaleSwitcher;
    invoke-static {v2}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView;->access$000(Lcom/amazon/mShop/localeswitch/LocaleSwitchView;)Lcom/amazon/mShop/localeswitch/LocaleSwitcher;

    move-result-object v2

    invoke-static {}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->values()[Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;

    move-result-object v3

    aget-object v3, v3, p3

    invoke-virtual {v3}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;->getLocaleString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/amazon/mShop/localeswitch/LocaleSwitcher;->changeLocale(Ljava/lang/String;)V

    goto :goto_0
.end method
