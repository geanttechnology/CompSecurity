.class public Lcom/amazon/retailsearch/android/ui/listadapter/GeneratorAdapter;
.super Landroid/widget/BaseAdapter;
.source "GeneratorAdapter.java"


# instance fields
.field private final generator:Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;

.field private final typeCount:I


# direct methods
.method public constructor <init>(Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;)V
    .locals 1
    .param p1, "generator"    # Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;

    .prologue
    .line 23
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Lcom/amazon/retailsearch/android/ui/listadapter/GeneratorAdapter;-><init>(Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;I)V

    .line 24
    return-void
.end method

.method public constructor <init>(Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;I)V
    .locals 0
    .param p1, "generator"    # Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;
    .param p2, "typeCount"    # I

    .prologue
    .line 32
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 33
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/listadapter/GeneratorAdapter;->generator:Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;

    .line 34
    iput p2, p0, Lcom/amazon/retailsearch/android/ui/listadapter/GeneratorAdapter;->typeCount:I

    .line 35
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/listadapter/GeneratorAdapter;->generator:Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;->getCount()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 66
    const/4 v0, 0x0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 74
    int-to-long v0, p1

    return-wide v0
.end method

.method public getItemViewType(I)I
    .locals 1
    .param p1, "index"    # I

    .prologue
    .line 50
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/listadapter/GeneratorAdapter;->generator:Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;

    invoke-interface {v0, p1}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;->getType(I)I

    move-result v0

    return v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 1
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 82
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/listadapter/GeneratorAdapter;->generator:Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;

    invoke-interface {v0, p1, p2, p3}, Lcom/amazon/retailsearch/android/ui/listadapter/ViewGenerator;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public getViewTypeCount()I
    .locals 1

    .prologue
    .line 58
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/listadapter/GeneratorAdapter;->typeCount:I

    return v0
.end method
