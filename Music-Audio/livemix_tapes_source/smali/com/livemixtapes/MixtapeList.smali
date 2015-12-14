.class public Lcom/livemixtapes/MixtapeList;
.super Landroid/app/Fragment;
.source "MixtapeList.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/livemixtapes/MixtapeList$MixtapeListAdapter;
    }
.end annotation


# instance fields
.field adapter:Lcom/livemixtapes/MixtapeList$MixtapeListAdapter;

.field curPage:I

.field imageLoader:Lcom/livemixtapes/ImageLoader;

.field layoutBack:Landroid/widget/LinearLayout;

.field private listScrollListener:Landroid/widget/AbsListView$OnScrollListener;

.field mContext:Landroid/content/Context;

.field mixtapeList:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;>;"
        }
    .end annotation
.end field

.field mixtapeListView:Landroid/widget/ListView;

.field rootView:Landroid/view/View;

.field textViewAction:Landroid/widget/TextView;

.field textViewBack:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 39
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 43
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/livemixtapes/MixtapeList;->mixtapeList:Ljava/util/ArrayList;

    .line 102
    new-instance v0, Lcom/livemixtapes/MixtapeList$1;

    invoke-direct {v0, p0}, Lcom/livemixtapes/MixtapeList$1;-><init>(Lcom/livemixtapes/MixtapeList;)V

    iput-object v0, p0, Lcom/livemixtapes/MixtapeList;->listScrollListener:Landroid/widget/AbsListView$OnScrollListener;

    .line 39
    return-void
.end method

.method static synthetic access$0(Lcom/livemixtapes/MixtapeList;)V
    .locals 0

    .prologue
    .line 120
    invoke-direct {p0}, Lcom/livemixtapes/MixtapeList;->loadNextPage()V

    return-void
.end method

