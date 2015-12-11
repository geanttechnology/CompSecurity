.class public Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/mixerbox/mixerbox3b/classes/MyItem;


# instance fields
.field private ctx:Landroid/content/Context;

.field private item:Lorg/json/JSONObject;

.field private jOb:Lorg/json/JSONObject;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lorg/json/JSONObject;)V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;->ctx:Landroid/content/Context;

    .line 31
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;->jOb:Lorg/json/JSONObject;

    .line 32
    iput-object p2, p0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;->item:Lorg/json/JSONObject;

    .line 33
    return-void
.end method


# virtual methods
.method public getMyJSONObject()Lorg/json/JSONObject;
    .locals 1

    .prologue
    .line 544
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;->jOb:Lorg/json/JSONObject;

    return-object v0
.end method

.method public getView(Landroid/view/LayoutInflater;Landroid/view/View;)Landroid/view/View;
    .locals 12

    .prologue
    .line 64
    if-nez p2, :cond_8

    .line 65
    const v0, 0x7f03004a

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 67
    new-instance v1, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;

    const/4 v0, 0x0

    invoke-direct {v1, v0}, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;-><init>(Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$1;)V

    .line 68
    const v0, 0x7f070073

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->ll:Landroid/widget/LinearLayout;

    .line 69
    const v0, 0x7f070103

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlHeader:Landroid/widget/RelativeLayout;

    .line 70
    const v0, 0x7f070111

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlImage:Landroid/widget/RelativeLayout;

    .line 71
    const v0, 0x7f070108

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlMain:Landroid/widget/RelativeLayout;

    .line 72
    const v0, 0x7f070117

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llFooter:Landroid/widget/LinearLayout;

    .line 73
    const v0, 0x7f070104

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->ivH:Landroid/widget/ImageView;

    .line 74
    const v0, 0x7f070106

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvMainH:Landroid/widget/TextView;

    .line 75
    const v0, 0x7f070107

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvSubH:Landroid/widget/TextView;

    .line 76
    const v0, 0x7f07010e

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvMainM:Landroid/widget/TextView;

    .line 77
    const v0, 0x7f07010f

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvSubM:Landroid/widget/TextView;

    .line 78
    const v0, 0x7f07010b

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvSideM:Landroid/widget/TextView;

    .line 79
    const v0, 0x7f07010c

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llSub:Landroid/widget/LinearLayout;

    .line 80
    const v0, 0x7f070109

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->ivM:Landroid/widget/ImageView;

    .line 81
    const v0, 0x7f07010a

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->ivQM:Landroid/widget/ImageView;

    .line 82
    const v0, 0x7f070112

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->ivB:Landroid/widget/ImageView;

    .line 83
    const v0, 0x7f070113

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->ivQB:Landroid/widget/ImageView;

    .line 84
    const v0, 0x7f070114

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvMain:Landroid/widget/TextView;

    .line 85
    const v0, 0x7f070115

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvSub:Landroid/widget/TextView;

    .line 86
    const v0, 0x7f070110

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llMusic:Landroid/widget/LinearLayout;

    .line 87
    invoke-virtual {p2, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    move-object v6, v1

    .line 93
    :goto_0
    const/4 v0, 0x0

    .line 94
    :try_start_0
    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;->item:Lorg/json/JSONObject;

    const-string v2, "margin"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_4c

    .line 95
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;->item:Lorg/json/JSONObject;

    const-string v1, "margin"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    move v5, v0

    .line 97
    :goto_1
    if-nez v5, :cond_0

    .line 98
    const/4 v0, 0x0

    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {p2, v0, v1, v2, v3}, Landroid/view/View;->setPadding(IIII)V

    .line 99
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->ll:Landroid/widget/LinearLayout;

    const v1, 0x7f060018

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setBackgroundResource(I)V

    .line 102
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;->item:Lorg/json/JSONObject;

    const-string v1, "views"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v7

    .line 104
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    .line 105
    const-string v1, "main"

    invoke-virtual {v7, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_4b

    const-string v1, "main"

    invoke-virtual {v7, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "mainLink"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_4b

    .line 106
    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "mainLink"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    move-object v4, v0

    .line 108
    :goto_2
    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_12

    .line 109
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlHeader:Landroid/widget/RelativeLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 110
    if-eqz v5, :cond_d

    .line 111
    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "bgColor"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_9

    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "bgColor"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_9

    const-string v0, "footer"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_9

    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 112
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlHeader:Landroid/widget/RelativeLayout;

    const v1, 0x7f0200c0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 131
    :goto_3
    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "imageUrl"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_f

    .line 132
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->ivH:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 133
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v0

    const-string v1, "header"

    invoke-virtual {v7, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "imageUrl"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iget-object v2, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->ivH:Landroid/widget/ImageView;

    invoke-virtual {v0, v1, v2}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 138
    :goto_4
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvMainH:Landroid/widget/TextView;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 140
    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "object1"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 141
    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "object1"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 142
    const-string v1, "header"

    invoke-virtual {v7, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 143
    const-string v2, "obj1IsSwitch"

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 144
    const-string v2, "header"

    invoke-virtual {v7, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "object1"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "title"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;

    iget-object v8, p0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;->ctx:Landroid/content/Context;

    invoke-direct {v3, v8, v0, v4, v1}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;-><init>(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;->ctx:Landroid/content/Context;

    invoke-static {v2, v3, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinkSpan(Ljava/lang/CharSequence;Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;Landroid/content/Context;)Landroid/text/SpannableString;

    move-result-object v0

    .line 147
    iget-object v1, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvMainH:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 148
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvMainH:Landroid/widget/TextView;

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinksFocusable(Landroid/widget/TextView;)V

    .line 149
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvMainH:Landroid/widget/TextView;

    const-string v1, " "

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 152
    :cond_1
    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "mainText"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_10

    .line 153
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvMainH:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 154
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvMainH:Landroid/widget/TextView;

    const-string v1, "header"

    invoke-virtual {v7, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "mainText"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 159
    :cond_2
    :goto_5
    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "object2"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 160
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvMainH:Landroid/widget/TextView;

    const-string v1, " "

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 161
    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 162
    const-string v1, "obj2IsSwitch"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lorg/json/JSONObject;->put(Ljava/lang/String;Z)Lorg/json/JSONObject;

    .line 163
    const-string v1, "header"

    invoke-virtual {v7, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "object2"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    .line 164
    const-string v2, "header"

    invoke-virtual {v7, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "object2"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v2

    const-string v3, "title"

    invoke-virtual {v2, v3}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    new-instance v3, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;

    iget-object v8, p0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;->ctx:Landroid/content/Context;

    invoke-direct {v3, v8, v1, v4, v0}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;-><init>(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;->ctx:Landroid/content/Context;

    invoke-static {v2, v3, v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinkSpan(Ljava/lang/CharSequence;Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;Landroid/content/Context;)Landroid/text/SpannableString;

    move-result-object v0

    .line 167
    iget-object v1, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvMainH:Landroid/widget/TextView;

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->append(Ljava/lang/CharSequence;)V

    .line 168
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvMainH:Landroid/widget/TextView;

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->makeLinksFocusable(Landroid/widget/TextView;)V

    .line 171
    :cond_3
    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "subText"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_11

    .line 172
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvSubH:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 173
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvSubH:Landroid/widget/TextView;

    const-string v1, "header"

    invoke-virtual {v7, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "subText"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 181
    :goto_6
    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3d

    .line 183
    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "thumbnail"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_4

    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "thumbnail"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "style"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_4

    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "thumbnail"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "style"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "square"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2e

    .line 187
    :cond_4
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlImage:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 188
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlMain:Landroid/widget/RelativeLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 190
    if-eqz v5, :cond_1a

    .line 191
    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "bgColor"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_16

    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "bgColor"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_16

    .line 192
    const-string v0, "footer"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_13

    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_13

    .line 193
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlMain:Landroid/widget/RelativeLayout;

    const v1, 0x7f0200c0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 219
    :goto_7
    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "mainLink"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_5

    .line 220
    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "mainLink"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 222
    iget-object v1, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlMain:Landroid/widget/RelativeLayout;

    new-instance v2, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;->ctx:Landroid/content/Context;

    const/4 v8, 0x0

    invoke-direct {v2, v3, v0, v4, v8}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;-><init>(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 225
    :cond_5
    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "thumbnail"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1c

    .line 226
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->ivM:Landroid/widget/ImageView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 227
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->ivQM:Landroid/widget/ImageView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 236
    :goto_8
    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "mainLink"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_6

    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "mainLink"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "type"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_6

    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "mainLink"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "type"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "music"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1d

    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "mainLink"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "type"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "playlist"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1d

    .line 237
    :cond_6
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->ivQM:Landroid/widget/ImageView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 242
    :goto_9
    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "subLinks"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1e

    .line 243
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llSub:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 306
    :cond_7
    :goto_a
    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "mainText"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_26

    .line 307
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvMainM:Landroid/widget/TextView;

    const-string v1, "main"

    invoke-virtual {v7, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "mainText"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 321
    :goto_b
    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "subText"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_28

    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "subText"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-lez v0, :cond_28

    .line 322
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvSubM:Landroid/widget/TextView;

    const-string v1, "main"

    invoke-virtual {v7, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "subText"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 323
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvSubM:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 328
    :goto_c
    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "sideText"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_29

    .line 329
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvSideM:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 330
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvSideM:Landroid/widget/TextView;

    const-string v1, "main"

    invoke-virtual {v7, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "sideText"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 335
    :goto_d
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvMainM:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getVisibility()I

    move-result v0

    const/16 v1, 0x8

    if-ne v0, v1, :cond_2a

    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvSubM:Landroid/widget/TextView;

    invoke-virtual {v0}, Landroid/widget/TextView;->getVisibility()I

    move-result v0

    const/16 v1, 0x8

    if-ne v0, v1, :cond_2a

    .line 336
    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    new-instance v1, Landroid/widget/RelativeLayout$LayoutParams;

    const/4 v2, -0x1

    const/4 v3, -0x2

    invoke-direct {v1, v2, v3}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    invoke-direct {v0, v1}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$MarginLayoutParams;)V

    .line 339
    iget-object v1, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llSub:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 340
    const/4 v0, 0x0

    :goto_e
    iget-object v1, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llSub:Landroid/widget/LinearLayout;

    invoke-virtual {v1}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v1

    if-ge v0, v1, :cond_2a

    .line 341
    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    new-instance v2, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v3, 0x0

    const/4 v8, -0x2

    invoke-direct {v2, v3, v8}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-direct {v1, v2}, Landroid/widget/LinearLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$MarginLayoutParams;)V

    .line 343
    const/high16 v2, 0x3f800000    # 1.0f

    iput v2, v1, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    .line 344
    iget-object v2, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llSub:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v0}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    const/16 v3, 0x14

    const/4 v8, 0x2

    const/16 v9, 0x14

    const/4 v10, 0x2

    invoke-virtual {v2, v3, v8, v9, v10}, Landroid/view/View;->setPadding(IIII)V

    .line 345
    iget-object v2, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llSub:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v0}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    .line 340
    add-int/lit8 v0, v0, 0x1

    goto :goto_e

    .line 89
    :cond_8
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;

    move-object v6, v0

    goto/16 :goto_0

    .line 114
    :cond_9
    :try_start_1
    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "bgColor"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_b

    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "bgColor"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 115
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlHeader:Landroid/widget/RelativeLayout;

    const v1, 0x7f0200c3

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_3

    .line 536
    :catch_0
    move-exception v0

    .line 537
    invoke-virtual {v0}, Lorg/json/JSONException;->printStackTrace()V

    .line 540
    :cond_a
    :goto_f
    return-object p2

    .line 117
    :cond_b
    :try_start_2
    const-string v0, "footer"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_c

    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_c

    .line 118
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlHeader:Landroid/widget/RelativeLayout;

    const v1, 0x7f0200c5

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    goto/16 :goto_3

    .line 121
    :cond_c
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlHeader:Landroid/widget/RelativeLayout;

    const v1, 0x7f0200c4

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    goto/16 :goto_3

    .line 124
    :cond_d
    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "bgColor"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_e

    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "bgColor"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_e

    .line 125
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlHeader:Landroid/widget/RelativeLayout;

    const v1, 0x7f0200c1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    goto/16 :goto_3

    .line 128
    :cond_e
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlHeader:Landroid/widget/RelativeLayout;

    const v1, 0x7f0200c2

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    goto/16 :goto_3

    .line 135
    :cond_f
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->ivH:Landroid/widget/ImageView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_4

    .line 155
    :cond_10
    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "object2"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "object1"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 156
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvMainH:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_5

    .line 175
    :cond_11
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvSubH:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_6

    .line 179
    :cond_12
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlHeader:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto/16 :goto_6

    .line 194
    :cond_13
    const-string v0, "footer"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_14

    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_14

    .line 195
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlMain:Landroid/widget/RelativeLayout;

    const v1, 0x7f0200c3

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    goto/16 :goto_7

    .line 196
    :cond_14
    const-string v0, "footer"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_15

    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_15

    .line 197
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlMain:Landroid/widget/RelativeLayout;

    const v1, 0x7f0200be

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    goto/16 :goto_7

    .line 199
    :cond_15
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlMain:Landroid/widget/RelativeLayout;

    const v1, 0x7f0200c1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    goto/16 :goto_7

    .line 202
    :cond_16
    const-string v0, "footer"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_17

    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_17

    .line 203
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlMain:Landroid/widget/RelativeLayout;

    const v1, 0x7f0200c5

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    goto/16 :goto_7

    .line 204
    :cond_17
    const-string v0, "footer"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_18

    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_18

    .line 205
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlMain:Landroid/widget/RelativeLayout;

    const v1, 0x7f0200c4

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    goto/16 :goto_7

    .line 206
    :cond_18
    const-string v0, "footer"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_19

    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_19

    .line 207
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlMain:Landroid/widget/RelativeLayout;

    const v1, 0x7f0200bf

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    goto/16 :goto_7

    .line 209
    :cond_19
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlMain:Landroid/widget/RelativeLayout;

    const v1, 0x7f0200c2

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    goto/16 :goto_7

    .line 212
    :cond_1a
    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "bgColor"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1b

    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "bgColor"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1b

    .line 213
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlMain:Landroid/widget/RelativeLayout;

    const v1, 0x7f0200c1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    goto/16 :goto_7

    .line 216
    :cond_1b
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlMain:Landroid/widget/RelativeLayout;

    const v1, 0x7f0200c2

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    goto/16 :goto_7

    .line 230
    :cond_1c
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->ivM:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 231
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->ivQM:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 232
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v0

    const-string v1, "main"

    invoke-virtual {v7, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "thumbnail"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "url"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iget-object v2, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->ivM:Landroid/widget/ImageView;

    invoke-virtual {v0, v1, v2}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    goto/16 :goto_8

    .line 240
    :cond_1d
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->ivQM:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_9

    .line 245
    :cond_1e
    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "subLinks"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    .line 246
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llSub:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 247
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llSub:Landroid/widget/LinearLayout;

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 248
    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v0

    const/4 v2, 0x1

    if-le v0, v2, :cond_21

    .line 249
    const/4 v0, 0x0

    :goto_10
    const/4 v2, 0x3

    if-ge v0, v2, :cond_7

    .line 250
    new-instance v2, Landroid/widget/TextView;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;->ctx:Landroid/content/Context;

    invoke-direct {v2, v3}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 252
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;

    new-instance v8, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v9, 0x0

    const/4 v10, -0x2

    invoke-direct {v8, v9, v10}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-direct {v3, v8}, Landroid/widget/LinearLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$MarginLayoutParams;)V

    .line 255
    const/high16 v8, 0x3f800000    # 1.0f

    iput v8, v3, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    .line 256
    const/16 v8, 0x14

    const/4 v9, 0x2

    const/16 v10, 0x14

    const/4 v11, 0x2

    invoke-virtual {v2, v8, v9, v10, v11}, Landroid/widget/TextView;->setPadding(IIII)V

    .line 257
    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 259
    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-gt v3, v0, :cond_1f

    .line 260
    iget-object v3, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llSub:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 249
    :goto_11
    add-int/lit8 v0, v0, 0x1

    goto :goto_10

    .line 264
    :cond_1f
    invoke-virtual {v1, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 265
    const-string v8, "title"

    invoke-virtual {v3, v8}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_20

    .line 266
    const-string v8, "title"

    invoke-virtual {v3, v8}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v2, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 268
    :cond_20
    iget-object v8, p0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;->ctx:Landroid/content/Context;

    invoke-virtual {v8}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    const v9, 0x7f060015

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getColor(I)I

    move-result v8

    invoke-virtual {v2, v8}, Landroid/widget/TextView;->setTextColor(I)V

    .line 269
    const/high16 v8, 0x41500000    # 13.0f

    invoke-virtual {v2, v8}, Landroid/widget/TextView;->setTextSize(F)V

    .line 270
    const/4 v8, 0x1

    invoke-virtual {v2, v8}, Landroid/widget/TextView;->setGravity(I)V

    .line 271
    const/4 v8, 0x0

    const/4 v9, 0x1

    invoke-virtual {v2, v8, v9}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 272
    new-instance v8, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;

    iget-object v9, p0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;->ctx:Landroid/content/Context;

    const/4 v10, 0x0

    invoke-direct {v8, v9, v3, v4, v10}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;-><init>(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    invoke-virtual {v2, v8}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 274
    iget-object v3, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llSub:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto :goto_11

    .line 277
    :cond_21
    const/4 v0, 0x0

    invoke-virtual {v1, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v1

    .line 278
    const/4 v0, 0x0

    .line 279
    const-string v2, "align"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_22

    .line 280
    const-string v0, "align"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v0

    .line 282
    :cond_22
    new-instance v2, Landroid/widget/TextView;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;->ctx:Landroid/content/Context;

    invoke-direct {v2, v3}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 283
    const/4 v3, 0x1

    if-ne v0, v3, :cond_24

    .line 284
    const/4 v0, 0x3

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setGravity(I)V

    .line 289
    :goto_12
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;

    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v8, 0x0

    const/4 v9, -0x2

    invoke-direct {v3, v8, v9}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-direct {v0, v3}, Landroid/widget/LinearLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$MarginLayoutParams;)V

    .line 291
    const/high16 v3, 0x3f800000    # 1.0f

    iput v3, v0, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    .line 292
    const/16 v3, 0x14

    const/4 v8, 0x2

    const/16 v9, 0x14

    const/4 v10, 0x2

    invoke-virtual {v2, v3, v8, v9, v10}, Landroid/widget/TextView;->setPadding(IIII)V

    .line 293
    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 295
    const-string v0, "title"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_23

    .line 296
    const-string v0, "title"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 297
    :cond_23
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;->ctx:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v3, 0x7f060015

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setTextColor(I)V

    .line 298
    const/high16 v0, 0x41500000    # 13.0f

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setTextSize(F)V

    .line 299
    const/4 v0, 0x0

    const/4 v3, 0x1

    invoke-virtual {v2, v0, v3}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 300
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;->ctx:Landroid/content/Context;

    const/4 v8, 0x0

    invoke-direct {v0, v3, v1, v4, v8}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;-><init>(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 302
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llSub:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto/16 :goto_a

    .line 285
    :cond_24
    const/4 v3, 0x2

    if-ne v0, v3, :cond_25

    .line 286
    const/4 v0, 0x5

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setGravity(I)V

    goto :goto_12

    .line 288
    :cond_25
    const/4 v0, 0x1

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setGravity(I)V

    goto :goto_12

    .line 309
    :cond_26
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvMainM:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setWidth(I)V

    .line 310
    new-instance v0, Landroid/widget/RelativeLayout$LayoutParams;

    new-instance v1, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v2, -0x1

    const/4 v3, -0x2

    invoke-direct {v1, v2, v3}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-direct {v0, v1}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$MarginLayoutParams;)V

    .line 312
    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    .line 313
    const-string v1, "main"

    invoke-virtual {v7, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "thumbnail"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_27

    .line 314
    const/4 v1, 0x1

    const v2, 0x7f070109

    invoke-virtual {v0, v1, v2}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(II)V

    .line 317
    :goto_13
    const/16 v1, 0xf

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    .line 318
    iget-object v1, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llSub:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    goto/16 :goto_b

    .line 316
    :cond_27
    const/16 v1, 0x9

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout$LayoutParams;->addRule(I)V

    goto :goto_13

    .line 325
    :cond_28
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvSubM:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_c

    .line 332
    :cond_29
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvSideM:Landroid/widget/TextView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_d

    .line 349
    :cond_2a
    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "snippet"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2c

    .line 350
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llMusic:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 351
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvMainM:Landroid/widget/TextView;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 352
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvSubM:Landroid/widget/TextView;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 353
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvSideM:Landroid/widget/TextView;

    const-string v1, ""

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 354
    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "snippet"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v8

    .line 355
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llMusic:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 356
    const/4 v0, 0x0

    move v3, v0

    :goto_14
    invoke-virtual {v8}, Lorg/json/JSONArray;->length()I

    move-result v0

    if-ge v3, v0, :cond_2d

    .line 357
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;->ctx:Landroid/content/Context;

    const-string v1, "layout_inflater"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    const v1, 0x7f03004d

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v9

    .line 359
    const v0, 0x7f070120

    invoke-virtual {v9, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 360
    const v1, 0x7f070121

    invoke-virtual {v9, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 361
    const v2, 0x7f07011e

    invoke-virtual {v9, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    .line 363
    const/16 v10, 0x8

    invoke-virtual {v2, v10}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 364
    const/16 v2, 0x8

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 366
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    add-int/lit8 v2, v3, 0x1

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ". "

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v8, v3}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v2

    const-string v10, "text"

    invoke-virtual {v2, v10}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 368
    invoke-virtual {v8}, Lorg/json/JSONArray;->length()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    if-ne v3, v0, :cond_2b

    .line 369
    const v0, 0x7f07011f

    invoke-virtual {v9, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 370
    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 373
    :cond_2b
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llMusic:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v9}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 356
    add-int/lit8 v0, v3, 0x1

    move v3, v0

    goto :goto_14

    .line 378
    :cond_2c
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llMusic:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 450
    :cond_2d
    :goto_15
    const-string v0, "footer"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_4a

    .line 451
    const-string v0, "footer"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "links"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    .line 452
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llFooter:Landroid/widget/LinearLayout;

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 454
    if-eqz v5, :cond_41

    .line 455
    const-string v0, "footer"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v2, "bgColor"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3e

    const-string v0, "footer"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v2, "bgColor"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3e

    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3e

    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3e

    .line 456
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llFooter:Landroid/widget/LinearLayout;

    const v2, 0x7f0200c0

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setBackgroundResource(I)V

    .line 475
    :goto_16
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llFooter:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 476
    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v0

    const/4 v2, 0x1

    if-le v0, v2, :cond_45

    .line 477
    const/4 v0, 0x0

    :goto_17
    const/4 v2, 0x3

    if-ge v0, v2, :cond_a

    .line 478
    new-instance v2, Landroid/widget/TextView;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;->ctx:Landroid/content/Context;

    invoke-direct {v2, v3}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 480
    const/4 v3, 0x1

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setGravity(I)V

    .line 481
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;

    new-instance v5, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v7, 0x0

    const/4 v8, -0x2

    invoke-direct {v5, v7, v8}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-direct {v3, v5}, Landroid/widget/LinearLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$MarginLayoutParams;)V

    .line 483
    const/high16 v5, 0x3f800000    # 1.0f

    iput v5, v3, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    .line 484
    const/16 v5, 0x14

    const/4 v7, 0x2

    const/16 v8, 0x14

    const/4 v9, 0x2

    invoke-virtual {v2, v5, v7, v8, v9}, Landroid/widget/TextView;->setPadding(IIII)V

    .line 485
    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 487
    invoke-virtual {v1}, Lorg/json/JSONArray;->length()I

    move-result v3

    if-lt v0, v3, :cond_43

    .line 488
    iget-object v3, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llFooter:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 477
    :goto_18
    add-int/lit8 v0, v0, 0x1

    goto :goto_17

    .line 382
    :cond_2e
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlImage:Landroid/widget/RelativeLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 383
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlMain:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 385
    if-eqz v5, :cond_38

    .line 386
    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "bgColor"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_34

    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "bgColor"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_34

    .line 387
    const-string v0, "footer"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_31

    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_31

    .line 388
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlImage:Landroid/widget/RelativeLayout;

    const v1, 0x7f0200c0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 414
    :goto_19
    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "mainLink"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_2f

    .line 415
    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "mainLink"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    .line 416
    iget-object v1, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlImage:Landroid/widget/RelativeLayout;

    new-instance v2, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;->ctx:Landroid/content/Context;

    const/4 v8, 0x0

    invoke-direct {v2, v3, v0, v4, v8}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;-><init>(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 420
    :cond_2f
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v0

    const-string v1, "main"

    invoke-virtual {v7, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "thumbnail"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "url"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iget-object v2, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->ivB:Landroid/widget/ImageView;

    invoke-virtual {v0, v1, v2}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 423
    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "mainLink"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_30

    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "mainLink"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "type"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_30

    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "mainLink"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "type"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "music"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3a

    .line 424
    :cond_30
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->ivQB:Landroid/widget/ImageView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 429
    :goto_1a
    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "mainText"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3b

    .line 430
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvMain:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 431
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvMain:Landroid/widget/TextView;

    const-string v1, "main"

    invoke-virtual {v7, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "mainText"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 436
    :goto_1b
    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "subText"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3c

    .line 437
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvSub:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 438
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvSub:Landroid/widget/TextView;

    const-string v1, "main"

    invoke-virtual {v7, v1}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v1

    const-string v2, "subText"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_15

    .line 389
    :cond_31
    const-string v0, "footer"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_32

    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_32

    .line 390
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlImage:Landroid/widget/RelativeLayout;

    const v1, 0x7f0200c3

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    goto/16 :goto_19

    .line 391
    :cond_32
    const-string v0, "footer"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_33

    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_33

    .line 392
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlImage:Landroid/widget/RelativeLayout;

    const v1, 0x7f0200be

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    goto/16 :goto_19

    .line 394
    :cond_33
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlImage:Landroid/widget/RelativeLayout;

    const v1, 0x7f0200c1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    goto/16 :goto_19

    .line 397
    :cond_34
    const-string v0, "footer"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_35

    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_35

    .line 398
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlImage:Landroid/widget/RelativeLayout;

    const v1, 0x7f0200c5

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    goto/16 :goto_19

    .line 399
    :cond_35
    const-string v0, "footer"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_36

    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_36

    .line 400
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlImage:Landroid/widget/RelativeLayout;

    const v1, 0x7f0200c4

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    goto/16 :goto_19

    .line 401
    :cond_36
    const-string v0, "footer"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_37

    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_37

    .line 402
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlImage:Landroid/widget/RelativeLayout;

    const v1, 0x7f0200bf

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    goto/16 :goto_19

    .line 404
    :cond_37
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlImage:Landroid/widget/RelativeLayout;

    const v1, 0x7f0200c2

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    goto/16 :goto_19

    .line 407
    :cond_38
    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "bgColor"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_39

    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v1, "bgColor"

    invoke-virtual {v0, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_39

    .line 408
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlImage:Landroid/widget/RelativeLayout;

    const v1, 0x7f0200c1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    goto/16 :goto_19

    .line 411
    :cond_39
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlImage:Landroid/widget/RelativeLayout;

    const v1, 0x7f0200c2

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    goto/16 :goto_19

    .line 427
    :cond_3a
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->ivQB:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    goto/16 :goto_1a

    .line 433
    :cond_3b
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvMain:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_1b

    .line 440
    :cond_3c
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->tvSub:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_15

    .line 446
    :cond_3d
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlImage:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 447
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->rlMain:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto/16 :goto_15

    .line 458
    :cond_3e
    const-string v0, "footer"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v2, "bgColor"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3f

    const-string v0, "footer"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v2, "bgColor"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3f

    .line 459
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llFooter:Landroid/widget/LinearLayout;

    const v2, 0x7f0200be

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setBackgroundResource(I)V

    goto/16 :goto_16

    .line 461
    :cond_3f
    const-string v0, "header"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_40

    const-string v0, "main"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_40

    .line 462
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llFooter:Landroid/widget/LinearLayout;

    const v2, 0x7f0200c5

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setBackgroundResource(I)V

    goto/16 :goto_16

    .line 465
    :cond_40
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llFooter:Landroid/widget/LinearLayout;

    const v2, 0x7f0200bf

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setBackgroundResource(I)V

    goto/16 :goto_16

    .line 468
    :cond_41
    const-string v0, "footer"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v2, "bgColor"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_42

    const-string v0, "footer"

    invoke-virtual {v7, v0}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v0

    const-string v2, "bgColor"

    invoke-virtual {v0, v2}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_42

    .line 469
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llFooter:Landroid/widget/LinearLayout;

    const v2, 0x7f0200c1

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setBackgroundResource(I)V

    goto/16 :goto_16

    .line 472
    :cond_42
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llFooter:Landroid/widget/LinearLayout;

    const v2, 0x7f0200c2

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setBackgroundResource(I)V

    goto/16 :goto_16

    .line 492
    :cond_43
    invoke-virtual {v1, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v3

    .line 493
    const-string v5, "title"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_44

    .line 494
    const-string v5, "title"

    invoke-virtual {v3, v5}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v2, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 495
    :cond_44
    iget-object v5, p0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;->ctx:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v7, 0x7f06001e

    invoke-virtual {v5, v7}, Landroid/content/res/Resources;->getColor(I)I

    move-result v5

    invoke-virtual {v2, v5}, Landroid/widget/TextView;->setTextColor(I)V

    .line 496
    const/high16 v5, 0x41500000    # 13.0f

    invoke-virtual {v2, v5}, Landroid/widget/TextView;->setTextSize(F)V

    .line 497
    const/4 v5, 0x0

    const/4 v7, 0x1

    invoke-virtual {v2, v5, v7}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 498
    new-instance v5, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;

    iget-object v7, p0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;->ctx:Landroid/content/Context;

    const/4 v8, 0x0

    invoke-direct {v5, v7, v3, v4, v8}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;-><init>(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    invoke-virtual {v2, v5}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 500
    iget-object v3, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llFooter:Landroid/widget/LinearLayout;

    invoke-virtual {v3, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto/16 :goto_18

    .line 504
    :cond_45
    const/4 v0, 0x0

    invoke-virtual {v1, v0}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v1

    .line 505
    const/4 v0, 0x0

    .line 506
    const-string v2, "align"

    invoke-virtual {v1, v2}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_46

    .line 507
    const-string v0, "align"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->getInt(Ljava/lang/String;)I

    move-result v0

    .line 509
    :cond_46
    new-instance v2, Landroid/widget/TextView;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;->ctx:Landroid/content/Context;

    invoke-direct {v2, v3}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 510
    const/4 v3, 0x1

    if-ne v0, v3, :cond_48

    .line 511
    const/4 v0, 0x3

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setGravity(I)V

    .line 516
    :goto_1c
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;

    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v5, 0x0

    const/4 v7, -0x2

    invoke-direct {v3, v5, v7}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    invoke-direct {v0, v3}, Landroid/widget/LinearLayout$LayoutParams;-><init>(Landroid/view/ViewGroup$MarginLayoutParams;)V

    .line 518
    const/high16 v3, 0x3f800000    # 1.0f

    iput v3, v0, Landroid/widget/LinearLayout$LayoutParams;->weight:F

    .line 519
    const/16 v3, 0x14

    const/4 v5, 0x2

    const/16 v7, 0x14

    const/4 v8, 0x2

    invoke-virtual {v2, v3, v5, v7, v8}, Landroid/widget/TextView;->setPadding(IIII)V

    .line 520
    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 522
    const-string v0, "title"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->isNull(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_47

    .line 523
    const-string v0, "title"

    invoke-virtual {v1, v0}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 524
    :cond_47
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;->ctx:Landroid/content/Context;

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v3, 0x7f06001e

    invoke-virtual {v0, v3}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setTextColor(I)V

    .line 525
    const/high16 v0, 0x41500000    # 13.0f

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setTextSize(F)V

    .line 526
    const/4 v0, 0x0

    const/4 v3, 0x1

    invoke-virtual {v2, v0, v3}, Landroid/widget/TextView;->setTypeface(Landroid/graphics/Typeface;I)V

    .line 527
    new-instance v0, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;

    iget-object v3, p0, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem;->ctx:Landroid/content/Context;

    const/4 v5, 0x0

    invoke-direct {v0, v3, v1, v4, v5}, Lcom/mixerbox/mixerbox3b/classes/VectorOnClickListener;-><init>(Landroid/content/Context;Lorg/json/JSONObject;Lorg/json/JSONObject;Lorg/json/JSONObject;)V

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 529
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llFooter:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto/16 :goto_f

    .line 512
    :cond_48
    const/4 v3, 0x2

    if-ne v0, v3, :cond_49

    .line 513
    const/4 v0, 0x5

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setGravity(I)V

    goto :goto_1c

    .line 515
    :cond_49
    const/4 v0, 0x1

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setGravity(I)V

    goto :goto_1c

    .line 533
    :cond_4a
    iget-object v0, v6, Lcom/mixerbox/mixerbox3b/classes/GeneralVectorItem$ViewHolder;->llFooter:Landroid/widget/LinearLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0

    goto/16 :goto_f

    :cond_4b
    move-object v4, v0

    goto/16 :goto_2

    :cond_4c
    move v5, v0

    goto/16 :goto_1
.end method

.method public getViewType()I
    .locals 1

    .prologue
    .line 36
    sget-object v0, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter$RowType;->GENERAL_ITEM:Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter$RowType;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/adapters/VectorAdapter$RowType;->ordinal()I

    move-result v0

    return v0
.end method
