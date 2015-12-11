.class Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;
.super Ljava/lang/Object;
.source "JunkCanliuAdapter.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/wjj/adapter/base/JunkCanliuAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "ViewHolder"
.end annotation


# instance fields
.field check_box:Landroid/widget/CheckBox;

.field name:Landroid/widget/TextView;

.field size:Landroid/widget/TextView;

.field final synthetic this$0:Lcom/wjj/adapter/base/JunkCanliuAdapter;


# direct methods
.method public constructor <init>(Lcom/wjj/adapter/base/JunkCanliuAdapter;Landroid/view/View;)V
    .locals 2
    .param p2, "parent"    # Landroid/view/View;

    .prologue
    .line 45
    iput-object p1, p0, Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;->this$0:Lcom/wjj/adapter/base/JunkCanliuAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    const v0, 0x7f07025b

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    iput-object v0, p0, Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;->check_box:Landroid/widget/CheckBox;

    .line 47
    const v0, 0x7f070259

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;->name:Landroid/widget/TextView;

    .line 48
    const v0, 0x7f07025a

    invoke-virtual {p2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;->size:Landroid/widget/TextView;

    .line 50
    iget-object v0, p0, Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;->check_box:Landroid/widget/CheckBox;

    new-instance v1, Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder$1;

    invoke-direct {v1, p0}, Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder$1;-><init>(Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;)V

    invoke-virtual {v0, v1}, Landroid/widget/CheckBox;->setOnCheckedChangeListener(Landroid/widget/CompoundButton$OnCheckedChangeListener;)V

    .line 58
    return-void
.end method

.method static synthetic access$0(Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;)Lcom/wjj/adapter/base/JunkCanliuAdapter;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;->this$0:Lcom/wjj/adapter/base/JunkCanliuAdapter;

    return-object v0
.end method
