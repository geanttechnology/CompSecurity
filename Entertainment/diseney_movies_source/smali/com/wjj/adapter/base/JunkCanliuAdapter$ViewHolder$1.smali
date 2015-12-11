.class Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder$1;
.super Ljava/lang/Object;
.source "JunkCanliuAdapter.java"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;-><init>(Lcom/wjj/adapter/base/JunkCanliuAdapter;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;


# direct methods
.method constructor <init>(Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder$1;->this$1:Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;

    .line 50
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 2
    .param p1, "buttonView"    # Landroid/widget/CompoundButton;
    .param p2, "isChecked"    # Z

    .prologue
    .line 54
    iget-object v1, p0, Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder$1;->this$1:Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;

    iget-object v1, v1, Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;->check_box:Landroid/widget/CheckBox;

    invoke-virtual {v1}, Landroid/widget/CheckBox;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 55
    .local v0, "position":I
    iget-object v1, p0, Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder$1;->this$1:Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;

    # getter for: Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;->this$0:Lcom/wjj/adapter/base/JunkCanliuAdapter;
    invoke-static {v1}, Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;->access$0(Lcom/wjj/adapter/base/JunkCanliuAdapter$ViewHolder;)Lcom/wjj/adapter/base/JunkCanliuAdapter;

    move-result-object v1

    iget-object v1, v1, Lcom/wjj/adapter/base/JunkCanliuAdapter;->list:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/wjj/eneity/Canliu;

    iput-boolean p2, v1, Lcom/wjj/eneity/Canliu;->ischecked:Z

    .line 56
    return-void
.end method
