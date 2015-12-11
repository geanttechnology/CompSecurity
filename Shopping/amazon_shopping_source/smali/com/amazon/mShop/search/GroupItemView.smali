.class public Lcom/amazon/mShop/search/GroupItemView;
.super Landroid/widget/LinearLayout;
.source "GroupItemView.java"


# instance fields
.field private mExpandableMark:Landroid/widget/ImageView;

.field private mGroupItemSubTitle:Landroid/widget/TextView;

.field private mGroupItemTitle:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 22
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 23
    return-void
.end method


# virtual methods
.method protected onFinishInflate()V
    .locals 1

    .prologue
    .line 27
    invoke-super {p0}, Landroid/widget/LinearLayout;->onFinishInflate()V

    .line 28
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->group_title:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/GroupItemView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/search/GroupItemView;->mGroupItemTitle:Landroid/widget/TextView;

    .line 29
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->group_subtitle:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/GroupItemView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/search/GroupItemView;->mGroupItemSubTitle:Landroid/widget/TextView;

    .line 30
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->expanded_mark:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/GroupItemView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/amazon/mShop/search/GroupItemView;->mExpandableMark:Landroid/widget/ImageView;

    .line 31
    return-void
.end method

.method public update(Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 3
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "subTitle"    # Ljava/lang/String;
    .param p3, "isExpanded"    # Z

    .prologue
    .line 34
    iget-object v0, p0, Lcom/amazon/mShop/search/GroupItemView;->mGroupItemTitle:Landroid/widget/TextView;

    invoke-virtual {v0, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 35
    invoke-static {p2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 36
    iget-object v0, p0, Lcom/amazon/mShop/search/GroupItemView;->mGroupItemSubTitle:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 37
    iget-object v0, p0, Lcom/amazon/mShop/search/GroupItemView;->mGroupItemSubTitle:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/amazon/mShop/search/GroupItemView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/util/UIUtils$CharacterColor;->DARK_GRAY:Lcom/amazon/mShop/util/UIUtils$CharacterColor;

    invoke-static {v1, p2, v2}, Lcom/amazon/mShop/util/UIUtils;->convertUnsupportedCharacter(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/mShop/util/UIUtils$CharacterColor;)Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 43
    :goto_0
    iget-object v1, p0, Lcom/amazon/mShop/search/GroupItemView;->mExpandableMark:Landroid/widget/ImageView;

    if-eqz p3, :cond_1

    sget v0, Lcom/amazon/mShop/android/lib/R$drawable;->arrow_up:I

    :goto_1
    invoke-virtual {v1, v0}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 45
    return-void

    .line 39
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/search/GroupItemView;->mGroupItemSubTitle:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 43
    :cond_1
    sget v0, Lcom/amazon/mShop/android/lib/R$drawable;->arrow_down:I

    goto :goto_1
.end method
