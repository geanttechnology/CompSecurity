.class Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$4;
.super Ljava/lang/Object;
.source "BookmarksFragment.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->onLiveStreamPlayRequested(Lcom/xfinity/playerlib/model/LiveStreamFavorite;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

    .prologue
    .line 198
    iput-object p1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$4;->this$0:Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 201
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 202
    return-void
.end method
