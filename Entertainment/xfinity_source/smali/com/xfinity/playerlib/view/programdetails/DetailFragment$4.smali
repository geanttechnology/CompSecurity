.class Lcom/xfinity/playerlib/view/programdetails/DetailFragment$4;
.super Ljava/lang/Object;
.source "DetailFragment.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->buildPlayLaunchDownloadClickListener(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;)Landroid/view/View$OnClickListener;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

.field final synthetic val$playPressedListener:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;

.field final synthetic val$video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

.field final synthetic val$watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    .prologue
    .line 1053
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$4;->val$playPressedListener:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;

    iput-object p3, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$4;->val$video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    iput-object p4, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$4;->val$watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 1056
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$4;->val$playPressedListener:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$4;->val$video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$4;->val$watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;

    invoke-interface {v0, v1, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;->onPlayOrResumePressed(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V

    .line 1057
    return-void
.end method
