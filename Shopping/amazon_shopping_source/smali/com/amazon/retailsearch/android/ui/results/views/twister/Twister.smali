.class public Lcom/amazon/retailsearch/android/ui/results/views/twister/Twister;
.super Landroid/widget/TextView;
.source "Twister.java"

# interfaces
.implements Lcom/amazon/retailsearch/android/ui/results/views/InteractiveRetailSearchResultView;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/TextView;",
        "Lcom/amazon/retailsearch/android/ui/results/views/InteractiveRetailSearchResultView",
        "<",
        "Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;",
        ">;"
    }
.end annotation


# static fields
.field private static final ATTR_SHOW_EDITIONS_DETAIL:Ljava/lang/String; = "Rs.Results.Twister.ShowEditionsDetail"

.field private static final DEFAULT_SHOW_EDITIONS_DETAIL:Z = true


# instance fields
.field private model:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;

.field private showEditionsDetail:Z


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 42
    invoke-direct {p0, p1, p2}, Landroid/widget/TextView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 43
    const-string/jumbo v0, "Rs.Results.Twister.ShowEditionsDetail"

    const/4 v1, 0x1

    invoke-static {p2, v0, v1}, Lcom/amazon/retailsearch/android/util/ResUtils;->getAttributeBooleanValue(Landroid/util/AttributeSet;Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/Twister;->showEditionsDetail:Z

    .line 44
    return-void
.end method


# virtual methods
.method public buildView(Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 6
    .param p1, "twisterModel"    # Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;
    .param p2, "viewType"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    const/16 v4, 0x8

    .line 52
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/Twister;->model:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;

    .line 53
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;->getEditionsMetadata()Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;

    move-result-object v3

    if-nez v3, :cond_1

    .line 55
    :cond_0
    invoke-virtual {p0, v4}, Lcom/amazon/retailsearch/android/ui/results/views/twister/Twister;->setVisibility(I)V

    .line 79
    :goto_0
    return-void

    .line 58
    :cond_1
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;->getEditionsMetadata()Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;->getLabel()Ljava/util/List;

    move-result-object v0

    .line 59
    .local v0, "label":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;->getEditionsMetadata()Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/searchapp/retailsearch/model/EditionsMetadata;->getTypesLabel()Ljava/util/List;

    move-result-object v2

    .line 60
    .local v2, "typesLabel":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/searchapp/retailsearch/model/StyledText;>;"
    if-eqz v0, :cond_2

    if-nez v2, :cond_3

    .line 62
    :cond_2
    invoke-virtual {p0, v4}, Lcom/amazon/retailsearch/android/ui/results/views/twister/Twister;->setVisibility(I)V

    goto :goto_0

    .line 65
    :cond_3
    new-instance v1, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/twister/Twister;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-direct {v1, p2, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;-><init>(Lcom/amazon/retailsearch/android/ui/results/ViewType;Landroid/content/Context;)V

    .line 66
    .local v1, "sss":Lcom/amazon/retailsearch/android/ui/StyledSpannableString;
    iget-boolean v3, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/Twister;->showEditionsDetail:Z

    if-eqz v3, :cond_4

    .line 68
    sget v3, Lcom/amazon/retailsearch/R$style;->Results_Twister:I

    invoke-virtual {v1, v0, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/util/List;I)V

    .line 69
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/twister/Twister;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/retailsearch/R$string;->twister_colon:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    sget v4, Lcom/amazon/retailsearch/R$style;->Results_Twister:I

    invoke-virtual {v1, v3, v4}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/lang/String;I)V

    .line 70
    sget v3, Lcom/amazon/retailsearch/R$style;->Results_Twister:I

    invoke-virtual {v1, v2, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/util/List;I)V

    .line 77
    :goto_1
    invoke-virtual {p0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/twister/Twister;->setText(Ljava/lang/CharSequence;)V

    .line 78
    const/4 v3, 0x0

    invoke-virtual {p0, v3}, Lcom/amazon/retailsearch/android/ui/results/views/twister/Twister;->setVisibility(I)V

    goto :goto_0

    .line 74
    :cond_4
    sget v3, Lcom/amazon/retailsearch/R$style;->Results_TwisterLink:I

    invoke-virtual {v1, v0, v3}, Lcom/amazon/retailsearch/android/ui/StyledSpannableString;->append(Ljava/util/List;I)V

    goto :goto_1
.end method

.method public bridge synthetic buildView(Ljava/lang/Object;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/amazon/retailsearch/android/ui/results/ViewType;

    .prologue
    .line 27
    check-cast p1, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/views/twister/Twister;->buildView(Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;Lcom/amazon/retailsearch/android/ui/results/ViewType;)V

    return-void
.end method

.method public getView()Landroid/view/View;
    .locals 0

    .prologue
    .line 98
    return-object p0
.end method

.method public handleSingleTap()V
    .locals 2

    .prologue
    .line 87
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/views/twister/Twister;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;-><init>(Landroid/content/Context;)V

    .line 88
    .local v0, "twisterDialog":Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/views/twister/Twister;->model:Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;->init(Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterModel;)V

    .line 89
    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/views/twister/TwisterDialog;->show()V

    .line 90
    return-void
.end method
