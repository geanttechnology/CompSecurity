.class public Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;
.super Landroid/widget/BaseAdapter;
.source "LDialogListBuilder.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/aio/downloader/views/LDialogListBuilder;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "ListItemAdapter"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$ViewHolder;
    }
.end annotation


# instance fields
.field private isChooseMode:Z

.field private items:[Ljava/lang/String;

.field private mContext:Landroid/content/Context;

.field private selectedIndex:I

.field final synthetic this$0:Lcom/aio/downloader/views/LDialogListBuilder;


# direct methods
.method public constructor <init>(Lcom/aio/downloader/views/LDialogListBuilder;Landroid/content/Context;[Ljava/lang/String;IZ)V
    .locals 1
    .param p2, "context"    # Landroid/content/Context;
    .param p3, "items"    # [Ljava/lang/String;
    .param p4, "selectedIndex"    # I
    .param p5, "isChooseMode"    # Z

    .prologue
    .line 81
    iput-object p1, p0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;->this$0:Lcom/aio/downloader/views/LDialogListBuilder;

    .line 80
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 77
    const/4 v0, -0x1

    iput v0, p0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;->selectedIndex:I

    .line 82
    iput-object p2, p0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;->mContext:Landroid/content/Context;

    .line 83
    iput-object p3, p0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;->items:[Ljava/lang/String;

    .line 84
    iput p4, p0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;->selectedIndex:I

    .line 85
    iput-boolean p5, p0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;->isChooseMode:Z

    .line 86
    return-void
.end method

.method static synthetic access$0(Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;)Lcom/aio/downloader/views/LDialogListBuilder;
    .locals 1

    .prologue
    .line 74
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;->this$0:Lcom/aio/downloader/views/LDialogListBuilder;

    return-object v0
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;->items:[Ljava/lang/String;

    array-length v0, v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "arg0"    # I

    .prologue
    .line 95
    const/4 v0, 0x0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "arg0"    # I

    .prologue
    .line 100
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 5
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "arg2"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v4, 0x0

    const/4 v2, 0x0

    .line 106
    const/4 v0, 0x0

    .line 107
    .local v0, "viewHolder":Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$ViewHolder;
    if-nez p2, :cond_1

    .line 108
    new-instance v0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$ViewHolder;

    .end local v0    # "viewHolder":Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$ViewHolder;
    invoke-direct {v0, p0, v4}, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$ViewHolder;-><init>(Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$ViewHolder;)V

    .line 109
    .restart local v0    # "viewHolder":Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$ViewHolder;
    iget-object v1, p0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;->mContext:Landroid/content/Context;

    .line 110
    const v3, 0x7f030073

    .line 109
    invoke-static {v1, v3, v4}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 112
    const v1, 0x7f0702c6

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 111
    iput-object v1, v0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$ViewHolder;->mTextView:Landroid/widget/TextView;

    .line 114
    const v1, 0x7f0702c7

    invoke-virtual {p2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    .line 113
    iput-object v1, v0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$ViewHolder;->mIconImageView:Landroid/widget/ImageView;

    .line 115
    iget-boolean v1, p0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;->isChooseMode:Z

    if-eqz v1, :cond_0

    .line 116
    iget-object v1, v0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$ViewHolder;->mIconImageView:Landroid/widget/ImageView;

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 118
    :cond_0
    invoke-virtual {p2, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 122
    :goto_0
    iget-object v3, v0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$ViewHolder;->mIconImageView:Landroid/widget/ImageView;

    iget v1, p0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;->selectedIndex:I

    if-ne v1, p1, :cond_2

    const/4 v1, 0x1

    :goto_1
    invoke-virtual {v3, v1}, Landroid/widget/ImageView;->setSelected(Z)V

    .line 123
    iget-object v1, v0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$ViewHolder;->mTextView:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;->items:[Ljava/lang/String;

    aget-object v2, v2, p1

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 124
    new-instance v1, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$1;

    invoke-direct {v1, p0, p1}, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$1;-><init>(Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;I)V

    invoke-virtual {p2, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 139
    return-object p2

    .line 120
    :cond_1
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "viewHolder":Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$ViewHolder;
    check-cast v0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$ViewHolder;

    .restart local v0    # "viewHolder":Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter$ViewHolder;
    goto :goto_0

    :cond_2
    move v1, v2

    .line 122
    goto :goto_1
.end method

.method public setSelectedIndex(I)V
    .locals 0
    .param p1, "index"    # I

    .prologue
    .line 148
    iput p1, p0, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;->selectedIndex:I

    .line 149
    invoke-virtual {p0}, Lcom/aio/downloader/views/LDialogListBuilder$ListItemAdapter;->notifyDataSetChanged()V

    .line 150
    return-void
.end method
