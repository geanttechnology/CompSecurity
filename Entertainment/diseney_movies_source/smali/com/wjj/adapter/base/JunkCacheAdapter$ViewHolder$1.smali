.class Lcom/wjj/adapter/base/JunkCacheAdapter$ViewHolder$1;
.super Ljava/lang/Object;
.source "JunkCacheAdapter.java"

# interfaces
.implements Landroid/widget/CompoundButton$OnCheckedChangeListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/wjj/adapter/base/JunkCacheAdapter$ViewHolder;-><init>(Lcom/wjj/adapter/base/JunkCacheAdapter;Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/wjj/adapter/base/JunkCacheAdapter$ViewHolder;


# direct methods
.method constructor <init>(Lcom/wjj/adapter/base/JunkCacheAdapter$ViewHolder;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/wjj/adapter/base/JunkCacheAdapter$ViewHolder$1;->this$1:Lcom/wjj/adapter/base/JunkCacheAdapter$ViewHolder;

    .line 54
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onCheckedChanged(Landroid/widget/CompoundButton;Z)V
    .locals 2
    .param p1, "buttonView"    # Landroid/widget/CompoundButton;
    .param p2, "isChecked"    # Z

    .prologue
    .line 58
    iget-object v1, p0, Lcom/wjj/adapter/base/JunkCacheAdapter$ViewHolder$1;->this$1:Lcom/wjj/adapter/base/JunkCacheAdapter$ViewHolder;

    iget-object v1, v1, Lcom/wjj/adapter/base/JunkCacheAdapter$ViewHolder;->check_box:Landroid/widget/CheckBox;

    invoke-virtual {v1}, Landroid/widget/CheckBox;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/Integer;

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 59
    .local v0, "position":I
    iget-object v1, p0, Lcom/wjj/adapter/base/JunkCacheAdapter$ViewHolder$1;->this$1:Lcom/wjj/adapter/base/JunkCacheAdapter$ViewHolder;

    # getter for: Lcom/wjj/adapter/base/JunkCacheAdapter$ViewHolder;->this$0:Lcom/wjj/adapter/base/JunkCacheAdapter;
    invoke-static {v1}, Lcom/wjj/adapter/base/JunkCacheAdapter$ViewHolder;->access$0(Lcom/wjj/adapter/base/JunkCacheAdapter$ViewHolder;)Lcom/wjj/adapter/base/JunkCacheAdapter;

    move-result-object v1

    iget-object v1, v1, Lcom/wjj/adapter/base/JunkCacheAdapter;->list:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/wjj/eneity/RubSoftware;

    iput-boolean p2, v1, Lcom/wjj/eneity/RubSoftware;->ischecked:Z

    .line 60
    return-void
.end method
