.class public Lco/vine/android/ContactsPickerAdapter;
.super Landroid/widget/ArrayAdapter;
.source "ContactsPickerAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;
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
.field private final mFragment:Lco/vine/android/ContactsRecipientPickerFragment;

.field private mRowHeaderStates:[I

.field private mViewHolders:Landroid/util/SparseArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/util/SparseArray",
            "<",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lco/vine/android/ContactsRecipientPickerFragment;)V
    .locals 2
    .param p1, "fragment"    # Lco/vine/android/ContactsRecipientPickerFragment;

    .prologue
    .line 35
    invoke-virtual {p1}, Lco/vine/android/ContactsRecipientPickerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;I)V

    .line 36
    iput-object p1, p0, Lco/vine/android/ContactsPickerAdapter;->mFragment:Lco/vine/android/ContactsRecipientPickerFragment;

    .line 37
    new-instance v0, Landroid/util/SparseArray;

    invoke-direct {v0}, Landroid/util/SparseArray;-><init>()V

    iput-object v0, p0, Lco/vine/android/ContactsPickerAdapter;->mViewHolders:Landroid/util/SparseArray;

    .line 38
    return-void
.end method

.method private getSelectionState(Lco/vine/android/ContactEntry;)Ljava/lang/Integer;
    .locals 13
    .param p1, "entry"    # Lco/vine/android/ContactEntry;

    .prologue
    const-wide/16 v4, 0x0

    const-wide/16 v1, -0x1

    const/4 v10, 0x1

    .line 119
    iget-object v0, p1, Lco/vine/android/ContactEntry;->valueMimeMap:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v9

    .line 120
    .local v9, "keySet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    const/4 v7, 0x0

    .line 121
    .local v7, "isEmailPicked":Z
    const/4 v8, 0x0

    .line 122
    .local v8, "isPhonePicked":Z
    invoke-interface {v9}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .local v6, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 123
    .local v3, "value":Ljava/lang/String;
    iget-object v0, p1, Lco/vine/android/ContactEntry;->valueMimeMap:Ljava/util/HashMap;

    invoke-virtual {v0, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v11

    .line 124
    .local v11, "typeFlag":I
    if-nez v7, :cond_1

    if-ne v11, v10, :cond_1

    .line 125
    iget-object v12, p0, Lco/vine/android/ContactsPickerAdapter;->mFragment:Lco/vine/android/ContactsRecipientPickerFragment;

    iget-object v0, p1, Lco/vine/android/ContactEntry;->displayName:Ljava/lang/String;

    invoke-static/range {v0 .. v5}, Lco/vine/android/api/VineRecipient;->fromEmail(Ljava/lang/String;JLjava/lang/String;J)Lco/vine/android/api/VineRecipient;

    move-result-object v0

    invoke-virtual {v12, v0}, Lco/vine/android/ContactsRecipientPickerFragment;->isRecipientSelected(Lco/vine/android/api/VineRecipient;)Z

    move-result v7

    .line 127
    :cond_1
    if-nez v8, :cond_2

    const/4 v0, 0x2

    if-ne v11, v0, :cond_2

    .line 128
    iget-object v12, p0, Lco/vine/android/ContactsPickerAdapter;->mFragment:Lco/vine/android/ContactsRecipientPickerFragment;

    iget-object v0, p1, Lco/vine/android/ContactEntry;->displayName:Ljava/lang/String;

    invoke-static/range {v0 .. v5}, Lco/vine/android/api/VineRecipient;->fromPhone(Ljava/lang/String;JLjava/lang/String;J)Lco/vine/android/api/VineRecipient;

    move-result-object v0

    invoke-virtual {v12, v0}, Lco/vine/android/ContactsRecipientPickerFragment;->isRecipientSelected(Lco/vine/android/api/VineRecipient;)Z

    move-result v8

    .line 130
    :cond_2
    if-eqz v7, :cond_0

    if-eqz v8, :cond_0

    .line 132
    .end local v3    # "value":Ljava/lang/String;
    .end local v11    # "typeFlag":I
    :cond_3
    if-eqz v7, :cond_5

    .line 133
    .local v10, "state":I
    :goto_0
    if-eqz v8, :cond_4

    or-int/lit8 v10, v10, 0x2

    .end local v10    # "state":I
    :cond_4
    invoke-static {v10}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    return-object v0

    .line 132
    :cond_5
    const/4 v10, 0x0

    goto :goto_0
.end method

.method private invalidateHolderSelectors(Lco/vine/android/ContactEntry;Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;)V
    .locals 5
    .param p1, "entry"    # Lco/vine/android/ContactEntry;
    .param p2, "holder"    # Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;

    .prologue
    const/4 v4, 0x1

    const/4 v2, 0x0

    .line 174
    invoke-direct {p0, p1}, Lco/vine/android/ContactsPickerAdapter;->getSelectionState(Lco/vine/android/ContactEntry;)Ljava/lang/Integer;

    move-result-object v1

    .line 175
    .local v1, "state":Ljava/lang/Integer;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 176
    .local v0, "selectionState":I
    :goto_0
    and-int/lit8 v3, v0, 0x1

    if-eqz v3, :cond_1

    .line 177
    iget-object v3, p2, Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;->emailIndicator:Landroid/widget/ImageView;

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setSelected(Z)V

    .line 182
    :goto_1
    and-int/lit8 v3, v0, 0x2

    if-eqz v3, :cond_2

    .line 183
    iget-object v2, p2, Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;->phoneIndicator:Landroid/widget/ImageView;

    invoke-virtual {v2, v4}, Landroid/widget/ImageView;->setSelected(Z)V

    .line 188
    :goto_2
    return-void

    .end local v0    # "selectionState":I
    :cond_0
    move v0, v2

    .line 175
    goto :goto_0

    .line 179
    .restart local v0    # "selectionState":I
    :cond_1
    iget-object v3, p2, Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;->emailIndicator:Landroid/widget/ImageView;

    invoke-virtual {v3, v2}, Landroid/widget/ImageView;->setSelected(Z)V

    goto :goto_1

    .line 185
    :cond_2
    iget-object v3, p2, Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;->phoneIndicator:Landroid/widget/ImageView;

    invoke-virtual {v3, v2}, Landroid/widget/ImageView;->setSelected(Z)V

    goto :goto_2
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
    .line 138
    .local p1, "collection":Ljava/util/Collection;, "Ljava/util/Collection<+Lco/vine/android/ContactEntry;>;"
    invoke-super {p0, p1}, Landroid/widget/ArrayAdapter;->addAll(Ljava/util/Collection;)V

    .line 139
    invoke-interface {p1}, Ljava/util/Collection;->size()I

    move-result v0

    new-array v0, v0, [I

    iput-object v0, p0, Lco/vine/android/ContactsPickerAdapter;->mRowHeaderStates:[I

    .line 140
    return-void
.end method

.method public getItemId(I)J
    .locals 3
    .param p1, "position"    # I

    .prologue
    .line 144
    invoke-virtual {p0, p1}, Lco/vine/android/ContactsPickerAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/ContactEntry;

    .line 145
    .local v0, "entry":Lco/vine/android/ContactEntry;
    if-eqz v0, :cond_0

    .line 146
    iget-wide v1, v0, Lco/vine/android/ContactEntry;->contactId:J

    .line 148
    :goto_0
    return-wide v1

    :cond_0
    const-wide/16 v1, 0x0

    goto :goto_0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 12
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/16 v9, 0x8

    const/4 v6, 0x1

    const/4 v7, 0x0

    .line 79
    if-nez p2, :cond_1

    .line 80
    invoke-virtual {p0}, Lco/vine/android/ContactsPickerAdapter;->getContext()Landroid/content/Context;

    move-result-object v8

    invoke-static {v8}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    .line 81
    .local v2, "inflater":Landroid/view/LayoutInflater;
    const v8, 0x7f03007e

    invoke-virtual {v2, v8, p3, v7}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object p2

    .line 82
    new-instance v1, Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;

    invoke-direct {v1, p2}, Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;-><init>(Landroid/view/View;)V

    .line 83
    .local v1, "holder":Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;
    invoke-virtual {p2, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 87
    .end local v2    # "inflater":Landroid/view/LayoutInflater;
    :goto_0
    iget-object v8, p0, Lco/vine/android/ContactsPickerAdapter;->mViewHolders:Landroid/util/SparseArray;

    new-instance v10, Ljava/lang/ref/WeakReference;

    invoke-direct {v10, v1}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v8, p1, v10}, Landroid/util/SparseArray;->put(ILjava/lang/Object;)V

    .line 89
    invoke-virtual {p0, p1}, Lco/vine/android/ContactsPickerAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/ContactEntry;

    .line 90
    .local v0, "entry":Lco/vine/android/ContactEntry;
    invoke-virtual {p0, p1, v0}, Lco/vine/android/ContactsPickerAdapter;->showSeparator(ILco/vine/android/ContactEntry;)Z

    move-result v5

    .line 91
    .local v5, "showSeparator":Z
    iget v8, v0, Lco/vine/android/ContactEntry;->typeFlag:I

    and-int/lit8 v8, v8, 0x1

    if-eqz v8, :cond_2

    move v3, v6

    .line 92
    .local v3, "showEmail":Z
    :goto_1
    iget v8, v0, Lco/vine/android/ContactEntry;->typeFlag:I

    and-int/lit8 v8, v8, 0x2

    if-eqz v8, :cond_3

    move v4, v6

    .line 93
    .local v4, "showPhone":Z
    :goto_2
    iget-object v8, v1, Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;->username:Landroid/widget/TextView;

    iget-object v10, v0, Lco/vine/android/ContactEntry;->displayName:Ljava/lang/String;

    invoke-virtual {v8, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 94
    iget-object v10, v1, Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;->emailIndicator:Landroid/widget/ImageView;

    if-eqz v3, :cond_4

    move v8, v7

    :goto_3
    invoke-virtual {v10, v8}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 95
    iget-object v10, v1, Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;->phoneIndicator:Landroid/widget/ImageView;

    if-eqz v4, :cond_5

    move v8, v7

    :goto_4
    invoke-virtual {v10, v8}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 96
    iget-wide v10, v0, Lco/vine/android/ContactEntry;->contactId:J

    iput-wide v10, v1, Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;->contactId:J

    .line 98
    invoke-direct {p0, v0, v1}, Lco/vine/android/ContactsPickerAdapter;->invalidateHolderSelectors(Lco/vine/android/ContactEntry;Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;)V

    .line 100
    if-eqz v5, :cond_7

    .line 101
    iget-object v8, v1, Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;->separator:Landroid/widget/TextView;

    invoke-virtual {v8, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 102
    iget-object v8, v0, Lco/vine/android/ContactEntry;->alternateName:Ljava/lang/String;

    if-eqz v8, :cond_6

    .line 103
    iget-object v8, v1, Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;->separator:Landroid/widget/TextView;

    new-array v10, v6, [C

    iget-object v11, v0, Lco/vine/android/ContactEntry;->alternateName:Ljava/lang/String;

    invoke-virtual {v11}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v11, v7}, Ljava/lang/String;->charAt(I)C

    move-result v11

    aput-char v11, v10, v7

    invoke-virtual {v8, v10, v7, v6}, Landroid/widget/TextView;->setText([CII)V

    .line 111
    :goto_5
    add-int/lit8 v6, p1, 0x1

    invoke-virtual {p0}, Lco/vine/android/ContactsPickerAdapter;->getCount()I

    move-result v8

    if-ge v6, v8, :cond_0

    .line 112
    iget-object v8, v1, Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;->divider:Landroid/view/View;

    add-int/lit8 v10, p1, 0x1

    add-int/lit8 v6, p1, 0x1

    invoke-virtual {p0, v6}, Lco/vine/android/ContactsPickerAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lco/vine/android/ContactEntry;

    invoke-virtual {p0, v10, v6}, Lco/vine/android/ContactsPickerAdapter;->showSeparator(ILco/vine/android/ContactEntry;)Z

    move-result v6

    if-eqz v6, :cond_8

    :goto_6
    invoke-virtual {v8, v9}, Landroid/view/View;->setVisibility(I)V

    .line 115
    :cond_0
    return-object p2

    .line 85
    .end local v0    # "entry":Lco/vine/android/ContactEntry;
    .end local v1    # "holder":Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;
    .end local v3    # "showEmail":Z
    .end local v4    # "showPhone":Z
    .end local v5    # "showSeparator":Z
    :cond_1
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;

    .restart local v1    # "holder":Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;
    goto/16 :goto_0

    .restart local v0    # "entry":Lco/vine/android/ContactEntry;
    .restart local v5    # "showSeparator":Z
    :cond_2
    move v3, v7

    .line 91
    goto :goto_1

    .restart local v3    # "showEmail":Z
    :cond_3
    move v4, v7

    .line 92
    goto :goto_2

    .restart local v4    # "showPhone":Z
    :cond_4
    move v8, v9

    .line 94
    goto :goto_3

    :cond_5
    move v8, v9

    .line 95
    goto :goto_4

    .line 105
    :cond_6
    iget-object v8, v1, Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;->separator:Landroid/widget/TextView;

    new-array v10, v6, [C

    iget-object v11, v0, Lco/vine/android/ContactEntry;->displayName:Ljava/lang/String;

    invoke-virtual {v11}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v11, v7}, Ljava/lang/String;->charAt(I)C

    move-result v11

    aput-char v11, v10, v7

    invoke-virtual {v8, v10, v7, v6}, Landroid/widget/TextView;->setText([CII)V

    goto :goto_5

    .line 108
    :cond_7
    iget-object v6, v1, Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;->separator:Landroid/widget/TextView;

    invoke-virtual {v6, v9}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_5

    :cond_8
    move v9, v7

    .line 112
    goto :goto_6
.end method

.method public onRecipientItemAdded(Lco/vine/android/ContactEntry;ILjava/lang/String;)V
    .locals 10
    .param p1, "entry"    # Lco/vine/android/ContactEntry;
    .param p2, "typeFlag"    # I
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    const/4 v9, 0x1

    .line 191
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 192
    .local v4, "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    iget-object v5, p0, Lco/vine/android/ContactsPickerAdapter;->mViewHolders:Landroid/util/SparseArray;

    invoke-virtual {v5}, Landroid/util/SparseArray;->size()I

    move-result v3

    .line 193
    .local v3, "size":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v3, :cond_3

    .line 194
    iget-object v5, p0, Lco/vine/android/ContactsPickerAdapter;->mViewHolders:Landroid/util/SparseArray;

    invoke-virtual {v5, v1}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/ref/WeakReference;

    .line 195
    .local v2, "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;>;"
    invoke-virtual {v2}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;

    .line 196
    .local v0, "holder":Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;
    if-nez v0, :cond_1

    .line 197
    iget-object v5, p0, Lco/vine/android/ContactsPickerAdapter;->mViewHolders:Landroid/util/SparseArray;

    invoke-virtual {v5, v1}, Landroid/util/SparseArray;->keyAt(I)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 193
    :cond_0
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 199
    :cond_1
    iget-wide v5, v0, Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;->contactId:J

    iget-wide v7, p1, Lco/vine/android/ContactEntry;->contactId:J

    cmp-long v5, v5, v7

    if-nez v5, :cond_0

    .line 200
    and-int/lit8 v5, p2, 0x1

    if-eqz v5, :cond_2

    .line 201
    iget-object v5, v0, Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;->emailIndicator:Landroid/widget/ImageView;

    invoke-virtual {v5, v9}, Landroid/widget/ImageView;->setSelected(Z)V

    goto :goto_1

    .line 202
    :cond_2
    and-int/lit8 v5, p2, 0x2

    if-eqz v5, :cond_0

    .line 203
    iget-object v5, v0, Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;->phoneIndicator:Landroid/widget/ImageView;

    invoke-virtual {v5, v9}, Landroid/widget/ImageView;->setSelected(Z)V

    goto :goto_1

    .line 208
    .end local v0    # "holder":Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;
    .end local v2    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;>;"
    :cond_3
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v3

    .line 209
    const/4 v1, 0x0

    :goto_2
    if-ge v1, v3, :cond_4

    .line 210
    iget-object v6, p0, Lco/vine/android/ContactsPickerAdapter;->mViewHolders:Landroid/util/SparseArray;

    invoke-virtual {v4, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Integer;

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    invoke-virtual {v6, v5}, Landroid/util/SparseArray;->remove(I)V

    .line 209
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 212
    :cond_4
    return-void
.end method

.method public onRecipientItemRemoved(Lco/vine/android/ContactEntry;ILjava/lang/String;)V
    .locals 9
    .param p1, "entry"    # Lco/vine/android/ContactEntry;
    .param p2, "typeFlag"    # I
    .param p3, "value"    # Ljava/lang/String;

    .prologue
    .line 153
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 154
    .local v4, "toRemove":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/lang/Integer;>;"
    iget-object v5, p0, Lco/vine/android/ContactsPickerAdapter;->mViewHolders:Landroid/util/SparseArray;

    invoke-virtual {v5}, Landroid/util/SparseArray;->size()I

    move-result v3

    .line 155
    .local v3, "size":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v3, :cond_2

    .line 156
    iget-object v5, p0, Lco/vine/android/ContactsPickerAdapter;->mViewHolders:Landroid/util/SparseArray;

    invoke-virtual {v5, v1}, Landroid/util/SparseArray;->valueAt(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/ref/WeakReference;

    .line 157
    .local v2, "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;>;"
    invoke-virtual {v2}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;

    .line 158
    .local v0, "holder":Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;
    if-nez v0, :cond_1

    .line 159
    iget-object v5, p0, Lco/vine/android/ContactsPickerAdapter;->mViewHolders:Landroid/util/SparseArray;

    invoke-virtual {v5, v1}, Landroid/util/SparseArray;->keyAt(I)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 155
    :cond_0
    :goto_1
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 161
    :cond_1
    iget-wide v5, v0, Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;->contactId:J

    iget-wide v7, p1, Lco/vine/android/ContactEntry;->contactId:J

    cmp-long v5, v5, v7

    if-nez v5, :cond_0

    .line 162
    invoke-direct {p0, p1, v0}, Lco/vine/android/ContactsPickerAdapter;->invalidateHolderSelectors(Lco/vine/android/ContactEntry;Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;)V

    goto :goto_1

    .line 166
    .end local v0    # "holder":Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;
    .end local v2    # "ref":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/ContactsPickerAdapter$ContactsPickerViewHolder;>;"
    :cond_2
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v3

    .line 167
    const/4 v1, 0x0

    :goto_2
    if-ge v1, v3, :cond_3

    .line 168
    iget-object v6, p0, Lco/vine/android/ContactsPickerAdapter;->mViewHolders:Landroid/util/SparseArray;

    invoke-virtual {v4, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/Integer;

    invoke-virtual {v5}, Ljava/lang/Integer;->intValue()I

    move-result v5

    invoke-virtual {v6, v5}, Landroid/util/SparseArray;->remove(I)V

    .line 167
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 171
    :cond_3
    return-void
.end method

.method public showSeparator(ILco/vine/android/ContactEntry;)Z
    .locals 5
    .param p1, "position"    # I
    .param p2, "entry"    # Lco/vine/android/ContactEntry;

    .prologue
    const/4 v4, 0x0

    .line 41
    const/4 v1, 0x0

    .line 42
    .local v1, "showSeparator":Z
    iget-object v2, p0, Lco/vine/android/ContactsPickerAdapter;->mRowHeaderStates:[I

    aget v2, v2, p1

    packed-switch v2, :pswitch_data_0

    .line 53
    if-nez p1, :cond_1

    .line 54
    const/4 v1, 0x1

    .line 69
    :cond_0
    :goto_0
    iget-object v3, p0, Lco/vine/android/ContactsPickerAdapter;->mRowHeaderStates:[I

    if-eqz v1, :cond_3

    const/4 v2, 0x1

    :goto_1
    aput v2, v3, p1

    .line 73
    :goto_2
    return v1

    .line 44
    :pswitch_0
    const/4 v1, 0x1

    .line 45
    goto :goto_2

    .line 48
    :pswitch_1
    const/4 v1, 0x0

    .line 49
    goto :goto_2

    .line 56
    :cond_1
    add-int/lit8 v2, p1, -0x1

    invoke-virtual {p0, v2}, Lco/vine/android/ContactsPickerAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/ContactEntry;

    .line 57
    .local v0, "lastEntry":Lco/vine/android/ContactEntry;
    iget-object v2, v0, Lco/vine/android/ContactEntry;->alternateName:Ljava/lang/String;

    if-eqz v2, :cond_2

    iget-object v2, p2, Lco/vine/android/ContactEntry;->alternateName:Ljava/lang/String;

    if-eqz v2, :cond_2

    .line 58
    iget-object v2, v0, Lco/vine/android/ContactEntry;->alternateName:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, v4}, Ljava/lang/String;->charAt(I)C

    move-result v2

    iget-object v3, p2, Lco/vine/android/ContactEntry;->alternateName:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, v4}, Ljava/lang/String;->charAt(I)C

    move-result v3

    if-eq v2, v3, :cond_0

    .line 60
    const/4 v1, 0x1

    goto :goto_0

    .line 63
    :cond_2
    iget-object v2, v0, Lco/vine/android/ContactEntry;->displayName:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2, v4}, Ljava/lang/String;->charAt(I)C

    move-result v2

    iget-object v3, p2, Lco/vine/android/ContactEntry;->displayName:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, v4}, Ljava/lang/String;->charAt(I)C

    move-result v3

    if-eq v2, v3, :cond_0

    .line 65
    const/4 v1, 0x1

    goto :goto_0

    .line 69
    .end local v0    # "lastEntry":Lco/vine/android/ContactEntry;
    :cond_3
    const/4 v2, 0x2

    goto :goto_1

    .line 42
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method
