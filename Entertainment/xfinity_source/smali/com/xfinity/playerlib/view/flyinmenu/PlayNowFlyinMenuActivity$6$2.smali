.class Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6$2;
.super Ljava/lang/Object;
.source "PlayNowFlyinMenuActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6;->onMenuItemActionCollapse(Landroid/view/MenuItem;)Z
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6;

    .prologue
    .line 280
    iput-object p1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6$2;->this$1:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 282
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6$2;->this$1:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$6;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->invalidateOptionsMenu()V

    .line 283
    return-void
.end method
