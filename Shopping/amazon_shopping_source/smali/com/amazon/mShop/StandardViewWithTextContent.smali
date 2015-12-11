.class public Lcom/amazon/mShop/StandardViewWithTextContent;
.super Lcom/amazon/mShop/StandardView;
.source "StandardViewWithTextContent.java"


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/Integer;IZ)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "titleResourceId"    # Ljava/lang/Integer;
    .param p3, "textContentResourceId"    # I
    .param p4, "textContentIsHtml"    # Z

    .prologue
    .line 34
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/StandardView;-><init>(Landroid/content/Context;Ljava/lang/Integer;)V

    .line 36
    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->standard_view_with_text_content:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/StandardViewWithTextContent;->setContentView(I)V

    .line 38
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->standard_view_with_text_content_text:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/StandardViewWithTextContent;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 40
    .local v1, "textView":Landroid/widget/TextView;
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    invoke-virtual {v2, p3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 41
    .local v0, "textContent":Ljava/lang/String;
    if-eqz p4, :cond_0

    .line 42
    invoke-static {v0}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 43
    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 47
    :goto_0
    return-void

    .line 45
    :cond_0
    invoke-virtual {v1, p3}, Landroid/widget/TextView;->setText(I)V

    goto :goto_0
.end method
