.class Lcom/livemixtapes/profile/SeeAllList$2;
.super Ljava/lang/Object;
.source "SeeAllList.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/profile/SeeAllList;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/profile/SeeAllList;


# direct methods
.method constructor <init>(Lcom/livemixtapes/profile/SeeAllList;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/profile/SeeAllList$2;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    .line 98
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 5
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v4, 0x1

    .line 101
    iget-object v0, p0, Lcom/livemixtapes/profile/SeeAllList$2;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    iget-boolean v0, v0, Lcom/livemixtapes/profile/SeeAllList;->isAddTracksToPlayList:Z

    if-eqz v0, :cond_0

    .line 102
    new-instance v0, Lcom/livemixtapes/profile/SeeAllList$AddtoPlayList;

    iget-object v1, p0, Lcom/livemixtapes/profile/SeeAllList$2;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    invoke-direct {v0, v1, v4}, Lcom/livemixtapes/profile/SeeAllList$AddtoPlayList;-><init>(Lcom/livemixtapes/profile/SeeAllList;I)V

    const/4 v1, 0x3

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const-string v3, "playlist/create"

    aput-object v3, v1, v2

    const-string v2, ""

    aput-object v2, v1, v4

    const/4 v2, 0x2

    iget-object v3, p0, Lcom/livemixtapes/profile/SeeAllList$2;->this$0:Lcom/livemixtapes/profile/SeeAllList;

    invoke-virtual {v3}, Lcom/livemixtapes/profile/SeeAllList;->getArguments()Landroid/os/Bundle;

    move-result-object v3

    .line 103
    const-string v4, "tracks"

    invoke-virtual {v3, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    .line 102
    invoke-virtual {v0, v1}, Lcom/livemixtapes/profile/SeeAllList$AddtoPlayList;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 104
    :cond_0
    return-void
.end method
