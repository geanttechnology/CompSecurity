.class public Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;
.super Landroid/widget/TableRow;
.source "MShopWebDebugSwitchNativeVSHTMLRow.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow$OnSelectionChangedListener;
    }
.end annotation


# instance fields
.field private mFeatureKey:Ljava/lang/String;

.field private mFeatureTextView:Landroid/widget/TextView;

.field private mHTMLBox:Landroid/widget/CheckBox;

.field private mLastCheckedBox:Landroid/widget/CheckBox;

.field private mNativeBox:Landroid/widget/CheckBox;

.field private mSelectionChangeListener:Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow$OnSelectionChangedListener;

.field private mWeblabBox:Landroid/widget/CheckBox;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 28
    invoke-direct {p0, p1, p2}, Landroid/widget/TableRow;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 30
    return-void
.end method


# virtual methods
.method public getSelectedFeatureValue()Ljava/lang/String;
    .locals 1

    .prologue
    .line 62
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mLastCheckedBox:Landroid/widget/CheckBox;

    invoke-virtual {v0}, Landroid/widget/CheckBox;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 79
    move-object v1, p1

    check-cast v1, Landroid/widget/CheckBox;

    .line 80
    .local v1, "clickedBox":Landroid/widget/CheckBox;
    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mLastCheckedBox:Landroid/widget/CheckBox;

    if-eq v2, v1, :cond_1

    .line 81
    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mLastCheckedBox:Landroid/widget/CheckBox;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 82
    iput-object v1, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mLastCheckedBox:Landroid/widget/CheckBox;

    .line 83
    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mLastCheckedBox:Landroid/widget/CheckBox;

    invoke-virtual {v2}, Landroid/widget/CheckBox;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 84
    .local v0, "checkedItem":Ljava/lang/String;
    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mSelectionChangeListener:Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow$OnSelectionChangedListener;

    if-eqz v2, :cond_0

    .line 85
    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mSelectionChangeListener:Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow$OnSelectionChangedListener;

    iget-object v3, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mFeatureKey:Ljava/lang/String;

    invoke-interface {v2, v0, v3}, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow$OnSelectionChangedListener;->onSelectionChanged(Ljava/lang/String;Ljava/lang/String;)V

    .line 91
    .end local v0    # "checkedItem":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 88
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mLastCheckedBox:Landroid/widget/CheckBox;

    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto :goto_0
.end method

.method protected onFinishInflate()V
    .locals 2

    .prologue
    .line 46
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->web_debug_settings_item_feature_name:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mFeatureTextView:Landroid/widget/TextView;

    .line 48
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->web_debug_settings_item_use_native:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    iput-object v0, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mNativeBox:Landroid/widget/CheckBox;

    .line 49
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->web_debug_settings_item_use_html:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    iput-object v0, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mHTMLBox:Landroid/widget/CheckBox;

    .line 50
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->web_debug_settings_item_use_weblab:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    iput-object v0, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mWeblabBox:Landroid/widget/CheckBox;

    .line 52
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mNativeBox:Landroid/widget/CheckBox;

    const-string/jumbo v1, "featureNative"

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setTag(Ljava/lang/Object;)V

    .line 53
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mHTMLBox:Landroid/widget/CheckBox;

    const-string/jumbo v1, "fatureHTML"

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setTag(Ljava/lang/Object;)V

    .line 54
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mWeblabBox:Landroid/widget/CheckBox;

    const-string/jumbo v1, "featureWeblab"

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setTag(Ljava/lang/Object;)V

    .line 56
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mWeblabBox:Landroid/widget/CheckBox;

    invoke-virtual {v0, p0}, Landroid/widget/CheckBox;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 57
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mNativeBox:Landroid/widget/CheckBox;

    invoke-virtual {v0, p0}, Landroid/widget/CheckBox;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 58
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mHTMLBox:Landroid/widget/CheckBox;

    invoke-virtual {v0, p0}, Landroid/widget/CheckBox;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 59
    return-void
.end method

.method public setFeatureKey(Ljava/lang/String;)V
    .locals 0
    .param p1, "featureKey"    # Ljava/lang/String;

    .prologue
    .line 41
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mFeatureKey:Ljava/lang/String;

    .line 42
    return-void
.end method

.method public setFeatureName(Ljava/lang/String;)V
    .locals 1
    .param p1, "featureName"    # Ljava/lang/String;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mFeatureTextView:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 38
    return-void
.end method

.method public setOnSelectionChangeListener(Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow$OnSelectionChangedListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow$OnSelectionChangedListener;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mSelectionChangeListener:Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow$OnSelectionChangedListener;

    .line 34
    return-void
.end method

.method public setSelectedFeatureValue(Ljava/lang/String;)V
    .locals 2
    .param p1, "selectedItem"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x1

    .line 66
    const-string/jumbo v0, "fatureHTML"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 67
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mHTMLBox:Landroid/widget/CheckBox;

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 68
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mHTMLBox:Landroid/widget/CheckBox;

    iput-object v0, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mLastCheckedBox:Landroid/widget/CheckBox;

    .line 76
    :goto_0
    return-void

    .line 69
    :cond_0
    const-string/jumbo v0, "featureNative"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 70
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mNativeBox:Landroid/widget/CheckBox;

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 71
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mNativeBox:Landroid/widget/CheckBox;

    iput-object v0, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mLastCheckedBox:Landroid/widget/CheckBox;

    goto :goto_0

    .line 73
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mWeblabBox:Landroid/widget/CheckBox;

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 74
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mWeblabBox:Landroid/widget/CheckBox;

    iput-object v0, p0, Lcom/amazon/mShop/web/MShopWebDebugSwitchNativeVSHTMLRow;->mLastCheckedBox:Landroid/widget/CheckBox;

    goto :goto_0
.end method
