.class Lco/vine/android/ConversationAdapter$3;
.super Ljava/lang/Object;
.source "ConversationAdapter.java"

# interfaces
.implements Lco/vine/android/player/VideoViewInterface$OnPreparedListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lco/vine/android/ConversationAdapter;->initVideoView(ILco/vine/android/ConversationAdapter$ConversationViewHolder;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lco/vine/android/ConversationAdapter;

.field final synthetic val$holder:Lco/vine/android/ConversationAdapter$ConversationViewHolder;

.field final synthetic val$position:I


# direct methods
.method constructor <init>(Lco/vine/android/ConversationAdapter;Lco/vine/android/ConversationAdapter$ConversationViewHolder;I)V
    .locals 0

    .prologue
    .line 935
    iput-object p1, p0, Lco/vine/android/ConversationAdapter$3;->this$0:Lco/vine/android/ConversationAdapter;

    iput-object p2, p0, Lco/vine/android/ConversationAdapter$3;->val$holder:Lco/vine/android/ConversationAdapter$ConversationViewHolder;

    iput p3, p0, Lco/vine/android/ConversationAdapter$3;->val$position:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onPrepared(Lco/vine/android/player/VideoViewInterface;)V
    .locals 3
    .param p1, "view"    # Lco/vine/android/player/VideoViewInterface;

    .prologue
    .line 938
    iget-object v1, p0, Lco/vine/android/ConversationAdapter$3;->val$holder:Lco/vine/android/ConversationAdapter$ConversationViewHolder;

    iget-boolean v1, v1, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->isCurrentUser:Z

    if-eqz v1, :cond_1

    .line 939
    invoke-interface {p1}, Lco/vine/android/player/VideoViewInterface;->start()V

    .line 940
    iget-object v1, p0, Lco/vine/android/ConversationAdapter$3;->this$0:Lco/vine/android/ConversationAdapter;

    iget-object v2, p0, Lco/vine/android/ConversationAdapter$3;->val$holder:Lco/vine/android/ConversationAdapter$ConversationViewHolder;

    invoke-virtual {v1, v2}, Lco/vine/android/ConversationAdapter;->onLoadFinish(Lco/vine/android/ConversationAdapter$ConversationViewHolder;)V

    .line 962
    :cond_0
    :goto_0
    iget-object v1, p0, Lco/vine/android/ConversationAdapter$3;->val$holder:Lco/vine/android/ConversationAdapter$ConversationViewHolder;

    iget-object v1, v1, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->nibs:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->bringToFront()V

    .line 963
    iget-object v1, p0, Lco/vine/android/ConversationAdapter$3;->val$holder:Lco/vine/android/ConversationAdapter$ConversationViewHolder;

    iget-object v1, v1, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->postNibs:Landroid/view/View;

    invoke-virtual {v1}, Landroid/view/View;->bringToFront()V

    .line 964
    return-void

    .line 942
    :cond_1
    iget-object v1, p0, Lco/vine/android/ConversationAdapter$3;->this$0:Lco/vine/android/ConversationAdapter;

    iget v2, p0, Lco/vine/android/ConversationAdapter$3;->val$position:I

    # invokes: Lco/vine/android/ConversationAdapter;->getSeekInfoMarkAsRead(Lco/vine/android/player/VideoViewInterface;I)Lco/vine/android/util/SeekInfoManager$SeekInfo;
    invoke-static {v1, p1, v2}, Lco/vine/android/ConversationAdapter;->access$500(Lco/vine/android/ConversationAdapter;Lco/vine/android/player/VideoViewInterface;I)Lco/vine/android/util/SeekInfoManager$SeekInfo;

    move-result-object v0

    .line 943
    .local v0, "seek":Lco/vine/android/util/SeekInfoManager$SeekInfo;
    if-nez v0, :cond_2

    .line 944
    const-string v1, "Invalid state onPrepared."

    invoke-static {v1}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    goto :goto_0

    .line 946
    :cond_2
    invoke-virtual {v0}, Lco/vine/android/util/SeekInfoManager$SeekInfo;->isExpired()Z

    move-result v1

    if-nez v1, :cond_4

    .line 947
    invoke-virtual {v0}, Lco/vine/android/util/SeekInfoManager$SeekInfo;->hasLoopLimit()Z

    move-result v1

    if-eqz v1, :cond_3

    invoke-virtual {v0}, Lco/vine/android/util/SeekInfoManager$SeekInfo;->isExpired()Z

    move-result v1

    if-nez v1, :cond_3

    .line 948
    invoke-virtual {v0}, Lco/vine/android/util/SeekInfoManager$SeekInfo;->getSeekTime()I

    move-result v1

    invoke-interface {p1, v1}, Lco/vine/android/player/VideoViewInterface;->seekTo(I)V

    .line 949
    iget-object v1, p0, Lco/vine/android/ConversationAdapter$3;->val$holder:Lco/vine/android/ConversationAdapter$ConversationViewHolder;

    iget-object v1, v1, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->vanishTimerText:Landroid/widget/TextView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 950
    iget-object v1, p0, Lco/vine/android/ConversationAdapter$3;->val$holder:Lco/vine/android/ConversationAdapter$ConversationViewHolder;

    iget-object v1, v1, Lco/vine/android/ConversationAdapter$ConversationViewHolder;->vanishTimerText:Landroid/widget/TextView;

    invoke-virtual {v0}, Lco/vine/android/util/SeekInfoManager$SeekInfo;->getLoopsLeftForDisplay()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 952
    :cond_3
    invoke-virtual {v0}, Lco/vine/android/util/SeekInfoManager$SeekInfo;->isExpired()Z

    move-result v1

    if-nez v1, :cond_0

    .line 953
    invoke-interface {p1}, Lco/vine/android/player/VideoViewInterface;->start()V

    .line 954
    iget-object v1, p0, Lco/vine/android/ConversationAdapter$3;->this$0:Lco/vine/android/ConversationAdapter;

    iget-object v2, p0, Lco/vine/android/ConversationAdapter$3;->val$holder:Lco/vine/android/ConversationAdapter$ConversationViewHolder;

    invoke-virtual {v1, v2}, Lco/vine/android/ConversationAdapter;->onLoadFinish(Lco/vine/android/ConversationAdapter$ConversationViewHolder;)V

    goto :goto_0

    .line 957
    :cond_4
    iget-object v1, p0, Lco/vine/android/ConversationAdapter$3;->this$0:Lco/vine/android/ConversationAdapter;

    iget v2, p0, Lco/vine/android/ConversationAdapter$3;->val$position:I

    # invokes: Lco/vine/android/ConversationAdapter;->onLoopFinished(Lco/vine/android/player/VideoViewInterface;I)Z
    invoke-static {v1, p1, v2}, Lco/vine/android/ConversationAdapter;->access$600(Lco/vine/android/ConversationAdapter;Lco/vine/android/player/VideoViewInterface;I)Z

    goto :goto_0
.end method
