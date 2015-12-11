.class Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$3;
.super Ljava/lang/Object;
.source "TabletFeaturedFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->showLastWatched(Lcom/xfinity/playerlib/bookmarks/Bookmark;Landroid/widget/ProgressBar;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

.field final synthetic val$bookmark:Lcom/xfinity/playerlib/bookmarks/Bookmark;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;Lcom/xfinity/playerlib/bookmarks/Bookmark;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    .prologue
    .line 275
    iput-object p1, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$3;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$3;->val$bookmark:Lcom/xfinity/playerlib/bookmarks/Bookmark;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 279
    new-instance v3, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$3;->val$bookmark:Lcom/xfinity/playerlib/bookmarks/Bookmark;

    check-cast v2, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    invoke-direct {v3, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;-><init>(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    const/4 v2, 0x1

    .line 281
    invoke-virtual {v3, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->loadAsActivity(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v2

    .line 282
    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    move-result-object v0

    .line 284
    .local v0, "detailIntentHelper":Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v1

    .line 286
    .local v1, "intent":Landroid/content/Intent;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment$3;->this$0:Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;

    invoke-virtual {v2, v1}, Lcom/xfinity/playerlib/view/featured/TabletFeaturedFragment;->startActivity(Landroid/content/Intent;)V

    .line 287
    return-void
.end method
