.class public Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSave;
.super Landroid/widget/TextView;
.source "SubscribeAndSave.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/results/views/RetailSearchResultView;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/TextView;",
        "Lcom/amazon/retailsearch/android/ui/results/views/RetailSearchResultView",
        "<",
        "Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;",
        ">;"
    }
.end annotation


# static fields
.field private static final ATTR_SHOW_SAVE_MORE_TEXT:Ljava/lang/String; = "Rs.Results.SubscribeAndSave.ShowSaveMoreText"

.field private static final NEW_LINE:Ljava/lang/String;


# instance fields
.field private showSaveMoreText:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 26
    const-string/jumbo v0, "line.separator"

    invoke-static {v0}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSave;->NEW_LINE:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 46
    invoke-direct {p0, p1, p2}, Landroid/widget/TextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 47
    const-string/jumbo v0, "Rs.Results.SubscribeAndSave.ShowSaveMoreText"

    const/4 v1, 0x0

    invoke-static {p2, v0, v1}, Lcom/amazon/retailsearch/android/util/ResUtils;->getAttributeBooleanValue(Landroid/util/AttributeSet;Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSave;->showSaveMoreText:Z

    .line 48
    return-void
.end method


# virtual methods
.method public buildView(Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 3
    .param p1, "model"    # Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;
    .param p2, "viewType"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 57
    if-nez p1, :cond_0

    .line 59
    const/16 v1, 0x8

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSave;->setVisibility(I)V

    .line 79
    :goto_0
    return-void

    .line 64
    :cond_0
    new-instance v0, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSave;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, p2, v1}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;-><init>(Lcom/amazon/retailsearch/android/ui/results/ViewType;Landroid/content/Context;)V

    .line 65
    .local v0, "sss":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;->getPrice()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    sget v2, Lcom/amazon/retailsearch/R$style;->Results_PriceSpan:I

    invoke-virtual {v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/String;I)V

    .line 67
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;->getPriceLabel()Ljava/lang/String;

    move-result-object v1

    sget v2, Lcom/amazon/retailsearch/R$style;->Results_SubscribeAndSavePriceLabel:I

    invoke-virtual {v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/String;I)V

    .line 69
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;->getSaveMoreText()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 72
    sget-object v1, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSave;->NEW_LINE:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/CharSequence;)Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    .line 73
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;->getSaveMoreText()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/CharSequence;)Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    .line 77
    :cond_1
    sget-object v1, Landroid/widget/TextView$BufferType;->SPANNABLE:Landroid/widget/TextView$BufferType;

    invoke-virtual {p0, v0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSave;->setText(Ljava/lang/CharSequence;Landroid/widget/TextView$BufferType;)V

    .line 78
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSave;->setVisibility(I)V

    goto :goto_0
.end method

.method public bridge synthetic buildView(Ljava/lang/Object;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 24
    check-cast p1, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSave;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSaveModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    return-void
.end method

.method public getShowSaveMoreText()Z
    .locals 1

    .prologue
    .line 36
    iget-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/price/SubscribeAndSave;->showSaveMoreText:Z

    return v0
.end method
