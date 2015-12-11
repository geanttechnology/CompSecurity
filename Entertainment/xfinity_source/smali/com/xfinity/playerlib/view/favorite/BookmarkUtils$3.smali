.class Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$3;
.super Ljava/lang/Object;
.source "BookmarkUtils.java"

# interfaces
.implements Landroid/content/DialogInterface$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;->showAddRemoveBookmarkDialog(Landroid/app/Fragment;ZLjava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    .prologue
    .line 79
    iput-object p1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarkUtils$3;->this$0:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/content/DialogInterface;I)V
    .locals 0
    .param p1, "dialog"    # Landroid/content/DialogInterface;
    .param p2, "which"    # I

    .prologue
    .line 82
    invoke-interface {p1}, Landroid/content/DialogInterface;->cancel()V

    .line 83
    return-void
.end method
