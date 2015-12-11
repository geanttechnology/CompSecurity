.class Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;
.super Ljava/lang/Object;
.source "CrashDescriptorStorageUtil.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DescriptorCount"
.end annotation


# instance fields
.field private mCount:I

.field private mCreatedMs:J

.field final synthetic this$0:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;


# direct methods
.method public constructor <init>(Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;)V
    .locals 3

    .prologue
    .line 367
    const/4 v0, 0x1

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    invoke-direct {p0, p1, v0, v1, v2}, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;-><init>(Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;IJ)V

    .line 368
    return-void
.end method

.method public constructor <init>(Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;IJ)V
    .locals 0
    .param p2, "count"    # I
    .param p3, "createdMs"    # J

    .prologue
    .line 372
    iput-object p1, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;->this$0:Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 373
    iput p2, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;->mCount:I

    .line 374
    iput-wide p3, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;->mCreatedMs:J

    .line 375
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 392
    iget v0, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;->mCount:I

    return v0
.end method

.method public getCreated()J
    .locals 2

    .prologue
    .line 386
    iget-wide v0, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;->mCreatedMs:J

    return-wide v0
.end method

.method public increment()V
    .locals 1

    .prologue
    .line 380
    iget v0, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;->mCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;->mCount:I

    .line 381
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 399
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget v1, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;->mCount:I

    invoke-static {v1}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "|"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-wide v1, p0, Lcom/amazon/device/crashmanager/CrashDescriptorStorageUtil$DescriptorCount;->mCreatedMs:J

    invoke-static {v1, v2}, Ljava/lang/Long;->toString(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
