.class Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;
.super Ljava/lang/Object;
.source "VirtuosoHLSFile.java"

# interfaces
.implements Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "VirtuosoFileFragment"
.end annotation


# instance fields
.field mCompleteTime:J

.field mCurrentSize:D

.field mDownloadStatus:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

.field mExpectedSize:D

.field mId:I

.field mPath:Ljava/lang/String;

.field mPending:Z

.field mRemotePath:Ljava/lang/String;

.field final synthetic this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;


# direct methods
.method constructor <init>(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;Landroid/database/Cursor;)V
    .locals 6
    .param p2, "c"    # Landroid/database/Cursor;

    .prologue
    const/4 v2, 0x0

    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 482
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 474
    iput-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mPath:Ljava/lang/String;

    .line 475
    iput-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mRemotePath:Ljava/lang/String;

    .line 476
    const/4 v2, -0x1

    iput v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mId:I

    .line 477
    const-wide/high16 v2, -0x4010000000000000L    # -1.0

    iput-wide v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mExpectedSize:D

    .line 478
    const-wide/16 v2, 0x0

    iput-wide v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mCurrentSize:D

    .line 479
    iput-boolean v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mPending:Z

    .line 480
    const-wide/16 v2, -0x1

    iput-wide v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mCompleteTime:J

    .line 481
    sget-object v2, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Not_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    iput-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mDownloadStatus:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    .line 483
    const-string v2, "assetUrl"

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mRemotePath:Ljava/lang/String;

    .line 484
    const-string v2, "filePath"

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mPath:Ljava/lang/String;

    .line 485
    const-string v2, "_id"

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getInt(I)I

    move-result v2

    iput v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mId:I

    .line 486
    const-string v2, "expectedSize"

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    long-to-double v2, v2

    iput-wide v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mExpectedSize:D

    .line 487
    const-string v2, "currentSize"

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v2

    long-to-double v2, v2

    iput-wide v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mCurrentSize:D

    .line 488
    invoke-static {}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->values()[Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v2

    const-string v3, "errorType"

    invoke-interface {p2, v3}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v3

    invoke-interface {p2, v3}, Landroid/database/Cursor;->getLong(I)J

    move-result-wide v4

    long-to-int v3, v4

    aget-object v2, v2, v3

    iput-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mDownloadStatus:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    .line 489
    const-string v2, "pending"

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v2

    invoke-interface {p2, v2}, Landroid/database/Cursor;->getShort(I)S

    move-result v2

    if-ne v2, v0, :cond_0

    :goto_0
    iput-boolean v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mPending:Z

    .line 490
    return-void

    :cond_0
    move v0, v1

    .line 489
    goto :goto_0
.end method


# virtual methods
.method public currentSize()D
    .locals 2

    .prologue
    .line 519
    iget-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mCurrentSize:D

    return-wide v0
.end method

.method public downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;
    .locals 1

    .prologue
    .line 529
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mDownloadStatus:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    return-object v0
.end method

.method public expectedSize()D
    .locals 2

    .prologue
    .line 514
    iget-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mExpectedSize:D

    return-wide v0
.end method

.method public filePath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 504
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mPath:Ljava/lang/String;

    return-object v0
.end method

.method public generateFilePath()V
    .locals 3

    .prologue
    .line 602
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;

    iget-object v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mRemotePath:Ljava/lang/String;

    iget v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mId:I

    # invokes: Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->generateFragmentPath(Ljava/lang/String;I)Ljava/lang/String;
    invoke-static {v0, v1, v2}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->access$0(Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->setFilePath(Ljava/lang/String;)V

    .line 603
    return-void
.end method

.method public id()I
    .locals 1

    .prologue
    .line 499
    iget v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mId:I

    return v0
.end method

.method public markComplete()V
    .locals 4

    .prologue
    .line 575
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    const-wide/16 v2, 0x3e8

    div-long/2addr v0, v2

    iput-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mCompleteTime:J

    .line 576
    sget-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->KvDE_Download_Complete:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    iput-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mDownloadStatus:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    .line 577
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mPending:Z

    .line 578
    iget-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mExpectedSize:D

    const-wide/high16 v2, -0x4010000000000000L    # -1.0

    cmpl-double v0, v0, v2

    if-lez v0, :cond_0

    .line 579
    iget-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mExpectedSize:D

    iput-wide v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mCurrentSize:D

    .line 580
    :cond_0
    return-void
.end method

.method public remotePath()Ljava/lang/String;
    .locals 1

    .prologue
    .line 509
    iget-object v0, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mRemotePath:Ljava/lang/String;

    return-object v0
.end method

.method public setCurrentSize(D)V
    .locals 7
    .param p1, "s"    # D

    .prologue
    .line 543
    iget-wide v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mCurrentSize:D

    sub-double v0, p1, v2

    .line 544
    .local v0, "delta":D
    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;

    iget-wide v4, v2, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iCurrentSize:D

    add-double/2addr v4, v0

    iput-wide v4, v2, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->iCurrentSize:D

    .line 545
    iput-wide p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mCurrentSize:D

    .line 546
    return-void
.end method

.method public setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V
    .locals 0
    .param p1, "ds"    # Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    .prologue
    .line 555
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mDownloadStatus:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    .line 556
    return-void
.end method

.method public setExpectedSize(D)V
    .locals 1
    .param p1, "s"    # D

    .prologue
    .line 534
    iput-wide p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mExpectedSize:D

    .line 535
    return-void
.end method

.method public setFilePath(Ljava/lang/String;)V
    .locals 0
    .param p1, "aPath"    # Ljava/lang/String;

    .prologue
    .line 597
    iput-object p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mPath:Ljava/lang/String;

    .line 598
    return-void
.end method

.method public setPending(Z)V
    .locals 0
    .param p1, "p"    # Z

    .prologue
    .line 550
    iput-boolean p1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mPending:Z

    .line 551
    return-void
.end method

.method public update(Landroid/content/Context;)Z
    .locals 7
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 584
    if-nez p1, :cond_0

    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "Invalid Context"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 585
    :cond_0
    invoke-virtual {p1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    .line 586
    .local v0, "cr":Landroid/content/ContentResolver;
    const/4 v2, 0x0

    .line 588
    .local v2, "updated":I
    :try_start_0
    iget-object v3, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->this$0:Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;

    invoke-virtual {v3}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->clientProviderAuth()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/penthera/virtuososdk/database/impl/provider/FileFragment$FragmentColumns;->CONTENT_URI(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    iget v4, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mId:I

    int-to-long v4, v4

    invoke-static {v3, v4, v5}, Landroid/content/ContentUris;->withAppendedId(Landroid/net/Uri;J)Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {p0}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->updatevalues()Landroid/content/ContentValues;

    move-result-object v4

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-virtual {v0, v3, v4, v5, v6}, Landroid/content/ContentResolver;->update(Landroid/net/Uri;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result v2

    .line 592
    :goto_0
    if-lez v2, :cond_1

    const/4 v3, 0x1

    :goto_1
    return v3

    .line 589
    :catch_0
    move-exception v1

    .line 590
    .local v1, "e":Ljava/lang/Exception;
    sget-object v3, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile;->LOG_TAG:Ljava/lang/String;

    const-string v4, "failed updating fragment"

    invoke-static {v3, v4, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 592
    .end local v1    # "e":Ljava/lang/Exception;
    :cond_1
    const/4 v3, 0x0

    goto :goto_1
.end method

.method public updatevalues()Landroid/content/ContentValues;
    .locals 6

    .prologue
    .line 560
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 562
    .local v0, "values":Landroid/content/ContentValues;
    const-string v1, "currentSize"

    iget-wide v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mCurrentSize:D

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Double;)V

    .line 563
    const-string v1, "expectedSize"

    iget-wide v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mExpectedSize:D

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Double;)V

    .line 564
    const-string v1, "errorType"

    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mDownloadStatus:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-virtual {v2}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 565
    const-string v1, "filePath"

    iget-object v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mPath:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/String;)V

    .line 566
    const-string v2, "pending"

    iget-boolean v1, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mPending:Z

    if-eqz v1, :cond_1

    const/4 v1, 0x1

    :goto_0
    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v2, v1}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 568
    iget-wide v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mCompleteTime:J

    const-wide/16 v4, 0x1

    cmp-long v1, v2, v4

    if-lez v1, :cond_0

    .line 569
    const-string v1, "completeTime"

    iget-wide v2, p0, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoHLSFile$VirtuosoFileFragment;->mCompleteTime:J

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Long;)V

    .line 570
    :cond_0
    return-object v0

    .line 566
    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method
