.class Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$EpisodeDetailFragmentSpeechListener;
.super Lcom/comcast/cim/android/accessibility/DefaultSpeechListener;
.source "EpisodeDetailFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "EpisodeDetailFragmentSpeechListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;


# direct methods
.method private constructor <init>(Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;)V
    .locals 0

    .prologue
    .line 351
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$EpisodeDetailFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    invoke-direct {p0}, Lcom/comcast/cim/android/accessibility/DefaultSpeechListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;
    .param p2, "x1"    # Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$1;

    .prologue
    .line 351
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$EpisodeDetailFragmentSpeechListener;-><init>(Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;)V

    return-void
.end method


# virtual methods
.method public onSpeechResponsePlay([Ljava/lang/String;)Z
    .locals 2
    .param p1, "searchTerms"    # [Ljava/lang/String;

    .prologue
    .line 356
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$EpisodeDetailFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->getFirstPlayButton()Landroid/widget/LinearLayout;

    move-result-object v0

    .line 358
    .local v0, "playButton":Landroid/widget/LinearLayout;
    if-eqz v0, :cond_0

    .line 359
    invoke-virtual {v0}, Landroid/widget/LinearLayout;->callOnClick()Z

    .line 362
    :cond_0
    const/4 v1, 0x1

    return v1
.end method
