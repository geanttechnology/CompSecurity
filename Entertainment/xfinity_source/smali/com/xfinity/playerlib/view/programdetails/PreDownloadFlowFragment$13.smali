.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;
.super Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;
.source "PreDownloadFlowFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->fetchHlsVariantPlaylistAndSelectEmbeddedMediaProfile(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener",
        "<",
        "Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 502
    .local p2, "provider":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;)V

    return-void
.end method


# virtual methods
.method public onPostExecute(Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;)V
    .locals 11
    .param p1, "resource"    # Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;

    .prologue
    const/4 v10, 0x0

    .line 506
    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->getMediaProfiles()Ljava/util/List;

    move-result-object v8

    invoke-static {v8}, Lcom/google/common/collect/Lists;->newArrayList(Ljava/lang/Iterable;)Ljava/util/ArrayList;

    move-result-object v4

    .line 507
    .local v4, "filteredProfiles":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;>;"
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .line 508
    .local v5, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;>;"
    :cond_0
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_2

    .line 509
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;

    .line 510
    .local v6, "profile":Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;
    invoke-virtual {v6}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->getWidth()I

    move-result v8

    iget-object v9, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->selectedHalVideoProfile:Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;
    invoke-static {v9}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$1200(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

    move-result-object v9

    invoke-virtual {v9}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->getWidth()I

    move-result v9

    if-ne v8, v9, :cond_1

    invoke-virtual {v6}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->getHeight()I

    move-result v8

    iget-object v9, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->selectedHalVideoProfile:Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;
    invoke-static {v9}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$1200(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

    move-result-object v9

    invoke-virtual {v9}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->getHeight()I

    move-result v9

    if-eq v8, v9, :cond_0

    .line 511
    :cond_1
    iget-object v8, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {v8}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$100(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lorg/slf4j/Logger;

    move-result-object v8

    const-string v9, "Filtering media profile {} as it has a resolution that does match the selected HAL profile"

    invoke-interface {v8, v9, v6}, Lorg/slf4j/Logger;->info(Ljava/lang/String;Ljava/lang/Object;)V

    .line 512
    invoke-interface {v5}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 516
    .end local v6    # "profile":Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;
    :cond_2
    invoke-interface {v4}, Ljava/util/List;->isEmpty()Z

    move-result v8

    if-eqz v8, :cond_3

    .line 517
    iget-object v8, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    new-instance v9, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13$1;

    invoke-direct {v9, p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13$1;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;)V

    const-string v10, "chooseVideoFormat"

    # invokes: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->showDialog(Lcom/comcast/cim/cmasl/utils/provider/Provider;Ljava/lang/String;)V
    invoke-static {v8, v9, v10}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$1700(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/utils/provider/Provider;Ljava/lang/String;)V

    .line 596
    :goto_1
    return-void

    .line 550
    :cond_3
    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->MEDIA_PROFILE_BANDWIDTH_COMPARATOR:Ljava/util/Comparator;
    invoke-static {}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$1800()Ljava/util/Comparator;

    move-result-object v8

    invoke-static {v4, v8}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 552
    sget-object v8, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$29;->$SwitchMap$com$xfinity$playerlib$view$programdetails$PreDownloadFlowFragment$VideoQuality:[I

    iget-object v9, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->selectedVideoQuality:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;
    invoke-static {v9}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$1900(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;

    move-result-object v9

    invoke-virtual {v9}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;->ordinal()I

    move-result v9

    aget v8, v8, v9

    packed-switch v8, :pswitch_data_0

    .line 559
    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v8

    add-int/lit8 v8, v8, -0x1

    invoke-interface {v4, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;

    .line 563
    .local v7, "selectedHlsMediaProfile":Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;
    :goto_2
    invoke-static {v7}, Lcom/comcast/cim/cmasl/utils/collections/CollectionUtils;->createList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v8

    invoke-virtual {p1, v8}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->setMediaProfiles(Ljava/util/List;)V

    .line 566
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    .line 567
    .local v0, "allowedProfiles":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;>;"
    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->getAudioProfiles()Ljava/util/List;

    move-result-object v8

    invoke-static {v8}, Lcom/google/common/collect/Lists;->newArrayList(Ljava/lang/Iterable;)Ljava/util/ArrayList;

    move-result-object v3

    .line 568
    .local v3, "audioProfiles":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;>;"
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 569
    .local v2, "audioProfileIterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;>;"
    :cond_4
    :goto_3
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_6

    .line 570
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;

    .line 572
    .local v1, "audioProfile":Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;
    invoke-virtual {v7}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->getAudio()Ljava/lang/String;

    move-result-object v8

    if-eqz v8, :cond_5

    .line 573
    invoke-virtual {v7}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->getAudio()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->getGroupId()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_5

    .line 574
    invoke-interface {v2}, Ljava/util/Iterator;->remove()V

    goto :goto_3

    .line 554
    .end local v0    # "allowedProfiles":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;>;"
    .end local v1    # "audioProfile":Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;
    .end local v2    # "audioProfileIterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;>;"
    .end local v3    # "audioProfiles":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;>;"
    .end local v7    # "selectedHlsMediaProfile":Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;
    :pswitch_0
    invoke-interface {v4, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;

    .line 555
    .restart local v7    # "selectedHlsMediaProfile":Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;
    goto :goto_2

    .line 579
    .restart local v0    # "allowedProfiles":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;>;"
    .restart local v1    # "audioProfile":Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;
    .restart local v2    # "audioProfileIterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;>;"
    .restart local v3    # "audioProfiles":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;>;"
    :cond_5
    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->getUriString()Ljava/lang/String;

    move-result-object v8

    if-nez v8, :cond_4

    .line 581
    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 582
    invoke-interface {v2}, Ljava/util/Iterator;->remove()V

    goto :goto_3

    .line 586
    .end local v1    # "audioProfile":Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;
    :cond_6
    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v8

    if-nez v8, :cond_7

    .line 587
    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->MEDIA_AUDIO_PROFILE_COMPARATOR:Ljava/util/Comparator;
    invoke-static {}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$2000()Ljava/util/Comparator;

    move-result-object v8

    invoke-static {v3, v8}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 589
    iget-object v9, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-interface {v3, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;

    # setter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->alternateAudioProfile:Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;
    invoke-static {v9, v8}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$2102(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;)Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;

    .line 590
    iget-object v8, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->alternateAudioProfile:Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;
    invoke-static {v8}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$2100(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;

    move-result-object v8

    invoke-interface {v0, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 592
    :cond_7
    invoke-virtual {p1, v0}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->setAudioProfiles(Ljava/util/List;)V

    .line 594
    iget-object v8, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # setter for: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->metaDownloadProfile:Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;
    invoke-static {v8, p1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$2202(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;)Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;

    .line 595
    iget-object v8, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->fetchHlsSimplePlaylistForMediaProfile(Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;)V
    invoke-static {v8, v7}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->access$2300(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;)V

    goto/16 :goto_1

    .line 552
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 502
    check-cast p1, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;->onPostExecute(Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;)V

    return-void
.end method
