.class public Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;
.super Landroid/widget/BaseAdapter;
.source "SeeAllList.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/profile/SeeAllList;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "PlayListAdapter"
.end annotation


# instance fields
.field private activity:Landroid/app/Activity;

.field private inflater:Landroid/view/LayoutInflater;

.field final synthetic this$0:Lcom/livemixtapes/profile/SeeAllList;


# direct methods
.method public constructor <init>(Lcom/livemixtapes/profile/SeeAllList;Landroid/app/Activity;)V
    .locals 0
    .param p2, "activity"    # Landroid/app/Activity;

    .prologue
    .line 226
    iput-object p1, p0, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 227
    iput-object p2, p0, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;->activity:Landroid/app/Activity;

    .line 228
    return-void
.end method

.method static synthetic access$0(Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;)Lcom/livemixtapes/profile/SeeAllList;
    .locals 1

    .prologue
    .line 222
    iget-object v0, p0, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    return-object v0
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 232
    iget-object v0, p0, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget-object v0, v0, Lcom/livemixtapes/profile/SeeAllList;->playList:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "location"    # I

    .prologue
    .line 237
    iget-object v0, p0, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget-object v0, v0, Lcom/livemixtapes/profile/SeeAllList;->playList:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 242
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 11
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/16 v10, 0x8

    const/4 v9, 0x0

    .line 248
    iget-object v6, p0, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;->inflater:Landroid/view/LayoutInflater;

    if-nez v6, :cond_0

    .line 249
    iget-object v6, p0, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;->activity:Landroid/app/Activity;

    .line 250
    const-string v7, "layout_inflater"

    invoke-virtual {v6, v7}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/view/LayoutInflater;

    .line 249
    iput-object v6, p0, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;->inflater:Landroid/view/LayoutInflater;

    .line 251
    :cond_0
    iget-object v6, p0, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;->inflater:Landroid/view/LayoutInflater;

    const v7, 0x7f030033

    const/4 v8, 0x0

    invoke-virtual {v6, v7, v8}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 253
    iget-object v6, p0, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget-object v6, v6, Lcom/livemixtapes/profile/SeeAllList;->playList:Ljava/util/List;

    invoke-interface {v6, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map;

    .line 255
    .local v3, "map":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    const v6, 0x7f0800f1

    invoke-virtual {p2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    .line 257
    .local v2, "iv":Landroid/widget/ImageView;
    const v6, 0x7f0800f3

    invoke-virtual {p2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .line 256
    check-cast v4, Landroid/widget/TextView;

    .line 259
    .local v4, "titleBig":Landroid/widget/TextView;
    const v6, 0x7f0800f4

    invoke-virtual {p2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    .line 258
    check-cast v5, Landroid/widget/TextView;

    .line 260
    .local v5, "titleSmall":Landroid/widget/TextView;
    const-string v6, "title"

    invoke-interface {v3, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 261
    const v6, 0x7f0800f0

    invoke-virtual {p2, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    .line 262
    .local v0, "deleteButton":Landroid/widget/ImageButton;
    iget-object v6, p0, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget v6, v6, Lcom/livemixtapes/profile/SeeAllList;->flag:I

    const/4 v7, 0x1

    if-ne v6, v7, :cond_2

    .line 263
    invoke-virtual {v2, v10}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 264
    new-instance v7, Ljava/lang/StringBuilder;

    const-string v6, "tracks"

    invoke-interface {v3, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/util/ArrayList;

    invoke-virtual {v6}, Ljava/util/ArrayList;->size()I

    move-result v6

    invoke-static {v6}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    invoke-direct {v7, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    .line 265
    const-string v6, " songs"

    invoke-virtual {v7, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 264
    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 266
    iget-object v6, p0, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget-boolean v6, v6, Lcom/livemixtapes/profile/SeeAllList;->isEditableMode:Z

    if-eqz v6, :cond_1

    .line 268
    invoke-virtual {v0, v9}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 269
    new-instance v6, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter$1;

    invoke-direct {v6, p0, v3}, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter$1;-><init>(Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;Ljava/util/Map;)V

    invoke-virtual {v0, v6}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 312
    :goto_0
    return-object p2

    .line 277
    :cond_1
    invoke-virtual {v0, v10}, Landroid/widget/ImageButton;->setVisibility(I)V

    goto :goto_0

    .line 280
    :cond_2
    iget-object v6, p0, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget v6, v6, Lcom/livemixtapes/profile/SeeAllList;->flag:I

    const/4 v7, 0x2

    if-ne v6, v7, :cond_5

    .line 282
    invoke-virtual {v2, v9}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 283
    iget-object v6, p0, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget-boolean v6, v6, Lcom/livemixtapes/profile/SeeAllList;->isEditableMode:Z

    if-eqz v6, :cond_4

    .line 285
    invoke-virtual {v0, v9}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 286
    new-instance v6, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter$2;

    invoke-direct {v6, p0, v3}, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter$2;-><init>(Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;Ljava/util/Map;)V

    invoke-virtual {v0, v6}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 295
    :goto_1
    const-string v6, "image"

    invoke-interface {v3, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    if-lez v6, :cond_3

    .line 296
    iget-object v6, p0, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget-object v7, v6, Lcom/livemixtapes/profile/SeeAllList;->imageLoader:Lcom/livemixtapes/ImageLoader;

    const-string v6, "image"

    invoke-interface {v3, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-virtual {v7, v6, v2}, Lcom/livemixtapes/ImageLoader;->DisplayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 297
    :cond_3
    const-string v6, "duration"

    invoke-interface {v3, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    .line 298
    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    .line 297
    invoke-static {v6}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v6

    div-int/lit8 v6, v6, 0x3c

    int-to-float v6, v6

    invoke-static {v6}, Ljava/lang/Math;->round(F)I

    move-result v1

    .line 299
    .local v1, "duration":I
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "count"

    invoke-interface {v3, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " songs, "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    .line 300
    const-string v7, " min"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 299
    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 294
    .end local v1    # "duration":I
    :cond_4
    invoke-virtual {v0, v10}, Landroid/widget/ImageButton;->setVisibility(I)V

    goto :goto_1

    .line 303
    :cond_5
    invoke-virtual {v2, v9}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 304
    const-string v6, "thumbnail"

    invoke-interface {v3, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    if-lez v6, :cond_6

    .line 305
    iget-object v6, p0, Lcom/livemixtapes/profile/SeeAllList$PlayListAdapter;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget-object v7, v6, Lcom/livemixtapes/profile/SeeAllList;->imageLoader:Lcom/livemixtapes/ImageLoader;

    const-string v6, "thumbnail"

    invoke-interface {v3, v6}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-virtual {v7, v6, v2}, Lcom/livemixtapes/ImageLoader;->DisplayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 306
    :cond_6
    const-string v6, ""

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0
.end method
