.class public Lco/vine/android/widget/ContactsMenuAdapter;
.super Landroid/widget/ArrayAdapter;
.source "ContactsMenuAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/widget/ContactsMenuAdapter$ContactsPickerViewHolder;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/ArrayAdapter",
        "<",
        "Lco/vine/android/ContactEntry;",
        ">;"
    }
.end annotation


# static fields
.field private static final STATE_REGULAR:I = 0x2

.field private static final STATE_SECTIONED:I = 0x1

.field private static final STATE_UNKNOWN:I


# instance fields
.field private mRowHeaderStates:[I

.field private final mViewHolders:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lco/vine/android/widget/ContactsMenuAdapter$ContactsPickerViewHolder;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 37
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;I)V

    .line 34
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Lco/vine/android/widget/ContactsMenuAdapter;->mViewHolders:Landroid/util/SparseArray;

    .line 38
    return-void
.end method


# virtual methods
.method public addAll(Ljava/util/Collection;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<+",
            "Lco/vine/android/ContactEntry;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 42
    .local p1, "collection":Ljava/util/Collection;, "Ljava/util/Collection<+Lco/vine/android/ContactEntry;>;"
    invoke-super {p0, p1}, Landroid/widget/ArrayAdapter;->addAll(Ljava/util/Collection;)V

    .line 43
    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v0

    new-array v0, v0, [I

    iput-object v0, p0, Lco/vine/android/widget/ContactsMenuAdapter;->mRowHeaderStates:[I

    .line 44
    return-void
.end method

.method public getItemId(I)J
    .locals 3
    .param p1, "position"    # I

    .prologue
    .line 128
    invoke-virtual {p0, p1}, Lco/vine/android/widget/ContactsMenuAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/ContactEntry;

    .line 129
    .local v0, "entry":Lco/vine/android/ContactEntry;
    if-eqz v0, :cond_0

    .line 130
    iget-wide v1, v0, Lco/vine/android/ContactEntry;->contactId:J

    .line 132
    :goto_0
    return-wide v1

    :cond_0
    const-wide/16 v1, 0x0

    goto :goto_0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 15
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;
    .annotation build Lorg/jetbrains/annotations/Nullable;
    .end annotation

    .prologue
    .line 50
    if-eqz p2, :cond_0

    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v10

    instance-of v10, v10, Lco/vine/android/widget/ContactsMenuAdapter$ContactsPickerViewHolder;

    if-nez v10, :cond_1

    .line 51
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/widget/ContactsMenuAdapter;->getContext()Landroid/content/Context;

    move-result-object v10

    invoke-static {v10}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v3

    .line 52
    .local v3, "inflater":Landroid/view/LayoutInflater;
    const v10, 0x7f030055

    const/4 v11, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v3, v10, v0, v11}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    .line 53
    new-instance v2, Lco/vine/android/widget/ContactsMenuAdapter$ContactsPickerViewHolder;

    invoke-virtual {p0}, Lco/vine/android/widget/ContactsMenuAdapter;->getContext()Landroid/content/Context;

    move-result-object v10

    move-object/from16 v0, p2

    invoke-direct {v2, v10, v0}, Lco/vine/android/widget/ContactsMenuAdapter$ContactsPickerViewHolder;-><init>(Landroid/content/Context;Landroid/view/View;)V

    .line 54
    .local v2, "holder":Lco/vine/android/widget/ContactsMenuAdapter$ContactsPickerViewHolder;
    move-object/from16 v0, p2

    invoke-virtual {v0, v2}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 58
    .end local v3    # "inflater":Landroid/view/LayoutInflater;
    :goto_0
    iget-object v10, p0, Lco/vine/android/widget/ContactsMenuAdapter;->mViewHolders:Landroid/util/SparseArray;

    new-instance v11, Ljava/lang/ref/WeakReference;

    invoke-direct {v11, v2}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    move/from16 v0, p1

    invoke-virtual {v10, v0, v11}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 60
    invoke-virtual/range {p0 .. p1}, Lco/vine/android/widget/ContactsMenuAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/ContactEntry;

    .line 62
    .local v1, "entry":Lco/vine/android/ContactEntry;
    iget-object v10, p0, Lco/vine/android/widget/ContactsMenuAdapter;->mRowHeaderStates:[I

    aget v10, v10, p1

    packed-switch v10, :pswitch_data_0

    .line 73
    if-nez p1, :cond_2

    .line 74
    const/4 v9, 0x1

    .line 79
    .local v9, "showSeparator":Z
    :goto_1
    iget-object v11, p0, Lco/vine/android/widget/ContactsMenuAdapter;->mRowHeaderStates:[I

    if-eqz v9, :cond_4

    const/4 v10, 0x1

    :goto_2
    aput v10, v11, p1

    .line 85
    :goto_3
    invoke-virtual {p0}, Lco/vine/android/widget/ContactsMenuAdapter;->getCount()I

    move-result v10

    add-int/lit8 v10, v10, -0x1

    move/from16 v0, p1

    if-ge v0, v10, :cond_5

    .line 86
    add-int/lit8 v10, p1, 0x1

    invoke-virtual {p0, v10}, Lco/vine/android/widget/ContactsMenuAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lco/vine/android/ContactEntry;

    .line 87
    .local v5, "nextEntry":Lco/vine/android/ContactEntry;
    invoke-virtual {v1, v5}, Lco/vine/android/ContactEntry;->isSameSection(Lco/vine/android/ContactEntry;)Z

    move-result v6

    .line 92
    .end local v5    # "nextEntry":Lco/vine/android/ContactEntry;
    .local v6, "showDivider":Z
    :goto_4
    iget-object v11, v2, Lco/vine/android/widget/ContactsMenuAdapter$ContactsPickerViewHolder;->divider:Landroid/view/View;

    if-eqz v6, :cond_6

    const/4 v10, 0x0

    :goto_5
    invoke-virtual {v11, v10}, Landroid/view/View;->setVisibility(I)V

    .line 94
    iget v10, v1, Lco/vine/android/ContactEntry;->typeFlag:I

    and-int/lit8 v10, v10, 0x1

    if-eqz v10, :cond_7

    const/4 v7, 0x1

    .line 95
    .local v7, "showEmail":Z
    :goto_6
    iget v10, v1, Lco/vine/android/ContactEntry;->typeFlag:I

    and-int/lit8 v10, v10, 0x2

    if-eqz v10, :cond_8

    const/4 v8, 0x1

    .line 96
    .local v8, "showPhone":Z
    :goto_7
    iget-object v10, v2, Lco/vine/android/widget/ContactsMenuAdapter$ContactsPickerViewHolder;->username:Landroid/widget/TextView;

    iget-object v11, v1, Lco/vine/android/ContactEntry;->displayName:Ljava/lang/String;

    invoke-virtual {v10, v11}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 97
    iget-object v11, v2, Lco/vine/android/widget/ContactsMenuAdapter$ContactsPickerViewHolder;->emailIndicator:Landroid/widget/ImageView;

    if-eqz v7, :cond_9

    const/4 v10, 0x0

    :goto_8
    invoke-virtual {v11, v10}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 98
    iget-object v11, v2, Lco/vine/android/widget/ContactsMenuAdapter$ContactsPickerViewHolder;->phoneIndicator:Landroid/widget/ImageView;

    if-eqz v8, :cond_a

    const/4 v10, 0x0

    :goto_9
    invoke-virtual {v11, v10}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 99
    iget-wide v10, v1, Lco/vine/android/ContactEntry;->contactId:J

    iput-wide v10, v2, Lco/vine/android/widget/ContactsMenuAdapter$ContactsPickerViewHolder;->contactId:J

    .line 101
    if-nez p1, :cond_b

    .line 102
    iget-object v10, v2, Lco/vine/android/widget/ContactsMenuAdapter$ContactsPickerViewHolder;->sectionTitle:Landroid/widget/TextView;

    invoke-virtual {p0}, Lco/vine/android/widget/ContactsMenuAdapter;->getContext()Landroid/content/Context;

    move-result-object v11

    const v12, 0x7f0e008f

    invoke-virtual {v11, v12}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 103
    iget-object v10, v2, Lco/vine/android/widget/ContactsMenuAdapter$ContactsPickerViewHolder;->sectionTitle:Landroid/widget/TextView;

    const/4 v11, 0x0

    invoke-virtual {v10, v11}, Landroid/widget/TextView;->setVisibility(I)V

    .line 108
    :goto_a
    if-eqz v9, :cond_e

    .line 109
    iget-object v10, v2, Lco/vine/android/widget/ContactsMenuAdapter$ContactsPickerViewHolder;->sectionIndicator:Landroid/view/View;

    const/4 v11, 0x0

    invoke-virtual {v10, v11}, Landroid/view/View;->setVisibility(I)V

    .line 110
    iget-object v10, v1, Lco/vine/android/ContactEntry;->alternateName:Ljava/lang/String;

    if-eqz v10, :cond_c

    .line 111
    iget-object v10, v2, Lco/vine/android/widget/ContactsMenuAdapter$ContactsPickerViewHolder;->sectionSort:Landroid/widget/TextView;

    const/4 v11, 0x1

    new-array v11, v11, [C

    const/4 v12, 0x0

    iget-object v13, v1, Lco/vine/android/ContactEntry;->alternateName:Ljava/lang/String;

    invoke-virtual {v13}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v13

    const/4 v14, 0x0

    invoke-virtual {v13, v14}, Ljava/lang/String;->charAt(I)C

    move-result v13

    aput-char v13, v11, v12

    const/4 v12, 0x0

    const/4 v13, 0x1

    invoke-virtual {v10, v11, v12, v13}, Landroid/widget/TextView;->setText([CII)V

    .line 123
    :goto_b
    return-object p2

    .line 56
    .end local v1    # "entry":Lco/vine/android/ContactEntry;
    .end local v2    # "holder":Lco/vine/android/widget/ContactsMenuAdapter$ContactsPickerViewHolder;
    .end local v6    # "showDivider":Z
    .end local v7    # "showEmail":Z
    .end local v8    # "showPhone":Z
    .end local v9    # "showSeparator":Z
    :cond_1
    invoke-virtual/range {p2 .. p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lco/vine/android/widget/ContactsMenuAdapter$ContactsPickerViewHolder;

    .restart local v2    # "holder":Lco/vine/android/widget/ContactsMenuAdapter$ContactsPickerViewHolder;
    goto/16 :goto_0

    .line 64
    .restart local v1    # "entry":Lco/vine/android/ContactEntry;
    :pswitch_0
    const/4 v9, 0x1

    .line 65
    .restart local v9    # "showSeparator":Z
    goto/16 :goto_3

    .line 68
    .end local v9    # "showSeparator":Z
    :pswitch_1
    const/4 v9, 0x0

    .line 69
    .restart local v9    # "showSeparator":Z
    goto/16 :goto_3

    .line 76
    .end local v9    # "showSeparator":Z
    :cond_2
    add-int/lit8 v10, p1, -0x1

    invoke-virtual {p0, v10}, Lco/vine/android/widget/ContactsMenuAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lco/vine/android/ContactEntry;

    .line 77
    .local v4, "lastEntry":Lco/vine/android/ContactEntry;
    invoke-virtual {v1, v4}, Lco/vine/android/ContactEntry;->isSameSection(Lco/vine/android/ContactEntry;)Z

    move-result v10

    if-nez v10, :cond_3

    const/4 v9, 0x1

    .restart local v9    # "showSeparator":Z
    :goto_c
    goto/16 :goto_1

    .end local v9    # "showSeparator":Z
    :cond_3
    const/4 v9, 0x0

    goto :goto_c

    .line 79
    .end local v4    # "lastEntry":Lco/vine/android/ContactEntry;
    .restart local v9    # "showSeparator":Z
    :cond_4
    const/4 v10, 0x2

    goto/16 :goto_2

    .line 89
    :cond_5
    const/4 v6, 0x1

    .restart local v6    # "showDivider":Z
    goto/16 :goto_4

    .line 92
    :cond_6
    const/16 v10, 0x8

    goto/16 :goto_5

    .line 94
    :cond_7
    const/4 v7, 0x0

    goto/16 :goto_6

    .line 95
    .restart local v7    # "showEmail":Z
    :cond_8
    const/4 v8, 0x0

    goto/16 :goto_7

    .line 97
    .restart local v8    # "showPhone":Z
    :cond_9
    const/16 v10, 0x8

    goto :goto_8

    .line 98
    :cond_a
    const/16 v10, 0x8

    goto :goto_9

    .line 105
    :cond_b
    iget-object v10, v2, Lco/vine/android/widget/ContactsMenuAdapter$ContactsPickerViewHolder;->sectionTitle:Landroid/widget/TextView;

    const/16 v11, 0x8

    invoke-virtual {v10, v11}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_a

    .line 113
    :cond_c
    iget-object v10, v1, Lco/vine/android/ContactEntry;->displayName:Ljava/lang/String;

    if-eqz v10, :cond_d

    .line 114
    iget-object v10, v2, Lco/vine/android/widget/ContactsMenuAdapter$ContactsPickerViewHolder;->sectionSort:Landroid/widget/TextView;

    const/4 v11, 0x1

    new-array v11, v11, [C

    const/4 v12, 0x0

    iget-object v13, v1, Lco/vine/android/ContactEntry;->displayName:Ljava/lang/String;

    invoke-virtual {v13}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v13

    const/4 v14, 0x0

    invoke-virtual {v13, v14}, Ljava/lang/String;->charAt(I)C

    move-result v13

    aput-char v13, v11, v12

    const/4 v12, 0x0

    const/4 v13, 0x1

    invoke-virtual {v10, v11, v12, v13}, Landroid/widget/TextView;->setText([CII)V

    goto :goto_b

    .line 116
    :cond_d
    iget-object v10, v2, Lco/vine/android/widget/ContactsMenuAdapter$ContactsPickerViewHolder;->sectionSort:Landroid/widget/TextView;

    const/4 v11, 0x1

    new-array v11, v11, [C

    const/4 v12, 0x0

    const/16 v13, 0x20

    aput-char v13, v11, v12

    const/4 v12, 0x0

    const/4 v13, 0x1

    invoke-virtual {v10, v11, v12, v13}, Landroid/widget/TextView;->setText([CII)V

    goto :goto_b

    .line 120
    :cond_e
    iget-object v10, v2, Lco/vine/android/widget/ContactsMenuAdapter$ContactsPickerViewHolder;->sectionIndicator:Landroid/view/View;

    const/16 v11, 0x8

    invoke-virtual {v10, v11}, Landroid/view/View;->setVisibility(I)V

    goto :goto_b

    .line 62
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
