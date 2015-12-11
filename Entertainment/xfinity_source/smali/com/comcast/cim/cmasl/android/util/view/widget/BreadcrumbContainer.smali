.class public Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;
.super Landroid/widget/LinearLayout;
.source "BreadcrumbContainer.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<F:",
        "Ljava/lang/Object;",
        ">",
        "Landroid/widget/LinearLayout;",
        "Lcom/comcast/cim/cmasl/android/util/view/common/FilterChangeListener",
        "<TF;>;"
    }
.end annotation


# instance fields
.field private adapter:Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter",
            "<TF;>;"
        }
    .end annotation
.end field

.field private addCommas:Z

.field private layoutInflater:Landroid/view/LayoutInflater;

.field private leadText:Ljava/lang/CharSequence;


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 28
    .local p0, "this":Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;, "Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer<TF;>;"
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 29
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 38
    .local p0, "this":Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;, "Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer<TF;>;"
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 39
    sget-object v1, Lcom/comcast/cim/cmasl/android/util/R$styleable;->com_comcast_cim_cmasl_android_util_view_widget_BreadcrumbContainer:[I

    invoke-virtual {p1, p2, v1}, Landroid/content/Context;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 40
    .local v0, "a":Landroid/content/res/TypedArray;
    sget v1, Lcom/comcast/cim/cmasl/android/util/R$styleable;->com_comcast_cim_cmasl_android_util_view_widget_BreadcrumbContainer_addCommas:I

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    iput-boolean v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;->addCommas:Z

    .line 41
    sget v1, Lcom/comcast/cim/cmasl/android/util/R$styleable;->com_comcast_cim_cmasl_android_util_view_widget_BreadcrumbContainer_leadText:I

    invoke-virtual {v0, v1}, Landroid/content/res/TypedArray;->getText(I)Ljava/lang/CharSequence;

    move-result-object v1

    iput-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;->leadText:Ljava/lang/CharSequence;

    .line 42
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 43
    return-void
.end method


# virtual methods
.method public onFilterChange(Ljava/lang/Object;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TF;)V"
        }
    .end annotation

    .prologue
    .line 72
    .local p0, "this":Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;, "Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer<TF;>;"
    .local p1, "filterValue":Ljava/lang/Object;, "TF;"
    invoke-virtual {p0, p1}, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;->update(Ljava/lang/Object;)V

    .line 73
    return-void
.end method

.method public setAdapter(Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter",
            "<TF;>;)V"
        }
    .end annotation

    .prologue
    .line 46
    .local p0, "this":Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;, "Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer<TF;>;"
    .local p1, "adapter":Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;, "Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter<TF;>;"
    iput-object p1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;->adapter:Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;

    .line 47
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;->leadText:Ljava/lang/CharSequence;

    invoke-virtual {p1, v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;->setLeadText(Ljava/lang/CharSequence;)V

    .line 48
    iget-boolean v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;->addCommas:Z

    invoke-virtual {p1, v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;->setAddCommas(Z)V

    .line 49
    return-void
.end method

.method public update(Ljava/lang/Object;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TF;)V"
        }
    .end annotation

    .prologue
    .line 57
    .local p0, "this":Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;, "Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer<TF;>;"
    .local p1, "filterValue":Ljava/lang/Object;, "TF;"
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;->removeAllViews()V

    .line 59
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;->layoutInflater:Landroid/view/LayoutInflater;

    if-nez v0, :cond_0

    .line 60
    invoke-virtual {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;->getContext()Landroid/content/Context;

    move-result-object v0

    const-string v1, "layout_inflater"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    iput-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;->layoutInflater:Landroid/view/LayoutInflater;

    .line 63
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;->adapter:Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;

    iget-object v1, p0, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbContainer;->layoutInflater:Landroid/view/LayoutInflater;

    invoke-virtual {v0, v1, p0, p1}, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;->addViews(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Ljava/lang/Object;)V

    .line 64
    return-void
.end method
