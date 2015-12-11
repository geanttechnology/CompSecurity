.class Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$3$1;
.super Ljava/lang/Object;
.source "HistoryFragment.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$3;->onClick(Landroid/view/View;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$3;

.field final synthetic val$activity:Landroid/app/Activity;

.field final synthetic val$view:Landroid/view/View;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$3;Landroid/app/Activity;Landroid/view/View;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$3;

    .prologue
    .line 161
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$3$1;->this$1:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$3;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$3$1;->val$activity:Landroid/app/Activity;

    iput-object p3, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$3$1;->val$view:Landroid/view/View;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 164
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$3$1;->val$activity:Landroid/app/Activity;

    check-cast v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$VideoPlayOrResumePressedListener;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$3$1;->val$view:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    invoke-interface {v0, v1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$VideoPlayOrResumePressedListener;->onVideoPlayOrResumePressed(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    .line 165
    return-void
.end method
