.class Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$PlayButtonOnClickListener;
.super Ljava/lang/Object;
.source "DownloadsArrayAdapter.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "PlayButtonOnClickListener"
.end annotation


# instance fields
.field final playerDownloadFile:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

.field final synthetic this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

.field final videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;
    .param p2, "videoFacade"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p3, "playerDownloadFile"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 74
    iput-object p1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$PlayButtonOnClickListener;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 75
    iput-object p2, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$PlayButtonOnClickListener;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 76
    iput-object p3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$PlayButtonOnClickListener;->playerDownloadFile:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .line 77
    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 4
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 81
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    .line 82
    .local v0, "context":Landroid/content/Context;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$PlayButtonOnClickListener;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    # getter for: Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->access$000(Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;)Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$PlayButtonOnClickListener;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getProviderCode()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitled(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 83
    iget-object v2, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$PlayButtonOnClickListener;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->listener:Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$PlayButtonOnClickListener;->playerDownloadFile:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-interface {v2, v0, v3}, Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;->onPlayEntitledDownloadPressed(Landroid/content/Context;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    .line 90
    .end local v0    # "context":Landroid/content/Context;
    :cond_0
    :goto_0
    return-void

    .line 85
    .restart local v0    # "context":Landroid/content/Context;
    :cond_1
    instance-of v2, v0, Landroid/support/v4/app/FragmentActivity;

    if-eqz v2, :cond_0

    .line 86
    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    .end local v0    # "context":Landroid/content/Context;
    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    .line 87
    .local v1, "fm":Landroid/app/FragmentManager;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$PlayButtonOnClickListener;->this$0:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->listener:Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter$PlayButtonOnClickListener;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-interface {v2, v1, v3}, Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;->onPlayUnentitledDownloadPressed(Landroid/app/FragmentManager;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V

    goto :goto_0
.end method
