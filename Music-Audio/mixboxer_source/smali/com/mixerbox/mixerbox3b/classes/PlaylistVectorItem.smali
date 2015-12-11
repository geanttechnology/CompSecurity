.class public Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/mixerbox/mixerbox3b/classes/MyItem;


# instance fields
.field private ctx:Landroid/content/Context;

.field private item:Lorg/json/JSONObject;

.field private jOb:Lorg/json/JSONObject;

.field private owner:Ljava/lang/String;

.field private size:Ljava/lang/String;

.field private title:Ljava/lang/String;

.field private u:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lorg/json/JSONObject;)V
    .locals 3

    .prologue
    const/16 v2, 0xf

    .line 37
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 38
    const-string v0, "thumbnail"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "title"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 39
    :cond_0
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->jOb:Lorg/json/JSONObject;

    .line 40
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->ctx:Landroid/content/Context;

    .line 41
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->item:Lorg/json/JSONObject;

    .line 42
    :try_start_0
    const-string v0, "title"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->title:Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 43
    :goto_0
    :try_start_1
    const-string v0, "owner"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->owner:Ljava/lang/String;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 44
    :goto_1
    :try_start_2
    const-string v0, "size"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->size:Ljava/lang/String;
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_2

    .line 46
    :goto_2
    :try_start_3
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v0, v2, :cond_1

    .line 47
    const-string v0, "thumbnailHQ"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->u:Ljava/lang/String;
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_3

    .line 88
    :goto_3
    return-void

    .line 42
    :catch_0
    move-exception v0

    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->title:Ljava/lang/String;

    goto :goto_0

    .line 43
    :catch_1
    move-exception v0

    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->owner:Ljava/lang/String;

    goto :goto_1

    .line 44
    :catch_2
    move-exception v0

    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->size:Ljava/lang/String;

    goto :goto_2

    .line 49
    :cond_1
    :try_start_4
    const-string v0, "thumbnail"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->u:Ljava/lang/String;
    :try_end_4
    .catch Lorg/json/JSONException; {:try_start_4 .. :try_end_4} :catch_3

    goto :goto_3

    .line 52
    :catch_3
    move-exception v0

    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->u:Ljava/lang/String;

    goto :goto_3

    .line 56
    :cond_2
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->jOb:Lorg/json/JSONObject;

    .line 57
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->ctx:Landroid/content/Context;

    .line 58
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->item:Lorg/json/JSONObject;

    .line 59
    :try_start_5
    const-string v0, "name"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->title:Ljava/lang/String;
    :try_end_5
    .catch Lorg/json/JSONException; {:try_start_5 .. :try_end_5} :catch_5

    .line 60
    :goto_4
    :try_start_6
    const-string v0, "ownerName"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->owner:Ljava/lang/String;
    :try_end_6
    .catch Lorg/json/JSONException; {:try_start_6 .. :try_end_6} :catch_6

    .line 61
    :goto_5
    :try_start_7
    const-string v0, "itemCount"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->size:Ljava/lang/String;
    :try_end_7
    .catch Lorg/json/JSONException; {:try_start_7 .. :try_end_7} :catch_7

    .line 63
    :goto_6
    :try_start_8
    const-string v0, "_id"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 64
    const-string v0, "ref"

    const-string v1, "_id"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 65
    :cond_3
    const-string v0, "name"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_4

    .line 66
    const-string v0, "title"

    const-string v1, "name"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 67
    :cond_4
    const-string v0, "coverhq"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_5

    .line 68
    const-string v0, "thumbnailHQ"

    const-string v1, "coverhq"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 69
    :cond_5
    const-string v0, "cover"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_6

    .line 70
    const-string v0, "thumbnail"

    const-string v1, "cover"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 71
    :cond_6
    const-string v0, "owner"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_7

    .line 72
    const-string v0, "ownerId"

    const-string v1, "owner"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 73
    :cond_7
    const-string v0, "ownerName"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_8

    .line 74
    const-string v0, "owner"

    const-string v1, "ownerNqme"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p2, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;

    .line 75
    :cond_8
    const-string v0, "itemCount"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_9

    .line 76
    const-string v0, "size"

    const-string v1, "itemCount"

    invoke-virtual {p2, v1}, Lorg/json/JSONObject;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {p2, v0, v1}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_8
    .catch Lorg/json/JSONException; {:try_start_8 .. :try_end_8} :catch_8

    .line 79
    :cond_9
    :goto_7
    :try_start_9
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v0, v2, :cond_a

    .line 80
    const-string v0, "coverhq"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->u:Ljava/lang/String;
    :try_end_9
    .catch Lorg/json/JSONException; {:try_start_9 .. :try_end_9} :catch_4

    goto/16 :goto_3

    .line 85
    :catch_4
    move-exception v0

    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->u:Ljava/lang/String;

    goto/16 :goto_3

    .line 59
    :catch_5
    move-exception v0

    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->title:Ljava/lang/String;

    goto/16 :goto_4

    .line 60
    :catch_6
    move-exception v0

    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->owner:Ljava/lang/String;

    goto/16 :goto_5

    .line 61
    :catch_7
    move-exception v0

    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->size:Ljava/lang/String;

    goto/16 :goto_6

    .line 82
    :cond_a
    :try_start_a
    const-string v0, "cover"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->u:Ljava/lang/String;
    :try_end_a
    .catch Lorg/json/JSONException; {:try_start_a .. :try_end_a} :catch_4

    goto/16 :goto_3

    :catch_8
    move-exception v0

    goto :goto_7
