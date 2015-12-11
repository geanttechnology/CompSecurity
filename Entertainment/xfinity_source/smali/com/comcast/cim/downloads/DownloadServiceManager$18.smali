.class Lcom/comcast/cim/downloads/DownloadServiceManager$18;
.super Ljava/lang/Object;
.source "DownloadServiceManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/downloads/DownloadServiceManager;->downloadHlsFileWithMetadata(Ljava/lang/String;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Lcom/comcast/cim/downloads/DownloadMetaData;Ljava/lang/Runnable;Lcom/google/common/util/concurrent/FutureCallback;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

.field final synthetic val$alternateAudioPlaylist:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

.field final synthetic val$assetId:Ljava/lang/String;

.field final synthetic val$extraTask:Ljava/lang/Runnable;

.field final synthetic val$metaData:Lcom/comcast/cim/downloads/DownloadMetaData;

.field final synthetic val$resultCallback:Lcom/google/common/util/concurrent/FutureCallback;

.field final synthetic val$simplePlaylist:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

.field final synthetic val$variantPlaylist:Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;


# direct methods
.method constructor <init>(Lcom/comcast/cim/downloads/DownloadServiceManager;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Ljava/lang/String;Lcom/comcast/cim/downloads/DownloadMetaData;Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;Ljava/lang/Runnable;Lcom/google/common/util/concurrent/FutureCallback;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/downloads/DownloadServiceManager;

    .prologue
    .line 766
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$18;, "Lcom/comcast/cim/downloads/DownloadServiceManager$18;"
    iput-object p1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    iput-object p2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$simplePlaylist:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    iput-object p3, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$alternateAudioPlaylist:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    iput-object p4, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$assetId:Ljava/lang/String;

    iput-object p5, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$metaData:Lcom/comcast/cim/downloads/DownloadMetaData;

    iput-object p6, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$variantPlaylist:Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;

    iput-object p7, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$extraTask:Ljava/lang/Runnable;

    iput-object p8, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$resultCallback:Lcom/google/common/util/concurrent/FutureCallback;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 25

    .prologue
    .line 769
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$18;, "Lcom/comcast/cim/downloads/DownloadServiceManager$18;"
    :try_start_0
    new-instance v21, Lorg/apache/commons/lang3/time/StopWatch;

    invoke-direct/range {v21 .. v21}, Lorg/apache/commons/lang3/time/StopWatch;-><init>()V

    .line 770
    .local v21, "timer":Lorg/apache/commons/lang3/time/StopWatch;
    invoke-virtual/range {v21 .. v21}, Lorg/apache/commons/lang3/time/StopWatch;->start()V

    .line 772
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$simplePlaylist:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    move-object/from16 v22, v0

    invoke-virtual/range {v22 .. v22}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->getRelativeSequencePaths()Ljava/util/List;

    move-result-object v20

    .line 773
    .local v20, "segments":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;>;"
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v4

    .line 774
    .local v4, "audioSegments":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;>;"
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$alternateAudioPlaylist:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    move-object/from16 v22, v0

    if-eqz v22, :cond_0

    .line 775
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$alternateAudioPlaylist:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    move-object/from16 v22, v0

    invoke-virtual/range {v22 .. v22}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->getRelativeSequencePaths()Ljava/util/List;

    move-result-object v4

    .line 778
    :cond_0
    new-instance v6, Ljava/util/ArrayList;

    invoke-interface/range {v20 .. v20}, Ljava/util/List;->size()I

    move-result v22

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v23

    add-int v22, v22, v23

    move/from16 v0, v22

    invoke-direct {v6, v0}, Ljava/util/ArrayList;-><init>(I)V

    .line 779
    .local v6, "fullPaths":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface/range {v20 .. v20}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v22

    :goto_0
    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->hasNext()Z

    move-result v23

    if-eqz v23, :cond_1

    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;

    .line 780
    .local v19, "segment":Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;
    new-instance v23, Ljava/lang/StringBuilder;

    invoke-direct/range {v23 .. v23}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$simplePlaylist:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    move-object/from16 v24, v0

    invoke-virtual/range {v24 .. v24}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->getUrlPathPrefix()Ljava/lang/String;

    move-result-object v24

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-virtual/range {v19 .. v19}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;->getPath()Ljava/lang/String;

    move-result-object v24

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    .line 781
    .local v12, "nextPath":Ljava/lang/String;
    invoke-interface {v6, v12}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Lcom/penthera/virtuososdk/client/ServiceException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 900
    .end local v4    # "audioSegments":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;>;"
    .end local v6    # "fullPaths":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v12    # "nextPath":Ljava/lang/String;
    .end local v19    # "segment":Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;
    .end local v20    # "segments":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;>;"
    .end local v21    # "timer":Lorg/apache/commons/lang3/time/StopWatch;
    :catch_0
    move-exception v5

    .line 901
    .local v5, "e":Lcom/penthera/virtuososdk/client/ServiceException;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$resultCallback:Lcom/google/common/util/concurrent/FutureCallback;

    move-object/from16 v22, v0

    new-instance v23, Lcom/comcast/cim/downloads/DownloadServiceException;

    move-object/from16 v0, v23

    invoke-direct {v0, v5}, Lcom/comcast/cim/downloads/DownloadServiceException;-><init>(Ljava/lang/Throwable;)V

    invoke-interface/range {v22 .. v23}, Lcom/google/common/util/concurrent/FutureCallback;->onFailure(Ljava/lang/Throwable;)V

    .line 903
    .end local v5    # "e":Lcom/penthera/virtuososdk/client/ServiceException;
    :goto_1
    return-void

    .line 784
    .restart local v4    # "audioSegments":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;>;"
    .restart local v6    # "fullPaths":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v20    # "segments":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;>;"
    .restart local v21    # "timer":Lorg/apache/commons/lang3/time/StopWatch;
    :cond_1
    :try_start_1
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v22

    :goto_2
    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->hasNext()Z

    move-result v23

    if-eqz v23, :cond_2

    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;

    .line 785
    .restart local v19    # "segment":Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;
    new-instance v23, Ljava/lang/StringBuilder;

    invoke-direct/range {v23 .. v23}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$alternateAudioPlaylist:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    move-object/from16 v24, v0

    invoke-virtual/range {v24 .. v24}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->getUrlPathPrefix()Ljava/lang/String;

    move-result-object v24

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-virtual/range {v19 .. v19}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;->getPath()Ljava/lang/String;

    move-result-object v24

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    .line 786
    .restart local v12    # "nextPath":Ljava/lang/String;
    invoke-interface {v6, v12}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 789
    .end local v12    # "nextPath":Ljava/lang/String;
    .end local v19    # "segment":Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;
    :cond_2
    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$000()Lorg/slf4j/Logger;

    move-result-object v22

    new-instance v23, Ljava/lang/StringBuilder;

    invoke-direct/range {v23 .. v23}, Ljava/lang/StringBuilder;-><init>()V

    const-string v24, "Added "

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-interface/range {v20 .. v20}, Ljava/util/List;->size()I

    move-result v24

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v23

    const-string v24, " segments"

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    invoke-interface/range {v22 .. v23}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 790
    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$000()Lorg/slf4j/Logger;

    move-result-object v22

    new-instance v23, Ljava/lang/StringBuilder;

    invoke-direct/range {v23 .. v23}, Ljava/lang/StringBuilder;-><init>()V

    const-string v24, "Added "

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v24

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v23

    const-string v24, " audio segments"

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    invoke-interface/range {v22 .. v23}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 791
    invoke-virtual/range {v21 .. v21}, Lorg/apache/commons/lang3/time/StopWatch;->stop()V

    .line 792
    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$000()Lorg/slf4j/Logger;

    move-result-object v22

    new-instance v23, Ljava/lang/StringBuilder;

    invoke-direct/range {v23 .. v23}, Ljava/lang/StringBuilder;-><init>()V

    const-string v24, "Created full path list in "

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    move-object/from16 v0, v23

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v23

    const-string v24, " seconds"

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    invoke-interface/range {v22 .. v23}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 794
    invoke-virtual/range {v21 .. v21}, Lorg/apache/commons/lang3/time/StopWatch;->reset()V

    .line 795
    invoke-virtual/range {v21 .. v21}, Lorg/apache/commons/lang3/time/StopWatch;->start()V

    .line 796
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    move-object/from16 v22, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$assetId:Ljava/lang/String;

    move-object/from16 v23, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$metaData:Lcom/comcast/cim/downloads/DownloadMetaData;

    move-object/from16 v24, v0

    move-object/from16 v0, v22

    move-object/from16 v1, v23

    move-object/from16 v2, v24

    invoke-virtual {v0, v6, v1, v2}, Lcom/comcast/cim/downloads/DownloadServiceManager;->createHlsFile(Ljava/util/List;Ljava/lang/String;Lcom/comcast/cim/downloads/DownloadMetaData;)Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;

    move-result-object v7

    .line 797
    .local v7, "hlsFile":Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;
    invoke-virtual/range {v21 .. v21}, Lorg/apache/commons/lang3/time/StopWatch;->stop()V

    .line 798
    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$000()Lorg/slf4j/Logger;

    move-result-object v22

    new-instance v23, Ljava/lang/StringBuilder;

    invoke-direct/range {v23 .. v23}, Ljava/lang/StringBuilder;-><init>()V

    const-string v24, "Created Virtuoso File in "

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    move-object/from16 v0, v23

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v23

    const-string v24, " seconds"

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    invoke-interface/range {v22 .. v23}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 803
    invoke-virtual/range {v21 .. v21}, Lorg/apache/commons/lang3/time/StopWatch;->reset()V

    .line 804
    invoke-virtual/range {v21 .. v21}, Lorg/apache/commons/lang3/time/StopWatch;->start()V

    .line 806
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$variantPlaylist:Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;

    move-object/from16 v22, v0

    invoke-virtual/range {v22 .. v22}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->getMediaProfiles()Ljava/util/List;

    move-result-object v17

    .line 807
    .local v17, "profiles":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;>;"
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v10

    .line 808
    .local v10, "newProfiles":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;>;"
    invoke-interface/range {v17 .. v17}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v22

    :goto_3
    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->hasNext()Z

    move-result v23

    if-eqz v23, :cond_3

    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;

    .line 809
    .local v16, "profile":Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;
    const-string v23, "simple.m3u8"

    move-object/from16 v0, v16

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;->setRelativePath(Ljava/lang/String;)V

    .line 810
    move-object/from16 v0, v16

    invoke-interface {v10, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_3

    .line 812
    .end local v16    # "profile":Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;
    :cond_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$variantPlaylist:Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    invoke-virtual {v0, v10}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->setMediaProfiles(Ljava/util/List;)V

    .line 815
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$variantPlaylist:Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;

    move-object/from16 v22, v0

    invoke-virtual/range {v22 .. v22}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->getAudioProfiles()Ljava/util/List;

    move-result-object v3

    .line 816
    .local v3, "audioProfiles":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;>;"
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v8

    .line 817
    .local v8, "newAudioProfiles":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;>;"
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v22

    :goto_4
    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->hasNext()Z

    move-result v23

    if-eqz v23, :cond_5

    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;

    .line 818
    .local v16, "profile":Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;
    invoke-virtual/range {v16 .. v16}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->getUriString()Ljava/lang/String;

    move-result-object v23

    if-eqz v23, :cond_4

    .line 819
    const-string v23, "\"audio.m3u8\""

    move-object/from16 v0, v16

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;->setUriString(Ljava/lang/String;)V

    .line 821
    :cond_4
    move-object/from16 v0, v16

    invoke-interface {v8, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_4

    .line 823
    .end local v16    # "profile":Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;
    :cond_5
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$variantPlaylist:Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    invoke-virtual {v0, v8}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->setAudioProfiles(Ljava/util/List;)V

    .line 824
    invoke-virtual/range {v21 .. v21}, Lorg/apache/commons/lang3/time/StopWatch;->stop()V

    .line 825
    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$000()Lorg/slf4j/Logger;

    move-result-object v22

    new-instance v23, Ljava/lang/StringBuilder;

    invoke-direct/range {v23 .. v23}, Ljava/lang/StringBuilder;-><init>()V

    const-string v24, "Manipulated Variant Playlist in "

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    move-object/from16 v0, v23

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v23

    const-string v24, " seconds"

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    invoke-interface/range {v22 .. v23}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 827
    invoke-virtual/range {v21 .. v21}, Lorg/apache/commons/lang3/time/StopWatch;->reset()V

    .line 828
    invoke-virtual/range {v21 .. v21}, Lorg/apache/commons/lang3/time/StopWatch;->start()V

    .line 829
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$simplePlaylist:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    move-object/from16 v22, v0

    invoke-virtual/range {v22 .. v22}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->getRelativeSequencePaths()Ljava/util/List;

    move-result-object v15

    .line 830
    .local v15, "oldSegments":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;>;"
    new-instance v11, Ljava/util/ArrayList;

    invoke-interface {v15}, Ljava/util/List;->size()I

    move-result v22

    move/from16 v0, v22

    invoke-direct {v11, v0}, Ljava/util/ArrayList;-><init>(I)V

    .line 831
    .local v11, "newSegments":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;>;"
    invoke-interface {v15}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v22

    :goto_5
    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->hasNext()Z

    move-result v23

    if-eqz v23, :cond_7

    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;

    .line 832
    .restart local v19    # "segment":Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;
    invoke-virtual/range {v19 .. v19}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;->getPath()Ljava/lang/String;

    move-result-object v14

    .line 833
    .local v14, "oldPath":Ljava/lang/String;
    const/16 v23, 0x2f

    move/from16 v0, v23

    invoke-virtual {v14, v0}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v23

    const/16 v24, -0x1

    move/from16 v0, v23

    move/from16 v1, v24

    if-eq v0, v1, :cond_6

    .line 834
    const/16 v23, 0x2f

    move/from16 v0, v23

    invoke-virtual {v14, v0}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v23

    add-int/lit8 v23, v23, 0x1

    move/from16 v0, v23

    invoke-virtual {v14, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v23

    move-object/from16 v0, v19

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;->setPath(Ljava/lang/String;)V

    .line 836
    :cond_6
    move-object/from16 v0, v19

    invoke-interface {v11, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_5

    .line 838
    .end local v14    # "oldPath":Ljava/lang/String;
    .end local v19    # "segment":Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;
    :cond_7
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$simplePlaylist:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    invoke-virtual {v0, v11}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->setSequencePaths(Ljava/util/List;)V

    .line 839
    invoke-virtual/range {v21 .. v21}, Lorg/apache/commons/lang3/time/StopWatch;->stop()V

    .line 840
    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$000()Lorg/slf4j/Logger;

    move-result-object v22

    new-instance v23, Ljava/lang/StringBuilder;

    invoke-direct/range {v23 .. v23}, Ljava/lang/StringBuilder;-><init>()V

    const-string v24, "Manipulated Simple Playlist in "

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    move-object/from16 v0, v23

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v23

    const-string v24, " seconds"

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    invoke-interface/range {v22 .. v23}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 842
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$alternateAudioPlaylist:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    move-object/from16 v22, v0

    if-eqz v22, :cond_a

    .line 843
    invoke-virtual/range {v21 .. v21}, Lorg/apache/commons/lang3/time/StopWatch;->reset()V

    .line 844
    invoke-virtual/range {v21 .. v21}, Lorg/apache/commons/lang3/time/StopWatch;->start()V

    .line 845
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$alternateAudioPlaylist:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    move-object/from16 v22, v0

    invoke-virtual/range {v22 .. v22}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->getRelativeSequencePaths()Ljava/util/List;

    move-result-object v13

    .line 846
    .local v13, "oldAudioSegments":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;>;"
    new-instance v9, Ljava/util/ArrayList;

    invoke-interface {v13}, Ljava/util/List;->size()I

    move-result v22

    move/from16 v0, v22

    invoke-direct {v9, v0}, Ljava/util/ArrayList;-><init>(I)V

    .line 847
    .local v9, "newAudioSegments":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;>;"
    invoke-interface {v13}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v22

    :goto_6
    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->hasNext()Z

    move-result v23

    if-eqz v23, :cond_9

    invoke-interface/range {v22 .. v22}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v19

    check-cast v19, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;

    .line 848
    .restart local v19    # "segment":Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;
    invoke-virtual/range {v19 .. v19}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;->getPath()Ljava/lang/String;

    move-result-object v14

    .line 849
    .restart local v14    # "oldPath":Ljava/lang/String;
    const/16 v23, 0x2f

    move/from16 v0, v23

    invoke-virtual {v14, v0}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v23

    const/16 v24, -0x1

    move/from16 v0, v23

    move/from16 v1, v24

    if-eq v0, v1, :cond_8

    .line 850
    const/16 v23, 0x2f

    move/from16 v0, v23

    invoke-virtual {v14, v0}, Ljava/lang/String;->lastIndexOf(I)I

    move-result v23

    add-int/lit8 v23, v23, 0x1

    move/from16 v0, v23

    invoke-virtual {v14, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v23

    move-object/from16 v0, v19

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;->setPath(Ljava/lang/String;)V

    .line 852
    :cond_8
    move-object/from16 v0, v19

    invoke-interface {v9, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_6

    .line 854
    .end local v14    # "oldPath":Ljava/lang/String;
    .end local v19    # "segment":Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;
    :cond_9
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$alternateAudioPlaylist:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    invoke-virtual {v0, v9}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->setSequencePaths(Ljava/util/List;)V

    .line 855
    invoke-virtual/range {v21 .. v21}, Lorg/apache/commons/lang3/time/StopWatch;->stop()V

    .line 856
    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$000()Lorg/slf4j/Logger;

    move-result-object v22

    new-instance v23, Ljava/lang/StringBuilder;

    invoke-direct/range {v23 .. v23}, Ljava/lang/StringBuilder;-><init>()V

    const-string v24, "Manipulated Alternate Audio Playlist in "

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    move-object/from16 v0, v23

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v23

    const-string v24, " seconds"

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    invoke-interface/range {v22 .. v23}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 859
    .end local v9    # "newAudioSegments":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;>;"
    .end local v13    # "oldAudioSegments":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist$SequenceSegment;>;"
    :cond_a
    invoke-virtual/range {v21 .. v21}, Lorg/apache/commons/lang3/time/StopWatch;->reset()V

    .line 860
    invoke-virtual/range {v21 .. v21}, Lorg/apache/commons/lang3/time/StopWatch;->start()V

    .line 861
    invoke-interface {v7}, Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;->localBaseDir()Ljava/lang/String;
    :try_end_1
    .catch Lcom/penthera/virtuososdk/client/ServiceException; {:try_start_1 .. :try_end_1} :catch_0

    move-result-object v18

    .line 863
    .local v18, "savePath":Ljava/lang/String;
    :try_start_2
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$variantPlaylist:Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;

    move-object/from16 v22, v0

    new-instance v23, Ljava/io/File;

    const-string v24, "variant.m3u8"

    move-object/from16 v0, v23

    move-object/from16 v1, v18

    move-object/from16 v2, v24

    invoke-direct {v0, v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual/range {v22 .. v23}, Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;->writeToFile(Ljava/io/File;)V

    .line 864
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$simplePlaylist:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    move-object/from16 v22, v0

    new-instance v23, Ljava/io/File;

    const-string v24, "simple.m3u8"

    move-object/from16 v0, v23

    move-object/from16 v1, v18

    move-object/from16 v2, v24

    invoke-direct {v0, v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual/range {v22 .. v23}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->writeToFile(Ljava/io/File;)V

    .line 865
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$alternateAudioPlaylist:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    move-object/from16 v22, v0

    if-eqz v22, :cond_b

    .line 866
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$alternateAudioPlaylist:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    move-object/from16 v22, v0

    new-instance v23, Ljava/io/File;

    const-string v24, "audio.m3u8"

    move-object/from16 v0, v23

    move-object/from16 v1, v18

    move-object/from16 v2, v24

    invoke-direct {v0, v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual/range {v22 .. v23}, Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;->writeToFile(Ljava/io/File;)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Lcom/penthera/virtuososdk/client/ServiceException; {:try_start_2 .. :try_end_2} :catch_0

    .line 873
    :cond_b
    :try_start_3
    invoke-virtual/range {v21 .. v21}, Lorg/apache/commons/lang3/time/StopWatch;->stop()V

    .line 874
    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$000()Lorg/slf4j/Logger;

    move-result-object v22

    new-instance v23, Ljava/lang/StringBuilder;

    invoke-direct/range {v23 .. v23}, Ljava/lang/StringBuilder;-><init>()V

    const-string v24, "Saved Variant & Simple Playlists to disk in "

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    move-object/from16 v0, v23

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v23

    const-string v24, "seconds"

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    invoke-virtual/range {v23 .. v23}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v23

    invoke-interface/range {v22 .. v23}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 876
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager;->foregroundExecutor:Ljava/util/concurrent/Executor;

    move-object/from16 v22, v0

    new-instance v23, Lcom/comcast/cim/downloads/DownloadServiceManager$18$1;

    move-object/from16 v0, v23

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v7}, Lcom/comcast/cim/downloads/DownloadServiceManager$18$1;-><init>(Lcom/comcast/cim/downloads/DownloadServiceManager$18;Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;)V

    invoke-interface/range {v22 .. v23}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    goto/16 :goto_1

    .line 868
    :catch_1
    move-exception v5

    .line 870
    .local v5, "e":Ljava/io/IOException;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    move-object/from16 v22, v0

    move-object/from16 v0, v22

    invoke-virtual {v0, v7}, Lcom/comcast/cim/downloads/DownloadServiceManager;->deleteUnusedHlsFile(Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;)V

    .line 871
    new-instance v22, Lcom/penthera/virtuososdk/client/ServiceException;

    const-string v23, "Failed to write playlist files"

    move-object/from16 v0, v22

    move-object/from16 v1, v23

    invoke-direct {v0, v1, v5}, Lcom/penthera/virtuososdk/client/ServiceException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v22
    :try_end_3
    .catch Lcom/penthera/virtuososdk/client/ServiceException; {:try_start_3 .. :try_end_3} :catch_0
.end method
