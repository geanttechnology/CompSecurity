.class Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;
.super Ljava/lang/Object;
.source "ApkSoftAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/wjj/adapter/base/ApkSoftAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ViewHolder"
.end annotation


# instance fields
.field check_box:Landroid/widget/CheckBox;

.field iv_icon:Landroid/widget/ImageView;

.field soft_version:Landroid/widget/TextView;

.field final synthetic this$0:Lcom/wjj/adapter/base/ApkSoftAdapter;

.field tv_softname:Landroid/widget/TextView;

.field tv_softsizi:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Lcom/wjj/adapter/base/ApkSoftAdapter;Landroid/view/View;)V
    .locals 2
    .param p2, "parent"    # Landroid/view/View;

    .prologue
    .line 59
    iput-object p1, p0, Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;->this$0:Lcom/wjj/adapter/base/ApkSoftAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 60
    const v0, 0x7f07024f

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;->soft_version:Landroid/widget/TextView;

    .line 61
    const v0, 0x7f070251

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    iput-object v0, p0, Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;->check_box:Landroid/widget/CheckBox;

    .line 62
    const v0, 0x7f07024d

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;->iv_icon:Landroid/widget/ImageView;

    .line 63
    const v0, 0x7f07024e

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;->tv_softname:Landroid/widget/TextView;

    .line 64
    const v0, 0x7f070250

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;->tv_softsizi:Landroid/widget/TextView;

    .line 66
    iget-object v0, p0, Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;->check_box:Landroid/widget/CheckBox;

    new-instance v1, Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder$1;

    invoke-direct {v1, p0}, Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder$1;-><init>(Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;)V

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 74
    return-void
.end method

.method static synthetic access$0(Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;)Lcom/wjj/adapter/base/ApkSoftAdapter;
    .locals 1

    .prologue
    .line 54
    iget-object v0, p0, Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;->this$0:Lcom/wjj/adapter/base/ApkSoftAdapter;

    return-object v0
.end method
