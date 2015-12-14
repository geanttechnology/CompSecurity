.class public Lcom/livemixtapes/SearchFragment;
.super Landroid/app/Fragment;
.source "SearchFragment.java"

# interfaces
.implements Lcom/livemixtapes/ui/widgets/SearchView$QueryTextListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/livemixtapes/SearchFragment$TopArtistsComparator;
    }
.end annotation


# static fields
.field private static textBasedSearchUrl:Ljava/lang/String;

.field private static topArtistsSearchUrl:Ljava/lang/String;


# instance fields
.field private DebounceHandler:Landroid/os/Handler;

.field private DebounceListener:Ljava/lang/Runnable;

.field activity:Lcom/livemixtapes/SearchActivity;

.field adapter:Lcom/livemixtapes/LazyAdapterSearch;

.field curPage:I

.field layoutHeader:Landroid/widget/RelativeLayout;

.field list:Landroid/widget/ListView;

.field listEmpty:Landroid/view/View;

.field listHeader:Landroid/view/View;

.field listProgress:Landroid/view/View;

.field private listScrollListener:Landroid/widget/AbsListView$OnScrollListener;

.field rootView:Landroid/view/View;

.field private searchResultClicked:Landroid/widget/AdapterView$OnItemClickListener;

.field searchView:Lcom/livemixtapes/ui/widgets/SearchView;

.field topArtistsResultsList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 54
    const-string v0, "https://api.livemixtapes.com/api/search?query="

    sput-object v0, Lcom/livemixtapes/SearchFragment;->textBasedSearchUrl:Ljava/lang/String;

    .line 55
    const-string v0, "https://api.livemixtapes.com/api/top_artists"

    sput-object v0, Lcom/livemixtapes/SearchFragment;->topArtistsSearchUrl:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 42
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 51
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/livemixtapes/SearchFragment;->topArtistsResultsList:Ljava/util/ArrayList;

    .line 186
    new-instance v0, Lcom/livemixtapes/SearchFragment$1;

    invoke-direct {v0, p0}, Lcom/livemixtapes/SearchFragment$1;-><init>(Lcom/livemixtapes/SearchFragment;)V

    iput-object v0, p0, Lcom/livemixtapes/SearchFragment;->searchResultClicked:Landroid/widget/AdapterView$OnItemClickListener;

    .line 201
    new-instance v0, Lcom/livemixtapes/SearchFragment$2;

    invoke-direct {v0, p0}, Lcom/livemixtapes/SearchFragment$2;-><init>(Lcom/livemixtapes/SearchFragment;)V

    iput-object v0, p0, Lcom/livemixtapes/SearchFragment;->listScrollListener:Landroid/widget/AbsListView$OnScrollListener;

    .line 323
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/livemixtapes/SearchFragment;->DebounceHandler:Landroid/os/Handler;

    .line 324
    new-instance v0, Lcom/livemixtapes/SearchFragment$3;

    invoke-direct {v0, p0}, Lcom/livemixtapes/SearchFragment$3;-><init>(Lcom/livemixtapes/SearchFragment;)V

    iput-object v0, p0, Lcom/livemixtapes/SearchFragment;->DebounceListener:Ljava/lang/Runnable;

    .line 42
    return-void
.end method

.method static synthetic access$0(Lcom/livemixtapes/SearchFragment;Landroid/content/Context;Ljava/util/HashMap;)V
    .locals 0

    .prologue
    .line 171
    invoke-direct {p0, p1, p2}, Lcom/livemixtapes/SearchFragment;->showMixtapeFragment(Landroid/content/Context;Ljava/util/HashMap;)V

    return-void
.end method

