.class public Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLine;
.super Landroid/widget/TextView;
.source "EditionLine.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/results/views/RetailSearchResultView;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/TextView;",
        "Lcom/amazon/retailsearch/android/ui/results/views/RetailSearchResultView",
        "<",
        "Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 30
    invoke-direct {p0, p1, p2}, Landroid/widget/TextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 31
    return-void
.end method


# virtual methods
.method public buildView(Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 1
    .param p1, "model"    # Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel;
    .param p2, "viewType"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 39
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel;->getEditionText()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 41
    :cond_0
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLine;->setVisibility(I)V

    .line 47
    :goto_0
    return-void

    .line 45
    :cond_1
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel;->getEditionText()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLine;->setText(Ljava/lang/CharSequence;)V

    .line 46
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLine;->setVisibility(I)V

    goto :goto_0
.end method

.method public bridge synthetic buildView(Ljava/lang/Object;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 21
    check-cast p1, Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLine;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/messaging/EditionLineModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    return-void
.end method
