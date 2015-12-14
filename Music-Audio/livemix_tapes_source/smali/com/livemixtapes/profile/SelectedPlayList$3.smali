.class Lcom/livemixtapes/profile/SelectedPlayList$3;
.super Ljava/lang/Object;
.source "SelectedPlayList.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/profile/SelectedPlayList;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/profile/SelectedPlayList;


# direct methods
.method constructor <init>(Lcom/livemixtapes/profile/SelectedPlayList;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/profile/SelectedPlayList$3;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    .line 92
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/livemixtapes/profile/SelectedPlayList$3;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    invoke-virtual {v0}, Lcom/livemixtapes/profile/SelectedPlayList;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->onBackPressed()V

    .line 98
    return-void
.end method
