.class Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;
.super Landroid/widget/BaseAdapter;
.source "AutoCompleteAdapter.java"

# interfaces
.implements Landroid/widget/Filterable;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$1;,
        Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$ViewHolder;,
        Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$SuggestionFilter;
    }
.end annotation


# instance fields
.field private mFilter:Landroid/widget/Filter;

.field private final mLayoutInflater:Landroid/view/LayoutInflater;

.field private mSearchSuggestionProvider:Lcom/amazon/retailsearch/data/ISuggestionDataProvider;

.field private final mSuggestionLock:Ljava/lang/Object;

.field private final mSuggestions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/retailsearch/data/SuggestionDataItem;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 39
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 32
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;->mSuggestionLock:Ljava/lang/Object;

    .line 34
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;->mSuggestions:Ljava/util/List;

    .line 40
    const-string/jumbo v0, "layout_inflater"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;->mLayoutInflater:Landroid/view/LayoutInflater;

    .line 42
    new-instance v0, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$SuggestionFilter;

    invoke-direct {v0, p0}, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$SuggestionFilter;-><init>(Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;->mFilter:Landroid/widget/Filter;

    .line 43
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;)Ljava/lang/Object;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;->mSuggestionLock:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;)Lcom/amazon/retailsearch/data/ISuggestionDataProvider;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;->mSearchSuggestionProvider:Lcom/amazon/retailsearch/data/ISuggestionDataProvider;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;->mSuggestions:Ljava/util/List;

    return-object v0
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;->mSuggestions:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getFilter()Landroid/widget/Filter;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;->mFilter:Landroid/widget/Filter;

    return-object v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 60
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;->mSuggestions:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 66
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v4, 0x0

    .line 73
    if-nez p2, :cond_1

    .line 75
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;->mLayoutInflater:Landroid/view/LayoutInflater;

    const v3, 0x109000a

    invoke-virtual {v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 77
    new-instance v1, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$ViewHolder;

    invoke-direct {v1, p0, v4}, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$ViewHolder;-><init>(Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$1;)V

    .line 78
    .local v1, "viewHolder":Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$ViewHolder;
    const v2, 0x1020014

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    iput-object v2, v1, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$ViewHolder;->textView:Landroid/widget/TextView;

    .line 80
    invoke-virtual {p2, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 86
    :goto_0
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;->mSuggestions:Ljava/util/List;

    invoke-interface {v2, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/retailsearch/data/SuggestionDataItem;

    .line 87
    .local v0, "item":Lcom/amazon/retailsearch/data/SuggestionDataItem;
    if-eqz v0, :cond_0

    .line 89
    iget-object v2, v1, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$ViewHolder;->textView:Landroid/widget/TextView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/data/SuggestionDataItem;->getDisplayText()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 92
    :cond_0
    return-object p2

    .line 83
    .end local v0    # "item":Lcom/amazon/retailsearch/data/SuggestionDataItem;
    .end local v1    # "viewHolder":Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$ViewHolder;
    :cond_1
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$ViewHolder;

    .restart local v1    # "viewHolder":Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter$ViewHolder;
    goto :goto_0
.end method

.method public setSearchSuggestionProvider(Lcom/amazon/retailsearch/data/ISuggestionDataProvider;)V
    .locals 2
    .param p1, "searchSuggestionProvider"    # Lcom/amazon/retailsearch/data/ISuggestionDataProvider;

    .prologue
    .line 98
    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;->mSuggestionLock:Ljava/lang/Object;

    monitor-enter v1

    .line 100
    :try_start_0
    iput-object p1, p0, Lcom/amazon/retailsearch/android/ui/input/AutoCompleteAdapter;->mSearchSuggestionProvider:Lcom/amazon/retailsearch/data/ISuggestionDataProvider;

    .line 101
    monitor-exit v1

    .line 102
    return-void

    .line 101
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
