.class public Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
.super Landroid/widget/BaseExpandableListAdapter;
.source "PinnedHeaderExpandableAdapter.java"

# interfaces
.implements Lcom/xiaos/view/PinnedHeaderExpandableListView$HeaderAdapter;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;,
        Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;,
        Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;
    }
.end annotation


# instance fields
.field private apkdata:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/wjj/eneity/SoftApk;",
            ">;"
        }
    .end annotation
.end field

.field private cachelist:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/wjj/eneity/RubSoftware;",
            ">;"
        }
    .end annotation
.end field

.field private checkListener:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;

.field private cllist:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/wjj/eneity/Canliu;",
            ">;"
        }
    .end annotation
.end field

.field private context:Landroid/content/Context;

.field private groupData:[Ljava/lang/String;

.field private groupSize:[Ljava/lang/String;

.field private groupStatusMap:Landroid/util/SparseIntArray;

.field private headcheck0:Z

.field private headcheck1:Z

.field private headcheck2:Z

.field private headcheck3:Z

.field private index:I

.field private index2:I

.field private indexalltrue:I

.field private inflater:Landroid/view/LayoutInflater;

.field private list:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/wjj/eneity/RuningApp;",
            ">;"
        }
    .end annotation
.end field

.field private listView:Lcom/xiaos/view/PinnedHeaderExpandableListView;


# direct methods
.method public constructor <init>(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;[Ljava/lang/String;Landroid/content/Context;Lcom/xiaos/view/PinnedHeaderExpandableListView;[Ljava/lang/String;Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;)V
    .locals 2
    .param p5, "groupData"    # [Ljava/lang/String;
    .param p6, "context"    # Landroid/content/Context;
    .param p7, "listView"    # Lcom/xiaos/view/PinnedHeaderExpandableListView;
    .param p8, "groupsize"    # [Ljava/lang/String;
    .param p9, "l"    # Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/wjj/eneity/RuningApp;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/wjj/eneity/RubSoftware;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/wjj/eneity/SoftApk;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/wjj/eneity/Canliu;",
            ">;[",
            "Ljava/lang/String;",
            "Landroid/content/Context;",
            "Lcom/xiaos/view/PinnedHeaderExpandableListView;",
            "[",
            "Ljava/lang/String;",
            "Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;",
            ")V"
        }
    .end annotation

    .prologue
    .local p1, "list":Ljava/util/List;, "Ljava/util/List<Lcom/wjj/eneity/RuningApp;>;"
    .local p2, "cachelist":Ljava/util/List;, "Ljava/util/List<Lcom/wjj/eneity/RubSoftware;>;"
    .local p3, "apkdata":Ljava/util/List;, "Ljava/util/List<Lcom/wjj/eneity/SoftApk;>;"
    .local p4, "cllist":Ljava/util/List;, "Ljava/util/List<Lcom/wjj/eneity/Canliu;>;"
    const/4 v1, 0x0

    .line 47
    invoke-direct {p0}, Landroid/widget/BaseExpandableListAdapter;-><init>()V

    .line 37
    const/16 v0, 0xa

    iput v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index:I

    .line 39
    iput v1, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index2:I

    .line 41
    iput v1, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->indexalltrue:I

    .line 400
    new-instance v0, Landroid/util/SparseIntArray;

    invoke-direct {v0}, Landroid/util/SparseIntArray;-><init>()V

    iput-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->groupStatusMap:Landroid/util/SparseIntArray;

    .line 49
    iput-object p5, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->groupData:[Ljava/lang/String;

    .line 50
    iput-object p1, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->list:Ljava/util/List;

    .line 51
    iput-object p2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->cachelist:Ljava/util/List;

    .line 52
    iput-object p4, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->cllist:Ljava/util/List;

    .line 53
    iput-object p3, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->apkdata:Ljava/util/List;

    .line 55
    iput-object p9, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->checkListener:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;

    .line 56
    iput-object p8, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->groupSize:[Ljava/lang/String;

    .line 58
    iput-object p6, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->context:Landroid/content/Context;

    .line 59
    iput-object p7, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->listView:Lcom/xiaos/view/PinnedHeaderExpandableListView;

    .line 60
    iget-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->context:Landroid/content/Context;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->inflater:Landroid/view/LayoutInflater;

    .line 61
    return-void
.end method

.method static synthetic access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)I
    .locals 1

    .prologue
    .line 37
    iget v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index:I

    return v0
.end method

.method static synthetic access$1(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)Ljava/util/List;
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->list:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$10(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;Z)V
    .locals 0

    .prologue
    .line 298
    iput-boolean p1, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->headcheck3:Z

    return-void
.end method

.method static synthetic access$2(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;I)V
    .locals 0

    .prologue
    .line 41
    iput p1, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->indexalltrue:I

    return-void
.end method

.method static synthetic access$3(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)Ljava/util/List;
    .locals 1

    .prologue
    .line 33
    iget-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->cachelist:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$4(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)Ljava/util/List;
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->cllist:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$5(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)Ljava/util/List;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->apkdata:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$6(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;Z)V
    .locals 0

    .prologue
    .line 298
    iput-boolean p1, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->headcheck0:Z

    return-void
.end method

.method static synthetic access$7(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->checkListener:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupCheckListener;

    return-object v0
.end method

.method static synthetic access$8(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;Z)V
    .locals 0

    .prologue
    .line 298
    iput-boolean p1, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->headcheck1:Z

    return-void
.end method

.method static synthetic access$9(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;Z)V
    .locals 0

    .prologue
    .line 298
    iput-boolean p1, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->headcheck2:Z

    return-void
.end method

.method private createChildrenView()Landroid/view/View;
    .locals 3

    .prologue
    .line 362
    iget-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->inflater:Landroid/view/LayoutInflater;

    const v1, 0x7f030062

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method private createGroupView()Landroid/view/View;
    .locals 3

    .prologue
    .line 366
    iget-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->inflater:Landroid/view/LayoutInflater;

    const v1, 0x7f03003b

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public configureHeader(Landroid/view/View;III)V
    .locals 4
    .param p1, "header"    # Landroid/view/View;
    .param p2, "groupPosition"    # I
    .param p3, "childPosition"    # I
    .param p4, "alpha"    # I

    .prologue
    const v3, 0x7f0701a3

    .line 385
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->groupData:[Ljava/lang/String;

    aget-object v0, v2, p2

    .line 386
    .local v0, "groupData":Ljava/lang/String;
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->groupSize:[Ljava/lang/String;

    aget-object v1, v2, p2

    .line 387
    .local v1, "groupsize":Ljava/lang/String;
    const v2, 0x7f0701a1

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    invoke-virtual {v2, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 388
    const v2, 0x7f0701a2

    invoke-virtual {p1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 389
    if-nez p2, :cond_1

    .line 390
    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/CheckBox;

    iget-boolean v3, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->headcheck0:Z

    invoke-virtual {v2, v3}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 398
    :cond_0
    :goto_0
    return-void

    .line 391
    :cond_1
    const/4 v2, 0x1

    if-ne p2, v2, :cond_2

    .line 392
    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/CheckBox;

    iget-boolean v3, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->headcheck1:Z

    invoke-virtual {v2, v3}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto :goto_0

    .line 393
    :cond_2
    const/4 v2, 0x2

    if-ne p2, v2, :cond_3

    .line 394
    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/CheckBox;

    iget-boolean v3, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->headcheck2:Z

    invoke-virtual {v2, v3}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto :goto_0

    .line 395
    :cond_3
    const/4 v2, 0x3

    if-ne p2, v2, :cond_0

    .line 396
    invoke-virtual {p1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/CheckBox;

    iget-boolean v3, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->headcheck3:Z

    invoke-virtual {v2, v3}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto :goto_0
.end method

.method public getChild(II)Ljava/lang/Object;
    .locals 1
    .param p1, "groupPosition"    # I
    .param p2, "childPosition"    # I

    .prologue
    .line 65
    if-nez p1, :cond_0

    .line 66
    iget-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->list:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    .line 74
    :goto_0
    return-object v0

    .line 67
    :cond_0
    const/4 v0, 0x1

    if-ne p1, v0, :cond_1

    .line 68
    iget-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->cachelist:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0

    .line 69
    :cond_1
    const/4 v0, 0x2

    if-ne p1, v0, :cond_2

    .line 70
    iget-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->cllist:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0

    .line 71
    :cond_2
    const/4 v0, 0x3

    if-ne p1, v0, :cond_3

    .line 72
    iget-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->apkdata:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    goto :goto_0

    .line 74
    :cond_3
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getChildId(II)J
    .locals 2
    .param p1, "groupPosition"    # I
    .param p2, "childPosition"    # I

    .prologue
    .line 79
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public getChildView(IIZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "groupPosition"    # I
    .param p2, "childPosition"    # I
    .param p3, "isLastChild"    # Z
    .param p4, "convertView"    # Landroid/view/View;
    .param p5, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    .line 92
    if-nez p4, :cond_1

    .line 93
    invoke-direct {p0}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->createChildrenView()Landroid/view/View;

    move-result-object p4

    .line 94
    new-instance v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;

    invoke-direct {v0, p0, p4}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;-><init>(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;Landroid/view/View;)V

    .line 95
    .local v0, "childViewHolder":Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;
    invoke-virtual {p4, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 100
    :goto_0
    if-nez p1, :cond_2

    .line 101
    const/4 v3, 0x0

    iput v3, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index:I

    .line 102
    iget-object v3, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->list:Ljava/util/List;

    invoke-interface {v3, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/wjj/eneity/RuningApp;

    .line 103
    .local v2, "sw":Lcom/wjj/eneity/RuningApp;
    iget-object v3, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->check_box:Landroid/widget/CheckBox;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/CheckBox;->setTag(Ljava/lang/Object;)V

    .line 104
    iget-object v3, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->tv_appname:Landroid/widget/TextView;

    iget-object v4, v2, Lcom/wjj/eneity/RuningApp;->runingsoftname:Ljava/lang/String;

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 105
    iget-object v3, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->iv_icon:Landroid/widget/ImageView;

    iget-object v4, v2, Lcom/wjj/eneity/RuningApp;->icon:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 106
    iget-object v3, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->tv_appsize:Landroid/widget/TextView;

    iget-wide v4, v2, Lcom/wjj/eneity/RuningApp;->memory:J

    invoke-static {v4, v5}, Lcom/wjj/utils/CommonUtil;->formatSize(J)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 107
    iget-object v3, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->check_box:Landroid/widget/CheckBox;

    iget-boolean v4, v2, Lcom/wjj/eneity/RuningApp;->ischecked:Z

    invoke-virtual {v3, v4}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 134
    .end local v2    # "sw":Lcom/wjj/eneity/RuningApp;
    :cond_0
    :goto_1
    return-object p4

    .line 97
    .end local v0    # "childViewHolder":Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;
    :cond_1
    invoke-virtual {p4}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;

    .restart local v0    # "childViewHolder":Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;
    goto :goto_0

    .line 108
    :cond_2
    if-ne p1, v3, :cond_3

    .line 109
    iput v3, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index:I

    .line 110
    iget-object v3, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->cachelist:Ljava/util/List;

    invoke-interface {v3, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/wjj/eneity/RubSoftware;

    .line 111
    .local v2, "sw":Lcom/wjj/eneity/RubSoftware;
    iget-object v3, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->check_box:Landroid/widget/CheckBox;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/CheckBox;->setTag(Ljava/lang/Object;)V

    .line 112
    iget-object v3, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->tv_appname:Landroid/widget/TextView;

    new-instance v4, Ljava/lang/StringBuilder;

    iget-object v5, v2, Lcom/wjj/eneity/RubSoftware;->softname:Ljava/lang/String;

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v5, "\'s Cache"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 113
    iget-object v3, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->iv_icon:Landroid/widget/ImageView;

    iget-object v4, v2, Lcom/wjj/eneity/RubSoftware;->icon:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 114
    iget-object v3, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->tv_appsize:Landroid/widget/TextView;

    iget-wide v4, v2, Lcom/wjj/eneity/RubSoftware;->allcache:J

    invoke-static {v4, v5}, Lcom/wjj/utils/CommonUtil;->formatSize(J)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 115
    iget-object v3, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->check_box:Landroid/widget/CheckBox;

    iget-boolean v4, v2, Lcom/wjj/eneity/RubSoftware;->ischecked:Z

    invoke-virtual {v3, v4}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto :goto_1

    .line 116
    .end local v2    # "sw":Lcom/wjj/eneity/RubSoftware;
    :cond_3
    if-ne p1, v4, :cond_4

    .line 117
    iput v4, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index:I

    .line 118
    iget-object v3, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->cllist:Ljava/util/List;

    invoke-interface {v3, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/wjj/eneity/Canliu;

    .line 119
    .local v1, "cl":Lcom/wjj/eneity/Canliu;
    iget-object v3, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->check_box:Landroid/widget/CheckBox;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/CheckBox;->setTag(Ljava/lang/Object;)V

    .line 120
    iget-object v3, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->tv_appname:Landroid/widget/TextView;

    iget-object v4, v1, Lcom/wjj/eneity/Canliu;->runingsoftname:Ljava/lang/String;

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 121
    iget-object v3, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->iv_icon:Landroid/widget/ImageView;

    const v4, 0x7f02010c

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 122
    iget-object v3, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->tv_appsize:Landroid/widget/TextView;

    iget-wide v4, v1, Lcom/wjj/eneity/Canliu;->memory:J

    invoke-static {v4, v5}, Lcom/wjj/utils/CommonUtil;->formatSize(J)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 123
    iget-object v3, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->check_box:Landroid/widget/CheckBox;

    iget-boolean v4, v1, Lcom/wjj/eneity/Canliu;->ischecked:Z

    invoke-virtual {v3, v4}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto/16 :goto_1

    .line 124
    .end local v1    # "cl":Lcom/wjj/eneity/Canliu;
    :cond_4
    if-ne p1, v5, :cond_0

    .line 125
    iput v5, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index:I

    .line 126
    iget-object v3, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->apkdata:Ljava/util/List;

    invoke-interface {v3, p2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/wjj/eneity/SoftApk;

    .line 127
    .local v2, "sw":Lcom/wjj/eneity/SoftApk;
    iget-object v3, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->check_box:Landroid/widget/CheckBox;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/CheckBox;->setTag(Ljava/lang/Object;)V

    .line 128
    iget-object v3, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->tv_appname:Landroid/widget/TextView;

    iget-object v4, v2, Lcom/wjj/eneity/SoftApk;->apkname:Ljava/lang/String;

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 129
    iget-object v3, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->iv_icon:Landroid/widget/ImageView;

    iget-object v4, v2, Lcom/wjj/eneity/SoftApk;->icon:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v3, v4}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 130
    iget-object v3, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->tv_appsize:Landroid/widget/TextView;

    iget-wide v4, v2, Lcom/wjj/eneity/SoftApk;->apksize:J

    invoke-static {v4, v5}, Lcom/wjj/utils/CommonUtil;->formatSize(J)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 131
    iget-object v3, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->check_box:Landroid/widget/CheckBox;

    iget-boolean v4, v2, Lcom/wjj/eneity/SoftApk;->ischecked:Z

    invoke-virtual {v3, v4}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto/16 :goto_1
.end method

.method public getChildrenCount(I)I
    .locals 1
    .param p1, "groupPosition"    # I

    .prologue
    .line 181
    if-nez p1, :cond_0

    .line 182
    iget-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->list:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    .line 190
    :goto_0
    return v0

    .line 183
    :cond_0
    const/4 v0, 0x1

    if-ne p1, v0, :cond_1

    .line 184
    iget-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->cachelist:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    goto :goto_0

    .line 185
    :cond_1
    const/4 v0, 0x2

    if-ne p1, v0, :cond_2

    .line 186
    iget-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->cllist:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    goto :goto_0

    .line 187
    :cond_2
    const/4 v0, 0x3

    if-ne p1, v0, :cond_3

    .line 188
    iget-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->apkdata:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    goto :goto_0

    .line 190
    :cond_3
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getGroup(I)Ljava/lang/Object;
    .locals 1
    .param p1, "groupPosition"    # I

    .prologue
    .line 195
    iget-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->groupData:[Ljava/lang/String;

    aget-object v0, v0, p1

    return-object v0
.end method

.method public getGroupClickStatus(I)I
    .locals 1
    .param p1, "groupPosition"    # I

    .prologue
    .line 409
    iget-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->groupStatusMap:Landroid/util/SparseIntArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseIntArray;->keyAt(I)I

    move-result v0

    if-ltz v0, :cond_0

    .line 410
    iget-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->groupStatusMap:Landroid/util/SparseIntArray;

    invoke-virtual {v0, p1}, Landroid/util/SparseIntArray;->get(I)I

    move-result v0

    .line 412
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getGroupCount()I
    .locals 1

    .prologue
    .line 200
    iget-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->groupData:[Ljava/lang/String;

    array-length v0, v0

    return v0
.end method

.method public getGroupId(I)J
    .locals 2
    .param p1, "groupPosition"    # I

    .prologue
    .line 205
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public getGroupView(IZLandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 6
    .param p1, "groupPosition"    # I
    .param p2, "isExpanded"    # Z
    .param p3, "convertView"    # Landroid/view/View;
    .param p4, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 218
    if-nez p3, :cond_1

    .line 219
    invoke-direct {p0}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->createGroupView()Landroid/view/View;

    move-result-object p3

    .line 220
    new-instance v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;

    invoke-direct {v0, p0, p3}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;-><init>(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;Landroid/view/View;)V

    .line 221
    .local v0, "groupview":Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;
    invoke-virtual {p3, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 226
    :goto_0
    if-eqz p2, :cond_2

    .line 227
    iget-object v2, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->iv:Landroid/widget/ImageView;

    const v3, 0x7f02001c

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 233
    :goto_1
    iget-object v2, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->text:Landroid/widget/TextView;

    iget-object v3, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->groupData:[Ljava/lang/String;

    aget-object v3, v3, p1

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 234
    iget-object v2, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->textsize:Landroid/widget/TextView;

    iget-object v3, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->groupSize:[Ljava/lang/String;

    aget-object v3, v3, p1

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 236
    if-nez p1, :cond_5

    .line 237
    iput v4, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index2:I

    .line 238
    iget-object v2, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->check_box:Landroid/widget/CheckBox;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/CheckBox;->setTag(Ljava/lang/Object;)V

    .line 239
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->list:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 240
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_2
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->list:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-lt v1, v2, :cond_3

    .line 245
    iget v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index2:I

    iget-object v3, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->list:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-ne v2, v3, :cond_0

    .line 246
    iget-object v2, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->check_box:Landroid/widget/CheckBox;

    invoke-virtual {v2, v5}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 295
    .end local v1    # "i":I
    :cond_0
    :goto_3
    return-object p3

    .line 223
    .end local v0    # "groupview":Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;
    :cond_1
    invoke-virtual {p3}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;

    .restart local v0    # "groupview":Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;
    goto :goto_0

    .line 230
    :cond_2
    iget-object v2, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->iv:Landroid/widget/ImageView;

    const v3, 0x7f02001b

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_1

    .line 241
    .restart local v1    # "i":I
    :cond_3
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->list:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/wjj/eneity/RuningApp;

    iget-boolean v2, v2, Lcom/wjj/eneity/RuningApp;->ischecked:Z

    if-eqz v2, :cond_4

    .line 242
    iget v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index2:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index2:I

    .line 240
    :cond_4
    add-int/lit8 v1, v1, 0x1

    goto :goto_2

    .line 250
    .end local v1    # "i":I
    :cond_5
    if-ne p1, v5, :cond_8

    .line 251
    iput v4, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index2:I

    .line 252
    iget-object v2, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->check_box:Landroid/widget/CheckBox;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/CheckBox;->setTag(Ljava/lang/Object;)V

    .line 253
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->cachelist:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 254
    const/4 v1, 0x0

    .restart local v1    # "i":I
    :goto_4
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->cachelist:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-lt v1, v2, :cond_6

    .line 259
    iget v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index2:I

    iget-object v3, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->cachelist:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-ne v2, v3, :cond_0

    .line 260
    iget-object v2, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->check_box:Landroid/widget/CheckBox;

    invoke-virtual {v2, v5}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto :goto_3

    .line 255
    :cond_6
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->cachelist:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/wjj/eneity/RubSoftware;

    iget-boolean v2, v2, Lcom/wjj/eneity/RubSoftware;->ischecked:Z

    if-eqz v2, :cond_7

    .line 256
    iget v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index2:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index2:I

    .line 254
    :cond_7
    add-int/lit8 v1, v1, 0x1

    goto :goto_4

    .line 264
    .end local v1    # "i":I
    :cond_8
    const/4 v2, 0x2

    if-ne p1, v2, :cond_b

    .line 265
    iput v4, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index2:I

    .line 266
    iget-object v2, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->check_box:Landroid/widget/CheckBox;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/CheckBox;->setTag(Ljava/lang/Object;)V

    .line 267
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->cllist:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 268
    const/4 v1, 0x0

    .restart local v1    # "i":I
    :goto_5
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->cllist:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-lt v1, v2, :cond_9

    .line 273
    iget v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index2:I

    iget-object v3, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->cllist:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-ne v2, v3, :cond_0

    .line 274
    iget-object v2, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->check_box:Landroid/widget/CheckBox;

    invoke-virtual {v2, v5}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto/16 :goto_3

    .line 269
    :cond_9
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->cllist:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/wjj/eneity/Canliu;

    iget-boolean v2, v2, Lcom/wjj/eneity/Canliu;->ischecked:Z

    if-eqz v2, :cond_a

    .line 270
    iget v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index2:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index2:I

    .line 268
    :cond_a
    add-int/lit8 v1, v1, 0x1

    goto :goto_5

    .line 278
    .end local v1    # "i":I
    :cond_b
    const/4 v2, 0x3

    if-ne p1, v2, :cond_0

    .line 279
    iput v4, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index2:I

    .line 280
    iget-object v2, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->check_box:Landroid/widget/CheckBox;

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/CheckBox;->setTag(Ljava/lang/Object;)V

    .line 281
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->apkdata:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 282
    const/4 v1, 0x0

    .restart local v1    # "i":I
    :goto_6
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->apkdata:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v2

    if-lt v1, v2, :cond_c

    .line 287
    iget v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index2:I

    iget-object v3, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->apkdata:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-ne v2, v3, :cond_e

    .line 288
    iget-object v2, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->check_box:Landroid/widget/CheckBox;

    invoke-virtual {v2, v5}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto/16 :goto_3

    .line 283
    :cond_c
    iget-object v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->apkdata:Ljava/util/List;

    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/wjj/eneity/SoftApk;

    iget-boolean v2, v2, Lcom/wjj/eneity/SoftApk;->ischecked:Z

    if-eqz v2, :cond_d

    .line 284
    iget v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index2:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index2:I

    .line 282
    :cond_d
    add-int/lit8 v1, v1, 0x1

    goto :goto_6

    .line 289
    :cond_e
    iget v2, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->index2:I

    if-nez v2, :cond_0

    .line 290
    iget-object v2, v0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->check_box:Landroid/widget/CheckBox;

    invoke-virtual {v2, v4}, Landroid/widget/CheckBox;->setChecked(Z)V

    goto/16 :goto_3
.end method

.method public getHeaderState(II)I
    .locals 2
    .param p1, "groupPosition"    # I
    .param p2, "childPosition"    # I

    .prologue
    .line 371
    invoke-virtual {p0, p1}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->getChildrenCount(I)I

    move-result v0

    .line 372
    .local v0, "childCount":I
    add-int/lit8 v1, v0, -0x1

    if-ne p2, v1, :cond_0

    .line 373
    const/4 v1, 0x2

    .line 378
    :goto_0
    return v1

    .line 374
    :cond_0
    const/4 v1, -0x1

    if-ne p2, v1, :cond_1

    .line 375
    iget-object v1, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->listView:Lcom/xiaos/view/PinnedHeaderExpandableListView;

    invoke-virtual {v1, p1}, Lcom/xiaos/view/PinnedHeaderExpandableListView;->isGroupExpanded(I)Z

    move-result v1

    if-nez v1, :cond_1

    .line 376
    const/4 v1, 0x0

    goto :goto_0

    .line 378
    :cond_1
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public hasStableIds()Z
    .locals 1

    .prologue
    .line 353
    const/4 v0, 0x1

    return v0
.end method

.method public isChildSelectable(II)Z
    .locals 1
    .param p1, "groupPosition"    # I
    .param p2, "childPosition"    # I

    .prologue
    .line 358
    const/4 v0, 0x1

    return v0
.end method

.method public setGroupClickStatus(II)V
    .locals 1
    .param p1, "groupPosition"    # I
    .param p2, "status"    # I

    .prologue
    .line 404
    iget-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;->groupStatusMap:Landroid/util/SparseIntArray;

    invoke-virtual {v0, p1, p2}, Landroid/util/SparseIntArray;->put(II)V

    .line 405
    return-void
.end method
