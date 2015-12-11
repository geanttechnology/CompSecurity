.class Lcom/mixerbox/mixerbox3b/MainPage$7;
.super Landroid/view/OrientationEventListener;
.source "SourceFile"


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;Landroid/content/Context;I)V
    .locals 0

    .prologue
    .line 564
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {p0, p2, p3}, Landroid/view/OrientationEventListener;-><init>(Landroid/content/Context;I)V

    return-void
.end method


# virtual methods
.method public onOrientationChanged(I)V
    .locals 4

    .prologue
    const/4 v1, -0x1

    const/4 v3, 0x0

    const/4 v2, 0x1

    .line 567
    if-eq p1, v1, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-boolean v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->isForeground:Z

    if-nez v0, :cond_1

    .line 606
    :cond_0
    :goto_0
    return-void

    .line 569
    :cond_1
    if-ltz p1, :cond_2

    const/16 v0, 0x2d

    if-le p1, v0, :cond_3

    :cond_2
    const/16 v0, 0x13b

    if-ge p1, v0, :cond_3

    const/16 v0, 0x87

    if-lt p1, v0, :cond_5

    const/16 v0, 0xe1

    if-gt p1, v0, :cond_5

    .line 570
    :cond_3
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput v2, v0, Lcom/mixerbox/mixerbox3b/MainPage;->curOri:I

    .line 574
    :goto_1
    sget-boolean v0, Lcom/mixerbox/mixerbox3b/MainPage;->defaultPortrait:Z

    if-nez v0, :cond_4

    .line 575
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->curOri:I

    if-ne v0, v2, :cond_6

    .line 576
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput v3, v0, Lcom/mixerbox/mixerbox3b/MainPage;->curOri:I

    .line 581
    :cond_4
    :goto_2
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->preOri:I

    if-ne v0, v1, :cond_7

    .line 582
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->curOri:I

    iput v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->preOri:I

    goto :goto_0

    .line 572
    :cond_5
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput v3, v0, Lcom/mixerbox/mixerbox3b/MainPage;->curOri:I

    goto :goto_1

    .line 578
    :cond_6
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iput v2, v0, Lcom/mixerbox/mixerbox3b/MainPage;->curOri:I

    goto :goto_2

    .line 585
    :cond_7
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->preOri:I

    if-eq v0, v1, :cond_8

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->preOri:I

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->curOri:I

    if-eq v0, v1, :cond_0

    .line 587
    :cond_8
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v1, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v1, v1, Lcom/mixerbox/mixerbox3b/MainPage;->curOri:I

    iput v1, v0, Lcom/mixerbox/mixerbox3b/MainPage;->preOri:I

    .line 589
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    if-eqz v0, :cond_9

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/DrawView;->isShown()Z

    move-result v0

    if-eqz v0, :cond_9

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string v1, "accelerometer_rotation"

    invoke-static {v0, v1, v3}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v0

    if-ne v0, v2, :cond_9

    .line 591
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->guideView:Lcom/mixerbox/mixerbox3b/classes/DrawView;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/classes/DrawView;->performClick()Z

    .line 594
    :cond_9
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->curOri:I

    if-ne v0, v2, :cond_a

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->SCREEN_STATE:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_a

    .line 595
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0, v2}, Lcom/mixerbox/mixerbox3b/MainPage;->setUnFullScreen(Z)V

    goto/16 :goto_0

    .line 596
    :cond_a
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->curOri:I

    if-ne v0, v2, :cond_b

    .line 597
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v1, 0x7

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setRequestedOrientation(I)V

    goto/16 :goto_0

    .line 598
    :cond_b
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->curOri:I

    if-nez v0, :cond_c

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string v1, "accelerometer_rotation"

    invoke-static {v0, v1, v3}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v0

    if-ne v0, v2, :cond_c

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->rlVideoPlayer:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v0

    if-nez v0, :cond_c

    .line 601
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->setFullScreen()V

    goto/16 :goto_0

    .line 602
    :cond_c
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->curOri:I

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    const-string v1, "accelerometer_rotation"

    invoke-static {v0, v1, v3}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v0

    if-ne v0, v2, :cond_0

    .line 604
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$7;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    const/4 v1, 0x6

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->setRequestedOrientation(I)V

    goto/16 :goto_0
.end method
