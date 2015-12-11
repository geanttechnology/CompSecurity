.class public Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/mixerbox/mixerbox3b/classes/MyItem;


# instance fields
.field private action:Ljava/lang/String;

.field private ctx:Landroid/content/Context;

.field private f:Ljava/lang/String;

.field private id:Ljava/lang/String;

.field private jOb:Lorg/json/JSONObject;

.field private k:I

.field private position:I

.field private source:I

.field private thumb:Ljava/lang/String;

.field private tm:Ljava/lang/String;

.field private tt:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lorg/json/JSONObject;II)V
    .locals 2

    .prologue
    .line 36
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->tt:Ljava/lang/String;

    .line 28
    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->tm:Ljava/lang/String;

    .line 29
    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->f:Ljava/lang/String;

    .line 30
    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->action:Ljava/lang/String;

    .line 31
    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->id:Ljava/lang/String;

    .line 35
    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->thumb:Ljava/lang/String;

    .line 37
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->jOb:Lorg/json/JSONObject;

    .line 38
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->ctx:Landroid/content/Context;

    .line 41
    :try_start_0
    const-string v0, "source"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3

    const-string v0, "source"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "soundcloud"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 42
    const-string v0, "title"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->tt:Ljava/lang/String;

    .line 43
    const-string v0, "duration"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->tm:Ljava/lang/String;

    .line 44
    const-string v0, "trackId"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->f:Ljava/lang/String;

    .line 45
    const-string v0, "action"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->action:Ljava/lang/String;

    .line 46
    const-string v0, "_id"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 47
    const-string v0, "_id"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->id:Ljava/lang/String;

    .line 48
    :cond_0
    const-string v0, "thumbnail"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 49
    const-string v0, "thumbnail"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->thumb:Ljava/lang/String;

    .line 50
    :cond_1
    const/4 v0, 0x3

    iput v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->source:I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_2

    .line 70
    :cond_2
    :goto_0
    iput p3, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->position:I

    .line 71
    iput p4, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->k:I

    .line 72
    return-void

    .line 53
    :cond_3
    :try_start_1
    const-string v0, "tt"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->tt:Ljava/lang/String;
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_2

    .line 54
    :goto_1
    :try_start_2
    const-string v0, "tm"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->tm:Ljava/lang/String;
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_3
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_2

    .line 55
    :goto_2
    :try_start_3
    const-string v0, "f"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->f:Ljava/lang/String;
    :try_end_3
    .catch Lorg/json/JSONException; {:try_start_3 .. :try_end_3} :catch_4
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_2

    .line 56
    :goto_3
    :try_start_4
    const-string v0, "action"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->action:Ljava/lang/String;
    :try_end_4
    .catch Lorg/json/JSONException; {:try_start_4 .. :try_end_4} :catch_5
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2

    .line 57
    :goto_4
    :try_start_5
    const-string v0, "_id"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->id:Ljava/lang/String;
    :try_end_5
    .catch Lorg/json/JSONException; {:try_start_5 .. :try_end_5} :catch_6
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_2

    .line 59
    :goto_5
    :try_start_6
    const-string v0, "source"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 60
    const/4 v0, 0x1

    iput v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->source:I
    :try_end_6
    .catch Lorg/json/JSONException; {:try_start_6 .. :try_end_6} :catch_0
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_2

    goto :goto_0

    :catch_0
    move-exception v0

    goto :goto_0

    .line 53
    :catch_1
    move-exception v0

    :try_start_7
    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->tt:Ljava/lang/String;

    goto :goto_1

    :catch_2
    move-exception v0

    goto :goto_0

    .line 54
    :catch_3
    move-exception v0

    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->tm:Ljava/lang/String;

    goto :goto_2

    .line 55
    :catch_4
    move-exception v0

    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->f:Ljava/lang/String;

    goto :goto_3

    .line 56
    :catch_5
    move-exception v0

    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->action:Ljava/lang/String;

    goto :goto_4

    .line 57
    :catch_6
    move-exception v0

    const-string v0, ""

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->id:Ljava/lang/String;
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_2

    goto :goto_5

    .line 61
    :cond_4
    :try_start_8
    const-string v0, "source"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "youtube"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 62
    const/4 v0, 0x1

    iput v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->source:I

    goto :goto_0

    .line 63
    :cond_5
    const-string v0, "source"

    invoke-virtual {p2, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "soundcloud"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 64
    const/4 v0, 0x3

    iput v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->source:I
    :try_end_8
    .catch Lorg/json/JSONException; {:try_start_8 .. :try_end_8} :catch_0
    .catch Ljava/lang/Exception; {:try_start_8 .. :try_end_8} :catch_2

    goto :goto_0
.end method

.method static synthetic access$100(Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->id:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->tt:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$300(Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->tm:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$400(Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->f:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$500(Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;)I
    .locals 1

    .prologue
    .line 24
    iget v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->position:I

    return v0
.end method

.method static synthetic access$600(Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;)I
    .locals 1

    .prologue
    .line 24
    iget v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->source:I

    return v0
.end method

.method static synthetic access$700(Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->thumb:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$800(Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->ctx:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$900(Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;)I
    .locals 1

    .prologue
    .line 24
    iget v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->k:I

    return v0
.end method


# virtual methods
.method public getMyJSONObject()Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 171
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->jOb:Lorg/json/JSONObject;

    return-object v0
.end method

.method public getView(Landroid/view/LayoutInflater;Landroid/view/View;)Landroid/view/View;
    .locals 9

    .prologue
    const v4, 0x7f0b0041

    const/16 v3, 0xf

    const/high16 v8, 0x41200000    # 10.0f

    const/high16 v7, 0x40a00000    # 5.0f

    const/4 v6, 0x0

    .line 88
    if-nez p2, :cond_1

    .line 89
    const v0, 0x7f03004f

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 91
    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$ViewHolder;

    const/4 v0, 0x0

    invoke-direct {v1, v0}, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$ViewHolder;-><init>(Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$1;)V

    .line 92
    const v0, 0x7f070121

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$ViewHolder;->tvName:Landroid/widget/TextView;

    .line 93
    const v0, 0x7f070120

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$ViewHolder;->tvTime:Landroid/widget/TextView;

    .line 94
    const v0, 0x7f07011e

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$ViewHolder;->iv:Landroid/widget/ImageView;

    .line 95
    const v0, 0x7f070122

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$ViewHolder;->btnEdit:Landroid/widget/ImageButton;

    .line 96
    invoke-virtual {p2, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    move-object v0, v1

    .line 101
    :goto_0
    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$ViewHolder;->tvName:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->tt:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 102
    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$ViewHolder;->tvTime:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->tm:Ljava/lang/String;

    invoke-static {v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->getSongTime(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 105
    iget v1, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->source:I

    const/4 v2, 0x3

    if-ne v1, v2, :cond_2

    .line 106
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->thumb:Ljava/lang/String;

    .line 107
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v2, v3, :cond_0

    .line 108
    new-instance v2, Landroid/widget/RelativeLayout$LayoutParams;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->ctx:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v3

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->ctx:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f0b0042

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v4

    invoke-direct {v2, v3, v4}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 111
    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->ctx:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v3

    iget v3, v3, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v3, v8

    float-to-int v3, v3

    .line 112
    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->ctx:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v4

    iget v4, v4, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v4, v7

    float-to-int v4, v4

    .line 113
    invoke-virtual {v2, v3, v4, v6, v4}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 114
    iget-object v3, v0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$ViewHolder;->iv:Landroid/widget/ImageView;

    invoke-virtual {v3, v2}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 133
    :cond_0
    :goto_1
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v2

    iget-object v3, v0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$ViewHolder;->iv:Landroid/widget/ImageView;

    invoke-virtual {v2, v1, v3}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 135
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->action:Ljava/lang/String;

    const-string v2, "addMusic"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 136
    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$ViewHolder;->btnEdit:Landroid/widget/ImageButton;

    invoke-virtual {v1, v6}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 137
    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$ViewHolder;->btnEdit:Landroid/widget/ImageButton;

    const v2, 0x7f0200c7

    invoke-virtual {v1, v2}, Landroid/widget/ImageButton;->setImageResource(I)V

    .line 138
    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$ViewHolder;->btnEdit:Landroid/widget/ImageButton;

    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$1;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$1;-><init>(Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 167
    :goto_2
    return-object p2

    .line 98
    :cond_1
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$ViewHolder;

    goto/16 :goto_0

    .line 118
    :cond_2
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    if-lt v1, v3, :cond_3

    .line 119
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "http://i.ytimg.com/vi/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->f:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/mqdefault.jpg"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 120
    new-instance v2, Landroid/widget/RelativeLayout$LayoutParams;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->ctx:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v3

    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->ctx:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    const v5, 0x7f0b0042

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v4

    invoke-direct {v2, v3, v4}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 123
    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->ctx:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v3

    iget v3, v3, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v3, v8

    float-to-int v3, v3

    .line 124
    iget-object v4, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->ctx:Landroid/content/Context;

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/res/Resources;->getDisplayMetrics()Landroid/util/DisplayMetrics;

    move-result-object v4

    iget v4, v4, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v4, v7

    float-to-int v4, v4

    .line 125
    invoke-virtual {v2, v3, v4, v6, v4}, Landroid/widget/RelativeLayout$LayoutParams;->setMargins(IIII)V

    .line 126
    iget-object v3, v0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$ViewHolder;->iv:Landroid/widget/ImageView;

    invoke-virtual {v3, v2}, Landroid/widget/ImageView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    goto/16 :goto_1

    .line 129
    :cond_3
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "http://i.ytimg.com/vi/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->f:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "/default.jpg"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto/16 :goto_1

    .line 148
    :cond_4
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;->action:Ljava/lang/String;

    const-string v2, "editMusic"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 149
    iget-object v1, v0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$ViewHolder;->btnEdit:Landroid/widget/ImageButton;

    invoke-virtual {v1, v6}, Landroid/widget/ImageButton;->setVisibility(I)V

    .line 150
    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$ViewHolder;->btnEdit:Landroid/widget/ImageButton;

    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$2;

    invoke-direct {v1, p0}, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$2;-><init>(Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem;)V

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_2

    .line 165
    :cond_5
    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/classes/MusicVectorItem$ViewHolder;->btnEdit:Landroid/widget/ImageButton;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageButton;->setVisibility(I)V

    goto/16 :goto_2
.end method

.method public getViewType()I
    .locals 1

    .prologue
    .line 75
    sget-object v0, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter$RowType;->MUSIC_ITEM:Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter$RowType;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter$RowType;->ordinal()I

    move-result v0

    return v0
.end method
