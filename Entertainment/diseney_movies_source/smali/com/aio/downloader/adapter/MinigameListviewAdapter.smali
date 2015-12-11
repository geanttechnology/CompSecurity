.class public Lcom/aio/downloader/adapter/MinigameListviewAdapter;
.super Landroid/widget/BaseAdapter;
.source "MinigameListviewAdapter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;
    }
.end annotation


# instance fields
.field private app:Lcom/aio/downloader/mydownload/MyApplcation;

.field private ctx:Landroid/content/Context;

.field private holder:Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;

.field private list:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/model/MiniGameModel;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/util/List;)V
    .locals 1
    .param p1, "ctx"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/util/List",
            "<",
            "Lcom/aio/downloader/model/MiniGameModel;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 31
    .local p2, "list":Ljava/util/List;, "Ljava/util/List<Lcom/aio/downloader/model/MiniGameModel;>;"
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 26
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->holder:Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;

    .line 32
    iput-object p1, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->ctx:Landroid/content/Context;

    .line 33
    iput-object p2, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->list:Ljava/util/List;

    .line 36
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/mydownload/MyApplcation;

    iput-object v0, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->app:Lcom/aio/downloader/mydownload/MyApplcation;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 41
    :goto_0
    return-void

    .line 38
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method static synthetic access$0(Lcom/aio/downloader/adapter/MinigameListviewAdapter;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 28
    iget-object v0, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->ctx:Landroid/content/Context;

    return-object v0
.end method


# virtual methods
.method public addItem(Ljava/util/ArrayList;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/aio/downloader/model/MiniGameModel;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 55
    .local p1, "model":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lcom/aio/downloader/model/MiniGameModel;>;"
    iget-object v0, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 56
    invoke-virtual {p0}, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->notifyDataSetChanged()V

    .line 57
    return-void
.end method

.method public getCount()I
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->list:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 47
    iget-object v0, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 49
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 62
    iget-object v0, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 68
    int-to-long v0, p1

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 4
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    .line 73
    iget-object v1, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->list:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/aio/downloader/model/MiniGameModel;

    .line 74
    .local v0, "in_fo":Lcom/aio/downloader/model/MiniGameModel;
    if-nez p2, :cond_0

    .line 75
    new-instance v1, Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;

    invoke-direct {v1, p0}, Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;-><init>(Lcom/aio/downloader/adapter/MinigameListviewAdapter;)V

    iput-object v1, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->holder:Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;

    .line 76
    iget-object v1, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->ctx:Landroid/content/Context;

    const v2, 0x7f030074

    const/4 v3, 0x0

    invoke-static {v1, v2, v3}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 77
    iget-object v2, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->holder:Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;

    .line 78
    const v1, 0x7f0702c9

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 77
    invoke-static {v2, v1}, Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->access$0(Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;Landroid/widget/ImageView;)V

    .line 79
    iget-object v2, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->holder:Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;

    .line 80
    const v1, 0x7f0702ca

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 79
    invoke-static {v2, v1}, Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->access$1(Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 82
    iget-object v2, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->holder:Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;

    .line 83
    const v1, 0x7f0702cc

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 82
    invoke-static {v2, v1}, Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->access$2(Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;Landroid/widget/TextView;)V

    .line 84
    iget-object v2, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->holder:Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;

    .line 85
    const v1, 0x7f0702cb

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RatingBar;

    .line 84
    invoke-static {v2, v1}, Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->access$3(Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;Landroid/widget/RatingBar;)V

    .line 86
    iget-object v2, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->holder:Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;

    .line 87
    const v1, 0x7f0702cd

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    .line 86
    invoke-static {v2, v1}, Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->access$4(Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;Landroid/widget/Button;)V

    .line 88
    iget-object v1, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->holder:Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;

    invoke-virtual {p2, v1}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 92
    :goto_0
    iget-object v1, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->holder:Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->minigametitle:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->access$5(Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v1

    invoke-virtual {v0}, Lcom/aio/downloader/model/MiniGameModel;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 93
    iget-object v1, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->holder:Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->minigamehints:Landroid/widget/TextView;
    invoke-static {v1}, Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->access$6(Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;)Landroid/widget/TextView;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "More than "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/aio/downloader/model/MiniGameModel;->getHits()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " plays"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 95
    :try_start_0
    iget-object v1, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->app:Lcom/aio/downloader/mydownload/MyApplcation;

    invoke-virtual {v0}, Lcom/aio/downloader/model/MiniGameModel;->getIcon()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->holder:Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->minigameicon:Landroid/widget/ImageView;
    invoke-static {v3}, Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->access$7(Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;)Landroid/widget/ImageView;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/aio/downloader/mydownload/MyApplcation;->asyncLoadImage(Ljava/lang/String;Landroid/widget/ImageView;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 100
    :goto_1
    rem-int/lit8 v1, p1, 0x2

    if-nez v1, :cond_1

    .line 101
    iget-object v1, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->holder:Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->minigame_ratingbar:Landroid/widget/RatingBar;
    invoke-static {v1}, Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->access$8(Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;)Landroid/widget/RatingBar;

    move-result-object v1

    const/high16 v2, 0x40800000    # 4.0f

    invoke-virtual {v1, v2}, Landroid/widget/RatingBar;->setRating(F)V

    .line 105
    :goto_2
    iget-object v1, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->holder:Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->minigameplaybt:Landroid/widget/Button;
    invoke-static {v1}, Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->access$9(Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;)Landroid/widget/Button;

    move-result-object v1

    new-instance v2, Lcom/aio/downloader/adapter/MinigameListviewAdapter$1;

    invoke-direct {v2, p0, v0}, Lcom/aio/downloader/adapter/MinigameListviewAdapter$1;-><init>(Lcom/aio/downloader/adapter/MinigameListviewAdapter;Lcom/aio/downloader/model/MiniGameModel;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 127
    return-object p2

    .line 90
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;

    iput-object v1, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->holder:Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;

    goto :goto_0

    .line 103
    :cond_1
    iget-object v1, p0, Lcom/aio/downloader/adapter/MinigameListviewAdapter;->holder:Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;

    # getter for: Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->minigame_ratingbar:Landroid/widget/RatingBar;
    invoke-static {v1}, Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;->access$8(Lcom/aio/downloader/adapter/MinigameListviewAdapter$ViewHolder;)Landroid/widget/RatingBar;

    move-result-object v1

    const/high16 v2, 0x40a00000    # 5.0f

    invoke-virtual {v1, v2}, Landroid/widget/RatingBar;->setRating(F)V

    goto :goto_2

    .line 96
    :catch_0
    move-exception v1

    goto :goto_1
.end method
