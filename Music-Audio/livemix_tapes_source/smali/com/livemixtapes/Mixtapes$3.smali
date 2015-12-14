.class Lcom/livemixtapes/Mixtapes$3;
.super Ljava/lang/Object;
.source "Mixtapes.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Mixtapes;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/Mixtapes;


# direct methods
.method constructor <init>(Lcom/livemixtapes/Mixtapes;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Mixtapes$3;->this$0:Lcom/livemixtapes/Mixtapes;

    .line 209
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/16 v3, 0x8

    const/4 v2, 0x0

    .line 213
    sget-object v0, Lcom/livemixtapes/App;->viewStyle:Ljava/lang/String;

    const-string v1, "grid"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 215
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$3;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v0, v0, Lcom/livemixtapes/Mixtapes;->grid:Landroid/widget/GridView;

    invoke-virtual {v0, v3}, Landroid/widget/GridView;->setVisibility(I)V

    .line 216
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$3;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v0, v0, Lcom/livemixtapes/Mixtapes;->listView:Lcom/livemixtapes/PullToRefreshListView;

    invoke-virtual {v0, v2}, Lcom/livemixtapes/PullToRefreshListView;->setVisibility(I)V

    .line 217
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$3;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v0, v0, Lcom/livemixtapes/Mixtapes;->adapter:Lcom/livemixtapes/LazyAdapterMixtapes;

    invoke-virtual {v0}, Lcom/livemixtapes/LazyAdapterMixtapes;->notifyDataSetChanged()V

    .line 218
    const-string v0, "list"

    sput-object v0, Lcom/livemixtapes/App;->viewStyle:Ljava/lang/String;

    .line 219
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$3;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v0, v0, Lcom/livemixtapes/Mixtapes;->layoutSwitchImage:Landroid/widget/ImageView;

    const v1, 0x7f02008c

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 230
    :cond_0
    :goto_0
    return-void

    .line 221
    :cond_1
    sget-object v0, Lcom/livemixtapes/App;->viewStyle:Ljava/lang/String;

    const-string v1, "list"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 223
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$3;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v0, v0, Lcom/livemixtapes/Mixtapes;->listView:Lcom/livemixtapes/PullToRefreshListView;

    invoke-virtual {v0, v3}, Lcom/livemixtapes/PullToRefreshListView;->setVisibility(I)V

    .line 224
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$3;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v0, v0, Lcom/livemixtapes/Mixtapes;->grid:Landroid/widget/GridView;

    invoke-virtual {v0, v2}, Landroid/widget/GridView;->setVisibility(I)V

    .line 225
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$3;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v0, v0, Lcom/livemixtapes/Mixtapes;->adapter:Lcom/livemixtapes/LazyAdapterMixtapes;

    invoke-virtual {v0}, Lcom/livemixtapes/LazyAdapterMixtapes;->notifyDataSetChanged()V

    .line 226
    const-string v0, "grid"

    sput-object v0, Lcom/livemixtapes/App;->viewStyle:Ljava/lang/String;

    .line 227
    iget-object v0, p0, Lcom/livemixtapes/Mixtapes$3;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v0, v0, Lcom/livemixtapes/Mixtapes;->layoutSwitchImage:Landroid/widget/ImageView;

    const v1, 0x7f02008b

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0
.end method
