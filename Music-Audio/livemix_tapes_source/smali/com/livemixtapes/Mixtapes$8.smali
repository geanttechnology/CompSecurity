.class Lcom/livemixtapes/Mixtapes$8;
.super Ljava/lang/Object;
.source "Mixtapes.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/Mixtapes;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Landroid/widget/AdapterView$OnItemClickListener;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/Mixtapes;


# direct methods
.method constructor <init>(Lcom/livemixtapes/Mixtapes;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/Mixtapes$8;->this$0:Lcom/livemixtapes/Mixtapes;

    .line 305
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 3
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 308
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes$8;->this$0:Lcom/livemixtapes/Mixtapes;

    iget-object v1, v1, Lcom/livemixtapes/Mixtapes;->mixtapelist:Ljava/util/ArrayList;

    invoke-virtual {v1, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/HashMap;

    .line 309
    .local v0, "tracksData":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    iget-object v1, p0, Lcom/livemixtapes/Mixtapes$8;->this$0:Lcom/livemixtapes/Mixtapes;

    const/4 v2, 0x0

    # invokes: Lcom/livemixtapes/Mixtapes;->loadMixtapeFragment(Ljava/util/HashMap;I)V
    invoke-static {v1, v0, v2}, Lcom/livemixtapes/Mixtapes;->access$7(Lcom/livemixtapes/Mixtapes;Ljava/util/HashMap;I)V

    .line 310
    return-void
.end method
