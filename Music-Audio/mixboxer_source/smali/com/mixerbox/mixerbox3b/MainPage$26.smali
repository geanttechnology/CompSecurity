.class Lcom/mixerbox/mixerbox3b/MainPage$26;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field final synthetic this$0:Lcom/mixerbox/mixerbox3b/MainPage;


# direct methods
.method constructor <init>(Lcom/mixerbox/mixerbox3b/MainPage;)V
    .locals 0

    .prologue
    .line 1487
    iput-object p1, p0, Lcom/mixerbox/mixerbox3b/MainPage$26;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 7

    .prologue
    const v6, 0x7f0800ed

    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 1490
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$26;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    # getter for: Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->access$200(Lcom/mixerbox/mixerbox3b/MainPage;)Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    move-result-object v0

    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->removeMessages(I)V

    .line 1491
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$26;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    # getter for: Lcom/mixerbox/mixerbox3b/MainPage;->mHandlerTime:Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;
    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/MainPage;->access$200(Lcom/mixerbox/mixerbox3b/MainPage;)Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;

    move-result-object v0

    const-wide/16 v3, 0xfa0

    invoke-virtual {v0, v1, v3, v4}, Lcom/mixerbox/mixerbox3b/MainPage$MyHandler;->sendEmptyMessageDelayed(IJ)Z

    .line 1492
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$26;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-static {v0}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxSharedPreferences;->getHighQuality(Landroid/content/Context;)Z

    move-result v3

    .line 1493
    if-eqz v3, :cond_1

    .line 1494
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 1495
    const-string v4, "from"

    const-string v5, "player"

    invoke-interface {v0, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1496
    const-string v4, "hd"

    const-string v5, "0"

    invoke-interface {v0, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1497
    const-string v4, "action:set_hd"

    invoke-static {v4, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 1498
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$26;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v5, p0, Lcom/mixerbox/mixerbox3b/MainPage$26;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v5}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/mixerbox/mixerbox3b/MainPage$26;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v5}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f08007c

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v0, v4, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    .line 1510
    :goto_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$26;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentSettings:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    invoke-virtual {v0}, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1511
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$26;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    iget-object v0, v0, Lcom/mixerbox/mixerbox3b/MainPage;->fragmentSettings:Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;

    iget-object v4, v0, Lcom/mixerbox/mixerbox3b/fragments/SettingsFragment;->cbHD:Landroid/widget/CheckBox;

    if-nez v3, :cond_2

    move v0, v1

    :goto_1
    invoke-virtual {v4, v0}, Landroid/widget/CheckBox;->setChecked(Z)V

    .line 1512
    :cond_0
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$26;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    if-nez v3, :cond_3

    :goto_2
    invoke-virtual {v0, v1}, Lcom/mixerbox/mixerbox3b/MainPage;->changeQuality(Z)V

    .line 1513
    return-void

    .line 1502
    :cond_1
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 1503
    const-string v4, "from"

    const-string v5, "player"

    invoke-interface {v0, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1504
    const-string v4, "hd"

    const-string v5, "1"

    invoke-interface {v0, v4, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1505
    const-string v4, "action:set_hd"

    invoke-static {v4, v0}, Lcom/flurry/android/FlurryAgent;->logEvent(Ljava/lang/String;Ljava/util/Map;)V

    .line 1506
    iget-object v0, p0, Lcom/mixerbox/mixerbox3b/MainPage$26;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v5, p0, Lcom/mixerbox/mixerbox3b/MainPage$26;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v5}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/mixerbox/mixerbox3b/MainPage$26;->this$0:Lcom/mixerbox/mixerbox3b/MainPage;

    invoke-virtual {v5}, Lcom/mixerbox/mixerbox3b/MainPage;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    const v6, 0x7f08007d

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v0, v4, v2}, Lcom/mixerbox/mixerbox3b/utils/MixerBoxUtils;->toastMsg(Landroid/content/Context;Ljava/lang/String;I)V

    goto :goto_0

    :cond_2
    move v0, v2

    .line 1511
    goto :goto_1

    :cond_3
    move v1, v2

    .line 1512
    goto :goto_2
.end method
