.class public Lcom/livemixtapes/adapter/ViewPagerAdapter;
.super Landroid/support/v4/view/PagerAdapter;
.source "ViewPagerAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/livemixtapes/adapter/ViewPagerAdapter$PagerCallbacks;,
        Lcom/livemixtapes/adapter/ViewPagerAdapter$ReleaseTimer;
    }
.end annotation


# static fields
.field private static final DAY:I = 0x5265c00

.field private static final HOUR:I = 0x36ee80

.field private static final MINUTE:I = 0xea60

.field private static final SECOND:I = 0x3e8


# instance fields
.field private callbacks:Lcom/livemixtapes/adapter/ViewPagerAdapter$PagerCallbacks;

.field context:Landroid/content/Context;

.field data:Ljava/util/ArrayList;
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

.field inflater:Landroid/view/LayoutInflater;

.field private timers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Landroid/os/CountDownTimer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/ArrayList;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
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
    .line 48
    .local p2, "data":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;>;"
    invoke-direct {p0}, Landroid/support/v4/view/PagerAdapter;-><init>()V

    .line 35
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter;->timers:Ljava/util/List;

    .line 43
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter;->data:Ljava/util/ArrayList;

    .line 46
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter;->callbacks:Lcom/livemixtapes/adapter/ViewPagerAdapter$PagerCallbacks;

    .line 49
    iput-object p1, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter;->context:Landroid/content/Context;

    .line 50
    iput-object p2, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter;->data:Ljava/util/ArrayList;

    .line 51
    return-void
.end method

.method static synthetic access$0(Lcom/livemixtapes/adapter/ViewPagerAdapter;)Lcom/livemixtapes/adapter/ViewPagerAdapter$PagerCallbacks;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter;->callbacks:Lcom/livemixtapes/adapter/ViewPagerAdapter$PagerCallbacks;

    return-object v0
.end method


# virtual methods
.method public cancelTimers()V
    .locals 3

    .prologue
    .line 126
    iget-object v1, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter;->timers:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_0

    .line 130
    iget-object v1, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter;->timers:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->clear()V

    .line 131
    return-void

    .line 126
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/CountDownTimer;

    .line 127
    .local v0, "timer":Landroid/os/CountDownTimer;
    invoke-virtual {v0}, Landroid/os/CountDownTimer;->cancel()V

    goto :goto_0
.end method

.method public destroyItem(Landroid/view/ViewGroup;ILjava/lang/Object;)V
    .locals 0
    .param p1, "container"    # Landroid/view/ViewGroup;
    .param p2, "position"    # I
    .param p3, "object"    # Ljava/lang/Object;

    .prologue
    .line 136
    check-cast p1, Landroid/support/v4/view/ViewPager;

    .end local p1    # "container":Landroid/view/ViewGroup;
    check-cast p3, Landroid/widget/LinearLayout;

    .end local p3    # "object":Ljava/lang/Object;
    invoke-virtual {p1, p3}, Landroid/support/v4/view/ViewPager;->removeView(Landroid/view/View;)V

    .line 137
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 59
    iget-object v0, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter;->data:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    return v0
.end method

