.class Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;
.super Ljava/lang/Object;
.source "PinnedHeaderExpandableAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "GroupViewHolder"
.end annotation


# instance fields
.field check_box:Landroid/widget/CheckBox;

.field iv:Landroid/widget/ImageView;

.field text:Landroid/widget/TextView;

.field textsize:Landroid/widget/TextView;

.field final synthetic this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;


# direct methods
.method public constructor <init>(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;Landroid/view/View;)V
    .locals 2
    .param p2, "parent"    # Landroid/view/View;

    .prologue
    .line 304
    iput-object p1, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 305
    const v0, 0x7f0701a1

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->text:Landroid/widget/TextView;

    .line 306
    const v0, 0x7f0701a2

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->textsize:Landroid/widget/TextView;

    .line 307
    const v0, 0x7f0701a3

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    iput-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->check_box:Landroid/widget/CheckBox;

    .line 308
    const v0, 0x7f0701a0

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->iv:Landroid/widget/ImageView;

    .line 309
    iget-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->check_box:Landroid/widget/CheckBox;

    new-instance v1, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder$1;

    invoke-direct {v1, p0}, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder$1;-><init>(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;)V

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 344
    return-void
.end method

.method static synthetic access$0(Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;)Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;
    .locals 1

    .prologue
    .line 299
    iget-object v0, p0, Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter$GroupViewHolder;->this$0:Lcom/xiaos/adapter/PinnedHeaderExpandableAdapter;

    return-object v0
.end method
