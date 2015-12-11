.class public Lcom/poshmark/data_model/adapters/FindPeopleAdapter;
.super Landroid/widget/CursorAdapter;
.source "FindPeopleAdapter.java"


# instance fields
.field context:Landroid/content/Context;

.field followFollowingButtonListener:Landroid/view/View$OnClickListener;

.field private inflater:Landroid/view/LayoutInflater;

.field itemClickListener:Landroid/view/View$OnClickListener;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/support/v4/app/Fragment;Landroid/database/Cursor;I)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "ownerFrag"    # Landroid/support/v4/app/Fragment;
    .param p3, "c"    # Landroid/database/Cursor;
    .param p4, "flags"    # I

    .prologue
    .line 49
    invoke-direct {p0, p1, p3, p4}, Landroid/widget/CursorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;I)V

    .line 28
    new-instance v0, Lcom/poshmark/data_model/adapters/FindPeopleAdapter$1;

    invoke-direct {v0, p0}, Lcom/poshmark/data_model/adapters/FindPeopleAdapter$1;-><init>(Lcom/poshmark/data_model/adapters/FindPeopleAdapter;)V

    iput-object v0, p0, Lcom/poshmark/data_model/adapters/FindPeopleAdapter;->followFollowingButtonListener:Landroid/view/View$OnClickListener;

    .line 50
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/FindPeopleAdapter;->context:Landroid/content/Context;

    .line 51
    return-void
.end method


# virtual methods
.method public bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
    .locals 9
    .param p1, "view"    # Landroid/view/View;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 57
    move-object v5, p3

    check-cast v5, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 58
    .local v5, "matrixCursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    sget-object v7, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    invoke-virtual {v5, v7}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v4

    .line 60
    .local v4, "idCol":I
    invoke-virtual {v5, v4}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->get(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/poshmark/data_model/models/inner_models/UserReference;

    .line 62
    .local v6, "userReference":Lcom/poshmark/data_model/models/inner_models/UserReference;
    const v7, 0x7f0c0057

    invoke-virtual {p1, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/PMAvataarImageView;

    .line 64
    .local v0, "avataarView":Lcom/poshmark/ui/customviews/PMAvataarImageView;
    const v7, 0x7f0c02f8

    invoke-virtual {p1, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 65
    .local v1, "connectionFullName":Landroid/widget/TextView;
    const v7, 0x7f0c0058

    invoke-virtual {p1, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 66
    .local v2, "connectionUserName":Landroid/widget/TextView;
    const v7, 0x7f0c0060

    invoke-virtual {p1, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    .line 69
    .local v3, "followFollowingButton":Landroid/widget/Button;
    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "@"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v6}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getUserName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 71
    const/4 v7, 0x0

    invoke-virtual {v0, v7}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    .line 72
    invoke-virtual {v6}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getUserId()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v7}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->setUser(Ljava/lang/String;)V

    .line 73
    invoke-virtual {v6}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getAvataar()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v7}, Lcom/poshmark/ui/customviews/PMAvataarImageView;->loadImage(Ljava/lang/String;)V

    .line 75
    invoke-virtual {v6}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getFullName()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v1, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 78
    invoke-virtual {v6}, Lcom/poshmark/data_model/models/inner_models/UserReference;->getUserId()Ljava/lang/String;

    move-result-object v7

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v8

    invoke-virtual {v8}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 79
    const/16 v7, 0x8

    invoke-virtual {v3, v7}, Landroid/widget/Button;->setVisibility(I)V

    .line 93
    :goto_0
    iget-object v7, p0, Lcom/poshmark/data_model/adapters/FindPeopleAdapter;->itemClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {p1, v7}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 94
    invoke-virtual {p1, v6}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 95
    return-void

    .line 82
    :cond_0
    const/4 v7, 0x0

    invoke-virtual {v3, v7}, Landroid/widget/Button;->setVisibility(I)V

    .line 83
    invoke-virtual {v3, v6}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 84
    iget-object v7, p0, Lcom/poshmark/data_model/adapters/FindPeopleAdapter;->followFollowingButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v3, v7}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 85
    invoke-virtual {v6}, Lcom/poshmark/data_model/models/inner_models/UserReference;->isCallerFollowing()Z

    move-result v7

    if-eqz v7, :cond_1

    .line 86
    invoke-static {p2, v3}, Lcom/poshmark/utils/FollowFollowingHelper;->setFollowingButton(Landroid/content/Context;Landroid/widget/Button;)V

    goto :goto_0

    .line 89
    :cond_1
    invoke-static {p2, v3}, Lcom/poshmark/utils/FollowFollowingHelper;->setFollowButton(Landroid/content/Context;Landroid/widget/Button;)V

    goto :goto_0
.end method

.method public newView(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 99
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    iput-object v1, p0, Lcom/poshmark/data_model/adapters/FindPeopleAdapter;->inflater:Landroid/view/LayoutInflater;

    .line 100
    iget-object v1, p0, Lcom/poshmark/data_model/adapters/FindPeopleAdapter;->inflater:Landroid/view/LayoutInflater;

    const v2, 0x7f0300cb

    const/4 v3, 0x0

    invoke-virtual {v1, v2, p3, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 101
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public setOnItemClickListener(Landroid/view/View$OnClickListener;)V
    .locals 0
    .param p1, "listener"    # Landroid/view/View$OnClickListener;

    .prologue
    .line 105
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/FindPeopleAdapter;->itemClickListener:Landroid/view/View$OnClickListener;

    .line 106
    return-void
.end method
