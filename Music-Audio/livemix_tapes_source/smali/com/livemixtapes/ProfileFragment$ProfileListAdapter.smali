.class public Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;
.super Landroid/widget/BaseAdapter;
.source "ProfileFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/ProfileFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "ProfileListAdapter"
.end annotation


# instance fields
.field private activity:Lcom/livemixtapes/ui/BaseActivity;

.field private inflater:Landroid/view/LayoutInflater;

.field final synthetic this$0:Lcom/livemixtapes/ProfileFragment;


# direct methods
.method public constructor <init>(Lcom/livemixtapes/ProfileFragment;Lcom/livemixtapes/ui/BaseActivity;)V
    .locals 0
    .param p2, "activity"    # Lcom/livemixtapes/ui/BaseActivity;

    .prologue
    .line 131
    iput-object p1, p0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->this$0:Lcom/livemixtapes/ProfileFragment;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 132
    iput-object p2, p0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->activity:Lcom/livemixtapes/ui/BaseActivity;

    .line 133
    return-void
.end method

.method static synthetic access$0(Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;)Lcom/livemixtapes/ui/BaseActivity;
    .locals 1

    .prologue
    .line 128
    iget-object v0, p0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->activity:Lcom/livemixtapes/ui/BaseActivity;

    return-object v0
.end method

