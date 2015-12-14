.class Lcom/livemixtapes/MixtapeList$3;
.super Ljava/lang/Object;
.source "MixtapeList.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/MixtapeList;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
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
.field final synthetic this$0:Lcom/livemixtapes/MixtapeList;


# direct methods
.method constructor <init>(Lcom/livemixtapes/MixtapeList;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/MixtapeList$3;->this$0:Lcom/livemixtapes/MixtapeList;

    .line 83
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 4
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
    .line 89
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v1, p0, Lcom/livemixtapes/MixtapeList$3;->this$0:Lcom/livemixtapes/MixtapeList;

    iget-object v0, p0, Lcom/livemixtapes/MixtapeList$3;->this$0:Lcom/livemixtapes/MixtapeList;

    iget-object v2, v0, Lcom/livemixtapes/MixtapeList;->mContext:Landroid/content/Context;

    new-instance v3, Ljava/util/HashMap;

    iget-object v0, p0, Lcom/livemixtapes/MixtapeList$3;->this$0:Lcom/livemixtapes/MixtapeList;

    iget-object v0, v0, Lcom/livemixtapes/MixtapeList;->mixtapeList:Ljava/util/ArrayList;

    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map;

    invoke-direct {v3, v0}, Ljava/util/HashMap;-><init>(Ljava/util/Map;)V

    invoke-virtual {v1, v2, v3}, Lcom/livemixtapes/MixtapeList;->showMixtapeFragment(Landroid/content/Context;Ljava/util/HashMap;)V

    .line 90
    return-void
.end method
