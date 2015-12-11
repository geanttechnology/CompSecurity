.class public Lcom/poshmark/data_model/adapters/ListingDetailsAdapter;
.super Landroid/widget/CursorAdapter;
.source "ListingDetailsAdapter.java"


# instance fields
.field private inflater:Landroid/view/LayoutInflater;

.field private listView:Landroid/widget/ListView;

.field parentFragment:Lcom/poshmark/ui/fragments/ListingDetailsFragment;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/poshmark/ui/fragments/ListingDetailsFragment;Landroid/database/Cursor;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "ownerFragment"    # Lcom/poshmark/ui/fragments/ListingDetailsFragment;
    .param p3, "c"    # Landroid/database/Cursor;
    .param p4, "flags"    # I

    .prologue
    .line 40
    invoke-direct {p0, p1, p3, p4}, Landroid/widget/CursorAdapter;-><init>(Landroid/content/Context;Landroid/database/Cursor;I)V

    .line 41
    iput-object p2, p0, Lcom/poshmark/data_model/adapters/ListingDetailsAdapter;->parentFragment:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    .line 42
    return-void
.end method


# virtual methods
.method public bindView(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V
    .locals 14
    .param p1, "view"    # Landroid/view/View;
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "cursor"    # Landroid/database/Cursor;

    .prologue
    .line 50
    move-object/from16 v8, p3

    check-cast v8, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 51
    .local v8, "matrixCursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    sget-object v12, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    invoke-virtual {v8, v12}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v6

    .line 52
    .local v6, "idCol":I
    invoke-virtual {v8}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getPosition()I

    move-result v4

    .line 53
    .local v4, "cursorPos":I
    invoke-virtual {v8, v6}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/poshmark/data_model/models/inner_models/Comment;

    .line 55
    .local v2, "comment":Lcom/poshmark/data_model/models/inner_models/Comment;
    const v12, 0x7f0c016f

    invoke-virtual {p1, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/customviews/RoundedImageView;

    .line 57
    .local v0, "avataar":Lcom/poshmark/ui/customviews/RoundedImageView;
    invoke-virtual {v2}, Lcom/poshmark/data_model/models/inner_models/Comment;->getCommenterName()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v0, v12}, Lcom/poshmark/ui/customviews/RoundedImageView;->setUser(Ljava/lang/String;)V

    .line 58
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v7

    .line 59
    .local v7, "imageLoader":Lcom/nostra13/universalimageloader/core/ImageLoader;
    invoke-virtual {v2}, Lcom/poshmark/data_model/models/inner_models/Comment;->getCommenterPicture()Ljava/lang/String;

    move-result-object v12

    if-eqz v12, :cond_0

    .line 60
    invoke-virtual {v2}, Lcom/poshmark/data_model/models/inner_models/Comment;->getCommenterPicture()Ljava/lang/String;

    move-result-object v12

    iget-object v13, v0, Lcom/poshmark/ui/customviews/RoundedImageView;->listener:Lcom/nostra13/universalimageloader/core/listener/ImageLoadingListener;

    invoke-virtual {v7, v12, v13}, Lcom/nostra13/universalimageloader/core/ImageLoader;->loadImage(Ljava/lang/String;Lcom/nostra13/universalimageloader/core/listener/ImageLoadingListener;)V

    .line 65
    :goto_0
    const v12, 0x7f0c0171

    invoke-virtual {p1, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/poshmark/ui/customviews/PMTextView;

    .line 66
    .local v3, "commentText":Lcom/poshmark/ui/customviews/PMTextView;
    iget-object v12, p0, Lcom/poshmark/data_model/adapters/ListingDetailsAdapter;->listView:Landroid/widget/ListView;

    invoke-virtual {v3, v12}, Lcom/poshmark/ui/customviews/PMTextView;->setParentLayout(Landroid/view/View;)V

    .line 67
    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/inner_models/Comment;->getCommenterDisplayHandle()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, " "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v2}, Lcom/poshmark/data_model/models/inner_models/Comment;->getComment()Ljava/lang/CharSequence;

    move-result-object v13

    invoke-interface {v13}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v3, v12}, Lcom/poshmark/ui/customviews/PMTextView;->setComment(Ljava/lang/String;)V

    .line 69
    const v12, 0x7f0c0172

    invoke-virtual {p1, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Lcom/poshmark/ui/customviews/PMTextView;

    .line 70
    .local v5, "dateTimeView":Lcom/poshmark/ui/customviews/PMTextView;
    const/4 v12, 0x0

    invoke-virtual {v5, v12}, Lcom/poshmark/ui/customviews/PMTextView;->setVisibility(I)V

    .line 71
    invoke-virtual {v2}, Lcom/poshmark/data_model/models/inner_models/Comment;->getCreatedAt()Ljava/lang/String;

    move-result-object v12

    const-string v13, ""

    invoke-static {v12, v13}, Lcom/poshmark/utils/DateUtils;->formatDateForDisplay(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v5, v12}, Lcom/poshmark/ui/customviews/PMTextView;->setText(Ljava/lang/CharSequence;)V

    .line 73
    const v12, 0x7f0c0174

    invoke-virtual {p1, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v11

    check-cast v11, Landroid/widget/LinearLayout;

    .line 74
    .local v11, "replyButton":Landroid/widget/LinearLayout;
    const/4 v12, 0x0

    invoke-virtual {v11, v12}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 75
    invoke-virtual {v2}, Lcom/poshmark/data_model/models/inner_models/Comment;->getCommenterDisplayHandle()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Landroid/widget/LinearLayout;->setTag(Ljava/lang/Object;)V

    .line 76
    new-instance v12, Lcom/poshmark/data_model/adapters/ListingDetailsAdapter$1;

    invoke-direct {v12, p0}, Lcom/poshmark/data_model/adapters/ListingDetailsAdapter$1;-><init>(Lcom/poshmark/data_model/adapters/ListingDetailsAdapter;)V

    invoke-virtual {v11, v12}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 83
    const v12, 0x7f0c012a

    invoke-virtual {p1, v12}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 84
    .local v1, "border":Landroid/view/View;
    invoke-virtual {v8}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getPosition()I

    move-result v10

    .line 85
    .local v10, "position":I
    invoke-virtual {v8}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getCount()I

    move-result v9

    .line 86
    .local v9, "numComments":I
    add-int/lit8 v12, v9, -0x1

    if-ge v10, v12, :cond_1

    .line 87
    const/4 v12, 0x0

    invoke-virtual {v1, v12}, Landroid/view/View;->setVisibility(I)V

    .line 92
    :goto_1
    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    invoke-virtual {p1, v12}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 93
    return-void

    .line 62
    .end local v1    # "border":Landroid/view/View;
    .end local v3    # "commentText":Lcom/poshmark/ui/customviews/PMTextView;
    .end local v5    # "dateTimeView":Lcom/poshmark/ui/customviews/PMTextView;
    .end local v9    # "numComments":I
    .end local v10    # "position":I
    .end local v11    # "replyButton":Landroid/widget/LinearLayout;
    :cond_0
    const v12, 0x7f0200d4

    invoke-virtual {v0, v12}, Lcom/poshmark/ui/customviews/RoundedImageView;->setBitmap(I)V

    goto/16 :goto_0

    .line 89
    .restart local v1    # "border":Landroid/view/View;
    .restart local v3    # "commentText":Lcom/poshmark/ui/customviews/PMTextView;
    .restart local v5    # "dateTimeView":Lcom/poshmark/ui/customviews/PMTextView;
    .restart local v9    # "numComments":I
    .restart local v10    # "position":I
    .restart local v11    # "replyButton":Landroid/widget/LinearLayout;
    :cond_1
    const/4 v12, 0x4

    invoke-virtual {v1, v12}, Landroid/view/View;->setVisibility(I)V

    goto :goto_1
.end method

.method public newView(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 9
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "cursor"    # Landroid/database/Cursor;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v8, 0x0

    .line 97
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v4

    iput-object v4, p0, Lcom/poshmark/data_model/adapters/ListingDetailsAdapter;->inflater:Landroid/view/LayoutInflater;

    move-object v2, p2

    .line 98
    check-cast v2, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;

    .line 99
    .local v2, "matrixCursor":Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;
    sget-object v4, Lcom/poshmark/data_model/models/PMData;->DATA_COL:Ljava/lang/String;

    invoke-virtual {v2, v4}, Lcom/poshmark/data_model/customcursors/CustomMatrixCursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v1

    .line 101
    .local v1, "idCol":I
    iget-object v4, p0, Lcom/poshmark/data_model/adapters/ListingDetailsAdapter;->inflater:Landroid/view/LayoutInflater;

    const v5, 0x7f03005f

    invoke-virtual {v4, v5, p3, v8}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    .line 102
    .local v3, "v":Landroid/view/View;
    invoke-virtual {v3}, Landroid/view/View;->getPaddingLeft()I

    move-result v4

    const/high16 v5, 0x41200000    # 10.0f

    invoke-static {p1, v5}, Lcom/poshmark/utils/ViewUtils;->dipToPixels(Landroid/content/Context;F)F

    move-result v5

    float-to-int v5, v5

    invoke-virtual {v3}, Landroid/view/View;->getPaddingRight()I

    move-result v6

    invoke-virtual {v3}, Landroid/view/View;->getPaddingBottom()I

    move-result v7

    invoke-virtual {v3, v4, v5, v6, v7}, Landroid/view/View;->setPadding(IIII)V

    .line 103
    const v4, 0x7f0c012a

    invoke-virtual {v3, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 104
    .local v0, "border":Landroid/view/View;
    invoke-virtual {v0, v8}, Landroid/view/View;->setVisibility(I)V

    .line 106
    return-object v3
.end method

.method public setParentListView(Landroid/widget/ListView;)V
    .locals 0
    .param p1, "listView"    # Landroid/widget/ListView;

    .prologue
    .line 45
    iput-object p1, p0, Lcom/poshmark/data_model/adapters/ListingDetailsAdapter;->listView:Landroid/widget/ListView;

    .line 46
    return-void
.end method
