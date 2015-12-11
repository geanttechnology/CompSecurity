.class Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;
.super Landroid/widget/ArrayAdapter;
.source "SourceFile"

# interfaces
.implements Landroid/widget/Filterable;


# instance fields
.field private img:Ljava/util/ArrayList;

.field private resultList:Ljava/util/ArrayList;

.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;


# direct methods
.method public constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/content/Context;I)V
    .locals 1

    .prologue
    .line 4020
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    .line 4021
    invoke-direct {p0, p2, p3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;I)V

    .line 4017
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->resultList:Ljava/util/ArrayList;

    .line 4022
    return-void
.end method

.method static synthetic access$1102(Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    .locals 0

    .prologue
    .line 4016
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->resultList:Ljava/util/ArrayList;

    return-object p1
.end method

.method static synthetic access$900(Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 4016
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->img:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic access$902(Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;Ljava/util/ArrayList;)Ljava/util/ArrayList;
    .locals 0

    .prologue
    .line 4016
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->img:Ljava/util/ArrayList;

    return-object p1
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 4026
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->resultList:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    .line 4027
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->resultList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    .line 4028
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getFilter()Landroid/widget/Filter;
    .locals 1

    .prologue
    .line 4080
    new-instance v0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1;

    invoke-direct {v0, p0}, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$1;-><init>(Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;)V

    .line 4138
    return-object v0
.end method

.method public bridge synthetic getItem(I)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 4016
    invoke-virtual {p0, p1}, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->getItem(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getItem(I)Ljava/lang/String;
    .locals 1

    .prologue
    .line 4033
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->resultList:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->resultList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-le v0, p1, :cond_0

    .line 4034
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->resultList:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 4035
    :goto_0
    return-object v0

    :cond_0
    const-string v0, ""

    goto :goto_0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 4046
    if-nez p2, :cond_0

    .line 4047
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    const-string v1, "layout_inflater"

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    .line 4048
    const v1, 0x7f03004e

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 4049
    new-instance v1, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$ViewHolder;

    invoke-direct {v1, p0, v2}, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$ViewHolder;-><init>(Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;Lcom/mixerbox/mixerbox3b/MainPage$1;)V

    .line 4050
    const v0, 0x7f070102

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$ViewHolder;->tv:Landroid/widget/TextView;

    .line 4051
    const v0, 0x7f070100

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, v1, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$ViewHolder;->iv:Landroid/widget/ImageView;

    .line 4052
    invoke-virtual {p2, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 4058
    :goto_0
    :try_start_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->img:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-le v0, p1, :cond_1

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->img:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_1

    .line 4059
    iget-object v0, v1, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$ViewHolder;->tv:Landroid/widget/TextView;

    invoke-virtual {p0, p1}, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->getItem(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 4060
    iget-object v0, v1, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$ViewHolder;->iv:Landroid/widget/ImageView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 4075
    :goto_1
    return-object p2

    .line 4054
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$ViewHolder;

    move-object v1, v0

    goto :goto_0

    .line 4061
    :cond_1
    :try_start_1
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->img:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-le v0, p1, :cond_2

    .line 4062
    iget-object v0, v1, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$ViewHolder;->iv:Landroid/widget/ImageView;

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 4063
    iget-object v0, v1, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$ViewHolder;->tv:Landroid/widget/TextView;

    invoke-virtual {p0, p1}, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->getItem(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 4065
    new-instance v0, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    invoke-direct {v0}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;-><init>()V

    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->cacheInMemory(Z)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v0

    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->cacheOnDisc(Z)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v0

    new-instance v2, Lcom/mixerbox/mixerbox3b/classes/CircleBitmapDisplayer;

    invoke-direct {v2}, Lcom/mixerbox/mixerbox3b/classes/CircleBitmapDisplayer;-><init>()V

    invoke-virtual {v0, v2}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->displayer(Lcom/nostra13/universalimageloader/core/display/BitmapDisplayer;)Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/nostra13/universalimageloader/core/DisplayImageOptions$Builder;->build()Lcom/nostra13/universalimageloader/core/DisplayImageOptions;

    move-result-object v2

    .line 4067
    invoke-static {}, Lcom/nostra13/universalimageloader/core/ImageLoader;->getInstance()Lcom/nostra13/universalimageloader/core/ImageLoader;

    move-result-object v3

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->img:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iget-object v1, v1, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$ViewHolder;->iv:Landroid/widget/ImageView;

    invoke-virtual {v3, v0, v1, v2}, Lcom/nostra13/universalimageloader/core/ImageLoader;->displayImage(Ljava/lang/String;Landroid/widget/ImageView;Lcom/nostra13/universalimageloader/core/DisplayImageOptions;)V

    goto :goto_1

    :catch_0
    move-exception v0

    goto :goto_1

    .line 4069
    :cond_2
    iget-object v0, v1, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$ViewHolder;->iv:Landroid/widget/ImageView;

    const/16 v2, 0x8

    invoke-virtual {v0, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 4070
    iget-object v0, v1, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter$ViewHolder;->tv:Landroid/widget/TextView;

    invoke-virtual {p0, p1}, Lcom/mixerbox/mixerbox3b/MainPage$MixerBoxSearchAutoCompleteAdapter;->getItem(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1
.end method