.method static synthetic access$1(Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;)Lcom/livemixtapes/ProfileFragment;
    .locals 1

    .prologue
    .line 127
    iget-object v0, p0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->this$0:Lcom/livemixtapes/ProfileFragment;

    return-object v0
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->this$0:Lcom/livemixtapes/ProfileFragment;

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment;->profileList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "location"    # I

    .prologue
    .line 142
    iget-object v0, p0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->this$0:Lcom/livemixtapes/ProfileFragment;

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment;->profileList:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 147
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 31
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 154
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->inflater:Landroid/view/LayoutInflater;

    move-object/from16 v26, v0

    if-nez v26, :cond_0

    .line 155
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->activity:Lcom/livemixtapes/ui/BaseActivity;

    move-object/from16 v26, v0

    .line 156
    const-string v27, "layout_inflater"

    invoke-virtual/range {v26 .. v27}, Lcom/livemixtapes/ui/BaseActivity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v26

    check-cast v26, Landroid/view/LayoutInflater;

    .line 155
    move-object/from16 v0, v26

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->inflater:Landroid/view/LayoutInflater;

    .line 158
    :cond_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->inflater:Landroid/view/LayoutInflater;

    move-object/from16 v26, v0

    const v27, 0x7f030032

    const/16 v28, 0x0

    invoke-virtual/range {v26 .. v28}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 160
    const v26, 0x7f08004d

    move-object/from16 v0, p2

    move/from16 v1, v26

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v10

    check-cast v10, Landroid/widget/ImageView;

    .line 161
    .local v10, "iv":Landroid/widget/ImageView;
    const v26, 0x7f08004e

    move-object/from16 v0, p2

    move/from16 v1, v26

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v23

    check-cast v23, Landroid/widget/TextView;

    .line 163
    .local v23, "title":Landroid/widget/TextView;
    const v26, 0x7f0800ed

    move-object/from16 v0, p2

    move/from16 v1, v26

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    .line 162
    check-cast v6, Landroid/widget/LinearLayout;

    .line 165
    .local v6, "contentLinearLayout":Landroid/widget/LinearLayout;
    const v26, 0x7f0800ee

    move/from16 v0, v26

    invoke-virtual {v6, v0}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v20

    .line 164
    check-cast v20, Landroid/widget/HorizontalScrollView;

    .line 167
    .local v20, "scrollView":Landroid/widget/HorizontalScrollView;
    const v26, 0x7f0800ef

    move-object/from16 v0, v20

    move/from16 v1, v26

    invoke-virtual {v0, v1}, Landroid/widget/HorizontalScrollView;->findViewById(I)Landroid/view/View;

    move-result-object v19

    .line 166
    check-cast v19, Landroid/widget/LinearLayout;

    .line 169
    .local v19, "scrollLayout":Landroid/widget/LinearLayout;
    const v26, 0x7f0800ec

    move-object/from16 v0, p2

    move/from16 v1, v26

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v21

    check-cast v21, Landroid/widget/Button;

    .line 171
    .local v21, "seeAll":Landroid/widget/Button;
    new-instance v26, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$1;

    move-object/from16 v0, v26

    move-object/from16 v1, p0

    move/from16 v2, p1

    invoke-direct {v0, v1, v2}, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$1;-><init>(Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;I)V

    move-object/from16 v0, v21

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 184
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->this$0:Lcom/livemixtapes/ProfileFragment;

    move-object/from16 v26, v0

    move-object/from16 v0, v26

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment;->profileList:Ljava/util/ArrayList;

    move-object/from16 v26, v0

    move-object/from16 v0, v26

    move/from16 v1, p1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v22

    check-cast v22, Ljava/lang/String;

    .line 185
    .local v22, "selected":Ljava/lang/String;
    const-string v17, "Playlists"

    .line 186
    .local v17, "resourceName":Ljava/lang/String;
    const/16 v26, 0x8

    move-object/from16 v0, v20

    move/from16 v1, v26

    invoke-virtual {v0, v1}, Landroid/widget/HorizontalScrollView;->setVisibility(I)V

    .line 188
    const-string v26, "Playlists"

    move-object/from16 v0, v22

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v26

    if-eqz v26, :cond_4

    .line 189
    const-string v17, "profile_playlists"

    .line 190
    new-instance v26, Ljava/lang/StringBuilder;

    invoke-static/range {v22 .. v22}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v27

    invoke-direct/range {v26 .. v27}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v27, " ("

    invoke-virtual/range {v26 .. v27}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v26

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->this$0:Lcom/livemixtapes/ProfileFragment;

    move-object/from16 v27, v0

    move-object/from16 v0, v27

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment;->playlistList:Ljava/util/ArrayList;

    move-object/from16 v27, v0

    invoke-virtual/range {v27 .. v27}, Ljava/util/ArrayList;->size()I

    move-result v27

    invoke-virtual/range {v26 .. v27}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v26

    const-string v27, ")"

    invoke-virtual/range {v26 .. v27}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v26

    invoke-virtual/range {v26 .. v26}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v26

    move-object/from16 v0, v23

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 192
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->this$0:Lcom/livemixtapes/ProfileFragment;

    move-object/from16 v26, v0

    move-object/from16 v0, v26

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment;->playlistList:Ljava/util/ArrayList;

    move-object/from16 v26, v0

    invoke-virtual/range {v26 .. v26}, Ljava/util/ArrayList;->size()I

    move-result v26

    const/16 v27, 0x3

    move/from16 v0, v26

    move/from16 v1, v27

    if-ge v0, v1, :cond_2

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->this$0:Lcom/livemixtapes/ProfileFragment;

    move-object/from16 v26, v0

    move-object/from16 v0, v26

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment;->playlistList:Ljava/util/ArrayList;

    move-object/from16 v26, v0

    invoke-virtual/range {v26 .. v26}, Ljava/util/ArrayList;->size()I

    move-result v14

    .line 193
    .local v14, "maxOf3AndCount":I
    :goto_0
    const/4 v8, 0x0

    .local v8, "i":I
    :goto_1
    if-lt v8, v14, :cond_3

    .line 293
    .end local v8    # "i":I
    .end local v14    # "maxOf3AndCount":I
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->this$0:Lcom/livemixtapes/ProfileFragment;

    move-object/from16 v26, v0

    invoke-virtual/range {v26 .. v26}, Lcom/livemixtapes/ProfileFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v26

    const-string v27, "drawable"

    .line 294
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->activity:Lcom/livemixtapes/ui/BaseActivity;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Lcom/livemixtapes/ui/BaseActivity;->getPackageName()Ljava/lang/String;

    move-result-object v28

    .line 293
    move-object/from16 v0, v26

    move-object/from16 v1, v17

    move-object/from16 v2, v27

    move-object/from16 v3, v28

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v16

    .line 295
    .local v16, "resId":I
    move/from16 v0, v16

    invoke-virtual {v10, v0}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 297
    return-object p2

    .line 192
    .end local v16    # "resId":I
    :cond_2
    const/4 v14, 0x3

    goto :goto_0

    .line 195
    .restart local v8    # "i":I
    .restart local v14    # "maxOf3AndCount":I
    :cond_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->this$0:Lcom/livemixtapes/ProfileFragment;

    move-object/from16 v26, v0

    move-object/from16 v0, v26

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment;->playlistList:Ljava/util/ArrayList;

    move-object/from16 v26, v0

    move-object/from16 v0, v26

    invoke-virtual {v0, v8}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/util/Map;

    .line 196
    .local v13, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->inflater:Landroid/view/LayoutInflater;

    move-object/from16 v26, v0

    .line 197
    const v27, 0x7f030033

    const/16 v28, 0x0

    .line 196
    invoke-virtual/range {v26 .. v28}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v5

    .line 198
    .local v5, "child":Landroid/view/View;
    new-instance v26, Landroid/widget/LinearLayout$LayoutParams;

    .line 199
    const/16 v27, -0x1

    .line 200
    const/16 v28, -0x2

    invoke-direct/range {v26 .. v28}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 198
    move-object/from16 v0, v26

    invoke-virtual {v5, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 202
    const v26, 0x7f0800f1

    move/from16 v0, v26

    invoke-virtual {v5, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v11

    .line 201
    check-cast v11, Landroid/widget/ImageView;

    .line 204
    .local v11, "iv1":Landroid/widget/ImageView;
    const v26, 0x7f0800f3

    move/from16 v0, v26

    invoke-virtual {v5, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v24

    .line 203
    check-cast v24, Landroid/widget/TextView;

    .line 206
    .local v24, "titleBig":Landroid/widget/TextView;
    const v26, 0x7f0800f4

    move/from16 v0, v26

    invoke-virtual {v5, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v25

    .line 205
    check-cast v25, Landroid/widget/TextView;

    .line 207
    .local v25, "titleSmall":Landroid/widget/TextView;
    const-string v26, "title"

    move-object/from16 v0, v26

    invoke-interface {v13, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v26

    invoke-virtual/range {v26 .. v26}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v26

    move-object/from16 v0, v24

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 208
    new-instance v27, Ljava/lang/StringBuilder;

    const-string v26, "tracks"

    move-object/from16 v0, v26

    invoke-interface {v13, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v26

    check-cast v26, Ljava/util/ArrayList;

    invoke-virtual/range {v26 .. v26}, Ljava/util/ArrayList;->size()I

    move-result v26

    invoke-static/range {v26 .. v26}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v26

    move-object/from16 v0, v27

    move-object/from16 v1, v26

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v26, " songs"

    move-object/from16 v0, v27

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v26

    invoke-virtual/range {v26 .. v26}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v25 .. v26}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 209
    const/16 v26, 0x8

    move/from16 v0, v26

    invoke-virtual {v11, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 211
    new-instance v26, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$2;

    move-object/from16 v0, v26

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v13}, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$2;-><init>(Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;Ljava/util/Map;)V

    move-object/from16 v0, v26

    invoke-virtual {v5, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 226
    invoke-virtual {v6, v5}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 193
    add-int/lit8 v8, v8, 0x1

    goto/16 :goto_1

    .line 228
    .end local v5    # "child":Landroid/view/View;
    .end local v8    # "i":I
    .end local v11    # "iv1":Landroid/widget/ImageView;
    .end local v13    # "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v14    # "maxOf3AndCount":I
    .end local v24    # "titleBig":Landroid/widget/TextView;
    .end local v25    # "titleSmall":Landroid/widget/TextView;
    :cond_4
    const-string v26, "Downloads"

    move-object/from16 v0, v22

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v26

    if-eqz v26, :cond_5

    .line 229
    const-string v17, "profile_downloads"

    .line 230
    new-instance v26, Ljava/lang/StringBuilder;

    invoke-static/range {v22 .. v22}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v27

    invoke-direct/range {v26 .. v27}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v27, " ("

    invoke-virtual/range {v26 .. v27}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v26

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->this$0:Lcom/livemixtapes/ProfileFragment;

    move-object/from16 v27, v0

    move-object/from16 v0, v27

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment;->downloadList:Ljava/util/ArrayList;

    move-object/from16 v27, v0

    invoke-virtual/range {v27 .. v27}, Ljava/util/ArrayList;->size()I

    move-result v27

    invoke-virtual/range {v26 .. v27}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v26

    const-string v27, ")"

    invoke-virtual/range {v26 .. v27}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v26

    invoke-virtual/range {v26 .. v26}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v26

    move-object/from16 v0, v23

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 231
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->this$0:Lcom/livemixtapes/ProfileFragment;

    move-object/from16 v26, v0

    move-object/from16 v0, v26

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment;->downloadList:Ljava/util/ArrayList;

    move-object/from16 v26, v0

    invoke-virtual/range {v26 .. v26}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v27

    :goto_2
    invoke-interface/range {v27 .. v27}, Ljava/util/Iterator;->hasNext()Z

    move-result v26

    if-eqz v26, :cond_1

    invoke-interface/range {v27 .. v27}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/util/Map;

    .line 232
    .restart local v13    # "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->inflater:Landroid/view/LayoutInflater;

    move-object/from16 v26, v0

    .line 233
    const v28, 0x7f030033

    const/16 v29, 0x0

    .line 232
    move-object/from16 v0, v26

    move/from16 v1, v28

    move-object/from16 v2, v29

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v5

    .line 234
    .restart local v5    # "child":Landroid/view/View;
    new-instance v26, Landroid/widget/LinearLayout$LayoutParams;

    .line 235
    const/16 v28, -0x1

    .line 236
    const/16 v29, -0x2

    move-object/from16 v0, v26

    move/from16 v1, v28

    move/from16 v2, v29

    invoke-direct {v0, v1, v2}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 234
    move-object/from16 v0, v26

    invoke-virtual {v5, v0}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 238
    const v26, 0x7f0800f1

    move/from16 v0, v26

    invoke-virtual {v5, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v11

    .line 237
    check-cast v11, Landroid/widget/ImageView;

    .line 240
    .restart local v11    # "iv1":Landroid/widget/ImageView;
    const v26, 0x7f0800f3

    move/from16 v0, v26

    invoke-virtual {v5, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v24

    .line 239
    check-cast v24, Landroid/widget/TextView;

    .line 242
    .restart local v24    # "titleBig":Landroid/widget/TextView;
    const v26, 0x7f0800f4

    move/from16 v0, v26

    invoke-virtual {v5, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v25

    .line 241
    check-cast v25, Landroid/widget/TextView;

    .line 243
    .restart local v25    # "titleSmall":Landroid/widget/TextView;
    const-string v26, "title"

    move-object/from16 v0, v26

    invoke-interface {v13, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v26

    invoke-virtual/range {v26 .. v26}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v26

    move-object/from16 v0, v24

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 244
    const-string v26, "duration"

    move-object/from16 v0, v26

    invoke-interface {v13, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v26

    invoke-virtual/range {v26 .. v26}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v26

    invoke-static/range {v26 .. v26}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v26

    div-int/lit8 v26, v26, 0x3c

    move/from16 v0, v26

    int-to-float v0, v0

    move/from16 v26, v0

    invoke-static/range {v26 .. v26}, Ljava/lang/Math;->round(F)I

    move-result v7

    .line 245
    .local v7, "duration":I
    new-instance v26, Ljava/lang/StringBuilder;

    const-string v28, "count"

    move-object/from16 v0, v28

    invoke-interface {v13, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v28

    invoke-static/range {v28 .. v28}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v28, " songs, "

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v26

    move-object/from16 v0, v26

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v26

    const-string v28, " min"

    move-object/from16 v0, v26

    move-object/from16 v1, v28

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v26

    invoke-virtual/range {v26 .. v26}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v26

    invoke-virtual/range {v25 .. v26}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 246
    const/16 v26, 0x0

    move/from16 v0, v26

    invoke-virtual {v11, v0}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 247
    const-string v26, "albumId"

    move-object/from16 v0, v26

    invoke-interface {v13, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v26

    invoke-virtual/range {v26 .. v26}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 248
    .local v4, "albumId":Ljava/lang/String;
    new-instance v26, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$3;

    move-object/from16 v0, v26

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v4}, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$3;-><init>(Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;Ljava/lang/String;)V

    move-object/from16 v0, v26

    invoke-virtual {v5, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 254
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->this$0:Lcom/livemixtapes/ProfileFragment;

    move-object/from16 v26, v0

    move-object/from16 v0, v26

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment;->imageLoader:Lcom/livemixtapes/ImageLoader;

    move-object/from16 v28, v0

    const-string v26, "image"

    move-object/from16 v0, v26

    invoke-interface {v13, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v26

    check-cast v26, Ljava/lang/String;

    move-object/from16 v0, v28

    move-object/from16 v1, v26

    invoke-virtual {v0, v1, v11}, Lcom/livemixtapes/ImageLoader;->DisplayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 256
    invoke-virtual {v6, v5}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto/16 :goto_2

    .line 260
    .end local v4    # "albumId":Ljava/lang/String;
    .end local v5    # "child":Landroid/view/View;
    .end local v7    # "duration":I
    .end local v11    # "iv1":Landroid/widget/ImageView;
    .end local v13    # "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    .end local v24    # "titleBig":Landroid/widget/TextView;
    .end local v25    # "titleSmall":Landroid/widget/TextView;
    :cond_5
    invoke-static {}, Lcom/livemixtapes/User;->isLogged()Ljava/lang/Boolean;

    move-result-object v26

    invoke-virtual/range {v26 .. v26}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v26

    if-eqz v26, :cond_1

    .line 261
    const/16 v26, 0x0

    move-object/from16 v0, v20

    move/from16 v1, v26

    invoke-virtual {v0, v1}, Landroid/widget/HorizontalScrollView;->setVisibility(I)V

    .line 262
    move-object/from16 v0, v23

    move-object/from16 v1, v22

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 263
    const-string v17, "profile_favorites"

    .line 264
    new-instance v26, Ljava/lang/StringBuilder;

    invoke-static/range {v22 .. v22}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v27

    invoke-direct/range {v26 .. v27}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v27, " ("

    invoke-virtual/range {v26 .. v27}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v26

    invoke-static {}, Lcom/livemixtapes/User;->getData()Lcom/livemixtapes/User$UserData;

    move-result-object v27

    move-object/from16 v0, v27

    iget-object v0, v0, Lcom/livemixtapes/User$UserData;->favoriteMixtapes:Ljava/util/List;

    move-object/from16 v27, v0

    invoke-interface/range {v27 .. v27}, Ljava/util/List;->size()I

    move-result v27

    invoke-virtual/range {v26 .. v27}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v26

    const-string v27, ")"

    invoke-virtual/range {v26 .. v27}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v26

    invoke-virtual/range {v26 .. v26}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v26

    move-object/from16 v0, v23

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 266
    invoke-static {}, Lcom/livemixtapes/User;->getData()Lcom/livemixtapes/User$UserData;

    move-result-object v26

    move-object/from16 v0, v26

    iget-object v0, v0, Lcom/livemixtapes/User$UserData;->favoriteMixtapes:Ljava/util/List;

    move-object/from16 v26, v0

    invoke-interface/range {v26 .. v26}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v27

    :goto_3
    invoke-interface/range {v27 .. v27}, Ljava/util/Iterator;->hasNext()Z

    move-result v26

    if-eqz v26, :cond_1

    invoke-interface/range {v27 .. v27}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Ljava/util/Map;

    .line 267
    .restart local v13    # "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    new-instance v9, Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->activity:Lcom/livemixtapes/ui/BaseActivity;

    move-object/from16 v26, v0

    move-object/from16 v0, v26

    invoke-direct {v9, v0}, Landroid/widget/ImageView;-><init>(Landroid/content/Context;)V

    .line 269
    .local v9, "imageView":Landroid/widget/ImageView;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->this$0:Lcom/livemixtapes/ProfileFragment;

    move-object/from16 v26, v0

    invoke-virtual/range {v26 .. v26}, Lcom/livemixtapes/ProfileFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v26

    invoke-virtual/range {v26 .. v26}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v26

    move-object/from16 v0, v26

    iget v0, v0, Landroid/util/DisplayMetrics;->density:F

    move/from16 v18, v0

    .line 270
    .local v18, "scale":F
    const/high16 v26, 0x42480000    # 50.0f

    mul-float v26, v26, v18

    const/high16 v28, 0x3f000000    # 0.5f

    add-float v26, v26, v28

    move/from16 v0, v26

    float-to-int v15, v0

    .line 272
    .local v15, "pixels":I
    new-instance v12, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v12, v15, v15}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 274
    .local v12, "layoutParams":Landroid/widget/LinearLayout$LayoutParams;
    const/16 v26, 0xa

    const/16 v28, 0x5

    const/16 v29, 0xa

    const/16 v30, 0x5

    move/from16 v0, v26

    move/from16 v1, v28

    move/from16 v2, v29

    move/from16 v3, v30

    invoke-virtual {v12, v0, v1, v2, v3}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 276
    invoke-virtual {v9, v12}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 277
    const v26, 0x7f02005b

    move/from16 v0, v26

    invoke-virtual {v9, v0}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 278
    sget-object v26, Landroid/widget/ImageView$ScaleType;->CENTER_INSIDE:Landroid/widget/ImageView$ScaleType;

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Landroid/widget/ImageView;->setScaleType(Landroid/widget/ImageView$ScaleType;)V

    .line 280
    new-instance v26, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$4;

    move-object/from16 v0, v26

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v13}, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter$4;-><init>(Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;Ljava/util/Map;)V

    move-object/from16 v0, v26

    invoke-virtual {v9, v0}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 287
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment$ProfileListAdapter;->this$0:Lcom/livemixtapes/ProfileFragment;

    move-object/from16 v26, v0

    move-object/from16 v0, v26

    iget-object v0, v0, Lcom/livemixtapes/ProfileFragment;->imageLoader:Lcom/livemixtapes/ImageLoader;

    move-object/from16 v28, v0

    const-string v26, "thumbnail"

    move-object/from16 v0, v26

    invoke-interface {v13, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v26

    check-cast v26, Ljava/lang/String;

    move-object/from16 v0, v28

    move-object/from16 v1, v26

    invoke-virtual {v0, v1, v9}, Lcom/livemixtapes/ImageLoader;->DisplayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 289
    move-object/from16 v0, v19

    invoke-virtual {v0, v9}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto/16 :goto_3
.end method
