.class public Lcom/livemixtapes/WorldFragment$NewsListAdapter;
.super Landroid/widget/BaseAdapter;
.source "WorldFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/WorldFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "NewsListAdapter"
.end annotation


# instance fields
.field private activity:Landroid/app/Activity;

.field private inflater:Landroid/view/LayoutInflater;

.field final synthetic this$0:Lcom/livemixtapes/WorldFragment;


# direct methods
.method public constructor <init>(Lcom/livemixtapes/WorldFragment;Landroid/app/Activity;)V
    .locals 0
    .param p2, "activity"    # Landroid/app/Activity;

    .prologue
    .line 89
    iput-object p1, p0, Lcom/livemixtapes/WorldFragment$NewsListAdapter;->this$0:Lcom/livemixtapes/WorldFragment;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 90
    iput-object p2, p0, Lcom/livemixtapes/WorldFragment$NewsListAdapter;->activity:Landroid/app/Activity;

    .line 91
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/livemixtapes/WorldFragment$NewsListAdapter;->this$0:Lcom/livemixtapes/WorldFragment;

    iget-object v0, v0, Lcom/livemixtapes/WorldFragment;->newsList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "location"    # I

    .prologue
    .line 100
    iget-object v0, p0, Lcom/livemixtapes/WorldFragment$NewsListAdapter;->this$0:Lcom/livemixtapes/WorldFragment;

    iget-object v0, v0, Lcom/livemixtapes/WorldFragment;->newsList:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 105
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 10
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 111
    iget-object v7, p0, Lcom/livemixtapes/WorldFragment$NewsListAdapter;->inflater:Landroid/view/LayoutInflater;

    if-nez v7, :cond_0

    .line 112
    iget-object v7, p0, Lcom/livemixtapes/WorldFragment$NewsListAdapter;->activity:Landroid/app/Activity;

    .line 113
    const-string v8, "layout_inflater"

    invoke-virtual {v7, v8}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/view/LayoutInflater;

    .line 112
    iput-object v7, p0, Lcom/livemixtapes/WorldFragment$NewsListAdapter;->inflater:Landroid/view/LayoutInflater;

    .line 114
    :cond_0
    if-nez p2, :cond_1

    .line 115
    iget-object v7, p0, Lcom/livemixtapes/WorldFragment$NewsListAdapter;->inflater:Landroid/view/LayoutInflater;

    const v8, 0x7f03002b

    .line 116
    const/4 v9, 0x0

    .line 115
    invoke-virtual {v7, v8, v9}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 119
    :cond_1
    const v7, 0x7f0800cf

    invoke-virtual {p2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    .line 118
    check-cast v4, Landroid/widget/TextView;

    .line 121
    .local v4, "titleTv":Landroid/widget/TextView;
    const v7, 0x7f0800cd

    invoke-virtual {p2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    .line 120
    check-cast v2, Landroid/widget/ImageView;

    .line 123
    .local v2, "posterImageView":Landroid/widget/ImageView;
    const v7, 0x7f0800ce

    invoke-virtual {p2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    .line 122
    check-cast v5, Landroid/widget/ImageView;

    .line 125
    .local v5, "websiteImageView":Landroid/widget/ImageView;
    iget-object v7, p0, Lcom/livemixtapes/WorldFragment$NewsListAdapter;->this$0:Lcom/livemixtapes/WorldFragment;

    iget-object v7, v7, Lcom/livemixtapes/WorldFragment;->newsList:Ljava/util/ArrayList;

    invoke-virtual {v7, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/HashMap;

    .line 127
    .local v1, "newsMap":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string v7, "title"

    invoke-virtual {v1, v7}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/CharSequence;

    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 129
    new-instance v0, Lcom/livemixtapes/ImageLoader;

    iget-object v7, p0, Lcom/livemixtapes/WorldFragment$NewsListAdapter;->activity:Landroid/app/Activity;

    invoke-direct {v0, v7}, Lcom/livemixtapes/ImageLoader;-><init>(Landroid/content/Context;)V

    .line 130
    .local v0, "imageLoader":Lcom/livemixtapes/ImageLoader;
    const-string v7, "poster"

    invoke-virtual {v1, v7}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    invoke-virtual {v0, v7, v2}, Lcom/livemixtapes/ImageLoader;->DisplayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 132
    new-instance v8, Ljava/lang/StringBuilder;

    const-string v7, "property_"

    invoke-direct {v8, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v7, "property"

    invoke-virtual {v1, v7}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Ljava/lang/String;

    invoke-virtual {v7}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v8, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    .line 134
    .local v6, "websiteName":Ljava/lang/String;
    :try_start_0
    iget-object v7, p0, Lcom/livemixtapes/WorldFragment$NewsListAdapter;->this$0:Lcom/livemixtapes/WorldFragment;

    invoke-virtual {v7}, Lcom/livemixtapes/WorldFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    .line 135
    const-string v8, "drawable"

    iget-object v9, p0, Lcom/livemixtapes/WorldFragment$NewsListAdapter;->activity:Landroid/app/Activity;

    invoke-virtual {v9}, Landroid/app/Activity;->getPackageName()Ljava/lang/String;

    move-result-object v9

    .line 134
    invoke-virtual {v7, v6, v8, v9}, Landroid/content/res/Resources;->getIdentifier(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)I

    move-result v3

    .line 137
    .local v3, "resId":I
    invoke-virtual {v5, v3}, Landroid/widget/ImageView;->setImageResource(I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 142
    .end local v3    # "resId":I
    :goto_0
    return-object p2

    .line 138
    :catch_0
    move-exception v7

    goto :goto_0
.end method