.method private loadNextPage()V
    .locals 8

    .prologue
    const/4 v4, 0x0

    .line 121
    invoke-virtual {p0}, Lcom/livemixtapes/MixtapeList;->getArguments()Landroid/os/Bundle;

    move-result-object v5

    const-string v6, "dj"

    invoke-virtual {v5, v6}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 122
    .local v1, "dj":Ljava/lang/String;
    iget v5, p0, Lcom/livemixtapes/MixtapeList;->curPage:I

    if-nez v5, :cond_0

    iget-object v5, p0, Lcom/livemixtapes/MixtapeList;->mContext:Landroid/content/Context;

    const-string v6, "Loading..."

    const/4 v7, 0x1

    invoke-static {v5, v1, v6, v7}, Landroid/app/ProgressDialog;->show(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Landroid/app/ProgressDialog;

    move-result-object v0

    .line 123
    .local v0, "dialog":Landroid/app/ProgressDialog;
    :goto_0
    const-string v5, " "

    const-string v6, "+"

    invoke-virtual {v1, v5, v6}, Ljava/lang/String;->replaceAll(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 125
    .local v3, "selectedDjEncoded":Ljava/lang/String;
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 129
    .local v2, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    new-instance v5, Lcom/livemixtapes/AsyncHttp;

    invoke-direct {v5}, Lcom/livemixtapes/AsyncHttp;-><init>()V

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "https://api.livemixtapes.com/api/dj/info?name="

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "&page="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget v7, p0, Lcom/livemixtapes/MixtapeList;->curPage:I

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 130
    new-instance v7, Lcom/livemixtapes/MixtapeList$4;

    invoke-direct {v7, p0, v0}, Lcom/livemixtapes/MixtapeList$4;-><init>(Lcom/livemixtapes/MixtapeList;Landroid/app/ProgressDialog;)V

    .line 129
    invoke-virtual {v5, v6, v4, v7}, Lcom/livemixtapes/AsyncHttp;->get(Ljava/lang/String;Ljava/util/Map;Lcom/livemixtapes/AsyncHttp$AsyncHttpCallback;)V

    .line 162
    return-void

    .end local v0    # "dialog":Landroid/app/ProgressDialog;
    .end local v2    # "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v3    # "selectedDjEncoded":Ljava/lang/String;
    :cond_0
    move-object v0, v4

    .line 122
    goto :goto_0
.end method


# virtual methods
.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 57
    iget-object v0, p0, Lcom/livemixtapes/MixtapeList;->rootView:Landroid/view/View;

    if-nez v0, :cond_0

    .line 58
    invoke-virtual {p0}, Lcom/livemixtapes/MixtapeList;->getActivity()Landroid/app/Activity;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/MixtapeList;->mContext:Landroid/content/Context;

    .line 59
    const v0, 0x7f030027

    .line 60
    const/4 v1, 0x0

    .line 59
    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/livemixtapes/MixtapeList;->rootView:Landroid/view/View;

    .line 61
    iget-object v0, p0, Lcom/livemixtapes/MixtapeList;->rootView:Landroid/view/View;

    const v1, 0x7f0800bf

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/livemixtapes/MixtapeList;->mixtapeListView:Landroid/widget/ListView;

    .line 63
    iget-object v0, p0, Lcom/livemixtapes/MixtapeList;->rootView:Landroid/view/View;

    const v1, 0x7f08006d

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/livemixtapes/MixtapeList;->layoutBack:Landroid/widget/LinearLayout;

    .line 64
    iget-object v0, p0, Lcom/livemixtapes/MixtapeList;->rootView:Landroid/view/View;

    const v1, 0x7f08006f

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/livemixtapes/MixtapeList;->textViewBack:Landroid/widget/TextView;

    .line 65
    iget-object v0, p0, Lcom/livemixtapes/MixtapeList;->textViewBack:Landroid/widget/TextView;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 67
    iget-object v0, p0, Lcom/livemixtapes/MixtapeList;->layoutBack:Landroid/widget/LinearLayout;

    new-instance v1, Lcom/livemixtapes/MixtapeList$2;

    invoke-direct {v1, p0}, Lcom/livemixtapes/MixtapeList$2;-><init>(Lcom/livemixtapes/MixtapeList;)V

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 74
    new-instance v0, Lcom/livemixtapes/ImageLoader;

    invoke-virtual {p0}, Lcom/livemixtapes/MixtapeList;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/livemixtapes/ImageLoader;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/livemixtapes/MixtapeList;->imageLoader:Lcom/livemixtapes/ImageLoader;

    .line 75
    new-instance v0, Lcom/livemixtapes/MixtapeList$MixtapeListAdapter;

    invoke-virtual {p0}, Lcom/livemixtapes/MixtapeList;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-direct {v0, p0, v1}, Lcom/livemixtapes/MixtapeList$MixtapeListAdapter;-><init>(Lcom/livemixtapes/MixtapeList;Landroid/app/Activity;)V

    iput-object v0, p0, Lcom/livemixtapes/MixtapeList;->adapter:Lcom/livemixtapes/MixtapeList$MixtapeListAdapter;

    .line 76
    iget-object v0, p0, Lcom/livemixtapes/MixtapeList;->mixtapeListView:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/livemixtapes/MixtapeList;->adapter:Lcom/livemixtapes/MixtapeList$MixtapeListAdapter;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 78
    iget-object v0, p0, Lcom/livemixtapes/MixtapeList;->rootView:Landroid/view/View;

    const v1, 0x7f08006c

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/livemixtapes/MixtapeList;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    const-string v2, "title"

    const-string v3, ""

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 83
    iget-object v0, p0, Lcom/livemixtapes/MixtapeList;->mixtapeListView:Landroid/widget/ListView;

    new-instance v1, Lcom/livemixtapes/MixtapeList$3;

    invoke-direct {v1, p0}, Lcom/livemixtapes/MixtapeList$3;-><init>(Lcom/livemixtapes/MixtapeList;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 93
    invoke-direct {p0}, Lcom/livemixtapes/MixtapeList;->loadNextPage()V

    .line 99
    :cond_0
    iget-object v0, p0, Lcom/livemixtapes/MixtapeList;->rootView:Landroid/view/View;

    return-object v0
.end method

.method showMixtapeFragment(Landroid/content/Context;Ljava/util/HashMap;)V
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
    .line 217
    .local p2, "obj":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-virtual {p0}, Lcom/livemixtapes/MixtapeList;->getActivity()Landroid/app/Activity;

    move-result-object v3

    check-cast v3, Lcom/livemixtapes/ui/BaseActivity;

    invoke-virtual {v3}, Lcom/livemixtapes/ui/BaseActivity;->getAnimatedFragmentTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    .line 218
    .local v1, "fragmentTransaction":Landroid/app/FragmentTransaction;
    new-instance v2, Lcom/livemixtapes/Mixtape;

    invoke-direct {v2}, Lcom/livemixtapes/Mixtape;-><init>()V

    .line 219
    .local v2, "mixtapeFragment":Lcom/livemixtapes/Mixtape;
    const v3, 0x7f0800cc

    const-string v4, "MIXTAPE"

    invoke-virtual {v1, v3, v2, v4}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/app/FragmentTransaction;->addToBackStack(Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 220
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 221
    .local v0, "extras":Landroid/os/Bundle;
    const-string v3, "mixtapeData"

    invoke-virtual {v0, v3, p2}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 222
    invoke-virtual {v2, v0}, Lcom/livemixtapes/Mixtape;->setArguments(Landroid/os/Bundle;)V

    .line 223
    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commit()I

    .line 224
    return-void
.end method
