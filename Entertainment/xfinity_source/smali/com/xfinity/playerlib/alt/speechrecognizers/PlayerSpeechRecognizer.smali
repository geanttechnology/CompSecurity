.class public Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;
.super Lcom/comcast/cim/android/accessibility/SpeechRecognizer;
.source "PlayerSpeechRecognizer.java"

# interfaces
.implements Landroid/content/DialogInterface$OnCancelListener;
.implements Landroid/content/DialogInterface$OnDismissListener;


# instance fields
.field private sortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/xfinity/playerlib/view/browseprograms/SortPolicy",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;"
        }
    .end annotation
.end field

.field private taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;>;"
        }
    .end annotation
.end field

.field private taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 38
    invoke-direct {p0}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;-><init>()V

    .line 40
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getProgramsAndTagsAndEntitlementTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    return-void
.end method

.method static synthetic access$001(Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;I)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;
    .param p1, "x1"    # I

    .prologue
    .line 38
    invoke-super {p0, p1}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->onError(I)V

    return-void
.end method


# virtual methods
.method public attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    .locals 2
    .param p1, "terms"    # [Ljava/lang/String;
    .param p2, "presentationMode"    # Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    .prologue
    .line 47
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    new-instance v1, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer$1;

    invoke-direct {v1, p0, p1, p2}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer$1;-><init>(Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 85
    return-void
.end method

.method protected checkTitleMatch(Ljava/lang/String;Ljava/lang/String;)Z
    .locals 1
    .param p1, "title"    # Ljava/lang/String;
    .param p2, "filterText"    # Ljava/lang/String;

    .prologue
    .line 183
    invoke-virtual {p1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    return v0
.end method

.method protected closeWithAction(Lcom/comcast/cim/android/accessibility/SpeechActions;)V
    .locals 5
    .param p1, "speechAction"    # Lcom/comcast/cim/android/accessibility/SpeechActions;

    .prologue
    .line 126
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 127
    .local v1, "callingActivityIntent":Landroid/content/Intent;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 129
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v2, "KEY_ACTION"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 130
    invoke-virtual {v1, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 132
    const/4 v2, -0x1

    invoke-virtual {p0, v2, v1}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->setResult(ILandroid/content/Intent;)V

    .line 134
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->finish()V

    .line 135
    return-void
.end method

.method protected closeWithIgnore()V
    .locals 5

    .prologue
    .line 140
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 141
    .local v1, "callingActivityIntent":Landroid/content/Intent;
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 143
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v2, "KEY_ACTION"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/comcast/cim/android/accessibility/SpeechActions;->IGNORE_REENTRY:Lcom/comcast/cim/android/accessibility/SpeechActions;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 144
    invoke-virtual {v1, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 146
    const/4 v2, -0x1

    invoke-virtual {p0, v2, v1}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->setResult(ILandroid/content/Intent;)V

    .line 148
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->finish()V

    .line 149
    return-void
.end method

.method protected closeWithNotEntitledDibicProgram(Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;)V
    .locals 3
    .param p1, "dibicProgram"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .param p2, "upsellType"    # Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    .prologue
    .line 292
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    .line 293
    .local v0, "fm":Landroid/app/FragmentManager;
    invoke-static {p2, p1}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->newInstance(Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;Lcom/xfinity/playerlib/model/dibic/DibicProgram;)Lcom/xfinity/playerlib/view/common/UpsellDialog;

    move-result-object v1

    .line 294
    .local v1, "upsellDialog":Lcom/xfinity/playerlib/view/common/UpsellDialog;
    const-string v2, "upsell_dialog"

    invoke-virtual {v1, v0, v2}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 295
    invoke-virtual {v1, p0}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 296
    invoke-virtual {v1, p0}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 297
    return-void
.end method

.method protected createSearchIntent([Ljava/lang/String;)V
    .locals 5
    .param p1, "terms"    # [Ljava/lang/String;

    .prologue
    .line 112
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 113
    .local v0, "bundle":Landroid/os/Bundle;
    new-instance v1, Landroid/content/Intent;

    invoke-direct {v1}, Landroid/content/Intent;-><init>()V

    .line 115
    .local v1, "intent":Landroid/content/Intent;
    const-string v2, "KEY_TERMS"

    invoke-virtual {v0, v2, p1}, Landroid/os/Bundle;->putStringArray(Ljava/lang/String;[Ljava/lang/String;)V

    .line 116
    const-string v2, "KEY_ACTION"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/comcast/cim/android/accessibility/SpeechActions;->SEARCH:Lcom/comcast/cim/android/accessibility/SpeechActions;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ""

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 117
    invoke-virtual {v1, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 118
    const/4 v2, -0x1

    invoke-virtual {p0, v2, v1}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->setResult(ILandroid/content/Intent;)V

    .line 120
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->finish()V

    .line 122
    return-void
.end method

.method protected getSortPolicy()Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/xfinity/playerlib/view/browseprograms/SortPolicy",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;"
        }
    .end annotation

    .prologue
    .line 215
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->sortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;

    return-object v0
.end method

.method protected getTaskExecutionListener()Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .locals 1

    .prologue
    .line 339
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    return-object v0
.end method

.method protected getTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 1

    .prologue
    .line 343
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    return-object v0
.end method

.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 0
    .param p1, "dialogInterface"    # Landroid/content/DialogInterface;

    .prologue
    .line 301
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->closeWithIgnore()V

    .line 302
    return-void
.end method

.method public onDismiss(Landroid/content/DialogInterface;)V
    .locals 0
    .param p1, "dialogInterface"    # Landroid/content/DialogInterface;

    .prologue
    .line 306
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->closeWithIgnore()V

    .line 307
    return-void
.end method

.method protected onStop()V
    .locals 2

    .prologue
    .line 332
    invoke-super {p0}, Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->onStop()V

    .line 333
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->getTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 334
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->getTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->getTaskExecutionListener()Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 336
    :cond_0
    return-void
.end method

.method protected playLiveStream(Ljava/lang/String;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V
    .locals 6
    .param p1, "liveStreamId"    # Ljava/lang/String;
    .param p2, "liveStreamResource"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;
    .param p3, "videoEntitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .prologue
    .line 311
    invoke-virtual {p2, p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;->getLiveStream(Ljava/lang/String;)Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v2

    .line 312
    .local v2, "liveStream":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getProviderCodes()Ljava/util/List;

    move-result-object v3

    .line 314
    .local v3, "providerCodes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v5

    new-array v5, v5, [Ljava/lang/String;

    invoke-interface {v3, v5}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v5

    check-cast v5, [Ljava/lang/String;

    invoke-virtual {p3, v5}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitledToList([Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 316
    invoke-static {p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createIntentForPlayer(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v1

    .line 317
    .local v1, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->startActivity(Landroid/content/Intent;)V

    .line 318
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->closeWithIgnore()V

    .line 328
    .end local v1    # "intent":Landroid/content/Intent;
    :goto_0
    return-void

    .line 322
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    .line 323
    .local v0, "fm":Landroid/app/FragmentManager;
    sget-object v5, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAY_FROM_HISTORY:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    invoke-static {v5, v2}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->newInstance(Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)Lcom/xfinity/playerlib/view/common/UpsellDialog;

    move-result-object v4

    .line 324
    .local v4, "upsellDialog":Lcom/xfinity/playerlib/view/common/UpsellDialog;
    const-string v5, "upsell_dialog"

    invoke-virtual {v4, v0, v5}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 325
    invoke-virtual {v4, p0}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    .line 326
    invoke-virtual {v4, p0}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    goto :goto_0
.end method

.method protected playOrShowIfEpisodeMatches(Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;)Z
    .locals 2
    .param p1, "filterText"    # Ljava/lang/String;
    .param p2, "presentationMode"    # Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;
    .param p3, "videoBookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .param p4, "dibicProgram"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .param p5, "videoEntitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .param p6, "upsellType"    # Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    .prologue
    .line 255
    invoke-virtual {p3}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->isMovie()Z

    move-result v0

    if-nez v0, :cond_3

    .line 256
    invoke-virtual {p3}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getTitle()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p4}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getTitle()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 258
    :cond_0
    sget-object v0, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->PLAY:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    invoke-virtual {p2, v0}, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 260
    invoke-virtual {p5, p4}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitled(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 261
    invoke-virtual {p3}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    invoke-virtual {p3}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->playVideo(Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 269
    :goto_0
    const/4 v0, 0x1

    .line 272
    :goto_1
    return v0

    .line 263
    :cond_1
    invoke-virtual {p0, p4, p6}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->closeWithNotEntitledDibicProgram(Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;)V

    goto :goto_0

    .line 267
    :cond_2
    invoke-virtual {p0, p3}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->showSeriesFromVideoBookmark(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    goto :goto_0

    .line 272
    :cond_3
    const/4 v0, 0x0

    goto :goto_1
.end method

.method protected playOrShowIfProgramMatches(Ljava/lang/String;Lcom/xfinity/playerlib/model/EditorialProgram;Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;)Z
    .locals 2
    .param p1, "filterText"    # Ljava/lang/String;
    .param p2, "editorialProgram"    # Lcom/xfinity/playerlib/model/EditorialProgram;
    .param p3, "dibicResource"    # Lcom/xfinity/playerlib/model/dibic/DibicResource;
    .param p4, "presentationMode"    # Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;
    .param p5, "videoEntitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .param p6, "upsellType"    # Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    .prologue
    .line 158
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/EditorialProgram;->getTitle()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 160
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/EditorialProgram;->isMovie()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/EditorialProgram;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    :goto_0
    invoke-interface {p3, v1}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getProgramByMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    move-result-object v0

    .line 161
    .local v0, "dibicProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    invoke-virtual {p0, v0, p4, p5, p6}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->playOrShowVideo(Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;)V

    .line 162
    const/4 v1, 0x1

    .line 165
    .end local v0    # "dibicProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :goto_1
    return v1

    .line 160
    :cond_0
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/EditorialProgram;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    goto :goto_0

    .line 165
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method

.method protected playOrShowIfValidListNumber(Ljava/util/List;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;)Z
    .locals 7
    .param p2, "terms"    # [Ljava/lang/String;
    .param p3, "presentationMode"    # Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;
    .param p4, "videoEntitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .param p5, "upsellType"    # Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;[",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;",
            ")Z"
        }
    .end annotation

    .prologue
    .local p1, "results":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 236
    array-length v3, p2

    if-ne v3, v2, :cond_0

    .line 237
    iget-object v3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->alternateInterfaceUtil:Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;

    aget-object v4, p2, v1

    invoke-virtual {v3, v4}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;->interpretIfNumber(Ljava/lang/String;)I

    move-result v0

    .line 239
    .local v0, "justaNumber":I
    const/4 v3, -0x1

    if-le v0, v3, :cond_0

    .line 240
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v3

    if-gt v0, v3, :cond_1

    .line 241
    add-int/lit8 v1, v0, -0x1

    invoke-interface {p1, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    invoke-virtual {p0, v1, p3, p4, p5}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->playOrShowVideo(Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;)V

    :goto_0
    move v1, v2

    .line 248
    .end local v0    # "justaNumber":I
    :cond_0
    return v1

    .line 243
    .restart local v0    # "justaNumber":I
    :cond_1
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v3

    sget v4, Lcom/xfinity/playerlib/R$string;->list_number_invalid:I

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v1

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v5, v2

    invoke-virtual {p0, v4, v5}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v3, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected playOrShowIfVideoMatches(Ljava/lang/String;Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;)Z
    .locals 1
    .param p1, "filterText"    # Ljava/lang/String;
    .param p2, "dibicProgram"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .param p3, "presentationMode"    # Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;
    .param p4, "videoEntitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .param p5, "upsellType"    # Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    .prologue
    .line 173
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getTitle()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0, p1}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->checkTitleMatch(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 174
    invoke-virtual {p0, p2, p3, p4, p5}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->playOrShowVideo(Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;)V

    .line 175
    const/4 v0, 0x1

    .line 178
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected playOrShowVideo(Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;)V
    .locals 2
    .param p1, "dibicProgram"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .param p2, "presentationMode"    # Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;
    .param p3, "videoEntitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .param p4, "upsellType"    # Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    .prologue
    .line 191
    invoke-virtual {p3, p1}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitled(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 192
    sget-object v0, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->PLAY:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    invoke-virtual {p2, v0}, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isMovie()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 193
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-virtual {p0, v0, v1}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->playVideo(Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 200
    :goto_0
    return-void

    .line 195
    :cond_0
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isMovie()Z

    move-result v1

    invoke-virtual {p0, v0, v1}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->showVideoDetails(Lcom/xfinity/playerlib/model/MerlinId;Z)V

    goto :goto_0

    .line 198
    :cond_1
    invoke-virtual {p0, p1, p4}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->closeWithNotEntitledDibicProgram(Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;)V

    goto :goto_0
.end method

.method protected playVideo(Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;)V
    .locals 7
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p2, "parentMerlinIdIfApplicable"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    const-wide/16 v2, 0x0

    .line 102
    new-instance v6, Landroid/content/Intent;

    const-class v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;

    invoke-direct {v6, p0, v0}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .local v6, "intent":Landroid/content/Intent;
    move-object v0, p1

    move-object v1, p2

    move-wide v4, v2

    .line 103
    invoke-static/range {v0 .. v5}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createBundle(Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;JJ)Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {v6, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 104
    invoke-virtual {p0, v6}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->startActivity(Landroid/content/Intent;)V

    .line 106
    invoke-virtual {p0, v6}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->startActivity(Landroid/content/Intent;)V

    .line 107
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->closeWithIgnore()V

    .line 108
    return-void
.end method

.method protected showSeriesFromVideoBookmark(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 4
    .param p1, "videoBookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    const/4 v3, 0x1

    .line 277
    new-instance v2, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    invoke-direct {v2, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;-><init>(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    .line 279
    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->loadAsActivity(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v2

    .line 280
    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    move-result-object v0

    .line 282
    .local v0, "detailIntentHelper":Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->getBaseContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v1

    .line 284
    .local v1, "intent":Landroid/content/Intent;
    const-string v2, "KEY_ANNOUNCE_EPISODES"

    invoke-virtual {v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 286
    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->startActivity(Landroid/content/Intent;)V

    .line 287
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->closeWithIgnore()V

    .line 288
    return-void
.end method

.method protected showVideoDetails(Lcom/xfinity/playerlib/model/MerlinId;Z)V
    .locals 3
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p2, "isMovie"    # Z

    .prologue
    .line 204
    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    invoke-direct {v1, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;-><init>(Lcom/xfinity/playerlib/model/MerlinId;)V

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    move-result-object v1

    invoke-virtual {v1, p0}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v0

    .line 206
    .local v0, "intent":Landroid/content/Intent;
    if-nez p2, :cond_0

    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->isAccessibilityEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 207
    const-string v1, "KEY_ANNOUNCE_EPISODES"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 210
    :cond_0
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->startActivity(Landroid/content/Intent;)V

    .line 211
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->closeWithIgnore()V

    .line 212
    return-void
.end method

.method protected showVideoDetails(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V
    .locals 3
    .param p1, "program"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .prologue
    .line 89
    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    invoke-direct {v1, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;-><init>(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    move-result-object v1

    invoke-virtual {v1, p0}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v0

    .line 91
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isMovie()Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->isAccessibilityEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 92
    const-string v1, "KEY_ANNOUNCE_EPISODES"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 95
    :cond_0
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->startActivity(Landroid/content/Intent;)V

    .line 96
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->closeWithIgnore()V

    .line 97
    return-void
.end method

.method protected sortList(Ljava/util/List;)Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;"
        }
    .end annotation

    .prologue
    .line 220
    .local p1, "programs":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->getSortPolicy()Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;

    move-result-object v2

    .line 222
    .local v2, "sortPolicy":Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;, "Lcom/xfinity/playerlib/view/browseprograms/SortPolicy<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;->getCurrentSortComparator()Ljava/util/Comparator;

    move-result-object v1

    .line 223
    .local v1, "sortComparator":Ljava/util/Comparator;, "Ljava/util/Comparator<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    if-eqz v1, :cond_0

    .line 224
    invoke-static {p1}, Lcom/google/common/collect/Lists;->newArrayList(Ljava/lang/Iterable;)Ljava/util/ArrayList;

    move-result-object v0

    .line 225
    .local v0, "copy":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;->getCurrentSortComparator()Ljava/util/Comparator;

    move-result-object v3

    invoke-static {v0, v3}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 229
    .end local v0    # "copy":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    :goto_0
    return-object v0

    :cond_0
    move-object v0, p1

    goto :goto_0
.end method
