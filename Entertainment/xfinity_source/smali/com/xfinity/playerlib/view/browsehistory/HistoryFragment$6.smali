.class Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$6;
.super Ljava/lang/Object;
.source "HistoryFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->onLiveStreamPlayRequested(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    .prologue
    .line 210
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$6;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 213
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 214
    return-void
.end method
