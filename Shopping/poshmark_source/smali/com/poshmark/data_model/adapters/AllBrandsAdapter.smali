.class public Lcom/poshmark/data_model/adapters/AllBrandsAdapter;
.super Landroid/widget/CursorAdapter;
.source "AllBrandsAdapter.java"


# instance fields
.field private inflater:Landroid/view/LayoutInflater;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/support/v4/app/Fragment;Landroid/database/Cursor;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "ownerFrag"    # Landroid/support/v4/app/Fragment;
    .param p3, "c"    # Landroid/database/Cursor;
    .param p4, "flags"    # I

    .prologue
    .line 36
    invoke-direct {p0, p1, p3, p4}, Landroid/widget/CursorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;I)V

    .line 37
    return-void
.end method


# virtual methods
.method public bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 54
    invoke-virtual {p1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/utils/view_holders/AllBrandsListViewHolder;

    .line 55
    .local v2, "viewHolder":Lcom/poshmark/utils/view_holders/AllBrandsListViewHolder;
    const-string v3, "canonical_name"

    invoke-interface {p3, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 56
    .local v1, "colIndex":I
    invoke-interface {p3, v1}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 57
    .local v0, "brandName":Ljava/lang/String;
    iget-object v3, v2, Lcom/poshmark/utils/view_holders/AllBrandsListViewHolder;->title:Lcom/poshmark/ui/customviews/PMTextView;

    invoke-virtual {v3, v0}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 58
    return-void
.end method

.method public newView(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 41
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/data_model/adapters/AllBrandsAdapter;->inflater:Landroid/view/LayoutInflater;

    .line 42
    iget-object v2, p0, Lcom/poshmark/data_model/adapters/AllBrandsAdapter;->inflater:Landroid/view/LayoutInflater;

    const v3, 0x7f03000c

    const/4 v4, 0x0

    invoke-virtual {v2, v3, p3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 44
    .local v0, "v":Landroid/view/View;
    new-instance v1, Lcom/poshmark/utils/view_holders/AllBrandsListViewHolder;

    invoke-direct {v1}, Lcom/poshmark/utils/view_holders/AllBrandsListViewHolder;-><init>()V

    .line 46
    .local v1, "viewHolder":Lcom/poshmark/utils/view_holders/AllBrandsListViewHolder;
    const v2, 0x7f0c0056

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/poshmark/ui/customviews/PMTextView;

    iput-object v2, v1, Lcom/poshmark/utils/view_holders/AllBrandsListViewHolder;->title:Lcom/poshmark/ui/customviews/PMTextView;

    .line 47
    invoke-virtual {v0, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 48
    return-object v0
.end method