.end method

.method static synthetic access$100(Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;)Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->item:Lorg/json/JSONObject;

    return-object v0
.end method

.method static synthetic access$200(Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->title:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$300(Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->owner:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$400(Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->size:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$500(Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->u:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$600(Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->ctx:Landroid/content/Context;

    return-object v0
.end method


# virtual methods
.method public getMyJSONObject()Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 163
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->jOb:Lorg/json/JSONObject;

    return-object v0
.end method

.method public getView(Landroid/view/LayoutInflater;Landroid/view/View;)Landroid/view/View;
    .locals 5

    .prologue
    const/4 v2, 0x0

    .line 105
    if-nez p2, :cond_0

    .line 106
    const v0, 0x7f03004c

    invoke-virtual {p1, v0, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 108
    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$ViewHolder;

    invoke-direct {v1, v2}, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$ViewHolder;-><init>(Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$1;)V

    .line 109
    const v0, 0x7f07011c

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$ViewHolder;->tvName:Landroid/widget/TextView;

    .line 110
    const v0, 0x7f07011d

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$ViewHolder;->tvOwner:Landroid/widget/TextView;

    .line 111
    const v0, 0x7f07011b

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$ViewHolder;->tvItemCount:Landroid/widget/TextView;

    .line 112
    const v0, 0x7f070119

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$ViewHolder;->iv:Landroid/widget/ImageView;

    .line 113
    const v0, 0x7f07011a

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$ViewHolder;->ivQuickPlay:Landroid/widget/ImageView;

    .line 114
    invoke-virtual {p2, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    move-object v0, v1

    .line 119
    :goto_0
    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$ViewHolder;->tvName:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->title:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 120
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->owner:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v1

    if-eqz v1, :cond_1

    .line 121
    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$ViewHolder;->tvOwner:Landroid/widget/TextView;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->ctx:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0800d1

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->owner:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 124
    :goto_1
    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$ViewHolder;->tvItemCount:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->size:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 126
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;->u:Ljava/lang/String;

    iget-object v3, v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$ViewHolder;->iv:Landroid/widget/ImageView;

    invoke-virtual {v1, v2, v3}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 128
    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$ViewHolder;->ivQuickPlay:Landroid/widget/ImageView;

    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$1;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$1;-><init>(Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 159
    return-object p2

    .line 116
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$ViewHolder;

    goto :goto_0

    .line 123
    :cond_1
    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/classes/PlaylistVectorItem$ViewHolder;->tvOwner:Landroid/widget/TextView;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1
.end method

.method public getViewType()I
    .locals 1

    .prologue
    .line 91
    sget-object v0, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter$RowType;->PLAYLIST_ITEM:Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter$RowType;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter$RowType;->ordinal()I

    move-result v0

    return v0
.end method
