.class public Lcom/amazon/mShop/InfoView;
.super Landroid/widget/ScrollView;
.source "InfoView.java"

# interfaces
.implements Lcom/amazon/mShop/TitleProvider;


# instance fields
.field titleId:I


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 29
    invoke-direct {p0, p1}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;)V

    .line 26
    iput v2, p0, Lcom/amazon/mShop/InfoView;->titleId:I

    .line 31
    const-string/jumbo v1, "amazon_titleResourceId"

    invoke-interface {p2, v3, v1, v2}, Landroid/util/AttributeSet;->getAttributeResourceValue(Ljava/lang/String;Ljava/lang/String;I)I

    move-result v1

    iput v1, p0, Lcom/amazon/mShop/InfoView;->titleId:I

    .line 32
    const-string/jumbo v1, "amazon_htmlContentId"

    invoke-interface {p2, v3, v1, v2}, Landroid/util/AttributeSet;->getAttributeResourceValue(Ljava/lang/String;Ljava/lang/String;I)I

    move-result v0

    .line 34
    .local v0, "htmlContentId":I
    invoke-direct {p0, p1, v0}, Lcom/amazon/mShop/InfoView;->setText(Landroid/content/Context;I)V

    .line 35
    return-void
.end method

.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;II)V
    .locals 1
    .param p1, "amazonActivity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "titleId"    # I
    .param p3, "textId"    # I

    .prologue
    .line 46
    invoke-direct {p0, p1}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;)V

    .line 26
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/mShop/InfoView;->titleId:I

    .line 47
    iput p2, p0, Lcom/amazon/mShop/InfoView;->titleId:I

    .line 49
    invoke-direct {p0, p1, p3}, Lcom/amazon/mShop/InfoView;->setText(Landroid/content/Context;I)V

    .line 50
    return-void
.end method

.method private setText(Landroid/content/Context;I)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "textId"    # I

    .prologue
    .line 53
    invoke-virtual {p0}, Lcom/amazon/mShop/InfoView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$layout;->info:I

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    .line 54
    .local v0, "content":Landroid/view/ViewGroup;
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->info_text_view_id:I

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 55
    .local v1, "text":Landroid/widget/TextView;
    invoke-virtual {p1, p2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 57
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/InfoView;->addView(Landroid/view/View;)V

    .line 58
    return-void
.end method


# virtual methods
.method public bridge synthetic getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 19
    invoke-virtual {p0}, Lcom/amazon/mShop/InfoView;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 2

    .prologue
    .line 65
    invoke-virtual {p0}, Lcom/amazon/mShop/InfoView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    iget v1, p0, Lcom/amazon/mShop/InfoView;->titleId:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