.method public instantiateItem(Landroid/view/ViewGroup;I)Ljava/lang/Object;
    .locals 12
    .param p1, "container"    # Landroid/view/ViewGroup;
    .param p2, "position"    # I

    .prologue
    const/4 v11, 0x0

    .line 69
    iget-object v8, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter;->context:Landroid/content/Context;

    const-string v9, "layout_inflater"

    invoke-virtual {v8, v9}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/view/LayoutInflater;

    iput-object v8, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter;->inflater:Landroid/view/LayoutInflater;

    .line 70
    iget-object v8, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter;->inflater:Landroid/view/LayoutInflater;

    const v9, 0x7f030021

    invoke-virtual {v8, v9, p1, v11}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v4

    .line 72
    .local v4, "itemView":Landroid/view/View;
    iget-object v8, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter;->callbacks:Lcom/livemixtapes/adapter/ViewPagerAdapter$PagerCallbacks;

    if-eqz v8, :cond_0

    .line 73
    new-instance v8, Lcom/livemixtapes/adapter/ViewPagerAdapter$1;

    invoke-direct {v8, p0, p2}, Lcom/livemixtapes/adapter/ViewPagerAdapter$1;-><init>(Lcom/livemixtapes/adapter/ViewPagerAdapter;I)V

    invoke-virtual {v4, v8}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 81
    :cond_0
    const v8, 0x7f080080

    invoke-virtual {v4, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    new-instance v9, Lcom/livemixtapes/adapter/ViewPagerAdapter$2;

    invoke-direct {v9, p0, p2}, Lcom/livemixtapes/adapter/ViewPagerAdapter$2;-><init>(Lcom/livemixtapes/adapter/ViewPagerAdapter;I)V

    invoke-virtual {v8, v9}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 88
    const v8, 0x7f080081

    invoke-virtual {v4, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    new-instance v9, Lcom/livemixtapes/adapter/ViewPagerAdapter$3;

    invoke-direct {v9, p0, p2}, Lcom/livemixtapes/adapter/ViewPagerAdapter$3;-><init>(Lcom/livemixtapes/adapter/ViewPagerAdapter;I)V

    invoke-virtual {v8, v9}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 95
    new-instance v3, Lcom/livemixtapes/ImageLoader;

    iget-object v8, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter;->context:Landroid/content/Context;

    invoke-direct {v3, v8}, Lcom/livemixtapes/ImageLoader;-><init>(Landroid/content/Context;)V

    .line 96
    .local v3, "imageLoader":Lcom/livemixtapes/ImageLoader;
    const v8, 0x7f080078

    invoke-virtual {v4, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    .line 97
    .local v2, "image":Landroid/widget/ImageView;
    iget-object v8, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter;->data:Ljava/util/ArrayList;

    invoke-virtual {v8, p2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/HashMap;

    const-string v9, "thumbnail"

    invoke-virtual {v8, v9}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v3, v8, v2}, Lcom/livemixtapes/ImageLoader;->DisplayImage(Ljava/lang/String;Landroid/widget/ImageView;)V

    .line 99
    const v8, 0x7f08004e

    invoke-virtual {v4, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/TextView;

    .line 100
    .local v7, "titleView":Landroid/widget/TextView;
    iget-object v8, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter;->data:Ljava/util/ArrayList;

    invoke-virtual {v8, p2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/Map;

    invoke-static {v8}, Lcom/livemixtapes/Utils;->getArtistAndTitle(Ljava/util/Map;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 102
    iget-object v8, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter;->data:Ljava/util/ArrayList;

    invoke-virtual {v8, p2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Ljava/util/HashMap;

    const-string v9, "releaseseconds"

    invoke-virtual {v8, v9}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v8

    invoke-static {v8}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-static {v8}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v5

    .local v5, "release_seconds":J
    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    .line 104
    new-instance v9, Ljava/lang/StringBuilder;

    const-string v10, "RELEASE SECONDS: "

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v9, v5, v6}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    aput-object v9, v8, v11

    invoke-static {v8}, Lcom/livemixtapes/console;->log([Ljava/lang/Object;)V

    .line 106
    const v8, 0x7f080079

    invoke-virtual {v4, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/livemixtapes/ui/widgets/DjBadgesView;

    .line 107
    .local v1, "djs":Lcom/livemixtapes/ui/widgets/DjBadgesView;
    iget-object v8, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter;->data:Ljava/util/ArrayList;

    invoke-virtual {v8, p2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

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

    invoke-virtual {v1, v8, v11}, Lcom/livemixtapes/ui/widgets/DjBadgesView;->loadDjs([Ljava/lang/String;Z)V

    .line 110
    const-wide/16 v8, 0x0

    cmp-long v8, v5, v8

    if-lez v8, :cond_1

    .line 111
    const v8, 0x7f08007a

    invoke-virtual {v4, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    .line 112
    .local v0, "countdown_layout":Landroid/widget/LinearLayout;
    invoke-virtual {v0, v11}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 113
    iget-object v8, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter;->timers:Ljava/util/List;

    new-instance v9, Lcom/livemixtapes/adapter/ViewPagerAdapter$ReleaseTimer;

    invoke-direct {v9, p0, v4, v5, v6}, Lcom/livemixtapes/adapter/ViewPagerAdapter$ReleaseTimer;-><init>(Lcom/livemixtapes/adapter/ViewPagerAdapter;Landroid/view/View;J)V

    invoke-interface {v8, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 120
    .end local v0    # "countdown_layout":Landroid/widget/LinearLayout;
    :cond_1
    check-cast p1, Landroid/support/v4/view/ViewPager;

    .end local p1    # "container":Landroid/view/ViewGroup;
    invoke-virtual {p1, v4}, Landroid/support/v4/view/ViewPager;->addView(Landroid/view/View;)V

    .line 122
    return-object v4
.end method

.method public isViewFromObject(Landroid/view/View;Ljava/lang/Object;)Z
    .locals 1
    .param p1, "view"    # Landroid/view/View;
    .param p2, "object"    # Ljava/lang/Object;

    .prologue
    .line 64
    check-cast p2, Landroid/widget/LinearLayout;

    .end local p2    # "object":Ljava/lang/Object;
    if-ne p1, p2, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setCallbacks(Lcom/livemixtapes/adapter/ViewPagerAdapter$PagerCallbacks;)V
    .locals 0
    .param p1, "callbacks"    # Lcom/livemixtapes/adapter/ViewPagerAdapter$PagerCallbacks;

    .prologue
    .line 54
    iput-object p1, p0, Lcom/livemixtapes/adapter/ViewPagerAdapter;->callbacks:Lcom/livemixtapes/adapter/ViewPagerAdapter$PagerCallbacks;

    .line 55
    return-void
.end method
