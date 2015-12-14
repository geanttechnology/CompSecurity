.class Lcom/livemixtapes/profile/SelectedPlayList$5;
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
    iput-object p1, p0, Lcom/livemixtapes/profile/SelectedPlayList$5;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    .line 139
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 142
    iget-object v0, p0, Lcom/livemixtapes/profile/SelectedPlayList$5;->this$0:Lcom/livemixtapes/profile/SelectedPlayList;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/livemixtapes/profile/SelectedPlayList;->openNowPlaying(I)V

    .line 143
    return-void
.end method
