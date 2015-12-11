.class public Lcom/mixerbox/mixerbox3b/classes/DJVectorItem;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/mixerbox/mixerbox3b/classes/MyItem;


# instance fields
.field private ctx:Landroid/content/Context;

.field private jOb:Lorg/json/JSONObject;

.field private size:Ljava/lang/String;

.field private title:Ljava/lang/String;

.field private u:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lorg/json/JSONObject;)V
    .locals 2

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/DJVectorItem;->ctx:Landroid/content/Context;

    .line 27
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/classes/DJVectorItem;->jOb:Lorg/json/JSONObject;

    .line 29
    :try_start_0
    const-string v0, "title"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/DJVectorItem;->title:Ljava/lang/String;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 34
    :goto_0
    :try_start_1
    const-string v0, "size"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/DJVectorItem;->size:Ljava/lang/String;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1

    .line 39
    :goto_1
    :try_start_2
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xf

    if-lt v0, v1, :cond_0

    .line 40
    const-string v0, "thumbnailHQ"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/DJVectorItem;->u:Ljava/lang/String;
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_2

    .line 47
    :goto_2
    return-void

    .line 31
    :catch_0
    move-exception v0

    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/DJVectorItem;->title:Ljava/lang/String;

    goto :goto_0

    .line 36
    :catch_1
    move-exception v0

    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/DJVectorItem;->size:Ljava/lang/String;

    goto :goto_1

    .line 42
    :cond_0
    :try_start_3
    const-string v0, "thumbnail"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/DJVectorItem;->u:Ljava/lang/String;
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_2

    goto :goto_2

    .line 45
    :catch_2
    move-exception v0

    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/DJVectorItem;->u:Ljava/lang/String;

    goto :goto_2
.end method


# virtual methods
.method public getMyJSONObject()Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/DJVectorItem;->jOb:Lorg/json/JSONObject;

    return-object v0
.end method

.method public getView(Landroid/view/LayoutInflater;Landroid/view/View;)Landroid/view/View;
    .locals 6

    .prologue
    const/4 v2, 0x0

    const/4 v5, 0x1

    .line 63
    if-nez p2, :cond_0

    .line 64
    const v0, 0x7f030048

    invoke-virtual {p1, v0, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 66
    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/DJVectorItem$ViewHolder;

    invoke-direct {v1, v2}, Lcom/mixerbox/mixerbox3b/classes/DJVectorItem$ViewHolder;-><init>(Lcom/mixerbox/mixerbox3b/classes/DJVectorItem$1;)V

    .line 67
    const v0, 0x7f070100

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/DJVectorItem$ViewHolder;->iv:Landroid/widget/ImageView;

    .line 68
    const v0, 0x7f070102

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/DJVectorItem$ViewHolder;->tvTitle:Landroid/widget/TextView;

    .line 69
    const v0, 0x7f070101

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/DJVectorItem$ViewHolder;->tvCount:Landroid/widget/TextView;

    .line 70
    invoke-virtual {p2, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    move-object v0, v1

    .line 75
    :goto_0
    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/classes/DJVectorItem$ViewHolder;->tvTitle:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/classes/DJVectorItem;->title:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 76
    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/classes/DJVectorItem$ViewHolder;->tvCount:Landroid/widget/TextView;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/classes/DJVectorItem;->size:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/classes/DJVectorItem;->ctx:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    const v4, 0x7f0800d6

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 78
    new-instance v1, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    invoke-direct {v1}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;-><init>()V

    invoke-virtual {v1, v5}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->cacheInMemory(Z)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v1

    invoke-virtual {v1, v5}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->cacheOnDisc(Z)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v1

    new-instance v2, Lcom/mixerbox/mixerbox3b/classes/CircleBitmapDisplayer;

    invoke-direct {v2}, Lcom/mixerbox/mixerbox3b/classes/CircleBitmapDisplayer;-><init>()V

    invoke-virtual {v1, v2}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->displayer(Lcom/nostra13/universalimageloader/core/display/BitmapDisplayer;)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v1

    invoke-virtual {v1}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->build()Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

    move-result-object v1

    .line 81
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v2

    const-string v3, ""

    iget-object v4, v0, Lcom/mixerbox/mixerbox3b/classes/DJVectorItem$ViewHolder;->iv:Landroid/widget/ImageView;

    invoke-virtual {v2, v3, v4, v1}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;Lcom/nostra13/universalimageloader/core/DisplayImageOptions;)V

    .line 83
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v2

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/classes/DJVectorItem;->u:Ljava/lang/String;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/classes/DJVectorItem$ViewHolder;->iv:Landroid/widget/ImageView;

    invoke-virtual {v2, v3, v0, v1}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;Lcom/nostra13/universalimageloader/core/DisplayImageOptions;)V

    .line 85
    return-object p2

    .line 72
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/DJVectorItem$ViewHolder;

    goto :goto_0
.end method

.method public getViewType()I
    .locals 1

    .prologue
    .line 51
    sget-object v0, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter$RowType;->DJ_ITEM:Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter$RowType;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter$RowType;->ordinal()I

    move-result v0

    return v0
.end method
