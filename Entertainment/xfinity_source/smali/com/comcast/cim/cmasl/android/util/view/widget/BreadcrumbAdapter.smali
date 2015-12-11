.class public abstract Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;
.super Ljava/lang/Object;
.source "BreadcrumbAdapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<F:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private addCommas:Z

.field private leadText:Ljava/lang/CharSequence;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    .local p0, "this":Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;, "Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter<TF;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private shouldUseLead()Z
    .locals 1

    .prologue
    .line 28
    .local p0, "this":Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;, "Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter<TF;>;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;->leadText:Ljava/lang/CharSequence;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;->leadText:Ljava/lang/CharSequence;

    invoke-interface {v0}, Ljava/lang/CharSequence;->length()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method protected addCommasAndSpacing(Landroid/widget/LinearLayout;)V
    .locals 6
    .param p1, "layout"    # Landroid/widget/LinearLayout;

    .prologue
    .line 36
    .local p0, "this":Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;, "Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter<TF;>;"
    iget-boolean v4, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;->addCommas:Z

    if-eqz v4, :cond_1

    .line 37
    invoke-virtual {p1}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v3

    .line 38
    .local v3, "viewCount":I
    const/4 v1, 0x0

    .line 39
    .local v1, "startIndex":I
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;->shouldUseLead()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 41
    const/4 v1, 0x1

    .line 43
    :cond_0
    move v0, v1

    .local v0, "i":I
    :goto_0
    add-int/lit8 v4, v3, -0x1

    if-ge v0, v4, :cond_1

    .line 44
    invoke-virtual {p1, v0}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;->getItemLabelViewId()I

    move-result v5

    invoke-virtual {v4, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 45
    .local v2, "view":Landroid/widget/TextView;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ", "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 43
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 48
    .end local v0    # "i":I
    .end local v1    # "startIndex":I
    .end local v2    # "view":Landroid/widget/TextView;
    .end local v3    # "viewCount":I
    :cond_1
    return-void
.end method

.method protected addLeadIfApplicable(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)V
    .locals 3
    .param p1, "layoutInflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;

    .prologue
    .line 21
    .local p0, "this":Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;, "Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter<TF;>;"
    invoke-direct {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;->shouldUseLead()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 22
    sget v1, Lcom/comcast/cim/cmasl/android/util/R$layout;->breadcrumb_lead:I

    invoke-virtual {p1, v1, p2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 23
    .local v0, "leadView":Landroid/view/View;
    sget v1, Lcom/comcast/cim/cmasl/android/util/R$id;->label:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iget-object v2, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;->leadText:Ljava/lang/CharSequence;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 25
    .end local v0    # "leadView":Landroid/view/View;
    :cond_0
    return-void
.end method

.method protected abstract addViews(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Ljava/lang/Object;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/LayoutInflater;",
            "Landroid/view/ViewGroup;",
            "TF;)V"
        }
    .end annotation
.end method

.method protected abstract getItemLabelViewId()I
.end method

.method protected abstract getItemLayoutId()I
.end method

.method public setAddCommas(Z)V
    .locals 0
    .param p1, "addCommas"    # Z

    .prologue
    .line 55
    .local p0, "this":Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;, "Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter<TF;>;"
    iput-boolean p1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;->addCommas:Z

    .line 56
    return-void
.end method

.method public setLeadText(Ljava/lang/CharSequence;)V
    .locals 0
    .param p1, "leadText"    # Ljava/lang/CharSequence;

    .prologue
    .line 51
    .local p0, "this":Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;, "Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter<TF;>;"
    iput-object p1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;->leadText:Ljava/lang/CharSequence;

    .line 52
    return-void
.end method
