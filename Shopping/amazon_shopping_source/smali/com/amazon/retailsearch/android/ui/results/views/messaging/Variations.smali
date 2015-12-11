.class public Lcom/amazon/retailsearch/android/ui/results/views/messaging/Variations;
.super Landroid/widget/TextView;
.source "Variations.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/results/views/RetailSearchResultView;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/TextView;",
        "Lcom/amazon/retailsearch/android/ui/results/views/RetailSearchResultView",
        "<",
        "Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel;",
        ">;"
    }
.end annotation


# instance fields
.field context:Landroid/content/Context;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 31
    invoke-direct {p0, p1, p2}, Landroid/widget/TextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 32
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/messaging/Variations;->context:Landroid/content/Context;

    .line 33
    return-void
.end method


# virtual methods
.method public buildView(Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 1
    .param p1, "model"    # Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel;
    .param p2, "viewType"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 41
    if-nez p1, :cond_0

    .line 43
    const/16 v0, 0x8

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/Variations;->setVisibility(I)V

    .line 49
    :goto_0
    return-void

    .line 47
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel;->getVariationsMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/Variations;->setText(Ljava/lang/CharSequence;)V

    .line 48
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/Variations;->setVisibility(I)V

    goto :goto_0
.end method

.method public bridge synthetic buildView(Ljava/lang/Object;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 20
    check-cast p1, Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/views/messaging/Variations;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/messaging/VariationsModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    return-void
.end method
