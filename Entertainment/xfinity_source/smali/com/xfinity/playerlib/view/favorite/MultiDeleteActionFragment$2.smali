.class Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment$2;
.super Ljava/lang/Object;
.source "MultiDeleteActionFragment.java"

# interfaces
.implements Landroid/view/MenuItem$OnMenuItemClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;

    .prologue
    .line 102
    iput-object p1, p0, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment$2;->this$0:Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onMenuItemClick(Landroid/view/MenuItem;)Z
    .locals 1
    .param p1, "menuItem"    # Landroid/view/MenuItem;

    .prologue
    .line 105
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment$2;->this$0:Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->startActionMode()V

    .line 106
    const/4 v0, 0x0

    return v0
.end method
