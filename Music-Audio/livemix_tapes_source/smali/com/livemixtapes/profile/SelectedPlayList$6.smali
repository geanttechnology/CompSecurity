.class Lcom/livemixtapes/profile/SelectedPlayList$6;
.super Ljava/lang/Object;
.source "SelectedPlayList.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/profile/SelectedPlayList;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
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
.field final synthetic this$0:Lcom/livemixtapes/profile/SelectedPlayList;


# direct methods
.method constructor <init>(Lcom/livemixtapes/profile/SelectedPlayList;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/profile/SelectedPlayList$6;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    .line 163
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 1
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
    .line 168
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v0, p0, Lcom/livemixtapes/profile/SelectedPlayList$6;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    invoke-virtual {v0, p3}, Lcom/livemixtapes/profile/SelectedPlayList;->openNowPlaying(I)V

    .line 169
    return-void
.end method
