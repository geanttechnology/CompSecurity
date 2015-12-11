.class Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;
.super Ljava/lang/Object;
.source "PinnedHeaderExpandableAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ChildViewHolder"
.end annotation


# instance fields
.field check_box:Landroid/widget/CheckBox;

.field iv_icon:Landroid/widget/ImageView;

.field final synthetic this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

.field tv_appname:Landroid/widget/TextView;

.field tv_appsize:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;Landroid/view/View;)V
    .locals 2
    .param p2, "parent"    # Landroid/view/View;

    .prologue
    .line 142
    iput-object p1, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 143
    const v0, 0x7f07025b

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    iput-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->check_box:Landroid/widget/CheckBox;

    .line 144
    const v0, 0x7f070255

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->iv_icon:Landroid/widget/ImageView;

    .line 145
    const v0, 0x7f070259

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->tv_appname:Landroid/widget/TextView;

    .line 146
    const v0, 0x7f07025a

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->tv_appsize:Landroid/widget/TextView;

    .line 148
    iget-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->check_box:Landroid/widget/CheckBox;

    new-instance v1, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder$1;

    invoke-direct {v1, p0}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder$1;-><init>(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;)V

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 175
    return-void
.end method

.method static synthetic access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    .locals 1

    .prologue
    .line 137
    iget-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$ChildViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    return-object v0
.end method