.method static synthetic access$1(Lcom/livemixtapes/SearchFragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 271
    invoke-direct {p0, p1}, Lcom/livemixtapes/SearchFragment;->loadSearchResults(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$2(Lcom/livemixtapes/SearchFragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 250
    invoke-direct {p0, p1}, Lcom/livemixtapes/SearchFragment;->loadTopArtistsFromJson(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$3(Lcom/livemixtapes/SearchFragment;Z)V
    .locals 0

    .prologue
    .line 223
    invoke-direct {p0, p1}, Lcom/livemixtapes/SearchFragment;->updateUI(Z)V

    return-void
.end method

.method static synthetic access$4(Lcom/livemixtapes/SearchFragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 293
    invoke-direct {p0, p1}, Lcom/livemixtapes/SearchFragment;->loadSearchResultsFromJson(Ljava/lang/String;)V

    return-void
.end method

.method private loadSearchResults(Ljava/lang/String;)V
    .locals 4
    .param p1, "query"    # Ljava/lang/String;

    .prologue
    .line 272
    const/4 v1, 0x1

    invoke-direct {p0, v1}, Lcom/livemixtapes/SearchFragment;->updateUI(Z)V

    .line 273
    new-instance v1, Ljava/lang/StringBuilder;

    sget-object v2, Lcom/livemixtapes/SearchFragment;->textBasedSearchUrl:Ljava/lang/String;

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-static {p1}, Ljava/net/URLEncoder;->encode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "&page="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget v2, p0, Lcom/livemixtapes/SearchFragment;->curPage:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 275
    .local v0, "url":Ljava/lang/String;
    new-instance v1, Lcom/livemixtapes/AsyncHttp;

    invoke-direct {v1}, Lcom/livemixtapes/AsyncHttp;-><init>()V

    const/4 v2, 0x0

    new-instance v3, Lcom/livemixtapes/SearchFragment$7;

    invoke-direct {v3, p0}, Lcom/livemixtapes/SearchFragment$7;-><init>(Lcom/livemixtapes/SearchFragment;)V

    invoke-virtual {v1, v0, v2, v3}, Lcom/livemixtapes/AsyncHttp;->get(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;)V

    .line 291
    return-void
.end method

.method private loadSearchResultsFromJson(Ljava/lang/String;)V
    .locals 7
    .param p1, "json"    # Ljava/lang/String;

    .prologue
    .line 295
    :try_start_0
    new-instance v2, Lorg/json/JSONObject;

    invoke-direct {v2, p1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V

    .line 297
    .local v2, "jsonObj":Lorg/json/JSONObject;
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 298
    .local v3, "results":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    invoke-static {v2}, Lcom/livemixtapes/JsonToMap;->convert(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v5

    const-string v6, "artist_results"

    invoke-virtual {v5, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    .line 299
    .local v0, "artistResults":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    invoke-static {v2}, Lcom/livemixtapes/JsonToMap;->convert(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v5

    const-string v6, "track_results"

    invoke-virtual {v5, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/ArrayList;

    .line 301
    .local v4, "trackResultsList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-lez v5, :cond_0

    .line 302
    const/4 v5, 0x0

    invoke-virtual {v0, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/HashMap;

    const-string v6, "mixtapes"

    invoke-virtual {v5, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/ArrayList;

    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 305
    :cond_0
    invoke-static {v2}, Lcom/livemixtapes/JsonToMap;->convert(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v5

    const-string v6, "mixtape_results"

    invoke-virtual {v5, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/util/ArrayList;

    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 307
    iget v5, p0, Lcom/livemixtapes/SearchFragment;->curPage:I

    if-nez v5, :cond_1

    .line 308
    iget-object v5, p0, Lcom/livemixtapes/SearchFragment;->adapter:Lcom/livemixtapes/LazyAdapterSearch;

    invoke-virtual {v5}, Lcom/livemixtapes/LazyAdapterSearch;->clear()V

    .line 311
    :cond_1
    iget-object v5, p0, Lcom/livemixtapes/SearchFragment;->adapter:Lcom/livemixtapes/LazyAdapterSearch;

    invoke-virtual {v5, v3, v4}, Lcom/livemixtapes/LazyAdapterSearch;->appendSearchResults(Ljava/util/ArrayList;Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 315
    .end local v0    # "artistResults":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    .end local v2    # "jsonObj":Lorg/json/JSONObject;
    .end local v3    # "results":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    .end local v4    # "trackResultsList":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;>;"
    :goto_0
    return-void

    .line 312
    :catch_0
    move-exception v1

    .line 313
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method private loadTopArtists()V
    .locals 4

    .prologue
    .line 230
    const/4 v0, 0x1

    invoke-direct {p0, v0}, Lcom/livemixtapes/SearchFragment;->updateUI(Z)V

    .line 232
    new-instance v0, Lcom/livemixtapes/AsyncHttp;

    invoke-direct {v0}, Lcom/livemixtapes/AsyncHttp;-><init>()V

    sget-object v1, Lcom/livemixtapes/SearchFragment;->topArtistsSearchUrl:Ljava/lang/String;

    const/4 v2, 0x0

    new-instance v3, Lcom/livemixtapes/SearchFragment$6;

    invoke-direct {v3, p0}, Lcom/livemixtapes/SearchFragment$6;-><init>(Lcom/livemixtapes/SearchFragment;)V

    invoke-virtual {v0, v1, v2, v3}, Lcom/livemixtapes/AsyncHttp;->get(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;)V

    .line 248
    return-void
.end method

.method private loadTopArtistsFromJson(Ljava/lang/String;)V
    .locals 5
    .param p1, "json"    # Ljava/lang/String;

    .prologue
    .line 252
    :try_start_0
    new-instance v0, Lorg/json/JSONArray;

    invoke-direct {v0, p1}, Lorg/json/JSONArray;-><init>(Ljava/lang/String;)V

    .line 253
    .local v0, "array":Lorg/json/JSONArray;
    invoke-static {v0}, Lcom/livemixtapes/JsonToMap;->toList(Lorg/json/JSONArray;)Ljava/util/List;

    move-result-object v2

    check-cast v2, Ljava/util/ArrayList;

    iput-object v2, p0, Lcom/livemixtapes/SearchFragment;->topArtistsResultsList:Ljava/util/ArrayList;

    .line 254
    iget-object v2, p0, Lcom/livemixtapes/SearchFragment;->topArtistsResultsList:Ljava/util/ArrayList;

    new-instance v3, Lcom/livemixtapes/SearchFragment$TopArtistsComparator;

    const/4 v4, 0x0

    invoke-direct {v3, p0, v4}, Lcom/livemixtapes/SearchFragment$TopArtistsComparator;-><init>(Lcom/livemixtapes/SearchFragment;Lcom/livemixtapes/SearchFragment$TopArtistsComparator;)V

    invoke-static {v2, v3}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 255
    iget-object v2, p0, Lcom/livemixtapes/SearchFragment;->adapter:Lcom/livemixtapes/LazyAdapterSearch;

    iget-object v3, p0, Lcom/livemixtapes/SearchFragment;->topArtistsResultsList:Ljava/util/ArrayList;

    invoke-virtual {v2, v3}, Lcom/livemixtapes/LazyAdapterSearch;->setTopArtists(Ljava/util/ArrayList;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 260
    .end local v0    # "array":Lorg/json/JSONArray;
    :goto_0
    const/4 v2, 0x0

    invoke-direct {p0, v2}, Lcom/livemixtapes/SearchFragment;->updateUI(Z)V

    .line 261
    return-void

    .line 256
    :catch_0
    move-exception v1

    .line 257
    .local v1, "e":Ljava/lang/Exception;
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0
.end method

.method private showMixtapeFragment(Landroid/content/Context;Ljava/util/HashMap;)V
    .locals 5
    .param p1, "ctx"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 172
    .local p2, "obj":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v3, p0, Lcom/livemixtapes/SearchFragment;->activity:Lcom/livemixtapes/SearchActivity;

    invoke-static {v3}, Lcom/livemixtapes/utils/Utility;->hideKeyboard(Landroid/app/Activity;)V

    .line 174
    iget-object v3, p0, Lcom/livemixtapes/SearchFragment;->searchView:Lcom/livemixtapes/ui/widgets/SearchView;

    invoke-virtual {v3}, Lcom/livemixtapes/ui/widgets/SearchView;->clearFocus()V

    .line 176
    iget-object v3, p0, Lcom/livemixtapes/SearchFragment;->activity:Lcom/livemixtapes/SearchActivity;

    invoke-virtual {v3}, Lcom/livemixtapes/SearchActivity;->getAnimatedFragmentTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    .line 177
    .local v1, "fragmentTransaction":Landroid/app/FragmentTransaction;
    new-instance v2, Lcom/livemixtapes/Mixtape;

    invoke-direct {v2}, Lcom/livemixtapes/Mixtape;-><init>()V

    .line 178
    .local v2, "mixtapeFragment":Lcom/livemixtapes/Mixtape;
    const v3, 0x7f0800cc

    const-string v4, "MIXTAPE"

    invoke-virtual {v1, v3, v2, v4}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 179
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 180
    .local v0, "extras":Landroid/os/Bundle;
    const-string v3, "mixtapeData"

    invoke-virtual {v0, v3, p2}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 181
    const-string v3, "backScreenTitle"

    const-string v4, "Search"

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 182
    invoke-virtual {v2, v0}, Lcom/livemixtapes/Mixtape;->setArguments(Landroid/os/Bundle;)V

    .line 183
    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commit()I

    .line 184
    return-void
.end method

.method private updateUI(Z)V
    .locals 4
    .param p1, "loading"    # Z

    .prologue
    const/16 v2, 0x8

    const/4 v1, 0x0

    .line 224
    iget-object v3, p0, Lcom/livemixtapes/SearchFragment;->listProgress:Landroid/view/View;

    iget-object v0, p0, Lcom/livemixtapes/SearchFragment;->adapter:Lcom/livemixtapes/LazyAdapterSearch;

    invoke-virtual {v0}, Lcom/livemixtapes/LazyAdapterSearch;->getCount()I

    move-result v0

    if-nez v0, :cond_0

    if-eqz p1, :cond_0

    move v0, v1

    :goto_0
    invoke-virtual {v3, v0}, Landroid/view/View;->setVisibility(I)V

    .line 225
    iget-object v3, p0, Lcom/livemixtapes/SearchFragment;->listEmpty:Landroid/view/View;

    iget-object v0, p0, Lcom/livemixtapes/SearchFragment;->adapter:Lcom/livemixtapes/LazyAdapterSearch;

    invoke-virtual {v0}, Lcom/livemixtapes/LazyAdapterSearch;->getCount()I

    move-result v0

    if-nez v0, :cond_1

    if-nez p1, :cond_1

    move v0, v1

    :goto_1
    invoke-virtual {v3, v0}, Landroid/view/View;->setVisibility(I)V

    .line 226
    iget-object v0, p0, Lcom/livemixtapes/SearchFragment;->listHeader:Landroid/view/View;

    iget-object v3, p0, Lcom/livemixtapes/SearchFragment;->adapter:Lcom/livemixtapes/LazyAdapterSearch;

    invoke-virtual {v3}, Lcom/livemixtapes/LazyAdapterSearch;->isTopArtistSearch()Z

    move-result v3

    if-eqz v3, :cond_2

    if-nez p1, :cond_2

    iget-object v3, p0, Lcom/livemixtapes/SearchFragment;->adapter:Lcom/livemixtapes/LazyAdapterSearch;

    invoke-virtual {v3}, Lcom/livemixtapes/LazyAdapterSearch;->getCount()I

    move-result v3

    if-lez v3, :cond_2

    :goto_2
    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 227
    return-void

    :cond_0
    move v0, v2

    .line 224
    goto :goto_0

    :cond_1
    move v0, v2

    .line 225
    goto :goto_1

    :cond_2
    move v1, v2

    .line 226
    goto :goto_2
.end method


# virtual methods
.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 11
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v8, 0x0

    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 65
    invoke-virtual {p0}, Lcom/livemixtapes/SearchFragment;->getActivity()Landroid/app/Activity;

    move-result-object v6

    check-cast v6, Lcom/livemixtapes/SearchActivity;

    iput-object v6, p0, Lcom/livemixtapes/SearchFragment;->activity:Lcom/livemixtapes/SearchActivity;

    .line 67
    iget-object v6, p0, Lcom/livemixtapes/SearchFragment;->rootView:Landroid/view/View;

    if-nez v6, :cond_1

    .line 68
    const v6, 0x7f030036

    invoke-virtual {p1, v6, p2, v9}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v6

    iput-object v6, p0, Lcom/livemixtapes/SearchFragment;->rootView:Landroid/view/View;

    .line 70
    iget-object v6, p0, Lcom/livemixtapes/SearchFragment;->rootView:Landroid/view/View;

    const v7, 0x7f0800ff

    invoke-virtual {v6, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Lcom/livemixtapes/ui/widgets/SearchView;

    iput-object v6, p0, Lcom/livemixtapes/SearchFragment;->searchView:Lcom/livemixtapes/ui/widgets/SearchView;

    .line 71
    iget-object v6, p0, Lcom/livemixtapes/SearchFragment;->searchView:Lcom/livemixtapes/ui/widgets/SearchView;

    invoke-virtual {v6, p0}, Lcom/livemixtapes/ui/widgets/SearchView;->setOnQueryTextListener(Lcom/livemixtapes/ui/widgets/SearchView$QueryTextListener;)V

    .line 72
    iget-object v6, p0, Lcom/livemixtapes/SearchFragment;->searchView:Lcom/livemixtapes/ui/widgets/SearchView;

    invoke-virtual {v6}, Lcom/livemixtapes/ui/widgets/SearchView;->clearFocus()V

    .line 74
    iget-object v6, p0, Lcom/livemixtapes/SearchFragment;->rootView:Landroid/view/View;

    new-instance v7, Lcom/livemixtapes/SearchFragment$4;

    invoke-direct {v7, p0}, Lcom/livemixtapes/SearchFragment$4;-><init>(Lcom/livemixtapes/SearchFragment;)V

    invoke-virtual {v6, v7}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 87
    iget-object v6, p0, Lcom/livemixtapes/SearchFragment;->searchView:Lcom/livemixtapes/ui/widgets/SearchView;

    new-instance v7, Lcom/livemixtapes/SearchFragment$5;

    invoke-direct {v7, p0}, Lcom/livemixtapes/SearchFragment$5;-><init>(Lcom/livemixtapes/SearchFragment;)V

    invoke-virtual {v6, v7}, Lcom/livemixtapes/ui/widgets/SearchView;->setOnExpandListener(Lcom/livemixtapes/ui/widgets/SearchView$ExpandListener;)V

    .line 115
    iget-object v6, p0, Lcom/livemixtapes/SearchFragment;->rootView:Landroid/view/View;

    const v7, 0x7f0800fe

    invoke-virtual {v6, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/RelativeLayout;

    iput-object v6, p0, Lcom/livemixtapes/SearchFragment;->layoutHeader:Landroid/widget/RelativeLayout;

    .line 117
    const v6, 0x7f030037

    invoke-virtual {p1, v6, v8, v9}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v6

    iput-object v6, p0, Lcom/livemixtapes/SearchFragment;->listHeader:Landroid/view/View;

    .line 119
    iget-object v6, p0, Lcom/livemixtapes/SearchFragment;->rootView:Landroid/view/View;

    const v7, 0x102000d

    invoke-virtual {v6, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    iput-object v6, p0, Lcom/livemixtapes/SearchFragment;->listProgress:Landroid/view/View;

    .line 120
    iget-object v6, p0, Lcom/livemixtapes/SearchFragment;->rootView:Landroid/view/View;

    const v7, 0x1020004

    invoke-virtual {v6, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    iput-object v6, p0, Lcom/livemixtapes/SearchFragment;->listEmpty:Landroid/view/View;

    .line 121
    iget-object v6, p0, Lcom/livemixtapes/SearchFragment;->rootView:Landroid/view/View;

    const v7, 0x7f080100

    invoke-virtual {v6, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/ListView;

    iput-object v6, p0, Lcom/livemixtapes/SearchFragment;->list:Landroid/widget/ListView;

    .line 122
    iget-object v6, p0, Lcom/livemixtapes/SearchFragment;->list:Landroid/widget/ListView;

    iget-object v7, p0, Lcom/livemixtapes/SearchFragment;->listHeader:Landroid/view/View;

    invoke-virtual {v6, v7}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 123
    iget-object v6, p0, Lcom/livemixtapes/SearchFragment;->listHeader:Landroid/view/View;

    const v7, 0x7f080101

    invoke-virtual {v6, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    iput-object v6, p0, Lcom/livemixtapes/SearchFragment;->listHeader:Landroid/view/View;

    .line 125
    new-instance v6, Lcom/livemixtapes/LazyAdapterSearch;

    invoke-direct {v6, p0}, Lcom/livemixtapes/LazyAdapterSearch;-><init>(Lcom/livemixtapes/SearchFragment;)V

    iput-object v6, p0, Lcom/livemixtapes/SearchFragment;->adapter:Lcom/livemixtapes/LazyAdapterSearch;

    .line 126
    iget-object v6, p0, Lcom/livemixtapes/SearchFragment;->list:Landroid/widget/ListView;

    iget-object v7, p0, Lcom/livemixtapes/SearchFragment;->adapter:Lcom/livemixtapes/LazyAdapterSearch;

    invoke-virtual {v6, v7}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 127
    invoke-direct {p0}, Lcom/livemixtapes/SearchFragment;->loadTopArtists()V

    .line 135
    const/4 v2, 0x0

    .line 136
    .local v2, "json":Lorg/json/JSONObject;
    const/4 v4, 0x0

    .line 138
    .local v4, "json_tape":Lorg/json/JSONObject;
    :try_start_0
    new-instance v3, Lorg/json/JSONObject;

    sget-object v6, Lcom/livemixtapes/App;->DefaultTape:Ljava/lang/String;

    invoke-direct {v3, v6}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 139
    .end local v2    # "json":Lorg/json/JSONObject;
    .local v3, "json":Lorg/json/JSONObject;
    :try_start_1
    const-string v6, "mixtape"

    invoke-virtual {v3, v6}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v4

    move-object v2, v3

    .line 145
    .end local v3    # "json":Lorg/json/JSONObject;
    .restart local v2    # "json":Lorg/json/JSONObject;
    :goto_0
    invoke-static {v4}, Lcom/livemixtapes/JsonToMap;->convert(Lorg/json/JSONObject;)Ljava/util/HashMap;

    move-result-object v5

    .line 147
    .local v5, "mixtape":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    sget-object v6, Lcom/livemixtapes/App;->didLoad:Ljava/lang/Boolean;

    invoke-virtual {v6}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v6

    if-nez v6, :cond_0

    .line 149
    invoke-static {v10}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    sput-object v6, Lcom/livemixtapes/App;->didLoad:Ljava/lang/Boolean;

    .line 150
    sput-boolean v10, Lcom/livemixtapes/MainActivity;->firstLoad:Z

    .line 151
    sput-object v5, Lcom/livemixtapes/NowPlayingActivity;->mixtape:Ljava/util/Map;

    .line 152
    const-string v6, "tracks"

    invoke-virtual {v5, v6}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/ArrayList;

    sput-object v6, Lcom/livemixtapes/NowPlayingActivity;->tracksList:Ljava/util/ArrayList;

    .line 153
    sput-object v8, Lcom/livemixtapes/NowPlayingActivity;->playList:Ljava/util/Map;

    .line 154
    sput v9, Lcom/livemixtapes/NowPlayingActivity;->position:I

    .line 155
    sput v10, Lcom/livemixtapes/NowPlayingActivity;->flag:I

    .line 157
    new-instance v6, Landroid/content/Intent;

    iget-object v7, p0, Lcom/livemixtapes/SearchFragment;->activity:Lcom/livemixtapes/SearchActivity;

    const-class v8, Lcom/livemixtapes/NowPlayingActivity;

    invoke-direct {v6, v7, v8}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    invoke-virtual {p0, v6}, Lcom/livemixtapes/SearchFragment;->startActivity(Landroid/content/Intent;)V

    .line 161
    :cond_0
    iget-object v6, p0, Lcom/livemixtapes/SearchFragment;->list:Landroid/widget/ListView;

    iget-object v7, p0, Lcom/livemixtapes/SearchFragment;->searchResultClicked:Landroid/widget/AdapterView$OnItemClickListener;

    invoke-virtual {v6, v7}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 164
    .end local v2    # "json":Lorg/json/JSONObject;
    .end local v4    # "json_tape":Lorg/json/JSONObject;
    .end local v5    # "mixtape":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    :cond_1
    iget-object v6, p0, Lcom/livemixtapes/SearchFragment;->activity:Lcom/livemixtapes/SearchActivity;

    const-string v7, "input_method"

    invoke-virtual {v6, v7}, Lcom/livemixtapes/SearchActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/inputmethod/InputMethodManager;

    .line 165
    .local v1, "imm":Landroid/view/inputmethod/InputMethodManager;
    iget-object v6, p0, Lcom/livemixtapes/SearchFragment;->searchView:Lcom/livemixtapes/ui/widgets/SearchView;

    invoke-virtual {v1, v6, v10}, Landroid/view/inputmethod/InputMethodManager;->showSoftInput(Landroid/view/View;I)Z

    .line 166
    iget-object v6, p0, Lcom/livemixtapes/SearchFragment;->searchView:Lcom/livemixtapes/ui/widgets/SearchView;

    invoke-virtual {v6, v9}, Lcom/livemixtapes/ui/widgets/SearchView;->setFocusable(Z)V

    .line 168
    iget-object v6, p0, Lcom/livemixtapes/SearchFragment;->rootView:Landroid/view/View;

    return-object v6

    .line 141
    .end local v1    # "imm":Landroid/view/inputmethod/InputMethodManager;
    .restart local v2    # "json":Lorg/json/JSONObject;
    .restart local v4    # "json_tape":Lorg/json/JSONObject;
    :catch_0
    move-exception v0

    .line 142
    .local v0, "e":Ljava/lang/Exception;
    :goto_1
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 141
    .end local v0    # "e":Ljava/lang/Exception;
    .end local v2    # "json":Lorg/json/JSONObject;
    .restart local v3    # "json":Lorg/json/JSONObject;
    :catch_1
    move-exception v0

    move-object v2, v3

    .end local v3    # "json":Lorg/json/JSONObject;
    .restart local v2    # "json":Lorg/json/JSONObject;
    goto :goto_1
.end method

.method public onQueryTextChange(Ljava/lang/String;)Z
    .locals 4
    .param p1, "arg0"    # Ljava/lang/String;

    .prologue
    .line 318
    iget-object v0, p0, Lcom/livemixtapes/SearchFragment;->DebounceHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/livemixtapes/SearchFragment;->DebounceListener:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 319
    iget-object v0, p0, Lcom/livemixtapes/SearchFragment;->DebounceHandler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/livemixtapes/SearchFragment;->DebounceListener:Ljava/lang/Runnable;

    const-wide/16 v2, 0x12c

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 320
    const/4 v0, 0x1

    return v0
.end method

.method public onQueryTextSubmit(Ljava/lang/String;)Z
    .locals 1
    .param p1, "arg0"    # Ljava/lang/String;

    .prologue
    .line 345
    iget-object v0, p0, Lcom/livemixtapes/SearchFragment;->searchView:Lcom/livemixtapes/ui/widgets/SearchView;

    invoke-virtual {v0}, Lcom/livemixtapes/ui/widgets/SearchView;->clearFocus()V

    .line 346
    const/4 v0, 0x0

    return v0
.end method

.method public runTextSearch(Ljava/lang/String;)V
    .locals 3
    .param p1, "text"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 332
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 333
    iget-object v0, p0, Lcom/livemixtapes/SearchFragment;->list:Landroid/widget/ListView;

    invoke-virtual {v0}, Landroid/widget/ListView;->clearTextFilter()V

    .line 334
    iget-object v0, p0, Lcom/livemixtapes/SearchFragment;->activity:Lcom/livemixtapes/SearchActivity;

    invoke-virtual {v0}, Lcom/livemixtapes/SearchActivity;->hideProgressBar()V

    .line 335
    iget-object v0, p0, Lcom/livemixtapes/SearchFragment;->adapter:Lcom/livemixtapes/LazyAdapterSearch;

    iget-object v1, p0, Lcom/livemixtapes/SearchFragment;->topArtistsResultsList:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/livemixtapes/LazyAdapterSearch;->setTopArtists(Ljava/util/ArrayList;)V

    .line 336
    invoke-direct {p0, v2}, Lcom/livemixtapes/SearchFragment;->updateUI(Z)V

    .line 342
    :goto_0
    return-void

    .line 338
    :cond_0
    iput v2, p0, Lcom/livemixtapes/SearchFragment;->curPage:I

    .line 339
    iget-object v0, p0, Lcom/livemixtapes/SearchFragment;->adapter:Lcom/livemixtapes/LazyAdapterSearch;

    invoke-virtual {v0}, Lcom/livemixtapes/LazyAdapterSearch;->clear()V

    .line 340
    invoke-direct {p0, p1}, Lcom/livemixtapes/SearchFragment;->loadSearchResults(Ljava/lang/String;)V

    goto :goto_0
.end method

.method shake(Landroid/content/Context;Landroid/view/View;Ljava/lang/Runnable;)V
    .locals 2
    .param p1, "ctx"    # Landroid/content/Context;
    .param p2, "v"    # Landroid/view/View;
    .param p3, "callback"    # Ljava/lang/Runnable;

    .prologue
    .line 350
    const v1, 0x7f04000c

    invoke-static {p1, v1}, Landroid/view/animation/AnimationUtils;->loadAnimation(Landroid/content/Context;I)Landroid/view/animation/Animation;

    move-result-object v0

    .line 352
    .local v0, "anim":Landroid/view/animation/Animation;
    new-instance v1, Lcom/livemixtapes/SearchFragment$8;

    invoke-direct {v1, p0, p3}, Lcom/livemixtapes/SearchFragment$8;-><init>(Lcom/livemixtapes/SearchFragment;Ljava/lang/Runnable;)V

    invoke-virtual {v0, v1}, Landroid/view/animation/Animation;->setAnimationListener(Landroid/view/animation/Animation$AnimationListener;)V

    .line 370
    invoke-virtual {p2, v0}, Landroid/view/View;->startAnimation(Landroid/view/animation/Animation;)V

    .line 371
    return-void
.end method
