.class public Lcom/amazon/mShop/util/BadgeUtils;
.super Ljava/lang/Object;
.source "BadgeUtils.java"


# static fields
.field private static sBadgeImagesMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Landroid/graphics/Bitmap;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 37
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/amazon/mShop/util/BadgeUtils;->sBadgeImagesMap:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 32
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static addBadgeBitampToCache(Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 1
    .param p0, "baseUrl"    # Ljava/lang/String;
    .param p1, "bitmap"    # Landroid/graphics/Bitmap;

    .prologue
    .line 48
    sget-object v0, Lcom/amazon/mShop/util/BadgeUtils;->sBadgeImagesMap:Ljava/util/Map;

    invoke-interface {v0, p0, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 49
    return-void
.end method

.method public static clearCachedBadge()V
    .locals 1

    .prologue
    .line 53
    sget-object v0, Lcom/amazon/mShop/util/BadgeUtils;->sBadgeImagesMap:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 54
    return-void
.end method

.method public static getBadgeImageUrl(Lcom/amazon/rio/j2me/client/services/mShop/Badge;)Ljava/lang/String;
    .locals 1
    .param p0, "badge"    # Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    .prologue
    .line 97
    if-eqz p0, :cond_0

    invoke-static {p0}, Lcom/amazon/mShop/util/BadgeUtils;->hasBadgeUrl(Lcom/amazon/rio/j2me/client/services/mShop/Badge;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 98
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Badge;->getMeta()Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->getImageLink()Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;->getUrl()Ljava/lang/String;

    move-result-object v0

    .line 100
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static getCachedBadge(Ljava/lang/String;)Landroid/graphics/Bitmap;
    .locals 1
    .param p0, "key"    # Ljava/lang/String;

    .prologue
    .line 40
    invoke-static {p0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 41
    sget-object v0, Lcom/amazon/mShop/util/BadgeUtils;->sBadgeImagesMap:Ljava/util/Map;

    invoke-interface {v0, p0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/Bitmap;

    .line 43
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static getUrlLinkFromRichMessage(Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;)Ljava/lang/String;
    .locals 4
    .param p0, "richMessage"    # Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    .prologue
    .line 109
    if-eqz p0, :cond_1

    .line 110
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->getMessages()Ljava/util/List;

    move-result-object v0

    .line 111
    .local v0, "hyperTexts":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HyperText;>;"
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 112
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    .line 113
    .local v1, "hypertext":Lcom/amazon/rio/j2me/client/services/mShop/HyperText;
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;->getAttributes()Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;

    move-result-object v3

    if-eqz v3, :cond_0

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;->getAttributes()Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->getLinkUrl()Ljava/lang/String;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 115
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;->getAttributes()Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/TextAttributes;->getLinkUrl()Ljava/lang/String;

    move-result-object v3

    .line 120
    .end local v0    # "hyperTexts":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HyperText;>;"
    .end local v1    # "hypertext":Lcom/amazon/rio/j2me/client/services/mShop/HyperText;
    .end local v2    # "i$":Ljava/util/Iterator;
    :goto_0
    return-object v3

    :cond_1
    const/4 v3, 0x0

    goto :goto_0
.end method

.method public static hasBadgeDefaultHyperText(Lcom/amazon/rio/j2me/client/services/mShop/Badge;)Z
    .locals 1
    .param p0, "badge"    # Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    .prologue
    .line 86
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Badge;->getMeta()Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Badge;->getMeta()Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->getMessages()Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static hasBadgeUrl(Lcom/amazon/rio/j2me/client/services/mShop/Badge;)Z
    .locals 1
    .param p0, "badge"    # Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    .prologue
    .line 74
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Badge;->getMeta()Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Badge;->getMeta()Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->getImageLink()Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/Badge;->getMeta()Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->getImageLink()Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/UniversalLink;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static isContainedBadge(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)Z
    .locals 1
    .param p0, "basicOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    .prologue
    .line 62
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getBadgeInfo()Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getBadgeInfo()Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->getBadge()Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getBadgeInfo()Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->getBadge()Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/Badge;->getMeta()Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static setBadgeItemSpan(Landroid/text/SpannableStringBuilder;Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;Lcom/amazon/mShop/AmazonActivity;)V
    .locals 3
    .param p0, "spanned"    # Landroid/text/SpannableStringBuilder;
    .param p1, "richMessage"    # Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;
    .param p2, "activity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 130
    if-eqz p0, :cond_1

    if-eqz p1, :cond_1

    .line 132
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 133
    .local v1, "textBackgroundColors":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->getBackgroundColor()Ljava/lang/Integer;

    move-result-object v0

    .line 134
    .local v0, "backgroundColor":Ljava/lang/Integer;
    if-eqz v0, :cond_0

    .line 135
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 137
    :cond_0
    const-string/jumbo v2, " "

    invoke-virtual {p0, v2}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 138
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->getMessages()Ljava/util/List;

    move-result-object v2

    invoke-static {p2, p0, v2, v1}, Lcom/amazon/mShop/util/UIUtils;->setSpanFromHyperTexts(Lcom/amazon/mShop/AmazonActivity;Landroid/text/SpannableStringBuilder;Ljava/util/List;Ljava/util/List;)V

    .line 140
    .end local v0    # "backgroundColor":Ljava/lang/Integer;
    .end local v1    # "textBackgroundColors":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    :cond_1
    return-void
.end method

.method public static updateAddOnMessage(Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;Landroid/widget/TextView;Lcom/amazon/mShop/AmazonActivity;Z)V
    .locals 16
    .param p0, "richMessage"    # Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;
    .param p1, "addOnMessageTextView"    # Landroid/widget/TextView;
    .param p2, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p3, "isAddOnDetailedMessage"    # Z

    .prologue
    .line 154
    if-eqz p0, :cond_4

    if-eqz p1, :cond_4

    .line 155
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->getMessages()Ljava/util/List;

    move-result-object v5

    .line 158
    .local v5, "hyperTexts":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HyperText;>;"
    invoke-static/range {p0 .. p0}, Lcom/amazon/mShop/util/BadgeUtils;->getUrlLinkFromRichMessage(Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;)Ljava/lang/String;

    move-result-object v8

    .line 159
    .local v8, "linkUrl":Ljava/lang/String;
    invoke-static {v8}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v13

    if-nez v13, :cond_0

    .line 160
    new-instance v13, Lcom/amazon/mShop/util/BadgeUtils$1;

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v13, v0, v1, v8}, Lcom/amazon/mShop/util/BadgeUtils$1;-><init>(Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;)V

    move-object/from16 v0, p1

    invoke-virtual {v0, v13}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 174
    :cond_0
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->getMessages()Ljava/util/List;

    move-result-object v13

    invoke-interface {v13}, Ljava/util/List;->size()I

    move-result v13

    const/4 v14, 0x2

    if-le v13, v14, :cond_1

    .line 175
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->getMessages()Ljava/util/List;

    move-result-object v13

    invoke-virtual/range {p0 .. p0}, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->getMessages()Ljava/util/List;

    move-result-object v14

    invoke-interface {v14}, Ljava/util/List;->size()I

    move-result v14

    add-int/lit8 v14, v14, -0x1

    invoke-interface {v13, v14}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 179
    :cond_1
    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .local v6, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v13

    if-eqz v13, :cond_2

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    .line 180
    .local v4, "hyperText":Lcom/amazon/rio/j2me/client/services/mShop/HyperText;
    const/4 v13, 0x1

    invoke-virtual {v4, v13}, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;->setLineBreak(Z)V

    goto :goto_0

    .line 183
    .end local v4    # "hyperText":Lcom/amazon/rio/j2me/client/services/mShop/HyperText;
    :cond_2
    invoke-virtual/range {p2 .. p2}, Lcom/amazon/mShop/AmazonActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    .line 185
    .local v11, "res":Landroid/content/res/Resources;
    new-instance v3, Landroid/graphics/drawable/StateListDrawable;

    invoke-direct {v3}, Landroid/graphics/drawable/StateListDrawable;-><init>()V

    .line 186
    .local v3, "backgroundStates":Landroid/graphics/drawable/StateListDrawable;
    const/4 v13, 0x1

    new-array v13, v13, [I

    const/4 v14, 0x0

    const v15, 0x10100a7

    aput v15, v13, v14

    sget v14, Lcom/amazon/mShop/android/lib/R$drawable;->orange_outline_sharp_corner:I

    invoke-virtual {v11, v14}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v14

    invoke-virtual {v3, v13, v14}, Landroid/graphics/drawable/StateListDrawable;->addState([ILandroid/graphics/drawable/Drawable;)V

    .line 188
    const/4 v13, 0x1

    new-array v13, v13, [I

    const/4 v14, 0x0

    const v15, 0x101009c

    aput v15, v13, v14

    sget v14, Lcom/amazon/mShop/android/lib/R$drawable;->orange_outline_sharp_corner:I

    invoke-virtual {v11, v14}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v14

    invoke-virtual {v3, v13, v14}, Landroid/graphics/drawable/StateListDrawable;->addState([ILandroid/graphics/drawable/Drawable;)V

    .line 190
    const/4 v13, 0x1

    new-array v13, v13, [I

    const/4 v14, 0x0

    const v15, 0x10100a1

    aput v15, v13, v14

    sget v14, Lcom/amazon/mShop/android/lib/R$drawable;->orange_outline_sharp_corner:I

    invoke-virtual {v11, v14}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v14

    invoke-virtual {v3, v13, v14}, Landroid/graphics/drawable/StateListDrawable;->addState([ILandroid/graphics/drawable/Drawable;)V

    .line 192
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->getBackgroundColor()Ljava/lang/Integer;

    move-result-object v9

    .line 193
    .local v9, "mBackgroundColor":Ljava/lang/Integer;
    if-eqz v9, :cond_3

    .line 197
    invoke-virtual {v9}, Ljava/lang/Integer;->intValue()I

    move-result v13

    const/high16 v14, -0x1000000

    or-int/2addr v13, v14

    invoke-static {v13}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    .line 198
    const/4 v13, 0x0

    new-array v13, v13, [I

    new-instance v14, Landroid/graphics/drawable/ColorDrawable;

    invoke-virtual {v9}, Ljava/lang/Integer;->intValue()I

    move-result v15

    invoke-direct {v14, v15}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v3, v13, v14}, Landroid/graphics/drawable/StateListDrawable;->addState([ILandroid/graphics/drawable/Drawable;)V

    .line 203
    :cond_3
    new-instance v2, Landroid/graphics/drawable/StateListDrawable;

    invoke-direct {v2}, Landroid/graphics/drawable/StateListDrawable;-><init>()V

    .line 204
    .local v2, "arrowIconStates":Landroid/graphics/drawable/StateListDrawable;
    if-eqz p3, :cond_5

    .line 209
    const/4 v13, 0x2

    new-array v13, v13, [I

    fill-array-data v13, :array_0

    sget v14, Lcom/amazon/mShop/android/lib/R$drawable;->arrow_right_normal:I

    invoke-virtual {v11, v14}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v14

    invoke-virtual {v2, v13, v14}, Landroid/graphics/drawable/StateListDrawable;->addState([ILandroid/graphics/drawable/Drawable;)V

    .line 215
    :goto_1
    const/4 v13, 0x2

    new-array v13, v13, [I

    fill-array-data v13, :array_1

    sget v14, Lcom/amazon/mShop/android/lib/R$drawable;->arrow_right_disabled:I

    invoke-virtual {v11, v14}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v14

    invoke-virtual {v2, v13, v14}, Landroid/graphics/drawable/StateListDrawable;->addState([ILandroid/graphics/drawable/Drawable;)V

    .line 217
    const/4 v13, 0x1

    new-array v13, v13, [I

    const/4 v14, 0x0

    const v15, 0x10100a7

    aput v15, v13, v14

    sget v14, Lcom/amazon/mShop/android/lib/R$drawable;->arrow_right_selected:I

    invoke-virtual {v11, v14}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v14

    invoke-virtual {v2, v13, v14}, Landroid/graphics/drawable/StateListDrawable;->addState([ILandroid/graphics/drawable/Drawable;)V

    .line 219
    const/4 v13, 0x2

    new-array v13, v13, [I

    fill-array-data v13, :array_2

    sget v14, Lcom/amazon/mShop/android/lib/R$drawable;->arrow_right_selected:I

    invoke-virtual {v11, v14}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v14

    invoke-virtual {v2, v13, v14}, Landroid/graphics/drawable/StateListDrawable;->addState([ILandroid/graphics/drawable/Drawable;)V

    .line 221
    if-eqz p3, :cond_6

    .line 226
    const/4 v13, 0x1

    new-array v13, v13, [I

    const/4 v14, 0x0

    const v15, 0x101009e

    aput v15, v13, v14

    sget v14, Lcom/amazon/mShop/android/lib/R$drawable;->arrow_right_normal:I

    invoke-virtual {v11, v14}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v14

    invoke-virtual {v2, v13, v14}, Landroid/graphics/drawable/StateListDrawable;->addState([ILandroid/graphics/drawable/Drawable;)V

    .line 232
    :goto_2
    const/4 v13, 0x1

    new-array v13, v13, [I

    const/4 v14, 0x0

    const v15, 0x101009c

    aput v15, v13, v14

    sget v14, Lcom/amazon/mShop/android/lib/R$drawable;->arrow_right_disabled:I

    invoke-virtual {v11, v14}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v14

    invoke-virtual {v2, v13, v14}, Landroid/graphics/drawable/StateListDrawable;->addState([ILandroid/graphics/drawable/Drawable;)V

    .line 234
    const/4 v13, 0x0

    new-array v13, v13, [I

    sget v14, Lcom/amazon/mShop/android/lib/R$drawable;->arrow_right_disabled:I

    invoke-virtual {v11, v14}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v14

    invoke-virtual {v2, v13, v14}, Landroid/graphics/drawable/StateListDrawable;->addState([ILandroid/graphics/drawable/Drawable;)V

    .line 237
    move-object/from16 v0, p1

    move-object/from16 v1, p2

    invoke-static {v0, v1, v5}, Lcom/amazon/mShop/util/UIUtils;->setHyperTexts(Landroid/widget/TextView;Lcom/amazon/mShop/AmazonActivity;Ljava/util/List;)V

    .line 238
    new-instance v7, Landroid/graphics/drawable/LayerDrawable;

    const/4 v13, 0x2

    new-array v13, v13, [Landroid/graphics/drawable/Drawable;

    const/4 v14, 0x0

    aput-object v3, v13, v14

    const/4 v14, 0x1

    aput-object v2, v13, v14

    invoke-direct {v7, v13}, Landroid/graphics/drawable/LayerDrawable;-><init>([Landroid/graphics/drawable/Drawable;)V

    .line 239
    .local v7, "layer":Landroid/graphics/drawable/LayerDrawable;
    move-object/from16 v0, p1

    invoke-virtual {v0, v7}, Landroid/widget/TextView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 240
    sget v13, Lcom/amazon/mShop/android/lib/R$dimen;->padding:I

    invoke-virtual {v11, v13}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v10

    .line 241
    .local v10, "padding":I
    sget v13, Lcom/amazon/mShop/android/lib/R$dimen;->padding_icon_selector_right:I

    invoke-virtual {v11, v13}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v12

    .line 242
    .local v12, "right_padding":I
    move-object/from16 v0, p1

    invoke-virtual {v0, v10, v10, v12, v10}, Landroid/widget/TextView;->setPadding(IIII)V

    .line 244
    .end local v2    # "arrowIconStates":Landroid/graphics/drawable/StateListDrawable;
    .end local v3    # "backgroundStates":Landroid/graphics/drawable/StateListDrawable;
    .end local v5    # "hyperTexts":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HyperText;>;"
    .end local v6    # "i$":Ljava/util/Iterator;
    .end local v7    # "layer":Landroid/graphics/drawable/LayerDrawable;
    .end local v8    # "linkUrl":Ljava/lang/String;
    .end local v9    # "mBackgroundColor":Ljava/lang/Integer;
    .end local v10    # "padding":I
    .end local v11    # "res":Landroid/content/res/Resources;
    .end local v12    # "right_padding":I
    :cond_4
    return-void

    .line 212
    .restart local v2    # "arrowIconStates":Landroid/graphics/drawable/StateListDrawable;
    .restart local v3    # "backgroundStates":Landroid/graphics/drawable/StateListDrawable;
    .restart local v5    # "hyperTexts":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HyperText;>;"
    .restart local v6    # "i$":Ljava/util/Iterator;
    .restart local v8    # "linkUrl":Ljava/lang/String;
    .restart local v9    # "mBackgroundColor":Ljava/lang/Integer;
    .restart local v11    # "res":Landroid/content/res/Resources;
    :cond_5
    const/4 v13, 0x2

    new-array v13, v13, [I

    fill-array-data v13, :array_3

    sget v14, Lcom/amazon/mShop/android/lib/R$drawable;->arrow_right_addon:I

    invoke-virtual {v11, v14}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v14

    invoke-virtual {v2, v13, v14}, Landroid/graphics/drawable/StateListDrawable;->addState([ILandroid/graphics/drawable/Drawable;)V

    goto/16 :goto_1

    .line 229
    :cond_6
    const/4 v13, 0x1

    new-array v13, v13, [I

    const/4 v14, 0x0

    const v15, 0x101009e

    aput v15, v13, v14

    sget v14, Lcom/amazon/mShop/android/lib/R$drawable;->arrow_right_addon:I

    invoke-virtual {v11, v14}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v14

    invoke-virtual {v2, v13, v14}, Landroid/graphics/drawable/StateListDrawable;->addState([ILandroid/graphics/drawable/Drawable;)V

    goto :goto_2

    .line 209
    :array_0
    .array-data 4
        -0x101009d
        0x101009e
    .end array-data

    .line 215
    :array_1
    .array-data 4
        -0x101009d
        -0x101009e
    .end array-data

    .line 219
    :array_2
    .array-data 4
        0x101009c
        0x101009e
    .end array-data

    .line 212
    :array_3
    .array-data 4
        -0x101009d
        0x101009e
    .end array-data
.end method

.method public static updateAddOnMessageBlocks(Landroid/view/ViewGroup;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/mShop/AmazonActivity;)V
    .locals 0
    .param p0, "content"    # Landroid/view/ViewGroup;
    .param p1, "basicOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .param p2, "activity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    .line 314
    invoke-static {p0, p1, p2}, Lcom/amazon/mShop/util/BadgeUtils;->updateDetailedAddOnMessage(Landroid/view/ViewGroup;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/mShop/AmazonActivity;)V

    .line 315
    invoke-static {p0, p1, p2}, Lcom/amazon/mShop/util/BadgeUtils;->updateProminentAddOnMessage(Landroid/view/ViewGroup;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/mShop/AmazonActivity;)V

    .line 316
    return-void
.end method

.method public static updateAddOnProminentMessageTextColor(Landroid/widget/TextView;)V
    .locals 8
    .param p0, "addOnMessageTextView"    # Landroid/widget/TextView;

    .prologue
    const/4 v2, 0x0

    .line 256
    if-eqz p0, :cond_0

    .line 257
    const/16 v6, 0x21

    .line 258
    .local v6, "flag":I
    invoke-virtual {p0}, Landroid/widget/TextView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$color;->add_on_prominent_message_text_selector:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColorStateList(I)Landroid/content/res/ColorStateList;

    move-result-object v4

    .line 260
    .local v4, "colorStateList":Landroid/content/res/ColorStateList;
    new-instance v7, Landroid/text/SpannableStringBuilder;

    invoke-virtual {p0}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v0

    invoke-direct {v7, v0}, Landroid/text/SpannableStringBuilder;-><init>(Ljava/lang/CharSequence;)V

    .line 261
    .local v7, "ssb":Landroid/text/SpannableStringBuilder;
    new-instance v0, Landroid/text/style/TextAppearanceSpan;

    const/4 v1, 0x0

    move v3, v2

    move-object v5, v4

    invoke-direct/range {v0 .. v5}, Landroid/text/style/TextAppearanceSpan;-><init>(Ljava/lang/String;IILandroid/content/res/ColorStateList;Landroid/content/res/ColorStateList;)V

    invoke-virtual {v7}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v1

    invoke-virtual {v7, v0, v2, v1, v6}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 262
    invoke-virtual {p0, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 264
    .end local v4    # "colorStateList":Landroid/content/res/ColorStateList;
    .end local v6    # "flag":I
    .end local v7    # "ssb":Landroid/text/SpannableStringBuilder;
    :cond_0
    return-void
.end method

.method public static updateDetailedAddOnMessage(Landroid/view/ViewGroup;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/mShop/AmazonActivity;)V
    .locals 6
    .param p0, "content"    # Landroid/view/ViewGroup;
    .param p1, "basicOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .param p2, "activity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    const/4 v5, 0x0

    const/16 v4, 0x8

    .line 267
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->add_on_detailed_message:I

    invoke-virtual {p0, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 268
    .local v0, "addOnDetailedMessage":Landroid/widget/TextView;
    sget v3, Lcom/amazon/mShop/android/lib/R$id;->add_on_detailed_message_block_separator:I

    invoke-virtual {p0, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 270
    .local v1, "addOnDetailedMessageSeparator":Landroid/view/View;
    invoke-static {p1}, Lcom/amazon/mShop/control/item/ProductController;->isEligibleForAddOnItem(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 271
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getBadgeInfo()Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->getDetailedMessage()Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    move-result-object v2

    .line 272
    .local v2, "detailedMessage":Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;
    if-eqz v2, :cond_1

    .line 273
    const/4 v3, 0x1

    invoke-static {v2, v0, p2, v3}, Lcom/amazon/mShop/util/BadgeUtils;->updateAddOnMessage(Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;Landroid/widget/TextView;Lcom/amazon/mShop/AmazonActivity;Z)V

    .line 274
    invoke-virtual {v0, v5}, Landroid/widget/TextView;->setVisibility(I)V

    .line 275
    if-eqz v1, :cond_0

    .line 276
    invoke-virtual {v1, v5}, Landroid/view/View;->setVisibility(I)V

    .line 288
    .end local v2    # "detailedMessage":Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;
    :cond_0
    :goto_0
    return-void

    .line 279
    .restart local v2    # "detailedMessage":Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;
    :cond_1
    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 280
    invoke-virtual {v1, v4}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    .line 283
    .end local v2    # "detailedMessage":Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;
    :cond_2
    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 284
    if-eqz v1, :cond_0

    .line 285
    invoke-virtual {v1, v4}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method public static updateProminentAddOnMessage(Landroid/view/ViewGroup;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/mShop/AmazonActivity;)V
    .locals 5
    .param p0, "content"    # Landroid/view/ViewGroup;
    .param p1, "basicOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .param p2, "activity"    # Lcom/amazon/mShop/AmazonActivity;

    .prologue
    const/16 v4, 0x8

    const/4 v3, 0x0

    .line 291
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->add_on_prominent_message:I

    invoke-virtual {p0, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 293
    .local v0, "addOnProminentMessage":Landroid/widget/TextView;
    invoke-static {p1}, Lcom/amazon/mShop/control/item/ProductController;->isEligibleForAddOnItem(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 294
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getBadgeInfo()Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->getProminentMessage()Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    move-result-object v1

    .line 295
    .local v1, "prominentMessage":Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;
    if-eqz v1, :cond_0

    .line 296
    invoke-static {v1, v0, p2, v3}, Lcom/amazon/mShop/util/BadgeUtils;->updateAddOnMessage(Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;Landroid/widget/TextView;Lcom/amazon/mShop/AmazonActivity;Z)V

    .line 297
    invoke-static {v0}, Lcom/amazon/mShop/util/BadgeUtils;->updateAddOnProminentMessageTextColor(Landroid/widget/TextView;)V

    .line 298
    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 305
    .end local v1    # "prominentMessage":Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;
    :goto_0
    return-void

    .line 300
    .restart local v1    # "prominentMessage":Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;
    :cond_0
    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 303
    .end local v1    # "prominentMessage":Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;
    :cond_1
    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method
