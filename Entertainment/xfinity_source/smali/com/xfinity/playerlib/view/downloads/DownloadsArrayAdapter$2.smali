.class Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$2;
.super Ljava/lang/Object;
.source "DownloadsArrayAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

.field final synthetic val$holder:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    .prologue
    .line 154
    iput-object p1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$2;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$2;->val$holder:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 157
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$2;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->listener:Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;

    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$2;->val$holder:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$DownloadableItemHolder;->playerDownloadFile:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-interface {v0, v1, v2}, Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;->onHotwireDownloadPressed(Landroid/content/Context;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    .line 158
    return-void
.end method
