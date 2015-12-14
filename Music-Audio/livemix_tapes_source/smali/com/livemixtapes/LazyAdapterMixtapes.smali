.class public Lcom/livemixtapes/LazyAdapterMixtapes;
.super Landroid/widget/BaseAdapter;
.source "LazyAdapterMixtapes.java"


# static fields
.field private static inflater:Landroid/view/LayoutInflater;


# instance fields
.field private activity:Landroid/app/Activity;

.field public data:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;>;"
        }
    .end annotation
.end field

.field public imageLoader:Lcom/livemixtapes/ImageLoader;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 26
    const/4 v0, 0x0

    sput-object v0, Lcom/livemixtapes/LazyAdapterMixtapes;->inflater:Landroid/view/LayoutInflater;

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Ljava/util/ArrayList;)V
    .locals 2
    .param p1, "a"    # Landroid/app/Activity;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 29
    .local p2, "d":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 34
    iput-object p1, p0, Lcom/livemixtapes/LazyAdapterMixtapes;->activity:Landroid/app/Activity;

    .line 35
    iput-object p2, p0, Lcom/livemixtapes/LazyAdapterMixtapes;->data:Ljava/util/ArrayList;

    .line 36
    iget-object v0, p0, Lcom/livemixtapes/LazyAdapterMixtapes;->activity:Landroid/app/Activity;

    const-string v1, "layout_inflater"

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    sput-object v0, Lcom/livemixtapes/LazyAdapterMixtapes;->inflater:Landroid/view/LayoutInflater;

    .line 37
    new-instance v0, Lcom/livemixtapes/ImageLoader;

    iget-object v1, p0, Lcom/livemixtapes/LazyAdapterMixtapes;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/livemixtapes/ImageLoader;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/livemixtapes/LazyAdapterMixtapes;->imageLoader:Lcom/livemixtapes/ImageLoader;

    .line 38
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/livemixtapes/LazyAdapterMixtapes;->data:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 52
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 56
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 11
    .param p1, "position"    # I
    .param p2, "view"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 60
    if-nez p2, :cond_0

    .line 61
    sget-object v8, Lcom/livemixtapes/App;->viewStyle:Ljava/lang/String;

    const-string v9, "list"

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 63
    sget-object v8, Lcom/livemixtapes/LazyAdapterMixtapes;->inflater:Landroid/view/LayoutInflater;

    const v9, 0x7f030028

    const/4 v10, 0x0

    invoke-virtual {v8, v9, v10}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 71
    :cond_0
    :goto_0
    const v8, 0x7f0800bb

    invoke-virtual {p2, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/TextView;

    .line 72
    .local v7, "text":Landroid/widget/TextView;
    const v8, 0x7f0800ba

    invoke-virtual {p2, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    .line 73
    .local v3, "image":Landroid/widget/ImageView;
    const v8, 0x7f0800b9

    invoke-virtual {p2, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/livemixtapes/ui/widgets/DjBadgesView;

    .line 75
    .local v1, "djs":Lcom/livemixtapes/ui/widgets/DjBadgesView;
    iget-object v8, p0, Lcom/livemixtapes/LazyAdapterMixtapes;->data:Ljava/util/ArrayList;

    invoke-virtual {v8, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/Map;

    invoke-static {v8}, Lcom/livemixtapes/Utils;->getArtistAndTitle(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 77
    iget-object v8, p0, Lcom/livemixtapes/LazyAdapterMixtapes;->data:Ljava/util/ArrayList;

    invoke-virtual {v8, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/HashMap;

    const-string v9, "featured"

    invoke-virtual {v8, v9}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    const-string v9, "1"

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    .line 79
    .local v2, "featured":Z
    iget-object v8, p0, Lcom/livemixtapes/LazyAdapterMixtapes;->data:Ljava/util/ArrayList;

    invoke-virtual {v8, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/HashMap;

    const-string v9, "site"

    invoke-virtual {v8, v9}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_2

    iget-object v8, p0, Lcom/livemixtapes/LazyAdapterMixtapes;->data:Ljava/util/ArrayList;

    invoke-virtual {v8, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/HashMap;

    const-string v9, "site"

    invoke-virtual {v8, v9}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v6

    .line 80
    .local v6, "site":Ljava/lang/String;
    :goto_1
    const-string v8, "club"

    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    .line 81
    .local v0, "club":Z
    const-string v8, "indy"

    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    .line 83
    .local v5, "indy":Z
    const v8, 0x7f0800be

    invoke-virtual {p2, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    if-eqz v2, :cond_3

    const/4 v8, 0x0

    :goto_2
    invoke-virtual {v9, v8}, Landroid/view/View;->setVisibility(I)V

    .line 84
    const v8, 0x7f0800bd

    invoke-virtual {p2, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    if-eqz v0, :cond_4

    const/4 v8, 0x0

    :goto_3
    invoke-virtual {v9, v8}, Landroid/view/View;->setVisibility(I)V

    .line 85
    const v8, 0x7f0800bc

    invoke-virtual {p2, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v9

    if-eqz v5, :cond_5

    const/4 v8, 0x0

    :goto_4
    invoke-virtual {v9, v8}, Landroid/view/View;->setVisibility(I)V

    .line 87
    sget-object v8, Lcom/livemixtapes/App;->viewStyle:Ljava/lang/String;

    const-string v9, "grid"

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_6

    const-string v4, "cover"

    .line 88
    .local v4, "imageKey":Ljava/lang/String;
    :goto_5
    iget-object v9, p0, Lcom/livemixtapes/LazyAdapterMixtapes;->imageLoader:Lcom/livemixtapes/ImageLoader;

    iget-object v8, p0, Lcom/livemixtapes/LazyAdapterMixtapes;->data:Ljava/util/ArrayList;

    invoke-virtual {v8, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/HashMap;

    invoke-virtual {v8, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v9, v8, v3}, Lcom/livemixtapes/ImageLoader;->DisplayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 90
    iget-object v8, p0, Lcom/livemixtapes/LazyAdapterMixtapes;->data:Ljava/util/ArrayList;

    invoke-virtual {v8, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/HashMap;

    const-string v9, "DJ"

    invoke-virtual {v8, v9}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    const-string v9, ","

    invoke-virtual {v8, v9}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v8

    sget-object v9, Lcom/livemixtapes/App;->viewStyle:Ljava/lang/String;

    const-string v10, "grid"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v9

    invoke-virtual {v1, v8, v9}, Lcom/livemixtapes/ui/widgets/DjBadgesView;->loadDjs([Ljava/lang/String;Z)V

    .line 92
    return-object p2

    .line 65
    .end local v0    # "club":Z
    .end local v1    # "djs":Lcom/livemixtapes/ui/widgets/DjBadgesView;
    .end local v2    # "featured":Z
    .end local v3    # "image":Landroid/widget/ImageView;
    .end local v4    # "imageKey":Ljava/lang/String;
    .end local v5    # "indy":Z
    .end local v6    # "site":Ljava/lang/String;
    .end local v7    # "text":Landroid/widget/TextView;
    :cond_1
    sget-object v8, Lcom/livemixtapes/App;->viewStyle:Ljava/lang/String;

    const-string v9, "grid"

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_0

    .line 67
    sget-object v8, Lcom/livemixtapes/LazyAdapterMixtapes;->inflater:Landroid/view/LayoutInflater;

    const v9, 0x7f030026

    const/4 v10, 0x0

    invoke-virtual {v8, v9, v10}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    goto/16 :goto_0

    .line 79
    .restart local v1    # "djs":Lcom/livemixtapes/ui/widgets/DjBadgesView;
    .restart local v2    # "featured":Z
    .restart local v3    # "image":Landroid/widget/ImageView;
    .restart local v7    # "text":Landroid/widget/TextView;
    :cond_2
    const-string v6, ""

    goto/16 :goto_1

    .line 83
    .restart local v0    # "club":Z
    .restart local v5    # "indy":Z
    .restart local v6    # "site":Ljava/lang/String;
    :cond_3
    const/16 v8, 0x8

    goto :goto_2

    .line 84
    :cond_4
    const/16 v8, 0x8

    goto :goto_3

    .line 85
    :cond_5
    const/16 v8, 0x8

    goto :goto_4

    .line 87
    :cond_6
    const-string v4, "thumbnail"

    goto :goto_5
.end method

.method public setData(Landroid/app/Activity;Ljava/util/ArrayList;)V
    .locals 2
    .param p1, "a"    # Landroid/app/Activity;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 45
    .local p2, "d":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    iput-object p1, p0, Lcom/livemixtapes/LazyAdapterMixtapes;->activity:Landroid/app/Activity;

    .line 46
    iput-object p2, p0, Lcom/livemixtapes/LazyAdapterMixtapes;->data:Ljava/util/ArrayList;

    .line 47
    iget-object v0, p0, Lcom/livemixtapes/LazyAdapterMixtapes;->activity:Landroid/app/Activity;

    const-string v1, "layout_inflater"

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/LayoutInflater;

    sput-object v0, Lcom/livemixtapes/LazyAdapterMixtapes;->inflater:Landroid/view/LayoutInflater;

    .line 48
    new-instance v0, Lcom/livemixtapes/ImageLoader;

    iget-object v1, p0, Lcom/livemixtapes/LazyAdapterMixtapes;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/livemixtapes/ImageLoader;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/livemixtapes/LazyAdapterMixtapes;->imageLoader:Lcom/livemixtapes/ImageLoader;

    .line 49
    return-void
.end method
