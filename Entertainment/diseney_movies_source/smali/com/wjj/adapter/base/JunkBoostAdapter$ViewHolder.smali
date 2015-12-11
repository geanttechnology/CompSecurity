.class Lcom/wjj/adapter/base/JunkBoostAdapter$ViewHolder;
.super Ljava/lang/Object;
.source "JunkBoostAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/wjj/adapter/base/JunkBoostAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ViewHolder"
.end annotation


# instance fields
.field check_box:Landroid/widget/CheckBox;

.field iv_icon:Landroid/widget/ImageView;

.field final synthetic this$0:Lcom/wjj/adapter/base/JunkBoostAdapter;

.field tv_appname:Landroid/widget/TextView;

.field tv_appsize:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Lcom/wjj/adapter/base/JunkBoostAdapter;Landroid/view/View;)V
    .locals 2
    .param p2, "parent"    # Landroid/view/View;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/wjj/adapter/base/JunkBoostAdapter$ViewHolder;->this$0:Lcom/wjj/adapter/base/JunkBoostAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 49
    const v0, 0x7f070254

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    iput-object v0, p0, Lcom/wjj/adapter/base/JunkBoostAdapter$ViewHolder;->check_box:Landroid/widget/CheckBox;

    .line 50
    const v0, 0x7f070252

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/wjj/adapter/base/JunkBoostAdapter$ViewHolder;->iv_icon:Landroid/widget/ImageView;

    .line 51
    const v0, 0x7f07024e

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wjj/adapter/base/JunkBoostAdapter$ViewHolder;->tv_appname:Landroid/widget/TextView;

    .line 52
    const v0, 0x7f070253

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wjj/adapter/base/JunkBoostAdapter$ViewHolder;->tv_appsize:Landroid/widget/TextView;

    .line 54
    iget-object v0, p0, Lcom/wjj/adapter/base/JunkBoostAdapter$ViewHolder;->check_box:Landroid/widget/CheckBox;

    new-instance v1, Lcom/wjj/adapter/base/JunkBoostAdapter$ViewHolder$1;

    invoke-direct {v1, p0}, Lcom/wjj/adapter/base/JunkBoostAdapter$ViewHolder$1;-><init>(Lcom/wjj/adapter/base/JunkBoostAdapter$ViewHolder;)V

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 62
    return-void
.end method

.method static synthetic access$0(Lcom/wjj/adapter/base/JunkBoostAdapter$ViewHolder;)Lcom/wjj/adapter/base/JunkBoostAdapter;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/wjj/adapter/base/JunkBoostAdapter$ViewHolder;->this$0:Lcom/wjj/adapter/base/JunkBoostAdapter;

    return-object v0
.end method
