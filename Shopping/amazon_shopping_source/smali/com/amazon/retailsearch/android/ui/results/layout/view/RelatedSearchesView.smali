.class public Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;
.super Landroid/widget/LinearLayout;
.source "RelatedSearchesView.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/listadapter/ModelView;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/LinearLayout;",
        "Lcom/amazon/retailsearch/android/ui/listadapter/ModelView",
        "<",
        "Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;",
        ">;"
    }
.end annotation


# static fields
.field private static newLineSeparator:Ljava/lang/String;


# instance fields
.field private final header:Landroid/widget/TextView;

.field private retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

.field userInteractionListener:Lcom/amazon/retailsearch/interaction/UserInteractionListener;
    .annotation runtime Ljavax/inject/Inject;
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 26
    const-string/jumbo v0, "line.separator"

    invoke-static {v0}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;->newLineSeparator:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 32
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 28
    invoke-static {}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getInstance()Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/api/log/RetailSearchLoggingProvider;->getRetailSearchLogger()Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    .line 33
    invoke-static {p0}, Lcom/amazon/retailsearch/di/RetailSearchDaggerGraphController;->inject(Ljava/lang/Object;)V

    .line 34
    sget v0, Lcom/amazon/retailsearch/R$layout;->rs_related_searches:I

    invoke-static {p1, v0, p0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 35
    sget v0, Lcom/amazon/retailsearch/R$id;->related_searches_text:I

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;->header:Landroid/widget/TextView;

    .line 36
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;)Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;->retailSearchLogger:Lcom/amazon/retailsearch/android/api/log/RetailSearchLogger;

    return-object v0
.end method


# virtual methods
.method public build(Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;)V
    .locals 7
    .param p1, "relatedSearches"    # Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;

    .prologue
    const/4 v6, 0x0

    .line 41
    if-eqz p1, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;->getLabel()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;->getAltQueries()Ljava/util/List;

    move-result-object v4

    if-nez v4, :cond_1

    .line 45
    :cond_0
    const/16 v4, 0x8

    invoke-virtual {p0, v4}, Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;->setVisibility(I)V

    .line 76
    :goto_0
    return-void

    .line 49
    :cond_1
    new-instance v3, Landroid/text/SpannableStringBuilder;

    invoke-direct {v3}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 50
    .local v3, "ssb":Landroid/text/SpannableStringBuilder;
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;->getLabel()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 51
    invoke-interface {p1}, Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;->getAltQueries()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/searchapp/retailsearch/model/Link;

    .line 53
    .local v2, "relatedSearch":Lcom/amazon/searchapp/retailsearch/model/Link;
    if-eqz v2, :cond_2

    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/Link;->getText()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_2

    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/Link;->getUrl()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_2

    .line 59
    sget-object v4, Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;->newLineSeparator:Ljava/lang/String;

    invoke-virtual {v3, v4}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    move-result-object v4

    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/Link;->getText()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 60
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView$1;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-direct {v0, p0, v4, v2}, Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView$1;-><init>(Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;Landroid/content/res/Resources;Lcom/amazon/searchapp/retailsearch/model/Link;)V

    .line 69
    .local v0, "clickSpan":Lcom/amazon/retailsearch/android/ui/results/SearchLinkSpan;
    invoke-virtual {v3}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v4

    invoke-interface {v2}, Lcom/amazon/searchapp/retailsearch/model/Link;->getText()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v5

    sub-int/2addr v4, v5

    invoke-virtual {v3}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v5

    invoke-virtual {v3, v0, v4, v5, v6}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    goto :goto_1

    .line 72
    .end local v0    # "clickSpan":Lcom/amazon/retailsearch/android/ui/results/SearchLinkSpan;
    .end local v2    # "relatedSearch":Lcom/amazon/searchapp/retailsearch/model/Link;
    :cond_3
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;->header:Landroid/widget/TextView;

    invoke-virtual {v4, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 74
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;->header:Landroid/widget/TextView;

    invoke-virtual {v4, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 75
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;->header:Landroid/widget/TextView;

    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    goto :goto_0
.end method

.method public bridge synthetic build(Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;

    .prologue
    .line 24
    check-cast p1, Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/view/RelatedSearchesView;->build(Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;)V

    return-void
.end method
