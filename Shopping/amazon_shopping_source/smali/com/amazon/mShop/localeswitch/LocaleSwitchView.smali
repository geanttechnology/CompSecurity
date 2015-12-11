.class public Lcom/amazon/mShop/localeswitch/LocaleSwitchView;
.super Landroid/widget/ListView;
.source "LocaleSwitchView.java"

# interfaces
.implements Lcom/amazon/mShop/TitleProvider;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/localeswitch/LocaleSwitchView$SelectCountryAdapter;,
        Lcom/amazon/mShop/localeswitch/LocaleSwitchView$LocaleItem;
    }
.end annotation


# instance fields
.field private mLocaleSwitcher:Lcom/amazon/mShop/localeswitch/LocaleSwitcher;

.field private mSelectCountryAdapter:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$SelectCountryAdapter;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/amazon/mShop/localeswitch/LocaleSwitcher;)V
    .locals 7
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "localeSwitcher"    # Lcom/amazon/mShop/localeswitch/LocaleSwitcher;

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x0

    .line 78
    invoke-direct {p0, p1}, Landroid/widget/ListView;-><init>(Landroid/content/Context;)V

    .line 79
    iput-object p2, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView;->mLocaleSwitcher:Lcom/amazon/mShop/localeswitch/LocaleSwitcher;

    .line 81
    new-instance v0, Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-direct {v0, v3}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 82
    .local v0, "description":Landroid/widget/TextView;
    invoke-virtual {p0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$dimen;->padding:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    .line 83
    .local v2, "padding":I
    invoke-virtual {v0, v2, v2, v2, v2}, Landroid/widget/TextView;->setPadding(IIII)V

    .line 84
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->amazon_store_header:I

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setText(I)V

    .line 86
    invoke-virtual {p0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$layout;->picker_view_header:I

    invoke-virtual {v3, v4, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 87
    .local v1, "header":Landroid/widget/TextView;
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->locale_switch_select_country_below:I

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setText(I)V

    .line 89
    invoke-virtual {p0, v5}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView;->setHeaderDividersEnabled(Z)V

    .line 90
    invoke-virtual {p0, v0, v6, v5}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 91
    invoke-virtual {p0, v1, v6, v5}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 93
    new-instance v3, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$SelectCountryAdapter;

    invoke-direct {v3, p0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView$SelectCountryAdapter;-><init>(Lcom/amazon/mShop/localeswitch/LocaleSwitchView;)V

    iput-object v3, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView;->mSelectCountryAdapter:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$SelectCountryAdapter;

    .line 94
    iget-object v3, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView;->mSelectCountryAdapter:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$SelectCountryAdapter;

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 95
    iget-object v3, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView;->mSelectCountryAdapter:Lcom/amazon/mShop/localeswitch/LocaleSwitchView$SelectCountryAdapter;

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 96
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/localeswitch/LocaleSwitchView;)Lcom/amazon/mShop/localeswitch/LocaleSwitcher;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/localeswitch/LocaleSwitchView;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/mShop/localeswitch/LocaleSwitchView;->mLocaleSwitcher:Lcom/amazon/mShop/localeswitch/LocaleSwitcher;

    return-object v0
.end method


# virtual methods
.method protected dispatchDraw(Landroid/graphics/Canvas;)V
    .locals 3
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 34
    :try_start_0
    invoke-super {p0, p1}, Landroid/widget/ListView;->dispatchDraw(Landroid/graphics/Canvas;)V
    :try_end_0
    .catch Ljava/lang/IndexOutOfBoundsException; {:try_start_0 .. :try_end_0} :catch_0

    .line 38
    :goto_0
    return-void

    .line 35
    :catch_0
    move-exception v0

    .line 36
    .local v0, "e":Ljava/lang/IndexOutOfBoundsException;
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0}, Ljava/lang/IndexOutOfBoundsException;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public bridge synthetic getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 27
    invoke-virtual {p0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 2

    .prologue
    .line 100
    invoke-virtual {p0}, Lcom/amazon/mShop/localeswitch/LocaleSwitchView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->amazon_store:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
