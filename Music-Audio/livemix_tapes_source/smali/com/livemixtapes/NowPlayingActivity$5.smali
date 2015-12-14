.class Lcom/livemixtapes/NowPlayingActivity$5;
.super Ljava/lang/Object;
.source "NowPlayingActivity.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/livemixtapes/NowPlayingActivity;->setListeners()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/livemixtapes/NowPlayingActivity;


# direct methods
.method constructor <init>(Lcom/livemixtapes/NowPlayingActivity;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/livemixtapes/NowPlayingActivity$5;->this$0:Lcom/livemixtapes/NowPlayingActivity;

    .line 598
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 601
    sget-boolean v0, Lcom/livemixtapes/NowPlayingActivity;->shuffleStatus:Z

    if-eqz v0, :cond_0

    .line 610
    new-instance v0, Ljava/util/ArrayList;

    sget-object v1, Lcom/livemixtapes/NowPlayingActivity;->savedTracksList:Ljava/util/ArrayList;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    sput-object v0, Lcom/livemixtapes/NowPlayingActivity;->tracksList:Ljava/util/ArrayList;

    .line 611
    sget-object v0, Lcom/livemixtapes/NowPlayingActivity;->shuffle:Lcom/livemixtapes/ui/FadeImageButton;

    const v1, 0x7f0200dd

    invoke-virtual {v0, v1}, Lcom/livemixtapes/ui/FadeImageButton;->setImageResource(I)V

    .line 618
    :goto_0
    sget-boolean v0, Lcom/livemixtapes/NowPlayingActivity;->shuffleStatus:Z

    if-eqz v0, :cond_1

    const/4 v0, 0x0

    :goto_1
    sput-boolean v0, Lcom/livemixtapes/NowPlayingActivity;->shuffleStatus:Z

    .line 619
    return-void

    .line 615
    :cond_0
    sget-object v0, Lcom/livemixtapes/NowPlayingActivity;->tracksList:Ljava/util/ArrayList;

    invoke-static {v0}, Ljava/util/Collections;->shuffle(Ljava/util/List;)V

    .line 616
    sget-object v0, Lcom/livemixtapes/NowPlayingActivity;->shuffle:Lcom/livemixtapes/ui/FadeImageButton;

    const v1, 0x7f0200dc

    invoke-virtual {v0, v1}, Lcom/livemixtapes/ui/FadeImageButton;->setImageResource(I)V

    goto :goto_0

    .line 618
    :cond_1
    const/4 v0, 0x1

    goto :goto_1
.end method
