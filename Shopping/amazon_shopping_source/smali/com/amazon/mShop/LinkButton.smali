.class public Lcom/amazon/mShop/LinkButton;
.super Landroid/widget/Button;
.source "LinkButton.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private final mConfigId:I

.field private final mHtmlContentId:I

.field private final mLinkClassName:Ljava/lang/String;

.field private final mLinkLayoutId:I

.field private mNavigationTarget:Ljava/lang/String;

.field private mStringUrl:Ljava/lang/String;

.field private final mTextContentId:I

.field private final mTitleResourceId:I

.field private final mUrlContentId:I

.field private final mUrlUseExternalBrowser:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v1, 0x0

    const/4 v2, 0x0

    .line 101
    invoke-direct {p0, p1, p2}, Landroid/widget/Button;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 103
    const-string/jumbo v0, "amazon_linkLayoutId"

    invoke-interface {p2, v2, v0, v1}, Landroid/util/AttributeSet;->getAttributeResourceValue(Ljava/lang/String;Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/LinkButton;->mLinkLayoutId:I

    .line 104
    const-string/jumbo v0, "amazon_linkClassName"

    invoke-interface {p2, v2, v0}, Landroid/util/AttributeSet;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/LinkButton;->mLinkClassName:Ljava/lang/String;

    .line 105
    const-string/jumbo v0, "amazon_titleResourceId"

    invoke-interface {p2, v2, v0, v1}, Landroid/util/AttributeSet;->getAttributeResourceValue(Ljava/lang/String;Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/LinkButton;->mTitleResourceId:I

    .line 106
    const-string/jumbo v0, "amazon_textContentId"

    invoke-interface {p2, v2, v0, v1}, Landroid/util/AttributeSet;->getAttributeResourceValue(Ljava/lang/String;Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/LinkButton;->mTextContentId:I

    .line 107
    const-string/jumbo v0, "amazon_htmlContentId"

    invoke-interface {p2, v2, v0, v1}, Landroid/util/AttributeSet;->getAttributeResourceValue(Ljava/lang/String;Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/LinkButton;->mHtmlContentId:I

    .line 108
    const-string/jumbo v0, "amazon_urlContentId"

    invoke-interface {p2, v2, v0, v1}, Landroid/util/AttributeSet;->getAttributeResourceValue(Ljava/lang/String;Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/LinkButton;->mUrlContentId:I

    .line 109
    const-string/jumbo v0, "amazon_urlUseExternalBrowser"

    invoke-interface {p2, v2, v0, v1}, Landroid/util/AttributeSet;->getAttributeBooleanValue(Ljava/lang/String;Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/amazon/mShop/LinkButton;->mUrlUseExternalBrowser:Z

    .line 110
    const-string/jumbo v0, "amazon_navigationTarget"

    invoke-interface {p2, v2, v0}, Landroid/util/AttributeSet;->getAttributeValue(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/LinkButton;->mNavigationTarget:Ljava/lang/String;

    .line 111
    const-string/jumbo v0, "amazon_configId"

    invoke-interface {p2, v2, v0, v1}, Landroid/util/AttributeSet;->getAttributeResourceValue(Ljava/lang/String;Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/amazon/mShop/LinkButton;->mConfigId:I

    .line 112
    iget v0, p0, Lcom/amazon/mShop/LinkButton;->mConfigId:I

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/LinkButton;->getContext()Landroid/content/Context;

    move-result-object v0

    iget v1, p0, Lcom/amazon/mShop/LinkButton;->mConfigId:I

    invoke-static {v0, v1}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v0

    if-nez v0, :cond_0

    .line 113
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/LinkButton;->setVisibility(I)V

    .line 115
    :cond_0
    iput-object v2, p0, Lcom/amazon/mShop/LinkButton;->mStringUrl:Ljava/lang/String;

    .line 116
    return-void
.end method


# virtual methods
.method public initLinkButton(Ljava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p1, "text"    # Ljava/lang/String;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 119
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/LinkButton;->setText(Ljava/lang/CharSequence;)V

    .line 120
    iput-object p2, p0, Lcom/amazon/mShop/LinkButton;->mStringUrl:Ljava/lang/String;

    .line 121
    invoke-virtual {p0, p0}, Lcom/amazon/mShop/LinkButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 122
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 13
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 135
    invoke-virtual {p0}, Lcom/amazon/mShop/LinkButton;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    .line 137
    .local v0, "activity":Lcom/amazon/mShop/AmazonActivity;
    iget v11, p0, Lcom/amazon/mShop/LinkButton;->mLinkLayoutId:I

    if-eqz v11, :cond_1

    .line 138
    iget v11, p0, Lcom/amazon/mShop/LinkButton;->mLinkLayoutId:I

    invoke-virtual {v0, v11}, Lcom/amazon/mShop/AmazonActivity;->pushView(I)V

    .line 237
    :cond_0
    :goto_0
    return-void

    .line 139
    :cond_1
    iget-object v11, p0, Lcom/amazon/mShop/LinkButton;->mLinkClassName:Ljava/lang/String;

    if-eqz v11, :cond_2

    .line 140
    const/4 v5, 0x0

    .line 142
    .local v5, "standardView":Lcom/amazon/mShop/StandardView;
    :try_start_0
    iget-object v11, p0, Lcom/amazon/mShop/LinkButton;->mLinkClassName:Ljava/lang/String;

    iget v12, p0, Lcom/amazon/mShop/LinkButton;->mTitleResourceId:I

    invoke-static {v11, v0, v12}, Lcom/amazon/mShop/StandardView;->createStandardView(Ljava/lang/String;Landroid/content/Context;I)Lcom/amazon/mShop/StandardView;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    .line 147
    :goto_1
    if-eqz v5, :cond_0

    .line 148
    invoke-virtual {v0, v5}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    goto :goto_0

    .line 144
    :catch_0
    move-exception v3

    .line 145
    .local v3, "e":Ljava/lang/Exception;
    const-string/jumbo v11, "AmazonActivity"

    invoke-virtual {v3}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 150
    .end local v3    # "e":Ljava/lang/Exception;
    .end local v5    # "standardView":Lcom/amazon/mShop/StandardView;
    :cond_2
    iget v11, p0, Lcom/amazon/mShop/LinkButton;->mTextContentId:I

    if-nez v11, :cond_3

    iget v11, p0, Lcom/amazon/mShop/LinkButton;->mHtmlContentId:I

    if-eqz v11, :cond_5

    .line 153
    :cond_3
    iget v11, p0, Lcom/amazon/mShop/LinkButton;->mTextContentId:I

    if-eqz v11, :cond_4

    .line 155
    iget v1, p0, Lcom/amazon/mShop/LinkButton;->mTextContentId:I

    .line 156
    .local v1, "contentId":I
    const/4 v2, 0x0

    .line 163
    .local v2, "contentIsHtml":Z
    :goto_2
    const/4 v6, 0x0

    .line 165
    .local v6, "standardViewWithTextContent":Lcom/amazon/mShop/StandardViewWithTextContent;
    :try_start_1
    new-instance v7, Lcom/amazon/mShop/StandardViewWithTextContent;

    iget v11, p0, Lcom/amazon/mShop/LinkButton;->mTitleResourceId:I

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    invoke-direct {v7, v0, v11, v1, v2}, Lcom/amazon/mShop/StandardViewWithTextContent;-><init>(Landroid/content/Context;Ljava/lang/Integer;IZ)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    .end local v6    # "standardViewWithTextContent":Lcom/amazon/mShop/StandardViewWithTextContent;
    .local v7, "standardViewWithTextContent":Lcom/amazon/mShop/StandardViewWithTextContent;
    move-object v6, v7

    .line 170
    .end local v7    # "standardViewWithTextContent":Lcom/amazon/mShop/StandardViewWithTextContent;
    .restart local v6    # "standardViewWithTextContent":Lcom/amazon/mShop/StandardViewWithTextContent;
    :goto_3
    if-eqz v6, :cond_0

    .line 171
    invoke-virtual {v0, v6}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    goto :goto_0

    .line 159
    .end local v1    # "contentId":I
    .end local v2    # "contentIsHtml":Z
    .end local v6    # "standardViewWithTextContent":Lcom/amazon/mShop/StandardViewWithTextContent;
    :cond_4
    iget v1, p0, Lcom/amazon/mShop/LinkButton;->mHtmlContentId:I

    .line 160
    .restart local v1    # "contentId":I
    const/4 v2, 0x1

    .restart local v2    # "contentIsHtml":Z
    goto :goto_2

    .line 167
    .restart local v6    # "standardViewWithTextContent":Lcom/amazon/mShop/StandardViewWithTextContent;
    :catch_1
    move-exception v3

    .line 168
    .restart local v3    # "e":Ljava/lang/Exception;
    const-string/jumbo v11, "AmazonActivity"

    invoke-virtual {v3}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_3

    .line 174
    .end local v1    # "contentId":I
    .end local v2    # "contentIsHtml":Z
    .end local v3    # "e":Ljava/lang/Exception;
    .end local v6    # "standardViewWithTextContent":Lcom/amazon/mShop/StandardViewWithTextContent;
    :cond_5
    iget v11, p0, Lcom/amazon/mShop/LinkButton;->mUrlContentId:I

    if-eqz v11, :cond_a

    .line 175
    invoke-virtual {p0}, Lcom/amazon/mShop/LinkButton;->getResources()Landroid/content/res/Resources;

    move-result-object v11

    iget v12, p0, Lcom/amazon/mShop/LinkButton;->mUrlContentId:I

    invoke-virtual {v11, v12}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v11

    invoke-static {v11}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v10

    .line 176
    .local v10, "url":Landroid/net/Uri;
    const-string/jumbo v11, "tel"

    invoke-virtual {v10}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_6

    .line 185
    new-instance v4, Landroid/content/Intent;

    const-string/jumbo v11, "android.intent.action.DIAL"

    invoke-direct {v4, v11, v10}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 186
    .local v4, "intent":Landroid/content/Intent;
    invoke-virtual {p0}, Lcom/amazon/mShop/LinkButton;->getContext()Landroid/content/Context;

    move-result-object v11

    invoke-virtual {v11, v4}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 189
    iget v11, p0, Lcom/amazon/mShop/LinkButton;->mUrlContentId:I

    sget v12, Lcom/amazon/mShop/android/lib/R$string;->help_call_customer_service_url:I

    if-ne v11, v12, :cond_0

    .line 190
    const-string/jumbo v11, "mr_ca_cs"

    invoke-static {v11}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 192
    .end local v4    # "intent":Landroid/content/Intent;
    :cond_6
    const-string/jumbo v11, "mailto"

    invoke-virtual {v10}, Landroid/net/Uri;->getScheme()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v11

    if-eqz v11, :cond_7

    .line 194
    invoke-virtual {v10}, Landroid/net/Uri;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-static {v0, v11}, Lcom/amazon/mShop/util/WebUtils;->handleMailtoLink(Landroid/content/Context;Ljava/lang/String;)Z

    goto/16 :goto_0

    .line 197
    :cond_7
    iget-boolean v11, p0, Lcom/amazon/mShop/LinkButton;->mUrlUseExternalBrowser:Z

    if-eqz v11, :cond_9

    .line 198
    new-instance v4, Landroid/content/Intent;

    const-string/jumbo v11, "android.intent.action.VIEW"

    invoke-direct {v4, v11, v10}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 199
    .restart local v4    # "intent":Landroid/content/Intent;
    invoke-virtual {p0}, Lcom/amazon/mShop/LinkButton;->getContext()Landroid/content/Context;

    move-result-object v11

    invoke-virtual {v11, v4}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    .line 214
    .end local v4    # "intent":Landroid/content/Intent;
    :cond_8
    :goto_4
    iget v11, p0, Lcom/amazon/mShop/LinkButton;->mUrlContentId:I

    sget v12, Lcom/amazon/mShop/android/lib/R$string;->help_email_customer_service_url:I

    if-ne v11, v12, :cond_0

    .line 215
    const-string/jumbo v11, "mr_em_cs"

    invoke-static {v11}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 201
    :cond_9
    const/4 v8, 0x0

    .line 203
    .local v8, "standardViewWithUrlContent":Lcom/amazon/mShop/StandardViewWithUrlContent;
    :try_start_2
    new-instance v9, Lcom/amazon/mShop/StandardViewWithUrlContent;

    iget v11, p0, Lcom/amazon/mShop/LinkButton;->mTitleResourceId:I

    invoke-static {v11}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    iget v12, p0, Lcom/amazon/mShop/LinkButton;->mUrlContentId:I

    invoke-direct {v9, v0, v11, v12}, Lcom/amazon/mShop/StandardViewWithUrlContent;-><init>(Landroid/content/Context;Ljava/lang/Integer;I)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    .end local v8    # "standardViewWithUrlContent":Lcom/amazon/mShop/StandardViewWithUrlContent;
    .local v9, "standardViewWithUrlContent":Lcom/amazon/mShop/StandardViewWithUrlContent;
    move-object v8, v9

    .line 207
    .end local v9    # "standardViewWithUrlContent":Lcom/amazon/mShop/StandardViewWithUrlContent;
    .restart local v8    # "standardViewWithUrlContent":Lcom/amazon/mShop/StandardViewWithUrlContent;
    :goto_5
    if-eqz v8, :cond_8

    .line 208
    invoke-virtual {v0, v8}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    goto :goto_4

    .line 204
    :catch_2
    move-exception v3

    .line 205
    .restart local v3    # "e":Ljava/lang/Exception;
    const-string/jumbo v11, "AmazonActivity"

    invoke-virtual {v3}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_5

    .line 218
    .end local v3    # "e":Ljava/lang/Exception;
    .end local v8    # "standardViewWithUrlContent":Lcom/amazon/mShop/StandardViewWithUrlContent;
    .end local v10    # "url":Landroid/net/Uri;
    :cond_a
    iget-object v11, p0, Lcom/amazon/mShop/LinkButton;->mStringUrl:Ljava/lang/String;

    if-eqz v11, :cond_c

    .line 219
    iget-object v11, p0, Lcom/amazon/mShop/LinkButton;->mStringUrl:Ljava/lang/String;

    invoke-static {v11}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v10

    .line 220
    .restart local v10    # "url":Landroid/net/Uri;
    iget-boolean v11, p0, Lcom/amazon/mShop/LinkButton;->mUrlUseExternalBrowser:Z

    if-eqz v11, :cond_b

    .line 221
    new-instance v4, Landroid/content/Intent;

    const-string/jumbo v11, "android.intent.action.VIEW"

    invoke-direct {v4, v11, v10}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 222
    .restart local v4    # "intent":Landroid/content/Intent;
    invoke-virtual {p0}, Lcom/amazon/mShop/LinkButton;->getContext()Landroid/content/Context;

    move-result-object v11

    invoke-virtual {v11, v4}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V

    goto/16 :goto_0

    .line 224
    .end local v4    # "intent":Landroid/content/Intent;
    :cond_b
    const/4 v8, 0x0

    .line 226
    .restart local v8    # "standardViewWithUrlContent":Lcom/amazon/mShop/StandardViewWithUrlContent;
    :try_start_3
    new-instance v9, Lcom/amazon/mShop/StandardViewWithUrlContent;

    invoke-virtual {p0}, Lcom/amazon/mShop/LinkButton;->getText()Ljava/lang/CharSequence;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v11

    iget-object v12, p0, Lcom/amazon/mShop/LinkButton;->mStringUrl:Ljava/lang/String;

    invoke-direct {v9, v0, v11, v12}, Lcom/amazon/mShop/StandardViewWithUrlContent;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_3

    .end local v8    # "standardViewWithUrlContent":Lcom/amazon/mShop/StandardViewWithUrlContent;
    .restart local v9    # "standardViewWithUrlContent":Lcom/amazon/mShop/StandardViewWithUrlContent;
    move-object v8, v9

    .line 230
    .end local v9    # "standardViewWithUrlContent":Lcom/amazon/mShop/StandardViewWithUrlContent;
    .restart local v8    # "standardViewWithUrlContent":Lcom/amazon/mShop/StandardViewWithUrlContent;
    :goto_6
    if-eqz v8, :cond_0

    .line 231
    invoke-virtual {v0, v8}, Lcom/amazon/mShop/AmazonActivity;->pushView(Landroid/view/View;)V

    goto/16 :goto_0

    .line 227
    :catch_3
    move-exception v3

    .line 228
    .restart local v3    # "e":Ljava/lang/Exception;
    const-string/jumbo v11, "AmazonActivity"

    invoke-virtual {v3}, Ljava/lang/Exception;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_6

    .line 234
    .end local v3    # "e":Ljava/lang/Exception;
    .end local v8    # "standardViewWithUrlContent":Lcom/amazon/mShop/StandardViewWithUrlContent;
    .end local v10    # "url":Landroid/net/Uri;
    :cond_c
    iget-object v11, p0, Lcom/amazon/mShop/LinkButton;->mNavigationTarget:Ljava/lang/String;

    invoke-static {v11}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v11

    if-nez v11, :cond_0

    .line 235
    iget-object v11, p0, Lcom/amazon/mShop/LinkButton;->mNavigationTarget:Ljava/lang/String;

    invoke-static {v11}, Lcom/amazon/mShop/navigation/AppNavigator$Target;->from(Ljava/lang/String;)Lcom/amazon/mShop/navigation/AppNavigator$Target;

    move-result-object v11

    invoke-static {v0, v11}, Lcom/amazon/mShop/navigation/AppNavigator;->navigate(Landroid/content/Context;Lcom/amazon/mShop/navigation/AppNavigator$Target;)V

    goto/16 :goto_0
.end method

.method protected onFinishInflate()V
    .locals 1

    .prologue
    .line 126
    invoke-super {p0}, Landroid/widget/Button;->onFinishInflate()V

    .line 127
    iget-object v0, p0, Lcom/amazon/mShop/LinkButton;->mLinkClassName:Ljava/lang/String;

    if-nez v0, :cond_0

    iget v0, p0, Lcom/amazon/mShop/LinkButton;->mLinkLayoutId:I

    if-nez v0, :cond_0

    iget v0, p0, Lcom/amazon/mShop/LinkButton;->mTextContentId:I

    if-nez v0, :cond_0

    iget v0, p0, Lcom/amazon/mShop/LinkButton;->mHtmlContentId:I

    if-nez v0, :cond_0

    iget v0, p0, Lcom/amazon/mShop/LinkButton;->mUrlContentId:I

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/LinkButton;->mNavigationTarget:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 129
    :cond_0
    invoke-virtual {p0, p0}, Lcom/amazon/mShop/LinkButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 131
    :cond_1
    return-void
.end method
