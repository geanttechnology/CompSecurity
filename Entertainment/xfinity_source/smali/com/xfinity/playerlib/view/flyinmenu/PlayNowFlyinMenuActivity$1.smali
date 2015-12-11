.class Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$1;
.super Ljava/lang/Object;
.source "PlayNowFlyinMenuActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->onCreate(Landroid/os/Bundle;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    .prologue
    .line 102
    iput-object p1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$1;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 104
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$1;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->searchMenuItem:Landroid/view/MenuItem;

    invoke-interface {v0}, Landroid/view/MenuItem;->collapseActionView()Z

    .line 105
    return-void
.end method
