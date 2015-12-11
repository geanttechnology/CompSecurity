.class Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder$1;
.super Ljava/lang/Object;
.source "ApkSoftAdapter.java"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;-><init>(Lcom/wjj/adapter/base/ApkSoftAdapter;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;


# direct methods
.method constructor <init>(Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder$1;->this$1:Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;

    .line 66
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 2
    .param p1, "buttonView"    # Landroid/widget/CompoundButton;
    .param p2, "isChecked"    # Z

    .prologue
    .line 70
    iget-object v1, p0, Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder$1;->this$1:Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;

    iget-object v1, v1, Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;->check_box:Landroid/widget/CheckBox;

    invoke-virtual {v1}, Landroid/widget/CheckBox;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 71
    .local v0, "position":I
    iget-object v1, p0, Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder$1;->this$1:Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;

    # getter for: Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;->this$0:Lcom/wjj/adapter/base/ApkSoftAdapter;
    invoke-static {v1}, Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;->access$0(Lcom/wjj/adapter/base/ApkSoftAdapter$ViewHolder;)Lcom/wjj/adapter/base/ApkSoftAdapter;

    move-result-object v1

    iget-object v1, v1, Lcom/wjj/adapter/base/ApkSoftAdapter;->list:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/wjj/eneity/SoftApk;

    iput-boolean p2, v1, Lcom/wjj/eneity/SoftApk;->ischecked:Z

    .line 72
    return-void
.end method
