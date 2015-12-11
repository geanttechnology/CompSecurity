.class public Lcom/xfinity/playerlib/view/programdetails/DetailFragment$DetailFragmentSpeechListener;
.super Lcom/comcast/cim/android/accessibility/DefaultSpeechListener;
.source "DetailFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/programdetails/DetailFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "DetailFragmentSpeechListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;


# direct methods
.method protected constructor <init>(Lcom/xfinity/playerlib/view/programdetails/DetailFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    .prologue
    .line 1161
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$DetailFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-direct {p0}, Lcom/comcast/cim/android/accessibility/DefaultSpeechListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onSpeechResponsePlay([Ljava/lang/String;)Z
    .locals 2
    .param p1, "searchTerms"    # [Ljava/lang/String;

    .prologue
    .line 1166
    array-length v1, p1

    if-nez v1, :cond_1

    .line 1168
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$DetailFragmentSpeechListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->getFirstPlayButton()Landroid/widget/LinearLayout;

    move-result-object v0

    .line 1170
    .local v0, "playButton":Landroid/widget/LinearLayout;
    if-eqz v0, :cond_0

    .line 1171
    invoke-virtual {v0}, Landroid/widget/LinearLayout;->callOnClick()Z

    .line 1173
    :cond_0
    const/4 v1, 0x1

    .line 1175
    .end local v0    # "playButton":Landroid/widget/LinearLayout;
    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method
