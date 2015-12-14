.class public Lcom/livemixtapes/MixtapeList$MixtapeListAdapter;
.super Landroid/widget/BaseAdapter;
.source "MixtapeList.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/livemixtapes/MixtapeList;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "MixtapeListAdapter"
.end annotation


# instance fields
.field private activity:Landroid/app/Activity;

.field private inflater:Landroid/view/LayoutInflater;

.field final synthetic this$0:Lcom/livemixtapes/MixtapeList;


# direct methods
.method public constructor <init>(Lcom/livemixtapes/MixtapeList;Landroid/app/Activity;)V
    .locals 0
    .param p2, "activity"    # Landroid/app/Activity;

    .prologue
    .line 168
    iput-object p1, p0, Lcom/livemixtapes/MixtapeList$MixtapeListAdapter;->this$0:Lcom/livemixtapes/MixtapeList;

    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 169
    iput-object p2, p0, Lcom/livemixtapes/MixtapeList$MixtapeListAdapter;->activity:Landroid/app/Activity;

    .line 170
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 174
    iget-object v0, p0, Lcom/livemixtapes/MixtapeList$MixtapeListAdapter;->this$0:Lcom/livemixtapes/MixtapeList;

    iget-object v0, v0, Lcom/livemixtapes/MixtapeList;->mixtapeList:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "location"    # I

    .prologue
    .line 179
    iget-object v0, p0, Lcom/livemixtapes/MixtapeList$MixtapeListAdapter;->this$0:Lcom/livemixtapes/MixtapeList;

    iget-object v0, v0, Lcom/livemixtapes/MixtapeList;->mixtapeList:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 184
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 10
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 190
    iget-object v7, p0, Lcom/livemixtapes/MixtapeList$MixtapeListAdapter;->inflater:Landroid/view/LayoutInflater;

    if-nez v7, :cond_0

    .line 191
    iget-object v7, p0, Lcom/livemixtapes/MixtapeList$MixtapeListAdapter;->activity:Landroid/app/Activity;

    .line 192
    const-string v8, "layout_inflater"

    invoke-virtual {v7, v8}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/view/LayoutInflater;

    .line 191
    iput-object v7, p0, Lcom/livemixtapes/MixtapeList$MixtapeListAdapter;->inflater:Landroid/view/LayoutInflater;

    .line 193
    :cond_0
    iget-object v7, p0, Lcom/livemixtapes/MixtapeList$MixtapeListAdapter;->inflater:Landroid/view/LayoutInflater;

    const v8, 0x7f030028

    const/4 v9, 0x0

    invoke-virtual {v7, v8, v9}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 195
    iget-object v7, p0, Lcom/livemixtapes/MixtapeList$MixtapeListAdapter;->this$0:Lcom/livemixtapes/MixtapeList;

    iget-object v7, v7, Lcom/livemixtapes/MixtapeList;->mixtapeList:Ljava/util/ArrayList;

    invoke-virtual {v7, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/util/Map;

    .line 197
    .local v3, "mixtape":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v7, p0, Lcom/livemixtapes/MixtapeList$MixtapeListAdapter;->activity:Landroid/app/Activity;

    invoke-virtual {v7}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v7

    const-string v8, "window"

    invoke-virtual {v7, v8}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/view/WindowManager;

    invoke-interface {v7}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    .line 198
    .local v0, "display":Landroid/view/Display;
    new-instance v4, Landroid/util/DisplayMetrics;

    invoke-direct {v4}, Landroid/util/DisplayMetrics;-><init>()V

    .line 199
    .local v4, "outMetrics":Landroid/util/DisplayMetrics;
    invoke-virtual {v0, v4}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 200
    iget v7, v4, Landroid/util/DisplayMetrics;->widthPixels:I

    int-to-float v5, v7

    .line 202
    .local v5, "scWidth":F
    const v7, 0x7f0800ba

    invoke-virtual {p2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    .line 203
    .local v2, "imageView":Landroid/widget/ImageView;
    invoke-virtual {v2}, Landroid/widget/ImageView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v7

    const v8, 0x3e19999a    # 0.15f

    mul-float/2addr v8, v5

    float-to-int v8, v8

    iput v8, v7, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 204
    const v7, 0x7f0800bb

    invoke-virtual {p2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    .line 206
    .local v6, "title":Landroid/widget/TextView;
    invoke-static {v3}, Lcom/livemixtapes/Utils;->getArtistAndTitle(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 207
    iget-object v7, p0, Lcom/livemixtapes/MixtapeList$MixtapeListAdapter;->this$0:Lcom/livemixtapes/MixtapeList;

    iget-object v7, v7, Lcom/livemixtapes/MixtapeList;->imageLoader:Lcom/livemixtapes/ImageLoader;

    const-string v8, "thumbnail"

    invoke-interface {v3, v8}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8, v2}, Lcom/livemixtapes/ImageLoader;->DisplayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 209
    const v7, 0x7f0800b9

    invoke-virtual {p2, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/livemixtapes/ui/widgets/DjBadgesView;

    .line 210
    .local v1, "djs":Lcom/livemixtapes/ui/widgets/DjBadgesView;
    const-string v7, "DJ"

    invoke-interface {v3, v7}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    const-string v8, ","

    invoke-virtual {v7, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v7

    const/4 v8, 0x0

    invoke-virtual {v1, v7, v8}, Lcom/livemixtapes/ui/widgets/DjBadgesView;->loadDjs([Ljava/lang/String;Z)V

    .line 212
    return-object p2
.end method
