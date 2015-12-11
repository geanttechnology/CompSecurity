.class public Lcom/poshmark/ui/fragments/AllBrandsFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "AllBrandsFragment.java"

# interfaces
.implements Landroid/support/v4/app/LoaderManager$LoaderCallbacks;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/poshmark/ui/fragments/PMFragment;",
        "Landroid/support/v4/app/LoaderManager$LoaderCallbacks",
        "<",
        "Landroid/database/Cursor;",
        ">;"
    }
.end annotation


# instance fields
.field adapter:Lcom/poshmark/data_model/adapters/AllBrandsAdapter;

.field brandsListView:Landroid/widget/ListView;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    return-void
.end method

.method private test(Landroid/view/View;)V
    .locals 2
    .param p1, "viewById"    # Landroid/view/View;

    .prologue
    .line 50
    move-object v0, p1

    check-cast v0, Landroid/widget/Button;

    .line 51
    .local v0, "button":Landroid/widget/Button;
    new-instance v1, Lcom/poshmark/ui/fragments/AllBrandsFragment$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/AllBrandsFragment$1;-><init>(Lcom/poshmark/ui/fragments/AllBrandsFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 57
    return-void
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 31
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 32
    new-instance v0, Lcom/poshmark/data_model/adapters/AllBrandsAdapter;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/AllBrandsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    const/4 v2, 0x0

    const/high16 v3, -0x80000000

    invoke-direct {v0, v1, p0, v2, v3}, Lcom/poshmark/data_model/adapters/AllBrandsAdapter;-><init>(Landroid/content/Context;Landroid/support/v4/app/Fragment;Landroid/database/Cursor;I)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/AllBrandsFragment;->adapter:Lcom/poshmark/data_model/adapters/AllBrandsAdapter;

    .line 33
    return-void
.end method

.method public onCreateLoader(ILandroid/os/Bundle;)Landroid/support/v4/content/Loader;
    .locals 7
    .param p1, "i"    # I
    .param p2, "bundle"    # Landroid/os/Bundle;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Landroid/os/Bundle;",
            ")",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 67
    new-instance v0, Landroid/support/v4/content/CursorLoader;

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/AllBrandsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    sget-object v2, Lcom/poshmark/db/PMDbContentProvider;->CONTENT_URI_BRANDS:Landroid/net/Uri;

    const-string v4, "select * from brands"

    move-object v5, v3

    move-object v6, v3

    invoke-direct/range {v0 .. v6}, Landroid/support/v4/content/CursorLoader;-><init>(Landroid/content/Context;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)V

    return-object v0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v3, 0x0

    .line 37
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 38
    const v1, 0x7f03000b

    invoke-virtual {p1, v1, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 39
    .local v0, "v":Landroid/view/View;
    const v1, 0x7f0c0054

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ListView;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/AllBrandsFragment;->brandsListView:Landroid/widget/ListView;

    .line 40
    iget-object v1, p0, Lcom/poshmark/ui/fragments/AllBrandsFragment;->brandsListView:Landroid/widget/ListView;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/AllBrandsFragment;->adapter:Lcom/poshmark/data_model/adapters/AllBrandsAdapter;

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 42
    const v1, 0x7f0c0055

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/poshmark/ui/fragments/AllBrandsFragment;->test(Landroid/view/View;)V

    .line 44
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/AllBrandsFragment;->getLoaderManager()Landroid/support/v4/app/LoaderManager;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v3, v2, p0}, Landroid/support/v4/app/LoaderManager;->initLoader(ILandroid/os/Bundle;Landroid/support/v4/app/LoaderManager$LoaderCallbacks;)Landroid/support/v4/content/Loader;

    .line 45
    return-object v0
.end method

.method public onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V
    .locals 1
    .param p2, "cursor"    # Landroid/database/Cursor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;",
            "Landroid/database/Cursor;",
            ")V"
        }
    .end annotation

    .prologue
    .line 78
    .local p1, "cursorLoader":Landroid/support/v4/content/Loader;, "Landroid/support/v4/content/Loader<Landroid/database/Cursor;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/AllBrandsFragment;->adapter:Lcom/poshmark/data_model/adapters/AllBrandsAdapter;

    invoke-virtual {v0, p2}, Lcom/poshmark/data_model/adapters/AllBrandsAdapter;->changeCursor(Landroid/database/Cursor;)V

    .line 79
    return-void
.end method

.method public bridge synthetic onLoadFinished(Landroid/support/v4/content/Loader;Ljava/lang/Object;)V
    .locals 0
    .param p1, "x0"    # Landroid/support/v4/content/Loader;
    .param p2, "x1"    # Ljava/lang/Object;

    .prologue
    .line 23
    check-cast p2, Landroid/database/Cursor;

    .end local p2    # "x1":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/poshmark/ui/fragments/AllBrandsFragment;->onLoadFinished(Landroid/support/v4/content/Loader;Landroid/database/Cursor;)V

    return-void
.end method

.method public onLoaderReset(Landroid/support/v4/content/Loader;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/support/v4/content/Loader",
            "<",
            "Landroid/database/Cursor;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 83
    .local p1, "cursorLoader":Landroid/support/v4/content/Loader;, "Landroid/support/v4/content/Loader<Landroid/database/Cursor;>;"
    iget-object v0, p0, Lcom/poshmark/ui/fragments/AllBrandsFragment;->adapter:Lcom/poshmark/data_model/adapters/AllBrandsAdapter;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/poshmark/data_model/adapters/AllBrandsAdapter;->changeCursor(Landroid/database/Cursor;)V

    .line 84
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 0

    .prologue
    .line 62
    return-void
.end method
